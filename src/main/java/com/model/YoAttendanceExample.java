package com.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class YoAttendanceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public YoAttendanceExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userid like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userid not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andCorpidIsNull() {
            addCriterion("corpId is null");
            return (Criteria) this;
        }

        public Criteria andCorpidIsNotNull() {
            addCriterion("corpId is not null");
            return (Criteria) this;
        }

        public Criteria andCorpidEqualTo(String value) {
            addCriterion("corpId =", value, "corpid");
            return (Criteria) this;
        }

        public Criteria andCorpidNotEqualTo(String value) {
            addCriterion("corpId <>", value, "corpid");
            return (Criteria) this;
        }

        public Criteria andCorpidGreaterThan(String value) {
            addCriterion("corpId >", value, "corpid");
            return (Criteria) this;
        }

        public Criteria andCorpidGreaterThanOrEqualTo(String value) {
            addCriterion("corpId >=", value, "corpid");
            return (Criteria) this;
        }

        public Criteria andCorpidLessThan(String value) {
            addCriterion("corpId <", value, "corpid");
            return (Criteria) this;
        }

        public Criteria andCorpidLessThanOrEqualTo(String value) {
            addCriterion("corpId <=", value, "corpid");
            return (Criteria) this;
        }

        public Criteria andCorpidLike(String value) {
            addCriterion("corpId like", value, "corpid");
            return (Criteria) this;
        }

        public Criteria andCorpidNotLike(String value) {
            addCriterion("corpId not like", value, "corpid");
            return (Criteria) this;
        }

        public Criteria andCorpidIn(List<String> values) {
            addCriterion("corpId in", values, "corpid");
            return (Criteria) this;
        }

        public Criteria andCorpidNotIn(List<String> values) {
            addCriterion("corpId not in", values, "corpid");
            return (Criteria) this;
        }

        public Criteria andCorpidBetween(String value1, String value2) {
            addCriterion("corpId between", value1, value2, "corpid");
            return (Criteria) this;
        }

        public Criteria andCorpidNotBetween(String value1, String value2) {
            addCriterion("corpId not between", value1, value2, "corpid");
            return (Criteria) this;
        }

        public Criteria andGroupidIsNull() {
            addCriterion("groupId is null");
            return (Criteria) this;
        }

        public Criteria andGroupidIsNotNull() {
            addCriterion("groupId is not null");
            return (Criteria) this;
        }

        public Criteria andGroupidEqualTo(String value) {
            addCriterion("groupId =", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidNotEqualTo(String value) {
            addCriterion("groupId <>", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidGreaterThan(String value) {
            addCriterion("groupId >", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidGreaterThanOrEqualTo(String value) {
            addCriterion("groupId >=", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidLessThan(String value) {
            addCriterion("groupId <", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidLessThanOrEqualTo(String value) {
            addCriterion("groupId <=", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidLike(String value) {
            addCriterion("groupId like", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidNotLike(String value) {
            addCriterion("groupId not like", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidIn(List<String> values) {
            addCriterion("groupId in", values, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidNotIn(List<String> values) {
            addCriterion("groupId not in", values, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidBetween(String value1, String value2) {
            addCriterion("groupId between", value1, value2, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidNotBetween(String value1, String value2) {
            addCriterion("groupId not between", value1, value2, "groupid");
            return (Criteria) this;
        }

        public Criteria andPlanidIsNull() {
            addCriterion("planId is null");
            return (Criteria) this;
        }

        public Criteria andPlanidIsNotNull() {
            addCriterion("planId is not null");
            return (Criteria) this;
        }

        public Criteria andPlanidEqualTo(String value) {
            addCriterion("planId =", value, "planid");
            return (Criteria) this;
        }

        public Criteria andPlanidNotEqualTo(String value) {
            addCriterion("planId <>", value, "planid");
            return (Criteria) this;
        }

        public Criteria andPlanidGreaterThan(String value) {
            addCriterion("planId >", value, "planid");
            return (Criteria) this;
        }

        public Criteria andPlanidGreaterThanOrEqualTo(String value) {
            addCriterion("planId >=", value, "planid");
            return (Criteria) this;
        }

        public Criteria andPlanidLessThan(String value) {
            addCriterion("planId <", value, "planid");
            return (Criteria) this;
        }

        public Criteria andPlanidLessThanOrEqualTo(String value) {
            addCriterion("planId <=", value, "planid");
            return (Criteria) this;
        }

        public Criteria andPlanidLike(String value) {
            addCriterion("planId like", value, "planid");
            return (Criteria) this;
        }

        public Criteria andPlanidNotLike(String value) {
            addCriterion("planId not like", value, "planid");
            return (Criteria) this;
        }

        public Criteria andPlanidIn(List<String> values) {
            addCriterion("planId in", values, "planid");
            return (Criteria) this;
        }

        public Criteria andPlanidNotIn(List<String> values) {
            addCriterion("planId not in", values, "planid");
            return (Criteria) this;
        }

        public Criteria andPlanidBetween(String value1, String value2) {
            addCriterion("planId between", value1, value2, "planid");
            return (Criteria) this;
        }

        public Criteria andPlanidNotBetween(String value1, String value2) {
            addCriterion("planId not between", value1, value2, "planid");
            return (Criteria) this;
        }

        public Criteria andRecordidIsNull() {
            addCriterion("recordId is null");
            return (Criteria) this;
        }

        public Criteria andRecordidIsNotNull() {
            addCriterion("recordId is not null");
            return (Criteria) this;
        }

        public Criteria andRecordidEqualTo(String value) {
            addCriterion("recordId =", value, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidNotEqualTo(String value) {
            addCriterion("recordId <>", value, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidGreaterThan(String value) {
            addCriterion("recordId >", value, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidGreaterThanOrEqualTo(String value) {
            addCriterion("recordId >=", value, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidLessThan(String value) {
            addCriterion("recordId <", value, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidLessThanOrEqualTo(String value) {
            addCriterion("recordId <=", value, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidLike(String value) {
            addCriterion("recordId like", value, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidNotLike(String value) {
            addCriterion("recordId not like", value, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidIn(List<String> values) {
            addCriterion("recordId in", values, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidNotIn(List<String> values) {
            addCriterion("recordId not in", values, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidBetween(String value1, String value2) {
            addCriterion("recordId between", value1, value2, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidNotBetween(String value1, String value2) {
            addCriterion("recordId not between", value1, value2, "recordid");
            return (Criteria) this;
        }

        public Criteria andAttaddressIsNull() {
            addCriterion("attaddress is null");
            return (Criteria) this;
        }

        public Criteria andAttaddressIsNotNull() {
            addCriterion("attaddress is not null");
            return (Criteria) this;
        }

        public Criteria andAttaddressEqualTo(String value) {
            addCriterion("attaddress =", value, "attaddress");
            return (Criteria) this;
        }

        public Criteria andAttaddressNotEqualTo(String value) {
            addCriterion("attaddress <>", value, "attaddress");
            return (Criteria) this;
        }

        public Criteria andAttaddressGreaterThan(String value) {
            addCriterion("attaddress >", value, "attaddress");
            return (Criteria) this;
        }

        public Criteria andAttaddressGreaterThanOrEqualTo(String value) {
            addCriterion("attaddress >=", value, "attaddress");
            return (Criteria) this;
        }

        public Criteria andAttaddressLessThan(String value) {
            addCriterion("attaddress <", value, "attaddress");
            return (Criteria) this;
        }

        public Criteria andAttaddressLessThanOrEqualTo(String value) {
            addCriterion("attaddress <=", value, "attaddress");
            return (Criteria) this;
        }

        public Criteria andAttaddressLike(String value) {
            addCriterion("attaddress like", value, "attaddress");
            return (Criteria) this;
        }

        public Criteria andAttaddressNotLike(String value) {
            addCriterion("attaddress not like", value, "attaddress");
            return (Criteria) this;
        }

        public Criteria andAttaddressIn(List<String> values) {
            addCriterion("attaddress in", values, "attaddress");
            return (Criteria) this;
        }

        public Criteria andAttaddressNotIn(List<String> values) {
            addCriterion("attaddress not in", values, "attaddress");
            return (Criteria) this;
        }

        public Criteria andAttaddressBetween(String value1, String value2) {
            addCriterion("attaddress between", value1, value2, "attaddress");
            return (Criteria) this;
        }

        public Criteria andAttaddressNotBetween(String value1, String value2) {
            addCriterion("attaddress not between", value1, value2, "attaddress");
            return (Criteria) this;
        }

        public Criteria andWorkdateIsNull() {
            addCriterion("workDate is null");
            return (Criteria) this;
        }

        public Criteria andWorkdateIsNotNull() {
            addCriterion("workDate is not null");
            return (Criteria) this;
        }

        public Criteria andWorkdateEqualTo(Date value) {
            addCriterionForJDBCDate("workDate =", value, "workdate");
            return (Criteria) this;
        }

        public Criteria andWorkdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("workDate <>", value, "workdate");
            return (Criteria) this;
        }

        public Criteria andWorkdateGreaterThan(Date value) {
            addCriterionForJDBCDate("workDate >", value, "workdate");
            return (Criteria) this;
        }

        public Criteria andWorkdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("workDate >=", value, "workdate");
            return (Criteria) this;
        }

        public Criteria andWorkdateLessThan(Date value) {
            addCriterionForJDBCDate("workDate <", value, "workdate");
            return (Criteria) this;
        }

        public Criteria andWorkdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("workDate <=", value, "workdate");
            return (Criteria) this;
        }

        public Criteria andWorkdateIn(List<Date> values) {
            addCriterionForJDBCDate("workDate in", values, "workdate");
            return (Criteria) this;
        }

        public Criteria andWorkdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("workDate not in", values, "workdate");
            return (Criteria) this;
        }

        public Criteria andWorkdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("workDate between", value1, value2, "workdate");
            return (Criteria) this;
        }

        public Criteria andWorkdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("workDate not between", value1, value2, "workdate");
            return (Criteria) this;
        }

        public Criteria andChecktypeIsNull() {
            addCriterion("checkType is null");
            return (Criteria) this;
        }

        public Criteria andChecktypeIsNotNull() {
            addCriterion("checkType is not null");
            return (Criteria) this;
        }

        public Criteria andChecktypeEqualTo(String value) {
            addCriterion("checkType =", value, "checktype");
            return (Criteria) this;
        }

        public Criteria andChecktypeNotEqualTo(String value) {
            addCriterion("checkType <>", value, "checktype");
            return (Criteria) this;
        }

        public Criteria andChecktypeGreaterThan(String value) {
            addCriterion("checkType >", value, "checktype");
            return (Criteria) this;
        }

        public Criteria andChecktypeGreaterThanOrEqualTo(String value) {
            addCriterion("checkType >=", value, "checktype");
            return (Criteria) this;
        }

        public Criteria andChecktypeLessThan(String value) {
            addCriterion("checkType <", value, "checktype");
            return (Criteria) this;
        }

        public Criteria andChecktypeLessThanOrEqualTo(String value) {
            addCriterion("checkType <=", value, "checktype");
            return (Criteria) this;
        }

        public Criteria andChecktypeLike(String value) {
            addCriterion("checkType like", value, "checktype");
            return (Criteria) this;
        }

        public Criteria andChecktypeNotLike(String value) {
            addCriterion("checkType not like", value, "checktype");
            return (Criteria) this;
        }

        public Criteria andChecktypeIn(List<String> values) {
            addCriterion("checkType in", values, "checktype");
            return (Criteria) this;
        }

        public Criteria andChecktypeNotIn(List<String> values) {
            addCriterion("checkType not in", values, "checktype");
            return (Criteria) this;
        }

        public Criteria andChecktypeBetween(String value1, String value2) {
            addCriterion("checkType between", value1, value2, "checktype");
            return (Criteria) this;
        }

        public Criteria andChecktypeNotBetween(String value1, String value2) {
            addCriterion("checkType not between", value1, value2, "checktype");
            return (Criteria) this;
        }

        public Criteria andTimeresultIsNull() {
            addCriterion("timeResult is null");
            return (Criteria) this;
        }

        public Criteria andTimeresultIsNotNull() {
            addCriterion("timeResult is not null");
            return (Criteria) this;
        }

        public Criteria andTimeresultEqualTo(String value) {
            addCriterion("timeResult =", value, "timeresult");
            return (Criteria) this;
        }

        public Criteria andTimeresultNotEqualTo(String value) {
            addCriterion("timeResult <>", value, "timeresult");
            return (Criteria) this;
        }

        public Criteria andTimeresultGreaterThan(String value) {
            addCriterion("timeResult >", value, "timeresult");
            return (Criteria) this;
        }

        public Criteria andTimeresultGreaterThanOrEqualTo(String value) {
            addCriterion("timeResult >=", value, "timeresult");
            return (Criteria) this;
        }

        public Criteria andTimeresultLessThan(String value) {
            addCriterion("timeResult <", value, "timeresult");
            return (Criteria) this;
        }

        public Criteria andTimeresultLessThanOrEqualTo(String value) {
            addCriterion("timeResult <=", value, "timeresult");
            return (Criteria) this;
        }

        public Criteria andTimeresultLike(String value) {
            addCriterion("timeResult like", value, "timeresult");
            return (Criteria) this;
        }

        public Criteria andTimeresultNotLike(String value) {
            addCriterion("timeResult not like", value, "timeresult");
            return (Criteria) this;
        }

        public Criteria andTimeresultIn(List<String> values) {
            addCriterion("timeResult in", values, "timeresult");
            return (Criteria) this;
        }

        public Criteria andTimeresultNotIn(List<String> values) {
            addCriterion("timeResult not in", values, "timeresult");
            return (Criteria) this;
        }

        public Criteria andTimeresultBetween(String value1, String value2) {
            addCriterion("timeResult between", value1, value2, "timeresult");
            return (Criteria) this;
        }

        public Criteria andTimeresultNotBetween(String value1, String value2) {
            addCriterion("timeResult not between", value1, value2, "timeresult");
            return (Criteria) this;
        }

        public Criteria andLocationresultIsNull() {
            addCriterion("locationResult is null");
            return (Criteria) this;
        }

        public Criteria andLocationresultIsNotNull() {
            addCriterion("locationResult is not null");
            return (Criteria) this;
        }

        public Criteria andLocationresultEqualTo(String value) {
            addCriterion("locationResult =", value, "locationresult");
            return (Criteria) this;
        }

        public Criteria andLocationresultNotEqualTo(String value) {
            addCriterion("locationResult <>", value, "locationresult");
            return (Criteria) this;
        }

        public Criteria andLocationresultGreaterThan(String value) {
            addCriterion("locationResult >", value, "locationresult");
            return (Criteria) this;
        }

        public Criteria andLocationresultGreaterThanOrEqualTo(String value) {
            addCriterion("locationResult >=", value, "locationresult");
            return (Criteria) this;
        }

        public Criteria andLocationresultLessThan(String value) {
            addCriterion("locationResult <", value, "locationresult");
            return (Criteria) this;
        }

        public Criteria andLocationresultLessThanOrEqualTo(String value) {
            addCriterion("locationResult <=", value, "locationresult");
            return (Criteria) this;
        }

        public Criteria andLocationresultLike(String value) {
            addCriterion("locationResult like", value, "locationresult");
            return (Criteria) this;
        }

        public Criteria andLocationresultNotLike(String value) {
            addCriterion("locationResult not like", value, "locationresult");
            return (Criteria) this;
        }

        public Criteria andLocationresultIn(List<String> values) {
            addCriterion("locationResult in", values, "locationresult");
            return (Criteria) this;
        }

        public Criteria andLocationresultNotIn(List<String> values) {
            addCriterion("locationResult not in", values, "locationresult");
            return (Criteria) this;
        }

        public Criteria andLocationresultBetween(String value1, String value2) {
            addCriterion("locationResult between", value1, value2, "locationresult");
            return (Criteria) this;
        }

        public Criteria andLocationresultNotBetween(String value1, String value2) {
            addCriterion("locationResult not between", value1, value2, "locationresult");
            return (Criteria) this;
        }

        public Criteria andBasechecktimeIsNull() {
            addCriterion("baseCheckTime is null");
            return (Criteria) this;
        }

        public Criteria andBasechecktimeIsNotNull() {
            addCriterion("baseCheckTime is not null");
            return (Criteria) this;
        }

        public Criteria andBasechecktimeEqualTo(Date value) {
            addCriterion("baseCheckTime =", value, "basechecktime");
            return (Criteria) this;
        }

        public Criteria andBasechecktimeNotEqualTo(Date value) {
            addCriterion("baseCheckTime <>", value, "basechecktime");
            return (Criteria) this;
        }

        public Criteria andBasechecktimeGreaterThan(Date value) {
            addCriterion("baseCheckTime >", value, "basechecktime");
            return (Criteria) this;
        }

        public Criteria andBasechecktimeGreaterThanOrEqualTo(Date value) {
            addCriterion("baseCheckTime >=", value, "basechecktime");
            return (Criteria) this;
        }

        public Criteria andBasechecktimeLessThan(Date value) {
            addCriterion("baseCheckTime <", value, "basechecktime");
            return (Criteria) this;
        }

        public Criteria andBasechecktimeLessThanOrEqualTo(Date value) {
            addCriterion("baseCheckTime <=", value, "basechecktime");
            return (Criteria) this;
        }

        public Criteria andBasechecktimeIn(List<Date> values) {
            addCriterion("baseCheckTime in", values, "basechecktime");
            return (Criteria) this;
        }

        public Criteria andBasechecktimeNotIn(List<Date> values) {
            addCriterion("baseCheckTime not in", values, "basechecktime");
            return (Criteria) this;
        }

        public Criteria andBasechecktimeBetween(Date value1, Date value2) {
            addCriterion("baseCheckTime between", value1, value2, "basechecktime");
            return (Criteria) this;
        }

        public Criteria andBasechecktimeNotBetween(Date value1, Date value2) {
            addCriterion("baseCheckTime not between", value1, value2, "basechecktime");
            return (Criteria) this;
        }

        public Criteria andUserchecktimeIsNull() {
            addCriterion("userCheckTime is null");
            return (Criteria) this;
        }

        public Criteria andUserchecktimeIsNotNull() {
            addCriterion("userCheckTime is not null");
            return (Criteria) this;
        }

        public Criteria andUserchecktimeEqualTo(Date value) {
            addCriterion("userCheckTime =", value, "userchecktime");
            return (Criteria) this;
        }

        public Criteria andUserchecktimeNotEqualTo(Date value) {
            addCriterion("userCheckTime <>", value, "userchecktime");
            return (Criteria) this;
        }

        public Criteria andUserchecktimeGreaterThan(Date value) {
            addCriterion("userCheckTime >", value, "userchecktime");
            return (Criteria) this;
        }

        public Criteria andUserchecktimeGreaterThanOrEqualTo(Date value) {
            addCriterion("userCheckTime >=", value, "userchecktime");
            return (Criteria) this;
        }

        public Criteria andUserchecktimeLessThan(Date value) {
            addCriterion("userCheckTime <", value, "userchecktime");
            return (Criteria) this;
        }

        public Criteria andUserchecktimeLessThanOrEqualTo(Date value) {
            addCriterion("userCheckTime <=", value, "userchecktime");
            return (Criteria) this;
        }

        public Criteria andUserchecktimeIn(List<Date> values) {
            addCriterion("userCheckTime in", values, "userchecktime");
            return (Criteria) this;
        }

        public Criteria andUserchecktimeNotIn(List<Date> values) {
            addCriterion("userCheckTime not in", values, "userchecktime");
            return (Criteria) this;
        }

        public Criteria andUserchecktimeBetween(Date value1, Date value2) {
            addCriterion("userCheckTime between", value1, value2, "userchecktime");
            return (Criteria) this;
        }

        public Criteria andUserchecktimeNotBetween(Date value1, Date value2) {
            addCriterion("userCheckTime not between", value1, value2, "userchecktime");
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