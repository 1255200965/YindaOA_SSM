package com.model;

import java.util.ArrayList;
import java.util.List;

public class YoYindaIdentifyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public YoYindaIdentifyExample() {
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

        public Criteria andYiSequenceNoIsNull() {
            addCriterion("yi_sequence_no is null");
            return (Criteria) this;
        }

        public Criteria andYiSequenceNoIsNotNull() {
            addCriterion("yi_sequence_no is not null");
            return (Criteria) this;
        }

        public Criteria andYiSequenceNoEqualTo(Integer value) {
            addCriterion("yi_sequence_no =", value, "yiSequenceNo");
            return (Criteria) this;
        }

        public Criteria andYiSequenceNoNotEqualTo(Integer value) {
            addCriterion("yi_sequence_no <>", value, "yiSequenceNo");
            return (Criteria) this;
        }

        public Criteria andYiSequenceNoGreaterThan(Integer value) {
            addCriterion("yi_sequence_no >", value, "yiSequenceNo");
            return (Criteria) this;
        }

        public Criteria andYiSequenceNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("yi_sequence_no >=", value, "yiSequenceNo");
            return (Criteria) this;
        }

        public Criteria andYiSequenceNoLessThan(Integer value) {
            addCriterion("yi_sequence_no <", value, "yiSequenceNo");
            return (Criteria) this;
        }

        public Criteria andYiSequenceNoLessThanOrEqualTo(Integer value) {
            addCriterion("yi_sequence_no <=", value, "yiSequenceNo");
            return (Criteria) this;
        }

        public Criteria andYiSequenceNoIn(List<Integer> values) {
            addCriterion("yi_sequence_no in", values, "yiSequenceNo");
            return (Criteria) this;
        }

        public Criteria andYiSequenceNoNotIn(List<Integer> values) {
            addCriterion("yi_sequence_no not in", values, "yiSequenceNo");
            return (Criteria) this;
        }

        public Criteria andYiSequenceNoBetween(Integer value1, Integer value2) {
            addCriterion("yi_sequence_no between", value1, value2, "yiSequenceNo");
            return (Criteria) this;
        }

        public Criteria andYiSequenceNoNotBetween(Integer value1, Integer value2) {
            addCriterion("yi_sequence_no not between", value1, value2, "yiSequenceNo");
            return (Criteria) this;
        }

        public Criteria andYiApproveNoIsNull() {
            addCriterion("yi_approve_no is null");
            return (Criteria) this;
        }

        public Criteria andYiApproveNoIsNotNull() {
            addCriterion("yi_approve_no is not null");
            return (Criteria) this;
        }

        public Criteria andYiApproveNoEqualTo(String value) {
            addCriterion("yi_approve_no =", value, "yiApproveNo");
            return (Criteria) this;
        }

        public Criteria andYiApproveNoNotEqualTo(String value) {
            addCriterion("yi_approve_no <>", value, "yiApproveNo");
            return (Criteria) this;
        }

        public Criteria andYiApproveNoGreaterThan(String value) {
            addCriterion("yi_approve_no >", value, "yiApproveNo");
            return (Criteria) this;
        }

        public Criteria andYiApproveNoGreaterThanOrEqualTo(String value) {
            addCriterion("yi_approve_no >=", value, "yiApproveNo");
            return (Criteria) this;
        }

        public Criteria andYiApproveNoLessThan(String value) {
            addCriterion("yi_approve_no <", value, "yiApproveNo");
            return (Criteria) this;
        }

        public Criteria andYiApproveNoLessThanOrEqualTo(String value) {
            addCriterion("yi_approve_no <=", value, "yiApproveNo");
            return (Criteria) this;
        }

        public Criteria andYiApproveNoLike(String value) {
            addCriterion("yi_approve_no like", value, "yiApproveNo");
            return (Criteria) this;
        }

        public Criteria andYiApproveNoNotLike(String value) {
            addCriterion("yi_approve_no not like", value, "yiApproveNo");
            return (Criteria) this;
        }

        public Criteria andYiApproveNoIn(List<String> values) {
            addCriterion("yi_approve_no in", values, "yiApproveNo");
            return (Criteria) this;
        }

        public Criteria andYiApproveNoNotIn(List<String> values) {
            addCriterion("yi_approve_no not in", values, "yiApproveNo");
            return (Criteria) this;
        }

        public Criteria andYiApproveNoBetween(String value1, String value2) {
            addCriterion("yi_approve_no between", value1, value2, "yiApproveNo");
            return (Criteria) this;
        }

        public Criteria andYiApproveNoNotBetween(String value1, String value2) {
            addCriterion("yi_approve_no not between", value1, value2, "yiApproveNo");
            return (Criteria) this;
        }

        public Criteria andYiTitleIsNull() {
            addCriterion("yi_title is null");
            return (Criteria) this;
        }

        public Criteria andYiTitleIsNotNull() {
            addCriterion("yi_title is not null");
            return (Criteria) this;
        }

        public Criteria andYiTitleEqualTo(String value) {
            addCriterion("yi_title =", value, "yiTitle");
            return (Criteria) this;
        }

        public Criteria andYiTitleNotEqualTo(String value) {
            addCriterion("yi_title <>", value, "yiTitle");
            return (Criteria) this;
        }

        public Criteria andYiTitleGreaterThan(String value) {
            addCriterion("yi_title >", value, "yiTitle");
            return (Criteria) this;
        }

        public Criteria andYiTitleGreaterThanOrEqualTo(String value) {
            addCriterion("yi_title >=", value, "yiTitle");
            return (Criteria) this;
        }

        public Criteria andYiTitleLessThan(String value) {
            addCriterion("yi_title <", value, "yiTitle");
            return (Criteria) this;
        }

        public Criteria andYiTitleLessThanOrEqualTo(String value) {
            addCriterion("yi_title <=", value, "yiTitle");
            return (Criteria) this;
        }

        public Criteria andYiTitleLike(String value) {
            addCriterion("yi_title like", value, "yiTitle");
            return (Criteria) this;
        }

        public Criteria andYiTitleNotLike(String value) {
            addCriterion("yi_title not like", value, "yiTitle");
            return (Criteria) this;
        }

        public Criteria andYiTitleIn(List<String> values) {
            addCriterion("yi_title in", values, "yiTitle");
            return (Criteria) this;
        }

        public Criteria andYiTitleNotIn(List<String> values) {
            addCriterion("yi_title not in", values, "yiTitle");
            return (Criteria) this;
        }

        public Criteria andYiTitleBetween(String value1, String value2) {
            addCriterion("yi_title between", value1, value2, "yiTitle");
            return (Criteria) this;
        }

        public Criteria andYiTitleNotBetween(String value1, String value2) {
            addCriterion("yi_title not between", value1, value2, "yiTitle");
            return (Criteria) this;
        }

        public Criteria andYiApproveStateIsNull() {
            addCriterion("yi_approve_state is null");
            return (Criteria) this;
        }

        public Criteria andYiApproveStateIsNotNull() {
            addCriterion("yi_approve_state is not null");
            return (Criteria) this;
        }

        public Criteria andYiApproveStateEqualTo(String value) {
            addCriterion("yi_approve_state =", value, "yiApproveState");
            return (Criteria) this;
        }

        public Criteria andYiApproveStateNotEqualTo(String value) {
            addCriterion("yi_approve_state <>", value, "yiApproveState");
            return (Criteria) this;
        }

        public Criteria andYiApproveStateGreaterThan(String value) {
            addCriterion("yi_approve_state >", value, "yiApproveState");
            return (Criteria) this;
        }

        public Criteria andYiApproveStateGreaterThanOrEqualTo(String value) {
            addCriterion("yi_approve_state >=", value, "yiApproveState");
            return (Criteria) this;
        }

        public Criteria andYiApproveStateLessThan(String value) {
            addCriterion("yi_approve_state <", value, "yiApproveState");
            return (Criteria) this;
        }

        public Criteria andYiApproveStateLessThanOrEqualTo(String value) {
            addCriterion("yi_approve_state <=", value, "yiApproveState");
            return (Criteria) this;
        }

        public Criteria andYiApproveStateLike(String value) {
            addCriterion("yi_approve_state like", value, "yiApproveState");
            return (Criteria) this;
        }

        public Criteria andYiApproveStateNotLike(String value) {
            addCriterion("yi_approve_state not like", value, "yiApproveState");
            return (Criteria) this;
        }

        public Criteria andYiApproveStateIn(List<String> values) {
            addCriterion("yi_approve_state in", values, "yiApproveState");
            return (Criteria) this;
        }

        public Criteria andYiApproveStateNotIn(List<String> values) {
            addCriterion("yi_approve_state not in", values, "yiApproveState");
            return (Criteria) this;
        }

        public Criteria andYiApproveStateBetween(String value1, String value2) {
            addCriterion("yi_approve_state between", value1, value2, "yiApproveState");
            return (Criteria) this;
        }

        public Criteria andYiApproveStateNotBetween(String value1, String value2) {
            addCriterion("yi_approve_state not between", value1, value2, "yiApproveState");
            return (Criteria) this;
        }

        public Criteria andYiApproveResultIsNull() {
            addCriterion("yi_approve_result is null");
            return (Criteria) this;
        }

        public Criteria andYiApproveResultIsNotNull() {
            addCriterion("yi_approve_result is not null");
            return (Criteria) this;
        }

        public Criteria andYiApproveResultEqualTo(String value) {
            addCriterion("yi_approve_result =", value, "yiApproveResult");
            return (Criteria) this;
        }

        public Criteria andYiApproveResultNotEqualTo(String value) {
            addCriterion("yi_approve_result <>", value, "yiApproveResult");
            return (Criteria) this;
        }

        public Criteria andYiApproveResultGreaterThan(String value) {
            addCriterion("yi_approve_result >", value, "yiApproveResult");
            return (Criteria) this;
        }

        public Criteria andYiApproveResultGreaterThanOrEqualTo(String value) {
            addCriterion("yi_approve_result >=", value, "yiApproveResult");
            return (Criteria) this;
        }

        public Criteria andYiApproveResultLessThan(String value) {
            addCriterion("yi_approve_result <", value, "yiApproveResult");
            return (Criteria) this;
        }

        public Criteria andYiApproveResultLessThanOrEqualTo(String value) {
            addCriterion("yi_approve_result <=", value, "yiApproveResult");
            return (Criteria) this;
        }

        public Criteria andYiApproveResultLike(String value) {
            addCriterion("yi_approve_result like", value, "yiApproveResult");
            return (Criteria) this;
        }

        public Criteria andYiApproveResultNotLike(String value) {
            addCriterion("yi_approve_result not like", value, "yiApproveResult");
            return (Criteria) this;
        }

        public Criteria andYiApproveResultIn(List<String> values) {
            addCriterion("yi_approve_result in", values, "yiApproveResult");
            return (Criteria) this;
        }

        public Criteria andYiApproveResultNotIn(List<String> values) {
            addCriterion("yi_approve_result not in", values, "yiApproveResult");
            return (Criteria) this;
        }

        public Criteria andYiApproveResultBetween(String value1, String value2) {
            addCriterion("yi_approve_result between", value1, value2, "yiApproveResult");
            return (Criteria) this;
        }

        public Criteria andYiApproveResultNotBetween(String value1, String value2) {
            addCriterion("yi_approve_result not between", value1, value2, "yiApproveResult");
            return (Criteria) this;
        }

        public Criteria andYiApproveBeginIsNull() {
            addCriterion("yi_approve_begin is null");
            return (Criteria) this;
        }

        public Criteria andYiApproveBeginIsNotNull() {
            addCriterion("yi_approve_begin is not null");
            return (Criteria) this;
        }

        public Criteria andYiApproveBeginEqualTo(String value) {
            addCriterion("yi_approve_begin =", value, "yiApproveBegin");
            return (Criteria) this;
        }

        public Criteria andYiApproveBeginNotEqualTo(String value) {
            addCriterion("yi_approve_begin <>", value, "yiApproveBegin");
            return (Criteria) this;
        }

        public Criteria andYiApproveBeginGreaterThan(String value) {
            addCriterion("yi_approve_begin >", value, "yiApproveBegin");
            return (Criteria) this;
        }

        public Criteria andYiApproveBeginGreaterThanOrEqualTo(String value) {
            addCriterion("yi_approve_begin >=", value, "yiApproveBegin");
            return (Criteria) this;
        }

        public Criteria andYiApproveBeginLessThan(String value) {
            addCriterion("yi_approve_begin <", value, "yiApproveBegin");
            return (Criteria) this;
        }

        public Criteria andYiApproveBeginLessThanOrEqualTo(String value) {
            addCriterion("yi_approve_begin <=", value, "yiApproveBegin");
            return (Criteria) this;
        }

        public Criteria andYiApproveBeginLike(String value) {
            addCriterion("yi_approve_begin like", value, "yiApproveBegin");
            return (Criteria) this;
        }

        public Criteria andYiApproveBeginNotLike(String value) {
            addCriterion("yi_approve_begin not like", value, "yiApproveBegin");
            return (Criteria) this;
        }

        public Criteria andYiApproveBeginIn(List<String> values) {
            addCriterion("yi_approve_begin in", values, "yiApproveBegin");
            return (Criteria) this;
        }

        public Criteria andYiApproveBeginNotIn(List<String> values) {
            addCriterion("yi_approve_begin not in", values, "yiApproveBegin");
            return (Criteria) this;
        }

        public Criteria andYiApproveBeginBetween(String value1, String value2) {
            addCriterion("yi_approve_begin between", value1, value2, "yiApproveBegin");
            return (Criteria) this;
        }

        public Criteria andYiApproveBeginNotBetween(String value1, String value2) {
            addCriterion("yi_approve_begin not between", value1, value2, "yiApproveBegin");
            return (Criteria) this;
        }

        public Criteria andYiApproveEndIsNull() {
            addCriterion("yi_approve_end is null");
            return (Criteria) this;
        }

        public Criteria andYiApproveEndIsNotNull() {
            addCriterion("yi_approve_end is not null");
            return (Criteria) this;
        }

        public Criteria andYiApproveEndEqualTo(String value) {
            addCriterion("yi_approve_end =", value, "yiApproveEnd");
            return (Criteria) this;
        }

        public Criteria andYiApproveEndNotEqualTo(String value) {
            addCriterion("yi_approve_end <>", value, "yiApproveEnd");
            return (Criteria) this;
        }

        public Criteria andYiApproveEndGreaterThan(String value) {
            addCriterion("yi_approve_end >", value, "yiApproveEnd");
            return (Criteria) this;
        }

        public Criteria andYiApproveEndGreaterThanOrEqualTo(String value) {
            addCriterion("yi_approve_end >=", value, "yiApproveEnd");
            return (Criteria) this;
        }

        public Criteria andYiApproveEndLessThan(String value) {
            addCriterion("yi_approve_end <", value, "yiApproveEnd");
            return (Criteria) this;
        }

        public Criteria andYiApproveEndLessThanOrEqualTo(String value) {
            addCriterion("yi_approve_end <=", value, "yiApproveEnd");
            return (Criteria) this;
        }

        public Criteria andYiApproveEndLike(String value) {
            addCriterion("yi_approve_end like", value, "yiApproveEnd");
            return (Criteria) this;
        }

        public Criteria andYiApproveEndNotLike(String value) {
            addCriterion("yi_approve_end not like", value, "yiApproveEnd");
            return (Criteria) this;
        }

        public Criteria andYiApproveEndIn(List<String> values) {
            addCriterion("yi_approve_end in", values, "yiApproveEnd");
            return (Criteria) this;
        }

        public Criteria andYiApproveEndNotIn(List<String> values) {
            addCriterion("yi_approve_end not in", values, "yiApproveEnd");
            return (Criteria) this;
        }

        public Criteria andYiApproveEndBetween(String value1, String value2) {
            addCriterion("yi_approve_end between", value1, value2, "yiApproveEnd");
            return (Criteria) this;
        }

        public Criteria andYiApproveEndNotBetween(String value1, String value2) {
            addCriterion("yi_approve_end not between", value1, value2, "yiApproveEnd");
            return (Criteria) this;
        }

        public Criteria andYiAskStaffIdIsNull() {
            addCriterion("yi_ask_staff_id is null");
            return (Criteria) this;
        }

        public Criteria andYiAskStaffIdIsNotNull() {
            addCriterion("yi_ask_staff_id is not null");
            return (Criteria) this;
        }

        public Criteria andYiAskStaffIdEqualTo(String value) {
            addCriterion("yi_ask_staff_id =", value, "yiAskStaffId");
            return (Criteria) this;
        }

        public Criteria andYiAskStaffIdNotEqualTo(String value) {
            addCriterion("yi_ask_staff_id <>", value, "yiAskStaffId");
            return (Criteria) this;
        }

        public Criteria andYiAskStaffIdGreaterThan(String value) {
            addCriterion("yi_ask_staff_id >", value, "yiAskStaffId");
            return (Criteria) this;
        }

        public Criteria andYiAskStaffIdGreaterThanOrEqualTo(String value) {
            addCriterion("yi_ask_staff_id >=", value, "yiAskStaffId");
            return (Criteria) this;
        }

        public Criteria andYiAskStaffIdLessThan(String value) {
            addCriterion("yi_ask_staff_id <", value, "yiAskStaffId");
            return (Criteria) this;
        }

        public Criteria andYiAskStaffIdLessThanOrEqualTo(String value) {
            addCriterion("yi_ask_staff_id <=", value, "yiAskStaffId");
            return (Criteria) this;
        }

        public Criteria andYiAskStaffIdLike(String value) {
            addCriterion("yi_ask_staff_id like", value, "yiAskStaffId");
            return (Criteria) this;
        }

        public Criteria andYiAskStaffIdNotLike(String value) {
            addCriterion("yi_ask_staff_id not like", value, "yiAskStaffId");
            return (Criteria) this;
        }

        public Criteria andYiAskStaffIdIn(List<String> values) {
            addCriterion("yi_ask_staff_id in", values, "yiAskStaffId");
            return (Criteria) this;
        }

        public Criteria andYiAskStaffIdNotIn(List<String> values) {
            addCriterion("yi_ask_staff_id not in", values, "yiAskStaffId");
            return (Criteria) this;
        }

        public Criteria andYiAskStaffIdBetween(String value1, String value2) {
            addCriterion("yi_ask_staff_id between", value1, value2, "yiAskStaffId");
            return (Criteria) this;
        }

        public Criteria andYiAskStaffIdNotBetween(String value1, String value2) {
            addCriterion("yi_ask_staff_id not between", value1, value2, "yiAskStaffId");
            return (Criteria) this;
        }

        public Criteria andYiAskStaffNameIsNull() {
            addCriterion("yi_ask_staff_name is null");
            return (Criteria) this;
        }

        public Criteria andYiAskStaffNameIsNotNull() {
            addCriterion("yi_ask_staff_name is not null");
            return (Criteria) this;
        }

        public Criteria andYiAskStaffNameEqualTo(String value) {
            addCriterion("yi_ask_staff_name =", value, "yiAskStaffName");
            return (Criteria) this;
        }

        public Criteria andYiAskStaffNameNotEqualTo(String value) {
            addCriterion("yi_ask_staff_name <>", value, "yiAskStaffName");
            return (Criteria) this;
        }

        public Criteria andYiAskStaffNameGreaterThan(String value) {
            addCriterion("yi_ask_staff_name >", value, "yiAskStaffName");
            return (Criteria) this;
        }

        public Criteria andYiAskStaffNameGreaterThanOrEqualTo(String value) {
            addCriterion("yi_ask_staff_name >=", value, "yiAskStaffName");
            return (Criteria) this;
        }

        public Criteria andYiAskStaffNameLessThan(String value) {
            addCriterion("yi_ask_staff_name <", value, "yiAskStaffName");
            return (Criteria) this;
        }

        public Criteria andYiAskStaffNameLessThanOrEqualTo(String value) {
            addCriterion("yi_ask_staff_name <=", value, "yiAskStaffName");
            return (Criteria) this;
        }

        public Criteria andYiAskStaffNameLike(String value) {
            addCriterion("yi_ask_staff_name like", value, "yiAskStaffName");
            return (Criteria) this;
        }

        public Criteria andYiAskStaffNameNotLike(String value) {
            addCriterion("yi_ask_staff_name not like", value, "yiAskStaffName");
            return (Criteria) this;
        }

        public Criteria andYiAskStaffNameIn(List<String> values) {
            addCriterion("yi_ask_staff_name in", values, "yiAskStaffName");
            return (Criteria) this;
        }

        public Criteria andYiAskStaffNameNotIn(List<String> values) {
            addCriterion("yi_ask_staff_name not in", values, "yiAskStaffName");
            return (Criteria) this;
        }

        public Criteria andYiAskStaffNameBetween(String value1, String value2) {
            addCriterion("yi_ask_staff_name between", value1, value2, "yiAskStaffName");
            return (Criteria) this;
        }

        public Criteria andYiAskStaffNameNotBetween(String value1, String value2) {
            addCriterion("yi_ask_staff_name not between", value1, value2, "yiAskStaffName");
            return (Criteria) this;
        }

        public Criteria andYiAskStaffDepartIsNull() {
            addCriterion("yi_ask_staff_depart is null");
            return (Criteria) this;
        }

        public Criteria andYiAskStaffDepartIsNotNull() {
            addCriterion("yi_ask_staff_depart is not null");
            return (Criteria) this;
        }

        public Criteria andYiAskStaffDepartEqualTo(String value) {
            addCriterion("yi_ask_staff_depart =", value, "yiAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andYiAskStaffDepartNotEqualTo(String value) {
            addCriterion("yi_ask_staff_depart <>", value, "yiAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andYiAskStaffDepartGreaterThan(String value) {
            addCriterion("yi_ask_staff_depart >", value, "yiAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andYiAskStaffDepartGreaterThanOrEqualTo(String value) {
            addCriterion("yi_ask_staff_depart >=", value, "yiAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andYiAskStaffDepartLessThan(String value) {
            addCriterion("yi_ask_staff_depart <", value, "yiAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andYiAskStaffDepartLessThanOrEqualTo(String value) {
            addCriterion("yi_ask_staff_depart <=", value, "yiAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andYiAskStaffDepartLike(String value) {
            addCriterion("yi_ask_staff_depart like", value, "yiAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andYiAskStaffDepartNotLike(String value) {
            addCriterion("yi_ask_staff_depart not like", value, "yiAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andYiAskStaffDepartIn(List<String> values) {
            addCriterion("yi_ask_staff_depart in", values, "yiAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andYiAskStaffDepartNotIn(List<String> values) {
            addCriterion("yi_ask_staff_depart not in", values, "yiAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andYiAskStaffDepartBetween(String value1, String value2) {
            addCriterion("yi_ask_staff_depart between", value1, value2, "yiAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andYiAskStaffDepartNotBetween(String value1, String value2) {
            addCriterion("yi_ask_staff_depart not between", value1, value2, "yiAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andYiHistoryApproveNameIsNull() {
            addCriterion("yi_history_approve_name is null");
            return (Criteria) this;
        }

        public Criteria andYiHistoryApproveNameIsNotNull() {
            addCriterion("yi_history_approve_name is not null");
            return (Criteria) this;
        }

        public Criteria andYiHistoryApproveNameEqualTo(String value) {
            addCriterion("yi_history_approve_name =", value, "yiHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andYiHistoryApproveNameNotEqualTo(String value) {
            addCriterion("yi_history_approve_name <>", value, "yiHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andYiHistoryApproveNameGreaterThan(String value) {
            addCriterion("yi_history_approve_name >", value, "yiHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andYiHistoryApproveNameGreaterThanOrEqualTo(String value) {
            addCriterion("yi_history_approve_name >=", value, "yiHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andYiHistoryApproveNameLessThan(String value) {
            addCriterion("yi_history_approve_name <", value, "yiHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andYiHistoryApproveNameLessThanOrEqualTo(String value) {
            addCriterion("yi_history_approve_name <=", value, "yiHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andYiHistoryApproveNameLike(String value) {
            addCriterion("yi_history_approve_name like", value, "yiHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andYiHistoryApproveNameNotLike(String value) {
            addCriterion("yi_history_approve_name not like", value, "yiHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andYiHistoryApproveNameIn(List<String> values) {
            addCriterion("yi_history_approve_name in", values, "yiHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andYiHistoryApproveNameNotIn(List<String> values) {
            addCriterion("yi_history_approve_name not in", values, "yiHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andYiHistoryApproveNameBetween(String value1, String value2) {
            addCriterion("yi_history_approve_name between", value1, value2, "yiHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andYiHistoryApproveNameNotBetween(String value1, String value2) {
            addCriterion("yi_history_approve_name not between", value1, value2, "yiHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andYiApproveRecordIsNull() {
            addCriterion("yi_approve_record is null");
            return (Criteria) this;
        }

        public Criteria andYiApproveRecordIsNotNull() {
            addCriterion("yi_approve_record is not null");
            return (Criteria) this;
        }

        public Criteria andYiApproveRecordEqualTo(String value) {
            addCriterion("yi_approve_record =", value, "yiApproveRecord");
            return (Criteria) this;
        }

        public Criteria andYiApproveRecordNotEqualTo(String value) {
            addCriterion("yi_approve_record <>", value, "yiApproveRecord");
            return (Criteria) this;
        }

        public Criteria andYiApproveRecordGreaterThan(String value) {
            addCriterion("yi_approve_record >", value, "yiApproveRecord");
            return (Criteria) this;
        }

        public Criteria andYiApproveRecordGreaterThanOrEqualTo(String value) {
            addCriterion("yi_approve_record >=", value, "yiApproveRecord");
            return (Criteria) this;
        }

        public Criteria andYiApproveRecordLessThan(String value) {
            addCriterion("yi_approve_record <", value, "yiApproveRecord");
            return (Criteria) this;
        }

        public Criteria andYiApproveRecordLessThanOrEqualTo(String value) {
            addCriterion("yi_approve_record <=", value, "yiApproveRecord");
            return (Criteria) this;
        }

        public Criteria andYiApproveRecordLike(String value) {
            addCriterion("yi_approve_record like", value, "yiApproveRecord");
            return (Criteria) this;
        }

        public Criteria andYiApproveRecordNotLike(String value) {
            addCriterion("yi_approve_record not like", value, "yiApproveRecord");
            return (Criteria) this;
        }

        public Criteria andYiApproveRecordIn(List<String> values) {
            addCriterion("yi_approve_record in", values, "yiApproveRecord");
            return (Criteria) this;
        }

        public Criteria andYiApproveRecordNotIn(List<String> values) {
            addCriterion("yi_approve_record not in", values, "yiApproveRecord");
            return (Criteria) this;
        }

        public Criteria andYiApproveRecordBetween(String value1, String value2) {
            addCriterion("yi_approve_record between", value1, value2, "yiApproveRecord");
            return (Criteria) this;
        }

        public Criteria andYiApproveRecordNotBetween(String value1, String value2) {
            addCriterion("yi_approve_record not between", value1, value2, "yiApproveRecord");
            return (Criteria) this;
        }

        public Criteria andYiNowApproveNameIsNull() {
            addCriterion("yi_now_approve_name is null");
            return (Criteria) this;
        }

        public Criteria andYiNowApproveNameIsNotNull() {
            addCriterion("yi_now_approve_name is not null");
            return (Criteria) this;
        }

        public Criteria andYiNowApproveNameEqualTo(String value) {
            addCriterion("yi_now_approve_name =", value, "yiNowApproveName");
            return (Criteria) this;
        }

        public Criteria andYiNowApproveNameNotEqualTo(String value) {
            addCriterion("yi_now_approve_name <>", value, "yiNowApproveName");
            return (Criteria) this;
        }

        public Criteria andYiNowApproveNameGreaterThan(String value) {
            addCriterion("yi_now_approve_name >", value, "yiNowApproveName");
            return (Criteria) this;
        }

        public Criteria andYiNowApproveNameGreaterThanOrEqualTo(String value) {
            addCriterion("yi_now_approve_name >=", value, "yiNowApproveName");
            return (Criteria) this;
        }

        public Criteria andYiNowApproveNameLessThan(String value) {
            addCriterion("yi_now_approve_name <", value, "yiNowApproveName");
            return (Criteria) this;
        }

        public Criteria andYiNowApproveNameLessThanOrEqualTo(String value) {
            addCriterion("yi_now_approve_name <=", value, "yiNowApproveName");
            return (Criteria) this;
        }

        public Criteria andYiNowApproveNameLike(String value) {
            addCriterion("yi_now_approve_name like", value, "yiNowApproveName");
            return (Criteria) this;
        }

        public Criteria andYiNowApproveNameNotLike(String value) {
            addCriterion("yi_now_approve_name not like", value, "yiNowApproveName");
            return (Criteria) this;
        }

        public Criteria andYiNowApproveNameIn(List<String> values) {
            addCriterion("yi_now_approve_name in", values, "yiNowApproveName");
            return (Criteria) this;
        }

        public Criteria andYiNowApproveNameNotIn(List<String> values) {
            addCriterion("yi_now_approve_name not in", values, "yiNowApproveName");
            return (Criteria) this;
        }

        public Criteria andYiNowApproveNameBetween(String value1, String value2) {
            addCriterion("yi_now_approve_name between", value1, value2, "yiNowApproveName");
            return (Criteria) this;
        }

        public Criteria andYiNowApproveNameNotBetween(String value1, String value2) {
            addCriterion("yi_now_approve_name not between", value1, value2, "yiNowApproveName");
            return (Criteria) this;
        }

        public Criteria andYiCostIsNull() {
            addCriterion("yi_cost is null");
            return (Criteria) this;
        }

        public Criteria andYiCostIsNotNull() {
            addCriterion("yi_cost is not null");
            return (Criteria) this;
        }

        public Criteria andYiCostEqualTo(String value) {
            addCriterion("yi_cost =", value, "yiCost");
            return (Criteria) this;
        }

        public Criteria andYiCostNotEqualTo(String value) {
            addCriterion("yi_cost <>", value, "yiCost");
            return (Criteria) this;
        }

        public Criteria andYiCostGreaterThan(String value) {
            addCriterion("yi_cost >", value, "yiCost");
            return (Criteria) this;
        }

        public Criteria andYiCostGreaterThanOrEqualTo(String value) {
            addCriterion("yi_cost >=", value, "yiCost");
            return (Criteria) this;
        }

        public Criteria andYiCostLessThan(String value) {
            addCriterion("yi_cost <", value, "yiCost");
            return (Criteria) this;
        }

        public Criteria andYiCostLessThanOrEqualTo(String value) {
            addCriterion("yi_cost <=", value, "yiCost");
            return (Criteria) this;
        }

        public Criteria andYiCostLike(String value) {
            addCriterion("yi_cost like", value, "yiCost");
            return (Criteria) this;
        }

        public Criteria andYiCostNotLike(String value) {
            addCriterion("yi_cost not like", value, "yiCost");
            return (Criteria) this;
        }

        public Criteria andYiCostIn(List<String> values) {
            addCriterion("yi_cost in", values, "yiCost");
            return (Criteria) this;
        }

        public Criteria andYiCostNotIn(List<String> values) {
            addCriterion("yi_cost not in", values, "yiCost");
            return (Criteria) this;
        }

        public Criteria andYiCostBetween(String value1, String value2) {
            addCriterion("yi_cost between", value1, value2, "yiCost");
            return (Criteria) this;
        }

        public Criteria andYiCostNotBetween(String value1, String value2) {
            addCriterion("yi_cost not between", value1, value2, "yiCost");
            return (Criteria) this;
        }

        public Criteria andYiYindaLevelIsNull() {
            addCriterion("yi_yinda_level is null");
            return (Criteria) this;
        }

        public Criteria andYiYindaLevelIsNotNull() {
            addCriterion("yi_yinda_level is not null");
            return (Criteria) this;
        }

        public Criteria andYiYindaLevelEqualTo(String value) {
            addCriterion("yi_yinda_level =", value, "yiYindaLevel");
            return (Criteria) this;
        }

        public Criteria andYiYindaLevelNotEqualTo(String value) {
            addCriterion("yi_yinda_level <>", value, "yiYindaLevel");
            return (Criteria) this;
        }

        public Criteria andYiYindaLevelGreaterThan(String value) {
            addCriterion("yi_yinda_level >", value, "yiYindaLevel");
            return (Criteria) this;
        }

        public Criteria andYiYindaLevelGreaterThanOrEqualTo(String value) {
            addCriterion("yi_yinda_level >=", value, "yiYindaLevel");
            return (Criteria) this;
        }

        public Criteria andYiYindaLevelLessThan(String value) {
            addCriterion("yi_yinda_level <", value, "yiYindaLevel");
            return (Criteria) this;
        }

        public Criteria andYiYindaLevelLessThanOrEqualTo(String value) {
            addCriterion("yi_yinda_level <=", value, "yiYindaLevel");
            return (Criteria) this;
        }

        public Criteria andYiYindaLevelLike(String value) {
            addCriterion("yi_yinda_level like", value, "yiYindaLevel");
            return (Criteria) this;
        }

        public Criteria andYiYindaLevelNotLike(String value) {
            addCriterion("yi_yinda_level not like", value, "yiYindaLevel");
            return (Criteria) this;
        }

        public Criteria andYiYindaLevelIn(List<String> values) {
            addCriterion("yi_yinda_level in", values, "yiYindaLevel");
            return (Criteria) this;
        }

        public Criteria andYiYindaLevelNotIn(List<String> values) {
            addCriterion("yi_yinda_level not in", values, "yiYindaLevel");
            return (Criteria) this;
        }

        public Criteria andYiYindaLevelBetween(String value1, String value2) {
            addCriterion("yi_yinda_level between", value1, value2, "yiYindaLevel");
            return (Criteria) this;
        }

        public Criteria andYiYindaLevelNotBetween(String value1, String value2) {
            addCriterion("yi_yinda_level not between", value1, value2, "yiYindaLevel");
            return (Criteria) this;
        }

        public Criteria andYiEffectDateIsNull() {
            addCriterion("yi_effect_date is null");
            return (Criteria) this;
        }

        public Criteria andYiEffectDateIsNotNull() {
            addCriterion("yi_effect_date is not null");
            return (Criteria) this;
        }

        public Criteria andYiEffectDateEqualTo(String value) {
            addCriterion("yi_effect_date =", value, "yiEffectDate");
            return (Criteria) this;
        }

        public Criteria andYiEffectDateNotEqualTo(String value) {
            addCriterion("yi_effect_date <>", value, "yiEffectDate");
            return (Criteria) this;
        }

        public Criteria andYiEffectDateGreaterThan(String value) {
            addCriterion("yi_effect_date >", value, "yiEffectDate");
            return (Criteria) this;
        }

        public Criteria andYiEffectDateGreaterThanOrEqualTo(String value) {
            addCriterion("yi_effect_date >=", value, "yiEffectDate");
            return (Criteria) this;
        }

        public Criteria andYiEffectDateLessThan(String value) {
            addCriterion("yi_effect_date <", value, "yiEffectDate");
            return (Criteria) this;
        }

        public Criteria andYiEffectDateLessThanOrEqualTo(String value) {
            addCriterion("yi_effect_date <=", value, "yiEffectDate");
            return (Criteria) this;
        }

        public Criteria andYiEffectDateLike(String value) {
            addCriterion("yi_effect_date like", value, "yiEffectDate");
            return (Criteria) this;
        }

        public Criteria andYiEffectDateNotLike(String value) {
            addCriterion("yi_effect_date not like", value, "yiEffectDate");
            return (Criteria) this;
        }

        public Criteria andYiEffectDateIn(List<String> values) {
            addCriterion("yi_effect_date in", values, "yiEffectDate");
            return (Criteria) this;
        }

        public Criteria andYiEffectDateNotIn(List<String> values) {
            addCriterion("yi_effect_date not in", values, "yiEffectDate");
            return (Criteria) this;
        }

        public Criteria andYiEffectDateBetween(String value1, String value2) {
            addCriterion("yi_effect_date between", value1, value2, "yiEffectDate");
            return (Criteria) this;
        }

        public Criteria andYiEffectDateNotBetween(String value1, String value2) {
            addCriterion("yi_effect_date not between", value1, value2, "yiEffectDate");
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