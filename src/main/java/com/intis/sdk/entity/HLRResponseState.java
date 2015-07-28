package com.intis.sdk.entity;

/**
 * Class HLRResponseState
 * Class for analysis of status of subscriber by HLR request
 */
public class HLRResponseState {

    /**
     * Constant of the successful status
     */
    private static final int SUCCESS = 1;

    /**
     * Constant of the status error
     */
    private static final int FAILED = 2;

    /**
     * Analysis of the string of status by HLR request
     *
     * @param str - String representation of status
     * @return integer
     */
    public static int Parse(String str) {
        return str.toLowerCase().contentEquals("delivrd") ? SUCCESS : FAILED;
    }
}
