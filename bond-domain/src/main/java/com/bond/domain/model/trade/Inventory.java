package com.bond.domain.model.trade;

/**
 * @author anzj
 * @date 2022/12/19 13:51
 */
public class Inventory {

    /**
     * 债券代码
     */
    private String bondCode;

    /**
     *  剩余额度
     */
    private Long remainQuota;

    public void reduce(Long faceValue){
        remainQuota -= faceValue;
    }


    public String getBondCode() {
        return bondCode;
    }

    public void setBondCode(String bondCode) {
        this.bondCode = bondCode;
    }

    public Long getRemainQuota() {
        return remainQuota;
    }

    public void setRemainQuota(Long remainQuota) {
        this.remainQuota = remainQuota;
    }
}
