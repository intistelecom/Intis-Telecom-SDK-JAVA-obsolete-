package intis.test;


import com.intis.sdk.IntisClient;
import com.intis.sdk.entity.*;
import com.intis.sdk.exceptions.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class NetworkTest {

    private String login = "your api login";
    private String apiKey = "your api key here";
    private String apiHost = "http://api.host.com/get/";

    @Test
    public void getNetworkByPhone() throws NetworkException{
        LocalApiConnector connector = new LocalApiConnector(this.getData());
        IntisClient client = new IntisClient(login, apiKey, apiHost, connector);

        Network network = client.getNetworkByPhone("89808887777");
        String title = network.getTitle();
        System.out.println(title);
        boolean aTrue = title.isEmpty();
        assertFalse(aTrue);
    }

    @Test(expected = NetworkException.class)
    public void getNetworkByPhoneWidthException() throws NetworkException{
        LocalApiConnector connector = new LocalApiConnector(this.getErrorData());
        IntisClient client = new IntisClient(login, apiKey, apiHost, connector);

        Network network = client.getNetworkByPhone("8980888777744");
    }

    private String getData()
    {
        return "{\"operator\" : \"AT&T\"}";
    }

    private String getErrorData()
    {
        return "{\"error\":4}";
    }
}
