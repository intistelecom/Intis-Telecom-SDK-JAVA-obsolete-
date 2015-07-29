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
        IntisClient client = new IntisClient(login, apiKey, apiHost);

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
        IntisClient client = new IntisClient(login + "--", apiKey, apiHost);
        List<Originator> bases = client.getOriginators();
    }
}
