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

public class PhoneBaseItemsTest {

    private String login = "your api login";
    private String apiKey = "your api key here";
    private String apiHost = "http://api.host.com/get/";

    @Test
    public void getPhoneBaseItems() throws PhoneBaseItemException{
        LocalApiConnector connector = new LocalApiConnector(this.getData());
        IntisClient client = new IntisClient(login, apiKey, apiHost, connector);

        List<PhoneBaseItem> bases = client.getPhoneBaseItems(125508, 1);

        for (PhoneBaseItem item : bases) {
            System.out.println("phone - " + item.getPhone());
            System.out.println("first name - " + item.getFirstName());
            System.out.println("middle name - " + item.getMiddleName());
            System.out.println("last name - " + item.getLastName());
            System.out.println("birth day - " + item.getBirthDay());
            System.out.println("gender - " + item.getGender());
            System.out.println("area - " + item.getArea());
            System.out.println("network - " + item.getNetwork());
            System.out.println("note1 - " + item.getNote1());
            System.out.println("note2 - " + item.getNote2());
        }
        assertTrue(bases.size() > 0);
    }

    @Test(expected = PhoneBaseItemException.class)
    public void getPhoneBaseItemsWidthException() throws PhoneBaseItemException{
        LocalApiConnector connector = new LocalApiConnector(this.getErrorData());
        IntisClient client = new IntisClient(login, apiKey, apiHost, connector);
        List<PhoneBaseItem> bases = client.getPhoneBaseItems(125508000, 1);
    }

    private String getData()
    {
        return "{\"442073238000\":{\"name\":\"Jon\",\"last_name\":\"Voight\",\"middle_name\":\"\",\"date_birth\":\"0000-00-00\",\"male\":\"m\",\"note1\":\"\",\"note2\":\"\",\"region\":null,\"operator\":null}," +
                "\"442073238001\":{\"name\":\"Jon\",\"last_name\":\"Voight\",\"middle_name\":\"\",\"date_birth\":\"0000-00-00\",\"male\":\"m\",\"note1\":\"\",\"note2\":\"\",\"region\":null,\"operator\":null}}";
    }

    private String getErrorData()
    {
        return "{\"error\":4}";
    }
}
