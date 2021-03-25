package com.javatribe.apicompetition.pojo.po;

import java.io.Serializable;
import java.util.Date;

public class StyleShow implements Serializable {
    private Long showId;

    private Long competitionId;

    private Date gmtCreate;

    private Date gmtModified;

    private Boolean showStatus;

    private Boolean deleteStatus;

    private Integer showOrder;

    private String imgs;

    private String projectName;

    private String teamName;

    private String teamMembers;

    private Date teamBeginTime;

    private Date teamEndTime;

    private String theYear;

    private Integer yearId;

    private String teamMasterName;

    private static final long serialVersionUID = 1L;

    public Long getShowId() {
        return showId;
    }

    public StyleShow withShowId(Long showId) {
        this.setShowId(showId);
        return this;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    public Long getCompetitionId() {
        return competitionId;
    }

    public StyleShow withCompetitionId(Long competitionId) {
        this.setCompetitionId(competitionId);
        return this;
    }

    public void setCompetitionId(Long competitionId) {
        this.competitionId = competitionId;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public StyleShow withGmtCreate(Date gmtCreate) {
        this.setGmtCreate(gmtCreate);
        return this;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public StyleShow withGmtModified(Date gmtModified) {
        this.setGmtModified(gmtModified);
        return this;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Boolean getShowStatus() {
        return showStatus;
    }

    public StyleShow withShowStatus(Boolean showStatus) {
        this.setShowStatus(showStatus);
        return this;
    }

    public void setShowStatus(Boolean showStatus) {
        this.showStatus = showStatus;
    }

    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    public StyleShow withDeleteStatus(Boolean deleteStatus) {
        this.setDeleteStatus(deleteStatus);
        return this;
    }

    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Integer getShowOrder() {
        return showOrder;
    }

    public StyleShow withShowOrder(Integer showOrder) {
        this.setShowOrder(showOrder);
        return this;
    }

    public void setShowOrder(Integer showOrder) {
        this.showOrder = showOrder;
    }

    public String getImgs() {
        return imgs;
    }

    public StyleShow withImgs(String imgs) {
        this.setImgs(imgs);
        return this;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs == null ? null : imgs.trim();
    }

    public String getProjectName() {
        return projectName;
    }

    public StyleShow withProjectName(String projectName) {
        this.setProjectName(projectName);
        return this;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getTeamName() {
        return teamName;
    }

    public StyleShow withTeamName(String teamName) {
        this.setTeamName(teamName);
        return this;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName == null ? null : teamName.trim();
    }

    public String getTeamMembers() {
        return teamMembers;
    }

    public StyleShow withTeamMembers(String teamMembers) {
        this.setTeamMembers(teamMembers);
        return this;
    }

    public void setTeamMembers(String teamMembers) {
        this.teamMembers = teamMembers == null ? null : teamMembers.trim();
    }

    public Date getTeamBeginTime() {
        return teamBeginTime;
    }

    public StyleShow withTeamBeginTime(Date teamBeginTime) {
        this.setTeamBeginTime(teamBeginTime);
        return this;
    }

    public void setTeamBeginTime(Date teamBeginTime) {
        this.teamBeginTime = teamBeginTime;
    }

    public Date getTeamEndTime() {
        return teamEndTime;
    }

    public StyleShow withTeamEndTime(Date teamEndTime) {
        this.setTeamEndTime(teamEndTime);
        return this;
    }

    public void setTeamEndTime(Date teamEndTime) {
        this.teamEndTime = teamEndTime;
    }

    public String getTheYear() {
        return theYear;
    }

    public StyleShow withTheYear(String theYear) {
        this.setTheYear(theYear);
        return this;
    }

    public void setTheYear(String theYear) {
        this.theYear = theYear == null ? null : theYear.trim();
    }

    public Integer getYearId() {
        return yearId;
    }

    public StyleShow withYearId(Integer yearId) {
        this.setYearId(yearId);
        return this;
    }

    public void setYearId(Integer yearId) {
        this.yearId = yearId;
    }

    public String getTeamMasterName() {
        return teamMasterName;
    }

    public StyleShow withTeamMasterName(String teamMasterName) {
        this.setTeamMasterName(teamMasterName);
        return this;
    }

    public void setTeamMasterName(String teamMasterName) {
        this.teamMasterName = teamMasterName == null ? null : teamMasterName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", showId=").append(showId);
        sb.append(", competitionId=").append(competitionId);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", showStatus=").append(showStatus);
        sb.append(", deleteStatus=").append(deleteStatus);
        sb.append(", showOrder=").append(showOrder);
        sb.append(", imgs=").append(imgs);
        sb.append(", projectName=").append(projectName);
        sb.append(", teamName=").append(teamName);
        sb.append(", teamMembers=").append(teamMembers);
        sb.append(", teamBeginTime=").append(teamBeginTime);
        sb.append(", teamEndTime=").append(teamEndTime);
        sb.append(", theYear=").append(theYear);
        sb.append(", yearId=").append(yearId);
        sb.append(", teamMasterName=").append(teamMasterName);
        sb.append("]");
        return sb.toString();
    }
}