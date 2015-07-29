package com.intis.sdk.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class Balance
 * Class of getting balance
 */
public class Balance {

    @JsonProperty("money")
    private String amount;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("bonusAmount")
    private String bonusAmount;

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
