package com.model;

import java.util.ArrayList;
import java.util.List;

public class AttendanceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AttendanceExample() {
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

        public Criteria andAidIsNull() {
            addCriterion("aid is null");
            return (Criteria) this;
        }

        public Criteria andAidIsNotNull() {
            addCriterion("aid is not null");
            return (Criteria) this;
        }

        public Criteria andAidEqualTo(Integer value) {
            addCriterion("aid =", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotEqualTo(Integer value) {
            addCriterion("aid <>", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThan(Integer value) {
            addCriterion("aid >", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThanOrEqualTo(Integer value) {
            addCriterion("aid >=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThan(Integer value) {
            addCriterion("aid <", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThanOrEqualTo(Integer value) {
            addCriterion("aid <=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidIn(List<Integer> values) {
            addCriterion("aid in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotIn(List<Integer> values) {
            addCriterion("aid not in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidBetween(Integer value1, Integer value2) {
            addCriterion("aid between", value1, value2, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotBetween(Integer value1, Integer value2) {
            addCriterion("aid not between", value1, value2, "aid");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
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

        public Criteria andWorkdateIsNull() {
            addCriterion("workDate is null");
            return (Criteria) this;
        }

        public Criteria andWorkdateIsNotNull() {
            addCriterion("workDate is not null");
            return (Criteria) this;
        }

        public Criteria andWorkdateEqualTo(String value) {
            addCriterion("workDate =", value, "workdate");
            return (Criteria) this;
        }

        public Criteria andWorkdateNotEqualTo(String value) {
            addCriterion("workDate <>", value, "workdate");
            return (Criteria) this;
        }

        public Criteria andWorkdateGreaterThan(String value) {
            addCriterion("workDate >", value, "workdate");
            return (Criteria) this;
        }

        public Criteria andWorkdateGreaterThanOrEqualTo(String value) {
            addCriterion("workDate >=", value, "workdate");
            return (Criteria) this;
        }

        public Criteria andWorkdateLessThan(String value) {
            addCriterion("workDate <", value, "workdate");
            return (Criteria) this;
        }

        public Criteria andWorkdateLessThanOrEqualTo(String value) {
            addCriterion("workDate <=", value, "workdate");
            return (Criteria) this;
        }

        public Criteria andWorkdateLike(String value) {
            addCriterion("workDate like", value, "workdate");
            return (Criteria) this;
        }

        public Criteria andWorkdateNotLike(String value) {
            addCriterion("workDate not like", value, "workdate");
            return (Criteria) this;
        }

        public Criteria andWorkdateIn(List<String> values) {
            addCriterion("workDate in", values, "workdate");
            return (Criteria) this;
        }

        public Criteria andWorkdateNotIn(List<String> values) {
            addCriterion("workDate not in", values, "workdate");
            return (Criteria) this;
        }

        public Criteria andWorkdateBetween(String value1, String value2) {
            addCriterion("workDate between", value1, value2, "workdate");
            return (Criteria) this;
        }

        public Criteria andWorkdateNotBetween(String value1, String value2) {
            addCriterion("workDate not between", value1, value2, "workdate");
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

        public Criteria andSourcetypeIsNull() {
            addCriterion("sourceType is null");
            return (Criteria) this;
        }

        public Criteria andSourcetypeIsNotNull() {
            addCriterion("sourceType is not null");
            return (Criteria) this;
        }

        public Criteria andSourcetypeEqualTo(String value) {
            addCriterion("sourceType =", value, "sourcetype");
            return (Criteria) this;
        }

        public Criteria andSourcetypeNotEqualTo(String value) {
            addCriterion("sourceType <>", value, "sourcetype");
            return (Criteria) this;
        }

        public Criteria andSourcetypeGreaterThan(String value) {
            addCriterion("sourceType >", value, "sourcetype");
            return (Criteria) this;
        }

        public Criteria andSourcetypeGreaterThanOrEqualTo(String value) {
            addCriterion("sourceType >=", value, "sourcetype");
            return (Criteria) this;
        }

        public Criteria andSourcetypeLessThan(String value) {
            addCriterion("sourceType <", value, "sourcetype");
            return (Criteria) this;
        }

        public Criteria andSourcetypeLessThanOrEqualTo(String value) {
            addCriterion("sourceType <=", value, "sourcetype");
            return (Criteria) this;
        }

        public Criteria andSourcetypeLike(String value) {
            addCriterion("sourceType like", value, "sourcetype");
            return (Criteria) this;
        }

        public Criteria andSourcetypeNotLike(String value) {
            addCriterion("sourceType not like", value, "sourcetype");
            return (Criteria) this;
        }

        public Criteria andSourcetypeIn(List<String> values) {
            addCriterion("sourceType in", values, "sourcetype");
            return (Criteria) this;
        }

        public Criteria andSourcetypeNotIn(List<String> values) {
            addCriterion("sourceType not in", values, "sourcetype");
            return (Criteria) this;
        }

        public Criteria andSourcetypeBetween(String value1, String value2) {
            addCriterion("sourceType between", value1, value2, "sourcetype");
            return (Criteria) this;
        }

        public Criteria andSourcetypeNotBetween(String value1, String value2) {
            addCriterion("sourceType not between", value1, value2, "sourcetype");
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

        public Criteria andApproveresultIsNull() {
            addCriterion("approveResult is null");
            return (Criteria) this;
        }

        public Criteria andApproveresultIsNotNull() {
            addCriterion("approveResult is not null");
            return (Criteria) this;
        }

        public Criteria andApproveresultEqualTo(String value) {
            addCriterion("approveResult =", value, "approveresult");
            return (Criteria) this;
        }

        public Criteria andApproveresultNotEqualTo(String value) {
            addCriterion("approveResult <>", value, "approveresult");
            return (Criteria) this;
        }

        public Criteria andApproveresultGreaterThan(String value) {
            addCriterion("approveResult >", value, "approveresult");
            return (Criteria) this;
        }

        public Criteria andApproveresultGreaterThanOrEqualTo(String value) {
            addCriterion("approveResult >=", value, "approveresult");
            return (Criteria) this;
        }

        public Criteria andApproveresultLessThan(String value) {
            addCriterion("approveResult <", value, "approveresult");
            return (Criteria) this;
        }

        public Criteria andApproveresultLessThanOrEqualTo(String value) {
            addCriterion("approveResult <=", value, "approveresult");
            return (Criteria) this;
        }

        public Criteria andApproveresultLike(String value) {
            addCriterion("approveResult like", value, "approveresult");
            return (Criteria) this;
        }

        public Criteria andApproveresultNotLike(String value) {
            addCriterion("approveResult not like", value, "approveresult");
            return (Criteria) this;
        }

        public Criteria andApproveresultIn(List<String> values) {
            addCriterion("approveResult in", values, "approveresult");
            return (Criteria) this;
        }

        public Criteria andApproveresultNotIn(List<String> values) {
            addCriterion("approveResult not in", values, "approveresult");
            return (Criteria) this;
        }

        public Criteria andApproveresultBetween(String value1, String value2) {
            addCriterion("approveResult between", value1, value2, "approveresult");
            return (Criteria) this;
        }

        public Criteria andApproveresultNotBetween(String value1, String value2) {
            addCriterion("approveResult not between", value1, value2, "approveresult");
            return (Criteria) this;
        }

        public Criteria andApproveidIsNull() {
            addCriterion("approveId is null");
            return (Criteria) this;
        }

        public Criteria andApproveidIsNotNull() {
            addCriterion("approveId is not null");
            return (Criteria) this;
        }

        public Criteria andApproveidEqualTo(String value) {
            addCriterion("approveId =", value, "approveid");
            return (Criteria) this;
        }

        public Criteria andApproveidNotEqualTo(String value) {
            addCriterion("approveId <>", value, "approveid");
            return (Criteria) this;
        }

        public Criteria andApproveidGreaterThan(String value) {
            addCriterion("approveId >", value, "approveid");
            return (Criteria) this;
        }

        public Criteria andApproveidGreaterThanOrEqualTo(String value) {
            addCriterion("approveId >=", value, "approveid");
            return (Criteria) this;
        }

        public Criteria andApproveidLessThan(String value) {
            addCriterion("approveId <", value, "approveid");
            return (Criteria) this;
        }

        public Criteria andApproveidLessThanOrEqualTo(String value) {
            addCriterion("approveId <=", value, "approveid");
            return (Criteria) this;
        }

        public Criteria andApproveidLike(String value) {
            addCriterion("approveId like", value, "approveid");
            return (Criteria) this;
        }

        public Criteria andApproveidNotLike(String value) {
            addCriterion("approveId not like", value, "approveid");
            return (Criteria) this;
        }

        public Criteria andApproveidIn(List<String> values) {
            addCriterion("approveId in", values, "approveid");
            return (Criteria) this;
        }

        public Criteria andApproveidNotIn(List<String> values) {
            addCriterion("approveId not in", values, "approveid");
            return (Criteria) this;
        }

        public Criteria andApproveidBetween(String value1, String value2) {
            addCriterion("approveId between", value1, value2, "approveid");
            return (Criteria) this;
        }

        public Criteria andApproveidNotBetween(String value1, String value2) {
            addCriterion("approveId not between", value1, value2, "approveid");
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

        public Criteria andBasechecktimeEqualTo(String value) {
            addCriterion("baseCheckTime =", value, "basechecktime");
            return (Criteria) this;
        }

        public Criteria andBasechecktimeNotEqualTo(String value) {
            addCriterion("baseCheckTime <>", value, "basechecktime");
            return (Criteria) this;
        }

        public Criteria andBasechecktimeGreaterThan(String value) {
            addCriterion("baseCheckTime >", value, "basechecktime");
            return (Criteria) this;
        }

        public Criteria andBasechecktimeGreaterThanOrEqualTo(String value) {
            addCriterion("baseCheckTime >=", value, "basechecktime");
            return (Criteria) this;
        }

        public Criteria andBasechecktimeLessThan(String value) {
            addCriterion("baseCheckTime <", value, "basechecktime");
            return (Criteria) this;
        }

        public Criteria andBasechecktimeLessThanOrEqualTo(String value) {
            addCriterion("baseCheckTime <=", value, "basechecktime");
            return (Criteria) this;
        }

        public Criteria andBasechecktimeLike(String value) {
            addCriterion("baseCheckTime like", value, "basechecktime");
            return (Criteria) this;
        }

        public Criteria andBasechecktimeNotLike(String value) {
            addCriterion("baseCheckTime not like", value, "basechecktime");
            return (Criteria) this;
        }

        public Criteria andBasechecktimeIn(List<String> values) {
            addCriterion("baseCheckTime in", values, "basechecktime");
            return (Criteria) this;
        }

        public Criteria andBasechecktimeNotIn(List<String> values) {
            addCriterion("baseCheckTime not in", values, "basechecktime");
            return (Criteria) this;
        }

        public Criteria andBasechecktimeBetween(String value1, String value2) {
            addCriterion("baseCheckTime between", value1, value2, "basechecktime");
            return (Criteria) this;
        }

        public Criteria andBasechecktimeNotBetween(String value1, String value2) {
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

        public Criteria andUserchecktimeEqualTo(String value) {
            addCriterion("userCheckTime =", value, "userchecktime");
            return (Criteria) this;
        }

        public Criteria andUserchecktimeNotEqualTo(String value) {
            addCriterion("userCheckTime <>", value, "userchecktime");
            return (Criteria) this;
        }

        public Criteria andUserchecktimeGreaterThan(String value) {
            addCriterion("userCheckTime >", value, "userchecktime");
            return (Criteria) this;
        }

        public Criteria andUserchecktimeGreaterThanOrEqualTo(String value) {
            addCriterion("userCheckTime >=", value, "userchecktime");
            return (Criteria) this;
        }

        public Criteria andUserchecktimeLessThan(String value) {
            addCriterion("userCheckTime <", value, "userchecktime");
            return (Criteria) this;
        }

        public Criteria andUserchecktimeLessThanOrEqualTo(String value) {
            addCriterion("userCheckTime <=", value, "userchecktime");
            return (Criteria) this;
        }

        public Criteria andUserchecktimeLike(String value) {
            addCriterion("userCheckTime like", value, "userchecktime");
            return (Criteria) this;
        }

        public Criteria andUserchecktimeNotLike(String value) {
            addCriterion("userCheckTime not like", value, "userchecktime");
            return (Criteria) this;
        }

        public Criteria andUserchecktimeIn(List<String> values) {
            addCriterion("userCheckTime in", values, "userchecktime");
            return (Criteria) this;
        }

        public Criteria andUserchecktimeNotIn(List<String> values) {
            addCriterion("userCheckTime not in", values, "userchecktime");
            return (Criteria) this;
        }

        public Criteria andUserchecktimeBetween(String value1, String value2) {
            addCriterion("userCheckTime between", value1, value2, "userchecktime");
            return (Criteria) this;
        }

        public Criteria andUserchecktimeNotBetween(String value1, String value2) {
            addCriterion("userCheckTime not between", value1, value2, "userchecktime");
            return (Criteria) this;
        }

        public Criteria andErrcodeIsNull() {
            addCriterion("errcode is null");
            return (Criteria) this;
        }

        public Criteria andErrcodeIsNotNull() {
            addCriterion("errcode is not null");
            return (Criteria) this;
        }

        public Criteria andErrcodeEqualTo(String value) {
            addCriterion("errcode =", value, "errcode");
            return (Criteria) this;
        }

        public Criteria andErrcodeNotEqualTo(String value) {
            addCriterion("errcode <>", value, "errcode");
            return (Criteria) this;
        }

        public Criteria andErrcodeGreaterThan(String value) {
            addCriterion("errcode >", value, "errcode");
            return (Criteria) this;
        }

        public Criteria andErrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("errcode >=", value, "errcode");
            return (Criteria) this;
        }

        public Criteria andErrcodeLessThan(String value) {
            addCriterion("errcode <", value, "errcode");
            return (Criteria) this;
        }

        public Criteria andErrcodeLessThanOrEqualTo(String value) {
            addCriterion("errcode <=", value, "errcode");
            return (Criteria) this;
        }

        public Criteria andErrcodeLike(String value) {
            addCriterion("errcode like", value, "errcode");
            return (Criteria) this;
        }

        public Criteria andErrcodeNotLike(String value) {
            addCriterion("errcode not like", value, "errcode");
            return (Criteria) this;
        }

        public Criteria andErrcodeIn(List<String> values) {
            addCriterion("errcode in", values, "errcode");
            return (Criteria) this;
        }

        public Criteria andErrcodeNotIn(List<String> values) {
            addCriterion("errcode not in", values, "errcode");
            return (Criteria) this;
        }

        public Criteria andErrcodeBetween(String value1, String value2) {
            addCriterion("errcode between", value1, value2, "errcode");
            return (Criteria) this;
        }

        public Criteria andErrcodeNotBetween(String value1, String value2) {
            addCriterion("errcode not between", value1, value2, "errcode");
            return (Criteria) this;
        }

        public Criteria andErrmsgIsNull() {
            addCriterion("errmsg is null");
            return (Criteria) this;
        }

        public Criteria andErrmsgIsNotNull() {
            addCriterion("errmsg is not null");
            return (Criteria) this;
        }

        public Criteria andErrmsgEqualTo(String value) {
            addCriterion("errmsg =", value, "errmsg");
            return (Criteria) this;
        }

        public Criteria andErrmsgNotEqualTo(String value) {
            addCriterion("errmsg <>", value, "errmsg");
            return (Criteria) this;
        }

        public Criteria andErrmsgGreaterThan(String value) {
            addCriterion("errmsg >", value, "errmsg");
            return (Criteria) this;
        }

        public Criteria andErrmsgGreaterThanOrEqualTo(String value) {
            addCriterion("errmsg >=", value, "errmsg");
            return (Criteria) this;
        }

        public Criteria andErrmsgLessThan(String value) {
            addCriterion("errmsg <", value, "errmsg");
            return (Criteria) this;
        }

        public Criteria andErrmsgLessThanOrEqualTo(String value) {
            addCriterion("errmsg <=", value, "errmsg");
            return (Criteria) this;
        }

        public Criteria andErrmsgLike(String value) {
            addCriterion("errmsg like", value, "errmsg");
            return (Criteria) this;
        }

        public Criteria andErrmsgNotLike(String value) {
            addCriterion("errmsg not like", value, "errmsg");
            return (Criteria) this;
        }

        public Criteria andErrmsgIn(List<String> values) {
            addCriterion("errmsg in", values, "errmsg");
            return (Criteria) this;
        }

        public Criteria andErrmsgNotIn(List<String> values) {
            addCriterion("errmsg not in", values, "errmsg");
            return (Criteria) this;
        }

        public Criteria andErrmsgBetween(String value1, String value2) {
            addCriterion("errmsg between", value1, value2, "errmsg");
            return (Criteria) this;
        }

        public Criteria andErrmsgNotBetween(String value1, String value2) {
            addCriterion("errmsg not between", value1, value2, "errmsg");
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