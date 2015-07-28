package com.intis.sdk.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class MessageSendingResult
 * Class of getting response to SMS sending
 */
public class MessageSending {

    @JsonProperty("phone")
    protected String mPhone;

    @JsonProperty("id_sms")
    protected String mMessageId;

    @JsonProperty("cost")
    protected float mCost;

    @JsonProperty("currency")
    protected String mCurrency;

    @JsonProperty("count_sms")
    protected int mMessagesCount;

    @JsonProperty("error")
    protected int mError;

    @JsonProperty("sender")
    protected String mSender;

    @JsonProperty("network")
    protected String mNetwork;

    @JsonProperty("ported")
    protected int mPorted;

    /**
     * @param phone phone
     */
    public void setPhone(String phone){
        mPhone = phone;
    }

    /**
     * @return Phone number
     */
    public String getPhone() {
        return mPhone;
    }

    /**
     * @return Message ID
     */
    public String getMessageId() {
        return mMessageId;
    }

    /**
     * @return Price for message
     */
    public float getCost() {
        return mCost;
    }

    /**
     * @return Name of currency
     */
    public String getCurrency() {
        return mCurrency;
    }

    /**
     * @return Number of message parts
     */
    public int getMessagesCount() {
        return mMessagesCount;
    }

    /**
     * @return Error text in SMS sending
     */
    public int getError() {
        return mError;
    }

    /**
     * @return Sender
     */
    public String getSender(){
        return mSender;
    }

    /**
     * @return operator
     */
    public String getNetwork(){
        return mNetwork;
    }

    public int getPorted(){
        return mPorted;
    }
}
