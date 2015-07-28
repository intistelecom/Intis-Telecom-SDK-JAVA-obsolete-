package com.intis.sdk.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class IncomingMessage
 * Class for getting incoming message
 */
public class IncomingMessage {

    @JsonProperty("messageId")
    protected String mMessageId;

    @JsonProperty("date")
    protected String mReceivedAt;

    @JsonProperty("sender")
    protected String mOriginator;

    @JsonProperty("prefix")
    protected String mPrefix;

    @JsonProperty("text")
    protected String mText;

    /**
     * @param messageId - Message ID
     */
    public void setMessageId(String messageId){
        mMessageId = messageId;
    }

    /**
     * @return Message ID
     */
    public String getMessageId() {
        return mMessageId;
    }

    /**
     * @return Date of message receipt
     */
    public String getReceivedAt() {
        return mReceivedAt;
    }

    /**
     * @return Sender name
     */
    public String getOriginator() {
        return mOriginator;
    }

    /**
     * @return Prefix of incoming message
     */
    public String getPrefix() {
        return mPrefix;
    }

    /**
     * @return SMS text
     */
    public String getText() {
        return mText;
    }
}
