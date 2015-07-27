package com.intis.sdk.exceptions;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.io.IOException;
import java.util.Map;

public class BalanceException extends SDKSerializationException {

    public BalanceException(Map<String, String> parameters, Throwable ex){
        super(parameters, ex);
    };
}
