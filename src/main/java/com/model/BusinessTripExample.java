package com.model;

import java.util.ArrayList;
import java.util.List;

public class BusinessTripExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BusinessTripExample() {
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

        public Criteria andBtSequenceNoIsNull() {
            addCriterion("bt_sequence_no is null");
            return (Criteria) this;
        }

        public Criteria andBtSequenceNoIsNotNull() {
            addCriterion("bt_sequence_no is not null");
            return (Criteria) this;
        }

        public Criteria andBtSequenceNoEqualTo(Integer value) {
            addCriterion("bt_sequence_no =", value, "btSequenceNo");
            return (Criteria) this;
        }

        public Criteria andBtSequenceNoNotEqualTo(Integer value) {
            addCriterion("bt_sequence_no <>", value, "btSequenceNo");
            return (Criteria) this;
        }

        public Criteria andBtSequenceNoGreaterThan(Integer value) {
            addCriterion("bt_sequence_no >", value, "btSequenceNo");
            return (Criteria) this;
        }

        public Criteria andBtSequenceNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("bt_sequence_no >=", value, "btSequenceNo");
            return (Criteria) this;
        }

        public Criteria andBtSequenceNoLessThan(Integer value) {
            addCriterion("bt_sequence_no <", value, "btSequenceNo");
            return (Criteria) this;
        }

        public Criteria andBtSequenceNoLessThanOrEqualTo(Integer value) {
            addCriterion("bt_sequence_no <=", value, "btSequenceNo");
            return (Criteria) this;
        }

        public Criteria andBtSequenceNoIn(List<Integer> values) {
            addCriterion("bt_sequence_no in", values, "btSequenceNo");
            return (Criteria) this;
        }

        public Criteria andBtSequenceNoNotIn(List<Integer> values) {
            addCriterion("bt_sequence_no not in", values, "btSequenceNo");
            return (Criteria) this;
        }

        public Criteria andBtSequenceNoBetween(Integer value1, Integer value2) {
            addCriterion("bt_sequence_no between", value1, value2, "btSequenceNo");
            return (Criteria) this;
        }

        public Criteria andBtSequenceNoNotBetween(Integer value1, Integer value2) {
            addCriterion("bt_sequence_no not between", value1, value2, "btSequenceNo");
            return (Criteria) this;
        }

        public Criteria andBtApproveNoIsNull() {
            addCriterion("bt_approve_no is null");
            return (Criteria) this;
        }

        public Criteria andBtApproveNoIsNotNull() {
            addCriterion("bt_approve_no is not null");
            return (Criteria) this;
        }

        public Criteria andBtApproveNoEqualTo(String value) {
            addCriterion("bt_approve_no =", value, "btApproveNo");
            return (Criteria) this;
        }

        public Criteria andBtApproveNoNotEqualTo(String value) {
            addCriterion("bt_approve_no <>", value, "btApproveNo");
            return (Criteria) this;
        }

        public Criteria andBtApproveNoGreaterThan(String value) {
            addCriterion("bt_approve_no >", value, "btApproveNo");
            return (Criteria) this;
        }

        public Criteria andBtApproveNoGreaterThanOrEqualTo(String value) {
            addCriterion("bt_approve_no >=", value, "btApproveNo");
            return (Criteria) this;
        }

        public Criteria andBtApproveNoLessThan(String value) {
            addCriterion("bt_approve_no <", value, "btApproveNo");
            return (Criteria) this;
        }

        public Criteria andBtApproveNoLessThanOrEqualTo(String value) {
            addCriterion("bt_approve_no <=", value, "btApproveNo");
            return (Criteria) this;
        }

        public Criteria andBtApproveNoLike(String value) {
            addCriterion("bt_approve_no like", value, "btApproveNo");
            return (Criteria) this;
        }

        public Criteria andBtApproveNoNotLike(String value) {
            addCriterion("bt_approve_no not like", value, "btApproveNo");
            return (Criteria) this;
        }

        public Criteria andBtApproveNoIn(List<String> values) {
            addCriterion("bt_approve_no in", values, "btApproveNo");
            return (Criteria) this;
        }

        public Criteria andBtApproveNoNotIn(List<String> values) {
            addCriterion("bt_approve_no not in", values, "btApproveNo");
            return (Criteria) this;
        }

        public Criteria andBtApproveNoBetween(String value1, String value2) {
            addCriterion("bt_approve_no between", value1, value2, "btApproveNo");
            return (Criteria) this;
        }

        public Criteria andBtApproveNoNotBetween(String value1, String value2) {
            addCriterion("bt_approve_no not between", value1, value2, "btApproveNo");
            return (Criteria) this;
        }

        public Criteria andBtTitleIsNull() {
            addCriterion("bt_title is null");
            return (Criteria) this;
        }

        public Criteria andBtTitleIsNotNull() {
            addCriterion("bt_title is not null");
            return (Criteria) this;
        }

        public Criteria andBtTitleEqualTo(String value) {
            addCriterion("bt_title =", value, "btTitle");
            return (Criteria) this;
        }

        public Criteria andBtTitleNotEqualTo(String value) {
            addCriterion("bt_title <>", value, "btTitle");
            return (Criteria) this;
        }

        public Criteria andBtTitleGreaterThan(String value) {
            addCriterion("bt_title >", value, "btTitle");
            return (Criteria) this;
        }

        public Criteria andBtTitleGreaterThanOrEqualTo(String value) {
            addCriterion("bt_title >=", value, "btTitle");
            return (Criteria) this;
        }

        public Criteria andBtTitleLessThan(String value) {
            addCriterion("bt_title <", value, "btTitle");
            return (Criteria) this;
        }

        public Criteria andBtTitleLessThanOrEqualTo(String value) {
            addCriterion("bt_title <=", value, "btTitle");
            return (Criteria) this;
        }

        public Criteria andBtTitleLike(String value) {
            addCriterion("bt_title like", value, "btTitle");
            return (Criteria) this;
        }

        public Criteria andBtTitleNotLike(String value) {
            addCriterion("bt_title not like", value, "btTitle");
            return (Criteria) this;
        }

        public Criteria andBtTitleIn(List<String> values) {
            addCriterion("bt_title in", values, "btTitle");
            return (Criteria) this;
        }

        public Criteria andBtTitleNotIn(List<String> values) {
            addCriterion("bt_title not in", values, "btTitle");
            return (Criteria) this;
        }

        public Criteria andBtTitleBetween(String value1, String value2) {
            addCriterion("bt_title between", value1, value2, "btTitle");
            return (Criteria) this;
        }

        public Criteria andBtTitleNotBetween(String value1, String value2) {
            addCriterion("bt_title not between", value1, value2, "btTitle");
            return (Criteria) this;
        }

        public Criteria andBtApproveStateIsNull() {
            addCriterion("bt_approve_state is null");
            return (Criteria) this;
        }

        public Criteria andBtApproveStateIsNotNull() {
            addCriterion("bt_approve_state is not null");
            return (Criteria) this;
        }

        public Criteria andBtApproveStateEqualTo(String value) {
            addCriterion("bt_approve_state =", value, "btApproveState");
            return (Criteria) this;
        }

        public Criteria andBtApproveStateNotEqualTo(String value) {
            addCriterion("bt_approve_state <>", value, "btApproveState");
            return (Criteria) this;
        }

        public Criteria andBtApproveStateGreaterThan(String value) {
            addCriterion("bt_approve_state >", value, "btApproveState");
            return (Criteria) this;
        }

        public Criteria andBtApproveStateGreaterThanOrEqualTo(String value) {
            addCriterion("bt_approve_state >=", value, "btApproveState");
            return (Criteria) this;
        }

        public Criteria andBtApproveStateLessThan(String value) {
            addCriterion("bt_approve_state <", value, "btApproveState");
            return (Criteria) this;
        }

        public Criteria andBtApproveStateLessThanOrEqualTo(String value) {
            addCriterion("bt_approve_state <=", value, "btApproveState");
            return (Criteria) this;
        }

        public Criteria andBtApproveStateLike(String value) {
            addCriterion("bt_approve_state like", value, "btApproveState");
            return (Criteria) this;
        }

        public Criteria andBtApproveStateNotLike(String value) {
            addCriterion("bt_approve_state not like", value, "btApproveState");
            return (Criteria) this;
        }

        public Criteria andBtApproveStateIn(List<String> values) {
            addCriterion("bt_approve_state in", values, "btApproveState");
            return (Criteria) this;
        }

        public Criteria andBtApproveStateNotIn(List<String> values) {
            addCriterion("bt_approve_state not in", values, "btApproveState");
            return (Criteria) this;
        }

        public Criteria andBtApproveStateBetween(String value1, String value2) {
            addCriterion("bt_approve_state between", value1, value2, "btApproveState");
            return (Criteria) this;
        }

        public Criteria andBtApproveStateNotBetween(String value1, String value2) {
            addCriterion("bt_approve_state not between", value1, value2, "btApproveState");
            return (Criteria) this;
        }

        public Criteria andBtApproveResultIsNull() {
            addCriterion("bt_approve_result is null");
            return (Criteria) this;
        }

        public Criteria andBtApproveResultIsNotNull() {
            addCriterion("bt_approve_result is not null");
            return (Criteria) this;
        }

        public Criteria andBtApproveResultEqualTo(String value) {
            addCriterion("bt_approve_result =", value, "btApproveResult");
            return (Criteria) this;
        }

        public Criteria andBtApproveResultNotEqualTo(String value) {
            addCriterion("bt_approve_result <>", value, "btApproveResult");
            return (Criteria) this;
        }

        public Criteria andBtApproveResultGreaterThan(String value) {
            addCriterion("bt_approve_result >", value, "btApproveResult");
            return (Criteria) this;
        }

        public Criteria andBtApproveResultGreaterThanOrEqualTo(String value) {
            addCriterion("bt_approve_result >=", value, "btApproveResult");
            return (Criteria) this;
        }

        public Criteria andBtApproveResultLessThan(String value) {
            addCriterion("bt_approve_result <", value, "btApproveResult");
            return (Criteria) this;
        }

        public Criteria andBtApproveResultLessThanOrEqualTo(String value) {
            addCriterion("bt_approve_result <=", value, "btApproveResult");
            return (Criteria) this;
        }

        public Criteria andBtApproveResultLike(String value) {
            addCriterion("bt_approve_result like", value, "btApproveResult");
            return (Criteria) this;
        }

        public Criteria andBtApproveResultNotLike(String value) {
            addCriterion("bt_approve_result not like", value, "btApproveResult");
            return (Criteria) this;
        }

        public Criteria andBtApproveResultIn(List<String> values) {
            addCriterion("bt_approve_result in", values, "btApproveResult");
            return (Criteria) this;
        }

        public Criteria andBtApproveResultNotIn(List<String> values) {
            addCriterion("bt_approve_result not in", values, "btApproveResult");
            return (Criteria) this;
        }

        public Criteria andBtApproveResultBetween(String value1, String value2) {
            addCriterion("bt_approve_result between", value1, value2, "btApproveResult");
            return (Criteria) this;
        }

        public Criteria andBtApproveResultNotBetween(String value1, String value2) {
            addCriterion("bt_approve_result not between", value1, value2, "btApproveResult");
            return (Criteria) this;
        }

        public Criteria andBtApproveBeginIsNull() {
            addCriterion("bt_approve_begin is null");
            return (Criteria) this;
        }

        public Criteria andBtApproveBeginIsNotNull() {
            addCriterion("bt_approve_begin is not null");
            return (Criteria) this;
        }

        public Criteria andBtApproveBeginEqualTo(String value) {
            addCriterion("bt_approve_begin =", value, "btApproveBegin");
            return (Criteria) this;
        }

        public Criteria andBtApproveBeginNotEqualTo(String value) {
            addCriterion("bt_approve_begin <>", value, "btApproveBegin");
            return (Criteria) this;
        }

        public Criteria andBtApproveBeginGreaterThan(String value) {
            addCriterion("bt_approve_begin >", value, "btApproveBegin");
            return (Criteria) this;
        }

        public Criteria andBtApproveBeginGreaterThanOrEqualTo(String value) {
            addCriterion("bt_approve_begin >=", value, "btApproveBegin");
            return (Criteria) this;
        }

        public Criteria andBtApproveBeginLessThan(String value) {
            addCriterion("bt_approve_begin <", value, "btApproveBegin");
            return (Criteria) this;
        }

        public Criteria andBtApproveBeginLessThanOrEqualTo(String value) {
            addCriterion("bt_approve_begin <=", value, "btApproveBegin");
            return (Criteria) this;
        }

        public Criteria andBtApproveBeginLike(String value) {
            addCriterion("bt_approve_begin like", value, "btApproveBegin");
            return (Criteria) this;
        }

        public Criteria andBtApproveBeginNotLike(String value) {
            addCriterion("bt_approve_begin not like", value, "btApproveBegin");
            return (Criteria) this;
        }

        public Criteria andBtApproveBeginIn(List<String> values) {
            addCriterion("bt_approve_begin in", values, "btApproveBegin");
            return (Criteria) this;
        }

        public Criteria andBtApproveBeginNotIn(List<String> values) {
            addCriterion("bt_approve_begin not in", values, "btApproveBegin");
            return (Criteria) this;
        }

        public Criteria andBtApproveBeginBetween(String value1, String value2) {
            addCriterion("bt_approve_begin between", value1, value2, "btApproveBegin");
            return (Criteria) this;
        }

        public Criteria andBtApproveBeginNotBetween(String value1, String value2) {
            addCriterion("bt_approve_begin not between", value1, value2, "btApproveBegin");
            return (Criteria) this;
        }

        public Criteria andBtApproveEndIsNull() {
            addCriterion("bt_approve_end is null");
            return (Criteria) this;
        }

        public Criteria andBtApproveEndIsNotNull() {
            addCriterion("bt_approve_end is not null");
            return (Criteria) this;
        }

        public Criteria andBtApproveEndEqualTo(String value) {
            addCriterion("bt_approve_end =", value, "btApproveEnd");
            return (Criteria) this;
        }

        public Criteria andBtApproveEndNotEqualTo(String value) {
            addCriterion("bt_approve_end <>", value, "btApproveEnd");
            return (Criteria) this;
        }

        public Criteria andBtApproveEndGreaterThan(String value) {
            addCriterion("bt_approve_end >", value, "btApproveEnd");
            return (Criteria) this;
        }

        public Criteria andBtApproveEndGreaterThanOrEqualTo(String value) {
            addCriterion("bt_approve_end >=", value, "btApproveEnd");
            return (Criteria) this;
        }

        public Criteria andBtApproveEndLessThan(String value) {
            addCriterion("bt_approve_end <", value, "btApproveEnd");
            return (Criteria) this;
        }

        public Criteria andBtApproveEndLessThanOrEqualTo(String value) {
            addCriterion("bt_approve_end <=", value, "btApproveEnd");
            return (Criteria) this;
        }

        public Criteria andBtApproveEndLike(String value) {
            addCriterion("bt_approve_end like", value, "btApproveEnd");
            return (Criteria) this;
        }

        public Criteria andBtApproveEndNotLike(String value) {
            addCriterion("bt_approve_end not like", value, "btApproveEnd");
            return (Criteria) this;
        }

        public Criteria andBtApproveEndIn(List<String> values) {
            addCriterion("bt_approve_end in", values, "btApproveEnd");
            return (Criteria) this;
        }

        public Criteria andBtApproveEndNotIn(List<String> values) {
            addCriterion("bt_approve_end not in", values, "btApproveEnd");
            return (Criteria) this;
        }

        public Criteria andBtApproveEndBetween(String value1, String value2) {
            addCriterion("bt_approve_end between", value1, value2, "btApproveEnd");
            return (Criteria) this;
        }

        public Criteria andBtApproveEndNotBetween(String value1, String value2) {
            addCriterion("bt_approve_end not between", value1, value2, "btApproveEnd");
            return (Criteria) this;
        }

        public Criteria andBtAskStaffIdIsNull() {
            addCriterion("bt_ask_staff_id is null");
            return (Criteria) this;
        }

        public Criteria andBtAskStaffIdIsNotNull() {
            addCriterion("bt_ask_staff_id is not null");
            return (Criteria) this;
        }

        public Criteria andBtAskStaffIdEqualTo(String value) {
            addCriterion("bt_ask_staff_id =", value, "btAskStaffId");
            return (Criteria) this;
        }

        public Criteria andBtAskStaffIdNotEqualTo(String value) {
            addCriterion("bt_ask_staff_id <>", value, "btAskStaffId");
            return (Criteria) this;
        }

        public Criteria andBtAskStaffIdGreaterThan(String value) {
            addCriterion("bt_ask_staff_id >", value, "btAskStaffId");
            return (Criteria) this;
        }

        public Criteria andBtAskStaffIdGreaterThanOrEqualTo(String value) {
            addCriterion("bt_ask_staff_id >=", value, "btAskStaffId");
            return (Criteria) this;
        }

        public Criteria andBtAskStaffIdLessThan(String value) {
            addCriterion("bt_ask_staff_id <", value, "btAskStaffId");
            return (Criteria) this;
        }

        public Criteria andBtAskStaffIdLessThanOrEqualTo(String value) {
            addCriterion("bt_ask_staff_id <=", value, "btAskStaffId");
            return (Criteria) this;
        }

        public Criteria andBtAskStaffIdLike(String value) {
            addCriterion("bt_ask_staff_id like", value, "btAskStaffId");
            return (Criteria) this;
        }

        public Criteria andBtAskStaffIdNotLike(String value) {
            addCriterion("bt_ask_staff_id not like", value, "btAskStaffId");
            return (Criteria) this;
        }

        public Criteria andBtAskStaffIdIn(List<String> values) {
            addCriterion("bt_ask_staff_id in", values, "btAskStaffId");
            return (Criteria) this;
        }

        public Criteria andBtAskStaffIdNotIn(List<String> values) {
            addCriterion("bt_ask_staff_id not in", values, "btAskStaffId");
            return (Criteria) this;
        }

        public Criteria andBtAskStaffIdBetween(String value1, String value2) {
            addCriterion("bt_ask_staff_id between", value1, value2, "btAskStaffId");
            return (Criteria) this;
        }

        public Criteria andBtAskStaffIdNotBetween(String value1, String value2) {
            addCriterion("bt_ask_staff_id not between", value1, value2, "btAskStaffId");
            return (Criteria) this;
        }

        public Criteria andBtAskStaffNameIsNull() {
            addCriterion("bt_ask_staff_name is null");
            return (Criteria) this;
        }

        public Criteria andBtAskStaffNameIsNotNull() {
            addCriterion("bt_ask_staff_name is not null");
            return (Criteria) this;
        }

        public Criteria andBtAskStaffNameEqualTo(String value) {
            addCriterion("bt_ask_staff_name =", value, "btAskStaffName");
            return (Criteria) this;
        }

        public Criteria andBtAskStaffNameNotEqualTo(String value) {
            addCriterion("bt_ask_staff_name <>", value, "btAskStaffName");
            return (Criteria) this;
        }

        public Criteria andBtAskStaffNameGreaterThan(String value) {
            addCriterion("bt_ask_staff_name >", value, "btAskStaffName");
            return (Criteria) this;
        }

        public Criteria andBtAskStaffNameGreaterThanOrEqualTo(String value) {
            addCriterion("bt_ask_staff_name >=", value, "btAskStaffName");
            return (Criteria) this;
        }

        public Criteria andBtAskStaffNameLessThan(String value) {
            addCriterion("bt_ask_staff_name <", value, "btAskStaffName");
            return (Criteria) this;
        }

        public Criteria andBtAskStaffNameLessThanOrEqualTo(String value) {
            addCriterion("bt_ask_staff_name <=", value, "btAskStaffName");
            return (Criteria) this;
        }

        public Criteria andBtAskStaffNameLike(String value) {
            addCriterion("bt_ask_staff_name like", value, "btAskStaffName");
            return (Criteria) this;
        }

        public Criteria andBtAskStaffNameNotLike(String value) {
            addCriterion("bt_ask_staff_name not like", value, "btAskStaffName");
            return (Criteria) this;
        }

        public Criteria andBtAskStaffNameIn(List<String> values) {
            addCriterion("bt_ask_staff_name in", values, "btAskStaffName");
            return (Criteria) this;
        }

        public Criteria andBtAskStaffNameNotIn(List<String> values) {
            addCriterion("bt_ask_staff_name not in", values, "btAskStaffName");
            return (Criteria) this;
        }

        public Criteria andBtAskStaffNameBetween(String value1, String value2) {
            addCriterion("bt_ask_staff_name between", value1, value2, "btAskStaffName");
            return (Criteria) this;
        }

        public Criteria andBtAskStaffNameNotBetween(String value1, String value2) {
            addCriterion("bt_ask_staff_name not between", value1, value2, "btAskStaffName");
            return (Criteria) this;
        }

        public Criteria andBtAskStaffDepartIsNull() {
            addCriterion("bt_ask_staff_depart is null");
            return (Criteria) this;
        }

        public Criteria andBtAskStaffDepartIsNotNull() {
            addCriterion("bt_ask_staff_depart is not null");
            return (Criteria) this;
        }

        public Criteria andBtAskStaffDepartEqualTo(String value) {
            addCriterion("bt_ask_staff_depart =", value, "btAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andBtAskStaffDepartNotEqualTo(String value) {
            addCriterion("bt_ask_staff_depart <>", value, "btAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andBtAskStaffDepartGreaterThan(String value) {
            addCriterion("bt_ask_staff_depart >", value, "btAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andBtAskStaffDepartGreaterThanOrEqualTo(String value) {
            addCriterion("bt_ask_staff_depart >=", value, "btAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andBtAskStaffDepartLessThan(String value) {
            addCriterion("bt_ask_staff_depart <", value, "btAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andBtAskStaffDepartLessThanOrEqualTo(String value) {
            addCriterion("bt_ask_staff_depart <=", value, "btAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andBtAskStaffDepartLike(String value) {
            addCriterion("bt_ask_staff_depart like", value, "btAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andBtAskStaffDepartNotLike(String value) {
            addCriterion("bt_ask_staff_depart not like", value, "btAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andBtAskStaffDepartIn(List<String> values) {
            addCriterion("bt_ask_staff_depart in", values, "btAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andBtAskStaffDepartNotIn(List<String> values) {
            addCriterion("bt_ask_staff_depart not in", values, "btAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andBtAskStaffDepartBetween(String value1, String value2) {
            addCriterion("bt_ask_staff_depart between", value1, value2, "btAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andBtAskStaffDepartNotBetween(String value1, String value2) {
            addCriterion("bt_ask_staff_depart not between", value1, value2, "btAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andBtHistoryApproveNameIsNull() {
            addCriterion("bt_history_approve_name is null");
            return (Criteria) this;
        }

        public Criteria andBtHistoryApproveNameIsNotNull() {
            addCriterion("bt_history_approve_name is not null");
            return (Criteria) this;
        }

        public Criteria andBtHistoryApproveNameEqualTo(String value) {
            addCriterion("bt_history_approve_name =", value, "btHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andBtHistoryApproveNameNotEqualTo(String value) {
            addCriterion("bt_history_approve_name <>", value, "btHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andBtHistoryApproveNameGreaterThan(String value) {
            addCriterion("bt_history_approve_name >", value, "btHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andBtHistoryApproveNameGreaterThanOrEqualTo(String value) {
            addCriterion("bt_history_approve_name >=", value, "btHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andBtHistoryApproveNameLessThan(String value) {
            addCriterion("bt_history_approve_name <", value, "btHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andBtHistoryApproveNameLessThanOrEqualTo(String value) {
            addCriterion("bt_history_approve_name <=", value, "btHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andBtHistoryApproveNameLike(String value) {
            addCriterion("bt_history_approve_name like", value, "btHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andBtHistoryApproveNameNotLike(String value) {
            addCriterion("bt_history_approve_name not like", value, "btHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andBtHistoryApproveNameIn(List<String> values) {
            addCriterion("bt_history_approve_name in", values, "btHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andBtHistoryApproveNameNotIn(List<String> values) {
            addCriterion("bt_history_approve_name not in", values, "btHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andBtHistoryApproveNameBetween(String value1, String value2) {
            addCriterion("bt_history_approve_name between", value1, value2, "btHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andBtHistoryApproveNameNotBetween(String value1, String value2) {
            addCriterion("bt_history_approve_name not between", value1, value2, "btHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andBtApproveRecordIsNull() {
            addCriterion("bt_approve_record is null");
            return (Criteria) this;
        }

        public Criteria andBtApproveRecordIsNotNull() {
            addCriterion("bt_approve_record is not null");
            return (Criteria) this;
        }

        public Criteria andBtApproveRecordEqualTo(String value) {
            addCriterion("bt_approve_record =", value, "btApproveRecord");
            return (Criteria) this;
        }

        public Criteria andBtApproveRecordNotEqualTo(String value) {
            addCriterion("bt_approve_record <>", value, "btApproveRecord");
            return (Criteria) this;
        }

        public Criteria andBtApproveRecordGreaterThan(String value) {
            addCriterion("bt_approve_record >", value, "btApproveRecord");
            return (Criteria) this;
        }

        public Criteria andBtApproveRecordGreaterThanOrEqualTo(String value) {
            addCriterion("bt_approve_record >=", value, "btApproveRecord");
            return (Criteria) this;
        }

        public Criteria andBtApproveRecordLessThan(String value) {
            addCriterion("bt_approve_record <", value, "btApproveRecord");
            return (Criteria) this;
        }

        public Criteria andBtApproveRecordLessThanOrEqualTo(String value) {
            addCriterion("bt_approve_record <=", value, "btApproveRecord");
            return (Criteria) this;
        }

        public Criteria andBtApproveRecordLike(String value) {
            addCriterion("bt_approve_record like", value, "btApproveRecord");
            return (Criteria) this;
        }

        public Criteria andBtApproveRecordNotLike(String value) {
            addCriterion("bt_approve_record not like", value, "btApproveRecord");
            return (Criteria) this;
        }

        public Criteria andBtApproveRecordIn(List<String> values) {
            addCriterion("bt_approve_record in", values, "btApproveRecord");
            return (Criteria) this;
        }

        public Criteria andBtApproveRecordNotIn(List<String> values) {
            addCriterion("bt_approve_record not in", values, "btApproveRecord");
            return (Criteria) this;
        }

        public Criteria andBtApproveRecordBetween(String value1, String value2) {
            addCriterion("bt_approve_record between", value1, value2, "btApproveRecord");
            return (Criteria) this;
        }

        public Criteria andBtApproveRecordNotBetween(String value1, String value2) {
            addCriterion("bt_approve_record not between", value1, value2, "btApproveRecord");
            return (Criteria) this;
        }

        public Criteria andBtNowApproveNameIsNull() {
            addCriterion("bt_now_approve_name is null");
            return (Criteria) this;
        }

        public Criteria andBtNowApproveNameIsNotNull() {
            addCriterion("bt_now_approve_name is not null");
            return (Criteria) this;
        }

        public Criteria andBtNowApproveNameEqualTo(String value) {
            addCriterion("bt_now_approve_name =", value, "btNowApproveName");
            return (Criteria) this;
        }

        public Criteria andBtNowApproveNameNotEqualTo(String value) {
            addCriterion("bt_now_approve_name <>", value, "btNowApproveName");
            return (Criteria) this;
        }

        public Criteria andBtNowApproveNameGreaterThan(String value) {
            addCriterion("bt_now_approve_name >", value, "btNowApproveName");
            return (Criteria) this;
        }

        public Criteria andBtNowApproveNameGreaterThanOrEqualTo(String value) {
            addCriterion("bt_now_approve_name >=", value, "btNowApproveName");
            return (Criteria) this;
        }

        public Criteria andBtNowApproveNameLessThan(String value) {
            addCriterion("bt_now_approve_name <", value, "btNowApproveName");
            return (Criteria) this;
        }

        public Criteria andBtNowApproveNameLessThanOrEqualTo(String value) {
            addCriterion("bt_now_approve_name <=", value, "btNowApproveName");
            return (Criteria) this;
        }

        public Criteria andBtNowApproveNameLike(String value) {
            addCriterion("bt_now_approve_name like", value, "btNowApproveName");
            return (Criteria) this;
        }

        public Criteria andBtNowApproveNameNotLike(String value) {
            addCriterion("bt_now_approve_name not like", value, "btNowApproveName");
            return (Criteria) this;
        }

        public Criteria andBtNowApproveNameIn(List<String> values) {
            addCriterion("bt_now_approve_name in", values, "btNowApproveName");
            return (Criteria) this;
        }

        public Criteria andBtNowApproveNameNotIn(List<String> values) {
            addCriterion("bt_now_approve_name not in", values, "btNowApproveName");
            return (Criteria) this;
        }

        public Criteria andBtNowApproveNameBetween(String value1, String value2) {
            addCriterion("bt_now_approve_name between", value1, value2, "btNowApproveName");
            return (Criteria) this;
        }

        public Criteria andBtNowApproveNameNotBetween(String value1, String value2) {
            addCriterion("bt_now_approve_name not between", value1, value2, "btNowApproveName");
            return (Criteria) this;
        }

        public Criteria andBtCostIsNull() {
            addCriterion("bt_cost is null");
            return (Criteria) this;
        }

        public Criteria andBtCostIsNotNull() {
            addCriterion("bt_cost is not null");
            return (Criteria) this;
        }

        public Criteria andBtCostEqualTo(String value) {
            addCriterion("bt_cost =", value, "btCost");
            return (Criteria) this;
        }

        public Criteria andBtCostNotEqualTo(String value) {
            addCriterion("bt_cost <>", value, "btCost");
            return (Criteria) this;
        }

        public Criteria andBtCostGreaterThan(String value) {
            addCriterion("bt_cost >", value, "btCost");
            return (Criteria) this;
        }

        public Criteria andBtCostGreaterThanOrEqualTo(String value) {
            addCriterion("bt_cost >=", value, "btCost");
            return (Criteria) this;
        }

        public Criteria andBtCostLessThan(String value) {
            addCriterion("bt_cost <", value, "btCost");
            return (Criteria) this;
        }

        public Criteria andBtCostLessThanOrEqualTo(String value) {
            addCriterion("bt_cost <=", value, "btCost");
            return (Criteria) this;
        }

        public Criteria andBtCostLike(String value) {
            addCriterion("bt_cost like", value, "btCost");
            return (Criteria) this;
        }

        public Criteria andBtCostNotLike(String value) {
            addCriterion("bt_cost not like", value, "btCost");
            return (Criteria) this;
        }

        public Criteria andBtCostIn(List<String> values) {
            addCriterion("bt_cost in", values, "btCost");
            return (Criteria) this;
        }

        public Criteria andBtCostNotIn(List<String> values) {
            addCriterion("bt_cost not in", values, "btCost");
            return (Criteria) this;
        }

        public Criteria andBtCostBetween(String value1, String value2) {
            addCriterion("bt_cost between", value1, value2, "btCost");
            return (Criteria) this;
        }

        public Criteria andBtCostNotBetween(String value1, String value2) {
            addCriterion("bt_cost not between", value1, value2, "btCost");
            return (Criteria) this;
        }

        public Criteria andBtDetailIsNull() {
            addCriterion("bt_detail is null");
            return (Criteria) this;
        }

        public Criteria andBtDetailIsNotNull() {
            addCriterion("bt_detail is not null");
            return (Criteria) this;
        }

        public Criteria andBtDetailEqualTo(String value) {
            addCriterion("bt_detail =", value, "btDetail");
            return (Criteria) this;
        }

        public Criteria andBtDetailNotEqualTo(String value) {
            addCriterion("bt_detail <>", value, "btDetail");
            return (Criteria) this;
        }

        public Criteria andBtDetailGreaterThan(String value) {
            addCriterion("bt_detail >", value, "btDetail");
            return (Criteria) this;
        }

        public Criteria andBtDetailGreaterThanOrEqualTo(String value) {
            addCriterion("bt_detail >=", value, "btDetail");
            return (Criteria) this;
        }

        public Criteria andBtDetailLessThan(String value) {
            addCriterion("bt_detail <", value, "btDetail");
            return (Criteria) this;
        }

        public Criteria andBtDetailLessThanOrEqualTo(String value) {
            addCriterion("bt_detail <=", value, "btDetail");
            return (Criteria) this;
        }

        public Criteria andBtDetailLike(String value) {
            addCriterion("bt_detail like", value, "btDetail");
            return (Criteria) this;
        }

        public Criteria andBtDetailNotLike(String value) {
            addCriterion("bt_detail not like", value, "btDetail");
            return (Criteria) this;
        }

        public Criteria andBtDetailIn(List<String> values) {
            addCriterion("bt_detail in", values, "btDetail");
            return (Criteria) this;
        }

        public Criteria andBtDetailNotIn(List<String> values) {
            addCriterion("bt_detail not in", values, "btDetail");
            return (Criteria) this;
        }

        public Criteria andBtDetailBetween(String value1, String value2) {
            addCriterion("bt_detail between", value1, value2, "btDetail");
            return (Criteria) this;
        }

        public Criteria andBtDetailNotBetween(String value1, String value2) {
            addCriterion("bt_detail not between", value1, value2, "btDetail");
            return (Criteria) this;
        }

        public Criteria andBtAddressIsNull() {
            addCriterion("bt_address is null");
            return (Criteria) this;
        }

        public Criteria andBtAddressIsNotNull() {
            addCriterion("bt_address is not null");
            return (Criteria) this;
        }

        public Criteria andBtAddressEqualTo(String value) {
            addCriterion("bt_address =", value, "btAddress");
            return (Criteria) this;
        }

        public Criteria andBtAddressNotEqualTo(String value) {
            addCriterion("bt_address <>", value, "btAddress");
            return (Criteria) this;
        }

        public Criteria andBtAddressGreaterThan(String value) {
            addCriterion("bt_address >", value, "btAddress");
            return (Criteria) this;
        }

        public Criteria andBtAddressGreaterThanOrEqualTo(String value) {
            addCriterion("bt_address >=", value, "btAddress");
            return (Criteria) this;
        }

        public Criteria andBtAddressLessThan(String value) {
            addCriterion("bt_address <", value, "btAddress");
            return (Criteria) this;
        }

        public Criteria andBtAddressLessThanOrEqualTo(String value) {
            addCriterion("bt_address <=", value, "btAddress");
            return (Criteria) this;
        }

        public Criteria andBtAddressLike(String value) {
            addCriterion("bt_address like", value, "btAddress");
            return (Criteria) this;
        }

        public Criteria andBtAddressNotLike(String value) {
            addCriterion("bt_address not like", value, "btAddress");
            return (Criteria) this;
        }

        public Criteria andBtAddressIn(List<String> values) {
            addCriterion("bt_address in", values, "btAddress");
            return (Criteria) this;
        }

        public Criteria andBtAddressNotIn(List<String> values) {
            addCriterion("bt_address not in", values, "btAddress");
            return (Criteria) this;
        }

        public Criteria andBtAddressBetween(String value1, String value2) {
            addCriterion("bt_address between", value1, value2, "btAddress");
            return (Criteria) this;
        }

        public Criteria andBtAddressNotBetween(String value1, String value2) {
            addCriterion("bt_address not between", value1, value2, "btAddress");
            return (Criteria) this;
        }

        public Criteria andBtAskBeginTimeIsNull() {
            addCriterion("bt_ask_begin_time is null");
            return (Criteria) this;
        }

        public Criteria andBtAskBeginTimeIsNotNull() {
            addCriterion("bt_ask_begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andBtAskBeginTimeEqualTo(String value) {
            addCriterion("bt_ask_begin_time =", value, "btAskBeginTime");
            return (Criteria) this;
        }

        public Criteria andBtAskBeginTimeNotEqualTo(String value) {
            addCriterion("bt_ask_begin_time <>", value, "btAskBeginTime");
            return (Criteria) this;
        }

        public Criteria andBtAskBeginTimeGreaterThan(String value) {
            addCriterion("bt_ask_begin_time >", value, "btAskBeginTime");
            return (Criteria) this;
        }

        public Criteria andBtAskBeginTimeGreaterThanOrEqualTo(String value) {
            addCriterion("bt_ask_begin_time >=", value, "btAskBeginTime");
            return (Criteria) this;
        }

        public Criteria andBtAskBeginTimeLessThan(String value) {
            addCriterion("bt_ask_begin_time <", value, "btAskBeginTime");
            return (Criteria) this;
        }

        public Criteria andBtAskBeginTimeLessThanOrEqualTo(String value) {
            addCriterion("bt_ask_begin_time <=", value, "btAskBeginTime");
            return (Criteria) this;
        }

        public Criteria andBtAskBeginTimeLike(String value) {
            addCriterion("bt_ask_begin_time like", value, "btAskBeginTime");
            return (Criteria) this;
        }

        public Criteria andBtAskBeginTimeNotLike(String value) {
            addCriterion("bt_ask_begin_time not like", value, "btAskBeginTime");
            return (Criteria) this;
        }

        public Criteria andBtAskBeginTimeIn(List<String> values) {
            addCriterion("bt_ask_begin_time in", values, "btAskBeginTime");
            return (Criteria) this;
        }

        public Criteria andBtAskBeginTimeNotIn(List<String> values) {
            addCriterion("bt_ask_begin_time not in", values, "btAskBeginTime");
            return (Criteria) this;
        }

        public Criteria andBtAskBeginTimeBetween(String value1, String value2) {
            addCriterion("bt_ask_begin_time between", value1, value2, "btAskBeginTime");
            return (Criteria) this;
        }

        public Criteria andBtAskBeginTimeNotBetween(String value1, String value2) {
            addCriterion("bt_ask_begin_time not between", value1, value2, "btAskBeginTime");
            return (Criteria) this;
        }

        public Criteria andBtAskEndTimeIsNull() {
            addCriterion("bt_ask_end_time is null");
            return (Criteria) this;
        }

        public Criteria andBtAskEndTimeIsNotNull() {
            addCriterion("bt_ask_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andBtAskEndTimeEqualTo(String value) {
            addCriterion("bt_ask_end_time =", value, "btAskEndTime");
            return (Criteria) this;
        }

        public Criteria andBtAskEndTimeNotEqualTo(String value) {
            addCriterion("bt_ask_end_time <>", value, "btAskEndTime");
            return (Criteria) this;
        }

        public Criteria andBtAskEndTimeGreaterThan(String value) {
            addCriterion("bt_ask_end_time >", value, "btAskEndTime");
            return (Criteria) this;
        }

        public Criteria andBtAskEndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("bt_ask_end_time >=", value, "btAskEndTime");
            return (Criteria) this;
        }

        public Criteria andBtAskEndTimeLessThan(String value) {
            addCriterion("bt_ask_end_time <", value, "btAskEndTime");
            return (Criteria) this;
        }

        public Criteria andBtAskEndTimeLessThanOrEqualTo(String value) {
            addCriterion("bt_ask_end_time <=", value, "btAskEndTime");
            return (Criteria) this;
        }

        public Criteria andBtAskEndTimeLike(String value) {
            addCriterion("bt_ask_end_time like", value, "btAskEndTime");
            return (Criteria) this;
        }

        public Criteria andBtAskEndTimeNotLike(String value) {
            addCriterion("bt_ask_end_time not like", value, "btAskEndTime");
            return (Criteria) this;
        }

        public Criteria andBtAskEndTimeIn(List<String> values) {
            addCriterion("bt_ask_end_time in", values, "btAskEndTime");
            return (Criteria) this;
        }

        public Criteria andBtAskEndTimeNotIn(List<String> values) {
            addCriterion("bt_ask_end_time not in", values, "btAskEndTime");
            return (Criteria) this;
        }

        public Criteria andBtAskEndTimeBetween(String value1, String value2) {
            addCriterion("bt_ask_end_time between", value1, value2, "btAskEndTime");
            return (Criteria) this;
        }

        public Criteria andBtAskEndTimeNotBetween(String value1, String value2) {
            addCriterion("bt_ask_end_time not between", value1, value2, "btAskEndTime");
            return (Criteria) this;
        }

        public Criteria andBtAskSustainIsNull() {
            addCriterion("bt_ask_sustain is null");
            return (Criteria) this;
        }

        public Criteria andBtAskSustainIsNotNull() {
            addCriterion("bt_ask_sustain is not null");
            return (Criteria) this;
        }

        public Criteria andBtAskSustainEqualTo(String value) {
            addCriterion("bt_ask_sustain =", value, "btAskSustain");
            return (Criteria) this;
        }

        public Criteria andBtAskSustainNotEqualTo(String value) {
            addCriterion("bt_ask_sustain <>", value, "btAskSustain");
            return (Criteria) this;
        }

        public Criteria andBtAskSustainGreaterThan(String value) {
            addCriterion("bt_ask_sustain >", value, "btAskSustain");
            return (Criteria) this;
        }

        public Criteria andBtAskSustainGreaterThanOrEqualTo(String value) {
            addCriterion("bt_ask_sustain >=", value, "btAskSustain");
            return (Criteria) this;
        }

        public Criteria andBtAskSustainLessThan(String value) {
            addCriterion("bt_ask_sustain <", value, "btAskSustain");
            return (Criteria) this;
        }

        public Criteria andBtAskSustainLessThanOrEqualTo(String value) {
            addCriterion("bt_ask_sustain <=", value, "btAskSustain");
            return (Criteria) this;
        }

        public Criteria andBtAskSustainLike(String value) {
            addCriterion("bt_ask_sustain like", value, "btAskSustain");
            return (Criteria) this;
        }

        public Criteria andBtAskSustainNotLike(String value) {
            addCriterion("bt_ask_sustain not like", value, "btAskSustain");
            return (Criteria) this;
        }

        public Criteria andBtAskSustainIn(List<String> values) {
            addCriterion("bt_ask_sustain in", values, "btAskSustain");
            return (Criteria) this;
        }

        public Criteria andBtAskSustainNotIn(List<String> values) {
            addCriterion("bt_ask_sustain not in", values, "btAskSustain");
            return (Criteria) this;
        }

        public Criteria andBtAskSustainBetween(String value1, String value2) {
            addCriterion("bt_ask_sustain between", value1, value2, "btAskSustain");
            return (Criteria) this;
        }

        public Criteria andBtAskSustainNotBetween(String value1, String value2) {
            addCriterion("bt_ask_sustain not between", value1, value2, "btAskSustain");
            return (Criteria) this;
        }

        public Criteria andBtAskReasonIsNull() {
            addCriterion("bt_ask_reason is null");
            return (Criteria) this;
        }

        public Criteria andBtAskReasonIsNotNull() {
            addCriterion("bt_ask_reason is not null");
            return (Criteria) this;
        }

        public Criteria andBtAskReasonEqualTo(String value) {
            addCriterion("bt_ask_reason =", value, "btAskReason");
            return (Criteria) this;
        }

        public Criteria andBtAskReasonNotEqualTo(String value) {
            addCriterion("bt_ask_reason <>", value, "btAskReason");
            return (Criteria) this;
        }

        public Criteria andBtAskReasonGreaterThan(String value) {
            addCriterion("bt_ask_reason >", value, "btAskReason");
            return (Criteria) this;
        }

        public Criteria andBtAskReasonGreaterThanOrEqualTo(String value) {
            addCriterion("bt_ask_reason >=", value, "btAskReason");
            return (Criteria) this;
        }

        public Criteria andBtAskReasonLessThan(String value) {
            addCriterion("bt_ask_reason <", value, "btAskReason");
            return (Criteria) this;
        }

        public Criteria andBtAskReasonLessThanOrEqualTo(String value) {
            addCriterion("bt_ask_reason <=", value, "btAskReason");
            return (Criteria) this;
        }

        public Criteria andBtAskReasonLike(String value) {
            addCriterion("bt_ask_reason like", value, "btAskReason");
            return (Criteria) this;
        }

        public Criteria andBtAskReasonNotLike(String value) {
            addCriterion("bt_ask_reason not like", value, "btAskReason");
            return (Criteria) this;
        }

        public Criteria andBtAskReasonIn(List<String> values) {
            addCriterion("bt_ask_reason in", values, "btAskReason");
            return (Criteria) this;
        }

        public Criteria andBtAskReasonNotIn(List<String> values) {
            addCriterion("bt_ask_reason not in", values, "btAskReason");
            return (Criteria) this;
        }

        public Criteria andBtAskReasonBetween(String value1, String value2) {
            addCriterion("bt_ask_reason between", value1, value2, "btAskReason");
            return (Criteria) this;
        }

        public Criteria andBtAskReasonNotBetween(String value1, String value2) {
            addCriterion("bt_ask_reason not between", value1, value2, "btAskReason");
            return (Criteria) this;
        }

        public Criteria andBtPictureIsNull() {
            addCriterion("bt_picture is null");
            return (Criteria) this;
        }

        public Criteria andBtPictureIsNotNull() {
            addCriterion("bt_picture is not null");
            return (Criteria) this;
        }

        public Criteria andBtPictureEqualTo(String value) {
            addCriterion("bt_picture =", value, "btPicture");
            return (Criteria) this;
        }

        public Criteria andBtPictureNotEqualTo(String value) {
            addCriterion("bt_picture <>", value, "btPicture");
            return (Criteria) this;
        }

        public Criteria andBtPictureGreaterThan(String value) {
            addCriterion("bt_picture >", value, "btPicture");
            return (Criteria) this;
        }

        public Criteria andBtPictureGreaterThanOrEqualTo(String value) {
            addCriterion("bt_picture >=", value, "btPicture");
            return (Criteria) this;
        }

        public Criteria andBtPictureLessThan(String value) {
            addCriterion("bt_picture <", value, "btPicture");
            return (Criteria) this;
        }

        public Criteria andBtPictureLessThanOrEqualTo(String value) {
            addCriterion("bt_picture <=", value, "btPicture");
            return (Criteria) this;
        }

        public Criteria andBtPictureLike(String value) {
            addCriterion("bt_picture like", value, "btPicture");
            return (Criteria) this;
        }

        public Criteria andBtPictureNotLike(String value) {
            addCriterion("bt_picture not like", value, "btPicture");
            return (Criteria) this;
        }

        public Criteria andBtPictureIn(List<String> values) {
            addCriterion("bt_picture in", values, "btPicture");
            return (Criteria) this;
        }

        public Criteria andBtPictureNotIn(List<String> values) {
            addCriterion("bt_picture not in", values, "btPicture");
            return (Criteria) this;
        }

        public Criteria andBtPictureBetween(String value1, String value2) {
            addCriterion("bt_picture between", value1, value2, "btPicture");
            return (Criteria) this;
        }

        public Criteria andBtPictureNotBetween(String value1, String value2) {
            addCriterion("bt_picture not between", value1, value2, "btPicture");
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