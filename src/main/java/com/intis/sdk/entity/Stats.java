package com.intis.sdk.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class Stats
 * Class for getting statistics
 */
public class Stats {
    protected String mStateText;

    @JsonProperty("cost")
    protected float mCost;

    @JsonProperty("currency")
    protected String mCurrency;

    @JsonProperty("parts")
    protected int mCount;

    /**
     * @param state Status of message
     */
    public void setmStateText(String state){
        mStateText = state;
    }

    /**
     * @return Status of message
     */
    public int getState(){
        return MessageState.Parse(mStateText);
    }

    /**
     * @return Price for message
     */
    public float getCost() {
        return mCost;
    }

    /**
     * @return Name of currency
     */
    public String getCurrency() {
        return mCurrency;
    }

    /**
     * @return Number of message parts
     */
    public int getCount() {
        return mCount;
    }
}
