package intis.test;


import com.intis.sdk.IntisClient;
import com.intis.sdk.entity.*;
import com.intis.sdk.exceptions.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class OriginatorTest {

    private String login = "rso";
    private String apiKey = "afa1748a75c0d796079d681e25d271a2c7916327";
    private String apiHost = "http://dev.sms16.ru/get/";

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
