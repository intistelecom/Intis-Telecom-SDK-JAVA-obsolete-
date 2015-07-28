package intis.test;


import com.intis.sdk.IntisClient;
import com.intis.sdk.entity.*;
import com.intis.sdk.exceptions.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class HLRStatItemTest {

    @Test
    public void testMakeHlrRequest() {

        String login = "rso";
        String apiKey = "afa1748a75c0d796079d681e25d271a2c7916327";
        String apiHost = "http://dev.sms16.ru/get/";

        IntisClient client = new IntisClient(login, apiKey, apiHost);

        try {
            String from = "2014-07-01";
            String to = "2014-10-01";
            List<HLRStatItem> bases = client.getHlrStats(from, to);

            for (HLRResponse item : bases) {
                System.out.print("id - " + item.getId());
                System.out.print("imsi - " + item.getImsi());
                System.out.print("original country code - " + item.getOriginalCountryCode());
            }
            assertTrue(bases.size() > 0);
        }
        catch (HLRStatItemException e)
        {
            e.printStackTrace();
        }
    }
}
