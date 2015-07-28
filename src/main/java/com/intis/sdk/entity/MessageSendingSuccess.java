package com.intis.sdk.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Sergey on 27.07.2015.
 */
public class MessageSendingSuccess extends MessageSendingResult {

    protected String mMessageId;

    protected float mCost;

    protected String mCurrency;

    protected int mMessagesCount;

    public MessageSendingSuccess() {
        setIsOk(true);
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
     * @param mMessageId - Message ID
     */
    public void setMessageId(String mMessageId) {
        this.mMessageId = mMessageId;
    }

    /**
     * @param mCost - Price for message
     */
    public void setCost(float mCost) {
        this.mCost = mCost;
    }

    /**
     * @param mCurrency - Name of currency
     */
    public void setCurrency(String mCurrency) {
        this.mCurrency = mCurrency;
    }

    /**
     * @param mMessagesCount - Number of message parts
     */
    public void setMessagesCount(int mMessagesCount) {
        this.mMessagesCount = mMessagesCount;
    }
}
