package com.model;

import java.util.ArrayList;
import java.util.List;

public class YoAdvanceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public YoAdvanceExample() {
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

        public Criteria andAdvanceStartTimeIsNull() {
            addCriterion("advance_start_time is null");
            return (Criteria) this;
        }

        public Criteria andAdvanceStartTimeIsNotNull() {
            addCriterion("advance_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andAdvanceStartTimeEqualTo(String value) {
            addCriterion("advance_start_time =", value, "advanceStartTime");
            return (Criteria) this;
        }

        public Criteria andAdvanceStartTimeNotEqualTo(String value) {
            addCriterion("advance_start_time <>", value, "advanceStartTime");
            return (Criteria) this;
        }

        public Criteria andAdvanceStartTimeGreaterThan(String value) {
            addCriterion("advance_start_time >", value, "advanceStartTime");
            return (Criteria) this;
        }

        public Criteria andAdvanceStartTimeGreaterThanOrEqualTo(String value) {
            addCriterion("advance_start_time >=", value, "advanceStartTime");
            return (Criteria) this;
        }

        public Criteria andAdvanceStartTimeLessThan(String value) {
            addCriterion("advance_start_time <", value, "advanceStartTime");
            return (Criteria) this;
        }

        public Criteria andAdvanceStartTimeLessThanOrEqualTo(String value) {
            addCriterion("advance_start_time <=", value, "advanceStartTime");
            return (Criteria) this;
        }

        public Criteria andAdvanceStartTimeLike(String value) {
            addCriterion("advance_start_time like", value, "advanceStartTime");
            return (Criteria) this;
        }

        public Criteria andAdvanceStartTimeNotLike(String value) {
            addCriterion("advance_start_time not like", value, "advanceStartTime");
            return (Criteria) this;
        }

        public Criteria andAdvanceStartTimeIn(List<String> values) {
            addCriterion("advance_start_time in", values, "advanceStartTime");
            return (Criteria) this;
        }

        public Criteria andAdvanceStartTimeNotIn(List<String> values) {
            addCriterion("advance_start_time not in", values, "advanceStartTime");
            return (Criteria) this;
        }

        public Criteria andAdvanceStartTimeBetween(String value1, String value2) {
            addCriterion("advance_start_time between", value1, value2, "advanceStartTime");
            return (Criteria) this;
        }

        public Criteria andAdvanceStartTimeNotBetween(String value1, String value2) {
            addCriterion("advance_start_time not between", value1, value2, "advanceStartTime");
            return (Criteria) this;
        }

        public Criteria andAdvanceAimMcIsNull() {
            addCriterion("advance_aim_MC is null");
            return (Criteria) this;
        }

        public Criteria andAdvanceAimMcIsNotNull() {
            addCriterion("advance_aim_MC is not null");
            return (Criteria) this;
        }

        public Criteria andAdvanceAimMcEqualTo(String value) {
            addCriterion("advance_aim_MC =", value, "advanceAimMc");
            return (Criteria) this;
        }

        public Criteria andAdvanceAimMcNotEqualTo(String value) {
            addCriterion("advance_aim_MC <>", value, "advanceAimMc");
            return (Criteria) this;
        }

        public Criteria andAdvanceAimMcGreaterThan(String value) {
            addCriterion("advance_aim_MC >", value, "advanceAimMc");
            return (Criteria) this;
        }

        public Criteria andAdvanceAimMcGreaterThanOrEqualTo(String value) {
            addCriterion("advance_aim_MC >=", value, "advanceAimMc");
            return (Criteria) this;
        }

        public Criteria andAdvanceAimMcLessThan(String value) {
            addCriterion("advance_aim_MC <", value, "advanceAimMc");
            return (Criteria) this;
        }

        public Criteria andAdvanceAimMcLessThanOrEqualTo(String value) {
            addCriterion("advance_aim_MC <=", value, "advanceAimMc");
            return (Criteria) this;
        }

        public Criteria andAdvanceAimMcLike(String value) {
            addCriterion("advance_aim_MC like", value, "advanceAimMc");
            return (Criteria) this;
        }

        public Criteria andAdvanceAimMcNotLike(String value) {
            addCriterion("advance_aim_MC not like", value, "advanceAimMc");
            return (Criteria) this;
        }

        public Criteria andAdvanceAimMcIn(List<String> values) {
            addCriterion("advance_aim_MC in", values, "advanceAimMc");
            return (Criteria) this;
        }

        public Criteria andAdvanceAimMcNotIn(List<String> values) {
            addCriterion("advance_aim_MC not in", values, "advanceAimMc");
            return (Criteria) this;
        }

        public Criteria andAdvanceAimMcBetween(String value1, String value2) {
            addCriterion("advance_aim_MC between", value1, value2, "advanceAimMc");
            return (Criteria) this;
        }

        public Criteria andAdvanceAimMcNotBetween(String value1, String value2) {
            addCriterion("advance_aim_MC not between", value1, value2, "advanceAimMc");
            return (Criteria) this;
        }

        public Criteria andAdvanceAimScIsNull() {
            addCriterion("advance_aim_SC is null");
            return (Criteria) this;
        }

        public Criteria andAdvanceAimScIsNotNull() {
            addCriterion("advance_aim_SC is not null");
            return (Criteria) this;
        }

        public Criteria andAdvanceAimScEqualTo(String value) {
            addCriterion("advance_aim_SC =", value, "advanceAimSc");
            return (Criteria) this;
        }

        public Criteria andAdvanceAimScNotEqualTo(String value) {
            addCriterion("advance_aim_SC <>", value, "advanceAimSc");
            return (Criteria) this;
        }

        public Criteria andAdvanceAimScGreaterThan(String value) {
            addCriterion("advance_aim_SC >", value, "advanceAimSc");
            return (Criteria) this;
        }

        public Criteria andAdvanceAimScGreaterThanOrEqualTo(String value) {
            addCriterion("advance_aim_SC >=", value, "advanceAimSc");
            return (Criteria) this;
        }

        public Criteria andAdvanceAimScLessThan(String value) {
            addCriterion("advance_aim_SC <", value, "advanceAimSc");
            return (Criteria) this;
        }

        public Criteria andAdvanceAimScLessThanOrEqualTo(String value) {
            addCriterion("advance_aim_SC <=", value, "advanceAimSc");
            return (Criteria) this;
        }

        public Criteria andAdvanceAimScLike(String value) {
            addCriterion("advance_aim_SC like", value, "advanceAimSc");
            return (Criteria) this;
        }

        public Criteria andAdvanceAimScNotLike(String value) {
            addCriterion("advance_aim_SC not like", value, "advanceAimSc");
            return (Criteria) this;
        }

        public Criteria andAdvanceAimScIn(List<String> values) {
            addCriterion("advance_aim_SC in", values, "advanceAimSc");
            return (Criteria) this;
        }

        public Criteria andAdvanceAimScNotIn(List<String> values) {
            addCriterion("advance_aim_SC not in", values, "advanceAimSc");
            return (Criteria) this;
        }

        public Criteria andAdvanceAimScBetween(String value1, String value2) {
            addCriterion("advance_aim_SC between", value1, value2, "advanceAimSc");
            return (Criteria) this;
        }

        public Criteria andAdvanceAimScNotBetween(String value1, String value2) {
            addCriterion("advance_aim_SC not between", value1, value2, "advanceAimSc");
            return (Criteria) this;
        }

        public Criteria andAdvanceSumIsNull() {
            addCriterion("advance_sum is null");
            return (Criteria) this;
        }

        public Criteria andAdvanceSumIsNotNull() {
            addCriterion("advance_sum is not null");
            return (Criteria) this;
        }

        public Criteria andAdvanceSumEqualTo(String value) {
            addCriterion("advance_sum =", value, "advanceSum");
            return (Criteria) this;
        }

        public Criteria andAdvanceSumNotEqualTo(String value) {
            addCriterion("advance_sum <>", value, "advanceSum");
            return (Criteria) this;
        }

        public Criteria andAdvanceSumGreaterThan(String value) {
            addCriterion("advance_sum >", value, "advanceSum");
            return (Criteria) this;
        }

        public Criteria andAdvanceSumGreaterThanOrEqualTo(String value) {
            addCriterion("advance_sum >=", value, "advanceSum");
            return (Criteria) this;
        }

        public Criteria andAdvanceSumLessThan(String value) {
            addCriterion("advance_sum <", value, "advanceSum");
            return (Criteria) this;
        }

        public Criteria andAdvanceSumLessThanOrEqualTo(String value) {
            addCriterion("advance_sum <=", value, "advanceSum");
            return (Criteria) this;
        }

        public Criteria andAdvanceSumLike(String value) {
            addCriterion("advance_sum like", value, "advanceSum");
            return (Criteria) this;
        }

        public Criteria andAdvanceSumNotLike(String value) {
            addCriterion("advance_sum not like", value, "advanceSum");
            return (Criteria) this;
        }

        public Criteria andAdvanceSumIn(List<String> values) {
            addCriterion("advance_sum in", values, "advanceSum");
            return (Criteria) this;
        }

        public Criteria andAdvanceSumNotIn(List<String> values) {
            addCriterion("advance_sum not in", values, "advanceSum");
            return (Criteria) this;
        }

        public Criteria andAdvanceSumBetween(String value1, String value2) {
            addCriterion("advance_sum between", value1, value2, "advanceSum");
            return (Criteria) this;
        }

        public Criteria andAdvanceSumNotBetween(String value1, String value2) {
            addCriterion("advance_sum not between", value1, value2, "advanceSum");
            return (Criteria) this;
        }

        public Criteria andAdvancePayeeIsNull() {
            addCriterion("advance_payee is null");
            return (Criteria) this;
        }

        public Criteria andAdvancePayeeIsNotNull() {
            addCriterion("advance_payee is not null");
            return (Criteria) this;
        }

        public Criteria andAdvancePayeeEqualTo(String value) {
            addCriterion("advance_payee =", value, "advancePayee");
            return (Criteria) this;
        }

        public Criteria andAdvancePayeeNotEqualTo(String value) {
            addCriterion("advance_payee <>", value, "advancePayee");
            return (Criteria) this;
        }

        public Criteria andAdvancePayeeGreaterThan(String value) {
            addCriterion("advance_payee >", value, "advancePayee");
            return (Criteria) this;
        }

        public Criteria andAdvancePayeeGreaterThanOrEqualTo(String value) {
            addCriterion("advance_payee >=", value, "advancePayee");
            return (Criteria) this;
        }

        public Criteria andAdvancePayeeLessThan(String value) {
            addCriterion("advance_payee <", value, "advancePayee");
            return (Criteria) this;
        }

        public Criteria andAdvancePayeeLessThanOrEqualTo(String value) {
            addCriterion("advance_payee <=", value, "advancePayee");
            return (Criteria) this;
        }

        public Criteria andAdvancePayeeLike(String value) {
            addCriterion("advance_payee like", value, "advancePayee");
            return (Criteria) this;
        }

        public Criteria andAdvancePayeeNotLike(String value) {
            addCriterion("advance_payee not like", value, "advancePayee");
            return (Criteria) this;
        }

        public Criteria andAdvancePayeeIn(List<String> values) {
            addCriterion("advance_payee in", values, "advancePayee");
            return (Criteria) this;
        }

        public Criteria andAdvancePayeeNotIn(List<String> values) {
            addCriterion("advance_payee not in", values, "advancePayee");
            return (Criteria) this;
        }

        public Criteria andAdvancePayeeBetween(String value1, String value2) {
            addCriterion("advance_payee between", value1, value2, "advancePayee");
            return (Criteria) this;
        }

        public Criteria andAdvancePayeeNotBetween(String value1, String value2) {
            addCriterion("advance_payee not between", value1, value2, "advancePayee");
            return (Criteria) this;
        }

        public Criteria andAdvanceBankIsNull() {
            addCriterion("advance_bank is null");
            return (Criteria) this;
        }

        public Criteria andAdvanceBankIsNotNull() {
            addCriterion("advance_bank is not null");
            return (Criteria) this;
        }

        public Criteria andAdvanceBankEqualTo(String value) {
            addCriterion("advance_bank =", value, "advanceBank");
            return (Criteria) this;
        }

        public Criteria andAdvanceBankNotEqualTo(String value) {
            addCriterion("advance_bank <>", value, "advanceBank");
            return (Criteria) this;
        }

        public Criteria andAdvanceBankGreaterThan(String value) {
            addCriterion("advance_bank >", value, "advanceBank");
            return (Criteria) this;
        }

        public Criteria andAdvanceBankGreaterThanOrEqualTo(String value) {
            addCriterion("advance_bank >=", value, "advanceBank");
            return (Criteria) this;
        }

        public Criteria andAdvanceBankLessThan(String value) {
            addCriterion("advance_bank <", value, "advanceBank");
            return (Criteria) this;
        }

        public Criteria andAdvanceBankLessThanOrEqualTo(String value) {
            addCriterion("advance_bank <=", value, "advanceBank");
            return (Criteria) this;
        }

        public Criteria andAdvanceBankLike(String value) {
            addCriterion("advance_bank like", value, "advanceBank");
            return (Criteria) this;
        }

        public Criteria andAdvanceBankNotLike(String value) {
            addCriterion("advance_bank not like", value, "advanceBank");
            return (Criteria) this;
        }

        public Criteria andAdvanceBankIn(List<String> values) {
            addCriterion("advance_bank in", values, "advanceBank");
            return (Criteria) this;
        }

        public Criteria andAdvanceBankNotIn(List<String> values) {
            addCriterion("advance_bank not in", values, "advanceBank");
            return (Criteria) this;
        }

        public Criteria andAdvanceBankBetween(String value1, String value2) {
            addCriterion("advance_bank between", value1, value2, "advanceBank");
            return (Criteria) this;
        }

        public Criteria andAdvanceBankNotBetween(String value1, String value2) {
            addCriterion("advance_bank not between", value1, value2, "advanceBank");
            return (Criteria) this;
        }

        public Criteria andAdvanceBranchIsNull() {
            addCriterion("advance_branch is null");
            return (Criteria) this;
        }

        public Criteria andAdvanceBranchIsNotNull() {
            addCriterion("advance_branch is not null");
            return (Criteria) this;
        }

        public Criteria andAdvanceBranchEqualTo(String value) {
            addCriterion("advance_branch =", value, "advanceBranch");
            return (Criteria) this;
        }

        public Criteria andAdvanceBranchNotEqualTo(String value) {
            addCriterion("advance_branch <>", value, "advanceBranch");
            return (Criteria) this;
        }

        public Criteria andAdvanceBranchGreaterThan(String value) {
            addCriterion("advance_branch >", value, "advanceBranch");
            return (Criteria) this;
        }

        public Criteria andAdvanceBranchGreaterThanOrEqualTo(String value) {
            addCriterion("advance_branch >=", value, "advanceBranch");
            return (Criteria) this;
        }

        public Criteria andAdvanceBranchLessThan(String value) {
            addCriterion("advance_branch <", value, "advanceBranch");
            return (Criteria) this;
        }

        public Criteria andAdvanceBranchLessThanOrEqualTo(String value) {
            addCriterion("advance_branch <=", value, "advanceBranch");
            return (Criteria) this;
        }

        public Criteria andAdvanceBranchLike(String value) {
            addCriterion("advance_branch like", value, "advanceBranch");
            return (Criteria) this;
        }

        public Criteria andAdvanceBranchNotLike(String value) {
            addCriterion("advance_branch not like", value, "advanceBranch");
            return (Criteria) this;
        }

        public Criteria andAdvanceBranchIn(List<String> values) {
            addCriterion("advance_branch in", values, "advanceBranch");
            return (Criteria) this;
        }

        public Criteria andAdvanceBranchNotIn(List<String> values) {
            addCriterion("advance_branch not in", values, "advanceBranch");
            return (Criteria) this;
        }

        public Criteria andAdvanceBranchBetween(String value1, String value2) {
            addCriterion("advance_branch between", value1, value2, "advanceBranch");
            return (Criteria) this;
        }

        public Criteria andAdvanceBranchNotBetween(String value1, String value2) {
            addCriterion("advance_branch not between", value1, value2, "advanceBranch");
            return (Criteria) this;
        }

        public Criteria andAdvanceBankAccountIsNull() {
            addCriterion("advance_bank_account is null");
            return (Criteria) this;
        }

        public Criteria andAdvanceBankAccountIsNotNull() {
            addCriterion("advance_bank_account is not null");
            return (Criteria) this;
        }

        public Criteria andAdvanceBankAccountEqualTo(String value) {
            addCriterion("advance_bank_account =", value, "advanceBankAccount");
            return (Criteria) this;
        }

        public Criteria andAdvanceBankAccountNotEqualTo(String value) {
            addCriterion("advance_bank_account <>", value, "advanceBankAccount");
            return (Criteria) this;
        }

        public Criteria andAdvanceBankAccountGreaterThan(String value) {
            addCriterion("advance_bank_account >", value, "advanceBankAccount");
            return (Criteria) this;
        }

        public Criteria andAdvanceBankAccountGreaterThanOrEqualTo(String value) {
            addCriterion("advance_bank_account >=", value, "advanceBankAccount");
            return (Criteria) this;
        }

        public Criteria andAdvanceBankAccountLessThan(String value) {
            addCriterion("advance_bank_account <", value, "advanceBankAccount");
            return (Criteria) this;
        }

        public Criteria andAdvanceBankAccountLessThanOrEqualTo(String value) {
            addCriterion("advance_bank_account <=", value, "advanceBankAccount");
            return (Criteria) this;
        }

        public Criteria andAdvanceBankAccountLike(String value) {
            addCriterion("advance_bank_account like", value, "advanceBankAccount");
            return (Criteria) this;
        }

        public Criteria andAdvanceBankAccountNotLike(String value) {
            addCriterion("advance_bank_account not like", value, "advanceBankAccount");
            return (Criteria) this;
        }

        public Criteria andAdvanceBankAccountIn(List<String> values) {
            addCriterion("advance_bank_account in", values, "advanceBankAccount");
            return (Criteria) this;
        }

        public Criteria andAdvanceBankAccountNotIn(List<String> values) {
            addCriterion("advance_bank_account not in", values, "advanceBankAccount");
            return (Criteria) this;
        }

        public Criteria andAdvanceBankAccountBetween(String value1, String value2) {
            addCriterion("advance_bank_account between", value1, value2, "advanceBankAccount");
            return (Criteria) this;
        }

        public Criteria andAdvanceBankAccountNotBetween(String value1, String value2) {
            addCriterion("advance_bank_account not between", value1, value2, "advanceBankAccount");
            return (Criteria) this;
        }

        public Criteria andAdvanceReasonIsNull() {
            addCriterion("advance_reason is null");
            return (Criteria) this;
        }

        public Criteria andAdvanceReasonIsNotNull() {
            addCriterion("advance_reason is not null");
            return (Criteria) this;
        }

        public Criteria andAdvanceReasonEqualTo(String value) {
            addCriterion("advance_reason =", value, "advanceReason");
            return (Criteria) this;
        }

        public Criteria andAdvanceReasonNotEqualTo(String value) {
            addCriterion("advance_reason <>", value, "advanceReason");
            return (Criteria) this;
        }

        public Criteria andAdvanceReasonGreaterThan(String value) {
            addCriterion("advance_reason >", value, "advanceReason");
            return (Criteria) this;
        }

        public Criteria andAdvanceReasonGreaterThanOrEqualTo(String value) {
            addCriterion("advance_reason >=", value, "advanceReason");
            return (Criteria) this;
        }

        public Criteria andAdvanceReasonLessThan(String value) {
            addCriterion("advance_reason <", value, "advanceReason");
            return (Criteria) this;
        }

        public Criteria andAdvanceReasonLessThanOrEqualTo(String value) {
            addCriterion("advance_reason <=", value, "advanceReason");
            return (Criteria) this;
        }

        public Criteria andAdvanceReasonLike(String value) {
            addCriterion("advance_reason like", value, "advanceReason");
            return (Criteria) this;
        }

        public Criteria andAdvanceReasonNotLike(String value) {
            addCriterion("advance_reason not like", value, "advanceReason");
            return (Criteria) this;
        }

        public Criteria andAdvanceReasonIn(List<String> values) {
            addCriterion("advance_reason in", values, "advanceReason");
            return (Criteria) this;
        }

        public Criteria andAdvanceReasonNotIn(List<String> values) {
            addCriterion("advance_reason not in", values, "advanceReason");
            return (Criteria) this;
        }

        public Criteria andAdvanceReasonBetween(String value1, String value2) {
            addCriterion("advance_reason between", value1, value2, "advanceReason");
            return (Criteria) this;
        }

        public Criteria andAdvanceReasonNotBetween(String value1, String value2) {
            addCriterion("advance_reason not between", value1, value2, "advanceReason");
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