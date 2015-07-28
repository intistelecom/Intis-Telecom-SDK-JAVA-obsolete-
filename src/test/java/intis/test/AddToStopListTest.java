package intis.test;


import com.intis.sdk.IntisClient;
import com.intis.sdk.entity.*;
import com.intis.sdk.exceptions.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AddToStopListTest {

    @Test
    public void testAddToStopList() {

        String login = "rso";
        String apiKey = "afa1748a75c0d796079d681e25d271a2c7916327";
        String apiHost = "http://dev.sms16.ru/get/";

        IntisClient client = new IntisClient(login, apiKey, apiHost);

        try {
            Long id = client.addToStopList("89808888888");
            System.out.println(id);
            assertNotNull(id);
        }
        catch (AddToStopListException e)
        {
            e.printStackTrace();
        }
    }
}
