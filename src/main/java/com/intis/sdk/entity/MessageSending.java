package com.intis.sdk.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class MessageSendingResult
 * Class of getting response to SMS sending
 */
public class MessageSending {

    @JsonProperty("phone")
    protected long mPhone;

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

    /**
     * @return Phone number
     */
    public long getPhone() {
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
}
