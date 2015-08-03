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
        LocalApiConnector connector = new LocalApiConnector(this.getData());
        IntisClient client = new IntisClient(login, apiKey, apiHost, connector);

        StopList check = client.checkStopList("79000000000");
        System.out.println("description - " + check.getDescription());
        System.out.println("time - " + check.getTimeAddedAt());
        System.out.println("id - " + check.getId());

        assertNotNull(check);
    }

    @Test(expected = StopListException.class)
    public void checkStopListWidthException() throws StopListException{
        LocalApiConnector connector = new LocalApiConnector(this.getErrorData());
        IntisClient client = new IntisClient(login, apiKey, apiHost, connector);

        StopList check = client.checkStopList("7900000000000");
    }

    private String getData()
    {
        return "{\"4494794\":{\"time_in\":\"2015-07-31 22:55:00\",\"description\":\"test\"}}";
    }

    private String getErrorData()
    {
        return "{\"error\":4}";
    }
}
