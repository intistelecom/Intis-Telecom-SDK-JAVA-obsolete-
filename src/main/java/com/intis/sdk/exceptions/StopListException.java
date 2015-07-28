package com.intis.sdk.exceptions;

import java.util.Map;

public class StopListException extends SDKSerializationException{
    public StopListException(Map<String, String> parameters, Throwable ex){
        super(parameters, ex);
    };
}