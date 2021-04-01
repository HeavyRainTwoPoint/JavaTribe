package com.javatribe.apicompetition.pojo.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class CompetitionYear implements Serializable {
    private Integer yearId;

    private Integer theYear;

    private Boolean deleteStatus;

    private Integer activeStatus;

    private Date gmtCreate;

    private Date gmtModified;


    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date yearStartTime;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date yearEndTime;

    private Integer competitionId;

    private Integer showOrder;

    private static final long serialVersionUID = 1L;

    public Integer getYearId() {
        return yearId;
    }

    public CompetitionYear withYearId(Integer yearId) {
        this.setYearId(yearId);
        return this;
    }

    public void setYearId(Integer yearId) {
        this.yearId = yearId;
    }

    public Integer getTheYear() {
        return theYear;
    }

    public CompetitionYear withTheYear(Integer theYear) {
        this.setTheYear(theYear);
        return this;
    }

    public void setTheYear(Integer theYear) {
        this.theYear = theYear;
    }

    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    public CompetitionYear withDeleteStatus(Boolean deleteStatus) {
        this.setDeleteStatus(deleteStatus);
        return this;
    }

    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Integer getActiveStatus() {
        return activeStatus;
    }

    public CompetitionYear withActiveStatus(Integer activeStatus) {
        this.setActiveStatus(activeStatus);
        return this;
    }

    public void setActiveStatus(Integer activeStatus) {
        this.activeStatus = activeStatus;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public CompetitionYear withGmtCreate(Date gmtCreate) {
        this.setGmtCreate(gmtCreate);
        return this;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public CompetitionYear withGmtModified(Date gmtModified) {
        this.setGmtModified(gmtModified);
        return this;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Date getYearStartTime() {
        return yearStartTime;
    }

    public CompetitionYear withYearStartTime(Date yearStartTime) {
        this.setYearStartTime(yearStartTime);
        return this;
    }

    public void setYearStartTime(Date yearStartTime) {
        this.yearStartTime = yearStartTime;
    }

    public Date getYearEndTime() {
        return yearEndTime;
    }

    public CompetitionYear withYearEndTime(Date yearEndTime) {
        this.setYearEndTime(yearEndTime);
        return this;
    }

    public void setYearEndTime(Date yearEndTime) {
        this.yearEndTime = yearEndTime;
    }

    public Integer getCompetitionId() {
        return competitionId;
    }

    public CompetitionYear withCompetitionId(Integer competitionId) {
        this.setCompetitionId(competitionId);
        return this;
    }

    public void setCompetitionId(Integer competitionId) {
        this.competitionId = competitionId;
    }

    public Integer getShowOrder() {
        return showOrder;
    }

    public CompetitionYear withShowOrder(Integer showOrder) {
        this.setShowOrder(showOrder);
        return this;
    }

    public void setShowOrder(Integer showOrder) {
        this.showOrder = showOrder;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", yearId=").append(yearId);
        sb.append(", theYear=").append(theYear);
        sb.append(", deleteStatus=").append(deleteStatus);
        sb.append(", activeStatus=").append(activeStatus);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", yearStartTime=").append(yearStartTime);
        sb.append(", yearEndTime=").append(yearEndTime);
        sb.append(", competitionId=").append(competitionId);
        sb.append(", showOrder=").append(showOrder);
        sb.append("]");
        return sb.toString();
    }
}