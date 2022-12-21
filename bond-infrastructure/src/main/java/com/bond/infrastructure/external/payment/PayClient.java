package com.bond.infrastructure.external.payment;

import java.net.ConnectException;
import java.rmi.RemoteException;

/**
 * @author anzj
 * @date 2022/12/20 17:38
 */
public class PayClient {

    public static final String PAY_IP = "0.0.0.0";

    private String ip;
    private String port;

    public PayClient(String ip, String port){
        this.ip = ip;
        this.port = port;
    }


    public PayResponse toPay(PayRequest request)throws RemoteException{
        if(!PAY_IP.equals(ip)){
            throw new RemoteException("远程连接被拒绝",new ConnectException("Connection refused"));
        }
        return new PayResponse();
    }


}
