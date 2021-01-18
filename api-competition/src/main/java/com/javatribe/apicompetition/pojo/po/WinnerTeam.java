package com.javatribe.apicompetition.pojo.po;

import java.io.Serializable;
import java.util.Date;

public class WinnerTeam implements Serializable {
    private Long teamId;

    private String teamName;

    private String teamUserList;

    private Date gmtCreate;

    private Date gmtModified;

    private String theYear;

    private Date teamBeginTime;

    private Date teamEndTime;

    private Boolean deleteStatus;

    private Long competitionId;

    private Integer teamOrderNum;

    private String teamOrderText;

    private static final long serialVersionUID = 1L;

    public Long getTeamId() {
        return teamId;
    }

    public WinnerTeam withTeamId(Long teamId) {
        this.setTeamId(teamId);
        return this;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public WinnerTeam withTeamName(String teamName) {
        this.setTeamName(teamName);
        return this;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName == null ? null : teamName.trim();
    }

    public String getTeamUserList() {
        return teamUserList;
    }

    public WinnerTeam withTeamUserList(String teamUserList) {
        this.setTeamUserList(teamUserList);
        return this;
    }

    public void setTeamUserList(String teamUserList) {
        this.teamUserList = teamUserList == null ? null : teamUserList.trim();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public WinnerTeam withGmtCreate(Date gmtCreate) {
        this.setGmtCreate(gmtCreate);
        return this;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public WinnerTeam withGmtModified(Date gmtModified) {
        this.setGmtModified(gmtModified);
        return this;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getTheYear() {
        return theYear;
    }

    public WinnerTeam withTheYear(String theYear) {
        this.setTheYear(theYear);
        return this;
    }

    public void setTheYear(String theYear) {
        this.theYear = theYear == null ? null : theYear.trim();
    }

    public Date getTeamBeginTime() {
        return teamBeginTime;
    }

    public WinnerTeam withTeamBeginTime(Date teamBeginTime) {
        this.setTeamBeginTime(teamBeginTime);
        return this;
    }

    public void setTeamBeginTime(Date teamBeginTime) {
        this.teamBeginTime = teamBeginTime;
    }

    public Date getTeamEndTime() {
        return teamEndTime;
    }

    public WinnerTeam withTeamEndTime(Date teamEndTime) {
        this.setTeamEndTime(teamEndTime);
        return this;
    }

    public void setTeamEndTime(Date teamEndTime) {
        this.teamEndTime = teamEndTime;
    }

    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    public WinnerTeam withDeleteStatus(Boolean deleteStatus) {
        this.setDeleteStatus(deleteStatus);
        return this;
    }

    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Long getCompetitionId() {
        return competitionId;
    }

    public WinnerTeam withCompetitionId(Long competitionId) {
        this.setCompetitionId(competitionId);
        return this;
    }

    public void setCompetitionId(Long competitionId) {
        this.competitionId = competitionId;
    }

    public Integer getTeamOrderNum() {
        return teamOrderNum;
    }

    public WinnerTeam withTeamOrderNum(Integer teamOrderNum) {
        this.setTeamOrderNum(teamOrderNum);
        return this;
    }

    public void setTeamOrderNum(Integer teamOrderNum) {
        this.teamOrderNum = teamOrderNum;
    }

    public String getTeamOrderText() {
        return teamOrderText;
    }

    public WinnerTeam withTeamOrderText(String teamOrderText) {
        this.setTeamOrderText(teamOrderText);
        return this;
    }

    public void setTeamOrderText(String teamOrderText) {
        this.teamOrderText = teamOrderText == null ? null : teamOrderText.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", teamId=").append(teamId);
        sb.append(", teamName=").append(teamName);
        sb.append(", teamUserList=").append(teamUserList);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", theYear=").append(theYear);
        sb.append(", teamBeginTime=").append(teamBeginTime);
        sb.append(", teamEndTime=").append(teamEndTime);
        sb.append(", deleteStatus=").append(deleteStatus);
        sb.append(", competitionId=").append(competitionId);
        sb.append(", teamOrderNum=").append(teamOrderNum);
        sb.append(", teamOrderText=").append(teamOrderText);
        sb.append("]");
        return sb.toString();
    }
}