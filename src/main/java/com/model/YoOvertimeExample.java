package com.model;

import java.util.ArrayList;
import java.util.List;

public class YoOvertimeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public YoOvertimeExample() {
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

        public Criteria andOtSequenceNoIsNull() {
            addCriterion("ot_sequence_no is null");
            return (Criteria) this;
        }

        public Criteria andOtSequenceNoIsNotNull() {
            addCriterion("ot_sequence_no is not null");
            return (Criteria) this;
        }

        public Criteria andOtSequenceNoEqualTo(Integer value) {
            addCriterion("ot_sequence_no =", value, "otSequenceNo");
            return (Criteria) this;
        }

        public Criteria andOtSequenceNoNotEqualTo(Integer value) {
            addCriterion("ot_sequence_no <>", value, "otSequenceNo");
            return (Criteria) this;
        }

        public Criteria andOtSequenceNoGreaterThan(Integer value) {
            addCriterion("ot_sequence_no >", value, "otSequenceNo");
            return (Criteria) this;
        }

        public Criteria andOtSequenceNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("ot_sequence_no >=", value, "otSequenceNo");
            return (Criteria) this;
        }

        public Criteria andOtSequenceNoLessThan(Integer value) {
            addCriterion("ot_sequence_no <", value, "otSequenceNo");
            return (Criteria) this;
        }

        public Criteria andOtSequenceNoLessThanOrEqualTo(Integer value) {
            addCriterion("ot_sequence_no <=", value, "otSequenceNo");
            return (Criteria) this;
        }

        public Criteria andOtSequenceNoIn(List<Integer> values) {
            addCriterion("ot_sequence_no in", values, "otSequenceNo");
            return (Criteria) this;
        }

        public Criteria andOtSequenceNoNotIn(List<Integer> values) {
            addCriterion("ot_sequence_no not in", values, "otSequenceNo");
            return (Criteria) this;
        }

        public Criteria andOtSequenceNoBetween(Integer value1, Integer value2) {
            addCriterion("ot_sequence_no between", value1, value2, "otSequenceNo");
            return (Criteria) this;
        }

        public Criteria andOtSequenceNoNotBetween(Integer value1, Integer value2) {
            addCriterion("ot_sequence_no not between", value1, value2, "otSequenceNo");
            return (Criteria) this;
        }

        public Criteria andOtApproveNoIsNull() {
            addCriterion("ot_approve_no is null");
            return (Criteria) this;
        }

        public Criteria andOtApproveNoIsNotNull() {
            addCriterion("ot_approve_no is not null");
            return (Criteria) this;
        }

        public Criteria andOtApproveNoEqualTo(String value) {
            addCriterion("ot_approve_no =", value, "otApproveNo");
            return (Criteria) this;
        }

        public Criteria andOtApproveNoNotEqualTo(String value) {
            addCriterion("ot_approve_no <>", value, "otApproveNo");
            return (Criteria) this;
        }

        public Criteria andOtApproveNoGreaterThan(String value) {
            addCriterion("ot_approve_no >", value, "otApproveNo");
            return (Criteria) this;
        }

        public Criteria andOtApproveNoGreaterThanOrEqualTo(String value) {
            addCriterion("ot_approve_no >=", value, "otApproveNo");
            return (Criteria) this;
        }

        public Criteria andOtApproveNoLessThan(String value) {
            addCriterion("ot_approve_no <", value, "otApproveNo");
            return (Criteria) this;
        }

        public Criteria andOtApproveNoLessThanOrEqualTo(String value) {
            addCriterion("ot_approve_no <=", value, "otApproveNo");
            return (Criteria) this;
        }

        public Criteria andOtApproveNoLike(String value) {
            addCriterion("ot_approve_no like", value, "otApproveNo");
            return (Criteria) this;
        }

        public Criteria andOtApproveNoNotLike(String value) {
            addCriterion("ot_approve_no not like", value, "otApproveNo");
            return (Criteria) this;
        }

        public Criteria andOtApproveNoIn(List<String> values) {
            addCriterion("ot_approve_no in", values, "otApproveNo");
            return (Criteria) this;
        }

        public Criteria andOtApproveNoNotIn(List<String> values) {
            addCriterion("ot_approve_no not in", values, "otApproveNo");
            return (Criteria) this;
        }

        public Criteria andOtApproveNoBetween(String value1, String value2) {
            addCriterion("ot_approve_no between", value1, value2, "otApproveNo");
            return (Criteria) this;
        }

        public Criteria andOtApproveNoNotBetween(String value1, String value2) {
            addCriterion("ot_approve_no not between", value1, value2, "otApproveNo");
            return (Criteria) this;
        }

        public Criteria andOtTitleIsNull() {
            addCriterion("ot_title is null");
            return (Criteria) this;
        }

        public Criteria andOtTitleIsNotNull() {
            addCriterion("ot_title is not null");
            return (Criteria) this;
        }

        public Criteria andOtTitleEqualTo(String value) {
            addCriterion("ot_title =", value, "otTitle");
            return (Criteria) this;
        }

        public Criteria andOtTitleNotEqualTo(String value) {
            addCriterion("ot_title <>", value, "otTitle");
            return (Criteria) this;
        }

        public Criteria andOtTitleGreaterThan(String value) {
            addCriterion("ot_title >", value, "otTitle");
            return (Criteria) this;
        }

        public Criteria andOtTitleGreaterThanOrEqualTo(String value) {
            addCriterion("ot_title >=", value, "otTitle");
            return (Criteria) this;
        }

        public Criteria andOtTitleLessThan(String value) {
            addCriterion("ot_title <", value, "otTitle");
            return (Criteria) this;
        }

        public Criteria andOtTitleLessThanOrEqualTo(String value) {
            addCriterion("ot_title <=", value, "otTitle");
            return (Criteria) this;
        }

        public Criteria andOtTitleLike(String value) {
            addCriterion("ot_title like", value, "otTitle");
            return (Criteria) this;
        }

        public Criteria andOtTitleNotLike(String value) {
            addCriterion("ot_title not like", value, "otTitle");
            return (Criteria) this;
        }

        public Criteria andOtTitleIn(List<String> values) {
            addCriterion("ot_title in", values, "otTitle");
            return (Criteria) this;
        }

        public Criteria andOtTitleNotIn(List<String> values) {
            addCriterion("ot_title not in", values, "otTitle");
            return (Criteria) this;
        }

        public Criteria andOtTitleBetween(String value1, String value2) {
            addCriterion("ot_title between", value1, value2, "otTitle");
            return (Criteria) this;
        }

        public Criteria andOtTitleNotBetween(String value1, String value2) {
            addCriterion("ot_title not between", value1, value2, "otTitle");
            return (Criteria) this;
        }

        public Criteria andOtApproveStateIsNull() {
            addCriterion("ot_approve_state is null");
            return (Criteria) this;
        }

        public Criteria andOtApproveStateIsNotNull() {
            addCriterion("ot_approve_state is not null");
            return (Criteria) this;
        }

        public Criteria andOtApproveStateEqualTo(String value) {
            addCriterion("ot_approve_state =", value, "otApproveState");
            return (Criteria) this;
        }

        public Criteria andOtApproveStateNotEqualTo(String value) {
            addCriterion("ot_approve_state <>", value, "otApproveState");
            return (Criteria) this;
        }

        public Criteria andOtApproveStateGreaterThan(String value) {
            addCriterion("ot_approve_state >", value, "otApproveState");
            return (Criteria) this;
        }

        public Criteria andOtApproveStateGreaterThanOrEqualTo(String value) {
            addCriterion("ot_approve_state >=", value, "otApproveState");
            return (Criteria) this;
        }

        public Criteria andOtApproveStateLessThan(String value) {
            addCriterion("ot_approve_state <", value, "otApproveState");
            return (Criteria) this;
        }

        public Criteria andOtApproveStateLessThanOrEqualTo(String value) {
            addCriterion("ot_approve_state <=", value, "otApproveState");
            return (Criteria) this;
        }

        public Criteria andOtApproveStateLike(String value) {
            addCriterion("ot_approve_state like", value, "otApproveState");
            return (Criteria) this;
        }

        public Criteria andOtApproveStateNotLike(String value) {
            addCriterion("ot_approve_state not like", value, "otApproveState");
            return (Criteria) this;
        }

        public Criteria andOtApproveStateIn(List<String> values) {
            addCriterion("ot_approve_state in", values, "otApproveState");
            return (Criteria) this;
        }

        public Criteria andOtApproveStateNotIn(List<String> values) {
            addCriterion("ot_approve_state not in", values, "otApproveState");
            return (Criteria) this;
        }

        public Criteria andOtApproveStateBetween(String value1, String value2) {
            addCriterion("ot_approve_state between", value1, value2, "otApproveState");
            return (Criteria) this;
        }

        public Criteria andOtApproveStateNotBetween(String value1, String value2) {
            addCriterion("ot_approve_state not between", value1, value2, "otApproveState");
            return (Criteria) this;
        }

        public Criteria andOtApproveResultIsNull() {
            addCriterion("ot_approve_result is null");
            return (Criteria) this;
        }

        public Criteria andOtApproveResultIsNotNull() {
            addCriterion("ot_approve_result is not null");
            return (Criteria) this;
        }

        public Criteria andOtApproveResultEqualTo(String value) {
            addCriterion("ot_approve_result =", value, "otApproveResult");
            return (Criteria) this;
        }

        public Criteria andOtApproveResultNotEqualTo(String value) {
            addCriterion("ot_approve_result <>", value, "otApproveResult");
            return (Criteria) this;
        }

        public Criteria andOtApproveResultGreaterThan(String value) {
            addCriterion("ot_approve_result >", value, "otApproveResult");
            return (Criteria) this;
        }

        public Criteria andOtApproveResultGreaterThanOrEqualTo(String value) {
            addCriterion("ot_approve_result >=", value, "otApproveResult");
            return (Criteria) this;
        }

        public Criteria andOtApproveResultLessThan(String value) {
            addCriterion("ot_approve_result <", value, "otApproveResult");
            return (Criteria) this;
        }

        public Criteria andOtApproveResultLessThanOrEqualTo(String value) {
            addCriterion("ot_approve_result <=", value, "otApproveResult");
            return (Criteria) this;
        }

        public Criteria andOtApproveResultLike(String value) {
            addCriterion("ot_approve_result like", value, "otApproveResult");
            return (Criteria) this;
        }

        public Criteria andOtApproveResultNotLike(String value) {
            addCriterion("ot_approve_result not like", value, "otApproveResult");
            return (Criteria) this;
        }

        public Criteria andOtApproveResultIn(List<String> values) {
            addCriterion("ot_approve_result in", values, "otApproveResult");
            return (Criteria) this;
        }

        public Criteria andOtApproveResultNotIn(List<String> values) {
            addCriterion("ot_approve_result not in", values, "otApproveResult");
            return (Criteria) this;
        }

        public Criteria andOtApproveResultBetween(String value1, String value2) {
            addCriterion("ot_approve_result between", value1, value2, "otApproveResult");
            return (Criteria) this;
        }

        public Criteria andOtApproveResultNotBetween(String value1, String value2) {
            addCriterion("ot_approve_result not between", value1, value2, "otApproveResult");
            return (Criteria) this;
        }

        public Criteria andOtApproveBeginIsNull() {
            addCriterion("ot_approve_begin is null");
            return (Criteria) this;
        }

        public Criteria andOtApproveBeginIsNotNull() {
            addCriterion("ot_approve_begin is not null");
            return (Criteria) this;
        }

        public Criteria andOtApproveBeginEqualTo(String value) {
            addCriterion("ot_approve_begin =", value, "otApproveBegin");
            return (Criteria) this;
        }

        public Criteria andOtApproveBeginNotEqualTo(String value) {
            addCriterion("ot_approve_begin <>", value, "otApproveBegin");
            return (Criteria) this;
        }

        public Criteria andOtApproveBeginGreaterThan(String value) {
            addCriterion("ot_approve_begin >", value, "otApproveBegin");
            return (Criteria) this;
        }

        public Criteria andOtApproveBeginGreaterThanOrEqualTo(String value) {
            addCriterion("ot_approve_begin >=", value, "otApproveBegin");
            return (Criteria) this;
        }

        public Criteria andOtApproveBeginLessThan(String value) {
            addCriterion("ot_approve_begin <", value, "otApproveBegin");
            return (Criteria) this;
        }

        public Criteria andOtApproveBeginLessThanOrEqualTo(String value) {
            addCriterion("ot_approve_begin <=", value, "otApproveBegin");
            return (Criteria) this;
        }

        public Criteria andOtApproveBeginLike(String value) {
            addCriterion("ot_approve_begin like", value, "otApproveBegin");
            return (Criteria) this;
        }

        public Criteria andOtApproveBeginNotLike(String value) {
            addCriterion("ot_approve_begin not like", value, "otApproveBegin");
            return (Criteria) this;
        }

        public Criteria andOtApproveBeginIn(List<String> values) {
            addCriterion("ot_approve_begin in", values, "otApproveBegin");
            return (Criteria) this;
        }

        public Criteria andOtApproveBeginNotIn(List<String> values) {
            addCriterion("ot_approve_begin not in", values, "otApproveBegin");
            return (Criteria) this;
        }

        public Criteria andOtApproveBeginBetween(String value1, String value2) {
            addCriterion("ot_approve_begin between", value1, value2, "otApproveBegin");
            return (Criteria) this;
        }

        public Criteria andOtApproveBeginNotBetween(String value1, String value2) {
            addCriterion("ot_approve_begin not between", value1, value2, "otApproveBegin");
            return (Criteria) this;
        }

        public Criteria andOtApproveEndIsNull() {
            addCriterion("ot_approve_end is null");
            return (Criteria) this;
        }

        public Criteria andOtApproveEndIsNotNull() {
            addCriterion("ot_approve_end is not null");
            return (Criteria) this;
        }

        public Criteria andOtApproveEndEqualTo(String value) {
            addCriterion("ot_approve_end =", value, "otApproveEnd");
            return (Criteria) this;
        }

        public Criteria andOtApproveEndNotEqualTo(String value) {
            addCriterion("ot_approve_end <>", value, "otApproveEnd");
            return (Criteria) this;
        }

        public Criteria andOtApproveEndGreaterThan(String value) {
            addCriterion("ot_approve_end >", value, "otApproveEnd");
            return (Criteria) this;
        }

        public Criteria andOtApproveEndGreaterThanOrEqualTo(String value) {
            addCriterion("ot_approve_end >=", value, "otApproveEnd");
            return (Criteria) this;
        }

        public Criteria andOtApproveEndLessThan(String value) {
            addCriterion("ot_approve_end <", value, "otApproveEnd");
            return (Criteria) this;
        }

        public Criteria andOtApproveEndLessThanOrEqualTo(String value) {
            addCriterion("ot_approve_end <=", value, "otApproveEnd");
            return (Criteria) this;
        }

        public Criteria andOtApproveEndLike(String value) {
            addCriterion("ot_approve_end like", value, "otApproveEnd");
            return (Criteria) this;
        }

        public Criteria andOtApproveEndNotLike(String value) {
            addCriterion("ot_approve_end not like", value, "otApproveEnd");
            return (Criteria) this;
        }

        public Criteria andOtApproveEndIn(List<String> values) {
            addCriterion("ot_approve_end in", values, "otApproveEnd");
            return (Criteria) this;
        }

        public Criteria andOtApproveEndNotIn(List<String> values) {
            addCriterion("ot_approve_end not in", values, "otApproveEnd");
            return (Criteria) this;
        }

        public Criteria andOtApproveEndBetween(String value1, String value2) {
            addCriterion("ot_approve_end between", value1, value2, "otApproveEnd");
            return (Criteria) this;
        }

        public Criteria andOtApproveEndNotBetween(String value1, String value2) {
            addCriterion("ot_approve_end not between", value1, value2, "otApproveEnd");
            return (Criteria) this;
        }

        public Criteria andOtAskStaffIdIsNull() {
            addCriterion("ot_ask_staff_id is null");
            return (Criteria) this;
        }

        public Criteria andOtAskStaffIdIsNotNull() {
            addCriterion("ot_ask_staff_id is not null");
            return (Criteria) this;
        }

        public Criteria andOtAskStaffIdEqualTo(String value) {
            addCriterion("ot_ask_staff_id =", value, "otAskStaffId");
            return (Criteria) this;
        }

        public Criteria andOtAskStaffIdNotEqualTo(String value) {
            addCriterion("ot_ask_staff_id <>", value, "otAskStaffId");
            return (Criteria) this;
        }

        public Criteria andOtAskStaffIdGreaterThan(String value) {
            addCriterion("ot_ask_staff_id >", value, "otAskStaffId");
            return (Criteria) this;
        }

        public Criteria andOtAskStaffIdGreaterThanOrEqualTo(String value) {
            addCriterion("ot_ask_staff_id >=", value, "otAskStaffId");
            return (Criteria) this;
        }

        public Criteria andOtAskStaffIdLessThan(String value) {
            addCriterion("ot_ask_staff_id <", value, "otAskStaffId");
            return (Criteria) this;
        }

        public Criteria andOtAskStaffIdLessThanOrEqualTo(String value) {
            addCriterion("ot_ask_staff_id <=", value, "otAskStaffId");
            return (Criteria) this;
        }

        public Criteria andOtAskStaffIdLike(String value) {
            addCriterion("ot_ask_staff_id like", value, "otAskStaffId");
            return (Criteria) this;
        }

        public Criteria andOtAskStaffIdNotLike(String value) {
            addCriterion("ot_ask_staff_id not like", value, "otAskStaffId");
            return (Criteria) this;
        }

        public Criteria andOtAskStaffIdIn(List<String> values) {
            addCriterion("ot_ask_staff_id in", values, "otAskStaffId");
            return (Criteria) this;
        }

        public Criteria andOtAskStaffIdNotIn(List<String> values) {
            addCriterion("ot_ask_staff_id not in", values, "otAskStaffId");
            return (Criteria) this;
        }

        public Criteria andOtAskStaffIdBetween(String value1, String value2) {
            addCriterion("ot_ask_staff_id between", value1, value2, "otAskStaffId");
            return (Criteria) this;
        }

        public Criteria andOtAskStaffIdNotBetween(String value1, String value2) {
            addCriterion("ot_ask_staff_id not between", value1, value2, "otAskStaffId");
            return (Criteria) this;
        }

        public Criteria andOtAskStaffNameIsNull() {
            addCriterion("ot_ask_staff_name is null");
            return (Criteria) this;
        }

        public Criteria andOtAskStaffNameIsNotNull() {
            addCriterion("ot_ask_staff_name is not null");
            return (Criteria) this;
        }

        public Criteria andOtAskStaffNameEqualTo(String value) {
            addCriterion("ot_ask_staff_name =", value, "otAskStaffName");
            return (Criteria) this;
        }

        public Criteria andOtAskStaffNameNotEqualTo(String value) {
            addCriterion("ot_ask_staff_name <>", value, "otAskStaffName");
            return (Criteria) this;
        }

        public Criteria andOtAskStaffNameGreaterThan(String value) {
            addCriterion("ot_ask_staff_name >", value, "otAskStaffName");
            return (Criteria) this;
        }

        public Criteria andOtAskStaffNameGreaterThanOrEqualTo(String value) {
            addCriterion("ot_ask_staff_name >=", value, "otAskStaffName");
            return (Criteria) this;
        }

        public Criteria andOtAskStaffNameLessThan(String value) {
            addCriterion("ot_ask_staff_name <", value, "otAskStaffName");
            return (Criteria) this;
        }

        public Criteria andOtAskStaffNameLessThanOrEqualTo(String value) {
            addCriterion("ot_ask_staff_name <=", value, "otAskStaffName");
            return (Criteria) this;
        }

        public Criteria andOtAskStaffNameLike(String value) {
            addCriterion("ot_ask_staff_name like", value, "otAskStaffName");
            return (Criteria) this;
        }

        public Criteria andOtAskStaffNameNotLike(String value) {
            addCriterion("ot_ask_staff_name not like", value, "otAskStaffName");
            return (Criteria) this;
        }

        public Criteria andOtAskStaffNameIn(List<String> values) {
            addCriterion("ot_ask_staff_name in", values, "otAskStaffName");
            return (Criteria) this;
        }

        public Criteria andOtAskStaffNameNotIn(List<String> values) {
            addCriterion("ot_ask_staff_name not in", values, "otAskStaffName");
            return (Criteria) this;
        }

        public Criteria andOtAskStaffNameBetween(String value1, String value2) {
            addCriterion("ot_ask_staff_name between", value1, value2, "otAskStaffName");
            return (Criteria) this;
        }

        public Criteria andOtAskStaffNameNotBetween(String value1, String value2) {
            addCriterion("ot_ask_staff_name not between", value1, value2, "otAskStaffName");
            return (Criteria) this;
        }

        public Criteria andOtAskStaffDepartIsNull() {
            addCriterion("ot_ask_staff_depart is null");
            return (Criteria) this;
        }

        public Criteria andOtAskStaffDepartIsNotNull() {
            addCriterion("ot_ask_staff_depart is not null");
            return (Criteria) this;
        }

        public Criteria andOtAskStaffDepartEqualTo(String value) {
            addCriterion("ot_ask_staff_depart =", value, "otAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andOtAskStaffDepartNotEqualTo(String value) {
            addCriterion("ot_ask_staff_depart <>", value, "otAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andOtAskStaffDepartGreaterThan(String value) {
            addCriterion("ot_ask_staff_depart >", value, "otAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andOtAskStaffDepartGreaterThanOrEqualTo(String value) {
            addCriterion("ot_ask_staff_depart >=", value, "otAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andOtAskStaffDepartLessThan(String value) {
            addCriterion("ot_ask_staff_depart <", value, "otAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andOtAskStaffDepartLessThanOrEqualTo(String value) {
            addCriterion("ot_ask_staff_depart <=", value, "otAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andOtAskStaffDepartLike(String value) {
            addCriterion("ot_ask_staff_depart like", value, "otAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andOtAskStaffDepartNotLike(String value) {
            addCriterion("ot_ask_staff_depart not like", value, "otAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andOtAskStaffDepartIn(List<String> values) {
            addCriterion("ot_ask_staff_depart in", values, "otAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andOtAskStaffDepartNotIn(List<String> values) {
            addCriterion("ot_ask_staff_depart not in", values, "otAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andOtAskStaffDepartBetween(String value1, String value2) {
            addCriterion("ot_ask_staff_depart between", value1, value2, "otAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andOtAskStaffDepartNotBetween(String value1, String value2) {
            addCriterion("ot_ask_staff_depart not between", value1, value2, "otAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andOtHistoryApproveNameIsNull() {
            addCriterion("ot_history_approve_name is null");
            return (Criteria) this;
        }

        public Criteria andOtHistoryApproveNameIsNotNull() {
            addCriterion("ot_history_approve_name is not null");
            return (Criteria) this;
        }

        public Criteria andOtHistoryApproveNameEqualTo(String value) {
            addCriterion("ot_history_approve_name =", value, "otHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andOtHistoryApproveNameNotEqualTo(String value) {
            addCriterion("ot_history_approve_name <>", value, "otHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andOtHistoryApproveNameGreaterThan(String value) {
            addCriterion("ot_history_approve_name >", value, "otHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andOtHistoryApproveNameGreaterThanOrEqualTo(String value) {
            addCriterion("ot_history_approve_name >=", value, "otHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andOtHistoryApproveNameLessThan(String value) {
            addCriterion("ot_history_approve_name <", value, "otHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andOtHistoryApproveNameLessThanOrEqualTo(String value) {
            addCriterion("ot_history_approve_name <=", value, "otHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andOtHistoryApproveNameLike(String value) {
            addCriterion("ot_history_approve_name like", value, "otHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andOtHistoryApproveNameNotLike(String value) {
            addCriterion("ot_history_approve_name not like", value, "otHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andOtHistoryApproveNameIn(List<String> values) {
            addCriterion("ot_history_approve_name in", values, "otHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andOtHistoryApproveNameNotIn(List<String> values) {
            addCriterion("ot_history_approve_name not in", values, "otHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andOtHistoryApproveNameBetween(String value1, String value2) {
            addCriterion("ot_history_approve_name between", value1, value2, "otHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andOtHistoryApproveNameNotBetween(String value1, String value2) {
            addCriterion("ot_history_approve_name not between", value1, value2, "otHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andOtApproveRecordIsNull() {
            addCriterion("ot_approve_record is null");
            return (Criteria) this;
        }

        public Criteria andOtApproveRecordIsNotNull() {
            addCriterion("ot_approve_record is not null");
            return (Criteria) this;
        }

        public Criteria andOtApproveRecordEqualTo(String value) {
            addCriterion("ot_approve_record =", value, "otApproveRecord");
            return (Criteria) this;
        }

        public Criteria andOtApproveRecordNotEqualTo(String value) {
            addCriterion("ot_approve_record <>", value, "otApproveRecord");
            return (Criteria) this;
        }

        public Criteria andOtApproveRecordGreaterThan(String value) {
            addCriterion("ot_approve_record >", value, "otApproveRecord");
            return (Criteria) this;
        }

        public Criteria andOtApproveRecordGreaterThanOrEqualTo(String value) {
            addCriterion("ot_approve_record >=", value, "otApproveRecord");
            return (Criteria) this;
        }

        public Criteria andOtApproveRecordLessThan(String value) {
            addCriterion("ot_approve_record <", value, "otApproveRecord");
            return (Criteria) this;
        }

        public Criteria andOtApproveRecordLessThanOrEqualTo(String value) {
            addCriterion("ot_approve_record <=", value, "otApproveRecord");
            return (Criteria) this;
        }

        public Criteria andOtApproveRecordLike(String value) {
            addCriterion("ot_approve_record like", value, "otApproveRecord");
            return (Criteria) this;
        }

        public Criteria andOtApproveRecordNotLike(String value) {
            addCriterion("ot_approve_record not like", value, "otApproveRecord");
            return (Criteria) this;
        }

        public Criteria andOtApproveRecordIn(List<String> values) {
            addCriterion("ot_approve_record in", values, "otApproveRecord");
            return (Criteria) this;
        }

        public Criteria andOtApproveRecordNotIn(List<String> values) {
            addCriterion("ot_approve_record not in", values, "otApproveRecord");
            return (Criteria) this;
        }

        public Criteria andOtApproveRecordBetween(String value1, String value2) {
            addCriterion("ot_approve_record between", value1, value2, "otApproveRecord");
            return (Criteria) this;
        }

        public Criteria andOtApproveRecordNotBetween(String value1, String value2) {
            addCriterion("ot_approve_record not between", value1, value2, "otApproveRecord");
            return (Criteria) this;
        }

        public Criteria andOtNowApproveNameIsNull() {
            addCriterion("ot_now_approve_name is null");
            return (Criteria) this;
        }

        public Criteria andOtNowApproveNameIsNotNull() {
            addCriterion("ot_now_approve_name is not null");
            return (Criteria) this;
        }

        public Criteria andOtNowApproveNameEqualTo(String value) {
            addCriterion("ot_now_approve_name =", value, "otNowApproveName");
            return (Criteria) this;
        }

        public Criteria andOtNowApproveNameNotEqualTo(String value) {
            addCriterion("ot_now_approve_name <>", value, "otNowApproveName");
            return (Criteria) this;
        }

        public Criteria andOtNowApproveNameGreaterThan(String value) {
            addCriterion("ot_now_approve_name >", value, "otNowApproveName");
            return (Criteria) this;
        }

        public Criteria andOtNowApproveNameGreaterThanOrEqualTo(String value) {
            addCriterion("ot_now_approve_name >=", value, "otNowApproveName");
            return (Criteria) this;
        }

        public Criteria andOtNowApproveNameLessThan(String value) {
            addCriterion("ot_now_approve_name <", value, "otNowApproveName");
            return (Criteria) this;
        }

        public Criteria andOtNowApproveNameLessThanOrEqualTo(String value) {
            addCriterion("ot_now_approve_name <=", value, "otNowApproveName");
            return (Criteria) this;
        }

        public Criteria andOtNowApproveNameLike(String value) {
            addCriterion("ot_now_approve_name like", value, "otNowApproveName");
            return (Criteria) this;
        }

        public Criteria andOtNowApproveNameNotLike(String value) {
            addCriterion("ot_now_approve_name not like", value, "otNowApproveName");
            return (Criteria) this;
        }

        public Criteria andOtNowApproveNameIn(List<String> values) {
            addCriterion("ot_now_approve_name in", values, "otNowApproveName");
            return (Criteria) this;
        }

        public Criteria andOtNowApproveNameNotIn(List<String> values) {
            addCriterion("ot_now_approve_name not in", values, "otNowApproveName");
            return (Criteria) this;
        }

        public Criteria andOtNowApproveNameBetween(String value1, String value2) {
            addCriterion("ot_now_approve_name between", value1, value2, "otNowApproveName");
            return (Criteria) this;
        }

        public Criteria andOtNowApproveNameNotBetween(String value1, String value2) {
            addCriterion("ot_now_approve_name not between", value1, value2, "otNowApproveName");
            return (Criteria) this;
        }

        public Criteria andOtCostIsNull() {
            addCriterion("ot_cost is null");
            return (Criteria) this;
        }

        public Criteria andOtCostIsNotNull() {
            addCriterion("ot_cost is not null");
            return (Criteria) this;
        }

        public Criteria andOtCostEqualTo(String value) {
            addCriterion("ot_cost =", value, "otCost");
            return (Criteria) this;
        }

        public Criteria andOtCostNotEqualTo(String value) {
            addCriterion("ot_cost <>", value, "otCost");
            return (Criteria) this;
        }

        public Criteria andOtCostGreaterThan(String value) {
            addCriterion("ot_cost >", value, "otCost");
            return (Criteria) this;
        }

        public Criteria andOtCostGreaterThanOrEqualTo(String value) {
            addCriterion("ot_cost >=", value, "otCost");
            return (Criteria) this;
        }

        public Criteria andOtCostLessThan(String value) {
            addCriterion("ot_cost <", value, "otCost");
            return (Criteria) this;
        }

        public Criteria andOtCostLessThanOrEqualTo(String value) {
            addCriterion("ot_cost <=", value, "otCost");
            return (Criteria) this;
        }

        public Criteria andOtCostLike(String value) {
            addCriterion("ot_cost like", value, "otCost");
            return (Criteria) this;
        }

        public Criteria andOtCostNotLike(String value) {
            addCriterion("ot_cost not like", value, "otCost");
            return (Criteria) this;
        }

        public Criteria andOtCostIn(List<String> values) {
            addCriterion("ot_cost in", values, "otCost");
            return (Criteria) this;
        }

        public Criteria andOtCostNotIn(List<String> values) {
            addCriterion("ot_cost not in", values, "otCost");
            return (Criteria) this;
        }

        public Criteria andOtCostBetween(String value1, String value2) {
            addCriterion("ot_cost between", value1, value2, "otCost");
            return (Criteria) this;
        }

        public Criteria andOtCostNotBetween(String value1, String value2) {
            addCriterion("ot_cost not between", value1, value2, "otCost");
            return (Criteria) this;
        }

        public Criteria andOtAskBeginTimeIsNull() {
            addCriterion("ot_ask_begin_time is null");
            return (Criteria) this;
        }

        public Criteria andOtAskBeginTimeIsNotNull() {
            addCriterion("ot_ask_begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andOtAskBeginTimeEqualTo(String value) {
            addCriterion("ot_ask_begin_time =", value, "otAskBeginTime");
            return (Criteria) this;
        }

        public Criteria andOtAskBeginTimeNotEqualTo(String value) {
            addCriterion("ot_ask_begin_time <>", value, "otAskBeginTime");
            return (Criteria) this;
        }

        public Criteria andOtAskBeginTimeGreaterThan(String value) {
            addCriterion("ot_ask_begin_time >", value, "otAskBeginTime");
            return (Criteria) this;
        }

        public Criteria andOtAskBeginTimeGreaterThanOrEqualTo(String value) {
            addCriterion("ot_ask_begin_time >=", value, "otAskBeginTime");
            return (Criteria) this;
        }

        public Criteria andOtAskBeginTimeLessThan(String value) {
            addCriterion("ot_ask_begin_time <", value, "otAskBeginTime");
            return (Criteria) this;
        }

        public Criteria andOtAskBeginTimeLessThanOrEqualTo(String value) {
            addCriterion("ot_ask_begin_time <=", value, "otAskBeginTime");
            return (Criteria) this;
        }

        public Criteria andOtAskBeginTimeLike(String value) {
            addCriterion("ot_ask_begin_time like", value, "otAskBeginTime");
            return (Criteria) this;
        }

        public Criteria andOtAskBeginTimeNotLike(String value) {
            addCriterion("ot_ask_begin_time not like", value, "otAskBeginTime");
            return (Criteria) this;
        }

        public Criteria andOtAskBeginTimeIn(List<String> values) {
            addCriterion("ot_ask_begin_time in", values, "otAskBeginTime");
            return (Criteria) this;
        }

        public Criteria andOtAskBeginTimeNotIn(List<String> values) {
            addCriterion("ot_ask_begin_time not in", values, "otAskBeginTime");
            return (Criteria) this;
        }

        public Criteria andOtAskBeginTimeBetween(String value1, String value2) {
            addCriterion("ot_ask_begin_time between", value1, value2, "otAskBeginTime");
            return (Criteria) this;
        }

        public Criteria andOtAskBeginTimeNotBetween(String value1, String value2) {
            addCriterion("ot_ask_begin_time not between", value1, value2, "otAskBeginTime");
            return (Criteria) this;
        }

        public Criteria andOtAskEndTimeIsNull() {
            addCriterion("ot_ask_end_time is null");
            return (Criteria) this;
        }

        public Criteria andOtAskEndTimeIsNotNull() {
            addCriterion("ot_ask_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andOtAskEndTimeEqualTo(String value) {
            addCriterion("ot_ask_end_time =", value, "otAskEndTime");
            return (Criteria) this;
        }

        public Criteria andOtAskEndTimeNotEqualTo(String value) {
            addCriterion("ot_ask_end_time <>", value, "otAskEndTime");
            return (Criteria) this;
        }

        public Criteria andOtAskEndTimeGreaterThan(String value) {
            addCriterion("ot_ask_end_time >", value, "otAskEndTime");
            return (Criteria) this;
        }

        public Criteria andOtAskEndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("ot_ask_end_time >=", value, "otAskEndTime");
            return (Criteria) this;
        }

        public Criteria andOtAskEndTimeLessThan(String value) {
            addCriterion("ot_ask_end_time <", value, "otAskEndTime");
            return (Criteria) this;
        }

        public Criteria andOtAskEndTimeLessThanOrEqualTo(String value) {
            addCriterion("ot_ask_end_time <=", value, "otAskEndTime");
            return (Criteria) this;
        }

        public Criteria andOtAskEndTimeLike(String value) {
            addCriterion("ot_ask_end_time like", value, "otAskEndTime");
            return (Criteria) this;
        }

        public Criteria andOtAskEndTimeNotLike(String value) {
            addCriterion("ot_ask_end_time not like", value, "otAskEndTime");
            return (Criteria) this;
        }

        public Criteria andOtAskEndTimeIn(List<String> values) {
            addCriterion("ot_ask_end_time in", values, "otAskEndTime");
            return (Criteria) this;
        }

        public Criteria andOtAskEndTimeNotIn(List<String> values) {
            addCriterion("ot_ask_end_time not in", values, "otAskEndTime");
            return (Criteria) this;
        }

        public Criteria andOtAskEndTimeBetween(String value1, String value2) {
            addCriterion("ot_ask_end_time between", value1, value2, "otAskEndTime");
            return (Criteria) this;
        }

        public Criteria andOtAskEndTimeNotBetween(String value1, String value2) {
            addCriterion("ot_ask_end_time not between", value1, value2, "otAskEndTime");
            return (Criteria) this;
        }

        public Criteria andOtLegalHolidayIsNull() {
            addCriterion("ot_legal_holiday is null");
            return (Criteria) this;
        }

        public Criteria andOtLegalHolidayIsNotNull() {
            addCriterion("ot_legal_holiday is not null");
            return (Criteria) this;
        }

        public Criteria andOtLegalHolidayEqualTo(String value) {
            addCriterion("ot_legal_holiday =", value, "otLegalHoliday");
            return (Criteria) this;
        }

        public Criteria andOtLegalHolidayNotEqualTo(String value) {
            addCriterion("ot_legal_holiday <>", value, "otLegalHoliday");
            return (Criteria) this;
        }

        public Criteria andOtLegalHolidayGreaterThan(String value) {
            addCriterion("ot_legal_holiday >", value, "otLegalHoliday");
            return (Criteria) this;
        }

        public Criteria andOtLegalHolidayGreaterThanOrEqualTo(String value) {
            addCriterion("ot_legal_holiday >=", value, "otLegalHoliday");
            return (Criteria) this;
        }

        public Criteria andOtLegalHolidayLessThan(String value) {
            addCriterion("ot_legal_holiday <", value, "otLegalHoliday");
            return (Criteria) this;
        }

        public Criteria andOtLegalHolidayLessThanOrEqualTo(String value) {
            addCriterion("ot_legal_holiday <=", value, "otLegalHoliday");
            return (Criteria) this;
        }

        public Criteria andOtLegalHolidayLike(String value) {
            addCriterion("ot_legal_holiday like", value, "otLegalHoliday");
            return (Criteria) this;
        }

        public Criteria andOtLegalHolidayNotLike(String value) {
            addCriterion("ot_legal_holiday not like", value, "otLegalHoliday");
            return (Criteria) this;
        }

        public Criteria andOtLegalHolidayIn(List<String> values) {
            addCriterion("ot_legal_holiday in", values, "otLegalHoliday");
            return (Criteria) this;
        }

        public Criteria andOtLegalHolidayNotIn(List<String> values) {
            addCriterion("ot_legal_holiday not in", values, "otLegalHoliday");
            return (Criteria) this;
        }

        public Criteria andOtLegalHolidayBetween(String value1, String value2) {
            addCriterion("ot_legal_holiday between", value1, value2, "otLegalHoliday");
            return (Criteria) this;
        }

        public Criteria andOtLegalHolidayNotBetween(String value1, String value2) {
            addCriterion("ot_legal_holiday not between", value1, value2, "otLegalHoliday");
            return (Criteria) this;
        }

        public Criteria andOtPayMethodIsNull() {
            addCriterion("ot_pay_method is null");
            return (Criteria) this;
        }

        public Criteria andOtPayMethodIsNotNull() {
            addCriterion("ot_pay_method is not null");
            return (Criteria) this;
        }

        public Criteria andOtPayMethodEqualTo(String value) {
            addCriterion("ot_pay_method =", value, "otPayMethod");
            return (Criteria) this;
        }

        public Criteria andOtPayMethodNotEqualTo(String value) {
            addCriterion("ot_pay_method <>", value, "otPayMethod");
            return (Criteria) this;
        }

        public Criteria andOtPayMethodGreaterThan(String value) {
            addCriterion("ot_pay_method >", value, "otPayMethod");
            return (Criteria) this;
        }

        public Criteria andOtPayMethodGreaterThanOrEqualTo(String value) {
            addCriterion("ot_pay_method >=", value, "otPayMethod");
            return (Criteria) this;
        }

        public Criteria andOtPayMethodLessThan(String value) {
            addCriterion("ot_pay_method <", value, "otPayMethod");
            return (Criteria) this;
        }

        public Criteria andOtPayMethodLessThanOrEqualTo(String value) {
            addCriterion("ot_pay_method <=", value, "otPayMethod");
            return (Criteria) this;
        }

        public Criteria andOtPayMethodLike(String value) {
            addCriterion("ot_pay_method like", value, "otPayMethod");
            return (Criteria) this;
        }

        public Criteria andOtPayMethodNotLike(String value) {
            addCriterion("ot_pay_method not like", value, "otPayMethod");
            return (Criteria) this;
        }

        public Criteria andOtPayMethodIn(List<String> values) {
            addCriterion("ot_pay_method in", values, "otPayMethod");
            return (Criteria) this;
        }

        public Criteria andOtPayMethodNotIn(List<String> values) {
            addCriterion("ot_pay_method not in", values, "otPayMethod");
            return (Criteria) this;
        }

        public Criteria andOtPayMethodBetween(String value1, String value2) {
            addCriterion("ot_pay_method between", value1, value2, "otPayMethod");
            return (Criteria) this;
        }

        public Criteria andOtPayMethodNotBetween(String value1, String value2) {
            addCriterion("ot_pay_method not between", value1, value2, "otPayMethod");
            return (Criteria) this;
        }

        public Criteria andOtAskSustainIsNull() {
            addCriterion("ot_ask_sustain is null");
            return (Criteria) this;
        }

        public Criteria andOtAskSustainIsNotNull() {
            addCriterion("ot_ask_sustain is not null");
            return (Criteria) this;
        }

        public Criteria andOtAskSustainEqualTo(String value) {
            addCriterion("ot_ask_sustain =", value, "otAskSustain");
            return (Criteria) this;
        }

        public Criteria andOtAskSustainNotEqualTo(String value) {
            addCriterion("ot_ask_sustain <>", value, "otAskSustain");
            return (Criteria) this;
        }

        public Criteria andOtAskSustainGreaterThan(String value) {
            addCriterion("ot_ask_sustain >", value, "otAskSustain");
            return (Criteria) this;
        }

        public Criteria andOtAskSustainGreaterThanOrEqualTo(String value) {
            addCriterion("ot_ask_sustain >=", value, "otAskSustain");
            return (Criteria) this;
        }

        public Criteria andOtAskSustainLessThan(String value) {
            addCriterion("ot_ask_sustain <", value, "otAskSustain");
            return (Criteria) this;
        }

        public Criteria andOtAskSustainLessThanOrEqualTo(String value) {
            addCriterion("ot_ask_sustain <=", value, "otAskSustain");
            return (Criteria) this;
        }

        public Criteria andOtAskSustainLike(String value) {
            addCriterion("ot_ask_sustain like", value, "otAskSustain");
            return (Criteria) this;
        }

        public Criteria andOtAskSustainNotLike(String value) {
            addCriterion("ot_ask_sustain not like", value, "otAskSustain");
            return (Criteria) this;
        }

        public Criteria andOtAskSustainIn(List<String> values) {
            addCriterion("ot_ask_sustain in", values, "otAskSustain");
            return (Criteria) this;
        }

        public Criteria andOtAskSustainNotIn(List<String> values) {
            addCriterion("ot_ask_sustain not in", values, "otAskSustain");
            return (Criteria) this;
        }

        public Criteria andOtAskSustainBetween(String value1, String value2) {
            addCriterion("ot_ask_sustain between", value1, value2, "otAskSustain");
            return (Criteria) this;
        }

        public Criteria andOtAskSustainNotBetween(String value1, String value2) {
            addCriterion("ot_ask_sustain not between", value1, value2, "otAskSustain");
            return (Criteria) this;
        }

        public Criteria andOtAskReasonIsNull() {
            addCriterion("ot_ask_reason is null");
            return (Criteria) this;
        }

        public Criteria andOtAskReasonIsNotNull() {
            addCriterion("ot_ask_reason is not null");
            return (Criteria) this;
        }

        public Criteria andOtAskReasonEqualTo(String value) {
            addCriterion("ot_ask_reason =", value, "otAskReason");
            return (Criteria) this;
        }

        public Criteria andOtAskReasonNotEqualTo(String value) {
            addCriterion("ot_ask_reason <>", value, "otAskReason");
            return (Criteria) this;
        }

        public Criteria andOtAskReasonGreaterThan(String value) {
            addCriterion("ot_ask_reason >", value, "otAskReason");
            return (Criteria) this;
        }

        public Criteria andOtAskReasonGreaterThanOrEqualTo(String value) {
            addCriterion("ot_ask_reason >=", value, "otAskReason");
            return (Criteria) this;
        }

        public Criteria andOtAskReasonLessThan(String value) {
            addCriterion("ot_ask_reason <", value, "otAskReason");
            return (Criteria) this;
        }

        public Criteria andOtAskReasonLessThanOrEqualTo(String value) {
            addCriterion("ot_ask_reason <=", value, "otAskReason");
            return (Criteria) this;
        }

        public Criteria andOtAskReasonLike(String value) {
            addCriterion("ot_ask_reason like", value, "otAskReason");
            return (Criteria) this;
        }

        public Criteria andOtAskReasonNotLike(String value) {
            addCriterion("ot_ask_reason not like", value, "otAskReason");
            return (Criteria) this;
        }

        public Criteria andOtAskReasonIn(List<String> values) {
            addCriterion("ot_ask_reason in", values, "otAskReason");
            return (Criteria) this;
        }

        public Criteria andOtAskReasonNotIn(List<String> values) {
            addCriterion("ot_ask_reason not in", values, "otAskReason");
            return (Criteria) this;
        }

        public Criteria andOtAskReasonBetween(String value1, String value2) {
            addCriterion("ot_ask_reason between", value1, value2, "otAskReason");
            return (Criteria) this;
        }

        public Criteria andOtAskReasonNotBetween(String value1, String value2) {
            addCriterion("ot_ask_reason not between", value1, value2, "otAskReason");
            return (Criteria) this;
        }

        public Criteria andOtCommentIsNull() {
            addCriterion("ot_comment is null");
            return (Criteria) this;
        }

        public Criteria andOtCommentIsNotNull() {
            addCriterion("ot_comment is not null");
            return (Criteria) this;
        }

        public Criteria andOtCommentEqualTo(String value) {
            addCriterion("ot_comment =", value, "otComment");
            return (Criteria) this;
        }

        public Criteria andOtCommentNotEqualTo(String value) {
            addCriterion("ot_comment <>", value, "otComment");
            return (Criteria) this;
        }

        public Criteria andOtCommentGreaterThan(String value) {
            addCriterion("ot_comment >", value, "otComment");
            return (Criteria) this;
        }

        public Criteria andOtCommentGreaterThanOrEqualTo(String value) {
            addCriterion("ot_comment >=", value, "otComment");
            return (Criteria) this;
        }

        public Criteria andOtCommentLessThan(String value) {
            addCriterion("ot_comment <", value, "otComment");
            return (Criteria) this;
        }

        public Criteria andOtCommentLessThanOrEqualTo(String value) {
            addCriterion("ot_comment <=", value, "otComment");
            return (Criteria) this;
        }

        public Criteria andOtCommentLike(String value) {
            addCriterion("ot_comment like", value, "otComment");
            return (Criteria) this;
        }

        public Criteria andOtCommentNotLike(String value) {
            addCriterion("ot_comment not like", value, "otComment");
            return (Criteria) this;
        }

        public Criteria andOtCommentIn(List<String> values) {
            addCriterion("ot_comment in", values, "otComment");
            return (Criteria) this;
        }

        public Criteria andOtCommentNotIn(List<String> values) {
            addCriterion("ot_comment not in", values, "otComment");
            return (Criteria) this;
        }

        public Criteria andOtCommentBetween(String value1, String value2) {
            addCriterion("ot_comment between", value1, value2, "otComment");
            return (Criteria) this;
        }

        public Criteria andOtCommentNotBetween(String value1, String value2) {
            addCriterion("ot_comment not between", value1, value2, "otComment");
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