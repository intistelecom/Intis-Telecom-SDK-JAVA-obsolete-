package intis.test;


import com.intis.sdk.IntisClient;
import com.intis.sdk.entity.*;
import com.intis.sdk.exceptions.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class HLRResponseTest {

    private String login = "rso";
    private String apiKey = "afa1748a75c0d796079d681e25d271a2c7916327";
    private String apiHost = "http://dev.sms16.ru/get/";

    @Test
    public void makeHlrRequest() throws HLRResponseException{
        IntisClient client = new IntisClient(login, apiKey, apiHost);

        String[] phones = {"79802503672"};
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
        IntisClient client = new IntisClient(login, apiKey, apiHost);

        String[] phones = {"79802503672"};
        List<HLRResponse> bases = client.makeHlrRequest(phones);
    }
}
