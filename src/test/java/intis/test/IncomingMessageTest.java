package intis.test;


import com.intis.sdk.IntisClient;
import com.intis.sdk.entity.*;
import com.intis.sdk.exceptions.*;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class IncomingMessageTest {

    @Test
    public void testGetIncomingMessages() {

        String login = "rso";
        String apiKey = "afa1748a75c0d796079d681e25d271a2c7916327";
        String apiHost = "http://dev.sms16.ru/get/";

        IntisClient client = new IntisClient(login, apiKey, apiHost);

        try {
            List<IncomingMessage> messages = client.getIncomingMessages("2015-04-02");
            for (IncomingMessage item : messages) {
                System.out.println("id - " + item.getMessageId());
                System.out.println("originator - " + item.getOriginator());
                System.out.println("text - " + item.getText());
                System.out.println("prefix - " + item.getPrefix());
                System.out.println("receivedAt - " + item.getReceivedAt());
            }
            assertNotNull(messages);
        }
        catch (IncomingMessageException e) {
            e.printStackTrace();
        }
    }
}
