package com.bond.domain.exception;

/**
 * @author anzj
 * @date 2022/12/19 17:59
 */
public abstract class ErrorConstant {

    public static final Error SUCCEED_TRADE = new Error("0000","交易成功","交易成功");
    public static final Error ERR_VALIDATION_PARAMETER = new Error("0001","输入参数校验不通过","输入参数校验不通过");
    public static final Error ERR_PAYMENT_FAILURE = new Error("0002","支付失败","支付失败");
    public static final Error ERR_VALIDATION_NOT_RELEASING = new Error("003","债券不在发行期","债券不在发行期");
}
