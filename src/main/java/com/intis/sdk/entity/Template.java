package com.intis.sdk.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class Template
 * Class for getting user templates
 */
public class Template {

    protected long mId;

    @JsonProperty("name")
    protected String mTitle;

    @JsonProperty("template")
    protected String mTemplate;

    @JsonProperty("up_time")
    protected String mCreatedAt;

    /**
     * @return Template ID
     */
    public long getId() {
        return mId;
    }

    /**
     * @param mId - Template ID
     */
    public void setId(long mId) {
        this.mId = mId;
    }

    /**
     * @return Template name
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * @return Text of template
     */
    public String getTemplate() {
        return mTemplate;
    }

    /**
     * @return Time of template creating
     */
    public String getCreatedAt() {
        return mCreatedAt;
    }
}
