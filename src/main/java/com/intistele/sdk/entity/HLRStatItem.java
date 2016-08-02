/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Intis Telecom
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:

 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.

 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.intistele.sdk.entity;

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
