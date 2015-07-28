package com.intis.sdk.entity;

import java.util.List;
import java.util.Map;

/**
 * Class DailyStats
 * Class for getting daily statistics
 */
public class DailyStats {

    protected String mDay;

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

    /**
     * @return variable for storing statistics
     */
    public List<Stats> getStats() {
        return mStats;
    }

    /**
     * @return day for statistics output
     */
    public String getDay() {
        return mDay;
    }
}
