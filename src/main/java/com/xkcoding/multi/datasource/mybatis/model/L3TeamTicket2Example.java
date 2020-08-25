package com.xkcoding.multi.datasource.mybatis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * @author fnchenxi
 */
public class L3TeamTicket2Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public L3TeamTicket2Example() {
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

        public Criteria andAvgHandledTimeIsNull() {
            addCriterion("avg_handled_time is null");
            return (Criteria) this;
        }

        public Criteria andAvgHandledTimeIsNotNull() {
            addCriterion("avg_handled_time is not null");
            return (Criteria) this;
        }

        public Criteria andAvgHandledTimeEqualTo(Date value) {
            addCriterion("avg_handled_time =", value, "avgHandledTime");
            return (Criteria) this;
        }

        public Criteria andAvgHandledTimeNotEqualTo(Date value) {
            addCriterion("avg_handled_time <>", value, "avgHandledTime");
            return (Criteria) this;
        }

        public Criteria andAvgHandledTimeGreaterThan(Date value) {
            addCriterion("avg_handled_time >", value, "avgHandledTime");
            return (Criteria) this;
        }

        public Criteria andAvgHandledTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("avg_handled_time >=", value, "avgHandledTime");
            return (Criteria) this;
        }

        public Criteria andAvgHandledTimeLessThan(Date value) {
            addCriterion("avg_handled_time <", value, "avgHandledTime");
            return (Criteria) this;
        }

        public Criteria andAvgHandledTimeLessThanOrEqualTo(Date value) {
            addCriterion("avg_handled_time <=", value, "avgHandledTime");
            return (Criteria) this;
        }

        public Criteria andAvgHandledTimeIn(List<Date> values) {
            addCriterion("avg_handled_time in", values, "avgHandledTime");
            return (Criteria) this;
        }

        public Criteria andAvgHandledTimeNotIn(List<Date> values) {
            addCriterion("avg_handled_time not in", values, "avgHandledTime");
            return (Criteria) this;
        }

        public Criteria andAvgHandledTimeBetween(Date value1, Date value2) {
            addCriterion("avg_handled_time between", value1, value2, "avgHandledTime");
            return (Criteria) this;
        }

        public Criteria andAvgHandledTimeNotBetween(Date value1, Date value2) {
            addCriterion("avg_handled_time not between", value1, value2, "avgHandledTime");
            return (Criteria) this;
        }

        public Criteria andAvgWaitTimeIsNull() {
            addCriterion("avg_wait_time is null");
            return (Criteria) this;
        }

        public Criteria andAvgWaitTimeIsNotNull() {
            addCriterion("avg_wait_time is not null");
            return (Criteria) this;
        }

        public Criteria andAvgWaitTimeEqualTo(Date value) {
            addCriterion("avg_wait_time =", value, "avgWaitTime");
            return (Criteria) this;
        }

        public Criteria andAvgWaitTimeNotEqualTo(Date value) {
            addCriterion("avg_wait_time <>", value, "avgWaitTime");
            return (Criteria) this;
        }

        public Criteria andAvgWaitTimeGreaterThan(Date value) {
            addCriterion("avg_wait_time >", value, "avgWaitTime");
            return (Criteria) this;
        }

        public Criteria andAvgWaitTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("avg_wait_time >=", value, "avgWaitTime");
            return (Criteria) this;
        }

        public Criteria andAvgWaitTimeLessThan(Date value) {
            addCriterion("avg_wait_time <", value, "avgWaitTime");
            return (Criteria) this;
        }

        public Criteria andAvgWaitTimeLessThanOrEqualTo(Date value) {
            addCriterion("avg_wait_time <=", value, "avgWaitTime");
            return (Criteria) this;
        }

        public Criteria andAvgWaitTimeIn(List<Date> values) {
            addCriterion("avg_wait_time in", values, "avgWaitTime");
            return (Criteria) this;
        }

        public Criteria andAvgWaitTimeNotIn(List<Date> values) {
            addCriterion("avg_wait_time not in", values, "avgWaitTime");
            return (Criteria) this;
        }

        public Criteria andAvgWaitTimeBetween(Date value1, Date value2) {
            addCriterion("avg_wait_time between", value1, value2, "avgWaitTime");
            return (Criteria) this;
        }

        public Criteria andAvgWaitTimeNotBetween(Date value1, Date value2) {
            addCriterion("avg_wait_time not between", value1, value2, "avgWaitTime");
            return (Criteria) this;
        }

        public Criteria andMaxProcessingTimeIsNull() {
            addCriterion("max_processing_time is null");
            return (Criteria) this;
        }

        public Criteria andMaxProcessingTimeIsNotNull() {
            addCriterion("max_processing_time is not null");
            return (Criteria) this;
        }

        public Criteria andMaxProcessingTimeEqualTo(Date value) {
            addCriterion("max_processing_time =", value, "maxProcessingTime");
            return (Criteria) this;
        }

        public Criteria andMaxProcessingTimeNotEqualTo(Date value) {
            addCriterion("max_processing_time <>", value, "maxProcessingTime");
            return (Criteria) this;
        }

        public Criteria andMaxProcessingTimeGreaterThan(Date value) {
            addCriterion("max_processing_time >", value, "maxProcessingTime");
            return (Criteria) this;
        }

        public Criteria andMaxProcessingTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("max_processing_time >=", value, "maxProcessingTime");
            return (Criteria) this;
        }

        public Criteria andMaxProcessingTimeLessThan(Date value) {
            addCriterion("max_processing_time <", value, "maxProcessingTime");
            return (Criteria) this;
        }

        public Criteria andMaxProcessingTimeLessThanOrEqualTo(Date value) {
            addCriterion("max_processing_time <=", value, "maxProcessingTime");
            return (Criteria) this;
        }

        public Criteria andMaxProcessingTimeIn(List<Date> values) {
            addCriterion("max_processing_time in", values, "maxProcessingTime");
            return (Criteria) this;
        }

        public Criteria andMaxProcessingTimeNotIn(List<Date> values) {
            addCriterion("max_processing_time not in", values, "maxProcessingTime");
            return (Criteria) this;
        }

        public Criteria andMaxProcessingTimeBetween(Date value1, Date value2) {
            addCriterion("max_processing_time between", value1, value2, "maxProcessingTime");
            return (Criteria) this;
        }

        public Criteria andMaxProcessingTimeNotBetween(Date value1, Date value2) {
            addCriterion("max_processing_time not between", value1, value2, "maxProcessingTime");
            return (Criteria) this;
        }

        public Criteria andMaxWaitTimeIsNull() {
            addCriterion("max_wait_time is null");
            return (Criteria) this;
        }

        public Criteria andMaxWaitTimeIsNotNull() {
            addCriterion("max_wait_time is not null");
            return (Criteria) this;
        }

        public Criteria andMaxWaitTimeEqualTo(Date value) {
            addCriterion("max_wait_time =", value, "maxWaitTime");
            return (Criteria) this;
        }

        public Criteria andMaxWaitTimeNotEqualTo(Date value) {
            addCriterion("max_wait_time <>", value, "maxWaitTime");
            return (Criteria) this;
        }

        public Criteria andMaxWaitTimeGreaterThan(Date value) {
            addCriterion("max_wait_time >", value, "maxWaitTime");
            return (Criteria) this;
        }

        public Criteria andMaxWaitTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("max_wait_time >=", value, "maxWaitTime");
            return (Criteria) this;
        }

        public Criteria andMaxWaitTimeLessThan(Date value) {
            addCriterion("max_wait_time <", value, "maxWaitTime");
            return (Criteria) this;
        }

        public Criteria andMaxWaitTimeLessThanOrEqualTo(Date value) {
            addCriterion("max_wait_time <=", value, "maxWaitTime");
            return (Criteria) this;
        }

        public Criteria andMaxWaitTimeIn(List<Date> values) {
            addCriterion("max_wait_time in", values, "maxWaitTime");
            return (Criteria) this;
        }

        public Criteria andMaxWaitTimeNotIn(List<Date> values) {
            addCriterion("max_wait_time not in", values, "maxWaitTime");
            return (Criteria) this;
        }

        public Criteria andMaxWaitTimeBetween(Date value1, Date value2) {
            addCriterion("max_wait_time between", value1, value2, "maxWaitTime");
            return (Criteria) this;
        }

        public Criteria andMaxWaitTimeNotBetween(Date value1, Date value2) {
            addCriterion("max_wait_time not between", value1, value2, "maxWaitTime");
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