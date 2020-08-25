package com.xkcoding.multi.datasource.mybatis.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderUpL2Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderUpL2Example() {
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

        public Criteria andTotalIsNull() {
            addCriterion("total is null");
            return (Criteria) this;
        }

        public Criteria andTotalIsNotNull() {
            addCriterion("total is not null");
            return (Criteria) this;
        }

        public Criteria andTotalEqualTo(Integer value) {
            addCriterion("total =", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotEqualTo(Integer value) {
            addCriterion("total <>", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThan(Integer value) {
            addCriterion("total >", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("total >=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThan(Integer value) {
            addCriterion("total <", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThanOrEqualTo(Integer value) {
            addCriterion("total <=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalIn(List<Integer> values) {
            addCriterion("total in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotIn(List<Integer> values) {
            addCriterion("total not in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalBetween(Integer value1, Integer value2) {
            addCriterion("total between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("total not between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIsNull() {
            addCriterion("order_number is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIsNotNull() {
            addCriterion("order_number is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberEqualTo(Integer value) {
            addCriterion("order_number =", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotEqualTo(Integer value) {
            addCriterion("order_number <>", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThan(Integer value) {
            addCriterion("order_number >", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_number >=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThan(Integer value) {
            addCriterion("order_number <", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThanOrEqualTo(Integer value) {
            addCriterion("order_number <=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIn(List<Integer> values) {
            addCriterion("order_number in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotIn(List<Integer> values) {
            addCriterion("order_number not in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberBetween(Integer value1, Integer value2) {
            addCriterion("order_number between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("order_number not between", value1, value2, "orderNumber");
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

        public Criteria andFteIsNull() {
            addCriterion("FTE is null");
            return (Criteria) this;
        }

        public Criteria andFteIsNotNull() {
            addCriterion("FTE is not null");
            return (Criteria) this;
        }

        public Criteria andFteEqualTo(Integer value) {
            addCriterion("FTE =", value, "fte");
            return (Criteria) this;
        }

        public Criteria andFteNotEqualTo(Integer value) {
            addCriterion("FTE <>", value, "fte");
            return (Criteria) this;
        }

        public Criteria andFteGreaterThan(Integer value) {
            addCriterion("FTE >", value, "fte");
            return (Criteria) this;
        }

        public Criteria andFteGreaterThanOrEqualTo(Integer value) {
            addCriterion("FTE >=", value, "fte");
            return (Criteria) this;
        }

        public Criteria andFteLessThan(Integer value) {
            addCriterion("FTE <", value, "fte");
            return (Criteria) this;
        }

        public Criteria andFteLessThanOrEqualTo(Integer value) {
            addCriterion("FTE <=", value, "fte");
            return (Criteria) this;
        }

        public Criteria andFteIn(List<Integer> values) {
            addCriterion("FTE in", values, "fte");
            return (Criteria) this;
        }

        public Criteria andFteNotIn(List<Integer> values) {
            addCriterion("FTE not in", values, "fte");
            return (Criteria) this;
        }

        public Criteria andFteBetween(Integer value1, Integer value2) {
            addCriterion("FTE between", value1, value2, "fte");
            return (Criteria) this;
        }

        public Criteria andFteNotBetween(Integer value1, Integer value2) {
            addCriterion("FTE not between", value1, value2, "fte");
            return (Criteria) this;
        }

        public Criteria andAvgTicketsIsNull() {
            addCriterion("AVG_Tickets is null");
            return (Criteria) this;
        }

        public Criteria andAvgTicketsIsNotNull() {
            addCriterion("AVG_Tickets is not null");
            return (Criteria) this;
        }

        public Criteria andAvgTicketsEqualTo(Integer value) {
            addCriterion("AVG_Tickets =", value, "avgTickets");
            return (Criteria) this;
        }

        public Criteria andAvgTicketsNotEqualTo(Integer value) {
            addCriterion("AVG_Tickets <>", value, "avgTickets");
            return (Criteria) this;
        }

        public Criteria andAvgTicketsGreaterThan(Integer value) {
            addCriterion("AVG_Tickets >", value, "avgTickets");
            return (Criteria) this;
        }

        public Criteria andAvgTicketsGreaterThanOrEqualTo(Integer value) {
            addCriterion("AVG_Tickets >=", value, "avgTickets");
            return (Criteria) this;
        }

        public Criteria andAvgTicketsLessThan(Integer value) {
            addCriterion("AVG_Tickets <", value, "avgTickets");
            return (Criteria) this;
        }

        public Criteria andAvgTicketsLessThanOrEqualTo(Integer value) {
            addCriterion("AVG_Tickets <=", value, "avgTickets");
            return (Criteria) this;
        }

        public Criteria andAvgTicketsIn(List<Integer> values) {
            addCriterion("AVG_Tickets in", values, "avgTickets");
            return (Criteria) this;
        }

        public Criteria andAvgTicketsNotIn(List<Integer> values) {
            addCriterion("AVG_Tickets not in", values, "avgTickets");
            return (Criteria) this;
        }

        public Criteria andAvgTicketsBetween(Integer value1, Integer value2) {
            addCriterion("AVG_Tickets between", value1, value2, "avgTickets");
            return (Criteria) this;
        }

        public Criteria andAvgTicketsNotBetween(Integer value1, Integer value2) {
            addCriterion("AVG_Tickets not between", value1, value2, "avgTickets");
            return (Criteria) this;
        }

        public Criteria andRespondedTicketsIsNull() {
            addCriterion("Responded_Tickets is null");
            return (Criteria) this;
        }

        public Criteria andRespondedTicketsIsNotNull() {
            addCriterion("Responded_Tickets is not null");
            return (Criteria) this;
        }

        public Criteria andRespondedTicketsEqualTo(Integer value) {
            addCriterion("Responded_Tickets =", value, "respondedTickets");
            return (Criteria) this;
        }

        public Criteria andRespondedTicketsNotEqualTo(Integer value) {
            addCriterion("Responded_Tickets <>", value, "respondedTickets");
            return (Criteria) this;
        }

        public Criteria andRespondedTicketsGreaterThan(Integer value) {
            addCriterion("Responded_Tickets >", value, "respondedTickets");
            return (Criteria) this;
        }

        public Criteria andRespondedTicketsGreaterThanOrEqualTo(Integer value) {
            addCriterion("Responded_Tickets >=", value, "respondedTickets");
            return (Criteria) this;
        }

        public Criteria andRespondedTicketsLessThan(Integer value) {
            addCriterion("Responded_Tickets <", value, "respondedTickets");
            return (Criteria) this;
        }

        public Criteria andRespondedTicketsLessThanOrEqualTo(Integer value) {
            addCriterion("Responded_Tickets <=", value, "respondedTickets");
            return (Criteria) this;
        }

        public Criteria andRespondedTicketsIn(List<Integer> values) {
            addCriterion("Responded_Tickets in", values, "respondedTickets");
            return (Criteria) this;
        }

        public Criteria andRespondedTicketsNotIn(List<Integer> values) {
            addCriterion("Responded_Tickets not in", values, "respondedTickets");
            return (Criteria) this;
        }

        public Criteria andRespondedTicketsBetween(Integer value1, Integer value2) {
            addCriterion("Responded_Tickets between", value1, value2, "respondedTickets");
            return (Criteria) this;
        }

        public Criteria andRespondedTicketsNotBetween(Integer value1, Integer value2) {
            addCriterion("Responded_Tickets not between", value1, value2, "respondedTickets");
            return (Criteria) this;
        }

        public Criteria andEscalationTicketsIsNull() {
            addCriterion("Escalation_Tickets is null");
            return (Criteria) this;
        }

        public Criteria andEscalationTicketsIsNotNull() {
            addCriterion("Escalation_Tickets is not null");
            return (Criteria) this;
        }

        public Criteria andEscalationTicketsEqualTo(BigDecimal value) {
            addCriterion("Escalation_Tickets =", value, "escalationTickets");
            return (Criteria) this;
        }

        public Criteria andEscalationTicketsNotEqualTo(BigDecimal value) {
            addCriterion("Escalation_Tickets <>", value, "escalationTickets");
            return (Criteria) this;
        }

        public Criteria andEscalationTicketsGreaterThan(BigDecimal value) {
            addCriterion("Escalation_Tickets >", value, "escalationTickets");
            return (Criteria) this;
        }

        public Criteria andEscalationTicketsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Escalation_Tickets >=", value, "escalationTickets");
            return (Criteria) this;
        }

        public Criteria andEscalationTicketsLessThan(BigDecimal value) {
            addCriterion("Escalation_Tickets <", value, "escalationTickets");
            return (Criteria) this;
        }

        public Criteria andEscalationTicketsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("Escalation_Tickets <=", value, "escalationTickets");
            return (Criteria) this;
        }

        public Criteria andEscalationTicketsIn(List<BigDecimal> values) {
            addCriterion("Escalation_Tickets in", values, "escalationTickets");
            return (Criteria) this;
        }

        public Criteria andEscalationTicketsNotIn(List<BigDecimal> values) {
            addCriterion("Escalation_Tickets not in", values, "escalationTickets");
            return (Criteria) this;
        }

        public Criteria andEscalationTicketsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Escalation_Tickets between", value1, value2, "escalationTickets");
            return (Criteria) this;
        }

        public Criteria andEscalationTicketsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Escalation_Tickets not between", value1, value2, "escalationTickets");
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