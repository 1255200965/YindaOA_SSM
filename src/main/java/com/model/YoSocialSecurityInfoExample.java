package com.model;

import java.util.ArrayList;
import java.util.List;

public class YoSocialSecurityInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public YoSocialSecurityInfoExample() {
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

        public Criteria andSsiSequenceNoIsNull() {
            addCriterion("ssi_sequence_no is null");
            return (Criteria) this;
        }

        public Criteria andSsiSequenceNoIsNotNull() {
            addCriterion("ssi_sequence_no is not null");
            return (Criteria) this;
        }

        public Criteria andSsiSequenceNoEqualTo(Integer value) {
            addCriterion("ssi_sequence_no =", value, "ssiSequenceNo");
            return (Criteria) this;
        }

        public Criteria andSsiSequenceNoNotEqualTo(Integer value) {
            addCriterion("ssi_sequence_no <>", value, "ssiSequenceNo");
            return (Criteria) this;
        }

        public Criteria andSsiSequenceNoGreaterThan(Integer value) {
            addCriterion("ssi_sequence_no >", value, "ssiSequenceNo");
            return (Criteria) this;
        }

        public Criteria andSsiSequenceNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("ssi_sequence_no >=", value, "ssiSequenceNo");
            return (Criteria) this;
        }

        public Criteria andSsiSequenceNoLessThan(Integer value) {
            addCriterion("ssi_sequence_no <", value, "ssiSequenceNo");
            return (Criteria) this;
        }

        public Criteria andSsiSequenceNoLessThanOrEqualTo(Integer value) {
            addCriterion("ssi_sequence_no <=", value, "ssiSequenceNo");
            return (Criteria) this;
        }

        public Criteria andSsiSequenceNoIn(List<Integer> values) {
            addCriterion("ssi_sequence_no in", values, "ssiSequenceNo");
            return (Criteria) this;
        }

        public Criteria andSsiSequenceNoNotIn(List<Integer> values) {
            addCriterion("ssi_sequence_no not in", values, "ssiSequenceNo");
            return (Criteria) this;
        }

        public Criteria andSsiSequenceNoBetween(Integer value1, Integer value2) {
            addCriterion("ssi_sequence_no between", value1, value2, "ssiSequenceNo");
            return (Criteria) this;
        }

        public Criteria andSsiSequenceNoNotBetween(Integer value1, Integer value2) {
            addCriterion("ssi_sequence_no not between", value1, value2, "ssiSequenceNo");
            return (Criteria) this;
        }

        public Criteria andSsiBranchCompanyIsNull() {
            addCriterion("ssi_branch_company is null");
            return (Criteria) this;
        }

        public Criteria andSsiBranchCompanyIsNotNull() {
            addCriterion("ssi_branch_company is not null");
            return (Criteria) this;
        }

        public Criteria andSsiBranchCompanyEqualTo(String value) {
            addCriterion("ssi_branch_company =", value, "ssiBranchCompany");
            return (Criteria) this;
        }

        public Criteria andSsiBranchCompanyNotEqualTo(String value) {
            addCriterion("ssi_branch_company <>", value, "ssiBranchCompany");
            return (Criteria) this;
        }

        public Criteria andSsiBranchCompanyGreaterThan(String value) {
            addCriterion("ssi_branch_company >", value, "ssiBranchCompany");
            return (Criteria) this;
        }

        public Criteria andSsiBranchCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("ssi_branch_company >=", value, "ssiBranchCompany");
            return (Criteria) this;
        }

        public Criteria andSsiBranchCompanyLessThan(String value) {
            addCriterion("ssi_branch_company <", value, "ssiBranchCompany");
            return (Criteria) this;
        }

        public Criteria andSsiBranchCompanyLessThanOrEqualTo(String value) {
            addCriterion("ssi_branch_company <=", value, "ssiBranchCompany");
            return (Criteria) this;
        }

        public Criteria andSsiBranchCompanyLike(String value) {
            addCriterion("ssi_branch_company like", value, "ssiBranchCompany");
            return (Criteria) this;
        }

        public Criteria andSsiBranchCompanyNotLike(String value) {
            addCriterion("ssi_branch_company not like", value, "ssiBranchCompany");
            return (Criteria) this;
        }

        public Criteria andSsiBranchCompanyIn(List<String> values) {
            addCriterion("ssi_branch_company in", values, "ssiBranchCompany");
            return (Criteria) this;
        }

        public Criteria andSsiBranchCompanyNotIn(List<String> values) {
            addCriterion("ssi_branch_company not in", values, "ssiBranchCompany");
            return (Criteria) this;
        }

        public Criteria andSsiBranchCompanyBetween(String value1, String value2) {
            addCriterion("ssi_branch_company between", value1, value2, "ssiBranchCompany");
            return (Criteria) this;
        }

        public Criteria andSsiBranchCompanyNotBetween(String value1, String value2) {
            addCriterion("ssi_branch_company not between", value1, value2, "ssiBranchCompany");
            return (Criteria) this;
        }

        public Criteria andSsiStaffIdIsNull() {
            addCriterion("ssi_staff_id is null");
            return (Criteria) this;
        }

        public Criteria andSsiStaffIdIsNotNull() {
            addCriterion("ssi_staff_id is not null");
            return (Criteria) this;
        }

        public Criteria andSsiStaffIdEqualTo(String value) {
            addCriterion("ssi_staff_id =", value, "ssiStaffId");
            return (Criteria) this;
        }

        public Criteria andSsiStaffIdNotEqualTo(String value) {
            addCriterion("ssi_staff_id <>", value, "ssiStaffId");
            return (Criteria) this;
        }

        public Criteria andSsiStaffIdGreaterThan(String value) {
            addCriterion("ssi_staff_id >", value, "ssiStaffId");
            return (Criteria) this;
        }

        public Criteria andSsiStaffIdGreaterThanOrEqualTo(String value) {
            addCriterion("ssi_staff_id >=", value, "ssiStaffId");
            return (Criteria) this;
        }

        public Criteria andSsiStaffIdLessThan(String value) {
            addCriterion("ssi_staff_id <", value, "ssiStaffId");
            return (Criteria) this;
        }

        public Criteria andSsiStaffIdLessThanOrEqualTo(String value) {
            addCriterion("ssi_staff_id <=", value, "ssiStaffId");
            return (Criteria) this;
        }

        public Criteria andSsiStaffIdLike(String value) {
            addCriterion("ssi_staff_id like", value, "ssiStaffId");
            return (Criteria) this;
        }

        public Criteria andSsiStaffIdNotLike(String value) {
            addCriterion("ssi_staff_id not like", value, "ssiStaffId");
            return (Criteria) this;
        }

        public Criteria andSsiStaffIdIn(List<String> values) {
            addCriterion("ssi_staff_id in", values, "ssiStaffId");
            return (Criteria) this;
        }

        public Criteria andSsiStaffIdNotIn(List<String> values) {
            addCriterion("ssi_staff_id not in", values, "ssiStaffId");
            return (Criteria) this;
        }

        public Criteria andSsiStaffIdBetween(String value1, String value2) {
            addCriterion("ssi_staff_id between", value1, value2, "ssiStaffId");
            return (Criteria) this;
        }

        public Criteria andSsiStaffIdNotBetween(String value1, String value2) {
            addCriterion("ssi_staff_id not between", value1, value2, "ssiStaffId");
            return (Criteria) this;
        }

        public Criteria andSsiNameIsNull() {
            addCriterion("ssi_name is null");
            return (Criteria) this;
        }

        public Criteria andSsiNameIsNotNull() {
            addCriterion("ssi_name is not null");
            return (Criteria) this;
        }

        public Criteria andSsiNameEqualTo(String value) {
            addCriterion("ssi_name =", value, "ssiName");
            return (Criteria) this;
        }

        public Criteria andSsiNameNotEqualTo(String value) {
            addCriterion("ssi_name <>", value, "ssiName");
            return (Criteria) this;
        }

        public Criteria andSsiNameGreaterThan(String value) {
            addCriterion("ssi_name >", value, "ssiName");
            return (Criteria) this;
        }

        public Criteria andSsiNameGreaterThanOrEqualTo(String value) {
            addCriterion("ssi_name >=", value, "ssiName");
            return (Criteria) this;
        }

        public Criteria andSsiNameLessThan(String value) {
            addCriterion("ssi_name <", value, "ssiName");
            return (Criteria) this;
        }

        public Criteria andSsiNameLessThanOrEqualTo(String value) {
            addCriterion("ssi_name <=", value, "ssiName");
            return (Criteria) this;
        }

        public Criteria andSsiNameLike(String value) {
            addCriterion("ssi_name like", value, "ssiName");
            return (Criteria) this;
        }

        public Criteria andSsiNameNotLike(String value) {
            addCriterion("ssi_name not like", value, "ssiName");
            return (Criteria) this;
        }

        public Criteria andSsiNameIn(List<String> values) {
            addCriterion("ssi_name in", values, "ssiName");
            return (Criteria) this;
        }

        public Criteria andSsiNameNotIn(List<String> values) {
            addCriterion("ssi_name not in", values, "ssiName");
            return (Criteria) this;
        }

        public Criteria andSsiNameBetween(String value1, String value2) {
            addCriterion("ssi_name between", value1, value2, "ssiName");
            return (Criteria) this;
        }

        public Criteria andSsiNameNotBetween(String value1, String value2) {
            addCriterion("ssi_name not between", value1, value2, "ssiName");
            return (Criteria) this;
        }

        public Criteria andSsiSecurityAddressIsNull() {
            addCriterion("ssi_security_address is null");
            return (Criteria) this;
        }

        public Criteria andSsiSecurityAddressIsNotNull() {
            addCriterion("ssi_security_address is not null");
            return (Criteria) this;
        }

        public Criteria andSsiSecurityAddressEqualTo(String value) {
            addCriterion("ssi_security_address =", value, "ssiSecurityAddress");
            return (Criteria) this;
        }

        public Criteria andSsiSecurityAddressNotEqualTo(String value) {
            addCriterion("ssi_security_address <>", value, "ssiSecurityAddress");
            return (Criteria) this;
        }

        public Criteria andSsiSecurityAddressGreaterThan(String value) {
            addCriterion("ssi_security_address >", value, "ssiSecurityAddress");
            return (Criteria) this;
        }

        public Criteria andSsiSecurityAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ssi_security_address >=", value, "ssiSecurityAddress");
            return (Criteria) this;
        }

        public Criteria andSsiSecurityAddressLessThan(String value) {
            addCriterion("ssi_security_address <", value, "ssiSecurityAddress");
            return (Criteria) this;
        }

        public Criteria andSsiSecurityAddressLessThanOrEqualTo(String value) {
            addCriterion("ssi_security_address <=", value, "ssiSecurityAddress");
            return (Criteria) this;
        }

        public Criteria andSsiSecurityAddressLike(String value) {
            addCriterion("ssi_security_address like", value, "ssiSecurityAddress");
            return (Criteria) this;
        }

        public Criteria andSsiSecurityAddressNotLike(String value) {
            addCriterion("ssi_security_address not like", value, "ssiSecurityAddress");
            return (Criteria) this;
        }

        public Criteria andSsiSecurityAddressIn(List<String> values) {
            addCriterion("ssi_security_address in", values, "ssiSecurityAddress");
            return (Criteria) this;
        }

        public Criteria andSsiSecurityAddressNotIn(List<String> values) {
            addCriterion("ssi_security_address not in", values, "ssiSecurityAddress");
            return (Criteria) this;
        }

        public Criteria andSsiSecurityAddressBetween(String value1, String value2) {
            addCriterion("ssi_security_address between", value1, value2, "ssiSecurityAddress");
            return (Criteria) this;
        }

        public Criteria andSsiSecurityAddressNotBetween(String value1, String value2) {
            addCriterion("ssi_security_address not between", value1, value2, "ssiSecurityAddress");
            return (Criteria) this;
        }

        public Criteria andSsiBeginMonthIsNull() {
            addCriterion("ssi_begin_month is null");
            return (Criteria) this;
        }

        public Criteria andSsiBeginMonthIsNotNull() {
            addCriterion("ssi_begin_month is not null");
            return (Criteria) this;
        }

        public Criteria andSsiBeginMonthEqualTo(String value) {
            addCriterion("ssi_begin_month =", value, "ssiBeginMonth");
            return (Criteria) this;
        }

        public Criteria andSsiBeginMonthNotEqualTo(String value) {
            addCriterion("ssi_begin_month <>", value, "ssiBeginMonth");
            return (Criteria) this;
        }

        public Criteria andSsiBeginMonthGreaterThan(String value) {
            addCriterion("ssi_begin_month >", value, "ssiBeginMonth");
            return (Criteria) this;
        }

        public Criteria andSsiBeginMonthGreaterThanOrEqualTo(String value) {
            addCriterion("ssi_begin_month >=", value, "ssiBeginMonth");
            return (Criteria) this;
        }

        public Criteria andSsiBeginMonthLessThan(String value) {
            addCriterion("ssi_begin_month <", value, "ssiBeginMonth");
            return (Criteria) this;
        }

        public Criteria andSsiBeginMonthLessThanOrEqualTo(String value) {
            addCriterion("ssi_begin_month <=", value, "ssiBeginMonth");
            return (Criteria) this;
        }

        public Criteria andSsiBeginMonthLike(String value) {
            addCriterion("ssi_begin_month like", value, "ssiBeginMonth");
            return (Criteria) this;
        }

        public Criteria andSsiBeginMonthNotLike(String value) {
            addCriterion("ssi_begin_month not like", value, "ssiBeginMonth");
            return (Criteria) this;
        }

        public Criteria andSsiBeginMonthIn(List<String> values) {
            addCriterion("ssi_begin_month in", values, "ssiBeginMonth");
            return (Criteria) this;
        }

        public Criteria andSsiBeginMonthNotIn(List<String> values) {
            addCriterion("ssi_begin_month not in", values, "ssiBeginMonth");
            return (Criteria) this;
        }

        public Criteria andSsiBeginMonthBetween(String value1, String value2) {
            addCriterion("ssi_begin_month between", value1, value2, "ssiBeginMonth");
            return (Criteria) this;
        }

        public Criteria andSsiBeginMonthNotBetween(String value1, String value2) {
            addCriterion("ssi_begin_month not between", value1, value2, "ssiBeginMonth");
            return (Criteria) this;
        }

        public Criteria andSsiEndowmentIsNull() {
            addCriterion("ssi_endowment is null");
            return (Criteria) this;
        }

        public Criteria andSsiEndowmentIsNotNull() {
            addCriterion("ssi_endowment is not null");
            return (Criteria) this;
        }

        public Criteria andSsiEndowmentEqualTo(String value) {
            addCriterion("ssi_endowment =", value, "ssiEndowment");
            return (Criteria) this;
        }

        public Criteria andSsiEndowmentNotEqualTo(String value) {
            addCriterion("ssi_endowment <>", value, "ssiEndowment");
            return (Criteria) this;
        }

        public Criteria andSsiEndowmentGreaterThan(String value) {
            addCriterion("ssi_endowment >", value, "ssiEndowment");
            return (Criteria) this;
        }

        public Criteria andSsiEndowmentGreaterThanOrEqualTo(String value) {
            addCriterion("ssi_endowment >=", value, "ssiEndowment");
            return (Criteria) this;
        }

        public Criteria andSsiEndowmentLessThan(String value) {
            addCriterion("ssi_endowment <", value, "ssiEndowment");
            return (Criteria) this;
        }

        public Criteria andSsiEndowmentLessThanOrEqualTo(String value) {
            addCriterion("ssi_endowment <=", value, "ssiEndowment");
            return (Criteria) this;
        }

        public Criteria andSsiEndowmentLike(String value) {
            addCriterion("ssi_endowment like", value, "ssiEndowment");
            return (Criteria) this;
        }

        public Criteria andSsiEndowmentNotLike(String value) {
            addCriterion("ssi_endowment not like", value, "ssiEndowment");
            return (Criteria) this;
        }

        public Criteria andSsiEndowmentIn(List<String> values) {
            addCriterion("ssi_endowment in", values, "ssiEndowment");
            return (Criteria) this;
        }

        public Criteria andSsiEndowmentNotIn(List<String> values) {
            addCriterion("ssi_endowment not in", values, "ssiEndowment");
            return (Criteria) this;
        }

        public Criteria andSsiEndowmentBetween(String value1, String value2) {
            addCriterion("ssi_endowment between", value1, value2, "ssiEndowment");
            return (Criteria) this;
        }

        public Criteria andSsiEndowmentNotBetween(String value1, String value2) {
            addCriterion("ssi_endowment not between", value1, value2, "ssiEndowment");
            return (Criteria) this;
        }

        public Criteria andSsiEndowmentComIsNull() {
            addCriterion("ssi_endowment_com is null");
            return (Criteria) this;
        }

        public Criteria andSsiEndowmentComIsNotNull() {
            addCriterion("ssi_endowment_com is not null");
            return (Criteria) this;
        }

        public Criteria andSsiEndowmentComEqualTo(String value) {
            addCriterion("ssi_endowment_com =", value, "ssiEndowmentCom");
            return (Criteria) this;
        }

        public Criteria andSsiEndowmentComNotEqualTo(String value) {
            addCriterion("ssi_endowment_com <>", value, "ssiEndowmentCom");
            return (Criteria) this;
        }

        public Criteria andSsiEndowmentComGreaterThan(String value) {
            addCriterion("ssi_endowment_com >", value, "ssiEndowmentCom");
            return (Criteria) this;
        }

        public Criteria andSsiEndowmentComGreaterThanOrEqualTo(String value) {
            addCriterion("ssi_endowment_com >=", value, "ssiEndowmentCom");
            return (Criteria) this;
        }

        public Criteria andSsiEndowmentComLessThan(String value) {
            addCriterion("ssi_endowment_com <", value, "ssiEndowmentCom");
            return (Criteria) this;
        }

        public Criteria andSsiEndowmentComLessThanOrEqualTo(String value) {
            addCriterion("ssi_endowment_com <=", value, "ssiEndowmentCom");
            return (Criteria) this;
        }

        public Criteria andSsiEndowmentComLike(String value) {
            addCriterion("ssi_endowment_com like", value, "ssiEndowmentCom");
            return (Criteria) this;
        }

        public Criteria andSsiEndowmentComNotLike(String value) {
            addCriterion("ssi_endowment_com not like", value, "ssiEndowmentCom");
            return (Criteria) this;
        }

        public Criteria andSsiEndowmentComIn(List<String> values) {
            addCriterion("ssi_endowment_com in", values, "ssiEndowmentCom");
            return (Criteria) this;
        }

        public Criteria andSsiEndowmentComNotIn(List<String> values) {
            addCriterion("ssi_endowment_com not in", values, "ssiEndowmentCom");
            return (Criteria) this;
        }

        public Criteria andSsiEndowmentComBetween(String value1, String value2) {
            addCriterion("ssi_endowment_com between", value1, value2, "ssiEndowmentCom");
            return (Criteria) this;
        }

        public Criteria andSsiEndowmentComNotBetween(String value1, String value2) {
            addCriterion("ssi_endowment_com not between", value1, value2, "ssiEndowmentCom");
            return (Criteria) this;
        }

        public Criteria andSsiEndowmentPerIsNull() {
            addCriterion("ssi_endowment_per is null");
            return (Criteria) this;
        }

        public Criteria andSsiEndowmentPerIsNotNull() {
            addCriterion("ssi_endowment_per is not null");
            return (Criteria) this;
        }

        public Criteria andSsiEndowmentPerEqualTo(String value) {
            addCriterion("ssi_endowment_per =", value, "ssiEndowmentPer");
            return (Criteria) this;
        }

        public Criteria andSsiEndowmentPerNotEqualTo(String value) {
            addCriterion("ssi_endowment_per <>", value, "ssiEndowmentPer");
            return (Criteria) this;
        }

        public Criteria andSsiEndowmentPerGreaterThan(String value) {
            addCriterion("ssi_endowment_per >", value, "ssiEndowmentPer");
            return (Criteria) this;
        }

        public Criteria andSsiEndowmentPerGreaterThanOrEqualTo(String value) {
            addCriterion("ssi_endowment_per >=", value, "ssiEndowmentPer");
            return (Criteria) this;
        }

        public Criteria andSsiEndowmentPerLessThan(String value) {
            addCriterion("ssi_endowment_per <", value, "ssiEndowmentPer");
            return (Criteria) this;
        }

        public Criteria andSsiEndowmentPerLessThanOrEqualTo(String value) {
            addCriterion("ssi_endowment_per <=", value, "ssiEndowmentPer");
            return (Criteria) this;
        }

        public Criteria andSsiEndowmentPerLike(String value) {
            addCriterion("ssi_endowment_per like", value, "ssiEndowmentPer");
            return (Criteria) this;
        }

        public Criteria andSsiEndowmentPerNotLike(String value) {
            addCriterion("ssi_endowment_per not like", value, "ssiEndowmentPer");
            return (Criteria) this;
        }

        public Criteria andSsiEndowmentPerIn(List<String> values) {
            addCriterion("ssi_endowment_per in", values, "ssiEndowmentPer");
            return (Criteria) this;
        }

        public Criteria andSsiEndowmentPerNotIn(List<String> values) {
            addCriterion("ssi_endowment_per not in", values, "ssiEndowmentPer");
            return (Criteria) this;
        }

        public Criteria andSsiEndowmentPerBetween(String value1, String value2) {
            addCriterion("ssi_endowment_per between", value1, value2, "ssiEndowmentPer");
            return (Criteria) this;
        }

        public Criteria andSsiEndowmentPerNotBetween(String value1, String value2) {
            addCriterion("ssi_endowment_per not between", value1, value2, "ssiEndowmentPer");
            return (Criteria) this;
        }

        public Criteria andSsiMedicalIsNull() {
            addCriterion("ssi_medical is null");
            return (Criteria) this;
        }

        public Criteria andSsiMedicalIsNotNull() {
            addCriterion("ssi_medical is not null");
            return (Criteria) this;
        }

        public Criteria andSsiMedicalEqualTo(String value) {
            addCriterion("ssi_medical =", value, "ssiMedical");
            return (Criteria) this;
        }

        public Criteria andSsiMedicalNotEqualTo(String value) {
            addCriterion("ssi_medical <>", value, "ssiMedical");
            return (Criteria) this;
        }

        public Criteria andSsiMedicalGreaterThan(String value) {
            addCriterion("ssi_medical >", value, "ssiMedical");
            return (Criteria) this;
        }

        public Criteria andSsiMedicalGreaterThanOrEqualTo(String value) {
            addCriterion("ssi_medical >=", value, "ssiMedical");
            return (Criteria) this;
        }

        public Criteria andSsiMedicalLessThan(String value) {
            addCriterion("ssi_medical <", value, "ssiMedical");
            return (Criteria) this;
        }

        public Criteria andSsiMedicalLessThanOrEqualTo(String value) {
            addCriterion("ssi_medical <=", value, "ssiMedical");
            return (Criteria) this;
        }

        public Criteria andSsiMedicalLike(String value) {
            addCriterion("ssi_medical like", value, "ssiMedical");
            return (Criteria) this;
        }

        public Criteria andSsiMedicalNotLike(String value) {
            addCriterion("ssi_medical not like", value, "ssiMedical");
            return (Criteria) this;
        }

        public Criteria andSsiMedicalIn(List<String> values) {
            addCriterion("ssi_medical in", values, "ssiMedical");
            return (Criteria) this;
        }

        public Criteria andSsiMedicalNotIn(List<String> values) {
            addCriterion("ssi_medical not in", values, "ssiMedical");
            return (Criteria) this;
        }

        public Criteria andSsiMedicalBetween(String value1, String value2) {
            addCriterion("ssi_medical between", value1, value2, "ssiMedical");
            return (Criteria) this;
        }

        public Criteria andSsiMedicalNotBetween(String value1, String value2) {
            addCriterion("ssi_medical not between", value1, value2, "ssiMedical");
            return (Criteria) this;
        }

        public Criteria andSsiMedicalComIsNull() {
            addCriterion("ssi_medical_com is null");
            return (Criteria) this;
        }

        public Criteria andSsiMedicalComIsNotNull() {
            addCriterion("ssi_medical_com is not null");
            return (Criteria) this;
        }

        public Criteria andSsiMedicalComEqualTo(String value) {
            addCriterion("ssi_medical_com =", value, "ssiMedicalCom");
            return (Criteria) this;
        }

        public Criteria andSsiMedicalComNotEqualTo(String value) {
            addCriterion("ssi_medical_com <>", value, "ssiMedicalCom");
            return (Criteria) this;
        }

        public Criteria andSsiMedicalComGreaterThan(String value) {
            addCriterion("ssi_medical_com >", value, "ssiMedicalCom");
            return (Criteria) this;
        }

        public Criteria andSsiMedicalComGreaterThanOrEqualTo(String value) {
            addCriterion("ssi_medical_com >=", value, "ssiMedicalCom");
            return (Criteria) this;
        }

        public Criteria andSsiMedicalComLessThan(String value) {
            addCriterion("ssi_medical_com <", value, "ssiMedicalCom");
            return (Criteria) this;
        }

        public Criteria andSsiMedicalComLessThanOrEqualTo(String value) {
            addCriterion("ssi_medical_com <=", value, "ssiMedicalCom");
            return (Criteria) this;
        }

        public Criteria andSsiMedicalComLike(String value) {
            addCriterion("ssi_medical_com like", value, "ssiMedicalCom");
            return (Criteria) this;
        }

        public Criteria andSsiMedicalComNotLike(String value) {
            addCriterion("ssi_medical_com not like", value, "ssiMedicalCom");
            return (Criteria) this;
        }

        public Criteria andSsiMedicalComIn(List<String> values) {
            addCriterion("ssi_medical_com in", values, "ssiMedicalCom");
            return (Criteria) this;
        }

        public Criteria andSsiMedicalComNotIn(List<String> values) {
            addCriterion("ssi_medical_com not in", values, "ssiMedicalCom");
            return (Criteria) this;
        }

        public Criteria andSsiMedicalComBetween(String value1, String value2) {
            addCriterion("ssi_medical_com between", value1, value2, "ssiMedicalCom");
            return (Criteria) this;
        }

        public Criteria andSsiMedicalComNotBetween(String value1, String value2) {
            addCriterion("ssi_medical_com not between", value1, value2, "ssiMedicalCom");
            return (Criteria) this;
        }

        public Criteria andSsiMedicalPerIsNull() {
            addCriterion("ssi_medical_per is null");
            return (Criteria) this;
        }

        public Criteria andSsiMedicalPerIsNotNull() {
            addCriterion("ssi_medical_per is not null");
            return (Criteria) this;
        }

        public Criteria andSsiMedicalPerEqualTo(String value) {
            addCriterion("ssi_medical_per =", value, "ssiMedicalPer");
            return (Criteria) this;
        }

        public Criteria andSsiMedicalPerNotEqualTo(String value) {
            addCriterion("ssi_medical_per <>", value, "ssiMedicalPer");
            return (Criteria) this;
        }

        public Criteria andSsiMedicalPerGreaterThan(String value) {
            addCriterion("ssi_medical_per >", value, "ssiMedicalPer");
            return (Criteria) this;
        }

        public Criteria andSsiMedicalPerGreaterThanOrEqualTo(String value) {
            addCriterion("ssi_medical_per >=", value, "ssiMedicalPer");
            return (Criteria) this;
        }

        public Criteria andSsiMedicalPerLessThan(String value) {
            addCriterion("ssi_medical_per <", value, "ssiMedicalPer");
            return (Criteria) this;
        }

        public Criteria andSsiMedicalPerLessThanOrEqualTo(String value) {
            addCriterion("ssi_medical_per <=", value, "ssiMedicalPer");
            return (Criteria) this;
        }

        public Criteria andSsiMedicalPerLike(String value) {
            addCriterion("ssi_medical_per like", value, "ssiMedicalPer");
            return (Criteria) this;
        }

        public Criteria andSsiMedicalPerNotLike(String value) {
            addCriterion("ssi_medical_per not like", value, "ssiMedicalPer");
            return (Criteria) this;
        }

        public Criteria andSsiMedicalPerIn(List<String> values) {
            addCriterion("ssi_medical_per in", values, "ssiMedicalPer");
            return (Criteria) this;
        }

        public Criteria andSsiMedicalPerNotIn(List<String> values) {
            addCriterion("ssi_medical_per not in", values, "ssiMedicalPer");
            return (Criteria) this;
        }

        public Criteria andSsiMedicalPerBetween(String value1, String value2) {
            addCriterion("ssi_medical_per between", value1, value2, "ssiMedicalPer");
            return (Criteria) this;
        }

        public Criteria andSsiMedicalPerNotBetween(String value1, String value2) {
            addCriterion("ssi_medical_per not between", value1, value2, "ssiMedicalPer");
            return (Criteria) this;
        }

        public Criteria andSsiUnemploymentIsNull() {
            addCriterion("ssi_unemployment is null");
            return (Criteria) this;
        }

        public Criteria andSsiUnemploymentIsNotNull() {
            addCriterion("ssi_unemployment is not null");
            return (Criteria) this;
        }

        public Criteria andSsiUnemploymentEqualTo(String value) {
            addCriterion("ssi_unemployment =", value, "ssiUnemployment");
            return (Criteria) this;
        }

        public Criteria andSsiUnemploymentNotEqualTo(String value) {
            addCriterion("ssi_unemployment <>", value, "ssiUnemployment");
            return (Criteria) this;
        }

        public Criteria andSsiUnemploymentGreaterThan(String value) {
            addCriterion("ssi_unemployment >", value, "ssiUnemployment");
            return (Criteria) this;
        }

        public Criteria andSsiUnemploymentGreaterThanOrEqualTo(String value) {
            addCriterion("ssi_unemployment >=", value, "ssiUnemployment");
            return (Criteria) this;
        }

        public Criteria andSsiUnemploymentLessThan(String value) {
            addCriterion("ssi_unemployment <", value, "ssiUnemployment");
            return (Criteria) this;
        }

        public Criteria andSsiUnemploymentLessThanOrEqualTo(String value) {
            addCriterion("ssi_unemployment <=", value, "ssiUnemployment");
            return (Criteria) this;
        }

        public Criteria andSsiUnemploymentLike(String value) {
            addCriterion("ssi_unemployment like", value, "ssiUnemployment");
            return (Criteria) this;
        }

        public Criteria andSsiUnemploymentNotLike(String value) {
            addCriterion("ssi_unemployment not like", value, "ssiUnemployment");
            return (Criteria) this;
        }

        public Criteria andSsiUnemploymentIn(List<String> values) {
            addCriterion("ssi_unemployment in", values, "ssiUnemployment");
            return (Criteria) this;
        }

        public Criteria andSsiUnemploymentNotIn(List<String> values) {
            addCriterion("ssi_unemployment not in", values, "ssiUnemployment");
            return (Criteria) this;
        }

        public Criteria andSsiUnemploymentBetween(String value1, String value2) {
            addCriterion("ssi_unemployment between", value1, value2, "ssiUnemployment");
            return (Criteria) this;
        }

        public Criteria andSsiUnemploymentNotBetween(String value1, String value2) {
            addCriterion("ssi_unemployment not between", value1, value2, "ssiUnemployment");
            return (Criteria) this;
        }

        public Criteria andSsiUnemploymentComIsNull() {
            addCriterion("ssi_unemployment_com is null");
            return (Criteria) this;
        }

        public Criteria andSsiUnemploymentComIsNotNull() {
            addCriterion("ssi_unemployment_com is not null");
            return (Criteria) this;
        }

        public Criteria andSsiUnemploymentComEqualTo(String value) {
            addCriterion("ssi_unemployment_com =", value, "ssiUnemploymentCom");
            return (Criteria) this;
        }

        public Criteria andSsiUnemploymentComNotEqualTo(String value) {
            addCriterion("ssi_unemployment_com <>", value, "ssiUnemploymentCom");
            return (Criteria) this;
        }

        public Criteria andSsiUnemploymentComGreaterThan(String value) {
            addCriterion("ssi_unemployment_com >", value, "ssiUnemploymentCom");
            return (Criteria) this;
        }

        public Criteria andSsiUnemploymentComGreaterThanOrEqualTo(String value) {
            addCriterion("ssi_unemployment_com >=", value, "ssiUnemploymentCom");
            return (Criteria) this;
        }

        public Criteria andSsiUnemploymentComLessThan(String value) {
            addCriterion("ssi_unemployment_com <", value, "ssiUnemploymentCom");
            return (Criteria) this;
        }

        public Criteria andSsiUnemploymentComLessThanOrEqualTo(String value) {
            addCriterion("ssi_unemployment_com <=", value, "ssiUnemploymentCom");
            return (Criteria) this;
        }

        public Criteria andSsiUnemploymentComLike(String value) {
            addCriterion("ssi_unemployment_com like", value, "ssiUnemploymentCom");
            return (Criteria) this;
        }

        public Criteria andSsiUnemploymentComNotLike(String value) {
            addCriterion("ssi_unemployment_com not like", value, "ssiUnemploymentCom");
            return (Criteria) this;
        }

        public Criteria andSsiUnemploymentComIn(List<String> values) {
            addCriterion("ssi_unemployment_com in", values, "ssiUnemploymentCom");
            return (Criteria) this;
        }

        public Criteria andSsiUnemploymentComNotIn(List<String> values) {
            addCriterion("ssi_unemployment_com not in", values, "ssiUnemploymentCom");
            return (Criteria) this;
        }

        public Criteria andSsiUnemploymentComBetween(String value1, String value2) {
            addCriterion("ssi_unemployment_com between", value1, value2, "ssiUnemploymentCom");
            return (Criteria) this;
        }

        public Criteria andSsiUnemploymentComNotBetween(String value1, String value2) {
            addCriterion("ssi_unemployment_com not between", value1, value2, "ssiUnemploymentCom");
            return (Criteria) this;
        }

        public Criteria andSsiUnemploymentPerIsNull() {
            addCriterion("ssi_unemployment_per is null");
            return (Criteria) this;
        }

        public Criteria andSsiUnemploymentPerIsNotNull() {
            addCriterion("ssi_unemployment_per is not null");
            return (Criteria) this;
        }

        public Criteria andSsiUnemploymentPerEqualTo(String value) {
            addCriterion("ssi_unemployment_per =", value, "ssiUnemploymentPer");
            return (Criteria) this;
        }

        public Criteria andSsiUnemploymentPerNotEqualTo(String value) {
            addCriterion("ssi_unemployment_per <>", value, "ssiUnemploymentPer");
            return (Criteria) this;
        }

        public Criteria andSsiUnemploymentPerGreaterThan(String value) {
            addCriterion("ssi_unemployment_per >", value, "ssiUnemploymentPer");
            return (Criteria) this;
        }

        public Criteria andSsiUnemploymentPerGreaterThanOrEqualTo(String value) {
            addCriterion("ssi_unemployment_per >=", value, "ssiUnemploymentPer");
            return (Criteria) this;
        }

        public Criteria andSsiUnemploymentPerLessThan(String value) {
            addCriterion("ssi_unemployment_per <", value, "ssiUnemploymentPer");
            return (Criteria) this;
        }

        public Criteria andSsiUnemploymentPerLessThanOrEqualTo(String value) {
            addCriterion("ssi_unemployment_per <=", value, "ssiUnemploymentPer");
            return (Criteria) this;
        }

        public Criteria andSsiUnemploymentPerLike(String value) {
            addCriterion("ssi_unemployment_per like", value, "ssiUnemploymentPer");
            return (Criteria) this;
        }

        public Criteria andSsiUnemploymentPerNotLike(String value) {
            addCriterion("ssi_unemployment_per not like", value, "ssiUnemploymentPer");
            return (Criteria) this;
        }

        public Criteria andSsiUnemploymentPerIn(List<String> values) {
            addCriterion("ssi_unemployment_per in", values, "ssiUnemploymentPer");
            return (Criteria) this;
        }

        public Criteria andSsiUnemploymentPerNotIn(List<String> values) {
            addCriterion("ssi_unemployment_per not in", values, "ssiUnemploymentPer");
            return (Criteria) this;
        }

        public Criteria andSsiUnemploymentPerBetween(String value1, String value2) {
            addCriterion("ssi_unemployment_per between", value1, value2, "ssiUnemploymentPer");
            return (Criteria) this;
        }

        public Criteria andSsiUnemploymentPerNotBetween(String value1, String value2) {
            addCriterion("ssi_unemployment_per not between", value1, value2, "ssiUnemploymentPer");
            return (Criteria) this;
        }

        public Criteria andSsiMaternityIsNull() {
            addCriterion("ssi_maternity is null");
            return (Criteria) this;
        }

        public Criteria andSsiMaternityIsNotNull() {
            addCriterion("ssi_maternity is not null");
            return (Criteria) this;
        }

        public Criteria andSsiMaternityEqualTo(String value) {
            addCriterion("ssi_maternity =", value, "ssiMaternity");
            return (Criteria) this;
        }

        public Criteria andSsiMaternityNotEqualTo(String value) {
            addCriterion("ssi_maternity <>", value, "ssiMaternity");
            return (Criteria) this;
        }

        public Criteria andSsiMaternityGreaterThan(String value) {
            addCriterion("ssi_maternity >", value, "ssiMaternity");
            return (Criteria) this;
        }

        public Criteria andSsiMaternityGreaterThanOrEqualTo(String value) {
            addCriterion("ssi_maternity >=", value, "ssiMaternity");
            return (Criteria) this;
        }

        public Criteria andSsiMaternityLessThan(String value) {
            addCriterion("ssi_maternity <", value, "ssiMaternity");
            return (Criteria) this;
        }

        public Criteria andSsiMaternityLessThanOrEqualTo(String value) {
            addCriterion("ssi_maternity <=", value, "ssiMaternity");
            return (Criteria) this;
        }

        public Criteria andSsiMaternityLike(String value) {
            addCriterion("ssi_maternity like", value, "ssiMaternity");
            return (Criteria) this;
        }

        public Criteria andSsiMaternityNotLike(String value) {
            addCriterion("ssi_maternity not like", value, "ssiMaternity");
            return (Criteria) this;
        }

        public Criteria andSsiMaternityIn(List<String> values) {
            addCriterion("ssi_maternity in", values, "ssiMaternity");
            return (Criteria) this;
        }

        public Criteria andSsiMaternityNotIn(List<String> values) {
            addCriterion("ssi_maternity not in", values, "ssiMaternity");
            return (Criteria) this;
        }

        public Criteria andSsiMaternityBetween(String value1, String value2) {
            addCriterion("ssi_maternity between", value1, value2, "ssiMaternity");
            return (Criteria) this;
        }

        public Criteria andSsiMaternityNotBetween(String value1, String value2) {
            addCriterion("ssi_maternity not between", value1, value2, "ssiMaternity");
            return (Criteria) this;
        }

        public Criteria andSsiMaternityComIsNull() {
            addCriterion("ssi_maternity_com is null");
            return (Criteria) this;
        }

        public Criteria andSsiMaternityComIsNotNull() {
            addCriterion("ssi_maternity_com is not null");
            return (Criteria) this;
        }

        public Criteria andSsiMaternityComEqualTo(String value) {
            addCriterion("ssi_maternity_com =", value, "ssiMaternityCom");
            return (Criteria) this;
        }

        public Criteria andSsiMaternityComNotEqualTo(String value) {
            addCriterion("ssi_maternity_com <>", value, "ssiMaternityCom");
            return (Criteria) this;
        }

        public Criteria andSsiMaternityComGreaterThan(String value) {
            addCriterion("ssi_maternity_com >", value, "ssiMaternityCom");
            return (Criteria) this;
        }

        public Criteria andSsiMaternityComGreaterThanOrEqualTo(String value) {
            addCriterion("ssi_maternity_com >=", value, "ssiMaternityCom");
            return (Criteria) this;
        }

        public Criteria andSsiMaternityComLessThan(String value) {
            addCriterion("ssi_maternity_com <", value, "ssiMaternityCom");
            return (Criteria) this;
        }

        public Criteria andSsiMaternityComLessThanOrEqualTo(String value) {
            addCriterion("ssi_maternity_com <=", value, "ssiMaternityCom");
            return (Criteria) this;
        }

        public Criteria andSsiMaternityComLike(String value) {
            addCriterion("ssi_maternity_com like", value, "ssiMaternityCom");
            return (Criteria) this;
        }

        public Criteria andSsiMaternityComNotLike(String value) {
            addCriterion("ssi_maternity_com not like", value, "ssiMaternityCom");
            return (Criteria) this;
        }

        public Criteria andSsiMaternityComIn(List<String> values) {
            addCriterion("ssi_maternity_com in", values, "ssiMaternityCom");
            return (Criteria) this;
        }

        public Criteria andSsiMaternityComNotIn(List<String> values) {
            addCriterion("ssi_maternity_com not in", values, "ssiMaternityCom");
            return (Criteria) this;
        }

        public Criteria andSsiMaternityComBetween(String value1, String value2) {
            addCriterion("ssi_maternity_com between", value1, value2, "ssiMaternityCom");
            return (Criteria) this;
        }

        public Criteria andSsiMaternityComNotBetween(String value1, String value2) {
            addCriterion("ssi_maternity_com not between", value1, value2, "ssiMaternityCom");
            return (Criteria) this;
        }

        public Criteria andSsiMaternityPerIsNull() {
            addCriterion("ssi_maternity_per is null");
            return (Criteria) this;
        }

        public Criteria andSsiMaternityPerIsNotNull() {
            addCriterion("ssi_maternity_per is not null");
            return (Criteria) this;
        }

        public Criteria andSsiMaternityPerEqualTo(String value) {
            addCriterion("ssi_maternity_per =", value, "ssiMaternityPer");
            return (Criteria) this;
        }

        public Criteria andSsiMaternityPerNotEqualTo(String value) {
            addCriterion("ssi_maternity_per <>", value, "ssiMaternityPer");
            return (Criteria) this;
        }

        public Criteria andSsiMaternityPerGreaterThan(String value) {
            addCriterion("ssi_maternity_per >", value, "ssiMaternityPer");
            return (Criteria) this;
        }

        public Criteria andSsiMaternityPerGreaterThanOrEqualTo(String value) {
            addCriterion("ssi_maternity_per >=", value, "ssiMaternityPer");
            return (Criteria) this;
        }

        public Criteria andSsiMaternityPerLessThan(String value) {
            addCriterion("ssi_maternity_per <", value, "ssiMaternityPer");
            return (Criteria) this;
        }

        public Criteria andSsiMaternityPerLessThanOrEqualTo(String value) {
            addCriterion("ssi_maternity_per <=", value, "ssiMaternityPer");
            return (Criteria) this;
        }

        public Criteria andSsiMaternityPerLike(String value) {
            addCriterion("ssi_maternity_per like", value, "ssiMaternityPer");
            return (Criteria) this;
        }

        public Criteria andSsiMaternityPerNotLike(String value) {
            addCriterion("ssi_maternity_per not like", value, "ssiMaternityPer");
            return (Criteria) this;
        }

        public Criteria andSsiMaternityPerIn(List<String> values) {
            addCriterion("ssi_maternity_per in", values, "ssiMaternityPer");
            return (Criteria) this;
        }

        public Criteria andSsiMaternityPerNotIn(List<String> values) {
            addCriterion("ssi_maternity_per not in", values, "ssiMaternityPer");
            return (Criteria) this;
        }

        public Criteria andSsiMaternityPerBetween(String value1, String value2) {
            addCriterion("ssi_maternity_per between", value1, value2, "ssiMaternityPer");
            return (Criteria) this;
        }

        public Criteria andSsiMaternityPerNotBetween(String value1, String value2) {
            addCriterion("ssi_maternity_per not between", value1, value2, "ssiMaternityPer");
            return (Criteria) this;
        }

        public Criteria andSsiInjuryIsNull() {
            addCriterion("ssi_injury is null");
            return (Criteria) this;
        }

        public Criteria andSsiInjuryIsNotNull() {
            addCriterion("ssi_injury is not null");
            return (Criteria) this;
        }

        public Criteria andSsiInjuryEqualTo(String value) {
            addCriterion("ssi_injury =", value, "ssiInjury");
            return (Criteria) this;
        }

        public Criteria andSsiInjuryNotEqualTo(String value) {
            addCriterion("ssi_injury <>", value, "ssiInjury");
            return (Criteria) this;
        }

        public Criteria andSsiInjuryGreaterThan(String value) {
            addCriterion("ssi_injury >", value, "ssiInjury");
            return (Criteria) this;
        }

        public Criteria andSsiInjuryGreaterThanOrEqualTo(String value) {
            addCriterion("ssi_injury >=", value, "ssiInjury");
            return (Criteria) this;
        }

        public Criteria andSsiInjuryLessThan(String value) {
            addCriterion("ssi_injury <", value, "ssiInjury");
            return (Criteria) this;
        }

        public Criteria andSsiInjuryLessThanOrEqualTo(String value) {
            addCriterion("ssi_injury <=", value, "ssiInjury");
            return (Criteria) this;
        }

        public Criteria andSsiInjuryLike(String value) {
            addCriterion("ssi_injury like", value, "ssiInjury");
            return (Criteria) this;
        }

        public Criteria andSsiInjuryNotLike(String value) {
            addCriterion("ssi_injury not like", value, "ssiInjury");
            return (Criteria) this;
        }

        public Criteria andSsiInjuryIn(List<String> values) {
            addCriterion("ssi_injury in", values, "ssiInjury");
            return (Criteria) this;
        }

        public Criteria andSsiInjuryNotIn(List<String> values) {
            addCriterion("ssi_injury not in", values, "ssiInjury");
            return (Criteria) this;
        }

        public Criteria andSsiInjuryBetween(String value1, String value2) {
            addCriterion("ssi_injury between", value1, value2, "ssiInjury");
            return (Criteria) this;
        }

        public Criteria andSsiInjuryNotBetween(String value1, String value2) {
            addCriterion("ssi_injury not between", value1, value2, "ssiInjury");
            return (Criteria) this;
        }

        public Criteria andSsiInjuryComIsNull() {
            addCriterion("ssi_injury_com is null");
            return (Criteria) this;
        }

        public Criteria andSsiInjuryComIsNotNull() {
            addCriterion("ssi_injury_com is not null");
            return (Criteria) this;
        }

        public Criteria andSsiInjuryComEqualTo(String value) {
            addCriterion("ssi_injury_com =", value, "ssiInjuryCom");
            return (Criteria) this;
        }

        public Criteria andSsiInjuryComNotEqualTo(String value) {
            addCriterion("ssi_injury_com <>", value, "ssiInjuryCom");
            return (Criteria) this;
        }

        public Criteria andSsiInjuryComGreaterThan(String value) {
            addCriterion("ssi_injury_com >", value, "ssiInjuryCom");
            return (Criteria) this;
        }

        public Criteria andSsiInjuryComGreaterThanOrEqualTo(String value) {
            addCriterion("ssi_injury_com >=", value, "ssiInjuryCom");
            return (Criteria) this;
        }

        public Criteria andSsiInjuryComLessThan(String value) {
            addCriterion("ssi_injury_com <", value, "ssiInjuryCom");
            return (Criteria) this;
        }

        public Criteria andSsiInjuryComLessThanOrEqualTo(String value) {
            addCriterion("ssi_injury_com <=", value, "ssiInjuryCom");
            return (Criteria) this;
        }

        public Criteria andSsiInjuryComLike(String value) {
            addCriterion("ssi_injury_com like", value, "ssiInjuryCom");
            return (Criteria) this;
        }

        public Criteria andSsiInjuryComNotLike(String value) {
            addCriterion("ssi_injury_com not like", value, "ssiInjuryCom");
            return (Criteria) this;
        }

        public Criteria andSsiInjuryComIn(List<String> values) {
            addCriterion("ssi_injury_com in", values, "ssiInjuryCom");
            return (Criteria) this;
        }

        public Criteria andSsiInjuryComNotIn(List<String> values) {
            addCriterion("ssi_injury_com not in", values, "ssiInjuryCom");
            return (Criteria) this;
        }

        public Criteria andSsiInjuryComBetween(String value1, String value2) {
            addCriterion("ssi_injury_com between", value1, value2, "ssiInjuryCom");
            return (Criteria) this;
        }

        public Criteria andSsiInjuryComNotBetween(String value1, String value2) {
            addCriterion("ssi_injury_com not between", value1, value2, "ssiInjuryCom");
            return (Criteria) this;
        }

        public Criteria andSsiInjuryPerIsNull() {
            addCriterion("ssi_injury_per is null");
            return (Criteria) this;
        }

        public Criteria andSsiInjuryPerIsNotNull() {
            addCriterion("ssi_injury_per is not null");
            return (Criteria) this;
        }

        public Criteria andSsiInjuryPerEqualTo(String value) {
            addCriterion("ssi_injury_per =", value, "ssiInjuryPer");
            return (Criteria) this;
        }

        public Criteria andSsiInjuryPerNotEqualTo(String value) {
            addCriterion("ssi_injury_per <>", value, "ssiInjuryPer");
            return (Criteria) this;
        }

        public Criteria andSsiInjuryPerGreaterThan(String value) {
            addCriterion("ssi_injury_per >", value, "ssiInjuryPer");
            return (Criteria) this;
        }

        public Criteria andSsiInjuryPerGreaterThanOrEqualTo(String value) {
            addCriterion("ssi_injury_per >=", value, "ssiInjuryPer");
            return (Criteria) this;
        }

        public Criteria andSsiInjuryPerLessThan(String value) {
            addCriterion("ssi_injury_per <", value, "ssiInjuryPer");
            return (Criteria) this;
        }

        public Criteria andSsiInjuryPerLessThanOrEqualTo(String value) {
            addCriterion("ssi_injury_per <=", value, "ssiInjuryPer");
            return (Criteria) this;
        }

        public Criteria andSsiInjuryPerLike(String value) {
            addCriterion("ssi_injury_per like", value, "ssiInjuryPer");
            return (Criteria) this;
        }

        public Criteria andSsiInjuryPerNotLike(String value) {
            addCriterion("ssi_injury_per not like", value, "ssiInjuryPer");
            return (Criteria) this;
        }

        public Criteria andSsiInjuryPerIn(List<String> values) {
            addCriterion("ssi_injury_per in", values, "ssiInjuryPer");
            return (Criteria) this;
        }

        public Criteria andSsiInjuryPerNotIn(List<String> values) {
            addCriterion("ssi_injury_per not in", values, "ssiInjuryPer");
            return (Criteria) this;
        }

        public Criteria andSsiInjuryPerBetween(String value1, String value2) {
            addCriterion("ssi_injury_per between", value1, value2, "ssiInjuryPer");
            return (Criteria) this;
        }

        public Criteria andSsiInjuryPerNotBetween(String value1, String value2) {
            addCriterion("ssi_injury_per not between", value1, value2, "ssiInjuryPer");
            return (Criteria) this;
        }

        public Criteria andSsiAccumulationIsNull() {
            addCriterion("ssi_accumulation is null");
            return (Criteria) this;
        }

        public Criteria andSsiAccumulationIsNotNull() {
            addCriterion("ssi_accumulation is not null");
            return (Criteria) this;
        }

        public Criteria andSsiAccumulationEqualTo(String value) {
            addCriterion("ssi_accumulation =", value, "ssiAccumulation");
            return (Criteria) this;
        }

        public Criteria andSsiAccumulationNotEqualTo(String value) {
            addCriterion("ssi_accumulation <>", value, "ssiAccumulation");
            return (Criteria) this;
        }

        public Criteria andSsiAccumulationGreaterThan(String value) {
            addCriterion("ssi_accumulation >", value, "ssiAccumulation");
            return (Criteria) this;
        }

        public Criteria andSsiAccumulationGreaterThanOrEqualTo(String value) {
            addCriterion("ssi_accumulation >=", value, "ssiAccumulation");
            return (Criteria) this;
        }

        public Criteria andSsiAccumulationLessThan(String value) {
            addCriterion("ssi_accumulation <", value, "ssiAccumulation");
            return (Criteria) this;
        }

        public Criteria andSsiAccumulationLessThanOrEqualTo(String value) {
            addCriterion("ssi_accumulation <=", value, "ssiAccumulation");
            return (Criteria) this;
        }

        public Criteria andSsiAccumulationLike(String value) {
            addCriterion("ssi_accumulation like", value, "ssiAccumulation");
            return (Criteria) this;
        }

        public Criteria andSsiAccumulationNotLike(String value) {
            addCriterion("ssi_accumulation not like", value, "ssiAccumulation");
            return (Criteria) this;
        }

        public Criteria andSsiAccumulationIn(List<String> values) {
            addCriterion("ssi_accumulation in", values, "ssiAccumulation");
            return (Criteria) this;
        }

        public Criteria andSsiAccumulationNotIn(List<String> values) {
            addCriterion("ssi_accumulation not in", values, "ssiAccumulation");
            return (Criteria) this;
        }

        public Criteria andSsiAccumulationBetween(String value1, String value2) {
            addCriterion("ssi_accumulation between", value1, value2, "ssiAccumulation");
            return (Criteria) this;
        }

        public Criteria andSsiAccumulationNotBetween(String value1, String value2) {
            addCriterion("ssi_accumulation not between", value1, value2, "ssiAccumulation");
            return (Criteria) this;
        }

        public Criteria andSsiAccumulationComIsNull() {
            addCriterion("ssi_accumulation_com is null");
            return (Criteria) this;
        }

        public Criteria andSsiAccumulationComIsNotNull() {
            addCriterion("ssi_accumulation_com is not null");
            return (Criteria) this;
        }

        public Criteria andSsiAccumulationComEqualTo(String value) {
            addCriterion("ssi_accumulation_com =", value, "ssiAccumulationCom");
            return (Criteria) this;
        }

        public Criteria andSsiAccumulationComNotEqualTo(String value) {
            addCriterion("ssi_accumulation_com <>", value, "ssiAccumulationCom");
            return (Criteria) this;
        }

        public Criteria andSsiAccumulationComGreaterThan(String value) {
            addCriterion("ssi_accumulation_com >", value, "ssiAccumulationCom");
            return (Criteria) this;
        }

        public Criteria andSsiAccumulationComGreaterThanOrEqualTo(String value) {
            addCriterion("ssi_accumulation_com >=", value, "ssiAccumulationCom");
            return (Criteria) this;
        }

        public Criteria andSsiAccumulationComLessThan(String value) {
            addCriterion("ssi_accumulation_com <", value, "ssiAccumulationCom");
            return (Criteria) this;
        }

        public Criteria andSsiAccumulationComLessThanOrEqualTo(String value) {
            addCriterion("ssi_accumulation_com <=", value, "ssiAccumulationCom");
            return (Criteria) this;
        }

        public Criteria andSsiAccumulationComLike(String value) {
            addCriterion("ssi_accumulation_com like", value, "ssiAccumulationCom");
            return (Criteria) this;
        }

        public Criteria andSsiAccumulationComNotLike(String value) {
            addCriterion("ssi_accumulation_com not like", value, "ssiAccumulationCom");
            return (Criteria) this;
        }

        public Criteria andSsiAccumulationComIn(List<String> values) {
            addCriterion("ssi_accumulation_com in", values, "ssiAccumulationCom");
            return (Criteria) this;
        }

        public Criteria andSsiAccumulationComNotIn(List<String> values) {
            addCriterion("ssi_accumulation_com not in", values, "ssiAccumulationCom");
            return (Criteria) this;
        }

        public Criteria andSsiAccumulationComBetween(String value1, String value2) {
            addCriterion("ssi_accumulation_com between", value1, value2, "ssiAccumulationCom");
            return (Criteria) this;
        }

        public Criteria andSsiAccumulationComNotBetween(String value1, String value2) {
            addCriterion("ssi_accumulation_com not between", value1, value2, "ssiAccumulationCom");
            return (Criteria) this;
        }

        public Criteria andSsiAccumulationPerIsNull() {
            addCriterion("ssi_accumulation_per is null");
            return (Criteria) this;
        }

        public Criteria andSsiAccumulationPerIsNotNull() {
            addCriterion("ssi_accumulation_per is not null");
            return (Criteria) this;
        }

        public Criteria andSsiAccumulationPerEqualTo(String value) {
            addCriterion("ssi_accumulation_per =", value, "ssiAccumulationPer");
            return (Criteria) this;
        }

        public Criteria andSsiAccumulationPerNotEqualTo(String value) {
            addCriterion("ssi_accumulation_per <>", value, "ssiAccumulationPer");
            return (Criteria) this;
        }

        public Criteria andSsiAccumulationPerGreaterThan(String value) {
            addCriterion("ssi_accumulation_per >", value, "ssiAccumulationPer");
            return (Criteria) this;
        }

        public Criteria andSsiAccumulationPerGreaterThanOrEqualTo(String value) {
            addCriterion("ssi_accumulation_per >=", value, "ssiAccumulationPer");
            return (Criteria) this;
        }

        public Criteria andSsiAccumulationPerLessThan(String value) {
            addCriterion("ssi_accumulation_per <", value, "ssiAccumulationPer");
            return (Criteria) this;
        }

        public Criteria andSsiAccumulationPerLessThanOrEqualTo(String value) {
            addCriterion("ssi_accumulation_per <=", value, "ssiAccumulationPer");
            return (Criteria) this;
        }

        public Criteria andSsiAccumulationPerLike(String value) {
            addCriterion("ssi_accumulation_per like", value, "ssiAccumulationPer");
            return (Criteria) this;
        }

        public Criteria andSsiAccumulationPerNotLike(String value) {
            addCriterion("ssi_accumulation_per not like", value, "ssiAccumulationPer");
            return (Criteria) this;
        }

        public Criteria andSsiAccumulationPerIn(List<String> values) {
            addCriterion("ssi_accumulation_per in", values, "ssiAccumulationPer");
            return (Criteria) this;
        }

        public Criteria andSsiAccumulationPerNotIn(List<String> values) {
            addCriterion("ssi_accumulation_per not in", values, "ssiAccumulationPer");
            return (Criteria) this;
        }

        public Criteria andSsiAccumulationPerBetween(String value1, String value2) {
            addCriterion("ssi_accumulation_per between", value1, value2, "ssiAccumulationPer");
            return (Criteria) this;
        }

        public Criteria andSsiAccumulationPerNotBetween(String value1, String value2) {
            addCriterion("ssi_accumulation_per not between", value1, value2, "ssiAccumulationPer");
            return (Criteria) this;
        }

        public Criteria andSsiExternalServiceIsNull() {
            addCriterion("ssi_external_service is null");
            return (Criteria) this;
        }

        public Criteria andSsiExternalServiceIsNotNull() {
            addCriterion("ssi_external_service is not null");
            return (Criteria) this;
        }

        public Criteria andSsiExternalServiceEqualTo(String value) {
            addCriterion("ssi_external_service =", value, "ssiExternalService");
            return (Criteria) this;
        }

        public Criteria andSsiExternalServiceNotEqualTo(String value) {
            addCriterion("ssi_external_service <>", value, "ssiExternalService");
            return (Criteria) this;
        }

        public Criteria andSsiExternalServiceGreaterThan(String value) {
            addCriterion("ssi_external_service >", value, "ssiExternalService");
            return (Criteria) this;
        }

        public Criteria andSsiExternalServiceGreaterThanOrEqualTo(String value) {
            addCriterion("ssi_external_service >=", value, "ssiExternalService");
            return (Criteria) this;
        }

        public Criteria andSsiExternalServiceLessThan(String value) {
            addCriterion("ssi_external_service <", value, "ssiExternalService");
            return (Criteria) this;
        }

        public Criteria andSsiExternalServiceLessThanOrEqualTo(String value) {
            addCriterion("ssi_external_service <=", value, "ssiExternalService");
            return (Criteria) this;
        }

        public Criteria andSsiExternalServiceLike(String value) {
            addCriterion("ssi_external_service like", value, "ssiExternalService");
            return (Criteria) this;
        }

        public Criteria andSsiExternalServiceNotLike(String value) {
            addCriterion("ssi_external_service not like", value, "ssiExternalService");
            return (Criteria) this;
        }

        public Criteria andSsiExternalServiceIn(List<String> values) {
            addCriterion("ssi_external_service in", values, "ssiExternalService");
            return (Criteria) this;
        }

        public Criteria andSsiExternalServiceNotIn(List<String> values) {
            addCriterion("ssi_external_service not in", values, "ssiExternalService");
            return (Criteria) this;
        }

        public Criteria andSsiExternalServiceBetween(String value1, String value2) {
            addCriterion("ssi_external_service between", value1, value2, "ssiExternalService");
            return (Criteria) this;
        }

        public Criteria andSsiExternalServiceNotBetween(String value1, String value2) {
            addCriterion("ssi_external_service not between", value1, value2, "ssiExternalService");
            return (Criteria) this;
        }

        public Criteria andSsiExternalServiceComIsNull() {
            addCriterion("ssi_external_service_com is null");
            return (Criteria) this;
        }

        public Criteria andSsiExternalServiceComIsNotNull() {
            addCriterion("ssi_external_service_com is not null");
            return (Criteria) this;
        }

        public Criteria andSsiExternalServiceComEqualTo(String value) {
            addCriterion("ssi_external_service_com =", value, "ssiExternalServiceCom");
            return (Criteria) this;
        }

        public Criteria andSsiExternalServiceComNotEqualTo(String value) {
            addCriterion("ssi_external_service_com <>", value, "ssiExternalServiceCom");
            return (Criteria) this;
        }

        public Criteria andSsiExternalServiceComGreaterThan(String value) {
            addCriterion("ssi_external_service_com >", value, "ssiExternalServiceCom");
            return (Criteria) this;
        }

        public Criteria andSsiExternalServiceComGreaterThanOrEqualTo(String value) {
            addCriterion("ssi_external_service_com >=", value, "ssiExternalServiceCom");
            return (Criteria) this;
        }

        public Criteria andSsiExternalServiceComLessThan(String value) {
            addCriterion("ssi_external_service_com <", value, "ssiExternalServiceCom");
            return (Criteria) this;
        }

        public Criteria andSsiExternalServiceComLessThanOrEqualTo(String value) {
            addCriterion("ssi_external_service_com <=", value, "ssiExternalServiceCom");
            return (Criteria) this;
        }

        public Criteria andSsiExternalServiceComLike(String value) {
            addCriterion("ssi_external_service_com like", value, "ssiExternalServiceCom");
            return (Criteria) this;
        }

        public Criteria andSsiExternalServiceComNotLike(String value) {
            addCriterion("ssi_external_service_com not like", value, "ssiExternalServiceCom");
            return (Criteria) this;
        }

        public Criteria andSsiExternalServiceComIn(List<String> values) {
            addCriterion("ssi_external_service_com in", values, "ssiExternalServiceCom");
            return (Criteria) this;
        }

        public Criteria andSsiExternalServiceComNotIn(List<String> values) {
            addCriterion("ssi_external_service_com not in", values, "ssiExternalServiceCom");
            return (Criteria) this;
        }

        public Criteria andSsiExternalServiceComBetween(String value1, String value2) {
            addCriterion("ssi_external_service_com between", value1, value2, "ssiExternalServiceCom");
            return (Criteria) this;
        }

        public Criteria andSsiExternalServiceComNotBetween(String value1, String value2) {
            addCriterion("ssi_external_service_com not between", value1, value2, "ssiExternalServiceCom");
            return (Criteria) this;
        }

        public Criteria andSsiExternalServicePerIsNull() {
            addCriterion("ssi_external_service_per is null");
            return (Criteria) this;
        }

        public Criteria andSsiExternalServicePerIsNotNull() {
            addCriterion("ssi_external_service_per is not null");
            return (Criteria) this;
        }

        public Criteria andSsiExternalServicePerEqualTo(String value) {
            addCriterion("ssi_external_service_per =", value, "ssiExternalServicePer");
            return (Criteria) this;
        }

        public Criteria andSsiExternalServicePerNotEqualTo(String value) {
            addCriterion("ssi_external_service_per <>", value, "ssiExternalServicePer");
            return (Criteria) this;
        }

        public Criteria andSsiExternalServicePerGreaterThan(String value) {
            addCriterion("ssi_external_service_per >", value, "ssiExternalServicePer");
            return (Criteria) this;
        }

        public Criteria andSsiExternalServicePerGreaterThanOrEqualTo(String value) {
            addCriterion("ssi_external_service_per >=", value, "ssiExternalServicePer");
            return (Criteria) this;
        }

        public Criteria andSsiExternalServicePerLessThan(String value) {
            addCriterion("ssi_external_service_per <", value, "ssiExternalServicePer");
            return (Criteria) this;
        }

        public Criteria andSsiExternalServicePerLessThanOrEqualTo(String value) {
            addCriterion("ssi_external_service_per <=", value, "ssiExternalServicePer");
            return (Criteria) this;
        }

        public Criteria andSsiExternalServicePerLike(String value) {
            addCriterion("ssi_external_service_per like", value, "ssiExternalServicePer");
            return (Criteria) this;
        }

        public Criteria andSsiExternalServicePerNotLike(String value) {
            addCriterion("ssi_external_service_per not like", value, "ssiExternalServicePer");
            return (Criteria) this;
        }

        public Criteria andSsiExternalServicePerIn(List<String> values) {
            addCriterion("ssi_external_service_per in", values, "ssiExternalServicePer");
            return (Criteria) this;
        }

        public Criteria andSsiExternalServicePerNotIn(List<String> values) {
            addCriterion("ssi_external_service_per not in", values, "ssiExternalServicePer");
            return (Criteria) this;
        }

        public Criteria andSsiExternalServicePerBetween(String value1, String value2) {
            addCriterion("ssi_external_service_per between", value1, value2, "ssiExternalServicePer");
            return (Criteria) this;
        }

        public Criteria andSsiExternalServicePerNotBetween(String value1, String value2) {
            addCriterion("ssi_external_service_per not between", value1, value2, "ssiExternalServicePer");
            return (Criteria) this;
        }

        public Criteria andSsiFatalIllIsNull() {
            addCriterion("ssi_fatal_ill is null");
            return (Criteria) this;
        }

        public Criteria andSsiFatalIllIsNotNull() {
            addCriterion("ssi_fatal_ill is not null");
            return (Criteria) this;
        }

        public Criteria andSsiFatalIllEqualTo(String value) {
            addCriterion("ssi_fatal_ill =", value, "ssiFatalIll");
            return (Criteria) this;
        }

        public Criteria andSsiFatalIllNotEqualTo(String value) {
            addCriterion("ssi_fatal_ill <>", value, "ssiFatalIll");
            return (Criteria) this;
        }

        public Criteria andSsiFatalIllGreaterThan(String value) {
            addCriterion("ssi_fatal_ill >", value, "ssiFatalIll");
            return (Criteria) this;
        }

        public Criteria andSsiFatalIllGreaterThanOrEqualTo(String value) {
            addCriterion("ssi_fatal_ill >=", value, "ssiFatalIll");
            return (Criteria) this;
        }

        public Criteria andSsiFatalIllLessThan(String value) {
            addCriterion("ssi_fatal_ill <", value, "ssiFatalIll");
            return (Criteria) this;
        }

        public Criteria andSsiFatalIllLessThanOrEqualTo(String value) {
            addCriterion("ssi_fatal_ill <=", value, "ssiFatalIll");
            return (Criteria) this;
        }

        public Criteria andSsiFatalIllLike(String value) {
            addCriterion("ssi_fatal_ill like", value, "ssiFatalIll");
            return (Criteria) this;
        }

        public Criteria andSsiFatalIllNotLike(String value) {
            addCriterion("ssi_fatal_ill not like", value, "ssiFatalIll");
            return (Criteria) this;
        }

        public Criteria andSsiFatalIllIn(List<String> values) {
            addCriterion("ssi_fatal_ill in", values, "ssiFatalIll");
            return (Criteria) this;
        }

        public Criteria andSsiFatalIllNotIn(List<String> values) {
            addCriterion("ssi_fatal_ill not in", values, "ssiFatalIll");
            return (Criteria) this;
        }

        public Criteria andSsiFatalIllBetween(String value1, String value2) {
            addCriterion("ssi_fatal_ill between", value1, value2, "ssiFatalIll");
            return (Criteria) this;
        }

        public Criteria andSsiFatalIllNotBetween(String value1, String value2) {
            addCriterion("ssi_fatal_ill not between", value1, value2, "ssiFatalIll");
            return (Criteria) this;
        }

        public Criteria andSsiFatalIllComIsNull() {
            addCriterion("ssi_fatal_ill_com is null");
            return (Criteria) this;
        }

        public Criteria andSsiFatalIllComIsNotNull() {
            addCriterion("ssi_fatal_ill_com is not null");
            return (Criteria) this;
        }

        public Criteria andSsiFatalIllComEqualTo(String value) {
            addCriterion("ssi_fatal_ill_com =", value, "ssiFatalIllCom");
            return (Criteria) this;
        }

        public Criteria andSsiFatalIllComNotEqualTo(String value) {
            addCriterion("ssi_fatal_ill_com <>", value, "ssiFatalIllCom");
            return (Criteria) this;
        }

        public Criteria andSsiFatalIllComGreaterThan(String value) {
            addCriterion("ssi_fatal_ill_com >", value, "ssiFatalIllCom");
            return (Criteria) this;
        }

        public Criteria andSsiFatalIllComGreaterThanOrEqualTo(String value) {
            addCriterion("ssi_fatal_ill_com >=", value, "ssiFatalIllCom");
            return (Criteria) this;
        }

        public Criteria andSsiFatalIllComLessThan(String value) {
            addCriterion("ssi_fatal_ill_com <", value, "ssiFatalIllCom");
            return (Criteria) this;
        }

        public Criteria andSsiFatalIllComLessThanOrEqualTo(String value) {
            addCriterion("ssi_fatal_ill_com <=", value, "ssiFatalIllCom");
            return (Criteria) this;
        }

        public Criteria andSsiFatalIllComLike(String value) {
            addCriterion("ssi_fatal_ill_com like", value, "ssiFatalIllCom");
            return (Criteria) this;
        }

        public Criteria andSsiFatalIllComNotLike(String value) {
            addCriterion("ssi_fatal_ill_com not like", value, "ssiFatalIllCom");
            return (Criteria) this;
        }

        public Criteria andSsiFatalIllComIn(List<String> values) {
            addCriterion("ssi_fatal_ill_com in", values, "ssiFatalIllCom");
            return (Criteria) this;
        }

        public Criteria andSsiFatalIllComNotIn(List<String> values) {
            addCriterion("ssi_fatal_ill_com not in", values, "ssiFatalIllCom");
            return (Criteria) this;
        }

        public Criteria andSsiFatalIllComBetween(String value1, String value2) {
            addCriterion("ssi_fatal_ill_com between", value1, value2, "ssiFatalIllCom");
            return (Criteria) this;
        }

        public Criteria andSsiFatalIllComNotBetween(String value1, String value2) {
            addCriterion("ssi_fatal_ill_com not between", value1, value2, "ssiFatalIllCom");
            return (Criteria) this;
        }

        public Criteria andSsiFatalIllPerIsNull() {
            addCriterion("ssi_fatal_ill_per is null");
            return (Criteria) this;
        }

        public Criteria andSsiFatalIllPerIsNotNull() {
            addCriterion("ssi_fatal_ill_per is not null");
            return (Criteria) this;
        }

        public Criteria andSsiFatalIllPerEqualTo(String value) {
            addCriterion("ssi_fatal_ill_per =", value, "ssiFatalIllPer");
            return (Criteria) this;
        }

        public Criteria andSsiFatalIllPerNotEqualTo(String value) {
            addCriterion("ssi_fatal_ill_per <>", value, "ssiFatalIllPer");
            return (Criteria) this;
        }

        public Criteria andSsiFatalIllPerGreaterThan(String value) {
            addCriterion("ssi_fatal_ill_per >", value, "ssiFatalIllPer");
            return (Criteria) this;
        }

        public Criteria andSsiFatalIllPerGreaterThanOrEqualTo(String value) {
            addCriterion("ssi_fatal_ill_per >=", value, "ssiFatalIllPer");
            return (Criteria) this;
        }

        public Criteria andSsiFatalIllPerLessThan(String value) {
            addCriterion("ssi_fatal_ill_per <", value, "ssiFatalIllPer");
            return (Criteria) this;
        }

        public Criteria andSsiFatalIllPerLessThanOrEqualTo(String value) {
            addCriterion("ssi_fatal_ill_per <=", value, "ssiFatalIllPer");
            return (Criteria) this;
        }

        public Criteria andSsiFatalIllPerLike(String value) {
            addCriterion("ssi_fatal_ill_per like", value, "ssiFatalIllPer");
            return (Criteria) this;
        }

        public Criteria andSsiFatalIllPerNotLike(String value) {
            addCriterion("ssi_fatal_ill_per not like", value, "ssiFatalIllPer");
            return (Criteria) this;
        }

        public Criteria andSsiFatalIllPerIn(List<String> values) {
            addCriterion("ssi_fatal_ill_per in", values, "ssiFatalIllPer");
            return (Criteria) this;
        }

        public Criteria andSsiFatalIllPerNotIn(List<String> values) {
            addCriterion("ssi_fatal_ill_per not in", values, "ssiFatalIllPer");
            return (Criteria) this;
        }

        public Criteria andSsiFatalIllPerBetween(String value1, String value2) {
            addCriterion("ssi_fatal_ill_per between", value1, value2, "ssiFatalIllPer");
            return (Criteria) this;
        }

        public Criteria andSsiFatalIllPerNotBetween(String value1, String value2) {
            addCriterion("ssi_fatal_ill_per not between", value1, value2, "ssiFatalIllPer");
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