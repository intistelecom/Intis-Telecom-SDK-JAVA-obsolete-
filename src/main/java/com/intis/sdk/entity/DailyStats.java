package com.intis.sdk.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

/**
 * Class DailyStats
 * Class for getting daily statistics
 */
public class DailyStats {

    @JsonProperty("date")
    protected String day;

    @JsonProperty("stats")
    protected List<Stats> stats;


    /**
     * @return variable for storing statistics
     */
    public List<Stats> getStats() {
        return stats;
    }

    /**
     * @return day for statistics output
     */
    public String getDay() {
        return day;
    }
}
