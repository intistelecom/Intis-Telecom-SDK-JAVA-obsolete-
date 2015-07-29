package com.intis.sdk.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class IncomingMessage
 * Class for getting incoming message
 */
public class IncomingMessage {

    @JsonProperty("messageId")
    private String messageId;

    @JsonProperty("date")
    private String receivedAt;

    @JsonProperty("sender")
    private String originator;

    @JsonProperty("prefix")
    private String prefix;

    @JsonProperty("text")
    private String text;

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
