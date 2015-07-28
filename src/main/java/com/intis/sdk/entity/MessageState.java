package com.intis.sdk.entity;

/**
 * Class MessageState
 * Class of analysis of message status
 */
public class MessageState {

    /**
     * Constant for scheduled message
     */
    private static final int SCHEDULED = 0;

    /**
     * Constant for message with ENROUT status
     */
    private static final int ENROUTE = 1;

    /**
     * Constant for delivered message
     */
    private static final int DELIVERED = 2;

    /**
     * Constant for expired message
     */
    private static final int EXPIRED = 3;

    /**
     * Constant for deleted message
     */
    private static final int DELETED = 4;

    /**
     * Constant for undelivered message
     */
    private static final int UNDELIVERABLE = 5;

    /**
     * Constant for sent message
     */
    private static final int ACCEPTED = 6;

    /**
     * Constant for unknown message
     */
    private static final int UNKNOWN = 7;

    /**
     * Constant for rejected message
     */
    private static final int REJECTED = 8;

    /**
     * Constant for missed message
     */
    private static final int SKIPPED = 9;

    /**
     * Analysis of the string of message status
     * @param state - String presentation of message status
     * @return Integer
     */
    public static Integer Parse(String state) {
        if(state.contentEquals("deliver")) return DELIVERED;
        if(state.contentEquals("expired")) return EXPIRED;
        if(state.contentEquals("not_deliver")) return UNDELIVERABLE;
        if(state.contentEquals("partly_deliver"))  return ACCEPTED;

        return null;
    }
}
