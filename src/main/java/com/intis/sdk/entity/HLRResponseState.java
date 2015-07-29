package com.intis.sdk.entity;

/**
 * Class HLRResponseState
 * Class for analysis of status of subscriber by HLR request
 */
public enum HLRResponseState {

    SUCCESS, FAILED;

    /**
     * Analysis of the string of status by HLR request
     *
     * @param str - String representation of status
     * @return integer
     */
    public static HLRResponseState Parse(String str) {
        return str.toLowerCase().contentEquals("delivrd") ? SUCCESS : FAILED;
    }
}
