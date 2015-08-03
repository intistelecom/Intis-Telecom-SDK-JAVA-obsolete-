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
        LocalApiConnector connector = new LocalApiConnector(this.getData());
        IntisClient client = new IntisClient(login, apiKey, apiHost, connector);

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
        LocalApiConnector connector = new LocalApiConnector(this.getErrorData());
        IntisClient client = new IntisClient(login, apiKey, apiHost, connector);
        List<DailyStats> bases = client.getDailyStatsByMonth(2015, 15);
    }

    private String getData()
    {
        return "[{\"date\":\"2014-10-02\",\"stats\":[{\"status\":\"deliver\",\"cost\":\"1.000\",\"parts\":\"2\"},{\"status\":\"not_deliver\",\"cost\":\"0.500\",\"parts\":\"1\"}]}," +
                "{\"date\":\"2014-10-13\",\"stats\":[{\"status\":\"deliver\",\"cost\":\"161.850\",\"parts\":\"358\"},{\"status\":\"expired\",\"cost\":\"1.650\",\"parts\":\"4\"},{\"status\":\"not_deliver\",\"cost\":\"87.700\",\"parts\":\"198\"}]}," +
                "{\"date\":\"2014-10-31\",\"stats\":[{\"status\":\"not_deliver\",\"cost\":\"211.200\",\"parts\":\"459\"},{\"status\":\"deliver\",\"cost\":\"327.950\",\"parts\":\"712\"}]}]";
    }

    private String getErrorData()
    {
        return "{\"error\":4}";
    }
}