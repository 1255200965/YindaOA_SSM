package com.model;

import java.util.ArrayList;
import java.util.List;

public class YoOrderPropertyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public YoOrderPropertyExample() {
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

        public Criteria andOrderBusinessPropertyIsNull() {
            addCriterion("order_business_property is null");
            return (Criteria) this;
        }

        public Criteria andOrderBusinessPropertyIsNotNull() {
            addCriterion("order_business_property is not null");
            return (Criteria) this;
        }

        public Criteria andOrderBusinessPropertyEqualTo(String value) {
            addCriterion("order_business_property =", value, "orderBusinessProperty");
            return (Criteria) this;
        }

        public Criteria andOrderBusinessPropertyNotEqualTo(String value) {
            addCriterion("order_business_property <>", value, "orderBusinessProperty");
            return (Criteria) this;
        }

        public Criteria andOrderBusinessPropertyGreaterThan(String value) {
            addCriterion("order_business_property >", value, "orderBusinessProperty");
            return (Criteria) this;
        }

        public Criteria andOrderBusinessPropertyGreaterThanOrEqualTo(String value) {
            addCriterion("order_business_property >=", value, "orderBusinessProperty");
            return (Criteria) this;
        }

        public Criteria andOrderBusinessPropertyLessThan(String value) {
            addCriterion("order_business_property <", value, "orderBusinessProperty");
            return (Criteria) this;
        }

        public Criteria andOrderBusinessPropertyLessThanOrEqualTo(String value) {
            addCriterion("order_business_property <=", value, "orderBusinessProperty");
            return (Criteria) this;
        }

        public Criteria andOrderBusinessPropertyLike(String value) {
            addCriterion("order_business_property like", value, "orderBusinessProperty");
            return (Criteria) this;
        }

        public Criteria andOrderBusinessPropertyNotLike(String value) {
            addCriterion("order_business_property not like", value, "orderBusinessProperty");
            return (Criteria) this;
        }

        public Criteria andOrderBusinessPropertyIn(List<String> values) {
            addCriterion("order_business_property in", values, "orderBusinessProperty");
            return (Criteria) this;
        }

        public Criteria andOrderBusinessPropertyNotIn(List<String> values) {
            addCriterion("order_business_property not in", values, "orderBusinessProperty");
            return (Criteria) this;
        }

        public Criteria andOrderBusinessPropertyBetween(String value1, String value2) {
            addCriterion("order_business_property between", value1, value2, "orderBusinessProperty");
            return (Criteria) this;
        }

        public Criteria andOrderBusinessPropertyNotBetween(String value1, String value2) {
            addCriterion("order_business_property not between", value1, value2, "orderBusinessProperty");
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