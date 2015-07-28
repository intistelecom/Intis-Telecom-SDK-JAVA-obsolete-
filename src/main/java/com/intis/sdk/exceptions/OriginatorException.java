package com.intis.sdk.exceptions;

import java.util.Map;

public class OriginatorException extends SDKSerializationException {
    public OriginatorException(Map<String, String> parameters, Throwable ex) {
        super(parameters, ex);
    }
}
