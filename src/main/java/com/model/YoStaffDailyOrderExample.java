package com.model;

import java.util.ArrayList;
import java.util.List;

public class YoStaffDailyOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public YoStaffDailyOrderExample() {
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

        public Criteria andSdoSequenceNoIsNull() {
            addCriterion("sdo_sequence_no is null");
            return (Criteria) this;
        }

        public Criteria andSdoSequenceNoIsNotNull() {
            addCriterion("sdo_sequence_no is not null");
            return (Criteria) this;
        }

        public Criteria andSdoSequenceNoEqualTo(Integer value) {
            addCriterion("sdo_sequence_no =", value, "sdoSequenceNo");
            return (Criteria) this;
        }

        public Criteria andSdoSequenceNoNotEqualTo(Integer value) {
            addCriterion("sdo_sequence_no <>", value, "sdoSequenceNo");
            return (Criteria) this;
        }

        public Criteria andSdoSequenceNoGreaterThan(Integer value) {
            addCriterion("sdo_sequence_no >", value, "sdoSequenceNo");
            return (Criteria) this;
        }

        public Criteria andSdoSequenceNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("sdo_sequence_no >=", value, "sdoSequenceNo");
            return (Criteria) this;
        }

        public Criteria andSdoSequenceNoLessThan(Integer value) {
            addCriterion("sdo_sequence_no <", value, "sdoSequenceNo");
            return (Criteria) this;
        }

        public Criteria andSdoSequenceNoLessThanOrEqualTo(Integer value) {
            addCriterion("sdo_sequence_no <=", value, "sdoSequenceNo");
            return (Criteria) this;
        }

        public Criteria andSdoSequenceNoIn(List<Integer> values) {
            addCriterion("sdo_sequence_no in", values, "sdoSequenceNo");
            return (Criteria) this;
        }

        public Criteria andSdoSequenceNoNotIn(List<Integer> values) {
            addCriterion("sdo_sequence_no not in", values, "sdoSequenceNo");
            return (Criteria) this;
        }

        public Criteria andSdoSequenceNoBetween(Integer value1, Integer value2) {
            addCriterion("sdo_sequence_no between", value1, value2, "sdoSequenceNo");
            return (Criteria) this;
        }

        public Criteria andSdoSequenceNoNotBetween(Integer value1, Integer value2) {
            addCriterion("sdo_sequence_no not between", value1, value2, "sdoSequenceNo");
            return (Criteria) this;
        }

        public Criteria andStaffUserIdIsNull() {
            addCriterion("staff_user_id is null");
            return (Criteria) this;
        }

        public Criteria andStaffUserIdIsNotNull() {
            addCriterion("staff_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andStaffUserIdEqualTo(String value) {
            addCriterion("staff_user_id =", value, "staffUserId");
            return (Criteria) this;
        }

        public Criteria andStaffUserIdNotEqualTo(String value) {
            addCriterion("staff_user_id <>", value, "staffUserId");
            return (Criteria) this;
        }

        public Criteria andStaffUserIdGreaterThan(String value) {
            addCriterion("staff_user_id >", value, "staffUserId");
            return (Criteria) this;
        }

        public Criteria andStaffUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("staff_user_id >=", value, "staffUserId");
            return (Criteria) this;
        }

        public Criteria andStaffUserIdLessThan(String value) {
            addCriterion("staff_user_id <", value, "staffUserId");
            return (Criteria) this;
        }

        public Criteria andStaffUserIdLessThanOrEqualTo(String value) {
            addCriterion("staff_user_id <=", value, "staffUserId");
            return (Criteria) this;
        }

        public Criteria andStaffUserIdLike(String value) {
            addCriterion("staff_user_id like", value, "staffUserId");
            return (Criteria) this;
        }

        public Criteria andStaffUserIdNotLike(String value) {
            addCriterion("staff_user_id not like", value, "staffUserId");
            return (Criteria) this;
        }

        public Criteria andStaffUserIdIn(List<String> values) {
            addCriterion("staff_user_id in", values, "staffUserId");
            return (Criteria) this;
        }

        public Criteria andStaffUserIdNotIn(List<String> values) {
            addCriterion("staff_user_id not in", values, "staffUserId");
            return (Criteria) this;
        }

        public Criteria andStaffUserIdBetween(String value1, String value2) {
            addCriterion("staff_user_id between", value1, value2, "staffUserId");
            return (Criteria) this;
        }

        public Criteria andStaffUserIdNotBetween(String value1, String value2) {
            addCriterion("staff_user_id not between", value1, value2, "staffUserId");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andSdoStaffIdIsNull() {
            addCriterion("sdo_staff_id is null");
            return (Criteria) this;
        }

        public Criteria andSdoStaffIdIsNotNull() {
            addCriterion("sdo_staff_id is not null");
            return (Criteria) this;
        }

        public Criteria andSdoStaffIdEqualTo(String value) {
            addCriterion("sdo_staff_id =", value, "sdoStaffId");
            return (Criteria) this;
        }

        public Criteria andSdoStaffIdNotEqualTo(String value) {
            addCriterion("sdo_staff_id <>", value, "sdoStaffId");
            return (Criteria) this;
        }

        public Criteria andSdoStaffIdGreaterThan(String value) {
            addCriterion("sdo_staff_id >", value, "sdoStaffId");
            return (Criteria) this;
        }

        public Criteria andSdoStaffIdGreaterThanOrEqualTo(String value) {
            addCriterion("sdo_staff_id >=", value, "sdoStaffId");
            return (Criteria) this;
        }

        public Criteria andSdoStaffIdLessThan(String value) {
            addCriterion("sdo_staff_id <", value, "sdoStaffId");
            return (Criteria) this;
        }

        public Criteria andSdoStaffIdLessThanOrEqualTo(String value) {
            addCriterion("sdo_staff_id <=", value, "sdoStaffId");
            return (Criteria) this;
        }

        public Criteria andSdoStaffIdLike(String value) {
            addCriterion("sdo_staff_id like", value, "sdoStaffId");
            return (Criteria) this;
        }

        public Criteria andSdoStaffIdNotLike(String value) {
            addCriterion("sdo_staff_id not like", value, "sdoStaffId");
            return (Criteria) this;
        }

        public Criteria andSdoStaffIdIn(List<String> values) {
            addCriterion("sdo_staff_id in", values, "sdoStaffId");
            return (Criteria) this;
        }

        public Criteria andSdoStaffIdNotIn(List<String> values) {
            addCriterion("sdo_staff_id not in", values, "sdoStaffId");
            return (Criteria) this;
        }

        public Criteria andSdoStaffIdBetween(String value1, String value2) {
            addCriterion("sdo_staff_id between", value1, value2, "sdoStaffId");
            return (Criteria) this;
        }

        public Criteria andSdoStaffIdNotBetween(String value1, String value2) {
            addCriterion("sdo_staff_id not between", value1, value2, "sdoStaffId");
            return (Criteria) this;
        }

        public Criteria andSdoDateIsNull() {
            addCriterion("sdo_date is null");
            return (Criteria) this;
        }

        public Criteria andSdoDateIsNotNull() {
            addCriterion("sdo_date is not null");
            return (Criteria) this;
        }

        public Criteria andSdoDateEqualTo(String value) {
            addCriterion("sdo_date =", value, "sdoDate");
            return (Criteria) this;
        }

        public Criteria andSdoDateNotEqualTo(String value) {
            addCriterion("sdo_date <>", value, "sdoDate");
            return (Criteria) this;
        }

        public Criteria andSdoDateGreaterThan(String value) {
            addCriterion("sdo_date >", value, "sdoDate");
            return (Criteria) this;
        }

        public Criteria andSdoDateGreaterThanOrEqualTo(String value) {
            addCriterion("sdo_date >=", value, "sdoDate");
            return (Criteria) this;
        }

        public Criteria andSdoDateLessThan(String value) {
            addCriterion("sdo_date <", value, "sdoDate");
            return (Criteria) this;
        }

        public Criteria andSdoDateLessThanOrEqualTo(String value) {
            addCriterion("sdo_date <=", value, "sdoDate");
            return (Criteria) this;
        }

        public Criteria andSdoDateLike(String value) {
            addCriterion("sdo_date like", value, "sdoDate");
            return (Criteria) this;
        }

        public Criteria andSdoDateNotLike(String value) {
            addCriterion("sdo_date not like", value, "sdoDate");
            return (Criteria) this;
        }

        public Criteria andSdoDateIn(List<String> values) {
            addCriterion("sdo_date in", values, "sdoDate");
            return (Criteria) this;
        }

        public Criteria andSdoDateNotIn(List<String> values) {
            addCriterion("sdo_date not in", values, "sdoDate");
            return (Criteria) this;
        }

        public Criteria andSdoDateBetween(String value1, String value2) {
            addCriterion("sdo_date between", value1, value2, "sdoDate");
            return (Criteria) this;
        }

        public Criteria andSdoDateNotBetween(String value1, String value2) {
            addCriterion("sdo_date not between", value1, value2, "sdoDate");
            return (Criteria) this;
        }

        public Criteria andSdoOrderNoIsNull() {
            addCriterion("sdo_order_no is null");
            return (Criteria) this;
        }

        public Criteria andSdoOrderNoIsNotNull() {
            addCriterion("sdo_order_no is not null");
            return (Criteria) this;
        }

        public Criteria andSdoOrderNoEqualTo(String value) {
            addCriterion("sdo_order_no =", value, "sdoOrderNo");
            return (Criteria) this;
        }

        public Criteria andSdoOrderNoNotEqualTo(String value) {
            addCriterion("sdo_order_no <>", value, "sdoOrderNo");
            return (Criteria) this;
        }

        public Criteria andSdoOrderNoGreaterThan(String value) {
            addCriterion("sdo_order_no >", value, "sdoOrderNo");
            return (Criteria) this;
        }

        public Criteria andSdoOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("sdo_order_no >=", value, "sdoOrderNo");
            return (Criteria) this;
        }

        public Criteria andSdoOrderNoLessThan(String value) {
            addCriterion("sdo_order_no <", value, "sdoOrderNo");
            return (Criteria) this;
        }

        public Criteria andSdoOrderNoLessThanOrEqualTo(String value) {
            addCriterion("sdo_order_no <=", value, "sdoOrderNo");
            return (Criteria) this;
        }

        public Criteria andSdoOrderNoLike(String value) {
            addCriterion("sdo_order_no like", value, "sdoOrderNo");
            return (Criteria) this;
        }

        public Criteria andSdoOrderNoNotLike(String value) {
            addCriterion("sdo_order_no not like", value, "sdoOrderNo");
            return (Criteria) this;
        }

        public Criteria andSdoOrderNoIn(List<String> values) {
            addCriterion("sdo_order_no in", values, "sdoOrderNo");
            return (Criteria) this;
        }

        public Criteria andSdoOrderNoNotIn(List<String> values) {
            addCriterion("sdo_order_no not in", values, "sdoOrderNo");
            return (Criteria) this;
        }

        public Criteria andSdoOrderNoBetween(String value1, String value2) {
            addCriterion("sdo_order_no between", value1, value2, "sdoOrderNo");
            return (Criteria) this;
        }

        public Criteria andSdoOrderNoNotBetween(String value1, String value2) {
            addCriterion("sdo_order_no not between", value1, value2, "sdoOrderNo");
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

        public Criteria andPrincipalIsNull() {
            addCriterion("principal is null");
            return (Criteria) this;
        }

        public Criteria andPrincipalIsNotNull() {
            addCriterion("principal is not null");
            return (Criteria) this;
        }

        public Criteria andPrincipalEqualTo(String value) {
            addCriterion("principal =", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalNotEqualTo(String value) {
            addCriterion("principal <>", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalGreaterThan(String value) {
            addCriterion("principal >", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalGreaterThanOrEqualTo(String value) {
            addCriterion("principal >=", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalLessThan(String value) {
            addCriterion("principal <", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalLessThanOrEqualTo(String value) {
            addCriterion("principal <=", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalLike(String value) {
            addCriterion("principal like", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalNotLike(String value) {
            addCriterion("principal not like", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalIn(List<String> values) {
            addCriterion("principal in", values, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalNotIn(List<String> values) {
            addCriterion("principal not in", values, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalBetween(String value1, String value2) {
            addCriterion("principal between", value1, value2, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalNotBetween(String value1, String value2) {
            addCriterion("principal not between", value1, value2, "principal");
            return (Criteria) this;
        }

        public Criteria andBusinessPropertyIsNull() {
            addCriterion("business_property is null");
            return (Criteria) this;
        }

        public Criteria andBusinessPropertyIsNotNull() {
            addCriterion("business_property is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessPropertyEqualTo(String value) {
            addCriterion("business_property =", value, "businessProperty");
            return (Criteria) this;
        }

        public Criteria andBusinessPropertyNotEqualTo(String value) {
            addCriterion("business_property <>", value, "businessProperty");
            return (Criteria) this;
        }

        public Criteria andBusinessPropertyGreaterThan(String value) {
            addCriterion("business_property >", value, "businessProperty");
            return (Criteria) this;
        }

        public Criteria andBusinessPropertyGreaterThanOrEqualTo(String value) {
            addCriterion("business_property >=", value, "businessProperty");
            return (Criteria) this;
        }

        public Criteria andBusinessPropertyLessThan(String value) {
            addCriterion("business_property <", value, "businessProperty");
            return (Criteria) this;
        }

        public Criteria andBusinessPropertyLessThanOrEqualTo(String value) {
            addCriterion("business_property <=", value, "businessProperty");
            return (Criteria) this;
        }

        public Criteria andBusinessPropertyLike(String value) {
            addCriterion("business_property like", value, "businessProperty");
            return (Criteria) this;
        }

        public Criteria andBusinessPropertyNotLike(String value) {
            addCriterion("business_property not like", value, "businessProperty");
            return (Criteria) this;
        }

        public Criteria andBusinessPropertyIn(List<String> values) {
            addCriterion("business_property in", values, "businessProperty");
            return (Criteria) this;
        }

        public Criteria andBusinessPropertyNotIn(List<String> values) {
            addCriterion("business_property not in", values, "businessProperty");
            return (Criteria) this;
        }

        public Criteria andBusinessPropertyBetween(String value1, String value2) {
            addCriterion("business_property between", value1, value2, "businessProperty");
            return (Criteria) this;
        }

        public Criteria andBusinessPropertyNotBetween(String value1, String value2) {
            addCriterion("business_property not between", value1, value2, "businessProperty");
            return (Criteria) this;
        }

        public Criteria andOutdoorJobIsNull() {
            addCriterion("outdoor_job is null");
            return (Criteria) this;
        }

        public Criteria andOutdoorJobIsNotNull() {
            addCriterion("outdoor_job is not null");
            return (Criteria) this;
        }

        public Criteria andOutdoorJobEqualTo(String value) {
            addCriterion("outdoor_job =", value, "outdoorJob");
            return (Criteria) this;
        }

        public Criteria andOutdoorJobNotEqualTo(String value) {
            addCriterion("outdoor_job <>", value, "outdoorJob");
            return (Criteria) this;
        }

        public Criteria andOutdoorJobGreaterThan(String value) {
            addCriterion("outdoor_job >", value, "outdoorJob");
            return (Criteria) this;
        }

        public Criteria andOutdoorJobGreaterThanOrEqualTo(String value) {
            addCriterion("outdoor_job >=", value, "outdoorJob");
            return (Criteria) this;
        }

        public Criteria andOutdoorJobLessThan(String value) {
            addCriterion("outdoor_job <", value, "outdoorJob");
            return (Criteria) this;
        }

        public Criteria andOutdoorJobLessThanOrEqualTo(String value) {
            addCriterion("outdoor_job <=", value, "outdoorJob");
            return (Criteria) this;
        }

        public Criteria andOutdoorJobLike(String value) {
            addCriterion("outdoor_job like", value, "outdoorJob");
            return (Criteria) this;
        }

        public Criteria andOutdoorJobNotLike(String value) {
            addCriterion("outdoor_job not like", value, "outdoorJob");
            return (Criteria) this;
        }

        public Criteria andOutdoorJobIn(List<String> values) {
            addCriterion("outdoor_job in", values, "outdoorJob");
            return (Criteria) this;
        }

        public Criteria andOutdoorJobNotIn(List<String> values) {
            addCriterion("outdoor_job not in", values, "outdoorJob");
            return (Criteria) this;
        }

        public Criteria andOutdoorJobBetween(String value1, String value2) {
            addCriterion("outdoor_job between", value1, value2, "outdoorJob");
            return (Criteria) this;
        }

        public Criteria andOutdoorJobNotBetween(String value1, String value2) {
            addCriterion("outdoor_job not between", value1, value2, "outdoorJob");
            return (Criteria) this;
        }

        public Criteria andOrderProvinceIsNull() {
            addCriterion("order_province is null");
            return (Criteria) this;
        }

        public Criteria andOrderProvinceIsNotNull() {
            addCriterion("order_province is not null");
            return (Criteria) this;
        }

        public Criteria andOrderProvinceEqualTo(String value) {
            addCriterion("order_province =", value, "orderProvince");
            return (Criteria) this;
        }

        public Criteria andOrderProvinceNotEqualTo(String value) {
            addCriterion("order_province <>", value, "orderProvince");
            return (Criteria) this;
        }

        public Criteria andOrderProvinceGreaterThan(String value) {
            addCriterion("order_province >", value, "orderProvince");
            return (Criteria) this;
        }

        public Criteria andOrderProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("order_province >=", value, "orderProvince");
            return (Criteria) this;
        }

        public Criteria andOrderProvinceLessThan(String value) {
            addCriterion("order_province <", value, "orderProvince");
            return (Criteria) this;
        }

        public Criteria andOrderProvinceLessThanOrEqualTo(String value) {
            addCriterion("order_province <=", value, "orderProvince");
            return (Criteria) this;
        }

        public Criteria andOrderProvinceLike(String value) {
            addCriterion("order_province like", value, "orderProvince");
            return (Criteria) this;
        }

        public Criteria andOrderProvinceNotLike(String value) {
            addCriterion("order_province not like", value, "orderProvince");
            return (Criteria) this;
        }

        public Criteria andOrderProvinceIn(List<String> values) {
            addCriterion("order_province in", values, "orderProvince");
            return (Criteria) this;
        }

        public Criteria andOrderProvinceNotIn(List<String> values) {
            addCriterion("order_province not in", values, "orderProvince");
            return (Criteria) this;
        }

        public Criteria andOrderProvinceBetween(String value1, String value2) {
            addCriterion("order_province between", value1, value2, "orderProvince");
            return (Criteria) this;
        }

        public Criteria andOrderProvinceNotBetween(String value1, String value2) {
            addCriterion("order_province not between", value1, value2, "orderProvince");
            return (Criteria) this;
        }

        public Criteria andOrderCityIsNull() {
            addCriterion("order_city is null");
            return (Criteria) this;
        }

        public Criteria andOrderCityIsNotNull() {
            addCriterion("order_city is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCityEqualTo(String value) {
            addCriterion("order_city =", value, "orderCity");
            return (Criteria) this;
        }

        public Criteria andOrderCityNotEqualTo(String value) {
            addCriterion("order_city <>", value, "orderCity");
            return (Criteria) this;
        }

        public Criteria andOrderCityGreaterThan(String value) {
            addCriterion("order_city >", value, "orderCity");
            return (Criteria) this;
        }

        public Criteria andOrderCityGreaterThanOrEqualTo(String value) {
            addCriterion("order_city >=", value, "orderCity");
            return (Criteria) this;
        }

        public Criteria andOrderCityLessThan(String value) {
            addCriterion("order_city <", value, "orderCity");
            return (Criteria) this;
        }

        public Criteria andOrderCityLessThanOrEqualTo(String value) {
            addCriterion("order_city <=", value, "orderCity");
            return (Criteria) this;
        }

        public Criteria andOrderCityLike(String value) {
            addCriterion("order_city like", value, "orderCity");
            return (Criteria) this;
        }

        public Criteria andOrderCityNotLike(String value) {
            addCriterion("order_city not like", value, "orderCity");
            return (Criteria) this;
        }

        public Criteria andOrderCityIn(List<String> values) {
            addCriterion("order_city in", values, "orderCity");
            return (Criteria) this;
        }

        public Criteria andOrderCityNotIn(List<String> values) {
            addCriterion("order_city not in", values, "orderCity");
            return (Criteria) this;
        }

        public Criteria andOrderCityBetween(String value1, String value2) {
            addCriterion("order_city between", value1, value2, "orderCity");
            return (Criteria) this;
        }

        public Criteria andOrderCityNotBetween(String value1, String value2) {
            addCriterion("order_city not between", value1, value2, "orderCity");
            return (Criteria) this;
        }

        public Criteria andOrderYearIsNull() {
            addCriterion("order_year is null");
            return (Criteria) this;
        }

        public Criteria andOrderYearIsNotNull() {
            addCriterion("order_year is not null");
            return (Criteria) this;
        }

        public Criteria andOrderYearEqualTo(String value) {
            addCriterion("order_year =", value, "orderYear");
            return (Criteria) this;
        }

        public Criteria andOrderYearNotEqualTo(String value) {
            addCriterion("order_year <>", value, "orderYear");
            return (Criteria) this;
        }

        public Criteria andOrderYearGreaterThan(String value) {
            addCriterion("order_year >", value, "orderYear");
            return (Criteria) this;
        }

        public Criteria andOrderYearGreaterThanOrEqualTo(String value) {
            addCriterion("order_year >=", value, "orderYear");
            return (Criteria) this;
        }

        public Criteria andOrderYearLessThan(String value) {
            addCriterion("order_year <", value, "orderYear");
            return (Criteria) this;
        }

        public Criteria andOrderYearLessThanOrEqualTo(String value) {
            addCriterion("order_year <=", value, "orderYear");
            return (Criteria) this;
        }

        public Criteria andOrderYearLike(String value) {
            addCriterion("order_year like", value, "orderYear");
            return (Criteria) this;
        }

        public Criteria andOrderYearNotLike(String value) {
            addCriterion("order_year not like", value, "orderYear");
            return (Criteria) this;
        }

        public Criteria andOrderYearIn(List<String> values) {
            addCriterion("order_year in", values, "orderYear");
            return (Criteria) this;
        }

        public Criteria andOrderYearNotIn(List<String> values) {
            addCriterion("order_year not in", values, "orderYear");
            return (Criteria) this;
        }

        public Criteria andOrderYearBetween(String value1, String value2) {
            addCriterion("order_year between", value1, value2, "orderYear");
            return (Criteria) this;
        }

        public Criteria andOrderYearNotBetween(String value1, String value2) {
            addCriterion("order_year not between", value1, value2, "orderYear");
            return (Criteria) this;
        }

        public Criteria andYindaIdentifyIsNull() {
            addCriterion("yinda_identify is null");
            return (Criteria) this;
        }

        public Criteria andYindaIdentifyIsNotNull() {
            addCriterion("yinda_identify is not null");
            return (Criteria) this;
        }

        public Criteria andYindaIdentifyEqualTo(String value) {
            addCriterion("yinda_identify =", value, "yindaIdentify");
            return (Criteria) this;
        }

        public Criteria andYindaIdentifyNotEqualTo(String value) {
            addCriterion("yinda_identify <>", value, "yindaIdentify");
            return (Criteria) this;
        }

        public Criteria andYindaIdentifyGreaterThan(String value) {
            addCriterion("yinda_identify >", value, "yindaIdentify");
            return (Criteria) this;
        }

        public Criteria andYindaIdentifyGreaterThanOrEqualTo(String value) {
            addCriterion("yinda_identify >=", value, "yindaIdentify");
            return (Criteria) this;
        }

        public Criteria andYindaIdentifyLessThan(String value) {
            addCriterion("yinda_identify <", value, "yindaIdentify");
            return (Criteria) this;
        }

        public Criteria andYindaIdentifyLessThanOrEqualTo(String value) {
            addCriterion("yinda_identify <=", value, "yindaIdentify");
            return (Criteria) this;
        }

        public Criteria andYindaIdentifyLike(String value) {
            addCriterion("yinda_identify like", value, "yindaIdentify");
            return (Criteria) this;
        }

        public Criteria andYindaIdentifyNotLike(String value) {
            addCriterion("yinda_identify not like", value, "yindaIdentify");
            return (Criteria) this;
        }

        public Criteria andYindaIdentifyIn(List<String> values) {
            addCriterion("yinda_identify in", values, "yindaIdentify");
            return (Criteria) this;
        }

        public Criteria andYindaIdentifyNotIn(List<String> values) {
            addCriterion("yinda_identify not in", values, "yindaIdentify");
            return (Criteria) this;
        }

        public Criteria andYindaIdentifyBetween(String value1, String value2) {
            addCriterion("yinda_identify between", value1, value2, "yindaIdentify");
            return (Criteria) this;
        }

        public Criteria andYindaIdentifyNotBetween(String value1, String value2) {
            addCriterion("yinda_identify not between", value1, value2, "yindaIdentify");
            return (Criteria) this;
        }

        public Criteria andContractTypeIsNull() {
            addCriterion("contract_type is null");
            return (Criteria) this;
        }

        public Criteria andContractTypeIsNotNull() {
            addCriterion("contract_type is not null");
            return (Criteria) this;
        }

        public Criteria andContractTypeEqualTo(String value) {
            addCriterion("contract_type =", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeNotEqualTo(String value) {
            addCriterion("contract_type <>", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeGreaterThan(String value) {
            addCriterion("contract_type >", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeGreaterThanOrEqualTo(String value) {
            addCriterion("contract_type >=", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeLessThan(String value) {
            addCriterion("contract_type <", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeLessThanOrEqualTo(String value) {
            addCriterion("contract_type <=", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeLike(String value) {
            addCriterion("contract_type like", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeNotLike(String value) {
            addCriterion("contract_type not like", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeIn(List<String> values) {
            addCriterion("contract_type in", values, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeNotIn(List<String> values) {
            addCriterion("contract_type not in", values, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeBetween(String value1, String value2) {
            addCriterion("contract_type between", value1, value2, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeNotBetween(String value1, String value2) {
            addCriterion("contract_type not between", value1, value2, "contractType");
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