/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Intis Telecom
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:

 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.

 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.intistele.sdk.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class PhoneBase
 * Class for getting data of phone number list
 */
public class PhoneBase {
    private long baseId;

    @JsonProperty("name")
    private String title;

    @JsonProperty("count")
    private int count;

    @JsonProperty("pages")
    private int pages;

    @JsonProperty("on_birth")
    private int enabled;

    @JsonProperty("day_before")
    private int daysBefore;

    @JsonProperty("birth_sender")
    private String originator;

    @JsonProperty("time_birth")
    private String timeToSend;

    @JsonProperty("local_time")
    private int useLocalTime;

    @JsonProperty("birth_text")
    private String template;

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
