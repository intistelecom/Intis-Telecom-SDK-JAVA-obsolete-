package com.intis.sdk.entity;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class HLRResponse
 * Class for getting HLR request
 */
public class HLRResponse {

    @JsonProperty("id")
    protected String mId;

    @JsonProperty("destination")
    protected long mDestination;

    @JsonProperty("stat")
    protected String mStatusString;

    @JsonProperty("IMSI")
    protected String mImsi;

    @JsonProperty("mccmnc")
    protected String mMccmnc;

    @JsonProperty("ocn")
    protected String mOriginalCountryName;

    @JsonProperty("ocp")
    protected String mOriginalCountryCode;

    @JsonProperty("orn")
    protected String mOriginalNetworkName;

    @JsonProperty("onp")
    protected String mOriginalNetworkPrefix;

    @JsonProperty("rcn")
    protected String mRoamingCountryName;

    @JsonProperty("rcp")
    protected String mRoamingCountryPrefix;

    @JsonProperty("ron")
    protected String mRoamingNetworkName;

    @JsonProperty("rnp")
    protected String mRoamingNetworkPrefix;

    @JsonProperty("pcn")
    protected String mPortedCountryName;

    @JsonProperty("pcp")
    protected String mPortedCountryPrefix;

    @JsonProperty("pon")
    protected String mPortedNetworkName;

    @JsonProperty("pnp")
    protected String mPortedNetworkPrefix;

    @JsonProperty("ppm")
    protected float mPricePerMessage;

    @JsonProperty("is_ported")
    protected boolean mIsPorted;

    @JsonProperty("is_roaming")
    protected boolean mIsInRoaming;

    /**
     * Number ID
     */
    public String getId() {
        return mId;
    }

    /**
     * @return Addressee
     */
    public long getmDestination() {
        return mDestination;
    }

    /**
     * @return Status of subscriber
     */
    public int getStatus() {
        return HLRResponseState.Parse(mStatusString);
    }

    /**
     * @return IMSI of subscriber
     */
    public String getImsi() {
        return mImsi;
    }

    /**
     * @return MCC of subscriber
     */
    public String getMcc(){
        return mMccmnc.substring(0, 3);
    }

    /**
     * @return MNC of subscriber
     */
    public String getMnc(){
        return mMccmnc.substring(3);
    }

    /**
     * @return The original code of the subscriber's country
     */
    public String getOriginalCountryName() {
        return mOriginalCountryName;
    }

    /**
     * @return The original code of the subscriber's country
     */
    public String getOriginalCountryCode() {
        return mOriginalCountryCode;
    }

    /**
     * @return The original name of the subscriber's operator
     */
    public String getOriginalNetworkName() {
        return mOriginalNetworkName;
    }

    /**
     * @return The original prefix of the subscriber's operator
     */
    public String getOriginalNetworkPrefix() {
        return mOriginalNetworkPrefix;
    }

    /**
     * @return Name of country in the subscriber's roaming
     */
    public String getRoamingCountryName() {
        return mRoamingCountryName;
    }

    /**
     * @return Prefix of country in the subscriber's roaming
     */
    public String getRoamingCountryPrefix() {
        return mRoamingCountryPrefix;
    }

    /**
     * @return Operator in the subscriber's roaming
     */
    public String getRoamingNetworkName() {
        return mRoamingNetworkName;
    }

    /**
     * @return Prefix of operator in the subscriber's roaming
     */
    public String getRoamingNetworkPrefix() {
        return mRoamingNetworkPrefix;
    }

    /**
     * @return Name of country if the phone number of the subscriber is ported
     */
    public String getPortedCountryName() {
        return mPortedCountryName;
    }

    /**
     * @return Prefix of country if the phone number of the subscriber is ported
     */
    public String getPortedCountryPrefix() {
        return mPortedCountryPrefix;
    }

    /**
     * @return Name of operator if the phone number of the subscriber is ported
     */
    public String getPortedNetworkName() {
        return mPortedNetworkName;
    }

    /**
     * @return Prefix of operator if the phone number of the subscriber is ported
     */
    public String getPortedNetworkPrefix() {
        return mPortedNetworkPrefix;
    }

    /**
     * @return Price for message
     */
    public float getPricePerMessage() {
        return mPricePerMessage;
    }

    /**
     * @return Key that is responsible for identification of a ported number
     */
    public boolean isIsPorted() {
        return mIsPorted;
    }

    /**
     * @return Key that is responsible for identification a subscriber in roaming
     */
    public boolean isIsInRoaming() {
        return mIsInRoaming;
    }
}
