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

public class TemplateTest {

    private String login = "your api login";
    private String apiKey = "your api key here";
    private String apiHost = "http://api.host.com/get/";

    @Test
    public void testGetBalance() throws TemplateException {
        LocalApiConnector connector = new LocalApiConnector(this.getData());
        IntisClient client = new IntisClient(login, apiKey, apiHost, connector);

        List<Template> templates = client.getTemplates();
        for (Template item : templates) {
            System.out.println("id - " + item.getId());
            System.out.println("title - " + item.getTitle());
            System.out.println("template - " + item.getTemplate());
            System.out.println("created_at - " + item.getCreatedAt());
        }
        assertNotNull(templates);
    }

    @Test(expected = TemplateException.class)
    public void getHlrStatsWidthException() throws TemplateException{
        LocalApiConnector connector = new LocalApiConnector(this.getErrorData());
        IntisClient client = new IntisClient(login, apiKey, apiHost, connector);
        List<Template> templates = client.getTemplates();
    }

    private String getData()
    {
        return "{\"25583\":{\"name\":\"newtemplate\",\"template\":\"Hello! #first-name# #last-name#! Your amount is #note1#\",\"up_time\":\"2015-03-31 15:22:50\"},\"25586\":{\"name\":\"test1\",\"template\":\"template for test1\",\"up_time\":\"2015-07-29 15:37:47\"},\"25582\":{\"name\":\"vnb cv\",\"template\":\"test\",\"up_time\":\"2015-03-30 17:34:39\"}}";
    }

    private String getErrorData()
    {
        return "{\"error\":4}";
    }
}
