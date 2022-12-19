package com.bond.client.api;

import com.bond.client.dto.result.SubscribeResult;
import com.bond.client.dto.valueobject.BondVO;
import com.bond.client.dto.valueobject.InvestorVO;
import com.bond.client.dto.valueobject.TradeDataVO;

/**
 * 债券相关服务
 */
public interface BondService {

    /**
     * 债券认购
     */
    SubscribeResult subscribe(InvestorVO investorVO, BondVO bondVO, TradeDataVO tradeDataVO);
}
