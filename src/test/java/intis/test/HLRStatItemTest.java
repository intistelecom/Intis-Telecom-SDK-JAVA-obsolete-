package intis.test;


import com.intis.sdk.IntisClient;
import com.intis.sdk.entity.*;
import com.intis.sdk.exceptions.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class HLRStatItemTest {

    private String login = "your api login";
    private String apiKey = "your api key here";
    private String apiHost = "http://api.host.com/get/";

    @Test
    public void getHlrStats() throws HLRStatItemException{
        IntisClient client = new IntisClient(login, apiKey, apiHost);

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
        IntisClient client = new IntisClient(login, apiKey, apiHost);

        String from = "ee";
        String to = "2014-10-01";
        List<HLRStatItem> bases = client.getHlrStats(from, to);
    }
}
