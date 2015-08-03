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
        LocalApiConnector connector = new LocalApiConnector(this.getData());
        IntisClient client = new IntisClient(login, apiKey, apiHost, connector);

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
        LocalApiConnector connector = new LocalApiConnector(this.getErrorData());
        IntisClient client = new IntisClient(login, apiKey, apiHost, connector);
        List<Template> templates = client.getTemplates();
    }

    private String getData()
    {
        return "{\"25583\":{\"name\":\"newtemplate\",\"template\":\"Hello! #first-name# #last-name#! Your amount is #note1#\",\"up_time\":\"2015-03-31 15:22:50\"},\"25586\":{\"name\":\"test1\",\"template\":\"template for test1\",\"up_time\":\"2015-07-29 15:37:47\"},\"25582\":{\"name\":\"vnb cv\",\"template\":\"test\",\"up_time\":\"2015-03-30 17:34:39\"}}";
    }

    private String getErrorData()
    {
        return "{\"error\":4}";
    }
}
