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
package com.intis.sdk.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.intis.sdk.exceptions.SDKException;

/**
 * Class MessageSendingError
 * Class for the message sending result with error
 */
public class MessageSendingError extends MessageSendingResult {

    private int code;

    public MessageSendingError(){
        setIsOk(false);
    }

    /**
     * @return Code error in SMS sending
     */
    public int getCode() {
        return code;
    }

    /**
     *
     * @param code - Code error
     */
    public void setCode(int code){
        this.code = code;
    }

    /**
    * @return Error text
    */
    public String getMessage() {
        return SDKException.getMessage(code);
    }
}
