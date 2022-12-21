package com.bond.domain.exception.strategy;

import com.bond.domain.exception.Error;
import com.bond.domain.exception.NetError;

/**
 * @author anzj
 * @date 2022/12/20 15:42
 */
public class SocketTimeoutErrorStrategy implements NetErrorStrategy {
    @Override
    public Error parseNetError(String message, String url, Integer connectTimeout, Integer readTimeout) {
        Error error = NetError.ERR_REMOTE_ERROR;
        if(message.contains(NetError.SOCKET_READ_TIMEOUT)){
            error = NetError.ERR_REMOTE_SOCKET_READ_TIMEOUT.buildErrorMessageForOperator(url,String.valueOf(readTimeout));
        }else  if(message.contains(NetError.SOCKET_CONNECTION_TIMEOUT)){
            error = NetError.ERR_REMOTE_CONNECTION_TIMEOUT.buildErrorMessageForOperator(url,String.valueOf(connectTimeout));
        }
        return error;
    }
}
