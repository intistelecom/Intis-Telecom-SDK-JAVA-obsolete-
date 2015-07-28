package com.intis.sdk.entity;

/**
 * Class BirthdayGreetingSettings
 * Getting settings of birthday greetings
 */
public class BirthdayGreetingSettings {

    protected int mEnabled;

    protected int mDaysBefore;

    protected String mOriginator;

    protected String mTimeToSend;

    protected int mUseLocalTime;

    protected String mTemplate;

    public BirthdayGreetingSettings(int enabled, int daysBefore, String originator, String timeToSend, int useLocalTime, String template)
    {
        mEnabled = enabled;
        mDaysBefore = daysBefore;
        mOriginator = originator;
        mTimeToSend = timeToSend;
        mUseLocalTime = useLocalTime;
        mTemplate = template;
    }

    /**
     * @return key that is responsible for sending birthday greeting
     */
    public int getEnabled() {
        return mEnabled;
    }

    /**
     * @return number of days to send greetings before
     */
    public int getDaysBefore() {
        return mDaysBefore;
    }

    /**
     * @return sender name of greeting SMS
     */
    public String getOriginator() {
        return mOriginator;
    }

    /**
     * @return time for sending greetings
     */
    public String getTimeToSend() {
        return mTimeToSend;
    }

    /**
     * @return use local time of subscriber while SMS sending
     */
    public int getUseLocalTime() {
        return mUseLocalTime;
    }

    /**
     * @return text template for sending greetings
     */
    public String getTemplate() {
        return mTemplate;
    }
}
