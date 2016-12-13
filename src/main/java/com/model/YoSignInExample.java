package com.model;

import java.util.ArrayList;
import java.util.List;

public class YoSignInExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public YoSignInExample() {
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

        public Criteria andSiSequenceNoIsNull() {
            addCriterion("si_sequence_no is null");
            return (Criteria) this;
        }

        public Criteria andSiSequenceNoIsNotNull() {
            addCriterion("si_sequence_no is not null");
            return (Criteria) this;
        }

        public Criteria andSiSequenceNoEqualTo(Integer value) {
            addCriterion("si_sequence_no =", value, "siSequenceNo");
            return (Criteria) this;
        }

        public Criteria andSiSequenceNoNotEqualTo(Integer value) {
            addCriterion("si_sequence_no <>", value, "siSequenceNo");
            return (Criteria) this;
        }

        public Criteria andSiSequenceNoGreaterThan(Integer value) {
            addCriterion("si_sequence_no >", value, "siSequenceNo");
            return (Criteria) this;
        }

        public Criteria andSiSequenceNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("si_sequence_no >=", value, "siSequenceNo");
            return (Criteria) this;
        }

        public Criteria andSiSequenceNoLessThan(Integer value) {
            addCriterion("si_sequence_no <", value, "siSequenceNo");
            return (Criteria) this;
        }

        public Criteria andSiSequenceNoLessThanOrEqualTo(Integer value) {
            addCriterion("si_sequence_no <=", value, "siSequenceNo");
            return (Criteria) this;
        }

        public Criteria andSiSequenceNoIn(List<Integer> values) {
            addCriterion("si_sequence_no in", values, "siSequenceNo");
            return (Criteria) this;
        }

        public Criteria andSiSequenceNoNotIn(List<Integer> values) {
            addCriterion("si_sequence_no not in", values, "siSequenceNo");
            return (Criteria) this;
        }

        public Criteria andSiSequenceNoBetween(Integer value1, Integer value2) {
            addCriterion("si_sequence_no between", value1, value2, "siSequenceNo");
            return (Criteria) this;
        }

        public Criteria andSiSequenceNoNotBetween(Integer value1, Integer value2) {
            addCriterion("si_sequence_no not between", value1, value2, "siSequenceNo");
            return (Criteria) this;
        }

        public Criteria andSiNameIsNull() {
            addCriterion("si_name is null");
            return (Criteria) this;
        }

        public Criteria andSiNameIsNotNull() {
            addCriterion("si_name is not null");
            return (Criteria) this;
        }

        public Criteria andSiNameEqualTo(String value) {
            addCriterion("si_name =", value, "siName");
            return (Criteria) this;
        }

        public Criteria andSiNameNotEqualTo(String value) {
            addCriterion("si_name <>", value, "siName");
            return (Criteria) this;
        }

        public Criteria andSiNameGreaterThan(String value) {
            addCriterion("si_name >", value, "siName");
            return (Criteria) this;
        }

        public Criteria andSiNameGreaterThanOrEqualTo(String value) {
            addCriterion("si_name >=", value, "siName");
            return (Criteria) this;
        }

        public Criteria andSiNameLessThan(String value) {
            addCriterion("si_name <", value, "siName");
            return (Criteria) this;
        }

        public Criteria andSiNameLessThanOrEqualTo(String value) {
            addCriterion("si_name <=", value, "siName");
            return (Criteria) this;
        }

        public Criteria andSiNameLike(String value) {
            addCriterion("si_name like", value, "siName");
            return (Criteria) this;
        }

        public Criteria andSiNameNotLike(String value) {
            addCriterion("si_name not like", value, "siName");
            return (Criteria) this;
        }

        public Criteria andSiNameIn(List<String> values) {
            addCriterion("si_name in", values, "siName");
            return (Criteria) this;
        }

        public Criteria andSiNameNotIn(List<String> values) {
            addCriterion("si_name not in", values, "siName");
            return (Criteria) this;
        }

        public Criteria andSiNameBetween(String value1, String value2) {
            addCriterion("si_name between", value1, value2, "siName");
            return (Criteria) this;
        }

        public Criteria andSiNameNotBetween(String value1, String value2) {
            addCriterion("si_name not between", value1, value2, "siName");
            return (Criteria) this;
        }

        public Criteria andSiStaffIdIsNull() {
            addCriterion("si_staff_id is null");
            return (Criteria) this;
        }

        public Criteria andSiStaffIdIsNotNull() {
            addCriterion("si_staff_id is not null");
            return (Criteria) this;
        }

        public Criteria andSiStaffIdEqualTo(String value) {
            addCriterion("si_staff_id =", value, "siStaffId");
            return (Criteria) this;
        }

        public Criteria andSiStaffIdNotEqualTo(String value) {
            addCriterion("si_staff_id <>", value, "siStaffId");
            return (Criteria) this;
        }

        public Criteria andSiStaffIdGreaterThan(String value) {
            addCriterion("si_staff_id >", value, "siStaffId");
            return (Criteria) this;
        }

        public Criteria andSiStaffIdGreaterThanOrEqualTo(String value) {
            addCriterion("si_staff_id >=", value, "siStaffId");
            return (Criteria) this;
        }

        public Criteria andSiStaffIdLessThan(String value) {
            addCriterion("si_staff_id <", value, "siStaffId");
            return (Criteria) this;
        }

        public Criteria andSiStaffIdLessThanOrEqualTo(String value) {
            addCriterion("si_staff_id <=", value, "siStaffId");
            return (Criteria) this;
        }

        public Criteria andSiStaffIdLike(String value) {
            addCriterion("si_staff_id like", value, "siStaffId");
            return (Criteria) this;
        }

        public Criteria andSiStaffIdNotLike(String value) {
            addCriterion("si_staff_id not like", value, "siStaffId");
            return (Criteria) this;
        }

        public Criteria andSiStaffIdIn(List<String> values) {
            addCriterion("si_staff_id in", values, "siStaffId");
            return (Criteria) this;
        }

        public Criteria andSiStaffIdNotIn(List<String> values) {
            addCriterion("si_staff_id not in", values, "siStaffId");
            return (Criteria) this;
        }

        public Criteria andSiStaffIdBetween(String value1, String value2) {
            addCriterion("si_staff_id between", value1, value2, "siStaffId");
            return (Criteria) this;
        }

        public Criteria andSiStaffIdNotBetween(String value1, String value2) {
            addCriterion("si_staff_id not between", value1, value2, "siStaffId");
            return (Criteria) this;
        }

        public Criteria andSiDepartmentIsNull() {
            addCriterion("si_department is null");
            return (Criteria) this;
        }

        public Criteria andSiDepartmentIsNotNull() {
            addCriterion("si_department is not null");
            return (Criteria) this;
        }

        public Criteria andSiDepartmentEqualTo(String value) {
            addCriterion("si_department =", value, "siDepartment");
            return (Criteria) this;
        }

        public Criteria andSiDepartmentNotEqualTo(String value) {
            addCriterion("si_department <>", value, "siDepartment");
            return (Criteria) this;
        }

        public Criteria andSiDepartmentGreaterThan(String value) {
            addCriterion("si_department >", value, "siDepartment");
            return (Criteria) this;
        }

        public Criteria andSiDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("si_department >=", value, "siDepartment");
            return (Criteria) this;
        }

        public Criteria andSiDepartmentLessThan(String value) {
            addCriterion("si_department <", value, "siDepartment");
            return (Criteria) this;
        }

        public Criteria andSiDepartmentLessThanOrEqualTo(String value) {
            addCriterion("si_department <=", value, "siDepartment");
            return (Criteria) this;
        }

        public Criteria andSiDepartmentLike(String value) {
            addCriterion("si_department like", value, "siDepartment");
            return (Criteria) this;
        }

        public Criteria andSiDepartmentNotLike(String value) {
            addCriterion("si_department not like", value, "siDepartment");
            return (Criteria) this;
        }

        public Criteria andSiDepartmentIn(List<String> values) {
            addCriterion("si_department in", values, "siDepartment");
            return (Criteria) this;
        }

        public Criteria andSiDepartmentNotIn(List<String> values) {
            addCriterion("si_department not in", values, "siDepartment");
            return (Criteria) this;
        }

        public Criteria andSiDepartmentBetween(String value1, String value2) {
            addCriterion("si_department between", value1, value2, "siDepartment");
            return (Criteria) this;
        }

        public Criteria andSiDepartmentNotBetween(String value1, String value2) {
            addCriterion("si_department not between", value1, value2, "siDepartment");
            return (Criteria) this;
        }

        public Criteria andSiCompleteDepartmentIsNull() {
            addCriterion("si_complete_department is null");
            return (Criteria) this;
        }

        public Criteria andSiCompleteDepartmentIsNotNull() {
            addCriterion("si_complete_department is not null");
            return (Criteria) this;
        }

        public Criteria andSiCompleteDepartmentEqualTo(String value) {
            addCriterion("si_complete_department =", value, "siCompleteDepartment");
            return (Criteria) this;
        }

        public Criteria andSiCompleteDepartmentNotEqualTo(String value) {
            addCriterion("si_complete_department <>", value, "siCompleteDepartment");
            return (Criteria) this;
        }

        public Criteria andSiCompleteDepartmentGreaterThan(String value) {
            addCriterion("si_complete_department >", value, "siCompleteDepartment");
            return (Criteria) this;
        }

        public Criteria andSiCompleteDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("si_complete_department >=", value, "siCompleteDepartment");
            return (Criteria) this;
        }

        public Criteria andSiCompleteDepartmentLessThan(String value) {
            addCriterion("si_complete_department <", value, "siCompleteDepartment");
            return (Criteria) this;
        }

        public Criteria andSiCompleteDepartmentLessThanOrEqualTo(String value) {
            addCriterion("si_complete_department <=", value, "siCompleteDepartment");
            return (Criteria) this;
        }

        public Criteria andSiCompleteDepartmentLike(String value) {
            addCriterion("si_complete_department like", value, "siCompleteDepartment");
            return (Criteria) this;
        }

        public Criteria andSiCompleteDepartmentNotLike(String value) {
            addCriterion("si_complete_department not like", value, "siCompleteDepartment");
            return (Criteria) this;
        }

        public Criteria andSiCompleteDepartmentIn(List<String> values) {
            addCriterion("si_complete_department in", values, "siCompleteDepartment");
            return (Criteria) this;
        }

        public Criteria andSiCompleteDepartmentNotIn(List<String> values) {
            addCriterion("si_complete_department not in", values, "siCompleteDepartment");
            return (Criteria) this;
        }

        public Criteria andSiCompleteDepartmentBetween(String value1, String value2) {
            addCriterion("si_complete_department between", value1, value2, "siCompleteDepartment");
            return (Criteria) this;
        }

        public Criteria andSiCompleteDepartmentNotBetween(String value1, String value2) {
            addCriterion("si_complete_department not between", value1, value2, "siCompleteDepartment");
            return (Criteria) this;
        }

        public Criteria andSiJobPositionIsNull() {
            addCriterion("si_job_position is null");
            return (Criteria) this;
        }

        public Criteria andSiJobPositionIsNotNull() {
            addCriterion("si_job_position is not null");
            return (Criteria) this;
        }

        public Criteria andSiJobPositionEqualTo(String value) {
            addCriterion("si_job_position =", value, "siJobPosition");
            return (Criteria) this;
        }

        public Criteria andSiJobPositionNotEqualTo(String value) {
            addCriterion("si_job_position <>", value, "siJobPosition");
            return (Criteria) this;
        }

        public Criteria andSiJobPositionGreaterThan(String value) {
            addCriterion("si_job_position >", value, "siJobPosition");
            return (Criteria) this;
        }

        public Criteria andSiJobPositionGreaterThanOrEqualTo(String value) {
            addCriterion("si_job_position >=", value, "siJobPosition");
            return (Criteria) this;
        }

        public Criteria andSiJobPositionLessThan(String value) {
            addCriterion("si_job_position <", value, "siJobPosition");
            return (Criteria) this;
        }

        public Criteria andSiJobPositionLessThanOrEqualTo(String value) {
            addCriterion("si_job_position <=", value, "siJobPosition");
            return (Criteria) this;
        }

        public Criteria andSiJobPositionLike(String value) {
            addCriterion("si_job_position like", value, "siJobPosition");
            return (Criteria) this;
        }

        public Criteria andSiJobPositionNotLike(String value) {
            addCriterion("si_job_position not like", value, "siJobPosition");
            return (Criteria) this;
        }

        public Criteria andSiJobPositionIn(List<String> values) {
            addCriterion("si_job_position in", values, "siJobPosition");
            return (Criteria) this;
        }

        public Criteria andSiJobPositionNotIn(List<String> values) {
            addCriterion("si_job_position not in", values, "siJobPosition");
            return (Criteria) this;
        }

        public Criteria andSiJobPositionBetween(String value1, String value2) {
            addCriterion("si_job_position between", value1, value2, "siJobPosition");
            return (Criteria) this;
        }

        public Criteria andSiJobPositionNotBetween(String value1, String value2) {
            addCriterion("si_job_position not between", value1, value2, "siJobPosition");
            return (Criteria) this;
        }

        public Criteria andSiDateIsNull() {
            addCriterion("si_date is null");
            return (Criteria) this;
        }

        public Criteria andSiDateIsNotNull() {
            addCriterion("si_date is not null");
            return (Criteria) this;
        }

        public Criteria andSiDateEqualTo(String value) {
            addCriterion("si_date =", value, "siDate");
            return (Criteria) this;
        }

        public Criteria andSiDateNotEqualTo(String value) {
            addCriterion("si_date <>", value, "siDate");
            return (Criteria) this;
        }

        public Criteria andSiDateGreaterThan(String value) {
            addCriterion("si_date >", value, "siDate");
            return (Criteria) this;
        }

        public Criteria andSiDateGreaterThanOrEqualTo(String value) {
            addCriterion("si_date >=", value, "siDate");
            return (Criteria) this;
        }

        public Criteria andSiDateLessThan(String value) {
            addCriterion("si_date <", value, "siDate");
            return (Criteria) this;
        }

        public Criteria andSiDateLessThanOrEqualTo(String value) {
            addCriterion("si_date <=", value, "siDate");
            return (Criteria) this;
        }

        public Criteria andSiDateLike(String value) {
            addCriterion("si_date like", value, "siDate");
            return (Criteria) this;
        }

        public Criteria andSiDateNotLike(String value) {
            addCriterion("si_date not like", value, "siDate");
            return (Criteria) this;
        }

        public Criteria andSiDateIn(List<String> values) {
            addCriterion("si_date in", values, "siDate");
            return (Criteria) this;
        }

        public Criteria andSiDateNotIn(List<String> values) {
            addCriterion("si_date not in", values, "siDate");
            return (Criteria) this;
        }

        public Criteria andSiDateBetween(String value1, String value2) {
            addCriterion("si_date between", value1, value2, "siDate");
            return (Criteria) this;
        }

        public Criteria andSiDateNotBetween(String value1, String value2) {
            addCriterion("si_date not between", value1, value2, "siDate");
            return (Criteria) this;
        }

        public Criteria andSiTimeIsNull() {
            addCriterion("si_time is null");
            return (Criteria) this;
        }

        public Criteria andSiTimeIsNotNull() {
            addCriterion("si_time is not null");
            return (Criteria) this;
        }

        public Criteria andSiTimeEqualTo(String value) {
            addCriterion("si_time =", value, "siTime");
            return (Criteria) this;
        }

        public Criteria andSiTimeNotEqualTo(String value) {
            addCriterion("si_time <>", value, "siTime");
            return (Criteria) this;
        }

        public Criteria andSiTimeGreaterThan(String value) {
            addCriterion("si_time >", value, "siTime");
            return (Criteria) this;
        }

        public Criteria andSiTimeGreaterThanOrEqualTo(String value) {
            addCriterion("si_time >=", value, "siTime");
            return (Criteria) this;
        }

        public Criteria andSiTimeLessThan(String value) {
            addCriterion("si_time <", value, "siTime");
            return (Criteria) this;
        }

        public Criteria andSiTimeLessThanOrEqualTo(String value) {
            addCriterion("si_time <=", value, "siTime");
            return (Criteria) this;
        }

        public Criteria andSiTimeLike(String value) {
            addCriterion("si_time like", value, "siTime");
            return (Criteria) this;
        }

        public Criteria andSiTimeNotLike(String value) {
            addCriterion("si_time not like", value, "siTime");
            return (Criteria) this;
        }

        public Criteria andSiTimeIn(List<String> values) {
            addCriterion("si_time in", values, "siTime");
            return (Criteria) this;
        }

        public Criteria andSiTimeNotIn(List<String> values) {
            addCriterion("si_time not in", values, "siTime");
            return (Criteria) this;
        }

        public Criteria andSiTimeBetween(String value1, String value2) {
            addCriterion("si_time between", value1, value2, "siTime");
            return (Criteria) this;
        }

        public Criteria andSiTimeNotBetween(String value1, String value2) {
            addCriterion("si_time not between", value1, value2, "siTime");
            return (Criteria) this;
        }

        public Criteria andSiLongitudeIsNull() {
            addCriterion("si_longitude is null");
            return (Criteria) this;
        }

        public Criteria andSiLongitudeIsNotNull() {
            addCriterion("si_longitude is not null");
            return (Criteria) this;
        }

        public Criteria andSiLongitudeEqualTo(String value) {
            addCriterion("si_longitude =", value, "siLongitude");
            return (Criteria) this;
        }

        public Criteria andSiLongitudeNotEqualTo(String value) {
            addCriterion("si_longitude <>", value, "siLongitude");
            return (Criteria) this;
        }

        public Criteria andSiLongitudeGreaterThan(String value) {
            addCriterion("si_longitude >", value, "siLongitude");
            return (Criteria) this;
        }

        public Criteria andSiLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("si_longitude >=", value, "siLongitude");
            return (Criteria) this;
        }

        public Criteria andSiLongitudeLessThan(String value) {
            addCriterion("si_longitude <", value, "siLongitude");
            return (Criteria) this;
        }

        public Criteria andSiLongitudeLessThanOrEqualTo(String value) {
            addCriterion("si_longitude <=", value, "siLongitude");
            return (Criteria) this;
        }

        public Criteria andSiLongitudeLike(String value) {
            addCriterion("si_longitude like", value, "siLongitude");
            return (Criteria) this;
        }

        public Criteria andSiLongitudeNotLike(String value) {
            addCriterion("si_longitude not like", value, "siLongitude");
            return (Criteria) this;
        }

        public Criteria andSiLongitudeIn(List<String> values) {
            addCriterion("si_longitude in", values, "siLongitude");
            return (Criteria) this;
        }

        public Criteria andSiLongitudeNotIn(List<String> values) {
            addCriterion("si_longitude not in", values, "siLongitude");
            return (Criteria) this;
        }

        public Criteria andSiLongitudeBetween(String value1, String value2) {
            addCriterion("si_longitude between", value1, value2, "siLongitude");
            return (Criteria) this;
        }

        public Criteria andSiLongitudeNotBetween(String value1, String value2) {
            addCriterion("si_longitude not between", value1, value2, "siLongitude");
            return (Criteria) this;
        }

        public Criteria andSiLatitudeIsNull() {
            addCriterion("si_latitude is null");
            return (Criteria) this;
        }

        public Criteria andSiLatitudeIsNotNull() {
            addCriterion("si_latitude is not null");
            return (Criteria) this;
        }

        public Criteria andSiLatitudeEqualTo(String value) {
            addCriterion("si_latitude =", value, "siLatitude");
            return (Criteria) this;
        }

        public Criteria andSiLatitudeNotEqualTo(String value) {
            addCriterion("si_latitude <>", value, "siLatitude");
            return (Criteria) this;
        }

        public Criteria andSiLatitudeGreaterThan(String value) {
            addCriterion("si_latitude >", value, "siLatitude");
            return (Criteria) this;
        }

        public Criteria andSiLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("si_latitude >=", value, "siLatitude");
            return (Criteria) this;
        }

        public Criteria andSiLatitudeLessThan(String value) {
            addCriterion("si_latitude <", value, "siLatitude");
            return (Criteria) this;
        }

        public Criteria andSiLatitudeLessThanOrEqualTo(String value) {
            addCriterion("si_latitude <=", value, "siLatitude");
            return (Criteria) this;
        }

        public Criteria andSiLatitudeLike(String value) {
            addCriterion("si_latitude like", value, "siLatitude");
            return (Criteria) this;
        }

        public Criteria andSiLatitudeNotLike(String value) {
            addCriterion("si_latitude not like", value, "siLatitude");
            return (Criteria) this;
        }

        public Criteria andSiLatitudeIn(List<String> values) {
            addCriterion("si_latitude in", values, "siLatitude");
            return (Criteria) this;
        }

        public Criteria andSiLatitudeNotIn(List<String> values) {
            addCriterion("si_latitude not in", values, "siLatitude");
            return (Criteria) this;
        }

        public Criteria andSiLatitudeBetween(String value1, String value2) {
            addCriterion("si_latitude between", value1, value2, "siLatitude");
            return (Criteria) this;
        }

        public Criteria andSiLatitudeNotBetween(String value1, String value2) {
            addCriterion("si_latitude not between", value1, value2, "siLatitude");
            return (Criteria) this;
        }

        public Criteria andSiAddressIsNull() {
            addCriterion("si_address is null");
            return (Criteria) this;
        }

        public Criteria andSiAddressIsNotNull() {
            addCriterion("si_address is not null");
            return (Criteria) this;
        }

        public Criteria andSiAddressEqualTo(String value) {
            addCriterion("si_address =", value, "siAddress");
            return (Criteria) this;
        }

        public Criteria andSiAddressNotEqualTo(String value) {
            addCriterion("si_address <>", value, "siAddress");
            return (Criteria) this;
        }

        public Criteria andSiAddressGreaterThan(String value) {
            addCriterion("si_address >", value, "siAddress");
            return (Criteria) this;
        }

        public Criteria andSiAddressGreaterThanOrEqualTo(String value) {
            addCriterion("si_address >=", value, "siAddress");
            return (Criteria) this;
        }

        public Criteria andSiAddressLessThan(String value) {
            addCriterion("si_address <", value, "siAddress");
            return (Criteria) this;
        }

        public Criteria andSiAddressLessThanOrEqualTo(String value) {
            addCriterion("si_address <=", value, "siAddress");
            return (Criteria) this;
        }

        public Criteria andSiAddressLike(String value) {
            addCriterion("si_address like", value, "siAddress");
            return (Criteria) this;
        }

        public Criteria andSiAddressNotLike(String value) {
            addCriterion("si_address not like", value, "siAddress");
            return (Criteria) this;
        }

        public Criteria andSiAddressIn(List<String> values) {
            addCriterion("si_address in", values, "siAddress");
            return (Criteria) this;
        }

        public Criteria andSiAddressNotIn(List<String> values) {
            addCriterion("si_address not in", values, "siAddress");
            return (Criteria) this;
        }

        public Criteria andSiAddressBetween(String value1, String value2) {
            addCriterion("si_address between", value1, value2, "siAddress");
            return (Criteria) this;
        }

        public Criteria andSiAddressNotBetween(String value1, String value2) {
            addCriterion("si_address not between", value1, value2, "siAddress");
            return (Criteria) this;
        }

        public Criteria andSiCompleteAddressIsNull() {
            addCriterion("si_complete_address is null");
            return (Criteria) this;
        }

        public Criteria andSiCompleteAddressIsNotNull() {
            addCriterion("si_complete_address is not null");
            return (Criteria) this;
        }

        public Criteria andSiCompleteAddressEqualTo(String value) {
            addCriterion("si_complete_address =", value, "siCompleteAddress");
            return (Criteria) this;
        }

        public Criteria andSiCompleteAddressNotEqualTo(String value) {
            addCriterion("si_complete_address <>", value, "siCompleteAddress");
            return (Criteria) this;
        }

        public Criteria andSiCompleteAddressGreaterThan(String value) {
            addCriterion("si_complete_address >", value, "siCompleteAddress");
            return (Criteria) this;
        }

        public Criteria andSiCompleteAddressGreaterThanOrEqualTo(String value) {
            addCriterion("si_complete_address >=", value, "siCompleteAddress");
            return (Criteria) this;
        }

        public Criteria andSiCompleteAddressLessThan(String value) {
            addCriterion("si_complete_address <", value, "siCompleteAddress");
            return (Criteria) this;
        }

        public Criteria andSiCompleteAddressLessThanOrEqualTo(String value) {
            addCriterion("si_complete_address <=", value, "siCompleteAddress");
            return (Criteria) this;
        }

        public Criteria andSiCompleteAddressLike(String value) {
            addCriterion("si_complete_address like", value, "siCompleteAddress");
            return (Criteria) this;
        }

        public Criteria andSiCompleteAddressNotLike(String value) {
            addCriterion("si_complete_address not like", value, "siCompleteAddress");
            return (Criteria) this;
        }

        public Criteria andSiCompleteAddressIn(List<String> values) {
            addCriterion("si_complete_address in", values, "siCompleteAddress");
            return (Criteria) this;
        }

        public Criteria andSiCompleteAddressNotIn(List<String> values) {
            addCriterion("si_complete_address not in", values, "siCompleteAddress");
            return (Criteria) this;
        }

        public Criteria andSiCompleteAddressBetween(String value1, String value2) {
            addCriterion("si_complete_address between", value1, value2, "siCompleteAddress");
            return (Criteria) this;
        }

        public Criteria andSiCompleteAddressNotBetween(String value1, String value2) {
            addCriterion("si_complete_address not between", value1, value2, "siCompleteAddress");
            return (Criteria) this;
        }

        public Criteria andSiMeetIsNull() {
            addCriterion("si_meet is null");
            return (Criteria) this;
        }

        public Criteria andSiMeetIsNotNull() {
            addCriterion("si_meet is not null");
            return (Criteria) this;
        }

        public Criteria andSiMeetEqualTo(String value) {
            addCriterion("si_meet =", value, "siMeet");
            return (Criteria) this;
        }

        public Criteria andSiMeetNotEqualTo(String value) {
            addCriterion("si_meet <>", value, "siMeet");
            return (Criteria) this;
        }

        public Criteria andSiMeetGreaterThan(String value) {
            addCriterion("si_meet >", value, "siMeet");
            return (Criteria) this;
        }

        public Criteria andSiMeetGreaterThanOrEqualTo(String value) {
            addCriterion("si_meet >=", value, "siMeet");
            return (Criteria) this;
        }

        public Criteria andSiMeetLessThan(String value) {
            addCriterion("si_meet <", value, "siMeet");
            return (Criteria) this;
        }

        public Criteria andSiMeetLessThanOrEqualTo(String value) {
            addCriterion("si_meet <=", value, "siMeet");
            return (Criteria) this;
        }

        public Criteria andSiMeetLike(String value) {
            addCriterion("si_meet like", value, "siMeet");
            return (Criteria) this;
        }

        public Criteria andSiMeetNotLike(String value) {
            addCriterion("si_meet not like", value, "siMeet");
            return (Criteria) this;
        }

        public Criteria andSiMeetIn(List<String> values) {
            addCriterion("si_meet in", values, "siMeet");
            return (Criteria) this;
        }

        public Criteria andSiMeetNotIn(List<String> values) {
            addCriterion("si_meet not in", values, "siMeet");
            return (Criteria) this;
        }

        public Criteria andSiMeetBetween(String value1, String value2) {
            addCriterion("si_meet between", value1, value2, "siMeet");
            return (Criteria) this;
        }

        public Criteria andSiMeetNotBetween(String value1, String value2) {
            addCriterion("si_meet not between", value1, value2, "siMeet");
            return (Criteria) this;
        }

        public Criteria andSiCommentIsNull() {
            addCriterion("si_comment is null");
            return (Criteria) this;
        }

        public Criteria andSiCommentIsNotNull() {
            addCriterion("si_comment is not null");
            return (Criteria) this;
        }

        public Criteria andSiCommentEqualTo(String value) {
            addCriterion("si_comment =", value, "siComment");
            return (Criteria) this;
        }

        public Criteria andSiCommentNotEqualTo(String value) {
            addCriterion("si_comment <>", value, "siComment");
            return (Criteria) this;
        }

        public Criteria andSiCommentGreaterThan(String value) {
            addCriterion("si_comment >", value, "siComment");
            return (Criteria) this;
        }

        public Criteria andSiCommentGreaterThanOrEqualTo(String value) {
            addCriterion("si_comment >=", value, "siComment");
            return (Criteria) this;
        }

        public Criteria andSiCommentLessThan(String value) {
            addCriterion("si_comment <", value, "siComment");
            return (Criteria) this;
        }

        public Criteria andSiCommentLessThanOrEqualTo(String value) {
            addCriterion("si_comment <=", value, "siComment");
            return (Criteria) this;
        }

        public Criteria andSiCommentLike(String value) {
            addCriterion("si_comment like", value, "siComment");
            return (Criteria) this;
        }

        public Criteria andSiCommentNotLike(String value) {
            addCriterion("si_comment not like", value, "siComment");
            return (Criteria) this;
        }

        public Criteria andSiCommentIn(List<String> values) {
            addCriterion("si_comment in", values, "siComment");
            return (Criteria) this;
        }

        public Criteria andSiCommentNotIn(List<String> values) {
            addCriterion("si_comment not in", values, "siComment");
            return (Criteria) this;
        }

        public Criteria andSiCommentBetween(String value1, String value2) {
            addCriterion("si_comment between", value1, value2, "siComment");
            return (Criteria) this;
        }

        public Criteria andSiCommentNotBetween(String value1, String value2) {
            addCriterion("si_comment not between", value1, value2, "siComment");
            return (Criteria) this;
        }

        public Criteria andSiCellphoneIdIsNull() {
            addCriterion("si_cellphone_id is null");
            return (Criteria) this;
        }

        public Criteria andSiCellphoneIdIsNotNull() {
            addCriterion("si_cellphone_id is not null");
            return (Criteria) this;
        }

        public Criteria andSiCellphoneIdEqualTo(String value) {
            addCriterion("si_cellphone_id =", value, "siCellphoneId");
            return (Criteria) this;
        }

        public Criteria andSiCellphoneIdNotEqualTo(String value) {
            addCriterion("si_cellphone_id <>", value, "siCellphoneId");
            return (Criteria) this;
        }

        public Criteria andSiCellphoneIdGreaterThan(String value) {
            addCriterion("si_cellphone_id >", value, "siCellphoneId");
            return (Criteria) this;
        }

        public Criteria andSiCellphoneIdGreaterThanOrEqualTo(String value) {
            addCriterion("si_cellphone_id >=", value, "siCellphoneId");
            return (Criteria) this;
        }

        public Criteria andSiCellphoneIdLessThan(String value) {
            addCriterion("si_cellphone_id <", value, "siCellphoneId");
            return (Criteria) this;
        }

        public Criteria andSiCellphoneIdLessThanOrEqualTo(String value) {
            addCriterion("si_cellphone_id <=", value, "siCellphoneId");
            return (Criteria) this;
        }

        public Criteria andSiCellphoneIdLike(String value) {
            addCriterion("si_cellphone_id like", value, "siCellphoneId");
            return (Criteria) this;
        }

        public Criteria andSiCellphoneIdNotLike(String value) {
            addCriterion("si_cellphone_id not like", value, "siCellphoneId");
            return (Criteria) this;
        }

        public Criteria andSiCellphoneIdIn(List<String> values) {
            addCriterion("si_cellphone_id in", values, "siCellphoneId");
            return (Criteria) this;
        }

        public Criteria andSiCellphoneIdNotIn(List<String> values) {
            addCriterion("si_cellphone_id not in", values, "siCellphoneId");
            return (Criteria) this;
        }

        public Criteria andSiCellphoneIdBetween(String value1, String value2) {
            addCriterion("si_cellphone_id between", value1, value2, "siCellphoneId");
            return (Criteria) this;
        }

        public Criteria andSiCellphoneIdNotBetween(String value1, String value2) {
            addCriterion("si_cellphone_id not between", value1, value2, "siCellphoneId");
            return (Criteria) this;
        }

        public Criteria andSiImage1IsNull() {
            addCriterion("si_image1 is null");
            return (Criteria) this;
        }

        public Criteria andSiImage1IsNotNull() {
            addCriterion("si_image1 is not null");
            return (Criteria) this;
        }

        public Criteria andSiImage1EqualTo(String value) {
            addCriterion("si_image1 =", value, "siImage1");
            return (Criteria) this;
        }

        public Criteria andSiImage1NotEqualTo(String value) {
            addCriterion("si_image1 <>", value, "siImage1");
            return (Criteria) this;
        }

        public Criteria andSiImage1GreaterThan(String value) {
            addCriterion("si_image1 >", value, "siImage1");
            return (Criteria) this;
        }

        public Criteria andSiImage1GreaterThanOrEqualTo(String value) {
            addCriterion("si_image1 >=", value, "siImage1");
            return (Criteria) this;
        }

        public Criteria andSiImage1LessThan(String value) {
            addCriterion("si_image1 <", value, "siImage1");
            return (Criteria) this;
        }

        public Criteria andSiImage1LessThanOrEqualTo(String value) {
            addCriterion("si_image1 <=", value, "siImage1");
            return (Criteria) this;
        }

        public Criteria andSiImage1Like(String value) {
            addCriterion("si_image1 like", value, "siImage1");
            return (Criteria) this;
        }

        public Criteria andSiImage1NotLike(String value) {
            addCriterion("si_image1 not like", value, "siImage1");
            return (Criteria) this;
        }

        public Criteria andSiImage1In(List<String> values) {
            addCriterion("si_image1 in", values, "siImage1");
            return (Criteria) this;
        }

        public Criteria andSiImage1NotIn(List<String> values) {
            addCriterion("si_image1 not in", values, "siImage1");
            return (Criteria) this;
        }

        public Criteria andSiImage1Between(String value1, String value2) {
            addCriterion("si_image1 between", value1, value2, "siImage1");
            return (Criteria) this;
        }

        public Criteria andSiImage1NotBetween(String value1, String value2) {
            addCriterion("si_image1 not between", value1, value2, "siImage1");
            return (Criteria) this;
        }

        public Criteria andSiImage2IsNull() {
            addCriterion("si_image2 is null");
            return (Criteria) this;
        }

        public Criteria andSiImage2IsNotNull() {
            addCriterion("si_image2 is not null");
            return (Criteria) this;
        }

        public Criteria andSiImage2EqualTo(String value) {
            addCriterion("si_image2 =", value, "siImage2");
            return (Criteria) this;
        }

        public Criteria andSiImage2NotEqualTo(String value) {
            addCriterion("si_image2 <>", value, "siImage2");
            return (Criteria) this;
        }

        public Criteria andSiImage2GreaterThan(String value) {
            addCriterion("si_image2 >", value, "siImage2");
            return (Criteria) this;
        }

        public Criteria andSiImage2GreaterThanOrEqualTo(String value) {
            addCriterion("si_image2 >=", value, "siImage2");
            return (Criteria) this;
        }

        public Criteria andSiImage2LessThan(String value) {
            addCriterion("si_image2 <", value, "siImage2");
            return (Criteria) this;
        }

        public Criteria andSiImage2LessThanOrEqualTo(String value) {
            addCriterion("si_image2 <=", value, "siImage2");
            return (Criteria) this;
        }

        public Criteria andSiImage2Like(String value) {
            addCriterion("si_image2 like", value, "siImage2");
            return (Criteria) this;
        }

        public Criteria andSiImage2NotLike(String value) {
            addCriterion("si_image2 not like", value, "siImage2");
            return (Criteria) this;
        }

        public Criteria andSiImage2In(List<String> values) {
            addCriterion("si_image2 in", values, "siImage2");
            return (Criteria) this;
        }

        public Criteria andSiImage2NotIn(List<String> values) {
            addCriterion("si_image2 not in", values, "siImage2");
            return (Criteria) this;
        }

        public Criteria andSiImage2Between(String value1, String value2) {
            addCriterion("si_image2 between", value1, value2, "siImage2");
            return (Criteria) this;
        }

        public Criteria andSiImage2NotBetween(String value1, String value2) {
            addCriterion("si_image2 not between", value1, value2, "siImage2");
            return (Criteria) this;
        }

        public Criteria andSiImage3IsNull() {
            addCriterion("si_image3 is null");
            return (Criteria) this;
        }

        public Criteria andSiImage3IsNotNull() {
            addCriterion("si_image3 is not null");
            return (Criteria) this;
        }

        public Criteria andSiImage3EqualTo(String value) {
            addCriterion("si_image3 =", value, "siImage3");
            return (Criteria) this;
        }

        public Criteria andSiImage3NotEqualTo(String value) {
            addCriterion("si_image3 <>", value, "siImage3");
            return (Criteria) this;
        }

        public Criteria andSiImage3GreaterThan(String value) {
            addCriterion("si_image3 >", value, "siImage3");
            return (Criteria) this;
        }

        public Criteria andSiImage3GreaterThanOrEqualTo(String value) {
            addCriterion("si_image3 >=", value, "siImage3");
            return (Criteria) this;
        }

        public Criteria andSiImage3LessThan(String value) {
            addCriterion("si_image3 <", value, "siImage3");
            return (Criteria) this;
        }

        public Criteria andSiImage3LessThanOrEqualTo(String value) {
            addCriterion("si_image3 <=", value, "siImage3");
            return (Criteria) this;
        }

        public Criteria andSiImage3Like(String value) {
            addCriterion("si_image3 like", value, "siImage3");
            return (Criteria) this;
        }

        public Criteria andSiImage3NotLike(String value) {
            addCriterion("si_image3 not like", value, "siImage3");
            return (Criteria) this;
        }

        public Criteria andSiImage3In(List<String> values) {
            addCriterion("si_image3 in", values, "siImage3");
            return (Criteria) this;
        }

        public Criteria andSiImage3NotIn(List<String> values) {
            addCriterion("si_image3 not in", values, "siImage3");
            return (Criteria) this;
        }

        public Criteria andSiImage3Between(String value1, String value2) {
            addCriterion("si_image3 between", value1, value2, "siImage3");
            return (Criteria) this;
        }

        public Criteria andSiImage3NotBetween(String value1, String value2) {
            addCriterion("si_image3 not between", value1, value2, "siImage3");
            return (Criteria) this;
        }

        public Criteria andSiImage4IsNull() {
            addCriterion("si_image4 is null");
            return (Criteria) this;
        }

        public Criteria andSiImage4IsNotNull() {
            addCriterion("si_image4 is not null");
            return (Criteria) this;
        }

        public Criteria andSiImage4EqualTo(String value) {
            addCriterion("si_image4 =", value, "siImage4");
            return (Criteria) this;
        }

        public Criteria andSiImage4NotEqualTo(String value) {
            addCriterion("si_image4 <>", value, "siImage4");
            return (Criteria) this;
        }

        public Criteria andSiImage4GreaterThan(String value) {
            addCriterion("si_image4 >", value, "siImage4");
            return (Criteria) this;
        }

        public Criteria andSiImage4GreaterThanOrEqualTo(String value) {
            addCriterion("si_image4 >=", value, "siImage4");
            return (Criteria) this;
        }

        public Criteria andSiImage4LessThan(String value) {
            addCriterion("si_image4 <", value, "siImage4");
            return (Criteria) this;
        }

        public Criteria andSiImage4LessThanOrEqualTo(String value) {
            addCriterion("si_image4 <=", value, "siImage4");
            return (Criteria) this;
        }

        public Criteria andSiImage4Like(String value) {
            addCriterion("si_image4 like", value, "siImage4");
            return (Criteria) this;
        }

        public Criteria andSiImage4NotLike(String value) {
            addCriterion("si_image4 not like", value, "siImage4");
            return (Criteria) this;
        }

        public Criteria andSiImage4In(List<String> values) {
            addCriterion("si_image4 in", values, "siImage4");
            return (Criteria) this;
        }

        public Criteria andSiImage4NotIn(List<String> values) {
            addCriterion("si_image4 not in", values, "siImage4");
            return (Criteria) this;
        }

        public Criteria andSiImage4Between(String value1, String value2) {
            addCriterion("si_image4 between", value1, value2, "siImage4");
            return (Criteria) this;
        }

        public Criteria andSiImage4NotBetween(String value1, String value2) {
            addCriterion("si_image4 not between", value1, value2, "siImage4");
            return (Criteria) this;
        }

        public Criteria andSiImage5IsNull() {
            addCriterion("si_image5 is null");
            return (Criteria) this;
        }

        public Criteria andSiImage5IsNotNull() {
            addCriterion("si_image5 is not null");
            return (Criteria) this;
        }

        public Criteria andSiImage5EqualTo(String value) {
            addCriterion("si_image5 =", value, "siImage5");
            return (Criteria) this;
        }

        public Criteria andSiImage5NotEqualTo(String value) {
            addCriterion("si_image5 <>", value, "siImage5");
            return (Criteria) this;
        }

        public Criteria andSiImage5GreaterThan(String value) {
            addCriterion("si_image5 >", value, "siImage5");
            return (Criteria) this;
        }

        public Criteria andSiImage5GreaterThanOrEqualTo(String value) {
            addCriterion("si_image5 >=", value, "siImage5");
            return (Criteria) this;
        }

        public Criteria andSiImage5LessThan(String value) {
            addCriterion("si_image5 <", value, "siImage5");
            return (Criteria) this;
        }

        public Criteria andSiImage5LessThanOrEqualTo(String value) {
            addCriterion("si_image5 <=", value, "siImage5");
            return (Criteria) this;
        }

        public Criteria andSiImage5Like(String value) {
            addCriterion("si_image5 like", value, "siImage5");
            return (Criteria) this;
        }

        public Criteria andSiImage5NotLike(String value) {
            addCriterion("si_image5 not like", value, "siImage5");
            return (Criteria) this;
        }

        public Criteria andSiImage5In(List<String> values) {
            addCriterion("si_image5 in", values, "siImage5");
            return (Criteria) this;
        }

        public Criteria andSiImage5NotIn(List<String> values) {
            addCriterion("si_image5 not in", values, "siImage5");
            return (Criteria) this;
        }

        public Criteria andSiImage5Between(String value1, String value2) {
            addCriterion("si_image5 between", value1, value2, "siImage5");
            return (Criteria) this;
        }

        public Criteria andSiImage5NotBetween(String value1, String value2) {
            addCriterion("si_image5 not between", value1, value2, "siImage5");
            return (Criteria) this;
        }

        public Criteria andSiImage6IsNull() {
            addCriterion("si_image6 is null");
            return (Criteria) this;
        }

        public Criteria andSiImage6IsNotNull() {
            addCriterion("si_image6 is not null");
            return (Criteria) this;
        }

        public Criteria andSiImage6EqualTo(String value) {
            addCriterion("si_image6 =", value, "siImage6");
            return (Criteria) this;
        }

        public Criteria andSiImage6NotEqualTo(String value) {
            addCriterion("si_image6 <>", value, "siImage6");
            return (Criteria) this;
        }

        public Criteria andSiImage6GreaterThan(String value) {
            addCriterion("si_image6 >", value, "siImage6");
            return (Criteria) this;
        }

        public Criteria andSiImage6GreaterThanOrEqualTo(String value) {
            addCriterion("si_image6 >=", value, "siImage6");
            return (Criteria) this;
        }

        public Criteria andSiImage6LessThan(String value) {
            addCriterion("si_image6 <", value, "siImage6");
            return (Criteria) this;
        }

        public Criteria andSiImage6LessThanOrEqualTo(String value) {
            addCriterion("si_image6 <=", value, "siImage6");
            return (Criteria) this;
        }

        public Criteria andSiImage6Like(String value) {
            addCriterion("si_image6 like", value, "siImage6");
            return (Criteria) this;
        }

        public Criteria andSiImage6NotLike(String value) {
            addCriterion("si_image6 not like", value, "siImage6");
            return (Criteria) this;
        }

        public Criteria andSiImage6In(List<String> values) {
            addCriterion("si_image6 in", values, "siImage6");
            return (Criteria) this;
        }

        public Criteria andSiImage6NotIn(List<String> values) {
            addCriterion("si_image6 not in", values, "siImage6");
            return (Criteria) this;
        }

        public Criteria andSiImage6Between(String value1, String value2) {
            addCriterion("si_image6 between", value1, value2, "siImage6");
            return (Criteria) this;
        }

        public Criteria andSiImage6NotBetween(String value1, String value2) {
            addCriterion("si_image6 not between", value1, value2, "siImage6");
            return (Criteria) this;
        }

        public Criteria andSiImage7IsNull() {
            addCriterion("si_image7 is null");
            return (Criteria) this;
        }

        public Criteria andSiImage7IsNotNull() {
            addCriterion("si_image7 is not null");
            return (Criteria) this;
        }

        public Criteria andSiImage7EqualTo(String value) {
            addCriterion("si_image7 =", value, "siImage7");
            return (Criteria) this;
        }

        public Criteria andSiImage7NotEqualTo(String value) {
            addCriterion("si_image7 <>", value, "siImage7");
            return (Criteria) this;
        }

        public Criteria andSiImage7GreaterThan(String value) {
            addCriterion("si_image7 >", value, "siImage7");
            return (Criteria) this;
        }

        public Criteria andSiImage7GreaterThanOrEqualTo(String value) {
            addCriterion("si_image7 >=", value, "siImage7");
            return (Criteria) this;
        }

        public Criteria andSiImage7LessThan(String value) {
            addCriterion("si_image7 <", value, "siImage7");
            return (Criteria) this;
        }

        public Criteria andSiImage7LessThanOrEqualTo(String value) {
            addCriterion("si_image7 <=", value, "siImage7");
            return (Criteria) this;
        }

        public Criteria andSiImage7Like(String value) {
            addCriterion("si_image7 like", value, "siImage7");
            return (Criteria) this;
        }

        public Criteria andSiImage7NotLike(String value) {
            addCriterion("si_image7 not like", value, "siImage7");
            return (Criteria) this;
        }

        public Criteria andSiImage7In(List<String> values) {
            addCriterion("si_image7 in", values, "siImage7");
            return (Criteria) this;
        }

        public Criteria andSiImage7NotIn(List<String> values) {
            addCriterion("si_image7 not in", values, "siImage7");
            return (Criteria) this;
        }

        public Criteria andSiImage7Between(String value1, String value2) {
            addCriterion("si_image7 between", value1, value2, "siImage7");
            return (Criteria) this;
        }

        public Criteria andSiImage7NotBetween(String value1, String value2) {
            addCriterion("si_image7 not between", value1, value2, "siImage7");
            return (Criteria) this;
        }

        public Criteria andSiImage8IsNull() {
            addCriterion("si_image8 is null");
            return (Criteria) this;
        }

        public Criteria andSiImage8IsNotNull() {
            addCriterion("si_image8 is not null");
            return (Criteria) this;
        }

        public Criteria andSiImage8EqualTo(String value) {
            addCriterion("si_image8 =", value, "siImage8");
            return (Criteria) this;
        }

        public Criteria andSiImage8NotEqualTo(String value) {
            addCriterion("si_image8 <>", value, "siImage8");
            return (Criteria) this;
        }

        public Criteria andSiImage8GreaterThan(String value) {
            addCriterion("si_image8 >", value, "siImage8");
            return (Criteria) this;
        }

        public Criteria andSiImage8GreaterThanOrEqualTo(String value) {
            addCriterion("si_image8 >=", value, "siImage8");
            return (Criteria) this;
        }

        public Criteria andSiImage8LessThan(String value) {
            addCriterion("si_image8 <", value, "siImage8");
            return (Criteria) this;
        }

        public Criteria andSiImage8LessThanOrEqualTo(String value) {
            addCriterion("si_image8 <=", value, "siImage8");
            return (Criteria) this;
        }

        public Criteria andSiImage8Like(String value) {
            addCriterion("si_image8 like", value, "siImage8");
            return (Criteria) this;
        }

        public Criteria andSiImage8NotLike(String value) {
            addCriterion("si_image8 not like", value, "siImage8");
            return (Criteria) this;
        }

        public Criteria andSiImage8In(List<String> values) {
            addCriterion("si_image8 in", values, "siImage8");
            return (Criteria) this;
        }

        public Criteria andSiImage8NotIn(List<String> values) {
            addCriterion("si_image8 not in", values, "siImage8");
            return (Criteria) this;
        }

        public Criteria andSiImage8Between(String value1, String value2) {
            addCriterion("si_image8 between", value1, value2, "siImage8");
            return (Criteria) this;
        }

        public Criteria andSiImage8NotBetween(String value1, String value2) {
            addCriterion("si_image8 not between", value1, value2, "siImage8");
            return (Criteria) this;
        }

        public Criteria andSiImage9IsNull() {
            addCriterion("si_image9 is null");
            return (Criteria) this;
        }

        public Criteria andSiImage9IsNotNull() {
            addCriterion("si_image9 is not null");
            return (Criteria) this;
        }

        public Criteria andSiImage9EqualTo(String value) {
            addCriterion("si_image9 =", value, "siImage9");
            return (Criteria) this;
        }

        public Criteria andSiImage9NotEqualTo(String value) {
            addCriterion("si_image9 <>", value, "siImage9");
            return (Criteria) this;
        }

        public Criteria andSiImage9GreaterThan(String value) {
            addCriterion("si_image9 >", value, "siImage9");
            return (Criteria) this;
        }

        public Criteria andSiImage9GreaterThanOrEqualTo(String value) {
            addCriterion("si_image9 >=", value, "siImage9");
            return (Criteria) this;
        }

        public Criteria andSiImage9LessThan(String value) {
            addCriterion("si_image9 <", value, "siImage9");
            return (Criteria) this;
        }

        public Criteria andSiImage9LessThanOrEqualTo(String value) {
            addCriterion("si_image9 <=", value, "siImage9");
            return (Criteria) this;
        }

        public Criteria andSiImage9Like(String value) {
            addCriterion("si_image9 like", value, "siImage9");
            return (Criteria) this;
        }

        public Criteria andSiImage9NotLike(String value) {
            addCriterion("si_image9 not like", value, "siImage9");
            return (Criteria) this;
        }

        public Criteria andSiImage9In(List<String> values) {
            addCriterion("si_image9 in", values, "siImage9");
            return (Criteria) this;
        }

        public Criteria andSiImage9NotIn(List<String> values) {
            addCriterion("si_image9 not in", values, "siImage9");
            return (Criteria) this;
        }

        public Criteria andSiImage9Between(String value1, String value2) {
            addCriterion("si_image9 between", value1, value2, "siImage9");
            return (Criteria) this;
        }

        public Criteria andSiImage9NotBetween(String value1, String value2) {
            addCriterion("si_image9 not between", value1, value2, "siImage9");
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