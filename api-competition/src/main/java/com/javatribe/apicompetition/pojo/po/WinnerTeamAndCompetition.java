package com.javatribe.apicompetition.pojo.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class WinnerTeamAndCompetition {

    private Long competitionId;

    private String competitionName;

    private String teamName;

    private String teamUserList;

    private String theYear;

    @JsonFormat(pattern = "yyyy.MM.dd")
    private Date teamBeginTime;

    @JsonFormat(pattern = "yyyy.MM.dd")
    private Date teamEndTime;

    private String teamOrderNum;

    private String teamOrderText;

    public Long getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(Long competitionId) {
        this.competitionId = competitionId;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamUserList() {
        return teamUserList;
    }

    public void setTeamUserList(String teamUserList) {
        this.teamUserList = teamUserList;
    }

    public String getTheYear() {
        return theYear;
    }

    public void setTheYear(String theYear) {
        this.theYear = theYear;
    }

    public Date getTeamBeginTime() {
        return teamBeginTime;
    }

    public void setTeamBeginTime(Date teamBeginTime) {
        this.teamBeginTime = teamBeginTime;
    }

    public Date getTeamEndTime() {
        return teamEndTime;
    }

    public void setTeamEndTime(Date teamEndTime) {
        this.teamEndTime = teamEndTime;
    }

    public String getTeamOrderNum() {
        return teamOrderNum;
    }

    public void setTeamOrderNum(String teamOrderNum) {
        this.teamOrderNum = teamOrderNum;
    }

    public String getTeamOrderText() {
        return teamOrderText;
    }

    public void setTeamOrderText(String teamOrderText) {
        this.teamOrderText = teamOrderText;
    }
}
