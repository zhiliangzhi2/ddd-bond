package com.bond.domain.exception;

import com.sun.xml.internal.bind.v2.model.runtime.RuntimeNonElement;

/**
 * @author anzj
 * @date 2022/12/19 11:05
 */
public class BizException extends RuntimeException {

    private String message;
    private Throwable t;

    public BizException(String message){
        this.message = message;
    }

    public BizException(String message,Throwable throwable){
        this.message = message;
        this.t = throwable;
    }
}
