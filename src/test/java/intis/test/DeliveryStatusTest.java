package intis.test;


import com.intis.sdk.IntisClient;
import com.intis.sdk.entity.*;
import com.intis.sdk.exceptions.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DeliveryStatusTest {

    @Test
    public void testGetDeliveryStatus() {

        String login = "rso";
        String apiKey = "afa1748a75c0d796079d681e25d271a2c7916327";
        String apiHost = "http://dev.sms16.ru/get/";

        IntisClient client = new IntisClient(login, apiKey, apiHost);

        try {
            String[] messages = {"4334273170107615820011"};
            List<DeliveryStatus> bases = client.getDeliveryStatus(messages);

            for (DeliveryStatus item : bases) {
                System.out.print("messageId - " + item.getMessageId());
                System.out.print("status - " + item.getMessageStatus());
                System.out.print("created - " + item.getCreatedAt());
            }
            assertTrue(bases.size() > 0);
        }
        catch (DeliveryStatusException e)
        {
            e.printStackTrace();
        }
    }
}
