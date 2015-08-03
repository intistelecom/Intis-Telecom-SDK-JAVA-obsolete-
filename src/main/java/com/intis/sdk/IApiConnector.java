package com.intis.sdk;

/**
 * Created by Alex on 29.07.15.
 */
public interface IApiConnector {
    /**
     * Getting data from API.
     */
    String getContentFromApi(String link);

    /**
     * Getting timestamp from API.
     */
    String getTimestampFromApi(String link);
}
