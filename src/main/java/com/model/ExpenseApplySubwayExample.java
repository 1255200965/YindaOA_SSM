package com.model;

import java.util.ArrayList;
import java.util.List;

public class ExpenseApplySubwayExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExpenseApplySubwayExample() {
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

        public Criteria andAskStaffUserIdIsNull() {
            addCriterion("ask_staff_user_id is null");
            return (Criteria) this;
        }

        public Criteria andAskStaffUserIdIsNotNull() {
            addCriterion("ask_staff_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andAskStaffUserIdEqualTo(String value) {
            addCriterion("ask_staff_user_id =", value, "askStaffUserId");
            return (Criteria) this;
        }

        public Criteria andAskStaffUserIdNotEqualTo(String value) {
            addCriterion("ask_staff_user_id <>", value, "askStaffUserId");
            return (Criteria) this;
        }

        public Criteria andAskStaffUserIdGreaterThan(String value) {
            addCriterion("ask_staff_user_id >", value, "askStaffUserId");
            return (Criteria) this;
        }

        public Criteria andAskStaffUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("ask_staff_user_id >=", value, "askStaffUserId");
            return (Criteria) this;
        }

        public Criteria andAskStaffUserIdLessThan(String value) {
            addCriterion("ask_staff_user_id <", value, "askStaffUserId");
            return (Criteria) this;
        }

        public Criteria andAskStaffUserIdLessThanOrEqualTo(String value) {
            addCriterion("ask_staff_user_id <=", value, "askStaffUserId");
            return (Criteria) this;
        }

        public Criteria andAskStaffUserIdLike(String value) {
            addCriterion("ask_staff_user_id like", value, "askStaffUserId");
            return (Criteria) this;
        }

        public Criteria andAskStaffUserIdNotLike(String value) {
            addCriterion("ask_staff_user_id not like", value, "askStaffUserId");
            return (Criteria) this;
        }

        public Criteria andAskStaffUserIdIn(List<String> values) {
            addCriterion("ask_staff_user_id in", values, "askStaffUserId");
            return (Criteria) this;
        }

        public Criteria andAskStaffUserIdNotIn(List<String> values) {
            addCriterion("ask_staff_user_id not in", values, "askStaffUserId");
            return (Criteria) this;
        }

        public Criteria andAskStaffUserIdBetween(String value1, String value2) {
            addCriterion("ask_staff_user_id between", value1, value2, "askStaffUserId");
            return (Criteria) this;
        }

        public Criteria andAskStaffUserIdNotBetween(String value1, String value2) {
            addCriterion("ask_staff_user_id not between", value1, value2, "askStaffUserId");
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

        public Criteria andAskStaffDepartIsNull() {
            addCriterion("ask_staff_depart is null");
            return (Criteria) this;
        }

        public Criteria andAskStaffDepartIsNotNull() {
            addCriterion("ask_staff_depart is not null");
            return (Criteria) this;
        }

        public Criteria andAskStaffDepartEqualTo(String value) {
            addCriterion("ask_staff_depart =", value, "askStaffDepart");
            return (Criteria) this;
        }

        public Criteria andAskStaffDepartNotEqualTo(String value) {
            addCriterion("ask_staff_depart <>", value, "askStaffDepart");
            return (Criteria) this;
        }

        public Criteria andAskStaffDepartGreaterThan(String value) {
            addCriterion("ask_staff_depart >", value, "askStaffDepart");
            return (Criteria) this;
        }

        public Criteria andAskStaffDepartGreaterThanOrEqualTo(String value) {
            addCriterion("ask_staff_depart >=", value, "askStaffDepart");
            return (Criteria) this;
        }

        public Criteria andAskStaffDepartLessThan(String value) {
            addCriterion("ask_staff_depart <", value, "askStaffDepart");
            return (Criteria) this;
        }

        public Criteria andAskStaffDepartLessThanOrEqualTo(String value) {
            addCriterion("ask_staff_depart <=", value, "askStaffDepart");
            return (Criteria) this;
        }

        public Criteria andAskStaffDepartLike(String value) {
            addCriterion("ask_staff_depart like", value, "askStaffDepart");
            return (Criteria) this;
        }

        public Criteria andAskStaffDepartNotLike(String value) {
            addCriterion("ask_staff_depart not like", value, "askStaffDepart");
            return (Criteria) this;
        }

        public Criteria andAskStaffDepartIn(List<String> values) {
            addCriterion("ask_staff_depart in", values, "askStaffDepart");
            return (Criteria) this;
        }

        public Criteria andAskStaffDepartNotIn(List<String> values) {
            addCriterion("ask_staff_depart not in", values, "askStaffDepart");
            return (Criteria) this;
        }

        public Criteria andAskStaffDepartBetween(String value1, String value2) {
            addCriterion("ask_staff_depart between", value1, value2, "askStaffDepart");
            return (Criteria) this;
        }

        public Criteria andAskStaffDepartNotBetween(String value1, String value2) {
            addCriterion("ask_staff_depart not between", value1, value2, "askStaffDepart");
            return (Criteria) this;
        }

        public Criteria andAskMonthIsNull() {
            addCriterion("ask_month is null");
            return (Criteria) this;
        }

        public Criteria andAskMonthIsNotNull() {
            addCriterion("ask_month is not null");
            return (Criteria) this;
        }

        public Criteria andAskMonthEqualTo(String value) {
            addCriterion("ask_month =", value, "askMonth");
            return (Criteria) this;
        }

        public Criteria andAskMonthNotEqualTo(String value) {
            addCriterion("ask_month <>", value, "askMonth");
            return (Criteria) this;
        }

        public Criteria andAskMonthGreaterThan(String value) {
            addCriterion("ask_month >", value, "askMonth");
            return (Criteria) this;
        }

        public Criteria andAskMonthGreaterThanOrEqualTo(String value) {
            addCriterion("ask_month >=", value, "askMonth");
            return (Criteria) this;
        }

        public Criteria andAskMonthLessThan(String value) {
            addCriterion("ask_month <", value, "askMonth");
            return (Criteria) this;
        }

        public Criteria andAskMonthLessThanOrEqualTo(String value) {
            addCriterion("ask_month <=", value, "askMonth");
            return (Criteria) this;
        }

        public Criteria andAskMonthLike(String value) {
            addCriterion("ask_month like", value, "askMonth");
            return (Criteria) this;
        }

        public Criteria andAskMonthNotLike(String value) {
            addCriterion("ask_month not like", value, "askMonth");
            return (Criteria) this;
        }

        public Criteria andAskMonthIn(List<String> values) {
            addCriterion("ask_month in", values, "askMonth");
            return (Criteria) this;
        }

        public Criteria andAskMonthNotIn(List<String> values) {
            addCriterion("ask_month not in", values, "askMonth");
            return (Criteria) this;
        }

        public Criteria andAskMonthBetween(String value1, String value2) {
            addCriterion("ask_month between", value1, value2, "askMonth");
            return (Criteria) this;
        }

        public Criteria andAskMonthNotBetween(String value1, String value2) {
            addCriterion("ask_month not between", value1, value2, "askMonth");
            return (Criteria) this;
        }

        public Criteria andAskMoneyIsNull() {
            addCriterion("ask_money is null");
            return (Criteria) this;
        }

        public Criteria andAskMoneyIsNotNull() {
            addCriterion("ask_money is not null");
            return (Criteria) this;
        }

        public Criteria andAskMoneyEqualTo(String value) {
            addCriterion("ask_money =", value, "askMoney");
            return (Criteria) this;
        }

        public Criteria andAskMoneyNotEqualTo(String value) {
            addCriterion("ask_money <>", value, "askMoney");
            return (Criteria) this;
        }

        public Criteria andAskMoneyGreaterThan(String value) {
            addCriterion("ask_money >", value, "askMoney");
            return (Criteria) this;
        }

        public Criteria andAskMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("ask_money >=", value, "askMoney");
            return (Criteria) this;
        }

        public Criteria andAskMoneyLessThan(String value) {
            addCriterion("ask_money <", value, "askMoney");
            return (Criteria) this;
        }

        public Criteria andAskMoneyLessThanOrEqualTo(String value) {
            addCriterion("ask_money <=", value, "askMoney");
            return (Criteria) this;
        }

        public Criteria andAskMoneyLike(String value) {
            addCriterion("ask_money like", value, "askMoney");
            return (Criteria) this;
        }

        public Criteria andAskMoneyNotLike(String value) {
            addCriterion("ask_money not like", value, "askMoney");
            return (Criteria) this;
        }

        public Criteria andAskMoneyIn(List<String> values) {
            addCriterion("ask_money in", values, "askMoney");
            return (Criteria) this;
        }

        public Criteria andAskMoneyNotIn(List<String> values) {
            addCriterion("ask_money not in", values, "askMoney");
            return (Criteria) this;
        }

        public Criteria andAskMoneyBetween(String value1, String value2) {
            addCriterion("ask_money between", value1, value2, "askMoney");
            return (Criteria) this;
        }

        public Criteria andAskMoneyNotBetween(String value1, String value2) {
            addCriterion("ask_money not between", value1, value2, "askMoney");
            return (Criteria) this;
        }

        public Criteria andApproverOrderIsNull() {
            addCriterion("approver_order is null");
            return (Criteria) this;
        }

        public Criteria andApproverOrderIsNotNull() {
            addCriterion("approver_order is not null");
            return (Criteria) this;
        }

        public Criteria andApproverOrderEqualTo(String value) {
            addCriterion("approver_order =", value, "approverOrder");
            return (Criteria) this;
        }

        public Criteria andApproverOrderNotEqualTo(String value) {
            addCriterion("approver_order <>", value, "approverOrder");
            return (Criteria) this;
        }

        public Criteria andApproverOrderGreaterThan(String value) {
            addCriterion("approver_order >", value, "approverOrder");
            return (Criteria) this;
        }

        public Criteria andApproverOrderGreaterThanOrEqualTo(String value) {
            addCriterion("approver_order >=", value, "approverOrder");
            return (Criteria) this;
        }

        public Criteria andApproverOrderLessThan(String value) {
            addCriterion("approver_order <", value, "approverOrder");
            return (Criteria) this;
        }

        public Criteria andApproverOrderLessThanOrEqualTo(String value) {
            addCriterion("approver_order <=", value, "approverOrder");
            return (Criteria) this;
        }

        public Criteria andApproverOrderLike(String value) {
            addCriterion("approver_order like", value, "approverOrder");
            return (Criteria) this;
        }

        public Criteria andApproverOrderNotLike(String value) {
            addCriterion("approver_order not like", value, "approverOrder");
            return (Criteria) this;
        }

        public Criteria andApproverOrderIn(List<String> values) {
            addCriterion("approver_order in", values, "approverOrder");
            return (Criteria) this;
        }

        public Criteria andApproverOrderNotIn(List<String> values) {
            addCriterion("approver_order not in", values, "approverOrder");
            return (Criteria) this;
        }

        public Criteria andApproverOrderBetween(String value1, String value2) {
            addCriterion("approver_order between", value1, value2, "approverOrder");
            return (Criteria) this;
        }

        public Criteria andApproverOrderNotBetween(String value1, String value2) {
            addCriterion("approver_order not between", value1, value2, "approverOrder");
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