package com.bond.domain.exception.strategy;

import com.bond.domain.exception.Error;
import com.bond.domain.exception.NetError;

/**
 * @author anzj
 * @date 2022/12/20 15:42
 */
public class ConnectErrorStrategy implements NetErrorStrategy {
    @Override
    public Error parseNetError(String message, String url, Integer connectTimeout, Integer readTimeout) {
        Error error = NetError.ERR_REMOTE_ERROR;

        if(message.contains(NetError.CONNECTION_REFUSED)){
            error = NetError.ERR_REMOTE_CONNECTION_REFUSED.buildErrorMessageForOperator(url);
        }else if(message.contains(NetError.CONNECTION_TIMEOUT)){
            error = NetError.ERR_REMOTE_CONNECTION_TIMEOUT.buildErrorMessageForOperator(url,String.valueOf(connectTimeout));
        }

        return error;
    }
}
