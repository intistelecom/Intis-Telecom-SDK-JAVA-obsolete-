package intis.test;


import com.intis.sdk.IntisClient;
import com.intis.sdk.entity.*;
import com.intis.sdk.exceptions.*;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class TemplateTest {

    @Test
    public void testGetBalance() {

        String login = "rso";
        String apiKey = "afa1748a75c0d796079d681e25d271a2c7916327";
        String apiHost = "http://dev.sms16.ru/get/";

        IntisClient client = new IntisClient(login, apiKey, apiHost);

        try {
            List<Template> templates = client.getTemplates();
            for (Template item : templates) {
                System.out.println("id - " + item.getId());
                System.out.println("title - " + item.getTitle());
                System.out.println("template - " + item.getTemplate());
                System.out.println("created_at - " + item.getCreatedAt());
            }
            assertNotNull(templates);
        }
        catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
