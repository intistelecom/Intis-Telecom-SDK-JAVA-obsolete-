package com.intis.sdk.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class Network
 * Class for getting operator of subscriber
 */
public class Network {

    @JsonProperty("operator")
    protected String title;

    @JsonProperty("currency")
    protected String currency;

    @JsonProperty("error")
    protected int error;

    @JsonProperty("mcc")
    protected String mcc;

    @JsonProperty("mnc")
    protected String mnc;

    @JsonProperty("phone")
    protected String phone;

    @JsonProperty("ported")
    protected String ported;

    @JsonProperty("price")
    protected String price;

    @JsonProperty("regionCode")
    protected int regionCode;

    @JsonProperty("timeZone")
    protected int timeZone;

    /**
     * @return Operator name
     */
    public String getTitle() {
        return title;
    }
}
