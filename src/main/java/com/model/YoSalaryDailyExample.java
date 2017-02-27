package com.model;

import java.util.ArrayList;
import java.util.List;

public class YoSalaryDailyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public YoSalaryDailyExample() {
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

        public Criteria andSeqNoIsNull() {
            addCriterion("seq_no is null");
            return (Criteria) this;
        }

        public Criteria andSeqNoIsNotNull() {
            addCriterion("seq_no is not null");
            return (Criteria) this;
        }

        public Criteria andSeqNoEqualTo(Integer value) {
            addCriterion("seq_no =", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoNotEqualTo(Integer value) {
            addCriterion("seq_no <>", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoGreaterThan(Integer value) {
            addCriterion("seq_no >", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("seq_no >=", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoLessThan(Integer value) {
            addCriterion("seq_no <", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoLessThanOrEqualTo(Integer value) {
            addCriterion("seq_no <=", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoIn(List<Integer> values) {
            addCriterion("seq_no in", values, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoNotIn(List<Integer> values) {
            addCriterion("seq_no not in", values, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoBetween(Integer value1, Integer value2) {
            addCriterion("seq_no between", value1, value2, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoNotBetween(Integer value1, Integer value2) {
            addCriterion("seq_no not between", value1, value2, "seqNo");
            return (Criteria) this;
        }

        public Criteria andStaffidIsNull() {
            addCriterion("staffid is null");
            return (Criteria) this;
        }

        public Criteria andStaffidIsNotNull() {
            addCriterion("staffid is not null");
            return (Criteria) this;
        }

        public Criteria andStaffidEqualTo(String value) {
            addCriterion("staffid =", value, "staffid");
            return (Criteria) this;
        }

        public Criteria andStaffidNotEqualTo(String value) {
            addCriterion("staffid <>", value, "staffid");
            return (Criteria) this;
        }

        public Criteria andStaffidGreaterThan(String value) {
            addCriterion("staffid >", value, "staffid");
            return (Criteria) this;
        }

        public Criteria andStaffidGreaterThanOrEqualTo(String value) {
            addCriterion("staffid >=", value, "staffid");
            return (Criteria) this;
        }

        public Criteria andStaffidLessThan(String value) {
            addCriterion("staffid <", value, "staffid");
            return (Criteria) this;
        }

        public Criteria andStaffidLessThanOrEqualTo(String value) {
            addCriterion("staffid <=", value, "staffid");
            return (Criteria) this;
        }

        public Criteria andStaffidLike(String value) {
            addCriterion("staffid like", value, "staffid");
            return (Criteria) this;
        }

        public Criteria andStaffidNotLike(String value) {
            addCriterion("staffid not like", value, "staffid");
            return (Criteria) this;
        }

        public Criteria andStaffidIn(List<String> values) {
            addCriterion("staffid in", values, "staffid");
            return (Criteria) this;
        }

        public Criteria andStaffidNotIn(List<String> values) {
            addCriterion("staffid not in", values, "staffid");
            return (Criteria) this;
        }

        public Criteria andStaffidBetween(String value1, String value2) {
            addCriterion("staffid between", value1, value2, "staffid");
            return (Criteria) this;
        }

        public Criteria andStaffidNotBetween(String value1, String value2) {
            addCriterion("staffid not between", value1, value2, "staffid");
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

        public Criteria andContractTypeIsNull() {
            addCriterion("contract_type is null");
            return (Criteria) this;
        }

        public Criteria andContractTypeIsNotNull() {
            addCriterion("contract_type is not null");
            return (Criteria) this;
        }

        public Criteria andContractTypeEqualTo(String value) {
            addCriterion("contract_type =", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeNotEqualTo(String value) {
            addCriterion("contract_type <>", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeGreaterThan(String value) {
            addCriterion("contract_type >", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeGreaterThanOrEqualTo(String value) {
            addCriterion("contract_type >=", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeLessThan(String value) {
            addCriterion("contract_type <", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeLessThanOrEqualTo(String value) {
            addCriterion("contract_type <=", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeLike(String value) {
            addCriterion("contract_type like", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeNotLike(String value) {
            addCriterion("contract_type not like", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeIn(List<String> values) {
            addCriterion("contract_type in", values, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeNotIn(List<String> values) {
            addCriterion("contract_type not in", values, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeBetween(String value1, String value2) {
            addCriterion("contract_type between", value1, value2, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeNotBetween(String value1, String value2) {
            addCriterion("contract_type not between", value1, value2, "contractType");
            return (Criteria) this;
        }

        public Criteria andOrdinaryAddressIsNull() {
            addCriterion("ordinary_address is null");
            return (Criteria) this;
        }

        public Criteria andOrdinaryAddressIsNotNull() {
            addCriterion("ordinary_address is not null");
            return (Criteria) this;
        }

        public Criteria andOrdinaryAddressEqualTo(String value) {
            addCriterion("ordinary_address =", value, "ordinaryAddress");
            return (Criteria) this;
        }

        public Criteria andOrdinaryAddressNotEqualTo(String value) {
            addCriterion("ordinary_address <>", value, "ordinaryAddress");
            return (Criteria) this;
        }

        public Criteria andOrdinaryAddressGreaterThan(String value) {
            addCriterion("ordinary_address >", value, "ordinaryAddress");
            return (Criteria) this;
        }

        public Criteria andOrdinaryAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ordinary_address >=", value, "ordinaryAddress");
            return (Criteria) this;
        }

        public Criteria andOrdinaryAddressLessThan(String value) {
            addCriterion("ordinary_address <", value, "ordinaryAddress");
            return (Criteria) this;
        }

        public Criteria andOrdinaryAddressLessThanOrEqualTo(String value) {
            addCriterion("ordinary_address <=", value, "ordinaryAddress");
            return (Criteria) this;
        }

        public Criteria andOrdinaryAddressLike(String value) {
            addCriterion("ordinary_address like", value, "ordinaryAddress");
            return (Criteria) this;
        }

        public Criteria andOrdinaryAddressNotLike(String value) {
            addCriterion("ordinary_address not like", value, "ordinaryAddress");
            return (Criteria) this;
        }

        public Criteria andOrdinaryAddressIn(List<String> values) {
            addCriterion("ordinary_address in", values, "ordinaryAddress");
            return (Criteria) this;
        }

        public Criteria andOrdinaryAddressNotIn(List<String> values) {
            addCriterion("ordinary_address not in", values, "ordinaryAddress");
            return (Criteria) this;
        }

        public Criteria andOrdinaryAddressBetween(String value1, String value2) {
            addCriterion("ordinary_address between", value1, value2, "ordinaryAddress");
            return (Criteria) this;
        }

        public Criteria andOrdinaryAddressNotBetween(String value1, String value2) {
            addCriterion("ordinary_address not between", value1, value2, "ordinaryAddress");
            return (Criteria) this;
        }

        public Criteria andWhetherBtAllowanceIsNull() {
            addCriterion("whether_bt_allowance is null");
            return (Criteria) this;
        }

        public Criteria andWhetherBtAllowanceIsNotNull() {
            addCriterion("whether_bt_allowance is not null");
            return (Criteria) this;
        }

        public Criteria andWhetherBtAllowanceEqualTo(String value) {
            addCriterion("whether_bt_allowance =", value, "whetherBtAllowance");
            return (Criteria) this;
        }

        public Criteria andWhetherBtAllowanceNotEqualTo(String value) {
            addCriterion("whether_bt_allowance <>", value, "whetherBtAllowance");
            return (Criteria) this;
        }

        public Criteria andWhetherBtAllowanceGreaterThan(String value) {
            addCriterion("whether_bt_allowance >", value, "whetherBtAllowance");
            return (Criteria) this;
        }

        public Criteria andWhetherBtAllowanceGreaterThanOrEqualTo(String value) {
            addCriterion("whether_bt_allowance >=", value, "whetherBtAllowance");
            return (Criteria) this;
        }

        public Criteria andWhetherBtAllowanceLessThan(String value) {
            addCriterion("whether_bt_allowance <", value, "whetherBtAllowance");
            return (Criteria) this;
        }

        public Criteria andWhetherBtAllowanceLessThanOrEqualTo(String value) {
            addCriterion("whether_bt_allowance <=", value, "whetherBtAllowance");
            return (Criteria) this;
        }

        public Criteria andWhetherBtAllowanceLike(String value) {
            addCriterion("whether_bt_allowance like", value, "whetherBtAllowance");
            return (Criteria) this;
        }

        public Criteria andWhetherBtAllowanceNotLike(String value) {
            addCriterion("whether_bt_allowance not like", value, "whetherBtAllowance");
            return (Criteria) this;
        }

        public Criteria andWhetherBtAllowanceIn(List<String> values) {
            addCriterion("whether_bt_allowance in", values, "whetherBtAllowance");
            return (Criteria) this;
        }

        public Criteria andWhetherBtAllowanceNotIn(List<String> values) {
            addCriterion("whether_bt_allowance not in", values, "whetherBtAllowance");
            return (Criteria) this;
        }

        public Criteria andWhetherBtAllowanceBetween(String value1, String value2) {
            addCriterion("whether_bt_allowance between", value1, value2, "whetherBtAllowance");
            return (Criteria) this;
        }

        public Criteria andWhetherBtAllowanceNotBetween(String value1, String value2) {
            addCriterion("whether_bt_allowance not between", value1, value2, "whetherBtAllowance");
            return (Criteria) this;
        }

        public Criteria andBaseSalaryIsNull() {
            addCriterion("base_salary is null");
            return (Criteria) this;
        }

        public Criteria andBaseSalaryIsNotNull() {
            addCriterion("base_salary is not null");
            return (Criteria) this;
        }

        public Criteria andBaseSalaryEqualTo(String value) {
            addCriterion("base_salary =", value, "baseSalary");
            return (Criteria) this;
        }

        public Criteria andBaseSalaryNotEqualTo(String value) {
            addCriterion("base_salary <>", value, "baseSalary");
            return (Criteria) this;
        }

        public Criteria andBaseSalaryGreaterThan(String value) {
            addCriterion("base_salary >", value, "baseSalary");
            return (Criteria) this;
        }

        public Criteria andBaseSalaryGreaterThanOrEqualTo(String value) {
            addCriterion("base_salary >=", value, "baseSalary");
            return (Criteria) this;
        }

        public Criteria andBaseSalaryLessThan(String value) {
            addCriterion("base_salary <", value, "baseSalary");
            return (Criteria) this;
        }

        public Criteria andBaseSalaryLessThanOrEqualTo(String value) {
            addCriterion("base_salary <=", value, "baseSalary");
            return (Criteria) this;
        }

        public Criteria andBaseSalaryLike(String value) {
            addCriterion("base_salary like", value, "baseSalary");
            return (Criteria) this;
        }

        public Criteria andBaseSalaryNotLike(String value) {
            addCriterion("base_salary not like", value, "baseSalary");
            return (Criteria) this;
        }

        public Criteria andBaseSalaryIn(List<String> values) {
            addCriterion("base_salary in", values, "baseSalary");
            return (Criteria) this;
        }

        public Criteria andBaseSalaryNotIn(List<String> values) {
            addCriterion("base_salary not in", values, "baseSalary");
            return (Criteria) this;
        }

        public Criteria andBaseSalaryBetween(String value1, String value2) {
            addCriterion("base_salary between", value1, value2, "baseSalary");
            return (Criteria) this;
        }

        public Criteria andBaseSalaryNotBetween(String value1, String value2) {
            addCriterion("base_salary not between", value1, value2, "baseSalary");
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

        public Criteria andDateEqualTo(String value) {
            addCriterion("date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(String value) {
            addCriterion("date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(String value) {
            addCriterion("date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(String value) {
            addCriterion("date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(String value) {
            addCriterion("date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(String value) {
            addCriterion("date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLike(String value) {
            addCriterion("date like", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotLike(String value) {
            addCriterion("date not like", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<String> values) {
            addCriterion("date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<String> values) {
            addCriterion("date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(String value1, String value2) {
            addCriterion("date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(String value1, String value2) {
            addCriterion("date not between", value1, value2, "date");
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

        public Criteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("order_no =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("order_no <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("order_no >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("order_no >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("order_no <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("order_no <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("order_no like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("order_no not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("order_no in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrdDepartIsNull() {
            addCriterion("ord_depart is null");
            return (Criteria) this;
        }

        public Criteria andOrdDepartIsNotNull() {
            addCriterion("ord_depart is not null");
            return (Criteria) this;
        }

        public Criteria andOrdDepartEqualTo(String value) {
            addCriterion("ord_depart =", value, "ordDepart");
            return (Criteria) this;
        }

        public Criteria andOrdDepartNotEqualTo(String value) {
            addCriterion("ord_depart <>", value, "ordDepart");
            return (Criteria) this;
        }

        public Criteria andOrdDepartGreaterThan(String value) {
            addCriterion("ord_depart >", value, "ordDepart");
            return (Criteria) this;
        }

        public Criteria andOrdDepartGreaterThanOrEqualTo(String value) {
            addCriterion("ord_depart >=", value, "ordDepart");
            return (Criteria) this;
        }

        public Criteria andOrdDepartLessThan(String value) {
            addCriterion("ord_depart <", value, "ordDepart");
            return (Criteria) this;
        }

        public Criteria andOrdDepartLessThanOrEqualTo(String value) {
            addCriterion("ord_depart <=", value, "ordDepart");
            return (Criteria) this;
        }

        public Criteria andOrdDepartLike(String value) {
            addCriterion("ord_depart like", value, "ordDepart");
            return (Criteria) this;
        }

        public Criteria andOrdDepartNotLike(String value) {
            addCriterion("ord_depart not like", value, "ordDepart");
            return (Criteria) this;
        }

        public Criteria andOrdDepartIn(List<String> values) {
            addCriterion("ord_depart in", values, "ordDepart");
            return (Criteria) this;
        }

        public Criteria andOrdDepartNotIn(List<String> values) {
            addCriterion("ord_depart not in", values, "ordDepart");
            return (Criteria) this;
        }

        public Criteria andOrdDepartBetween(String value1, String value2) {
            addCriterion("ord_depart between", value1, value2, "ordDepart");
            return (Criteria) this;
        }

        public Criteria andOrdDepartNotBetween(String value1, String value2) {
            addCriterion("ord_depart not between", value1, value2, "ordDepart");
            return (Criteria) this;
        }

        public Criteria andProjectIsNull() {
            addCriterion("project is null");
            return (Criteria) this;
        }

        public Criteria andProjectIsNotNull() {
            addCriterion("project is not null");
            return (Criteria) this;
        }

        public Criteria andProjectEqualTo(String value) {
            addCriterion("project =", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotEqualTo(String value) {
            addCriterion("project <>", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectGreaterThan(String value) {
            addCriterion("project >", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectGreaterThanOrEqualTo(String value) {
            addCriterion("project >=", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectLessThan(String value) {
            addCriterion("project <", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectLessThanOrEqualTo(String value) {
            addCriterion("project <=", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectLike(String value) {
            addCriterion("project like", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotLike(String value) {
            addCriterion("project not like", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectIn(List<String> values) {
            addCriterion("project in", values, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotIn(List<String> values) {
            addCriterion("project not in", values, "project");
            return (Criteria) this;
        }

        public Criteria andProjectBetween(String value1, String value2) {
            addCriterion("project between", value1, value2, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotBetween(String value1, String value2) {
            addCriterion("project not between", value1, value2, "project");
            return (Criteria) this;
        }

        public Criteria andOrderNameIsNull() {
            addCriterion("order_name is null");
            return (Criteria) this;
        }

        public Criteria andOrderNameIsNotNull() {
            addCriterion("order_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNameEqualTo(String value) {
            addCriterion("order_name =", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameNotEqualTo(String value) {
            addCriterion("order_name <>", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameGreaterThan(String value) {
            addCriterion("order_name >", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameGreaterThanOrEqualTo(String value) {
            addCriterion("order_name >=", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameLessThan(String value) {
            addCriterion("order_name <", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameLessThanOrEqualTo(String value) {
            addCriterion("order_name <=", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameLike(String value) {
            addCriterion("order_name like", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameNotLike(String value) {
            addCriterion("order_name not like", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameIn(List<String> values) {
            addCriterion("order_name in", values, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameNotIn(List<String> values) {
            addCriterion("order_name not in", values, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameBetween(String value1, String value2) {
            addCriterion("order_name between", value1, value2, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameNotBetween(String value1, String value2) {
            addCriterion("order_name not between", value1, value2, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderProcityIsNull() {
            addCriterion("order_procity is null");
            return (Criteria) this;
        }

        public Criteria andOrderProcityIsNotNull() {
            addCriterion("order_procity is not null");
            return (Criteria) this;
        }

        public Criteria andOrderProcityEqualTo(String value) {
            addCriterion("order_procity =", value, "orderProcity");
            return (Criteria) this;
        }

        public Criteria andOrderProcityNotEqualTo(String value) {
            addCriterion("order_procity <>", value, "orderProcity");
            return (Criteria) this;
        }

        public Criteria andOrderProcityGreaterThan(String value) {
            addCriterion("order_procity >", value, "orderProcity");
            return (Criteria) this;
        }

        public Criteria andOrderProcityGreaterThanOrEqualTo(String value) {
            addCriterion("order_procity >=", value, "orderProcity");
            return (Criteria) this;
        }

        public Criteria andOrderProcityLessThan(String value) {
            addCriterion("order_procity <", value, "orderProcity");
            return (Criteria) this;
        }

        public Criteria andOrderProcityLessThanOrEqualTo(String value) {
            addCriterion("order_procity <=", value, "orderProcity");
            return (Criteria) this;
        }

        public Criteria andOrderProcityLike(String value) {
            addCriterion("order_procity like", value, "orderProcity");
            return (Criteria) this;
        }

        public Criteria andOrderProcityNotLike(String value) {
            addCriterion("order_procity not like", value, "orderProcity");
            return (Criteria) this;
        }

        public Criteria andOrderProcityIn(List<String> values) {
            addCriterion("order_procity in", values, "orderProcity");
            return (Criteria) this;
        }

        public Criteria andOrderProcityNotIn(List<String> values) {
            addCriterion("order_procity not in", values, "orderProcity");
            return (Criteria) this;
        }

        public Criteria andOrderProcityBetween(String value1, String value2) {
            addCriterion("order_procity between", value1, value2, "orderProcity");
            return (Criteria) this;
        }

        public Criteria andOrderProcityNotBetween(String value1, String value2) {
            addCriterion("order_procity not between", value1, value2, "orderProcity");
            return (Criteria) this;
        }

        public Criteria andBusinessAttributeIsNull() {
            addCriterion("business_attribute is null");
            return (Criteria) this;
        }

        public Criteria andBusinessAttributeIsNotNull() {
            addCriterion("business_attribute is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessAttributeEqualTo(String value) {
            addCriterion("business_attribute =", value, "businessAttribute");
            return (Criteria) this;
        }

        public Criteria andBusinessAttributeNotEqualTo(String value) {
            addCriterion("business_attribute <>", value, "businessAttribute");
            return (Criteria) this;
        }

        public Criteria andBusinessAttributeGreaterThan(String value) {
            addCriterion("business_attribute >", value, "businessAttribute");
            return (Criteria) this;
        }

        public Criteria andBusinessAttributeGreaterThanOrEqualTo(String value) {
            addCriterion("business_attribute >=", value, "businessAttribute");
            return (Criteria) this;
        }

        public Criteria andBusinessAttributeLessThan(String value) {
            addCriterion("business_attribute <", value, "businessAttribute");
            return (Criteria) this;
        }

        public Criteria andBusinessAttributeLessThanOrEqualTo(String value) {
            addCriterion("business_attribute <=", value, "businessAttribute");
            return (Criteria) this;
        }

        public Criteria andBusinessAttributeLike(String value) {
            addCriterion("business_attribute like", value, "businessAttribute");
            return (Criteria) this;
        }

        public Criteria andBusinessAttributeNotLike(String value) {
            addCriterion("business_attribute not like", value, "businessAttribute");
            return (Criteria) this;
        }

        public Criteria andBusinessAttributeIn(List<String> values) {
            addCriterion("business_attribute in", values, "businessAttribute");
            return (Criteria) this;
        }

        public Criteria andBusinessAttributeNotIn(List<String> values) {
            addCriterion("business_attribute not in", values, "businessAttribute");
            return (Criteria) this;
        }

        public Criteria andBusinessAttributeBetween(String value1, String value2) {
            addCriterion("business_attribute between", value1, value2, "businessAttribute");
            return (Criteria) this;
        }

        public Criteria andBusinessAttributeNotBetween(String value1, String value2) {
            addCriterion("business_attribute not between", value1, value2, "businessAttribute");
            return (Criteria) this;
        }

        public Criteria andBusinessLevelIsNull() {
            addCriterion("business_level is null");
            return (Criteria) this;
        }

        public Criteria andBusinessLevelIsNotNull() {
            addCriterion("business_level is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessLevelEqualTo(String value) {
            addCriterion("business_level =", value, "businessLevel");
            return (Criteria) this;
        }

        public Criteria andBusinessLevelNotEqualTo(String value) {
            addCriterion("business_level <>", value, "businessLevel");
            return (Criteria) this;
        }

        public Criteria andBusinessLevelGreaterThan(String value) {
            addCriterion("business_level >", value, "businessLevel");
            return (Criteria) this;
        }

        public Criteria andBusinessLevelGreaterThanOrEqualTo(String value) {
            addCriterion("business_level >=", value, "businessLevel");
            return (Criteria) this;
        }

        public Criteria andBusinessLevelLessThan(String value) {
            addCriterion("business_level <", value, "businessLevel");
            return (Criteria) this;
        }

        public Criteria andBusinessLevelLessThanOrEqualTo(String value) {
            addCriterion("business_level <=", value, "businessLevel");
            return (Criteria) this;
        }

        public Criteria andBusinessLevelLike(String value) {
            addCriterion("business_level like", value, "businessLevel");
            return (Criteria) this;
        }

        public Criteria andBusinessLevelNotLike(String value) {
            addCriterion("business_level not like", value, "businessLevel");
            return (Criteria) this;
        }

        public Criteria andBusinessLevelIn(List<String> values) {
            addCriterion("business_level in", values, "businessLevel");
            return (Criteria) this;
        }

        public Criteria andBusinessLevelNotIn(List<String> values) {
            addCriterion("business_level not in", values, "businessLevel");
            return (Criteria) this;
        }

        public Criteria andBusinessLevelBetween(String value1, String value2) {
            addCriterion("business_level between", value1, value2, "businessLevel");
            return (Criteria) this;
        }

        public Criteria andBusinessLevelNotBetween(String value1, String value2) {
            addCriterion("business_level not between", value1, value2, "businessLevel");
            return (Criteria) this;
        }

        public Criteria andOutdoorWorkIsNull() {
            addCriterion("outdoor_work is null");
            return (Criteria) this;
        }

        public Criteria andOutdoorWorkIsNotNull() {
            addCriterion("outdoor_work is not null");
            return (Criteria) this;
        }

        public Criteria andOutdoorWorkEqualTo(String value) {
            addCriterion("outdoor_work =", value, "outdoorWork");
            return (Criteria) this;
        }

        public Criteria andOutdoorWorkNotEqualTo(String value) {
            addCriterion("outdoor_work <>", value, "outdoorWork");
            return (Criteria) this;
        }

        public Criteria andOutdoorWorkGreaterThan(String value) {
            addCriterion("outdoor_work >", value, "outdoorWork");
            return (Criteria) this;
        }

        public Criteria andOutdoorWorkGreaterThanOrEqualTo(String value) {
            addCriterion("outdoor_work >=", value, "outdoorWork");
            return (Criteria) this;
        }

        public Criteria andOutdoorWorkLessThan(String value) {
            addCriterion("outdoor_work <", value, "outdoorWork");
            return (Criteria) this;
        }

        public Criteria andOutdoorWorkLessThanOrEqualTo(String value) {
            addCriterion("outdoor_work <=", value, "outdoorWork");
            return (Criteria) this;
        }

        public Criteria andOutdoorWorkLike(String value) {
            addCriterion("outdoor_work like", value, "outdoorWork");
            return (Criteria) this;
        }

        public Criteria andOutdoorWorkNotLike(String value) {
            addCriterion("outdoor_work not like", value, "outdoorWork");
            return (Criteria) this;
        }

        public Criteria andOutdoorWorkIn(List<String> values) {
            addCriterion("outdoor_work in", values, "outdoorWork");
            return (Criteria) this;
        }

        public Criteria andOutdoorWorkNotIn(List<String> values) {
            addCriterion("outdoor_work not in", values, "outdoorWork");
            return (Criteria) this;
        }

        public Criteria andOutdoorWorkBetween(String value1, String value2) {
            addCriterion("outdoor_work between", value1, value2, "outdoorWork");
            return (Criteria) this;
        }

        public Criteria andOutdoorWorkNotBetween(String value1, String value2) {
            addCriterion("outdoor_work not between", value1, value2, "outdoorWork");
            return (Criteria) this;
        }

        public Criteria andWhetherAttIsNull() {
            addCriterion("whether_att is null");
            return (Criteria) this;
        }

        public Criteria andWhetherAttIsNotNull() {
            addCriterion("whether_att is not null");
            return (Criteria) this;
        }

        public Criteria andWhetherAttEqualTo(String value) {
            addCriterion("whether_att =", value, "whetherAtt");
            return (Criteria) this;
        }

        public Criteria andWhetherAttNotEqualTo(String value) {
            addCriterion("whether_att <>", value, "whetherAtt");
            return (Criteria) this;
        }

        public Criteria andWhetherAttGreaterThan(String value) {
            addCriterion("whether_att >", value, "whetherAtt");
            return (Criteria) this;
        }

        public Criteria andWhetherAttGreaterThanOrEqualTo(String value) {
            addCriterion("whether_att >=", value, "whetherAtt");
            return (Criteria) this;
        }

        public Criteria andWhetherAttLessThan(String value) {
            addCriterion("whether_att <", value, "whetherAtt");
            return (Criteria) this;
        }

        public Criteria andWhetherAttLessThanOrEqualTo(String value) {
            addCriterion("whether_att <=", value, "whetherAtt");
            return (Criteria) this;
        }

        public Criteria andWhetherAttLike(String value) {
            addCriterion("whether_att like", value, "whetherAtt");
            return (Criteria) this;
        }

        public Criteria andWhetherAttNotLike(String value) {
            addCriterion("whether_att not like", value, "whetherAtt");
            return (Criteria) this;
        }

        public Criteria andWhetherAttIn(List<String> values) {
            addCriterion("whether_att in", values, "whetherAtt");
            return (Criteria) this;
        }

        public Criteria andWhetherAttNotIn(List<String> values) {
            addCriterion("whether_att not in", values, "whetherAtt");
            return (Criteria) this;
        }

        public Criteria andWhetherAttBetween(String value1, String value2) {
            addCriterion("whether_att between", value1, value2, "whetherAtt");
            return (Criteria) this;
        }

        public Criteria andWhetherAttNotBetween(String value1, String value2) {
            addCriterion("whether_att not between", value1, value2, "whetherAtt");
            return (Criteria) this;
        }

        public Criteria andAttProcityIsNull() {
            addCriterion("att_procity is null");
            return (Criteria) this;
        }

        public Criteria andAttProcityIsNotNull() {
            addCriterion("att_procity is not null");
            return (Criteria) this;
        }

        public Criteria andAttProcityEqualTo(String value) {
            addCriterion("att_procity =", value, "attProcity");
            return (Criteria) this;
        }

        public Criteria andAttProcityNotEqualTo(String value) {
            addCriterion("att_procity <>", value, "attProcity");
            return (Criteria) this;
        }

        public Criteria andAttProcityGreaterThan(String value) {
            addCriterion("att_procity >", value, "attProcity");
            return (Criteria) this;
        }

        public Criteria andAttProcityGreaterThanOrEqualTo(String value) {
            addCriterion("att_procity >=", value, "attProcity");
            return (Criteria) this;
        }

        public Criteria andAttProcityLessThan(String value) {
            addCriterion("att_procity <", value, "attProcity");
            return (Criteria) this;
        }

        public Criteria andAttProcityLessThanOrEqualTo(String value) {
            addCriterion("att_procity <=", value, "attProcity");
            return (Criteria) this;
        }

        public Criteria andAttProcityLike(String value) {
            addCriterion("att_procity like", value, "attProcity");
            return (Criteria) this;
        }

        public Criteria andAttProcityNotLike(String value) {
            addCriterion("att_procity not like", value, "attProcity");
            return (Criteria) this;
        }

        public Criteria andAttProcityIn(List<String> values) {
            addCriterion("att_procity in", values, "attProcity");
            return (Criteria) this;
        }

        public Criteria andAttProcityNotIn(List<String> values) {
            addCriterion("att_procity not in", values, "attProcity");
            return (Criteria) this;
        }

        public Criteria andAttProcityBetween(String value1, String value2) {
            addCriterion("att_procity between", value1, value2, "attProcity");
            return (Criteria) this;
        }

        public Criteria andAttProcityNotBetween(String value1, String value2) {
            addCriterion("att_procity not between", value1, value2, "attProcity");
            return (Criteria) this;
        }

        public Criteria andAttTypeIsNull() {
            addCriterion("att_type is null");
            return (Criteria) this;
        }

        public Criteria andAttTypeIsNotNull() {
            addCriterion("att_type is not null");
            return (Criteria) this;
        }

        public Criteria andAttTypeEqualTo(String value) {
            addCriterion("att_type =", value, "attType");
            return (Criteria) this;
        }

        public Criteria andAttTypeNotEqualTo(String value) {
            addCriterion("att_type <>", value, "attType");
            return (Criteria) this;
        }

        public Criteria andAttTypeGreaterThan(String value) {
            addCriterion("att_type >", value, "attType");
            return (Criteria) this;
        }

        public Criteria andAttTypeGreaterThanOrEqualTo(String value) {
            addCriterion("att_type >=", value, "attType");
            return (Criteria) this;
        }

        public Criteria andAttTypeLessThan(String value) {
            addCriterion("att_type <", value, "attType");
            return (Criteria) this;
        }

        public Criteria andAttTypeLessThanOrEqualTo(String value) {
            addCriterion("att_type <=", value, "attType");
            return (Criteria) this;
        }

        public Criteria andAttTypeLike(String value) {
            addCriterion("att_type like", value, "attType");
            return (Criteria) this;
        }

        public Criteria andAttTypeNotLike(String value) {
            addCriterion("att_type not like", value, "attType");
            return (Criteria) this;
        }

        public Criteria andAttTypeIn(List<String> values) {
            addCriterion("att_type in", values, "attType");
            return (Criteria) this;
        }

        public Criteria andAttTypeNotIn(List<String> values) {
            addCriterion("att_type not in", values, "attType");
            return (Criteria) this;
        }

        public Criteria andAttTypeBetween(String value1, String value2) {
            addCriterion("att_type between", value1, value2, "attType");
            return (Criteria) this;
        }

        public Criteria andAttTypeNotBetween(String value1, String value2) {
            addCriterion("att_type not between", value1, value2, "attType");
            return (Criteria) this;
        }

        public Criteria andWhetherSignIsNull() {
            addCriterion("whether_sign is null");
            return (Criteria) this;
        }

        public Criteria andWhetherSignIsNotNull() {
            addCriterion("whether_sign is not null");
            return (Criteria) this;
        }

        public Criteria andWhetherSignEqualTo(String value) {
            addCriterion("whether_sign =", value, "whetherSign");
            return (Criteria) this;
        }

        public Criteria andWhetherSignNotEqualTo(String value) {
            addCriterion("whether_sign <>", value, "whetherSign");
            return (Criteria) this;
        }

        public Criteria andWhetherSignGreaterThan(String value) {
            addCriterion("whether_sign >", value, "whetherSign");
            return (Criteria) this;
        }

        public Criteria andWhetherSignGreaterThanOrEqualTo(String value) {
            addCriterion("whether_sign >=", value, "whetherSign");
            return (Criteria) this;
        }

        public Criteria andWhetherSignLessThan(String value) {
            addCriterion("whether_sign <", value, "whetherSign");
            return (Criteria) this;
        }

        public Criteria andWhetherSignLessThanOrEqualTo(String value) {
            addCriterion("whether_sign <=", value, "whetherSign");
            return (Criteria) this;
        }

        public Criteria andWhetherSignLike(String value) {
            addCriterion("whether_sign like", value, "whetherSign");
            return (Criteria) this;
        }

        public Criteria andWhetherSignNotLike(String value) {
            addCriterion("whether_sign not like", value, "whetherSign");
            return (Criteria) this;
        }

        public Criteria andWhetherSignIn(List<String> values) {
            addCriterion("whether_sign in", values, "whetherSign");
            return (Criteria) this;
        }

        public Criteria andWhetherSignNotIn(List<String> values) {
            addCriterion("whether_sign not in", values, "whetherSign");
            return (Criteria) this;
        }

        public Criteria andWhetherSignBetween(String value1, String value2) {
            addCriterion("whether_sign between", value1, value2, "whetherSign");
            return (Criteria) this;
        }

        public Criteria andWhetherSignNotBetween(String value1, String value2) {
            addCriterion("whether_sign not between", value1, value2, "whetherSign");
            return (Criteria) this;
        }

        public Criteria andSignProcityIsNull() {
            addCriterion("sign_procity is null");
            return (Criteria) this;
        }

        public Criteria andSignProcityIsNotNull() {
            addCriterion("sign_procity is not null");
            return (Criteria) this;
        }

        public Criteria andSignProcityEqualTo(String value) {
            addCriterion("sign_procity =", value, "signProcity");
            return (Criteria) this;
        }

        public Criteria andSignProcityNotEqualTo(String value) {
            addCriterion("sign_procity <>", value, "signProcity");
            return (Criteria) this;
        }

        public Criteria andSignProcityGreaterThan(String value) {
            addCriterion("sign_procity >", value, "signProcity");
            return (Criteria) this;
        }

        public Criteria andSignProcityGreaterThanOrEqualTo(String value) {
            addCriterion("sign_procity >=", value, "signProcity");
            return (Criteria) this;
        }

        public Criteria andSignProcityLessThan(String value) {
            addCriterion("sign_procity <", value, "signProcity");
            return (Criteria) this;
        }

        public Criteria andSignProcityLessThanOrEqualTo(String value) {
            addCriterion("sign_procity <=", value, "signProcity");
            return (Criteria) this;
        }

        public Criteria andSignProcityLike(String value) {
            addCriterion("sign_procity like", value, "signProcity");
            return (Criteria) this;
        }

        public Criteria andSignProcityNotLike(String value) {
            addCriterion("sign_procity not like", value, "signProcity");
            return (Criteria) this;
        }

        public Criteria andSignProcityIn(List<String> values) {
            addCriterion("sign_procity in", values, "signProcity");
            return (Criteria) this;
        }

        public Criteria andSignProcityNotIn(List<String> values) {
            addCriterion("sign_procity not in", values, "signProcity");
            return (Criteria) this;
        }

        public Criteria andSignProcityBetween(String value1, String value2) {
            addCriterion("sign_procity between", value1, value2, "signProcity");
            return (Criteria) this;
        }

        public Criteria andSignProcityNotBetween(String value1, String value2) {
            addCriterion("sign_procity not between", value1, value2, "signProcity");
            return (Criteria) this;
        }

        public Criteria andAskLeaveTypeIsNull() {
            addCriterion("ask_leave_type is null");
            return (Criteria) this;
        }

        public Criteria andAskLeaveTypeIsNotNull() {
            addCriterion("ask_leave_type is not null");
            return (Criteria) this;
        }

        public Criteria andAskLeaveTypeEqualTo(String value) {
            addCriterion("ask_leave_type =", value, "askLeaveType");
            return (Criteria) this;
        }

        public Criteria andAskLeaveTypeNotEqualTo(String value) {
            addCriterion("ask_leave_type <>", value, "askLeaveType");
            return (Criteria) this;
        }

        public Criteria andAskLeaveTypeGreaterThan(String value) {
            addCriterion("ask_leave_type >", value, "askLeaveType");
            return (Criteria) this;
        }

        public Criteria andAskLeaveTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ask_leave_type >=", value, "askLeaveType");
            return (Criteria) this;
        }

        public Criteria andAskLeaveTypeLessThan(String value) {
            addCriterion("ask_leave_type <", value, "askLeaveType");
            return (Criteria) this;
        }

        public Criteria andAskLeaveTypeLessThanOrEqualTo(String value) {
            addCriterion("ask_leave_type <=", value, "askLeaveType");
            return (Criteria) this;
        }

        public Criteria andAskLeaveTypeLike(String value) {
            addCriterion("ask_leave_type like", value, "askLeaveType");
            return (Criteria) this;
        }

        public Criteria andAskLeaveTypeNotLike(String value) {
            addCriterion("ask_leave_type not like", value, "askLeaveType");
            return (Criteria) this;
        }

        public Criteria andAskLeaveTypeIn(List<String> values) {
            addCriterion("ask_leave_type in", values, "askLeaveType");
            return (Criteria) this;
        }

        public Criteria andAskLeaveTypeNotIn(List<String> values) {
            addCriterion("ask_leave_type not in", values, "askLeaveType");
            return (Criteria) this;
        }

        public Criteria andAskLeaveTypeBetween(String value1, String value2) {
            addCriterion("ask_leave_type between", value1, value2, "askLeaveType");
            return (Criteria) this;
        }

        public Criteria andAskLeaveTypeNotBetween(String value1, String value2) {
            addCriterion("ask_leave_type not between", value1, value2, "askLeaveType");
            return (Criteria) this;
        }

        public Criteria andAskLeaveAllowanceIsNull() {
            addCriterion("ask_leave_allowance is null");
            return (Criteria) this;
        }

        public Criteria andAskLeaveAllowanceIsNotNull() {
            addCriterion("ask_leave_allowance is not null");
            return (Criteria) this;
        }

        public Criteria andAskLeaveAllowanceEqualTo(String value) {
            addCriterion("ask_leave_allowance =", value, "askLeaveAllowance");
            return (Criteria) this;
        }

        public Criteria andAskLeaveAllowanceNotEqualTo(String value) {
            addCriterion("ask_leave_allowance <>", value, "askLeaveAllowance");
            return (Criteria) this;
        }

        public Criteria andAskLeaveAllowanceGreaterThan(String value) {
            addCriterion("ask_leave_allowance >", value, "askLeaveAllowance");
            return (Criteria) this;
        }

        public Criteria andAskLeaveAllowanceGreaterThanOrEqualTo(String value) {
            addCriterion("ask_leave_allowance >=", value, "askLeaveAllowance");
            return (Criteria) this;
        }

        public Criteria andAskLeaveAllowanceLessThan(String value) {
            addCriterion("ask_leave_allowance <", value, "askLeaveAllowance");
            return (Criteria) this;
        }

        public Criteria andAskLeaveAllowanceLessThanOrEqualTo(String value) {
            addCriterion("ask_leave_allowance <=", value, "askLeaveAllowance");
            return (Criteria) this;
        }

        public Criteria andAskLeaveAllowanceLike(String value) {
            addCriterion("ask_leave_allowance like", value, "askLeaveAllowance");
            return (Criteria) this;
        }

        public Criteria andAskLeaveAllowanceNotLike(String value) {
            addCriterion("ask_leave_allowance not like", value, "askLeaveAllowance");
            return (Criteria) this;
        }

        public Criteria andAskLeaveAllowanceIn(List<String> values) {
            addCriterion("ask_leave_allowance in", values, "askLeaveAllowance");
            return (Criteria) this;
        }

        public Criteria andAskLeaveAllowanceNotIn(List<String> values) {
            addCriterion("ask_leave_allowance not in", values, "askLeaveAllowance");
            return (Criteria) this;
        }

        public Criteria andAskLeaveAllowanceBetween(String value1, String value2) {
            addCriterion("ask_leave_allowance between", value1, value2, "askLeaveAllowance");
            return (Criteria) this;
        }

        public Criteria andAskLeaveAllowanceNotBetween(String value1, String value2) {
            addCriterion("ask_leave_allowance not between", value1, value2, "askLeaveAllowance");
            return (Criteria) this;
        }

        public Criteria andWhetherBtIsNull() {
            addCriterion("whether_bt is null");
            return (Criteria) this;
        }

        public Criteria andWhetherBtIsNotNull() {
            addCriterion("whether_bt is not null");
            return (Criteria) this;
        }

        public Criteria andWhetherBtEqualTo(String value) {
            addCriterion("whether_bt =", value, "whetherBt");
            return (Criteria) this;
        }

        public Criteria andWhetherBtNotEqualTo(String value) {
            addCriterion("whether_bt <>", value, "whetherBt");
            return (Criteria) this;
        }

        public Criteria andWhetherBtGreaterThan(String value) {
            addCriterion("whether_bt >", value, "whetherBt");
            return (Criteria) this;
        }

        public Criteria andWhetherBtGreaterThanOrEqualTo(String value) {
            addCriterion("whether_bt >=", value, "whetherBt");
            return (Criteria) this;
        }

        public Criteria andWhetherBtLessThan(String value) {
            addCriterion("whether_bt <", value, "whetherBt");
            return (Criteria) this;
        }

        public Criteria andWhetherBtLessThanOrEqualTo(String value) {
            addCriterion("whether_bt <=", value, "whetherBt");
            return (Criteria) this;
        }

        public Criteria andWhetherBtLike(String value) {
            addCriterion("whether_bt like", value, "whetherBt");
            return (Criteria) this;
        }

        public Criteria andWhetherBtNotLike(String value) {
            addCriterion("whether_bt not like", value, "whetherBt");
            return (Criteria) this;
        }

        public Criteria andWhetherBtIn(List<String> values) {
            addCriterion("whether_bt in", values, "whetherBt");
            return (Criteria) this;
        }

        public Criteria andWhetherBtNotIn(List<String> values) {
            addCriterion("whether_bt not in", values, "whetherBt");
            return (Criteria) this;
        }

        public Criteria andWhetherBtBetween(String value1, String value2) {
            addCriterion("whether_bt between", value1, value2, "whetherBt");
            return (Criteria) this;
        }

        public Criteria andWhetherBtNotBetween(String value1, String value2) {
            addCriterion("whether_bt not between", value1, value2, "whetherBt");
            return (Criteria) this;
        }

        public Criteria andBtProcityIsNull() {
            addCriterion("bt_procity is null");
            return (Criteria) this;
        }

        public Criteria andBtProcityIsNotNull() {
            addCriterion("bt_procity is not null");
            return (Criteria) this;
        }

        public Criteria andBtProcityEqualTo(String value) {
            addCriterion("bt_procity =", value, "btProcity");
            return (Criteria) this;
        }

        public Criteria andBtProcityNotEqualTo(String value) {
            addCriterion("bt_procity <>", value, "btProcity");
            return (Criteria) this;
        }

        public Criteria andBtProcityGreaterThan(String value) {
            addCriterion("bt_procity >", value, "btProcity");
            return (Criteria) this;
        }

        public Criteria andBtProcityGreaterThanOrEqualTo(String value) {
            addCriterion("bt_procity >=", value, "btProcity");
            return (Criteria) this;
        }

        public Criteria andBtProcityLessThan(String value) {
            addCriterion("bt_procity <", value, "btProcity");
            return (Criteria) this;
        }

        public Criteria andBtProcityLessThanOrEqualTo(String value) {
            addCriterion("bt_procity <=", value, "btProcity");
            return (Criteria) this;
        }

        public Criteria andBtProcityLike(String value) {
            addCriterion("bt_procity like", value, "btProcity");
            return (Criteria) this;
        }

        public Criteria andBtProcityNotLike(String value) {
            addCriterion("bt_procity not like", value, "btProcity");
            return (Criteria) this;
        }

        public Criteria andBtProcityIn(List<String> values) {
            addCriterion("bt_procity in", values, "btProcity");
            return (Criteria) this;
        }

        public Criteria andBtProcityNotIn(List<String> values) {
            addCriterion("bt_procity not in", values, "btProcity");
            return (Criteria) this;
        }

        public Criteria andBtProcityBetween(String value1, String value2) {
            addCriterion("bt_procity between", value1, value2, "btProcity");
            return (Criteria) this;
        }

        public Criteria andBtProcityNotBetween(String value1, String value2) {
            addCriterion("bt_procity not between", value1, value2, "btProcity");
            return (Criteria) this;
        }

        public Criteria andWhetherEffAttIsNull() {
            addCriterion("whether_eff_att is null");
            return (Criteria) this;
        }

        public Criteria andWhetherEffAttIsNotNull() {
            addCriterion("whether_eff_att is not null");
            return (Criteria) this;
        }

        public Criteria andWhetherEffAttEqualTo(String value) {
            addCriterion("whether_eff_att =", value, "whetherEffAtt");
            return (Criteria) this;
        }

        public Criteria andWhetherEffAttNotEqualTo(String value) {
            addCriterion("whether_eff_att <>", value, "whetherEffAtt");
            return (Criteria) this;
        }

        public Criteria andWhetherEffAttGreaterThan(String value) {
            addCriterion("whether_eff_att >", value, "whetherEffAtt");
            return (Criteria) this;
        }

        public Criteria andWhetherEffAttGreaterThanOrEqualTo(String value) {
            addCriterion("whether_eff_att >=", value, "whetherEffAtt");
            return (Criteria) this;
        }

        public Criteria andWhetherEffAttLessThan(String value) {
            addCriterion("whether_eff_att <", value, "whetherEffAtt");
            return (Criteria) this;
        }

        public Criteria andWhetherEffAttLessThanOrEqualTo(String value) {
            addCriterion("whether_eff_att <=", value, "whetherEffAtt");
            return (Criteria) this;
        }

        public Criteria andWhetherEffAttLike(String value) {
            addCriterion("whether_eff_att like", value, "whetherEffAtt");
            return (Criteria) this;
        }

        public Criteria andWhetherEffAttNotLike(String value) {
            addCriterion("whether_eff_att not like", value, "whetherEffAtt");
            return (Criteria) this;
        }

        public Criteria andWhetherEffAttIn(List<String> values) {
            addCriterion("whether_eff_att in", values, "whetherEffAtt");
            return (Criteria) this;
        }

        public Criteria andWhetherEffAttNotIn(List<String> values) {
            addCriterion("whether_eff_att not in", values, "whetherEffAtt");
            return (Criteria) this;
        }

        public Criteria andWhetherEffAttBetween(String value1, String value2) {
            addCriterion("whether_eff_att between", value1, value2, "whetherEffAtt");
            return (Criteria) this;
        }

        public Criteria andWhetherEffAttNotBetween(String value1, String value2) {
            addCriterion("whether_eff_att not between", value1, value2, "whetherEffAtt");
            return (Criteria) this;
        }

        public Criteria andWhetherOtIsNull() {
            addCriterion("whether_ot is null");
            return (Criteria) this;
        }

        public Criteria andWhetherOtIsNotNull() {
            addCriterion("whether_ot is not null");
            return (Criteria) this;
        }

        public Criteria andWhetherOtEqualTo(String value) {
            addCriterion("whether_ot =", value, "whetherOt");
            return (Criteria) this;
        }

        public Criteria andWhetherOtNotEqualTo(String value) {
            addCriterion("whether_ot <>", value, "whetherOt");
            return (Criteria) this;
        }

        public Criteria andWhetherOtGreaterThan(String value) {
            addCriterion("whether_ot >", value, "whetherOt");
            return (Criteria) this;
        }

        public Criteria andWhetherOtGreaterThanOrEqualTo(String value) {
            addCriterion("whether_ot >=", value, "whetherOt");
            return (Criteria) this;
        }

        public Criteria andWhetherOtLessThan(String value) {
            addCriterion("whether_ot <", value, "whetherOt");
            return (Criteria) this;
        }

        public Criteria andWhetherOtLessThanOrEqualTo(String value) {
            addCriterion("whether_ot <=", value, "whetherOt");
            return (Criteria) this;
        }

        public Criteria andWhetherOtLike(String value) {
            addCriterion("whether_ot like", value, "whetherOt");
            return (Criteria) this;
        }

        public Criteria andWhetherOtNotLike(String value) {
            addCriterion("whether_ot not like", value, "whetherOt");
            return (Criteria) this;
        }

        public Criteria andWhetherOtIn(List<String> values) {
            addCriterion("whether_ot in", values, "whetherOt");
            return (Criteria) this;
        }

        public Criteria andWhetherOtNotIn(List<String> values) {
            addCriterion("whether_ot not in", values, "whetherOt");
            return (Criteria) this;
        }

        public Criteria andWhetherOtBetween(String value1, String value2) {
            addCriterion("whether_ot between", value1, value2, "whetherOt");
            return (Criteria) this;
        }

        public Criteria andWhetherOtNotBetween(String value1, String value2) {
            addCriterion("whether_ot not between", value1, value2, "whetherOt");
            return (Criteria) this;
        }

        public Criteria andOtProcityIsNull() {
            addCriterion("ot_procity is null");
            return (Criteria) this;
        }

        public Criteria andOtProcityIsNotNull() {
            addCriterion("ot_procity is not null");
            return (Criteria) this;
        }

        public Criteria andOtProcityEqualTo(String value) {
            addCriterion("ot_procity =", value, "otProcity");
            return (Criteria) this;
        }

        public Criteria andOtProcityNotEqualTo(String value) {
            addCriterion("ot_procity <>", value, "otProcity");
            return (Criteria) this;
        }

        public Criteria andOtProcityGreaterThan(String value) {
            addCriterion("ot_procity >", value, "otProcity");
            return (Criteria) this;
        }

        public Criteria andOtProcityGreaterThanOrEqualTo(String value) {
            addCriterion("ot_procity >=", value, "otProcity");
            return (Criteria) this;
        }

        public Criteria andOtProcityLessThan(String value) {
            addCriterion("ot_procity <", value, "otProcity");
            return (Criteria) this;
        }

        public Criteria andOtProcityLessThanOrEqualTo(String value) {
            addCriterion("ot_procity <=", value, "otProcity");
            return (Criteria) this;
        }

        public Criteria andOtProcityLike(String value) {
            addCriterion("ot_procity like", value, "otProcity");
            return (Criteria) this;
        }

        public Criteria andOtProcityNotLike(String value) {
            addCriterion("ot_procity not like", value, "otProcity");
            return (Criteria) this;
        }

        public Criteria andOtProcityIn(List<String> values) {
            addCriterion("ot_procity in", values, "otProcity");
            return (Criteria) this;
        }

        public Criteria andOtProcityNotIn(List<String> values) {
            addCriterion("ot_procity not in", values, "otProcity");
            return (Criteria) this;
        }

        public Criteria andOtProcityBetween(String value1, String value2) {
            addCriterion("ot_procity between", value1, value2, "otProcity");
            return (Criteria) this;
        }

        public Criteria andOtProcityNotBetween(String value1, String value2) {
            addCriterion("ot_procity not between", value1, value2, "otProcity");
            return (Criteria) this;
        }

        public Criteria andWhetherEffSignIsNull() {
            addCriterion("whether_eff_sign is null");
            return (Criteria) this;
        }

        public Criteria andWhetherEffSignIsNotNull() {
            addCriterion("whether_eff_sign is not null");
            return (Criteria) this;
        }

        public Criteria andWhetherEffSignEqualTo(String value) {
            addCriterion("whether_eff_sign =", value, "whetherEffSign");
            return (Criteria) this;
        }

        public Criteria andWhetherEffSignNotEqualTo(String value) {
            addCriterion("whether_eff_sign <>", value, "whetherEffSign");
            return (Criteria) this;
        }

        public Criteria andWhetherEffSignGreaterThan(String value) {
            addCriterion("whether_eff_sign >", value, "whetherEffSign");
            return (Criteria) this;
        }

        public Criteria andWhetherEffSignGreaterThanOrEqualTo(String value) {
            addCriterion("whether_eff_sign >=", value, "whetherEffSign");
            return (Criteria) this;
        }

        public Criteria andWhetherEffSignLessThan(String value) {
            addCriterion("whether_eff_sign <", value, "whetherEffSign");
            return (Criteria) this;
        }

        public Criteria andWhetherEffSignLessThanOrEqualTo(String value) {
            addCriterion("whether_eff_sign <=", value, "whetherEffSign");
            return (Criteria) this;
        }

        public Criteria andWhetherEffSignLike(String value) {
            addCriterion("whether_eff_sign like", value, "whetherEffSign");
            return (Criteria) this;
        }

        public Criteria andWhetherEffSignNotLike(String value) {
            addCriterion("whether_eff_sign not like", value, "whetherEffSign");
            return (Criteria) this;
        }

        public Criteria andWhetherEffSignIn(List<String> values) {
            addCriterion("whether_eff_sign in", values, "whetherEffSign");
            return (Criteria) this;
        }

        public Criteria andWhetherEffSignNotIn(List<String> values) {
            addCriterion("whether_eff_sign not in", values, "whetherEffSign");
            return (Criteria) this;
        }

        public Criteria andWhetherEffSignBetween(String value1, String value2) {
            addCriterion("whether_eff_sign between", value1, value2, "whetherEffSign");
            return (Criteria) this;
        }

        public Criteria andWhetherEffSignNotBetween(String value1, String value2) {
            addCriterion("whether_eff_sign not between", value1, value2, "whetherEffSign");
            return (Criteria) this;
        }

        public Criteria andWhetherEffBtIsNull() {
            addCriterion("whether_eff_bt is null");
            return (Criteria) this;
        }

        public Criteria andWhetherEffBtIsNotNull() {
            addCriterion("whether_eff_bt is not null");
            return (Criteria) this;
        }

        public Criteria andWhetherEffBtEqualTo(String value) {
            addCriterion("whether_eff_bt =", value, "whetherEffBt");
            return (Criteria) this;
        }

        public Criteria andWhetherEffBtNotEqualTo(String value) {
            addCriterion("whether_eff_bt <>", value, "whetherEffBt");
            return (Criteria) this;
        }

        public Criteria andWhetherEffBtGreaterThan(String value) {
            addCriterion("whether_eff_bt >", value, "whetherEffBt");
            return (Criteria) this;
        }

        public Criteria andWhetherEffBtGreaterThanOrEqualTo(String value) {
            addCriterion("whether_eff_bt >=", value, "whetherEffBt");
            return (Criteria) this;
        }

        public Criteria andWhetherEffBtLessThan(String value) {
            addCriterion("whether_eff_bt <", value, "whetherEffBt");
            return (Criteria) this;
        }

        public Criteria andWhetherEffBtLessThanOrEqualTo(String value) {
            addCriterion("whether_eff_bt <=", value, "whetherEffBt");
            return (Criteria) this;
        }

        public Criteria andWhetherEffBtLike(String value) {
            addCriterion("whether_eff_bt like", value, "whetherEffBt");
            return (Criteria) this;
        }

        public Criteria andWhetherEffBtNotLike(String value) {
            addCriterion("whether_eff_bt not like", value, "whetherEffBt");
            return (Criteria) this;
        }

        public Criteria andWhetherEffBtIn(List<String> values) {
            addCriterion("whether_eff_bt in", values, "whetherEffBt");
            return (Criteria) this;
        }

        public Criteria andWhetherEffBtNotIn(List<String> values) {
            addCriterion("whether_eff_bt not in", values, "whetherEffBt");
            return (Criteria) this;
        }

        public Criteria andWhetherEffBtBetween(String value1, String value2) {
            addCriterion("whether_eff_bt between", value1, value2, "whetherEffBt");
            return (Criteria) this;
        }

        public Criteria andWhetherEffBtNotBetween(String value1, String value2) {
            addCriterion("whether_eff_bt not between", value1, value2, "whetherEffBt");
            return (Criteria) this;
        }

        public Criteria andBtAllowanceIsNull() {
            addCriterion("bt_allowance is null");
            return (Criteria) this;
        }

        public Criteria andBtAllowanceIsNotNull() {
            addCriterion("bt_allowance is not null");
            return (Criteria) this;
        }

        public Criteria andBtAllowanceEqualTo(String value) {
            addCriterion("bt_allowance =", value, "btAllowance");
            return (Criteria) this;
        }

        public Criteria andBtAllowanceNotEqualTo(String value) {
            addCriterion("bt_allowance <>", value, "btAllowance");
            return (Criteria) this;
        }

        public Criteria andBtAllowanceGreaterThan(String value) {
            addCriterion("bt_allowance >", value, "btAllowance");
            return (Criteria) this;
        }

        public Criteria andBtAllowanceGreaterThanOrEqualTo(String value) {
            addCriterion("bt_allowance >=", value, "btAllowance");
            return (Criteria) this;
        }

        public Criteria andBtAllowanceLessThan(String value) {
            addCriterion("bt_allowance <", value, "btAllowance");
            return (Criteria) this;
        }

        public Criteria andBtAllowanceLessThanOrEqualTo(String value) {
            addCriterion("bt_allowance <=", value, "btAllowance");
            return (Criteria) this;
        }

        public Criteria andBtAllowanceLike(String value) {
            addCriterion("bt_allowance like", value, "btAllowance");
            return (Criteria) this;
        }

        public Criteria andBtAllowanceNotLike(String value) {
            addCriterion("bt_allowance not like", value, "btAllowance");
            return (Criteria) this;
        }

        public Criteria andBtAllowanceIn(List<String> values) {
            addCriterion("bt_allowance in", values, "btAllowance");
            return (Criteria) this;
        }

        public Criteria andBtAllowanceNotIn(List<String> values) {
            addCriterion("bt_allowance not in", values, "btAllowance");
            return (Criteria) this;
        }

        public Criteria andBtAllowanceBetween(String value1, String value2) {
            addCriterion("bt_allowance between", value1, value2, "btAllowance");
            return (Criteria) this;
        }

        public Criteria andBtAllowanceNotBetween(String value1, String value2) {
            addCriterion("bt_allowance not between", value1, value2, "btAllowance");
            return (Criteria) this;
        }

        public Criteria andWhetherEffOtIsNull() {
            addCriterion("whether_eff_ot is null");
            return (Criteria) this;
        }

        public Criteria andWhetherEffOtIsNotNull() {
            addCriterion("whether_eff_ot is not null");
            return (Criteria) this;
        }

        public Criteria andWhetherEffOtEqualTo(String value) {
            addCriterion("whether_eff_ot =", value, "whetherEffOt");
            return (Criteria) this;
        }

        public Criteria andWhetherEffOtNotEqualTo(String value) {
            addCriterion("whether_eff_ot <>", value, "whetherEffOt");
            return (Criteria) this;
        }

        public Criteria andWhetherEffOtGreaterThan(String value) {
            addCriterion("whether_eff_ot >", value, "whetherEffOt");
            return (Criteria) this;
        }

        public Criteria andWhetherEffOtGreaterThanOrEqualTo(String value) {
            addCriterion("whether_eff_ot >=", value, "whetherEffOt");
            return (Criteria) this;
        }

        public Criteria andWhetherEffOtLessThan(String value) {
            addCriterion("whether_eff_ot <", value, "whetherEffOt");
            return (Criteria) this;
        }

        public Criteria andWhetherEffOtLessThanOrEqualTo(String value) {
            addCriterion("whether_eff_ot <=", value, "whetherEffOt");
            return (Criteria) this;
        }

        public Criteria andWhetherEffOtLike(String value) {
            addCriterion("whether_eff_ot like", value, "whetherEffOt");
            return (Criteria) this;
        }

        public Criteria andWhetherEffOtNotLike(String value) {
            addCriterion("whether_eff_ot not like", value, "whetherEffOt");
            return (Criteria) this;
        }

        public Criteria andWhetherEffOtIn(List<String> values) {
            addCriterion("whether_eff_ot in", values, "whetherEffOt");
            return (Criteria) this;
        }

        public Criteria andWhetherEffOtNotIn(List<String> values) {
            addCriterion("whether_eff_ot not in", values, "whetherEffOt");
            return (Criteria) this;
        }

        public Criteria andWhetherEffOtBetween(String value1, String value2) {
            addCriterion("whether_eff_ot between", value1, value2, "whetherEffOt");
            return (Criteria) this;
        }

        public Criteria andWhetherEffOtNotBetween(String value1, String value2) {
            addCriterion("whether_eff_ot not between", value1, value2, "whetherEffOt");
            return (Criteria) this;
        }

        public Criteria andOtAllowanceIsNull() {
            addCriterion("ot_allowance is null");
            return (Criteria) this;
        }

        public Criteria andOtAllowanceIsNotNull() {
            addCriterion("ot_allowance is not null");
            return (Criteria) this;
        }

        public Criteria andOtAllowanceEqualTo(String value) {
            addCriterion("ot_allowance =", value, "otAllowance");
            return (Criteria) this;
        }

        public Criteria andOtAllowanceNotEqualTo(String value) {
            addCriterion("ot_allowance <>", value, "otAllowance");
            return (Criteria) this;
        }

        public Criteria andOtAllowanceGreaterThan(String value) {
            addCriterion("ot_allowance >", value, "otAllowance");
            return (Criteria) this;
        }

        public Criteria andOtAllowanceGreaterThanOrEqualTo(String value) {
            addCriterion("ot_allowance >=", value, "otAllowance");
            return (Criteria) this;
        }

        public Criteria andOtAllowanceLessThan(String value) {
            addCriterion("ot_allowance <", value, "otAllowance");
            return (Criteria) this;
        }

        public Criteria andOtAllowanceLessThanOrEqualTo(String value) {
            addCriterion("ot_allowance <=", value, "otAllowance");
            return (Criteria) this;
        }

        public Criteria andOtAllowanceLike(String value) {
            addCriterion("ot_allowance like", value, "otAllowance");
            return (Criteria) this;
        }

        public Criteria andOtAllowanceNotLike(String value) {
            addCriterion("ot_allowance not like", value, "otAllowance");
            return (Criteria) this;
        }

        public Criteria andOtAllowanceIn(List<String> values) {
            addCriterion("ot_allowance in", values, "otAllowance");
            return (Criteria) this;
        }

        public Criteria andOtAllowanceNotIn(List<String> values) {
            addCriterion("ot_allowance not in", values, "otAllowance");
            return (Criteria) this;
        }

        public Criteria andOtAllowanceBetween(String value1, String value2) {
            addCriterion("ot_allowance between", value1, value2, "otAllowance");
            return (Criteria) this;
        }

        public Criteria andOtAllowanceNotBetween(String value1, String value2) {
            addCriterion("ot_allowance not between", value1, value2, "otAllowance");
            return (Criteria) this;
        }

        public Criteria andHeatingAllowanceIsNull() {
            addCriterion("heating_allowance is null");
            return (Criteria) this;
        }

        public Criteria andHeatingAllowanceIsNotNull() {
            addCriterion("heating_allowance is not null");
            return (Criteria) this;
        }

        public Criteria andHeatingAllowanceEqualTo(String value) {
            addCriterion("heating_allowance =", value, "heatingAllowance");
            return (Criteria) this;
        }

        public Criteria andHeatingAllowanceNotEqualTo(String value) {
            addCriterion("heating_allowance <>", value, "heatingAllowance");
            return (Criteria) this;
        }

        public Criteria andHeatingAllowanceGreaterThan(String value) {
            addCriterion("heating_allowance >", value, "heatingAllowance");
            return (Criteria) this;
        }

        public Criteria andHeatingAllowanceGreaterThanOrEqualTo(String value) {
            addCriterion("heating_allowance >=", value, "heatingAllowance");
            return (Criteria) this;
        }

        public Criteria andHeatingAllowanceLessThan(String value) {
            addCriterion("heating_allowance <", value, "heatingAllowance");
            return (Criteria) this;
        }

        public Criteria andHeatingAllowanceLessThanOrEqualTo(String value) {
            addCriterion("heating_allowance <=", value, "heatingAllowance");
            return (Criteria) this;
        }

        public Criteria andHeatingAllowanceLike(String value) {
            addCriterion("heating_allowance like", value, "heatingAllowance");
            return (Criteria) this;
        }

        public Criteria andHeatingAllowanceNotLike(String value) {
            addCriterion("heating_allowance not like", value, "heatingAllowance");
            return (Criteria) this;
        }

        public Criteria andHeatingAllowanceIn(List<String> values) {
            addCriterion("heating_allowance in", values, "heatingAllowance");
            return (Criteria) this;
        }

        public Criteria andHeatingAllowanceNotIn(List<String> values) {
            addCriterion("heating_allowance not in", values, "heatingAllowance");
            return (Criteria) this;
        }

        public Criteria andHeatingAllowanceBetween(String value1, String value2) {
            addCriterion("heating_allowance between", value1, value2, "heatingAllowance");
            return (Criteria) this;
        }

        public Criteria andHeatingAllowanceNotBetween(String value1, String value2) {
            addCriterion("heating_allowance not between", value1, value2, "heatingAllowance");
            return (Criteria) this;
        }

        public Criteria andTimebaseIsNull() {
            addCriterion("timebase is null");
            return (Criteria) this;
        }

        public Criteria andTimebaseIsNotNull() {
            addCriterion("timebase is not null");
            return (Criteria) this;
        }

        public Criteria andTimebaseEqualTo(String value) {
            addCriterion("timebase =", value, "timebase");
            return (Criteria) this;
        }

        public Criteria andTimebaseNotEqualTo(String value) {
            addCriterion("timebase <>", value, "timebase");
            return (Criteria) this;
        }

        public Criteria andTimebaseGreaterThan(String value) {
            addCriterion("timebase >", value, "timebase");
            return (Criteria) this;
        }

        public Criteria andTimebaseGreaterThanOrEqualTo(String value) {
            addCriterion("timebase >=", value, "timebase");
            return (Criteria) this;
        }

        public Criteria andTimebaseLessThan(String value) {
            addCriterion("timebase <", value, "timebase");
            return (Criteria) this;
        }

        public Criteria andTimebaseLessThanOrEqualTo(String value) {
            addCriterion("timebase <=", value, "timebase");
            return (Criteria) this;
        }

        public Criteria andTimebaseLike(String value) {
            addCriterion("timebase like", value, "timebase");
            return (Criteria) this;
        }

        public Criteria andTimebaseNotLike(String value) {
            addCriterion("timebase not like", value, "timebase");
            return (Criteria) this;
        }

        public Criteria andTimebaseIn(List<String> values) {
            addCriterion("timebase in", values, "timebase");
            return (Criteria) this;
        }

        public Criteria andTimebaseNotIn(List<String> values) {
            addCriterion("timebase not in", values, "timebase");
            return (Criteria) this;
        }

        public Criteria andTimebaseBetween(String value1, String value2) {
            addCriterion("timebase between", value1, value2, "timebase");
            return (Criteria) this;
        }

        public Criteria andTimebaseNotBetween(String value1, String value2) {
            addCriterion("timebase not between", value1, value2, "timebase");
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