package com.bond.domain.exception;


import com.bond.domain.exception.strategy.*;

import java.net.BindException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;

/**
 * @author anzj
 * @date 2022/12/20 15:28
 */
public class NetErrorParser {


    public static Error parse(Throwable t, String url, Integer readTimeout, Integer connectTimeout){
        Error error =null;
        NetErrorContext netErrorContext = null;
        while(true){
            if(t instanceof ConnectException){
                netErrorContext = new NetErrorContext(new ConnectErrorStrategy());
                break;
            }else if(t instanceof SocketTimeoutException){
                netErrorContext = new NetErrorContext(new SocketTimeoutErrorStrategy());
                break;
            }else if(t instanceof SocketException){
                netErrorContext = new NetErrorContext(new SocketErrorStrategy());
                break;
            }else if(t instanceof BindException){
                netErrorContext = new NetErrorContext(new BindErrorStrategy());
                break;
            }else if(t.getCause() == null){
                netErrorContext = new NetErrorContext(new DefaultNetErrorStrategy());
                break;
            }
            t = t.getCause();
        }
        error = netErrorContext.parseNetError(t.getMessage(), url,connectTimeout,readTimeout);
        return error;
    }
}
