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

/**
 * Class MessageSendingSuccess
 * Class for successful message sending
 */
public class MessageSendingSuccess extends MessageSendingResult {

    private String messageId;

    private float cost;

    private String currency;

    private int messagesCount;

    public MessageSendingSuccess() {
        setIsOk(true);
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
     * @param messageId - Message ID
     */
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    /**
     * @param cost - Price for message
     */
    public void setCost(float cost) {
        this.cost = cost;
    }

    /**
     * @param currency - Name of currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * @param messagesCount - Number of message parts
     */
    public void setMessagesCount(int messagesCount) {
        this.messagesCount = messagesCount;
    }
}
