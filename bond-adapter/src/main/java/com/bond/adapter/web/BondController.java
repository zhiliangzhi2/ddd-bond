package com.bond.adapter.web;

import com.bond.client.api.BondService;
import com.bond.client.dto.protocol.request.SubscribeRequest;
import com.bond.client.dto.protocol.response.SubscribeResponse;
import com.bond.client.dto.result.SubscribeResult;
import com.bond.client.dto.valueobject.BondVO;
import com.bond.client.dto.valueobject.InvestorVO;
import com.bond.client.dto.valueobject.TradeDataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.table.TableRowSorter;

/**
 * @author anzj
 * @date 2022/12/19 16:51
 */
@RestController
public class BondController {

    @Autowired
    private BondService bondService;

    @PostMapping("/bond/subscribe")
    @ResponseBody
    public SubscribeResponse subscription(SubscribeRequest request){
        SubscribeResponse response = new SubscribeResponse();

        BondVO bondVO = request.getBondVO();
        InvestorVO investorVO = request.getInvestorVO();
        TradeDataVO tradeDataVO = request.getTradeDataVO();

        SubscribeResult result = bondService.subscribe(investorVO,bondVO,tradeDataVO);

        return response;
    }
}
