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

public class PhoneBasesTest {

    private String login = "your api login";
    private String apiKey = "your api key here";
    private String apiHost = "http://api.host.com/get/";

    @Test
    public void getPhoneBases() throws PhoneBasesException{
        LocalApiConnector connector = new LocalApiConnector(this.getData());
        IntisClient client = new IntisClient(login, apiKey, apiHost, connector);

        List<PhoneBase> bases = client.getPhoneBases();
        for (PhoneBase item : bases) {
            System.out.println("baseId - " + item.getBaseId());
            System.out.println("title - " + item.getTitle());
            System.out.println("count - " + item.getCount());
            System.out.println("pages - " + item.getPages());
            BirthdayGreetingSettings s = item.getBirthdayGreetingSettings();
            System.out.println("BirthdayGreetingSettings enabled - " + s.getEnabled());
            System.out.println("BirthdayGreetingSettings daysBefore - " + s.getDaysBefore());
            System.out.println("BirthdayGreetingSettings originator - " + s.getOriginator());
            System.out.println("BirthdayGreetingSettings template - " + s.getTemplate());
            System.out.println("BirthdayGreetingSettings timeToSend - " + s.getTimeToSend());
            System.out.println("BirthdayGreetingSettings useLocalTime - " + s.getUseLocalTime());
        }
        assertTrue(bases.size() > 0);
    }

    @Test(expected = PhoneBasesException.class)
    public void getPhoneBasesWidthException() throws PhoneBasesException{
        LocalApiConnector connector = new LocalApiConnector(this.getErrorData());
        IntisClient client = new IntisClient(login, apiKey, apiHost, connector);

        List<PhoneBase> bases = client.getPhoneBases();
    }

    private String getData()
    {
        return "{\"125480\":{\"name\":\"989878979\",\"time_birth\":\"12:00:00\",\"day_before\":\"0\",\"local_time\":\"1\",\"birth_sender\":\"\",\"birth_text\":\"\",\"on_birth\":\"0\",\"count\":\"0\",\"pages\":0}," +
                "\"125473\":{\"name\":\"654564\",\"time_birth\":\"12:00:00\",\"day_before\":\"0\",\"local_time\":\"1\",\"birth_sender\":\"\",\"birth_text\":\"\",\"on_birth\":\"0\",\"count\":\"367\",\"pages\":4}}";
    }

    private String getErrorData()
    {
        return "{\"error\":4}";
    }
}
