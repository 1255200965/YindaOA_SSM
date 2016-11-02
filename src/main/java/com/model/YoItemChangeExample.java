package com.model;

import java.util.ArrayList;
import java.util.List;

public class YoItemChangeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public YoItemChangeExample() {
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

        public Criteria andIcSequenceNoIsNull() {
            addCriterion("ic_sequence_no is null");
            return (Criteria) this;
        }

        public Criteria andIcSequenceNoIsNotNull() {
            addCriterion("ic_sequence_no is not null");
            return (Criteria) this;
        }

        public Criteria andIcSequenceNoEqualTo(Integer value) {
            addCriterion("ic_sequence_no =", value, "icSequenceNo");
            return (Criteria) this;
        }

        public Criteria andIcSequenceNoNotEqualTo(Integer value) {
            addCriterion("ic_sequence_no <>", value, "icSequenceNo");
            return (Criteria) this;
        }

        public Criteria andIcSequenceNoGreaterThan(Integer value) {
            addCriterion("ic_sequence_no >", value, "icSequenceNo");
            return (Criteria) this;
        }

        public Criteria andIcSequenceNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("ic_sequence_no >=", value, "icSequenceNo");
            return (Criteria) this;
        }

        public Criteria andIcSequenceNoLessThan(Integer value) {
            addCriterion("ic_sequence_no <", value, "icSequenceNo");
            return (Criteria) this;
        }

        public Criteria andIcSequenceNoLessThanOrEqualTo(Integer value) {
            addCriterion("ic_sequence_no <=", value, "icSequenceNo");
            return (Criteria) this;
        }

        public Criteria andIcSequenceNoIn(List<Integer> values) {
            addCriterion("ic_sequence_no in", values, "icSequenceNo");
            return (Criteria) this;
        }

        public Criteria andIcSequenceNoNotIn(List<Integer> values) {
            addCriterion("ic_sequence_no not in", values, "icSequenceNo");
            return (Criteria) this;
        }

        public Criteria andIcSequenceNoBetween(Integer value1, Integer value2) {
            addCriterion("ic_sequence_no between", value1, value2, "icSequenceNo");
            return (Criteria) this;
        }

        public Criteria andIcSequenceNoNotBetween(Integer value1, Integer value2) {
            addCriterion("ic_sequence_no not between", value1, value2, "icSequenceNo");
            return (Criteria) this;
        }

        public Criteria andIcApproveNoIsNull() {
            addCriterion("ic_approve_no is null");
            return (Criteria) this;
        }

        public Criteria andIcApproveNoIsNotNull() {
            addCriterion("ic_approve_no is not null");
            return (Criteria) this;
        }

        public Criteria andIcApproveNoEqualTo(String value) {
            addCriterion("ic_approve_no =", value, "icApproveNo");
            return (Criteria) this;
        }

        public Criteria andIcApproveNoNotEqualTo(String value) {
            addCriterion("ic_approve_no <>", value, "icApproveNo");
            return (Criteria) this;
        }

        public Criteria andIcApproveNoGreaterThan(String value) {
            addCriterion("ic_approve_no >", value, "icApproveNo");
            return (Criteria) this;
        }

        public Criteria andIcApproveNoGreaterThanOrEqualTo(String value) {
            addCriterion("ic_approve_no >=", value, "icApproveNo");
            return (Criteria) this;
        }

        public Criteria andIcApproveNoLessThan(String value) {
            addCriterion("ic_approve_no <", value, "icApproveNo");
            return (Criteria) this;
        }

        public Criteria andIcApproveNoLessThanOrEqualTo(String value) {
            addCriterion("ic_approve_no <=", value, "icApproveNo");
            return (Criteria) this;
        }

        public Criteria andIcApproveNoLike(String value) {
            addCriterion("ic_approve_no like", value, "icApproveNo");
            return (Criteria) this;
        }

        public Criteria andIcApproveNoNotLike(String value) {
            addCriterion("ic_approve_no not like", value, "icApproveNo");
            return (Criteria) this;
        }

        public Criteria andIcApproveNoIn(List<String> values) {
            addCriterion("ic_approve_no in", values, "icApproveNo");
            return (Criteria) this;
        }

        public Criteria andIcApproveNoNotIn(List<String> values) {
            addCriterion("ic_approve_no not in", values, "icApproveNo");
            return (Criteria) this;
        }

        public Criteria andIcApproveNoBetween(String value1, String value2) {
            addCriterion("ic_approve_no between", value1, value2, "icApproveNo");
            return (Criteria) this;
        }

        public Criteria andIcApproveNoNotBetween(String value1, String value2) {
            addCriterion("ic_approve_no not between", value1, value2, "icApproveNo");
            return (Criteria) this;
        }

        public Criteria andIcTitleIsNull() {
            addCriterion("ic_title is null");
            return (Criteria) this;
        }

        public Criteria andIcTitleIsNotNull() {
            addCriterion("ic_title is not null");
            return (Criteria) this;
        }

        public Criteria andIcTitleEqualTo(String value) {
            addCriterion("ic_title =", value, "icTitle");
            return (Criteria) this;
        }

        public Criteria andIcTitleNotEqualTo(String value) {
            addCriterion("ic_title <>", value, "icTitle");
            return (Criteria) this;
        }

        public Criteria andIcTitleGreaterThan(String value) {
            addCriterion("ic_title >", value, "icTitle");
            return (Criteria) this;
        }

        public Criteria andIcTitleGreaterThanOrEqualTo(String value) {
            addCriterion("ic_title >=", value, "icTitle");
            return (Criteria) this;
        }

        public Criteria andIcTitleLessThan(String value) {
            addCriterion("ic_title <", value, "icTitle");
            return (Criteria) this;
        }

        public Criteria andIcTitleLessThanOrEqualTo(String value) {
            addCriterion("ic_title <=", value, "icTitle");
            return (Criteria) this;
        }

        public Criteria andIcTitleLike(String value) {
            addCriterion("ic_title like", value, "icTitle");
            return (Criteria) this;
        }

        public Criteria andIcTitleNotLike(String value) {
            addCriterion("ic_title not like", value, "icTitle");
            return (Criteria) this;
        }

        public Criteria andIcTitleIn(List<String> values) {
            addCriterion("ic_title in", values, "icTitle");
            return (Criteria) this;
        }

        public Criteria andIcTitleNotIn(List<String> values) {
            addCriterion("ic_title not in", values, "icTitle");
            return (Criteria) this;
        }

        public Criteria andIcTitleBetween(String value1, String value2) {
            addCriterion("ic_title between", value1, value2, "icTitle");
            return (Criteria) this;
        }

        public Criteria andIcTitleNotBetween(String value1, String value2) {
            addCriterion("ic_title not between", value1, value2, "icTitle");
            return (Criteria) this;
        }

        public Criteria andIcApproveStateIsNull() {
            addCriterion("ic_approve_state is null");
            return (Criteria) this;
        }

        public Criteria andIcApproveStateIsNotNull() {
            addCriterion("ic_approve_state is not null");
            return (Criteria) this;
        }

        public Criteria andIcApproveStateEqualTo(String value) {
            addCriterion("ic_approve_state =", value, "icApproveState");
            return (Criteria) this;
        }

        public Criteria andIcApproveStateNotEqualTo(String value) {
            addCriterion("ic_approve_state <>", value, "icApproveState");
            return (Criteria) this;
        }

        public Criteria andIcApproveStateGreaterThan(String value) {
            addCriterion("ic_approve_state >", value, "icApproveState");
            return (Criteria) this;
        }

        public Criteria andIcApproveStateGreaterThanOrEqualTo(String value) {
            addCriterion("ic_approve_state >=", value, "icApproveState");
            return (Criteria) this;
        }

        public Criteria andIcApproveStateLessThan(String value) {
            addCriterion("ic_approve_state <", value, "icApproveState");
            return (Criteria) this;
        }

        public Criteria andIcApproveStateLessThanOrEqualTo(String value) {
            addCriterion("ic_approve_state <=", value, "icApproveState");
            return (Criteria) this;
        }

        public Criteria andIcApproveStateLike(String value) {
            addCriterion("ic_approve_state like", value, "icApproveState");
            return (Criteria) this;
        }

        public Criteria andIcApproveStateNotLike(String value) {
            addCriterion("ic_approve_state not like", value, "icApproveState");
            return (Criteria) this;
        }

        public Criteria andIcApproveStateIn(List<String> values) {
            addCriterion("ic_approve_state in", values, "icApproveState");
            return (Criteria) this;
        }

        public Criteria andIcApproveStateNotIn(List<String> values) {
            addCriterion("ic_approve_state not in", values, "icApproveState");
            return (Criteria) this;
        }

        public Criteria andIcApproveStateBetween(String value1, String value2) {
            addCriterion("ic_approve_state between", value1, value2, "icApproveState");
            return (Criteria) this;
        }

        public Criteria andIcApproveStateNotBetween(String value1, String value2) {
            addCriterion("ic_approve_state not between", value1, value2, "icApproveState");
            return (Criteria) this;
        }

        public Criteria andIcApproveResultIsNull() {
            addCriterion("ic_approve_result is null");
            return (Criteria) this;
        }

        public Criteria andIcApproveResultIsNotNull() {
            addCriterion("ic_approve_result is not null");
            return (Criteria) this;
        }

        public Criteria andIcApproveResultEqualTo(String value) {
            addCriterion("ic_approve_result =", value, "icApproveResult");
            return (Criteria) this;
        }

        public Criteria andIcApproveResultNotEqualTo(String value) {
            addCriterion("ic_approve_result <>", value, "icApproveResult");
            return (Criteria) this;
        }

        public Criteria andIcApproveResultGreaterThan(String value) {
            addCriterion("ic_approve_result >", value, "icApproveResult");
            return (Criteria) this;
        }

        public Criteria andIcApproveResultGreaterThanOrEqualTo(String value) {
            addCriterion("ic_approve_result >=", value, "icApproveResult");
            return (Criteria) this;
        }

        public Criteria andIcApproveResultLessThan(String value) {
            addCriterion("ic_approve_result <", value, "icApproveResult");
            return (Criteria) this;
        }

        public Criteria andIcApproveResultLessThanOrEqualTo(String value) {
            addCriterion("ic_approve_result <=", value, "icApproveResult");
            return (Criteria) this;
        }

        public Criteria andIcApproveResultLike(String value) {
            addCriterion("ic_approve_result like", value, "icApproveResult");
            return (Criteria) this;
        }

        public Criteria andIcApproveResultNotLike(String value) {
            addCriterion("ic_approve_result not like", value, "icApproveResult");
            return (Criteria) this;
        }

        public Criteria andIcApproveResultIn(List<String> values) {
            addCriterion("ic_approve_result in", values, "icApproveResult");
            return (Criteria) this;
        }

        public Criteria andIcApproveResultNotIn(List<String> values) {
            addCriterion("ic_approve_result not in", values, "icApproveResult");
            return (Criteria) this;
        }

        public Criteria andIcApproveResultBetween(String value1, String value2) {
            addCriterion("ic_approve_result between", value1, value2, "icApproveResult");
            return (Criteria) this;
        }

        public Criteria andIcApproveResultNotBetween(String value1, String value2) {
            addCriterion("ic_approve_result not between", value1, value2, "icApproveResult");
            return (Criteria) this;
        }

        public Criteria andIcApproveBeginIsNull() {
            addCriterion("ic_approve_begin is null");
            return (Criteria) this;
        }

        public Criteria andIcApproveBeginIsNotNull() {
            addCriterion("ic_approve_begin is not null");
            return (Criteria) this;
        }

        public Criteria andIcApproveBeginEqualTo(String value) {
            addCriterion("ic_approve_begin =", value, "icApproveBegin");
            return (Criteria) this;
        }

        public Criteria andIcApproveBeginNotEqualTo(String value) {
            addCriterion("ic_approve_begin <>", value, "icApproveBegin");
            return (Criteria) this;
        }

        public Criteria andIcApproveBeginGreaterThan(String value) {
            addCriterion("ic_approve_begin >", value, "icApproveBegin");
            return (Criteria) this;
        }

        public Criteria andIcApproveBeginGreaterThanOrEqualTo(String value) {
            addCriterion("ic_approve_begin >=", value, "icApproveBegin");
            return (Criteria) this;
        }

        public Criteria andIcApproveBeginLessThan(String value) {
            addCriterion("ic_approve_begin <", value, "icApproveBegin");
            return (Criteria) this;
        }

        public Criteria andIcApproveBeginLessThanOrEqualTo(String value) {
            addCriterion("ic_approve_begin <=", value, "icApproveBegin");
            return (Criteria) this;
        }

        public Criteria andIcApproveBeginLike(String value) {
            addCriterion("ic_approve_begin like", value, "icApproveBegin");
            return (Criteria) this;
        }

        public Criteria andIcApproveBeginNotLike(String value) {
            addCriterion("ic_approve_begin not like", value, "icApproveBegin");
            return (Criteria) this;
        }

        public Criteria andIcApproveBeginIn(List<String> values) {
            addCriterion("ic_approve_begin in", values, "icApproveBegin");
            return (Criteria) this;
        }

        public Criteria andIcApproveBeginNotIn(List<String> values) {
            addCriterion("ic_approve_begin not in", values, "icApproveBegin");
            return (Criteria) this;
        }

        public Criteria andIcApproveBeginBetween(String value1, String value2) {
            addCriterion("ic_approve_begin between", value1, value2, "icApproveBegin");
            return (Criteria) this;
        }

        public Criteria andIcApproveBeginNotBetween(String value1, String value2) {
            addCriterion("ic_approve_begin not between", value1, value2, "icApproveBegin");
            return (Criteria) this;
        }

        public Criteria andIcApproveEndIsNull() {
            addCriterion("ic_approve_end is null");
            return (Criteria) this;
        }

        public Criteria andIcApproveEndIsNotNull() {
            addCriterion("ic_approve_end is not null");
            return (Criteria) this;
        }

        public Criteria andIcApproveEndEqualTo(String value) {
            addCriterion("ic_approve_end =", value, "icApproveEnd");
            return (Criteria) this;
        }

        public Criteria andIcApproveEndNotEqualTo(String value) {
            addCriterion("ic_approve_end <>", value, "icApproveEnd");
            return (Criteria) this;
        }

        public Criteria andIcApproveEndGreaterThan(String value) {
            addCriterion("ic_approve_end >", value, "icApproveEnd");
            return (Criteria) this;
        }

        public Criteria andIcApproveEndGreaterThanOrEqualTo(String value) {
            addCriterion("ic_approve_end >=", value, "icApproveEnd");
            return (Criteria) this;
        }

        public Criteria andIcApproveEndLessThan(String value) {
            addCriterion("ic_approve_end <", value, "icApproveEnd");
            return (Criteria) this;
        }

        public Criteria andIcApproveEndLessThanOrEqualTo(String value) {
            addCriterion("ic_approve_end <=", value, "icApproveEnd");
            return (Criteria) this;
        }

        public Criteria andIcApproveEndLike(String value) {
            addCriterion("ic_approve_end like", value, "icApproveEnd");
            return (Criteria) this;
        }

        public Criteria andIcApproveEndNotLike(String value) {
            addCriterion("ic_approve_end not like", value, "icApproveEnd");
            return (Criteria) this;
        }

        public Criteria andIcApproveEndIn(List<String> values) {
            addCriterion("ic_approve_end in", values, "icApproveEnd");
            return (Criteria) this;
        }

        public Criteria andIcApproveEndNotIn(List<String> values) {
            addCriterion("ic_approve_end not in", values, "icApproveEnd");
            return (Criteria) this;
        }

        public Criteria andIcApproveEndBetween(String value1, String value2) {
            addCriterion("ic_approve_end between", value1, value2, "icApproveEnd");
            return (Criteria) this;
        }

        public Criteria andIcApproveEndNotBetween(String value1, String value2) {
            addCriterion("ic_approve_end not between", value1, value2, "icApproveEnd");
            return (Criteria) this;
        }

        public Criteria andIcAskStaffIdIsNull() {
            addCriterion("ic_ask_staff_id is null");
            return (Criteria) this;
        }

        public Criteria andIcAskStaffIdIsNotNull() {
            addCriterion("ic_ask_staff_id is not null");
            return (Criteria) this;
        }

        public Criteria andIcAskStaffIdEqualTo(String value) {
            addCriterion("ic_ask_staff_id =", value, "icAskStaffId");
            return (Criteria) this;
        }

        public Criteria andIcAskStaffIdNotEqualTo(String value) {
            addCriterion("ic_ask_staff_id <>", value, "icAskStaffId");
            return (Criteria) this;
        }

        public Criteria andIcAskStaffIdGreaterThan(String value) {
            addCriterion("ic_ask_staff_id >", value, "icAskStaffId");
            return (Criteria) this;
        }

        public Criteria andIcAskStaffIdGreaterThanOrEqualTo(String value) {
            addCriterion("ic_ask_staff_id >=", value, "icAskStaffId");
            return (Criteria) this;
        }

        public Criteria andIcAskStaffIdLessThan(String value) {
            addCriterion("ic_ask_staff_id <", value, "icAskStaffId");
            return (Criteria) this;
        }

        public Criteria andIcAskStaffIdLessThanOrEqualTo(String value) {
            addCriterion("ic_ask_staff_id <=", value, "icAskStaffId");
            return (Criteria) this;
        }

        public Criteria andIcAskStaffIdLike(String value) {
            addCriterion("ic_ask_staff_id like", value, "icAskStaffId");
            return (Criteria) this;
        }

        public Criteria andIcAskStaffIdNotLike(String value) {
            addCriterion("ic_ask_staff_id not like", value, "icAskStaffId");
            return (Criteria) this;
        }

        public Criteria andIcAskStaffIdIn(List<String> values) {
            addCriterion("ic_ask_staff_id in", values, "icAskStaffId");
            return (Criteria) this;
        }

        public Criteria andIcAskStaffIdNotIn(List<String> values) {
            addCriterion("ic_ask_staff_id not in", values, "icAskStaffId");
            return (Criteria) this;
        }

        public Criteria andIcAskStaffIdBetween(String value1, String value2) {
            addCriterion("ic_ask_staff_id between", value1, value2, "icAskStaffId");
            return (Criteria) this;
        }

        public Criteria andIcAskStaffIdNotBetween(String value1, String value2) {
            addCriterion("ic_ask_staff_id not between", value1, value2, "icAskStaffId");
            return (Criteria) this;
        }

        public Criteria andIcAskStaffNameIsNull() {
            addCriterion("ic_ask_staff_name is null");
            return (Criteria) this;
        }

        public Criteria andIcAskStaffNameIsNotNull() {
            addCriterion("ic_ask_staff_name is not null");
            return (Criteria) this;
        }

        public Criteria andIcAskStaffNameEqualTo(String value) {
            addCriterion("ic_ask_staff_name =", value, "icAskStaffName");
            return (Criteria) this;
        }

        public Criteria andIcAskStaffNameNotEqualTo(String value) {
            addCriterion("ic_ask_staff_name <>", value, "icAskStaffName");
            return (Criteria) this;
        }

        public Criteria andIcAskStaffNameGreaterThan(String value) {
            addCriterion("ic_ask_staff_name >", value, "icAskStaffName");
            return (Criteria) this;
        }

        public Criteria andIcAskStaffNameGreaterThanOrEqualTo(String value) {
            addCriterion("ic_ask_staff_name >=", value, "icAskStaffName");
            return (Criteria) this;
        }

        public Criteria andIcAskStaffNameLessThan(String value) {
            addCriterion("ic_ask_staff_name <", value, "icAskStaffName");
            return (Criteria) this;
        }

        public Criteria andIcAskStaffNameLessThanOrEqualTo(String value) {
            addCriterion("ic_ask_staff_name <=", value, "icAskStaffName");
            return (Criteria) this;
        }

        public Criteria andIcAskStaffNameLike(String value) {
            addCriterion("ic_ask_staff_name like", value, "icAskStaffName");
            return (Criteria) this;
        }

        public Criteria andIcAskStaffNameNotLike(String value) {
            addCriterion("ic_ask_staff_name not like", value, "icAskStaffName");
            return (Criteria) this;
        }

        public Criteria andIcAskStaffNameIn(List<String> values) {
            addCriterion("ic_ask_staff_name in", values, "icAskStaffName");
            return (Criteria) this;
        }

        public Criteria andIcAskStaffNameNotIn(List<String> values) {
            addCriterion("ic_ask_staff_name not in", values, "icAskStaffName");
            return (Criteria) this;
        }

        public Criteria andIcAskStaffNameBetween(String value1, String value2) {
            addCriterion("ic_ask_staff_name between", value1, value2, "icAskStaffName");
            return (Criteria) this;
        }

        public Criteria andIcAskStaffNameNotBetween(String value1, String value2) {
            addCriterion("ic_ask_staff_name not between", value1, value2, "icAskStaffName");
            return (Criteria) this;
        }

        public Criteria andIcAskStaffDepartIsNull() {
            addCriterion("ic_ask_staff_depart is null");
            return (Criteria) this;
        }

        public Criteria andIcAskStaffDepartIsNotNull() {
            addCriterion("ic_ask_staff_depart is not null");
            return (Criteria) this;
        }

        public Criteria andIcAskStaffDepartEqualTo(String value) {
            addCriterion("ic_ask_staff_depart =", value, "icAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andIcAskStaffDepartNotEqualTo(String value) {
            addCriterion("ic_ask_staff_depart <>", value, "icAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andIcAskStaffDepartGreaterThan(String value) {
            addCriterion("ic_ask_staff_depart >", value, "icAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andIcAskStaffDepartGreaterThanOrEqualTo(String value) {
            addCriterion("ic_ask_staff_depart >=", value, "icAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andIcAskStaffDepartLessThan(String value) {
            addCriterion("ic_ask_staff_depart <", value, "icAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andIcAskStaffDepartLessThanOrEqualTo(String value) {
            addCriterion("ic_ask_staff_depart <=", value, "icAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andIcAskStaffDepartLike(String value) {
            addCriterion("ic_ask_staff_depart like", value, "icAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andIcAskStaffDepartNotLike(String value) {
            addCriterion("ic_ask_staff_depart not like", value, "icAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andIcAskStaffDepartIn(List<String> values) {
            addCriterion("ic_ask_staff_depart in", values, "icAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andIcAskStaffDepartNotIn(List<String> values) {
            addCriterion("ic_ask_staff_depart not in", values, "icAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andIcAskStaffDepartBetween(String value1, String value2) {
            addCriterion("ic_ask_staff_depart between", value1, value2, "icAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andIcAskStaffDepartNotBetween(String value1, String value2) {
            addCriterion("ic_ask_staff_depart not between", value1, value2, "icAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andIcHistoryApproveNameIsNull() {
            addCriterion("ic_history_approve_name is null");
            return (Criteria) this;
        }

        public Criteria andIcHistoryApproveNameIsNotNull() {
            addCriterion("ic_history_approve_name is not null");
            return (Criteria) this;
        }

        public Criteria andIcHistoryApproveNameEqualTo(String value) {
            addCriterion("ic_history_approve_name =", value, "icHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andIcHistoryApproveNameNotEqualTo(String value) {
            addCriterion("ic_history_approve_name <>", value, "icHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andIcHistoryApproveNameGreaterThan(String value) {
            addCriterion("ic_history_approve_name >", value, "icHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andIcHistoryApproveNameGreaterThanOrEqualTo(String value) {
            addCriterion("ic_history_approve_name >=", value, "icHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andIcHistoryApproveNameLessThan(String value) {
            addCriterion("ic_history_approve_name <", value, "icHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andIcHistoryApproveNameLessThanOrEqualTo(String value) {
            addCriterion("ic_history_approve_name <=", value, "icHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andIcHistoryApproveNameLike(String value) {
            addCriterion("ic_history_approve_name like", value, "icHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andIcHistoryApproveNameNotLike(String value) {
            addCriterion("ic_history_approve_name not like", value, "icHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andIcHistoryApproveNameIn(List<String> values) {
            addCriterion("ic_history_approve_name in", values, "icHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andIcHistoryApproveNameNotIn(List<String> values) {
            addCriterion("ic_history_approve_name not in", values, "icHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andIcHistoryApproveNameBetween(String value1, String value2) {
            addCriterion("ic_history_approve_name between", value1, value2, "icHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andIcHistoryApproveNameNotBetween(String value1, String value2) {
            addCriterion("ic_history_approve_name not between", value1, value2, "icHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andIcApproveRecordIsNull() {
            addCriterion("ic_approve_record is null");
            return (Criteria) this;
        }

        public Criteria andIcApproveRecordIsNotNull() {
            addCriterion("ic_approve_record is not null");
            return (Criteria) this;
        }

        public Criteria andIcApproveRecordEqualTo(String value) {
            addCriterion("ic_approve_record =", value, "icApproveRecord");
            return (Criteria) this;
        }

        public Criteria andIcApproveRecordNotEqualTo(String value) {
            addCriterion("ic_approve_record <>", value, "icApproveRecord");
            return (Criteria) this;
        }

        public Criteria andIcApproveRecordGreaterThan(String value) {
            addCriterion("ic_approve_record >", value, "icApproveRecord");
            return (Criteria) this;
        }

        public Criteria andIcApproveRecordGreaterThanOrEqualTo(String value) {
            addCriterion("ic_approve_record >=", value, "icApproveRecord");
            return (Criteria) this;
        }

        public Criteria andIcApproveRecordLessThan(String value) {
            addCriterion("ic_approve_record <", value, "icApproveRecord");
            return (Criteria) this;
        }

        public Criteria andIcApproveRecordLessThanOrEqualTo(String value) {
            addCriterion("ic_approve_record <=", value, "icApproveRecord");
            return (Criteria) this;
        }

        public Criteria andIcApproveRecordLike(String value) {
            addCriterion("ic_approve_record like", value, "icApproveRecord");
            return (Criteria) this;
        }

        public Criteria andIcApproveRecordNotLike(String value) {
            addCriterion("ic_approve_record not like", value, "icApproveRecord");
            return (Criteria) this;
        }

        public Criteria andIcApproveRecordIn(List<String> values) {
            addCriterion("ic_approve_record in", values, "icApproveRecord");
            return (Criteria) this;
        }

        public Criteria andIcApproveRecordNotIn(List<String> values) {
            addCriterion("ic_approve_record not in", values, "icApproveRecord");
            return (Criteria) this;
        }

        public Criteria andIcApproveRecordBetween(String value1, String value2) {
            addCriterion("ic_approve_record between", value1, value2, "icApproveRecord");
            return (Criteria) this;
        }

        public Criteria andIcApproveRecordNotBetween(String value1, String value2) {
            addCriterion("ic_approve_record not between", value1, value2, "icApproveRecord");
            return (Criteria) this;
        }

        public Criteria andIcNowApproveNameIsNull() {
            addCriterion("ic_now_approve_name is null");
            return (Criteria) this;
        }

        public Criteria andIcNowApproveNameIsNotNull() {
            addCriterion("ic_now_approve_name is not null");
            return (Criteria) this;
        }

        public Criteria andIcNowApproveNameEqualTo(String value) {
            addCriterion("ic_now_approve_name =", value, "icNowApproveName");
            return (Criteria) this;
        }

        public Criteria andIcNowApproveNameNotEqualTo(String value) {
            addCriterion("ic_now_approve_name <>", value, "icNowApproveName");
            return (Criteria) this;
        }

        public Criteria andIcNowApproveNameGreaterThan(String value) {
            addCriterion("ic_now_approve_name >", value, "icNowApproveName");
            return (Criteria) this;
        }

        public Criteria andIcNowApproveNameGreaterThanOrEqualTo(String value) {
            addCriterion("ic_now_approve_name >=", value, "icNowApproveName");
            return (Criteria) this;
        }

        public Criteria andIcNowApproveNameLessThan(String value) {
            addCriterion("ic_now_approve_name <", value, "icNowApproveName");
            return (Criteria) this;
        }

        public Criteria andIcNowApproveNameLessThanOrEqualTo(String value) {
            addCriterion("ic_now_approve_name <=", value, "icNowApproveName");
            return (Criteria) this;
        }

        public Criteria andIcNowApproveNameLike(String value) {
            addCriterion("ic_now_approve_name like", value, "icNowApproveName");
            return (Criteria) this;
        }

        public Criteria andIcNowApproveNameNotLike(String value) {
            addCriterion("ic_now_approve_name not like", value, "icNowApproveName");
            return (Criteria) this;
        }

        public Criteria andIcNowApproveNameIn(List<String> values) {
            addCriterion("ic_now_approve_name in", values, "icNowApproveName");
            return (Criteria) this;
        }

        public Criteria andIcNowApproveNameNotIn(List<String> values) {
            addCriterion("ic_now_approve_name not in", values, "icNowApproveName");
            return (Criteria) this;
        }

        public Criteria andIcNowApproveNameBetween(String value1, String value2) {
            addCriterion("ic_now_approve_name between", value1, value2, "icNowApproveName");
            return (Criteria) this;
        }

        public Criteria andIcNowApproveNameNotBetween(String value1, String value2) {
            addCriterion("ic_now_approve_name not between", value1, value2, "icNowApproveName");
            return (Criteria) this;
        }

        public Criteria andIcCostIsNull() {
            addCriterion("ic_cost is null");
            return (Criteria) this;
        }

        public Criteria andIcCostIsNotNull() {
            addCriterion("ic_cost is not null");
            return (Criteria) this;
        }

        public Criteria andIcCostEqualTo(String value) {
            addCriterion("ic_cost =", value, "icCost");
            return (Criteria) this;
        }

        public Criteria andIcCostNotEqualTo(String value) {
            addCriterion("ic_cost <>", value, "icCost");
            return (Criteria) this;
        }

        public Criteria andIcCostGreaterThan(String value) {
            addCriterion("ic_cost >", value, "icCost");
            return (Criteria) this;
        }

        public Criteria andIcCostGreaterThanOrEqualTo(String value) {
            addCriterion("ic_cost >=", value, "icCost");
            return (Criteria) this;
        }

        public Criteria andIcCostLessThan(String value) {
            addCriterion("ic_cost <", value, "icCost");
            return (Criteria) this;
        }

        public Criteria andIcCostLessThanOrEqualTo(String value) {
            addCriterion("ic_cost <=", value, "icCost");
            return (Criteria) this;
        }

        public Criteria andIcCostLike(String value) {
            addCriterion("ic_cost like", value, "icCost");
            return (Criteria) this;
        }

        public Criteria andIcCostNotLike(String value) {
            addCriterion("ic_cost not like", value, "icCost");
            return (Criteria) this;
        }

        public Criteria andIcCostIn(List<String> values) {
            addCriterion("ic_cost in", values, "icCost");
            return (Criteria) this;
        }

        public Criteria andIcCostNotIn(List<String> values) {
            addCriterion("ic_cost not in", values, "icCost");
            return (Criteria) this;
        }

        public Criteria andIcCostBetween(String value1, String value2) {
            addCriterion("ic_cost between", value1, value2, "icCost");
            return (Criteria) this;
        }

        public Criteria andIcCostNotBetween(String value1, String value2) {
            addCriterion("ic_cost not between", value1, value2, "icCost");
            return (Criteria) this;
        }

        public Criteria andIcChangeItemIsNull() {
            addCriterion("ic_change_item is null");
            return (Criteria) this;
        }

        public Criteria andIcChangeItemIsNotNull() {
            addCriterion("ic_change_item is not null");
            return (Criteria) this;
        }

        public Criteria andIcChangeItemEqualTo(String value) {
            addCriterion("ic_change_item =", value, "icChangeItem");
            return (Criteria) this;
        }

        public Criteria andIcChangeItemNotEqualTo(String value) {
            addCriterion("ic_change_item <>", value, "icChangeItem");
            return (Criteria) this;
        }

        public Criteria andIcChangeItemGreaterThan(String value) {
            addCriterion("ic_change_item >", value, "icChangeItem");
            return (Criteria) this;
        }

        public Criteria andIcChangeItemGreaterThanOrEqualTo(String value) {
            addCriterion("ic_change_item >=", value, "icChangeItem");
            return (Criteria) this;
        }

        public Criteria andIcChangeItemLessThan(String value) {
            addCriterion("ic_change_item <", value, "icChangeItem");
            return (Criteria) this;
        }

        public Criteria andIcChangeItemLessThanOrEqualTo(String value) {
            addCriterion("ic_change_item <=", value, "icChangeItem");
            return (Criteria) this;
        }

        public Criteria andIcChangeItemLike(String value) {
            addCriterion("ic_change_item like", value, "icChangeItem");
            return (Criteria) this;
        }

        public Criteria andIcChangeItemNotLike(String value) {
            addCriterion("ic_change_item not like", value, "icChangeItem");
            return (Criteria) this;
        }

        public Criteria andIcChangeItemIn(List<String> values) {
            addCriterion("ic_change_item in", values, "icChangeItem");
            return (Criteria) this;
        }

        public Criteria andIcChangeItemNotIn(List<String> values) {
            addCriterion("ic_change_item not in", values, "icChangeItem");
            return (Criteria) this;
        }

        public Criteria andIcChangeItemBetween(String value1, String value2) {
            addCriterion("ic_change_item between", value1, value2, "icChangeItem");
            return (Criteria) this;
        }

        public Criteria andIcChangeItemNotBetween(String value1, String value2) {
            addCriterion("ic_change_item not between", value1, value2, "icChangeItem");
            return (Criteria) this;
        }

        public Criteria andIcChangeProvinceIsNull() {
            addCriterion("ic_change_province is null");
            return (Criteria) this;
        }

        public Criteria andIcChangeProvinceIsNotNull() {
            addCriterion("ic_change_province is not null");
            return (Criteria) this;
        }

        public Criteria andIcChangeProvinceEqualTo(String value) {
            addCriterion("ic_change_province =", value, "icChangeProvince");
            return (Criteria) this;
        }

        public Criteria andIcChangeProvinceNotEqualTo(String value) {
            addCriterion("ic_change_province <>", value, "icChangeProvince");
            return (Criteria) this;
        }

        public Criteria andIcChangeProvinceGreaterThan(String value) {
            addCriterion("ic_change_province >", value, "icChangeProvince");
            return (Criteria) this;
        }

        public Criteria andIcChangeProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("ic_change_province >=", value, "icChangeProvince");
            return (Criteria) this;
        }

        public Criteria andIcChangeProvinceLessThan(String value) {
            addCriterion("ic_change_province <", value, "icChangeProvince");
            return (Criteria) this;
        }

        public Criteria andIcChangeProvinceLessThanOrEqualTo(String value) {
            addCriterion("ic_change_province <=", value, "icChangeProvince");
            return (Criteria) this;
        }

        public Criteria andIcChangeProvinceLike(String value) {
            addCriterion("ic_change_province like", value, "icChangeProvince");
            return (Criteria) this;
        }

        public Criteria andIcChangeProvinceNotLike(String value) {
            addCriterion("ic_change_province not like", value, "icChangeProvince");
            return (Criteria) this;
        }

        public Criteria andIcChangeProvinceIn(List<String> values) {
            addCriterion("ic_change_province in", values, "icChangeProvince");
            return (Criteria) this;
        }

        public Criteria andIcChangeProvinceNotIn(List<String> values) {
            addCriterion("ic_change_province not in", values, "icChangeProvince");
            return (Criteria) this;
        }

        public Criteria andIcChangeProvinceBetween(String value1, String value2) {
            addCriterion("ic_change_province between", value1, value2, "icChangeProvince");
            return (Criteria) this;
        }

        public Criteria andIcChangeProvinceNotBetween(String value1, String value2) {
            addCriterion("ic_change_province not between", value1, value2, "icChangeProvince");
            return (Criteria) this;
        }

        public Criteria andIcWorkCityIsNull() {
            addCriterion("ic_work_city is null");
            return (Criteria) this;
        }

        public Criteria andIcWorkCityIsNotNull() {
            addCriterion("ic_work_city is not null");
            return (Criteria) this;
        }

        public Criteria andIcWorkCityEqualTo(String value) {
            addCriterion("ic_work_city =", value, "icWorkCity");
            return (Criteria) this;
        }

        public Criteria andIcWorkCityNotEqualTo(String value) {
            addCriterion("ic_work_city <>", value, "icWorkCity");
            return (Criteria) this;
        }

        public Criteria andIcWorkCityGreaterThan(String value) {
            addCriterion("ic_work_city >", value, "icWorkCity");
            return (Criteria) this;
        }

        public Criteria andIcWorkCityGreaterThanOrEqualTo(String value) {
            addCriterion("ic_work_city >=", value, "icWorkCity");
            return (Criteria) this;
        }

        public Criteria andIcWorkCityLessThan(String value) {
            addCriterion("ic_work_city <", value, "icWorkCity");
            return (Criteria) this;
        }

        public Criteria andIcWorkCityLessThanOrEqualTo(String value) {
            addCriterion("ic_work_city <=", value, "icWorkCity");
            return (Criteria) this;
        }

        public Criteria andIcWorkCityLike(String value) {
            addCriterion("ic_work_city like", value, "icWorkCity");
            return (Criteria) this;
        }

        public Criteria andIcWorkCityNotLike(String value) {
            addCriterion("ic_work_city not like", value, "icWorkCity");
            return (Criteria) this;
        }

        public Criteria andIcWorkCityIn(List<String> values) {
            addCriterion("ic_work_city in", values, "icWorkCity");
            return (Criteria) this;
        }

        public Criteria andIcWorkCityNotIn(List<String> values) {
            addCriterion("ic_work_city not in", values, "icWorkCity");
            return (Criteria) this;
        }

        public Criteria andIcWorkCityBetween(String value1, String value2) {
            addCriterion("ic_work_city between", value1, value2, "icWorkCity");
            return (Criteria) this;
        }

        public Criteria andIcWorkCityNotBetween(String value1, String value2) {
            addCriterion("ic_work_city not between", value1, value2, "icWorkCity");
            return (Criteria) this;
        }

        public Criteria andIcTimebaseIsNull() {
            addCriterion("ic_timebase is null");
            return (Criteria) this;
        }

        public Criteria andIcTimebaseIsNotNull() {
            addCriterion("ic_timebase is not null");
            return (Criteria) this;
        }

        public Criteria andIcTimebaseEqualTo(String value) {
            addCriterion("ic_timebase =", value, "icTimebase");
            return (Criteria) this;
        }

        public Criteria andIcTimebaseNotEqualTo(String value) {
            addCriterion("ic_timebase <>", value, "icTimebase");
            return (Criteria) this;
        }

        public Criteria andIcTimebaseGreaterThan(String value) {
            addCriterion("ic_timebase >", value, "icTimebase");
            return (Criteria) this;
        }

        public Criteria andIcTimebaseGreaterThanOrEqualTo(String value) {
            addCriterion("ic_timebase >=", value, "icTimebase");
            return (Criteria) this;
        }

        public Criteria andIcTimebaseLessThan(String value) {
            addCriterion("ic_timebase <", value, "icTimebase");
            return (Criteria) this;
        }

        public Criteria andIcTimebaseLessThanOrEqualTo(String value) {
            addCriterion("ic_timebase <=", value, "icTimebase");
            return (Criteria) this;
        }

        public Criteria andIcTimebaseLike(String value) {
            addCriterion("ic_timebase like", value, "icTimebase");
            return (Criteria) this;
        }

        public Criteria andIcTimebaseNotLike(String value) {
            addCriterion("ic_timebase not like", value, "icTimebase");
            return (Criteria) this;
        }

        public Criteria andIcTimebaseIn(List<String> values) {
            addCriterion("ic_timebase in", values, "icTimebase");
            return (Criteria) this;
        }

        public Criteria andIcTimebaseNotIn(List<String> values) {
            addCriterion("ic_timebase not in", values, "icTimebase");
            return (Criteria) this;
        }

        public Criteria andIcTimebaseBetween(String value1, String value2) {
            addCriterion("ic_timebase between", value1, value2, "icTimebase");
            return (Criteria) this;
        }

        public Criteria andIcTimebaseNotBetween(String value1, String value2) {
            addCriterion("ic_timebase not between", value1, value2, "icTimebase");
            return (Criteria) this;
        }

        public Criteria andIcEffectDateIsNull() {
            addCriterion("ic_effect_date is null");
            return (Criteria) this;
        }

        public Criteria andIcEffectDateIsNotNull() {
            addCriterion("ic_effect_date is not null");
            return (Criteria) this;
        }

        public Criteria andIcEffectDateEqualTo(String value) {
            addCriterion("ic_effect_date =", value, "icEffectDate");
            return (Criteria) this;
        }

        public Criteria andIcEffectDateNotEqualTo(String value) {
            addCriterion("ic_effect_date <>", value, "icEffectDate");
            return (Criteria) this;
        }

        public Criteria andIcEffectDateGreaterThan(String value) {
            addCriterion("ic_effect_date >", value, "icEffectDate");
            return (Criteria) this;
        }

        public Criteria andIcEffectDateGreaterThanOrEqualTo(String value) {
            addCriterion("ic_effect_date >=", value, "icEffectDate");
            return (Criteria) this;
        }

        public Criteria andIcEffectDateLessThan(String value) {
            addCriterion("ic_effect_date <", value, "icEffectDate");
            return (Criteria) this;
        }

        public Criteria andIcEffectDateLessThanOrEqualTo(String value) {
            addCriterion("ic_effect_date <=", value, "icEffectDate");
            return (Criteria) this;
        }

        public Criteria andIcEffectDateLike(String value) {
            addCriterion("ic_effect_date like", value, "icEffectDate");
            return (Criteria) this;
        }

        public Criteria andIcEffectDateNotLike(String value) {
            addCriterion("ic_effect_date not like", value, "icEffectDate");
            return (Criteria) this;
        }

        public Criteria andIcEffectDateIn(List<String> values) {
            addCriterion("ic_effect_date in", values, "icEffectDate");
            return (Criteria) this;
        }

        public Criteria andIcEffectDateNotIn(List<String> values) {
            addCriterion("ic_effect_date not in", values, "icEffectDate");
            return (Criteria) this;
        }

        public Criteria andIcEffectDateBetween(String value1, String value2) {
            addCriterion("ic_effect_date between", value1, value2, "icEffectDate");
            return (Criteria) this;
        }

        public Criteria andIcEffectDateNotBetween(String value1, String value2) {
            addCriterion("ic_effect_date not between", value1, value2, "icEffectDate");
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