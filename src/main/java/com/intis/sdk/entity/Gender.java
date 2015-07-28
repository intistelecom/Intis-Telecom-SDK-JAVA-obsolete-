package com.intis.sdk.entity;

/**
 * Class Gender
 * Getting gender of subscriber
 */
public class Gender {

    /**
     * Constant for male
     */
    private static final int MALE = 1;

    /**
     * Constant for female
     */
    private static final int FEMALE = 2;

    /**
     * Constant for undefined gender
     */
    private static final int UNDEFINED = 3;

    /**
     * Parsing a string for getting gender of subscriber
     *
     * @param str - String representation of subscriber gender
     * @return integer
     */
    public static int Parse(String str){
        if (str.toLowerCase().contentEquals("m")) {
            return MALE;
        }
        if (str.toLowerCase().contentEquals("f")) {
            return FEMALE;
        }

        return UNDEFINED;
    }
}
