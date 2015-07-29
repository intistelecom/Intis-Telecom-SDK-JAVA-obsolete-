package com.intis.sdk.entity;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class HLRResponse
 * Class for getting HLR request
 */
public class HLRResponse {

    @JsonProperty("id")
    protected String id;

    @JsonProperty("destination")
    protected long destination;

    @JsonProperty("stat")
    protected String statusString;

    @JsonProperty("IMSI")
    protected String imsi;

    @JsonProperty("mccmnc")
    protected String mccmnc;

    @JsonProperty("ocn")
    protected String originalCountryName;

    @JsonProperty("ocp")
    protected String originalCountryCode;

    @JsonProperty("orn")
    protected String originalNetworkName;

    @JsonProperty("onp")
    protected String originalNetworkPrefix;

    @JsonProperty("rcn")
    protected String roamingCountryName;

    @JsonProperty("rcp")
    protected String roamingCountryPrefix;

    @JsonProperty("ron")
    protected String roamingNetworkName;

    @JsonProperty("rnp")
    protected String roamingNetworkPrefix;

    @JsonProperty("pcn")
    protected String portedCountryName;

    @JsonProperty("pcp")
    protected String portedCountryPrefix;

    @JsonProperty("pon")
    protected String portedNetworkName;

    @JsonProperty("pnp")
    protected String portedNetworkPrefix;

    @JsonProperty("ppm")
    protected float pricePerMessage;

    @JsonProperty("is_ported")
    protected boolean isPorted;

    @JsonProperty("is_roaming")
    protected boolean isInRoaming;

    /**
     * Number ID
     */
    public String getId() {
        return id;
    }

    /**
     * @return Addressee
     */
    public long getmDestination() {
        return destination;
    }

    /**
     * @return Status of subscriber
     */
    public HLRResponseState getStatus() {
        return HLRResponseState.Parse(statusString);
    }

    /**
     * @return IMSI of subscriber
     */
    public String getImsi() {
        return imsi;
    }

    /**
     * @return MCC of subscriber
     */
    public String getMcc(){
        return mccmnc.substring(0, 3);
    }

    /**
     * @return MNC of subscriber
     */
    public String getMnc(){
        return mccmnc.substring(3);
    }

    /**
     * @return The original code of the subscriber's country
     */
    public String getOriginalCountryName() {
        return originalCountryName;
    }

    /**
     * @return The original code of the subscriber's country
     */
    public String getOriginalCountryCode() {
        return originalCountryCode;
    }

    /**
     * @return The original name of the subscriber's operator
     */
    public String getOriginalNetworkName() {
        return originalNetworkName;
    }

    /**
     * @return The original prefix of the subscriber's operator
     */
    public String getOriginalNetworkPrefix() {
        return originalNetworkPrefix;
    }

    /**
     * @return Name of country in the subscriber's roaming
     */
    public String getRoamingCountryName() {
        return roamingCountryName;
    }

    /**
     * @return Prefix of country in the subscriber's roaming
     */
    public String getRoamingCountryPrefix() {
        return roamingCountryPrefix;
    }

    /**
     * @return Operator in the subscriber's roaming
     */
    public String getRoamingNetworkName() {
        return roamingNetworkName;
    }

    /**
     * @return Prefix of operator in the subscriber's roaming
     */
    public String getRoamingNetworkPrefix() {
        return roamingNetworkPrefix;
    }

    /**
     * @return Name of country if the phone number of the subscriber is ported
     */
    public String getPortedCountryName() {
        return portedCountryName;
    }

    /**
     * @return Prefix of country if the phone number of the subscriber is ported
     */
    public String getPortedCountryPrefix() {
        return portedCountryPrefix;
    }

    /**
     * @return Name of operator if the phone number of the subscriber is ported
     */
    public String getPortedNetworkName() {
        return portedNetworkName;
    }

    /**
     * @return Prefix of operator if the phone number of the subscriber is ported
     */
    public String getPortedNetworkPrefix() {
        return portedNetworkPrefix;
    }

    /**
     * @return Price for message
     */
    public float getPricePerMessage() {
        return pricePerMessage;
    }

    /**
     * @return Key that is responsible for identification of a ported number
     */
    public boolean isIsPorted() {
        return isPorted;
    }

    /**
     * @return Key that is responsible for identification a subscriber in roaming
     */
    public boolean isIsInRoaming() {
        return isInRoaming;
    }
}
