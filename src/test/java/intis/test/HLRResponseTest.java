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
        IntisClient client = new IntisClient(login, apiKey, apiHost);

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
        IntisClient client = new IntisClient(login, apiKey, apiHost);

        String[] phones = {"790000000000"};
        List<HLRResponse> bases = client.makeHlrRequest(phones);
    }
}
