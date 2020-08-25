package com.yida.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * @author fnchenxi
 */
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

        public Criteria andAverageIsNull() {
            addCriterion("average is null");
            return (Criteria) this;
        }

        public Criteria andAverageIsNotNull() {
            addCriterion("average is not null");
            return (Criteria) this;
        }

        public Criteria andAverageEqualTo(BigDecimal value) {
            addCriterion("average =", value, "average");
            return (Criteria) this;
        }

        public Criteria andAverageNotEqualTo(BigDecimal value) {
            addCriterion("average <>", value, "average");
            return (Criteria) this;
        }

        public Criteria andAverageGreaterThan(BigDecimal value) {
            addCriterion("average >", value, "average");
            return (Criteria) this;
        }

        public Criteria andAverageGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("average >=", value, "average");
            return (Criteria) this;
        }

        public Criteria andAverageLessThan(BigDecimal value) {
            addCriterion("average <", value, "average");
            return (Criteria) this;
        }

        public Criteria andAverageLessThanOrEqualTo(BigDecimal value) {
            addCriterion("average <=", value, "average");
            return (Criteria) this;
        }

        public Criteria andAverageIn(List<BigDecimal> values) {
            addCriterion("average in", values, "average");
            return (Criteria) this;
        }

        public Criteria andAverageNotIn(List<BigDecimal> values) {
            addCriterion("average not in", values, "average");
            return (Criteria) this;
        }

        public Criteria andAverageBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("average between", value1, value2, "average");
            return (Criteria) this;
        }

        public Criteria andAverageNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("average not between", value1, value2, "average");
            return (Criteria) this;
        }

        public Criteria andNineIsNull() {
            addCriterion("nine is null");
            return (Criteria) this;
        }

        public Criteria andNineIsNotNull() {
            addCriterion("nine is not null");
            return (Criteria) this;
        }

        public Criteria andNineEqualTo(BigDecimal value) {
            addCriterion("nine =", value, "nine");
            return (Criteria) this;
        }

        public Criteria andNineNotEqualTo(BigDecimal value) {
            addCriterion("nine <>", value, "nine");
            return (Criteria) this;
        }

        public Criteria andNineGreaterThan(BigDecimal value) {
            addCriterion("nine >", value, "nine");
            return (Criteria) this;
        }

        public Criteria andNineGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("nine >=", value, "nine");
            return (Criteria) this;
        }

        public Criteria andNineLessThan(BigDecimal value) {
            addCriterion("nine <", value, "nine");
            return (Criteria) this;
        }

        public Criteria andNineLessThanOrEqualTo(BigDecimal value) {
            addCriterion("nine <=", value, "nine");
            return (Criteria) this;
        }

        public Criteria andNineIn(List<BigDecimal> values) {
            addCriterion("nine in", values, "nine");
            return (Criteria) this;
        }

        public Criteria andNineNotIn(List<BigDecimal> values) {
            addCriterion("nine not in", values, "nine");
            return (Criteria) this;
        }

        public Criteria andNineBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("nine between", value1, value2, "nine");
            return (Criteria) this;
        }

        public Criteria andNineNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("nine not between", value1, value2, "nine");
            return (Criteria) this;
        }

        public Criteria andTenIsNull() {
            addCriterion("ten is null");
            return (Criteria) this;
        }

        public Criteria andTenIsNotNull() {
            addCriterion("ten is not null");
            return (Criteria) this;
        }

        public Criteria andTenEqualTo(BigDecimal value) {
            addCriterion("ten =", value, "ten");
            return (Criteria) this;
        }

        public Criteria andTenNotEqualTo(BigDecimal value) {
            addCriterion("ten <>", value, "ten");
            return (Criteria) this;
        }

        public Criteria andTenGreaterThan(BigDecimal value) {
            addCriterion("ten >", value, "ten");
            return (Criteria) this;
        }

        public Criteria andTenGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ten >=", value, "ten");
            return (Criteria) this;
        }

        public Criteria andTenLessThan(BigDecimal value) {
            addCriterion("ten <", value, "ten");
            return (Criteria) this;
        }

        public Criteria andTenLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ten <=", value, "ten");
            return (Criteria) this;
        }

        public Criteria andTenIn(List<BigDecimal> values) {
            addCriterion("ten in", values, "ten");
            return (Criteria) this;
        }

        public Criteria andTenNotIn(List<BigDecimal> values) {
            addCriterion("ten not in", values, "ten");
            return (Criteria) this;
        }

        public Criteria andTenBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ten between", value1, value2, "ten");
            return (Criteria) this;
        }

        public Criteria andTenNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ten not between", value1, value2, "ten");
            return (Criteria) this;
        }

        public Criteria andElevenIsNull() {
            addCriterion("eleven is null");
            return (Criteria) this;
        }

        public Criteria andElevenIsNotNull() {
            addCriterion("eleven is not null");
            return (Criteria) this;
        }

        public Criteria andElevenEqualTo(BigDecimal value) {
            addCriterion("eleven =", value, "eleven");
            return (Criteria) this;
        }

        public Criteria andElevenNotEqualTo(BigDecimal value) {
            addCriterion("eleven <>", value, "eleven");
            return (Criteria) this;
        }

        public Criteria andElevenGreaterThan(BigDecimal value) {
            addCriterion("eleven >", value, "eleven");
            return (Criteria) this;
        }

        public Criteria andElevenGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("eleven >=", value, "eleven");
            return (Criteria) this;
        }

        public Criteria andElevenLessThan(BigDecimal value) {
            addCriterion("eleven <", value, "eleven");
            return (Criteria) this;
        }

        public Criteria andElevenLessThanOrEqualTo(BigDecimal value) {
            addCriterion("eleven <=", value, "eleven");
            return (Criteria) this;
        }

        public Criteria andElevenIn(List<BigDecimal> values) {
            addCriterion("eleven in", values, "eleven");
            return (Criteria) this;
        }

        public Criteria andElevenNotIn(List<BigDecimal> values) {
            addCriterion("eleven not in", values, "eleven");
            return (Criteria) this;
        }

        public Criteria andElevenBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("eleven between", value1, value2, "eleven");
            return (Criteria) this;
        }

        public Criteria andElevenNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("eleven not between", value1, value2, "eleven");
            return (Criteria) this;
        }

        public Criteria andTwelveIsNull() {
            addCriterion("twelve is null");
            return (Criteria) this;
        }

        public Criteria andTwelveIsNotNull() {
            addCriterion("twelve is not null");
            return (Criteria) this;
        }

        public Criteria andTwelveEqualTo(BigDecimal value) {
            addCriterion("twelve =", value, "twelve");
            return (Criteria) this;
        }

        public Criteria andTwelveNotEqualTo(BigDecimal value) {
            addCriterion("twelve <>", value, "twelve");
            return (Criteria) this;
        }

        public Criteria andTwelveGreaterThan(BigDecimal value) {
            addCriterion("twelve >", value, "twelve");
            return (Criteria) this;
        }

        public Criteria andTwelveGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("twelve >=", value, "twelve");
            return (Criteria) this;
        }

        public Criteria andTwelveLessThan(BigDecimal value) {
            addCriterion("twelve <", value, "twelve");
            return (Criteria) this;
        }

        public Criteria andTwelveLessThanOrEqualTo(BigDecimal value) {
            addCriterion("twelve <=", value, "twelve");
            return (Criteria) this;
        }

        public Criteria andTwelveIn(List<BigDecimal> values) {
            addCriterion("twelve in", values, "twelve");
            return (Criteria) this;
        }

        public Criteria andTwelveNotIn(List<BigDecimal> values) {
            addCriterion("twelve not in", values, "twelve");
            return (Criteria) this;
        }

        public Criteria andTwelveBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("twelve between", value1, value2, "twelve");
            return (Criteria) this;
        }

        public Criteria andTwelveNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("twelve not between", value1, value2, "twelve");
            return (Criteria) this;
        }

        public Criteria andThirteenIsNull() {
            addCriterion("thirteen is null");
            return (Criteria) this;
        }

        public Criteria andThirteenIsNotNull() {
            addCriterion("thirteen is not null");
            return (Criteria) this;
        }

        public Criteria andThirteenEqualTo(BigDecimal value) {
            addCriterion("thirteen =", value, "thirteen");
            return (Criteria) this;
        }

        public Criteria andThirteenNotEqualTo(BigDecimal value) {
            addCriterion("thirteen <>", value, "thirteen");
            return (Criteria) this;
        }

        public Criteria andThirteenGreaterThan(BigDecimal value) {
            addCriterion("thirteen >", value, "thirteen");
            return (Criteria) this;
        }

        public Criteria andThirteenGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("thirteen >=", value, "thirteen");
            return (Criteria) this;
        }

        public Criteria andThirteenLessThan(BigDecimal value) {
            addCriterion("thirteen <", value, "thirteen");
            return (Criteria) this;
        }

        public Criteria andThirteenLessThanOrEqualTo(BigDecimal value) {
            addCriterion("thirteen <=", value, "thirteen");
            return (Criteria) this;
        }

        public Criteria andThirteenIn(List<BigDecimal> values) {
            addCriterion("thirteen in", values, "thirteen");
            return (Criteria) this;
        }

        public Criteria andThirteenNotIn(List<BigDecimal> values) {
            addCriterion("thirteen not in", values, "thirteen");
            return (Criteria) this;
        }

        public Criteria andThirteenBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("thirteen between", value1, value2, "thirteen");
            return (Criteria) this;
        }

        public Criteria andThirteenNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("thirteen not between", value1, value2, "thirteen");
            return (Criteria) this;
        }

        public Criteria andFourteenIsNull() {
            addCriterion("fourteen is null");
            return (Criteria) this;
        }

        public Criteria andFourteenIsNotNull() {
            addCriterion("fourteen is not null");
            return (Criteria) this;
        }

        public Criteria andFourteenEqualTo(BigDecimal value) {
            addCriterion("fourteen =", value, "fourteen");
            return (Criteria) this;
        }

        public Criteria andFourteenNotEqualTo(BigDecimal value) {
            addCriterion("fourteen <>", value, "fourteen");
            return (Criteria) this;
        }

        public Criteria andFourteenGreaterThan(BigDecimal value) {
            addCriterion("fourteen >", value, "fourteen");
            return (Criteria) this;
        }

        public Criteria andFourteenGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fourteen >=", value, "fourteen");
            return (Criteria) this;
        }

        public Criteria andFourteenLessThan(BigDecimal value) {
            addCriterion("fourteen <", value, "fourteen");
            return (Criteria) this;
        }

        public Criteria andFourteenLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fourteen <=", value, "fourteen");
            return (Criteria) this;
        }

        public Criteria andFourteenIn(List<BigDecimal> values) {
            addCriterion("fourteen in", values, "fourteen");
            return (Criteria) this;
        }

        public Criteria andFourteenNotIn(List<BigDecimal> values) {
            addCriterion("fourteen not in", values, "fourteen");
            return (Criteria) this;
        }

        public Criteria andFourteenBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fourteen between", value1, value2, "fourteen");
            return (Criteria) this;
        }

        public Criteria andFourteenNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fourteen not between", value1, value2, "fourteen");
            return (Criteria) this;
        }

        public Criteria andFifteenIsNull() {
            addCriterion("fifteen is null");
            return (Criteria) this;
        }

        public Criteria andFifteenIsNotNull() {
            addCriterion("fifteen is not null");
            return (Criteria) this;
        }

        public Criteria andFifteenEqualTo(BigDecimal value) {
            addCriterion("fifteen =", value, "fifteen");
            return (Criteria) this;
        }

        public Criteria andFifteenNotEqualTo(BigDecimal value) {
            addCriterion("fifteen <>", value, "fifteen");
            return (Criteria) this;
        }

        public Criteria andFifteenGreaterThan(BigDecimal value) {
            addCriterion("fifteen >", value, "fifteen");
            return (Criteria) this;
        }

        public Criteria andFifteenGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fifteen >=", value, "fifteen");
            return (Criteria) this;
        }

        public Criteria andFifteenLessThan(BigDecimal value) {
            addCriterion("fifteen <", value, "fifteen");
            return (Criteria) this;
        }

        public Criteria andFifteenLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fifteen <=", value, "fifteen");
            return (Criteria) this;
        }

        public Criteria andFifteenIn(List<BigDecimal> values) {
            addCriterion("fifteen in", values, "fifteen");
            return (Criteria) this;
        }

        public Criteria andFifteenNotIn(List<BigDecimal> values) {
            addCriterion("fifteen not in", values, "fifteen");
            return (Criteria) this;
        }

        public Criteria andFifteenBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fifteen between", value1, value2, "fifteen");
            return (Criteria) this;
        }

        public Criteria andFifteenNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fifteen not between", value1, value2, "fifteen");
            return (Criteria) this;
        }

        public Criteria andSixteenIsNull() {
            addCriterion("sixteen is null");
            return (Criteria) this;
        }

        public Criteria andSixteenIsNotNull() {
            addCriterion("sixteen is not null");
            return (Criteria) this;
        }

        public Criteria andSixteenEqualTo(BigDecimal value) {
            addCriterion("sixteen =", value, "sixteen");
            return (Criteria) this;
        }

        public Criteria andSixteenNotEqualTo(BigDecimal value) {
            addCriterion("sixteen <>", value, "sixteen");
            return (Criteria) this;
        }

        public Criteria andSixteenGreaterThan(BigDecimal value) {
            addCriterion("sixteen >", value, "sixteen");
            return (Criteria) this;
        }

        public Criteria andSixteenGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sixteen >=", value, "sixteen");
            return (Criteria) this;
        }

        public Criteria andSixteenLessThan(BigDecimal value) {
            addCriterion("sixteen <", value, "sixteen");
            return (Criteria) this;
        }

        public Criteria andSixteenLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sixteen <=", value, "sixteen");
            return (Criteria) this;
        }

        public Criteria andSixteenIn(List<BigDecimal> values) {
            addCriterion("sixteen in", values, "sixteen");
            return (Criteria) this;
        }

        public Criteria andSixteenNotIn(List<BigDecimal> values) {
            addCriterion("sixteen not in", values, "sixteen");
            return (Criteria) this;
        }

        public Criteria andSixteenBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sixteen between", value1, value2, "sixteen");
            return (Criteria) this;
        }

        public Criteria andSixteenNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sixteen not between", value1, value2, "sixteen");
            return (Criteria) this;
        }

        public Criteria andSeventeenIsNull() {
            addCriterion("seventeen is null");
            return (Criteria) this;
        }

        public Criteria andSeventeenIsNotNull() {
            addCriterion("seventeen is not null");
            return (Criteria) this;
        }

        public Criteria andSeventeenEqualTo(BigDecimal value) {
            addCriterion("seventeen =", value, "seventeen");
            return (Criteria) this;
        }

        public Criteria andSeventeenNotEqualTo(BigDecimal value) {
            addCriterion("seventeen <>", value, "seventeen");
            return (Criteria) this;
        }

        public Criteria andSeventeenGreaterThan(BigDecimal value) {
            addCriterion("seventeen >", value, "seventeen");
            return (Criteria) this;
        }

        public Criteria andSeventeenGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("seventeen >=", value, "seventeen");
            return (Criteria) this;
        }

        public Criteria andSeventeenLessThan(BigDecimal value) {
            addCriterion("seventeen <", value, "seventeen");
            return (Criteria) this;
        }

        public Criteria andSeventeenLessThanOrEqualTo(BigDecimal value) {
            addCriterion("seventeen <=", value, "seventeen");
            return (Criteria) this;
        }

        public Criteria andSeventeenIn(List<BigDecimal> values) {
            addCriterion("seventeen in", values, "seventeen");
            return (Criteria) this;
        }

        public Criteria andSeventeenNotIn(List<BigDecimal> values) {
            addCriterion("seventeen not in", values, "seventeen");
            return (Criteria) this;
        }

        public Criteria andSeventeenBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("seventeen between", value1, value2, "seventeen");
            return (Criteria) this;
        }

        public Criteria andSeventeenNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("seventeen not between", value1, value2, "seventeen");
            return (Criteria) this;
        }

        public Criteria andEighteenIsNull() {
            addCriterion("eighteen is null");
            return (Criteria) this;
        }

        public Criteria andEighteenIsNotNull() {
            addCriterion("eighteen is not null");
            return (Criteria) this;
        }

        public Criteria andEighteenEqualTo(BigDecimal value) {
            addCriterion("eighteen =", value, "eighteen");
            return (Criteria) this;
        }

        public Criteria andEighteenNotEqualTo(BigDecimal value) {
            addCriterion("eighteen <>", value, "eighteen");
            return (Criteria) this;
        }

        public Criteria andEighteenGreaterThan(BigDecimal value) {
            addCriterion("eighteen >", value, "eighteen");
            return (Criteria) this;
        }

        public Criteria andEighteenGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("eighteen >=", value, "eighteen");
            return (Criteria) this;
        }

        public Criteria andEighteenLessThan(BigDecimal value) {
            addCriterion("eighteen <", value, "eighteen");
            return (Criteria) this;
        }

        public Criteria andEighteenLessThanOrEqualTo(BigDecimal value) {
            addCriterion("eighteen <=", value, "eighteen");
            return (Criteria) this;
        }

        public Criteria andEighteenIn(List<BigDecimal> values) {
            addCriterion("eighteen in", values, "eighteen");
            return (Criteria) this;
        }

        public Criteria andEighteenNotIn(List<BigDecimal> values) {
            addCriterion("eighteen not in", values, "eighteen");
            return (Criteria) this;
        }

        public Criteria andEighteenBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("eighteen between", value1, value2, "eighteen");
            return (Criteria) this;
        }

        public Criteria andEighteenNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("eighteen not between", value1, value2, "eighteen");
            return (Criteria) this;
        }

        public Criteria andDailyCasesIsNull() {
            addCriterion("daily_cases is null");
            return (Criteria) this;
        }

        public Criteria andDailyCasesIsNotNull() {
            addCriterion("daily_cases is not null");
            return (Criteria) this;
        }

        public Criteria andDailyCasesEqualTo(Integer value) {
            addCriterion("daily_cases =", value, "dailyCases");
            return (Criteria) this;
        }

        public Criteria andDailyCasesNotEqualTo(Integer value) {
            addCriterion("daily_cases <>", value, "dailyCases");
            return (Criteria) this;
        }

        public Criteria andDailyCasesGreaterThan(Integer value) {
            addCriterion("daily_cases >", value, "dailyCases");
            return (Criteria) this;
        }

        public Criteria andDailyCasesGreaterThanOrEqualTo(Integer value) {
            addCriterion("daily_cases >=", value, "dailyCases");
            return (Criteria) this;
        }

        public Criteria andDailyCasesLessThan(Integer value) {
            addCriterion("daily_cases <", value, "dailyCases");
            return (Criteria) this;
        }

        public Criteria andDailyCasesLessThanOrEqualTo(Integer value) {
            addCriterion("daily_cases <=", value, "dailyCases");
            return (Criteria) this;
        }

        public Criteria andDailyCasesIn(List<Integer> values) {
            addCriterion("daily_cases in", values, "dailyCases");
            return (Criteria) this;
        }

        public Criteria andDailyCasesNotIn(List<Integer> values) {
            addCriterion("daily_cases not in", values, "dailyCases");
            return (Criteria) this;
        }

        public Criteria andDailyCasesBetween(Integer value1, Integer value2) {
            addCriterion("daily_cases between", value1, value2, "dailyCases");
            return (Criteria) this;
        }

        public Criteria andDailyCasesNotBetween(Integer value1, Integer value2) {
            addCriterion("daily_cases not between", value1, value2, "dailyCases");
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