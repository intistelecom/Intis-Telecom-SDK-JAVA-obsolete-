package intis.test;


import com.intis.sdk.IntisClient;
import com.intis.sdk.entity.*;
import com.intis.sdk.exceptions.*;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class TemplateTest {

    private String login = "your api login";
    private String apiKey = "your api key here";
    private String apiHost = "http://api.host.com/get/";

    @Test
    public void testGetBalance() throws TemplateException {
        IntisClient client = new IntisClient(login, apiKey, apiHost);

        List<Template> templates = client.getTemplates();
        for (Template item : templates) {
            System.out.println("id - " + item.getId());
            System.out.println("title - " + item.getTitle());
            System.out.println("template - " + item.getTemplate());
            System.out.println("created_at - " + item.getCreatedAt());
        }
        assertNotNull(templates);
    }

    @Test(expected = TemplateException.class)
    public void getHlrStatsWidthException() throws TemplateException{
        IntisClient client = new IntisClient(login + "--", apiKey, apiHost);
        List<Template> templates = client.getTemplates();
    }
}
