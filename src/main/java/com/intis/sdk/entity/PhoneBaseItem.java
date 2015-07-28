package com.intis.sdk.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class PhoneBaseItem
 * Class of getting subscriber data in list
 */
public class PhoneBaseItem {

    protected long mPhone;

    @JsonProperty("name")
    protected String mFirstName;

    @JsonProperty("middle_name")
    protected String mMiddleName;

    @JsonProperty("last_name")
    protected String mLastName;

    @JsonProperty("date_birth")
    protected String mBirthDay;

    @JsonProperty("male")
    protected String mGenderString;

    @JsonProperty("region")
    protected String mArea;

    @JsonProperty("operator")
    protected String mNetwork;

    @JsonProperty("note1")
    protected String mNote1;

    @JsonProperty("note2")
    protected String mNote2;

    /**
     * @param phone - Phone number of subscriber
     */
    public void setPhone(long phone){
        mPhone = phone;
    }
    /**
     * @return Phone number of subscriber
     */
    public long getPhone() {
        return mPhone;
    }

    /**
     * @return Subscriber first name
     */
    public String getFirstName() {
        return mFirstName;
    }

    /**
     * @return Subscriber middle name
     */
    public String getMiddleName() {
        return mMiddleName;
    }

    /**
     * @return Subscriber last name
     */
    public String getLastName() {
        return mLastName;
    }

    /**
     * @return Subscriber birth date
     */
    public String getBirthDay() {
        return mBirthDay;
    }

    /**
     * @return Gender of subscriber
     */
    public int getGender() {
        return Gender.Parse(mGenderString);
    }

    /**
     * @return Region of subscriber
     */
    public String getArea() {
        return mArea;
    }

    /**
     * @return Operator of subscriber
     */
    public String getNetwork() {
        return mNetwork;
    }

    /**
     * @return Note 1
     */
    public String getNote1() {
        return mNote1;
    }

    /**
     * @return Note 2
     */
    public String getNote2() {
        return mNote2;
    }
}
