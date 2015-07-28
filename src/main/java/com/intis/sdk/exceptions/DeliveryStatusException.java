package com.intis.sdk.exceptions;

import java.util.Map;

public class DeliveryStatusException extends SDKSerializationException{
    public DeliveryStatusException(Map<String, String> parameters, Throwable ex){
        super(parameters, ex);
    };
}
