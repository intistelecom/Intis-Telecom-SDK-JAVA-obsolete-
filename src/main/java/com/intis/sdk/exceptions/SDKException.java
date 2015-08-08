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
package com.intis.sdk.exceptions;

import java.util.HashMap;
import java.util.Map;

public class SDKException extends Exception {

    public int code;

    public static String getMessage(int code){
        Map<Integer, String> messages = new HashMap<Integer, String>();
        messages.put(0, "Service is disabled");
        messages.put(1, "Signature is not specified");
        messages.put(2, "Login is not specified");
        messages.put(3, "Text is not specified");
        messages.put(4, "Phone number is not specified");
        messages.put(5, "Sender is not specified");
        messages.put(6, "Incorrect signature");
        messages.put(7, "Incorrect login");
        messages.put(8, "Incorrect sender name");
        messages.put(9, "Unregistered sender name");
        messages.put(10, "Sender name is not approved");
        messages.put(11, "There are forbidden words in the text");
        messages.put(12, "SMS sending error");
        messages.put(13, "Phone number is in stop-list. SMS sending to this number is blocked");
        messages.put(14, "There are more than 50 numbers in the request");
        messages.put(15, "List is not specified");
        messages.put(16, "Invalid number");
        messages.put(17, "SMS ID are not specified");
        messages.put(18, "Status is not received");
        messages.put(19, "Empty response");
        messages.put(20, "This number is already taken");
        messages.put(21, "No name");
        messages.put(22, "This template is already created");
        messages.put(23, "Month is not specified (format: YYYY-MM)");
        messages.put(24, "Time stamp is not specified");
        messages.put(25, "Error in access to list");
        messages.put(26, "There are no numbers in the list");
        messages.put(27, "There are no valid numbers");
        messages.put(28, "Initial date is not specified");
        messages.put(29, "Final date is not specified");
        messages.put(30, "Wrong or empty date (format: YYYY-MM-DD)");
        messages.put(31, "Unavailable direction");
        messages.put(32, "Low balance");
        messages.put(33, "Wrong phone number");
        messages.put(34, "Phone is in the global stop-list");
        messages.put(35, "Billing failed");

        String message = messages.get(code);

        return message;
    }

    public SDKException(){};

    public SDKException(int c) {
        super(SDKException.getMessage(c));
        code = c;
    }

    public SDKException(Throwable cause) {
        super(cause);
    }

    public SDKException(int c, Throwable throwable) {
        super(SDKException.getMessage(c), throwable);
        code = c;
    }
}
