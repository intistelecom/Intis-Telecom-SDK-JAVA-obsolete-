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

/**
 * Class BirthdayGreetingSettings
 * Getting settings of birthday greetings
 */
public class BirthdayGreetingSettings {

    private int enabled;

    private int daysBefore;

    private String originator;

    private String timeToSend;

    private int useLocalTime;

    private String template;

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
