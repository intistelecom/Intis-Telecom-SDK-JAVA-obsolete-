package com.intis.sdk.exceptions;

import java.util.Map;

public class HLRResponseException extends SDKSerializationException{
    public HLRResponseException(Map<String, String> parameters, Throwable ex){
        super(parameters, ex);
    };
}

