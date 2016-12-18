package com.model;

import java.util.ArrayList;
import java.util.List;

public class ExpenseApplayHotelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExpenseApplayHotelExample() {
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

        public Criteria andStaffIdIsNull() {
            addCriterion("staff_id is null");
            return (Criteria) this;
        }

        public Criteria andStaffIdIsNotNull() {
            addCriterion("staff_id is not null");
            return (Criteria) this;
        }

        public Criteria andStaffIdEqualTo(String value) {
            addCriterion("staff_id =", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotEqualTo(String value) {
            addCriterion("staff_id <>", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdGreaterThan(String value) {
            addCriterion("staff_id >", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdGreaterThanOrEqualTo(String value) {
            addCriterion("staff_id >=", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLessThan(String value) {
            addCriterion("staff_id <", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLessThanOrEqualTo(String value) {
            addCriterion("staff_id <=", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLike(String value) {
            addCriterion("staff_id like", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotLike(String value) {
            addCriterion("staff_id not like", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdIn(List<String> values) {
            addCriterion("staff_id in", values, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotIn(List<String> values) {
            addCriterion("staff_id not in", values, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdBetween(String value1, String value2) {
            addCriterion("staff_id between", value1, value2, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotBetween(String value1, String value2) {
            addCriterion("staff_id not between", value1, value2, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffNameIsNull() {
            addCriterion("staff_name is null");
            return (Criteria) this;
        }

        public Criteria andStaffNameIsNotNull() {
            addCriterion("staff_name is not null");
            return (Criteria) this;
        }

        public Criteria andStaffNameEqualTo(String value) {
            addCriterion("staff_name =", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotEqualTo(String value) {
            addCriterion("staff_name <>", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameGreaterThan(String value) {
            addCriterion("staff_name >", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameGreaterThanOrEqualTo(String value) {
            addCriterion("staff_name >=", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameLessThan(String value) {
            addCriterion("staff_name <", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameLessThanOrEqualTo(String value) {
            addCriterion("staff_name <=", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameLike(String value) {
            addCriterion("staff_name like", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotLike(String value) {
            addCriterion("staff_name not like", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameIn(List<String> values) {
            addCriterion("staff_name in", values, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotIn(List<String> values) {
            addCriterion("staff_name not in", values, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameBetween(String value1, String value2) {
            addCriterion("staff_name between", value1, value2, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotBetween(String value1, String value2) {
            addCriterion("staff_name not between", value1, value2, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffDepartIsNull() {
            addCriterion("staff_depart is null");
            return (Criteria) this;
        }

        public Criteria andStaffDepartIsNotNull() {
            addCriterion("staff_depart is not null");
            return (Criteria) this;
        }

        public Criteria andStaffDepartEqualTo(String value) {
            addCriterion("staff_depart =", value, "staffDepart");
            return (Criteria) this;
        }

        public Criteria andStaffDepartNotEqualTo(String value) {
            addCriterion("staff_depart <>", value, "staffDepart");
            return (Criteria) this;
        }

        public Criteria andStaffDepartGreaterThan(String value) {
            addCriterion("staff_depart >", value, "staffDepart");
            return (Criteria) this;
        }

        public Criteria andStaffDepartGreaterThanOrEqualTo(String value) {
            addCriterion("staff_depart >=", value, "staffDepart");
            return (Criteria) this;
        }

        public Criteria andStaffDepartLessThan(String value) {
            addCriterion("staff_depart <", value, "staffDepart");
            return (Criteria) this;
        }

        public Criteria andStaffDepartLessThanOrEqualTo(String value) {
            addCriterion("staff_depart <=", value, "staffDepart");
            return (Criteria) this;
        }

        public Criteria andStaffDepartLike(String value) {
            addCriterion("staff_depart like", value, "staffDepart");
            return (Criteria) this;
        }

        public Criteria andStaffDepartNotLike(String value) {
            addCriterion("staff_depart not like", value, "staffDepart");
            return (Criteria) this;
        }

        public Criteria andStaffDepartIn(List<String> values) {
            addCriterion("staff_depart in", values, "staffDepart");
            return (Criteria) this;
        }

        public Criteria andStaffDepartNotIn(List<String> values) {
            addCriterion("staff_depart not in", values, "staffDepart");
            return (Criteria) this;
        }

        public Criteria andStaffDepartBetween(String value1, String value2) {
            addCriterion("staff_depart between", value1, value2, "staffDepart");
            return (Criteria) this;
        }

        public Criteria andStaffDepartNotBetween(String value1, String value2) {
            addCriterion("staff_depart not between", value1, value2, "staffDepart");
            return (Criteria) this;
        }

        public Criteria andHotelNameIsNull() {
            addCriterion("hotel_name is null");
            return (Criteria) this;
        }

        public Criteria andHotelNameIsNotNull() {
            addCriterion("hotel_name is not null");
            return (Criteria) this;
        }

        public Criteria andHotelNameEqualTo(String value) {
            addCriterion("hotel_name =", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameNotEqualTo(String value) {
            addCriterion("hotel_name <>", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameGreaterThan(String value) {
            addCriterion("hotel_name >", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_name >=", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameLessThan(String value) {
            addCriterion("hotel_name <", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameLessThanOrEqualTo(String value) {
            addCriterion("hotel_name <=", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameLike(String value) {
            addCriterion("hotel_name like", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameNotLike(String value) {
            addCriterion("hotel_name not like", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameIn(List<String> values) {
            addCriterion("hotel_name in", values, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameNotIn(List<String> values) {
            addCriterion("hotel_name not in", values, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameBetween(String value1, String value2) {
            addCriterion("hotel_name between", value1, value2, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameNotBetween(String value1, String value2) {
            addCriterion("hotel_name not between", value1, value2, "hotelName");
            return (Criteria) this;
        }

        public Criteria andReasonIsNull() {
            addCriterion("reason is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("reason is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("reason =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("reason <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("reason >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("reason >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("reason <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("reason <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("reason like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("reason not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("reason in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("reason not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("reason between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("reason not between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(String value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(String value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(String value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(String value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(String value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(String value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLike(String value) {
            addCriterion("start_time like", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotLike(String value) {
            addCriterion("start_time not like", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<String> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<String> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(String value1, String value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(String value1, String value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(String value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(String value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(String value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(String value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(String value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLike(String value) {
            addCriterion("end_time like", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotLike(String value) {
            addCriterion("end_time not like", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<String> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<String> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(String value1, String value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(String value1, String value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andMoneyCostIsNull() {
            addCriterion("money_cost is null");
            return (Criteria) this;
        }

        public Criteria andMoneyCostIsNotNull() {
            addCriterion("money_cost is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyCostEqualTo(Double value) {
            addCriterion("money_cost =", value, "moneyCost");
            return (Criteria) this;
        }

        public Criteria andMoneyCostNotEqualTo(Double value) {
            addCriterion("money_cost <>", value, "moneyCost");
            return (Criteria) this;
        }

        public Criteria andMoneyCostGreaterThan(Double value) {
            addCriterion("money_cost >", value, "moneyCost");
            return (Criteria) this;
        }

        public Criteria andMoneyCostGreaterThanOrEqualTo(Double value) {
            addCriterion("money_cost >=", value, "moneyCost");
            return (Criteria) this;
        }

        public Criteria andMoneyCostLessThan(Double value) {
            addCriterion("money_cost <", value, "moneyCost");
            return (Criteria) this;
        }

        public Criteria andMoneyCostLessThanOrEqualTo(Double value) {
            addCriterion("money_cost <=", value, "moneyCost");
            return (Criteria) this;
        }

        public Criteria andMoneyCostIn(List<Double> values) {
            addCriterion("money_cost in", values, "moneyCost");
            return (Criteria) this;
        }

        public Criteria andMoneyCostNotIn(List<Double> values) {
            addCriterion("money_cost not in", values, "moneyCost");
            return (Criteria) this;
        }

        public Criteria andMoneyCostBetween(Double value1, Double value2) {
            addCriterion("money_cost between", value1, value2, "moneyCost");
            return (Criteria) this;
        }

        public Criteria andMoneyCostNotBetween(Double value1, Double value2) {
            addCriterion("money_cost not between", value1, value2, "moneyCost");
            return (Criteria) this;
        }

        public Criteria andDaysCostIsNull() {
            addCriterion("days_cost is null");
            return (Criteria) this;
        }

        public Criteria andDaysCostIsNotNull() {
            addCriterion("days_cost is not null");
            return (Criteria) this;
        }

        public Criteria andDaysCostEqualTo(String value) {
            addCriterion("days_cost =", value, "daysCost");
            return (Criteria) this;
        }

        public Criteria andDaysCostNotEqualTo(String value) {
            addCriterion("days_cost <>", value, "daysCost");
            return (Criteria) this;
        }

        public Criteria andDaysCostGreaterThan(String value) {
            addCriterion("days_cost >", value, "daysCost");
            return (Criteria) this;
        }

        public Criteria andDaysCostGreaterThanOrEqualTo(String value) {
            addCriterion("days_cost >=", value, "daysCost");
            return (Criteria) this;
        }

        public Criteria andDaysCostLessThan(String value) {
            addCriterion("days_cost <", value, "daysCost");
            return (Criteria) this;
        }

        public Criteria andDaysCostLessThanOrEqualTo(String value) {
            addCriterion("days_cost <=", value, "daysCost");
            return (Criteria) this;
        }

        public Criteria andDaysCostLike(String value) {
            addCriterion("days_cost like", value, "daysCost");
            return (Criteria) this;
        }

        public Criteria andDaysCostNotLike(String value) {
            addCriterion("days_cost not like", value, "daysCost");
            return (Criteria) this;
        }

        public Criteria andDaysCostIn(List<String> values) {
            addCriterion("days_cost in", values, "daysCost");
            return (Criteria) this;
        }

        public Criteria andDaysCostNotIn(List<String> values) {
            addCriterion("days_cost not in", values, "daysCost");
            return (Criteria) this;
        }

        public Criteria andDaysCostBetween(String value1, String value2) {
            addCriterion("days_cost between", value1, value2, "daysCost");
            return (Criteria) this;
        }

        public Criteria andDaysCostNotBetween(String value1, String value2) {
            addCriterion("days_cost not between", value1, value2, "daysCost");
            return (Criteria) this;
        }

        public Criteria andDetailExplainIsNull() {
            addCriterion("detail_explain is null");
            return (Criteria) this;
        }

        public Criteria andDetailExplainIsNotNull() {
            addCriterion("detail_explain is not null");
            return (Criteria) this;
        }

        public Criteria andDetailExplainEqualTo(String value) {
            addCriterion("detail_explain =", value, "detailExplain");
            return (Criteria) this;
        }

        public Criteria andDetailExplainNotEqualTo(String value) {
            addCriterion("detail_explain <>", value, "detailExplain");
            return (Criteria) this;
        }

        public Criteria andDetailExplainGreaterThan(String value) {
            addCriterion("detail_explain >", value, "detailExplain");
            return (Criteria) this;
        }

        public Criteria andDetailExplainGreaterThanOrEqualTo(String value) {
            addCriterion("detail_explain >=", value, "detailExplain");
            return (Criteria) this;
        }

        public Criteria andDetailExplainLessThan(String value) {
            addCriterion("detail_explain <", value, "detailExplain");
            return (Criteria) this;
        }

        public Criteria andDetailExplainLessThanOrEqualTo(String value) {
            addCriterion("detail_explain <=", value, "detailExplain");
            return (Criteria) this;
        }

        public Criteria andDetailExplainLike(String value) {
            addCriterion("detail_explain like", value, "detailExplain");
            return (Criteria) this;
        }

        public Criteria andDetailExplainNotLike(String value) {
            addCriterion("detail_explain not like", value, "detailExplain");
            return (Criteria) this;
        }

        public Criteria andDetailExplainIn(List<String> values) {
            addCriterion("detail_explain in", values, "detailExplain");
            return (Criteria) this;
        }

        public Criteria andDetailExplainNotIn(List<String> values) {
            addCriterion("detail_explain not in", values, "detailExplain");
            return (Criteria) this;
        }

        public Criteria andDetailExplainBetween(String value1, String value2) {
            addCriterion("detail_explain between", value1, value2, "detailExplain");
            return (Criteria) this;
        }

        public Criteria andDetailExplainNotBetween(String value1, String value2) {
            addCriterion("detail_explain not between", value1, value2, "detailExplain");
            return (Criteria) this;
        }

        public Criteria andStaffUserIdIsNull() {
            addCriterion("staff_user_id is null");
            return (Criteria) this;
        }

        public Criteria andStaffUserIdIsNotNull() {
            addCriterion("staff_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andStaffUserIdEqualTo(String value) {
            addCriterion("staff_user_id =", value, "staffUserId");
            return (Criteria) this;
        }

        public Criteria andStaffUserIdNotEqualTo(String value) {
            addCriterion("staff_user_id <>", value, "staffUserId");
            return (Criteria) this;
        }

        public Criteria andStaffUserIdGreaterThan(String value) {
            addCriterion("staff_user_id >", value, "staffUserId");
            return (Criteria) this;
        }

        public Criteria andStaffUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("staff_user_id >=", value, "staffUserId");
            return (Criteria) this;
        }

        public Criteria andStaffUserIdLessThan(String value) {
            addCriterion("staff_user_id <", value, "staffUserId");
            return (Criteria) this;
        }

        public Criteria andStaffUserIdLessThanOrEqualTo(String value) {
            addCriterion("staff_user_id <=", value, "staffUserId");
            return (Criteria) this;
        }

        public Criteria andStaffUserIdLike(String value) {
            addCriterion("staff_user_id like", value, "staffUserId");
            return (Criteria) this;
        }

        public Criteria andStaffUserIdNotLike(String value) {
            addCriterion("staff_user_id not like", value, "staffUserId");
            return (Criteria) this;
        }

        public Criteria andStaffUserIdIn(List<String> values) {
            addCriterion("staff_user_id in", values, "staffUserId");
            return (Criteria) this;
        }

        public Criteria andStaffUserIdNotIn(List<String> values) {
            addCriterion("staff_user_id not in", values, "staffUserId");
            return (Criteria) this;
        }

        public Criteria andStaffUserIdBetween(String value1, String value2) {
            addCriterion("staff_user_id between", value1, value2, "staffUserId");
            return (Criteria) this;
        }

        public Criteria andStaffUserIdNotBetween(String value1, String value2) {
            addCriterion("staff_user_id not between", value1, value2, "staffUserId");
            return (Criteria) this;
        }

        public Criteria andTripIdIsNull() {
            addCriterion("trip_id is null");
            return (Criteria) this;
        }

        public Criteria andTripIdIsNotNull() {
            addCriterion("trip_id is not null");
            return (Criteria) this;
        }

        public Criteria andTripIdEqualTo(Integer value) {
            addCriterion("trip_id =", value, "tripId");
            return (Criteria) this;
        }

        public Criteria andTripIdNotEqualTo(Integer value) {
            addCriterion("trip_id <>", value, "tripId");
            return (Criteria) this;
        }

        public Criteria andTripIdGreaterThan(Integer value) {
            addCriterion("trip_id >", value, "tripId");
            return (Criteria) this;
        }

        public Criteria andTripIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("trip_id >=", value, "tripId");
            return (Criteria) this;
        }

        public Criteria andTripIdLessThan(Integer value) {
            addCriterion("trip_id <", value, "tripId");
            return (Criteria) this;
        }

        public Criteria andTripIdLessThanOrEqualTo(Integer value) {
            addCriterion("trip_id <=", value, "tripId");
            return (Criteria) this;
        }

        public Criteria andTripIdIn(List<Integer> values) {
            addCriterion("trip_id in", values, "tripId");
            return (Criteria) this;
        }

        public Criteria andTripIdNotIn(List<Integer> values) {
            addCriterion("trip_id not in", values, "tripId");
            return (Criteria) this;
        }

        public Criteria andTripIdBetween(Integer value1, Integer value2) {
            addCriterion("trip_id between", value1, value2, "tripId");
            return (Criteria) this;
        }

        public Criteria andTripIdNotBetween(Integer value1, Integer value2) {
            addCriterion("trip_id not between", value1, value2, "tripId");
            return (Criteria) this;
        }

        public Criteria andApplayStatusIsNull() {
            addCriterion("applay_status is null");
            return (Criteria) this;
        }

        public Criteria andApplayStatusIsNotNull() {
            addCriterion("applay_status is not null");
            return (Criteria) this;
        }

        public Criteria andApplayStatusEqualTo(String value) {
            addCriterion("applay_status =", value, "applayStatus");
            return (Criteria) this;
        }

        public Criteria andApplayStatusNotEqualTo(String value) {
            addCriterion("applay_status <>", value, "applayStatus");
            return (Criteria) this;
        }

        public Criteria andApplayStatusGreaterThan(String value) {
            addCriterion("applay_status >", value, "applayStatus");
            return (Criteria) this;
        }

        public Criteria andApplayStatusGreaterThanOrEqualTo(String value) {
            addCriterion("applay_status >=", value, "applayStatus");
            return (Criteria) this;
        }

        public Criteria andApplayStatusLessThan(String value) {
            addCriterion("applay_status <", value, "applayStatus");
            return (Criteria) this;
        }

        public Criteria andApplayStatusLessThanOrEqualTo(String value) {
            addCriterion("applay_status <=", value, "applayStatus");
            return (Criteria) this;
        }

        public Criteria andApplayStatusLike(String value) {
            addCriterion("applay_status like", value, "applayStatus");
            return (Criteria) this;
        }

        public Criteria andApplayStatusNotLike(String value) {
            addCriterion("applay_status not like", value, "applayStatus");
            return (Criteria) this;
        }

        public Criteria andApplayStatusIn(List<String> values) {
            addCriterion("applay_status in", values, "applayStatus");
            return (Criteria) this;
        }

        public Criteria andApplayStatusNotIn(List<String> values) {
            addCriterion("applay_status not in", values, "applayStatus");
            return (Criteria) this;
        }

        public Criteria andApplayStatusBetween(String value1, String value2) {
            addCriterion("applay_status between", value1, value2, "applayStatus");
            return (Criteria) this;
        }

        public Criteria andApplayStatusNotBetween(String value1, String value2) {
            addCriterion("applay_status not between", value1, value2, "applayStatus");
            return (Criteria) this;
        }

        public Criteria andImageUrlIsNull() {
            addCriterion("image_url is null");
            return (Criteria) this;
        }

        public Criteria andImageUrlIsNotNull() {
            addCriterion("image_url is not null");
            return (Criteria) this;
        }

        public Criteria andImageUrlEqualTo(String value) {
            addCriterion("image_url =", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotEqualTo(String value) {
            addCriterion("image_url <>", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlGreaterThan(String value) {
            addCriterion("image_url >", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("image_url >=", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlLessThan(String value) {
            addCriterion("image_url <", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlLessThanOrEqualTo(String value) {
            addCriterion("image_url <=", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlLike(String value) {
            addCriterion("image_url like", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotLike(String value) {
            addCriterion("image_url not like", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlIn(List<String> values) {
            addCriterion("image_url in", values, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotIn(List<String> values) {
            addCriterion("image_url not in", values, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlBetween(String value1, String value2) {
            addCriterion("image_url between", value1, value2, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotBetween(String value1, String value2) {
            addCriterion("image_url not between", value1, value2, "imageUrl");
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