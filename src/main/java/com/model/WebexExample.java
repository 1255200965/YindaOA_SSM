package com.model;

import java.util.ArrayList;
import java.util.List;

public class WebexExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WebexExample() {
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

        public Criteria andMeetingCountIsNull() {
            addCriterion("meeting_count is null");
            return (Criteria) this;
        }

        public Criteria andMeetingCountIsNotNull() {
            addCriterion("meeting_count is not null");
            return (Criteria) this;
        }

        public Criteria andMeetingCountEqualTo(String value) {
            addCriterion("meeting_count =", value, "meetingCount");
            return (Criteria) this;
        }

        public Criteria andMeetingCountNotEqualTo(String value) {
            addCriterion("meeting_count <>", value, "meetingCount");
            return (Criteria) this;
        }

        public Criteria andMeetingCountGreaterThan(String value) {
            addCriterion("meeting_count >", value, "meetingCount");
            return (Criteria) this;
        }

        public Criteria andMeetingCountGreaterThanOrEqualTo(String value) {
            addCriterion("meeting_count >=", value, "meetingCount");
            return (Criteria) this;
        }

        public Criteria andMeetingCountLessThan(String value) {
            addCriterion("meeting_count <", value, "meetingCount");
            return (Criteria) this;
        }

        public Criteria andMeetingCountLessThanOrEqualTo(String value) {
            addCriterion("meeting_count <=", value, "meetingCount");
            return (Criteria) this;
        }

        public Criteria andMeetingCountLike(String value) {
            addCriterion("meeting_count like", value, "meetingCount");
            return (Criteria) this;
        }

        public Criteria andMeetingCountNotLike(String value) {
            addCriterion("meeting_count not like", value, "meetingCount");
            return (Criteria) this;
        }

        public Criteria andMeetingCountIn(List<String> values) {
            addCriterion("meeting_count in", values, "meetingCount");
            return (Criteria) this;
        }

        public Criteria andMeetingCountNotIn(List<String> values) {
            addCriterion("meeting_count not in", values, "meetingCount");
            return (Criteria) this;
        }

        public Criteria andMeetingCountBetween(String value1, String value2) {
            addCriterion("meeting_count between", value1, value2, "meetingCount");
            return (Criteria) this;
        }

        public Criteria andMeetingCountNotBetween(String value1, String value2) {
            addCriterion("meeting_count not between", value1, value2, "meetingCount");
            return (Criteria) this;
        }

        public Criteria andMeetingDescIsNull() {
            addCriterion("meeting_desc is null");
            return (Criteria) this;
        }

        public Criteria andMeetingDescIsNotNull() {
            addCriterion("meeting_desc is not null");
            return (Criteria) this;
        }

        public Criteria andMeetingDescEqualTo(String value) {
            addCriterion("meeting_desc =", value, "meetingDesc");
            return (Criteria) this;
        }

        public Criteria andMeetingDescNotEqualTo(String value) {
            addCriterion("meeting_desc <>", value, "meetingDesc");
            return (Criteria) this;
        }

        public Criteria andMeetingDescGreaterThan(String value) {
            addCriterion("meeting_desc >", value, "meetingDesc");
            return (Criteria) this;
        }

        public Criteria andMeetingDescGreaterThanOrEqualTo(String value) {
            addCriterion("meeting_desc >=", value, "meetingDesc");
            return (Criteria) this;
        }

        public Criteria andMeetingDescLessThan(String value) {
            addCriterion("meeting_desc <", value, "meetingDesc");
            return (Criteria) this;
        }

        public Criteria andMeetingDescLessThanOrEqualTo(String value) {
            addCriterion("meeting_desc <=", value, "meetingDesc");
            return (Criteria) this;
        }

        public Criteria andMeetingDescLike(String value) {
            addCriterion("meeting_desc like", value, "meetingDesc");
            return (Criteria) this;
        }

        public Criteria andMeetingDescNotLike(String value) {
            addCriterion("meeting_desc not like", value, "meetingDesc");
            return (Criteria) this;
        }

        public Criteria andMeetingDescIn(List<String> values) {
            addCriterion("meeting_desc in", values, "meetingDesc");
            return (Criteria) this;
        }

        public Criteria andMeetingDescNotIn(List<String> values) {
            addCriterion("meeting_desc not in", values, "meetingDesc");
            return (Criteria) this;
        }

        public Criteria andMeetingDescBetween(String value1, String value2) {
            addCriterion("meeting_desc between", value1, value2, "meetingDesc");
            return (Criteria) this;
        }

        public Criteria andMeetingDescNotBetween(String value1, String value2) {
            addCriterion("meeting_desc not between", value1, value2, "meetingDesc");
            return (Criteria) this;
        }

        public Criteria andMeetingLengthIsNull() {
            addCriterion("meeting_length is null");
            return (Criteria) this;
        }

        public Criteria andMeetingLengthIsNotNull() {
            addCriterion("meeting_length is not null");
            return (Criteria) this;
        }

        public Criteria andMeetingLengthEqualTo(String value) {
            addCriterion("meeting_length =", value, "meetingLength");
            return (Criteria) this;
        }

        public Criteria andMeetingLengthNotEqualTo(String value) {
            addCriterion("meeting_length <>", value, "meetingLength");
            return (Criteria) this;
        }

        public Criteria andMeetingLengthGreaterThan(String value) {
            addCriterion("meeting_length >", value, "meetingLength");
            return (Criteria) this;
        }

        public Criteria andMeetingLengthGreaterThanOrEqualTo(String value) {
            addCriterion("meeting_length >=", value, "meetingLength");
            return (Criteria) this;
        }

        public Criteria andMeetingLengthLessThan(String value) {
            addCriterion("meeting_length <", value, "meetingLength");
            return (Criteria) this;
        }

        public Criteria andMeetingLengthLessThanOrEqualTo(String value) {
            addCriterion("meeting_length <=", value, "meetingLength");
            return (Criteria) this;
        }

        public Criteria andMeetingLengthLike(String value) {
            addCriterion("meeting_length like", value, "meetingLength");
            return (Criteria) this;
        }

        public Criteria andMeetingLengthNotLike(String value) {
            addCriterion("meeting_length not like", value, "meetingLength");
            return (Criteria) this;
        }

        public Criteria andMeetingLengthIn(List<String> values) {
            addCriterion("meeting_length in", values, "meetingLength");
            return (Criteria) this;
        }

        public Criteria andMeetingLengthNotIn(List<String> values) {
            addCriterion("meeting_length not in", values, "meetingLength");
            return (Criteria) this;
        }

        public Criteria andMeetingLengthBetween(String value1, String value2) {
            addCriterion("meeting_length between", value1, value2, "meetingLength");
            return (Criteria) this;
        }

        public Criteria andMeetingLengthNotBetween(String value1, String value2) {
            addCriterion("meeting_length not between", value1, value2, "meetingLength");
            return (Criteria) this;
        }

        public Criteria andMeetingNameIsNull() {
            addCriterion("meeting_name is null");
            return (Criteria) this;
        }

        public Criteria andMeetingNameIsNotNull() {
            addCriterion("meeting_name is not null");
            return (Criteria) this;
        }

        public Criteria andMeetingNameEqualTo(String value) {
            addCriterion("meeting_name =", value, "meetingName");
            return (Criteria) this;
        }

        public Criteria andMeetingNameNotEqualTo(String value) {
            addCriterion("meeting_name <>", value, "meetingName");
            return (Criteria) this;
        }

        public Criteria andMeetingNameGreaterThan(String value) {
            addCriterion("meeting_name >", value, "meetingName");
            return (Criteria) this;
        }

        public Criteria andMeetingNameGreaterThanOrEqualTo(String value) {
            addCriterion("meeting_name >=", value, "meetingName");
            return (Criteria) this;
        }

        public Criteria andMeetingNameLessThan(String value) {
            addCriterion("meeting_name <", value, "meetingName");
            return (Criteria) this;
        }

        public Criteria andMeetingNameLessThanOrEqualTo(String value) {
            addCriterion("meeting_name <=", value, "meetingName");
            return (Criteria) this;
        }

        public Criteria andMeetingNameLike(String value) {
            addCriterion("meeting_name like", value, "meetingName");
            return (Criteria) this;
        }

        public Criteria andMeetingNameNotLike(String value) {
            addCriterion("meeting_name not like", value, "meetingName");
            return (Criteria) this;
        }

        public Criteria andMeetingNameIn(List<String> values) {
            addCriterion("meeting_name in", values, "meetingName");
            return (Criteria) this;
        }

        public Criteria andMeetingNameNotIn(List<String> values) {
            addCriterion("meeting_name not in", values, "meetingName");
            return (Criteria) this;
        }

        public Criteria andMeetingNameBetween(String value1, String value2) {
            addCriterion("meeting_name between", value1, value2, "meetingName");
            return (Criteria) this;
        }

        public Criteria andMeetingNameNotBetween(String value1, String value2) {
            addCriterion("meeting_name not between", value1, value2, "meetingName");
            return (Criteria) this;
        }

        public Criteria andMeetingPasswordIsNull() {
            addCriterion("meeting_password is null");
            return (Criteria) this;
        }

        public Criteria andMeetingPasswordIsNotNull() {
            addCriterion("meeting_password is not null");
            return (Criteria) this;
        }

        public Criteria andMeetingPasswordEqualTo(String value) {
            addCriterion("meeting_password =", value, "meetingPassword");
            return (Criteria) this;
        }

        public Criteria andMeetingPasswordNotEqualTo(String value) {
            addCriterion("meeting_password <>", value, "meetingPassword");
            return (Criteria) this;
        }

        public Criteria andMeetingPasswordGreaterThan(String value) {
            addCriterion("meeting_password >", value, "meetingPassword");
            return (Criteria) this;
        }

        public Criteria andMeetingPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("meeting_password >=", value, "meetingPassword");
            return (Criteria) this;
        }

        public Criteria andMeetingPasswordLessThan(String value) {
            addCriterion("meeting_password <", value, "meetingPassword");
            return (Criteria) this;
        }

        public Criteria andMeetingPasswordLessThanOrEqualTo(String value) {
            addCriterion("meeting_password <=", value, "meetingPassword");
            return (Criteria) this;
        }

        public Criteria andMeetingPasswordLike(String value) {
            addCriterion("meeting_password like", value, "meetingPassword");
            return (Criteria) this;
        }

        public Criteria andMeetingPasswordNotLike(String value) {
            addCriterion("meeting_password not like", value, "meetingPassword");
            return (Criteria) this;
        }

        public Criteria andMeetingPasswordIn(List<String> values) {
            addCriterion("meeting_password in", values, "meetingPassword");
            return (Criteria) this;
        }

        public Criteria andMeetingPasswordNotIn(List<String> values) {
            addCriterion("meeting_password not in", values, "meetingPassword");
            return (Criteria) this;
        }

        public Criteria andMeetingPasswordBetween(String value1, String value2) {
            addCriterion("meeting_password between", value1, value2, "meetingPassword");
            return (Criteria) this;
        }

        public Criteria andMeetingPasswordNotBetween(String value1, String value2) {
            addCriterion("meeting_password not between", value1, value2, "meetingPassword");
            return (Criteria) this;
        }

        public Criteria andMeetingTimeIsNull() {
            addCriterion("meeting_time is null");
            return (Criteria) this;
        }

        public Criteria andMeetingTimeIsNotNull() {
            addCriterion("meeting_time is not null");
            return (Criteria) this;
        }

        public Criteria andMeetingTimeEqualTo(String value) {
            addCriterion("meeting_time =", value, "meetingTime");
            return (Criteria) this;
        }

        public Criteria andMeetingTimeNotEqualTo(String value) {
            addCriterion("meeting_time <>", value, "meetingTime");
            return (Criteria) this;
        }

        public Criteria andMeetingTimeGreaterThan(String value) {
            addCriterion("meeting_time >", value, "meetingTime");
            return (Criteria) this;
        }

        public Criteria andMeetingTimeGreaterThanOrEqualTo(String value) {
            addCriterion("meeting_time >=", value, "meetingTime");
            return (Criteria) this;
        }

        public Criteria andMeetingTimeLessThan(String value) {
            addCriterion("meeting_time <", value, "meetingTime");
            return (Criteria) this;
        }

        public Criteria andMeetingTimeLessThanOrEqualTo(String value) {
            addCriterion("meeting_time <=", value, "meetingTime");
            return (Criteria) this;
        }

        public Criteria andMeetingTimeLike(String value) {
            addCriterion("meeting_time like", value, "meetingTime");
            return (Criteria) this;
        }

        public Criteria andMeetingTimeNotLike(String value) {
            addCriterion("meeting_time not like", value, "meetingTime");
            return (Criteria) this;
        }

        public Criteria andMeetingTimeIn(List<String> values) {
            addCriterion("meeting_time in", values, "meetingTime");
            return (Criteria) this;
        }

        public Criteria andMeetingTimeNotIn(List<String> values) {
            addCriterion("meeting_time not in", values, "meetingTime");
            return (Criteria) this;
        }

        public Criteria andMeetingTimeBetween(String value1, String value2) {
            addCriterion("meeting_time between", value1, value2, "meetingTime");
            return (Criteria) this;
        }

        public Criteria andMeetingTimeNotBetween(String value1, String value2) {
            addCriterion("meeting_time not between", value1, value2, "meetingTime");
            return (Criteria) this;
        }

        public Criteria andSessionKeyIsNull() {
            addCriterion("session_key is null");
            return (Criteria) this;
        }

        public Criteria andSessionKeyIsNotNull() {
            addCriterion("session_key is not null");
            return (Criteria) this;
        }

        public Criteria andSessionKeyEqualTo(String value) {
            addCriterion("session_key =", value, "sessionKey");
            return (Criteria) this;
        }

        public Criteria andSessionKeyNotEqualTo(String value) {
            addCriterion("session_key <>", value, "sessionKey");
            return (Criteria) this;
        }

        public Criteria andSessionKeyGreaterThan(String value) {
            addCriterion("session_key >", value, "sessionKey");
            return (Criteria) this;
        }

        public Criteria andSessionKeyGreaterThanOrEqualTo(String value) {
            addCriterion("session_key >=", value, "sessionKey");
            return (Criteria) this;
        }

        public Criteria andSessionKeyLessThan(String value) {
            addCriterion("session_key <", value, "sessionKey");
            return (Criteria) this;
        }

        public Criteria andSessionKeyLessThanOrEqualTo(String value) {
            addCriterion("session_key <=", value, "sessionKey");
            return (Criteria) this;
        }

        public Criteria andSessionKeyLike(String value) {
            addCriterion("session_key like", value, "sessionKey");
            return (Criteria) this;
        }

        public Criteria andSessionKeyNotLike(String value) {
            addCriterion("session_key not like", value, "sessionKey");
            return (Criteria) this;
        }

        public Criteria andSessionKeyIn(List<String> values) {
            addCriterion("session_key in", values, "sessionKey");
            return (Criteria) this;
        }

        public Criteria andSessionKeyNotIn(List<String> values) {
            addCriterion("session_key not in", values, "sessionKey");
            return (Criteria) this;
        }

        public Criteria andSessionKeyBetween(String value1, String value2) {
            addCriterion("session_key between", value1, value2, "sessionKey");
            return (Criteria) this;
        }

        public Criteria andSessionKeyNotBetween(String value1, String value2) {
            addCriterion("session_key not between", value1, value2, "sessionKey");
            return (Criteria) this;
        }

        public Criteria andTrainNowNumberIsNull() {
            addCriterion("train_now_number is null");
            return (Criteria) this;
        }

        public Criteria andTrainNowNumberIsNotNull() {
            addCriterion("train_now_number is not null");
            return (Criteria) this;
        }

        public Criteria andTrainNowNumberEqualTo(Integer value) {
            addCriterion("train_now_number =", value, "trainNowNumber");
            return (Criteria) this;
        }

        public Criteria andTrainNowNumberNotEqualTo(Integer value) {
            addCriterion("train_now_number <>", value, "trainNowNumber");
            return (Criteria) this;
        }

        public Criteria andTrainNowNumberGreaterThan(Integer value) {
            addCriterion("train_now_number >", value, "trainNowNumber");
            return (Criteria) this;
        }

        public Criteria andTrainNowNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("train_now_number >=", value, "trainNowNumber");
            return (Criteria) this;
        }

        public Criteria andTrainNowNumberLessThan(Integer value) {
            addCriterion("train_now_number <", value, "trainNowNumber");
            return (Criteria) this;
        }

        public Criteria andTrainNowNumberLessThanOrEqualTo(Integer value) {
            addCriterion("train_now_number <=", value, "trainNowNumber");
            return (Criteria) this;
        }

        public Criteria andTrainNowNumberIn(List<Integer> values) {
            addCriterion("train_now_number in", values, "trainNowNumber");
            return (Criteria) this;
        }

        public Criteria andTrainNowNumberNotIn(List<Integer> values) {
            addCriterion("train_now_number not in", values, "trainNowNumber");
            return (Criteria) this;
        }

        public Criteria andTrainNowNumberBetween(Integer value1, Integer value2) {
            addCriterion("train_now_number between", value1, value2, "trainNowNumber");
            return (Criteria) this;
        }

        public Criteria andTrainNowNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("train_now_number not between", value1, value2, "trainNowNumber");
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