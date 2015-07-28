package com.intis.sdk.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class DeliveryStatus
 * Class for getting message statuses
 */
public class DeliveryStatus {

    @JsonProperty("messageId")
    protected String mMessageId;

    @JsonProperty("status")
    protected String mMessageStatus;

    @JsonProperty("time")
    protected String mCreatedAt;

    /**
     * @return Message ID
     */
    public String getMessageId() {
        return mMessageId;
    }

    public void setMessageId(String messageId){
        mMessageId = messageId;
    }

    /**
     * @return Status of message
     */
    public String getMessageStatus() {
        return mMessageStatus;
    }

    /**
     * @return Message ID
     */
    public String getCreatedAt() {
        return mCreatedAt;
    }
}
