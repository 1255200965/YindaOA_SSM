package com.model;

import java.util.ArrayList;
import java.util.List;

public class YoAnnualVacationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public YoAnnualVacationExample() {
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

        public Criteria andAvSequenceNoIsNull() {
            addCriterion("av_sequence_no is null");
            return (Criteria) this;
        }

        public Criteria andAvSequenceNoIsNotNull() {
            addCriterion("av_sequence_no is not null");
            return (Criteria) this;
        }

        public Criteria andAvSequenceNoEqualTo(Integer value) {
            addCriterion("av_sequence_no =", value, "avSequenceNo");
            return (Criteria) this;
        }

        public Criteria andAvSequenceNoNotEqualTo(Integer value) {
            addCriterion("av_sequence_no <>", value, "avSequenceNo");
            return (Criteria) this;
        }

        public Criteria andAvSequenceNoGreaterThan(Integer value) {
            addCriterion("av_sequence_no >", value, "avSequenceNo");
            return (Criteria) this;
        }

        public Criteria andAvSequenceNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("av_sequence_no >=", value, "avSequenceNo");
            return (Criteria) this;
        }

        public Criteria andAvSequenceNoLessThan(Integer value) {
            addCriterion("av_sequence_no <", value, "avSequenceNo");
            return (Criteria) this;
        }

        public Criteria andAvSequenceNoLessThanOrEqualTo(Integer value) {
            addCriterion("av_sequence_no <=", value, "avSequenceNo");
            return (Criteria) this;
        }

        public Criteria andAvSequenceNoIn(List<Integer> values) {
            addCriterion("av_sequence_no in", values, "avSequenceNo");
            return (Criteria) this;
        }

        public Criteria andAvSequenceNoNotIn(List<Integer> values) {
            addCriterion("av_sequence_no not in", values, "avSequenceNo");
            return (Criteria) this;
        }

        public Criteria andAvSequenceNoBetween(Integer value1, Integer value2) {
            addCriterion("av_sequence_no between", value1, value2, "avSequenceNo");
            return (Criteria) this;
        }

        public Criteria andAvSequenceNoNotBetween(Integer value1, Integer value2) {
            addCriterion("av_sequence_no not between", value1, value2, "avSequenceNo");
            return (Criteria) this;
        }

        public Criteria andAvDingdingUserIdIsNull() {
            addCriterion("av_dingding_user_id is null");
            return (Criteria) this;
        }

        public Criteria andAvDingdingUserIdIsNotNull() {
            addCriterion("av_dingding_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andAvDingdingUserIdEqualTo(String value) {
            addCriterion("av_dingding_user_id =", value, "avDingdingUserId");
            return (Criteria) this;
        }

        public Criteria andAvDingdingUserIdNotEqualTo(String value) {
            addCriterion("av_dingding_user_id <>", value, "avDingdingUserId");
            return (Criteria) this;
        }

        public Criteria andAvDingdingUserIdGreaterThan(String value) {
            addCriterion("av_dingding_user_id >", value, "avDingdingUserId");
            return (Criteria) this;
        }

        public Criteria andAvDingdingUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("av_dingding_user_id >=", value, "avDingdingUserId");
            return (Criteria) this;
        }

        public Criteria andAvDingdingUserIdLessThan(String value) {
            addCriterion("av_dingding_user_id <", value, "avDingdingUserId");
            return (Criteria) this;
        }

        public Criteria andAvDingdingUserIdLessThanOrEqualTo(String value) {
            addCriterion("av_dingding_user_id <=", value, "avDingdingUserId");
            return (Criteria) this;
        }

        public Criteria andAvDingdingUserIdLike(String value) {
            addCriterion("av_dingding_user_id like", value, "avDingdingUserId");
            return (Criteria) this;
        }

        public Criteria andAvDingdingUserIdNotLike(String value) {
            addCriterion("av_dingding_user_id not like", value, "avDingdingUserId");
            return (Criteria) this;
        }

        public Criteria andAvDingdingUserIdIn(List<String> values) {
            addCriterion("av_dingding_user_id in", values, "avDingdingUserId");
            return (Criteria) this;
        }

        public Criteria andAvDingdingUserIdNotIn(List<String> values) {
            addCriterion("av_dingding_user_id not in", values, "avDingdingUserId");
            return (Criteria) this;
        }

        public Criteria andAvDingdingUserIdBetween(String value1, String value2) {
            addCriterion("av_dingding_user_id between", value1, value2, "avDingdingUserId");
            return (Criteria) this;
        }

        public Criteria andAvDingdingUserIdNotBetween(String value1, String value2) {
            addCriterion("av_dingding_user_id not between", value1, value2, "avDingdingUserId");
            return (Criteria) this;
        }

        public Criteria andAvNameIsNull() {
            addCriterion("av_name is null");
            return (Criteria) this;
        }

        public Criteria andAvNameIsNotNull() {
            addCriterion("av_name is not null");
            return (Criteria) this;
        }

        public Criteria andAvNameEqualTo(String value) {
            addCriterion("av_name =", value, "avName");
            return (Criteria) this;
        }

        public Criteria andAvNameNotEqualTo(String value) {
            addCriterion("av_name <>", value, "avName");
            return (Criteria) this;
        }

        public Criteria andAvNameGreaterThan(String value) {
            addCriterion("av_name >", value, "avName");
            return (Criteria) this;
        }

        public Criteria andAvNameGreaterThanOrEqualTo(String value) {
            addCriterion("av_name >=", value, "avName");
            return (Criteria) this;
        }

        public Criteria andAvNameLessThan(String value) {
            addCriterion("av_name <", value, "avName");
            return (Criteria) this;
        }

        public Criteria andAvNameLessThanOrEqualTo(String value) {
            addCriterion("av_name <=", value, "avName");
            return (Criteria) this;
        }

        public Criteria andAvNameLike(String value) {
            addCriterion("av_name like", value, "avName");
            return (Criteria) this;
        }

        public Criteria andAvNameNotLike(String value) {
            addCriterion("av_name not like", value, "avName");
            return (Criteria) this;
        }

        public Criteria andAvNameIn(List<String> values) {
            addCriterion("av_name in", values, "avName");
            return (Criteria) this;
        }

        public Criteria andAvNameNotIn(List<String> values) {
            addCriterion("av_name not in", values, "avName");
            return (Criteria) this;
        }

        public Criteria andAvNameBetween(String value1, String value2) {
            addCriterion("av_name between", value1, value2, "avName");
            return (Criteria) this;
        }

        public Criteria andAvNameNotBetween(String value1, String value2) {
            addCriterion("av_name not between", value1, value2, "avName");
            return (Criteria) this;
        }

        public Criteria andAvStaffIdIsNull() {
            addCriterion("av_staff_id is null");
            return (Criteria) this;
        }

        public Criteria andAvStaffIdIsNotNull() {
            addCriterion("av_staff_id is not null");
            return (Criteria) this;
        }

        public Criteria andAvStaffIdEqualTo(String value) {
            addCriterion("av_staff_id =", value, "avStaffId");
            return (Criteria) this;
        }

        public Criteria andAvStaffIdNotEqualTo(String value) {
            addCriterion("av_staff_id <>", value, "avStaffId");
            return (Criteria) this;
        }

        public Criteria andAvStaffIdGreaterThan(String value) {
            addCriterion("av_staff_id >", value, "avStaffId");
            return (Criteria) this;
        }

        public Criteria andAvStaffIdGreaterThanOrEqualTo(String value) {
            addCriterion("av_staff_id >=", value, "avStaffId");
            return (Criteria) this;
        }

        public Criteria andAvStaffIdLessThan(String value) {
            addCriterion("av_staff_id <", value, "avStaffId");
            return (Criteria) this;
        }

        public Criteria andAvStaffIdLessThanOrEqualTo(String value) {
            addCriterion("av_staff_id <=", value, "avStaffId");
            return (Criteria) this;
        }

        public Criteria andAvStaffIdLike(String value) {
            addCriterion("av_staff_id like", value, "avStaffId");
            return (Criteria) this;
        }

        public Criteria andAvStaffIdNotLike(String value) {
            addCriterion("av_staff_id not like", value, "avStaffId");
            return (Criteria) this;
        }

        public Criteria andAvStaffIdIn(List<String> values) {
            addCriterion("av_staff_id in", values, "avStaffId");
            return (Criteria) this;
        }

        public Criteria andAvStaffIdNotIn(List<String> values) {
            addCriterion("av_staff_id not in", values, "avStaffId");
            return (Criteria) this;
        }

        public Criteria andAvStaffIdBetween(String value1, String value2) {
            addCriterion("av_staff_id between", value1, value2, "avStaffId");
            return (Criteria) this;
        }

        public Criteria andAvStaffIdNotBetween(String value1, String value2) {
            addCriterion("av_staff_id not between", value1, value2, "avStaffId");
            return (Criteria) this;
        }

        public Criteria andAvDepartmentIsNull() {
            addCriterion("av_department is null");
            return (Criteria) this;
        }

        public Criteria andAvDepartmentIsNotNull() {
            addCriterion("av_department is not null");
            return (Criteria) this;
        }

        public Criteria andAvDepartmentEqualTo(String value) {
            addCriterion("av_department =", value, "avDepartment");
            return (Criteria) this;
        }

        public Criteria andAvDepartmentNotEqualTo(String value) {
            addCriterion("av_department <>", value, "avDepartment");
            return (Criteria) this;
        }

        public Criteria andAvDepartmentGreaterThan(String value) {
            addCriterion("av_department >", value, "avDepartment");
            return (Criteria) this;
        }

        public Criteria andAvDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("av_department >=", value, "avDepartment");
            return (Criteria) this;
        }

        public Criteria andAvDepartmentLessThan(String value) {
            addCriterion("av_department <", value, "avDepartment");
            return (Criteria) this;
        }

        public Criteria andAvDepartmentLessThanOrEqualTo(String value) {
            addCriterion("av_department <=", value, "avDepartment");
            return (Criteria) this;
        }

        public Criteria andAvDepartmentLike(String value) {
            addCriterion("av_department like", value, "avDepartment");
            return (Criteria) this;
        }

        public Criteria andAvDepartmentNotLike(String value) {
            addCriterion("av_department not like", value, "avDepartment");
            return (Criteria) this;
        }

        public Criteria andAvDepartmentIn(List<String> values) {
            addCriterion("av_department in", values, "avDepartment");
            return (Criteria) this;
        }

        public Criteria andAvDepartmentNotIn(List<String> values) {
            addCriterion("av_department not in", values, "avDepartment");
            return (Criteria) this;
        }

        public Criteria andAvDepartmentBetween(String value1, String value2) {
            addCriterion("av_department between", value1, value2, "avDepartment");
            return (Criteria) this;
        }

        public Criteria andAvDepartmentNotBetween(String value1, String value2) {
            addCriterion("av_department not between", value1, value2, "avDepartment");
            return (Criteria) this;
        }

        public Criteria andAvYearIsNull() {
            addCriterion("av_year is null");
            return (Criteria) this;
        }

        public Criteria andAvYearIsNotNull() {
            addCriterion("av_year is not null");
            return (Criteria) this;
        }

        public Criteria andAvYearEqualTo(Integer value) {
            addCriterion("av_year =", value, "avYear");
            return (Criteria) this;
        }

        public Criteria andAvYearNotEqualTo(Integer value) {
            addCriterion("av_year <>", value, "avYear");
            return (Criteria) this;
        }

        public Criteria andAvYearGreaterThan(Integer value) {
            addCriterion("av_year >", value, "avYear");
            return (Criteria) this;
        }

        public Criteria andAvYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("av_year >=", value, "avYear");
            return (Criteria) this;
        }

        public Criteria andAvYearLessThan(Integer value) {
            addCriterion("av_year <", value, "avYear");
            return (Criteria) this;
        }

        public Criteria andAvYearLessThanOrEqualTo(Integer value) {
            addCriterion("av_year <=", value, "avYear");
            return (Criteria) this;
        }

        public Criteria andAvYearIn(List<Integer> values) {
            addCriterion("av_year in", values, "avYear");
            return (Criteria) this;
        }

        public Criteria andAvYearNotIn(List<Integer> values) {
            addCriterion("av_year not in", values, "avYear");
            return (Criteria) this;
        }

        public Criteria andAvYearBetween(Integer value1, Integer value2) {
            addCriterion("av_year between", value1, value2, "avYear");
            return (Criteria) this;
        }

        public Criteria andAvYearNotBetween(Integer value1, Integer value2) {
            addCriterion("av_year not between", value1, value2, "avYear");
            return (Criteria) this;
        }

        public Criteria andAvLeftVecationDaysIsNull() {
            addCriterion("av_left_vecation_days is null");
            return (Criteria) this;
        }

        public Criteria andAvLeftVecationDaysIsNotNull() {
            addCriterion("av_left_vecation_days is not null");
            return (Criteria) this;
        }

        public Criteria andAvLeftVecationDaysEqualTo(Float value) {
            addCriterion("av_left_vecation_days =", value, "avLeftVecationDays");
            return (Criteria) this;
        }

        public Criteria andAvLeftVecationDaysNotEqualTo(Float value) {
            addCriterion("av_left_vecation_days <>", value, "avLeftVecationDays");
            return (Criteria) this;
        }

        public Criteria andAvLeftVecationDaysGreaterThan(Float value) {
            addCriterion("av_left_vecation_days >", value, "avLeftVecationDays");
            return (Criteria) this;
        }

        public Criteria andAvLeftVecationDaysGreaterThanOrEqualTo(Float value) {
            addCriterion("av_left_vecation_days >=", value, "avLeftVecationDays");
            return (Criteria) this;
        }

        public Criteria andAvLeftVecationDaysLessThan(Float value) {
            addCriterion("av_left_vecation_days <", value, "avLeftVecationDays");
            return (Criteria) this;
        }

        public Criteria andAvLeftVecationDaysLessThanOrEqualTo(Float value) {
            addCriterion("av_left_vecation_days <=", value, "avLeftVecationDays");
            return (Criteria) this;
        }

        public Criteria andAvLeftVecationDaysIn(List<Float> values) {
            addCriterion("av_left_vecation_days in", values, "avLeftVecationDays");
            return (Criteria) this;
        }

        public Criteria andAvLeftVecationDaysNotIn(List<Float> values) {
            addCriterion("av_left_vecation_days not in", values, "avLeftVecationDays");
            return (Criteria) this;
        }

        public Criteria andAvLeftVecationDaysBetween(Float value1, Float value2) {
            addCriterion("av_left_vecation_days between", value1, value2, "avLeftVecationDays");
            return (Criteria) this;
        }

        public Criteria andAvLeftVecationDaysNotBetween(Float value1, Float value2) {
            addCriterion("av_left_vecation_days not between", value1, value2, "avLeftVecationDays");
            return (Criteria) this;
        }

        public Criteria andAvLeftDaysoffDaysIsNull() {
            addCriterion("av_left_daysoff_days is null");
            return (Criteria) this;
        }

        public Criteria andAvLeftDaysoffDaysIsNotNull() {
            addCriterion("av_left_daysoff_days is not null");
            return (Criteria) this;
        }

        public Criteria andAvLeftDaysoffDaysEqualTo(String value) {
            addCriterion("av_left_daysoff_days =", value, "avLeftDaysoffDays");
            return (Criteria) this;
        }

        public Criteria andAvLeftDaysoffDaysNotEqualTo(String value) {
            addCriterion("av_left_daysoff_days <>", value, "avLeftDaysoffDays");
            return (Criteria) this;
        }

        public Criteria andAvLeftDaysoffDaysGreaterThan(String value) {
            addCriterion("av_left_daysoff_days >", value, "avLeftDaysoffDays");
            return (Criteria) this;
        }

        public Criteria andAvLeftDaysoffDaysGreaterThanOrEqualTo(String value) {
            addCriterion("av_left_daysoff_days >=", value, "avLeftDaysoffDays");
            return (Criteria) this;
        }

        public Criteria andAvLeftDaysoffDaysLessThan(String value) {
            addCriterion("av_left_daysoff_days <", value, "avLeftDaysoffDays");
            return (Criteria) this;
        }

        public Criteria andAvLeftDaysoffDaysLessThanOrEqualTo(String value) {
            addCriterion("av_left_daysoff_days <=", value, "avLeftDaysoffDays");
            return (Criteria) this;
        }

        public Criteria andAvLeftDaysoffDaysLike(String value) {
            addCriterion("av_left_daysoff_days like", value, "avLeftDaysoffDays");
            return (Criteria) this;
        }

        public Criteria andAvLeftDaysoffDaysNotLike(String value) {
            addCriterion("av_left_daysoff_days not like", value, "avLeftDaysoffDays");
            return (Criteria) this;
        }

        public Criteria andAvLeftDaysoffDaysIn(List<String> values) {
            addCriterion("av_left_daysoff_days in", values, "avLeftDaysoffDays");
            return (Criteria) this;
        }

        public Criteria andAvLeftDaysoffDaysNotIn(List<String> values) {
            addCriterion("av_left_daysoff_days not in", values, "avLeftDaysoffDays");
            return (Criteria) this;
        }

        public Criteria andAvLeftDaysoffDaysBetween(String value1, String value2) {
            addCriterion("av_left_daysoff_days between", value1, value2, "avLeftDaysoffDays");
            return (Criteria) this;
        }

        public Criteria andAvLeftDaysoffDaysNotBetween(String value1, String value2) {
            addCriterion("av_left_daysoff_days not between", value1, value2, "avLeftDaysoffDays");
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