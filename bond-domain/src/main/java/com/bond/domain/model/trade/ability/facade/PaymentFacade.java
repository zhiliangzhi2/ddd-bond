package com.bond.domain.model.trade.ability.facade;

import com.bond.domain.model.trade.Order;
import com.bond.domain.model.trade.PaymentAccount;
import com.bond.domain.model.trade.type.PaymentResult;

/**
 * @author anzj
 * @date 2022/12/19 14:19
 */
public interface PaymentFacade {

     PaymentResult Pay(Order order, PaymentAccount sourceAccount, PaymentAccount targetAccount);

}
