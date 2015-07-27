package com.intis.sdk.entity;

import java.util.List;
import java.util.Map;

/**
 * Class DailyStats
 * Class for getting daily statistics
 */
public class DailyStats {

    /**
     * day for statistics output
     */
    protected String mDay;

    /**
     * variable for storing statistics
     */
    protected List<Stats> mStats;

    public void DailyStats(Map<String, Map<String, Stats[]>[]> obj)
    {
//        Day = obj.Key;
//
//        var stats = new List<Stats>();
//        foreach (var one in obj.Value)
//        {
//            foreach (var item in one)
//            {
//                var st = item.Key;
//                foreach (var stObj in item.Value)
//                {
//                    stObj.StateText = st;
//                    stats.Add(stObj);
//                }
//            }
//        }
//        Stats = stats;
    }

    public List<Stats> getStats() {
        return mStats;
    }

    public void setStats(List<Stats> mStats) {
        this.mStats = mStats;
    }

    public String getDay() {
        return mDay;
    }

    public void setDay(String mDay) {
        this.mDay = mDay;
    }
}
