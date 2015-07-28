package com.intis.sdk.exceptions;

import java.util.Map;

public class HLRStatItemException extends SDKSerializationException{
    public HLRStatItemException(Map<String, String> parameters, Throwable ex){
        super(parameters, ex);
    };
}