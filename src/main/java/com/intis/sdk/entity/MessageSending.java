/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Intis Telecom
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:

 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.

 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
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
