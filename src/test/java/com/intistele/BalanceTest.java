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
package com.intistele;

import com.intistele.sdk.IntisClient;
import com.intistele.sdk.entity.*;
import com.intistele.sdk.exceptions.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class BalanceTest {

    private String login = "your api login";
    private String apiKey = "your api key here";
    private String apiHost = "http://api.host.com/get/";

    @Test
    public void getBalance() throws BalanceException{
        LocalApiConnector connector = new LocalApiConnector(this.getData());
        IntisClient client = new IntisClient(login, apiKey, apiHost, connector);

        Balance balance = client.getBalance();
        String amount = balance.getAmount();
        String currency = balance.getCurrency();

        boolean aTrue = amount.isEmpty();
        assertFalse(aTrue);
        boolean cTrue = currency.isEmpty();
        assertFalse(cTrue);
    }

    @Test(expected = BalanceException.class)
    public void getBalanceWidthException() throws BalanceException{
        LocalApiConnector connector = new LocalApiConnector(this.getErrorData());
        IntisClient client = new IntisClient(login, apiKey, apiHost, connector);
        Balance balance = client.getBalance();
    }

    private String getData()
    {
        return "{\"money\":4, \"currency\":\"RUB\"}";
    }

    private String getErrorData()
    {
        return "{\"error\":4}";
    }
}
