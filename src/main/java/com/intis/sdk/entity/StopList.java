package com.intis.sdk.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class StopList
 * Class for testing number for stop list
 */
public class StopList {

    protected long mId;

    @JsonProperty("time_in")
    protected String mTimeAddedAt;

    @JsonProperty("description")
    protected String mDescription;

    /**
     * @param id - Stop list ID
     */
    public void setId(long id){
        mId = id;
    }
    /**
     * @return Stop list ID
     */
    public long getId() {
        return mId;
    }

    /**
     * @return Time of adding to stop list
     */
    public String getTimeAddedAt() {
        return mTimeAddedAt;
    }

    /**
     * @return Reason of adding to stop list
     */
    public String getDescription() {
        return mDescription;
    }
}
