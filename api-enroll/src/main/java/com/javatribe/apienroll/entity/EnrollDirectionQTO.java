package com.javatribe.apienroll.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EnrollDirectionQTO {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EnrollDirectionQTO() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDirectionImgIsNull() {
            addCriterion("direction_img is null");
            return (Criteria) this;
        }

        public Criteria andDirectionImgIsNotNull() {
            addCriterion("direction_img is not null");
            return (Criteria) this;
        }

        public Criteria andDirectionImgEqualTo(String value) {
            addCriterion("direction_img =", value, "directionImg");
            return (Criteria) this;
        }

        public Criteria andDirectionImgNotEqualTo(String value) {
            addCriterion("direction_img <>", value, "directionImg");
            return (Criteria) this;
        }

        public Criteria andDirectionImgGreaterThan(String value) {
            addCriterion("direction_img >", value, "directionImg");
            return (Criteria) this;
        }

        public Criteria andDirectionImgGreaterThanOrEqualTo(String value) {
            addCriterion("direction_img >=", value, "directionImg");
            return (Criteria) this;
        }

        public Criteria andDirectionImgLessThan(String value) {
            addCriterion("direction_img <", value, "directionImg");
            return (Criteria) this;
        }

        public Criteria andDirectionImgLessThanOrEqualTo(String value) {
            addCriterion("direction_img <=", value, "directionImg");
            return (Criteria) this;
        }

        public Criteria andDirectionImgLike(String value) {
            addCriterion("direction_img like", value, "directionImg");
            return (Criteria) this;
        }

        public Criteria andDirectionImgNotLike(String value) {
            addCriterion("direction_img not like", value, "directionImg");
            return (Criteria) this;
        }

        public Criteria andDirectionImgIn(List<String> values) {
            addCriterion("direction_img in", values, "directionImg");
            return (Criteria) this;
        }

        public Criteria andDirectionImgNotIn(List<String> values) {
            addCriterion("direction_img not in", values, "directionImg");
            return (Criteria) this;
        }

        public Criteria andDirectionImgBetween(String value1, String value2) {
            addCriterion("direction_img between", value1, value2, "directionImg");
            return (Criteria) this;
        }

        public Criteria andDirectionImgNotBetween(String value1, String value2) {
            addCriterion("direction_img not between", value1, value2, "directionImg");
            return (Criteria) this;
        }

        public Criteria andDirectionNameIsNull() {
            addCriterion("direction_name is null");
            return (Criteria) this;
        }

        public Criteria andDirectionNameIsNotNull() {
            addCriterion("direction_name is not null");
            return (Criteria) this;
        }

        public Criteria andDirectionNameEqualTo(String value) {
            addCriterion("direction_name =", value, "directionName");
            return (Criteria) this;
        }

        public Criteria andDirectionNameNotEqualTo(String value) {
            addCriterion("direction_name <>", value, "directionName");
            return (Criteria) this;
        }

        public Criteria andDirectionNameGreaterThan(String value) {
            addCriterion("direction_name >", value, "directionName");
            return (Criteria) this;
        }

        public Criteria andDirectionNameGreaterThanOrEqualTo(String value) {
            addCriterion("direction_name >=", value, "directionName");
            return (Criteria) this;
        }

        public Criteria andDirectionNameLessThan(String value) {
            addCriterion("direction_name <", value, "directionName");
            return (Criteria) this;
        }

        public Criteria andDirectionNameLessThanOrEqualTo(String value) {
            addCriterion("direction_name <=", value, "directionName");
            return (Criteria) this;
        }

        public Criteria andDirectionNameLike(String value) {
            addCriterion("direction_name like", value, "directionName");
            return (Criteria) this;
        }

        public Criteria andDirectionNameNotLike(String value) {
            addCriterion("direction_name not like", value, "directionName");
            return (Criteria) this;
        }

        public Criteria andDirectionNameIn(List<String> values) {
            addCriterion("direction_name in", values, "directionName");
            return (Criteria) this;
        }

        public Criteria andDirectionNameNotIn(List<String> values) {
            addCriterion("direction_name not in", values, "directionName");
            return (Criteria) this;
        }

        public Criteria andDirectionNameBetween(String value1, String value2) {
            addCriterion("direction_name between", value1, value2, "directionName");
            return (Criteria) this;
        }

        public Criteria andDirectionNameNotBetween(String value1, String value2) {
            addCriterion("direction_name not between", value1, value2, "directionName");
            return (Criteria) this;
        }

        public Criteria andDirectionCodeIsNull() {
            addCriterion("direction_code is null");
            return (Criteria) this;
        }

        public Criteria andDirectionCodeIsNotNull() {
            addCriterion("direction_code is not null");
            return (Criteria) this;
        }

        public Criteria andDirectionCodeEqualTo(Integer value) {
            addCriterion("direction_code =", value, "directionCode");
            return (Criteria) this;
        }

        public Criteria andDirectionCodeNotEqualTo(Integer value) {
            addCriterion("direction_code <>", value, "directionCode");
            return (Criteria) this;
        }

        public Criteria andDirectionCodeGreaterThan(Integer value) {
            addCriterion("direction_code >", value, "directionCode");
            return (Criteria) this;
        }

        public Criteria andDirectionCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("direction_code >=", value, "directionCode");
            return (Criteria) this;
        }

        public Criteria andDirectionCodeLessThan(Integer value) {
            addCriterion("direction_code <", value, "directionCode");
            return (Criteria) this;
        }

        public Criteria andDirectionCodeLessThanOrEqualTo(Integer value) {
            addCriterion("direction_code <=", value, "directionCode");
            return (Criteria) this;
        }

        public Criteria andDirectionCodeIn(List<Integer> values) {
            addCriterion("direction_code in", values, "directionCode");
            return (Criteria) this;
        }

        public Criteria andDirectionCodeNotIn(List<Integer> values) {
            addCriterion("direction_code not in", values, "directionCode");
            return (Criteria) this;
        }

        public Criteria andDirectionCodeBetween(Integer value1, Integer value2) {
            addCriterion("direction_code between", value1, value2, "directionCode");
            return (Criteria) this;
        }

        public Criteria andDirectionCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("direction_code not between", value1, value2, "directionCode");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedIsNull() {
            addCriterion("gmt_created is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedIsNotNull() {
            addCriterion("gmt_created is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedEqualTo(Date value) {
            addCriterion("gmt_created =", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedNotEqualTo(Date value) {
            addCriterion("gmt_created <>", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedGreaterThan(Date value) {
            addCriterion("gmt_created >", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_created >=", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedLessThan(Date value) {
            addCriterion("gmt_created <", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_created <=", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedIn(List<Date> values) {
            addCriterion("gmt_created in", values, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedNotIn(List<Date> values) {
            addCriterion("gmt_created not in", values, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedBetween(Date value1, Date value2) {
            addCriterion("gmt_created between", value1, value2, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_created not between", value1, value2, "gmtCreated");
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

        public Criteria andDeleteMarkIsNull() {
            addCriterion("delete_mark is null");
            return (Criteria) this;
        }

        public Criteria andDeleteMarkIsNotNull() {
            addCriterion("delete_mark is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteMarkEqualTo(Integer value) {
            addCriterion("delete_mark =", value, "deleteMark");
            return (Criteria) this;
        }

        public Criteria andDeleteMarkNotEqualTo(Integer value) {
            addCriterion("delete_mark <>", value, "deleteMark");
            return (Criteria) this;
        }

        public Criteria andDeleteMarkGreaterThan(Integer value) {
            addCriterion("delete_mark >", value, "deleteMark");
            return (Criteria) this;
        }

        public Criteria andDeleteMarkGreaterThanOrEqualTo(Integer value) {
            addCriterion("delete_mark >=", value, "deleteMark");
            return (Criteria) this;
        }

        public Criteria andDeleteMarkLessThan(Integer value) {
            addCriterion("delete_mark <", value, "deleteMark");
            return (Criteria) this;
        }

        public Criteria andDeleteMarkLessThanOrEqualTo(Integer value) {
            addCriterion("delete_mark <=", value, "deleteMark");
            return (Criteria) this;
        }

        public Criteria andDeleteMarkIn(List<Integer> values) {
            addCriterion("delete_mark in", values, "deleteMark");
            return (Criteria) this;
        }

        public Criteria andDeleteMarkNotIn(List<Integer> values) {
            addCriterion("delete_mark not in", values, "deleteMark");
            return (Criteria) this;
        }

        public Criteria andDeleteMarkBetween(Integer value1, Integer value2) {
            addCriterion("delete_mark between", value1, value2, "deleteMark");
            return (Criteria) this;
        }

        public Criteria andDeleteMarkNotBetween(Integer value1, Integer value2) {
            addCriterion("delete_mark not between", value1, value2, "deleteMark");
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