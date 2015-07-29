package com.intis.sdk.entity;

/**
 * Class MessageSendingResult
 * Class of getting response to SMS sending
 */
public class MessageSendingResult {

    private String phone;

    private boolean isOk;

    /**
     * @return Phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @return Success result
     */
    public boolean isOk() {
        return isOk;
    }

    /**
     * @param mPhone - Phone number
     */
    public void setPhone(String mPhone) {
        this.phone = mPhone;
    }

    /**
     * @param mIsOk - Success result
     */
    public void setIsOk(boolean mIsOk) {
        this.isOk = mIsOk;
    }
}
