package com.intis.sdk.entity;

/**
 * Class Originator
 * Class for getting sender status
 */
public class Originator {

    private String name;

    private String stateText;

    public Originator(String mName, String mStateText) {
        this.name = mName;
        this.stateText = mStateText;
    }

    /**
     * @return Sender name
     */
    public String getName() {
        return name;
    }

    /**
     * @return Sender status
     */
    public OriginatorState getState() {
        return OriginatorState.Parse(this.stateText);
    }

}
