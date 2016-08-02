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
