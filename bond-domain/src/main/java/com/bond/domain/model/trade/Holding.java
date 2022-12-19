package com.bond.domain.model.trade;

/**
 * @author anzj
 * @date 2022/12/19 14:00
 */
public class Holding {

    /**
     * 投资人名称
     */
    private String investorName;


    /**
     * 债券代码
     */
    private String bondCode;

    /**
     * 持有额度
     */
    private Long holdQuota;


    public void add(Long faceValue){
        holdQuota += faceValue;
    }



    public String getInvestorName() {
        return investorName;
    }

    public void setInvestorName(String investorName) {
        this.investorName = investorName;
    }

    public String getBondCode() {
        return bondCode;
    }

    public void setBondCode(String bondCode) {
        this.bondCode = bondCode;
    }

    public Long getHoldQuota() {
        return holdQuota;
    }

    public void setHoldQuota(Long holdQuota) {
        this.holdQuota = holdQuota;
    }
}
