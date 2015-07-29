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
        IntisClient client = new IntisClient(login, apiKey, apiHost);

        Network network = client.getNetworkByPhone("89808887777");
        String title = network.getTitle();
        System.out.println(title);
        boolean aTrue = title.isEmpty();
        assertFalse(aTrue);
    }

    @Test(expected = NetworkException.class)
    public void getNetworkByPhoneWidthException() throws NetworkException{
        IntisClient client = new IntisClient(login, apiKey, apiHost);

        Network network = client.getNetworkByPhone("8980888777744");
    }
}
