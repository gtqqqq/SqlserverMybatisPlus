package com.xkcoding.multi.datasource.mybatis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * @author fnchenxi
 */
public class NotCloseModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NotCloseModelExample() {
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

        public Criteria andNotCloseNumIsNull() {
            addCriterion("not_close_num is null");
            return (Criteria) this;
        }

        public Criteria andNotCloseNumIsNotNull() {
            addCriterion("not_close_num is not null");
            return (Criteria) this;
        }

        public Criteria andNotCloseNumEqualTo(Integer value) {
            addCriterion("not_close_num =", value, "notCloseNum");
            return (Criteria) this;
        }

        public Criteria andNotCloseNumNotEqualTo(Integer value) {
            addCriterion("not_close_num <>", value, "notCloseNum");
            return (Criteria) this;
        }

        public Criteria andNotCloseNumGreaterThan(Integer value) {
            addCriterion("not_close_num >", value, "notCloseNum");
            return (Criteria) this;
        }

        public Criteria andNotCloseNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("not_close_num >=", value, "notCloseNum");
            return (Criteria) this;
        }

        public Criteria andNotCloseNumLessThan(Integer value) {
            addCriterion("not_close_num <", value, "notCloseNum");
            return (Criteria) this;
        }

        public Criteria andNotCloseNumLessThanOrEqualTo(Integer value) {
            addCriterion("not_close_num <=", value, "notCloseNum");
            return (Criteria) this;
        }

        public Criteria andNotCloseNumIn(List<Integer> values) {
            addCriterion("not_close_num in", values, "notCloseNum");
            return (Criteria) this;
        }

        public Criteria andNotCloseNumNotIn(List<Integer> values) {
            addCriterion("not_close_num not in", values, "notCloseNum");
            return (Criteria) this;
        }

        public Criteria andNotCloseNumBetween(Integer value1, Integer value2) {
            addCriterion("not_close_num between", value1, value2, "notCloseNum");
            return (Criteria) this;
        }

        public Criteria andNotCloseNumNotBetween(Integer value1, Integer value2) {
            addCriterion("not_close_num not between", value1, value2, "notCloseNum");
            return (Criteria) this;
        }

        public Criteria andStopNumIsNull() {
            addCriterion("stop_num is null");
            return (Criteria) this;
        }

        public Criteria andStopNumIsNotNull() {
            addCriterion("stop_num is not null");
            return (Criteria) this;
        }

        public Criteria andStopNumEqualTo(Integer value) {
            addCriterion("stop_num =", value, "stopNum");
            return (Criteria) this;
        }

        public Criteria andStopNumNotEqualTo(Integer value) {
            addCriterion("stop_num <>", value, "stopNum");
            return (Criteria) this;
        }

        public Criteria andStopNumGreaterThan(Integer value) {
            addCriterion("stop_num >", value, "stopNum");
            return (Criteria) this;
        }

        public Criteria andStopNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("stop_num >=", value, "stopNum");
            return (Criteria) this;
        }

        public Criteria andStopNumLessThan(Integer value) {
            addCriterion("stop_num <", value, "stopNum");
            return (Criteria) this;
        }

        public Criteria andStopNumLessThanOrEqualTo(Integer value) {
            addCriterion("stop_num <=", value, "stopNum");
            return (Criteria) this;
        }

        public Criteria andStopNumIn(List<Integer> values) {
            addCriterion("stop_num in", values, "stopNum");
            return (Criteria) this;
        }

        public Criteria andStopNumNotIn(List<Integer> values) {
            addCriterion("stop_num not in", values, "stopNum");
            return (Criteria) this;
        }

        public Criteria andStopNumBetween(Integer value1, Integer value2) {
            addCriterion("stop_num between", value1, value2, "stopNum");
            return (Criteria) this;
        }

        public Criteria andStopNumNotBetween(Integer value1, Integer value2) {
            addCriterion("stop_num not between", value1, value2, "stopNum");
            return (Criteria) this;
        }

        public Criteria andOngoingNumIsNull() {
            addCriterion("ongoing_num is null");
            return (Criteria) this;
        }

        public Criteria andOngoingNumIsNotNull() {
            addCriterion("ongoing_num is not null");
            return (Criteria) this;
        }

        public Criteria andOngoingNumEqualTo(Integer value) {
            addCriterion("ongoing_num =", value, "ongoingNum");
            return (Criteria) this;
        }

        public Criteria andOngoingNumNotEqualTo(Integer value) {
            addCriterion("ongoing_num <>", value, "ongoingNum");
            return (Criteria) this;
        }

        public Criteria andOngoingNumGreaterThan(Integer value) {
            addCriterion("ongoing_num >", value, "ongoingNum");
            return (Criteria) this;
        }

        public Criteria andOngoingNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("ongoing_num >=", value, "ongoingNum");
            return (Criteria) this;
        }

        public Criteria andOngoingNumLessThan(Integer value) {
            addCriterion("ongoing_num <", value, "ongoingNum");
            return (Criteria) this;
        }

        public Criteria andOngoingNumLessThanOrEqualTo(Integer value) {
            addCriterion("ongoing_num <=", value, "ongoingNum");
            return (Criteria) this;
        }

        public Criteria andOngoingNumIn(List<Integer> values) {
            addCriterion("ongoing_num in", values, "ongoingNum");
            return (Criteria) this;
        }

        public Criteria andOngoingNumNotIn(List<Integer> values) {
            addCriterion("ongoing_num not in", values, "ongoingNum");
            return (Criteria) this;
        }

        public Criteria andOngoingNumBetween(Integer value1, Integer value2) {
            addCriterion("ongoing_num between", value1, value2, "ongoingNum");
            return (Criteria) this;
        }

        public Criteria andOngoingNumNotBetween(Integer value1, Integer value2) {
            addCriterion("ongoing_num not between", value1, value2, "ongoingNum");
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