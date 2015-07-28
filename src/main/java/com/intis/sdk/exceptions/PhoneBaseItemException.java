package com.intis.sdk.exceptions;

import java.util.Map;

public class PhoneBaseItemException extends SDKSerializationException{
    public PhoneBaseItemException(Map<String, String> parameters, Throwable ex){
        super(parameters, ex);
    };
}
