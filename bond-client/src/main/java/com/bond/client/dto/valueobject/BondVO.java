package com.bond.client.dto.valueobject;

import java.math.BigDecimal;

/**
 * 债券信息
 */
public class BondVO {

    /**
     * 债券编码
     */
    private String bondCode;

    /**
     * 债券名称
     */
    private String bondName;

    /**
     * 债券发行人
     */
    private String issuer;

    /**
     * 债券发行价格
     */
    private BigDecimal issuePrice;


    public String getBondCode() {
        return bondCode;
    }

    public void setBondCode(String bondCode) {
        this.bondCode = bondCode;
    }

    public String getBondName() {
        return bondName;
    }

    public void setBondName(String bondName) {
        this.bondName = bondName;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public BigDecimal getIssuePrice() {
        return issuePrice;
    }

    public void setIssuePrice(BigDecimal issuePrice) {
        this.issuePrice = issuePrice;
    }
}
