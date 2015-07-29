package com.intis.sdk.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class Stats
 * Class for getting statistics
 */
public class Stats {

    @JsonProperty("cost")
    private float cost;

    @JsonProperty("status")
    private String statusText;

    @JsonProperty("parts")
    private int count;

    public int getCount() {
        return count;
    }

    public float getCost() {
        return cost;
    }

    public MessageState getState(){
        return MessageState.Parse(statusText);

    }
}
