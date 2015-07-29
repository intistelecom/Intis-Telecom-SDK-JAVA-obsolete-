package com.intis.sdk.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class StopList
 * Class for testing number for stop list
 */
public class StopList {

    private long id;

    @JsonProperty("time_in")
    private String timeAddedAt;

    @JsonProperty("description")
    private String description;

    /**
     * @param id - Stop list ID
     */
    public void setId(long id){
        this.id = id;
    }
    /**
     * @return Stop list ID
     */
    public long getId() {
        return id;
    }

    /**
     * @return Time of adding to stop list
     */
    public String getTimeAddedAt() {
        return timeAddedAt;
    }

    /**
     * @return Reason of adding to stop list
     */
    public String getDescription() {
        return description;
    }
}
