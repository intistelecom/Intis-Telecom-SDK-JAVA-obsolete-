package com.intis.sdk.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class HLRStatItem
 * Class of statistics by HLR requests
 */
public class HLRStatItem extends HLRResponse {

    @JsonProperty("message_id")
    protected String messageId;

    @JsonProperty("total_price")
    protected float totalPrice;

    @JsonProperty("request_id")
    protected String requestId;

    @JsonProperty("request_time")
    protected String requestTime;

    @JsonProperty("error")
    protected int error;

    /**
     * @return Message ID
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * @return Final price
     */
    public float getTotalPrice() {
        return totalPrice;
    }

    /**
     * @return Request ID
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * @return Time of HLR request
     */
    public String getRequestTime() {
        return requestTime;
    }

    /**
     * @return Code error
     */
    public int getError(){
        return error;
    }
}
