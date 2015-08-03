package intis.test;


import com.intis.sdk.IntisClient;
import com.intis.sdk.entity.*;
import com.intis.sdk.exceptions.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DeliveryStatusTest {

    private String login = "your api login";
    private String apiKey = "your api key here";
    private String apiHost = "http://api.host.com/get/";

    @Test
    public void getDeliveryStatus() throws DeliveryStatusException{
        LocalApiConnector connector = new LocalApiConnector(this.getData());
        IntisClient client = new IntisClient(login, apiKey, apiHost, connector);

        String[] messages = {"4385937961543210880001"};
        List<DeliveryStatus> bases = client.getDeliveryStatus(messages);

        for (DeliveryStatus item : bases) {
            System.out.print("messageId - " + item.getMessageId());
            System.out.print("status - " + item.getMessageStatus());
            System.out.print("created - " + item.getCreatedAt());
        }
        assertTrue(bases.size() > 0);
    }

    @Test(expected = DeliveryStatusException.class)
    public void getDeliveryStatusWidthException() throws DeliveryStatusException{
        LocalApiConnector connector = new LocalApiConnector(this.getErrorData());
        IntisClient client = new IntisClient(login, apiKey, apiHost, connector);

        String[] messages = {"433427317010761582001133"};
        client.getDeliveryStatus(messages);
    }

    private String getData()
    {
        return "{\"4385937961543210880001\":{\"status\":\"deliver\", \"time\":\"2014-10-05\"},\"4385937961543210880002\":{\"status\":\"not_deliver\", \"time\":\"2014-10-01\"}}";
    }

    private String getErrorData()
    {
        return "{\"error\":4}";
    }
}
