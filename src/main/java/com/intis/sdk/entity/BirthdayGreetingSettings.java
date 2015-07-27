package com.intis.sdk.entity;

/**
 * Class BirthdayGreetingSettings
 * Getting settings of birthday greetings
 */
public class BirthdayGreetingSettings {

    /**
     * key that is responsible for sending birthday greeting
     */
    protected int mEnabled;

    /**
     * number of days to send greetings before
     */
    protected int mDaysBefore;

    /**
     * sender name of greeting SMS
     */
    protected String mOriginator;

    /**
     * time for sending greetings
     */
    protected String mTimeToSend;

    /**
     * use local time of subscriber while SMS sending
     */
    protected int mUseLocalTime;

    /**
     * text template for sending greetings
     */
    protected String mTemplate;

    public void BirthdayGreetingSettings(int enabled, int daysBefore, String originator, String timeToSend, int useLocalTime, String template)
    {
        mEnabled = enabled;
        mDaysBefore = daysBefore;
        mOriginator = originator;
        mTimeToSend = timeToSend;
        mUseLocalTime = useLocalTime;
        mTemplate = template;
    }

    public int getEnabled() {
        return mEnabled;
    }

    public void setEnabled(int mEnabled) {
        this.mEnabled = mEnabled;
    }

    public int getDaysBefore() {
        return mDaysBefore;
    }

    public void setDaysBefore(int mDaysBefore) {
        this.mDaysBefore = mDaysBefore;
    }

    public String getOriginator() {
        return mOriginator;
    }

    public void setOriginator(String mOriginator) {
        this.mOriginator = mOriginator;
    }

    public String getTimeToSend() {
        return mTimeToSend;
    }

    public void setTimeToSend(String mTimeToSend) {
        this.mTimeToSend = mTimeToSend;
    }

    public int getUseLocalTime() {
        return mUseLocalTime;
    }

    public void setUseLocalTime(int mUseLocalTime) {
        this.mUseLocalTime = mUseLocalTime;
    }

    public String getTemplate() {
        return mTemplate;
    }

    public void setTemplate(String mTemplate) {
        this.mTemplate = mTemplate;
    }
}
