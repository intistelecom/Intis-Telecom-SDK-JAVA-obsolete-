package com.intis.sdk.exceptions;

import java.util.Map;

public class NetworkException extends SDKSerializationException{
    public NetworkException(Map<String, String> parameters, Throwable ex){
        super(parameters, ex);
    };
}
