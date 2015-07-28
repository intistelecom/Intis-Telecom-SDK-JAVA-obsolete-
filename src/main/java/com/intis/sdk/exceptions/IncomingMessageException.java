package com.intis.sdk.exceptions;

import java.util.Map;

public class IncomingMessageException extends SDKSerializationException{
    public IncomingMessageException(Map<String, String> parameters, Throwable ex){
        super(parameters, ex);
    };
}