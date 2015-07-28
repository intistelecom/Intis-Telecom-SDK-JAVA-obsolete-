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
        String apiKey = "afa1748a75c0d796079d681e25d271a2c7916327";
        String apiHost = "http://dev.sms16.ru/get/";

        IntisClient client = new IntisClient(login, apiKey, apiHost);

        try {
            Balance balance = client.getBalance();
            String amount = balance.getAmount();
            String currency = balance.getCurrency();

            boolean aTrue = amount.isEmpty();
            assertFalse(aTrue);
            boolean cTrue = currency.isEmpty();
            assertFalse(cTrue);
        }
        catch (BalanceException e)
        {
            e.printStackTrace();
        }
    }
}
