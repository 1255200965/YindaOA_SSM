package com.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class YoAtteninfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public YoAtteninfoExample() {
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

        public Criteria andInidIsNull() {
            addCriterion("inid is null");
            return (Criteria) this;
        }

        public Criteria andInidIsNotNull() {
            addCriterion("inid is not null");
            return (Criteria) this;
        }

        public Criteria andInidEqualTo(Integer value) {
            addCriterion("inid =", value, "inid");
            return (Criteria) this;
        }

        public Criteria andInidNotEqualTo(Integer value) {
            addCriterion("inid <>", value, "inid");
            return (Criteria) this;
        }

        public Criteria andInidGreaterThan(Integer value) {
            addCriterion("inid >", value, "inid");
            return (Criteria) this;
        }

        public Criteria andInidGreaterThanOrEqualTo(Integer value) {
            addCriterion("inid >=", value, "inid");
            return (Criteria) this;
        }

        public Criteria andInidLessThan(Integer value) {
            addCriterion("inid <", value, "inid");
            return (Criteria) this;
        }

        public Criteria andInidLessThanOrEqualTo(Integer value) {
            addCriterion("inid <=", value, "inid");
            return (Criteria) this;
        }

        public Criteria andInidIn(List<Integer> values) {
            addCriterion("inid in", values, "inid");
            return (Criteria) this;
        }

        public Criteria andInidNotIn(List<Integer> values) {
            addCriterion("inid not in", values, "inid");
            return (Criteria) this;
        }

        public Criteria andInidBetween(Integer value1, Integer value2) {
            addCriterion("inid between", value1, value2, "inid");
            return (Criteria) this;
        }

        public Criteria andInidNotBetween(Integer value1, Integer value2) {
            addCriterion("inid not between", value1, value2, "inid");
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

        public Criteria andAttdateIsNull() {
            addCriterion("attdate is null");
            return (Criteria) this;
        }

        public Criteria andAttdateIsNotNull() {
            addCriterion("attdate is not null");
            return (Criteria) this;
        }

        public Criteria andAttdateEqualTo(Date value) {
            addCriterionForJDBCDate("attdate =", value, "attdate");
            return (Criteria) this;
        }

        public Criteria andAttdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("attdate <>", value, "attdate");
            return (Criteria) this;
        }

        public Criteria andAttdateGreaterThan(Date value) {
            addCriterionForJDBCDate("attdate >", value, "attdate");
            return (Criteria) this;
        }

        public Criteria andAttdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("attdate >=", value, "attdate");
            return (Criteria) this;
        }

        public Criteria andAttdateLessThan(Date value) {
            addCriterionForJDBCDate("attdate <", value, "attdate");
            return (Criteria) this;
        }

        public Criteria andAttdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("attdate <=", value, "attdate");
            return (Criteria) this;
        }

        public Criteria andAttdateIn(List<Date> values) {
            addCriterionForJDBCDate("attdate in", values, "attdate");
            return (Criteria) this;
        }

        public Criteria andAttdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("attdate not in", values, "attdate");
            return (Criteria) this;
        }

        public Criteria andAttdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("attdate between", value1, value2, "attdate");
            return (Criteria) this;
        }

        public Criteria andAttdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("attdate not between", value1, value2, "attdate");
            return (Criteria) this;
        }

        public Criteria andAtttimeIsNull() {
            addCriterion("atttime is null");
            return (Criteria) this;
        }

        public Criteria andAtttimeIsNotNull() {
            addCriterion("atttime is not null");
            return (Criteria) this;
        }

        public Criteria andAtttimeEqualTo(Date value) {
            addCriterion("atttime =", value, "atttime");
            return (Criteria) this;
        }

        public Criteria andAtttimeNotEqualTo(Date value) {
            addCriterion("atttime <>", value, "atttime");
            return (Criteria) this;
        }

        public Criteria andAtttimeGreaterThan(Date value) {
            addCriterion("atttime >", value, "atttime");
            return (Criteria) this;
        }

        public Criteria andAtttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("atttime >=", value, "atttime");
            return (Criteria) this;
        }

        public Criteria andAtttimeLessThan(Date value) {
            addCriterion("atttime <", value, "atttime");
            return (Criteria) this;
        }

        public Criteria andAtttimeLessThanOrEqualTo(Date value) {
            addCriterion("atttime <=", value, "atttime");
            return (Criteria) this;
        }

        public Criteria andAtttimeIn(List<Date> values) {
            addCriterion("atttime in", values, "atttime");
            return (Criteria) this;
        }

        public Criteria andAtttimeNotIn(List<Date> values) {
            addCriterion("atttime not in", values, "atttime");
            return (Criteria) this;
        }

        public Criteria andAtttimeBetween(Date value1, Date value2) {
            addCriterion("atttime between", value1, value2, "atttime");
            return (Criteria) this;
        }

        public Criteria andAtttimeNotBetween(Date value1, Date value2) {
            addCriterion("atttime not between", value1, value2, "atttime");
            return (Criteria) this;
        }

        public Criteria andAttendtimeIsNull() {
            addCriterion("attendtime is null");
            return (Criteria) this;
        }

        public Criteria andAttendtimeIsNotNull() {
            addCriterion("attendtime is not null");
            return (Criteria) this;
        }

        public Criteria andAttendtimeEqualTo(Date value) {
            addCriterion("attendtime =", value, "attendtime");
            return (Criteria) this;
        }

        public Criteria andAttendtimeNotEqualTo(Date value) {
            addCriterion("attendtime <>", value, "attendtime");
            return (Criteria) this;
        }

        public Criteria andAttendtimeGreaterThan(Date value) {
            addCriterion("attendtime >", value, "attendtime");
            return (Criteria) this;
        }

        public Criteria andAttendtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("attendtime >=", value, "attendtime");
            return (Criteria) this;
        }

        public Criteria andAttendtimeLessThan(Date value) {
            addCriterion("attendtime <", value, "attendtime");
            return (Criteria) this;
        }

        public Criteria andAttendtimeLessThanOrEqualTo(Date value) {
            addCriterion("attendtime <=", value, "attendtime");
            return (Criteria) this;
        }

        public Criteria andAttendtimeIn(List<Date> values) {
            addCriterion("attendtime in", values, "attendtime");
            return (Criteria) this;
        }

        public Criteria andAttendtimeNotIn(List<Date> values) {
            addCriterion("attendtime not in", values, "attendtime");
            return (Criteria) this;
        }

        public Criteria andAttendtimeBetween(Date value1, Date value2) {
            addCriterion("attendtime between", value1, value2, "attendtime");
            return (Criteria) this;
        }

        public Criteria andAttendtimeNotBetween(Date value1, Date value2) {
            addCriterion("attendtime not between", value1, value2, "attendtime");
            return (Criteria) this;
        }

        public Criteria andAttendresultIsNull() {
            addCriterion("attendresult is null");
            return (Criteria) this;
        }

        public Criteria andAttendresultIsNotNull() {
            addCriterion("attendresult is not null");
            return (Criteria) this;
        }

        public Criteria andAttendresultEqualTo(String value) {
            addCriterion("attendresult =", value, "attendresult");
            return (Criteria) this;
        }

        public Criteria andAttendresultNotEqualTo(String value) {
            addCriterion("attendresult <>", value, "attendresult");
            return (Criteria) this;
        }

        public Criteria andAttendresultGreaterThan(String value) {
            addCriterion("attendresult >", value, "attendresult");
            return (Criteria) this;
        }

        public Criteria andAttendresultGreaterThanOrEqualTo(String value) {
            addCriterion("attendresult >=", value, "attendresult");
            return (Criteria) this;
        }

        public Criteria andAttendresultLessThan(String value) {
            addCriterion("attendresult <", value, "attendresult");
            return (Criteria) this;
        }

        public Criteria andAttendresultLessThanOrEqualTo(String value) {
            addCriterion("attendresult <=", value, "attendresult");
            return (Criteria) this;
        }

        public Criteria andAttendresultLike(String value) {
            addCriterion("attendresult like", value, "attendresult");
            return (Criteria) this;
        }

        public Criteria andAttendresultNotLike(String value) {
            addCriterion("attendresult not like", value, "attendresult");
            return (Criteria) this;
        }

        public Criteria andAttendresultIn(List<String> values) {
            addCriterion("attendresult in", values, "attendresult");
            return (Criteria) this;
        }

        public Criteria andAttendresultNotIn(List<String> values) {
            addCriterion("attendresult not in", values, "attendresult");
            return (Criteria) this;
        }

        public Criteria andAttendresultBetween(String value1, String value2) {
            addCriterion("attendresult between", value1, value2, "attendresult");
            return (Criteria) this;
        }

        public Criteria andAttendresultNotBetween(String value1, String value2) {
            addCriterion("attendresult not between", value1, value2, "attendresult");
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

        public Criteria andIfactivityIsNull() {
            addCriterion("ifactivity is null");
            return (Criteria) this;
        }

        public Criteria andIfactivityIsNotNull() {
            addCriterion("ifactivity is not null");
            return (Criteria) this;
        }

        public Criteria andIfactivityEqualTo(String value) {
            addCriterion("ifactivity =", value, "ifactivity");
            return (Criteria) this;
        }

        public Criteria andIfactivityNotEqualTo(String value) {
            addCriterion("ifactivity <>", value, "ifactivity");
            return (Criteria) this;
        }

        public Criteria andIfactivityGreaterThan(String value) {
            addCriterion("ifactivity >", value, "ifactivity");
            return (Criteria) this;
        }

        public Criteria andIfactivityGreaterThanOrEqualTo(String value) {
            addCriterion("ifactivity >=", value, "ifactivity");
            return (Criteria) this;
        }

        public Criteria andIfactivityLessThan(String value) {
            addCriterion("ifactivity <", value, "ifactivity");
            return (Criteria) this;
        }

        public Criteria andIfactivityLessThanOrEqualTo(String value) {
            addCriterion("ifactivity <=", value, "ifactivity");
            return (Criteria) this;
        }

        public Criteria andIfactivityLike(String value) {
            addCriterion("ifactivity like", value, "ifactivity");
            return (Criteria) this;
        }

        public Criteria andIfactivityNotLike(String value) {
            addCriterion("ifactivity not like", value, "ifactivity");
            return (Criteria) this;
        }

        public Criteria andIfactivityIn(List<String> values) {
            addCriterion("ifactivity in", values, "ifactivity");
            return (Criteria) this;
        }

        public Criteria andIfactivityNotIn(List<String> values) {
            addCriterion("ifactivity not in", values, "ifactivity");
            return (Criteria) this;
        }

        public Criteria andIfactivityBetween(String value1, String value2) {
            addCriterion("ifactivity between", value1, value2, "ifactivity");
            return (Criteria) this;
        }

        public Criteria andIfactivityNotBetween(String value1, String value2) {
            addCriterion("ifactivity not between", value1, value2, "ifactivity");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andImgoneIsNull() {
            addCriterion("imgone is null");
            return (Criteria) this;
        }

        public Criteria andImgoneIsNotNull() {
            addCriterion("imgone is not null");
            return (Criteria) this;
        }

        public Criteria andImgoneEqualTo(String value) {
            addCriterion("imgone =", value, "imgone");
            return (Criteria) this;
        }

        public Criteria andImgoneNotEqualTo(String value) {
            addCriterion("imgone <>", value, "imgone");
            return (Criteria) this;
        }

        public Criteria andImgoneGreaterThan(String value) {
            addCriterion("imgone >", value, "imgone");
            return (Criteria) this;
        }

        public Criteria andImgoneGreaterThanOrEqualTo(String value) {
            addCriterion("imgone >=", value, "imgone");
            return (Criteria) this;
        }

        public Criteria andImgoneLessThan(String value) {
            addCriterion("imgone <", value, "imgone");
            return (Criteria) this;
        }

        public Criteria andImgoneLessThanOrEqualTo(String value) {
            addCriterion("imgone <=", value, "imgone");
            return (Criteria) this;
        }

        public Criteria andImgoneLike(String value) {
            addCriterion("imgone like", value, "imgone");
            return (Criteria) this;
        }

        public Criteria andImgoneNotLike(String value) {
            addCriterion("imgone not like", value, "imgone");
            return (Criteria) this;
        }

        public Criteria andImgoneIn(List<String> values) {
            addCriterion("imgone in", values, "imgone");
            return (Criteria) this;
        }

        public Criteria andImgoneNotIn(List<String> values) {
            addCriterion("imgone not in", values, "imgone");
            return (Criteria) this;
        }

        public Criteria andImgoneBetween(String value1, String value2) {
            addCriterion("imgone between", value1, value2, "imgone");
            return (Criteria) this;
        }

        public Criteria andImgoneNotBetween(String value1, String value2) {
            addCriterion("imgone not between", value1, value2, "imgone");
            return (Criteria) this;
        }

        public Criteria andImgtwoIsNull() {
            addCriterion("imgtwo is null");
            return (Criteria) this;
        }

        public Criteria andImgtwoIsNotNull() {
            addCriterion("imgtwo is not null");
            return (Criteria) this;
        }

        public Criteria andImgtwoEqualTo(String value) {
            addCriterion("imgtwo =", value, "imgtwo");
            return (Criteria) this;
        }

        public Criteria andImgtwoNotEqualTo(String value) {
            addCriterion("imgtwo <>", value, "imgtwo");
            return (Criteria) this;
        }

        public Criteria andImgtwoGreaterThan(String value) {
            addCriterion("imgtwo >", value, "imgtwo");
            return (Criteria) this;
        }

        public Criteria andImgtwoGreaterThanOrEqualTo(String value) {
            addCriterion("imgtwo >=", value, "imgtwo");
            return (Criteria) this;
        }

        public Criteria andImgtwoLessThan(String value) {
            addCriterion("imgtwo <", value, "imgtwo");
            return (Criteria) this;
        }

        public Criteria andImgtwoLessThanOrEqualTo(String value) {
            addCriterion("imgtwo <=", value, "imgtwo");
            return (Criteria) this;
        }

        public Criteria andImgtwoLike(String value) {
            addCriterion("imgtwo like", value, "imgtwo");
            return (Criteria) this;
        }

        public Criteria andImgtwoNotLike(String value) {
            addCriterion("imgtwo not like", value, "imgtwo");
            return (Criteria) this;
        }

        public Criteria andImgtwoIn(List<String> values) {
            addCriterion("imgtwo in", values, "imgtwo");
            return (Criteria) this;
        }

        public Criteria andImgtwoNotIn(List<String> values) {
            addCriterion("imgtwo not in", values, "imgtwo");
            return (Criteria) this;
        }

        public Criteria andImgtwoBetween(String value1, String value2) {
            addCriterion("imgtwo between", value1, value2, "imgtwo");
            return (Criteria) this;
        }

        public Criteria andImgtwoNotBetween(String value1, String value2) {
            addCriterion("imgtwo not between", value1, value2, "imgtwo");
            return (Criteria) this;
        }

        public Criteria andDeviceIsNull() {
            addCriterion("device is null");
            return (Criteria) this;
        }

        public Criteria andDeviceIsNotNull() {
            addCriterion("device is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceEqualTo(String value) {
            addCriterion("device =", value, "device");
            return (Criteria) this;
        }

        public Criteria andDeviceNotEqualTo(String value) {
            addCriterion("device <>", value, "device");
            return (Criteria) this;
        }

        public Criteria andDeviceGreaterThan(String value) {
            addCriterion("device >", value, "device");
            return (Criteria) this;
        }

        public Criteria andDeviceGreaterThanOrEqualTo(String value) {
            addCriterion("device >=", value, "device");
            return (Criteria) this;
        }

        public Criteria andDeviceLessThan(String value) {
            addCriterion("device <", value, "device");
            return (Criteria) this;
        }

        public Criteria andDeviceLessThanOrEqualTo(String value) {
            addCriterion("device <=", value, "device");
            return (Criteria) this;
        }

        public Criteria andDeviceLike(String value) {
            addCriterion("device like", value, "device");
            return (Criteria) this;
        }

        public Criteria andDeviceNotLike(String value) {
            addCriterion("device not like", value, "device");
            return (Criteria) this;
        }

        public Criteria andDeviceIn(List<String> values) {
            addCriterion("device in", values, "device");
            return (Criteria) this;
        }

        public Criteria andDeviceNotIn(List<String> values) {
            addCriterion("device not in", values, "device");
            return (Criteria) this;
        }

        public Criteria andDeviceBetween(String value1, String value2) {
            addCriterion("device between", value1, value2, "device");
            return (Criteria) this;
        }

        public Criteria andDeviceNotBetween(String value1, String value2) {
            addCriterion("device not between", value1, value2, "device");
            return (Criteria) this;
        }

        public Criteria andDeviceidIsNull() {
            addCriterion("deviceid is null");
            return (Criteria) this;
        }

        public Criteria andDeviceidIsNotNull() {
            addCriterion("deviceid is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceidEqualTo(String value) {
            addCriterion("deviceid =", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidNotEqualTo(String value) {
            addCriterion("deviceid <>", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidGreaterThan(String value) {
            addCriterion("deviceid >", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidGreaterThanOrEqualTo(String value) {
            addCriterion("deviceid >=", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidLessThan(String value) {
            addCriterion("deviceid <", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidLessThanOrEqualTo(String value) {
            addCriterion("deviceid <=", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidLike(String value) {
            addCriterion("deviceid like", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidNotLike(String value) {
            addCriterion("deviceid not like", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidIn(List<String> values) {
            addCriterion("deviceid in", values, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidNotIn(List<String> values) {
            addCriterion("deviceid not in", values, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidBetween(String value1, String value2) {
            addCriterion("deviceid between", value1, value2, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidNotBetween(String value1, String value2) {
            addCriterion("deviceid not between", value1, value2, "deviceid");
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