package com.bond.infrastructure.facadeimpl;

import com.bond.domain.exception.BizException;
import com.bond.domain.model.trade.Order;
import com.bond.domain.model.trade.PaymentAccount;
import org.junit.jupiter.api.Test;

/**
 * @author anzj
 * @date 2022/12/21 11:09
 */

public class PaymentFacadeImplTest {

    @Test
    public void payTest(){
        Order order = new Order();
        order.setOrderId("000001");

        PaymentAccount sourceAccount = new PaymentAccount();
        sourceAccount.setAccountNo("1111");

        PaymentAccount targetAccount = new PaymentAccount();
        targetAccount.setAccountNo("2222");

        PaymentFacadeImpl paymentFacade = new PaymentFacadeImpl();

        try {
            paymentFacade.Pay(order,sourceAccount,targetAccount);
        } catch (BizException e){
            System.out.println(e.getError().getErrorMessageForOperator());
        }

    }
}
