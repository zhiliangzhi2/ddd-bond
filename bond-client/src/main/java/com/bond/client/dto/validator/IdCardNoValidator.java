package com.bond.client.dto.validator;

import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @author anzj
 * @date 2022/12/20 11:24
 */
public class IdCardNoValidator extends ValidatorHandler<String> implements Validator<String> {


    @Override
    public boolean validate(ValidatorContext context, String s) {


        return true;
    }
}
