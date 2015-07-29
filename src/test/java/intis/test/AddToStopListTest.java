package intis.test;


import com.intis.sdk.IntisClient;
import com.intis.sdk.entity.*;
import com.intis.sdk.exceptions.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AddToStopListTest {

    private String login = "your api login";
    private String apiKey = "your api key here";
    private String apiHost = "http://api.host.com/get/";

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
