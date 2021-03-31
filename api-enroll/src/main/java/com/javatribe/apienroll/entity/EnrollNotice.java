package com.javatribe.apienroll.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

public class EnrollNotice implements Serializable {
    private Long id;

    private String title;

    private String content;

    @JsonProperty("direction_code")
    private Integer directionCode;

    @JsonProperty("delete_mark")
    private Integer deleteMark;

    @JsonProperty("gmt_created")
    private Date gmtCreated;

    @JsonProperty("gmt_modified")
    private Date gmtModified;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getDirectionCode() {
        return directionCode;
    }

    public void setDirectionCode(Integer directionCode) {
        this.directionCode = directionCode;
    }

    public Integer getDeleteMark() {
        return deleteMark;
    }

    public void setDeleteMark(Integer deleteMark) {
        this.deleteMark = deleteMark;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}