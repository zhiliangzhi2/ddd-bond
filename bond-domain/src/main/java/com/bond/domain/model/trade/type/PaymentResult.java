package com.bond.domain.model.trade.type;

/**
 * @author anzj
 * @date 2022/12/20 17:48
 */
public class PaymentResult {
    public static final String SUCCESS_CODE = "S";
    public static final String FAILURE_CODE = "F";
    public static final String UNKNOWN = "U";

    private String resultCode;

    public boolean isSuccess(){
        return resultCode == SUCCESS_CODE;
    }

    public boolean isUnknown(){
        return resultCode == UNKNOWN;
    }


    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }
}
