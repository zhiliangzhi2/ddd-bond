package com.bond.client.dto.protocol.request;

import com.bond.client.dto.valueobject.BondVO;
import com.bond.client.dto.valueobject.InvestorVO;
import com.bond.client.dto.valueobject.TradeDataVO;

/**
 * @author anzj
 * @date 2022/12/19 17:06
 */
public class SubscribeRequest {


    public BondVO getBondVO(){
        return new BondVO();
    }

    public InvestorVO getInvestorVO(){
        return new InvestorVO();
    }

    public TradeDataVO getTradeDataVO(){
        return new TradeDataVO();
    }

}
