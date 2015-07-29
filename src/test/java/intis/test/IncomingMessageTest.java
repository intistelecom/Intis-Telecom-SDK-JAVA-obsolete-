package intis.test;


import com.intis.sdk.IntisClient;
import com.intis.sdk.entity.*;
import com.intis.sdk.exceptions.*;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class IncomingMessageTest {

    private String login = "rso";
    private String apiKey = "afa1748a75c0d796079d681e25d271a2c7916327";
    private String apiHost = "http://dev.sms16.ru/get/";

    @Test
    public void getIncomingMessages() throws IncomingMessageException {
        IntisClient client = new IntisClient(login, apiKey, apiHost);

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

    @Test(expected = IncomingMessageException.class)
    public void getIncomingMessagesWidthException() throws IncomingMessageException{
        IntisClient client = new IntisClient(login, apiKey, apiHost);

        List<IncomingMessage> messages = client.getIncomingMessages("2025-04-02");
    }
}
