package com.bond.domain.exception;


import com.bond.domain.exception.strategy.NetErrorStrategy;

/**
 * @author anzj
 * @date 2022/12/20 15:43
 */
public class NetErrorContext {

    private NetErrorStrategy netErrorStrategy;

    public NetErrorContext(NetErrorStrategy netErrorStrategy){
        this.netErrorStrategy = netErrorStrategy;
    }

    public Error parseNetError(String errorMessage, String url, Integer connectTimeout, Integer readTimeout){
        return netErrorStrategy.parseNetError(errorMessage,url,connectTimeout,readTimeout);
    }
}
