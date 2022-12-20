package com.bond.client.dto.result;

/**
 * @author anzj
 * @date 2022/12/18 17:37
 */
public class Result {
    /**
     * 返回类型 s-成功 f-失败 w-警告
     */
    private String resultType;

    /**
     * 自定义返回码
     */
    private String resultCode;

    /**
     * 返回消息
     */
    private String resultMessage;


    public void buildSucceedResult(){
        setResultMessage("交易成功");
    }

    public void buildFailedResult(String errorCode,String errorMessage){
        setResultMessage("交易失败");
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }
}
