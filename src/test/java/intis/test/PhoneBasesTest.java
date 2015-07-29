package intis.test;


import com.intis.sdk.IntisClient;
import com.intis.sdk.entity.*;
import com.intis.sdk.exceptions.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PhoneBasesTest {

    private String login = "your api login";
    private String apiKey = "your api key here";
    private String apiHost = "http://api.host.com/get/";

    @Test
    public void getPhoneBases() throws PhoneBasesException{
        IntisClient client = new IntisClient(login, apiKey, apiHost);

        List<PhoneBase> bases = client.getPhoneBases();
        for (PhoneBase item : bases) {
            System.out.println("baseId - " + item.getBaseId());
            System.out.println("title - " + item.getTitle());
            System.out.println("count - " + item.getCount());
            System.out.println("pages - " + item.getPages());
            BirthdayGreetingSettings s = item.getBirthdayGreetingSettings();
            System.out.println("BirthdayGreetingSettings enabled - " + s.getEnabled());
            System.out.println("BirthdayGreetingSettings daysBefore - " + s.getDaysBefore());
            System.out.println("BirthdayGreetingSettings originator - " + s.getOriginator());
            System.out.println("BirthdayGreetingSettings template - " + s.getTemplate());
            System.out.println("BirthdayGreetingSettings timeToSend - " + s.getTimeToSend());
            System.out.println("BirthdayGreetingSettings useLocalTime - " + s.getUseLocalTime());
        }
        assertTrue(bases.size() > 0);
    }

    @Test(expected = PhoneBasesException.class)
    public void getPhoneBasesWidthException() throws PhoneBasesException{
        IntisClient client = new IntisClient(login + "--", apiKey, apiHost);

        List<PhoneBase> bases = client.getPhoneBases();
    }
}
