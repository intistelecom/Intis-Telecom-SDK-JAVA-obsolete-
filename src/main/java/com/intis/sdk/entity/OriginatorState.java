package com.intis.sdk.entity;

/**
 * Class OriginatorState
 * Class for analysis sender status
 */
public class OriginatorState {

    /**
     * Constant for approved sender
     */
    private static final int COMPLETED = 1;

    /**
     * Constant for sender in moderation queue
     */
    private static final int MODERATION = 2;

    /**
     * Constant for rejected sender
     */
    private static final int REJECTED = 3;

    /**
     * Analysis of the string of sender status
     *
     * @param str - String presentation of sender status
     * @return integer
     */
    public static Integer Parse(String str) {
        if(str.contentEquals("completed")) return COMPLETED;
        if(str.contentEquals("order")) return MODERATION;
        if(str.contentEquals("rejected")) return REJECTED;

        return null;
    }
}
