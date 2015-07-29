package com.intis.sdk.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class Template
 * Class for getting user templates
 */
public class Template {

    protected long id;

    @JsonProperty("name")
    protected String title;

    @JsonProperty("template")
    protected String template;

    @JsonProperty("up_time")
    protected String createdAt;

    /**
     * @return Template ID
     */
    public long getId() {
        return id;
    }

    /**
     * @param mId - Template ID
     */
    public void setId(long mId) {
        this.id = mId;
    }

    /**
     * @return Template name
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return Text of template
     */
    public String getTemplate() {
        return template;
    }

    /**
     * @return Time of template creating
     */
    public String getCreatedAt() {
        return createdAt;
    }
}
