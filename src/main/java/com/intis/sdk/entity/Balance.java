package com.intis.sdk.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class Balance
 * Class of getting balance
 */
public class Balance {

    @JsonProperty("money")
    protected String mAmount;

    @JsonProperty("currency")
    protected String mCurrency;

    @JsonProperty("bonusAmount")
    protected String mBonusAmount;

    /**
     * @return Amount of money
     */
    public String getAmount() {
        return mAmount;
    }

    /**
     * @return Name of currency
     */
    public String getCurrency() {
        return mCurrency;
    }

    /**
     * @return The bonus amount
     */
    public String getBonusAmount() {
        return mBonusAmount;
    }
}
