package intis.test;


import com.intis.sdk.IntisClient;
import com.intis.sdk.entity.*;
import com.intis.sdk.exceptions.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class NetworkTest {

    @Test
    public void testGetBalance() {

        String login = "rso";
        String apiKey = "afa1748a75c0d796079d681e25d271a2c7916327";
        String apiHost = "http://dev.sms16.ru/get/";

        IntisClient client = new IntisClient(login, apiKey, apiHost);

        try {
            Network network = client.getNetworkByPhone("89808887777");
            String title = network.getTitle();
            System.out.println(title);
            boolean aTrue = title.isEmpty();
            assertFalse(aTrue);
        }
        catch (NetworkException e)
        {
            e.printStackTrace();
        }
    }
}
