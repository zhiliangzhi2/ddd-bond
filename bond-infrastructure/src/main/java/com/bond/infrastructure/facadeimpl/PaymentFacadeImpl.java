package com.bond.infrastructure.facadeimpl;

import com.bond.domain.model.trade.Order;
import com.bond.domain.model.trade.PaymentAccount;
import com.bond.domain.model.trade.ability.facade.PaymentFacade;
import com.bond.domain.model.trade.type.PaymentResult;
import com.bond.infrastructure.common.Constant;
import com.bond.infrastructure.external.payment.PayClient;
import com.bond.infrastructure.external.payment.PayRequest;
import com.bond.infrastructure.external.payment.PayResult;

/**
 * @author anzj
 * @date 2022/12/19 14:47
 */
public class PaymentFacadeImpl implements PaymentFacade {


    @Override
    public PaymentResult Pay(Order order, PaymentAccount sourceAccount, PaymentAccount targetAccount) {
        PaymentResult result = null;

        try {
            //调用三方支付接口进行支付
            PayClient payClient = new PayClient("0.0.0.0","8080");
            PayRequest request = new PayRequest();
            request.setSourceAccount(sourceAccount.getAccountNo());
            request.setTargetAccount(targetAccount.getAccountNo());
            request.setAmount(order.getOrderAmount());

            PayResult payResult = payClient.toPay(request);

            result = new PaymentResult();

            if(Constant.PAY_SUCCEED.equals(payResult.getCode())){
                result.setResultCode(PaymentResult.SUCCESS_CODE);
            }else{
                result.setResultCode(PaymentResult.FAILURE_CODE);
            }
        } catch (Exception e) {

        }

        return result;

    }
}
