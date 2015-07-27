package com.intis.sdk.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class Balance
 * Class of getting balance
 */
public class Balance {
    /**
     * Amount of money
     */
    @JsonProperty("money")
    protected String mAmount;

    /**
     * Name of currency
     */
    @JsonProperty("currency")
    protected String mCurrency;

    public String getAmount() {
        return mAmount;
    }

    public String getCurrency() {
        return mCurrency;
    }
}
