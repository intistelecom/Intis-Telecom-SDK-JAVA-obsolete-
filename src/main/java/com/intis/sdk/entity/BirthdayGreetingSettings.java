package com.intis.sdk.entity;

/**
 * Class BirthdayGreetingSettings
 * Getting settings of birthday greetings
 */
public class BirthdayGreetingSettings {

    protected int enabled;

    protected int daysBefore;

    protected String originator;

    protected String timeToSend;

    protected int useLocalTime;

    protected String template;

    public BirthdayGreetingSettings(int enabled, int daysBefore, String originator, String timeToSend, int useLocalTime, String template)
    {
        this.enabled = enabled;
        this.daysBefore = daysBefore;
        this.originator = originator;
        this.timeToSend = timeToSend;
        this.useLocalTime = useLocalTime;
        this.template = template;
    }

    /**
     * @return key that is responsible for sending birthday greeting
     */
    public int getEnabled() {
        return enabled;
    }

    /**
     * @return number of days to send greetings before
     */
    public int getDaysBefore() {
        return daysBefore;
    }

    /**
     * @return sender name of greeting SMS
     */
    public String getOriginator() {
        return originator;
    }

    /**
     * @return time for sending greetings
     */
    public String getTimeToSend() {
        return timeToSend;
    }

    /**
     * @return use local time of subscriber while SMS sending
     */
    public int getUseLocalTime() {
        return useLocalTime;
    }

    /**
     * @return text template for sending greetings
     */
    public String getTemplate() {
        return template;
    }
}
