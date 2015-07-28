package com.intis.sdk.exceptions;

import java.util.Map;

public class AddTemplateException extends SDKSerializationException{
    public AddTemplateException(Map<String, String> parameters, Throwable ex){
        super(parameters, ex);
    };
}