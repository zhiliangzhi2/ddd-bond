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
import com.bond.domain.model.trade.Bond;
import com.bond.domain.model.trade.Holding;
import com.bond.domain.model.trade.Inventory;
import com.bond.domain.model.trade.repository.BondRepository;
import com.bond.domain.model.trade.repository.HoldingRepository;
import com.bond.domain.model.trade.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toSimple;

/**
 * 应用服务层:1、逻辑错误异常等统一处理  2、业务主逻辑步骤
 */
@Service
public class BondServiceImpl implements BondService {

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
            Result result = FluentValidator.checkAll().failOver()
                    .on(investorVO,new HibernateSupportedValidator<>())
                    .on(investorVO.getPhoneNumber(),new PhoneNumberValidator())
                    .doValidate().result(toSimple());
            if(!result.isSuccess()){
                StringBuffer stringBuffer = new StringBuffer();
                for(String error : result.getErrors()){
                    stringBuffer.append(error);
                }
                subscribeResult.setResultType("f");
                subscribeResult.setResultMessage(stringBuffer.toString());
                return subscribeResult;
            }
            // step2 业务验证逻辑
            Bond bond = bondRepository.find(bondVO.getBondCode());
            bond.checkIssueStatus();
            // step3 业务执行逻辑 3.1 第三方服务调用ACL 3.2 repository调用存储服务
            Inventory inventory = inventoryRepository.find(bondVO.getBondCode());
            inventory.reduce(tradeDataVO.getFaceValue());

            Holding holding = holdingRepository.find(investorVO.getName(),bondVO.getBondCode());
            holding.add(tradeDataVO.getFaceValue());

            subscribeTransaction.transaction(holding,inventory);
            // step4 构建返回信息
            subscribeResult.buildSucceedResult();

        } catch (BizException e) {
            subscribeResult.buildFailedResult();
            return subscribeResult;
        }
        return subscribeResult;
    }
}
