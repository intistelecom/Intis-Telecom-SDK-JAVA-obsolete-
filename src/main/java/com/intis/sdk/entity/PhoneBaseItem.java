package com.intis.sdk.entity;

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
