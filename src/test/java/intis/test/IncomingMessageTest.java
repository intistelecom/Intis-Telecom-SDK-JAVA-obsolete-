package intis.test;


import com.intis.sdk.IntisClient;
import com.intis.sdk.entity.*;
import com.intis.sdk.exceptions.*;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class IncomingMessageTest {

    private String login = "your api login";
    private String apiKey = "your api key here";
    private String apiHost = "http://api.host.com/get/";

    @Test
    public void getIncomingMessages() throws IncomingMessageException {
        LocalApiConnector connector = new LocalApiConnector(this.getData());
        IntisClient client = new IntisClient(login, apiKey, apiHost, connector);

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
        LocalApiConnector connector = new LocalApiConnector(this.getErrorData());
        IntisClient client = new IntisClient(login, apiKey, apiHost, connector);

        List<IncomingMessage> messages = client.getIncomingMessages("2025-04-02");
    }

    private String getData()
    {
        return "{\"75396\":{\"date\":\"2015-04-01 14:01:24\",\"sender\":\"79099004898\",\"prefix\":\"\",\"text\":\"TEST\"},\"75397\":{\"date\":\"2015-04-01 22:31:22\",\"sender\":\"79033145252\",\"prefix\":\"\",\"text\":\"111111111\"},\"75398\":{\"date\":\"2015-04-01 22:37:13\",\"sender\":\"79099004898\",\"prefix\":\"\",\"text\":\"TEST INCOMING\"},\"75399\":{\"date\":\"2015-04-01 22:39:33\",\"sender\":\"79033145252\",\"prefix\":\"\",\"text\":\"2222223\"}}";
    }

    private String getErrorData()
    {
        return "{\"error\":4}";
    }
}
