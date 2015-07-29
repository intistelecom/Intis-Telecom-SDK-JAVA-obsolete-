package com.intis.sdk.entity;

/**
 * Class Gender
 * Getting gender of subscriber
 */
public enum Gender {
    MALE, FEMALE, UNDEFINED;

    /**
    * Parsing a string for getting gender of subscriber
    *
    * @param str - String representation of subscriber gender
    * @return integer
    */
    public static Gender Parse(String str){
        if (str.toLowerCase().contentEquals("m")) {
            return MALE;
        }
        if (str.toLowerCase().contentEquals("f")) {
            return FEMALE;
        }

        return UNDEFINED;
    }
}
