package com.model;

import java.util.ArrayList;
import java.util.List;

public class YoLoanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public YoLoanExample() {
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

        public Criteria andApproveNoIsNull() {
            addCriterion("approve_no is null");
            return (Criteria) this;
        }

        public Criteria andApproveNoIsNotNull() {
            addCriterion("approve_no is not null");
            return (Criteria) this;
        }

        public Criteria andApproveNoEqualTo(String value) {
            addCriterion("approve_no =", value, "approveNo");
            return (Criteria) this;
        }

        public Criteria andApproveNoNotEqualTo(String value) {
            addCriterion("approve_no <>", value, "approveNo");
            return (Criteria) this;
        }

        public Criteria andApproveNoGreaterThan(String value) {
            addCriterion("approve_no >", value, "approveNo");
            return (Criteria) this;
        }

        public Criteria andApproveNoGreaterThanOrEqualTo(String value) {
            addCriterion("approve_no >=", value, "approveNo");
            return (Criteria) this;
        }

        public Criteria andApproveNoLessThan(String value) {
            addCriterion("approve_no <", value, "approveNo");
            return (Criteria) this;
        }

        public Criteria andApproveNoLessThanOrEqualTo(String value) {
            addCriterion("approve_no <=", value, "approveNo");
            return (Criteria) this;
        }

        public Criteria andApproveNoLike(String value) {
            addCriterion("approve_no like", value, "approveNo");
            return (Criteria) this;
        }

        public Criteria andApproveNoNotLike(String value) {
            addCriterion("approve_no not like", value, "approveNo");
            return (Criteria) this;
        }

        public Criteria andApproveNoIn(List<String> values) {
            addCriterion("approve_no in", values, "approveNo");
            return (Criteria) this;
        }

        public Criteria andApproveNoNotIn(List<String> values) {
            addCriterion("approve_no not in", values, "approveNo");
            return (Criteria) this;
        }

        public Criteria andApproveNoBetween(String value1, String value2) {
            addCriterion("approve_no between", value1, value2, "approveNo");
            return (Criteria) this;
        }

        public Criteria andApproveNoNotBetween(String value1, String value2) {
            addCriterion("approve_no not between", value1, value2, "approveNo");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andApproveStatusIsNull() {
            addCriterion("approve_status is null");
            return (Criteria) this;
        }

        public Criteria andApproveStatusIsNotNull() {
            addCriterion("approve_status is not null");
            return (Criteria) this;
        }

        public Criteria andApproveStatusEqualTo(String value) {
            addCriterion("approve_status =", value, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusNotEqualTo(String value) {
            addCriterion("approve_status <>", value, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusGreaterThan(String value) {
            addCriterion("approve_status >", value, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusGreaterThanOrEqualTo(String value) {
            addCriterion("approve_status >=", value, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusLessThan(String value) {
            addCriterion("approve_status <", value, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusLessThanOrEqualTo(String value) {
            addCriterion("approve_status <=", value, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusLike(String value) {
            addCriterion("approve_status like", value, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusNotLike(String value) {
            addCriterion("approve_status not like", value, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusIn(List<String> values) {
            addCriterion("approve_status in", values, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusNotIn(List<String> values) {
            addCriterion("approve_status not in", values, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusBetween(String value1, String value2) {
            addCriterion("approve_status between", value1, value2, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusNotBetween(String value1, String value2) {
            addCriterion("approve_status not between", value1, value2, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveResultIsNull() {
            addCriterion("approve_result is null");
            return (Criteria) this;
        }

        public Criteria andApproveResultIsNotNull() {
            addCriterion("approve_result is not null");
            return (Criteria) this;
        }

        public Criteria andApproveResultEqualTo(String value) {
            addCriterion("approve_result =", value, "approveResult");
            return (Criteria) this;
        }

        public Criteria andApproveResultNotEqualTo(String value) {
            addCriterion("approve_result <>", value, "approveResult");
            return (Criteria) this;
        }

        public Criteria andApproveResultGreaterThan(String value) {
            addCriterion("approve_result >", value, "approveResult");
            return (Criteria) this;
        }

        public Criteria andApproveResultGreaterThanOrEqualTo(String value) {
            addCriterion("approve_result >=", value, "approveResult");
            return (Criteria) this;
        }

        public Criteria andApproveResultLessThan(String value) {
            addCriterion("approve_result <", value, "approveResult");
            return (Criteria) this;
        }

        public Criteria andApproveResultLessThanOrEqualTo(String value) {
            addCriterion("approve_result <=", value, "approveResult");
            return (Criteria) this;
        }

        public Criteria andApproveResultLike(String value) {
            addCriterion("approve_result like", value, "approveResult");
            return (Criteria) this;
        }

        public Criteria andApproveResultNotLike(String value) {
            addCriterion("approve_result not like", value, "approveResult");
            return (Criteria) this;
        }

        public Criteria andApproveResultIn(List<String> values) {
            addCriterion("approve_result in", values, "approveResult");
            return (Criteria) this;
        }

        public Criteria andApproveResultNotIn(List<String> values) {
            addCriterion("approve_result not in", values, "approveResult");
            return (Criteria) this;
        }

        public Criteria andApproveResultBetween(String value1, String value2) {
            addCriterion("approve_result between", value1, value2, "approveResult");
            return (Criteria) this;
        }

        public Criteria andApproveResultNotBetween(String value1, String value2) {
            addCriterion("approve_result not between", value1, value2, "approveResult");
            return (Criteria) this;
        }

        public Criteria andAskStartTimeIsNull() {
            addCriterion("ask_start_time is null");
            return (Criteria) this;
        }

        public Criteria andAskStartTimeIsNotNull() {
            addCriterion("ask_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andAskStartTimeEqualTo(String value) {
            addCriterion("ask_start_time =", value, "askStartTime");
            return (Criteria) this;
        }

        public Criteria andAskStartTimeNotEqualTo(String value) {
            addCriterion("ask_start_time <>", value, "askStartTime");
            return (Criteria) this;
        }

        public Criteria andAskStartTimeGreaterThan(String value) {
            addCriterion("ask_start_time >", value, "askStartTime");
            return (Criteria) this;
        }

        public Criteria andAskStartTimeGreaterThanOrEqualTo(String value) {
            addCriterion("ask_start_time >=", value, "askStartTime");
            return (Criteria) this;
        }

        public Criteria andAskStartTimeLessThan(String value) {
            addCriterion("ask_start_time <", value, "askStartTime");
            return (Criteria) this;
        }

        public Criteria andAskStartTimeLessThanOrEqualTo(String value) {
            addCriterion("ask_start_time <=", value, "askStartTime");
            return (Criteria) this;
        }

        public Criteria andAskStartTimeLike(String value) {
            addCriterion("ask_start_time like", value, "askStartTime");
            return (Criteria) this;
        }

        public Criteria andAskStartTimeNotLike(String value) {
            addCriterion("ask_start_time not like", value, "askStartTime");
            return (Criteria) this;
        }

        public Criteria andAskStartTimeIn(List<String> values) {
            addCriterion("ask_start_time in", values, "askStartTime");
            return (Criteria) this;
        }

        public Criteria andAskStartTimeNotIn(List<String> values) {
            addCriterion("ask_start_time not in", values, "askStartTime");
            return (Criteria) this;
        }

        public Criteria andAskStartTimeBetween(String value1, String value2) {
            addCriterion("ask_start_time between", value1, value2, "askStartTime");
            return (Criteria) this;
        }

        public Criteria andAskStartTimeNotBetween(String value1, String value2) {
            addCriterion("ask_start_time not between", value1, value2, "askStartTime");
            return (Criteria) this;
        }

        public Criteria andAskEndTimeIsNull() {
            addCriterion("ask_end_time is null");
            return (Criteria) this;
        }

        public Criteria andAskEndTimeIsNotNull() {
            addCriterion("ask_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andAskEndTimeEqualTo(String value) {
            addCriterion("ask_end_time =", value, "askEndTime");
            return (Criteria) this;
        }

        public Criteria andAskEndTimeNotEqualTo(String value) {
            addCriterion("ask_end_time <>", value, "askEndTime");
            return (Criteria) this;
        }

        public Criteria andAskEndTimeGreaterThan(String value) {
            addCriterion("ask_end_time >", value, "askEndTime");
            return (Criteria) this;
        }

        public Criteria andAskEndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("ask_end_time >=", value, "askEndTime");
            return (Criteria) this;
        }

        public Criteria andAskEndTimeLessThan(String value) {
            addCriterion("ask_end_time <", value, "askEndTime");
            return (Criteria) this;
        }

        public Criteria andAskEndTimeLessThanOrEqualTo(String value) {
            addCriterion("ask_end_time <=", value, "askEndTime");
            return (Criteria) this;
        }

        public Criteria andAskEndTimeLike(String value) {
            addCriterion("ask_end_time like", value, "askEndTime");
            return (Criteria) this;
        }

        public Criteria andAskEndTimeNotLike(String value) {
            addCriterion("ask_end_time not like", value, "askEndTime");
            return (Criteria) this;
        }

        public Criteria andAskEndTimeIn(List<String> values) {
            addCriterion("ask_end_time in", values, "askEndTime");
            return (Criteria) this;
        }

        public Criteria andAskEndTimeNotIn(List<String> values) {
            addCriterion("ask_end_time not in", values, "askEndTime");
            return (Criteria) this;
        }

        public Criteria andAskEndTimeBetween(String value1, String value2) {
            addCriterion("ask_end_time between", value1, value2, "askEndTime");
            return (Criteria) this;
        }

        public Criteria andAskEndTimeNotBetween(String value1, String value2) {
            addCriterion("ask_end_time not between", value1, value2, "askEndTime");
            return (Criteria) this;
        }

        public Criteria andAskStaffIdIsNull() {
            addCriterion("ask_staff_id is null");
            return (Criteria) this;
        }

        public Criteria andAskStaffIdIsNotNull() {
            addCriterion("ask_staff_id is not null");
            return (Criteria) this;
        }

        public Criteria andAskStaffIdEqualTo(String value) {
            addCriterion("ask_staff_id =", value, "askStaffId");
            return (Criteria) this;
        }

        public Criteria andAskStaffIdNotEqualTo(String value) {
            addCriterion("ask_staff_id <>", value, "askStaffId");
            return (Criteria) this;
        }

        public Criteria andAskStaffIdGreaterThan(String value) {
            addCriterion("ask_staff_id >", value, "askStaffId");
            return (Criteria) this;
        }

        public Criteria andAskStaffIdGreaterThanOrEqualTo(String value) {
            addCriterion("ask_staff_id >=", value, "askStaffId");
            return (Criteria) this;
        }

        public Criteria andAskStaffIdLessThan(String value) {
            addCriterion("ask_staff_id <", value, "askStaffId");
            return (Criteria) this;
        }

        public Criteria andAskStaffIdLessThanOrEqualTo(String value) {
            addCriterion("ask_staff_id <=", value, "askStaffId");
            return (Criteria) this;
        }

        public Criteria andAskStaffIdLike(String value) {
            addCriterion("ask_staff_id like", value, "askStaffId");
            return (Criteria) this;
        }

        public Criteria andAskStaffIdNotLike(String value) {
            addCriterion("ask_staff_id not like", value, "askStaffId");
            return (Criteria) this;
        }

        public Criteria andAskStaffIdIn(List<String> values) {
            addCriterion("ask_staff_id in", values, "askStaffId");
            return (Criteria) this;
        }

        public Criteria andAskStaffIdNotIn(List<String> values) {
            addCriterion("ask_staff_id not in", values, "askStaffId");
            return (Criteria) this;
        }

        public Criteria andAskStaffIdBetween(String value1, String value2) {
            addCriterion("ask_staff_id between", value1, value2, "askStaffId");
            return (Criteria) this;
        }

        public Criteria andAskStaffIdNotBetween(String value1, String value2) {
            addCriterion("ask_staff_id not between", value1, value2, "askStaffId");
            return (Criteria) this;
        }

        public Criteria andAskStaffNameIsNull() {
            addCriterion("ask_staff_name is null");
            return (Criteria) this;
        }

        public Criteria andAskStaffNameIsNotNull() {
            addCriterion("ask_staff_name is not null");
            return (Criteria) this;
        }

        public Criteria andAskStaffNameEqualTo(String value) {
            addCriterion("ask_staff_name =", value, "askStaffName");
            return (Criteria) this;
        }

        public Criteria andAskStaffNameNotEqualTo(String value) {
            addCriterion("ask_staff_name <>", value, "askStaffName");
            return (Criteria) this;
        }

        public Criteria andAskStaffNameGreaterThan(String value) {
            addCriterion("ask_staff_name >", value, "askStaffName");
            return (Criteria) this;
        }

        public Criteria andAskStaffNameGreaterThanOrEqualTo(String value) {
            addCriterion("ask_staff_name >=", value, "askStaffName");
            return (Criteria) this;
        }

        public Criteria andAskStaffNameLessThan(String value) {
            addCriterion("ask_staff_name <", value, "askStaffName");
            return (Criteria) this;
        }

        public Criteria andAskStaffNameLessThanOrEqualTo(String value) {
            addCriterion("ask_staff_name <=", value, "askStaffName");
            return (Criteria) this;
        }

        public Criteria andAskStaffNameLike(String value) {
            addCriterion("ask_staff_name like", value, "askStaffName");
            return (Criteria) this;
        }

        public Criteria andAskStaffNameNotLike(String value) {
            addCriterion("ask_staff_name not like", value, "askStaffName");
            return (Criteria) this;
        }

        public Criteria andAskStaffNameIn(List<String> values) {
            addCriterion("ask_staff_name in", values, "askStaffName");
            return (Criteria) this;
        }

        public Criteria andAskStaffNameNotIn(List<String> values) {
            addCriterion("ask_staff_name not in", values, "askStaffName");
            return (Criteria) this;
        }

        public Criteria andAskStaffNameBetween(String value1, String value2) {
            addCriterion("ask_staff_name between", value1, value2, "askStaffName");
            return (Criteria) this;
        }

        public Criteria andAskStaffNameNotBetween(String value1, String value2) {
            addCriterion("ask_staff_name not between", value1, value2, "askStaffName");
            return (Criteria) this;
        }

        public Criteria andAskStaffDepIsNull() {
            addCriterion("ask_staff_dep is null");
            return (Criteria) this;
        }

        public Criteria andAskStaffDepIsNotNull() {
            addCriterion("ask_staff_dep is not null");
            return (Criteria) this;
        }

        public Criteria andAskStaffDepEqualTo(String value) {
            addCriterion("ask_staff_dep =", value, "askStaffDep");
            return (Criteria) this;
        }

        public Criteria andAskStaffDepNotEqualTo(String value) {
            addCriterion("ask_staff_dep <>", value, "askStaffDep");
            return (Criteria) this;
        }

        public Criteria andAskStaffDepGreaterThan(String value) {
            addCriterion("ask_staff_dep >", value, "askStaffDep");
            return (Criteria) this;
        }

        public Criteria andAskStaffDepGreaterThanOrEqualTo(String value) {
            addCriterion("ask_staff_dep >=", value, "askStaffDep");
            return (Criteria) this;
        }

        public Criteria andAskStaffDepLessThan(String value) {
            addCriterion("ask_staff_dep <", value, "askStaffDep");
            return (Criteria) this;
        }

        public Criteria andAskStaffDepLessThanOrEqualTo(String value) {
            addCriterion("ask_staff_dep <=", value, "askStaffDep");
            return (Criteria) this;
        }

        public Criteria andAskStaffDepLike(String value) {
            addCriterion("ask_staff_dep like", value, "askStaffDep");
            return (Criteria) this;
        }

        public Criteria andAskStaffDepNotLike(String value) {
            addCriterion("ask_staff_dep not like", value, "askStaffDep");
            return (Criteria) this;
        }

        public Criteria andAskStaffDepIn(List<String> values) {
            addCriterion("ask_staff_dep in", values, "askStaffDep");
            return (Criteria) this;
        }

        public Criteria andAskStaffDepNotIn(List<String> values) {
            addCriterion("ask_staff_dep not in", values, "askStaffDep");
            return (Criteria) this;
        }

        public Criteria andAskStaffDepBetween(String value1, String value2) {
            addCriterion("ask_staff_dep between", value1, value2, "askStaffDep");
            return (Criteria) this;
        }

        public Criteria andAskStaffDepNotBetween(String value1, String value2) {
            addCriterion("ask_staff_dep not between", value1, value2, "askStaffDep");
            return (Criteria) this;
        }

        public Criteria andApproverHistoryIsNull() {
            addCriterion("approver_history is null");
            return (Criteria) this;
        }

        public Criteria andApproverHistoryIsNotNull() {
            addCriterion("approver_history is not null");
            return (Criteria) this;
        }

        public Criteria andApproverHistoryEqualTo(String value) {
            addCriterion("approver_history =", value, "approverHistory");
            return (Criteria) this;
        }

        public Criteria andApproverHistoryNotEqualTo(String value) {
            addCriterion("approver_history <>", value, "approverHistory");
            return (Criteria) this;
        }

        public Criteria andApproverHistoryGreaterThan(String value) {
            addCriterion("approver_history >", value, "approverHistory");
            return (Criteria) this;
        }

        public Criteria andApproverHistoryGreaterThanOrEqualTo(String value) {
            addCriterion("approver_history >=", value, "approverHistory");
            return (Criteria) this;
        }

        public Criteria andApproverHistoryLessThan(String value) {
            addCriterion("approver_history <", value, "approverHistory");
            return (Criteria) this;
        }

        public Criteria andApproverHistoryLessThanOrEqualTo(String value) {
            addCriterion("approver_history <=", value, "approverHistory");
            return (Criteria) this;
        }

        public Criteria andApproverHistoryLike(String value) {
            addCriterion("approver_history like", value, "approverHistory");
            return (Criteria) this;
        }

        public Criteria andApproverHistoryNotLike(String value) {
            addCriterion("approver_history not like", value, "approverHistory");
            return (Criteria) this;
        }

        public Criteria andApproverHistoryIn(List<String> values) {
            addCriterion("approver_history in", values, "approverHistory");
            return (Criteria) this;
        }

        public Criteria andApproverHistoryNotIn(List<String> values) {
            addCriterion("approver_history not in", values, "approverHistory");
            return (Criteria) this;
        }

        public Criteria andApproverHistoryBetween(String value1, String value2) {
            addCriterion("approver_history between", value1, value2, "approverHistory");
            return (Criteria) this;
        }

        public Criteria andApproverHistoryNotBetween(String value1, String value2) {
            addCriterion("approver_history not between", value1, value2, "approverHistory");
            return (Criteria) this;
        }

        public Criteria andApproveRecordIsNull() {
            addCriterion("approve_record is null");
            return (Criteria) this;
        }

        public Criteria andApproveRecordIsNotNull() {
            addCriterion("approve_record is not null");
            return (Criteria) this;
        }

        public Criteria andApproveRecordEqualTo(String value) {
            addCriterion("approve_record =", value, "approveRecord");
            return (Criteria) this;
        }

        public Criteria andApproveRecordNotEqualTo(String value) {
            addCriterion("approve_record <>", value, "approveRecord");
            return (Criteria) this;
        }

        public Criteria andApproveRecordGreaterThan(String value) {
            addCriterion("approve_record >", value, "approveRecord");
            return (Criteria) this;
        }

        public Criteria andApproveRecordGreaterThanOrEqualTo(String value) {
            addCriterion("approve_record >=", value, "approveRecord");
            return (Criteria) this;
        }

        public Criteria andApproveRecordLessThan(String value) {
            addCriterion("approve_record <", value, "approveRecord");
            return (Criteria) this;
        }

        public Criteria andApproveRecordLessThanOrEqualTo(String value) {
            addCriterion("approve_record <=", value, "approveRecord");
            return (Criteria) this;
        }

        public Criteria andApproveRecordLike(String value) {
            addCriterion("approve_record like", value, "approveRecord");
            return (Criteria) this;
        }

        public Criteria andApproveRecordNotLike(String value) {
            addCriterion("approve_record not like", value, "approveRecord");
            return (Criteria) this;
        }

        public Criteria andApproveRecordIn(List<String> values) {
            addCriterion("approve_record in", values, "approveRecord");
            return (Criteria) this;
        }

        public Criteria andApproveRecordNotIn(List<String> values) {
            addCriterion("approve_record not in", values, "approveRecord");
            return (Criteria) this;
        }

        public Criteria andApproveRecordBetween(String value1, String value2) {
            addCriterion("approve_record between", value1, value2, "approveRecord");
            return (Criteria) this;
        }

        public Criteria andApproveRecordNotBetween(String value1, String value2) {
            addCriterion("approve_record not between", value1, value2, "approveRecord");
            return (Criteria) this;
        }

        public Criteria andApproverNowIsNull() {
            addCriterion("approver_now is null");
            return (Criteria) this;
        }

        public Criteria andApproverNowIsNotNull() {
            addCriterion("approver_now is not null");
            return (Criteria) this;
        }

        public Criteria andApproverNowEqualTo(String value) {
            addCriterion("approver_now =", value, "approverNow");
            return (Criteria) this;
        }

        public Criteria andApproverNowNotEqualTo(String value) {
            addCriterion("approver_now <>", value, "approverNow");
            return (Criteria) this;
        }

        public Criteria andApproverNowGreaterThan(String value) {
            addCriterion("approver_now >", value, "approverNow");
            return (Criteria) this;
        }

        public Criteria andApproverNowGreaterThanOrEqualTo(String value) {
            addCriterion("approver_now >=", value, "approverNow");
            return (Criteria) this;
        }

        public Criteria andApproverNowLessThan(String value) {
            addCriterion("approver_now <", value, "approverNow");
            return (Criteria) this;
        }

        public Criteria andApproverNowLessThanOrEqualTo(String value) {
            addCriterion("approver_now <=", value, "approverNow");
            return (Criteria) this;
        }

        public Criteria andApproverNowLike(String value) {
            addCriterion("approver_now like", value, "approverNow");
            return (Criteria) this;
        }

        public Criteria andApproverNowNotLike(String value) {
            addCriterion("approver_now not like", value, "approverNow");
            return (Criteria) this;
        }

        public Criteria andApproverNowIn(List<String> values) {
            addCriterion("approver_now in", values, "approverNow");
            return (Criteria) this;
        }

        public Criteria andApproverNowNotIn(List<String> values) {
            addCriterion("approver_now not in", values, "approverNow");
            return (Criteria) this;
        }

        public Criteria andApproverNowBetween(String value1, String value2) {
            addCriterion("approver_now between", value1, value2, "approverNow");
            return (Criteria) this;
        }

        public Criteria andApproverNowNotBetween(String value1, String value2) {
            addCriterion("approver_now not between", value1, value2, "approverNow");
            return (Criteria) this;
        }

        public Criteria andApproveCostIsNull() {
            addCriterion("approve_cost is null");
            return (Criteria) this;
        }

        public Criteria andApproveCostIsNotNull() {
            addCriterion("approve_cost is not null");
            return (Criteria) this;
        }

        public Criteria andApproveCostEqualTo(String value) {
            addCriterion("approve_cost =", value, "approveCost");
            return (Criteria) this;
        }

        public Criteria andApproveCostNotEqualTo(String value) {
            addCriterion("approve_cost <>", value, "approveCost");
            return (Criteria) this;
        }

        public Criteria andApproveCostGreaterThan(String value) {
            addCriterion("approve_cost >", value, "approveCost");
            return (Criteria) this;
        }

        public Criteria andApproveCostGreaterThanOrEqualTo(String value) {
            addCriterion("approve_cost >=", value, "approveCost");
            return (Criteria) this;
        }

        public Criteria andApproveCostLessThan(String value) {
            addCriterion("approve_cost <", value, "approveCost");
            return (Criteria) this;
        }

        public Criteria andApproveCostLessThanOrEqualTo(String value) {
            addCriterion("approve_cost <=", value, "approveCost");
            return (Criteria) this;
        }

        public Criteria andApproveCostLike(String value) {
            addCriterion("approve_cost like", value, "approveCost");
            return (Criteria) this;
        }

        public Criteria andApproveCostNotLike(String value) {
            addCriterion("approve_cost not like", value, "approveCost");
            return (Criteria) this;
        }

        public Criteria andApproveCostIn(List<String> values) {
            addCriterion("approve_cost in", values, "approveCost");
            return (Criteria) this;
        }

        public Criteria andApproveCostNotIn(List<String> values) {
            addCriterion("approve_cost not in", values, "approveCost");
            return (Criteria) this;
        }

        public Criteria andApproveCostBetween(String value1, String value2) {
            addCriterion("approve_cost between", value1, value2, "approveCost");
            return (Criteria) this;
        }

        public Criteria andApproveCostNotBetween(String value1, String value2) {
            addCriterion("approve_cost not between", value1, value2, "approveCost");
            return (Criteria) this;
        }

        public Criteria andLoanStartTimeIsNull() {
            addCriterion("loan_start_time is null");
            return (Criteria) this;
        }

        public Criteria andLoanStartTimeIsNotNull() {
            addCriterion("loan_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andLoanStartTimeEqualTo(String value) {
            addCriterion("loan_start_time =", value, "loanStartTime");
            return (Criteria) this;
        }

        public Criteria andLoanStartTimeNotEqualTo(String value) {
            addCriterion("loan_start_time <>", value, "loanStartTime");
            return (Criteria) this;
        }

        public Criteria andLoanStartTimeGreaterThan(String value) {
            addCriterion("loan_start_time >", value, "loanStartTime");
            return (Criteria) this;
        }

        public Criteria andLoanStartTimeGreaterThanOrEqualTo(String value) {
            addCriterion("loan_start_time >=", value, "loanStartTime");
            return (Criteria) this;
        }

        public Criteria andLoanStartTimeLessThan(String value) {
            addCriterion("loan_start_time <", value, "loanStartTime");
            return (Criteria) this;
        }

        public Criteria andLoanStartTimeLessThanOrEqualTo(String value) {
            addCriterion("loan_start_time <=", value, "loanStartTime");
            return (Criteria) this;
        }

        public Criteria andLoanStartTimeLike(String value) {
            addCriterion("loan_start_time like", value, "loanStartTime");
            return (Criteria) this;
        }

        public Criteria andLoanStartTimeNotLike(String value) {
            addCriterion("loan_start_time not like", value, "loanStartTime");
            return (Criteria) this;
        }

        public Criteria andLoanStartTimeIn(List<String> values) {
            addCriterion("loan_start_time in", values, "loanStartTime");
            return (Criteria) this;
        }

        public Criteria andLoanStartTimeNotIn(List<String> values) {
            addCriterion("loan_start_time not in", values, "loanStartTime");
            return (Criteria) this;
        }

        public Criteria andLoanStartTimeBetween(String value1, String value2) {
            addCriterion("loan_start_time between", value1, value2, "loanStartTime");
            return (Criteria) this;
        }

        public Criteria andLoanStartTimeNotBetween(String value1, String value2) {
            addCriterion("loan_start_time not between", value1, value2, "loanStartTime");
            return (Criteria) this;
        }

        public Criteria andLoanAimMcIsNull() {
            addCriterion("loan_aim_mc is null");
            return (Criteria) this;
        }

        public Criteria andLoanAimMcIsNotNull() {
            addCriterion("loan_aim_mc is not null");
            return (Criteria) this;
        }

        public Criteria andLoanAimMcEqualTo(String value) {
            addCriterion("loan_aim_mc =", value, "loanAimMc");
            return (Criteria) this;
        }

        public Criteria andLoanAimMcNotEqualTo(String value) {
            addCriterion("loan_aim_mc <>", value, "loanAimMc");
            return (Criteria) this;
        }

        public Criteria andLoanAimMcGreaterThan(String value) {
            addCriterion("loan_aim_mc >", value, "loanAimMc");
            return (Criteria) this;
        }

        public Criteria andLoanAimMcGreaterThanOrEqualTo(String value) {
            addCriterion("loan_aim_mc >=", value, "loanAimMc");
            return (Criteria) this;
        }

        public Criteria andLoanAimMcLessThan(String value) {
            addCriterion("loan_aim_mc <", value, "loanAimMc");
            return (Criteria) this;
        }

        public Criteria andLoanAimMcLessThanOrEqualTo(String value) {
            addCriterion("loan_aim_mc <=", value, "loanAimMc");
            return (Criteria) this;
        }

        public Criteria andLoanAimMcLike(String value) {
            addCriterion("loan_aim_mc like", value, "loanAimMc");
            return (Criteria) this;
        }

        public Criteria andLoanAimMcNotLike(String value) {
            addCriterion("loan_aim_mc not like", value, "loanAimMc");
            return (Criteria) this;
        }

        public Criteria andLoanAimMcIn(List<String> values) {
            addCriterion("loan_aim_mc in", values, "loanAimMc");
            return (Criteria) this;
        }

        public Criteria andLoanAimMcNotIn(List<String> values) {
            addCriterion("loan_aim_mc not in", values, "loanAimMc");
            return (Criteria) this;
        }

        public Criteria andLoanAimMcBetween(String value1, String value2) {
            addCriterion("loan_aim_mc between", value1, value2, "loanAimMc");
            return (Criteria) this;
        }

        public Criteria andLoanAimMcNotBetween(String value1, String value2) {
            addCriterion("loan_aim_mc not between", value1, value2, "loanAimMc");
            return (Criteria) this;
        }

        public Criteria andLoanAimScIsNull() {
            addCriterion("loan_aim_sc is null");
            return (Criteria) this;
        }

        public Criteria andLoanAimScIsNotNull() {
            addCriterion("loan_aim_sc is not null");
            return (Criteria) this;
        }

        public Criteria andLoanAimScEqualTo(String value) {
            addCriterion("loan_aim_sc =", value, "loanAimSc");
            return (Criteria) this;
        }

        public Criteria andLoanAimScNotEqualTo(String value) {
            addCriterion("loan_aim_sc <>", value, "loanAimSc");
            return (Criteria) this;
        }

        public Criteria andLoanAimScGreaterThan(String value) {
            addCriterion("loan_aim_sc >", value, "loanAimSc");
            return (Criteria) this;
        }

        public Criteria andLoanAimScGreaterThanOrEqualTo(String value) {
            addCriterion("loan_aim_sc >=", value, "loanAimSc");
            return (Criteria) this;
        }

        public Criteria andLoanAimScLessThan(String value) {
            addCriterion("loan_aim_sc <", value, "loanAimSc");
            return (Criteria) this;
        }

        public Criteria andLoanAimScLessThanOrEqualTo(String value) {
            addCriterion("loan_aim_sc <=", value, "loanAimSc");
            return (Criteria) this;
        }

        public Criteria andLoanAimScLike(String value) {
            addCriterion("loan_aim_sc like", value, "loanAimSc");
            return (Criteria) this;
        }

        public Criteria andLoanAimScNotLike(String value) {
            addCriterion("loan_aim_sc not like", value, "loanAimSc");
            return (Criteria) this;
        }

        public Criteria andLoanAimScIn(List<String> values) {
            addCriterion("loan_aim_sc in", values, "loanAimSc");
            return (Criteria) this;
        }

        public Criteria andLoanAimScNotIn(List<String> values) {
            addCriterion("loan_aim_sc not in", values, "loanAimSc");
            return (Criteria) this;
        }

        public Criteria andLoanAimScBetween(String value1, String value2) {
            addCriterion("loan_aim_sc between", value1, value2, "loanAimSc");
            return (Criteria) this;
        }

        public Criteria andLoanAimScNotBetween(String value1, String value2) {
            addCriterion("loan_aim_sc not between", value1, value2, "loanAimSc");
            return (Criteria) this;
        }

        public Criteria andLoanSumIsNull() {
            addCriterion("loan_sum is null");
            return (Criteria) this;
        }

        public Criteria andLoanSumIsNotNull() {
            addCriterion("loan_sum is not null");
            return (Criteria) this;
        }

        public Criteria andLoanSumEqualTo(String value) {
            addCriterion("loan_sum =", value, "loanSum");
            return (Criteria) this;
        }

        public Criteria andLoanSumNotEqualTo(String value) {
            addCriterion("loan_sum <>", value, "loanSum");
            return (Criteria) this;
        }

        public Criteria andLoanSumGreaterThan(String value) {
            addCriterion("loan_sum >", value, "loanSum");
            return (Criteria) this;
        }

        public Criteria andLoanSumGreaterThanOrEqualTo(String value) {
            addCriterion("loan_sum >=", value, "loanSum");
            return (Criteria) this;
        }

        public Criteria andLoanSumLessThan(String value) {
            addCriterion("loan_sum <", value, "loanSum");
            return (Criteria) this;
        }

        public Criteria andLoanSumLessThanOrEqualTo(String value) {
            addCriterion("loan_sum <=", value, "loanSum");
            return (Criteria) this;
        }

        public Criteria andLoanSumLike(String value) {
            addCriterion("loan_sum like", value, "loanSum");
            return (Criteria) this;
        }

        public Criteria andLoanSumNotLike(String value) {
            addCriterion("loan_sum not like", value, "loanSum");
            return (Criteria) this;
        }

        public Criteria andLoanSumIn(List<String> values) {
            addCriterion("loan_sum in", values, "loanSum");
            return (Criteria) this;
        }

        public Criteria andLoanSumNotIn(List<String> values) {
            addCriterion("loan_sum not in", values, "loanSum");
            return (Criteria) this;
        }

        public Criteria andLoanSumBetween(String value1, String value2) {
            addCriterion("loan_sum between", value1, value2, "loanSum");
            return (Criteria) this;
        }

        public Criteria andLoanSumNotBetween(String value1, String value2) {
            addCriterion("loan_sum not between", value1, value2, "loanSum");
            return (Criteria) this;
        }

        public Criteria andLoanPayeeIsNull() {
            addCriterion("loan_payee is null");
            return (Criteria) this;
        }

        public Criteria andLoanPayeeIsNotNull() {
            addCriterion("loan_payee is not null");
            return (Criteria) this;
        }

        public Criteria andLoanPayeeEqualTo(String value) {
            addCriterion("loan_payee =", value, "loanPayee");
            return (Criteria) this;
        }

        public Criteria andLoanPayeeNotEqualTo(String value) {
            addCriterion("loan_payee <>", value, "loanPayee");
            return (Criteria) this;
        }

        public Criteria andLoanPayeeGreaterThan(String value) {
            addCriterion("loan_payee >", value, "loanPayee");
            return (Criteria) this;
        }

        public Criteria andLoanPayeeGreaterThanOrEqualTo(String value) {
            addCriterion("loan_payee >=", value, "loanPayee");
            return (Criteria) this;
        }

        public Criteria andLoanPayeeLessThan(String value) {
            addCriterion("loan_payee <", value, "loanPayee");
            return (Criteria) this;
        }

        public Criteria andLoanPayeeLessThanOrEqualTo(String value) {
            addCriterion("loan_payee <=", value, "loanPayee");
            return (Criteria) this;
        }

        public Criteria andLoanPayeeLike(String value) {
            addCriterion("loan_payee like", value, "loanPayee");
            return (Criteria) this;
        }

        public Criteria andLoanPayeeNotLike(String value) {
            addCriterion("loan_payee not like", value, "loanPayee");
            return (Criteria) this;
        }

        public Criteria andLoanPayeeIn(List<String> values) {
            addCriterion("loan_payee in", values, "loanPayee");
            return (Criteria) this;
        }

        public Criteria andLoanPayeeNotIn(List<String> values) {
            addCriterion("loan_payee not in", values, "loanPayee");
            return (Criteria) this;
        }

        public Criteria andLoanPayeeBetween(String value1, String value2) {
            addCriterion("loan_payee between", value1, value2, "loanPayee");
            return (Criteria) this;
        }

        public Criteria andLoanPayeeNotBetween(String value1, String value2) {
            addCriterion("loan_payee not between", value1, value2, "loanPayee");
            return (Criteria) this;
        }

        public Criteria andLoanBankIsNull() {
            addCriterion("loan_bank is null");
            return (Criteria) this;
        }

        public Criteria andLoanBankIsNotNull() {
            addCriterion("loan_bank is not null");
            return (Criteria) this;
        }

        public Criteria andLoanBankEqualTo(String value) {
            addCriterion("loan_bank =", value, "loanBank");
            return (Criteria) this;
        }

        public Criteria andLoanBankNotEqualTo(String value) {
            addCriterion("loan_bank <>", value, "loanBank");
            return (Criteria) this;
        }

        public Criteria andLoanBankGreaterThan(String value) {
            addCriterion("loan_bank >", value, "loanBank");
            return (Criteria) this;
        }

        public Criteria andLoanBankGreaterThanOrEqualTo(String value) {
            addCriterion("loan_bank >=", value, "loanBank");
            return (Criteria) this;
        }

        public Criteria andLoanBankLessThan(String value) {
            addCriterion("loan_bank <", value, "loanBank");
            return (Criteria) this;
        }

        public Criteria andLoanBankLessThanOrEqualTo(String value) {
            addCriterion("loan_bank <=", value, "loanBank");
            return (Criteria) this;
        }

        public Criteria andLoanBankLike(String value) {
            addCriterion("loan_bank like", value, "loanBank");
            return (Criteria) this;
        }

        public Criteria andLoanBankNotLike(String value) {
            addCriterion("loan_bank not like", value, "loanBank");
            return (Criteria) this;
        }

        public Criteria andLoanBankIn(List<String> values) {
            addCriterion("loan_bank in", values, "loanBank");
            return (Criteria) this;
        }

        public Criteria andLoanBankNotIn(List<String> values) {
            addCriterion("loan_bank not in", values, "loanBank");
            return (Criteria) this;
        }

        public Criteria andLoanBankBetween(String value1, String value2) {
            addCriterion("loan_bank between", value1, value2, "loanBank");
            return (Criteria) this;
        }

        public Criteria andLoanBankNotBetween(String value1, String value2) {
            addCriterion("loan_bank not between", value1, value2, "loanBank");
            return (Criteria) this;
        }

        public Criteria andLoanBranchIsNull() {
            addCriterion("loan_branch is null");
            return (Criteria) this;
        }

        public Criteria andLoanBranchIsNotNull() {
            addCriterion("loan_branch is not null");
            return (Criteria) this;
        }

        public Criteria andLoanBranchEqualTo(String value) {
            addCriterion("loan_branch =", value, "loanBranch");
            return (Criteria) this;
        }

        public Criteria andLoanBranchNotEqualTo(String value) {
            addCriterion("loan_branch <>", value, "loanBranch");
            return (Criteria) this;
        }

        public Criteria andLoanBranchGreaterThan(String value) {
            addCriterion("loan_branch >", value, "loanBranch");
            return (Criteria) this;
        }

        public Criteria andLoanBranchGreaterThanOrEqualTo(String value) {
            addCriterion("loan_branch >=", value, "loanBranch");
            return (Criteria) this;
        }

        public Criteria andLoanBranchLessThan(String value) {
            addCriterion("loan_branch <", value, "loanBranch");
            return (Criteria) this;
        }

        public Criteria andLoanBranchLessThanOrEqualTo(String value) {
            addCriterion("loan_branch <=", value, "loanBranch");
            return (Criteria) this;
        }

        public Criteria andLoanBranchLike(String value) {
            addCriterion("loan_branch like", value, "loanBranch");
            return (Criteria) this;
        }

        public Criteria andLoanBranchNotLike(String value) {
            addCriterion("loan_branch not like", value, "loanBranch");
            return (Criteria) this;
        }

        public Criteria andLoanBranchIn(List<String> values) {
            addCriterion("loan_branch in", values, "loanBranch");
            return (Criteria) this;
        }

        public Criteria andLoanBranchNotIn(List<String> values) {
            addCriterion("loan_branch not in", values, "loanBranch");
            return (Criteria) this;
        }

        public Criteria andLoanBranchBetween(String value1, String value2) {
            addCriterion("loan_branch between", value1, value2, "loanBranch");
            return (Criteria) this;
        }

        public Criteria andLoanBranchNotBetween(String value1, String value2) {
            addCriterion("loan_branch not between", value1, value2, "loanBranch");
            return (Criteria) this;
        }

        public Criteria andLoanBankAccountIsNull() {
            addCriterion("loan_bank_account is null");
            return (Criteria) this;
        }

        public Criteria andLoanBankAccountIsNotNull() {
            addCriterion("loan_bank_account is not null");
            return (Criteria) this;
        }

        public Criteria andLoanBankAccountEqualTo(String value) {
            addCriterion("loan_bank_account =", value, "loanBankAccount");
            return (Criteria) this;
        }

        public Criteria andLoanBankAccountNotEqualTo(String value) {
            addCriterion("loan_bank_account <>", value, "loanBankAccount");
            return (Criteria) this;
        }

        public Criteria andLoanBankAccountGreaterThan(String value) {
            addCriterion("loan_bank_account >", value, "loanBankAccount");
            return (Criteria) this;
        }

        public Criteria andLoanBankAccountGreaterThanOrEqualTo(String value) {
            addCriterion("loan_bank_account >=", value, "loanBankAccount");
            return (Criteria) this;
        }

        public Criteria andLoanBankAccountLessThan(String value) {
            addCriterion("loan_bank_account <", value, "loanBankAccount");
            return (Criteria) this;
        }

        public Criteria andLoanBankAccountLessThanOrEqualTo(String value) {
            addCriterion("loan_bank_account <=", value, "loanBankAccount");
            return (Criteria) this;
        }

        public Criteria andLoanBankAccountLike(String value) {
            addCriterion("loan_bank_account like", value, "loanBankAccount");
            return (Criteria) this;
        }

        public Criteria andLoanBankAccountNotLike(String value) {
            addCriterion("loan_bank_account not like", value, "loanBankAccount");
            return (Criteria) this;
        }

        public Criteria andLoanBankAccountIn(List<String> values) {
            addCriterion("loan_bank_account in", values, "loanBankAccount");
            return (Criteria) this;
        }

        public Criteria andLoanBankAccountNotIn(List<String> values) {
            addCriterion("loan_bank_account not in", values, "loanBankAccount");
            return (Criteria) this;
        }

        public Criteria andLoanBankAccountBetween(String value1, String value2) {
            addCriterion("loan_bank_account between", value1, value2, "loanBankAccount");
            return (Criteria) this;
        }

        public Criteria andLoanBankAccountNotBetween(String value1, String value2) {
            addCriterion("loan_bank_account not between", value1, value2, "loanBankAccount");
            return (Criteria) this;
        }

        public Criteria andLoanReasonIsNull() {
            addCriterion("loan_reason is null");
            return (Criteria) this;
        }

        public Criteria andLoanReasonIsNotNull() {
            addCriterion("loan_reason is not null");
            return (Criteria) this;
        }

        public Criteria andLoanReasonEqualTo(String value) {
            addCriterion("loan_reason =", value, "loanReason");
            return (Criteria) this;
        }

        public Criteria andLoanReasonNotEqualTo(String value) {
            addCriterion("loan_reason <>", value, "loanReason");
            return (Criteria) this;
        }

        public Criteria andLoanReasonGreaterThan(String value) {
            addCriterion("loan_reason >", value, "loanReason");
            return (Criteria) this;
        }

        public Criteria andLoanReasonGreaterThanOrEqualTo(String value) {
            addCriterion("loan_reason >=", value, "loanReason");
            return (Criteria) this;
        }

        public Criteria andLoanReasonLessThan(String value) {
            addCriterion("loan_reason <", value, "loanReason");
            return (Criteria) this;
        }

        public Criteria andLoanReasonLessThanOrEqualTo(String value) {
            addCriterion("loan_reason <=", value, "loanReason");
            return (Criteria) this;
        }

        public Criteria andLoanReasonLike(String value) {
            addCriterion("loan_reason like", value, "loanReason");
            return (Criteria) this;
        }

        public Criteria andLoanReasonNotLike(String value) {
            addCriterion("loan_reason not like", value, "loanReason");
            return (Criteria) this;
        }

        public Criteria andLoanReasonIn(List<String> values) {
            addCriterion("loan_reason in", values, "loanReason");
            return (Criteria) this;
        }

        public Criteria andLoanReasonNotIn(List<String> values) {
            addCriterion("loan_reason not in", values, "loanReason");
            return (Criteria) this;
        }

        public Criteria andLoanReasonBetween(String value1, String value2) {
            addCriterion("loan_reason between", value1, value2, "loanReason");
            return (Criteria) this;
        }

        public Criteria andLoanReasonNotBetween(String value1, String value2) {
            addCriterion("loan_reason not between", value1, value2, "loanReason");
            return (Criteria) this;
        }

        public Criteria andOtherIsNull() {
            addCriterion("other is null");
            return (Criteria) this;
        }

        public Criteria andOtherIsNotNull() {
            addCriterion("other is not null");
            return (Criteria) this;
        }

        public Criteria andOtherEqualTo(String value) {
            addCriterion("other =", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotEqualTo(String value) {
            addCriterion("other <>", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherGreaterThan(String value) {
            addCriterion("other >", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherGreaterThanOrEqualTo(String value) {
            addCriterion("other >=", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLessThan(String value) {
            addCriterion("other <", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLessThanOrEqualTo(String value) {
            addCriterion("other <=", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLike(String value) {
            addCriterion("other like", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotLike(String value) {
            addCriterion("other not like", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherIn(List<String> values) {
            addCriterion("other in", values, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotIn(List<String> values) {
            addCriterion("other not in", values, "other");
            return (Criteria) this;
        }

        public Criteria andOtherBetween(String value1, String value2) {
            addCriterion("other between", value1, value2, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotBetween(String value1, String value2) {
            addCriterion("other not between", value1, value2, "other");
            return (Criteria) this;
        }

        public Criteria andOperationStatusIsNull() {
            addCriterion("operation_status is null");
            return (Criteria) this;
        }

        public Criteria andOperationStatusIsNotNull() {
            addCriterion("operation_status is not null");
            return (Criteria) this;
        }

        public Criteria andOperationStatusEqualTo(String value) {
            addCriterion("operation_status =", value, "operationStatus");
            return (Criteria) this;
        }

        public Criteria andOperationStatusNotEqualTo(String value) {
            addCriterion("operation_status <>", value, "operationStatus");
            return (Criteria) this;
        }

        public Criteria andOperationStatusGreaterThan(String value) {
            addCriterion("operation_status >", value, "operationStatus");
            return (Criteria) this;
        }

        public Criteria andOperationStatusGreaterThanOrEqualTo(String value) {
            addCriterion("operation_status >=", value, "operationStatus");
            return (Criteria) this;
        }

        public Criteria andOperationStatusLessThan(String value) {
            addCriterion("operation_status <", value, "operationStatus");
            return (Criteria) this;
        }

        public Criteria andOperationStatusLessThanOrEqualTo(String value) {
            addCriterion("operation_status <=", value, "operationStatus");
            return (Criteria) this;
        }

        public Criteria andOperationStatusLike(String value) {
            addCriterion("operation_status like", value, "operationStatus");
            return (Criteria) this;
        }

        public Criteria andOperationStatusNotLike(String value) {
            addCriterion("operation_status not like", value, "operationStatus");
            return (Criteria) this;
        }

        public Criteria andOperationStatusIn(List<String> values) {
            addCriterion("operation_status in", values, "operationStatus");
            return (Criteria) this;
        }

        public Criteria andOperationStatusNotIn(List<String> values) {
            addCriterion("operation_status not in", values, "operationStatus");
            return (Criteria) this;
        }

        public Criteria andOperationStatusBetween(String value1, String value2) {
            addCriterion("operation_status between", value1, value2, "operationStatus");
            return (Criteria) this;
        }

        public Criteria andOperationStatusNotBetween(String value1, String value2) {
            addCriterion("operation_status not between", value1, value2, "operationStatus");
            return (Criteria) this;
        }

        public Criteria andExportStatusIsNull() {
            addCriterion("export_status is null");
            return (Criteria) this;
        }

        public Criteria andExportStatusIsNotNull() {
            addCriterion("export_status is not null");
            return (Criteria) this;
        }

        public Criteria andExportStatusEqualTo(String value) {
            addCriterion("export_status =", value, "exportStatus");
            return (Criteria) this;
        }

        public Criteria andExportStatusNotEqualTo(String value) {
            addCriterion("export_status <>", value, "exportStatus");
            return (Criteria) this;
        }

        public Criteria andExportStatusGreaterThan(String value) {
            addCriterion("export_status >", value, "exportStatus");
            return (Criteria) this;
        }

        public Criteria andExportStatusGreaterThanOrEqualTo(String value) {
            addCriterion("export_status >=", value, "exportStatus");
            return (Criteria) this;
        }

        public Criteria andExportStatusLessThan(String value) {
            addCriterion("export_status <", value, "exportStatus");
            return (Criteria) this;
        }

        public Criteria andExportStatusLessThanOrEqualTo(String value) {
            addCriterion("export_status <=", value, "exportStatus");
            return (Criteria) this;
        }

        public Criteria andExportStatusLike(String value) {
            addCriterion("export_status like", value, "exportStatus");
            return (Criteria) this;
        }

        public Criteria andExportStatusNotLike(String value) {
            addCriterion("export_status not like", value, "exportStatus");
            return (Criteria) this;
        }

        public Criteria andExportStatusIn(List<String> values) {
            addCriterion("export_status in", values, "exportStatus");
            return (Criteria) this;
        }

        public Criteria andExportStatusNotIn(List<String> values) {
            addCriterion("export_status not in", values, "exportStatus");
            return (Criteria) this;
        }

        public Criteria andExportStatusBetween(String value1, String value2) {
            addCriterion("export_status between", value1, value2, "exportStatus");
            return (Criteria) this;
        }

        public Criteria andExportStatusNotBetween(String value1, String value2) {
            addCriterion("export_status not between", value1, value2, "exportStatus");
            return (Criteria) this;
        }

        public Criteria andApproveRepaymentIsNull() {
            addCriterion("approve_repayment is null");
            return (Criteria) this;
        }

        public Criteria andApproveRepaymentIsNotNull() {
            addCriterion("approve_repayment is not null");
            return (Criteria) this;
        }

        public Criteria andApproveRepaymentEqualTo(String value) {
            addCriterion("approve_repayment =", value, "approveRepayment");
            return (Criteria) this;
        }

        public Criteria andApproveRepaymentNotEqualTo(String value) {
            addCriterion("approve_repayment <>", value, "approveRepayment");
            return (Criteria) this;
        }

        public Criteria andApproveRepaymentGreaterThan(String value) {
            addCriterion("approve_repayment >", value, "approveRepayment");
            return (Criteria) this;
        }

        public Criteria andApproveRepaymentGreaterThanOrEqualTo(String value) {
            addCriterion("approve_repayment >=", value, "approveRepayment");
            return (Criteria) this;
        }

        public Criteria andApproveRepaymentLessThan(String value) {
            addCriterion("approve_repayment <", value, "approveRepayment");
            return (Criteria) this;
        }

        public Criteria andApproveRepaymentLessThanOrEqualTo(String value) {
            addCriterion("approve_repayment <=", value, "approveRepayment");
            return (Criteria) this;
        }

        public Criteria andApproveRepaymentLike(String value) {
            addCriterion("approve_repayment like", value, "approveRepayment");
            return (Criteria) this;
        }

        public Criteria andApproveRepaymentNotLike(String value) {
            addCriterion("approve_repayment not like", value, "approveRepayment");
            return (Criteria) this;
        }

        public Criteria andApproveRepaymentIn(List<String> values) {
            addCriterion("approve_repayment in", values, "approveRepayment");
            return (Criteria) this;
        }

        public Criteria andApproveRepaymentNotIn(List<String> values) {
            addCriterion("approve_repayment not in", values, "approveRepayment");
            return (Criteria) this;
        }

        public Criteria andApproveRepaymentBetween(String value1, String value2) {
            addCriterion("approve_repayment between", value1, value2, "approveRepayment");
            return (Criteria) this;
        }

        public Criteria andApproveRepaymentNotBetween(String value1, String value2) {
            addCriterion("approve_repayment not between", value1, value2, "approveRepayment");
            return (Criteria) this;
        }

        public Criteria andApproveInvoiceIsNull() {
            addCriterion("approve_invoice is null");
            return (Criteria) this;
        }

        public Criteria andApproveInvoiceIsNotNull() {
            addCriterion("approve_invoice is not null");
            return (Criteria) this;
        }

        public Criteria andApproveInvoiceEqualTo(String value) {
            addCriterion("approve_invoice =", value, "approveInvoice");
            return (Criteria) this;
        }

        public Criteria andApproveInvoiceNotEqualTo(String value) {
            addCriterion("approve_invoice <>", value, "approveInvoice");
            return (Criteria) this;
        }

        public Criteria andApproveInvoiceGreaterThan(String value) {
            addCriterion("approve_invoice >", value, "approveInvoice");
            return (Criteria) this;
        }

        public Criteria andApproveInvoiceGreaterThanOrEqualTo(String value) {
            addCriterion("approve_invoice >=", value, "approveInvoice");
            return (Criteria) this;
        }

        public Criteria andApproveInvoiceLessThan(String value) {
            addCriterion("approve_invoice <", value, "approveInvoice");
            return (Criteria) this;
        }

        public Criteria andApproveInvoiceLessThanOrEqualTo(String value) {
            addCriterion("approve_invoice <=", value, "approveInvoice");
            return (Criteria) this;
        }

        public Criteria andApproveInvoiceLike(String value) {
            addCriterion("approve_invoice like", value, "approveInvoice");
            return (Criteria) this;
        }

        public Criteria andApproveInvoiceNotLike(String value) {
            addCriterion("approve_invoice not like", value, "approveInvoice");
            return (Criteria) this;
        }

        public Criteria andApproveInvoiceIn(List<String> values) {
            addCriterion("approve_invoice in", values, "approveInvoice");
            return (Criteria) this;
        }

        public Criteria andApproveInvoiceNotIn(List<String> values) {
            addCriterion("approve_invoice not in", values, "approveInvoice");
            return (Criteria) this;
        }

        public Criteria andApproveInvoiceBetween(String value1, String value2) {
            addCriterion("approve_invoice between", value1, value2, "approveInvoice");
            return (Criteria) this;
        }

        public Criteria andApproveInvoiceNotBetween(String value1, String value2) {
            addCriterion("approve_invoice not between", value1, value2, "approveInvoice");
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

        public Criteria andApproveAdviceIsNull() {
            addCriterion("approve_advice is null");
            return (Criteria) this;
        }

        public Criteria andApproveAdviceIsNotNull() {
            addCriterion("approve_advice is not null");
            return (Criteria) this;
        }

        public Criteria andApproveAdviceEqualTo(String value) {
            addCriterion("approve_advice =", value, "approveAdvice");
            return (Criteria) this;
        }

        public Criteria andApproveAdviceNotEqualTo(String value) {
            addCriterion("approve_advice <>", value, "approveAdvice");
            return (Criteria) this;
        }

        public Criteria andApproveAdviceGreaterThan(String value) {
            addCriterion("approve_advice >", value, "approveAdvice");
            return (Criteria) this;
        }

        public Criteria andApproveAdviceGreaterThanOrEqualTo(String value) {
            addCriterion("approve_advice >=", value, "approveAdvice");
            return (Criteria) this;
        }

        public Criteria andApproveAdviceLessThan(String value) {
            addCriterion("approve_advice <", value, "approveAdvice");
            return (Criteria) this;
        }

        public Criteria andApproveAdviceLessThanOrEqualTo(String value) {
            addCriterion("approve_advice <=", value, "approveAdvice");
            return (Criteria) this;
        }

        public Criteria andApproveAdviceLike(String value) {
            addCriterion("approve_advice like", value, "approveAdvice");
            return (Criteria) this;
        }

        public Criteria andApproveAdviceNotLike(String value) {
            addCriterion("approve_advice not like", value, "approveAdvice");
            return (Criteria) this;
        }

        public Criteria andApproveAdviceIn(List<String> values) {
            addCriterion("approve_advice in", values, "approveAdvice");
            return (Criteria) this;
        }

        public Criteria andApproveAdviceNotIn(List<String> values) {
            addCriterion("approve_advice not in", values, "approveAdvice");
            return (Criteria) this;
        }

        public Criteria andApproveAdviceBetween(String value1, String value2) {
            addCriterion("approve_advice between", value1, value2, "approveAdvice");
            return (Criteria) this;
        }

        public Criteria andApproveAdviceNotBetween(String value1, String value2) {
            addCriterion("approve_advice not between", value1, value2, "approveAdvice");
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