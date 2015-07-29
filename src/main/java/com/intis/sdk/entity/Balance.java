package com.intis.sdk.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class Balance
 * Class of getting balance
 */
public class Balance {

    @JsonProperty("money")
    protected String amount;

    @JsonProperty("currency")
    protected String currency;

    @JsonProperty("bonusAmount")
    protected String bonusAmount;

    /**
     * @return Amount of money
     */
    public String getAmount() {
        return amount;
    }

    /**
     * @return Name of currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * @return The bonus amount
     */
    public String getBonusAmount() {
        return bonusAmount;
    }
}
