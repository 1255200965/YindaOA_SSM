package com.model;

import java.util.ArrayList;
import java.util.List;

public class UserInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserInfoExample() {
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

        public Criteria andSequenceNumIsNull() {
            addCriterion("sequence_num is null");
            return (Criteria) this;
        }

        public Criteria andSequenceNumIsNotNull() {
            addCriterion("sequence_num is not null");
            return (Criteria) this;
        }

        public Criteria andSequenceNumEqualTo(Integer value) {
            addCriterion("sequence_num =", value, "sequenceNum");
            return (Criteria) this;
        }

        public Criteria andSequenceNumNotEqualTo(Integer value) {
            addCriterion("sequence_num <>", value, "sequenceNum");
            return (Criteria) this;
        }

        public Criteria andSequenceNumGreaterThan(Integer value) {
            addCriterion("sequence_num >", value, "sequenceNum");
            return (Criteria) this;
        }

        public Criteria andSequenceNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("sequence_num >=", value, "sequenceNum");
            return (Criteria) this;
        }

        public Criteria andSequenceNumLessThan(Integer value) {
            addCriterion("sequence_num <", value, "sequenceNum");
            return (Criteria) this;
        }

        public Criteria andSequenceNumLessThanOrEqualTo(Integer value) {
            addCriterion("sequence_num <=", value, "sequenceNum");
            return (Criteria) this;
        }

        public Criteria andSequenceNumIn(List<Integer> values) {
            addCriterion("sequence_num in", values, "sequenceNum");
            return (Criteria) this;
        }

        public Criteria andSequenceNumNotIn(List<Integer> values) {
            addCriterion("sequence_num not in", values, "sequenceNum");
            return (Criteria) this;
        }

        public Criteria andSequenceNumBetween(Integer value1, Integer value2) {
            addCriterion("sequence_num between", value1, value2, "sequenceNum");
            return (Criteria) this;
        }

        public Criteria andSequenceNumNotBetween(Integer value1, Integer value2) {
            addCriterion("sequence_num not between", value1, value2, "sequenceNum");
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

        public Criteria andAgeIsNull() {
            addCriterion("age is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("age is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(Integer value) {
            addCriterion("age =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(Integer value) {
            addCriterion("age <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(Integer value) {
            addCriterion("age >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("age >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(Integer value) {
            addCriterion("age <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(Integer value) {
            addCriterion("age <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<Integer> values) {
            addCriterion("age in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<Integer> values) {
            addCriterion("age not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(Integer value1, Integer value2) {
            addCriterion("age between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("age not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andHouseholdIsNull() {
            addCriterion("household is null");
            return (Criteria) this;
        }

        public Criteria andHouseholdIsNotNull() {
            addCriterion("household is not null");
            return (Criteria) this;
        }

        public Criteria andHouseholdEqualTo(String value) {
            addCriterion("household =", value, "household");
            return (Criteria) this;
        }

        public Criteria andHouseholdNotEqualTo(String value) {
            addCriterion("household <>", value, "household");
            return (Criteria) this;
        }

        public Criteria andHouseholdGreaterThan(String value) {
            addCriterion("household >", value, "household");
            return (Criteria) this;
        }

        public Criteria andHouseholdGreaterThanOrEqualTo(String value) {
            addCriterion("household >=", value, "household");
            return (Criteria) this;
        }

        public Criteria andHouseholdLessThan(String value) {
            addCriterion("household <", value, "household");
            return (Criteria) this;
        }

        public Criteria andHouseholdLessThanOrEqualTo(String value) {
            addCriterion("household <=", value, "household");
            return (Criteria) this;
        }

        public Criteria andHouseholdLike(String value) {
            addCriterion("household like", value, "household");
            return (Criteria) this;
        }

        public Criteria andHouseholdNotLike(String value) {
            addCriterion("household not like", value, "household");
            return (Criteria) this;
        }

        public Criteria andHouseholdIn(List<String> values) {
            addCriterion("household in", values, "household");
            return (Criteria) this;
        }

        public Criteria andHouseholdNotIn(List<String> values) {
            addCriterion("household not in", values, "household");
            return (Criteria) this;
        }

        public Criteria andHouseholdBetween(String value1, String value2) {
            addCriterion("household between", value1, value2, "household");
            return (Criteria) this;
        }

        public Criteria andHouseholdNotBetween(String value1, String value2) {
            addCriterion("household not between", value1, value2, "household");
            return (Criteria) this;
        }

        public Criteria andNationIsNull() {
            addCriterion("nation is null");
            return (Criteria) this;
        }

        public Criteria andNationIsNotNull() {
            addCriterion("nation is not null");
            return (Criteria) this;
        }

        public Criteria andNationEqualTo(String value) {
            addCriterion("nation =", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotEqualTo(String value) {
            addCriterion("nation <>", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThan(String value) {
            addCriterion("nation >", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThanOrEqualTo(String value) {
            addCriterion("nation >=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThan(String value) {
            addCriterion("nation <", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThanOrEqualTo(String value) {
            addCriterion("nation <=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLike(String value) {
            addCriterion("nation like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotLike(String value) {
            addCriterion("nation not like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationIn(List<String> values) {
            addCriterion("nation in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotIn(List<String> values) {
            addCriterion("nation not in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationBetween(String value1, String value2) {
            addCriterion("nation between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotBetween(String value1, String value2) {
            addCriterion("nation not between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(String value) {
            addCriterion("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(String value) {
            addCriterion("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(String value) {
            addCriterion("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(String value) {
            addCriterion("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(String value) {
            addCriterion("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLike(String value) {
            addCriterion("birthday like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotLike(String value) {
            addCriterion("birthday not like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<String> values) {
            addCriterion("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<String> values) {
            addCriterion("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(String value1, String value2) {
            addCriterion("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(String value1, String value2) {
            addCriterion("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andGrdtSchoolIsNull() {
            addCriterion("grdt_school is null");
            return (Criteria) this;
        }

        public Criteria andGrdtSchoolIsNotNull() {
            addCriterion("grdt_school is not null");
            return (Criteria) this;
        }

        public Criteria andGrdtSchoolEqualTo(String value) {
            addCriterion("grdt_school =", value, "grdtSchool");
            return (Criteria) this;
        }

        public Criteria andGrdtSchoolNotEqualTo(String value) {
            addCriterion("grdt_school <>", value, "grdtSchool");
            return (Criteria) this;
        }

        public Criteria andGrdtSchoolGreaterThan(String value) {
            addCriterion("grdt_school >", value, "grdtSchool");
            return (Criteria) this;
        }

        public Criteria andGrdtSchoolGreaterThanOrEqualTo(String value) {
            addCriterion("grdt_school >=", value, "grdtSchool");
            return (Criteria) this;
        }

        public Criteria andGrdtSchoolLessThan(String value) {
            addCriterion("grdt_school <", value, "grdtSchool");
            return (Criteria) this;
        }

        public Criteria andGrdtSchoolLessThanOrEqualTo(String value) {
            addCriterion("grdt_school <=", value, "grdtSchool");
            return (Criteria) this;
        }

        public Criteria andGrdtSchoolLike(String value) {
            addCriterion("grdt_school like", value, "grdtSchool");
            return (Criteria) this;
        }

        public Criteria andGrdtSchoolNotLike(String value) {
            addCriterion("grdt_school not like", value, "grdtSchool");
            return (Criteria) this;
        }

        public Criteria andGrdtSchoolIn(List<String> values) {
            addCriterion("grdt_school in", values, "grdtSchool");
            return (Criteria) this;
        }

        public Criteria andGrdtSchoolNotIn(List<String> values) {
            addCriterion("grdt_school not in", values, "grdtSchool");
            return (Criteria) this;
        }

        public Criteria andGrdtSchoolBetween(String value1, String value2) {
            addCriterion("grdt_school between", value1, value2, "grdtSchool");
            return (Criteria) this;
        }

        public Criteria andGrdtSchoolNotBetween(String value1, String value2) {
            addCriterion("grdt_school not between", value1, value2, "grdtSchool");
            return (Criteria) this;
        }

        public Criteria andSchRecordIsNull() {
            addCriterion("sch_record is null");
            return (Criteria) this;
        }

        public Criteria andSchRecordIsNotNull() {
            addCriterion("sch_record is not null");
            return (Criteria) this;
        }

        public Criteria andSchRecordEqualTo(String value) {
            addCriterion("sch_record =", value, "schRecord");
            return (Criteria) this;
        }

        public Criteria andSchRecordNotEqualTo(String value) {
            addCriterion("sch_record <>", value, "schRecord");
            return (Criteria) this;
        }

        public Criteria andSchRecordGreaterThan(String value) {
            addCriterion("sch_record >", value, "schRecord");
            return (Criteria) this;
        }

        public Criteria andSchRecordGreaterThanOrEqualTo(String value) {
            addCriterion("sch_record >=", value, "schRecord");
            return (Criteria) this;
        }

        public Criteria andSchRecordLessThan(String value) {
            addCriterion("sch_record <", value, "schRecord");
            return (Criteria) this;
        }

        public Criteria andSchRecordLessThanOrEqualTo(String value) {
            addCriterion("sch_record <=", value, "schRecord");
            return (Criteria) this;
        }

        public Criteria andSchRecordLike(String value) {
            addCriterion("sch_record like", value, "schRecord");
            return (Criteria) this;
        }

        public Criteria andSchRecordNotLike(String value) {
            addCriterion("sch_record not like", value, "schRecord");
            return (Criteria) this;
        }

        public Criteria andSchRecordIn(List<String> values) {
            addCriterion("sch_record in", values, "schRecord");
            return (Criteria) this;
        }

        public Criteria andSchRecordNotIn(List<String> values) {
            addCriterion("sch_record not in", values, "schRecord");
            return (Criteria) this;
        }

        public Criteria andSchRecordBetween(String value1, String value2) {
            addCriterion("sch_record between", value1, value2, "schRecord");
            return (Criteria) this;
        }

        public Criteria andSchRecordNotBetween(String value1, String value2) {
            addCriterion("sch_record not between", value1, value2, "schRecord");
            return (Criteria) this;
        }

        public Criteria andGrdtDateIsNull() {
            addCriterion("grdt_date is null");
            return (Criteria) this;
        }

        public Criteria andGrdtDateIsNotNull() {
            addCriterion("grdt_date is not null");
            return (Criteria) this;
        }

        public Criteria andGrdtDateEqualTo(String value) {
            addCriterion("grdt_date =", value, "grdtDate");
            return (Criteria) this;
        }

        public Criteria andGrdtDateNotEqualTo(String value) {
            addCriterion("grdt_date <>", value, "grdtDate");
            return (Criteria) this;
        }

        public Criteria andGrdtDateGreaterThan(String value) {
            addCriterion("grdt_date >", value, "grdtDate");
            return (Criteria) this;
        }

        public Criteria andGrdtDateGreaterThanOrEqualTo(String value) {
            addCriterion("grdt_date >=", value, "grdtDate");
            return (Criteria) this;
        }

        public Criteria andGrdtDateLessThan(String value) {
            addCriterion("grdt_date <", value, "grdtDate");
            return (Criteria) this;
        }

        public Criteria andGrdtDateLessThanOrEqualTo(String value) {
            addCriterion("grdt_date <=", value, "grdtDate");
            return (Criteria) this;
        }

        public Criteria andGrdtDateLike(String value) {
            addCriterion("grdt_date like", value, "grdtDate");
            return (Criteria) this;
        }

        public Criteria andGrdtDateNotLike(String value) {
            addCriterion("grdt_date not like", value, "grdtDate");
            return (Criteria) this;
        }

        public Criteria andGrdtDateIn(List<String> values) {
            addCriterion("grdt_date in", values, "grdtDate");
            return (Criteria) this;
        }

        public Criteria andGrdtDateNotIn(List<String> values) {
            addCriterion("grdt_date not in", values, "grdtDate");
            return (Criteria) this;
        }

        public Criteria andGrdtDateBetween(String value1, String value2) {
            addCriterion("grdt_date between", value1, value2, "grdtDate");
            return (Criteria) this;
        }

        public Criteria andGrdtDateNotBetween(String value1, String value2) {
            addCriterion("grdt_date not between", value1, value2, "grdtDate");
            return (Criteria) this;
        }

        public Criteria andIdcardIsNull() {
            addCriterion("idcard is null");
            return (Criteria) this;
        }

        public Criteria andIdcardIsNotNull() {
            addCriterion("idcard is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardEqualTo(String value) {
            addCriterion("idcard =", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotEqualTo(String value) {
            addCriterion("idcard <>", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardGreaterThan(String value) {
            addCriterion("idcard >", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardGreaterThanOrEqualTo(String value) {
            addCriterion("idcard >=", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLessThan(String value) {
            addCriterion("idcard <", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLessThanOrEqualTo(String value) {
            addCriterion("idcard <=", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLike(String value) {
            addCriterion("idcard like", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotLike(String value) {
            addCriterion("idcard not like", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardIn(List<String> values) {
            addCriterion("idcard in", values, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotIn(List<String> values) {
            addCriterion("idcard not in", values, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardBetween(String value1, String value2) {
            addCriterion("idcard between", value1, value2, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotBetween(String value1, String value2) {
            addCriterion("idcard not between", value1, value2, "idcard");
            return (Criteria) this;
        }

        public Criteria andCellphoneIsNull() {
            addCriterion("cellphone is null");
            return (Criteria) this;
        }

        public Criteria andCellphoneIsNotNull() {
            addCriterion("cellphone is not null");
            return (Criteria) this;
        }

        public Criteria andCellphoneEqualTo(String value) {
            addCriterion("cellphone =", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneNotEqualTo(String value) {
            addCriterion("cellphone <>", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneGreaterThan(String value) {
            addCriterion("cellphone >", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneGreaterThanOrEqualTo(String value) {
            addCriterion("cellphone >=", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneLessThan(String value) {
            addCriterion("cellphone <", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneLessThanOrEqualTo(String value) {
            addCriterion("cellphone <=", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneLike(String value) {
            addCriterion("cellphone like", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneNotLike(String value) {
            addCriterion("cellphone not like", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneIn(List<String> values) {
            addCriterion("cellphone in", values, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneNotIn(List<String> values) {
            addCriterion("cellphone not in", values, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneBetween(String value1, String value2) {
            addCriterion("cellphone between", value1, value2, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneNotBetween(String value1, String value2) {
            addCriterion("cellphone not between", value1, value2, "cellphone");
            return (Criteria) this;
        }

        public Criteria andMailIsNull() {
            addCriterion("mail is null");
            return (Criteria) this;
        }

        public Criteria andMailIsNotNull() {
            addCriterion("mail is not null");
            return (Criteria) this;
        }

        public Criteria andMailEqualTo(String value) {
            addCriterion("mail =", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotEqualTo(String value) {
            addCriterion("mail <>", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailGreaterThan(String value) {
            addCriterion("mail >", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailGreaterThanOrEqualTo(String value) {
            addCriterion("mail >=", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailLessThan(String value) {
            addCriterion("mail <", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailLessThanOrEqualTo(String value) {
            addCriterion("mail <=", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailLike(String value) {
            addCriterion("mail like", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotLike(String value) {
            addCriterion("mail not like", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailIn(List<String> values) {
            addCriterion("mail in", values, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotIn(List<String> values) {
            addCriterion("mail not in", values, "mail");
            return (Criteria) this;
        }

        public Criteria andMailBetween(String value1, String value2) {
            addCriterion("mail between", value1, value2, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotBetween(String value1, String value2) {
            addCriterion("mail not between", value1, value2, "mail");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andBrnCompanyIsNull() {
            addCriterion("brn_company is null");
            return (Criteria) this;
        }

        public Criteria andBrnCompanyIsNotNull() {
            addCriterion("brn_company is not null");
            return (Criteria) this;
        }

        public Criteria andBrnCompanyEqualTo(String value) {
            addCriterion("brn_company =", value, "brnCompany");
            return (Criteria) this;
        }

        public Criteria andBrnCompanyNotEqualTo(String value) {
            addCriterion("brn_company <>", value, "brnCompany");
            return (Criteria) this;
        }

        public Criteria andBrnCompanyGreaterThan(String value) {
            addCriterion("brn_company >", value, "brnCompany");
            return (Criteria) this;
        }

        public Criteria andBrnCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("brn_company >=", value, "brnCompany");
            return (Criteria) this;
        }

        public Criteria andBrnCompanyLessThan(String value) {
            addCriterion("brn_company <", value, "brnCompany");
            return (Criteria) this;
        }

        public Criteria andBrnCompanyLessThanOrEqualTo(String value) {
            addCriterion("brn_company <=", value, "brnCompany");
            return (Criteria) this;
        }

        public Criteria andBrnCompanyLike(String value) {
            addCriterion("brn_company like", value, "brnCompany");
            return (Criteria) this;
        }

        public Criteria andBrnCompanyNotLike(String value) {
            addCriterion("brn_company not like", value, "brnCompany");
            return (Criteria) this;
        }

        public Criteria andBrnCompanyIn(List<String> values) {
            addCriterion("brn_company in", values, "brnCompany");
            return (Criteria) this;
        }

        public Criteria andBrnCompanyNotIn(List<String> values) {
            addCriterion("brn_company not in", values, "brnCompany");
            return (Criteria) this;
        }

        public Criteria andBrnCompanyBetween(String value1, String value2) {
            addCriterion("brn_company between", value1, value2, "brnCompany");
            return (Criteria) this;
        }

        public Criteria andBrnCompanyNotBetween(String value1, String value2) {
            addCriterion("brn_company not between", value1, value2, "brnCompany");
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

        public Criteria andJoinDateIsNull() {
            addCriterion("join_date is null");
            return (Criteria) this;
        }

        public Criteria andJoinDateIsNotNull() {
            addCriterion("join_date is not null");
            return (Criteria) this;
        }

        public Criteria andJoinDateEqualTo(String value) {
            addCriterion("join_date =", value, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateNotEqualTo(String value) {
            addCriterion("join_date <>", value, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateGreaterThan(String value) {
            addCriterion("join_date >", value, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateGreaterThanOrEqualTo(String value) {
            addCriterion("join_date >=", value, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateLessThan(String value) {
            addCriterion("join_date <", value, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateLessThanOrEqualTo(String value) {
            addCriterion("join_date <=", value, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateLike(String value) {
            addCriterion("join_date like", value, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateNotLike(String value) {
            addCriterion("join_date not like", value, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateIn(List<String> values) {
            addCriterion("join_date in", values, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateNotIn(List<String> values) {
            addCriterion("join_date not in", values, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateBetween(String value1, String value2) {
            addCriterion("join_date between", value1, value2, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateNotBetween(String value1, String value2) {
            addCriterion("join_date not between", value1, value2, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinAddrssIsNull() {
            addCriterion("join_addrss is null");
            return (Criteria) this;
        }

        public Criteria andJoinAddrssIsNotNull() {
            addCriterion("join_addrss is not null");
            return (Criteria) this;
        }

        public Criteria andJoinAddrssEqualTo(String value) {
            addCriterion("join_addrss =", value, "joinAddrss");
            return (Criteria) this;
        }

        public Criteria andJoinAddrssNotEqualTo(String value) {
            addCriterion("join_addrss <>", value, "joinAddrss");
            return (Criteria) this;
        }

        public Criteria andJoinAddrssGreaterThan(String value) {
            addCriterion("join_addrss >", value, "joinAddrss");
            return (Criteria) this;
        }

        public Criteria andJoinAddrssGreaterThanOrEqualTo(String value) {
            addCriterion("join_addrss >=", value, "joinAddrss");
            return (Criteria) this;
        }

        public Criteria andJoinAddrssLessThan(String value) {
            addCriterion("join_addrss <", value, "joinAddrss");
            return (Criteria) this;
        }

        public Criteria andJoinAddrssLessThanOrEqualTo(String value) {
            addCriterion("join_addrss <=", value, "joinAddrss");
            return (Criteria) this;
        }

        public Criteria andJoinAddrssLike(String value) {
            addCriterion("join_addrss like", value, "joinAddrss");
            return (Criteria) this;
        }

        public Criteria andJoinAddrssNotLike(String value) {
            addCriterion("join_addrss not like", value, "joinAddrss");
            return (Criteria) this;
        }

        public Criteria andJoinAddrssIn(List<String> values) {
            addCriterion("join_addrss in", values, "joinAddrss");
            return (Criteria) this;
        }

        public Criteria andJoinAddrssNotIn(List<String> values) {
            addCriterion("join_addrss not in", values, "joinAddrss");
            return (Criteria) this;
        }

        public Criteria andJoinAddrssBetween(String value1, String value2) {
            addCriterion("join_addrss between", value1, value2, "joinAddrss");
            return (Criteria) this;
        }

        public Criteria andJoinAddrssNotBetween(String value1, String value2) {
            addCriterion("join_addrss not between", value1, value2, "joinAddrss");
            return (Criteria) this;
        }

        public Criteria andCntrctTypeIsNull() {
            addCriterion("cntrct_type is null");
            return (Criteria) this;
        }

        public Criteria andCntrctTypeIsNotNull() {
            addCriterion("cntrct_type is not null");
            return (Criteria) this;
        }

        public Criteria andCntrctTypeEqualTo(String value) {
            addCriterion("cntrct_type =", value, "cntrctType");
            return (Criteria) this;
        }

        public Criteria andCntrctTypeNotEqualTo(String value) {
            addCriterion("cntrct_type <>", value, "cntrctType");
            return (Criteria) this;
        }

        public Criteria andCntrctTypeGreaterThan(String value) {
            addCriterion("cntrct_type >", value, "cntrctType");
            return (Criteria) this;
        }

        public Criteria andCntrctTypeGreaterThanOrEqualTo(String value) {
            addCriterion("cntrct_type >=", value, "cntrctType");
            return (Criteria) this;
        }

        public Criteria andCntrctTypeLessThan(String value) {
            addCriterion("cntrct_type <", value, "cntrctType");
            return (Criteria) this;
        }

        public Criteria andCntrctTypeLessThanOrEqualTo(String value) {
            addCriterion("cntrct_type <=", value, "cntrctType");
            return (Criteria) this;
        }

        public Criteria andCntrctTypeLike(String value) {
            addCriterion("cntrct_type like", value, "cntrctType");
            return (Criteria) this;
        }

        public Criteria andCntrctTypeNotLike(String value) {
            addCriterion("cntrct_type not like", value, "cntrctType");
            return (Criteria) this;
        }

        public Criteria andCntrctTypeIn(List<String> values) {
            addCriterion("cntrct_type in", values, "cntrctType");
            return (Criteria) this;
        }

        public Criteria andCntrctTypeNotIn(List<String> values) {
            addCriterion("cntrct_type not in", values, "cntrctType");
            return (Criteria) this;
        }

        public Criteria andCntrctTypeBetween(String value1, String value2) {
            addCriterion("cntrct_type between", value1, value2, "cntrctType");
            return (Criteria) this;
        }

        public Criteria andCntrctTypeNotBetween(String value1, String value2) {
            addCriterion("cntrct_type not between", value1, value2, "cntrctType");
            return (Criteria) this;
        }

        public Criteria andCntrctBeginIsNull() {
            addCriterion("cntrct_begin is null");
            return (Criteria) this;
        }

        public Criteria andCntrctBeginIsNotNull() {
            addCriterion("cntrct_begin is not null");
            return (Criteria) this;
        }

        public Criteria andCntrctBeginEqualTo(String value) {
            addCriterion("cntrct_begin =", value, "cntrctBegin");
            return (Criteria) this;
        }

        public Criteria andCntrctBeginNotEqualTo(String value) {
            addCriterion("cntrct_begin <>", value, "cntrctBegin");
            return (Criteria) this;
        }

        public Criteria andCntrctBeginGreaterThan(String value) {
            addCriterion("cntrct_begin >", value, "cntrctBegin");
            return (Criteria) this;
        }

        public Criteria andCntrctBeginGreaterThanOrEqualTo(String value) {
            addCriterion("cntrct_begin >=", value, "cntrctBegin");
            return (Criteria) this;
        }

        public Criteria andCntrctBeginLessThan(String value) {
            addCriterion("cntrct_begin <", value, "cntrctBegin");
            return (Criteria) this;
        }

        public Criteria andCntrctBeginLessThanOrEqualTo(String value) {
            addCriterion("cntrct_begin <=", value, "cntrctBegin");
            return (Criteria) this;
        }

        public Criteria andCntrctBeginLike(String value) {
            addCriterion("cntrct_begin like", value, "cntrctBegin");
            return (Criteria) this;
        }

        public Criteria andCntrctBeginNotLike(String value) {
            addCriterion("cntrct_begin not like", value, "cntrctBegin");
            return (Criteria) this;
        }

        public Criteria andCntrctBeginIn(List<String> values) {
            addCriterion("cntrct_begin in", values, "cntrctBegin");
            return (Criteria) this;
        }

        public Criteria andCntrctBeginNotIn(List<String> values) {
            addCriterion("cntrct_begin not in", values, "cntrctBegin");
            return (Criteria) this;
        }

        public Criteria andCntrctBeginBetween(String value1, String value2) {
            addCriterion("cntrct_begin between", value1, value2, "cntrctBegin");
            return (Criteria) this;
        }

        public Criteria andCntrctBeginNotBetween(String value1, String value2) {
            addCriterion("cntrct_begin not between", value1, value2, "cntrctBegin");
            return (Criteria) this;
        }

        public Criteria andCntrctEndIsNull() {
            addCriterion("cntrct_end is null");
            return (Criteria) this;
        }

        public Criteria andCntrctEndIsNotNull() {
            addCriterion("cntrct_end is not null");
            return (Criteria) this;
        }

        public Criteria andCntrctEndEqualTo(String value) {
            addCriterion("cntrct_end =", value, "cntrctEnd");
            return (Criteria) this;
        }

        public Criteria andCntrctEndNotEqualTo(String value) {
            addCriterion("cntrct_end <>", value, "cntrctEnd");
            return (Criteria) this;
        }

        public Criteria andCntrctEndGreaterThan(String value) {
            addCriterion("cntrct_end >", value, "cntrctEnd");
            return (Criteria) this;
        }

        public Criteria andCntrctEndGreaterThanOrEqualTo(String value) {
            addCriterion("cntrct_end >=", value, "cntrctEnd");
            return (Criteria) this;
        }

        public Criteria andCntrctEndLessThan(String value) {
            addCriterion("cntrct_end <", value, "cntrctEnd");
            return (Criteria) this;
        }

        public Criteria andCntrctEndLessThanOrEqualTo(String value) {
            addCriterion("cntrct_end <=", value, "cntrctEnd");
            return (Criteria) this;
        }

        public Criteria andCntrctEndLike(String value) {
            addCriterion("cntrct_end like", value, "cntrctEnd");
            return (Criteria) this;
        }

        public Criteria andCntrctEndNotLike(String value) {
            addCriterion("cntrct_end not like", value, "cntrctEnd");
            return (Criteria) this;
        }

        public Criteria andCntrctEndIn(List<String> values) {
            addCriterion("cntrct_end in", values, "cntrctEnd");
            return (Criteria) this;
        }

        public Criteria andCntrctEndNotIn(List<String> values) {
            addCriterion("cntrct_end not in", values, "cntrctEnd");
            return (Criteria) this;
        }

        public Criteria andCntrctEndBetween(String value1, String value2) {
            addCriterion("cntrct_end between", value1, value2, "cntrctEnd");
            return (Criteria) this;
        }

        public Criteria andCntrctEndNotBetween(String value1, String value2) {
            addCriterion("cntrct_end not between", value1, value2, "cntrctEnd");
            return (Criteria) this;
        }

        public Criteria andSalaryCardIsNull() {
            addCriterion("salary_card is null");
            return (Criteria) this;
        }

        public Criteria andSalaryCardIsNotNull() {
            addCriterion("salary_card is not null");
            return (Criteria) this;
        }

        public Criteria andSalaryCardEqualTo(String value) {
            addCriterion("salary_card =", value, "salaryCard");
            return (Criteria) this;
        }

        public Criteria andSalaryCardNotEqualTo(String value) {
            addCriterion("salary_card <>", value, "salaryCard");
            return (Criteria) this;
        }

        public Criteria andSalaryCardGreaterThan(String value) {
            addCriterion("salary_card >", value, "salaryCard");
            return (Criteria) this;
        }

        public Criteria andSalaryCardGreaterThanOrEqualTo(String value) {
            addCriterion("salary_card >=", value, "salaryCard");
            return (Criteria) this;
        }

        public Criteria andSalaryCardLessThan(String value) {
            addCriterion("salary_card <", value, "salaryCard");
            return (Criteria) this;
        }

        public Criteria andSalaryCardLessThanOrEqualTo(String value) {
            addCriterion("salary_card <=", value, "salaryCard");
            return (Criteria) this;
        }

        public Criteria andSalaryCardLike(String value) {
            addCriterion("salary_card like", value, "salaryCard");
            return (Criteria) this;
        }

        public Criteria andSalaryCardNotLike(String value) {
            addCriterion("salary_card not like", value, "salaryCard");
            return (Criteria) this;
        }

        public Criteria andSalaryCardIn(List<String> values) {
            addCriterion("salary_card in", values, "salaryCard");
            return (Criteria) this;
        }

        public Criteria andSalaryCardNotIn(List<String> values) {
            addCriterion("salary_card not in", values, "salaryCard");
            return (Criteria) this;
        }

        public Criteria andSalaryCardBetween(String value1, String value2) {
            addCriterion("salary_card between", value1, value2, "salaryCard");
            return (Criteria) this;
        }

        public Criteria andSalaryCardNotBetween(String value1, String value2) {
            addCriterion("salary_card not between", value1, value2, "salaryCard");
            return (Criteria) this;
        }

        public Criteria andExpenseCardIsNull() {
            addCriterion("expense_card is null");
            return (Criteria) this;
        }

        public Criteria andExpenseCardIsNotNull() {
            addCriterion("expense_card is not null");
            return (Criteria) this;
        }

        public Criteria andExpenseCardEqualTo(String value) {
            addCriterion("expense_card =", value, "expenseCard");
            return (Criteria) this;
        }

        public Criteria andExpenseCardNotEqualTo(String value) {
            addCriterion("expense_card <>", value, "expenseCard");
            return (Criteria) this;
        }

        public Criteria andExpenseCardGreaterThan(String value) {
            addCriterion("expense_card >", value, "expenseCard");
            return (Criteria) this;
        }

        public Criteria andExpenseCardGreaterThanOrEqualTo(String value) {
            addCriterion("expense_card >=", value, "expenseCard");
            return (Criteria) this;
        }

        public Criteria andExpenseCardLessThan(String value) {
            addCriterion("expense_card <", value, "expenseCard");
            return (Criteria) this;
        }

        public Criteria andExpenseCardLessThanOrEqualTo(String value) {
            addCriterion("expense_card <=", value, "expenseCard");
            return (Criteria) this;
        }

        public Criteria andExpenseCardLike(String value) {
            addCriterion("expense_card like", value, "expenseCard");
            return (Criteria) this;
        }

        public Criteria andExpenseCardNotLike(String value) {
            addCriterion("expense_card not like", value, "expenseCard");
            return (Criteria) this;
        }

        public Criteria andExpenseCardIn(List<String> values) {
            addCriterion("expense_card in", values, "expenseCard");
            return (Criteria) this;
        }

        public Criteria andExpenseCardNotIn(List<String> values) {
            addCriterion("expense_card not in", values, "expenseCard");
            return (Criteria) this;
        }

        public Criteria andExpenseCardBetween(String value1, String value2) {
            addCriterion("expense_card between", value1, value2, "expenseCard");
            return (Criteria) this;
        }

        public Criteria andExpenseCardNotBetween(String value1, String value2) {
            addCriterion("expense_card not between", value1, value2, "expenseCard");
            return (Criteria) this;
        }

        public Criteria andWtrItemIsNull() {
            addCriterion("wtr_item is null");
            return (Criteria) this;
        }

        public Criteria andWtrItemIsNotNull() {
            addCriterion("wtr_item is not null");
            return (Criteria) this;
        }

        public Criteria andWtrItemEqualTo(String value) {
            addCriterion("wtr_item =", value, "wtrItem");
            return (Criteria) this;
        }

        public Criteria andWtrItemNotEqualTo(String value) {
            addCriterion("wtr_item <>", value, "wtrItem");
            return (Criteria) this;
        }

        public Criteria andWtrItemGreaterThan(String value) {
            addCriterion("wtr_item >", value, "wtrItem");
            return (Criteria) this;
        }

        public Criteria andWtrItemGreaterThanOrEqualTo(String value) {
            addCriterion("wtr_item >=", value, "wtrItem");
            return (Criteria) this;
        }

        public Criteria andWtrItemLessThan(String value) {
            addCriterion("wtr_item <", value, "wtrItem");
            return (Criteria) this;
        }

        public Criteria andWtrItemLessThanOrEqualTo(String value) {
            addCriterion("wtr_item <=", value, "wtrItem");
            return (Criteria) this;
        }

        public Criteria andWtrItemLike(String value) {
            addCriterion("wtr_item like", value, "wtrItem");
            return (Criteria) this;
        }

        public Criteria andWtrItemNotLike(String value) {
            addCriterion("wtr_item not like", value, "wtrItem");
            return (Criteria) this;
        }

        public Criteria andWtrItemIn(List<String> values) {
            addCriterion("wtr_item in", values, "wtrItem");
            return (Criteria) this;
        }

        public Criteria andWtrItemNotIn(List<String> values) {
            addCriterion("wtr_item not in", values, "wtrItem");
            return (Criteria) this;
        }

        public Criteria andWtrItemBetween(String value1, String value2) {
            addCriterion("wtr_item between", value1, value2, "wtrItem");
            return (Criteria) this;
        }

        public Criteria andWtrItemNotBetween(String value1, String value2) {
            addCriterion("wtr_item not between", value1, value2, "wtrItem");
            return (Criteria) this;
        }

        public Criteria andWtrOrderIsNull() {
            addCriterion("wtr_order is null");
            return (Criteria) this;
        }

        public Criteria andWtrOrderIsNotNull() {
            addCriterion("wtr_order is not null");
            return (Criteria) this;
        }

        public Criteria andWtrOrderEqualTo(String value) {
            addCriterion("wtr_order =", value, "wtrOrder");
            return (Criteria) this;
        }

        public Criteria andWtrOrderNotEqualTo(String value) {
            addCriterion("wtr_order <>", value, "wtrOrder");
            return (Criteria) this;
        }

        public Criteria andWtrOrderGreaterThan(String value) {
            addCriterion("wtr_order >", value, "wtrOrder");
            return (Criteria) this;
        }

        public Criteria andWtrOrderGreaterThanOrEqualTo(String value) {
            addCriterion("wtr_order >=", value, "wtrOrder");
            return (Criteria) this;
        }

        public Criteria andWtrOrderLessThan(String value) {
            addCriterion("wtr_order <", value, "wtrOrder");
            return (Criteria) this;
        }

        public Criteria andWtrOrderLessThanOrEqualTo(String value) {
            addCriterion("wtr_order <=", value, "wtrOrder");
            return (Criteria) this;
        }

        public Criteria andWtrOrderLike(String value) {
            addCriterion("wtr_order like", value, "wtrOrder");
            return (Criteria) this;
        }

        public Criteria andWtrOrderNotLike(String value) {
            addCriterion("wtr_order not like", value, "wtrOrder");
            return (Criteria) this;
        }

        public Criteria andWtrOrderIn(List<String> values) {
            addCriterion("wtr_order in", values, "wtrOrder");
            return (Criteria) this;
        }

        public Criteria andWtrOrderNotIn(List<String> values) {
            addCriterion("wtr_order not in", values, "wtrOrder");
            return (Criteria) this;
        }

        public Criteria andWtrOrderBetween(String value1, String value2) {
            addCriterion("wtr_order between", value1, value2, "wtrOrder");
            return (Criteria) this;
        }

        public Criteria andWtrOrderNotBetween(String value1, String value2) {
            addCriterion("wtr_order not between", value1, value2, "wtrOrder");
            return (Criteria) this;
        }

        public Criteria andNetUnitIsNull() {
            addCriterion("net_unit is null");
            return (Criteria) this;
        }

        public Criteria andNetUnitIsNotNull() {
            addCriterion("net_unit is not null");
            return (Criteria) this;
        }

        public Criteria andNetUnitEqualTo(String value) {
            addCriterion("net_unit =", value, "netUnit");
            return (Criteria) this;
        }

        public Criteria andNetUnitNotEqualTo(String value) {
            addCriterion("net_unit <>", value, "netUnit");
            return (Criteria) this;
        }

        public Criteria andNetUnitGreaterThan(String value) {
            addCriterion("net_unit >", value, "netUnit");
            return (Criteria) this;
        }

        public Criteria andNetUnitGreaterThanOrEqualTo(String value) {
            addCriterion("net_unit >=", value, "netUnit");
            return (Criteria) this;
        }

        public Criteria andNetUnitLessThan(String value) {
            addCriterion("net_unit <", value, "netUnit");
            return (Criteria) this;
        }

        public Criteria andNetUnitLessThanOrEqualTo(String value) {
            addCriterion("net_unit <=", value, "netUnit");
            return (Criteria) this;
        }

        public Criteria andNetUnitLike(String value) {
            addCriterion("net_unit like", value, "netUnit");
            return (Criteria) this;
        }

        public Criteria andNetUnitNotLike(String value) {
            addCriterion("net_unit not like", value, "netUnit");
            return (Criteria) this;
        }

        public Criteria andNetUnitIn(List<String> values) {
            addCriterion("net_unit in", values, "netUnit");
            return (Criteria) this;
        }

        public Criteria andNetUnitNotIn(List<String> values) {
            addCriterion("net_unit not in", values, "netUnit");
            return (Criteria) this;
        }

        public Criteria andNetUnitBetween(String value1, String value2) {
            addCriterion("net_unit between", value1, value2, "netUnit");
            return (Criteria) this;
        }

        public Criteria andNetUnitNotBetween(String value1, String value2) {
            addCriterion("net_unit not between", value1, value2, "netUnit");
            return (Criteria) this;
        }

        public Criteria andTechLevelIsNull() {
            addCriterion("tech_level is null");
            return (Criteria) this;
        }

        public Criteria andTechLevelIsNotNull() {
            addCriterion("tech_level is not null");
            return (Criteria) this;
        }

        public Criteria andTechLevelEqualTo(String value) {
            addCriterion("tech_level =", value, "techLevel");
            return (Criteria) this;
        }

        public Criteria andTechLevelNotEqualTo(String value) {
            addCriterion("tech_level <>", value, "techLevel");
            return (Criteria) this;
        }

        public Criteria andTechLevelGreaterThan(String value) {
            addCriterion("tech_level >", value, "techLevel");
            return (Criteria) this;
        }

        public Criteria andTechLevelGreaterThanOrEqualTo(String value) {
            addCriterion("tech_level >=", value, "techLevel");
            return (Criteria) this;
        }

        public Criteria andTechLevelLessThan(String value) {
            addCriterion("tech_level <", value, "techLevel");
            return (Criteria) this;
        }

        public Criteria andTechLevelLessThanOrEqualTo(String value) {
            addCriterion("tech_level <=", value, "techLevel");
            return (Criteria) this;
        }

        public Criteria andTechLevelLike(String value) {
            addCriterion("tech_level like", value, "techLevel");
            return (Criteria) this;
        }

        public Criteria andTechLevelNotLike(String value) {
            addCriterion("tech_level not like", value, "techLevel");
            return (Criteria) this;
        }

        public Criteria andTechLevelIn(List<String> values) {
            addCriterion("tech_level in", values, "techLevel");
            return (Criteria) this;
        }

        public Criteria andTechLevelNotIn(List<String> values) {
            addCriterion("tech_level not in", values, "techLevel");
            return (Criteria) this;
        }

        public Criteria andTechLevelBetween(String value1, String value2) {
            addCriterion("tech_level between", value1, value2, "techLevel");
            return (Criteria) this;
        }

        public Criteria andTechLevelNotBetween(String value1, String value2) {
            addCriterion("tech_level not between", value1, value2, "techLevel");
            return (Criteria) this;
        }

        public Criteria andIdentifyUnitIsNull() {
            addCriterion("identify_unit is null");
            return (Criteria) this;
        }

        public Criteria andIdentifyUnitIsNotNull() {
            addCriterion("identify_unit is not null");
            return (Criteria) this;
        }

        public Criteria andIdentifyUnitEqualTo(String value) {
            addCriterion("identify_unit =", value, "identifyUnit");
            return (Criteria) this;
        }

        public Criteria andIdentifyUnitNotEqualTo(String value) {
            addCriterion("identify_unit <>", value, "identifyUnit");
            return (Criteria) this;
        }

        public Criteria andIdentifyUnitGreaterThan(String value) {
            addCriterion("identify_unit >", value, "identifyUnit");
            return (Criteria) this;
        }

        public Criteria andIdentifyUnitGreaterThanOrEqualTo(String value) {
            addCriterion("identify_unit >=", value, "identifyUnit");
            return (Criteria) this;
        }

        public Criteria andIdentifyUnitLessThan(String value) {
            addCriterion("identify_unit <", value, "identifyUnit");
            return (Criteria) this;
        }

        public Criteria andIdentifyUnitLessThanOrEqualTo(String value) {
            addCriterion("identify_unit <=", value, "identifyUnit");
            return (Criteria) this;
        }

        public Criteria andIdentifyUnitLike(String value) {
            addCriterion("identify_unit like", value, "identifyUnit");
            return (Criteria) this;
        }

        public Criteria andIdentifyUnitNotLike(String value) {
            addCriterion("identify_unit not like", value, "identifyUnit");
            return (Criteria) this;
        }

        public Criteria andIdentifyUnitIn(List<String> values) {
            addCriterion("identify_unit in", values, "identifyUnit");
            return (Criteria) this;
        }

        public Criteria andIdentifyUnitNotIn(List<String> values) {
            addCriterion("identify_unit not in", values, "identifyUnit");
            return (Criteria) this;
        }

        public Criteria andIdentifyUnitBetween(String value1, String value2) {
            addCriterion("identify_unit between", value1, value2, "identifyUnit");
            return (Criteria) this;
        }

        public Criteria andIdentifyUnitNotBetween(String value1, String value2) {
            addCriterion("identify_unit not between", value1, value2, "identifyUnit");
            return (Criteria) this;
        }

        public Criteria andAccntTypeIsNull() {
            addCriterion("accnt_type is null");
            return (Criteria) this;
        }

        public Criteria andAccntTypeIsNotNull() {
            addCriterion("accnt_type is not null");
            return (Criteria) this;
        }

        public Criteria andAccntTypeEqualTo(String value) {
            addCriterion("accnt_type =", value, "accntType");
            return (Criteria) this;
        }

        public Criteria andAccntTypeNotEqualTo(String value) {
            addCriterion("accnt_type <>", value, "accntType");
            return (Criteria) this;
        }

        public Criteria andAccntTypeGreaterThan(String value) {
            addCriterion("accnt_type >", value, "accntType");
            return (Criteria) this;
        }

        public Criteria andAccntTypeGreaterThanOrEqualTo(String value) {
            addCriterion("accnt_type >=", value, "accntType");
            return (Criteria) this;
        }

        public Criteria andAccntTypeLessThan(String value) {
            addCriterion("accnt_type <", value, "accntType");
            return (Criteria) this;
        }

        public Criteria andAccntTypeLessThanOrEqualTo(String value) {
            addCriterion("accnt_type <=", value, "accntType");
            return (Criteria) this;
        }

        public Criteria andAccntTypeLike(String value) {
            addCriterion("accnt_type like", value, "accntType");
            return (Criteria) this;
        }

        public Criteria andAccntTypeNotLike(String value) {
            addCriterion("accnt_type not like", value, "accntType");
            return (Criteria) this;
        }

        public Criteria andAccntTypeIn(List<String> values) {
            addCriterion("accnt_type in", values, "accntType");
            return (Criteria) this;
        }

        public Criteria andAccntTypeNotIn(List<String> values) {
            addCriterion("accnt_type not in", values, "accntType");
            return (Criteria) this;
        }

        public Criteria andAccntTypeBetween(String value1, String value2) {
            addCriterion("accnt_type between", value1, value2, "accntType");
            return (Criteria) this;
        }

        public Criteria andAccntTypeNotBetween(String value1, String value2) {
            addCriterion("accnt_type not between", value1, value2, "accntType");
            return (Criteria) this;
        }

        public Criteria andAccntStateIsNull() {
            addCriterion("accnt_state is null");
            return (Criteria) this;
        }

        public Criteria andAccntStateIsNotNull() {
            addCriterion("accnt_state is not null");
            return (Criteria) this;
        }

        public Criteria andAccntStateEqualTo(String value) {
            addCriterion("accnt_state =", value, "accntState");
            return (Criteria) this;
        }

        public Criteria andAccntStateNotEqualTo(String value) {
            addCriterion("accnt_state <>", value, "accntState");
            return (Criteria) this;
        }

        public Criteria andAccntStateGreaterThan(String value) {
            addCriterion("accnt_state >", value, "accntState");
            return (Criteria) this;
        }

        public Criteria andAccntStateGreaterThanOrEqualTo(String value) {
            addCriterion("accnt_state >=", value, "accntState");
            return (Criteria) this;
        }

        public Criteria andAccntStateLessThan(String value) {
            addCriterion("accnt_state <", value, "accntState");
            return (Criteria) this;
        }

        public Criteria andAccntStateLessThanOrEqualTo(String value) {
            addCriterion("accnt_state <=", value, "accntState");
            return (Criteria) this;
        }

        public Criteria andAccntStateLike(String value) {
            addCriterion("accnt_state like", value, "accntState");
            return (Criteria) this;
        }

        public Criteria andAccntStateNotLike(String value) {
            addCriterion("accnt_state not like", value, "accntState");
            return (Criteria) this;
        }

        public Criteria andAccntStateIn(List<String> values) {
            addCriterion("accnt_state in", values, "accntState");
            return (Criteria) this;
        }

        public Criteria andAccntStateNotIn(List<String> values) {
            addCriterion("accnt_state not in", values, "accntState");
            return (Criteria) this;
        }

        public Criteria andAccntStateBetween(String value1, String value2) {
            addCriterion("accnt_state between", value1, value2, "accntState");
            return (Criteria) this;
        }

        public Criteria andAccntStateNotBetween(String value1, String value2) {
            addCriterion("accnt_state not between", value1, value2, "accntState");
            return (Criteria) this;
        }

        public Criteria andUserStateIsNull() {
            addCriterion("user_state is null");
            return (Criteria) this;
        }

        public Criteria andUserStateIsNotNull() {
            addCriterion("user_state is not null");
            return (Criteria) this;
        }

        public Criteria andUserStateEqualTo(String value) {
            addCriterion("user_state =", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateNotEqualTo(String value) {
            addCriterion("user_state <>", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateGreaterThan(String value) {
            addCriterion("user_state >", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateGreaterThanOrEqualTo(String value) {
            addCriterion("user_state >=", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateLessThan(String value) {
            addCriterion("user_state <", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateLessThanOrEqualTo(String value) {
            addCriterion("user_state <=", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateLike(String value) {
            addCriterion("user_state like", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateNotLike(String value) {
            addCriterion("user_state not like", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateIn(List<String> values) {
            addCriterion("user_state in", values, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateNotIn(List<String> values) {
            addCriterion("user_state not in", values, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateBetween(String value1, String value2) {
            addCriterion("user_state between", value1, value2, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateNotBetween(String value1, String value2) {
            addCriterion("user_state not between", value1, value2, "userState");
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