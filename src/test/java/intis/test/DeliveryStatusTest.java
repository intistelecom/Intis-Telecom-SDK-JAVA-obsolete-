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
        IntisClient client = new IntisClient(login, apiKey, apiHost);

        String[] messages = {"4381960011347047370003"};
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
        IntisClient client = new IntisClient(login, apiKey, apiHost);

        String[] messages = {"433427317010761582001133"};
        List<DeliveryStatus> bases = client.getDeliveryStatus(messages);
    }
}
