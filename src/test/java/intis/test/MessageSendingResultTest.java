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
package intis.test;

import com.intis.sdk.IntisClient;
import com.intis.sdk.entity.*;
import com.intis.sdk.exceptions.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MessageSendingResultTest {

    private String login = "your api login";
    private String apiKey = "your api key here";
    private String apiHost = "http://api.host.com/get/";

    @Test
    public void sendMessage() throws MessageSendingResultException{
        LocalApiConnector connector = new LocalApiConnector(this.getData());
        IntisClient client = new IntisClient(login, apiKey, apiHost, connector);

        String[] phone = {"442073238000", "442073238001"};
        List<MessageSendingResult> bases = client.sendMessage(phone, "smstest", "test sms");

        for (MessageSendingResult item : bases) {
            System.out.println(item.getPhone());
            System.out.println(item.isOk());
            System.out.println(" - ");
        }
        assertTrue(bases.size() > 0);
    }

    @Test
    public void sheduleSendMessage() throws MessageSendingResultException{
        LocalApiConnector connector = new LocalApiConnector(this.getData());
        IntisClient client = new IntisClient(login, apiKey, apiHost, connector);

        String[] phone = {"442073238000", "442073238001"};
        List<MessageSendingResult> bases = client.sendMessage(phone, "smstest", "test sms", "2016-08-07 15:30");

        for (MessageSendingResult item : bases) {
            System.out.println(item.getPhone());
            System.out.println(item.isOk());
            System.out.println(" - ");
        }
        assertTrue(bases.size() > 0);
    }

    @Test(expected = MessageSendingResultException.class)
    public void sendMessageWidthException() throws MessageSendingResultException{
        LocalApiConnector connector = new LocalApiConnector(this.getErrorData());
        IntisClient client = new IntisClient(login, apiKey, apiHost, connector);

        String[] phone = {};
        List<MessageSendingResult> bases = client.sendMessage(phone, "smstest", "test sms");
    }

    private String getData()
    {
        return "{\"442073238000\":{\"error\":\"0\",\"id_sms\":\"4384607771347164730001\",\"cost\":1,\"count_sms\":1,\"sender\":\"smstest\",\"network\":\"Landline\",\"ported\":0},\"442073238000\":{\"error\":31}}";
    }

    private String getErrorData()
    {
        return "{\"error\":4}";
    }
}
