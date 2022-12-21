package com.bond.infrastructure.external.payment;

/**
 * @author anzj
 * @date 2022/12/21 10:54
 */
public class QueryResponse {

    private String code;

    private String message;

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
