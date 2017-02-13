package com.model;

import java.util.ArrayList;
import java.util.List;

public class PrizeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PrizeExample() {
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

        public Criteria andPrizetypeIsNull() {
            addCriterion("prizeType is null");
            return (Criteria) this;
        }

        public Criteria andPrizetypeIsNotNull() {
            addCriterion("prizeType is not null");
            return (Criteria) this;
        }

        public Criteria andPrizetypeEqualTo(String value) {
            addCriterion("prizeType =", value, "prizetype");
            return (Criteria) this;
        }

        public Criteria andPrizetypeNotEqualTo(String value) {
            addCriterion("prizeType <>", value, "prizetype");
            return (Criteria) this;
        }

        public Criteria andPrizetypeGreaterThan(String value) {
            addCriterion("prizeType >", value, "prizetype");
            return (Criteria) this;
        }

        public Criteria andPrizetypeGreaterThanOrEqualTo(String value) {
            addCriterion("prizeType >=", value, "prizetype");
            return (Criteria) this;
        }

        public Criteria andPrizetypeLessThan(String value) {
            addCriterion("prizeType <", value, "prizetype");
            return (Criteria) this;
        }

        public Criteria andPrizetypeLessThanOrEqualTo(String value) {
            addCriterion("prizeType <=", value, "prizetype");
            return (Criteria) this;
        }

        public Criteria andPrizetypeLike(String value) {
            addCriterion("prizeType like", value, "prizetype");
            return (Criteria) this;
        }

        public Criteria andPrizetypeNotLike(String value) {
            addCriterion("prizeType not like", value, "prizetype");
            return (Criteria) this;
        }

        public Criteria andPrizetypeIn(List<String> values) {
            addCriterion("prizeType in", values, "prizetype");
            return (Criteria) this;
        }

        public Criteria andPrizetypeNotIn(List<String> values) {
            addCriterion("prizeType not in", values, "prizetype");
            return (Criteria) this;
        }

        public Criteria andPrizetypeBetween(String value1, String value2) {
            addCriterion("prizeType between", value1, value2, "prizetype");
            return (Criteria) this;
        }

        public Criteria andPrizetypeNotBetween(String value1, String value2) {
            addCriterion("prizeType not between", value1, value2, "prizetype");
            return (Criteria) this;
        }

        public Criteria andPrizecontentIsNull() {
            addCriterion("prizeContent is null");
            return (Criteria) this;
        }

        public Criteria andPrizecontentIsNotNull() {
            addCriterion("prizeContent is not null");
            return (Criteria) this;
        }

        public Criteria andPrizecontentEqualTo(String value) {
            addCriterion("prizeContent =", value, "prizecontent");
            return (Criteria) this;
        }

        public Criteria andPrizecontentNotEqualTo(String value) {
            addCriterion("prizeContent <>", value, "prizecontent");
            return (Criteria) this;
        }

        public Criteria andPrizecontentGreaterThan(String value) {
            addCriterion("prizeContent >", value, "prizecontent");
            return (Criteria) this;
        }

        public Criteria andPrizecontentGreaterThanOrEqualTo(String value) {
            addCriterion("prizeContent >=", value, "prizecontent");
            return (Criteria) this;
        }

        public Criteria andPrizecontentLessThan(String value) {
            addCriterion("prizeContent <", value, "prizecontent");
            return (Criteria) this;
        }

        public Criteria andPrizecontentLessThanOrEqualTo(String value) {
            addCriterion("prizeContent <=", value, "prizecontent");
            return (Criteria) this;
        }

        public Criteria andPrizecontentLike(String value) {
            addCriterion("prizeContent like", value, "prizecontent");
            return (Criteria) this;
        }

        public Criteria andPrizecontentNotLike(String value) {
            addCriterion("prizeContent not like", value, "prizecontent");
            return (Criteria) this;
        }

        public Criteria andPrizecontentIn(List<String> values) {
            addCriterion("prizeContent in", values, "prizecontent");
            return (Criteria) this;
        }

        public Criteria andPrizecontentNotIn(List<String> values) {
            addCriterion("prizeContent not in", values, "prizecontent");
            return (Criteria) this;
        }

        public Criteria andPrizecontentBetween(String value1, String value2) {
            addCriterion("prizeContent between", value1, value2, "prizecontent");
            return (Criteria) this;
        }

        public Criteria andPrizecontentNotBetween(String value1, String value2) {
            addCriterion("prizeContent not between", value1, value2, "prizecontent");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
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