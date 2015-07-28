package com.intis.sdk.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Sergey on 27.07.2015.
 */
public class MessageSendingSuccess extends MessageSendingResult {

    @JsonProperty("messageId")
    protected String mMessageId;

    @JsonProperty("cost")
    protected float mCost;

    @JsonProperty("currency")
    protected String mCurrency;

    @JsonProperty("messageCount")
    protected int mMessagesCount;

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

    //    public MessageSendingSuccess()
//    : base()
//    {
//        IsOk = true;
//    }
}
