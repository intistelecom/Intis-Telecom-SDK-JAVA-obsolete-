package com.intis.sdk.exceptions;

import java.util.Map;

public class MessageSendingResultException extends SDKSerializationException{
    public MessageSendingResultException(Map<String, String> parameters, Throwable ex){
        super(parameters, ex);
    };
}
