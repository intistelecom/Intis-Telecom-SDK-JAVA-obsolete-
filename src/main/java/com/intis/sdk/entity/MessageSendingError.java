package com.intis.sdk.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.intis.sdk.exceptions.SDKException;

public class MessageSendingError extends MessageSendingResult {

    @JsonProperty("code")
    protected int mCode;

    /**
     * @return Error text in SMS sending
     */
    public int getCode() {
        return mCode;
    }

    public String getMessage() {
        return SDKException.getMessage(mCode);
    }

//    public MessageSendingError()
//    : base()
//    {
//        IsOk = false;
//    }
}
