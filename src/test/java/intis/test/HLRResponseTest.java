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

public class HLRResponseTest {

    private String login = "your api login";
    private String apiKey = "your api key here";
    private String apiHost = "http://api.host.com/get/";

    @Test
    public void makeHlrRequest() throws HLRResponseException{
        LocalApiConnector connector = new LocalApiConnector(this.getData());
        IntisClient client = new IntisClient(login, apiKey, apiHost, connector);

        String[] phones = {"79000000000"};
        List<HLRResponse> bases = client.makeHlrRequest(phones);

        for (HLRResponse item : bases) {
            System.out.print("id - " + item.getId());
            System.out.print("imsi - " + item.getImsi());
            System.out.print("original country code - " + item.getOriginalCountryCode());
        }
        assertTrue(bases.size() > 0);
    }

    @Test(expected = HLRResponseException.class)
    public void makeHlrRequestWidthException() throws HLRResponseException{
        LocalApiConnector connector = new LocalApiConnector(this.getErrorData());
        IntisClient client = new IntisClient(login, apiKey, apiHost, connector);

        String[] phones = {"790000000000"};
        List<HLRResponse> bases = client.makeHlrRequest(phones);
    }

    private String getData()
    {
        return "[{\"id\":\"4133004490987800000001\",\"destination\":\"79178880143\",\"IMSI\":\"250017224827276\",\"stat\":\"DELIVRD\",\"orn\":\"MTS (Mobile TeleSystems)\",\"pon\":\"MTS (Mobile TeleSystems)\",\"ron\":\"MTS (Mobile TeleSystems)\",\"mccmnc\":\"25001\",\"rcn\":\"Russian Federation\",\"ppm\":\"932\",\"onp\":\"91788\",\"ocn\":\"Russian Federation\",\"ocp\":\"7\",\"is_ported\":\"false\",\"rnp\":\"917\",\"rcp\":\"7\",\"is_roaming\":\"false\",\"pnp\":\"79872500000\",\"pcn\":\"Russian Federation\",\"pcp\":\"7\"}," +
                "{\"id\":\"4115440762085900000001\",\"destination\":\"79371844901\",\"IMSI\":\"250017145699048\",\"stat\":\"DELIVRD\",\"orn\":\"Megafon\",\"pon\":\"MTS (Mobile TeleSystems)\",\"ron\":\"MTS (Mobile TeleSystems)\",\"mccmnc\":\"25001\",\"rcn\":\"Russian Federation\",\"ppm\":\"932\",\"onp\":\"93718\",\"ocn\":\"Russian Federation\",\"ocp\":\"7\",\"is_ported\":\"true\",\"rnp\":\"91701\",\"rcp\":\"7\",\"is_roaming\":\"false\",\"pnp\":\"79872500000\",\"pcn\":\"Russian Federation\",\"pcp\":\"7\"}]";
    }

    private String getErrorData()
    {
        return "{\"error\":4}";
    }
}
