package intis.test;


import com.intis.sdk.IntisClient;
import com.intis.sdk.entity.*;
import com.intis.sdk.exceptions.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PhoneBasesTest {

    @Test
    public void testGetPhoneBase() {

        String login = "rso";
        String apiKey = "afa1748a75c0d796079d681e25d271a2c7916327";
        String apiHost = "http://dev.sms16.ru/get/";

        IntisClient client = new IntisClient(login, apiKey, apiHost);

        try {
            List<PhoneBase> bases = client.getPhoneBases();
            for (PhoneBase item : bases) {
                System.out.print(item.getBaseId());
                System.out.print(item.getTitle());
                System.out.print(item.getCount());
                System.out.print(item.getPages());
                BirthdayGreetingSettings s = item.getBirthdayGreetingSettings();
                System.out.print(s.getEnabled());
                System.out.print(s.getDaysBefore());
                System.out.print(s.getOriginator());
                System.out.print(s.getTemplate());
                System.out.print(s.getTimeToSend());
                System.out.print(s.getUseLocalTime());
            }
            assertTrue(bases.size() > 0);
        }
        catch (PhoneBasesException e)
        {
            e.printStackTrace();
        }
    }
}
