package com.intis.sdk.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class PhoneBase
 * Class for getting data of phone number list
 */
public class PhoneBase {
    protected long baseId;

    @JsonProperty("name")
    protected String title;

    @JsonProperty("count")
    protected int count;

    @JsonProperty("pages")
    protected int pages;

    @JsonProperty("on_birth")
    protected int enabled;

    @JsonProperty("day_before")
    protected int daysBefore;

    @JsonProperty("birth_sender")
    protected String originator;

    @JsonProperty("time_birth")
    protected String timeToSend;

    @JsonProperty("local_time")
    protected int useLocalTime;

    @JsonProperty("birth_text")
    protected String template;

    /**
     * @param id - List ID
     */
    public void setBaseId(long id){
        baseId = id;
    }
    /**
     * @return List ID
     */
    public long getBaseId() {
        return baseId;
    }

    /**
     * @return Name of list
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return Number of contacts in list
     */
    public int getCount() {
        return count;
    }

    /**
     * @return Number of pages in list
     */
    public int getPages() {
        return pages;
    }

    /**
     * Settings of birthday greeting for the list contacts
     *
     * @return BirthdayGreetingSettings
     */
    public BirthdayGreetingSettings getBirthdayGreetingSettings(){
            return new BirthdayGreetingSettings(enabled, daysBefore, originator, timeToSend, useLocalTime, template);
    }
}
