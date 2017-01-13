package com.model;

import java.util.ArrayList;
import java.util.List;

public class ExpenseWorkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExpenseWorkExample() {
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

        public Criteria andApproveNumberIsNull() {
            addCriterion("approve_number is null");
            return (Criteria) this;
        }

        public Criteria andApproveNumberIsNotNull() {
            addCriterion("approve_number is not null");
            return (Criteria) this;
        }

        public Criteria andApproveNumberEqualTo(String value) {
            addCriterion("approve_number =", value, "approveNumber");
            return (Criteria) this;
        }

        public Criteria andApproveNumberNotEqualTo(String value) {
            addCriterion("approve_number <>", value, "approveNumber");
            return (Criteria) this;
        }

        public Criteria andApproveNumberGreaterThan(String value) {
            addCriterion("approve_number >", value, "approveNumber");
            return (Criteria) this;
        }

        public Criteria andApproveNumberGreaterThanOrEqualTo(String value) {
            addCriterion("approve_number >=", value, "approveNumber");
            return (Criteria) this;
        }

        public Criteria andApproveNumberLessThan(String value) {
            addCriterion("approve_number <", value, "approveNumber");
            return (Criteria) this;
        }

        public Criteria andApproveNumberLessThanOrEqualTo(String value) {
            addCriterion("approve_number <=", value, "approveNumber");
            return (Criteria) this;
        }

        public Criteria andApproveNumberLike(String value) {
            addCriterion("approve_number like", value, "approveNumber");
            return (Criteria) this;
        }

        public Criteria andApproveNumberNotLike(String value) {
            addCriterion("approve_number not like", value, "approveNumber");
            return (Criteria) this;
        }

        public Criteria andApproveNumberIn(List<String> values) {
            addCriterion("approve_number in", values, "approveNumber");
            return (Criteria) this;
        }

        public Criteria andApproveNumberNotIn(List<String> values) {
            addCriterion("approve_number not in", values, "approveNumber");
            return (Criteria) this;
        }

        public Criteria andApproveNumberBetween(String value1, String value2) {
            addCriterion("approve_number between", value1, value2, "approveNumber");
            return (Criteria) this;
        }

        public Criteria andApproveNumberNotBetween(String value1, String value2) {
            addCriterion("approve_number not between", value1, value2, "approveNumber");
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

        public Criteria andExpenseStatusIsNull() {
            addCriterion("expense_status is null");
            return (Criteria) this;
        }

        public Criteria andExpenseStatusIsNotNull() {
            addCriterion("expense_status is not null");
            return (Criteria) this;
        }

        public Criteria andExpenseStatusEqualTo(String value) {
            addCriterion("expense_status =", value, "expenseStatus");
            return (Criteria) this;
        }

        public Criteria andExpenseStatusNotEqualTo(String value) {
            addCriterion("expense_status <>", value, "expenseStatus");
            return (Criteria) this;
        }

        public Criteria andExpenseStatusGreaterThan(String value) {
            addCriterion("expense_status >", value, "expenseStatus");
            return (Criteria) this;
        }

        public Criteria andExpenseStatusGreaterThanOrEqualTo(String value) {
            addCriterion("expense_status >=", value, "expenseStatus");
            return (Criteria) this;
        }

        public Criteria andExpenseStatusLessThan(String value) {
            addCriterion("expense_status <", value, "expenseStatus");
            return (Criteria) this;
        }

        public Criteria andExpenseStatusLessThanOrEqualTo(String value) {
            addCriterion("expense_status <=", value, "expenseStatus");
            return (Criteria) this;
        }

        public Criteria andExpenseStatusLike(String value) {
            addCriterion("expense_status like", value, "expenseStatus");
            return (Criteria) this;
        }

        public Criteria andExpenseStatusNotLike(String value) {
            addCriterion("expense_status not like", value, "expenseStatus");
            return (Criteria) this;
        }

        public Criteria andExpenseStatusIn(List<String> values) {
            addCriterion("expense_status in", values, "expenseStatus");
            return (Criteria) this;
        }

        public Criteria andExpenseStatusNotIn(List<String> values) {
            addCriterion("expense_status not in", values, "expenseStatus");
            return (Criteria) this;
        }

        public Criteria andExpenseStatusBetween(String value1, String value2) {
            addCriterion("expense_status between", value1, value2, "expenseStatus");
            return (Criteria) this;
        }

        public Criteria andExpenseStatusNotBetween(String value1, String value2) {
            addCriterion("expense_status not between", value1, value2, "expenseStatus");
            return (Criteria) this;
        }

        public Criteria andResultIsNull() {
            addCriterion("result is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("result is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(String value) {
            addCriterion("result =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(String value) {
            addCriterion("result <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(String value) {
            addCriterion("result >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(String value) {
            addCriterion("result >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(String value) {
            addCriterion("result <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(String value) {
            addCriterion("result <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLike(String value) {
            addCriterion("result like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotLike(String value) {
            addCriterion("result not like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<String> values) {
            addCriterion("result in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<String> values) {
            addCriterion("result not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(String value1, String value2) {
            addCriterion("result between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(String value1, String value2) {
            addCriterion("result not between", value1, value2, "result");
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

        public Criteria andApplyStaffIdIsNull() {
            addCriterion("apply_staff_id is null");
            return (Criteria) this;
        }

        public Criteria andApplyStaffIdIsNotNull() {
            addCriterion("apply_staff_id is not null");
            return (Criteria) this;
        }

        public Criteria andApplyStaffIdEqualTo(String value) {
            addCriterion("apply_staff_id =", value, "applyStaffId");
            return (Criteria) this;
        }

        public Criteria andApplyStaffIdNotEqualTo(String value) {
            addCriterion("apply_staff_id <>", value, "applyStaffId");
            return (Criteria) this;
        }

        public Criteria andApplyStaffIdGreaterThan(String value) {
            addCriterion("apply_staff_id >", value, "applyStaffId");
            return (Criteria) this;
        }

        public Criteria andApplyStaffIdGreaterThanOrEqualTo(String value) {
            addCriterion("apply_staff_id >=", value, "applyStaffId");
            return (Criteria) this;
        }

        public Criteria andApplyStaffIdLessThan(String value) {
            addCriterion("apply_staff_id <", value, "applyStaffId");
            return (Criteria) this;
        }

        public Criteria andApplyStaffIdLessThanOrEqualTo(String value) {
            addCriterion("apply_staff_id <=", value, "applyStaffId");
            return (Criteria) this;
        }

        public Criteria andApplyStaffIdLike(String value) {
            addCriterion("apply_staff_id like", value, "applyStaffId");
            return (Criteria) this;
        }

        public Criteria andApplyStaffIdNotLike(String value) {
            addCriterion("apply_staff_id not like", value, "applyStaffId");
            return (Criteria) this;
        }

        public Criteria andApplyStaffIdIn(List<String> values) {
            addCriterion("apply_staff_id in", values, "applyStaffId");
            return (Criteria) this;
        }

        public Criteria andApplyStaffIdNotIn(List<String> values) {
            addCriterion("apply_staff_id not in", values, "applyStaffId");
            return (Criteria) this;
        }

        public Criteria andApplyStaffIdBetween(String value1, String value2) {
            addCriterion("apply_staff_id between", value1, value2, "applyStaffId");
            return (Criteria) this;
        }

        public Criteria andApplyStaffIdNotBetween(String value1, String value2) {
            addCriterion("apply_staff_id not between", value1, value2, "applyStaffId");
            return (Criteria) this;
        }

        public Criteria andApplyNameIsNull() {
            addCriterion("apply_name is null");
            return (Criteria) this;
        }

        public Criteria andApplyNameIsNotNull() {
            addCriterion("apply_name is not null");
            return (Criteria) this;
        }

        public Criteria andApplyNameEqualTo(String value) {
            addCriterion("apply_name =", value, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameNotEqualTo(String value) {
            addCriterion("apply_name <>", value, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameGreaterThan(String value) {
            addCriterion("apply_name >", value, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameGreaterThanOrEqualTo(String value) {
            addCriterion("apply_name >=", value, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameLessThan(String value) {
            addCriterion("apply_name <", value, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameLessThanOrEqualTo(String value) {
            addCriterion("apply_name <=", value, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameLike(String value) {
            addCriterion("apply_name like", value, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameNotLike(String value) {
            addCriterion("apply_name not like", value, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameIn(List<String> values) {
            addCriterion("apply_name in", values, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameNotIn(List<String> values) {
            addCriterion("apply_name not in", values, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameBetween(String value1, String value2) {
            addCriterion("apply_name between", value1, value2, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameNotBetween(String value1, String value2) {
            addCriterion("apply_name not between", value1, value2, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyDepartmentIsNull() {
            addCriterion("apply_department is null");
            return (Criteria) this;
        }

        public Criteria andApplyDepartmentIsNotNull() {
            addCriterion("apply_department is not null");
            return (Criteria) this;
        }

        public Criteria andApplyDepartmentEqualTo(String value) {
            addCriterion("apply_department =", value, "applyDepartment");
            return (Criteria) this;
        }

        public Criteria andApplyDepartmentNotEqualTo(String value) {
            addCriterion("apply_department <>", value, "applyDepartment");
            return (Criteria) this;
        }

        public Criteria andApplyDepartmentGreaterThan(String value) {
            addCriterion("apply_department >", value, "applyDepartment");
            return (Criteria) this;
        }

        public Criteria andApplyDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("apply_department >=", value, "applyDepartment");
            return (Criteria) this;
        }

        public Criteria andApplyDepartmentLessThan(String value) {
            addCriterion("apply_department <", value, "applyDepartment");
            return (Criteria) this;
        }

        public Criteria andApplyDepartmentLessThanOrEqualTo(String value) {
            addCriterion("apply_department <=", value, "applyDepartment");
            return (Criteria) this;
        }

        public Criteria andApplyDepartmentLike(String value) {
            addCriterion("apply_department like", value, "applyDepartment");
            return (Criteria) this;
        }

        public Criteria andApplyDepartmentNotLike(String value) {
            addCriterion("apply_department not like", value, "applyDepartment");
            return (Criteria) this;
        }

        public Criteria andApplyDepartmentIn(List<String> values) {
            addCriterion("apply_department in", values, "applyDepartment");
            return (Criteria) this;
        }

        public Criteria andApplyDepartmentNotIn(List<String> values) {
            addCriterion("apply_department not in", values, "applyDepartment");
            return (Criteria) this;
        }

        public Criteria andApplyDepartmentBetween(String value1, String value2) {
            addCriterion("apply_department between", value1, value2, "applyDepartment");
            return (Criteria) this;
        }

        public Criteria andApplyDepartmentNotBetween(String value1, String value2) {
            addCriterion("apply_department not between", value1, value2, "applyDepartment");
            return (Criteria) this;
        }

        public Criteria andHistotyAccessIsNull() {
            addCriterion("histoty_access is null");
            return (Criteria) this;
        }

        public Criteria andHistotyAccessIsNotNull() {
            addCriterion("histoty_access is not null");
            return (Criteria) this;
        }

        public Criteria andHistotyAccessEqualTo(String value) {
            addCriterion("histoty_access =", value, "histotyAccess");
            return (Criteria) this;
        }

        public Criteria andHistotyAccessNotEqualTo(String value) {
            addCriterion("histoty_access <>", value, "histotyAccess");
            return (Criteria) this;
        }

        public Criteria andHistotyAccessGreaterThan(String value) {
            addCriterion("histoty_access >", value, "histotyAccess");
            return (Criteria) this;
        }

        public Criteria andHistotyAccessGreaterThanOrEqualTo(String value) {
            addCriterion("histoty_access >=", value, "histotyAccess");
            return (Criteria) this;
        }

        public Criteria andHistotyAccessLessThan(String value) {
            addCriterion("histoty_access <", value, "histotyAccess");
            return (Criteria) this;
        }

        public Criteria andHistotyAccessLessThanOrEqualTo(String value) {
            addCriterion("histoty_access <=", value, "histotyAccess");
            return (Criteria) this;
        }

        public Criteria andHistotyAccessLike(String value) {
            addCriterion("histoty_access like", value, "histotyAccess");
            return (Criteria) this;
        }

        public Criteria andHistotyAccessNotLike(String value) {
            addCriterion("histoty_access not like", value, "histotyAccess");
            return (Criteria) this;
        }

        public Criteria andHistotyAccessIn(List<String> values) {
            addCriterion("histoty_access in", values, "histotyAccess");
            return (Criteria) this;
        }

        public Criteria andHistotyAccessNotIn(List<String> values) {
            addCriterion("histoty_access not in", values, "histotyAccess");
            return (Criteria) this;
        }

        public Criteria andHistotyAccessBetween(String value1, String value2) {
            addCriterion("histoty_access between", value1, value2, "histotyAccess");
            return (Criteria) this;
        }

        public Criteria andHistotyAccessNotBetween(String value1, String value2) {
            addCriterion("histoty_access not between", value1, value2, "histotyAccess");
            return (Criteria) this;
        }

        public Criteria andHistoryRecordIsNull() {
            addCriterion("history_record is null");
            return (Criteria) this;
        }

        public Criteria andHistoryRecordIsNotNull() {
            addCriterion("history_record is not null");
            return (Criteria) this;
        }

        public Criteria andHistoryRecordEqualTo(String value) {
            addCriterion("history_record =", value, "historyRecord");
            return (Criteria) this;
        }

        public Criteria andHistoryRecordNotEqualTo(String value) {
            addCriterion("history_record <>", value, "historyRecord");
            return (Criteria) this;
        }

        public Criteria andHistoryRecordGreaterThan(String value) {
            addCriterion("history_record >", value, "historyRecord");
            return (Criteria) this;
        }

        public Criteria andHistoryRecordGreaterThanOrEqualTo(String value) {
            addCriterion("history_record >=", value, "historyRecord");
            return (Criteria) this;
        }

        public Criteria andHistoryRecordLessThan(String value) {
            addCriterion("history_record <", value, "historyRecord");
            return (Criteria) this;
        }

        public Criteria andHistoryRecordLessThanOrEqualTo(String value) {
            addCriterion("history_record <=", value, "historyRecord");
            return (Criteria) this;
        }

        public Criteria andHistoryRecordLike(String value) {
            addCriterion("history_record like", value, "historyRecord");
            return (Criteria) this;
        }

        public Criteria andHistoryRecordNotLike(String value) {
            addCriterion("history_record not like", value, "historyRecord");
            return (Criteria) this;
        }

        public Criteria andHistoryRecordIn(List<String> values) {
            addCriterion("history_record in", values, "historyRecord");
            return (Criteria) this;
        }

        public Criteria andHistoryRecordNotIn(List<String> values) {
            addCriterion("history_record not in", values, "historyRecord");
            return (Criteria) this;
        }

        public Criteria andHistoryRecordBetween(String value1, String value2) {
            addCriterion("history_record between", value1, value2, "historyRecord");
            return (Criteria) this;
        }

        public Criteria andHistoryRecordNotBetween(String value1, String value2) {
            addCriterion("history_record not between", value1, value2, "historyRecord");
            return (Criteria) this;
        }

        public Criteria andNowAccessIsNull() {
            addCriterion("now_access is null");
            return (Criteria) this;
        }

        public Criteria andNowAccessIsNotNull() {
            addCriterion("now_access is not null");
            return (Criteria) this;
        }

        public Criteria andNowAccessEqualTo(String value) {
            addCriterion("now_access =", value, "nowAccess");
            return (Criteria) this;
        }

        public Criteria andNowAccessNotEqualTo(String value) {
            addCriterion("now_access <>", value, "nowAccess");
            return (Criteria) this;
        }

        public Criteria andNowAccessGreaterThan(String value) {
            addCriterion("now_access >", value, "nowAccess");
            return (Criteria) this;
        }

        public Criteria andNowAccessGreaterThanOrEqualTo(String value) {
            addCriterion("now_access >=", value, "nowAccess");
            return (Criteria) this;
        }

        public Criteria andNowAccessLessThan(String value) {
            addCriterion("now_access <", value, "nowAccess");
            return (Criteria) this;
        }

        public Criteria andNowAccessLessThanOrEqualTo(String value) {
            addCriterion("now_access <=", value, "nowAccess");
            return (Criteria) this;
        }

        public Criteria andNowAccessLike(String value) {
            addCriterion("now_access like", value, "nowAccess");
            return (Criteria) this;
        }

        public Criteria andNowAccessNotLike(String value) {
            addCriterion("now_access not like", value, "nowAccess");
            return (Criteria) this;
        }

        public Criteria andNowAccessIn(List<String> values) {
            addCriterion("now_access in", values, "nowAccess");
            return (Criteria) this;
        }

        public Criteria andNowAccessNotIn(List<String> values) {
            addCriterion("now_access not in", values, "nowAccess");
            return (Criteria) this;
        }

        public Criteria andNowAccessBetween(String value1, String value2) {
            addCriterion("now_access between", value1, value2, "nowAccess");
            return (Criteria) this;
        }

        public Criteria andNowAccessNotBetween(String value1, String value2) {
            addCriterion("now_access not between", value1, value2, "nowAccess");
            return (Criteria) this;
        }

        public Criteria andUsedTimeIsNull() {
            addCriterion("used_time is null");
            return (Criteria) this;
        }

        public Criteria andUsedTimeIsNotNull() {
            addCriterion("used_time is not null");
            return (Criteria) this;
        }

        public Criteria andUsedTimeEqualTo(String value) {
            addCriterion("used_time =", value, "usedTime");
            return (Criteria) this;
        }

        public Criteria andUsedTimeNotEqualTo(String value) {
            addCriterion("used_time <>", value, "usedTime");
            return (Criteria) this;
        }

        public Criteria andUsedTimeGreaterThan(String value) {
            addCriterion("used_time >", value, "usedTime");
            return (Criteria) this;
        }

        public Criteria andUsedTimeGreaterThanOrEqualTo(String value) {
            addCriterion("used_time >=", value, "usedTime");
            return (Criteria) this;
        }

        public Criteria andUsedTimeLessThan(String value) {
            addCriterion("used_time <", value, "usedTime");
            return (Criteria) this;
        }

        public Criteria andUsedTimeLessThanOrEqualTo(String value) {
            addCriterion("used_time <=", value, "usedTime");
            return (Criteria) this;
        }

        public Criteria andUsedTimeLike(String value) {
            addCriterion("used_time like", value, "usedTime");
            return (Criteria) this;
        }

        public Criteria andUsedTimeNotLike(String value) {
            addCriterion("used_time not like", value, "usedTime");
            return (Criteria) this;
        }

        public Criteria andUsedTimeIn(List<String> values) {
            addCriterion("used_time in", values, "usedTime");
            return (Criteria) this;
        }

        public Criteria andUsedTimeNotIn(List<String> values) {
            addCriterion("used_time not in", values, "usedTime");
            return (Criteria) this;
        }

        public Criteria andUsedTimeBetween(String value1, String value2) {
            addCriterion("used_time between", value1, value2, "usedTime");
            return (Criteria) this;
        }

        public Criteria andUsedTimeNotBetween(String value1, String value2) {
            addCriterion("used_time not between", value1, value2, "usedTime");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNull() {
            addCriterion("department is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNotNull() {
            addCriterion("department is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentEqualTo(String value) {
            addCriterion("department =", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotEqualTo(String value) {
            addCriterion("department <>", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThan(String value) {
            addCriterion("department >", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("department >=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThan(String value) {
            addCriterion("department <", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThanOrEqualTo(String value) {
            addCriterion("department <=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLike(String value) {
            addCriterion("department like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotLike(String value) {
            addCriterion("department not like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentIn(List<String> values) {
            addCriterion("department in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotIn(List<String> values) {
            addCriterion("department not in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentBetween(String value1, String value2) {
            addCriterion("department between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotBetween(String value1, String value2) {
            addCriterion("department not between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andProjectIsNull() {
            addCriterion("project is null");
            return (Criteria) this;
        }

        public Criteria andProjectIsNotNull() {
            addCriterion("project is not null");
            return (Criteria) this;
        }

        public Criteria andProjectEqualTo(String value) {
            addCriterion("project =", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotEqualTo(String value) {
            addCriterion("project <>", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectGreaterThan(String value) {
            addCriterion("project >", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectGreaterThanOrEqualTo(String value) {
            addCriterion("project >=", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectLessThan(String value) {
            addCriterion("project <", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectLessThanOrEqualTo(String value) {
            addCriterion("project <=", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectLike(String value) {
            addCriterion("project like", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotLike(String value) {
            addCriterion("project not like", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectIn(List<String> values) {
            addCriterion("project in", values, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotIn(List<String> values) {
            addCriterion("project not in", values, "project");
            return (Criteria) this;
        }

        public Criteria andProjectBetween(String value1, String value2) {
            addCriterion("project between", value1, value2, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotBetween(String value1, String value2) {
            addCriterion("project not between", value1, value2, "project");
            return (Criteria) this;
        }

        public Criteria andOrderNameIsNull() {
            addCriterion("order_name is null");
            return (Criteria) this;
        }

        public Criteria andOrderNameIsNotNull() {
            addCriterion("order_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNameEqualTo(String value) {
            addCriterion("order_name =", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameNotEqualTo(String value) {
            addCriterion("order_name <>", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameGreaterThan(String value) {
            addCriterion("order_name >", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameGreaterThanOrEqualTo(String value) {
            addCriterion("order_name >=", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameLessThan(String value) {
            addCriterion("order_name <", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameLessThanOrEqualTo(String value) {
            addCriterion("order_name <=", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameLike(String value) {
            addCriterion("order_name like", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameNotLike(String value) {
            addCriterion("order_name not like", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameIn(List<String> values) {
            addCriterion("order_name in", values, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameNotIn(List<String> values) {
            addCriterion("order_name not in", values, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameBetween(String value1, String value2) {
            addCriterion("order_name between", value1, value2, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameNotBetween(String value1, String value2) {
            addCriterion("order_name not between", value1, value2, "orderName");
            return (Criteria) this;
        }

        public Criteria andOfficeSiteIsNull() {
            addCriterion("office_site is null");
            return (Criteria) this;
        }

        public Criteria andOfficeSiteIsNotNull() {
            addCriterion("office_site is not null");
            return (Criteria) this;
        }

        public Criteria andOfficeSiteEqualTo(String value) {
            addCriterion("office_site =", value, "officeSite");
            return (Criteria) this;
        }

        public Criteria andOfficeSiteNotEqualTo(String value) {
            addCriterion("office_site <>", value, "officeSite");
            return (Criteria) this;
        }

        public Criteria andOfficeSiteGreaterThan(String value) {
            addCriterion("office_site >", value, "officeSite");
            return (Criteria) this;
        }

        public Criteria andOfficeSiteGreaterThanOrEqualTo(String value) {
            addCriterion("office_site >=", value, "officeSite");
            return (Criteria) this;
        }

        public Criteria andOfficeSiteLessThan(String value) {
            addCriterion("office_site <", value, "officeSite");
            return (Criteria) this;
        }

        public Criteria andOfficeSiteLessThanOrEqualTo(String value) {
            addCriterion("office_site <=", value, "officeSite");
            return (Criteria) this;
        }

        public Criteria andOfficeSiteLike(String value) {
            addCriterion("office_site like", value, "officeSite");
            return (Criteria) this;
        }

        public Criteria andOfficeSiteNotLike(String value) {
            addCriterion("office_site not like", value, "officeSite");
            return (Criteria) this;
        }

        public Criteria andOfficeSiteIn(List<String> values) {
            addCriterion("office_site in", values, "officeSite");
            return (Criteria) this;
        }

        public Criteria andOfficeSiteNotIn(List<String> values) {
            addCriterion("office_site not in", values, "officeSite");
            return (Criteria) this;
        }

        public Criteria andOfficeSiteBetween(String value1, String value2) {
            addCriterion("office_site between", value1, value2, "officeSite");
            return (Criteria) this;
        }

        public Criteria andOfficeSiteNotBetween(String value1, String value2) {
            addCriterion("office_site not between", value1, value2, "officeSite");
            return (Criteria) this;
        }

        public Criteria andCostClassIsNull() {
            addCriterion("cost_class is null");
            return (Criteria) this;
        }

        public Criteria andCostClassIsNotNull() {
            addCriterion("cost_class is not null");
            return (Criteria) this;
        }

        public Criteria andCostClassEqualTo(String value) {
            addCriterion("cost_class =", value, "costClass");
            return (Criteria) this;
        }

        public Criteria andCostClassNotEqualTo(String value) {
            addCriterion("cost_class <>", value, "costClass");
            return (Criteria) this;
        }

        public Criteria andCostClassGreaterThan(String value) {
            addCriterion("cost_class >", value, "costClass");
            return (Criteria) this;
        }

        public Criteria andCostClassGreaterThanOrEqualTo(String value) {
            addCriterion("cost_class >=", value, "costClass");
            return (Criteria) this;
        }

        public Criteria andCostClassLessThan(String value) {
            addCriterion("cost_class <", value, "costClass");
            return (Criteria) this;
        }

        public Criteria andCostClassLessThanOrEqualTo(String value) {
            addCriterion("cost_class <=", value, "costClass");
            return (Criteria) this;
        }

        public Criteria andCostClassLike(String value) {
            addCriterion("cost_class like", value, "costClass");
            return (Criteria) this;
        }

        public Criteria andCostClassNotLike(String value) {
            addCriterion("cost_class not like", value, "costClass");
            return (Criteria) this;
        }

        public Criteria andCostClassIn(List<String> values) {
            addCriterion("cost_class in", values, "costClass");
            return (Criteria) this;
        }

        public Criteria andCostClassNotIn(List<String> values) {
            addCriterion("cost_class not in", values, "costClass");
            return (Criteria) this;
        }

        public Criteria andCostClassBetween(String value1, String value2) {
            addCriterion("cost_class between", value1, value2, "costClass");
            return (Criteria) this;
        }

        public Criteria andCostClassNotBetween(String value1, String value2) {
            addCriterion("cost_class not between", value1, value2, "costClass");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIsNull() {
            addCriterion("receiver_name is null");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIsNotNull() {
            addCriterion("receiver_name is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverNameEqualTo(String value) {
            addCriterion("receiver_name =", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotEqualTo(String value) {
            addCriterion("receiver_name <>", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameGreaterThan(String value) {
            addCriterion("receiver_name >", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_name >=", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLessThan(String value) {
            addCriterion("receiver_name <", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLessThanOrEqualTo(String value) {
            addCriterion("receiver_name <=", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLike(String value) {
            addCriterion("receiver_name like", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotLike(String value) {
            addCriterion("receiver_name not like", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIn(List<String> values) {
            addCriterion("receiver_name in", values, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotIn(List<String> values) {
            addCriterion("receiver_name not in", values, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameBetween(String value1, String value2) {
            addCriterion("receiver_name between", value1, value2, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotBetween(String value1, String value2) {
            addCriterion("receiver_name not between", value1, value2, "receiverName");
            return (Criteria) this;
        }

        public Criteria andBankIsNull() {
            addCriterion("bank is null");
            return (Criteria) this;
        }

        public Criteria andBankIsNotNull() {
            addCriterion("bank is not null");
            return (Criteria) this;
        }

        public Criteria andBankEqualTo(String value) {
            addCriterion("bank =", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotEqualTo(String value) {
            addCriterion("bank <>", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankGreaterThan(String value) {
            addCriterion("bank >", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankGreaterThanOrEqualTo(String value) {
            addCriterion("bank >=", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankLessThan(String value) {
            addCriterion("bank <", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankLessThanOrEqualTo(String value) {
            addCriterion("bank <=", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankLike(String value) {
            addCriterion("bank like", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotLike(String value) {
            addCriterion("bank not like", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankIn(List<String> values) {
            addCriterion("bank in", values, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotIn(List<String> values) {
            addCriterion("bank not in", values, "bank");
            return (Criteria) this;
        }

        public Criteria andBankBetween(String value1, String value2) {
            addCriterion("bank between", value1, value2, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotBetween(String value1, String value2) {
            addCriterion("bank not between", value1, value2, "bank");
            return (Criteria) this;
        }

        public Criteria andBrachBankIsNull() {
            addCriterion("brach_bank is null");
            return (Criteria) this;
        }

        public Criteria andBrachBankIsNotNull() {
            addCriterion("brach_bank is not null");
            return (Criteria) this;
        }

        public Criteria andBrachBankEqualTo(String value) {
            addCriterion("brach_bank =", value, "brachBank");
            return (Criteria) this;
        }

        public Criteria andBrachBankNotEqualTo(String value) {
            addCriterion("brach_bank <>", value, "brachBank");
            return (Criteria) this;
        }

        public Criteria andBrachBankGreaterThan(String value) {
            addCriterion("brach_bank >", value, "brachBank");
            return (Criteria) this;
        }

        public Criteria andBrachBankGreaterThanOrEqualTo(String value) {
            addCriterion("brach_bank >=", value, "brachBank");
            return (Criteria) this;
        }

        public Criteria andBrachBankLessThan(String value) {
            addCriterion("brach_bank <", value, "brachBank");
            return (Criteria) this;
        }

        public Criteria andBrachBankLessThanOrEqualTo(String value) {
            addCriterion("brach_bank <=", value, "brachBank");
            return (Criteria) this;
        }

        public Criteria andBrachBankLike(String value) {
            addCriterion("brach_bank like", value, "brachBank");
            return (Criteria) this;
        }

        public Criteria andBrachBankNotLike(String value) {
            addCriterion("brach_bank not like", value, "brachBank");
            return (Criteria) this;
        }

        public Criteria andBrachBankIn(List<String> values) {
            addCriterion("brach_bank in", values, "brachBank");
            return (Criteria) this;
        }

        public Criteria andBrachBankNotIn(List<String> values) {
            addCriterion("brach_bank not in", values, "brachBank");
            return (Criteria) this;
        }

        public Criteria andBrachBankBetween(String value1, String value2) {
            addCriterion("brach_bank between", value1, value2, "brachBank");
            return (Criteria) this;
        }

        public Criteria andBrachBankNotBetween(String value1, String value2) {
            addCriterion("brach_bank not between", value1, value2, "brachBank");
            return (Criteria) this;
        }

        public Criteria andBankAccountIsNull() {
            addCriterion("bank_account is null");
            return (Criteria) this;
        }

        public Criteria andBankAccountIsNotNull() {
            addCriterion("bank_account is not null");
            return (Criteria) this;
        }

        public Criteria andBankAccountEqualTo(String value) {
            addCriterion("bank_account =", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotEqualTo(String value) {
            addCriterion("bank_account <>", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountGreaterThan(String value) {
            addCriterion("bank_account >", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountGreaterThanOrEqualTo(String value) {
            addCriterion("bank_account >=", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLessThan(String value) {
            addCriterion("bank_account <", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLessThanOrEqualTo(String value) {
            addCriterion("bank_account <=", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLike(String value) {
            addCriterion("bank_account like", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotLike(String value) {
            addCriterion("bank_account not like", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountIn(List<String> values) {
            addCriterion("bank_account in", values, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotIn(List<String> values) {
            addCriterion("bank_account not in", values, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountBetween(String value1, String value2) {
            addCriterion("bank_account between", value1, value2, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotBetween(String value1, String value2) {
            addCriterion("bank_account not between", value1, value2, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIsNull() {
            addCriterion("total_money is null");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIsNotNull() {
            addCriterion("total_money is not null");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyEqualTo(String value) {
            addCriterion("total_money =", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotEqualTo(String value) {
            addCriterion("total_money <>", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyGreaterThan(String value) {
            addCriterion("total_money >", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("total_money >=", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyLessThan(String value) {
            addCriterion("total_money <", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyLessThanOrEqualTo(String value) {
            addCriterion("total_money <=", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyLike(String value) {
            addCriterion("total_money like", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotLike(String value) {
            addCriterion("total_money not like", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIn(List<String> values) {
            addCriterion("total_money in", values, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotIn(List<String> values) {
            addCriterion("total_money not in", values, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyBetween(String value1, String value2) {
            addCriterion("total_money between", value1, value2, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotBetween(String value1, String value2) {
            addCriterion("total_money not between", value1, value2, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyUpperIsNull() {
            addCriterion("total_money_upper is null");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyUpperIsNotNull() {
            addCriterion("total_money_upper is not null");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyUpperEqualTo(String value) {
            addCriterion("total_money_upper =", value, "totalMoneyUpper");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyUpperNotEqualTo(String value) {
            addCriterion("total_money_upper <>", value, "totalMoneyUpper");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyUpperGreaterThan(String value) {
            addCriterion("total_money_upper >", value, "totalMoneyUpper");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyUpperGreaterThanOrEqualTo(String value) {
            addCriterion("total_money_upper >=", value, "totalMoneyUpper");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyUpperLessThan(String value) {
            addCriterion("total_money_upper <", value, "totalMoneyUpper");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyUpperLessThanOrEqualTo(String value) {
            addCriterion("total_money_upper <=", value, "totalMoneyUpper");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyUpperLike(String value) {
            addCriterion("total_money_upper like", value, "totalMoneyUpper");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyUpperNotLike(String value) {
            addCriterion("total_money_upper not like", value, "totalMoneyUpper");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyUpperIn(List<String> values) {
            addCriterion("total_money_upper in", values, "totalMoneyUpper");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyUpperNotIn(List<String> values) {
            addCriterion("total_money_upper not in", values, "totalMoneyUpper");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyUpperBetween(String value1, String value2) {
            addCriterion("total_money_upper between", value1, value2, "totalMoneyUpper");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyUpperNotBetween(String value1, String value2) {
            addCriterion("total_money_upper not between", value1, value2, "totalMoneyUpper");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andInvoiceIsNull() {
            addCriterion("invoice is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceIsNotNull() {
            addCriterion("invoice is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceEqualTo(String value) {
            addCriterion("invoice =", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceNotEqualTo(String value) {
            addCriterion("invoice <>", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceGreaterThan(String value) {
            addCriterion("invoice >", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceGreaterThanOrEqualTo(String value) {
            addCriterion("invoice >=", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceLessThan(String value) {
            addCriterion("invoice <", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceLessThanOrEqualTo(String value) {
            addCriterion("invoice <=", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceLike(String value) {
            addCriterion("invoice like", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceNotLike(String value) {
            addCriterion("invoice not like", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceIn(List<String> values) {
            addCriterion("invoice in", values, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceNotIn(List<String> values) {
            addCriterion("invoice not in", values, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceBetween(String value1, String value2) {
            addCriterion("invoice between", value1, value2, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceNotBetween(String value1, String value2) {
            addCriterion("invoice not between", value1, value2, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceClassIsNull() {
            addCriterion("invoice_class is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceClassIsNotNull() {
            addCriterion("invoice_class is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceClassEqualTo(String value) {
            addCriterion("invoice_class =", value, "invoiceClass");
            return (Criteria) this;
        }

        public Criteria andInvoiceClassNotEqualTo(String value) {
            addCriterion("invoice_class <>", value, "invoiceClass");
            return (Criteria) this;
        }

        public Criteria andInvoiceClassGreaterThan(String value) {
            addCriterion("invoice_class >", value, "invoiceClass");
            return (Criteria) this;
        }

        public Criteria andInvoiceClassGreaterThanOrEqualTo(String value) {
            addCriterion("invoice_class >=", value, "invoiceClass");
            return (Criteria) this;
        }

        public Criteria andInvoiceClassLessThan(String value) {
            addCriterion("invoice_class <", value, "invoiceClass");
            return (Criteria) this;
        }

        public Criteria andInvoiceClassLessThanOrEqualTo(String value) {
            addCriterion("invoice_class <=", value, "invoiceClass");
            return (Criteria) this;
        }

        public Criteria andInvoiceClassLike(String value) {
            addCriterion("invoice_class like", value, "invoiceClass");
            return (Criteria) this;
        }

        public Criteria andInvoiceClassNotLike(String value) {
            addCriterion("invoice_class not like", value, "invoiceClass");
            return (Criteria) this;
        }

        public Criteria andInvoiceClassIn(List<String> values) {
            addCriterion("invoice_class in", values, "invoiceClass");
            return (Criteria) this;
        }

        public Criteria andInvoiceClassNotIn(List<String> values) {
            addCriterion("invoice_class not in", values, "invoiceClass");
            return (Criteria) this;
        }

        public Criteria andInvoiceClassBetween(String value1, String value2) {
            addCriterion("invoice_class between", value1, value2, "invoiceClass");
            return (Criteria) this;
        }

        public Criteria andInvoiceClassNotBetween(String value1, String value2) {
            addCriterion("invoice_class not between", value1, value2, "invoiceClass");
            return (Criteria) this;
        }

        public Criteria andInvoiceCodeIsNull() {
            addCriterion("invoice_code is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceCodeIsNotNull() {
            addCriterion("invoice_code is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceCodeEqualTo(String value) {
            addCriterion("invoice_code =", value, "invoiceCode");
            return (Criteria) this;
        }

        public Criteria andInvoiceCodeNotEqualTo(String value) {
            addCriterion("invoice_code <>", value, "invoiceCode");
            return (Criteria) this;
        }

        public Criteria andInvoiceCodeGreaterThan(String value) {
            addCriterion("invoice_code >", value, "invoiceCode");
            return (Criteria) this;
        }

        public Criteria andInvoiceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("invoice_code >=", value, "invoiceCode");
            return (Criteria) this;
        }

        public Criteria andInvoiceCodeLessThan(String value) {
            addCriterion("invoice_code <", value, "invoiceCode");
            return (Criteria) this;
        }

        public Criteria andInvoiceCodeLessThanOrEqualTo(String value) {
            addCriterion("invoice_code <=", value, "invoiceCode");
            return (Criteria) this;
        }

        public Criteria andInvoiceCodeLike(String value) {
            addCriterion("invoice_code like", value, "invoiceCode");
            return (Criteria) this;
        }

        public Criteria andInvoiceCodeNotLike(String value) {
            addCriterion("invoice_code not like", value, "invoiceCode");
            return (Criteria) this;
        }

        public Criteria andInvoiceCodeIn(List<String> values) {
            addCriterion("invoice_code in", values, "invoiceCode");
            return (Criteria) this;
        }

        public Criteria andInvoiceCodeNotIn(List<String> values) {
            addCriterion("invoice_code not in", values, "invoiceCode");
            return (Criteria) this;
        }

        public Criteria andInvoiceCodeBetween(String value1, String value2) {
            addCriterion("invoice_code between", value1, value2, "invoiceCode");
            return (Criteria) this;
        }

        public Criteria andInvoiceCodeNotBetween(String value1, String value2) {
            addCriterion("invoice_code not between", value1, value2, "invoiceCode");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberIsNull() {
            addCriterion("invoice_number is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberIsNotNull() {
            addCriterion("invoice_number is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberEqualTo(String value) {
            addCriterion("invoice_number =", value, "invoiceNumber");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberNotEqualTo(String value) {
            addCriterion("invoice_number <>", value, "invoiceNumber");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberGreaterThan(String value) {
            addCriterion("invoice_number >", value, "invoiceNumber");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberGreaterThanOrEqualTo(String value) {
            addCriterion("invoice_number >=", value, "invoiceNumber");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberLessThan(String value) {
            addCriterion("invoice_number <", value, "invoiceNumber");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberLessThanOrEqualTo(String value) {
            addCriterion("invoice_number <=", value, "invoiceNumber");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberLike(String value) {
            addCriterion("invoice_number like", value, "invoiceNumber");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberNotLike(String value) {
            addCriterion("invoice_number not like", value, "invoiceNumber");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberIn(List<String> values) {
            addCriterion("invoice_number in", values, "invoiceNumber");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberNotIn(List<String> values) {
            addCriterion("invoice_number not in", values, "invoiceNumber");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberBetween(String value1, String value2) {
            addCriterion("invoice_number between", value1, value2, "invoiceNumber");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberNotBetween(String value1, String value2) {
            addCriterion("invoice_number not between", value1, value2, "invoiceNumber");
            return (Criteria) this;
        }

        public Criteria andInvoiceTimeIsNull() {
            addCriterion("invoice_time is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTimeIsNotNull() {
            addCriterion("invoice_time is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTimeEqualTo(String value) {
            addCriterion("invoice_time =", value, "invoiceTime");
            return (Criteria) this;
        }

        public Criteria andInvoiceTimeNotEqualTo(String value) {
            addCriterion("invoice_time <>", value, "invoiceTime");
            return (Criteria) this;
        }

        public Criteria andInvoiceTimeGreaterThan(String value) {
            addCriterion("invoice_time >", value, "invoiceTime");
            return (Criteria) this;
        }

        public Criteria andInvoiceTimeGreaterThanOrEqualTo(String value) {
            addCriterion("invoice_time >=", value, "invoiceTime");
            return (Criteria) this;
        }

        public Criteria andInvoiceTimeLessThan(String value) {
            addCriterion("invoice_time <", value, "invoiceTime");
            return (Criteria) this;
        }

        public Criteria andInvoiceTimeLessThanOrEqualTo(String value) {
            addCriterion("invoice_time <=", value, "invoiceTime");
            return (Criteria) this;
        }

        public Criteria andInvoiceTimeLike(String value) {
            addCriterion("invoice_time like", value, "invoiceTime");
            return (Criteria) this;
        }

        public Criteria andInvoiceTimeNotLike(String value) {
            addCriterion("invoice_time not like", value, "invoiceTime");
            return (Criteria) this;
        }

        public Criteria andInvoiceTimeIn(List<String> values) {
            addCriterion("invoice_time in", values, "invoiceTime");
            return (Criteria) this;
        }

        public Criteria andInvoiceTimeNotIn(List<String> values) {
            addCriterion("invoice_time not in", values, "invoiceTime");
            return (Criteria) this;
        }

        public Criteria andInvoiceTimeBetween(String value1, String value2) {
            addCriterion("invoice_time between", value1, value2, "invoiceTime");
            return (Criteria) this;
        }

        public Criteria andInvoiceTimeNotBetween(String value1, String value2) {
            addCriterion("invoice_time not between", value1, value2, "invoiceTime");
            return (Criteria) this;
        }

        public Criteria andReceiveOrgIsNull() {
            addCriterion("receive_org is null");
            return (Criteria) this;
        }

        public Criteria andReceiveOrgIsNotNull() {
            addCriterion("receive_org is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveOrgEqualTo(String value) {
            addCriterion("receive_org =", value, "receiveOrg");
            return (Criteria) this;
        }

        public Criteria andReceiveOrgNotEqualTo(String value) {
            addCriterion("receive_org <>", value, "receiveOrg");
            return (Criteria) this;
        }

        public Criteria andReceiveOrgGreaterThan(String value) {
            addCriterion("receive_org >", value, "receiveOrg");
            return (Criteria) this;
        }

        public Criteria andReceiveOrgGreaterThanOrEqualTo(String value) {
            addCriterion("receive_org >=", value, "receiveOrg");
            return (Criteria) this;
        }

        public Criteria andReceiveOrgLessThan(String value) {
            addCriterion("receive_org <", value, "receiveOrg");
            return (Criteria) this;
        }

        public Criteria andReceiveOrgLessThanOrEqualTo(String value) {
            addCriterion("receive_org <=", value, "receiveOrg");
            return (Criteria) this;
        }

        public Criteria andReceiveOrgLike(String value) {
            addCriterion("receive_org like", value, "receiveOrg");
            return (Criteria) this;
        }

        public Criteria andReceiveOrgNotLike(String value) {
            addCriterion("receive_org not like", value, "receiveOrg");
            return (Criteria) this;
        }

        public Criteria andReceiveOrgIn(List<String> values) {
            addCriterion("receive_org in", values, "receiveOrg");
            return (Criteria) this;
        }

        public Criteria andReceiveOrgNotIn(List<String> values) {
            addCriterion("receive_org not in", values, "receiveOrg");
            return (Criteria) this;
        }

        public Criteria andReceiveOrgBetween(String value1, String value2) {
            addCriterion("receive_org between", value1, value2, "receiveOrg");
            return (Criteria) this;
        }

        public Criteria andReceiveOrgNotBetween(String value1, String value2) {
            addCriterion("receive_org not between", value1, value2, "receiveOrg");
            return (Criteria) this;
        }

        public Criteria andReceiveOrgNumberIsNull() {
            addCriterion("receive_org_number is null");
            return (Criteria) this;
        }

        public Criteria andReceiveOrgNumberIsNotNull() {
            addCriterion("receive_org_number is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveOrgNumberEqualTo(String value) {
            addCriterion("receive_org_number =", value, "receiveOrgNumber");
            return (Criteria) this;
        }

        public Criteria andReceiveOrgNumberNotEqualTo(String value) {
            addCriterion("receive_org_number <>", value, "receiveOrgNumber");
            return (Criteria) this;
        }

        public Criteria andReceiveOrgNumberGreaterThan(String value) {
            addCriterion("receive_org_number >", value, "receiveOrgNumber");
            return (Criteria) this;
        }

        public Criteria andReceiveOrgNumberGreaterThanOrEqualTo(String value) {
            addCriterion("receive_org_number >=", value, "receiveOrgNumber");
            return (Criteria) this;
        }

        public Criteria andReceiveOrgNumberLessThan(String value) {
            addCriterion("receive_org_number <", value, "receiveOrgNumber");
            return (Criteria) this;
        }

        public Criteria andReceiveOrgNumberLessThanOrEqualTo(String value) {
            addCriterion("receive_org_number <=", value, "receiveOrgNumber");
            return (Criteria) this;
        }

        public Criteria andReceiveOrgNumberLike(String value) {
            addCriterion("receive_org_number like", value, "receiveOrgNumber");
            return (Criteria) this;
        }

        public Criteria andReceiveOrgNumberNotLike(String value) {
            addCriterion("receive_org_number not like", value, "receiveOrgNumber");
            return (Criteria) this;
        }

        public Criteria andReceiveOrgNumberIn(List<String> values) {
            addCriterion("receive_org_number in", values, "receiveOrgNumber");
            return (Criteria) this;
        }

        public Criteria andReceiveOrgNumberNotIn(List<String> values) {
            addCriterion("receive_org_number not in", values, "receiveOrgNumber");
            return (Criteria) this;
        }

        public Criteria andReceiveOrgNumberBetween(String value1, String value2) {
            addCriterion("receive_org_number between", value1, value2, "receiveOrgNumber");
            return (Criteria) this;
        }

        public Criteria andReceiveOrgNumberNotBetween(String value1, String value2) {
            addCriterion("receive_org_number not between", value1, value2, "receiveOrgNumber");
            return (Criteria) this;
        }

        public Criteria andReceiveMoneyIsNull() {
            addCriterion("receive_money is null");
            return (Criteria) this;
        }

        public Criteria andReceiveMoneyIsNotNull() {
            addCriterion("receive_money is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveMoneyEqualTo(String value) {
            addCriterion("receive_money =", value, "receiveMoney");
            return (Criteria) this;
        }

        public Criteria andReceiveMoneyNotEqualTo(String value) {
            addCriterion("receive_money <>", value, "receiveMoney");
            return (Criteria) this;
        }

        public Criteria andReceiveMoneyGreaterThan(String value) {
            addCriterion("receive_money >", value, "receiveMoney");
            return (Criteria) this;
        }

        public Criteria andReceiveMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("receive_money >=", value, "receiveMoney");
            return (Criteria) this;
        }

        public Criteria andReceiveMoneyLessThan(String value) {
            addCriterion("receive_money <", value, "receiveMoney");
            return (Criteria) this;
        }

        public Criteria andReceiveMoneyLessThanOrEqualTo(String value) {
            addCriterion("receive_money <=", value, "receiveMoney");
            return (Criteria) this;
        }

        public Criteria andReceiveMoneyLike(String value) {
            addCriterion("receive_money like", value, "receiveMoney");
            return (Criteria) this;
        }

        public Criteria andReceiveMoneyNotLike(String value) {
            addCriterion("receive_money not like", value, "receiveMoney");
            return (Criteria) this;
        }

        public Criteria andReceiveMoneyIn(List<String> values) {
            addCriterion("receive_money in", values, "receiveMoney");
            return (Criteria) this;
        }

        public Criteria andReceiveMoneyNotIn(List<String> values) {
            addCriterion("receive_money not in", values, "receiveMoney");
            return (Criteria) this;
        }

        public Criteria andReceiveMoneyBetween(String value1, String value2) {
            addCriterion("receive_money between", value1, value2, "receiveMoney");
            return (Criteria) this;
        }

        public Criteria andReceiveMoneyNotBetween(String value1, String value2) {
            addCriterion("receive_money not between", value1, value2, "receiveMoney");
            return (Criteria) this;
        }

        public Criteria andImageIsNull() {
            addCriterion("image is null");
            return (Criteria) this;
        }

        public Criteria andImageIsNotNull() {
            addCriterion("image is not null");
            return (Criteria) this;
        }

        public Criteria andImageEqualTo(String value) {
            addCriterion("image =", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotEqualTo(String value) {
            addCriterion("image <>", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThan(String value) {
            addCriterion("image >", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThanOrEqualTo(String value) {
            addCriterion("image >=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThan(String value) {
            addCriterion("image <", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThanOrEqualTo(String value) {
            addCriterion("image <=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLike(String value) {
            addCriterion("image like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotLike(String value) {
            addCriterion("image not like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageIn(List<String> values) {
            addCriterion("image in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotIn(List<String> values) {
            addCriterion("image not in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageBetween(String value1, String value2) {
            addCriterion("image between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotBetween(String value1, String value2) {
            addCriterion("image not between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andMoneyMonthIsNull() {
            addCriterion("money_month is null");
            return (Criteria) this;
        }

        public Criteria andMoneyMonthIsNotNull() {
            addCriterion("money_month is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyMonthEqualTo(String value) {
            addCriterion("money_month =", value, "moneyMonth");
            return (Criteria) this;
        }

        public Criteria andMoneyMonthNotEqualTo(String value) {
            addCriterion("money_month <>", value, "moneyMonth");
            return (Criteria) this;
        }

        public Criteria andMoneyMonthGreaterThan(String value) {
            addCriterion("money_month >", value, "moneyMonth");
            return (Criteria) this;
        }

        public Criteria andMoneyMonthGreaterThanOrEqualTo(String value) {
            addCriterion("money_month >=", value, "moneyMonth");
            return (Criteria) this;
        }

        public Criteria andMoneyMonthLessThan(String value) {
            addCriterion("money_month <", value, "moneyMonth");
            return (Criteria) this;
        }

        public Criteria andMoneyMonthLessThanOrEqualTo(String value) {
            addCriterion("money_month <=", value, "moneyMonth");
            return (Criteria) this;
        }

        public Criteria andMoneyMonthLike(String value) {
            addCriterion("money_month like", value, "moneyMonth");
            return (Criteria) this;
        }

        public Criteria andMoneyMonthNotLike(String value) {
            addCriterion("money_month not like", value, "moneyMonth");
            return (Criteria) this;
        }

        public Criteria andMoneyMonthIn(List<String> values) {
            addCriterion("money_month in", values, "moneyMonth");
            return (Criteria) this;
        }

        public Criteria andMoneyMonthNotIn(List<String> values) {
            addCriterion("money_month not in", values, "moneyMonth");
            return (Criteria) this;
        }

        public Criteria andMoneyMonthBetween(String value1, String value2) {
            addCriterion("money_month between", value1, value2, "moneyMonth");
            return (Criteria) this;
        }

        public Criteria andMoneyMonthNotBetween(String value1, String value2) {
            addCriterion("money_month not between", value1, value2, "moneyMonth");
            return (Criteria) this;
        }

        public Criteria andBankCardImageIsNull() {
            addCriterion("bank_card_image is null");
            return (Criteria) this;
        }

        public Criteria andBankCardImageIsNotNull() {
            addCriterion("bank_card_image is not null");
            return (Criteria) this;
        }

        public Criteria andBankCardImageEqualTo(String value) {
            addCriterion("bank_card_image =", value, "bankCardImage");
            return (Criteria) this;
        }

        public Criteria andBankCardImageNotEqualTo(String value) {
            addCriterion("bank_card_image <>", value, "bankCardImage");
            return (Criteria) this;
        }

        public Criteria andBankCardImageGreaterThan(String value) {
            addCriterion("bank_card_image >", value, "bankCardImage");
            return (Criteria) this;
        }

        public Criteria andBankCardImageGreaterThanOrEqualTo(String value) {
            addCriterion("bank_card_image >=", value, "bankCardImage");
            return (Criteria) this;
        }

        public Criteria andBankCardImageLessThan(String value) {
            addCriterion("bank_card_image <", value, "bankCardImage");
            return (Criteria) this;
        }

        public Criteria andBankCardImageLessThanOrEqualTo(String value) {
            addCriterion("bank_card_image <=", value, "bankCardImage");
            return (Criteria) this;
        }

        public Criteria andBankCardImageLike(String value) {
            addCriterion("bank_card_image like", value, "bankCardImage");
            return (Criteria) this;
        }

        public Criteria andBankCardImageNotLike(String value) {
            addCriterion("bank_card_image not like", value, "bankCardImage");
            return (Criteria) this;
        }

        public Criteria andBankCardImageIn(List<String> values) {
            addCriterion("bank_card_image in", values, "bankCardImage");
            return (Criteria) this;
        }

        public Criteria andBankCardImageNotIn(List<String> values) {
            addCriterion("bank_card_image not in", values, "bankCardImage");
            return (Criteria) this;
        }

        public Criteria andBankCardImageBetween(String value1, String value2) {
            addCriterion("bank_card_image between", value1, value2, "bankCardImage");
            return (Criteria) this;
        }

        public Criteria andBankCardImageNotBetween(String value1, String value2) {
            addCriterion("bank_card_image not between", value1, value2, "bankCardImage");
            return (Criteria) this;
        }

        public Criteria andIsExportIsNull() {
            addCriterion("is_export is null");
            return (Criteria) this;
        }

        public Criteria andIsExportIsNotNull() {
            addCriterion("is_export is not null");
            return (Criteria) this;
        }

        public Criteria andIsExportEqualTo(String value) {
            addCriterion("is_export =", value, "isExport");
            return (Criteria) this;
        }

        public Criteria andIsExportNotEqualTo(String value) {
            addCriterion("is_export <>", value, "isExport");
            return (Criteria) this;
        }

        public Criteria andIsExportGreaterThan(String value) {
            addCriterion("is_export >", value, "isExport");
            return (Criteria) this;
        }

        public Criteria andIsExportGreaterThanOrEqualTo(String value) {
            addCriterion("is_export >=", value, "isExport");
            return (Criteria) this;
        }

        public Criteria andIsExportLessThan(String value) {
            addCriterion("is_export <", value, "isExport");
            return (Criteria) this;
        }

        public Criteria andIsExportLessThanOrEqualTo(String value) {
            addCriterion("is_export <=", value, "isExport");
            return (Criteria) this;
        }

        public Criteria andIsExportLike(String value) {
            addCriterion("is_export like", value, "isExport");
            return (Criteria) this;
        }

        public Criteria andIsExportNotLike(String value) {
            addCriterion("is_export not like", value, "isExport");
            return (Criteria) this;
        }

        public Criteria andIsExportIn(List<String> values) {
            addCriterion("is_export in", values, "isExport");
            return (Criteria) this;
        }

        public Criteria andIsExportNotIn(List<String> values) {
            addCriterion("is_export not in", values, "isExport");
            return (Criteria) this;
        }

        public Criteria andIsExportBetween(String value1, String value2) {
            addCriterion("is_export between", value1, value2, "isExport");
            return (Criteria) this;
        }

        public Criteria andIsExportNotBetween(String value1, String value2) {
            addCriterion("is_export not between", value1, value2, "isExport");
            return (Criteria) this;
        }

        public Criteria andImprotTimeIsNull() {
            addCriterion("improt_time is null");
            return (Criteria) this;
        }

        public Criteria andImprotTimeIsNotNull() {
            addCriterion("improt_time is not null");
            return (Criteria) this;
        }

        public Criteria andImprotTimeEqualTo(String value) {
            addCriterion("improt_time =", value, "improtTime");
            return (Criteria) this;
        }

        public Criteria andImprotTimeNotEqualTo(String value) {
            addCriterion("improt_time <>", value, "improtTime");
            return (Criteria) this;
        }

        public Criteria andImprotTimeGreaterThan(String value) {
            addCriterion("improt_time >", value, "improtTime");
            return (Criteria) this;
        }

        public Criteria andImprotTimeGreaterThanOrEqualTo(String value) {
            addCriterion("improt_time >=", value, "improtTime");
            return (Criteria) this;
        }

        public Criteria andImprotTimeLessThan(String value) {
            addCriterion("improt_time <", value, "improtTime");
            return (Criteria) this;
        }

        public Criteria andImprotTimeLessThanOrEqualTo(String value) {
            addCriterion("improt_time <=", value, "improtTime");
            return (Criteria) this;
        }

        public Criteria andImprotTimeLike(String value) {
            addCriterion("improt_time like", value, "improtTime");
            return (Criteria) this;
        }

        public Criteria andImprotTimeNotLike(String value) {
            addCriterion("improt_time not like", value, "improtTime");
            return (Criteria) this;
        }

        public Criteria andImprotTimeIn(List<String> values) {
            addCriterion("improt_time in", values, "improtTime");
            return (Criteria) this;
        }

        public Criteria andImprotTimeNotIn(List<String> values) {
            addCriterion("improt_time not in", values, "improtTime");
            return (Criteria) this;
        }

        public Criteria andImprotTimeBetween(String value1, String value2) {
            addCriterion("improt_time between", value1, value2, "improtTime");
            return (Criteria) this;
        }

        public Criteria andImprotTimeNotBetween(String value1, String value2) {
            addCriterion("improt_time not between", value1, value2, "improtTime");
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