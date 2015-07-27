package com.intis.sdk.exceptions;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.util.Map;

public class SDKSerializationException extends JsonMappingException {
    public Map<String, String> parameters;

    public SDKSerializationException(String msg) {
        super(msg);
    }

    public SDKSerializationException(Map<String, String> params, Throwable rootCause) {
        super(rootCause.getMessage(), rootCause);
        parameters = params;
    }

    public SDKSerializationException(String msg, Throwable rootCause) {
        super(msg, rootCause);
    }

    public SDKSerializationException(String msg, JsonLocation loc) {
        super(msg, loc);
    }

    public SDKSerializationException(String msg, JsonLocation loc, Throwable rootCause) {
        super(msg, loc, rootCause);
    }
}
