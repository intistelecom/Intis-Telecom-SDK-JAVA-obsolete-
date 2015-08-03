package intis.test;


import com.intis.sdk.IntisClient;
import com.intis.sdk.exceptions.*;
import org.junit.Test;
import java.util.UUID;

import static org.junit.Assert.*;

public class AddTemplateTest {

    private String login = "your api login";
    private String apiKey = "your api key here";
    private String apiHost = "http://api.host.com/get/";

    @Test
    public void addTemplate() throws AddTemplateException {

        LocalApiConnector connector = new LocalApiConnector(this.getData());
        IntisClient client = new IntisClient(login, apiKey, apiHost, connector);

        String uniqueID = UUID.randomUUID().toString();
        Long id = client.addTemplate(uniqueID, "template for [" + uniqueID + "]");
        System.out.println(id);
        assertNotNull(id);
    }

    @Test(expected = AddTemplateException.class)
    public void addTemplateWidthException() throws AddTemplateException{
        LocalApiConnector connector = new LocalApiConnector(this.getErrorData());
        IntisClient client = new IntisClient(login, apiKey, apiHost, connector);
        Long id = client.addTemplate("test1", "template for test1");
    }

    private String getData(){
        return "{\"id\":1}";
    }

    private String getErrorData(){
        return "{\"error\":4}";
    }
}
