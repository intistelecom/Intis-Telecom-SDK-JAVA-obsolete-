package com.intis.sdk.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class HLRStatItem
 * Class of statistics by HLR requests
 */
public class HLRStatItem extends HLRResponse {

    @JsonProperty("message_id")
    private String messageId;

    @JsonProperty("total_price")
    private float totalPrice;

    @JsonProperty("request_id")
    private String requestId;

    @JsonProperty("request_time")
    private String requestTime;

    @JsonProperty("error")
    private int error;

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
