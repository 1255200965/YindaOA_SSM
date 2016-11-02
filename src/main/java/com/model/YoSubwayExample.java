package com.model;

import java.util.ArrayList;
import java.util.List;

public class YoSubwayExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public YoSubwayExample() {
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

        public Criteria andSubSequenceNoIsNull() {
            addCriterion("sub_sequence_no is null");
            return (Criteria) this;
        }

        public Criteria andSubSequenceNoIsNotNull() {
            addCriterion("sub_sequence_no is not null");
            return (Criteria) this;
        }

        public Criteria andSubSequenceNoEqualTo(Integer value) {
            addCriterion("sub_sequence_no =", value, "subSequenceNo");
            return (Criteria) this;
        }

        public Criteria andSubSequenceNoNotEqualTo(Integer value) {
            addCriterion("sub_sequence_no <>", value, "subSequenceNo");
            return (Criteria) this;
        }

        public Criteria andSubSequenceNoGreaterThan(Integer value) {
            addCriterion("sub_sequence_no >", value, "subSequenceNo");
            return (Criteria) this;
        }

        public Criteria andSubSequenceNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("sub_sequence_no >=", value, "subSequenceNo");
            return (Criteria) this;
        }

        public Criteria andSubSequenceNoLessThan(Integer value) {
            addCriterion("sub_sequence_no <", value, "subSequenceNo");
            return (Criteria) this;
        }

        public Criteria andSubSequenceNoLessThanOrEqualTo(Integer value) {
            addCriterion("sub_sequence_no <=", value, "subSequenceNo");
            return (Criteria) this;
        }

        public Criteria andSubSequenceNoIn(List<Integer> values) {
            addCriterion("sub_sequence_no in", values, "subSequenceNo");
            return (Criteria) this;
        }

        public Criteria andSubSequenceNoNotIn(List<Integer> values) {
            addCriterion("sub_sequence_no not in", values, "subSequenceNo");
            return (Criteria) this;
        }

        public Criteria andSubSequenceNoBetween(Integer value1, Integer value2) {
            addCriterion("sub_sequence_no between", value1, value2, "subSequenceNo");
            return (Criteria) this;
        }

        public Criteria andSubSequenceNoNotBetween(Integer value1, Integer value2) {
            addCriterion("sub_sequence_no not between", value1, value2, "subSequenceNo");
            return (Criteria) this;
        }

        public Criteria andSubApproveNoIsNull() {
            addCriterion("sub_approve_no is null");
            return (Criteria) this;
        }

        public Criteria andSubApproveNoIsNotNull() {
            addCriterion("sub_approve_no is not null");
            return (Criteria) this;
        }

        public Criteria andSubApproveNoEqualTo(String value) {
            addCriterion("sub_approve_no =", value, "subApproveNo");
            return (Criteria) this;
        }

        public Criteria andSubApproveNoNotEqualTo(String value) {
            addCriterion("sub_approve_no <>", value, "subApproveNo");
            return (Criteria) this;
        }

        public Criteria andSubApproveNoGreaterThan(String value) {
            addCriterion("sub_approve_no >", value, "subApproveNo");
            return (Criteria) this;
        }

        public Criteria andSubApproveNoGreaterThanOrEqualTo(String value) {
            addCriterion("sub_approve_no >=", value, "subApproveNo");
            return (Criteria) this;
        }

        public Criteria andSubApproveNoLessThan(String value) {
            addCriterion("sub_approve_no <", value, "subApproveNo");
            return (Criteria) this;
        }

        public Criteria andSubApproveNoLessThanOrEqualTo(String value) {
            addCriterion("sub_approve_no <=", value, "subApproveNo");
            return (Criteria) this;
        }

        public Criteria andSubApproveNoLike(String value) {
            addCriterion("sub_approve_no like", value, "subApproveNo");
            return (Criteria) this;
        }

        public Criteria andSubApproveNoNotLike(String value) {
            addCriterion("sub_approve_no not like", value, "subApproveNo");
            return (Criteria) this;
        }

        public Criteria andSubApproveNoIn(List<String> values) {
            addCriterion("sub_approve_no in", values, "subApproveNo");
            return (Criteria) this;
        }

        public Criteria andSubApproveNoNotIn(List<String> values) {
            addCriterion("sub_approve_no not in", values, "subApproveNo");
            return (Criteria) this;
        }

        public Criteria andSubApproveNoBetween(String value1, String value2) {
            addCriterion("sub_approve_no between", value1, value2, "subApproveNo");
            return (Criteria) this;
        }

        public Criteria andSubApproveNoNotBetween(String value1, String value2) {
            addCriterion("sub_approve_no not between", value1, value2, "subApproveNo");
            return (Criteria) this;
        }

        public Criteria andSubTitleIsNull() {
            addCriterion("sub_title is null");
            return (Criteria) this;
        }

        public Criteria andSubTitleIsNotNull() {
            addCriterion("sub_title is not null");
            return (Criteria) this;
        }

        public Criteria andSubTitleEqualTo(String value) {
            addCriterion("sub_title =", value, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleNotEqualTo(String value) {
            addCriterion("sub_title <>", value, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleGreaterThan(String value) {
            addCriterion("sub_title >", value, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleGreaterThanOrEqualTo(String value) {
            addCriterion("sub_title >=", value, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleLessThan(String value) {
            addCriterion("sub_title <", value, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleLessThanOrEqualTo(String value) {
            addCriterion("sub_title <=", value, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleLike(String value) {
            addCriterion("sub_title like", value, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleNotLike(String value) {
            addCriterion("sub_title not like", value, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleIn(List<String> values) {
            addCriterion("sub_title in", values, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleNotIn(List<String> values) {
            addCriterion("sub_title not in", values, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleBetween(String value1, String value2) {
            addCriterion("sub_title between", value1, value2, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleNotBetween(String value1, String value2) {
            addCriterion("sub_title not between", value1, value2, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubApproveStateIsNull() {
            addCriterion("sub_approve_state is null");
            return (Criteria) this;
        }

        public Criteria andSubApproveStateIsNotNull() {
            addCriterion("sub_approve_state is not null");
            return (Criteria) this;
        }

        public Criteria andSubApproveStateEqualTo(String value) {
            addCriterion("sub_approve_state =", value, "subApproveState");
            return (Criteria) this;
        }

        public Criteria andSubApproveStateNotEqualTo(String value) {
            addCriterion("sub_approve_state <>", value, "subApproveState");
            return (Criteria) this;
        }

        public Criteria andSubApproveStateGreaterThan(String value) {
            addCriterion("sub_approve_state >", value, "subApproveState");
            return (Criteria) this;
        }

        public Criteria andSubApproveStateGreaterThanOrEqualTo(String value) {
            addCriterion("sub_approve_state >=", value, "subApproveState");
            return (Criteria) this;
        }

        public Criteria andSubApproveStateLessThan(String value) {
            addCriterion("sub_approve_state <", value, "subApproveState");
            return (Criteria) this;
        }

        public Criteria andSubApproveStateLessThanOrEqualTo(String value) {
            addCriterion("sub_approve_state <=", value, "subApproveState");
            return (Criteria) this;
        }

        public Criteria andSubApproveStateLike(String value) {
            addCriterion("sub_approve_state like", value, "subApproveState");
            return (Criteria) this;
        }

        public Criteria andSubApproveStateNotLike(String value) {
            addCriterion("sub_approve_state not like", value, "subApproveState");
            return (Criteria) this;
        }

        public Criteria andSubApproveStateIn(List<String> values) {
            addCriterion("sub_approve_state in", values, "subApproveState");
            return (Criteria) this;
        }

        public Criteria andSubApproveStateNotIn(List<String> values) {
            addCriterion("sub_approve_state not in", values, "subApproveState");
            return (Criteria) this;
        }

        public Criteria andSubApproveStateBetween(String value1, String value2) {
            addCriterion("sub_approve_state between", value1, value2, "subApproveState");
            return (Criteria) this;
        }

        public Criteria andSubApproveStateNotBetween(String value1, String value2) {
            addCriterion("sub_approve_state not between", value1, value2, "subApproveState");
            return (Criteria) this;
        }

        public Criteria andSubApproveResultIsNull() {
            addCriterion("sub_approve_result is null");
            return (Criteria) this;
        }

        public Criteria andSubApproveResultIsNotNull() {
            addCriterion("sub_approve_result is not null");
            return (Criteria) this;
        }

        public Criteria andSubApproveResultEqualTo(String value) {
            addCriterion("sub_approve_result =", value, "subApproveResult");
            return (Criteria) this;
        }

        public Criteria andSubApproveResultNotEqualTo(String value) {
            addCriterion("sub_approve_result <>", value, "subApproveResult");
            return (Criteria) this;
        }

        public Criteria andSubApproveResultGreaterThan(String value) {
            addCriterion("sub_approve_result >", value, "subApproveResult");
            return (Criteria) this;
        }

        public Criteria andSubApproveResultGreaterThanOrEqualTo(String value) {
            addCriterion("sub_approve_result >=", value, "subApproveResult");
            return (Criteria) this;
        }

        public Criteria andSubApproveResultLessThan(String value) {
            addCriterion("sub_approve_result <", value, "subApproveResult");
            return (Criteria) this;
        }

        public Criteria andSubApproveResultLessThanOrEqualTo(String value) {
            addCriterion("sub_approve_result <=", value, "subApproveResult");
            return (Criteria) this;
        }

        public Criteria andSubApproveResultLike(String value) {
            addCriterion("sub_approve_result like", value, "subApproveResult");
            return (Criteria) this;
        }

        public Criteria andSubApproveResultNotLike(String value) {
            addCriterion("sub_approve_result not like", value, "subApproveResult");
            return (Criteria) this;
        }

        public Criteria andSubApproveResultIn(List<String> values) {
            addCriterion("sub_approve_result in", values, "subApproveResult");
            return (Criteria) this;
        }

        public Criteria andSubApproveResultNotIn(List<String> values) {
            addCriterion("sub_approve_result not in", values, "subApproveResult");
            return (Criteria) this;
        }

        public Criteria andSubApproveResultBetween(String value1, String value2) {
            addCriterion("sub_approve_result between", value1, value2, "subApproveResult");
            return (Criteria) this;
        }

        public Criteria andSubApproveResultNotBetween(String value1, String value2) {
            addCriterion("sub_approve_result not between", value1, value2, "subApproveResult");
            return (Criteria) this;
        }

        public Criteria andSubApproveBeginIsNull() {
            addCriterion("sub_approve_begin is null");
            return (Criteria) this;
        }

        public Criteria andSubApproveBeginIsNotNull() {
            addCriterion("sub_approve_begin is not null");
            return (Criteria) this;
        }

        public Criteria andSubApproveBeginEqualTo(String value) {
            addCriterion("sub_approve_begin =", value, "subApproveBegin");
            return (Criteria) this;
        }

        public Criteria andSubApproveBeginNotEqualTo(String value) {
            addCriterion("sub_approve_begin <>", value, "subApproveBegin");
            return (Criteria) this;
        }

        public Criteria andSubApproveBeginGreaterThan(String value) {
            addCriterion("sub_approve_begin >", value, "subApproveBegin");
            return (Criteria) this;
        }

        public Criteria andSubApproveBeginGreaterThanOrEqualTo(String value) {
            addCriterion("sub_approve_begin >=", value, "subApproveBegin");
            return (Criteria) this;
        }

        public Criteria andSubApproveBeginLessThan(String value) {
            addCriterion("sub_approve_begin <", value, "subApproveBegin");
            return (Criteria) this;
        }

        public Criteria andSubApproveBeginLessThanOrEqualTo(String value) {
            addCriterion("sub_approve_begin <=", value, "subApproveBegin");
            return (Criteria) this;
        }

        public Criteria andSubApproveBeginLike(String value) {
            addCriterion("sub_approve_begin like", value, "subApproveBegin");
            return (Criteria) this;
        }

        public Criteria andSubApproveBeginNotLike(String value) {
            addCriterion("sub_approve_begin not like", value, "subApproveBegin");
            return (Criteria) this;
        }

        public Criteria andSubApproveBeginIn(List<String> values) {
            addCriterion("sub_approve_begin in", values, "subApproveBegin");
            return (Criteria) this;
        }

        public Criteria andSubApproveBeginNotIn(List<String> values) {
            addCriterion("sub_approve_begin not in", values, "subApproveBegin");
            return (Criteria) this;
        }

        public Criteria andSubApproveBeginBetween(String value1, String value2) {
            addCriterion("sub_approve_begin between", value1, value2, "subApproveBegin");
            return (Criteria) this;
        }

        public Criteria andSubApproveBeginNotBetween(String value1, String value2) {
            addCriterion("sub_approve_begin not between", value1, value2, "subApproveBegin");
            return (Criteria) this;
        }

        public Criteria andSubApproveEndIsNull() {
            addCriterion("sub_approve_end is null");
            return (Criteria) this;
        }

        public Criteria andSubApproveEndIsNotNull() {
            addCriterion("sub_approve_end is not null");
            return (Criteria) this;
        }

        public Criteria andSubApproveEndEqualTo(String value) {
            addCriterion("sub_approve_end =", value, "subApproveEnd");
            return (Criteria) this;
        }

        public Criteria andSubApproveEndNotEqualTo(String value) {
            addCriterion("sub_approve_end <>", value, "subApproveEnd");
            return (Criteria) this;
        }

        public Criteria andSubApproveEndGreaterThan(String value) {
            addCriterion("sub_approve_end >", value, "subApproveEnd");
            return (Criteria) this;
        }

        public Criteria andSubApproveEndGreaterThanOrEqualTo(String value) {
            addCriterion("sub_approve_end >=", value, "subApproveEnd");
            return (Criteria) this;
        }

        public Criteria andSubApproveEndLessThan(String value) {
            addCriterion("sub_approve_end <", value, "subApproveEnd");
            return (Criteria) this;
        }

        public Criteria andSubApproveEndLessThanOrEqualTo(String value) {
            addCriterion("sub_approve_end <=", value, "subApproveEnd");
            return (Criteria) this;
        }

        public Criteria andSubApproveEndLike(String value) {
            addCriterion("sub_approve_end like", value, "subApproveEnd");
            return (Criteria) this;
        }

        public Criteria andSubApproveEndNotLike(String value) {
            addCriterion("sub_approve_end not like", value, "subApproveEnd");
            return (Criteria) this;
        }

        public Criteria andSubApproveEndIn(List<String> values) {
            addCriterion("sub_approve_end in", values, "subApproveEnd");
            return (Criteria) this;
        }

        public Criteria andSubApproveEndNotIn(List<String> values) {
            addCriterion("sub_approve_end not in", values, "subApproveEnd");
            return (Criteria) this;
        }

        public Criteria andSubApproveEndBetween(String value1, String value2) {
            addCriterion("sub_approve_end between", value1, value2, "subApproveEnd");
            return (Criteria) this;
        }

        public Criteria andSubApproveEndNotBetween(String value1, String value2) {
            addCriterion("sub_approve_end not between", value1, value2, "subApproveEnd");
            return (Criteria) this;
        }

        public Criteria andSubAskStaffIdIsNull() {
            addCriterion("sub_ask_staff_id is null");
            return (Criteria) this;
        }

        public Criteria andSubAskStaffIdIsNotNull() {
            addCriterion("sub_ask_staff_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubAskStaffIdEqualTo(String value) {
            addCriterion("sub_ask_staff_id =", value, "subAskStaffId");
            return (Criteria) this;
        }

        public Criteria andSubAskStaffIdNotEqualTo(String value) {
            addCriterion("sub_ask_staff_id <>", value, "subAskStaffId");
            return (Criteria) this;
        }

        public Criteria andSubAskStaffIdGreaterThan(String value) {
            addCriterion("sub_ask_staff_id >", value, "subAskStaffId");
            return (Criteria) this;
        }

        public Criteria andSubAskStaffIdGreaterThanOrEqualTo(String value) {
            addCriterion("sub_ask_staff_id >=", value, "subAskStaffId");
            return (Criteria) this;
        }

        public Criteria andSubAskStaffIdLessThan(String value) {
            addCriterion("sub_ask_staff_id <", value, "subAskStaffId");
            return (Criteria) this;
        }

        public Criteria andSubAskStaffIdLessThanOrEqualTo(String value) {
            addCriterion("sub_ask_staff_id <=", value, "subAskStaffId");
            return (Criteria) this;
        }

        public Criteria andSubAskStaffIdLike(String value) {
            addCriterion("sub_ask_staff_id like", value, "subAskStaffId");
            return (Criteria) this;
        }

        public Criteria andSubAskStaffIdNotLike(String value) {
            addCriterion("sub_ask_staff_id not like", value, "subAskStaffId");
            return (Criteria) this;
        }

        public Criteria andSubAskStaffIdIn(List<String> values) {
            addCriterion("sub_ask_staff_id in", values, "subAskStaffId");
            return (Criteria) this;
        }

        public Criteria andSubAskStaffIdNotIn(List<String> values) {
            addCriterion("sub_ask_staff_id not in", values, "subAskStaffId");
            return (Criteria) this;
        }

        public Criteria andSubAskStaffIdBetween(String value1, String value2) {
            addCriterion("sub_ask_staff_id between", value1, value2, "subAskStaffId");
            return (Criteria) this;
        }

        public Criteria andSubAskStaffIdNotBetween(String value1, String value2) {
            addCriterion("sub_ask_staff_id not between", value1, value2, "subAskStaffId");
            return (Criteria) this;
        }

        public Criteria andSubAskStaffNameIsNull() {
            addCriterion("sub_ask_staff_name is null");
            return (Criteria) this;
        }

        public Criteria andSubAskStaffNameIsNotNull() {
            addCriterion("sub_ask_staff_name is not null");
            return (Criteria) this;
        }

        public Criteria andSubAskStaffNameEqualTo(String value) {
            addCriterion("sub_ask_staff_name =", value, "subAskStaffName");
            return (Criteria) this;
        }

        public Criteria andSubAskStaffNameNotEqualTo(String value) {
            addCriterion("sub_ask_staff_name <>", value, "subAskStaffName");
            return (Criteria) this;
        }

        public Criteria andSubAskStaffNameGreaterThan(String value) {
            addCriterion("sub_ask_staff_name >", value, "subAskStaffName");
            return (Criteria) this;
        }

        public Criteria andSubAskStaffNameGreaterThanOrEqualTo(String value) {
            addCriterion("sub_ask_staff_name >=", value, "subAskStaffName");
            return (Criteria) this;
        }

        public Criteria andSubAskStaffNameLessThan(String value) {
            addCriterion("sub_ask_staff_name <", value, "subAskStaffName");
            return (Criteria) this;
        }

        public Criteria andSubAskStaffNameLessThanOrEqualTo(String value) {
            addCriterion("sub_ask_staff_name <=", value, "subAskStaffName");
            return (Criteria) this;
        }

        public Criteria andSubAskStaffNameLike(String value) {
            addCriterion("sub_ask_staff_name like", value, "subAskStaffName");
            return (Criteria) this;
        }

        public Criteria andSubAskStaffNameNotLike(String value) {
            addCriterion("sub_ask_staff_name not like", value, "subAskStaffName");
            return (Criteria) this;
        }

        public Criteria andSubAskStaffNameIn(List<String> values) {
            addCriterion("sub_ask_staff_name in", values, "subAskStaffName");
            return (Criteria) this;
        }

        public Criteria andSubAskStaffNameNotIn(List<String> values) {
            addCriterion("sub_ask_staff_name not in", values, "subAskStaffName");
            return (Criteria) this;
        }

        public Criteria andSubAskStaffNameBetween(String value1, String value2) {
            addCriterion("sub_ask_staff_name between", value1, value2, "subAskStaffName");
            return (Criteria) this;
        }

        public Criteria andSubAskStaffNameNotBetween(String value1, String value2) {
            addCriterion("sub_ask_staff_name not between", value1, value2, "subAskStaffName");
            return (Criteria) this;
        }

        public Criteria andSubAskStaffDepartIsNull() {
            addCriterion("sub_ask_staff_depart is null");
            return (Criteria) this;
        }

        public Criteria andSubAskStaffDepartIsNotNull() {
            addCriterion("sub_ask_staff_depart is not null");
            return (Criteria) this;
        }

        public Criteria andSubAskStaffDepartEqualTo(String value) {
            addCriterion("sub_ask_staff_depart =", value, "subAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andSubAskStaffDepartNotEqualTo(String value) {
            addCriterion("sub_ask_staff_depart <>", value, "subAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andSubAskStaffDepartGreaterThan(String value) {
            addCriterion("sub_ask_staff_depart >", value, "subAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andSubAskStaffDepartGreaterThanOrEqualTo(String value) {
            addCriterion("sub_ask_staff_depart >=", value, "subAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andSubAskStaffDepartLessThan(String value) {
            addCriterion("sub_ask_staff_depart <", value, "subAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andSubAskStaffDepartLessThanOrEqualTo(String value) {
            addCriterion("sub_ask_staff_depart <=", value, "subAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andSubAskStaffDepartLike(String value) {
            addCriterion("sub_ask_staff_depart like", value, "subAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andSubAskStaffDepartNotLike(String value) {
            addCriterion("sub_ask_staff_depart not like", value, "subAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andSubAskStaffDepartIn(List<String> values) {
            addCriterion("sub_ask_staff_depart in", values, "subAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andSubAskStaffDepartNotIn(List<String> values) {
            addCriterion("sub_ask_staff_depart not in", values, "subAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andSubAskStaffDepartBetween(String value1, String value2) {
            addCriterion("sub_ask_staff_depart between", value1, value2, "subAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andSubAskStaffDepartNotBetween(String value1, String value2) {
            addCriterion("sub_ask_staff_depart not between", value1, value2, "subAskStaffDepart");
            return (Criteria) this;
        }

        public Criteria andSubHistoryApproveNameIsNull() {
            addCriterion("sub_history_approve_name is null");
            return (Criteria) this;
        }

        public Criteria andSubHistoryApproveNameIsNotNull() {
            addCriterion("sub_history_approve_name is not null");
            return (Criteria) this;
        }

        public Criteria andSubHistoryApproveNameEqualTo(String value) {
            addCriterion("sub_history_approve_name =", value, "subHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andSubHistoryApproveNameNotEqualTo(String value) {
            addCriterion("sub_history_approve_name <>", value, "subHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andSubHistoryApproveNameGreaterThan(String value) {
            addCriterion("sub_history_approve_name >", value, "subHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andSubHistoryApproveNameGreaterThanOrEqualTo(String value) {
            addCriterion("sub_history_approve_name >=", value, "subHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andSubHistoryApproveNameLessThan(String value) {
            addCriterion("sub_history_approve_name <", value, "subHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andSubHistoryApproveNameLessThanOrEqualTo(String value) {
            addCriterion("sub_history_approve_name <=", value, "subHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andSubHistoryApproveNameLike(String value) {
            addCriterion("sub_history_approve_name like", value, "subHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andSubHistoryApproveNameNotLike(String value) {
            addCriterion("sub_history_approve_name not like", value, "subHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andSubHistoryApproveNameIn(List<String> values) {
            addCriterion("sub_history_approve_name in", values, "subHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andSubHistoryApproveNameNotIn(List<String> values) {
            addCriterion("sub_history_approve_name not in", values, "subHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andSubHistoryApproveNameBetween(String value1, String value2) {
            addCriterion("sub_history_approve_name between", value1, value2, "subHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andSubHistoryApproveNameNotBetween(String value1, String value2) {
            addCriterion("sub_history_approve_name not between", value1, value2, "subHistoryApproveName");
            return (Criteria) this;
        }

        public Criteria andSubApproveRecordIsNull() {
            addCriterion("sub_approve_record is null");
            return (Criteria) this;
        }

        public Criteria andSubApproveRecordIsNotNull() {
            addCriterion("sub_approve_record is not null");
            return (Criteria) this;
        }

        public Criteria andSubApproveRecordEqualTo(String value) {
            addCriterion("sub_approve_record =", value, "subApproveRecord");
            return (Criteria) this;
        }

        public Criteria andSubApproveRecordNotEqualTo(String value) {
            addCriterion("sub_approve_record <>", value, "subApproveRecord");
            return (Criteria) this;
        }

        public Criteria andSubApproveRecordGreaterThan(String value) {
            addCriterion("sub_approve_record >", value, "subApproveRecord");
            return (Criteria) this;
        }

        public Criteria andSubApproveRecordGreaterThanOrEqualTo(String value) {
            addCriterion("sub_approve_record >=", value, "subApproveRecord");
            return (Criteria) this;
        }

        public Criteria andSubApproveRecordLessThan(String value) {
            addCriterion("sub_approve_record <", value, "subApproveRecord");
            return (Criteria) this;
        }

        public Criteria andSubApproveRecordLessThanOrEqualTo(String value) {
            addCriterion("sub_approve_record <=", value, "subApproveRecord");
            return (Criteria) this;
        }

        public Criteria andSubApproveRecordLike(String value) {
            addCriterion("sub_approve_record like", value, "subApproveRecord");
            return (Criteria) this;
        }

        public Criteria andSubApproveRecordNotLike(String value) {
            addCriterion("sub_approve_record not like", value, "subApproveRecord");
            return (Criteria) this;
        }

        public Criteria andSubApproveRecordIn(List<String> values) {
            addCriterion("sub_approve_record in", values, "subApproveRecord");
            return (Criteria) this;
        }

        public Criteria andSubApproveRecordNotIn(List<String> values) {
            addCriterion("sub_approve_record not in", values, "subApproveRecord");
            return (Criteria) this;
        }

        public Criteria andSubApproveRecordBetween(String value1, String value2) {
            addCriterion("sub_approve_record between", value1, value2, "subApproveRecord");
            return (Criteria) this;
        }

        public Criteria andSubApproveRecordNotBetween(String value1, String value2) {
            addCriterion("sub_approve_record not between", value1, value2, "subApproveRecord");
            return (Criteria) this;
        }

        public Criteria andSubNowApproveNameIsNull() {
            addCriterion("sub_now_approve_name is null");
            return (Criteria) this;
        }

        public Criteria andSubNowApproveNameIsNotNull() {
            addCriterion("sub_now_approve_name is not null");
            return (Criteria) this;
        }

        public Criteria andSubNowApproveNameEqualTo(String value) {
            addCriterion("sub_now_approve_name =", value, "subNowApproveName");
            return (Criteria) this;
        }

        public Criteria andSubNowApproveNameNotEqualTo(String value) {
            addCriterion("sub_now_approve_name <>", value, "subNowApproveName");
            return (Criteria) this;
        }

        public Criteria andSubNowApproveNameGreaterThan(String value) {
            addCriterion("sub_now_approve_name >", value, "subNowApproveName");
            return (Criteria) this;
        }

        public Criteria andSubNowApproveNameGreaterThanOrEqualTo(String value) {
            addCriterion("sub_now_approve_name >=", value, "subNowApproveName");
            return (Criteria) this;
        }

        public Criteria andSubNowApproveNameLessThan(String value) {
            addCriterion("sub_now_approve_name <", value, "subNowApproveName");
            return (Criteria) this;
        }

        public Criteria andSubNowApproveNameLessThanOrEqualTo(String value) {
            addCriterion("sub_now_approve_name <=", value, "subNowApproveName");
            return (Criteria) this;
        }

        public Criteria andSubNowApproveNameLike(String value) {
            addCriterion("sub_now_approve_name like", value, "subNowApproveName");
            return (Criteria) this;
        }

        public Criteria andSubNowApproveNameNotLike(String value) {
            addCriterion("sub_now_approve_name not like", value, "subNowApproveName");
            return (Criteria) this;
        }

        public Criteria andSubNowApproveNameIn(List<String> values) {
            addCriterion("sub_now_approve_name in", values, "subNowApproveName");
            return (Criteria) this;
        }

        public Criteria andSubNowApproveNameNotIn(List<String> values) {
            addCriterion("sub_now_approve_name not in", values, "subNowApproveName");
            return (Criteria) this;
        }

        public Criteria andSubNowApproveNameBetween(String value1, String value2) {
            addCriterion("sub_now_approve_name between", value1, value2, "subNowApproveName");
            return (Criteria) this;
        }

        public Criteria andSubNowApproveNameNotBetween(String value1, String value2) {
            addCriterion("sub_now_approve_name not between", value1, value2, "subNowApproveName");
            return (Criteria) this;
        }

        public Criteria andSubCostIsNull() {
            addCriterion("sub_cost is null");
            return (Criteria) this;
        }

        public Criteria andSubCostIsNotNull() {
            addCriterion("sub_cost is not null");
            return (Criteria) this;
        }

        public Criteria andSubCostEqualTo(String value) {
            addCriterion("sub_cost =", value, "subCost");
            return (Criteria) this;
        }

        public Criteria andSubCostNotEqualTo(String value) {
            addCriterion("sub_cost <>", value, "subCost");
            return (Criteria) this;
        }

        public Criteria andSubCostGreaterThan(String value) {
            addCriterion("sub_cost >", value, "subCost");
            return (Criteria) this;
        }

        public Criteria andSubCostGreaterThanOrEqualTo(String value) {
            addCriterion("sub_cost >=", value, "subCost");
            return (Criteria) this;
        }

        public Criteria andSubCostLessThan(String value) {
            addCriterion("sub_cost <", value, "subCost");
            return (Criteria) this;
        }

        public Criteria andSubCostLessThanOrEqualTo(String value) {
            addCriterion("sub_cost <=", value, "subCost");
            return (Criteria) this;
        }

        public Criteria andSubCostLike(String value) {
            addCriterion("sub_cost like", value, "subCost");
            return (Criteria) this;
        }

        public Criteria andSubCostNotLike(String value) {
            addCriterion("sub_cost not like", value, "subCost");
            return (Criteria) this;
        }

        public Criteria andSubCostIn(List<String> values) {
            addCriterion("sub_cost in", values, "subCost");
            return (Criteria) this;
        }

        public Criteria andSubCostNotIn(List<String> values) {
            addCriterion("sub_cost not in", values, "subCost");
            return (Criteria) this;
        }

        public Criteria andSubCostBetween(String value1, String value2) {
            addCriterion("sub_cost between", value1, value2, "subCost");
            return (Criteria) this;
        }

        public Criteria andSubCostNotBetween(String value1, String value2) {
            addCriterion("sub_cost not between", value1, value2, "subCost");
            return (Criteria) this;
        }

        public Criteria andSubTakeDateIsNull() {
            addCriterion("sub_take_date is null");
            return (Criteria) this;
        }

        public Criteria andSubTakeDateIsNotNull() {
            addCriterion("sub_take_date is not null");
            return (Criteria) this;
        }

        public Criteria andSubTakeDateEqualTo(String value) {
            addCriterion("sub_take_date =", value, "subTakeDate");
            return (Criteria) this;
        }

        public Criteria andSubTakeDateNotEqualTo(String value) {
            addCriterion("sub_take_date <>", value, "subTakeDate");
            return (Criteria) this;
        }

        public Criteria andSubTakeDateGreaterThan(String value) {
            addCriterion("sub_take_date >", value, "subTakeDate");
            return (Criteria) this;
        }

        public Criteria andSubTakeDateGreaterThanOrEqualTo(String value) {
            addCriterion("sub_take_date >=", value, "subTakeDate");
            return (Criteria) this;
        }

        public Criteria andSubTakeDateLessThan(String value) {
            addCriterion("sub_take_date <", value, "subTakeDate");
            return (Criteria) this;
        }

        public Criteria andSubTakeDateLessThanOrEqualTo(String value) {
            addCriterion("sub_take_date <=", value, "subTakeDate");
            return (Criteria) this;
        }

        public Criteria andSubTakeDateLike(String value) {
            addCriterion("sub_take_date like", value, "subTakeDate");
            return (Criteria) this;
        }

        public Criteria andSubTakeDateNotLike(String value) {
            addCriterion("sub_take_date not like", value, "subTakeDate");
            return (Criteria) this;
        }

        public Criteria andSubTakeDateIn(List<String> values) {
            addCriterion("sub_take_date in", values, "subTakeDate");
            return (Criteria) this;
        }

        public Criteria andSubTakeDateNotIn(List<String> values) {
            addCriterion("sub_take_date not in", values, "subTakeDate");
            return (Criteria) this;
        }

        public Criteria andSubTakeDateBetween(String value1, String value2) {
            addCriterion("sub_take_date between", value1, value2, "subTakeDate");
            return (Criteria) this;
        }

        public Criteria andSubTakeDateNotBetween(String value1, String value2) {
            addCriterion("sub_take_date not between", value1, value2, "subTakeDate");
            return (Criteria) this;
        }

        public Criteria andSubAmountIsNull() {
            addCriterion("sub_amount is null");
            return (Criteria) this;
        }

        public Criteria andSubAmountIsNotNull() {
            addCriterion("sub_amount is not null");
            return (Criteria) this;
        }

        public Criteria andSubAmountEqualTo(String value) {
            addCriterion("sub_amount =", value, "subAmount");
            return (Criteria) this;
        }

        public Criteria andSubAmountNotEqualTo(String value) {
            addCriterion("sub_amount <>", value, "subAmount");
            return (Criteria) this;
        }

        public Criteria andSubAmountGreaterThan(String value) {
            addCriterion("sub_amount >", value, "subAmount");
            return (Criteria) this;
        }

        public Criteria andSubAmountGreaterThanOrEqualTo(String value) {
            addCriterion("sub_amount >=", value, "subAmount");
            return (Criteria) this;
        }

        public Criteria andSubAmountLessThan(String value) {
            addCriterion("sub_amount <", value, "subAmount");
            return (Criteria) this;
        }

        public Criteria andSubAmountLessThanOrEqualTo(String value) {
            addCriterion("sub_amount <=", value, "subAmount");
            return (Criteria) this;
        }

        public Criteria andSubAmountLike(String value) {
            addCriterion("sub_amount like", value, "subAmount");
            return (Criteria) this;
        }

        public Criteria andSubAmountNotLike(String value) {
            addCriterion("sub_amount not like", value, "subAmount");
            return (Criteria) this;
        }

        public Criteria andSubAmountIn(List<String> values) {
            addCriterion("sub_amount in", values, "subAmount");
            return (Criteria) this;
        }

        public Criteria andSubAmountNotIn(List<String> values) {
            addCriterion("sub_amount not in", values, "subAmount");
            return (Criteria) this;
        }

        public Criteria andSubAmountBetween(String value1, String value2) {
            addCriterion("sub_amount between", value1, value2, "subAmount");
            return (Criteria) this;
        }

        public Criteria andSubAmountNotBetween(String value1, String value2) {
            addCriterion("sub_amount not between", value1, value2, "subAmount");
            return (Criteria) this;
        }

        public Criteria andSubAskReasonIsNull() {
            addCriterion("sub_ask_reason is null");
            return (Criteria) this;
        }

        public Criteria andSubAskReasonIsNotNull() {
            addCriterion("sub_ask_reason is not null");
            return (Criteria) this;
        }

        public Criteria andSubAskReasonEqualTo(String value) {
            addCriterion("sub_ask_reason =", value, "subAskReason");
            return (Criteria) this;
        }

        public Criteria andSubAskReasonNotEqualTo(String value) {
            addCriterion("sub_ask_reason <>", value, "subAskReason");
            return (Criteria) this;
        }

        public Criteria andSubAskReasonGreaterThan(String value) {
            addCriterion("sub_ask_reason >", value, "subAskReason");
            return (Criteria) this;
        }

        public Criteria andSubAskReasonGreaterThanOrEqualTo(String value) {
            addCriterion("sub_ask_reason >=", value, "subAskReason");
            return (Criteria) this;
        }

        public Criteria andSubAskReasonLessThan(String value) {
            addCriterion("sub_ask_reason <", value, "subAskReason");
            return (Criteria) this;
        }

        public Criteria andSubAskReasonLessThanOrEqualTo(String value) {
            addCriterion("sub_ask_reason <=", value, "subAskReason");
            return (Criteria) this;
        }

        public Criteria andSubAskReasonLike(String value) {
            addCriterion("sub_ask_reason like", value, "subAskReason");
            return (Criteria) this;
        }

        public Criteria andSubAskReasonNotLike(String value) {
            addCriterion("sub_ask_reason not like", value, "subAskReason");
            return (Criteria) this;
        }

        public Criteria andSubAskReasonIn(List<String> values) {
            addCriterion("sub_ask_reason in", values, "subAskReason");
            return (Criteria) this;
        }

        public Criteria andSubAskReasonNotIn(List<String> values) {
            addCriterion("sub_ask_reason not in", values, "subAskReason");
            return (Criteria) this;
        }

        public Criteria andSubAskReasonBetween(String value1, String value2) {
            addCriterion("sub_ask_reason between", value1, value2, "subAskReason");
            return (Criteria) this;
        }

        public Criteria andSubAskReasonNotBetween(String value1, String value2) {
            addCriterion("sub_ask_reason not between", value1, value2, "subAskReason");
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