package com.intis.sdk.entity;

/**
 * Class Originator
 * Class for getting sender status
 */
public class Originator {

    protected String mName;

    protected String mStateText;

    public Originator(String mName, String mStateText) {
        this.mName = mName;
        this.mStateText = mStateText;
    }

    /**
     * @return Sender name
     */
    public String getName() {
        return mName;
    }

    /**
     * @return Sender status
     */
    public Integer getState() {
        return OriginatorState.Parse(this.mStateText);
    }

}
