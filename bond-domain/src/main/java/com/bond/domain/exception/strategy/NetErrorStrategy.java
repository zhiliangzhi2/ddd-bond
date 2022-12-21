package com.bond.domain.exception.strategy;


import com.bond.domain.exception.Error;

/**
 * @author anzj
 * @date 2022/12/20 15:39
 */
public interface NetErrorStrategy {

    Error parseNetError(String message, String url, Integer connectTimeout, Integer readTimeout);
}
