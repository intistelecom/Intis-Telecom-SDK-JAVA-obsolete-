package intis.test;


import com.intis.sdk.IntisClient;
import com.intis.sdk.entity.*;
import com.intis.sdk.exceptions.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DailyStatsByMonthTest {

    @Test
    public void testMakeHlrRequest() {

        String login = "rso";
        String apiKey = "afa1748a75c0d796079d681e25d271a2c7916327";
        String apiHost = "http://dev.sms16.ru/get/";

        IntisClient client = new IntisClient(login, apiKey, apiHost);

        try {
            List<DailyStats> bases = client.getDailyStatsByMonth(2015, 2);

            for (DailyStats item : bases) {
                System.out.println("day - " + item.getDay());
                List<Stats> stats = item.getStats();
                for(Stats entry: stats){
                    System.out.println("stats - " + entry.getState());
                    System.out.println("cost - " + entry.getCost());
                    System.out.println("count - " + entry.getCount());
                }
            }
            assertTrue(bases.size() > 0);
        }
        catch (DailyStatsException e)
        {
            e.printStackTrace();
        }
    }
}