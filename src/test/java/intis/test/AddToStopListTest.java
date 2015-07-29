package intis.test;


import com.intis.sdk.IntisClient;
import com.intis.sdk.entity.*;
import com.intis.sdk.exceptions.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AddToStopListTest {

    private String login = "rso";
    private String apiKey = "afa1748a75c0d796079d681e25d271a2c7916327";
    private String apiHost = "http://dev.sms16.ru/get/";

    @Test
    public void addToStopList() throws AddToStopListException{
        IntisClient client = new IntisClient(login, apiKey, apiHost);

        Long id = client.addToStopList("89808888887");
        System.out.println(id);
        assertNotNull(id);
    }

    @Test(expected = AddToStopListException.class)
    public void addToStopListWidthException() throws AddToStopListException{
        IntisClient client = new IntisClient(login, apiKey, apiHost);
        Long id = client.addToStopList("89808888888");
    }
}
