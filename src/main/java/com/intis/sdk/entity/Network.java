package com.intis.sdk.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class Network
 * Class for getting operator of subscriber
 */
public class Network {

    @JsonProperty("operator")
    protected String mTitle;

    @JsonProperty("currency")
    protected String mCurrency;

    @JsonProperty("error")
    protected int mError;

    @JsonProperty("mcc")
    protected String mMcc;

    @JsonProperty("mnc")
    protected String mMnc;

    @JsonProperty("phone")
    protected String mPhone;

    @JsonProperty("ported")
    protected String mPorted;

    @JsonProperty("price")
    protected String mPrice;

    @JsonProperty("regionCode")
    protected int mRegionCode;

    @JsonProperty("timeZone")
    protected int mTimeZone;

    /**
     * @return Operator name
     */
    public String getTitle() {
        return mTitle;
    }
}
