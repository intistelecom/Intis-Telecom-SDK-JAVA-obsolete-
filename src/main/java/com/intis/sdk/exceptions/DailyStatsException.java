package com.intis.sdk.exceptions;

import java.util.Map;

public class DailyStatsException extends SDKSerializationException{
    public DailyStatsException(Map<String, String> parameters, Throwable ex){
        super(parameters, ex);
    };
}
