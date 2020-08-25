package com.xkcoding.multi.datasource.mybatis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductionControlExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductionControlExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andTotalNumIsNull() {
            addCriterion("total_num is null");
            return (Criteria) this;
        }

        public Criteria andTotalNumIsNotNull() {
            addCriterion("total_num is not null");
            return (Criteria) this;
        }

        public Criteria andTotalNumEqualTo(Integer value) {
            addCriterion("total_num =", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumNotEqualTo(Integer value) {
            addCriterion("total_num <>", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumGreaterThan(Integer value) {
            addCriterion("total_num >", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_num >=", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumLessThan(Integer value) {
            addCriterion("total_num <", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumLessThanOrEqualTo(Integer value) {
            addCriterion("total_num <=", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumIn(List<Integer> values) {
            addCriterion("total_num in", values, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumNotIn(List<Integer> values) {
            addCriterion("total_num not in", values, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumBetween(Integer value1, Integer value2) {
            addCriterion("total_num between", value1, value2, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumNotBetween(Integer value1, Integer value2) {
            addCriterion("total_num not between", value1, value2, "totalNum");
            return (Criteria) this;
        }

        public Criteria andRespondedIsNull() {
            addCriterion("Responded is null");
            return (Criteria) this;
        }

        public Criteria andRespondedIsNotNull() {
            addCriterion("Responded is not null");
            return (Criteria) this;
        }

        public Criteria andRespondedEqualTo(Integer value) {
            addCriterion("Responded =", value, "responded");
            return (Criteria) this;
        }

        public Criteria andRespondedNotEqualTo(Integer value) {
            addCriterion("Responded <>", value, "responded");
            return (Criteria) this;
        }

        public Criteria andRespondedGreaterThan(Integer value) {
            addCriterion("Responded >", value, "responded");
            return (Criteria) this;
        }

        public Criteria andRespondedGreaterThanOrEqualTo(Integer value) {
            addCriterion("Responded >=", value, "responded");
            return (Criteria) this;
        }

        public Criteria andRespondedLessThan(Integer value) {
            addCriterion("Responded <", value, "responded");
            return (Criteria) this;
        }

        public Criteria andRespondedLessThanOrEqualTo(Integer value) {
            addCriterion("Responded <=", value, "responded");
            return (Criteria) this;
        }

        public Criteria andRespondedIn(List<Integer> values) {
            addCriterion("Responded in", values, "responded");
            return (Criteria) this;
        }

        public Criteria andRespondedNotIn(List<Integer> values) {
            addCriterion("Responded not in", values, "responded");
            return (Criteria) this;
        }

        public Criteria andRespondedBetween(Integer value1, Integer value2) {
            addCriterion("Responded between", value1, value2, "responded");
            return (Criteria) this;
        }

        public Criteria andRespondedNotBetween(Integer value1, Integer value2) {
            addCriterion("Responded not between", value1, value2, "responded");
            return (Criteria) this;
        }

        public Criteria andCloseNumIsNull() {
            addCriterion("close_num is null");
            return (Criteria) this;
        }

        public Criteria andCloseNumIsNotNull() {
            addCriterion("close_num is not null");
            return (Criteria) this;
        }

        public Criteria andCloseNumEqualTo(Integer value) {
            addCriterion("close_num =", value, "closeNum");
            return (Criteria) this;
        }

        public Criteria andCloseNumNotEqualTo(Integer value) {
            addCriterion("close_num <>", value, "closeNum");
            return (Criteria) this;
        }

        public Criteria andCloseNumGreaterThan(Integer value) {
            addCriterion("close_num >", value, "closeNum");
            return (Criteria) this;
        }

        public Criteria andCloseNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("close_num >=", value, "closeNum");
            return (Criteria) this;
        }

        public Criteria andCloseNumLessThan(Integer value) {
            addCriterion("close_num <", value, "closeNum");
            return (Criteria) this;
        }

        public Criteria andCloseNumLessThanOrEqualTo(Integer value) {
            addCriterion("close_num <=", value, "closeNum");
            return (Criteria) this;
        }

        public Criteria andCloseNumIn(List<Integer> values) {
            addCriterion("close_num in", values, "closeNum");
            return (Criteria) this;
        }

        public Criteria andCloseNumNotIn(List<Integer> values) {
            addCriterion("close_num not in", values, "closeNum");
            return (Criteria) this;
        }

        public Criteria andCloseNumBetween(Integer value1, Integer value2) {
            addCriterion("close_num between", value1, value2, "closeNum");
            return (Criteria) this;
        }

        public Criteria andCloseNumNotBetween(Integer value1, Integer value2) {
            addCriterion("close_num not between", value1, value2, "closeNum");
            return (Criteria) this;
        }

        public Criteria andAssignmentGroupIsNull() {
            addCriterion("assignment_group is null");
            return (Criteria) this;
        }

        public Criteria andAssignmentGroupIsNotNull() {
            addCriterion("assignment_group is not null");
            return (Criteria) this;
        }

        public Criteria andAssignmentGroupEqualTo(String value) {
            addCriterion("assignment_group =", value, "assignmentGroup");
            return (Criteria) this;
        }

        public Criteria andAssignmentGroupNotEqualTo(String value) {
            addCriterion("assignment_group <>", value, "assignmentGroup");
            return (Criteria) this;
        }

        public Criteria andAssignmentGroupGreaterThan(String value) {
            addCriterion("assignment_group >", value, "assignmentGroup");
            return (Criteria) this;
        }

        public Criteria andAssignmentGroupGreaterThanOrEqualTo(String value) {
            addCriterion("assignment_group >=", value, "assignmentGroup");
            return (Criteria) this;
        }

        public Criteria andAssignmentGroupLessThan(String value) {
            addCriterion("assignment_group <", value, "assignmentGroup");
            return (Criteria) this;
        }

        public Criteria andAssignmentGroupLessThanOrEqualTo(String value) {
            addCriterion("assignment_group <=", value, "assignmentGroup");
            return (Criteria) this;
        }

        public Criteria andAssignmentGroupLike(String value) {
            addCriterion("assignment_group like", value, "assignmentGroup");
            return (Criteria) this;
        }

        public Criteria andAssignmentGroupNotLike(String value) {
            addCriterion("assignment_group not like", value, "assignmentGroup");
            return (Criteria) this;
        }

        public Criteria andAssignmentGroupIn(List<String> values) {
            addCriterion("assignment_group in", values, "assignmentGroup");
            return (Criteria) this;
        }

        public Criteria andAssignmentGroupNotIn(List<String> values) {
            addCriterion("assignment_group not in", values, "assignmentGroup");
            return (Criteria) this;
        }

        public Criteria andAssignmentGroupBetween(String value1, String value2) {
            addCriterion("assignment_group between", value1, value2, "assignmentGroup");
            return (Criteria) this;
        }

        public Criteria andAssignmentGroupNotBetween(String value1, String value2) {
            addCriterion("assignment_group not between", value1, value2, "assignmentGroup");
            return (Criteria) this;
        }

        public Criteria andMarkIsNull() {
            addCriterion("mark is null");
            return (Criteria) this;
        }

        public Criteria andMarkIsNotNull() {
            addCriterion("mark is not null");
            return (Criteria) this;
        }

        public Criteria andMarkEqualTo(Integer value) {
            addCriterion("mark =", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotEqualTo(Integer value) {
            addCriterion("mark <>", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThan(Integer value) {
            addCriterion("mark >", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThanOrEqualTo(Integer value) {
            addCriterion("mark >=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThan(Integer value) {
            addCriterion("mark <", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThanOrEqualTo(Integer value) {
            addCriterion("mark <=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkIn(List<Integer> values) {
            addCriterion("mark in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotIn(List<Integer> values) {
            addCriterion("mark not in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkBetween(Integer value1, Integer value2) {
            addCriterion("mark between", value1, value2, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotBetween(Integer value1, Integer value2) {
            addCriterion("mark not between", value1, value2, "mark");
            return (Criteria) this;
        }

        public Criteria andSourceTypeIsNull() {
            addCriterion("source_type is null");
            return (Criteria) this;
        }

        public Criteria andSourceTypeIsNotNull() {
            addCriterion("source_type is not null");
            return (Criteria) this;
        }

        public Criteria andSourceTypeEqualTo(Integer value) {
            addCriterion("source_type =", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNotEqualTo(Integer value) {
            addCriterion("source_type <>", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeGreaterThan(Integer value) {
            addCriterion("source_type >", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("source_type >=", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeLessThan(Integer value) {
            addCriterion("source_type <", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeLessThanOrEqualTo(Integer value) {
            addCriterion("source_type <=", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeIn(List<Integer> values) {
            addCriterion("source_type in", values, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNotIn(List<Integer> values) {
            addCriterion("source_type not in", values, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeBetween(Integer value1, Integer value2) {
            addCriterion("source_type between", value1, value2, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("source_type not between", value1, value2, "sourceType");
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