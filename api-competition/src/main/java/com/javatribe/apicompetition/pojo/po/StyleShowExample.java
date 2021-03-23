package com.javatribe.apicompetition.pojo.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StyleShowExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StyleShowExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andShowIdIsNull() {
            addCriterion("show_id is null");
            return (Criteria) this;
        }

        public Criteria andShowIdIsNotNull() {
            addCriterion("show_id is not null");
            return (Criteria) this;
        }

        public Criteria andShowIdEqualTo(Long value) {
            addCriterion("show_id =", value, "showId");
            return (Criteria) this;
        }

        public Criteria andShowIdNotEqualTo(Long value) {
            addCriterion("show_id <>", value, "showId");
            return (Criteria) this;
        }

        public Criteria andShowIdGreaterThan(Long value) {
            addCriterion("show_id >", value, "showId");
            return (Criteria) this;
        }

        public Criteria andShowIdGreaterThanOrEqualTo(Long value) {
            addCriterion("show_id >=", value, "showId");
            return (Criteria) this;
        }

        public Criteria andShowIdLessThan(Long value) {
            addCriterion("show_id <", value, "showId");
            return (Criteria) this;
        }

        public Criteria andShowIdLessThanOrEqualTo(Long value) {
            addCriterion("show_id <=", value, "showId");
            return (Criteria) this;
        }

        public Criteria andShowIdIn(List<Long> values) {
            addCriterion("show_id in", values, "showId");
            return (Criteria) this;
        }

        public Criteria andShowIdNotIn(List<Long> values) {
            addCriterion("show_id not in", values, "showId");
            return (Criteria) this;
        }

        public Criteria andShowIdBetween(Long value1, Long value2) {
            addCriterion("show_id between", value1, value2, "showId");
            return (Criteria) this;
        }

        public Criteria andShowIdNotBetween(Long value1, Long value2) {
            addCriterion("show_id not between", value1, value2, "showId");
            return (Criteria) this;
        }

        public Criteria andCompetitionIdIsNull() {
            addCriterion("competition_id is null");
            return (Criteria) this;
        }

        public Criteria andCompetitionIdIsNotNull() {
            addCriterion("competition_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompetitionIdEqualTo(Long value) {
            addCriterion("competition_id =", value, "competitionId");
            return (Criteria) this;
        }

        public Criteria andCompetitionIdNotEqualTo(Long value) {
            addCriterion("competition_id <>", value, "competitionId");
            return (Criteria) this;
        }

        public Criteria andCompetitionIdGreaterThan(Long value) {
            addCriterion("competition_id >", value, "competitionId");
            return (Criteria) this;
        }

        public Criteria andCompetitionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("competition_id >=", value, "competitionId");
            return (Criteria) this;
        }

        public Criteria andCompetitionIdLessThan(Long value) {
            addCriterion("competition_id <", value, "competitionId");
            return (Criteria) this;
        }

        public Criteria andCompetitionIdLessThanOrEqualTo(Long value) {
            addCriterion("competition_id <=", value, "competitionId");
            return (Criteria) this;
        }

        public Criteria andCompetitionIdIn(List<Long> values) {
            addCriterion("competition_id in", values, "competitionId");
            return (Criteria) this;
        }

        public Criteria andCompetitionIdNotIn(List<Long> values) {
            addCriterion("competition_id not in", values, "competitionId");
            return (Criteria) this;
        }

        public Criteria andCompetitionIdBetween(Long value1, Long value2) {
            addCriterion("competition_id between", value1, value2, "competitionId");
            return (Criteria) this;
        }

        public Criteria andCompetitionIdNotBetween(Long value1, Long value2) {
            addCriterion("competition_id not between", value1, value2, "competitionId");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Date value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Date value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Date value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Date> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNull() {
            addCriterion("gmt_modified is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNotNull() {
            addCriterion("gmt_modified is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedEqualTo(Date value) {
            addCriterion("gmt_modified =", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotEqualTo(Date value) {
            addCriterion("gmt_modified <>", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThan(Date value) {
            addCriterion("gmt_modified >", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_modified >=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThan(Date value) {
            addCriterion("gmt_modified <", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_modified <=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIn(List<Date> values) {
            addCriterion("gmt_modified in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotIn(List<Date> values) {
            addCriterion("gmt_modified not in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedBetween(Date value1, Date value2) {
            addCriterion("gmt_modified between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_modified not between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andShowStatusIsNull() {
            addCriterion("show_status is null");
            return (Criteria) this;
        }

        public Criteria andShowStatusIsNotNull() {
            addCriterion("show_status is not null");
            return (Criteria) this;
        }

        public Criteria andShowStatusEqualTo(Boolean value) {
            addCriterion("show_status =", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusNotEqualTo(Boolean value) {
            addCriterion("show_status <>", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusGreaterThan(Boolean value) {
            addCriterion("show_status >", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("show_status >=", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusLessThan(Boolean value) {
            addCriterion("show_status <", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("show_status <=", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusIn(List<Boolean> values) {
            addCriterion("show_status in", values, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusNotIn(List<Boolean> values) {
            addCriterion("show_status not in", values, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("show_status between", value1, value2, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("show_status not between", value1, value2, "showStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusIsNull() {
            addCriterion("delete_status is null");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusIsNotNull() {
            addCriterion("delete_status is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusEqualTo(Boolean value) {
            addCriterion("delete_status =", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusNotEqualTo(Boolean value) {
            addCriterion("delete_status <>", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusGreaterThan(Boolean value) {
            addCriterion("delete_status >", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("delete_status >=", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusLessThan(Boolean value) {
            addCriterion("delete_status <", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("delete_status <=", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusIn(List<Boolean> values) {
            addCriterion("delete_status in", values, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusNotIn(List<Boolean> values) {
            addCriterion("delete_status not in", values, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("delete_status between", value1, value2, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("delete_status not between", value1, value2, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andShowOrderIsNull() {
            addCriterion("show_order is null");
            return (Criteria) this;
        }

        public Criteria andShowOrderIsNotNull() {
            addCriterion("show_order is not null");
            return (Criteria) this;
        }

        public Criteria andShowOrderEqualTo(Integer value) {
            addCriterion("show_order =", value, "showOrder");
            return (Criteria) this;
        }

        public Criteria andShowOrderNotEqualTo(Integer value) {
            addCriterion("show_order <>", value, "showOrder");
            return (Criteria) this;
        }

        public Criteria andShowOrderGreaterThan(Integer value) {
            addCriterion("show_order >", value, "showOrder");
            return (Criteria) this;
        }

        public Criteria andShowOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("show_order >=", value, "showOrder");
            return (Criteria) this;
        }

        public Criteria andShowOrderLessThan(Integer value) {
            addCriterion("show_order <", value, "showOrder");
            return (Criteria) this;
        }

        public Criteria andShowOrderLessThanOrEqualTo(Integer value) {
            addCriterion("show_order <=", value, "showOrder");
            return (Criteria) this;
        }

        public Criteria andShowOrderIn(List<Integer> values) {
            addCriterion("show_order in", values, "showOrder");
            return (Criteria) this;
        }

        public Criteria andShowOrderNotIn(List<Integer> values) {
            addCriterion("show_order not in", values, "showOrder");
            return (Criteria) this;
        }

        public Criteria andShowOrderBetween(Integer value1, Integer value2) {
            addCriterion("show_order between", value1, value2, "showOrder");
            return (Criteria) this;
        }

        public Criteria andShowOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("show_order not between", value1, value2, "showOrder");
            return (Criteria) this;
        }

        public Criteria andImgsIsNull() {
            addCriterion("imgs is null");
            return (Criteria) this;
        }

        public Criteria andImgsIsNotNull() {
            addCriterion("imgs is not null");
            return (Criteria) this;
        }

        public Criteria andImgsEqualTo(String value) {
            addCriterion("imgs =", value, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsNotEqualTo(String value) {
            addCriterion("imgs <>", value, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsGreaterThan(String value) {
            addCriterion("imgs >", value, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsGreaterThanOrEqualTo(String value) {
            addCriterion("imgs >=", value, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsLessThan(String value) {
            addCriterion("imgs <", value, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsLessThanOrEqualTo(String value) {
            addCriterion("imgs <=", value, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsLike(String value) {
            addCriterion("imgs like", value, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsNotLike(String value) {
            addCriterion("imgs not like", value, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsIn(List<String> values) {
            addCriterion("imgs in", values, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsNotIn(List<String> values) {
            addCriterion("imgs not in", values, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsBetween(String value1, String value2) {
            addCriterion("imgs between", value1, value2, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsNotBetween(String value1, String value2) {
            addCriterion("imgs not between", value1, value2, "imgs");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNull() {
            addCriterion("project_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("project_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("project_name =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("project_name <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("project_name >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_name >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("project_name <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("project_name <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("project_name like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("project_name not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("project_name in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("project_name not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("project_name between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("project_name not between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andTeamNameIsNull() {
            addCriterion("team_name is null");
            return (Criteria) this;
        }

        public Criteria andTeamNameIsNotNull() {
            addCriterion("team_name is not null");
            return (Criteria) this;
        }

        public Criteria andTeamNameEqualTo(String value) {
            addCriterion("team_name =", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameNotEqualTo(String value) {
            addCriterion("team_name <>", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameGreaterThan(String value) {
            addCriterion("team_name >", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameGreaterThanOrEqualTo(String value) {
            addCriterion("team_name >=", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameLessThan(String value) {
            addCriterion("team_name <", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameLessThanOrEqualTo(String value) {
            addCriterion("team_name <=", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameLike(String value) {
            addCriterion("team_name like", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameNotLike(String value) {
            addCriterion("team_name not like", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameIn(List<String> values) {
            addCriterion("team_name in", values, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameNotIn(List<String> values) {
            addCriterion("team_name not in", values, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameBetween(String value1, String value2) {
            addCriterion("team_name between", value1, value2, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameNotBetween(String value1, String value2) {
            addCriterion("team_name not between", value1, value2, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamMembersIsNull() {
            addCriterion("team_members is null");
            return (Criteria) this;
        }

        public Criteria andTeamMembersIsNotNull() {
            addCriterion("team_members is not null");
            return (Criteria) this;
        }

        public Criteria andTeamMembersEqualTo(String value) {
            addCriterion("team_members =", value, "teamMembers");
            return (Criteria) this;
        }

        public Criteria andTeamMembersNotEqualTo(String value) {
            addCriterion("team_members <>", value, "teamMembers");
            return (Criteria) this;
        }

        public Criteria andTeamMembersGreaterThan(String value) {
            addCriterion("team_members >", value, "teamMembers");
            return (Criteria) this;
        }

        public Criteria andTeamMembersGreaterThanOrEqualTo(String value) {
            addCriterion("team_members >=", value, "teamMembers");
            return (Criteria) this;
        }

        public Criteria andTeamMembersLessThan(String value) {
            addCriterion("team_members <", value, "teamMembers");
            return (Criteria) this;
        }

        public Criteria andTeamMembersLessThanOrEqualTo(String value) {
            addCriterion("team_members <=", value, "teamMembers");
            return (Criteria) this;
        }

        public Criteria andTeamMembersLike(String value) {
            addCriterion("team_members like", value, "teamMembers");
            return (Criteria) this;
        }

        public Criteria andTeamMembersNotLike(String value) {
            addCriterion("team_members not like", value, "teamMembers");
            return (Criteria) this;
        }

        public Criteria andTeamMembersIn(List<String> values) {
            addCriterion("team_members in", values, "teamMembers");
            return (Criteria) this;
        }

        public Criteria andTeamMembersNotIn(List<String> values) {
            addCriterion("team_members not in", values, "teamMembers");
            return (Criteria) this;
        }

        public Criteria andTeamMembersBetween(String value1, String value2) {
            addCriterion("team_members between", value1, value2, "teamMembers");
            return (Criteria) this;
        }

        public Criteria andTeamMembersNotBetween(String value1, String value2) {
            addCriterion("team_members not between", value1, value2, "teamMembers");
            return (Criteria) this;
        }

        public Criteria andTeamBeginTimeIsNull() {
            addCriterion("team_begin_time is null");
            return (Criteria) this;
        }

        public Criteria andTeamBeginTimeIsNotNull() {
            addCriterion("team_begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andTeamBeginTimeEqualTo(Date value) {
            addCriterion("team_begin_time =", value, "teamBeginTime");
            return (Criteria) this;
        }

        public Criteria andTeamBeginTimeNotEqualTo(Date value) {
            addCriterion("team_begin_time <>", value, "teamBeginTime");
            return (Criteria) this;
        }

        public Criteria andTeamBeginTimeGreaterThan(Date value) {
            addCriterion("team_begin_time >", value, "teamBeginTime");
            return (Criteria) this;
        }

        public Criteria andTeamBeginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("team_begin_time >=", value, "teamBeginTime");
            return (Criteria) this;
        }

        public Criteria andTeamBeginTimeLessThan(Date value) {
            addCriterion("team_begin_time <", value, "teamBeginTime");
            return (Criteria) this;
        }

        public Criteria andTeamBeginTimeLessThanOrEqualTo(Date value) {
            addCriterion("team_begin_time <=", value, "teamBeginTime");
            return (Criteria) this;
        }

        public Criteria andTeamBeginTimeIn(List<Date> values) {
            addCriterion("team_begin_time in", values, "teamBeginTime");
            return (Criteria) this;
        }

        public Criteria andTeamBeginTimeNotIn(List<Date> values) {
            addCriterion("team_begin_time not in", values, "teamBeginTime");
            return (Criteria) this;
        }

        public Criteria andTeamBeginTimeBetween(Date value1, Date value2) {
            addCriterion("team_begin_time between", value1, value2, "teamBeginTime");
            return (Criteria) this;
        }

        public Criteria andTeamBeginTimeNotBetween(Date value1, Date value2) {
            addCriterion("team_begin_time not between", value1, value2, "teamBeginTime");
            return (Criteria) this;
        }

        public Criteria andTeamEndTimeIsNull() {
            addCriterion("team_end_time is null");
            return (Criteria) this;
        }

        public Criteria andTeamEndTimeIsNotNull() {
            addCriterion("team_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andTeamEndTimeEqualTo(Date value) {
            addCriterion("team_end_time =", value, "teamEndTime");
            return (Criteria) this;
        }

        public Criteria andTeamEndTimeNotEqualTo(Date value) {
            addCriterion("team_end_time <>", value, "teamEndTime");
            return (Criteria) this;
        }

        public Criteria andTeamEndTimeGreaterThan(Date value) {
            addCriterion("team_end_time >", value, "teamEndTime");
            return (Criteria) this;
        }

        public Criteria andTeamEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("team_end_time >=", value, "teamEndTime");
            return (Criteria) this;
        }

        public Criteria andTeamEndTimeLessThan(Date value) {
            addCriterion("team_end_time <", value, "teamEndTime");
            return (Criteria) this;
        }

        public Criteria andTeamEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("team_end_time <=", value, "teamEndTime");
            return (Criteria) this;
        }

        public Criteria andTeamEndTimeIn(List<Date> values) {
            addCriterion("team_end_time in", values, "teamEndTime");
            return (Criteria) this;
        }

        public Criteria andTeamEndTimeNotIn(List<Date> values) {
            addCriterion("team_end_time not in", values, "teamEndTime");
            return (Criteria) this;
        }

        public Criteria andTeamEndTimeBetween(Date value1, Date value2) {
            addCriterion("team_end_time between", value1, value2, "teamEndTime");
            return (Criteria) this;
        }

        public Criteria andTeamEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("team_end_time not between", value1, value2, "teamEndTime");
            return (Criteria) this;
        }

        public Criteria andTheYearIsNull() {
            addCriterion("the_year is null");
            return (Criteria) this;
        }

        public Criteria andTheYearIsNotNull() {
            addCriterion("the_year is not null");
            return (Criteria) this;
        }

        public Criteria andTheYearEqualTo(String value) {
            addCriterion("the_year =", value, "theYear");
            return (Criteria) this;
        }

        public Criteria andTheYearNotEqualTo(String value) {
            addCriterion("the_year <>", value, "theYear");
            return (Criteria) this;
        }

        public Criteria andTheYearGreaterThan(String value) {
            addCriterion("the_year >", value, "theYear");
            return (Criteria) this;
        }

        public Criteria andTheYearGreaterThanOrEqualTo(String value) {
            addCriterion("the_year >=", value, "theYear");
            return (Criteria) this;
        }

        public Criteria andTheYearLessThan(String value) {
            addCriterion("the_year <", value, "theYear");
            return (Criteria) this;
        }

        public Criteria andTheYearLessThanOrEqualTo(String value) {
            addCriterion("the_year <=", value, "theYear");
            return (Criteria) this;
        }

        public Criteria andTheYearLike(String value) {
            addCriterion("the_year like", value, "theYear");
            return (Criteria) this;
        }

        public Criteria andTheYearNotLike(String value) {
            addCriterion("the_year not like", value, "theYear");
            return (Criteria) this;
        }

        public Criteria andTheYearIn(List<String> values) {
            addCriterion("the_year in", values, "theYear");
            return (Criteria) this;
        }

        public Criteria andTheYearNotIn(List<String> values) {
            addCriterion("the_year not in", values, "theYear");
            return (Criteria) this;
        }

        public Criteria andTheYearBetween(String value1, String value2) {
            addCriterion("the_year between", value1, value2, "theYear");
            return (Criteria) this;
        }

        public Criteria andTheYearNotBetween(String value1, String value2) {
            addCriterion("the_year not between", value1, value2, "theYear");
            return (Criteria) this;
        }

        public Criteria andYearIdIsNull() {
            addCriterion("year_id is null");
            return (Criteria) this;
        }

        public Criteria andYearIdIsNotNull() {
            addCriterion("year_id is not null");
            return (Criteria) this;
        }

        public Criteria andYearIdEqualTo(Integer value) {
            addCriterion("year_id =", value, "yearId");
            return (Criteria) this;
        }

        public Criteria andYearIdNotEqualTo(Integer value) {
            addCriterion("year_id <>", value, "yearId");
            return (Criteria) this;
        }

        public Criteria andYearIdGreaterThan(Integer value) {
            addCriterion("year_id >", value, "yearId");
            return (Criteria) this;
        }

        public Criteria andYearIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("year_id >=", value, "yearId");
            return (Criteria) this;
        }

        public Criteria andYearIdLessThan(Integer value) {
            addCriterion("year_id <", value, "yearId");
            return (Criteria) this;
        }

        public Criteria andYearIdLessThanOrEqualTo(Integer value) {
            addCriterion("year_id <=", value, "yearId");
            return (Criteria) this;
        }

        public Criteria andYearIdIn(List<Integer> values) {
            addCriterion("year_id in", values, "yearId");
            return (Criteria) this;
        }

        public Criteria andYearIdNotIn(List<Integer> values) {
            addCriterion("year_id not in", values, "yearId");
            return (Criteria) this;
        }

        public Criteria andYearIdBetween(Integer value1, Integer value2) {
            addCriterion("year_id between", value1, value2, "yearId");
            return (Criteria) this;
        }

        public Criteria andYearIdNotBetween(Integer value1, Integer value2) {
            addCriterion("year_id not between", value1, value2, "yearId");
            return (Criteria) this;
        }

        public Criteria andTeamMasterNameIsNull() {
            addCriterion("team_master_name is null");
            return (Criteria) this;
        }

        public Criteria andTeamMasterNameIsNotNull() {
            addCriterion("team_master_name is not null");
            return (Criteria) this;
        }

        public Criteria andTeamMasterNameEqualTo(String value) {
            addCriterion("team_master_name =", value, "teamMasterName");
            return (Criteria) this;
        }

        public Criteria andTeamMasterNameNotEqualTo(String value) {
            addCriterion("team_master_name <>", value, "teamMasterName");
            return (Criteria) this;
        }

        public Criteria andTeamMasterNameGreaterThan(String value) {
            addCriterion("team_master_name >", value, "teamMasterName");
            return (Criteria) this;
        }

        public Criteria andTeamMasterNameGreaterThanOrEqualTo(String value) {
            addCriterion("team_master_name >=", value, "teamMasterName");
            return (Criteria) this;
        }

        public Criteria andTeamMasterNameLessThan(String value) {
            addCriterion("team_master_name <", value, "teamMasterName");
            return (Criteria) this;
        }

        public Criteria andTeamMasterNameLessThanOrEqualTo(String value) {
            addCriterion("team_master_name <=", value, "teamMasterName");
            return (Criteria) this;
        }

        public Criteria andTeamMasterNameLike(String value) {
            addCriterion("team_master_name like", value, "teamMasterName");
            return (Criteria) this;
        }

        public Criteria andTeamMasterNameNotLike(String value) {
            addCriterion("team_master_name not like", value, "teamMasterName");
            return (Criteria) this;
        }

        public Criteria andTeamMasterNameIn(List<String> values) {
            addCriterion("team_master_name in", values, "teamMasterName");
            return (Criteria) this;
        }

        public Criteria andTeamMasterNameNotIn(List<String> values) {
            addCriterion("team_master_name not in", values, "teamMasterName");
            return (Criteria) this;
        }

        public Criteria andTeamMasterNameBetween(String value1, String value2) {
            addCriterion("team_master_name between", value1, value2, "teamMasterName");
            return (Criteria) this;
        }

        public Criteria andTeamMasterNameNotBetween(String value1, String value2) {
            addCriterion("team_master_name not between", value1, value2, "teamMasterName");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}