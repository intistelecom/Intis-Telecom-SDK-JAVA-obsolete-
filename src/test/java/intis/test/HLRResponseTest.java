package intis.test;


import com.intis.sdk.IntisClient;
import com.intis.sdk.entity.*;
import com.intis.sdk.exceptions.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class HLRResponseTest {

    @Test
    public void testMakeHlrRequest() {

        String login = "rso";
        String apiKey = "afa1748a75c0d796079d681e25d271a2c7916327";
        String apiHost = "http://dev.sms16.ru/get/";

        IntisClient client = new IntisClient(login, apiKey, apiHost);

        try {
            String[] phones = {"89178880143"};
            List<HLRResponse> bases = client.makeHlrRequest(phones);

            for (HLRResponse item : bases) {
                System.out.print("id - " + item.getId());
                System.out.print("imsi - " + item.getImsi());
                System.out.print("original country code - " + item.getOriginalCountryCode());
            }
            assertTrue(bases.size() > 0);
        }
        catch (HLRResponseException e)
        {
            e.printStackTrace();
        }
    }
}
