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
        LocalApiConnector connector = new LocalApiConnector(this.getData());
        IntisClient client = new IntisClient(login, apiKey, apiHost, connector);

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
        LocalApiConnector connector = new LocalApiConnector(this.getErrorData());
        IntisClient client = new IntisClient(login, apiKey, apiHost, connector);
        List<PhoneBaseItem> bases = client.getPhoneBaseItems(125508000, 1);
    }

    private String getData()
    {
        return "{\"78432956720\":{\"name\":\"\u0417\u0430\u0432\u0434\u0430\u0442\",\"last_name\":\"\u0421\u0430\u0445\u0430\u0432\u0435\u0442\u0434\u0438\u043d\u043e\u0432\",\"middle_name\":\"\u0411\u0430\u0433\u0430\u0432\u0435\u0442\u0434\u0438\u043d\u043e\u0432\u0438\u0447\",\"date_birth\":\"0000-00-00\",\"male\":\"m\",\"note1\":\"\",\"note2\":\"\",\"region\":null,\"operator\":null}," +
                "\"78432793843\":{\"name\":\"\u0413\u0435\u043d\u043d\u0430\u0434\u0438\u0439\",\"last_name\":\"\u042e\u0440\u044c\u0435\u0432\",\"middle_name\":\"\u0412\u0430\u0441\u0438\u043b\u044c\u0435\u0432\u0438\u0447\",\"date_birth\":\"0000-00-00\",\"male\":\"m\",\"note1\":\"\",\"note2\":\"\",\"region\":null,\"operator\":null}}";
    }

    private String getErrorData()
    {
        return "{\"error\":4}";
    }
}
