package com.intis.sdk.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class Network
 * Class for getting operator of subscriber
 */
public class Network {

    @JsonProperty("operator")
    protected String mTitle;

    /**
     * @return Operator name
     */
    public String getTitle() {
        return mTitle;
    }
}
