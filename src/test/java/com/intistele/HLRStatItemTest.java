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

public class HLRStatItemTest {

    private String login = "your api login";
    private String apiKey = "your api key here";
    private String apiHost = "http://api.host.com/get/";

    @Test
    public void getHlrStats() throws HLRStatItemException{
        LocalApiConnector connector = new LocalApiConnector(this.getData());
        IntisClient client = new IntisClient(login, apiKey, apiHost, connector);

        String from = "2014-07-01";
        String to = "2014-10-01";
        List<HLRStatItem> bases = client.getHlrStats(from, to);

        for (HLRResponse item : bases) {
            System.out.println("id - " + item.getId());
            System.out.println("imsi - " + item.getImsi());
            System.out.println("original country code - " + item.getOriginalCountryCode());
        }
        assertTrue(bases.size() > 0);
    }

    @Test(expected = HLRStatItemException.class)
    public void getHlrStatsWidthException() throws HLRStatItemException{
        LocalApiConnector connector = new LocalApiConnector(this.getErrorData());
        IntisClient client = new IntisClient(login, apiKey, apiHost, connector);

        String from = "ee";
        String to = "2014-10-01";
        List<HLRStatItem> bases = client.getHlrStats(from, to);
    }

    private String getData()
    {
        return "{\"442073238000\":{\"id\":\"4133004490987800000001\",\"destination\":\"442073238000\",\"message_id\":\"x6ikubibd4y5ljdnttxt\",\"IMSI\":\"250017224827276\",\"stat\":\"DELIVRD\",\"error\":\"0\",\"orn\":\"Landline\",\"pon\":\"Landline\",\"ron\":\"Landline\",\"mccmnc\":\"25001\",\"rcn\":\"United Kingdom\",\"ppm\":\"932\",\"onp\":\"91788\",\"ocn\":\"United Kingdom\",\"ocp\":\"7\",\"is_ported\":\"false\",\"rnp\":\"917\",\"rcp\":\"7\",\"is_roaming\":\"false\",\"pnp\":\"442073238000\",\"pcn\":\"United Kingdom\",\"pcp\":\"7\",\"total_price\":\"0.2\",\"request_id\":\"607a199fb7dc99e68af1196f659c23cf\",\"request_time\":\"2014-10-14 19:27:29\"}," +
                "\"442073238001\":{\"id\":\"4115440762085900000001\",\"destination\":\"442073238001\",\"message_id\":\"l9likizqtxau2e5gbbho\",\"IMSI\":\"250017145699048\",\"stat\":\"DELIVRD\",\"error\":\"0\",\"orn\":\"Landline\",\"pon\":\"Landline\",\"ron\":\"Landline\",\"mccmnc\":\"25001\",\"rcn\":\"United Kingdom\",\"ppm\":\"932\",\"onp\":\"93718\",\"ocn\":\"United Kingdom\",\"ocp\":\"7\",\"is_ported\":\"true\",\"rnp\":\"91701\",\"rcp\":\"7\",\"is_roaming\":\"false\",\"pnp\":\"442073238001\",\"pcn\":\"United Kingdom\",\"pcp\":\"7\",\"total_price\":\"0.2\",\"request_id\":\"79cdde57cea85f1cc2728f7c0d48f0bd\",\"request_time\":\"2014-09-24 11:34:36\"}}";
    }

    private String getErrorData()
    {
        return "{\"error\":4}";
    }
}
