package intis.test;


import com.intis.sdk.IntisClient;
import com.intis.sdk.entity.*;
import com.intis.sdk.exceptions.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class BalanceTest {

    @Test
    public void testGetBalance() {

        String login = "rso";
        String apiKey = "cfe4fb6f670914b7897cc2783234b7428d6dc826";
        String apiHost = "http://dev.sms16.ru/get/";

        IntisClient client = new IntisClient(login, apiKey, apiHost);

        try {
            Balance balance = client.getBalance();
            String amount = balance.getAmount();
            String currency = balance.getCurrency();

            boolean aTrue = amount.isEmpty();
            assertTrue(aTrue);
            boolean cTrue = currency.isEmpty();
            assertTrue(cTrue);
        }
        catch (BalanceException e)
        {
            e.printStackTrace();
        }
    }
}
