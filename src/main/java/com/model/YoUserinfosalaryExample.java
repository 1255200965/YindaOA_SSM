package com.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class YoUserinfosalaryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public YoUserinfosalaryExample() {
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

        public Criteria andSidIsNull() {
            addCriterion("sid is null");
            return (Criteria) this;
        }

        public Criteria andSidIsNotNull() {
            addCriterion("sid is not null");
            return (Criteria) this;
        }

        public Criteria andSidEqualTo(Integer value) {
            addCriterion("sid =", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotEqualTo(Integer value) {
            addCriterion("sid <>", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThan(Integer value) {
            addCriterion("sid >", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sid >=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThan(Integer value) {
            addCriterion("sid <", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThanOrEqualTo(Integer value) {
            addCriterion("sid <=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidIn(List<Integer> values) {
            addCriterion("sid in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotIn(List<Integer> values) {
            addCriterion("sid not in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidBetween(Integer value1, Integer value2) {
            addCriterion("sid between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotBetween(Integer value1, Integer value2) {
            addCriterion("sid not between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andSalarydateIsNull() {
            addCriterion("salarydate is null");
            return (Criteria) this;
        }

        public Criteria andSalarydateIsNotNull() {
            addCriterion("salarydate is not null");
            return (Criteria) this;
        }

        public Criteria andSalarydateEqualTo(String value) {
            addCriterion("salarydate =", value, "salarydate");
            return (Criteria) this;
        }

        public Criteria andSalarydateNotEqualTo(String value) {
            addCriterion("salarydate <>", value, "salarydate");
            return (Criteria) this;
        }

        public Criteria andSalarydateGreaterThan(String value) {
            addCriterion("salarydate >", value, "salarydate");
            return (Criteria) this;
        }

        public Criteria andSalarydateGreaterThanOrEqualTo(String value) {
            addCriterion("salarydate >=", value, "salarydate");
            return (Criteria) this;
        }

        public Criteria andSalarydateLessThan(String value) {
            addCriterion("salarydate <", value, "salarydate");
            return (Criteria) this;
        }

        public Criteria andSalarydateLessThanOrEqualTo(String value) {
            addCriterion("salarydate <=", value, "salarydate");
            return (Criteria) this;
        }

        public Criteria andSalarydateLike(String value) {
            addCriterion("salarydate like", value, "salarydate");
            return (Criteria) this;
        }

        public Criteria andSalarydateNotLike(String value) {
            addCriterion("salarydate not like", value, "salarydate");
            return (Criteria) this;
        }

        public Criteria andSalarydateIn(List<String> values) {
            addCriterion("salarydate in", values, "salarydate");
            return (Criteria) this;
        }

        public Criteria andSalarydateNotIn(List<String> values) {
            addCriterion("salarydate not in", values, "salarydate");
            return (Criteria) this;
        }

        public Criteria andSalarydateBetween(String value1, String value2) {
            addCriterion("salarydate between", value1, value2, "salarydate");
            return (Criteria) this;
        }

        public Criteria andSalarydateNotBetween(String value1, String value2) {
            addCriterion("salarydate not between", value1, value2, "salarydate");
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

        public Criteria andSalaryidIsNull() {
            addCriterion("salaryid is null");
            return (Criteria) this;
        }

        public Criteria andSalaryidIsNotNull() {
            addCriterion("salaryid is not null");
            return (Criteria) this;
        }

        public Criteria andSalaryidEqualTo(String value) {
            addCriterion("salaryid =", value, "salaryid");
            return (Criteria) this;
        }

        public Criteria andSalaryidNotEqualTo(String value) {
            addCriterion("salaryid <>", value, "salaryid");
            return (Criteria) this;
        }

        public Criteria andSalaryidGreaterThan(String value) {
            addCriterion("salaryid >", value, "salaryid");
            return (Criteria) this;
        }

        public Criteria andSalaryidGreaterThanOrEqualTo(String value) {
            addCriterion("salaryid >=", value, "salaryid");
            return (Criteria) this;
        }

        public Criteria andSalaryidLessThan(String value) {
            addCriterion("salaryid <", value, "salaryid");
            return (Criteria) this;
        }

        public Criteria andSalaryidLessThanOrEqualTo(String value) {
            addCriterion("salaryid <=", value, "salaryid");
            return (Criteria) this;
        }

        public Criteria andSalaryidLike(String value) {
            addCriterion("salaryid like", value, "salaryid");
            return (Criteria) this;
        }

        public Criteria andSalaryidNotLike(String value) {
            addCriterion("salaryid not like", value, "salaryid");
            return (Criteria) this;
        }

        public Criteria andSalaryidIn(List<String> values) {
            addCriterion("salaryid in", values, "salaryid");
            return (Criteria) this;
        }

        public Criteria andSalaryidNotIn(List<String> values) {
            addCriterion("salaryid not in", values, "salaryid");
            return (Criteria) this;
        }

        public Criteria andSalaryidBetween(String value1, String value2) {
            addCriterion("salaryid between", value1, value2, "salaryid");
            return (Criteria) this;
        }

        public Criteria andSalaryidNotBetween(String value1, String value2) {
            addCriterion("salaryid not between", value1, value2, "salaryid");
            return (Criteria) this;
        }

        public Criteria andDateIsNull() {
            addCriterion("date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(Date value) {
            addCriterionForJDBCDate("date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(Date value) {
            addCriterionForJDBCDate("date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(Date value) {
            addCriterionForJDBCDate("date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<Date> values) {
            addCriterionForJDBCDate("date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("date not between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDatetypeIsNull() {
            addCriterion("datetype is null");
            return (Criteria) this;
        }

        public Criteria andDatetypeIsNotNull() {
            addCriterion("datetype is not null");
            return (Criteria) this;
        }

        public Criteria andDatetypeEqualTo(String value) {
            addCriterion("datetype =", value, "datetype");
            return (Criteria) this;
        }

        public Criteria andDatetypeNotEqualTo(String value) {
            addCriterion("datetype <>", value, "datetype");
            return (Criteria) this;
        }

        public Criteria andDatetypeGreaterThan(String value) {
            addCriterion("datetype >", value, "datetype");
            return (Criteria) this;
        }

        public Criteria andDatetypeGreaterThanOrEqualTo(String value) {
            addCriterion("datetype >=", value, "datetype");
            return (Criteria) this;
        }

        public Criteria andDatetypeLessThan(String value) {
            addCriterion("datetype <", value, "datetype");
            return (Criteria) this;
        }

        public Criteria andDatetypeLessThanOrEqualTo(String value) {
            addCriterion("datetype <=", value, "datetype");
            return (Criteria) this;
        }

        public Criteria andDatetypeLike(String value) {
            addCriterion("datetype like", value, "datetype");
            return (Criteria) this;
        }

        public Criteria andDatetypeNotLike(String value) {
            addCriterion("datetype not like", value, "datetype");
            return (Criteria) this;
        }

        public Criteria andDatetypeIn(List<String> values) {
            addCriterion("datetype in", values, "datetype");
            return (Criteria) this;
        }

        public Criteria andDatetypeNotIn(List<String> values) {
            addCriterion("datetype not in", values, "datetype");
            return (Criteria) this;
        }

        public Criteria andDatetypeBetween(String value1, String value2) {
            addCriterion("datetype between", value1, value2, "datetype");
            return (Criteria) this;
        }

        public Criteria andDatetypeNotBetween(String value1, String value2) {
            addCriterion("datetype not between", value1, value2, "datetype");
            return (Criteria) this;
        }

        public Criteria andAttendanceIsNull() {
            addCriterion("attendance is null");
            return (Criteria) this;
        }

        public Criteria andAttendanceIsNotNull() {
            addCriterion("attendance is not null");
            return (Criteria) this;
        }

        public Criteria andAttendanceEqualTo(String value) {
            addCriterion("attendance =", value, "attendance");
            return (Criteria) this;
        }

        public Criteria andAttendanceNotEqualTo(String value) {
            addCriterion("attendance <>", value, "attendance");
            return (Criteria) this;
        }

        public Criteria andAttendanceGreaterThan(String value) {
            addCriterion("attendance >", value, "attendance");
            return (Criteria) this;
        }

        public Criteria andAttendanceGreaterThanOrEqualTo(String value) {
            addCriterion("attendance >=", value, "attendance");
            return (Criteria) this;
        }

        public Criteria andAttendanceLessThan(String value) {
            addCriterion("attendance <", value, "attendance");
            return (Criteria) this;
        }

        public Criteria andAttendanceLessThanOrEqualTo(String value) {
            addCriterion("attendance <=", value, "attendance");
            return (Criteria) this;
        }

        public Criteria andAttendanceLike(String value) {
            addCriterion("attendance like", value, "attendance");
            return (Criteria) this;
        }

        public Criteria andAttendanceNotLike(String value) {
            addCriterion("attendance not like", value, "attendance");
            return (Criteria) this;
        }

        public Criteria andAttendanceIn(List<String> values) {
            addCriterion("attendance in", values, "attendance");
            return (Criteria) this;
        }

        public Criteria andAttendanceNotIn(List<String> values) {
            addCriterion("attendance not in", values, "attendance");
            return (Criteria) this;
        }

        public Criteria andAttendanceBetween(String value1, String value2) {
            addCriterion("attendance between", value1, value2, "attendance");
            return (Criteria) this;
        }

        public Criteria andAttendanceNotBetween(String value1, String value2) {
            addCriterion("attendance not between", value1, value2, "attendance");
            return (Criteria) this;
        }

        public Criteria andRealityattendanceIsNull() {
            addCriterion("realityattendance is null");
            return (Criteria) this;
        }

        public Criteria andRealityattendanceIsNotNull() {
            addCriterion("realityattendance is not null");
            return (Criteria) this;
        }

        public Criteria andRealityattendanceEqualTo(String value) {
            addCriterion("realityattendance =", value, "realityattendance");
            return (Criteria) this;
        }

        public Criteria andRealityattendanceNotEqualTo(String value) {
            addCriterion("realityattendance <>", value, "realityattendance");
            return (Criteria) this;
        }

        public Criteria andRealityattendanceGreaterThan(String value) {
            addCriterion("realityattendance >", value, "realityattendance");
            return (Criteria) this;
        }

        public Criteria andRealityattendanceGreaterThanOrEqualTo(String value) {
            addCriterion("realityattendance >=", value, "realityattendance");
            return (Criteria) this;
        }

        public Criteria andRealityattendanceLessThan(String value) {
            addCriterion("realityattendance <", value, "realityattendance");
            return (Criteria) this;
        }

        public Criteria andRealityattendanceLessThanOrEqualTo(String value) {
            addCriterion("realityattendance <=", value, "realityattendance");
            return (Criteria) this;
        }

        public Criteria andRealityattendanceLike(String value) {
            addCriterion("realityattendance like", value, "realityattendance");
            return (Criteria) this;
        }

        public Criteria andRealityattendanceNotLike(String value) {
            addCriterion("realityattendance not like", value, "realityattendance");
            return (Criteria) this;
        }

        public Criteria andRealityattendanceIn(List<String> values) {
            addCriterion("realityattendance in", values, "realityattendance");
            return (Criteria) this;
        }

        public Criteria andRealityattendanceNotIn(List<String> values) {
            addCriterion("realityattendance not in", values, "realityattendance");
            return (Criteria) this;
        }

        public Criteria andRealityattendanceBetween(String value1, String value2) {
            addCriterion("realityattendance between", value1, value2, "realityattendance");
            return (Criteria) this;
        }

        public Criteria andRealityattendanceNotBetween(String value1, String value2) {
            addCriterion("realityattendance not between", value1, value2, "realityattendance");
            return (Criteria) this;
        }

        public Criteria andEffectiveattendanceIsNull() {
            addCriterion("effectiveAttendance is null");
            return (Criteria) this;
        }

        public Criteria andEffectiveattendanceIsNotNull() {
            addCriterion("effectiveAttendance is not null");
            return (Criteria) this;
        }

        public Criteria andEffectiveattendanceEqualTo(String value) {
            addCriterion("effectiveAttendance =", value, "effectiveattendance");
            return (Criteria) this;
        }

        public Criteria andEffectiveattendanceNotEqualTo(String value) {
            addCriterion("effectiveAttendance <>", value, "effectiveattendance");
            return (Criteria) this;
        }

        public Criteria andEffectiveattendanceGreaterThan(String value) {
            addCriterion("effectiveAttendance >", value, "effectiveattendance");
            return (Criteria) this;
        }

        public Criteria andEffectiveattendanceGreaterThanOrEqualTo(String value) {
            addCriterion("effectiveAttendance >=", value, "effectiveattendance");
            return (Criteria) this;
        }

        public Criteria andEffectiveattendanceLessThan(String value) {
            addCriterion("effectiveAttendance <", value, "effectiveattendance");
            return (Criteria) this;
        }

        public Criteria andEffectiveattendanceLessThanOrEqualTo(String value) {
            addCriterion("effectiveAttendance <=", value, "effectiveattendance");
            return (Criteria) this;
        }

        public Criteria andEffectiveattendanceLike(String value) {
            addCriterion("effectiveAttendance like", value, "effectiveattendance");
            return (Criteria) this;
        }

        public Criteria andEffectiveattendanceNotLike(String value) {
            addCriterion("effectiveAttendance not like", value, "effectiveattendance");
            return (Criteria) this;
        }

        public Criteria andEffectiveattendanceIn(List<String> values) {
            addCriterion("effectiveAttendance in", values, "effectiveattendance");
            return (Criteria) this;
        }

        public Criteria andEffectiveattendanceNotIn(List<String> values) {
            addCriterion("effectiveAttendance not in", values, "effectiveattendance");
            return (Criteria) this;
        }

        public Criteria andEffectiveattendanceBetween(String value1, String value2) {
            addCriterion("effectiveAttendance between", value1, value2, "effectiveattendance");
            return (Criteria) this;
        }

        public Criteria andEffectiveattendanceNotBetween(String value1, String value2) {
            addCriterion("effectiveAttendance not between", value1, value2, "effectiveattendance");
            return (Criteria) this;
        }

        public Criteria andTotalsalaryIsNull() {
            addCriterion("totalsalary is null");
            return (Criteria) this;
        }

        public Criteria andTotalsalaryIsNotNull() {
            addCriterion("totalsalary is not null");
            return (Criteria) this;
        }

        public Criteria andTotalsalaryEqualTo(Double value) {
            addCriterion("totalsalary =", value, "totalsalary");
            return (Criteria) this;
        }

        public Criteria andTotalsalaryNotEqualTo(Double value) {
            addCriterion("totalsalary <>", value, "totalsalary");
            return (Criteria) this;
        }

        public Criteria andTotalsalaryGreaterThan(Double value) {
            addCriterion("totalsalary >", value, "totalsalary");
            return (Criteria) this;
        }

        public Criteria andTotalsalaryGreaterThanOrEqualTo(Double value) {
            addCriterion("totalsalary >=", value, "totalsalary");
            return (Criteria) this;
        }

        public Criteria andTotalsalaryLessThan(Double value) {
            addCriterion("totalsalary <", value, "totalsalary");
            return (Criteria) this;
        }

        public Criteria andTotalsalaryLessThanOrEqualTo(Double value) {
            addCriterion("totalsalary <=", value, "totalsalary");
            return (Criteria) this;
        }

        public Criteria andTotalsalaryIn(List<Double> values) {
            addCriterion("totalsalary in", values, "totalsalary");
            return (Criteria) this;
        }

        public Criteria andTotalsalaryNotIn(List<Double> values) {
            addCriterion("totalsalary not in", values, "totalsalary");
            return (Criteria) this;
        }

        public Criteria andTotalsalaryBetween(Double value1, Double value2) {
            addCriterion("totalsalary between", value1, value2, "totalsalary");
            return (Criteria) this;
        }

        public Criteria andTotalsalaryNotBetween(Double value1, Double value2) {
            addCriterion("totalsalary not between", value1, value2, "totalsalary");
            return (Criteria) this;
        }

        public Criteria andLeavetypeIsNull() {
            addCriterion("leavetype is null");
            return (Criteria) this;
        }

        public Criteria andLeavetypeIsNotNull() {
            addCriterion("leavetype is not null");
            return (Criteria) this;
        }

        public Criteria andLeavetypeEqualTo(String value) {
            addCriterion("leavetype =", value, "leavetype");
            return (Criteria) this;
        }

        public Criteria andLeavetypeNotEqualTo(String value) {
            addCriterion("leavetype <>", value, "leavetype");
            return (Criteria) this;
        }

        public Criteria andLeavetypeGreaterThan(String value) {
            addCriterion("leavetype >", value, "leavetype");
            return (Criteria) this;
        }

        public Criteria andLeavetypeGreaterThanOrEqualTo(String value) {
            addCriterion("leavetype >=", value, "leavetype");
            return (Criteria) this;
        }

        public Criteria andLeavetypeLessThan(String value) {
            addCriterion("leavetype <", value, "leavetype");
            return (Criteria) this;
        }

        public Criteria andLeavetypeLessThanOrEqualTo(String value) {
            addCriterion("leavetype <=", value, "leavetype");
            return (Criteria) this;
        }

        public Criteria andLeavetypeLike(String value) {
            addCriterion("leavetype like", value, "leavetype");
            return (Criteria) this;
        }

        public Criteria andLeavetypeNotLike(String value) {
            addCriterion("leavetype not like", value, "leavetype");
            return (Criteria) this;
        }

        public Criteria andLeavetypeIn(List<String> values) {
            addCriterion("leavetype in", values, "leavetype");
            return (Criteria) this;
        }

        public Criteria andLeavetypeNotIn(List<String> values) {
            addCriterion("leavetype not in", values, "leavetype");
            return (Criteria) this;
        }

        public Criteria andLeavetypeBetween(String value1, String value2) {
            addCriterion("leavetype between", value1, value2, "leavetype");
            return (Criteria) this;
        }

        public Criteria andLeavetypeNotBetween(String value1, String value2) {
            addCriterion("leavetype not between", value1, value2, "leavetype");
            return (Criteria) this;
        }

        public Criteria andLeavesalaryIsNull() {
            addCriterion("leavesalary is null");
            return (Criteria) this;
        }

        public Criteria andLeavesalaryIsNotNull() {
            addCriterion("leavesalary is not null");
            return (Criteria) this;
        }

        public Criteria andLeavesalaryEqualTo(Double value) {
            addCriterion("leavesalary =", value, "leavesalary");
            return (Criteria) this;
        }

        public Criteria andLeavesalaryNotEqualTo(Double value) {
            addCriterion("leavesalary <>", value, "leavesalary");
            return (Criteria) this;
        }

        public Criteria andLeavesalaryGreaterThan(Double value) {
            addCriterion("leavesalary >", value, "leavesalary");
            return (Criteria) this;
        }

        public Criteria andLeavesalaryGreaterThanOrEqualTo(Double value) {
            addCriterion("leavesalary >=", value, "leavesalary");
            return (Criteria) this;
        }

        public Criteria andLeavesalaryLessThan(Double value) {
            addCriterion("leavesalary <", value, "leavesalary");
            return (Criteria) this;
        }

        public Criteria andLeavesalaryLessThanOrEqualTo(Double value) {
            addCriterion("leavesalary <=", value, "leavesalary");
            return (Criteria) this;
        }

        public Criteria andLeavesalaryIn(List<Double> values) {
            addCriterion("leavesalary in", values, "leavesalary");
            return (Criteria) this;
        }

        public Criteria andLeavesalaryNotIn(List<Double> values) {
            addCriterion("leavesalary not in", values, "leavesalary");
            return (Criteria) this;
        }

        public Criteria andLeavesalaryBetween(Double value1, Double value2) {
            addCriterion("leavesalary between", value1, value2, "leavesalary");
            return (Criteria) this;
        }

        public Criteria andLeavesalaryNotBetween(Double value1, Double value2) {
            addCriterion("leavesalary not between", value1, value2, "leavesalary");
            return (Criteria) this;
        }

        public Criteria andWorkovertimeIsNull() {
            addCriterion("workovertime is null");
            return (Criteria) this;
        }

        public Criteria andWorkovertimeIsNotNull() {
            addCriterion("workovertime is not null");
            return (Criteria) this;
        }

        public Criteria andWorkovertimeEqualTo(String value) {
            addCriterion("workovertime =", value, "workovertime");
            return (Criteria) this;
        }

        public Criteria andWorkovertimeNotEqualTo(String value) {
            addCriterion("workovertime <>", value, "workovertime");
            return (Criteria) this;
        }

        public Criteria andWorkovertimeGreaterThan(String value) {
            addCriterion("workovertime >", value, "workovertime");
            return (Criteria) this;
        }

        public Criteria andWorkovertimeGreaterThanOrEqualTo(String value) {
            addCriterion("workovertime >=", value, "workovertime");
            return (Criteria) this;
        }

        public Criteria andWorkovertimeLessThan(String value) {
            addCriterion("workovertime <", value, "workovertime");
            return (Criteria) this;
        }

        public Criteria andWorkovertimeLessThanOrEqualTo(String value) {
            addCriterion("workovertime <=", value, "workovertime");
            return (Criteria) this;
        }

        public Criteria andWorkovertimeLike(String value) {
            addCriterion("workovertime like", value, "workovertime");
            return (Criteria) this;
        }

        public Criteria andWorkovertimeNotLike(String value) {
            addCriterion("workovertime not like", value, "workovertime");
            return (Criteria) this;
        }

        public Criteria andWorkovertimeIn(List<String> values) {
            addCriterion("workovertime in", values, "workovertime");
            return (Criteria) this;
        }

        public Criteria andWorkovertimeNotIn(List<String> values) {
            addCriterion("workovertime not in", values, "workovertime");
            return (Criteria) this;
        }

        public Criteria andWorkovertimeBetween(String value1, String value2) {
            addCriterion("workovertime between", value1, value2, "workovertime");
            return (Criteria) this;
        }

        public Criteria andWorkovertimeNotBetween(String value1, String value2) {
            addCriterion("workovertime not between", value1, value2, "workovertime");
            return (Criteria) this;
        }

        public Criteria andWorksalaryIsNull() {
            addCriterion("worksalary is null");
            return (Criteria) this;
        }

        public Criteria andWorksalaryIsNotNull() {
            addCriterion("worksalary is not null");
            return (Criteria) this;
        }

        public Criteria andWorksalaryEqualTo(Double value) {
            addCriterion("worksalary =", value, "worksalary");
            return (Criteria) this;
        }

        public Criteria andWorksalaryNotEqualTo(Double value) {
            addCriterion("worksalary <>", value, "worksalary");
            return (Criteria) this;
        }

        public Criteria andWorksalaryGreaterThan(Double value) {
            addCriterion("worksalary >", value, "worksalary");
            return (Criteria) this;
        }

        public Criteria andWorksalaryGreaterThanOrEqualTo(Double value) {
            addCriterion("worksalary >=", value, "worksalary");
            return (Criteria) this;
        }

        public Criteria andWorksalaryLessThan(Double value) {
            addCriterion("worksalary <", value, "worksalary");
            return (Criteria) this;
        }

        public Criteria andWorksalaryLessThanOrEqualTo(Double value) {
            addCriterion("worksalary <=", value, "worksalary");
            return (Criteria) this;
        }

        public Criteria andWorksalaryIn(List<Double> values) {
            addCriterion("worksalary in", values, "worksalary");
            return (Criteria) this;
        }

        public Criteria andWorksalaryNotIn(List<Double> values) {
            addCriterion("worksalary not in", values, "worksalary");
            return (Criteria) this;
        }

        public Criteria andWorksalaryBetween(Double value1, Double value2) {
            addCriterion("worksalary between", value1, value2, "worksalary");
            return (Criteria) this;
        }

        public Criteria andWorksalaryNotBetween(Double value1, Double value2) {
            addCriterion("worksalary not between", value1, value2, "worksalary");
            return (Criteria) this;
        }

        public Criteria andEvectionIsNull() {
            addCriterion("evection is null");
            return (Criteria) this;
        }

        public Criteria andEvectionIsNotNull() {
            addCriterion("evection is not null");
            return (Criteria) this;
        }

        public Criteria andEvectionEqualTo(String value) {
            addCriterion("evection =", value, "evection");
            return (Criteria) this;
        }

        public Criteria andEvectionNotEqualTo(String value) {
            addCriterion("evection <>", value, "evection");
            return (Criteria) this;
        }

        public Criteria andEvectionGreaterThan(String value) {
            addCriterion("evection >", value, "evection");
            return (Criteria) this;
        }

        public Criteria andEvectionGreaterThanOrEqualTo(String value) {
            addCriterion("evection >=", value, "evection");
            return (Criteria) this;
        }

        public Criteria andEvectionLessThan(String value) {
            addCriterion("evection <", value, "evection");
            return (Criteria) this;
        }

        public Criteria andEvectionLessThanOrEqualTo(String value) {
            addCriterion("evection <=", value, "evection");
            return (Criteria) this;
        }

        public Criteria andEvectionLike(String value) {
            addCriterion("evection like", value, "evection");
            return (Criteria) this;
        }

        public Criteria andEvectionNotLike(String value) {
            addCriterion("evection not like", value, "evection");
            return (Criteria) this;
        }

        public Criteria andEvectionIn(List<String> values) {
            addCriterion("evection in", values, "evection");
            return (Criteria) this;
        }

        public Criteria andEvectionNotIn(List<String> values) {
            addCriterion("evection not in", values, "evection");
            return (Criteria) this;
        }

        public Criteria andEvectionBetween(String value1, String value2) {
            addCriterion("evection between", value1, value2, "evection");
            return (Criteria) this;
        }

        public Criteria andEvectionNotBetween(String value1, String value2) {
            addCriterion("evection not between", value1, value2, "evection");
            return (Criteria) this;
        }

        public Criteria andAllowanceIsNull() {
            addCriterion("allowance is null");
            return (Criteria) this;
        }

        public Criteria andAllowanceIsNotNull() {
            addCriterion("allowance is not null");
            return (Criteria) this;
        }

        public Criteria andAllowanceEqualTo(String value) {
            addCriterion("allowance =", value, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceNotEqualTo(String value) {
            addCriterion("allowance <>", value, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceGreaterThan(String value) {
            addCriterion("allowance >", value, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceGreaterThanOrEqualTo(String value) {
            addCriterion("allowance >=", value, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceLessThan(String value) {
            addCriterion("allowance <", value, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceLessThanOrEqualTo(String value) {
            addCriterion("allowance <=", value, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceLike(String value) {
            addCriterion("allowance like", value, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceNotLike(String value) {
            addCriterion("allowance not like", value, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceIn(List<String> values) {
            addCriterion("allowance in", values, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceNotIn(List<String> values) {
            addCriterion("allowance not in", values, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceBetween(String value1, String value2) {
            addCriterion("allowance between", value1, value2, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceNotBetween(String value1, String value2) {
            addCriterion("allowance not between", value1, value2, "allowance");
            return (Criteria) this;
        }

        public Criteria andTimesalaryIsNull() {
            addCriterion("timesalary is null");
            return (Criteria) this;
        }

        public Criteria andTimesalaryIsNotNull() {
            addCriterion("timesalary is not null");
            return (Criteria) this;
        }

        public Criteria andTimesalaryEqualTo(Double value) {
            addCriterion("timesalary =", value, "timesalary");
            return (Criteria) this;
        }

        public Criteria andTimesalaryNotEqualTo(Double value) {
            addCriterion("timesalary <>", value, "timesalary");
            return (Criteria) this;
        }

        public Criteria andTimesalaryGreaterThan(Double value) {
            addCriterion("timesalary >", value, "timesalary");
            return (Criteria) this;
        }

        public Criteria andTimesalaryGreaterThanOrEqualTo(Double value) {
            addCriterion("timesalary >=", value, "timesalary");
            return (Criteria) this;
        }

        public Criteria andTimesalaryLessThan(Double value) {
            addCriterion("timesalary <", value, "timesalary");
            return (Criteria) this;
        }

        public Criteria andTimesalaryLessThanOrEqualTo(Double value) {
            addCriterion("timesalary <=", value, "timesalary");
            return (Criteria) this;
        }

        public Criteria andTimesalaryIn(List<Double> values) {
            addCriterion("timesalary in", values, "timesalary");
            return (Criteria) this;
        }

        public Criteria andTimesalaryNotIn(List<Double> values) {
            addCriterion("timesalary not in", values, "timesalary");
            return (Criteria) this;
        }

        public Criteria andTimesalaryBetween(Double value1, Double value2) {
            addCriterion("timesalary between", value1, value2, "timesalary");
            return (Criteria) this;
        }

        public Criteria andTimesalaryNotBetween(Double value1, Double value2) {
            addCriterion("timesalary not between", value1, value2, "timesalary");
            return (Criteria) this;
        }

        public Criteria andTaskIsNull() {
            addCriterion("task is null");
            return (Criteria) this;
        }

        public Criteria andTaskIsNotNull() {
            addCriterion("task is not null");
            return (Criteria) this;
        }

        public Criteria andTaskEqualTo(String value) {
            addCriterion("task =", value, "task");
            return (Criteria) this;
        }

        public Criteria andTaskNotEqualTo(String value) {
            addCriterion("task <>", value, "task");
            return (Criteria) this;
        }

        public Criteria andTaskGreaterThan(String value) {
            addCriterion("task >", value, "task");
            return (Criteria) this;
        }

        public Criteria andTaskGreaterThanOrEqualTo(String value) {
            addCriterion("task >=", value, "task");
            return (Criteria) this;
        }

        public Criteria andTaskLessThan(String value) {
            addCriterion("task <", value, "task");
            return (Criteria) this;
        }

        public Criteria andTaskLessThanOrEqualTo(String value) {
            addCriterion("task <=", value, "task");
            return (Criteria) this;
        }

        public Criteria andTaskLike(String value) {
            addCriterion("task like", value, "task");
            return (Criteria) this;
        }

        public Criteria andTaskNotLike(String value) {
            addCriterion("task not like", value, "task");
            return (Criteria) this;
        }

        public Criteria andTaskIn(List<String> values) {
            addCriterion("task in", values, "task");
            return (Criteria) this;
        }

        public Criteria andTaskNotIn(List<String> values) {
            addCriterion("task not in", values, "task");
            return (Criteria) this;
        }

        public Criteria andTaskBetween(String value1, String value2) {
            addCriterion("task between", value1, value2, "task");
            return (Criteria) this;
        }

        public Criteria andTaskNotBetween(String value1, String value2) {
            addCriterion("task not between", value1, value2, "task");
            return (Criteria) this;
        }

        public Criteria andTasksalaryIsNull() {
            addCriterion("tasksalary is null");
            return (Criteria) this;
        }

        public Criteria andTasksalaryIsNotNull() {
            addCriterion("tasksalary is not null");
            return (Criteria) this;
        }

        public Criteria andTasksalaryEqualTo(Double value) {
            addCriterion("tasksalary =", value, "tasksalary");
            return (Criteria) this;
        }

        public Criteria andTasksalaryNotEqualTo(Double value) {
            addCriterion("tasksalary <>", value, "tasksalary");
            return (Criteria) this;
        }

        public Criteria andTasksalaryGreaterThan(Double value) {
            addCriterion("tasksalary >", value, "tasksalary");
            return (Criteria) this;
        }

        public Criteria andTasksalaryGreaterThanOrEqualTo(Double value) {
            addCriterion("tasksalary >=", value, "tasksalary");
            return (Criteria) this;
        }

        public Criteria andTasksalaryLessThan(Double value) {
            addCriterion("tasksalary <", value, "tasksalary");
            return (Criteria) this;
        }

        public Criteria andTasksalaryLessThanOrEqualTo(Double value) {
            addCriterion("tasksalary <=", value, "tasksalary");
            return (Criteria) this;
        }

        public Criteria andTasksalaryIn(List<Double> values) {
            addCriterion("tasksalary in", values, "tasksalary");
            return (Criteria) this;
        }

        public Criteria andTasksalaryNotIn(List<Double> values) {
            addCriterion("tasksalary not in", values, "tasksalary");
            return (Criteria) this;
        }

        public Criteria andTasksalaryBetween(Double value1, Double value2) {
            addCriterion("tasksalary between", value1, value2, "tasksalary");
            return (Criteria) this;
        }

        public Criteria andTasksalaryNotBetween(Double value1, Double value2) {
            addCriterion("tasksalary not between", value1, value2, "tasksalary");
            return (Criteria) this;
        }

        public Criteria andBusalaryIsNull() {
            addCriterion("busalary is null");
            return (Criteria) this;
        }

        public Criteria andBusalaryIsNotNull() {
            addCriterion("busalary is not null");
            return (Criteria) this;
        }

        public Criteria andBusalaryEqualTo(Double value) {
            addCriterion("busalary =", value, "busalary");
            return (Criteria) this;
        }

        public Criteria andBusalaryNotEqualTo(Double value) {
            addCriterion("busalary <>", value, "busalary");
            return (Criteria) this;
        }

        public Criteria andBusalaryGreaterThan(Double value) {
            addCriterion("busalary >", value, "busalary");
            return (Criteria) this;
        }

        public Criteria andBusalaryGreaterThanOrEqualTo(Double value) {
            addCriterion("busalary >=", value, "busalary");
            return (Criteria) this;
        }

        public Criteria andBusalaryLessThan(Double value) {
            addCriterion("busalary <", value, "busalary");
            return (Criteria) this;
        }

        public Criteria andBusalaryLessThanOrEqualTo(Double value) {
            addCriterion("busalary <=", value, "busalary");
            return (Criteria) this;
        }

        public Criteria andBusalaryIn(List<Double> values) {
            addCriterion("busalary in", values, "busalary");
            return (Criteria) this;
        }

        public Criteria andBusalaryNotIn(List<Double> values) {
            addCriterion("busalary not in", values, "busalary");
            return (Criteria) this;
        }

        public Criteria andBusalaryBetween(Double value1, Double value2) {
            addCriterion("busalary between", value1, value2, "busalary");
            return (Criteria) this;
        }

        public Criteria andBusalaryNotBetween(Double value1, Double value2) {
            addCriterion("busalary not between", value1, value2, "busalary");
            return (Criteria) this;
        }

        public Criteria andTrafficsalaryIsNull() {
            addCriterion("trafficsalary is null");
            return (Criteria) this;
        }

        public Criteria andTrafficsalaryIsNotNull() {
            addCriterion("trafficsalary is not null");
            return (Criteria) this;
        }

        public Criteria andTrafficsalaryEqualTo(Double value) {
            addCriterion("trafficsalary =", value, "trafficsalary");
            return (Criteria) this;
        }

        public Criteria andTrafficsalaryNotEqualTo(Double value) {
            addCriterion("trafficsalary <>", value, "trafficsalary");
            return (Criteria) this;
        }

        public Criteria andTrafficsalaryGreaterThan(Double value) {
            addCriterion("trafficsalary >", value, "trafficsalary");
            return (Criteria) this;
        }

        public Criteria andTrafficsalaryGreaterThanOrEqualTo(Double value) {
            addCriterion("trafficsalary >=", value, "trafficsalary");
            return (Criteria) this;
        }

        public Criteria andTrafficsalaryLessThan(Double value) {
            addCriterion("trafficsalary <", value, "trafficsalary");
            return (Criteria) this;
        }

        public Criteria andTrafficsalaryLessThanOrEqualTo(Double value) {
            addCriterion("trafficsalary <=", value, "trafficsalary");
            return (Criteria) this;
        }

        public Criteria andTrafficsalaryIn(List<Double> values) {
            addCriterion("trafficsalary in", values, "trafficsalary");
            return (Criteria) this;
        }

        public Criteria andTrafficsalaryNotIn(List<Double> values) {
            addCriterion("trafficsalary not in", values, "trafficsalary");
            return (Criteria) this;
        }

        public Criteria andTrafficsalaryBetween(Double value1, Double value2) {
            addCriterion("trafficsalary between", value1, value2, "trafficsalary");
            return (Criteria) this;
        }

        public Criteria andTrafficsalaryNotBetween(Double value1, Double value2) {
            addCriterion("trafficsalary not between", value1, value2, "trafficsalary");
            return (Criteria) this;
        }

        public Criteria andAdditionalsalaryIsNull() {
            addCriterion("additionalsalary is null");
            return (Criteria) this;
        }

        public Criteria andAdditionalsalaryIsNotNull() {
            addCriterion("additionalsalary is not null");
            return (Criteria) this;
        }

        public Criteria andAdditionalsalaryEqualTo(Double value) {
            addCriterion("additionalsalary =", value, "additionalsalary");
            return (Criteria) this;
        }

        public Criteria andAdditionalsalaryNotEqualTo(Double value) {
            addCriterion("additionalsalary <>", value, "additionalsalary");
            return (Criteria) this;
        }

        public Criteria andAdditionalsalaryGreaterThan(Double value) {
            addCriterion("additionalsalary >", value, "additionalsalary");
            return (Criteria) this;
        }

        public Criteria andAdditionalsalaryGreaterThanOrEqualTo(Double value) {
            addCriterion("additionalsalary >=", value, "additionalsalary");
            return (Criteria) this;
        }

        public Criteria andAdditionalsalaryLessThan(Double value) {
            addCriterion("additionalsalary <", value, "additionalsalary");
            return (Criteria) this;
        }

        public Criteria andAdditionalsalaryLessThanOrEqualTo(Double value) {
            addCriterion("additionalsalary <=", value, "additionalsalary");
            return (Criteria) this;
        }

        public Criteria andAdditionalsalaryIn(List<Double> values) {
            addCriterion("additionalsalary in", values, "additionalsalary");
            return (Criteria) this;
        }

        public Criteria andAdditionalsalaryNotIn(List<Double> values) {
            addCriterion("additionalsalary not in", values, "additionalsalary");
            return (Criteria) this;
        }

        public Criteria andAdditionalsalaryBetween(Double value1, Double value2) {
            addCriterion("additionalsalary between", value1, value2, "additionalsalary");
            return (Criteria) this;
        }

        public Criteria andAdditionalsalaryNotBetween(Double value1, Double value2) {
            addCriterion("additionalsalary not between", value1, value2, "additionalsalary");
            return (Criteria) this;
        }

        public Criteria andTotalIsNull() {
            addCriterion("total is null");
            return (Criteria) this;
        }

        public Criteria andTotalIsNotNull() {
            addCriterion("total is not null");
            return (Criteria) this;
        }

        public Criteria andTotalEqualTo(String value) {
            addCriterion("total =", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotEqualTo(String value) {
            addCriterion("total <>", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThan(String value) {
            addCriterion("total >", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThanOrEqualTo(String value) {
            addCriterion("total >=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThan(String value) {
            addCriterion("total <", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThanOrEqualTo(String value) {
            addCriterion("total <=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLike(String value) {
            addCriterion("total like", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotLike(String value) {
            addCriterion("total not like", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalIn(List<String> values) {
            addCriterion("total in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotIn(List<String> values) {
            addCriterion("total not in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalBetween(String value1, String value2) {
            addCriterion("total between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotBetween(String value1, String value2) {
            addCriterion("total not between", value1, value2, "total");
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