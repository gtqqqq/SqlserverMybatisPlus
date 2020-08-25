package com.xkcoding.multi.datasource.mybatis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * @author fnchenxi
 */
public class L3TeamTicket3Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public L3TeamTicket3Example() {
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

        public Criteria andTotalTicketsIsNull() {
            addCriterion("total_tickets is null");
            return (Criteria) this;
        }

        public Criteria andTotalTicketsIsNotNull() {
            addCriterion("total_tickets is not null");
            return (Criteria) this;
        }

        public Criteria andTotalTicketsEqualTo(Integer value) {
            addCriterion("total_tickets =", value, "totalTickets");
            return (Criteria) this;
        }

        public Criteria andTotalTicketsNotEqualTo(Integer value) {
            addCriterion("total_tickets <>", value, "totalTickets");
            return (Criteria) this;
        }

        public Criteria andTotalTicketsGreaterThan(Integer value) {
            addCriterion("total_tickets >", value, "totalTickets");
            return (Criteria) this;
        }

        public Criteria andTotalTicketsGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_tickets >=", value, "totalTickets");
            return (Criteria) this;
        }

        public Criteria andTotalTicketsLessThan(Integer value) {
            addCriterion("total_tickets <", value, "totalTickets");
            return (Criteria) this;
        }

        public Criteria andTotalTicketsLessThanOrEqualTo(Integer value) {
            addCriterion("total_tickets <=", value, "totalTickets");
            return (Criteria) this;
        }

        public Criteria andTotalTicketsIn(List<Integer> values) {
            addCriterion("total_tickets in", values, "totalTickets");
            return (Criteria) this;
        }

        public Criteria andTotalTicketsNotIn(List<Integer> values) {
            addCriterion("total_tickets not in", values, "totalTickets");
            return (Criteria) this;
        }

        public Criteria andTotalTicketsBetween(Integer value1, Integer value2) {
            addCriterion("total_tickets between", value1, value2, "totalTickets");
            return (Criteria) this;
        }

        public Criteria andTotalTicketsNotBetween(Integer value1, Integer value2) {
            addCriterion("total_tickets not between", value1, value2, "totalTickets");
            return (Criteria) this;
        }

        public Criteria andClosedTicketsIsNull() {
            addCriterion("closed_tickets is null");
            return (Criteria) this;
        }

        public Criteria andClosedTicketsIsNotNull() {
            addCriterion("closed_tickets is not null");
            return (Criteria) this;
        }

        public Criteria andClosedTicketsEqualTo(Integer value) {
            addCriterion("closed_tickets =", value, "closedTickets");
            return (Criteria) this;
        }

        public Criteria andClosedTicketsNotEqualTo(Integer value) {
            addCriterion("closed_tickets <>", value, "closedTickets");
            return (Criteria) this;
        }

        public Criteria andClosedTicketsGreaterThan(Integer value) {
            addCriterion("closed_tickets >", value, "closedTickets");
            return (Criteria) this;
        }

        public Criteria andClosedTicketsGreaterThanOrEqualTo(Integer value) {
            addCriterion("closed_tickets >=", value, "closedTickets");
            return (Criteria) this;
        }

        public Criteria andClosedTicketsLessThan(Integer value) {
            addCriterion("closed_tickets <", value, "closedTickets");
            return (Criteria) this;
        }

        public Criteria andClosedTicketsLessThanOrEqualTo(Integer value) {
            addCriterion("closed_tickets <=", value, "closedTickets");
            return (Criteria) this;
        }

        public Criteria andClosedTicketsIn(List<Integer> values) {
            addCriterion("closed_tickets in", values, "closedTickets");
            return (Criteria) this;
        }

        public Criteria andClosedTicketsNotIn(List<Integer> values) {
            addCriterion("closed_tickets not in", values, "closedTickets");
            return (Criteria) this;
        }

        public Criteria andClosedTicketsBetween(Integer value1, Integer value2) {
            addCriterion("closed_tickets between", value1, value2, "closedTickets");
            return (Criteria) this;
        }

        public Criteria andClosedTicketsNotBetween(Integer value1, Integer value2) {
            addCriterion("closed_tickets not between", value1, value2, "closedTickets");
            return (Criteria) this;
        }

        public Criteria andPendingTicketsIsNull() {
            addCriterion("pending_tickets is null");
            return (Criteria) this;
        }

        public Criteria andPendingTicketsIsNotNull() {
            addCriterion("pending_tickets is not null");
            return (Criteria) this;
        }

        public Criteria andPendingTicketsEqualTo(Integer value) {
            addCriterion("pending_tickets =", value, "pendingTickets");
            return (Criteria) this;
        }

        public Criteria andPendingTicketsNotEqualTo(Integer value) {
            addCriterion("pending_tickets <>", value, "pendingTickets");
            return (Criteria) this;
        }

        public Criteria andPendingTicketsGreaterThan(Integer value) {
            addCriterion("pending_tickets >", value, "pendingTickets");
            return (Criteria) this;
        }

        public Criteria andPendingTicketsGreaterThanOrEqualTo(Integer value) {
            addCriterion("pending_tickets >=", value, "pendingTickets");
            return (Criteria) this;
        }

        public Criteria andPendingTicketsLessThan(Integer value) {
            addCriterion("pending_tickets <", value, "pendingTickets");
            return (Criteria) this;
        }

        public Criteria andPendingTicketsLessThanOrEqualTo(Integer value) {
            addCriterion("pending_tickets <=", value, "pendingTickets");
            return (Criteria) this;
        }

        public Criteria andPendingTicketsIn(List<Integer> values) {
            addCriterion("pending_tickets in", values, "pendingTickets");
            return (Criteria) this;
        }

        public Criteria andPendingTicketsNotIn(List<Integer> values) {
            addCriterion("pending_tickets not in", values, "pendingTickets");
            return (Criteria) this;
        }

        public Criteria andPendingTicketsBetween(Integer value1, Integer value2) {
            addCriterion("pending_tickets between", value1, value2, "pendingTickets");
            return (Criteria) this;
        }

        public Criteria andPendingTicketsNotBetween(Integer value1, Integer value2) {
            addCriterion("pending_tickets not between", value1, value2, "pendingTickets");
            return (Criteria) this;
        }

        public Criteria andWaitingTicketsIsNull() {
            addCriterion("waiting_tickets is null");
            return (Criteria) this;
        }

        public Criteria andWaitingTicketsIsNotNull() {
            addCriterion("waiting_tickets is not null");
            return (Criteria) this;
        }

        public Criteria andWaitingTicketsEqualTo(Integer value) {
            addCriterion("waiting_tickets =", value, "waitingTickets");
            return (Criteria) this;
        }

        public Criteria andWaitingTicketsNotEqualTo(Integer value) {
            addCriterion("waiting_tickets <>", value, "waitingTickets");
            return (Criteria) this;
        }

        public Criteria andWaitingTicketsGreaterThan(Integer value) {
            addCriterion("waiting_tickets >", value, "waitingTickets");
            return (Criteria) this;
        }

        public Criteria andWaitingTicketsGreaterThanOrEqualTo(Integer value) {
            addCriterion("waiting_tickets >=", value, "waitingTickets");
            return (Criteria) this;
        }

        public Criteria andWaitingTicketsLessThan(Integer value) {
            addCriterion("waiting_tickets <", value, "waitingTickets");
            return (Criteria) this;
        }

        public Criteria andWaitingTicketsLessThanOrEqualTo(Integer value) {
            addCriterion("waiting_tickets <=", value, "waitingTickets");
            return (Criteria) this;
        }

        public Criteria andWaitingTicketsIn(List<Integer> values) {
            addCriterion("waiting_tickets in", values, "waitingTickets");
            return (Criteria) this;
        }

        public Criteria andWaitingTicketsNotIn(List<Integer> values) {
            addCriterion("waiting_tickets not in", values, "waitingTickets");
            return (Criteria) this;
        }

        public Criteria andWaitingTicketsBetween(Integer value1, Integer value2) {
            addCriterion("waiting_tickets between", value1, value2, "waitingTickets");
            return (Criteria) this;
        }

        public Criteria andWaitingTicketsNotBetween(Integer value1, Integer value2) {
            addCriterion("waiting_tickets not between", value1, value2, "waitingTickets");
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