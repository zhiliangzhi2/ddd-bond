package com.bond.domain.model.trade.ability.factory;

import com.bond.domain.model.trade.PaymentAccount;

/**
 * @author anzj
 * @date 2022/12/19 14:29
 */
public interface PaymentAccountFactory {

    PaymentAccount initSourceAccount();

    PaymentAccount initTargetAccount();
}
