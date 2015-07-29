package intis.test;


import com.intis.sdk.IntisClient;
import com.intis.sdk.entity.*;
import com.intis.sdk.exceptions.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class StopListTest {

    private String login = "your api login";
    private String apiKey = "your api key here";
    private String apiHost = "http://api.host.com/get/";

    @Test
    public void checkStopList() throws StopListException{
        IntisClient client = new IntisClient(login, apiKey, apiHost);

        StopList check = client.checkStopList("79000000000");
        System.out.println("description - " + check.getDescription());
        System.out.println("time - " + check.getTimeAddedAt());
        System.out.println("id - " + check.getId());

        assertNotNull(check);
    }

    @Test(expected = StopListException.class)
    public void checkStopListWidthException() throws StopListException{
        IntisClient client = new IntisClient(login, apiKey, apiHost);

        StopList check = client.checkStopList("7900000000000");
    }
}
