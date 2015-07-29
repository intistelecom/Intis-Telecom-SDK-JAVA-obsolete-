package com.intis.sdk.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class MessageSendingResult
 * Class of getting response to SMS sending
 */
public class MessageSending {

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("id_sms")
    private String messageId;

    @JsonProperty("cost")
    private float cost;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("count_sms")
    private int messagesCount;

    @JsonProperty("error")
    private int error;

    @JsonProperty("sender")
    private String sender;

    @JsonProperty("network")
    private String network;

    @JsonProperty("ported")
    private int ported;

    /**
     * @param phone phone
     */
    public void setPhone(String phone){
        this.phone = phone;
    }

    /**
     * @return Phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @return Message ID
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * @return Price for message
     */
    public float getCost() {
        return cost;
    }

    /**
     * @return Name of currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * @return Number of message parts
     */
    public int getMessagesCount() {
        return messagesCount;
    }

    /**
     * @return Error text in SMS sending
     */
    public int getError() {
        return error;
    }

    /**
     * @return Sender
     */
    public String getSender(){
        return sender;
    }

    /**
     * @return operator
     */
    public String getNetwork(){
        return network;
    }

    public int getPorted(){
        return ported;
    }
}
