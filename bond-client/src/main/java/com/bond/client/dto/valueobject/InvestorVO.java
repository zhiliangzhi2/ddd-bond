package com.bond.client.dto.valueobject;

import javax.validation.constraints.NotNull;

/**
 * 投资人信息值对象
 */
public class InvestorVO {

    /**
     * 投资人姓名
     */
    @NotNull(message = "姓名不能为空")
    private String name;

    /**
     * 电话号码
     */
    private String phoneNumber;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
