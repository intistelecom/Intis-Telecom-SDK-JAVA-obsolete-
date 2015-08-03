package intis.test;


import com.intis.sdk.IntisClient;
import com.intis.sdk.exceptions.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class AddToStopListTest {

    private String login = "your api login";
    private String apiKey = "your api key here";
    private String apiHost = "http://api.host.com/get/";

    @Test
    public void addToStopList() throws AddToStopListException{
        LocalApiConnector connector = new LocalApiConnector(this.getData());
        IntisClient client = new IntisClient(login, apiKey, apiHost, connector);

        Long id = client.addToStopList("89808888887");
        System.out.println(id);
        assertNotNull(id);
    }

    @Test(expected = AddToStopListException.class)
    public void addToStopListWidthException() throws AddToStopListException{
        LocalApiConnector connector = new LocalApiConnector(this.getErrorData());
        IntisClient client = new IntisClient(login, apiKey, apiHost, connector);
        Long id = client.addToStopList("89808888888");
    }

    private String getData()
    {
        return "{\"id\":4}";
    }

    private String getErrorData()
    {
        return "{\"error\":4}";
    }
}
