package intis.test;


import com.intis.sdk.IntisClient;
import com.intis.sdk.entity.*;
import com.intis.sdk.exceptions.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class OriginatorTest {

    private String login = "your api login";
    private String apiKey = "your api key here";
    private String apiHost = "http://api.host.com/get/";

    @Test
    public void getOriginator() throws OriginatorException{
        LocalApiConnector connector = new LocalApiConnector(this.getData());
        IntisClient client = new IntisClient(login, apiKey, apiHost, connector);

        List<Originator> bases = client.getOriginators();

        for (Originator item : bases) {
            System.out.print(item.getName());
            System.out.print(item.getState());
            System.out.print(" - ");
        }
        assertTrue(bases.size() > 0);
    }

    @Test(expected = OriginatorException.class)
    public void getOriginatorWidthException() throws OriginatorException{
        LocalApiConnector connector = new LocalApiConnector(this.getErrorData());
        IntisClient client = new IntisClient(login, apiKey, apiHost, connector);
        List<Originator> bases = client.getOriginators();
    }

    private String getData()
    {
        return "{\"smstest\":\"completed\",\"Stok&Sekond\":\"completed\",\"chmvm\":\"completed\",\"rsoTEST\":\"completed\"}";
    }

    private String getErrorData()
    {
        return "{\"error\":4}";
    }
}
