package com.intis.sdk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Alex on 29.07.15.
 */
public class HttpApiConnector  implements IApiConnector{

    public String getContentFromApi(String link) {
        String result = "";
        try {
            URL url = new URL(link);
            InputStream is = url.openConnection().getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            String line = "";
            while ((line = reader.readLine()) != null) {
                result = result + line;
            }
            reader.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
