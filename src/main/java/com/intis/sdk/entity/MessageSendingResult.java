package com.intis.sdk.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class MessageSendingResult
 * Class of getting response to SMS sending
 */
public class MessageSendingResult {

    @JsonProperty("phone")
    protected long mPhone;

    @JsonProperty("isOk")
    protected boolean mIsOk;

    /**
     * @return Phone number
     */
    public long getPhone() {
        return mPhone;
    }

    /**
     * @return Success result
     */
    public boolean isOk() {
        return mIsOk;
    }
}
