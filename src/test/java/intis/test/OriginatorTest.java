package intis.test;


import com.intis.sdk.IntisClient;
import com.intis.sdk.entity.*;
import com.intis.sdk.exceptions.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class OriginatorTest {

    @Test
    public void testGetOriginator() {

        String login = "rso";
        String apiKey = "afa1748a75c0d796079d681e25d271a2c7916327";
        String apiHost = "http://dev.sms16.ru/get/";

        IntisClient client = new IntisClient(login, apiKey, apiHost);

        try {
            List<Originator> bases = client.getOriginators();

            for (Originator item : bases) {
                System.out.print(item.getName());
                System.out.print(item.getState());
                System.out.print(" - ");
            }
            assertTrue(bases.size() > 0);
        }
        catch (OriginatorException e)
        {
            e.printStackTrace();
        }
    }
}
