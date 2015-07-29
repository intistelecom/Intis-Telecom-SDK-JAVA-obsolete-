package com.intis.sdk.entity;

/**
 * Class MessageState
 * Class of analysis of message status
 */
public enum MessageState {
    SCHEDULED, ENROUTE, DELIVERED, EXPIRED, DELETED, UNDELIVERABLE, ACCEPTED, UNKNOWN, REJECTED, SKIPPED;

    /**
     * Analysis of the string of message status
     * @param state - String presentation of message status
     * @return Integer
     */
    public static MessageState Parse(String state) {
        if(state.contentEquals("deliver")) return DELIVERED;
        if(state.contentEquals("expired")) return EXPIRED;
        if(state.contentEquals("not_deliver")) return UNDELIVERABLE;
        if(state.contentEquals("partly_deliver"))  return ACCEPTED;

        return null;
    }
}
