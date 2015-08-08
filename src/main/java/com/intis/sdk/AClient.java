/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Intis Telecom
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:

 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.

 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.intis.sdk;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intis.sdk.exceptions.*;
import com.sun.deploy.util.StringUtils;

import java.io.*;
import java.net.URLEncoder;
import java.util.*;

/**
 * Class AClient
 * The main class for working with API
 */
public abstract class AClient {

    /**
     * User?s login
     */
    protected String mLogin;

    /**
     * SDK key
     */
    protected String mApiKey;

    /**
     * SDK address
     */
    protected String mApiHost;

    /**
     * IApiConnector API data connector
     */
    protected IApiConnector apiConnector;

    public AClient(IApiConnector apiConnector){
        if (apiConnector == null)
            this.apiConnector = new HttpApiConnector();
        else
            this.apiConnector = apiConnector;
    }

    /**
     * Getting content using parameters and name of API script
     *
     * @param scriptName Name of API script
     * @param parameters map of parameters
     *
     * @return data as an string
     */
    public String getContent(String scriptName, Map<String, String> parameters) throws SDKException, SDKSerializationException{
        Map<String, String> allParameters = getParameters(parameters);
        String url = mApiHost + scriptName + ".php?" + urlEncodeUTF8(allParameters);

        String result = apiConnector.getContentFromApi(url);

        checkException(result);

        return result;
    }

    /**
     * Getting time in UNIX format from the file timestamp.php in API
     *
     * @return timestamp
     */
    private String getTimestamp(){
        String url = mApiHost + "timestamp.php";

        String result = apiConnector.getTimestampFromApi(url);

        return result;
    }

    /**
     * Getting basic API parameters
     */
    private Map<String, String> getBaseParameters() {
        Map<String, String> map = new TreeMap<String, String>();
        map.put("login", mLogin);
        map.put("timestamp", getTimestamp());
        map.put("return", "json");

        return map;
    }

    /**
     * Get all API parameters
     */
    private Map<String, String> getParameters(Map<String, String> more) {
        Map<String, String> parameters = getBaseParameters();
        if (more.size() > 0) {
            for (Map.Entry<String, String> entry : more.entrySet()) {
                parameters.put(entry.getKey(), entry.getValue());
            }
        }
        String sig = getSignature(parameters);
        parameters.put("signature", sig);

        return parameters;
    }

    /**
     * Getting signatures by incoming parameters
     *
     * @param parameters values of query parameters
     * @return hash
     */
    private String getSignature(Map<String, String> parameters) {
        Collection<String> str = parameters.values();
        String strParameters = StringUtils.join(str, "") + mApiKey;

        return MD5(strParameters);
    }

    /**
     * Generating Hash from String
     *
     * @param md5 line parameters
     * @return hash
     */
    private String MD5(String md5){
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Translates a string into {@code application/x-www-form-urlencoded}
     *
     * @param s query parameter
     * @return parameter UTP-8
     */
    private static String urlEncodeUTF8(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException(e);
        }
    }

    /**
     * Translates a URL parameters into {@code application/x-www-form-urlencoded}
     *
     * @param map URL parameters
     * @return query string
     */
    private String urlEncodeUTF8(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(String.format("%s=%s",
                    urlEncodeUTF8(entry.getKey()),
                    urlEncodeUTF8(entry.getValue())
            ));
        }
        return sb.toString();
    }

    /**
     * Testing for special exceptions and error output
     */
    private void checkException(String result) throws SDKException, SDKSerializationException {
        if (result.isEmpty()) {
            throw new SDKException(0);
        }

        String test = result.substring(0, 8);
        if(test.equals("{\"error\"")){
            Map<String, Object> map;
            ObjectMapper mapper = new ObjectMapper();

            Integer code1 = null;
            try {
                map = mapper.readValue(result, new TypeReference<HashMap<String, Object>>() {});
                if(map.size() == 1 && map.containsKey("error")) {
                    Object code = map.get("error");
                    code1 = Integer.parseInt(code.toString());
                }
            } catch (Exception e) {
                throw new SDKSerializationException(e.getMessage());
            }

            if(code1 != null)
                throw new SDKException(code1);

        }
    }
}
