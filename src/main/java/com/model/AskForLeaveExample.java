package com.model;

import java.util.ArrayList;
import java.util.List;

public class AskForLeaveExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AskForLeaveExample() {
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

        public Criteria andSequenceNoIsNull() {
            addCriterion("sequence_no is null");
            return (Criteria) this;
        }

        public Criteria andSequenceNoIsNotNull() {
            addCriterion("sequence_no is not null");
            return (Criteria) this;
        }

        public Criteria andSequenceNoEqualTo(Integer value) {
            addCriterion("sequence_no =", value, "sequenceNo");
            return (Criteria) this;
        }

        public Criteria andSequenceNoNotEqualTo(Integer value) {
            addCriterion("sequence_no <>", value, "sequenceNo");
            return (Criteria) this;
        }

        public Criteria andSequenceNoGreaterThan(Integer value) {
            addCriterion("sequence_no >", value, "sequenceNo");
            return (Criteria) this;
        }

        public Criteria andSequenceNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("sequence_no >=", value, "sequenceNo");
            return (Criteria) this;
        }

        public Criteria andSequenceNoLessThan(Integer value) {
            addCriterion("sequence_no <", value, "sequenceNo");
            return (Criteria) this;
        }

        public Criteria andSequenceNoLessThanOrEqualTo(Integer value) {
            addCriterion("sequence_no <=", value, "sequenceNo");
            return (Criteria) this;
        }

        public Criteria andSequenceNoIn(List<Integer> values) {
            addCriterion("sequence_no in", values, "sequenceNo");
            return (Criteria) this;
        }

        public Criteria andSequenceNoNotIn(List<Integer> values) {
            addCriterion("sequence_no not in", values, "sequenceNo");
            return (Criteria) this;
        }

        public Criteria andSequenceNoBetween(Integer value1, Integer value2) {
            addCriterion("sequence_no between", value1, value2, "sequenceNo");
            return (Criteria) this;
        }

        public Criteria andSequenceNoNotBetween(Integer value1, Integer value2) {
            addCriterion("sequence_no not between", value1, value2, "sequenceNo");
            return (Criteria) this;
        }

        public Criteria andYoApproveNoIsNull() {
            addCriterion("yo_approve_no is null");
            return (Criteria) this;
        }

        public Criteria andYoApproveNoIsNotNull() {
            addCriterion("yo_approve_no is not null");
            return (Criteria) this;
        }

        public Criteria andYoApproveNoEqualTo(String value) {
            addCriterion("yo_approve_no =", value, "yoApproveNo");
            return (Criteria) this;
        }

        public Criteria andYoApproveNoNotEqualTo(String value) {
            addCriterion("yo_approve_no <>", value, "yoApproveNo");
            return (Criteria) this;
        }

        public Criteria andYoApproveNoGreaterThan(String value) {
            addCriterion("yo_approve_no >", value, "yoApproveNo");
            return (Criteria) this;
        }

        public Criteria andYoApproveNoGreaterThanOrEqualTo(String value) {
            addCriterion("yo_approve_no >=", value, "yoApproveNo");
            return (Criteria) this;
        }

        public Criteria andYoApproveNoLessThan(String value) {
            addCriterion("yo_approve_no <", value, "yoApproveNo");
            return (Criteria) this;
        }

        public Criteria andYoApproveNoLessThanOrEqualTo(String value) {
            addCriterion("yo_approve_no <=", value, "yoApproveNo");
            return (Criteria) this;
        }

        public Criteria andYoApproveNoLike(String value) {
            addCriterion("yo_approve_no like", value, "yoApproveNo");
            return (Criteria) this;
        }

        public Criteria andYoApproveNoNotLike(String value) {
            addCriterion("yo_approve_no not like", value, "yoApproveNo");
            return (Criteria) this;
        }

        public Criteria andYoApproveNoIn(List<String> values) {
            addCriterion("yo_approve_no in", values, "yoApproveNo");
            return (Criteria) this;
        }

        public Criteria andYoApproveNoNotIn(List<String> values) {
            addCriterion("yo_approve_no not in", values, "yoApproveNo");
            return (Criteria) this;
        }

        public Criteria andYoApproveNoBetween(String value1, String value2) {
            addCriterion("yo_approve_no between", value1, value2, "yoApproveNo");
            return (Criteria) this;
        }

        public Criteria andYoApproveNoNotBetween(String value1, String value2) {
            addCriterion("yo_approve_no not between", value1, value2, "yoApproveNo");
            return (Criteria) this;
        }

        public Criteria andYoTitleIsNull() {
            addCriterion("yo_title is null");
            return (Criteria) this;
        }

        public Criteria andYoTitleIsNotNull() {
            addCriterion("yo_title is not null");
            return (Criteria) this;
        }

        public Criteria andYoTitleEqualTo(String value) {
            addCriterion("yo_title =", value, "yoTitle");
            return (Criteria) this;
        }

        public Criteria andYoTitleNotEqualTo(String value) {
            addCriterion("yo_title <>", value, "yoTitle");
            return (Criteria) this;
        }

        public Criteria andYoTitleGreaterThan(String value) {
            addCriterion("yo_title >", value, "yoTitle");
            return (Criteria) this;
        }

        public Criteria andYoTitleGreaterThanOrEqualTo(String value) {
            addCriterion("yo_title >=", value, "yoTitle");
            return (Criteria) this;
        }

        public Criteria andYoTitleLessThan(String value) {
            addCriterion("yo_title <", value, "yoTitle");
            return (Criteria) this;
        }

        public Criteria andYoTitleLessThanOrEqualTo(String value) {
            addCriterion("yo_title <=", value, "yoTitle");
            return (Criteria) this;
        }

        public Criteria andYoTitleLike(String value) {
            addCriterion("yo_title like", value, "yoTitle");
            return (Criteria) this;
        }

        public Criteria andYoTitleNotLike(String value) {
            addCriterion("yo_title not like", value, "yoTitle");
            return (Criteria) this;
        }

        public Criteria andYoTitleIn(List<String> values) {
            addCriterion("yo_title in", values, "yoTitle");
            return (Criteria) this;
        }

        public Criteria andYoTitleNotIn(List<String> values) {
            addCriterion("yo_title not in", values, "yoTitle");
            return (Criteria) this;
        }

        public Criteria andYoTitleBetween(String value1, String value2) {
            addCriterion("yo_title between", value1, value2, "yoTitle");
            return (Criteria) this;
        }

        public Criteria andYoTitleNotBetween(String value1, String value2) {
            addCriterion("yo_title not between", value1, value2, "yoTitle");
            return (Criteria) this;
        }

        public Criteria andYoApproveStateIsNull() {
            addCriterion("yo_approve_state is null");
            return (Criteria) this;
        }

        public Criteria andYoApproveStateIsNotNull() {
            addCriterion("yo_approve_state is not null");
            return (Criteria) this;
        }

        public Criteria andYoApproveStateEqualTo(String value) {
            addCriterion("yo_approve_state =", value, "yoApproveState");
            return (Criteria) this;
        }

        public Criteria andYoApproveStateNotEqualTo(String value) {
            addCriterion("yo_approve_state <>", value, "yoApproveState");
            return (Criteria) this;
        }

        public Criteria andYoApproveStateGreaterThan(String value) {
            addCriterion("yo_approve_state >", value, "yoApproveState");
            return (Criteria) this;
        }

        public Criteria andYoApproveStateGreaterThanOrEqualTo(String value) {
            addCriterion("yo_approve_state >=", value, "yoApproveState");
            return (Criteria) this;
        }

        public Criteria andYoApproveStateLessThan(String value) {
            addCriterion("yo_approve_state <", value, "yoApproveState");
            return (Criteria) this;
        }

        public Criteria andYoApproveStateLessThanOrEqualTo(String value) {
            addCriterion("yo_approve_state <=", value, "yoApproveState");
            return (Criteria) this;
        }

        public Criteria andYoApproveStateLike(String value) {
            addCriterion("yo_approve_state like", value, "yoApproveState");
            return (Criteria) this;
        }

        public Criteria andYoApproveStateNotLike(String value) {
            addCriterion("yo_approve_state not like", value, "yoApproveState");
            return (Criteria) this;
        }

        public Criteria andYoApproveStateIn(List<String> values) {
            addCriterion("yo_approve_state in", values, "yoApproveState");
            return (Criteria) this;
        }

        public Criteria andYoApproveStateNotIn(List<String> values) {
            addCriterion("yo_approve_state not in", values, "yoApproveState");
            return (Criteria) this;
        }

        public Criteria andYoApproveStateBetween(String value1, String value2) {
            addCriterion("yo_approve_state between", value1, value2, "yoApproveState");
            return (Criteria) this;
        }

        public Criteria andYoApproveStateNotBetween(String value1, String value2) {
            addCriterion("yo_approve_state not between", value1, value2, "yoApproveState");
            return (Criteria) this;
        }

        public Criteria andYoApproveResultIsNull() {
            addCriterion("yo_approve_result is null");
            return (Criteria) this;
        }

        public Criteria andYoApproveResultIsNotNull() {
            addCriterion("yo_approve_result is not null");
            return (Criteria) this;
        }

        public Criteria andYoApproveResultEqualTo(String value) {
            addCriterion("yo_approve_result =", value, "yoApproveResult");
            return (Criteria) this;
        }

        public Criteria andYoApproveResultNotEqualTo(String value) {
            addCriterion("yo_approve_result <>", value, "yoApproveResult");
            return (Criteria) this;
        }

        public Criteria andYoApproveResultGreaterThan(String value) {
            addCriterion("yo_approve_result >", value, "yoApproveResult");
            return (Criteria) this;
        }

        public Criteria andYoApproveResultGreaterThanOrEqualTo(String value) {
            addCriterion("yo_approve_result >=", value, "yoApproveResult");
            return (Criteria) this;
        }

        public Criteria andYoApproveResultLessThan(String value) {
            addCriterion("yo_approve_result <", value, "yoApproveResult");
            return (Criteria) this;
        }

        public Criteria andYoApproveResultLessThanOrEqualTo(String value) {
            addCriterion("yo_approve_result <=", value, "yoApproveResult");
            return (Criteria) this;
        }

        public Criteria andYoApproveResultLike(String value) {
            addCriterion("yo_approve_result like", value, "yoApproveResult");
            return (Criteria) this;
        }

        public Criteria andYoApproveResultNotLike(String value) {
            addCriterion("yo_approve_result not like", value, "yoApproveResult");
            return (Criteria) this;
        }

        public Criteria andYoApproveResultIn(List<String> values) {
            addCriterion("yo_approve_result in", values, "yoApproveResult");
            return (Criteria) this;
        }

        public Criteria andYoApproveResultNotIn(List<String> values) {
            addCriterion("yo_approve_result not in", values, "yoApproveResult");
            return (Criteria) this;
        }

        public Criteria andYoApproveResultBetween(String value1, String value2) {
            addCriterion("yo_approve_result between", value1, value2, "yoApproveResult");
            return (Criteria) this;
        }

        public Criteria andYoApproveResultNotBetween(String value1, String value2) {
            addCriterion("yo_approve_result not between", value1, value2, "yoApproveResult");
            return (Criteria) this;
        }

        public Criteria andYoApproveBeginIsNull() {
            addCriterion("yo_approve_begin is null");
            return (Criteria) this;
        }

        public Criteria andYoApproveBeginIsNotNull() {
            addCriterion("yo_approve_begin is not null");
            return (Criteria) this;
        }

        public Criteria andYoApproveBeginEqualTo(String value) {
            addCriterion("yo_approve_begin =", value, "yoApproveBegin");
            return (Criteria) this;
        }

        public Criteria andYoApproveBeginNotEqualTo(String value) {
            addCriterion("yo_approve_begin <>", value, "yoApproveBegin");
            return (Criteria) this;
        }

        public Criteria andYoApproveBeginGreaterThan(String value) {
            addCriterion("yo_approve_begin >", value, "yoApproveBegin");
            return (Criteria) this;
        }

        public Criteria andYoApproveBeginGreaterThanOrEqualTo(String value) {
            addCriterion("yo_approve_begin >=", value, "yoApproveBegin");
            return (Criteria) this;
        }

        public Criteria andYoApproveBeginLessThan(String value) {
            addCriterion("yo_approve_begin <", value, "yoApproveBegin");
            return (Criteria) this;
        }

        public Criteria andYoApproveBeginLessThanOrEqualTo(String value) {
            addCriterion("yo_approve_begin <=", value, "yoApproveBegin");
            return (Criteria) this;
        }

        public Criteria andYoApproveBeginLike(String value) {
            addCriterion("yo_approve_begin like", value, "yoApproveBegin");
            return (Criteria) this;
        }

        public Criteria andYoApproveBeginNotLike(String value) {
            addCriterion("yo_approve_begin not like", value, "yoApproveBegin");
            return (Criteria) this;
        }

        public Criteria andYoApproveBeginIn(List<String> values) {
            addCriterion("yo_approve_begin in", values, "yoApproveBegin");
            return (Criteria) this;
        }

        public Criteria andYoApproveBeginNotIn(List<String> values) {
            addCriterion("yo_approve_begin not in", values, "yoApproveBegin");
            return (Criteria) this;
        }

        public Criteria andYoApproveBeginBetween(String value1, String value2) {
            addCriterion("yo_approve_begin between", value1, value2, "yoApproveBegin");
            return (Criteria) this;
        }

        public Criteria andYoApproveBeginNotBetween(String value1, String value2) {
            addCriterion("yo_approve_begin not between", value1, value2, "yoApproveBegin");
            return (Criteria) this;
        }

        public Criteria andYoApproveEndIsNull() {
            addCriterion("yo_approve_end is null");
            return (Criteria) this;
        }

        public Criteria andYoApproveEndIsNotNull() {
            addCriterion("yo_approve_end is not null");
            return (Criteria) this;
        }

        public Criteria andYoApproveEndEqualTo(String value) {
            addCriterion("yo_approve_end =", value, "yoApproveEnd");
            return (Criteria) this;
        }

        public Criteria andYoApproveEndNotEqualTo(String value) {
            addCriterion("yo_approve_end <>", value, "yoApproveEnd");
            return (Criteria) this;
        }

        public Criteria andYoApproveEndGreaterThan(String value) {
            addCriterion("yo_approve_end >", value, "yoApproveEnd");
            return (Criteria) this;
        }

        public Criteria andYoApproveEndGreaterThanOrEqualTo(String value) {
            addCriterion("yo_approve_end >=", value, "yoApproveEnd");
            return (Criteria) this;
        }

        public Criteria andYoApproveEndLessThan(String value) {
            addCriterion("yo_approve_end <", value, "yoApproveEnd");
            return (Criteria) this;
        }

        public Criteria andYoApproveEndLessThanOrEqualTo(String value) {
            addCriterion("yo_approve_end <=", value, "yoApproveEnd");
            return (Criteria) this;
        }

        public Criteria andYoApproveEndLike(String value) {
            addCriterion("yo_approve_end like", value, "yoApproveEnd");
            return (Criteria) this;
        }

        public Criteria andYoApproveEndNotLike(String value) {
            addCriterion("yo_approve_end not like", value, "yoApproveEnd");
            return (Criteria) this;
        }

        public Criteria andYoApproveEndIn(List<String> values) {
            addCriterion("yo_approve_end in", values, "yoApproveEnd");
            return (Criteria) this;
        }

        public Criteria andYoApproveEndNotIn(List<String> values) {
            addCriterion("yo_approve_end not in", values, "yoApproveEnd");
            return (Criteria) this;
        }

        public Criteria andYoApproveEndBetween(String value1, String value2) {
            addCriterion("yo_approve_end between", value1, value2, "yoApproveEnd");
            return (Criteria) this;
        }

        public Criteria andYoApproveEndNotBetween(String value1, String value2) {
            addCriterion("yo_approve_end not between", value1, value2, "yoApproveEnd");
            return (Criteria) this;
        }

        public Criteria andYoAskStaffIdIsNull() {
            addCriterion("yo_ask_staff_id is null");
            return (Criteria) this;
        }

        public Criteria andYoAskStaffIdIsNotNull() {
            addCriterion("yo_ask_staff_id is not null");
            return (Criteria) this;
        }

        public Criteria andYoAskStaffIdEqualTo(String value) {
            addCriterion("yo_ask_staff_id =", value, "yoAskStaffId");
            return (Criteria) this;
        }

        public Criteria andYoAskStaffIdNotEqualTo(String value) {
            addCriterion("yo_ask_staff_id <>", value, "yoAskStaffId");
            return (Criteria) this;
        }

        public Criteria andYoAskStaffIdGreaterThan(String value) {
            addCriterion("yo_ask_staff_id >", value, "yoAskStaffId");
            return (Criteria) this;
        }

        public Criteria andYoAskStaffIdGreaterThanOrEqualTo(String value) {
            addCriterion("yo_ask_staff_id >=", value, "yoAskStaffId");
            return (Criteria) this;
        }

        public Criteria andYoAskStaffIdLessThan(String value) {
            addCriterion("yo_ask_staff_id <", value, "yoAskStaffId");
            return (Criteria) this;
        }

        public Criteria andYoAskStaffIdLessThanOrEqualTo(String value) {
            addCriterion("yo_ask_staff_id <=", value, "yoAskStaffId");
            return (Criteria) this;
        }

        public Criteria andYoAskStaffIdLike(String value) {
            addCriterion("yo_ask_staff_id like", value, "yoAskStaffId");
            return (Criteria) this;
        }

        public Criteria andYoAskStaffIdNotLike(String value) {
            addCriterion("yo_ask_staff_id not like", value, "yoAskStaffId");
            return (Criteria) this;
        }

        public Criteria andYoAskStaffIdIn(List<String> values) {
            addCriterion("yo_ask_staff_id in", values, "yoAskStaffId");
            return (Criteria) this;
        }

        public Criteria andYoAskStaffIdNotIn(List<String> values) {
            addCriterion("yo_ask_staff_id not in", values, "yoAskStaffId");
            return (Criteria) this;
        }

        public Criteria andYoAskStaffIdBetween(String value1, String value2) {
            addCriterion("yo_ask_staff_id between", value1, value2, "yoAskStaffId");
            return (Criteria) this;
        }

        public Criteria andYoAskStaffIdNotBetween(String value1, String value2) {
            addCriterion("yo_ask_staff_id not between", value1, value2, "yoAskStaffId");
            return (Criteria) this;
        }

        public Criteria andYoAskStaffNameIsNull() {
            addCriterion("yo_ask_staff_name is null");
            return (Criteria) this;
        }

        public Criteria andYoAskStaffNameIsNotNull() {
            addCriterion("yo_ask_staff_name is not null");
            return (Criteria) this;
        }

        public Criteria andYoAskStaffNameEqualTo(String value) {
            addCriterion("yo_ask_staff_name =", value, "yoAskStaffName");
            return (Criteria) this;
        }

        public Criteria andYoAskStaffNameNotEqualTo(String value) {
            addCriterion("yo_ask_staff_name <>", value, "yoAskStaffName");
            return (Criteria) this;
        }

        public Criteria andYoAskStaffNameGreaterThan(String value) {
            addCriterion("yo_ask_staff_name >", value, "yoAskStaffName");
            return (Criteria) this;
        }

        public Criteria andYoAskStaffNameGreaterThanOrEqualTo(String value) {
            addCriterion("yo_ask_staff_name >=", value, "yoAskStaffName");
            return (Criteria) this;
        }

        public Criteria andYoAskStaffNameLessThan(String value) {
            addCriterion("yo_ask_staff_name <", value, "yoAskStaffName");
            return (Criteria) this;
        }

        public Criteria andYoAskStaffNameLessThanOrEqualTo(String value) {
            addCriterion("yo_ask_staff_name <=", value, "yoAskStaffName");
            return (Criteria) this;
        }

        public Criteria andYoAskStaffNameLike(String value) {
            addCriterion("yo_ask_staff_name like", value, "yoAskStaffName");
            return (Criteria) this;
        }

        public Criteria andYoAskStaffNameNotLike(String value) {
            addCriterion("yo_ask_staff_name not like", value, "yoAskStaffName");
            return (Criteria) this;
        }

        public Criteria andYoAskStaffNameIn(List<String> values) {
            addCriterion("yo_ask_staff_name in", values, "yoAskStaffName");
            return (Criteria) this;
        }

        public Criteria andYoAskStaffNameNotIn(List<String> values) {
            addCriterion("yo_ask_staff_name not in", values, "yoAskStaffName");
            return (Criteria) this;
        }

        public Criteria andYoAskStaffNameBetween(String value1, String value2) {
            addCriterion("yo_ask_staff_name between", value1, value2, "yoAskStaffName");
            return (Criteria) this;
        }

        public Criteria andYoAskStaffNameNotBetween(String value1, String value2) {
            addCriterion("yo_ask_staff_name not between", value1, value2, "yoAskStaffName");
            return (Criteria) this;
        }

        public Criteria andYoAskStaffDepartIsNull() {
            addCriterion("yo_ask_staff_depart is null");
            return (Criteria) this;
        }

        public Criteria andYoAskStaffDepartIsNotNull() {
            addCriterion("yo_ask_staff_depart is not null");
            return (Criteria) this;
        }

        public Criteria andYoAskStaffDepartEqualTo(String value) {
            addCriterion("yo_ask_staff_depart =", value, "yoAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andYoAskStaffDepartNotEqualTo(String value) {
            addCriterion("yo_ask_staff_depart <>", value, "yoAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andYoAskStaffDepartGreaterThan(String value) {
            addCriterion("yo_ask_staff_depart >", value, "yoAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andYoAskStaffDepartGreaterThanOrEqualTo(String value) {
            addCriterion("yo_ask_staff_depart >=", value, "yoAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andYoAskStaffDepartLessThan(String value) {
            addCriterion("yo_ask_staff_depart <", value, "yoAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andYoAskStaffDepartLessThanOrEqualTo(String value) {
            addCriterion("yo_ask_staff_depart <=", value, "yoAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andYoAskStaffDepartLike(String value) {
            addCriterion("yo_ask_staff_depart like", value, "yoAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andYoAskStaffDepartNotLike(String value) {
            addCriterion("yo_ask_staff_depart not like", value, "yoAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andYoAskStaffDepartIn(List<String> values) {
            addCriterion("yo_ask_staff_depart in", values, "yoAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andYoAskStaffDepartNotIn(List<String> values) {
            addCriterion("yo_ask_staff_depart not in", values, "yoAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andYoAskStaffDepartBetween(String value1, String value2) {
            addCriterion("yo_ask_staff_depart between", value1, value2, "yoAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andYoAskStaffDepartNotBetween(String value1, String value2) {
            addCriterion("yo_ask_staff_depart not between", value1, value2, "yoAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andYoHistoryApproveNameIsNull() {
            addCriterion("yo_history_approve_name is null");
            return (Criteria) this;
        }

        public Criteria andYoHistoryApproveNameIsNotNull() {
            addCriterion("yo_history_approve_name is not null");
            return (Criteria) this;
        }

        public Criteria andYoHistoryApproveNameEqualTo(String value) {
            addCriterion("yo_history_approve_name =", value, "yoHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andYoHistoryApproveNameNotEqualTo(String value) {
            addCriterion("yo_history_approve_name <>", value, "yoHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andYoHistoryApproveNameGreaterThan(String value) {
            addCriterion("yo_history_approve_name >", value, "yoHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andYoHistoryApproveNameGreaterThanOrEqualTo(String value) {
            addCriterion("yo_history_approve_name >=", value, "yoHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andYoHistoryApproveNameLessThan(String value) {
            addCriterion("yo_history_approve_name <", value, "yoHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andYoHistoryApproveNameLessThanOrEqualTo(String value) {
            addCriterion("yo_history_approve_name <=", value, "yoHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andYoHistoryApproveNameLike(String value) {
            addCriterion("yo_history_approve_name like", value, "yoHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andYoHistoryApproveNameNotLike(String value) {
            addCriterion("yo_history_approve_name not like", value, "yoHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andYoHistoryApproveNameIn(List<String> values) {
            addCriterion("yo_history_approve_name in", values, "yoHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andYoHistoryApproveNameNotIn(List<String> values) {
            addCriterion("yo_history_approve_name not in", values, "yoHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andYoHistoryApproveNameBetween(String value1, String value2) {
            addCriterion("yo_history_approve_name between", value1, value2, "yoHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andYoHistoryApproveNameNotBetween(String value1, String value2) {
            addCriterion("yo_history_approve_name not between", value1, value2, "yoHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andYoApproveRecordIsNull() {
            addCriterion("yo_approve_record is null");
            return (Criteria) this;
        }

        public Criteria andYoApproveRecordIsNotNull() {
            addCriterion("yo_approve_record is not null");
            return (Criteria) this;
        }

        public Criteria andYoApproveRecordEqualTo(String value) {
            addCriterion("yo_approve_record =", value, "yoApproveRecord");
            return (Criteria) this;
        }

        public Criteria andYoApproveRecordNotEqualTo(String value) {
            addCriterion("yo_approve_record <>", value, "yoApproveRecord");
            return (Criteria) this;
        }

        public Criteria andYoApproveRecordGreaterThan(String value) {
            addCriterion("yo_approve_record >", value, "yoApproveRecord");
            return (Criteria) this;
        }

        public Criteria andYoApproveRecordGreaterThanOrEqualTo(String value) {
            addCriterion("yo_approve_record >=", value, "yoApproveRecord");
            return (Criteria) this;
        }

        public Criteria andYoApproveRecordLessThan(String value) {
            addCriterion("yo_approve_record <", value, "yoApproveRecord");
            return (Criteria) this;
        }

        public Criteria andYoApproveRecordLessThanOrEqualTo(String value) {
            addCriterion("yo_approve_record <=", value, "yoApproveRecord");
            return (Criteria) this;
        }

        public Criteria andYoApproveRecordLike(String value) {
            addCriterion("yo_approve_record like", value, "yoApproveRecord");
            return (Criteria) this;
        }

        public Criteria andYoApproveRecordNotLike(String value) {
            addCriterion("yo_approve_record not like", value, "yoApproveRecord");
            return (Criteria) this;
        }

        public Criteria andYoApproveRecordIn(List<String> values) {
            addCriterion("yo_approve_record in", values, "yoApproveRecord");
            return (Criteria) this;
        }

        public Criteria andYoApproveRecordNotIn(List<String> values) {
            addCriterion("yo_approve_record not in", values, "yoApproveRecord");
            return (Criteria) this;
        }

        public Criteria andYoApproveRecordBetween(String value1, String value2) {
            addCriterion("yo_approve_record between", value1, value2, "yoApproveRecord");
            return (Criteria) this;
        }

        public Criteria andYoApproveRecordNotBetween(String value1, String value2) {
            addCriterion("yo_approve_record not between", value1, value2, "yoApproveRecord");
            return (Criteria) this;
        }

        public Criteria andYoNowApproveNameIsNull() {
            addCriterion("yo_now_approve_name is null");
            return (Criteria) this;
        }

        public Criteria andYoNowApproveNameIsNotNull() {
            addCriterion("yo_now_approve_name is not null");
            return (Criteria) this;
        }

        public Criteria andYoNowApproveNameEqualTo(String value) {
            addCriterion("yo_now_approve_name =", value, "yoNowApproveName");
            return (Criteria) this;
        }

        public Criteria andYoNowApproveNameNotEqualTo(String value) {
            addCriterion("yo_now_approve_name <>", value, "yoNowApproveName");
            return (Criteria) this;
        }

        public Criteria andYoNowApproveNameGreaterThan(String value) {
            addCriterion("yo_now_approve_name >", value, "yoNowApproveName");
            return (Criteria) this;
        }

        public Criteria andYoNowApproveNameGreaterThanOrEqualTo(String value) {
            addCriterion("yo_now_approve_name >=", value, "yoNowApproveName");
            return (Criteria) this;
        }

        public Criteria andYoNowApproveNameLessThan(String value) {
            addCriterion("yo_now_approve_name <", value, "yoNowApproveName");
            return (Criteria) this;
        }

        public Criteria andYoNowApproveNameLessThanOrEqualTo(String value) {
            addCriterion("yo_now_approve_name <=", value, "yoNowApproveName");
            return (Criteria) this;
        }

        public Criteria andYoNowApproveNameLike(String value) {
            addCriterion("yo_now_approve_name like", value, "yoNowApproveName");
            return (Criteria) this;
        }

        public Criteria andYoNowApproveNameNotLike(String value) {
            addCriterion("yo_now_approve_name not like", value, "yoNowApproveName");
            return (Criteria) this;
        }

        public Criteria andYoNowApproveNameIn(List<String> values) {
            addCriterion("yo_now_approve_name in", values, "yoNowApproveName");
            return (Criteria) this;
        }

        public Criteria andYoNowApproveNameNotIn(List<String> values) {
            addCriterion("yo_now_approve_name not in", values, "yoNowApproveName");
            return (Criteria) this;
        }

        public Criteria andYoNowApproveNameBetween(String value1, String value2) {
            addCriterion("yo_now_approve_name between", value1, value2, "yoNowApproveName");
            return (Criteria) this;
        }

        public Criteria andYoNowApproveNameNotBetween(String value1, String value2) {
            addCriterion("yo_now_approve_name not between", value1, value2, "yoNowApproveName");
            return (Criteria) this;
        }

        public Criteria andYoCostIsNull() {
            addCriterion("yo_cost is null");
            return (Criteria) this;
        }

        public Criteria andYoCostIsNotNull() {
            addCriterion("yo_cost is not null");
            return (Criteria) this;
        }

        public Criteria andYoCostEqualTo(String value) {
            addCriterion("yo_cost =", value, "yoCost");
            return (Criteria) this;
        }

        public Criteria andYoCostNotEqualTo(String value) {
            addCriterion("yo_cost <>", value, "yoCost");
            return (Criteria) this;
        }

        public Criteria andYoCostGreaterThan(String value) {
            addCriterion("yo_cost >", value, "yoCost");
            return (Criteria) this;
        }

        public Criteria andYoCostGreaterThanOrEqualTo(String value) {
            addCriterion("yo_cost >=", value, "yoCost");
            return (Criteria) this;
        }

        public Criteria andYoCostLessThan(String value) {
            addCriterion("yo_cost <", value, "yoCost");
            return (Criteria) this;
        }

        public Criteria andYoCostLessThanOrEqualTo(String value) {
            addCriterion("yo_cost <=", value, "yoCost");
            return (Criteria) this;
        }

        public Criteria andYoCostLike(String value) {
            addCriterion("yo_cost like", value, "yoCost");
            return (Criteria) this;
        }

        public Criteria andYoCostNotLike(String value) {
            addCriterion("yo_cost not like", value, "yoCost");
            return (Criteria) this;
        }

        public Criteria andYoCostIn(List<String> values) {
            addCriterion("yo_cost in", values, "yoCost");
            return (Criteria) this;
        }

        public Criteria andYoCostNotIn(List<String> values) {
            addCriterion("yo_cost not in", values, "yoCost");
            return (Criteria) this;
        }

        public Criteria andYoCostBetween(String value1, String value2) {
            addCriterion("yo_cost between", value1, value2, "yoCost");
            return (Criteria) this;
        }

        public Criteria andYoCostNotBetween(String value1, String value2) {
            addCriterion("yo_cost not between", value1, value2, "yoCost");
            return (Criteria) this;
        }

        public Criteria andYoTypeIsNull() {
            addCriterion("yo_type is null");
            return (Criteria) this;
        }

        public Criteria andYoTypeIsNotNull() {
            addCriterion("yo_type is not null");
            return (Criteria) this;
        }

        public Criteria andYoTypeEqualTo(String value) {
            addCriterion("yo_type =", value, "yoType");
            return (Criteria) this;
        }

        public Criteria andYoTypeNotEqualTo(String value) {
            addCriterion("yo_type <>", value, "yoType");
            return (Criteria) this;
        }

        public Criteria andYoTypeGreaterThan(String value) {
            addCriterion("yo_type >", value, "yoType");
            return (Criteria) this;
        }

        public Criteria andYoTypeGreaterThanOrEqualTo(String value) {
            addCriterion("yo_type >=", value, "yoType");
            return (Criteria) this;
        }

        public Criteria andYoTypeLessThan(String value) {
            addCriterion("yo_type <", value, "yoType");
            return (Criteria) this;
        }

        public Criteria andYoTypeLessThanOrEqualTo(String value) {
            addCriterion("yo_type <=", value, "yoType");
            return (Criteria) this;
        }

        public Criteria andYoTypeLike(String value) {
            addCriterion("yo_type like", value, "yoType");
            return (Criteria) this;
        }

        public Criteria andYoTypeNotLike(String value) {
            addCriterion("yo_type not like", value, "yoType");
            return (Criteria) this;
        }

        public Criteria andYoTypeIn(List<String> values) {
            addCriterion("yo_type in", values, "yoType");
            return (Criteria) this;
        }

        public Criteria andYoTypeNotIn(List<String> values) {
            addCriterion("yo_type not in", values, "yoType");
            return (Criteria) this;
        }

        public Criteria andYoTypeBetween(String value1, String value2) {
            addCriterion("yo_type between", value1, value2, "yoType");
            return (Criteria) this;
        }

        public Criteria andYoTypeNotBetween(String value1, String value2) {
            addCriterion("yo_type not between", value1, value2, "yoType");
            return (Criteria) this;
        }

        public Criteria andYoAskBeginDateIsNull() {
            addCriterion("yo_ask_begin_date is null");
            return (Criteria) this;
        }

        public Criteria andYoAskBeginDateIsNotNull() {
            addCriterion("yo_ask_begin_date is not null");
            return (Criteria) this;
        }

        public Criteria andYoAskBeginDateEqualTo(String value) {
            addCriterion("yo_ask_begin_date =", value, "yoAskBeginDate");
            return (Criteria) this;
        }

        public Criteria andYoAskBeginDateNotEqualTo(String value) {
            addCriterion("yo_ask_begin_date <>", value, "yoAskBeginDate");
            return (Criteria) this;
        }

        public Criteria andYoAskBeginDateGreaterThan(String value) {
            addCriterion("yo_ask_begin_date >", value, "yoAskBeginDate");
            return (Criteria) this;
        }

        public Criteria andYoAskBeginDateGreaterThanOrEqualTo(String value) {
            addCriterion("yo_ask_begin_date >=", value, "yoAskBeginDate");
            return (Criteria) this;
        }

        public Criteria andYoAskBeginDateLessThan(String value) {
            addCriterion("yo_ask_begin_date <", value, "yoAskBeginDate");
            return (Criteria) this;
        }

        public Criteria andYoAskBeginDateLessThanOrEqualTo(String value) {
            addCriterion("yo_ask_begin_date <=", value, "yoAskBeginDate");
            return (Criteria) this;
        }

        public Criteria andYoAskBeginDateLike(String value) {
            addCriterion("yo_ask_begin_date like", value, "yoAskBeginDate");
            return (Criteria) this;
        }

        public Criteria andYoAskBeginDateNotLike(String value) {
            addCriterion("yo_ask_begin_date not like", value, "yoAskBeginDate");
            return (Criteria) this;
        }

        public Criteria andYoAskBeginDateIn(List<String> values) {
            addCriterion("yo_ask_begin_date in", values, "yoAskBeginDate");
            return (Criteria) this;
        }

        public Criteria andYoAskBeginDateNotIn(List<String> values) {
            addCriterion("yo_ask_begin_date not in", values, "yoAskBeginDate");
            return (Criteria) this;
        }

        public Criteria andYoAskBeginDateBetween(String value1, String value2) {
            addCriterion("yo_ask_begin_date between", value1, value2, "yoAskBeginDate");
            return (Criteria) this;
        }

        public Criteria andYoAskBeginDateNotBetween(String value1, String value2) {
            addCriterion("yo_ask_begin_date not between", value1, value2, "yoAskBeginDate");
            return (Criteria) this;
        }

        public Criteria andYoAskBeginTimeIsNull() {
            addCriterion("yo_ask_begin_time is null");
            return (Criteria) this;
        }

        public Criteria andYoAskBeginTimeIsNotNull() {
            addCriterion("yo_ask_begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andYoAskBeginTimeEqualTo(String value) {
            addCriterion("yo_ask_begin_time =", value, "yoAskBeginTime");
            return (Criteria) this;
        }

        public Criteria andYoAskBeginTimeNotEqualTo(String value) {
            addCriterion("yo_ask_begin_time <>", value, "yoAskBeginTime");
            return (Criteria) this;
        }

        public Criteria andYoAskBeginTimeGreaterThan(String value) {
            addCriterion("yo_ask_begin_time >", value, "yoAskBeginTime");
            return (Criteria) this;
        }

        public Criteria andYoAskBeginTimeGreaterThanOrEqualTo(String value) {
            addCriterion("yo_ask_begin_time >=", value, "yoAskBeginTime");
            return (Criteria) this;
        }

        public Criteria andYoAskBeginTimeLessThan(String value) {
            addCriterion("yo_ask_begin_time <", value, "yoAskBeginTime");
            return (Criteria) this;
        }

        public Criteria andYoAskBeginTimeLessThanOrEqualTo(String value) {
            addCriterion("yo_ask_begin_time <=", value, "yoAskBeginTime");
            return (Criteria) this;
        }

        public Criteria andYoAskBeginTimeLike(String value) {
            addCriterion("yo_ask_begin_time like", value, "yoAskBeginTime");
            return (Criteria) this;
        }

        public Criteria andYoAskBeginTimeNotLike(String value) {
            addCriterion("yo_ask_begin_time not like", value, "yoAskBeginTime");
            return (Criteria) this;
        }

        public Criteria andYoAskBeginTimeIn(List<String> values) {
            addCriterion("yo_ask_begin_time in", values, "yoAskBeginTime");
            return (Criteria) this;
        }

        public Criteria andYoAskBeginTimeNotIn(List<String> values) {
            addCriterion("yo_ask_begin_time not in", values, "yoAskBeginTime");
            return (Criteria) this;
        }

        public Criteria andYoAskBeginTimeBetween(String value1, String value2) {
            addCriterion("yo_ask_begin_time between", value1, value2, "yoAskBeginTime");
            return (Criteria) this;
        }

        public Criteria andYoAskBeginTimeNotBetween(String value1, String value2) {
            addCriterion("yo_ask_begin_time not between", value1, value2, "yoAskBeginTime");
            return (Criteria) this;
        }

        public Criteria andYoAskEndDateIsNull() {
            addCriterion("yo_ask_end_date is null");
            return (Criteria) this;
        }

        public Criteria andYoAskEndDateIsNotNull() {
            addCriterion("yo_ask_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andYoAskEndDateEqualTo(String value) {
            addCriterion("yo_ask_end_date =", value, "yoAskEndDate");
            return (Criteria) this;
        }

        public Criteria andYoAskEndDateNotEqualTo(String value) {
            addCriterion("yo_ask_end_date <>", value, "yoAskEndDate");
            return (Criteria) this;
        }

        public Criteria andYoAskEndDateGreaterThan(String value) {
            addCriterion("yo_ask_end_date >", value, "yoAskEndDate");
            return (Criteria) this;
        }

        public Criteria andYoAskEndDateGreaterThanOrEqualTo(String value) {
            addCriterion("yo_ask_end_date >=", value, "yoAskEndDate");
            return (Criteria) this;
        }

        public Criteria andYoAskEndDateLessThan(String value) {
            addCriterion("yo_ask_end_date <", value, "yoAskEndDate");
            return (Criteria) this;
        }

        public Criteria andYoAskEndDateLessThanOrEqualTo(String value) {
            addCriterion("yo_ask_end_date <=", value, "yoAskEndDate");
            return (Criteria) this;
        }

        public Criteria andYoAskEndDateLike(String value) {
            addCriterion("yo_ask_end_date like", value, "yoAskEndDate");
            return (Criteria) this;
        }

        public Criteria andYoAskEndDateNotLike(String value) {
            addCriterion("yo_ask_end_date not like", value, "yoAskEndDate");
            return (Criteria) this;
        }

        public Criteria andYoAskEndDateIn(List<String> values) {
            addCriterion("yo_ask_end_date in", values, "yoAskEndDate");
            return (Criteria) this;
        }

        public Criteria andYoAskEndDateNotIn(List<String> values) {
            addCriterion("yo_ask_end_date not in", values, "yoAskEndDate");
            return (Criteria) this;
        }

        public Criteria andYoAskEndDateBetween(String value1, String value2) {
            addCriterion("yo_ask_end_date between", value1, value2, "yoAskEndDate");
            return (Criteria) this;
        }

        public Criteria andYoAskEndDateNotBetween(String value1, String value2) {
            addCriterion("yo_ask_end_date not between", value1, value2, "yoAskEndDate");
            return (Criteria) this;
        }

        public Criteria andYoAskEndTimeIsNull() {
            addCriterion("yo_ask_end_time is null");
            return (Criteria) this;
        }

        public Criteria andYoAskEndTimeIsNotNull() {
            addCriterion("yo_ask_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andYoAskEndTimeEqualTo(String value) {
            addCriterion("yo_ask_end_time =", value, "yoAskEndTime");
            return (Criteria) this;
        }

        public Criteria andYoAskEndTimeNotEqualTo(String value) {
            addCriterion("yo_ask_end_time <>", value, "yoAskEndTime");
            return (Criteria) this;
        }

        public Criteria andYoAskEndTimeGreaterThan(String value) {
            addCriterion("yo_ask_end_time >", value, "yoAskEndTime");
            return (Criteria) this;
        }

        public Criteria andYoAskEndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("yo_ask_end_time >=", value, "yoAskEndTime");
            return (Criteria) this;
        }

        public Criteria andYoAskEndTimeLessThan(String value) {
            addCriterion("yo_ask_end_time <", value, "yoAskEndTime");
            return (Criteria) this;
        }

        public Criteria andYoAskEndTimeLessThanOrEqualTo(String value) {
            addCriterion("yo_ask_end_time <=", value, "yoAskEndTime");
            return (Criteria) this;
        }

        public Criteria andYoAskEndTimeLike(String value) {
            addCriterion("yo_ask_end_time like", value, "yoAskEndTime");
            return (Criteria) this;
        }

        public Criteria andYoAskEndTimeNotLike(String value) {
            addCriterion("yo_ask_end_time not like", value, "yoAskEndTime");
            return (Criteria) this;
        }

        public Criteria andYoAskEndTimeIn(List<String> values) {
            addCriterion("yo_ask_end_time in", values, "yoAskEndTime");
            return (Criteria) this;
        }

        public Criteria andYoAskEndTimeNotIn(List<String> values) {
            addCriterion("yo_ask_end_time not in", values, "yoAskEndTime");
            return (Criteria) this;
        }

        public Criteria andYoAskEndTimeBetween(String value1, String value2) {
            addCriterion("yo_ask_end_time between", value1, value2, "yoAskEndTime");
            return (Criteria) this;
        }

        public Criteria andYoAskEndTimeNotBetween(String value1, String value2) {
            addCriterion("yo_ask_end_time not between", value1, value2, "yoAskEndTime");
            return (Criteria) this;
        }

        public Criteria andYoAskSustainIsNull() {
            addCriterion("yo_ask_sustain is null");
            return (Criteria) this;
        }

        public Criteria andYoAskSustainIsNotNull() {
            addCriterion("yo_ask_sustain is not null");
            return (Criteria) this;
        }

        public Criteria andYoAskSustainEqualTo(String value) {
            addCriterion("yo_ask_sustain =", value, "yoAskSustain");
            return (Criteria) this;
        }

        public Criteria andYoAskSustainNotEqualTo(String value) {
            addCriterion("yo_ask_sustain <>", value, "yoAskSustain");
            return (Criteria) this;
        }

        public Criteria andYoAskSustainGreaterThan(String value) {
            addCriterion("yo_ask_sustain >", value, "yoAskSustain");
            return (Criteria) this;
        }

        public Criteria andYoAskSustainGreaterThanOrEqualTo(String value) {
            addCriterion("yo_ask_sustain >=", value, "yoAskSustain");
            return (Criteria) this;
        }

        public Criteria andYoAskSustainLessThan(String value) {
            addCriterion("yo_ask_sustain <", value, "yoAskSustain");
            return (Criteria) this;
        }

        public Criteria andYoAskSustainLessThanOrEqualTo(String value) {
            addCriterion("yo_ask_sustain <=", value, "yoAskSustain");
            return (Criteria) this;
        }

        public Criteria andYoAskSustainLike(String value) {
            addCriterion("yo_ask_sustain like", value, "yoAskSustain");
            return (Criteria) this;
        }

        public Criteria andYoAskSustainNotLike(String value) {
            addCriterion("yo_ask_sustain not like", value, "yoAskSustain");
            return (Criteria) this;
        }

        public Criteria andYoAskSustainIn(List<String> values) {
            addCriterion("yo_ask_sustain in", values, "yoAskSustain");
            return (Criteria) this;
        }

        public Criteria andYoAskSustainNotIn(List<String> values) {
            addCriterion("yo_ask_sustain not in", values, "yoAskSustain");
            return (Criteria) this;
        }

        public Criteria andYoAskSustainBetween(String value1, String value2) {
            addCriterion("yo_ask_sustain between", value1, value2, "yoAskSustain");
            return (Criteria) this;
        }

        public Criteria andYoAskSustainNotBetween(String value1, String value2) {
            addCriterion("yo_ask_sustain not between", value1, value2, "yoAskSustain");
            return (Criteria) this;
        }

        public Criteria andYoAskReasonIsNull() {
            addCriterion("yo_ask_reason is null");
            return (Criteria) this;
        }

        public Criteria andYoAskReasonIsNotNull() {
            addCriterion("yo_ask_reason is not null");
            return (Criteria) this;
        }

        public Criteria andYoAskReasonEqualTo(String value) {
            addCriterion("yo_ask_reason =", value, "yoAskReason");
            return (Criteria) this;
        }

        public Criteria andYoAskReasonNotEqualTo(String value) {
            addCriterion("yo_ask_reason <>", value, "yoAskReason");
            return (Criteria) this;
        }

        public Criteria andYoAskReasonGreaterThan(String value) {
            addCriterion("yo_ask_reason >", value, "yoAskReason");
            return (Criteria) this;
        }

        public Criteria andYoAskReasonGreaterThanOrEqualTo(String value) {
            addCriterion("yo_ask_reason >=", value, "yoAskReason");
            return (Criteria) this;
        }

        public Criteria andYoAskReasonLessThan(String value) {
            addCriterion("yo_ask_reason <", value, "yoAskReason");
            return (Criteria) this;
        }

        public Criteria andYoAskReasonLessThanOrEqualTo(String value) {
            addCriterion("yo_ask_reason <=", value, "yoAskReason");
            return (Criteria) this;
        }

        public Criteria andYoAskReasonLike(String value) {
            addCriterion("yo_ask_reason like", value, "yoAskReason");
            return (Criteria) this;
        }

        public Criteria andYoAskReasonNotLike(String value) {
            addCriterion("yo_ask_reason not like", value, "yoAskReason");
            return (Criteria) this;
        }

        public Criteria andYoAskReasonIn(List<String> values) {
            addCriterion("yo_ask_reason in", values, "yoAskReason");
            return (Criteria) this;
        }

        public Criteria andYoAskReasonNotIn(List<String> values) {
            addCriterion("yo_ask_reason not in", values, "yoAskReason");
            return (Criteria) this;
        }

        public Criteria andYoAskReasonBetween(String value1, String value2) {
            addCriterion("yo_ask_reason between", value1, value2, "yoAskReason");
            return (Criteria) this;
        }

        public Criteria andYoAskReasonNotBetween(String value1, String value2) {
            addCriterion("yo_ask_reason not between", value1, value2, "yoAskReason");
            return (Criteria) this;
        }

        public Criteria andYoPictureIsNull() {
            addCriterion("yo_picture is null");
            return (Criteria) this;
        }

        public Criteria andYoPictureIsNotNull() {
            addCriterion("yo_picture is not null");
            return (Criteria) this;
        }

        public Criteria andYoPictureEqualTo(String value) {
            addCriterion("yo_picture =", value, "yoPicture");
            return (Criteria) this;
        }

        public Criteria andYoPictureNotEqualTo(String value) {
            addCriterion("yo_picture <>", value, "yoPicture");
            return (Criteria) this;
        }

        public Criteria andYoPictureGreaterThan(String value) {
            addCriterion("yo_picture >", value, "yoPicture");
            return (Criteria) this;
        }

        public Criteria andYoPictureGreaterThanOrEqualTo(String value) {
            addCriterion("yo_picture >=", value, "yoPicture");
            return (Criteria) this;
        }

        public Criteria andYoPictureLessThan(String value) {
            addCriterion("yo_picture <", value, "yoPicture");
            return (Criteria) this;
        }

        public Criteria andYoPictureLessThanOrEqualTo(String value) {
            addCriterion("yo_picture <=", value, "yoPicture");
            return (Criteria) this;
        }

        public Criteria andYoPictureLike(String value) {
            addCriterion("yo_picture like", value, "yoPicture");
            return (Criteria) this;
        }

        public Criteria andYoPictureNotLike(String value) {
            addCriterion("yo_picture not like", value, "yoPicture");
            return (Criteria) this;
        }

        public Criteria andYoPictureIn(List<String> values) {
            addCriterion("yo_picture in", values, "yoPicture");
            return (Criteria) this;
        }

        public Criteria andYoPictureNotIn(List<String> values) {
            addCriterion("yo_picture not in", values, "yoPicture");
            return (Criteria) this;
        }

        public Criteria andYoPictureBetween(String value1, String value2) {
            addCriterion("yo_picture between", value1, value2, "yoPicture");
            return (Criteria) this;
        }

        public Criteria andYoPictureNotBetween(String value1, String value2) {
            addCriterion("yo_picture not between", value1, value2, "yoPicture");
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