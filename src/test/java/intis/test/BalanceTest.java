package intis.test;


import com.intis.sdk.IntisClient;
import com.intis.sdk.entity.*;
import com.intis.sdk.exceptions.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class BalanceTest {

    private String login = "your api login";
    private String apiKey = "your api key here";
    private String apiHost = "http://api.host.com/get/";

    @Test
    public void getBalance() throws BalanceException{
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
    public void getBalanceWidthException() throws BalanceException{
        IntisClient client = new IntisClient(login, apiKey, apiHost);
        Balance balance = client.getBalance();
    }
}
