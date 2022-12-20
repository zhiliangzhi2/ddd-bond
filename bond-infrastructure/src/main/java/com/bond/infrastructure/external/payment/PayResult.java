package com.bond.infrastructure.external.payment;

/**
 * @author anzj
 * @date 2022/12/20 17:38
 */
public class PayResult {

    private String type;
    private String code;
    private String message;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
