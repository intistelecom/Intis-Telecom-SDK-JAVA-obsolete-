package com.intis.sdk.entity;
/**
 * Created by Sergey on 27.07.2015.
 */
public class MessageSendingSuccess extends MessageSendingResult {

    protected String messageId;

    protected float cost;

    protected String currency;

    protected int messagesCount;

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
     * @param mMessageId - Message ID
     */
    public void setMessageId(String mMessageId) {
        this.messageId = mMessageId;
    }

    /**
     * @param mCost - Price for message
     */
    public void setCost(float mCost) {
        this.cost = mCost;
    }

    /**
     * @param mCurrency - Name of currency
     */
    public void setCurrency(String mCurrency) {
        this.currency = mCurrency;
    }

    /**
     * @param mMessagesCount - Number of message parts
     */
    public void setMessagesCount(int mMessagesCount) {
        this.messagesCount = mMessagesCount;
    }
}
