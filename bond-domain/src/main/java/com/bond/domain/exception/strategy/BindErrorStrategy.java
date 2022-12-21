package com.bond.domain.exception.strategy;

import com.bond.domain.exception.Error;
import com.bond.domain.exception.NetError;

/**
 * @author anzj
 * @date 2022/12/20 15:41
 */
public class BindErrorStrategy implements NetErrorStrategy {
    @Override
    public Error parseNetError(String message, String url, Integer connectTimeout, Integer readTimeout) {
        return NetError.ERR_REMOTE_ALREADY_BIND.buildErrorMessageForOperator(url);
    }
}
