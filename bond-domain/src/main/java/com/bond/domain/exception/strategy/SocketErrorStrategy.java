package com.bond.domain.exception.strategy;

import com.bond.domain.exception.Error;
import com.bond.domain.exception.NetError;

/**
 * @author anzj
 * @date 2022/12/20 15:41
 */
public class SocketErrorStrategy implements NetErrorStrategy{
    @Override
    public Error parseNetError(String message, String url, Integer connectTimeout, Integer readTimeout) {
        Error error = NetError.ERR_REMOTE_ERROR;
        if(message.contains(NetError.SOCKET_CLOSED)){
            error = NetError.ERR_REMOTE_SOCKET_CLOSED.buildErrorMessageForOperator(url);
        }else if(message.contains(NetError.CONNECTION_RESET)){
            error = NetError.ERR_REMOTE_CONNECTION_RESET.buildErrorMessageForOperator(url);
        }else if(message.contains(NetError.BROKEN_PIPE)){
            error = NetError.ERR_REMOTE_PIPE_BROKEN.buildErrorMessageForOperator(url);
        }
        return error;
    }
}
