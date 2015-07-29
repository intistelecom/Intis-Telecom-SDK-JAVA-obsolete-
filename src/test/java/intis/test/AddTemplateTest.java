package intis.test;


import com.intis.sdk.IntisClient;
import com.intis.sdk.entity.*;
import com.intis.sdk.exceptions.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

public class AddTemplateTest {

    private String login = "rso";
    private String apiKey = "afa1748a75c0d796079d681e25d271a2c7916327";
    private String apiHost = "http://dev.sms16.ru/get/";

    @Test
    public void addTemplate() throws AddTemplateException {
        IntisClient client = new IntisClient(login, apiKey, apiHost);

        String uniqueID = UUID.randomUUID().toString();
        Long id = client.addTemplate(uniqueID, "template for [" + uniqueID + "]");
        System.out.println(id);
        assertNotNull(id);
    }

    @Test(expected = AddTemplateException.class)
    public void addTemplateWidthException() throws AddTemplateException{
        IntisClient client = new IntisClient(login, apiKey, apiHost);
        Long id = client.addTemplate("test1", "template for test12");
    }
}
