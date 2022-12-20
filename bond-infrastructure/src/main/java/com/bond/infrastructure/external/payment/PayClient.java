package com.bond.infrastructure.external.payment;

import java.net.ConnectException;

/**
 * @author anzj
 * @date 2022/12/20 17:38
 */
public class PayClient {

    private String ip;
    private String port;

    public PayClient(String ip, String port){
        this.ip = ip;
        this.port = port;
    }


    public PayResult toPay(PayRequest request){
        return new PayResult();
    }


}
