package com.intis.sdk.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class DeliveryStatus
 * Class for getting message statuses
 */
public class DeliveryStatus {

    private String messageId;

    @JsonProperty("status")
    private String messageStatus;

    @JsonProperty("time")
    private String createdAt;

    /**
     * @return Message ID
     */
    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId){
        this.messageId = messageId;
    }

    /**
     * @return Status of message
     */
    public String getMessageStatus() {
        return messageStatus;
    }

    /**
     * @return Message ID
     */
    public String getCreatedAt() {
        return createdAt;
    }
}
