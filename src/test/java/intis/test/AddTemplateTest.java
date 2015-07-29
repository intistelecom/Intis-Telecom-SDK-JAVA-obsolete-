package intis.test;


import com.intis.sdk.IntisClient;
import com.intis.sdk.entity.*;
import com.intis.sdk.exceptions.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static org.junit.Assert.*;

public class AddTemplateTest {

    @Test
    public void addTemplate() throws AddTemplateException {
        String login = "rso";
        String apiKey = "afa1748a75c0d796079d681e25d271a2c7916327";
        String apiHost = "http://dev.sms16.ru/get/";

        IntisClient client = new IntisClient(login, apiKey, apiHost);

        Long id = client.addTemplate("test16", "template for test11");
        System.out.println(id);
        assertNotNull(id);
    }

    @Test(expected = SDKSerializationException.class)
    public void addTemplateWidthException() throws AddTemplateException{
        String login = "rso";
        String apiKey = "afa1748a75c0d796079d681e25d271a2c7916327";
        String apiHost = "http://dev.sms16.ru/get/";

        IntisClient client = new IntisClient(login, apiKey, apiHost);
        Long id = client.addTemplate("test1", "template for test12");
    }
}
