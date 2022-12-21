package com.bond.app.service;

import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.Result;
import com.baidu.unbiz.fluentvalidator.jsr303.HibernateSupportedValidator;
import com.bond.app.transaction.SubscribeTransaction;
import com.bond.client.api.BondService;
import com.bond.client.dto.result.SubscribeResult;
import com.bond.client.dto.validator.PhoneNumberValidator;
import com.bond.client.dto.valueobject.BondVO;
import com.bond.client.dto.valueobject.InvestorVO;
import com.bond.client.dto.valueobject.TradeDataVO;
import com.bond.domain.exception.BizException;
import com.bond.domain.exception.ErrorConstant;
import com.bond.domain.model.trade.Bond;
import com.bond.domain.model.trade.Holding;
import com.bond.domain.model.trade.Inventory;
import com.bond.domain.model.trade.repository.BondRepository;
import com.bond.domain.model.trade.repository.HoldingRepository;
import com.bond.domain.model.trade.repository.InventoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toSimple;

/**
 * 应用服务层:1、逻辑错误异常等统一处理  2、业务主逻辑步骤
 */
@Service
public class BondServiceImpl implements BondService {

    private static final Logger logger = LoggerFactory.getLogger(BondServiceImpl.class);

    @Autowired
    private BondRepository bondRepository;
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private HoldingRepository holdingRepository;
    @Autowired
    private SubscribeTransaction subscribeTransaction;

    @Override
    public SubscribeResult subscribe(InvestorVO investorVO, BondVO bondVO, TradeDataVO tradeDataVO) {
        SubscribeResult subscribeResult = new SubscribeResult();
        try {
            // step1 输入参数校验 Fluent-Validator + Hibernate-Validator
            validateParameter(investorVO,bondVO,tradeDataVO);
            logger.info("输入参数验证完成");
            // step2 业务验证逻辑
            Bond bond = bondRepository.find(bondVO.getBondCode());
            bond.checkIssueStatus();
            logger.info("债券[{}]发行期验证完成,在发行期",bond.getBondCode());
            // step3 业务执行逻辑 3.1 第三方服务调用ACL 3.2 repository调用存储服务
            Inventory inventory = inventoryRepository.find(bondVO.getBondCode());
            inventory.reduce(tradeDataVO.getFaceValue());
            logger.info("债券库存扣减完成剩余[{}]",inventory.getRemainQuota());
            Holding holding = holdingRepository.find(investorVO.getName(),bondVO.getBondCode());
            holding.add(tradeDataVO.getFaceValue());
            logger.info("投资人持仓增加成功,目前持有额度[{}]",holding.getHoldQuota());
            subscribeTransaction.transaction(holding,inventory);
            logger.info("支付完成,交易成功！");
            // step4 构建返回信息
            subscribeResult.buildSucceedResult();

        } catch (BizException e) {
            if(e.getCause()!=null){
                //业务验证出错
                logger.warn(e.getError().getErrorMessageForOperator());
            }else{
                //系统环境出错
                logger.error(e.getError().getErrorMessageForOperator());
            }
            String errorCode = e.getError().getErrorCode();
            String errorMessage = e.getError().getErrorMessageForCaller();
            subscribeResult.buildFailedResult(errorCode,errorMessage);
            return subscribeResult;
        }
        return subscribeResult;
    }

    private void validateParameter(InvestorVO investorVO, BondVO bondVO, TradeDataVO tradeDataVO){
        Result result = FluentValidator.checkAll().failOver()
                .on(investorVO,new HibernateSupportedValidator<>())
                .on(investorVO.getPhoneNumber(),new PhoneNumberValidator())
                .doValidate().result(toSimple());
        if(!result.isSuccess()){
            StringBuffer stringBuffer = new StringBuffer();
            for(String error : result.getErrors()){
                stringBuffer.append(error);
            }
            throw BizException.buildBizException (ErrorConstant.ERR_VALIDATION_PARAMETER.buildErrorMessageForCaller(stringBuffer.toString()));
        }
    }
}
