package com.bond.infrastructure.external.payment;

import java.net.ConnectException;
import java.rmi.RemoteException;

/**
 * @author anzj
 * @date 2022/12/21 10:54
 */
public class QueryClient {
    public static final String QUERY_IP = "0.0.0.0";

    private String ip;
    private String port;

    public QueryClient(String ip,String port){
        this.ip = ip;
        this.port = port;
    }

    public QueryResponse toQuery(QueryRequest request)throws RemoteException{

        if(!QUERY_IP.equals(ip)){
            throw new RemoteException("远程连接被拒绝",new ConnectException("Connection refused"));
        }
        return new QueryResponse();
    }


    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
