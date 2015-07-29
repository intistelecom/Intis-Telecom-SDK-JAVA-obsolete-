package intis.test;


import com.intis.sdk.IntisClient;
import com.intis.sdk.entity.*;
import com.intis.sdk.exceptions.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PhoneBaseItemsTest {

    private String login = "your api login";
    private String apiKey = "your api key here";
    private String apiHost = "http://api.host.com/get/";

    @Test
    public void getPhoneBaseItems() throws PhoneBaseItemException{
        IntisClient client = new IntisClient(login, apiKey, apiHost);

        List<PhoneBaseItem> bases = client.getPhoneBaseItems(125508, 1);

        for (PhoneBaseItem item : bases) {
            System.out.println("phone - " + item.getPhone());
            System.out.println("first name - " + item.getFirstName());
            System.out.println("middle name - " + item.getMiddleName());
            System.out.println("last name - " + item.getLastName());
            System.out.println("birth day - " + item.getBirthDay());
            System.out.println("gender - " + item.getGender());
            System.out.println("area - " + item.getArea());
            System.out.println("network - " + item.getNetwork());
            System.out.println("note1 - " + item.getNote1());
            System.out.println("note2 - " + item.getNote2());
        }
        assertTrue(bases.size() > 0);
    }

    @Test(expected = PhoneBaseItemException.class)
    public void getPhoneBaseItemsWidthException() throws PhoneBaseItemException{
        IntisClient client = new IntisClient(login, apiKey, apiHost);
        List<PhoneBaseItem> bases = client.getPhoneBaseItems(125508000, 1);
    }
}
