package com.xkcoding.multi.datasource.mybatis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SecurityIncidentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SecurityIncidentExample() {
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

        public Criteria andSeclevelIsNull() {
            addCriterion("SecLevel is null");
            return (Criteria) this;
        }

        public Criteria andSeclevelIsNotNull() {
            addCriterion("SecLevel is not null");
            return (Criteria) this;
        }

        public Criteria andSeclevelEqualTo(String value) {
            addCriterion("SecLevel =", value, "seclevel");
            return (Criteria) this;
        }

        public Criteria andSeclevelNotEqualTo(String value) {
            addCriterion("SecLevel <>", value, "seclevel");
            return (Criteria) this;
        }

        public Criteria andSeclevelGreaterThan(String value) {
            addCriterion("SecLevel >", value, "seclevel");
            return (Criteria) this;
        }

        public Criteria andSeclevelGreaterThanOrEqualTo(String value) {
            addCriterion("SecLevel >=", value, "seclevel");
            return (Criteria) this;
        }

        public Criteria andSeclevelLessThan(String value) {
            addCriterion("SecLevel <", value, "seclevel");
            return (Criteria) this;
        }

        public Criteria andSeclevelLessThanOrEqualTo(String value) {
            addCriterion("SecLevel <=", value, "seclevel");
            return (Criteria) this;
        }

        public Criteria andSeclevelLike(String value) {
            addCriterion("SecLevel like", value, "seclevel");
            return (Criteria) this;
        }

        public Criteria andSeclevelNotLike(String value) {
            addCriterion("SecLevel not like", value, "seclevel");
            return (Criteria) this;
        }

        public Criteria andSeclevelIn(List<String> values) {
            addCriterion("SecLevel in", values, "seclevel");
            return (Criteria) this;
        }

        public Criteria andSeclevelNotIn(List<String> values) {
            addCriterion("SecLevel not in", values, "seclevel");
            return (Criteria) this;
        }

        public Criteria andSeclevelBetween(String value1, String value2) {
            addCriterion("SecLevel between", value1, value2, "seclevel");
            return (Criteria) this;
        }

        public Criteria andSeclevelNotBetween(String value1, String value2) {
            addCriterion("SecLevel not between", value1, value2, "seclevel");
            return (Criteria) this;
        }

        public Criteria andSecEventtypeIsNull() {
            addCriterion("Sec_EventType is null");
            return (Criteria) this;
        }

        public Criteria andSecEventtypeIsNotNull() {
            addCriterion("Sec_EventType is not null");
            return (Criteria) this;
        }

        public Criteria andSecEventtypeEqualTo(String value) {
            addCriterion("Sec_EventType =", value, "secEventtype");
            return (Criteria) this;
        }

        public Criteria andSecEventtypeNotEqualTo(String value) {
            addCriterion("Sec_EventType <>", value, "secEventtype");
            return (Criteria) this;
        }

        public Criteria andSecEventtypeGreaterThan(String value) {
            addCriterion("Sec_EventType >", value, "secEventtype");
            return (Criteria) this;
        }

        public Criteria andSecEventtypeGreaterThanOrEqualTo(String value) {
            addCriterion("Sec_EventType >=", value, "secEventtype");
            return (Criteria) this;
        }

        public Criteria andSecEventtypeLessThan(String value) {
            addCriterion("Sec_EventType <", value, "secEventtype");
            return (Criteria) this;
        }

        public Criteria andSecEventtypeLessThanOrEqualTo(String value) {
            addCriterion("Sec_EventType <=", value, "secEventtype");
            return (Criteria) this;
        }

        public Criteria andSecEventtypeLike(String value) {
            addCriterion("Sec_EventType like", value, "secEventtype");
            return (Criteria) this;
        }

        public Criteria andSecEventtypeNotLike(String value) {
            addCriterion("Sec_EventType not like", value, "secEventtype");
            return (Criteria) this;
        }

        public Criteria andSecEventtypeIn(List<String> values) {
            addCriterion("Sec_EventType in", values, "secEventtype");
            return (Criteria) this;
        }

        public Criteria andSecEventtypeNotIn(List<String> values) {
            addCriterion("Sec_EventType not in", values, "secEventtype");
            return (Criteria) this;
        }

        public Criteria andSecEventtypeBetween(String value1, String value2) {
            addCriterion("Sec_EventType between", value1, value2, "secEventtype");
            return (Criteria) this;
        }

        public Criteria andSecEventtypeNotBetween(String value1, String value2) {
            addCriterion("Sec_EventType not between", value1, value2, "secEventtype");
            return (Criteria) this;
        }

        public Criteria andSecnumberIsNull() {
            addCriterion("SecNumber is null");
            return (Criteria) this;
        }

        public Criteria andSecnumberIsNotNull() {
            addCriterion("SecNumber is not null");
            return (Criteria) this;
        }

        public Criteria andSecnumberEqualTo(Integer value) {
            addCriterion("SecNumber =", value, "secnumber");
            return (Criteria) this;
        }

        public Criteria andSecnumberNotEqualTo(Integer value) {
            addCriterion("SecNumber <>", value, "secnumber");
            return (Criteria) this;
        }

        public Criteria andSecnumberGreaterThan(Integer value) {
            addCriterion("SecNumber >", value, "secnumber");
            return (Criteria) this;
        }

        public Criteria andSecnumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("SecNumber >=", value, "secnumber");
            return (Criteria) this;
        }

        public Criteria andSecnumberLessThan(Integer value) {
            addCriterion("SecNumber <", value, "secnumber");
            return (Criteria) this;
        }

        public Criteria andSecnumberLessThanOrEqualTo(Integer value) {
            addCriterion("SecNumber <=", value, "secnumber");
            return (Criteria) this;
        }

        public Criteria andSecnumberIn(List<Integer> values) {
            addCriterion("SecNumber in", values, "secnumber");
            return (Criteria) this;
        }

        public Criteria andSecnumberNotIn(List<Integer> values) {
            addCriterion("SecNumber not in", values, "secnumber");
            return (Criteria) this;
        }

        public Criteria andSecnumberBetween(Integer value1, Integer value2) {
            addCriterion("SecNumber between", value1, value2, "secnumber");
            return (Criteria) this;
        }

        public Criteria andSecnumberNotBetween(Integer value1, Integer value2) {
            addCriterion("SecNumber not between", value1, value2, "secnumber");
            return (Criteria) this;
        }

        public Criteria andLineNumIsNull() {
            addCriterion("line_num is null");
            return (Criteria) this;
        }

        public Criteria andLineNumIsNotNull() {
            addCriterion("line_num is not null");
            return (Criteria) this;
        }

        public Criteria andLineNumEqualTo(Integer value) {
            addCriterion("line_num =", value, "lineNum");
            return (Criteria) this;
        }

        public Criteria andLineNumNotEqualTo(Integer value) {
            addCriterion("line_num <>", value, "lineNum");
            return (Criteria) this;
        }

        public Criteria andLineNumGreaterThan(Integer value) {
            addCriterion("line_num >", value, "lineNum");
            return (Criteria) this;
        }

        public Criteria andLineNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("line_num >=", value, "lineNum");
            return (Criteria) this;
        }

        public Criteria andLineNumLessThan(Integer value) {
            addCriterion("line_num <", value, "lineNum");
            return (Criteria) this;
        }

        public Criteria andLineNumLessThanOrEqualTo(Integer value) {
            addCriterion("line_num <=", value, "lineNum");
            return (Criteria) this;
        }

        public Criteria andLineNumIn(List<Integer> values) {
            addCriterion("line_num in", values, "lineNum");
            return (Criteria) this;
        }

        public Criteria andLineNumNotIn(List<Integer> values) {
            addCriterion("line_num not in", values, "lineNum");
            return (Criteria) this;
        }

        public Criteria andLineNumBetween(Integer value1, Integer value2) {
            addCriterion("line_num between", value1, value2, "lineNum");
            return (Criteria) this;
        }

        public Criteria andLineNumNotBetween(Integer value1, Integer value2) {
            addCriterion("line_num not between", value1, value2, "lineNum");
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