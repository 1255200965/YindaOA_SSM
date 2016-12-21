package com.model;

import java.util.ArrayList;
import java.util.List;

public class YoOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public YoOrderExample() {
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

        public Criteria andYoStatusIsNull() {
            addCriterion("yo_status is null");
            return (Criteria) this;
        }

        public Criteria andYoStatusIsNotNull() {
            addCriterion("yo_status is not null");
            return (Criteria) this;
        }

        public Criteria andYoStatusEqualTo(String value) {
            addCriterion("yo_status =", value, "yoStatus");
            return (Criteria) this;
        }

        public Criteria andYoStatusNotEqualTo(String value) {
            addCriterion("yo_status <>", value, "yoStatus");
            return (Criteria) this;
        }

        public Criteria andYoStatusGreaterThan(String value) {
            addCriterion("yo_status >", value, "yoStatus");
            return (Criteria) this;
        }

        public Criteria andYoStatusGreaterThanOrEqualTo(String value) {
            addCriterion("yo_status >=", value, "yoStatus");
            return (Criteria) this;
        }

        public Criteria andYoStatusLessThan(String value) {
            addCriterion("yo_status <", value, "yoStatus");
            return (Criteria) this;
        }

        public Criteria andYoStatusLessThanOrEqualTo(String value) {
            addCriterion("yo_status <=", value, "yoStatus");
            return (Criteria) this;
        }

        public Criteria andYoStatusLike(String value) {
            addCriterion("yo_status like", value, "yoStatus");
            return (Criteria) this;
        }

        public Criteria andYoStatusNotLike(String value) {
            addCriterion("yo_status not like", value, "yoStatus");
            return (Criteria) this;
        }

        public Criteria andYoStatusIn(List<String> values) {
            addCriterion("yo_status in", values, "yoStatus");
            return (Criteria) this;
        }

        public Criteria andYoStatusNotIn(List<String> values) {
            addCriterion("yo_status not in", values, "yoStatus");
            return (Criteria) this;
        }

        public Criteria andYoStatusBetween(String value1, String value2) {
            addCriterion("yo_status between", value1, value2, "yoStatus");
            return (Criteria) this;
        }

        public Criteria andYoStatusNotBetween(String value1, String value2) {
            addCriterion("yo_status not between", value1, value2, "yoStatus");
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