package com.intis.sdk.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class Stats
 * Class for getting statistics
 */
public class Stats {

    @JsonProperty("cost")
    protected float mCost;

    @JsonProperty("status")
    protected String mStatusText;

    @JsonProperty("parts")
    protected int mCount;

    public int getCount() {
        return mCount;
    }

    public float getCost() {
        return mCost;
    }

    public int getState(){
        return MessageState.Parse(mStatusText);

    }
}
