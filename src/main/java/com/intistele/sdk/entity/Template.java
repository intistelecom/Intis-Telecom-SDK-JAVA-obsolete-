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
 * Class Template
 * Class for getting user templates
 */
public class Template {

    private long id;

    @JsonProperty("name")
    private String title;

    @JsonProperty("template")
    private String template;

    @JsonProperty("up_time")
    private String createdAt;

    /**
     * @return Template ID
     */
    public long getId() {
        return id;
    }

    /**
     * @param id - Template ID
     */
    public void setId(long id) {
        this.id = id;
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
