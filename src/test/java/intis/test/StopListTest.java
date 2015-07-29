package intis.test;


import com.intis.sdk.IntisClient;
import com.intis.sdk.entity.*;
import com.intis.sdk.exceptions.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class StopListTest {

    private String login = "rso";
    private String apiKey = "afa1748a75c0d796079d681e25d271a2c7916327";
    private String apiHost = "http://dev.sms16.ru/get/";

    @Test
    public void checkStopList() throws StopListException{
        IntisClient client = new IntisClient(login, apiKey, apiHost);

        StopList check = client.checkStopList("798563269856");
        System.out.println("description - " + check.getDescription());
        System.out.println("time - " + check.getTimeAddedAt());
        System.out.println("id - " + check.getId());

        assertNotNull(check);
    }

    @Test(expected = StopListException.class)
    public void checkStopListWidthException() throws StopListException{
        IntisClient client = new IntisClient(login, apiKey, apiHost);

        StopList check = client.checkStopList("798563269856000");
    }
}
