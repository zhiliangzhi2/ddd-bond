package com.bond.infrastructure.facadeimpl;

import com.bond.domain.model.trade.Order;
import com.bond.domain.model.trade.PaymentAccount;
import com.bond.domain.model.trade.ability.facade.PaymentFacade;

/**
 * @author anzj
 * @date 2022/12/19 14:47
 */
public class PaymentFacadeImpl implements PaymentFacade {


    @Override
    public String Pay(Order order, PaymentAccount sourceAccount, PaymentAccount targetAccount) {

        //调用三方支付接口进行支付

        return null;

    }
}
