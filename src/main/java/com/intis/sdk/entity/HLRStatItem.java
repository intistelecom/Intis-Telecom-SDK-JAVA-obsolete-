package com.intis.sdk.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class HLRStatItem
 * Class of statistics by HLR requests
 */
public class HLRStatItem extends HLRResponse {

    @JsonProperty("message_id")
    protected String mMessageId;

    @JsonProperty("total_price")
    protected float mTotalPrice;

    @JsonProperty("request_id")
    protected String mRequestId;

    @JsonProperty("request_time")
    protected String mRequestTime;

    @JsonProperty("error")
    protected int mError;

    /**
     * @return Message ID
     */
    public String getMessageId() {
        return mMessageId;
    }

    /**
     * @return Final price
     */
    public float getTotalPrice() {
        return mTotalPrice;
    }

    /**
     * @return Request ID
     */
    public String getRequestId() {
        return mRequestId;
    }

    /**
     * @return Time of HLR request
     */
    public String getRequestTime() {
        return mRequestTime;
    }

    /**
     * @return Code error
     */
    public int getError(){
        return mError;
    }
}
