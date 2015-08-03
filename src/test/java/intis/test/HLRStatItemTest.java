package intis.test;


import com.intis.sdk.IntisClient;
import com.intis.sdk.entity.*;
import com.intis.sdk.exceptions.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class HLRStatItemTest {

    private String login = "your api login";
    private String apiKey = "your api key here";
    private String apiHost = "http://api.host.com/get/";

    @Test
    public void getHlrStats() throws HLRStatItemException{
        LocalApiConnector connector = new LocalApiConnector(this.getData());
        IntisClient client = new IntisClient(login, apiKey, apiHost, connector);

        String from = "2014-07-01";
        String to = "2014-10-01";
        List<HLRStatItem> bases = client.getHlrStats(from, to);

        for (HLRResponse item : bases) {
            System.out.println("id - " + item.getId());
            System.out.println("imsi - " + item.getImsi());
            System.out.println("original country code - " + item.getOriginalCountryCode());
        }
        assertTrue(bases.size() > 0);
    }

    @Test(expected = HLRStatItemException.class)
    public void getHlrStatsWidthException() throws HLRStatItemException{
        LocalApiConnector connector = new LocalApiConnector(this.getErrorData());
        IntisClient client = new IntisClient(login, apiKey, apiHost, connector);

        String from = "ee";
        String to = "2014-10-01";
        List<HLRStatItem> bases = client.getHlrStats(from, to);
    }

    private String getData()
    {
        return "{\"79178880143\":{\"id\":\"4133004490987800000001\",\"destination\":\"79178880143\",\"message_id\":\"x6ikubibd4y5ljdnttxt\",\"IMSI\":\"250017224827276\",\"stat\":\"DELIVRD\",\"error\":\"0\",\"orn\":\"MTS (Mobile TeleSystems)\",\"pon\":\"MTS (Mobile TeleSystems)\",\"ron\":\"MTS (Mobile TeleSystems)\",\"mccmnc\":\"25001\",\"rcn\":\"Russian Federation\",\"ppm\":\"932\",\"onp\":\"91788\",\"ocn\":\"Russian Federation\",\"ocp\":\"7\",\"is_ported\":\"false\",\"rnp\":\"917\",\"rcp\":\"7\",\"is_roaming\":\"false\",\"pnp\":\"79872500000\",\"pcn\":\"Russian Federation\",\"pcp\":\"7\",\"total_price\":\"0.2\",\"request_id\":\"607a199fb7dc99e68af1196f659c23cf\",\"request_time\":\"2014-10-14 19:27:29\"}," +
                "\"79371844901\":{\"id\":\"4115440762085900000001\",\"destination\":\"79371844901\",\"message_id\":\"l9likizqtxau2e5gbbho\",\"IMSI\":\"250017145699048\",\"stat\":\"DELIVRD\",\"error\":\"0\",\"orn\":\"Megafon\",\"pon\":\"MTS (Mobile TeleSystems)\",\"ron\":\"MTS (Mobile TeleSystems)\",\"mccmnc\":\"25001\",\"rcn\":\"Russian Federation\",\"ppm\":\"932\",\"onp\":\"93718\",\"ocn\":\"Russian Federation\",\"ocp\":\"7\",\"is_ported\":\"true\",\"rnp\":\"91701\",\"rcp\":\"7\",\"is_roaming\":\"false\",\"pnp\":\"79872500000\",\"pcn\":\"Russian Federation\",\"pcp\":\"7\",\"total_price\":\"0.2\",\"request_id\":\"79cdde57cea85f1cc2728f7c0d48f0bd\",\"request_time\":\"2014-09-24 11:34:36\"}}";
    }

    private String getErrorData()
    {
        return "{\"error\":4}";
    }
}
