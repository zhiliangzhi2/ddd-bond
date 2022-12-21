package com.bond.domain.exception.strategy;


import com.bond.domain.exception.Error;
import com.bond.domain.exception.NetError;

/**
 * @author anzj
 * @date 2022/12/20 16:02
 */
public class DefaultNetErrorStrategy implements NetErrorStrategy{
    @Override
    public Error parseNetError(String message, String url, Integer connectTimeout, Integer readTimeout) {
        return NetError.ERR_REMOTE_ERROR;
    }
}
