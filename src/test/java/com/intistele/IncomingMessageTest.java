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

import java.util.List;

import static org.junit.Assert.*;

public class IncomingMessageTest {

    private String login = "your api login";
    private String apiKey = "your api key here";
    private String apiHost = "http://api.host.com/get/";

    @Test
    public void getIncomingMessages() throws IncomingMessageException {
        LocalApiConnector connector = new LocalApiConnector(this.getData());
        IntisClient client = new IntisClient(login, apiKey, apiHost, connector);

        List<IncomingMessage> messages = client.getIncomingMessages("2015-04-02");
        for (IncomingMessage item : messages) {
            System.out.println("id - " + item.getMessageId());
            System.out.println("originator - " + item.getOriginator());
            System.out.println("text - " + item.getText());
            System.out.println("prefix - " + item.getPrefix());
            System.out.println("destination - " + item.getDestination());
            System.out.println("receivedAt - " + item.getReceivedAt());
        }
        assertNotNull(messages);
    }

    @Test
    public void getIncomingMessagesForPeriod() throws IncomingMessageException {
        LocalApiConnector connector = new LocalApiConnector(this.getData());
        IntisClient client = new IntisClient(login, apiKey, apiHost, connector);

        List<IncomingMessage> messages = client.getIncomingMessages("2015-07-02 00:00:00", "2016-08-01 23:00:00");
        for (IncomingMessage item : messages) {
            System.out.println("id - " + item.getMessageId());
            System.out.println("originator - " + item.getOriginator());
            System.out.println("text - " + item.getText());
            System.out.println("prefix - " + item.getPrefix());
            System.out.println("destination - " + item.getDestination());
            System.out.println("receivedAt - " + item.getReceivedAt());
        }
        assertNotNull(messages);
    }

    @Test(expected = IncomingMessageException.class)
    public void getIncomingMessagesWidthException() throws IncomingMessageException{
        LocalApiConnector connector = new LocalApiConnector(this.getErrorData());
        IntisClient client = new IntisClient(login, apiKey, apiHost, connector);

        List<IncomingMessage> messages = client.getIncomingMessages("2025-04-02");
    }

    private String getData()
    {
        return "{\"75396\":{\"date\":\"2015-04-01 14:01:24\",\"sender\":\"442073238000\",\"prefix\":\"\",\"text\":\"TEST\",\"phone\":\"5163251632\"},\"75397\":{\"date\":\"2015-04-01 22:31:22\",\"sender\":\"442073238001\",\"prefix\":\"\",\"text\":\"111111111\",\"phone\":\"5163251632\"},\"75398\":{\"date\":\"2015-04-01 22:37:13\",\"sender\":\"442073238002\",\"prefix\":\"\",\"text\":\"TEST INCOMING\",\"phone\":\"5163251632\"},\"75399\":{\"date\":\"2015-04-01 22:39:33\",\"sender\":\"442073238003\",\"prefix\":\"\",\"text\":\"2222223\",\"phone\":\"5163251632\"}}";
    }

    private String getErrorData()
    {
        return "{\"error\":4}";
    }
}
