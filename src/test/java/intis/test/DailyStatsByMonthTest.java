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

public class DailyStatsByMonthTest {

    private String login = "your api login";
    private String apiKey = "your api key here";
    private String apiHost = "http://api.host.com/get/";

    @Test
    public void makeHlrRequest() throws DailyStatsException{
        LocalApiConnector connector = new LocalApiConnector(this.getData());
        IntisClient client = new IntisClient(login, apiKey, apiHost, connector);

        List<DailyStats> bases = client.getDailyStatsByMonth(2015, 2);

        for (DailyStats item : bases) {
            System.out.println("day - " + item.getDay());
            List<Stats> stats = item.getStats();
            for(Stats entry: stats){
                System.out.println("stats - " + entry.getState());
                System.out.println("cost - " + entry.getCost());
                System.out.println("count - " + entry.getCount());
            }
        }
        assertTrue(bases.size() > 0);
    }

    @Test(expected = DailyStatsException.class)
    public void makeHlrRequestWidthException() throws DailyStatsException{
        LocalApiConnector connector = new LocalApiConnector(this.getErrorData());
        IntisClient client = new IntisClient(login, apiKey, apiHost, connector);
        List<DailyStats> bases = client.getDailyStatsByMonth(2015, 15);
    }

    private String getData()
    {
        return "[{\"date\":\"2015-02-02\",\"stats\":[{\"status\":\"deliver\",\"cost\":\"1.000\",\"parts\":\"2\"},{\"status\":\"not_deliver\",\"cost\":\"0.500\",\"parts\":\"1\"}]}," +
                "{\"date\":\"2015-02-13\",\"stats\":[{\"status\":\"deliver\",\"cost\":\"161.850\",\"parts\":\"358\"},{\"status\":\"expired\",\"cost\":\"1.650\",\"parts\":\"4\"},{\"status\":\"not_deliver\",\"cost\":\"87.700\",\"parts\":\"198\"}]}," +
                "{\"date\":\"2015-02-20\",\"stats\":[{\"status\":\"not_deliver\",\"cost\":\"211.200\",\"parts\":\"459\"},{\"status\":\"deliver\",\"cost\":\"327.950\",\"parts\":\"712\"}]}]";
    }

    private String getErrorData()
    {
        return "{\"error\":4}";
    }
}