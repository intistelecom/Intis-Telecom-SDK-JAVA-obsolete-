package intis.test;


import com.intis.sdk.IntisClient;
import com.intis.sdk.entity.*;
import com.intis.sdk.exceptions.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DailyStatsByMonthTest {

    private String login = "your api login";
    private String apiKey = "your api key here";
    private String apiHost = "http://api.host.com/get/";

    @Test
    public void makeHlrRequest() throws DailyStatsException{
        IntisClient client = new IntisClient(login, apiKey, apiHost);

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

    @Test(expected = DailyStatsException.class)
    public void makeHlrRequestWidthException() throws DailyStatsException{
        IntisClient client = new IntisClient(login, apiKey, apiHost);
        List<DailyStats> bases = client.getDailyStatsByMonth(2015, 15);
    }
}