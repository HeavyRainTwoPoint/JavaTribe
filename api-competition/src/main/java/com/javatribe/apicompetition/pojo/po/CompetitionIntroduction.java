package com.javatribe.apicompetition.pojo.po;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class CompetitionIntroduction implements Serializable {
    private Long competitionId;

    private String competitionName;

    private String showContent;

    private Boolean deleteStatus;

    @JSONField(format = "yyyy-MM-dd")
    private Date gmtCreate;

    @JSONField(format = "yyyy-MM-dd")
    private Date gmtModified;

    private Integer signUp;

    private static final long serialVersionUID = 1L;

    public Long getCompetitionId() {
        return competitionId;
    }

    public CompetitionIntroduction withCompetitionId(Long competitionId) {
        this.setCompetitionId(competitionId);
        return this;
    }

    public void setCompetitionId(Long competitionId) {
        this.competitionId = competitionId;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public CompetitionIntroduction withCompetitionName(String competitionName) {
        this.setCompetitionName(competitionName);
        return this;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName == null ? null : competitionName.trim();
    }

    public String getShowContent() {
        return showContent;
    }

    public CompetitionIntroduction withShowContent(String showContent) {
        this.setShowContent(showContent);
        return this;
    }

    public void setShowContent(String showContent) {
        this.showContent = showContent == null ? null : showContent.trim();
    }

    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    public CompetitionIntroduction withDeleteStatus(Boolean deleteStatus) {
        this.setDeleteStatus(deleteStatus);
        return this;
    }

    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public CompetitionIntroduction withGmtCreate(Date gmtCreate) {
        this.setGmtCreate(gmtCreate);
        return this;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public CompetitionIntroduction withGmtModified(Date gmtModified) {
        this.setGmtModified(gmtModified);
        return this;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Integer getSignUp() {
        return signUp;
    }

    public CompetitionIntroduction withSignUp(Integer signUp) {
        this.setSignUp(signUp);
        return this;
    }

    public void setSignUp(Integer signUp) {
        this.signUp = signUp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", competitionId=").append(competitionId);
        sb.append(", competitionName=").append(competitionName);
        sb.append(", showContent=").append(showContent);
        sb.append(", deleteStatus=").append(deleteStatus);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", signUp=").append(signUp);
        sb.append("]");
        return sb.toString();
    }
}