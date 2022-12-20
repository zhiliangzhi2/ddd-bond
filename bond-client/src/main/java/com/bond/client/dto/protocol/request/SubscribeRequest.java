package com.bond.client.dto.protocol.request;

import com.bond.client.dto.valueobject.BondVO;
import com.bond.client.dto.valueobject.InvestorVO;
import com.bond.client.dto.valueobject.TradeDataVO;

/**
 * @author anzj
 * @date 2022/12/19 17:06
 */
public class SubscribeRequest {

    /**
     * 投资人姓名
     */
    private String investorName;
    /**
     * 投资人身份证号
     */
    private String investorIdCardNo;

    /**
     * 债券代码
     */
    private String bondCode;
    /**
     * 交易日期
     */
    private String tradeDate;
    /**
     * 交易面额
     */
    private Long faceValue;



    public BondVO getBondVO(){
        BondVO bondVO = new BondVO();
        bondVO.setBondCode(getBondCode());
        return bondVO;
    }

    public InvestorVO getInvestorVO(){
        InvestorVO investorVO = new InvestorVO();
        investorVO.setName(getInvestorName());
        investorVO.setIdCardNO(getInvestorIdCardNo());
        return investorVO;
    }

    public TradeDataVO getTradeDataVO(){
        TradeDataVO tradeDataVO = new TradeDataVO();
        tradeDataVO.setFaceValue(getFaceValue());
        tradeDataVO.setTradeDate(getTradeDate());
        return new TradeDataVO();
    }

    public String getInvestorName() {
        return investorName;
    }

    public void setInvestorName(String investorName) {
        this.investorName = investorName;
    }

    public String getInvestorIdCardNo() {
        return investorIdCardNo;
    }

    public void setInvestorIdCardNo(String investorIdCardNo) {
        this.investorIdCardNo = investorIdCardNo;
    }

    public String getBondCode() {
        return bondCode;
    }

    public void setBondCode(String bondCode) {
        this.bondCode = bondCode;
    }

    public String getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
    }

    public Long getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(Long faceValue) {
        this.faceValue = faceValue;
    }
}
