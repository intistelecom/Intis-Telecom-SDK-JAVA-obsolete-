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
 * Class PhoneBaseItem
 * Class of getting subscriber data in list
 */
public class PhoneBaseItem {

    private long phone;

    @JsonProperty("name")
    private String firstName;

    @JsonProperty("middle_name")
    private String middleName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("date_birth")
    private String birthDay;

    @JsonProperty("male")
    private String genderString;

    @JsonProperty("region")
    private String area;

    @JsonProperty("operator")
    private String network;

    @JsonProperty("note1")
    private String note1;

    @JsonProperty("note2")
    private String note2;

    /**
     * @param phone - Phone number of subscriber
     */
    public void setPhone(long phone){
        this.phone = phone;
    }
    /**
     * @return Phone number of subscriber
     */
    public long getPhone() {
        return phone;
    }

    /**
     * @return Subscriber first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return Subscriber middle name
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * @return Subscriber last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return Subscriber birth date
     */
    public String getBirthDay() {
        return birthDay;
    }

    /**
     * @return Gender of subscriber
     */
    public Gender getGender() {
        return Gender.Parse(genderString);
    }

    /**
     * @return Region of subscriber
     */
    public String getArea() {
        return area;
    }

    /**
     * @return Operator of subscriber
     */
    public String getNetwork() {
        return network;
    }

    /**
     * @return Note 1
     */
    public String getNote1() {
        return note1;
    }

    /**
     * @return Note 2
     */
    public String getNote2() {
        return note2;
    }
}
