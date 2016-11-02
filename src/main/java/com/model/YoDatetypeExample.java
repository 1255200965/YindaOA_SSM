package com.model;

import java.util.ArrayList;
import java.util.List;

public class YoDatetypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public YoDatetypeExample() {
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

        public Criteria andDateIdIsNull() {
            addCriterion("date_id is null");
            return (Criteria) this;
        }

        public Criteria andDateIdIsNotNull() {
            addCriterion("date_id is not null");
            return (Criteria) this;
        }

        public Criteria andDateIdEqualTo(Integer value) {
            addCriterion("date_id =", value, "dateId");
            return (Criteria) this;
        }

        public Criteria andDateIdNotEqualTo(Integer value) {
            addCriterion("date_id <>", value, "dateId");
            return (Criteria) this;
        }

        public Criteria andDateIdGreaterThan(Integer value) {
            addCriterion("date_id >", value, "dateId");
            return (Criteria) this;
        }

        public Criteria andDateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("date_id >=", value, "dateId");
            return (Criteria) this;
        }

        public Criteria andDateIdLessThan(Integer value) {
            addCriterion("date_id <", value, "dateId");
            return (Criteria) this;
        }

        public Criteria andDateIdLessThanOrEqualTo(Integer value) {
            addCriterion("date_id <=", value, "dateId");
            return (Criteria) this;
        }

        public Criteria andDateIdIn(List<Integer> values) {
            addCriterion("date_id in", values, "dateId");
            return (Criteria) this;
        }

        public Criteria andDateIdNotIn(List<Integer> values) {
            addCriterion("date_id not in", values, "dateId");
            return (Criteria) this;
        }

        public Criteria andDateIdBetween(Integer value1, Integer value2) {
            addCriterion("date_id between", value1, value2, "dateId");
            return (Criteria) this;
        }

        public Criteria andDateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("date_id not between", value1, value2, "dateId");
            return (Criteria) this;
        }

        public Criteria andDateTypeIsNull() {
            addCriterion("date_type is null");
            return (Criteria) this;
        }

        public Criteria andDateTypeIsNotNull() {
            addCriterion("date_type is not null");
            return (Criteria) this;
        }

        public Criteria andDateTypeEqualTo(String value) {
            addCriterion("date_type =", value, "dateType");
            return (Criteria) this;
        }

        public Criteria andDateTypeNotEqualTo(String value) {
            addCriterion("date_type <>", value, "dateType");
            return (Criteria) this;
        }

        public Criteria andDateTypeGreaterThan(String value) {
            addCriterion("date_type >", value, "dateType");
            return (Criteria) this;
        }

        public Criteria andDateTypeGreaterThanOrEqualTo(String value) {
            addCriterion("date_type >=", value, "dateType");
            return (Criteria) this;
        }

        public Criteria andDateTypeLessThan(String value) {
            addCriterion("date_type <", value, "dateType");
            return (Criteria) this;
        }

        public Criteria andDateTypeLessThanOrEqualTo(String value) {
            addCriterion("date_type <=", value, "dateType");
            return (Criteria) this;
        }

        public Criteria andDateTypeLike(String value) {
            addCriterion("date_type like", value, "dateType");
            return (Criteria) this;
        }

        public Criteria andDateTypeNotLike(String value) {
            addCriterion("date_type not like", value, "dateType");
            return (Criteria) this;
        }

        public Criteria andDateTypeIn(List<String> values) {
            addCriterion("date_type in", values, "dateType");
            return (Criteria) this;
        }

        public Criteria andDateTypeNotIn(List<String> values) {
            addCriterion("date_type not in", values, "dateType");
            return (Criteria) this;
        }

        public Criteria andDateTypeBetween(String value1, String value2) {
            addCriterion("date_type between", value1, value2, "dateType");
            return (Criteria) this;
        }

        public Criteria andDateTypeNotBetween(String value1, String value2) {
            addCriterion("date_type not between", value1, value2, "dateType");
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