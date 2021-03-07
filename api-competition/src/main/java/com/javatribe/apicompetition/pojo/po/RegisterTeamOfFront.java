package com.javatribe.apicompetition.pojo.po;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class RegisterTeamOfFront implements Serializable {

    private Long registerId;

    private Long competitionId;

    private Long order;

    private String teamName;

    private String teamLeaderName;

    private String teamLeaderPhone;

    private String teamLeaderStudentId;

    private String teamLeaderWechat;

    private String teamLeaderCollege;

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date registerTime;

    private List<String> teamUserList;

    public Long getRegisterId() {
        return registerId;
    }

    public void setRegisterId(Long registerId) {
        this.registerId = registerId;
    }

    public Long getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(Long competitionId) {
        this.competitionId = competitionId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamLeaderName() {
        return teamLeaderName;
    }

    public void setTeamLeaderName(String teamLeaderName) {
        this.teamLeaderName = teamLeaderName;
    }

    public String getTeamLeaderPhone() {
        return teamLeaderPhone;
    }

    public void setTeamLeaderPhone(String teamLeaderPhone) {
        this.teamLeaderPhone = teamLeaderPhone;
    }

    public String getTeamLeaderStudentId() {
        return teamLeaderStudentId;
    }

    public void setTeamLeaderStudentId(String teamLeaderStudentId) {
        this.teamLeaderStudentId = teamLeaderStudentId;
    }

    public String getTeamLeaderWechat() {
        return teamLeaderWechat;
    }

    public void setTeamLeaderWechat(String teamLeaderWechat) {
        this.teamLeaderWechat = teamLeaderWechat;
    }

    public String getTeamLeaderCollege() {
        return teamLeaderCollege;
    }

    public void setTeamLeaderCollege(String teamLeaderCollege) {
        this.teamLeaderCollege = teamLeaderCollege;
    }

    public List<String> getTeamUserList() {
        return teamUserList;
    }

    public void setTeamUserList(List<String> teamUserList) {
        this.teamUserList = teamUserList;
    }

    public Long getOrder() {
        return order;
    }

    public void setOrder(Long order) {
        this.order = order;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }
}
