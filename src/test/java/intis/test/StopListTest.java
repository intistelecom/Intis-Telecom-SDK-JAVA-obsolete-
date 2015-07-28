package intis.test;


import com.intis.sdk.IntisClient;
import com.intis.sdk.entity.*;
import com.intis.sdk.exceptions.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class StopListTest {

    @Test
    public void testGetBalance() {

        String login = "rso";
        String apiKey = "afa1748a75c0d796079d681e25d271a2c7916327";
        String apiHost = "http://dev.sms16.ru/get/";

        IntisClient client = new IntisClient(login, apiKey, apiHost);

        try {
            StopList check = client.checkStopList("798563269856");
            System.out.println("description - " + check.getDescription());
            System.out.println("time - " + check.getTimeAddedAt());
            System.out.println("id - " + check.getId());

            assertNotNull(check);
        }
        catch (StopListException e) {
            e.printStackTrace();
        }
    }
}
