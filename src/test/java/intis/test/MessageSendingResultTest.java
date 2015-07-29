package intis.test;


import com.intis.sdk.IntisClient;
import com.intis.sdk.entity.*;
import com.intis.sdk.exceptions.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MessageSendingResultTest {

    private String login = "rso";
    private String apiKey = "afa1748a75c0d796079d681e25d271a2c7916327";
    private String apiHost = "http://dev.sms16.ru/get/";

    @Test
    public void sendMessage() throws MessageSendingResultException{
        IntisClient client = new IntisClient(login, apiKey, apiHost);

        String[] phone = {"79804444444", "79655555555"};
        List<MessageSendingResult> bases = client.sendMessage(phone, "smstest", "test sms");

        for (MessageSendingResult item : bases) {
            System.out.println(item.getPhone());
            System.out.println(item.isOk());
            System.out.println(" - ");
        }
        assertTrue(bases.size() > 0);
    }

    @Test(expected = MessageSendingResultException.class)
    public void sendMessageWidthException() throws MessageSendingResultException{
        IntisClient client = new IntisClient(login, apiKey, apiHost);

        String[] phone = {};
        List<MessageSendingResult> bases = client.sendMessage(phone, "smstest", "test sms");
    }
}
