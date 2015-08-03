package intis.test;


import com.intis.sdk.IntisClient;
import com.intis.sdk.entity.*;
import com.intis.sdk.exceptions.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MessageSendingResultTest {

    private String login = "your api login";
    private String apiKey = "your api key here";
    private String apiHost = "http://api.host.com/get/";

    @Test
    public void sendMessage() throws MessageSendingResultException{
        LocalApiConnector connector = new LocalApiConnector(this.getData());
        IntisClient client = new IntisClient(login, apiKey, apiHost, connector);

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
        LocalApiConnector connector = new LocalApiConnector(this.getErrorData());
        IntisClient client = new IntisClient(login, apiKey, apiHost, connector);

        String[] phone = {};
        List<MessageSendingResult> bases = client.sendMessage(phone, "smstest", "test sms");
    }

    private String getData()
    {
        return "{\"79802002020\":{\"error\":\"0\",\"id_sms\":\"4384607771347164730001\",\"cost\":1,\"count_sms\":1,\"sender\":\"smstest\",\"network\":\" Russia MTC\",\"ported\":0},\"79009009091\":{\"error\":31}}";
    }

    private String getErrorData()
    {
        return "{\"error\":4}";
    }
}
