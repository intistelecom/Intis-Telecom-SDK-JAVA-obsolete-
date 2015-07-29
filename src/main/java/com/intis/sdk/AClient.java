package com.intis.sdk;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intis.sdk.exceptions.*;
import com.sun.deploy.util.StringUtils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.util.*;

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

    protected IApiConnector apiConnector;

    public AClient(IApiConnector apiConnector){
        if (apiConnector == null)
            this.apiConnector = new HttpApiConnector();
    }

    public String getContent(String scriptName, Map<String, String> parameters) throws SDKException, SDKSerializationException{
        Map<String, String> allParameters = getParameters(parameters);
        String url = mApiHost + scriptName + ".php?" + urlEncodeUTF8(allParameters);

        String result = apiConnector.getContentFromApi(url);

        checkException(result);

        return result;
    }

    /**
     * Getting time in UNIX format from the file timestamp.php in API
     */
    private String getTimestamp(){
        String url = mApiHost + "timestamp.php";

        String result = apiConnector.getContentFromApi(url);

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
     * Get phone numbers from list
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
     */
    private String getSignature(Map<String, String> parameters) {
        Collection<String> str = parameters.values();
        String strParameters = StringUtils.join(str, "") + mApiKey;

        return MD5(strParameters);
    }

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

    private static String urlEncodeUTF8(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException(e);
        }
    }

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
