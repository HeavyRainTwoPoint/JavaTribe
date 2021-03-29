package com.javatribe.apicompetition.pojo.po;

import org.springframework.format.annotation.DateTimeFormat;

import javax.xml.crypto.Data;
import java.util.Date;

//存放届数
public class NumberOfSessions {

    private int yearId;

    private String theYear;

    private Integer deleteStatus;

    private Integer activeStatus;

    private Date gmtCreate;

    private Date gmtModified;

    @DateTimeFormat(pattern = "yyyy.MM.dd")
    private Date yearStartTime;

    @DateTimeFormat(pattern = "yyyy.MM.dd")
    private Date yearEndTime;

    private Integer competitionId;

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer delete_status) {
        this.deleteStatus = delete_status;
    }

    public Integer getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(Integer activeStatus) {
        this.activeStatus = activeStatus;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Date getYearStartTime() {
        return yearStartTime;
    }

    public void setYearStartTime(Date yearStartTime) {
        this.yearStartTime = yearStartTime;
    }

    public Date getYearEndTime() {
        return yearEndTime;
    }

    public void setYearEndTime(Date yearEndTime) {
        this.yearEndTime = yearEndTime;
    }

    public int getYearId() {
        return yearId;
    }

    public void setYearId(int yearId) {
        this.yearId = yearId;
    }

    public String getTheYear() {
        return theYear;
    }

    public void setTheYear(String theYear) {
        this.theYear = theYear;
    }

    public Integer getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(Integer competitionId) {
        this.competitionId = competitionId;
    }
}
