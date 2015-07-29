package intis.test;


import com.intis.sdk.IntisClient;
import com.intis.sdk.entity.*;
import com.intis.sdk.exceptions.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class BalanceTest {

    private String login = "rso";
    private String apiKey = "afa1748a75c0d796079d681e25d271a2c7916327";
    private String apiHost = "http://dev.sms16.ru/get/";

    @Test
    public void testGetBalance() throws BalanceException{
        IntisClient client = new IntisClient(login, apiKey, apiHost);

        Balance balance = client.getBalance();
        String amount = balance.getAmount();
        String currency = balance.getCurrency();

        boolean aTrue = amount.isEmpty();
        assertFalse(aTrue);
        boolean cTrue = currency.isEmpty();
        assertFalse(cTrue);
    }

    @Test(expected = BalanceException.class)
    public void addToStopListWidthException() throws BalanceException{
        IntisClient client = new IntisClient(login, apiKey, apiHost);
        Balance balance = client.getBalance();
    }
}
