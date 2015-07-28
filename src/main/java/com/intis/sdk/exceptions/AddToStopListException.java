package com.intis.sdk.exceptions;

import java.util.Map;

public class AddToStopListException extends SDKSerializationException{
    public AddToStopListException(Map<String, String> parameters, Throwable ex){
        super(parameters, ex);
    };
}
