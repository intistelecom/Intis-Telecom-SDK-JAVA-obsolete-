package com.intis.sdk.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class DeliveryStatus
 * Class for getting message statuses
 */
public class DeliveryStatus {

    /**
     * Message ID
     */
    @JsonProperty("messageId")
    protected String mMessageId;

    /**
     * Message ID
     */
    @JsonProperty("status")
    protected String mMessageStatus;

    /**
     * Message ID
     */
    @JsonProperty("time")
    protected String mCreatedAt;

    public String getMessageId() {
        return mMessageId;
    }

    public String getMessageStatus() {
        return mMessageStatus;
    }

    public String getCreatedAt() {
        return mCreatedAt;
    }
}
