package com.javatribe.apicompetition.pojo.po;

import java.io.Serializable;
import java.util.Date;

public class RegisterTeam implements Serializable {
    private Long registerId;

    private Long competitionId;

    private String teamName;

    private String teamLeaderName;

    private String teamLeaderPhone;

    private String teamLeaderStudentId;

    private String teamLeaderWechat;

    private String teamLeaderCollege;

    private String teamUserList;

    private Integer deleteStatus;

    private Date registerTime;

    private static final long serialVersionUID = 1L;

    public Long getRegisterId() {
        return registerId;
    }

    public RegisterTeam withRegisterId(Long registerId) {
        this.setRegisterId(registerId);
        return this;
    }

    public void setRegisterId(Long registerId) {
        this.registerId = registerId;
    }

    public Long getCompetitionId() {
        return competitionId;
    }

    public RegisterTeam withCompetitionId(Long competitionId) {
        this.setCompetitionId(competitionId);
        return this;
    }

    public void setCompetitionId(Long competitionId) {
        this.competitionId = competitionId;
    }

    public String getTeamName() {
        return teamName;
    }

    public RegisterTeam withTeamName(String teamName) {
        this.setTeamName(teamName);
        return this;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName == null ? null : teamName.trim();
    }

    public String getTeamLeaderName() {
        return teamLeaderName;
    }

    public RegisterTeam withTeamLeaderName(String teamLeaderName) {
        this.setTeamLeaderName(teamLeaderName);
        return this;
    }

    public void setTeamLeaderName(String teamLeaderName) {
        this.teamLeaderName = teamLeaderName == null ? null : teamLeaderName.trim();
    }

    public String getTeamLeaderPhone() {
        return teamLeaderPhone;
    }

    public RegisterTeam withTeamLeaderPhone(String teamLeaderPhone) {
        this.setTeamLeaderPhone(teamLeaderPhone);
        return this;
    }

    public void setTeamLeaderPhone(String teamLeaderPhone) {
        this.teamLeaderPhone = teamLeaderPhone == null ? null : teamLeaderPhone.trim();
    }

    public String getTeamLeaderStudentId() {
        return teamLeaderStudentId;
    }

    public RegisterTeam withTeamLeaderStudentId(String teamLeaderStudentId) {
        this.setTeamLeaderStudentId(teamLeaderStudentId);
        return this;
    }

    public void setTeamLeaderStudentId(String teamLeaderStudentId) {
        this.teamLeaderStudentId = teamLeaderStudentId == null ? null : teamLeaderStudentId.trim();
    }

    public String getTeamLeaderWechat() {
        return teamLeaderWechat;
    }

    public RegisterTeam withTeamLeaderWechat(String teamLeaderWechat) {
        this.setTeamLeaderWechat(teamLeaderWechat);
        return this;
    }

    public void setTeamLeaderWechat(String teamLeaderWechat) {
        this.teamLeaderWechat = teamLeaderWechat == null ? null : teamLeaderWechat.trim();
    }

    public String getTeamLeaderCollege() {
        return teamLeaderCollege;
    }

    public RegisterTeam withTeamLeaderCollege(String teamLeaderCollege) {
        this.setTeamLeaderCollege(teamLeaderCollege);
        return this;
    }

    public void setTeamLeaderCollege(String teamLeaderCollege) {
        this.teamLeaderCollege = teamLeaderCollege == null ? null : teamLeaderCollege.trim();
    }

    public String getTeamUserList() {
        return teamUserList;
    }

    public RegisterTeam withTeamUserList(String teamUserList) {
        this.setTeamUserList(teamUserList);
        return this;
    }

    public void setTeamUserList(String teamUserList) {
        this.teamUserList = teamUserList == null ? null : teamUserList.trim();
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public RegisterTeam withDeleteStatus(Integer deleteStatus) {
        this.setDeleteStatus(deleteStatus);
        return this;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public RegisterTeam withRegisterTime(Date registerTime) {
        this.setRegisterTime(registerTime);
        return this;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", registerId=").append(registerId);
        sb.append(", competitionId=").append(competitionId);
        sb.append(", teamName=").append(teamName);
        sb.append(", teamLeaderName=").append(teamLeaderName);
        sb.append(", teamLeaderPhone=").append(teamLeaderPhone);
        sb.append(", teamLeaderStudentId=").append(teamLeaderStudentId);
        sb.append(", teamLeaderWechat=").append(teamLeaderWechat);
        sb.append(", teamLeaderCollege=").append(teamLeaderCollege);
        sb.append(", teamUserList=").append(teamUserList);
        sb.append(", deleteStatus=").append(deleteStatus);
        sb.append(", registerTime=").append(registerTime);
        sb.append("]");
        return sb.toString();
    }
}