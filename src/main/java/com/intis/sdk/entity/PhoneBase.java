package com.intis.sdk.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class PhoneBase
 * Class for getting data of phone number list
 */
public class PhoneBase {
    protected long mBaseId;

    @JsonProperty("name")
    protected String mTitle;

    @JsonProperty("count")
    protected int mCount;

    @JsonProperty("pages")
    protected int mPages;

    @JsonProperty("on_birth")
    protected int mEnabled;

    @JsonProperty("day_before")
    protected int mDaysBefore;

    @JsonProperty("birth_sender")
    protected String mOriginator;

    @JsonProperty("time_birth")
    protected String mTimeToSend;

    @JsonProperty("local_time")
    protected int mUseLocalTime;

    @JsonProperty("birth_text")
    protected String mTemplate;

    /**
     * @param id - List ID
     */
    public void setBaseId(long id){
        mBaseId = id;
    }
    /**
     * @return List ID
     */
    public long getBaseId() {
        return mBaseId;
    }

    /**
     * @return Name of list
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * @return Number of contacts in list
     */
    public int getCount() {
        return mCount;
    }

    /**
     * @return Number of pages in list
     */
    public int getPages() {
        return mPages;
    }

    /**
     * Settings of birthday greeting for the list contacts
     *
     * @return BirthdayGreetingSettings
     */
    public BirthdayGreetingSettings getBirthdayGreetingSettings(){
            return new BirthdayGreetingSettings(mEnabled, mDaysBefore, mOriginator, mTimeToSend, mUseLocalTime, mTemplate);
    }
}
