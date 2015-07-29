package com.intis.sdk.entity;

/**
 * Class OriginatorState
 * Class for analysis sender status
 */
public enum OriginatorState {

    COMPLETED, MODERATION, REJECTED;

    /**
     * Analysis of the string of sender status
     *
     * @param str - String presentation of sender status
     * @return integer
     */
    public static OriginatorState Parse(String str) {
        if(str.contentEquals("completed")) return COMPLETED;
        if(str.contentEquals("order")) return MODERATION;
        if(str.contentEquals("rejected")) return REJECTED;

        return null;
    }
}
