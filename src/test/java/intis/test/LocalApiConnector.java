package intis.test;

import com.intis.sdk.IApiConnector;

/**
 * Created by Sergey on 03.08.2015.
 */
public class LocalApiConnector implements IApiConnector {
    private String data;

    public LocalApiConnector(String data){
        this.data = data;
    }

    public String getContentFromApi(String link){
        return this.data;
    }

    public String getTimestampFromApi(String link){
        return "";
    }
}
