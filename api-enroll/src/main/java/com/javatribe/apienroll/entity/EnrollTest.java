package com.javatribe.apienroll.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

public class EnrollTest implements Serializable {
    private Long id;

    @JsonProperty("test_name")
    private String testName;

    @JsonProperty("direction_code")
    private Integer directionCode;

    @JsonProperty("ownner_name")
    private String ownnerName;

    @JsonProperty("file_url")
    private String fileUrl;

    @JsonProperty("gmt_created")
    private Date gmtCreated;

    @JsonProperty("gmt_modified")
    private Date gmtModified;

    @JsonProperty("gmt_modified")
    private Integer deleteMark;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName == null ? null : testName.trim();
    }

    public Integer getDirectionCode() {
        return directionCode;
    }

    public void setDirectionCode(Integer directionCode) {
        this.directionCode = directionCode;
    }

    public String getOwnnerName() {
        return ownnerName;
    }

    public void setOwnnerName(String ownnerName) {
        this.ownnerName = ownnerName == null ? null : ownnerName.trim();
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl == null ? null : fileUrl.trim();
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