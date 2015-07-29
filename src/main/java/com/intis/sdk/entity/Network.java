package com.intis.sdk.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class Network
 * Class for getting operator of subscriber
 */
public class Network {

    @JsonProperty("operator")
    private String title;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("error")
    private int error;

    @JsonProperty("mcc")
    private String mcc;

    @JsonProperty("mnc")
    private String mnc;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("ported")
    private String ported;

    @JsonProperty("price")
    private String price;

    @JsonProperty("regionCode")
    private int regionCode;

    @JsonProperty("timeZone")
    private int timeZone;

    /**
     * @return Operator name
     */
    public String getTitle() {
        return title;
    }
}
