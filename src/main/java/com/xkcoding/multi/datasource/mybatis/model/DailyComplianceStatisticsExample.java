package com.xkcoding.multi.datasource.mybatis.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DailyComplianceStatisticsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DailyComplianceStatisticsExample() {
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

        public Criteria andWorkAverageIsNull() {
            addCriterion("work_average is null");
            return (Criteria) this;
        }

        public Criteria andWorkAverageIsNotNull() {
            addCriterion("work_average is not null");
            return (Criteria) this;
        }

        public Criteria andWorkAverageEqualTo(BigDecimal value) {
            addCriterion("work_average =", value, "workAverage");
            return (Criteria) this;
        }

        public Criteria andWorkAverageNotEqualTo(BigDecimal value) {
            addCriterion("work_average <>", value, "workAverage");
            return (Criteria) this;
        }

        public Criteria andWorkAverageGreaterThan(BigDecimal value) {
            addCriterion("work_average >", value, "workAverage");
            return (Criteria) this;
        }

        public Criteria andWorkAverageGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("work_average >=", value, "workAverage");
            return (Criteria) this;
        }

        public Criteria andWorkAverageLessThan(BigDecimal value) {
            addCriterion("work_average <", value, "workAverage");
            return (Criteria) this;
        }

        public Criteria andWorkAverageLessThanOrEqualTo(BigDecimal value) {
            addCriterion("work_average <=", value, "workAverage");
            return (Criteria) this;
        }

        public Criteria andWorkAverageIn(List<BigDecimal> values) {
            addCriterion("work_average in", values, "workAverage");
            return (Criteria) this;
        }

        public Criteria andWorkAverageNotIn(List<BigDecimal> values) {
            addCriterion("work_average not in", values, "workAverage");
            return (Criteria) this;
        }

        public Criteria andWorkAverageBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("work_average between", value1, value2, "workAverage");
            return (Criteria) this;
        }

        public Criteria andWorkAverageNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("work_average not between", value1, value2, "workAverage");
            return (Criteria) this;
        }

        public Criteria andAllAverageIsNull() {
            addCriterion("all_average is null");
            return (Criteria) this;
        }

        public Criteria andAllAverageIsNotNull() {
            addCriterion("all_average is not null");
            return (Criteria) this;
        }

        public Criteria andAllAverageEqualTo(BigDecimal value) {
            addCriterion("all_average =", value, "allAverage");
            return (Criteria) this;
        }

        public Criteria andAllAverageNotEqualTo(BigDecimal value) {
            addCriterion("all_average <>", value, "allAverage");
            return (Criteria) this;
        }

        public Criteria andAllAverageGreaterThan(BigDecimal value) {
            addCriterion("all_average >", value, "allAverage");
            return (Criteria) this;
        }

        public Criteria andAllAverageGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("all_average >=", value, "allAverage");
            return (Criteria) this;
        }

        public Criteria andAllAverageLessThan(BigDecimal value) {
            addCriterion("all_average <", value, "allAverage");
            return (Criteria) this;
        }

        public Criteria andAllAverageLessThanOrEqualTo(BigDecimal value) {
            addCriterion("all_average <=", value, "allAverage");
            return (Criteria) this;
        }

        public Criteria andAllAverageIn(List<BigDecimal> values) {
            addCriterion("all_average in", values, "allAverage");
            return (Criteria) this;
        }

        public Criteria andAllAverageNotIn(List<BigDecimal> values) {
            addCriterion("all_average not in", values, "allAverage");
            return (Criteria) this;
        }

        public Criteria andAllAverageBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("all_average between", value1, value2, "allAverage");
            return (Criteria) this;
        }

        public Criteria andAllAverageNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("all_average not between", value1, value2, "allAverage");
            return (Criteria) this;
        }

        public Criteria andHour0OkIsNull() {
            addCriterion("hour_0_ok is null");
            return (Criteria) this;
        }

        public Criteria andHour0OkIsNotNull() {
            addCriterion("hour_0_ok is not null");
            return (Criteria) this;
        }

        public Criteria andHour0OkEqualTo(BigDecimal value) {
            addCriterion("hour_0_ok =", value, "hour0Ok");
            return (Criteria) this;
        }

        public Criteria andHour0OkNotEqualTo(BigDecimal value) {
            addCriterion("hour_0_ok <>", value, "hour0Ok");
            return (Criteria) this;
        }

        public Criteria andHour0OkGreaterThan(BigDecimal value) {
            addCriterion("hour_0_ok >", value, "hour0Ok");
            return (Criteria) this;
        }

        public Criteria andHour0OkGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_0_ok >=", value, "hour0Ok");
            return (Criteria) this;
        }

        public Criteria andHour0OkLessThan(BigDecimal value) {
            addCriterion("hour_0_ok <", value, "hour0Ok");
            return (Criteria) this;
        }

        public Criteria andHour0OkLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_0_ok <=", value, "hour0Ok");
            return (Criteria) this;
        }

        public Criteria andHour0OkIn(List<BigDecimal> values) {
            addCriterion("hour_0_ok in", values, "hour0Ok");
            return (Criteria) this;
        }

        public Criteria andHour0OkNotIn(List<BigDecimal> values) {
            addCriterion("hour_0_ok not in", values, "hour0Ok");
            return (Criteria) this;
        }

        public Criteria andHour0OkBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_0_ok between", value1, value2, "hour0Ok");
            return (Criteria) this;
        }

        public Criteria andHour0OkNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_0_ok not between", value1, value2, "hour0Ok");
            return (Criteria) this;
        }

        public Criteria andHour0AllIsNull() {
            addCriterion("hour_0_all is null");
            return (Criteria) this;
        }

        public Criteria andHour0AllIsNotNull() {
            addCriterion("hour_0_all is not null");
            return (Criteria) this;
        }

        public Criteria andHour0AllEqualTo(BigDecimal value) {
            addCriterion("hour_0_all =", value, "hour0All");
            return (Criteria) this;
        }

        public Criteria andHour0AllNotEqualTo(BigDecimal value) {
            addCriterion("hour_0_all <>", value, "hour0All");
            return (Criteria) this;
        }

        public Criteria andHour0AllGreaterThan(BigDecimal value) {
            addCriterion("hour_0_all >", value, "hour0All");
            return (Criteria) this;
        }

        public Criteria andHour0AllGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_0_all >=", value, "hour0All");
            return (Criteria) this;
        }

        public Criteria andHour0AllLessThan(BigDecimal value) {
            addCriterion("hour_0_all <", value, "hour0All");
            return (Criteria) this;
        }

        public Criteria andHour0AllLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_0_all <=", value, "hour0All");
            return (Criteria) this;
        }

        public Criteria andHour0AllIn(List<BigDecimal> values) {
            addCriterion("hour_0_all in", values, "hour0All");
            return (Criteria) this;
        }

        public Criteria andHour0AllNotIn(List<BigDecimal> values) {
            addCriterion("hour_0_all not in", values, "hour0All");
            return (Criteria) this;
        }

        public Criteria andHour0AllBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_0_all between", value1, value2, "hour0All");
            return (Criteria) this;
        }

        public Criteria andHour0AllNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_0_all not between", value1, value2, "hour0All");
            return (Criteria) this;
        }

        public Criteria andHour1OkIsNull() {
            addCriterion("hour_1_ok is null");
            return (Criteria) this;
        }

        public Criteria andHour1OkIsNotNull() {
            addCriterion("hour_1_ok is not null");
            return (Criteria) this;
        }

        public Criteria andHour1OkEqualTo(BigDecimal value) {
            addCriterion("hour_1_ok =", value, "hour1Ok");
            return (Criteria) this;
        }

        public Criteria andHour1OkNotEqualTo(BigDecimal value) {
            addCriterion("hour_1_ok <>", value, "hour1Ok");
            return (Criteria) this;
        }

        public Criteria andHour1OkGreaterThan(BigDecimal value) {
            addCriterion("hour_1_ok >", value, "hour1Ok");
            return (Criteria) this;
        }

        public Criteria andHour1OkGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_1_ok >=", value, "hour1Ok");
            return (Criteria) this;
        }

        public Criteria andHour1OkLessThan(BigDecimal value) {
            addCriterion("hour_1_ok <", value, "hour1Ok");
            return (Criteria) this;
        }

        public Criteria andHour1OkLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_1_ok <=", value, "hour1Ok");
            return (Criteria) this;
        }

        public Criteria andHour1OkIn(List<BigDecimal> values) {
            addCriterion("hour_1_ok in", values, "hour1Ok");
            return (Criteria) this;
        }

        public Criteria andHour1OkNotIn(List<BigDecimal> values) {
            addCriterion("hour_1_ok not in", values, "hour1Ok");
            return (Criteria) this;
        }

        public Criteria andHour1OkBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_1_ok between", value1, value2, "hour1Ok");
            return (Criteria) this;
        }

        public Criteria andHour1OkNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_1_ok not between", value1, value2, "hour1Ok");
            return (Criteria) this;
        }

        public Criteria andHour1AllIsNull() {
            addCriterion("hour_1_all is null");
            return (Criteria) this;
        }

        public Criteria andHour1AllIsNotNull() {
            addCriterion("hour_1_all is not null");
            return (Criteria) this;
        }

        public Criteria andHour1AllEqualTo(BigDecimal value) {
            addCriterion("hour_1_all =", value, "hour1All");
            return (Criteria) this;
        }

        public Criteria andHour1AllNotEqualTo(BigDecimal value) {
            addCriterion("hour_1_all <>", value, "hour1All");
            return (Criteria) this;
        }

        public Criteria andHour1AllGreaterThan(BigDecimal value) {
            addCriterion("hour_1_all >", value, "hour1All");
            return (Criteria) this;
        }

        public Criteria andHour1AllGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_1_all >=", value, "hour1All");
            return (Criteria) this;
        }

        public Criteria andHour1AllLessThan(BigDecimal value) {
            addCriterion("hour_1_all <", value, "hour1All");
            return (Criteria) this;
        }

        public Criteria andHour1AllLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_1_all <=", value, "hour1All");
            return (Criteria) this;
        }

        public Criteria andHour1AllIn(List<BigDecimal> values) {
            addCriterion("hour_1_all in", values, "hour1All");
            return (Criteria) this;
        }

        public Criteria andHour1AllNotIn(List<BigDecimal> values) {
            addCriterion("hour_1_all not in", values, "hour1All");
            return (Criteria) this;
        }

        public Criteria andHour1AllBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_1_all between", value1, value2, "hour1All");
            return (Criteria) this;
        }

        public Criteria andHour1AllNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_1_all not between", value1, value2, "hour1All");
            return (Criteria) this;
        }

        public Criteria andHour2OkIsNull() {
            addCriterion("hour_2_ok is null");
            return (Criteria) this;
        }

        public Criteria andHour2OkIsNotNull() {
            addCriterion("hour_2_ok is not null");
            return (Criteria) this;
        }

        public Criteria andHour2OkEqualTo(BigDecimal value) {
            addCriterion("hour_2_ok =", value, "hour2Ok");
            return (Criteria) this;
        }

        public Criteria andHour2OkNotEqualTo(BigDecimal value) {
            addCriterion("hour_2_ok <>", value, "hour2Ok");
            return (Criteria) this;
        }

        public Criteria andHour2OkGreaterThan(BigDecimal value) {
            addCriterion("hour_2_ok >", value, "hour2Ok");
            return (Criteria) this;
        }

        public Criteria andHour2OkGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_2_ok >=", value, "hour2Ok");
            return (Criteria) this;
        }

        public Criteria andHour2OkLessThan(BigDecimal value) {
            addCriterion("hour_2_ok <", value, "hour2Ok");
            return (Criteria) this;
        }

        public Criteria andHour2OkLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_2_ok <=", value, "hour2Ok");
            return (Criteria) this;
        }

        public Criteria andHour2OkIn(List<BigDecimal> values) {
            addCriterion("hour_2_ok in", values, "hour2Ok");
            return (Criteria) this;
        }

        public Criteria andHour2OkNotIn(List<BigDecimal> values) {
            addCriterion("hour_2_ok not in", values, "hour2Ok");
            return (Criteria) this;
        }

        public Criteria andHour2OkBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_2_ok between", value1, value2, "hour2Ok");
            return (Criteria) this;
        }

        public Criteria andHour2OkNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_2_ok not between", value1, value2, "hour2Ok");
            return (Criteria) this;
        }

        public Criteria andHour2AllIsNull() {
            addCriterion("hour_2_all is null");
            return (Criteria) this;
        }

        public Criteria andHour2AllIsNotNull() {
            addCriterion("hour_2_all is not null");
            return (Criteria) this;
        }

        public Criteria andHour2AllEqualTo(BigDecimal value) {
            addCriterion("hour_2_all =", value, "hour2All");
            return (Criteria) this;
        }

        public Criteria andHour2AllNotEqualTo(BigDecimal value) {
            addCriterion("hour_2_all <>", value, "hour2All");
            return (Criteria) this;
        }

        public Criteria andHour2AllGreaterThan(BigDecimal value) {
            addCriterion("hour_2_all >", value, "hour2All");
            return (Criteria) this;
        }

        public Criteria andHour2AllGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_2_all >=", value, "hour2All");
            return (Criteria) this;
        }

        public Criteria andHour2AllLessThan(BigDecimal value) {
            addCriterion("hour_2_all <", value, "hour2All");
            return (Criteria) this;
        }

        public Criteria andHour2AllLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_2_all <=", value, "hour2All");
            return (Criteria) this;
        }

        public Criteria andHour2AllIn(List<BigDecimal> values) {
            addCriterion("hour_2_all in", values, "hour2All");
            return (Criteria) this;
        }

        public Criteria andHour2AllNotIn(List<BigDecimal> values) {
            addCriterion("hour_2_all not in", values, "hour2All");
            return (Criteria) this;
        }

        public Criteria andHour2AllBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_2_all between", value1, value2, "hour2All");
            return (Criteria) this;
        }

        public Criteria andHour2AllNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_2_all not between", value1, value2, "hour2All");
            return (Criteria) this;
        }

        public Criteria andHour3OkIsNull() {
            addCriterion("hour_3_ok is null");
            return (Criteria) this;
        }

        public Criteria andHour3OkIsNotNull() {
            addCriterion("hour_3_ok is not null");
            return (Criteria) this;
        }

        public Criteria andHour3OkEqualTo(BigDecimal value) {
            addCriterion("hour_3_ok =", value, "hour3Ok");
            return (Criteria) this;
        }

        public Criteria andHour3OkNotEqualTo(BigDecimal value) {
            addCriterion("hour_3_ok <>", value, "hour3Ok");
            return (Criteria) this;
        }

        public Criteria andHour3OkGreaterThan(BigDecimal value) {
            addCriterion("hour_3_ok >", value, "hour3Ok");
            return (Criteria) this;
        }

        public Criteria andHour3OkGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_3_ok >=", value, "hour3Ok");
            return (Criteria) this;
        }

        public Criteria andHour3OkLessThan(BigDecimal value) {
            addCriterion("hour_3_ok <", value, "hour3Ok");
            return (Criteria) this;
        }

        public Criteria andHour3OkLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_3_ok <=", value, "hour3Ok");
            return (Criteria) this;
        }

        public Criteria andHour3OkIn(List<BigDecimal> values) {
            addCriterion("hour_3_ok in", values, "hour3Ok");
            return (Criteria) this;
        }

        public Criteria andHour3OkNotIn(List<BigDecimal> values) {
            addCriterion("hour_3_ok not in", values, "hour3Ok");
            return (Criteria) this;
        }

        public Criteria andHour3OkBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_3_ok between", value1, value2, "hour3Ok");
            return (Criteria) this;
        }

        public Criteria andHour3OkNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_3_ok not between", value1, value2, "hour3Ok");
            return (Criteria) this;
        }

        public Criteria andHour3AllIsNull() {
            addCriterion("hour_3_all is null");
            return (Criteria) this;
        }

        public Criteria andHour3AllIsNotNull() {
            addCriterion("hour_3_all is not null");
            return (Criteria) this;
        }

        public Criteria andHour3AllEqualTo(BigDecimal value) {
            addCriterion("hour_3_all =", value, "hour3All");
            return (Criteria) this;
        }

        public Criteria andHour3AllNotEqualTo(BigDecimal value) {
            addCriterion("hour_3_all <>", value, "hour3All");
            return (Criteria) this;
        }

        public Criteria andHour3AllGreaterThan(BigDecimal value) {
            addCriterion("hour_3_all >", value, "hour3All");
            return (Criteria) this;
        }

        public Criteria andHour3AllGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_3_all >=", value, "hour3All");
            return (Criteria) this;
        }

        public Criteria andHour3AllLessThan(BigDecimal value) {
            addCriterion("hour_3_all <", value, "hour3All");
            return (Criteria) this;
        }

        public Criteria andHour3AllLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_3_all <=", value, "hour3All");
            return (Criteria) this;
        }

        public Criteria andHour3AllIn(List<BigDecimal> values) {
            addCriterion("hour_3_all in", values, "hour3All");
            return (Criteria) this;
        }

        public Criteria andHour3AllNotIn(List<BigDecimal> values) {
            addCriterion("hour_3_all not in", values, "hour3All");
            return (Criteria) this;
        }

        public Criteria andHour3AllBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_3_all between", value1, value2, "hour3All");
            return (Criteria) this;
        }

        public Criteria andHour3AllNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_3_all not between", value1, value2, "hour3All");
            return (Criteria) this;
        }

        public Criteria andHour4OkIsNull() {
            addCriterion("hour_4_ok is null");
            return (Criteria) this;
        }

        public Criteria andHour4OkIsNotNull() {
            addCriterion("hour_4_ok is not null");
            return (Criteria) this;
        }

        public Criteria andHour4OkEqualTo(BigDecimal value) {
            addCriterion("hour_4_ok =", value, "hour4Ok");
            return (Criteria) this;
        }

        public Criteria andHour4OkNotEqualTo(BigDecimal value) {
            addCriterion("hour_4_ok <>", value, "hour4Ok");
            return (Criteria) this;
        }

        public Criteria andHour4OkGreaterThan(BigDecimal value) {
            addCriterion("hour_4_ok >", value, "hour4Ok");
            return (Criteria) this;
        }

        public Criteria andHour4OkGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_4_ok >=", value, "hour4Ok");
            return (Criteria) this;
        }

        public Criteria andHour4OkLessThan(BigDecimal value) {
            addCriterion("hour_4_ok <", value, "hour4Ok");
            return (Criteria) this;
        }

        public Criteria andHour4OkLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_4_ok <=", value, "hour4Ok");
            return (Criteria) this;
        }

        public Criteria andHour4OkIn(List<BigDecimal> values) {
            addCriterion("hour_4_ok in", values, "hour4Ok");
            return (Criteria) this;
        }

        public Criteria andHour4OkNotIn(List<BigDecimal> values) {
            addCriterion("hour_4_ok not in", values, "hour4Ok");
            return (Criteria) this;
        }

        public Criteria andHour4OkBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_4_ok between", value1, value2, "hour4Ok");
            return (Criteria) this;
        }

        public Criteria andHour4OkNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_4_ok not between", value1, value2, "hour4Ok");
            return (Criteria) this;
        }

        public Criteria andHour4AllIsNull() {
            addCriterion("hour_4_all is null");
            return (Criteria) this;
        }

        public Criteria andHour4AllIsNotNull() {
            addCriterion("hour_4_all is not null");
            return (Criteria) this;
        }

        public Criteria andHour4AllEqualTo(BigDecimal value) {
            addCriterion("hour_4_all =", value, "hour4All");
            return (Criteria) this;
        }

        public Criteria andHour4AllNotEqualTo(BigDecimal value) {
            addCriterion("hour_4_all <>", value, "hour4All");
            return (Criteria) this;
        }

        public Criteria andHour4AllGreaterThan(BigDecimal value) {
            addCriterion("hour_4_all >", value, "hour4All");
            return (Criteria) this;
        }

        public Criteria andHour4AllGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_4_all >=", value, "hour4All");
            return (Criteria) this;
        }

        public Criteria andHour4AllLessThan(BigDecimal value) {
            addCriterion("hour_4_all <", value, "hour4All");
            return (Criteria) this;
        }

        public Criteria andHour4AllLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_4_all <=", value, "hour4All");
            return (Criteria) this;
        }

        public Criteria andHour4AllIn(List<BigDecimal> values) {
            addCriterion("hour_4_all in", values, "hour4All");
            return (Criteria) this;
        }

        public Criteria andHour4AllNotIn(List<BigDecimal> values) {
            addCriterion("hour_4_all not in", values, "hour4All");
            return (Criteria) this;
        }

        public Criteria andHour4AllBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_4_all between", value1, value2, "hour4All");
            return (Criteria) this;
        }

        public Criteria andHour4AllNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_4_all not between", value1, value2, "hour4All");
            return (Criteria) this;
        }

        public Criteria andHour5OkIsNull() {
            addCriterion("hour_5_ok is null");
            return (Criteria) this;
        }

        public Criteria andHour5OkIsNotNull() {
            addCriterion("hour_5_ok is not null");
            return (Criteria) this;
        }

        public Criteria andHour5OkEqualTo(BigDecimal value) {
            addCriterion("hour_5_ok =", value, "hour5Ok");
            return (Criteria) this;
        }

        public Criteria andHour5OkNotEqualTo(BigDecimal value) {
            addCriterion("hour_5_ok <>", value, "hour5Ok");
            return (Criteria) this;
        }

        public Criteria andHour5OkGreaterThan(BigDecimal value) {
            addCriterion("hour_5_ok >", value, "hour5Ok");
            return (Criteria) this;
        }

        public Criteria andHour5OkGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_5_ok >=", value, "hour5Ok");
            return (Criteria) this;
        }

        public Criteria andHour5OkLessThan(BigDecimal value) {
            addCriterion("hour_5_ok <", value, "hour5Ok");
            return (Criteria) this;
        }

        public Criteria andHour5OkLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_5_ok <=", value, "hour5Ok");
            return (Criteria) this;
        }

        public Criteria andHour5OkIn(List<BigDecimal> values) {
            addCriterion("hour_5_ok in", values, "hour5Ok");
            return (Criteria) this;
        }

        public Criteria andHour5OkNotIn(List<BigDecimal> values) {
            addCriterion("hour_5_ok not in", values, "hour5Ok");
            return (Criteria) this;
        }

        public Criteria andHour5OkBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_5_ok between", value1, value2, "hour5Ok");
            return (Criteria) this;
        }

        public Criteria andHour5OkNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_5_ok not between", value1, value2, "hour5Ok");
            return (Criteria) this;
        }

        public Criteria andHour5AllIsNull() {
            addCriterion("hour_5_all is null");
            return (Criteria) this;
        }

        public Criteria andHour5AllIsNotNull() {
            addCriterion("hour_5_all is not null");
            return (Criteria) this;
        }

        public Criteria andHour5AllEqualTo(BigDecimal value) {
            addCriterion("hour_5_all =", value, "hour5All");
            return (Criteria) this;
        }

        public Criteria andHour5AllNotEqualTo(BigDecimal value) {
            addCriterion("hour_5_all <>", value, "hour5All");
            return (Criteria) this;
        }

        public Criteria andHour5AllGreaterThan(BigDecimal value) {
            addCriterion("hour_5_all >", value, "hour5All");
            return (Criteria) this;
        }

        public Criteria andHour5AllGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_5_all >=", value, "hour5All");
            return (Criteria) this;
        }

        public Criteria andHour5AllLessThan(BigDecimal value) {
            addCriterion("hour_5_all <", value, "hour5All");
            return (Criteria) this;
        }

        public Criteria andHour5AllLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_5_all <=", value, "hour5All");
            return (Criteria) this;
        }

        public Criteria andHour5AllIn(List<BigDecimal> values) {
            addCriterion("hour_5_all in", values, "hour5All");
            return (Criteria) this;
        }

        public Criteria andHour5AllNotIn(List<BigDecimal> values) {
            addCriterion("hour_5_all not in", values, "hour5All");
            return (Criteria) this;
        }

        public Criteria andHour5AllBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_5_all between", value1, value2, "hour5All");
            return (Criteria) this;
        }

        public Criteria andHour5AllNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_5_all not between", value1, value2, "hour5All");
            return (Criteria) this;
        }

        public Criteria andHour6OkIsNull() {
            addCriterion("hour_6_ok is null");
            return (Criteria) this;
        }

        public Criteria andHour6OkIsNotNull() {
            addCriterion("hour_6_ok is not null");
            return (Criteria) this;
        }

        public Criteria andHour6OkEqualTo(BigDecimal value) {
            addCriterion("hour_6_ok =", value, "hour6Ok");
            return (Criteria) this;
        }

        public Criteria andHour6OkNotEqualTo(BigDecimal value) {
            addCriterion("hour_6_ok <>", value, "hour6Ok");
            return (Criteria) this;
        }

        public Criteria andHour6OkGreaterThan(BigDecimal value) {
            addCriterion("hour_6_ok >", value, "hour6Ok");
            return (Criteria) this;
        }

        public Criteria andHour6OkGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_6_ok >=", value, "hour6Ok");
            return (Criteria) this;
        }

        public Criteria andHour6OkLessThan(BigDecimal value) {
            addCriterion("hour_6_ok <", value, "hour6Ok");
            return (Criteria) this;
        }

        public Criteria andHour6OkLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_6_ok <=", value, "hour6Ok");
            return (Criteria) this;
        }

        public Criteria andHour6OkIn(List<BigDecimal> values) {
            addCriterion("hour_6_ok in", values, "hour6Ok");
            return (Criteria) this;
        }

        public Criteria andHour6OkNotIn(List<BigDecimal> values) {
            addCriterion("hour_6_ok not in", values, "hour6Ok");
            return (Criteria) this;
        }

        public Criteria andHour6OkBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_6_ok between", value1, value2, "hour6Ok");
            return (Criteria) this;
        }

        public Criteria andHour6OkNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_6_ok not between", value1, value2, "hour6Ok");
            return (Criteria) this;
        }

        public Criteria andHour6AllIsNull() {
            addCriterion("hour_6_all is null");
            return (Criteria) this;
        }

        public Criteria andHour6AllIsNotNull() {
            addCriterion("hour_6_all is not null");
            return (Criteria) this;
        }

        public Criteria andHour6AllEqualTo(BigDecimal value) {
            addCriterion("hour_6_all =", value, "hour6All");
            return (Criteria) this;
        }

        public Criteria andHour6AllNotEqualTo(BigDecimal value) {
            addCriterion("hour_6_all <>", value, "hour6All");
            return (Criteria) this;
        }

        public Criteria andHour6AllGreaterThan(BigDecimal value) {
            addCriterion("hour_6_all >", value, "hour6All");
            return (Criteria) this;
        }

        public Criteria andHour6AllGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_6_all >=", value, "hour6All");
            return (Criteria) this;
        }

        public Criteria andHour6AllLessThan(BigDecimal value) {
            addCriterion("hour_6_all <", value, "hour6All");
            return (Criteria) this;
        }

        public Criteria andHour6AllLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_6_all <=", value, "hour6All");
            return (Criteria) this;
        }

        public Criteria andHour6AllIn(List<BigDecimal> values) {
            addCriterion("hour_6_all in", values, "hour6All");
            return (Criteria) this;
        }

        public Criteria andHour6AllNotIn(List<BigDecimal> values) {
            addCriterion("hour_6_all not in", values, "hour6All");
            return (Criteria) this;
        }

        public Criteria andHour6AllBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_6_all between", value1, value2, "hour6All");
            return (Criteria) this;
        }

        public Criteria andHour6AllNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_6_all not between", value1, value2, "hour6All");
            return (Criteria) this;
        }

        public Criteria andHour7OkIsNull() {
            addCriterion("hour_7_ok is null");
            return (Criteria) this;
        }

        public Criteria andHour7OkIsNotNull() {
            addCriterion("hour_7_ok is not null");
            return (Criteria) this;
        }

        public Criteria andHour7OkEqualTo(BigDecimal value) {
            addCriterion("hour_7_ok =", value, "hour7Ok");
            return (Criteria) this;
        }

        public Criteria andHour7OkNotEqualTo(BigDecimal value) {
            addCriterion("hour_7_ok <>", value, "hour7Ok");
            return (Criteria) this;
        }

        public Criteria andHour7OkGreaterThan(BigDecimal value) {
            addCriterion("hour_7_ok >", value, "hour7Ok");
            return (Criteria) this;
        }

        public Criteria andHour7OkGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_7_ok >=", value, "hour7Ok");
            return (Criteria) this;
        }

        public Criteria andHour7OkLessThan(BigDecimal value) {
            addCriterion("hour_7_ok <", value, "hour7Ok");
            return (Criteria) this;
        }

        public Criteria andHour7OkLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_7_ok <=", value, "hour7Ok");
            return (Criteria) this;
        }

        public Criteria andHour7OkIn(List<BigDecimal> values) {
            addCriterion("hour_7_ok in", values, "hour7Ok");
            return (Criteria) this;
        }

        public Criteria andHour7OkNotIn(List<BigDecimal> values) {
            addCriterion("hour_7_ok not in", values, "hour7Ok");
            return (Criteria) this;
        }

        public Criteria andHour7OkBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_7_ok between", value1, value2, "hour7Ok");
            return (Criteria) this;
        }

        public Criteria andHour7OkNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_7_ok not between", value1, value2, "hour7Ok");
            return (Criteria) this;
        }

        public Criteria andHour7AllIsNull() {
            addCriterion("hour_7_all is null");
            return (Criteria) this;
        }

        public Criteria andHour7AllIsNotNull() {
            addCriterion("hour_7_all is not null");
            return (Criteria) this;
        }

        public Criteria andHour7AllEqualTo(BigDecimal value) {
            addCriterion("hour_7_all =", value, "hour7All");
            return (Criteria) this;
        }

        public Criteria andHour7AllNotEqualTo(BigDecimal value) {
            addCriterion("hour_7_all <>", value, "hour7All");
            return (Criteria) this;
        }

        public Criteria andHour7AllGreaterThan(BigDecimal value) {
            addCriterion("hour_7_all >", value, "hour7All");
            return (Criteria) this;
        }

        public Criteria andHour7AllGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_7_all >=", value, "hour7All");
            return (Criteria) this;
        }

        public Criteria andHour7AllLessThan(BigDecimal value) {
            addCriterion("hour_7_all <", value, "hour7All");
            return (Criteria) this;
        }

        public Criteria andHour7AllLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_7_all <=", value, "hour7All");
            return (Criteria) this;
        }

        public Criteria andHour7AllIn(List<BigDecimal> values) {
            addCriterion("hour_7_all in", values, "hour7All");
            return (Criteria) this;
        }

        public Criteria andHour7AllNotIn(List<BigDecimal> values) {
            addCriterion("hour_7_all not in", values, "hour7All");
            return (Criteria) this;
        }

        public Criteria andHour7AllBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_7_all between", value1, value2, "hour7All");
            return (Criteria) this;
        }

        public Criteria andHour7AllNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_7_all not between", value1, value2, "hour7All");
            return (Criteria) this;
        }

        public Criteria andHour8OkIsNull() {
            addCriterion("hour_8_ok is null");
            return (Criteria) this;
        }

        public Criteria andHour8OkIsNotNull() {
            addCriterion("hour_8_ok is not null");
            return (Criteria) this;
        }

        public Criteria andHour8OkEqualTo(BigDecimal value) {
            addCriterion("hour_8_ok =", value, "hour8Ok");
            return (Criteria) this;
        }

        public Criteria andHour8OkNotEqualTo(BigDecimal value) {
            addCriterion("hour_8_ok <>", value, "hour8Ok");
            return (Criteria) this;
        }

        public Criteria andHour8OkGreaterThan(BigDecimal value) {
            addCriterion("hour_8_ok >", value, "hour8Ok");
            return (Criteria) this;
        }

        public Criteria andHour8OkGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_8_ok >=", value, "hour8Ok");
            return (Criteria) this;
        }

        public Criteria andHour8OkLessThan(BigDecimal value) {
            addCriterion("hour_8_ok <", value, "hour8Ok");
            return (Criteria) this;
        }

        public Criteria andHour8OkLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_8_ok <=", value, "hour8Ok");
            return (Criteria) this;
        }

        public Criteria andHour8OkIn(List<BigDecimal> values) {
            addCriterion("hour_8_ok in", values, "hour8Ok");
            return (Criteria) this;
        }

        public Criteria andHour8OkNotIn(List<BigDecimal> values) {
            addCriterion("hour_8_ok not in", values, "hour8Ok");
            return (Criteria) this;
        }

        public Criteria andHour8OkBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_8_ok between", value1, value2, "hour8Ok");
            return (Criteria) this;
        }

        public Criteria andHour8OkNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_8_ok not between", value1, value2, "hour8Ok");
            return (Criteria) this;
        }

        public Criteria andHour8AllIsNull() {
            addCriterion("hour_8_all is null");
            return (Criteria) this;
        }

        public Criteria andHour8AllIsNotNull() {
            addCriterion("hour_8_all is not null");
            return (Criteria) this;
        }

        public Criteria andHour8AllEqualTo(BigDecimal value) {
            addCriterion("hour_8_all =", value, "hour8All");
            return (Criteria) this;
        }

        public Criteria andHour8AllNotEqualTo(BigDecimal value) {
            addCriterion("hour_8_all <>", value, "hour8All");
            return (Criteria) this;
        }

        public Criteria andHour8AllGreaterThan(BigDecimal value) {
            addCriterion("hour_8_all >", value, "hour8All");
            return (Criteria) this;
        }

        public Criteria andHour8AllGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_8_all >=", value, "hour8All");
            return (Criteria) this;
        }

        public Criteria andHour8AllLessThan(BigDecimal value) {
            addCriterion("hour_8_all <", value, "hour8All");
            return (Criteria) this;
        }

        public Criteria andHour8AllLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_8_all <=", value, "hour8All");
            return (Criteria) this;
        }

        public Criteria andHour8AllIn(List<BigDecimal> values) {
            addCriterion("hour_8_all in", values, "hour8All");
            return (Criteria) this;
        }

        public Criteria andHour8AllNotIn(List<BigDecimal> values) {
            addCriterion("hour_8_all not in", values, "hour8All");
            return (Criteria) this;
        }

        public Criteria andHour8AllBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_8_all between", value1, value2, "hour8All");
            return (Criteria) this;
        }

        public Criteria andHour8AllNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_8_all not between", value1, value2, "hour8All");
            return (Criteria) this;
        }

        public Criteria andHour9OkIsNull() {
            addCriterion("hour_9_ok is null");
            return (Criteria) this;
        }

        public Criteria andHour9OkIsNotNull() {
            addCriterion("hour_9_ok is not null");
            return (Criteria) this;
        }

        public Criteria andHour9OkEqualTo(BigDecimal value) {
            addCriterion("hour_9_ok =", value, "hour9Ok");
            return (Criteria) this;
        }

        public Criteria andHour9OkNotEqualTo(BigDecimal value) {
            addCriterion("hour_9_ok <>", value, "hour9Ok");
            return (Criteria) this;
        }

        public Criteria andHour9OkGreaterThan(BigDecimal value) {
            addCriterion("hour_9_ok >", value, "hour9Ok");
            return (Criteria) this;
        }

        public Criteria andHour9OkGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_9_ok >=", value, "hour9Ok");
            return (Criteria) this;
        }

        public Criteria andHour9OkLessThan(BigDecimal value) {
            addCriterion("hour_9_ok <", value, "hour9Ok");
            return (Criteria) this;
        }

        public Criteria andHour9OkLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_9_ok <=", value, "hour9Ok");
            return (Criteria) this;
        }

        public Criteria andHour9OkIn(List<BigDecimal> values) {
            addCriterion("hour_9_ok in", values, "hour9Ok");
            return (Criteria) this;
        }

        public Criteria andHour9OkNotIn(List<BigDecimal> values) {
            addCriterion("hour_9_ok not in", values, "hour9Ok");
            return (Criteria) this;
        }

        public Criteria andHour9OkBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_9_ok between", value1, value2, "hour9Ok");
            return (Criteria) this;
        }

        public Criteria andHour9OkNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_9_ok not between", value1, value2, "hour9Ok");
            return (Criteria) this;
        }

        public Criteria andHour9AllIsNull() {
            addCriterion("hour_9_all is null");
            return (Criteria) this;
        }

        public Criteria andHour9AllIsNotNull() {
            addCriterion("hour_9_all is not null");
            return (Criteria) this;
        }

        public Criteria andHour9AllEqualTo(BigDecimal value) {
            addCriterion("hour_9_all =", value, "hour9All");
            return (Criteria) this;
        }

        public Criteria andHour9AllNotEqualTo(BigDecimal value) {
            addCriterion("hour_9_all <>", value, "hour9All");
            return (Criteria) this;
        }

        public Criteria andHour9AllGreaterThan(BigDecimal value) {
            addCriterion("hour_9_all >", value, "hour9All");
            return (Criteria) this;
        }

        public Criteria andHour9AllGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_9_all >=", value, "hour9All");
            return (Criteria) this;
        }

        public Criteria andHour9AllLessThan(BigDecimal value) {
            addCriterion("hour_9_all <", value, "hour9All");
            return (Criteria) this;
        }

        public Criteria andHour9AllLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_9_all <=", value, "hour9All");
            return (Criteria) this;
        }

        public Criteria andHour9AllIn(List<BigDecimal> values) {
            addCriterion("hour_9_all in", values, "hour9All");
            return (Criteria) this;
        }

        public Criteria andHour9AllNotIn(List<BigDecimal> values) {
            addCriterion("hour_9_all not in", values, "hour9All");
            return (Criteria) this;
        }

        public Criteria andHour9AllBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_9_all between", value1, value2, "hour9All");
            return (Criteria) this;
        }

        public Criteria andHour9AllNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_9_all not between", value1, value2, "hour9All");
            return (Criteria) this;
        }

        public Criteria andHour10OkIsNull() {
            addCriterion("hour_10_ok is null");
            return (Criteria) this;
        }

        public Criteria andHour10OkIsNotNull() {
            addCriterion("hour_10_ok is not null");
            return (Criteria) this;
        }

        public Criteria andHour10OkEqualTo(BigDecimal value) {
            addCriterion("hour_10_ok =", value, "hour10Ok");
            return (Criteria) this;
        }

        public Criteria andHour10OkNotEqualTo(BigDecimal value) {
            addCriterion("hour_10_ok <>", value, "hour10Ok");
            return (Criteria) this;
        }

        public Criteria andHour10OkGreaterThan(BigDecimal value) {
            addCriterion("hour_10_ok >", value, "hour10Ok");
            return (Criteria) this;
        }

        public Criteria andHour10OkGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_10_ok >=", value, "hour10Ok");
            return (Criteria) this;
        }

        public Criteria andHour10OkLessThan(BigDecimal value) {
            addCriterion("hour_10_ok <", value, "hour10Ok");
            return (Criteria) this;
        }

        public Criteria andHour10OkLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_10_ok <=", value, "hour10Ok");
            return (Criteria) this;
        }

        public Criteria andHour10OkIn(List<BigDecimal> values) {
            addCriterion("hour_10_ok in", values, "hour10Ok");
            return (Criteria) this;
        }

        public Criteria andHour10OkNotIn(List<BigDecimal> values) {
            addCriterion("hour_10_ok not in", values, "hour10Ok");
            return (Criteria) this;
        }

        public Criteria andHour10OkBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_10_ok between", value1, value2, "hour10Ok");
            return (Criteria) this;
        }

        public Criteria andHour10OkNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_10_ok not between", value1, value2, "hour10Ok");
            return (Criteria) this;
        }

        public Criteria andHour10AllIsNull() {
            addCriterion("hour_10_all is null");
            return (Criteria) this;
        }

        public Criteria andHour10AllIsNotNull() {
            addCriterion("hour_10_all is not null");
            return (Criteria) this;
        }

        public Criteria andHour10AllEqualTo(BigDecimal value) {
            addCriterion("hour_10_all =", value, "hour10All");
            return (Criteria) this;
        }

        public Criteria andHour10AllNotEqualTo(BigDecimal value) {
            addCriterion("hour_10_all <>", value, "hour10All");
            return (Criteria) this;
        }

        public Criteria andHour10AllGreaterThan(BigDecimal value) {
            addCriterion("hour_10_all >", value, "hour10All");
            return (Criteria) this;
        }

        public Criteria andHour10AllGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_10_all >=", value, "hour10All");
            return (Criteria) this;
        }

        public Criteria andHour10AllLessThan(BigDecimal value) {
            addCriterion("hour_10_all <", value, "hour10All");
            return (Criteria) this;
        }

        public Criteria andHour10AllLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_10_all <=", value, "hour10All");
            return (Criteria) this;
        }

        public Criteria andHour10AllIn(List<BigDecimal> values) {
            addCriterion("hour_10_all in", values, "hour10All");
            return (Criteria) this;
        }

        public Criteria andHour10AllNotIn(List<BigDecimal> values) {
            addCriterion("hour_10_all not in", values, "hour10All");
            return (Criteria) this;
        }

        public Criteria andHour10AllBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_10_all between", value1, value2, "hour10All");
            return (Criteria) this;
        }

        public Criteria andHour10AllNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_10_all not between", value1, value2, "hour10All");
            return (Criteria) this;
        }

        public Criteria andHour11OkIsNull() {
            addCriterion("hour_11_ok is null");
            return (Criteria) this;
        }

        public Criteria andHour11OkIsNotNull() {
            addCriterion("hour_11_ok is not null");
            return (Criteria) this;
        }

        public Criteria andHour11OkEqualTo(BigDecimal value) {
            addCriterion("hour_11_ok =", value, "hour11Ok");
            return (Criteria) this;
        }

        public Criteria andHour11OkNotEqualTo(BigDecimal value) {
            addCriterion("hour_11_ok <>", value, "hour11Ok");
            return (Criteria) this;
        }

        public Criteria andHour11OkGreaterThan(BigDecimal value) {
            addCriterion("hour_11_ok >", value, "hour11Ok");
            return (Criteria) this;
        }

        public Criteria andHour11OkGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_11_ok >=", value, "hour11Ok");
            return (Criteria) this;
        }

        public Criteria andHour11OkLessThan(BigDecimal value) {
            addCriterion("hour_11_ok <", value, "hour11Ok");
            return (Criteria) this;
        }

        public Criteria andHour11OkLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_11_ok <=", value, "hour11Ok");
            return (Criteria) this;
        }

        public Criteria andHour11OkIn(List<BigDecimal> values) {
            addCriterion("hour_11_ok in", values, "hour11Ok");
            return (Criteria) this;
        }

        public Criteria andHour11OkNotIn(List<BigDecimal> values) {
            addCriterion("hour_11_ok not in", values, "hour11Ok");
            return (Criteria) this;
        }

        public Criteria andHour11OkBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_11_ok between", value1, value2, "hour11Ok");
            return (Criteria) this;
        }

        public Criteria andHour11OkNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_11_ok not between", value1, value2, "hour11Ok");
            return (Criteria) this;
        }

        public Criteria andHour11AllIsNull() {
            addCriterion("hour_11_all is null");
            return (Criteria) this;
        }

        public Criteria andHour11AllIsNotNull() {
            addCriterion("hour_11_all is not null");
            return (Criteria) this;
        }

        public Criteria andHour11AllEqualTo(BigDecimal value) {
            addCriterion("hour_11_all =", value, "hour11All");
            return (Criteria) this;
        }

        public Criteria andHour11AllNotEqualTo(BigDecimal value) {
            addCriterion("hour_11_all <>", value, "hour11All");
            return (Criteria) this;
        }

        public Criteria andHour11AllGreaterThan(BigDecimal value) {
            addCriterion("hour_11_all >", value, "hour11All");
            return (Criteria) this;
        }

        public Criteria andHour11AllGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_11_all >=", value, "hour11All");
            return (Criteria) this;
        }

        public Criteria andHour11AllLessThan(BigDecimal value) {
            addCriterion("hour_11_all <", value, "hour11All");
            return (Criteria) this;
        }

        public Criteria andHour11AllLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_11_all <=", value, "hour11All");
            return (Criteria) this;
        }

        public Criteria andHour11AllIn(List<BigDecimal> values) {
            addCriterion("hour_11_all in", values, "hour11All");
            return (Criteria) this;
        }

        public Criteria andHour11AllNotIn(List<BigDecimal> values) {
            addCriterion("hour_11_all not in", values, "hour11All");
            return (Criteria) this;
        }

        public Criteria andHour11AllBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_11_all between", value1, value2, "hour11All");
            return (Criteria) this;
        }

        public Criteria andHour11AllNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_11_all not between", value1, value2, "hour11All");
            return (Criteria) this;
        }

        public Criteria andHour12OkIsNull() {
            addCriterion("hour_12_ok is null");
            return (Criteria) this;
        }

        public Criteria andHour12OkIsNotNull() {
            addCriterion("hour_12_ok is not null");
            return (Criteria) this;
        }

        public Criteria andHour12OkEqualTo(BigDecimal value) {
            addCriterion("hour_12_ok =", value, "hour12Ok");
            return (Criteria) this;
        }

        public Criteria andHour12OkNotEqualTo(BigDecimal value) {
            addCriterion("hour_12_ok <>", value, "hour12Ok");
            return (Criteria) this;
        }

        public Criteria andHour12OkGreaterThan(BigDecimal value) {
            addCriterion("hour_12_ok >", value, "hour12Ok");
            return (Criteria) this;
        }

        public Criteria andHour12OkGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_12_ok >=", value, "hour12Ok");
            return (Criteria) this;
        }

        public Criteria andHour12OkLessThan(BigDecimal value) {
            addCriterion("hour_12_ok <", value, "hour12Ok");
            return (Criteria) this;
        }

        public Criteria andHour12OkLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_12_ok <=", value, "hour12Ok");
            return (Criteria) this;
        }

        public Criteria andHour12OkIn(List<BigDecimal> values) {
            addCriterion("hour_12_ok in", values, "hour12Ok");
            return (Criteria) this;
        }

        public Criteria andHour12OkNotIn(List<BigDecimal> values) {
            addCriterion("hour_12_ok not in", values, "hour12Ok");
            return (Criteria) this;
        }

        public Criteria andHour12OkBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_12_ok between", value1, value2, "hour12Ok");
            return (Criteria) this;
        }

        public Criteria andHour12OkNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_12_ok not between", value1, value2, "hour12Ok");
            return (Criteria) this;
        }

        public Criteria andHour12AllIsNull() {
            addCriterion("hour_12_all is null");
            return (Criteria) this;
        }

        public Criteria andHour12AllIsNotNull() {
            addCriterion("hour_12_all is not null");
            return (Criteria) this;
        }

        public Criteria andHour12AllEqualTo(BigDecimal value) {
            addCriterion("hour_12_all =", value, "hour12All");
            return (Criteria) this;
        }

        public Criteria andHour12AllNotEqualTo(BigDecimal value) {
            addCriterion("hour_12_all <>", value, "hour12All");
            return (Criteria) this;
        }

        public Criteria andHour12AllGreaterThan(BigDecimal value) {
            addCriterion("hour_12_all >", value, "hour12All");
            return (Criteria) this;
        }

        public Criteria andHour12AllGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_12_all >=", value, "hour12All");
            return (Criteria) this;
        }

        public Criteria andHour12AllLessThan(BigDecimal value) {
            addCriterion("hour_12_all <", value, "hour12All");
            return (Criteria) this;
        }

        public Criteria andHour12AllLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_12_all <=", value, "hour12All");
            return (Criteria) this;
        }

        public Criteria andHour12AllIn(List<BigDecimal> values) {
            addCriterion("hour_12_all in", values, "hour12All");
            return (Criteria) this;
        }

        public Criteria andHour12AllNotIn(List<BigDecimal> values) {
            addCriterion("hour_12_all not in", values, "hour12All");
            return (Criteria) this;
        }

        public Criteria andHour12AllBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_12_all between", value1, value2, "hour12All");
            return (Criteria) this;
        }

        public Criteria andHour12AllNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_12_all not between", value1, value2, "hour12All");
            return (Criteria) this;
        }

        public Criteria andHour13OkIsNull() {
            addCriterion("hour_13_ok is null");
            return (Criteria) this;
        }

        public Criteria andHour13OkIsNotNull() {
            addCriterion("hour_13_ok is not null");
            return (Criteria) this;
        }

        public Criteria andHour13OkEqualTo(BigDecimal value) {
            addCriterion("hour_13_ok =", value, "hour13Ok");
            return (Criteria) this;
        }

        public Criteria andHour13OkNotEqualTo(BigDecimal value) {
            addCriterion("hour_13_ok <>", value, "hour13Ok");
            return (Criteria) this;
        }

        public Criteria andHour13OkGreaterThan(BigDecimal value) {
            addCriterion("hour_13_ok >", value, "hour13Ok");
            return (Criteria) this;
        }

        public Criteria andHour13OkGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_13_ok >=", value, "hour13Ok");
            return (Criteria) this;
        }

        public Criteria andHour13OkLessThan(BigDecimal value) {
            addCriterion("hour_13_ok <", value, "hour13Ok");
            return (Criteria) this;
        }

        public Criteria andHour13OkLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_13_ok <=", value, "hour13Ok");
            return (Criteria) this;
        }

        public Criteria andHour13OkIn(List<BigDecimal> values) {
            addCriterion("hour_13_ok in", values, "hour13Ok");
            return (Criteria) this;
        }

        public Criteria andHour13OkNotIn(List<BigDecimal> values) {
            addCriterion("hour_13_ok not in", values, "hour13Ok");
            return (Criteria) this;
        }

        public Criteria andHour13OkBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_13_ok between", value1, value2, "hour13Ok");
            return (Criteria) this;
        }

        public Criteria andHour13OkNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_13_ok not between", value1, value2, "hour13Ok");
            return (Criteria) this;
        }

        public Criteria andHour13AllIsNull() {
            addCriterion("hour_13_all is null");
            return (Criteria) this;
        }

        public Criteria andHour13AllIsNotNull() {
            addCriterion("hour_13_all is not null");
            return (Criteria) this;
        }

        public Criteria andHour13AllEqualTo(BigDecimal value) {
            addCriterion("hour_13_all =", value, "hour13All");
            return (Criteria) this;
        }

        public Criteria andHour13AllNotEqualTo(BigDecimal value) {
            addCriterion("hour_13_all <>", value, "hour13All");
            return (Criteria) this;
        }

        public Criteria andHour13AllGreaterThan(BigDecimal value) {
            addCriterion("hour_13_all >", value, "hour13All");
            return (Criteria) this;
        }

        public Criteria andHour13AllGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_13_all >=", value, "hour13All");
            return (Criteria) this;
        }

        public Criteria andHour13AllLessThan(BigDecimal value) {
            addCriterion("hour_13_all <", value, "hour13All");
            return (Criteria) this;
        }

        public Criteria andHour13AllLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_13_all <=", value, "hour13All");
            return (Criteria) this;
        }

        public Criteria andHour13AllIn(List<BigDecimal> values) {
            addCriterion("hour_13_all in", values, "hour13All");
            return (Criteria) this;
        }

        public Criteria andHour13AllNotIn(List<BigDecimal> values) {
            addCriterion("hour_13_all not in", values, "hour13All");
            return (Criteria) this;
        }

        public Criteria andHour13AllBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_13_all between", value1, value2, "hour13All");
            return (Criteria) this;
        }

        public Criteria andHour13AllNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_13_all not between", value1, value2, "hour13All");
            return (Criteria) this;
        }

        public Criteria andHour14OkIsNull() {
            addCriterion("hour_14_ok is null");
            return (Criteria) this;
        }

        public Criteria andHour14OkIsNotNull() {
            addCriterion("hour_14_ok is not null");
            return (Criteria) this;
        }

        public Criteria andHour14OkEqualTo(BigDecimal value) {
            addCriterion("hour_14_ok =", value, "hour14Ok");
            return (Criteria) this;
        }

        public Criteria andHour14OkNotEqualTo(BigDecimal value) {
            addCriterion("hour_14_ok <>", value, "hour14Ok");
            return (Criteria) this;
        }

        public Criteria andHour14OkGreaterThan(BigDecimal value) {
            addCriterion("hour_14_ok >", value, "hour14Ok");
            return (Criteria) this;
        }

        public Criteria andHour14OkGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_14_ok >=", value, "hour14Ok");
            return (Criteria) this;
        }

        public Criteria andHour14OkLessThan(BigDecimal value) {
            addCriterion("hour_14_ok <", value, "hour14Ok");
            return (Criteria) this;
        }

        public Criteria andHour14OkLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_14_ok <=", value, "hour14Ok");
            return (Criteria) this;
        }

        public Criteria andHour14OkIn(List<BigDecimal> values) {
            addCriterion("hour_14_ok in", values, "hour14Ok");
            return (Criteria) this;
        }

        public Criteria andHour14OkNotIn(List<BigDecimal> values) {
            addCriterion("hour_14_ok not in", values, "hour14Ok");
            return (Criteria) this;
        }

        public Criteria andHour14OkBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_14_ok between", value1, value2, "hour14Ok");
            return (Criteria) this;
        }

        public Criteria andHour14OkNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_14_ok not between", value1, value2, "hour14Ok");
            return (Criteria) this;
        }

        public Criteria andHour14AllIsNull() {
            addCriterion("hour_14_all is null");
            return (Criteria) this;
        }

        public Criteria andHour14AllIsNotNull() {
            addCriterion("hour_14_all is not null");
            return (Criteria) this;
        }

        public Criteria andHour14AllEqualTo(BigDecimal value) {
            addCriterion("hour_14_all =", value, "hour14All");
            return (Criteria) this;
        }

        public Criteria andHour14AllNotEqualTo(BigDecimal value) {
            addCriterion("hour_14_all <>", value, "hour14All");
            return (Criteria) this;
        }

        public Criteria andHour14AllGreaterThan(BigDecimal value) {
            addCriterion("hour_14_all >", value, "hour14All");
            return (Criteria) this;
        }

        public Criteria andHour14AllGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_14_all >=", value, "hour14All");
            return (Criteria) this;
        }

        public Criteria andHour14AllLessThan(BigDecimal value) {
            addCriterion("hour_14_all <", value, "hour14All");
            return (Criteria) this;
        }

        public Criteria andHour14AllLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_14_all <=", value, "hour14All");
            return (Criteria) this;
        }

        public Criteria andHour14AllIn(List<BigDecimal> values) {
            addCriterion("hour_14_all in", values, "hour14All");
            return (Criteria) this;
        }

        public Criteria andHour14AllNotIn(List<BigDecimal> values) {
            addCriterion("hour_14_all not in", values, "hour14All");
            return (Criteria) this;
        }

        public Criteria andHour14AllBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_14_all between", value1, value2, "hour14All");
            return (Criteria) this;
        }

        public Criteria andHour14AllNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_14_all not between", value1, value2, "hour14All");
            return (Criteria) this;
        }

        public Criteria andHour15OkIsNull() {
            addCriterion("hour_15_ok is null");
            return (Criteria) this;
        }

        public Criteria andHour15OkIsNotNull() {
            addCriterion("hour_15_ok is not null");
            return (Criteria) this;
        }

        public Criteria andHour15OkEqualTo(BigDecimal value) {
            addCriterion("hour_15_ok =", value, "hour15Ok");
            return (Criteria) this;
        }

        public Criteria andHour15OkNotEqualTo(BigDecimal value) {
            addCriterion("hour_15_ok <>", value, "hour15Ok");
            return (Criteria) this;
        }

        public Criteria andHour15OkGreaterThan(BigDecimal value) {
            addCriterion("hour_15_ok >", value, "hour15Ok");
            return (Criteria) this;
        }

        public Criteria andHour15OkGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_15_ok >=", value, "hour15Ok");
            return (Criteria) this;
        }

        public Criteria andHour15OkLessThan(BigDecimal value) {
            addCriterion("hour_15_ok <", value, "hour15Ok");
            return (Criteria) this;
        }

        public Criteria andHour15OkLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_15_ok <=", value, "hour15Ok");
            return (Criteria) this;
        }

        public Criteria andHour15OkIn(List<BigDecimal> values) {
            addCriterion("hour_15_ok in", values, "hour15Ok");
            return (Criteria) this;
        }

        public Criteria andHour15OkNotIn(List<BigDecimal> values) {
            addCriterion("hour_15_ok not in", values, "hour15Ok");
            return (Criteria) this;
        }

        public Criteria andHour15OkBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_15_ok between", value1, value2, "hour15Ok");
            return (Criteria) this;
        }

        public Criteria andHour15OkNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_15_ok not between", value1, value2, "hour15Ok");
            return (Criteria) this;
        }

        public Criteria andHour15AllIsNull() {
            addCriterion("hour_15_all is null");
            return (Criteria) this;
        }

        public Criteria andHour15AllIsNotNull() {
            addCriterion("hour_15_all is not null");
            return (Criteria) this;
        }

        public Criteria andHour15AllEqualTo(BigDecimal value) {
            addCriterion("hour_15_all =", value, "hour15All");
            return (Criteria) this;
        }

        public Criteria andHour15AllNotEqualTo(BigDecimal value) {
            addCriterion("hour_15_all <>", value, "hour15All");
            return (Criteria) this;
        }

        public Criteria andHour15AllGreaterThan(BigDecimal value) {
            addCriterion("hour_15_all >", value, "hour15All");
            return (Criteria) this;
        }

        public Criteria andHour15AllGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_15_all >=", value, "hour15All");
            return (Criteria) this;
        }

        public Criteria andHour15AllLessThan(BigDecimal value) {
            addCriterion("hour_15_all <", value, "hour15All");
            return (Criteria) this;
        }

        public Criteria andHour15AllLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_15_all <=", value, "hour15All");
            return (Criteria) this;
        }

        public Criteria andHour15AllIn(List<BigDecimal> values) {
            addCriterion("hour_15_all in", values, "hour15All");
            return (Criteria) this;
        }

        public Criteria andHour15AllNotIn(List<BigDecimal> values) {
            addCriterion("hour_15_all not in", values, "hour15All");
            return (Criteria) this;
        }

        public Criteria andHour15AllBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_15_all between", value1, value2, "hour15All");
            return (Criteria) this;
        }

        public Criteria andHour15AllNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_15_all not between", value1, value2, "hour15All");
            return (Criteria) this;
        }

        public Criteria andHour16OkIsNull() {
            addCriterion("hour_16_ok is null");
            return (Criteria) this;
        }

        public Criteria andHour16OkIsNotNull() {
            addCriterion("hour_16_ok is not null");
            return (Criteria) this;
        }

        public Criteria andHour16OkEqualTo(BigDecimal value) {
            addCriterion("hour_16_ok =", value, "hour16Ok");
            return (Criteria) this;
        }

        public Criteria andHour16OkNotEqualTo(BigDecimal value) {
            addCriterion("hour_16_ok <>", value, "hour16Ok");
            return (Criteria) this;
        }

        public Criteria andHour16OkGreaterThan(BigDecimal value) {
            addCriterion("hour_16_ok >", value, "hour16Ok");
            return (Criteria) this;
        }

        public Criteria andHour16OkGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_16_ok >=", value, "hour16Ok");
            return (Criteria) this;
        }

        public Criteria andHour16OkLessThan(BigDecimal value) {
            addCriterion("hour_16_ok <", value, "hour16Ok");
            return (Criteria) this;
        }

        public Criteria andHour16OkLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_16_ok <=", value, "hour16Ok");
            return (Criteria) this;
        }

        public Criteria andHour16OkIn(List<BigDecimal> values) {
            addCriterion("hour_16_ok in", values, "hour16Ok");
            return (Criteria) this;
        }

        public Criteria andHour16OkNotIn(List<BigDecimal> values) {
            addCriterion("hour_16_ok not in", values, "hour16Ok");
            return (Criteria) this;
        }

        public Criteria andHour16OkBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_16_ok between", value1, value2, "hour16Ok");
            return (Criteria) this;
        }

        public Criteria andHour16OkNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_16_ok not between", value1, value2, "hour16Ok");
            return (Criteria) this;
        }

        public Criteria andHour16AllIsNull() {
            addCriterion("hour_16_all is null");
            return (Criteria) this;
        }

        public Criteria andHour16AllIsNotNull() {
            addCriterion("hour_16_all is not null");
            return (Criteria) this;
        }

        public Criteria andHour16AllEqualTo(BigDecimal value) {
            addCriterion("hour_16_all =", value, "hour16All");
            return (Criteria) this;
        }

        public Criteria andHour16AllNotEqualTo(BigDecimal value) {
            addCriterion("hour_16_all <>", value, "hour16All");
            return (Criteria) this;
        }

        public Criteria andHour16AllGreaterThan(BigDecimal value) {
            addCriterion("hour_16_all >", value, "hour16All");
            return (Criteria) this;
        }

        public Criteria andHour16AllGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_16_all >=", value, "hour16All");
            return (Criteria) this;
        }

        public Criteria andHour16AllLessThan(BigDecimal value) {
            addCriterion("hour_16_all <", value, "hour16All");
            return (Criteria) this;
        }

        public Criteria andHour16AllLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_16_all <=", value, "hour16All");
            return (Criteria) this;
        }

        public Criteria andHour16AllIn(List<BigDecimal> values) {
            addCriterion("hour_16_all in", values, "hour16All");
            return (Criteria) this;
        }

        public Criteria andHour16AllNotIn(List<BigDecimal> values) {
            addCriterion("hour_16_all not in", values, "hour16All");
            return (Criteria) this;
        }

        public Criteria andHour16AllBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_16_all between", value1, value2, "hour16All");
            return (Criteria) this;
        }

        public Criteria andHour16AllNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_16_all not between", value1, value2, "hour16All");
            return (Criteria) this;
        }

        public Criteria andHour17OkIsNull() {
            addCriterion("hour_17_ok is null");
            return (Criteria) this;
        }

        public Criteria andHour17OkIsNotNull() {
            addCriterion("hour_17_ok is not null");
            return (Criteria) this;
        }

        public Criteria andHour17OkEqualTo(BigDecimal value) {
            addCriterion("hour_17_ok =", value, "hour17Ok");
            return (Criteria) this;
        }

        public Criteria andHour17OkNotEqualTo(BigDecimal value) {
            addCriterion("hour_17_ok <>", value, "hour17Ok");
            return (Criteria) this;
        }

        public Criteria andHour17OkGreaterThan(BigDecimal value) {
            addCriterion("hour_17_ok >", value, "hour17Ok");
            return (Criteria) this;
        }

        public Criteria andHour17OkGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_17_ok >=", value, "hour17Ok");
            return (Criteria) this;
        }

        public Criteria andHour17OkLessThan(BigDecimal value) {
            addCriterion("hour_17_ok <", value, "hour17Ok");
            return (Criteria) this;
        }

        public Criteria andHour17OkLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_17_ok <=", value, "hour17Ok");
            return (Criteria) this;
        }

        public Criteria andHour17OkIn(List<BigDecimal> values) {
            addCriterion("hour_17_ok in", values, "hour17Ok");
            return (Criteria) this;
        }

        public Criteria andHour17OkNotIn(List<BigDecimal> values) {
            addCriterion("hour_17_ok not in", values, "hour17Ok");
            return (Criteria) this;
        }

        public Criteria andHour17OkBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_17_ok between", value1, value2, "hour17Ok");
            return (Criteria) this;
        }

        public Criteria andHour17OkNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_17_ok not between", value1, value2, "hour17Ok");
            return (Criteria) this;
        }

        public Criteria andHour17AllIsNull() {
            addCriterion("hour_17_all is null");
            return (Criteria) this;
        }

        public Criteria andHour17AllIsNotNull() {
            addCriterion("hour_17_all is not null");
            return (Criteria) this;
        }

        public Criteria andHour17AllEqualTo(BigDecimal value) {
            addCriterion("hour_17_all =", value, "hour17All");
            return (Criteria) this;
        }

        public Criteria andHour17AllNotEqualTo(BigDecimal value) {
            addCriterion("hour_17_all <>", value, "hour17All");
            return (Criteria) this;
        }

        public Criteria andHour17AllGreaterThan(BigDecimal value) {
            addCriterion("hour_17_all >", value, "hour17All");
            return (Criteria) this;
        }

        public Criteria andHour17AllGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_17_all >=", value, "hour17All");
            return (Criteria) this;
        }

        public Criteria andHour17AllLessThan(BigDecimal value) {
            addCriterion("hour_17_all <", value, "hour17All");
            return (Criteria) this;
        }

        public Criteria andHour17AllLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_17_all <=", value, "hour17All");
            return (Criteria) this;
        }

        public Criteria andHour17AllIn(List<BigDecimal> values) {
            addCriterion("hour_17_all in", values, "hour17All");
            return (Criteria) this;
        }

        public Criteria andHour17AllNotIn(List<BigDecimal> values) {
            addCriterion("hour_17_all not in", values, "hour17All");
            return (Criteria) this;
        }

        public Criteria andHour17AllBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_17_all between", value1, value2, "hour17All");
            return (Criteria) this;
        }

        public Criteria andHour17AllNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_17_all not between", value1, value2, "hour17All");
            return (Criteria) this;
        }

        public Criteria andHour18OkIsNull() {
            addCriterion("hour_18_ok is null");
            return (Criteria) this;
        }

        public Criteria andHour18OkIsNotNull() {
            addCriterion("hour_18_ok is not null");
            return (Criteria) this;
        }

        public Criteria andHour18OkEqualTo(BigDecimal value) {
            addCriterion("hour_18_ok =", value, "hour18Ok");
            return (Criteria) this;
        }

        public Criteria andHour18OkNotEqualTo(BigDecimal value) {
            addCriterion("hour_18_ok <>", value, "hour18Ok");
            return (Criteria) this;
        }

        public Criteria andHour18OkGreaterThan(BigDecimal value) {
            addCriterion("hour_18_ok >", value, "hour18Ok");
            return (Criteria) this;
        }

        public Criteria andHour18OkGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_18_ok >=", value, "hour18Ok");
            return (Criteria) this;
        }

        public Criteria andHour18OkLessThan(BigDecimal value) {
            addCriterion("hour_18_ok <", value, "hour18Ok");
            return (Criteria) this;
        }

        public Criteria andHour18OkLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_18_ok <=", value, "hour18Ok");
            return (Criteria) this;
        }

        public Criteria andHour18OkIn(List<BigDecimal> values) {
            addCriterion("hour_18_ok in", values, "hour18Ok");
            return (Criteria) this;
        }

        public Criteria andHour18OkNotIn(List<BigDecimal> values) {
            addCriterion("hour_18_ok not in", values, "hour18Ok");
            return (Criteria) this;
        }

        public Criteria andHour18OkBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_18_ok between", value1, value2, "hour18Ok");
            return (Criteria) this;
        }

        public Criteria andHour18OkNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_18_ok not between", value1, value2, "hour18Ok");
            return (Criteria) this;
        }

        public Criteria andHour18AllIsNull() {
            addCriterion("hour_18_all is null");
            return (Criteria) this;
        }

        public Criteria andHour18AllIsNotNull() {
            addCriterion("hour_18_all is not null");
            return (Criteria) this;
        }

        public Criteria andHour18AllEqualTo(BigDecimal value) {
            addCriterion("hour_18_all =", value, "hour18All");
            return (Criteria) this;
        }

        public Criteria andHour18AllNotEqualTo(BigDecimal value) {
            addCriterion("hour_18_all <>", value, "hour18All");
            return (Criteria) this;
        }

        public Criteria andHour18AllGreaterThan(BigDecimal value) {
            addCriterion("hour_18_all >", value, "hour18All");
            return (Criteria) this;
        }

        public Criteria andHour18AllGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_18_all >=", value, "hour18All");
            return (Criteria) this;
        }

        public Criteria andHour18AllLessThan(BigDecimal value) {
            addCriterion("hour_18_all <", value, "hour18All");
            return (Criteria) this;
        }

        public Criteria andHour18AllLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_18_all <=", value, "hour18All");
            return (Criteria) this;
        }

        public Criteria andHour18AllIn(List<BigDecimal> values) {
            addCriterion("hour_18_all in", values, "hour18All");
            return (Criteria) this;
        }

        public Criteria andHour18AllNotIn(List<BigDecimal> values) {
            addCriterion("hour_18_all not in", values, "hour18All");
            return (Criteria) this;
        }

        public Criteria andHour18AllBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_18_all between", value1, value2, "hour18All");
            return (Criteria) this;
        }

        public Criteria andHour18AllNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_18_all not between", value1, value2, "hour18All");
            return (Criteria) this;
        }

        public Criteria andHour19OkIsNull() {
            addCriterion("hour_19_ok is null");
            return (Criteria) this;
        }

        public Criteria andHour19OkIsNotNull() {
            addCriterion("hour_19_ok is not null");
            return (Criteria) this;
        }

        public Criteria andHour19OkEqualTo(BigDecimal value) {
            addCriterion("hour_19_ok =", value, "hour19Ok");
            return (Criteria) this;
        }

        public Criteria andHour19OkNotEqualTo(BigDecimal value) {
            addCriterion("hour_19_ok <>", value, "hour19Ok");
            return (Criteria) this;
        }

        public Criteria andHour19OkGreaterThan(BigDecimal value) {
            addCriterion("hour_19_ok >", value, "hour19Ok");
            return (Criteria) this;
        }

        public Criteria andHour19OkGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_19_ok >=", value, "hour19Ok");
            return (Criteria) this;
        }

        public Criteria andHour19OkLessThan(BigDecimal value) {
            addCriterion("hour_19_ok <", value, "hour19Ok");
            return (Criteria) this;
        }

        public Criteria andHour19OkLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_19_ok <=", value, "hour19Ok");
            return (Criteria) this;
        }

        public Criteria andHour19OkIn(List<BigDecimal> values) {
            addCriterion("hour_19_ok in", values, "hour19Ok");
            return (Criteria) this;
        }

        public Criteria andHour19OkNotIn(List<BigDecimal> values) {
            addCriterion("hour_19_ok not in", values, "hour19Ok");
            return (Criteria) this;
        }

        public Criteria andHour19OkBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_19_ok between", value1, value2, "hour19Ok");
            return (Criteria) this;
        }

        public Criteria andHour19OkNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_19_ok not between", value1, value2, "hour19Ok");
            return (Criteria) this;
        }

        public Criteria andHour19AllIsNull() {
            addCriterion("hour_19_all is null");
            return (Criteria) this;
        }

        public Criteria andHour19AllIsNotNull() {
            addCriterion("hour_19_all is not null");
            return (Criteria) this;
        }

        public Criteria andHour19AllEqualTo(BigDecimal value) {
            addCriterion("hour_19_all =", value, "hour19All");
            return (Criteria) this;
        }

        public Criteria andHour19AllNotEqualTo(BigDecimal value) {
            addCriterion("hour_19_all <>", value, "hour19All");
            return (Criteria) this;
        }

        public Criteria andHour19AllGreaterThan(BigDecimal value) {
            addCriterion("hour_19_all >", value, "hour19All");
            return (Criteria) this;
        }

        public Criteria andHour19AllGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_19_all >=", value, "hour19All");
            return (Criteria) this;
        }

        public Criteria andHour19AllLessThan(BigDecimal value) {
            addCriterion("hour_19_all <", value, "hour19All");
            return (Criteria) this;
        }

        public Criteria andHour19AllLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_19_all <=", value, "hour19All");
            return (Criteria) this;
        }

        public Criteria andHour19AllIn(List<BigDecimal> values) {
            addCriterion("hour_19_all in", values, "hour19All");
            return (Criteria) this;
        }

        public Criteria andHour19AllNotIn(List<BigDecimal> values) {
            addCriterion("hour_19_all not in", values, "hour19All");
            return (Criteria) this;
        }

        public Criteria andHour19AllBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_19_all between", value1, value2, "hour19All");
            return (Criteria) this;
        }

        public Criteria andHour19AllNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_19_all not between", value1, value2, "hour19All");
            return (Criteria) this;
        }

        public Criteria andHour20OkIsNull() {
            addCriterion("hour_20_ok is null");
            return (Criteria) this;
        }

        public Criteria andHour20OkIsNotNull() {
            addCriterion("hour_20_ok is not null");
            return (Criteria) this;
        }

        public Criteria andHour20OkEqualTo(BigDecimal value) {
            addCriterion("hour_20_ok =", value, "hour20Ok");
            return (Criteria) this;
        }

        public Criteria andHour20OkNotEqualTo(BigDecimal value) {
            addCriterion("hour_20_ok <>", value, "hour20Ok");
            return (Criteria) this;
        }

        public Criteria andHour20OkGreaterThan(BigDecimal value) {
            addCriterion("hour_20_ok >", value, "hour20Ok");
            return (Criteria) this;
        }

        public Criteria andHour20OkGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_20_ok >=", value, "hour20Ok");
            return (Criteria) this;
        }

        public Criteria andHour20OkLessThan(BigDecimal value) {
            addCriterion("hour_20_ok <", value, "hour20Ok");
            return (Criteria) this;
        }

        public Criteria andHour20OkLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_20_ok <=", value, "hour20Ok");
            return (Criteria) this;
        }

        public Criteria andHour20OkIn(List<BigDecimal> values) {
            addCriterion("hour_20_ok in", values, "hour20Ok");
            return (Criteria) this;
        }

        public Criteria andHour20OkNotIn(List<BigDecimal> values) {
            addCriterion("hour_20_ok not in", values, "hour20Ok");
            return (Criteria) this;
        }

        public Criteria andHour20OkBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_20_ok between", value1, value2, "hour20Ok");
            return (Criteria) this;
        }

        public Criteria andHour20OkNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_20_ok not between", value1, value2, "hour20Ok");
            return (Criteria) this;
        }

        public Criteria andHour20AllIsNull() {
            addCriterion("hour_20_all is null");
            return (Criteria) this;
        }

        public Criteria andHour20AllIsNotNull() {
            addCriterion("hour_20_all is not null");
            return (Criteria) this;
        }

        public Criteria andHour20AllEqualTo(BigDecimal value) {
            addCriterion("hour_20_all =", value, "hour20All");
            return (Criteria) this;
        }

        public Criteria andHour20AllNotEqualTo(BigDecimal value) {
            addCriterion("hour_20_all <>", value, "hour20All");
            return (Criteria) this;
        }

        public Criteria andHour20AllGreaterThan(BigDecimal value) {
            addCriterion("hour_20_all >", value, "hour20All");
            return (Criteria) this;
        }

        public Criteria andHour20AllGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_20_all >=", value, "hour20All");
            return (Criteria) this;
        }

        public Criteria andHour20AllLessThan(BigDecimal value) {
            addCriterion("hour_20_all <", value, "hour20All");
            return (Criteria) this;
        }

        public Criteria andHour20AllLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_20_all <=", value, "hour20All");
            return (Criteria) this;
        }

        public Criteria andHour20AllIn(List<BigDecimal> values) {
            addCriterion("hour_20_all in", values, "hour20All");
            return (Criteria) this;
        }

        public Criteria andHour20AllNotIn(List<BigDecimal> values) {
            addCriterion("hour_20_all not in", values, "hour20All");
            return (Criteria) this;
        }

        public Criteria andHour20AllBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_20_all between", value1, value2, "hour20All");
            return (Criteria) this;
        }

        public Criteria andHour20AllNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_20_all not between", value1, value2, "hour20All");
            return (Criteria) this;
        }

        public Criteria andHour21OkIsNull() {
            addCriterion("hour_21_ok is null");
            return (Criteria) this;
        }

        public Criteria andHour21OkIsNotNull() {
            addCriterion("hour_21_ok is not null");
            return (Criteria) this;
        }

        public Criteria andHour21OkEqualTo(BigDecimal value) {
            addCriterion("hour_21_ok =", value, "hour21Ok");
            return (Criteria) this;
        }

        public Criteria andHour21OkNotEqualTo(BigDecimal value) {
            addCriterion("hour_21_ok <>", value, "hour21Ok");
            return (Criteria) this;
        }

        public Criteria andHour21OkGreaterThan(BigDecimal value) {
            addCriterion("hour_21_ok >", value, "hour21Ok");
            return (Criteria) this;
        }

        public Criteria andHour21OkGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_21_ok >=", value, "hour21Ok");
            return (Criteria) this;
        }

        public Criteria andHour21OkLessThan(BigDecimal value) {
            addCriterion("hour_21_ok <", value, "hour21Ok");
            return (Criteria) this;
        }

        public Criteria andHour21OkLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_21_ok <=", value, "hour21Ok");
            return (Criteria) this;
        }

        public Criteria andHour21OkIn(List<BigDecimal> values) {
            addCriterion("hour_21_ok in", values, "hour21Ok");
            return (Criteria) this;
        }

        public Criteria andHour21OkNotIn(List<BigDecimal> values) {
            addCriterion("hour_21_ok not in", values, "hour21Ok");
            return (Criteria) this;
        }

        public Criteria andHour21OkBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_21_ok between", value1, value2, "hour21Ok");
            return (Criteria) this;
        }

        public Criteria andHour21OkNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_21_ok not between", value1, value2, "hour21Ok");
            return (Criteria) this;
        }

        public Criteria andHour21AllIsNull() {
            addCriterion("hour_21_all is null");
            return (Criteria) this;
        }

        public Criteria andHour21AllIsNotNull() {
            addCriterion("hour_21_all is not null");
            return (Criteria) this;
        }

        public Criteria andHour21AllEqualTo(BigDecimal value) {
            addCriterion("hour_21_all =", value, "hour21All");
            return (Criteria) this;
        }

        public Criteria andHour21AllNotEqualTo(BigDecimal value) {
            addCriterion("hour_21_all <>", value, "hour21All");
            return (Criteria) this;
        }

        public Criteria andHour21AllGreaterThan(BigDecimal value) {
            addCriterion("hour_21_all >", value, "hour21All");
            return (Criteria) this;
        }

        public Criteria andHour21AllGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_21_all >=", value, "hour21All");
            return (Criteria) this;
        }

        public Criteria andHour21AllLessThan(BigDecimal value) {
            addCriterion("hour_21_all <", value, "hour21All");
            return (Criteria) this;
        }

        public Criteria andHour21AllLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_21_all <=", value, "hour21All");
            return (Criteria) this;
        }

        public Criteria andHour21AllIn(List<BigDecimal> values) {
            addCriterion("hour_21_all in", values, "hour21All");
            return (Criteria) this;
        }

        public Criteria andHour21AllNotIn(List<BigDecimal> values) {
            addCriterion("hour_21_all not in", values, "hour21All");
            return (Criteria) this;
        }

        public Criteria andHour21AllBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_21_all between", value1, value2, "hour21All");
            return (Criteria) this;
        }

        public Criteria andHour21AllNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_21_all not between", value1, value2, "hour21All");
            return (Criteria) this;
        }

        public Criteria andHour22OkIsNull() {
            addCriterion("hour_22_ok is null");
            return (Criteria) this;
        }

        public Criteria andHour22OkIsNotNull() {
            addCriterion("hour_22_ok is not null");
            return (Criteria) this;
        }

        public Criteria andHour22OkEqualTo(BigDecimal value) {
            addCriterion("hour_22_ok =", value, "hour22Ok");
            return (Criteria) this;
        }

        public Criteria andHour22OkNotEqualTo(BigDecimal value) {
            addCriterion("hour_22_ok <>", value, "hour22Ok");
            return (Criteria) this;
        }

        public Criteria andHour22OkGreaterThan(BigDecimal value) {
            addCriterion("hour_22_ok >", value, "hour22Ok");
            return (Criteria) this;
        }

        public Criteria andHour22OkGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_22_ok >=", value, "hour22Ok");
            return (Criteria) this;
        }

        public Criteria andHour22OkLessThan(BigDecimal value) {
            addCriterion("hour_22_ok <", value, "hour22Ok");
            return (Criteria) this;
        }

        public Criteria andHour22OkLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_22_ok <=", value, "hour22Ok");
            return (Criteria) this;
        }

        public Criteria andHour22OkIn(List<BigDecimal> values) {
            addCriterion("hour_22_ok in", values, "hour22Ok");
            return (Criteria) this;
        }

        public Criteria andHour22OkNotIn(List<BigDecimal> values) {
            addCriterion("hour_22_ok not in", values, "hour22Ok");
            return (Criteria) this;
        }

        public Criteria andHour22OkBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_22_ok between", value1, value2, "hour22Ok");
            return (Criteria) this;
        }

        public Criteria andHour22OkNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_22_ok not between", value1, value2, "hour22Ok");
            return (Criteria) this;
        }

        public Criteria andHour22AllIsNull() {
            addCriterion("hour_22_all is null");
            return (Criteria) this;
        }

        public Criteria andHour22AllIsNotNull() {
            addCriterion("hour_22_all is not null");
            return (Criteria) this;
        }

        public Criteria andHour22AllEqualTo(BigDecimal value) {
            addCriterion("hour_22_all =", value, "hour22All");
            return (Criteria) this;
        }

        public Criteria andHour22AllNotEqualTo(BigDecimal value) {
            addCriterion("hour_22_all <>", value, "hour22All");
            return (Criteria) this;
        }

        public Criteria andHour22AllGreaterThan(BigDecimal value) {
            addCriterion("hour_22_all >", value, "hour22All");
            return (Criteria) this;
        }

        public Criteria andHour22AllGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_22_all >=", value, "hour22All");
            return (Criteria) this;
        }

        public Criteria andHour22AllLessThan(BigDecimal value) {
            addCriterion("hour_22_all <", value, "hour22All");
            return (Criteria) this;
        }

        public Criteria andHour22AllLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_22_all <=", value, "hour22All");
            return (Criteria) this;
        }

        public Criteria andHour22AllIn(List<BigDecimal> values) {
            addCriterion("hour_22_all in", values, "hour22All");
            return (Criteria) this;
        }

        public Criteria andHour22AllNotIn(List<BigDecimal> values) {
            addCriterion("hour_22_all not in", values, "hour22All");
            return (Criteria) this;
        }

        public Criteria andHour22AllBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_22_all between", value1, value2, "hour22All");
            return (Criteria) this;
        }

        public Criteria andHour22AllNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_22_all not between", value1, value2, "hour22All");
            return (Criteria) this;
        }

        public Criteria andHour23OkIsNull() {
            addCriterion("hour_23_ok is null");
            return (Criteria) this;
        }

        public Criteria andHour23OkIsNotNull() {
            addCriterion("hour_23_ok is not null");
            return (Criteria) this;
        }

        public Criteria andHour23OkEqualTo(BigDecimal value) {
            addCriterion("hour_23_ok =", value, "hour23Ok");
            return (Criteria) this;
        }

        public Criteria andHour23OkNotEqualTo(BigDecimal value) {
            addCriterion("hour_23_ok <>", value, "hour23Ok");
            return (Criteria) this;
        }

        public Criteria andHour23OkGreaterThan(BigDecimal value) {
            addCriterion("hour_23_ok >", value, "hour23Ok");
            return (Criteria) this;
        }

        public Criteria andHour23OkGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_23_ok >=", value, "hour23Ok");
            return (Criteria) this;
        }

        public Criteria andHour23OkLessThan(BigDecimal value) {
            addCriterion("hour_23_ok <", value, "hour23Ok");
            return (Criteria) this;
        }

        public Criteria andHour23OkLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_23_ok <=", value, "hour23Ok");
            return (Criteria) this;
        }

        public Criteria andHour23OkIn(List<BigDecimal> values) {
            addCriterion("hour_23_ok in", values, "hour23Ok");
            return (Criteria) this;
        }

        public Criteria andHour23OkNotIn(List<BigDecimal> values) {
            addCriterion("hour_23_ok not in", values, "hour23Ok");
            return (Criteria) this;
        }

        public Criteria andHour23OkBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_23_ok between", value1, value2, "hour23Ok");
            return (Criteria) this;
        }

        public Criteria andHour23OkNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_23_ok not between", value1, value2, "hour23Ok");
            return (Criteria) this;
        }

        public Criteria andHour23AllIsNull() {
            addCriterion("hour_23_all is null");
            return (Criteria) this;
        }

        public Criteria andHour23AllIsNotNull() {
            addCriterion("hour_23_all is not null");
            return (Criteria) this;
        }

        public Criteria andHour23AllEqualTo(BigDecimal value) {
            addCriterion("hour_23_all =", value, "hour23All");
            return (Criteria) this;
        }

        public Criteria andHour23AllNotEqualTo(BigDecimal value) {
            addCriterion("hour_23_all <>", value, "hour23All");
            return (Criteria) this;
        }

        public Criteria andHour23AllGreaterThan(BigDecimal value) {
            addCriterion("hour_23_all >", value, "hour23All");
            return (Criteria) this;
        }

        public Criteria andHour23AllGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_23_all >=", value, "hour23All");
            return (Criteria) this;
        }

        public Criteria andHour23AllLessThan(BigDecimal value) {
            addCriterion("hour_23_all <", value, "hour23All");
            return (Criteria) this;
        }

        public Criteria andHour23AllLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hour_23_all <=", value, "hour23All");
            return (Criteria) this;
        }

        public Criteria andHour23AllIn(List<BigDecimal> values) {
            addCriterion("hour_23_all in", values, "hour23All");
            return (Criteria) this;
        }

        public Criteria andHour23AllNotIn(List<BigDecimal> values) {
            addCriterion("hour_23_all not in", values, "hour23All");
            return (Criteria) this;
        }

        public Criteria andHour23AllBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_23_all between", value1, value2, "hour23All");
            return (Criteria) this;
        }

        public Criteria andHour23AllNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hour_23_all not between", value1, value2, "hour23All");
            return (Criteria) this;
        }

        public Criteria andWorkDailyCasesIsNull() {
            addCriterion("work_daily_cases is null");
            return (Criteria) this;
        }

        public Criteria andWorkDailyCasesIsNotNull() {
            addCriterion("work_daily_cases is not null");
            return (Criteria) this;
        }

        public Criteria andWorkDailyCasesEqualTo(Integer value) {
            addCriterion("work_daily_cases =", value, "workDailyCases");
            return (Criteria) this;
        }

        public Criteria andWorkDailyCasesNotEqualTo(Integer value) {
            addCriterion("work_daily_cases <>", value, "workDailyCases");
            return (Criteria) this;
        }

        public Criteria andWorkDailyCasesGreaterThan(Integer value) {
            addCriterion("work_daily_cases >", value, "workDailyCases");
            return (Criteria) this;
        }

        public Criteria andWorkDailyCasesGreaterThanOrEqualTo(Integer value) {
            addCriterion("work_daily_cases >=", value, "workDailyCases");
            return (Criteria) this;
        }

        public Criteria andWorkDailyCasesLessThan(Integer value) {
            addCriterion("work_daily_cases <", value, "workDailyCases");
            return (Criteria) this;
        }

        public Criteria andWorkDailyCasesLessThanOrEqualTo(Integer value) {
            addCriterion("work_daily_cases <=", value, "workDailyCases");
            return (Criteria) this;
        }

        public Criteria andWorkDailyCasesIn(List<Integer> values) {
            addCriterion("work_daily_cases in", values, "workDailyCases");
            return (Criteria) this;
        }

        public Criteria andWorkDailyCasesNotIn(List<Integer> values) {
            addCriterion("work_daily_cases not in", values, "workDailyCases");
            return (Criteria) this;
        }

        public Criteria andWorkDailyCasesBetween(Integer value1, Integer value2) {
            addCriterion("work_daily_cases between", value1, value2, "workDailyCases");
            return (Criteria) this;
        }

        public Criteria andWorkDailyCasesNotBetween(Integer value1, Integer value2) {
            addCriterion("work_daily_cases not between", value1, value2, "workDailyCases");
            return (Criteria) this;
        }

        public Criteria andAllDailyCasesIsNull() {
            addCriterion("all_daily_cases is null");
            return (Criteria) this;
        }

        public Criteria andAllDailyCasesIsNotNull() {
            addCriterion("all_daily_cases is not null");
            return (Criteria) this;
        }

        public Criteria andAllDailyCasesEqualTo(Integer value) {
            addCriterion("all_daily_cases =", value, "allDailyCases");
            return (Criteria) this;
        }

        public Criteria andAllDailyCasesNotEqualTo(Integer value) {
            addCriterion("all_daily_cases <>", value, "allDailyCases");
            return (Criteria) this;
        }

        public Criteria andAllDailyCasesGreaterThan(Integer value) {
            addCriterion("all_daily_cases >", value, "allDailyCases");
            return (Criteria) this;
        }

        public Criteria andAllDailyCasesGreaterThanOrEqualTo(Integer value) {
            addCriterion("all_daily_cases >=", value, "allDailyCases");
            return (Criteria) this;
        }

        public Criteria andAllDailyCasesLessThan(Integer value) {
            addCriterion("all_daily_cases <", value, "allDailyCases");
            return (Criteria) this;
        }

        public Criteria andAllDailyCasesLessThanOrEqualTo(Integer value) {
            addCriterion("all_daily_cases <=", value, "allDailyCases");
            return (Criteria) this;
        }

        public Criteria andAllDailyCasesIn(List<Integer> values) {
            addCriterion("all_daily_cases in", values, "allDailyCases");
            return (Criteria) this;
        }

        public Criteria andAllDailyCasesNotIn(List<Integer> values) {
            addCriterion("all_daily_cases not in", values, "allDailyCases");
            return (Criteria) this;
        }

        public Criteria andAllDailyCasesBetween(Integer value1, Integer value2) {
            addCriterion("all_daily_cases between", value1, value2, "allDailyCases");
            return (Criteria) this;
        }

        public Criteria andAllDailyCasesNotBetween(Integer value1, Integer value2) {
            addCriterion("all_daily_cases not between", value1, value2, "allDailyCases");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
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