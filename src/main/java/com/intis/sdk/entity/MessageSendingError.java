package com.intis.sdk.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.intis.sdk.exceptions.SDKException;

public class MessageSendingError extends MessageSendingResult {

    private int code;

    public MessageSendingError(){
        setIsOk(false);
    }

    /**
     * @return Code error in SMS sending
     */
    public int getCode() {
        return code;
    }

    /**
     *
     * @param code - Code error
     */
    public void setCode(int code){
        this.code = code;
    }

    /**
    * @return Error text
    */
    public String getMessage() {
        return SDKException.getMessage(code);
    }
}
