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

}
