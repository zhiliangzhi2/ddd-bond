package com.bond.app.transaction;

import com.bond.domain.model.trade.Holding;
import com.bond.domain.model.trade.Inventory;
import com.bond.domain.model.trade.Order;
import com.bond.domain.model.trade.PaymentAccount;
import com.bond.domain.model.trade.ability.facade.PaymentFacade;
import com.bond.domain.model.trade.ability.factory.OrderFactory;
import com.bond.domain.model.trade.ability.factory.PaymentAccountFactory;
import com.bond.domain.model.trade.repository.HoldingRepository;
import com.bond.domain.model.trade.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author anzj
 * @date 2022/12/19 14:14
 */
@Component
public class SubscribeTransaction {

    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private HoldingRepository holdingRepository;
    @Autowired
    private PaymentFacade paymentFacade;
    @Autowired
    private OrderFactory orderFactory;
    @Autowired
    private PaymentAccountFactory paymentAccountFactory;

    @Transactional
    public void transaction(Holding holding, Inventory inventory){
        inventoryRepository.update(inventory);
        holdingRepository.save(holding);

        Order order = orderFactory.create();
        PaymentAccount sourceAccount = paymentAccountFactory.initSourceAccount();
        PaymentAccount targetAccount = paymentAccountFactory.initTargetAccount();
        //支付
        paymentFacade.Pay(order,sourceAccount,targetAccount);

    }
}
