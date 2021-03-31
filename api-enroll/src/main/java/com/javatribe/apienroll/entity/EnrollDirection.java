package com.javatribe.apienroll.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

public class EnrollDirection implements Serializable {
    private Long id;

    @JsonProperty("direction_img")
    private String directionImg;

    @JsonProperty("direction_img")
    private String directionName;
    @JsonProperty("direction_code")
    private Integer directionCode;
    @JsonProperty("gmt_created")
    private Date gmtCreated;
    @JsonProperty("gmt_modified")
    private Date gmtModified;
    @JsonProperty("delete_mark")
    private Integer deleteMark;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDirectionImg() {
        return directionImg;
    }

    public void setDirectionImg(String directionImg) {
        this.directionImg = directionImg == null ? null : directionImg.trim();
    }

    public String getDirectionName() {
        return directionName;
    }

    public void setDirectionName(String directionName) {
        this.directionName = directionName == null ? null : directionName.trim();
    }

    public Integer getDirectionCode() {
        return directionCode;
    }

    public void setDirectionCode(Integer directionCode) {
        this.directionCode = directionCode;
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

    public Integer getDeleteMark() {
        return deleteMark;
    }

    public void setDeleteMark(Integer deleteMark) {
        this.deleteMark = deleteMark;
    }
}