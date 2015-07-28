package com.intis.sdk.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class MessageSendingResult
 * Class of getting response to SMS sending
 */
public class MessageSendingResult {

    protected String mPhone;

    protected boolean mIsOk;

    /**
     * @return Phone number
     */
    public String getPhone() {
        return mPhone;
    }

    /**
     * @return Success result
     */
    public boolean isOk() {
        return mIsOk;
    }

    /**
     * @param mPhone - Phone number
     */
    public void setPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    /**
     * @param mIsOk - Success result
     */
    public void setIsOk(boolean mIsOk) {
        this.mIsOk = mIsOk;
    }
}
