package com.intis.sdk.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class IncomingMessage
 * Class for getting incoming message
 */
public class IncomingMessage {

    @JsonProperty("messageId")
    protected String messageId;

    @JsonProperty("date")
    protected String receivedAt;

    @JsonProperty("sender")
    protected String originator;

    @JsonProperty("prefix")
    protected String prefix;

    @JsonProperty("text")
    protected String text;

    /**
     * @param messageId - Message ID
     */
    public void setMessageId(String messageId){
        this.messageId = messageId;
    }

    /**
     * @return Message ID
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * @return Date of message receipt
     */
    public String getReceivedAt() {
        return receivedAt;
    }

    /**
     * @return Sender name
     */
    public String getOriginator() {
        return originator;
    }

    /**
     * @return Prefix of incoming message
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * @return SMS text
     */
    public String getText() {
        return text;
    }
}
