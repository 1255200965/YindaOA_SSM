package com.model;

import java.util.ArrayList;
import java.util.List;

public class YoOrderChangeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public YoOrderChangeExample() {
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

        public Criteria andStaffIdIsNull() {
            addCriterion("staff_id is null");
            return (Criteria) this;
        }

        public Criteria andStaffIdIsNotNull() {
            addCriterion("staff_id is not null");
            return (Criteria) this;
        }

        public Criteria andStaffIdEqualTo(String value) {
            addCriterion("staff_id =", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotEqualTo(String value) {
            addCriterion("staff_id <>", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdGreaterThan(String value) {
            addCriterion("staff_id >", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdGreaterThanOrEqualTo(String value) {
            addCriterion("staff_id >=", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLessThan(String value) {
            addCriterion("staff_id <", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLessThanOrEqualTo(String value) {
            addCriterion("staff_id <=", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLike(String value) {
            addCriterion("staff_id like", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotLike(String value) {
            addCriterion("staff_id not like", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdIn(List<String> values) {
            addCriterion("staff_id in", values, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotIn(List<String> values) {
            addCriterion("staff_id not in", values, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdBetween(String value1, String value2) {
            addCriterion("staff_id between", value1, value2, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotBetween(String value1, String value2) {
            addCriterion("staff_id not between", value1, value2, "staffId");
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

        public Criteria andOrderNumberIsNull() {
            addCriterion("order_number is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIsNotNull() {
            addCriterion("order_number is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberEqualTo(String value) {
            addCriterion("order_number =", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotEqualTo(String value) {
            addCriterion("order_number <>", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThan(String value) {
            addCriterion("order_number >", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThanOrEqualTo(String value) {
            addCriterion("order_number >=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThan(String value) {
            addCriterion("order_number <", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThanOrEqualTo(String value) {
            addCriterion("order_number <=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLike(String value) {
            addCriterion("order_number like", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotLike(String value) {
            addCriterion("order_number not like", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIn(List<String> values) {
            addCriterion("order_number in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotIn(List<String> values) {
            addCriterion("order_number not in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberBetween(String value1, String value2) {
            addCriterion("order_number between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotBetween(String value1, String value2) {
            addCriterion("order_number not between", value1, value2, "orderNumber");
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

        public Criteria andChangeProvinceIsNull() {
            addCriterion("change_province is null");
            return (Criteria) this;
        }

        public Criteria andChangeProvinceIsNotNull() {
            addCriterion("change_province is not null");
            return (Criteria) this;
        }

        public Criteria andChangeProvinceEqualTo(String value) {
            addCriterion("change_province =", value, "changeProvince");
            return (Criteria) this;
        }

        public Criteria andChangeProvinceNotEqualTo(String value) {
            addCriterion("change_province <>", value, "changeProvince");
            return (Criteria) this;
        }

        public Criteria andChangeProvinceGreaterThan(String value) {
            addCriterion("change_province >", value, "changeProvince");
            return (Criteria) this;
        }

        public Criteria andChangeProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("change_province >=", value, "changeProvince");
            return (Criteria) this;
        }

        public Criteria andChangeProvinceLessThan(String value) {
            addCriterion("change_province <", value, "changeProvince");
            return (Criteria) this;
        }

        public Criteria andChangeProvinceLessThanOrEqualTo(String value) {
            addCriterion("change_province <=", value, "changeProvince");
            return (Criteria) this;
        }

        public Criteria andChangeProvinceLike(String value) {
            addCriterion("change_province like", value, "changeProvince");
            return (Criteria) this;
        }

        public Criteria andChangeProvinceNotLike(String value) {
            addCriterion("change_province not like", value, "changeProvince");
            return (Criteria) this;
        }

        public Criteria andChangeProvinceIn(List<String> values) {
            addCriterion("change_province in", values, "changeProvince");
            return (Criteria) this;
        }

        public Criteria andChangeProvinceNotIn(List<String> values) {
            addCriterion("change_province not in", values, "changeProvince");
            return (Criteria) this;
        }

        public Criteria andChangeProvinceBetween(String value1, String value2) {
            addCriterion("change_province between", value1, value2, "changeProvince");
            return (Criteria) this;
        }

        public Criteria andChangeProvinceNotBetween(String value1, String value2) {
            addCriterion("change_province not between", value1, value2, "changeProvince");
            return (Criteria) this;
        }

        public Criteria andChangeCityIsNull() {
            addCriterion("change_city is null");
            return (Criteria) this;
        }

        public Criteria andChangeCityIsNotNull() {
            addCriterion("change_city is not null");
            return (Criteria) this;
        }

        public Criteria andChangeCityEqualTo(String value) {
            addCriterion("change_city =", value, "changeCity");
            return (Criteria) this;
        }

        public Criteria andChangeCityNotEqualTo(String value) {
            addCriterion("change_city <>", value, "changeCity");
            return (Criteria) this;
        }

        public Criteria andChangeCityGreaterThan(String value) {
            addCriterion("change_city >", value, "changeCity");
            return (Criteria) this;
        }

        public Criteria andChangeCityGreaterThanOrEqualTo(String value) {
            addCriterion("change_city >=", value, "changeCity");
            return (Criteria) this;
        }

        public Criteria andChangeCityLessThan(String value) {
            addCriterion("change_city <", value, "changeCity");
            return (Criteria) this;
        }

        public Criteria andChangeCityLessThanOrEqualTo(String value) {
            addCriterion("change_city <=", value, "changeCity");
            return (Criteria) this;
        }

        public Criteria andChangeCityLike(String value) {
            addCriterion("change_city like", value, "changeCity");
            return (Criteria) this;
        }

        public Criteria andChangeCityNotLike(String value) {
            addCriterion("change_city not like", value, "changeCity");
            return (Criteria) this;
        }

        public Criteria andChangeCityIn(List<String> values) {
            addCriterion("change_city in", values, "changeCity");
            return (Criteria) this;
        }

        public Criteria andChangeCityNotIn(List<String> values) {
            addCriterion("change_city not in", values, "changeCity");
            return (Criteria) this;
        }

        public Criteria andChangeCityBetween(String value1, String value2) {
            addCriterion("change_city between", value1, value2, "changeCity");
            return (Criteria) this;
        }

        public Criteria andChangeCityNotBetween(String value1, String value2) {
            addCriterion("change_city not between", value1, value2, "changeCity");
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

        public Criteria andModifyUserIsNull() {
            addCriterion("modify_user is null");
            return (Criteria) this;
        }

        public Criteria andModifyUserIsNotNull() {
            addCriterion("modify_user is not null");
            return (Criteria) this;
        }

        public Criteria andModifyUserEqualTo(String value) {
            addCriterion("modify_user =", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserNotEqualTo(String value) {
            addCriterion("modify_user <>", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserGreaterThan(String value) {
            addCriterion("modify_user >", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserGreaterThanOrEqualTo(String value) {
            addCriterion("modify_user >=", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserLessThan(String value) {
            addCriterion("modify_user <", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserLessThanOrEqualTo(String value) {
            addCriterion("modify_user <=", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserLike(String value) {
            addCriterion("modify_user like", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserNotLike(String value) {
            addCriterion("modify_user not like", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserIn(List<String> values) {
            addCriterion("modify_user in", values, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserNotIn(List<String> values) {
            addCriterion("modify_user not in", values, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserBetween(String value1, String value2) {
            addCriterion("modify_user between", value1, value2, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserNotBetween(String value1, String value2) {
            addCriterion("modify_user not between", value1, value2, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andEffectTimeIsNull() {
            addCriterion("effect_time is null");
            return (Criteria) this;
        }

        public Criteria andEffectTimeIsNotNull() {
            addCriterion("effect_time is not null");
            return (Criteria) this;
        }

        public Criteria andEffectTimeEqualTo(String value) {
            addCriterion("effect_time =", value, "effectTime");
            return (Criteria) this;
        }

        public Criteria andEffectTimeNotEqualTo(String value) {
            addCriterion("effect_time <>", value, "effectTime");
            return (Criteria) this;
        }

        public Criteria andEffectTimeGreaterThan(String value) {
            addCriterion("effect_time >", value, "effectTime");
            return (Criteria) this;
        }

        public Criteria andEffectTimeGreaterThanOrEqualTo(String value) {
            addCriterion("effect_time >=", value, "effectTime");
            return (Criteria) this;
        }

        public Criteria andEffectTimeLessThan(String value) {
            addCriterion("effect_time <", value, "effectTime");
            return (Criteria) this;
        }

        public Criteria andEffectTimeLessThanOrEqualTo(String value) {
            addCriterion("effect_time <=", value, "effectTime");
            return (Criteria) this;
        }

        public Criteria andEffectTimeLike(String value) {
            addCriterion("effect_time like", value, "effectTime");
            return (Criteria) this;
        }

        public Criteria andEffectTimeNotLike(String value) {
            addCriterion("effect_time not like", value, "effectTime");
            return (Criteria) this;
        }

        public Criteria andEffectTimeIn(List<String> values) {
            addCriterion("effect_time in", values, "effectTime");
            return (Criteria) this;
        }

        public Criteria andEffectTimeNotIn(List<String> values) {
            addCriterion("effect_time not in", values, "effectTime");
            return (Criteria) this;
        }

        public Criteria andEffectTimeBetween(String value1, String value2) {
            addCriterion("effect_time between", value1, value2, "effectTime");
            return (Criteria) this;
        }

        public Criteria andEffectTimeNotBetween(String value1, String value2) {
            addCriterion("effect_time not between", value1, value2, "effectTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("modify_time is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(String value) {
            addCriterion("modify_time =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(String value) {
            addCriterion("modify_time <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(String value) {
            addCriterion("modify_time >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(String value) {
            addCriterion("modify_time >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(String value) {
            addCriterion("modify_time <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(String value) {
            addCriterion("modify_time <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLike(String value) {
            addCriterion("modify_time like", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotLike(String value) {
            addCriterion("modify_time not like", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<String> values) {
            addCriterion("modify_time in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<String> values) {
            addCriterion("modify_time not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(String value1, String value2) {
            addCriterion("modify_time between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(String value1, String value2) {
            addCriterion("modify_time not between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNull() {
            addCriterion("order_status is null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNotNull() {
            addCriterion("order_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusEqualTo(String value) {
            addCriterion("order_status =", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotEqualTo(String value) {
            addCriterion("order_status <>", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThan(String value) {
            addCriterion("order_status >", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThanOrEqualTo(String value) {
            addCriterion("order_status >=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThan(String value) {
            addCriterion("order_status <", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThanOrEqualTo(String value) {
            addCriterion("order_status <=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLike(String value) {
            addCriterion("order_status like", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotLike(String value) {
            addCriterion("order_status not like", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIn(List<String> values) {
            addCriterion("order_status in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotIn(List<String> values) {
            addCriterion("order_status not in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusBetween(String value1, String value2) {
            addCriterion("order_status between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotBetween(String value1, String value2) {
            addCriterion("order_status not between", value1, value2, "orderStatus");
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

        public Criteria andAssessIsNull() {
            addCriterion("assess is null");
            return (Criteria) this;
        }

        public Criteria andAssessIsNotNull() {
            addCriterion("assess is not null");
            return (Criteria) this;
        }

        public Criteria andAssessEqualTo(String value) {
            addCriterion("assess =", value, "assess");
            return (Criteria) this;
        }

        public Criteria andAssessNotEqualTo(String value) {
            addCriterion("assess <>", value, "assess");
            return (Criteria) this;
        }

        public Criteria andAssessGreaterThan(String value) {
            addCriterion("assess >", value, "assess");
            return (Criteria) this;
        }

        public Criteria andAssessGreaterThanOrEqualTo(String value) {
            addCriterion("assess >=", value, "assess");
            return (Criteria) this;
        }

        public Criteria andAssessLessThan(String value) {
            addCriterion("assess <", value, "assess");
            return (Criteria) this;
        }

        public Criteria andAssessLessThanOrEqualTo(String value) {
            addCriterion("assess <=", value, "assess");
            return (Criteria) this;
        }

        public Criteria andAssessLike(String value) {
            addCriterion("assess like", value, "assess");
            return (Criteria) this;
        }

        public Criteria andAssessNotLike(String value) {
            addCriterion("assess not like", value, "assess");
            return (Criteria) this;
        }

        public Criteria andAssessIn(List<String> values) {
            addCriterion("assess in", values, "assess");
            return (Criteria) this;
        }

        public Criteria andAssessNotIn(List<String> values) {
            addCriterion("assess not in", values, "assess");
            return (Criteria) this;
        }

        public Criteria andAssessBetween(String value1, String value2) {
            addCriterion("assess between", value1, value2, "assess");
            return (Criteria) this;
        }

        public Criteria andAssessNotBetween(String value1, String value2) {
            addCriterion("assess not between", value1, value2, "assess");
            return (Criteria) this;
        }

        public Criteria andLteIsNull() {
            addCriterion("LTE is null");
            return (Criteria) this;
        }

        public Criteria andLteIsNotNull() {
            addCriterion("LTE is not null");
            return (Criteria) this;
        }

        public Criteria andLteEqualTo(String value) {
            addCriterion("LTE =", value, "lte");
            return (Criteria) this;
        }

        public Criteria andLteNotEqualTo(String value) {
            addCriterion("LTE <>", value, "lte");
            return (Criteria) this;
        }

        public Criteria andLteGreaterThan(String value) {
            addCriterion("LTE >", value, "lte");
            return (Criteria) this;
        }

        public Criteria andLteGreaterThanOrEqualTo(String value) {
            addCriterion("LTE >=", value, "lte");
            return (Criteria) this;
        }

        public Criteria andLteLessThan(String value) {
            addCriterion("LTE <", value, "lte");
            return (Criteria) this;
        }

        public Criteria andLteLessThanOrEqualTo(String value) {
            addCriterion("LTE <=", value, "lte");
            return (Criteria) this;
        }

        public Criteria andLteLike(String value) {
            addCriterion("LTE like", value, "lte");
            return (Criteria) this;
        }

        public Criteria andLteNotLike(String value) {
            addCriterion("LTE not like", value, "lte");
            return (Criteria) this;
        }

        public Criteria andLteIn(List<String> values) {
            addCriterion("LTE in", values, "lte");
            return (Criteria) this;
        }

        public Criteria andLteNotIn(List<String> values) {
            addCriterion("LTE not in", values, "lte");
            return (Criteria) this;
        }

        public Criteria andLteBetween(String value1, String value2) {
            addCriterion("LTE between", value1, value2, "lte");
            return (Criteria) this;
        }

        public Criteria andLteNotBetween(String value1, String value2) {
            addCriterion("LTE not between", value1, value2, "lte");
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

        public Criteria andOrderResultIsNull() {
            addCriterion("order_result is null");
            return (Criteria) this;
        }

        public Criteria andOrderResultIsNotNull() {
            addCriterion("order_result is not null");
            return (Criteria) this;
        }

        public Criteria andOrderResultEqualTo(String value) {
            addCriterion("order_result =", value, "orderResult");
            return (Criteria) this;
        }

        public Criteria andOrderResultNotEqualTo(String value) {
            addCriterion("order_result <>", value, "orderResult");
            return (Criteria) this;
        }

        public Criteria andOrderResultGreaterThan(String value) {
            addCriterion("order_result >", value, "orderResult");
            return (Criteria) this;
        }

        public Criteria andOrderResultGreaterThanOrEqualTo(String value) {
            addCriterion("order_result >=", value, "orderResult");
            return (Criteria) this;
        }

        public Criteria andOrderResultLessThan(String value) {
            addCriterion("order_result <", value, "orderResult");
            return (Criteria) this;
        }

        public Criteria andOrderResultLessThanOrEqualTo(String value) {
            addCriterion("order_result <=", value, "orderResult");
            return (Criteria) this;
        }

        public Criteria andOrderResultLike(String value) {
            addCriterion("order_result like", value, "orderResult");
            return (Criteria) this;
        }

        public Criteria andOrderResultNotLike(String value) {
            addCriterion("order_result not like", value, "orderResult");
            return (Criteria) this;
        }

        public Criteria andOrderResultIn(List<String> values) {
            addCriterion("order_result in", values, "orderResult");
            return (Criteria) this;
        }

        public Criteria andOrderResultNotIn(List<String> values) {
            addCriterion("order_result not in", values, "orderResult");
            return (Criteria) this;
        }

        public Criteria andOrderResultBetween(String value1, String value2) {
            addCriterion("order_result between", value1, value2, "orderResult");
            return (Criteria) this;
        }

        public Criteria andOrderResultNotBetween(String value1, String value2) {
            addCriterion("order_result not between", value1, value2, "orderResult");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkIsNull() {
            addCriterion("order_remark is null");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkIsNotNull() {
            addCriterion("order_remark is not null");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkEqualTo(String value) {
            addCriterion("order_remark =", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkNotEqualTo(String value) {
            addCriterion("order_remark <>", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkGreaterThan(String value) {
            addCriterion("order_remark >", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("order_remark >=", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkLessThan(String value) {
            addCriterion("order_remark <", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkLessThanOrEqualTo(String value) {
            addCriterion("order_remark <=", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkLike(String value) {
            addCriterion("order_remark like", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkNotLike(String value) {
            addCriterion("order_remark not like", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkIn(List<String> values) {
            addCriterion("order_remark in", values, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkNotIn(List<String> values) {
            addCriterion("order_remark not in", values, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkBetween(String value1, String value2) {
            addCriterion("order_remark between", value1, value2, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkNotBetween(String value1, String value2) {
            addCriterion("order_remark not between", value1, value2, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andHistoryAccessIsNull() {
            addCriterion("history_access is null");
            return (Criteria) this;
        }

        public Criteria andHistoryAccessIsNotNull() {
            addCriterion("history_access is not null");
            return (Criteria) this;
        }

        public Criteria andHistoryAccessEqualTo(String value) {
            addCriterion("history_access =", value, "historyAccess");
            return (Criteria) this;
        }

        public Criteria andHistoryAccessNotEqualTo(String value) {
            addCriterion("history_access <>", value, "historyAccess");
            return (Criteria) this;
        }

        public Criteria andHistoryAccessGreaterThan(String value) {
            addCriterion("history_access >", value, "historyAccess");
            return (Criteria) this;
        }

        public Criteria andHistoryAccessGreaterThanOrEqualTo(String value) {
            addCriterion("history_access >=", value, "historyAccess");
            return (Criteria) this;
        }

        public Criteria andHistoryAccessLessThan(String value) {
            addCriterion("history_access <", value, "historyAccess");
            return (Criteria) this;
        }

        public Criteria andHistoryAccessLessThanOrEqualTo(String value) {
            addCriterion("history_access <=", value, "historyAccess");
            return (Criteria) this;
        }

        public Criteria andHistoryAccessLike(String value) {
            addCriterion("history_access like", value, "historyAccess");
            return (Criteria) this;
        }

        public Criteria andHistoryAccessNotLike(String value) {
            addCriterion("history_access not like", value, "historyAccess");
            return (Criteria) this;
        }

        public Criteria andHistoryAccessIn(List<String> values) {
            addCriterion("history_access in", values, "historyAccess");
            return (Criteria) this;
        }

        public Criteria andHistoryAccessNotIn(List<String> values) {
            addCriterion("history_access not in", values, "historyAccess");
            return (Criteria) this;
        }

        public Criteria andHistoryAccessBetween(String value1, String value2) {
            addCriterion("history_access between", value1, value2, "historyAccess");
            return (Criteria) this;
        }

        public Criteria andHistoryAccessNotBetween(String value1, String value2) {
            addCriterion("history_access not between", value1, value2, "historyAccess");
            return (Criteria) this;
        }

        public Criteria andNowAcessIsNull() {
            addCriterion("now_acess is null");
            return (Criteria) this;
        }

        public Criteria andNowAcessIsNotNull() {
            addCriterion("now_acess is not null");
            return (Criteria) this;
        }

        public Criteria andNowAcessEqualTo(String value) {
            addCriterion("now_acess =", value, "nowAcess");
            return (Criteria) this;
        }

        public Criteria andNowAcessNotEqualTo(String value) {
            addCriterion("now_acess <>", value, "nowAcess");
            return (Criteria) this;
        }

        public Criteria andNowAcessGreaterThan(String value) {
            addCriterion("now_acess >", value, "nowAcess");
            return (Criteria) this;
        }

        public Criteria andNowAcessGreaterThanOrEqualTo(String value) {
            addCriterion("now_acess >=", value, "nowAcess");
            return (Criteria) this;
        }

        public Criteria andNowAcessLessThan(String value) {
            addCriterion("now_acess <", value, "nowAcess");
            return (Criteria) this;
        }

        public Criteria andNowAcessLessThanOrEqualTo(String value) {
            addCriterion("now_acess <=", value, "nowAcess");
            return (Criteria) this;
        }

        public Criteria andNowAcessLike(String value) {
            addCriterion("now_acess like", value, "nowAcess");
            return (Criteria) this;
        }

        public Criteria andNowAcessNotLike(String value) {
            addCriterion("now_acess not like", value, "nowAcess");
            return (Criteria) this;
        }

        public Criteria andNowAcessIn(List<String> values) {
            addCriterion("now_acess in", values, "nowAcess");
            return (Criteria) this;
        }

        public Criteria andNowAcessNotIn(List<String> values) {
            addCriterion("now_acess not in", values, "nowAcess");
            return (Criteria) this;
        }

        public Criteria andNowAcessBetween(String value1, String value2) {
            addCriterion("now_acess between", value1, value2, "nowAcess");
            return (Criteria) this;
        }

        public Criteria andNowAcessNotBetween(String value1, String value2) {
            addCriterion("now_acess not between", value1, value2, "nowAcess");
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