package com.xkcoding.multi.datasource.mybatis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CrComplaintExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CrComplaintExample() {
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

        public Criteria andLNumIsNull() {
            addCriterion("l_num is null");
            return (Criteria) this;
        }

        public Criteria andLNumIsNotNull() {
            addCriterion("l_num is not null");
            return (Criteria) this;
        }

        public Criteria andLNumEqualTo(Integer value) {
            addCriterion("l_num =", value, "lNum");
            return (Criteria) this;
        }

        public Criteria andLNumNotEqualTo(Integer value) {
            addCriterion("l_num <>", value, "lNum");
            return (Criteria) this;
        }

        public Criteria andLNumGreaterThan(Integer value) {
            addCriterion("l_num >", value, "lNum");
            return (Criteria) this;
        }

        public Criteria andLNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("l_num >=", value, "lNum");
            return (Criteria) this;
        }

        public Criteria andLNumLessThan(Integer value) {
            addCriterion("l_num <", value, "lNum");
            return (Criteria) this;
        }

        public Criteria andLNumLessThanOrEqualTo(Integer value) {
            addCriterion("l_num <=", value, "lNum");
            return (Criteria) this;
        }

        public Criteria andLNumIn(List<Integer> values) {
            addCriterion("l_num in", values, "lNum");
            return (Criteria) this;
        }

        public Criteria andLNumNotIn(List<Integer> values) {
            addCriterion("l_num not in", values, "lNum");
            return (Criteria) this;
        }

        public Criteria andLNumBetween(Integer value1, Integer value2) {
            addCriterion("l_num between", value1, value2, "lNum");
            return (Criteria) this;
        }

        public Criteria andLNumNotBetween(Integer value1, Integer value2) {
            addCriterion("l_num not between", value1, value2, "lNum");
            return (Criteria) this;
        }

        public Criteria andCrComplaintNumIsNull() {
            addCriterion("cr_complaint_num is null");
            return (Criteria) this;
        }

        public Criteria andCrComplaintNumIsNotNull() {
            addCriterion("cr_complaint_num is not null");
            return (Criteria) this;
        }

        public Criteria andCrComplaintNumEqualTo(Integer value) {
            addCriterion("cr_complaint_num =", value, "crComplaintNum");
            return (Criteria) this;
        }

        public Criteria andCrComplaintNumNotEqualTo(Integer value) {
            addCriterion("cr_complaint_num <>", value, "crComplaintNum");
            return (Criteria) this;
        }

        public Criteria andCrComplaintNumGreaterThan(Integer value) {
            addCriterion("cr_complaint_num >", value, "crComplaintNum");
            return (Criteria) this;
        }

        public Criteria andCrComplaintNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("cr_complaint_num >=", value, "crComplaintNum");
            return (Criteria) this;
        }

        public Criteria andCrComplaintNumLessThan(Integer value) {
            addCriterion("cr_complaint_num <", value, "crComplaintNum");
            return (Criteria) this;
        }

        public Criteria andCrComplaintNumLessThanOrEqualTo(Integer value) {
            addCriterion("cr_complaint_num <=", value, "crComplaintNum");
            return (Criteria) this;
        }

        public Criteria andCrComplaintNumIn(List<Integer> values) {
            addCriterion("cr_complaint_num in", values, "crComplaintNum");
            return (Criteria) this;
        }

        public Criteria andCrComplaintNumNotIn(List<Integer> values) {
            addCriterion("cr_complaint_num not in", values, "crComplaintNum");
            return (Criteria) this;
        }

        public Criteria andCrComplaintNumBetween(Integer value1, Integer value2) {
            addCriterion("cr_complaint_num between", value1, value2, "crComplaintNum");
            return (Criteria) this;
        }

        public Criteria andCrComplaintNumNotBetween(Integer value1, Integer value2) {
            addCriterion("cr_complaint_num not between", value1, value2, "crComplaintNum");
            return (Criteria) this;
        }

        public Criteria andComplaintCheckIsNull() {
            addCriterion("complaint_check is null");
            return (Criteria) this;
        }

        public Criteria andComplaintCheckIsNotNull() {
            addCriterion("complaint_check is not null");
            return (Criteria) this;
        }

        public Criteria andComplaintCheckEqualTo(String value) {
            addCriterion("complaint_check =", value, "complaintCheck");
            return (Criteria) this;
        }

        public Criteria andComplaintCheckNotEqualTo(String value) {
            addCriterion("complaint_check <>", value, "complaintCheck");
            return (Criteria) this;
        }

        public Criteria andComplaintCheckGreaterThan(String value) {
            addCriterion("complaint_check >", value, "complaintCheck");
            return (Criteria) this;
        }

        public Criteria andComplaintCheckGreaterThanOrEqualTo(String value) {
            addCriterion("complaint_check >=", value, "complaintCheck");
            return (Criteria) this;
        }

        public Criteria andComplaintCheckLessThan(String value) {
            addCriterion("complaint_check <", value, "complaintCheck");
            return (Criteria) this;
        }

        public Criteria andComplaintCheckLessThanOrEqualTo(String value) {
            addCriterion("complaint_check <=", value, "complaintCheck");
            return (Criteria) this;
        }

        public Criteria andComplaintCheckLike(String value) {
            addCriterion("complaint_check like", value, "complaintCheck");
            return (Criteria) this;
        }

        public Criteria andComplaintCheckNotLike(String value) {
            addCriterion("complaint_check not like", value, "complaintCheck");
            return (Criteria) this;
        }

        public Criteria andComplaintCheckIn(List<String> values) {
            addCriterion("complaint_check in", values, "complaintCheck");
            return (Criteria) this;
        }

        public Criteria andComplaintCheckNotIn(List<String> values) {
            addCriterion("complaint_check not in", values, "complaintCheck");
            return (Criteria) this;
        }

        public Criteria andComplaintCheckBetween(String value1, String value2) {
            addCriterion("complaint_check between", value1, value2, "complaintCheck");
            return (Criteria) this;
        }

        public Criteria andComplaintCheckNotBetween(String value1, String value2) {
            addCriterion("complaint_check not between", value1, value2, "complaintCheck");
            return (Criteria) this;
        }

        public Criteria andGroupNameIsNull() {
            addCriterion("group_name is null");
            return (Criteria) this;
        }

        public Criteria andGroupNameIsNotNull() {
            addCriterion("group_name is not null");
            return (Criteria) this;
        }

        public Criteria andGroupNameEqualTo(String value) {
            addCriterion("group_name =", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotEqualTo(String value) {
            addCriterion("group_name <>", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThan(String value) {
            addCriterion("group_name >", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("group_name >=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThan(String value) {
            addCriterion("group_name <", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThanOrEqualTo(String value) {
            addCriterion("group_name <=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLike(String value) {
            addCriterion("group_name like", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotLike(String value) {
            addCriterion("group_name not like", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameIn(List<String> values) {
            addCriterion("group_name in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotIn(List<String> values) {
            addCriterion("group_name not in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameBetween(String value1, String value2) {
            addCriterion("group_name between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotBetween(String value1, String value2) {
            addCriterion("group_name not between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andComplaintNameIsNull() {
            addCriterion("complaint_name is null");
            return (Criteria) this;
        }

        public Criteria andComplaintNameIsNotNull() {
            addCriterion("complaint_name is not null");
            return (Criteria) this;
        }

        public Criteria andComplaintNameEqualTo(String value) {
            addCriterion("complaint_name =", value, "complaintName");
            return (Criteria) this;
        }

        public Criteria andComplaintNameNotEqualTo(String value) {
            addCriterion("complaint_name <>", value, "complaintName");
            return (Criteria) this;
        }

        public Criteria andComplaintNameGreaterThan(String value) {
            addCriterion("complaint_name >", value, "complaintName");
            return (Criteria) this;
        }

        public Criteria andComplaintNameGreaterThanOrEqualTo(String value) {
            addCriterion("complaint_name >=", value, "complaintName");
            return (Criteria) this;
        }

        public Criteria andComplaintNameLessThan(String value) {
            addCriterion("complaint_name <", value, "complaintName");
            return (Criteria) this;
        }

        public Criteria andComplaintNameLessThanOrEqualTo(String value) {
            addCriterion("complaint_name <=", value, "complaintName");
            return (Criteria) this;
        }

        public Criteria andComplaintNameLike(String value) {
            addCriterion("complaint_name like", value, "complaintName");
            return (Criteria) this;
        }

        public Criteria andComplaintNameNotLike(String value) {
            addCriterion("complaint_name not like", value, "complaintName");
            return (Criteria) this;
        }

        public Criteria andComplaintNameIn(List<String> values) {
            addCriterion("complaint_name in", values, "complaintName");
            return (Criteria) this;
        }

        public Criteria andComplaintNameNotIn(List<String> values) {
            addCriterion("complaint_name not in", values, "complaintName");
            return (Criteria) this;
        }

        public Criteria andComplaintNameBetween(String value1, String value2) {
            addCriterion("complaint_name between", value1, value2, "complaintName");
            return (Criteria) this;
        }

        public Criteria andComplaintNameNotBetween(String value1, String value2) {
            addCriterion("complaint_name not between", value1, value2, "complaintName");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Date value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Date value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Date value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Date value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Date value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Date> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Date> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Date value1, Date value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Date value1, Date value2) {
            addCriterion("time not between", value1, value2, "time");
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