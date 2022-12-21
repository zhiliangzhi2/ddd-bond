package com.bond.domain.model.trade;

import java.math.BigDecimal;

/**
 * @author anzj
 * @date 2022/12/19 14:23
 */
public class Order {

    private String orderId;
    private String investorName;
    private String investorIdCardNo;
    private String bondCode;
    private BigDecimal orderAmount;


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

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
