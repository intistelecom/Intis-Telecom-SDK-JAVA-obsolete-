package com.intis.sdk.exceptions;

import java.util.Map;

public class PhoneBasesException extends SDKSerializationException{
    public PhoneBasesException(Map<String, String> parameters, Throwable ex){
        super(parameters, ex);
    };
}
