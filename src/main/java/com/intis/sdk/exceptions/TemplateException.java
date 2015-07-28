package com.intis.sdk.exceptions;

import java.util.Map;

public class TemplateException extends SDKSerializationException{
    public TemplateException(Map<String, String> parameters, Throwable ex){
        super(parameters, ex);
    };
}

