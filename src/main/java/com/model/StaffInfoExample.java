package com.model;

import java.util.ArrayList;
import java.util.List;

public class StaffInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StaffInfoExample() {
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

        public Criteria andSqncNmbrIsNull() {
            addCriterion("sqnc_nmbr is null");
            return (Criteria) this;
        }

        public Criteria andSqncNmbrIsNotNull() {
            addCriterion("sqnc_nmbr is not null");
            return (Criteria) this;
        }

        public Criteria andSqncNmbrEqualTo(Integer value) {
            addCriterion("sqnc_nmbr =", value, "sqncNmbr");
            return (Criteria) this;
        }

        public Criteria andSqncNmbrNotEqualTo(Integer value) {
            addCriterion("sqnc_nmbr <>", value, "sqncNmbr");
            return (Criteria) this;
        }

        public Criteria andSqncNmbrGreaterThan(Integer value) {
            addCriterion("sqnc_nmbr >", value, "sqncNmbr");
            return (Criteria) this;
        }

        public Criteria andSqncNmbrGreaterThanOrEqualTo(Integer value) {
            addCriterion("sqnc_nmbr >=", value, "sqncNmbr");
            return (Criteria) this;
        }

        public Criteria andSqncNmbrLessThan(Integer value) {
            addCriterion("sqnc_nmbr <", value, "sqncNmbr");
            return (Criteria) this;
        }

        public Criteria andSqncNmbrLessThanOrEqualTo(Integer value) {
            addCriterion("sqnc_nmbr <=", value, "sqncNmbr");
            return (Criteria) this;
        }

        public Criteria andSqncNmbrIn(List<Integer> values) {
            addCriterion("sqnc_nmbr in", values, "sqncNmbr");
            return (Criteria) this;
        }

        public Criteria andSqncNmbrNotIn(List<Integer> values) {
            addCriterion("sqnc_nmbr not in", values, "sqncNmbr");
            return (Criteria) this;
        }

        public Criteria andSqncNmbrBetween(Integer value1, Integer value2) {
            addCriterion("sqnc_nmbr between", value1, value2, "sqncNmbr");
            return (Criteria) this;
        }

        public Criteria andSqncNmbrNotBetween(Integer value1, Integer value2) {
            addCriterion("sqnc_nmbr not between", value1, value2, "sqncNmbr");
            return (Criteria) this;
        }

        public Criteria andStffIdIsNull() {
            addCriterion("stff_id is null");
            return (Criteria) this;
        }

        public Criteria andStffIdIsNotNull() {
            addCriterion("stff_id is not null");
            return (Criteria) this;
        }

        public Criteria andStffIdEqualTo(String value) {
            addCriterion("stff_id =", value, "stffId");
            return (Criteria) this;
        }

        public Criteria andStffIdNotEqualTo(String value) {
            addCriterion("stff_id <>", value, "stffId");
            return (Criteria) this;
        }

        public Criteria andStffIdGreaterThan(String value) {
            addCriterion("stff_id >", value, "stffId");
            return (Criteria) this;
        }

        public Criteria andStffIdGreaterThanOrEqualTo(String value) {
            addCriterion("stff_id >=", value, "stffId");
            return (Criteria) this;
        }

        public Criteria andStffIdLessThan(String value) {
            addCriterion("stff_id <", value, "stffId");
            return (Criteria) this;
        }

        public Criteria andStffIdLessThanOrEqualTo(String value) {
            addCriterion("stff_id <=", value, "stffId");
            return (Criteria) this;
        }

        public Criteria andStffIdLike(String value) {
            addCriterion("stff_id like", value, "stffId");
            return (Criteria) this;
        }

        public Criteria andStffIdNotLike(String value) {
            addCriterion("stff_id not like", value, "stffId");
            return (Criteria) this;
        }

        public Criteria andStffIdIn(List<String> values) {
            addCriterion("stff_id in", values, "stffId");
            return (Criteria) this;
        }

        public Criteria andStffIdNotIn(List<String> values) {
            addCriterion("stff_id not in", values, "stffId");
            return (Criteria) this;
        }

        public Criteria andStffIdBetween(String value1, String value2) {
            addCriterion("stff_id between", value1, value2, "stffId");
            return (Criteria) this;
        }

        public Criteria andStffIdNotBetween(String value1, String value2) {
            addCriterion("stff_id not between", value1, value2, "stffId");
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

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andIdCrdIsNull() {
            addCriterion("id_crd is null");
            return (Criteria) this;
        }

        public Criteria andIdCrdIsNotNull() {
            addCriterion("id_crd is not null");
            return (Criteria) this;
        }

        public Criteria andIdCrdEqualTo(String value) {
            addCriterion("id_crd =", value, "idCrd");
            return (Criteria) this;
        }

        public Criteria andIdCrdNotEqualTo(String value) {
            addCriterion("id_crd <>", value, "idCrd");
            return (Criteria) this;
        }

        public Criteria andIdCrdGreaterThan(String value) {
            addCriterion("id_crd >", value, "idCrd");
            return (Criteria) this;
        }

        public Criteria andIdCrdGreaterThanOrEqualTo(String value) {
            addCriterion("id_crd >=", value, "idCrd");
            return (Criteria) this;
        }

        public Criteria andIdCrdLessThan(String value) {
            addCriterion("id_crd <", value, "idCrd");
            return (Criteria) this;
        }

        public Criteria andIdCrdLessThanOrEqualTo(String value) {
            addCriterion("id_crd <=", value, "idCrd");
            return (Criteria) this;
        }

        public Criteria andIdCrdLike(String value) {
            addCriterion("id_crd like", value, "idCrd");
            return (Criteria) this;
        }

        public Criteria andIdCrdNotLike(String value) {
            addCriterion("id_crd not like", value, "idCrd");
            return (Criteria) this;
        }

        public Criteria andIdCrdIn(List<String> values) {
            addCriterion("id_crd in", values, "idCrd");
            return (Criteria) this;
        }

        public Criteria andIdCrdNotIn(List<String> values) {
            addCriterion("id_crd not in", values, "idCrd");
            return (Criteria) this;
        }

        public Criteria andIdCrdBetween(String value1, String value2) {
            addCriterion("id_crd between", value1, value2, "idCrd");
            return (Criteria) this;
        }

        public Criteria andIdCrdNotBetween(String value1, String value2) {
            addCriterion("id_crd not between", value1, value2, "idCrd");
            return (Criteria) this;
        }

        public Criteria andHshldAddrssIsNull() {
            addCriterion("hshld_addrss is null");
            return (Criteria) this;
        }

        public Criteria andHshldAddrssIsNotNull() {
            addCriterion("hshld_addrss is not null");
            return (Criteria) this;
        }

        public Criteria andHshldAddrssEqualTo(String value) {
            addCriterion("hshld_addrss =", value, "hshldAddrss");
            return (Criteria) this;
        }

        public Criteria andHshldAddrssNotEqualTo(String value) {
            addCriterion("hshld_addrss <>", value, "hshldAddrss");
            return (Criteria) this;
        }

        public Criteria andHshldAddrssGreaterThan(String value) {
            addCriterion("hshld_addrss >", value, "hshldAddrss");
            return (Criteria) this;
        }

        public Criteria andHshldAddrssGreaterThanOrEqualTo(String value) {
            addCriterion("hshld_addrss >=", value, "hshldAddrss");
            return (Criteria) this;
        }

        public Criteria andHshldAddrssLessThan(String value) {
            addCriterion("hshld_addrss <", value, "hshldAddrss");
            return (Criteria) this;
        }

        public Criteria andHshldAddrssLessThanOrEqualTo(String value) {
            addCriterion("hshld_addrss <=", value, "hshldAddrss");
            return (Criteria) this;
        }

        public Criteria andHshldAddrssLike(String value) {
            addCriterion("hshld_addrss like", value, "hshldAddrss");
            return (Criteria) this;
        }

        public Criteria andHshldAddrssNotLike(String value) {
            addCriterion("hshld_addrss not like", value, "hshldAddrss");
            return (Criteria) this;
        }

        public Criteria andHshldAddrssIn(List<String> values) {
            addCriterion("hshld_addrss in", values, "hshldAddrss");
            return (Criteria) this;
        }

        public Criteria andHshldAddrssNotIn(List<String> values) {
            addCriterion("hshld_addrss not in", values, "hshldAddrss");
            return (Criteria) this;
        }

        public Criteria andHshldAddrssBetween(String value1, String value2) {
            addCriterion("hshld_addrss between", value1, value2, "hshldAddrss");
            return (Criteria) this;
        }

        public Criteria andHshldAddrssNotBetween(String value1, String value2) {
            addCriterion("hshld_addrss not between", value1, value2, "hshldAddrss");
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

        public Criteria andLvAddrssIsNull() {
            addCriterion("lv_addrss is null");
            return (Criteria) this;
        }

        public Criteria andLvAddrssIsNotNull() {
            addCriterion("lv_addrss is not null");
            return (Criteria) this;
        }

        public Criteria andLvAddrssEqualTo(String value) {
            addCriterion("lv_addrss =", value, "lvAddrss");
            return (Criteria) this;
        }

        public Criteria andLvAddrssNotEqualTo(String value) {
            addCriterion("lv_addrss <>", value, "lvAddrss");
            return (Criteria) this;
        }

        public Criteria andLvAddrssGreaterThan(String value) {
            addCriterion("lv_addrss >", value, "lvAddrss");
            return (Criteria) this;
        }

        public Criteria andLvAddrssGreaterThanOrEqualTo(String value) {
            addCriterion("lv_addrss >=", value, "lvAddrss");
            return (Criteria) this;
        }

        public Criteria andLvAddrssLessThan(String value) {
            addCriterion("lv_addrss <", value, "lvAddrss");
            return (Criteria) this;
        }

        public Criteria andLvAddrssLessThanOrEqualTo(String value) {
            addCriterion("lv_addrss <=", value, "lvAddrss");
            return (Criteria) this;
        }

        public Criteria andLvAddrssLike(String value) {
            addCriterion("lv_addrss like", value, "lvAddrss");
            return (Criteria) this;
        }

        public Criteria andLvAddrssNotLike(String value) {
            addCriterion("lv_addrss not like", value, "lvAddrss");
            return (Criteria) this;
        }

        public Criteria andLvAddrssIn(List<String> values) {
            addCriterion("lv_addrss in", values, "lvAddrss");
            return (Criteria) this;
        }

        public Criteria andLvAddrssNotIn(List<String> values) {
            addCriterion("lv_addrss not in", values, "lvAddrss");
            return (Criteria) this;
        }

        public Criteria andLvAddrssBetween(String value1, String value2) {
            addCriterion("lv_addrss between", value1, value2, "lvAddrss");
            return (Criteria) this;
        }

        public Criteria andLvAddrssNotBetween(String value1, String value2) {
            addCriterion("lv_addrss not between", value1, value2, "lvAddrss");
            return (Criteria) this;
        }

        public Criteria andBrnchCmpnyIsNull() {
            addCriterion("brnch_cmpny is null");
            return (Criteria) this;
        }

        public Criteria andBrnchCmpnyIsNotNull() {
            addCriterion("brnch_cmpny is not null");
            return (Criteria) this;
        }

        public Criteria andBrnchCmpnyEqualTo(String value) {
            addCriterion("brnch_cmpny =", value, "brnchCmpny");
            return (Criteria) this;
        }

        public Criteria andBrnchCmpnyNotEqualTo(String value) {
            addCriterion("brnch_cmpny <>", value, "brnchCmpny");
            return (Criteria) this;
        }

        public Criteria andBrnchCmpnyGreaterThan(String value) {
            addCriterion("brnch_cmpny >", value, "brnchCmpny");
            return (Criteria) this;
        }

        public Criteria andBrnchCmpnyGreaterThanOrEqualTo(String value) {
            addCriterion("brnch_cmpny >=", value, "brnchCmpny");
            return (Criteria) this;
        }

        public Criteria andBrnchCmpnyLessThan(String value) {
            addCriterion("brnch_cmpny <", value, "brnchCmpny");
            return (Criteria) this;
        }

        public Criteria andBrnchCmpnyLessThanOrEqualTo(String value) {
            addCriterion("brnch_cmpny <=", value, "brnchCmpny");
            return (Criteria) this;
        }

        public Criteria andBrnchCmpnyLike(String value) {
            addCriterion("brnch_cmpny like", value, "brnchCmpny");
            return (Criteria) this;
        }

        public Criteria andBrnchCmpnyNotLike(String value) {
            addCriterion("brnch_cmpny not like", value, "brnchCmpny");
            return (Criteria) this;
        }

        public Criteria andBrnchCmpnyIn(List<String> values) {
            addCriterion("brnch_cmpny in", values, "brnchCmpny");
            return (Criteria) this;
        }

        public Criteria andBrnchCmpnyNotIn(List<String> values) {
            addCriterion("brnch_cmpny not in", values, "brnchCmpny");
            return (Criteria) this;
        }

        public Criteria andBrnchCmpnyBetween(String value1, String value2) {
            addCriterion("brnch_cmpny between", value1, value2, "brnchCmpny");
            return (Criteria) this;
        }

        public Criteria andBrnchCmpnyNotBetween(String value1, String value2) {
            addCriterion("brnch_cmpny not between", value1, value2, "brnchCmpny");
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

        public Criteria andSgnAddrssIsNull() {
            addCriterion("sgn_addrss is null");
            return (Criteria) this;
        }

        public Criteria andSgnAddrssIsNotNull() {
            addCriterion("sgn_addrss is not null");
            return (Criteria) this;
        }

        public Criteria andSgnAddrssEqualTo(String value) {
            addCriterion("sgn_addrss =", value, "sgnAddrss");
            return (Criteria) this;
        }

        public Criteria andSgnAddrssNotEqualTo(String value) {
            addCriterion("sgn_addrss <>", value, "sgnAddrss");
            return (Criteria) this;
        }

        public Criteria andSgnAddrssGreaterThan(String value) {
            addCriterion("sgn_addrss >", value, "sgnAddrss");
            return (Criteria) this;
        }

        public Criteria andSgnAddrssGreaterThanOrEqualTo(String value) {
            addCriterion("sgn_addrss >=", value, "sgnAddrss");
            return (Criteria) this;
        }

        public Criteria andSgnAddrssLessThan(String value) {
            addCriterion("sgn_addrss <", value, "sgnAddrss");
            return (Criteria) this;
        }

        public Criteria andSgnAddrssLessThanOrEqualTo(String value) {
            addCriterion("sgn_addrss <=", value, "sgnAddrss");
            return (Criteria) this;
        }

        public Criteria andSgnAddrssLike(String value) {
            addCriterion("sgn_addrss like", value, "sgnAddrss");
            return (Criteria) this;
        }

        public Criteria andSgnAddrssNotLike(String value) {
            addCriterion("sgn_addrss not like", value, "sgnAddrss");
            return (Criteria) this;
        }

        public Criteria andSgnAddrssIn(List<String> values) {
            addCriterion("sgn_addrss in", values, "sgnAddrss");
            return (Criteria) this;
        }

        public Criteria andSgnAddrssNotIn(List<String> values) {
            addCriterion("sgn_addrss not in", values, "sgnAddrss");
            return (Criteria) this;
        }

        public Criteria andSgnAddrssBetween(String value1, String value2) {
            addCriterion("sgn_addrss between", value1, value2, "sgnAddrss");
            return (Criteria) this;
        }

        public Criteria andSgnAddrssNotBetween(String value1, String value2) {
            addCriterion("sgn_addrss not between", value1, value2, "sgnAddrss");
            return (Criteria) this;
        }

        public Criteria andSgnDtIsNull() {
            addCriterion("sgn_dt is null");
            return (Criteria) this;
        }

        public Criteria andSgnDtIsNotNull() {
            addCriterion("sgn_dt is not null");
            return (Criteria) this;
        }

        public Criteria andSgnDtEqualTo(String value) {
            addCriterion("sgn_dt =", value, "sgnDt");
            return (Criteria) this;
        }

        public Criteria andSgnDtNotEqualTo(String value) {
            addCriterion("sgn_dt <>", value, "sgnDt");
            return (Criteria) this;
        }

        public Criteria andSgnDtGreaterThan(String value) {
            addCriterion("sgn_dt >", value, "sgnDt");
            return (Criteria) this;
        }

        public Criteria andSgnDtGreaterThanOrEqualTo(String value) {
            addCriterion("sgn_dt >=", value, "sgnDt");
            return (Criteria) this;
        }

        public Criteria andSgnDtLessThan(String value) {
            addCriterion("sgn_dt <", value, "sgnDt");
            return (Criteria) this;
        }

        public Criteria andSgnDtLessThanOrEqualTo(String value) {
            addCriterion("sgn_dt <=", value, "sgnDt");
            return (Criteria) this;
        }

        public Criteria andSgnDtLike(String value) {
            addCriterion("sgn_dt like", value, "sgnDt");
            return (Criteria) this;
        }

        public Criteria andSgnDtNotLike(String value) {
            addCriterion("sgn_dt not like", value, "sgnDt");
            return (Criteria) this;
        }

        public Criteria andSgnDtIn(List<String> values) {
            addCriterion("sgn_dt in", values, "sgnDt");
            return (Criteria) this;
        }

        public Criteria andSgnDtNotIn(List<String> values) {
            addCriterion("sgn_dt not in", values, "sgnDt");
            return (Criteria) this;
        }

        public Criteria andSgnDtBetween(String value1, String value2) {
            addCriterion("sgn_dt between", value1, value2, "sgnDt");
            return (Criteria) this;
        }

        public Criteria andSgnDtNotBetween(String value1, String value2) {
            addCriterion("sgn_dt not between", value1, value2, "sgnDt");
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

        public Criteria andCntrctBgnIsNull() {
            addCriterion("cntrct_bgn is null");
            return (Criteria) this;
        }

        public Criteria andCntrctBgnIsNotNull() {
            addCriterion("cntrct_bgn is not null");
            return (Criteria) this;
        }

        public Criteria andCntrctBgnEqualTo(String value) {
            addCriterion("cntrct_bgn =", value, "cntrctBgn");
            return (Criteria) this;
        }

        public Criteria andCntrctBgnNotEqualTo(String value) {
            addCriterion("cntrct_bgn <>", value, "cntrctBgn");
            return (Criteria) this;
        }

        public Criteria andCntrctBgnGreaterThan(String value) {
            addCriterion("cntrct_bgn >", value, "cntrctBgn");
            return (Criteria) this;
        }

        public Criteria andCntrctBgnGreaterThanOrEqualTo(String value) {
            addCriterion("cntrct_bgn >=", value, "cntrctBgn");
            return (Criteria) this;
        }

        public Criteria andCntrctBgnLessThan(String value) {
            addCriterion("cntrct_bgn <", value, "cntrctBgn");
            return (Criteria) this;
        }

        public Criteria andCntrctBgnLessThanOrEqualTo(String value) {
            addCriterion("cntrct_bgn <=", value, "cntrctBgn");
            return (Criteria) this;
        }

        public Criteria andCntrctBgnLike(String value) {
            addCriterion("cntrct_bgn like", value, "cntrctBgn");
            return (Criteria) this;
        }

        public Criteria andCntrctBgnNotLike(String value) {
            addCriterion("cntrct_bgn not like", value, "cntrctBgn");
            return (Criteria) this;
        }

        public Criteria andCntrctBgnIn(List<String> values) {
            addCriterion("cntrct_bgn in", values, "cntrctBgn");
            return (Criteria) this;
        }

        public Criteria andCntrctBgnNotIn(List<String> values) {
            addCriterion("cntrct_bgn not in", values, "cntrctBgn");
            return (Criteria) this;
        }

        public Criteria andCntrctBgnBetween(String value1, String value2) {
            addCriterion("cntrct_bgn between", value1, value2, "cntrctBgn");
            return (Criteria) this;
        }

        public Criteria andCntrctBgnNotBetween(String value1, String value2) {
            addCriterion("cntrct_bgn not between", value1, value2, "cntrctBgn");
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

        public Criteria andSlryCrdIsNull() {
            addCriterion("slry_crd is null");
            return (Criteria) this;
        }

        public Criteria andSlryCrdIsNotNull() {
            addCriterion("slry_crd is not null");
            return (Criteria) this;
        }

        public Criteria andSlryCrdEqualTo(String value) {
            addCriterion("slry_crd =", value, "slryCrd");
            return (Criteria) this;
        }

        public Criteria andSlryCrdNotEqualTo(String value) {
            addCriterion("slry_crd <>", value, "slryCrd");
            return (Criteria) this;
        }

        public Criteria andSlryCrdGreaterThan(String value) {
            addCriterion("slry_crd >", value, "slryCrd");
            return (Criteria) this;
        }

        public Criteria andSlryCrdGreaterThanOrEqualTo(String value) {
            addCriterion("slry_crd >=", value, "slryCrd");
            return (Criteria) this;
        }

        public Criteria andSlryCrdLessThan(String value) {
            addCriterion("slry_crd <", value, "slryCrd");
            return (Criteria) this;
        }

        public Criteria andSlryCrdLessThanOrEqualTo(String value) {
            addCriterion("slry_crd <=", value, "slryCrd");
            return (Criteria) this;
        }

        public Criteria andSlryCrdLike(String value) {
            addCriterion("slry_crd like", value, "slryCrd");
            return (Criteria) this;
        }

        public Criteria andSlryCrdNotLike(String value) {
            addCriterion("slry_crd not like", value, "slryCrd");
            return (Criteria) this;
        }

        public Criteria andSlryCrdIn(List<String> values) {
            addCriterion("slry_crd in", values, "slryCrd");
            return (Criteria) this;
        }

        public Criteria andSlryCrdNotIn(List<String> values) {
            addCriterion("slry_crd not in", values, "slryCrd");
            return (Criteria) this;
        }

        public Criteria andSlryCrdBetween(String value1, String value2) {
            addCriterion("slry_crd between", value1, value2, "slryCrd");
            return (Criteria) this;
        }

        public Criteria andSlryCrdNotBetween(String value1, String value2) {
            addCriterion("slry_crd not between", value1, value2, "slryCrd");
            return (Criteria) this;
        }

        public Criteria andExpnsCrdIsNull() {
            addCriterion("expns_crd is null");
            return (Criteria) this;
        }

        public Criteria andExpnsCrdIsNotNull() {
            addCriterion("expns_crd is not null");
            return (Criteria) this;
        }

        public Criteria andExpnsCrdEqualTo(String value) {
            addCriterion("expns_crd =", value, "expnsCrd");
            return (Criteria) this;
        }

        public Criteria andExpnsCrdNotEqualTo(String value) {
            addCriterion("expns_crd <>", value, "expnsCrd");
            return (Criteria) this;
        }

        public Criteria andExpnsCrdGreaterThan(String value) {
            addCriterion("expns_crd >", value, "expnsCrd");
            return (Criteria) this;
        }

        public Criteria andExpnsCrdGreaterThanOrEqualTo(String value) {
            addCriterion("expns_crd >=", value, "expnsCrd");
            return (Criteria) this;
        }

        public Criteria andExpnsCrdLessThan(String value) {
            addCriterion("expns_crd <", value, "expnsCrd");
            return (Criteria) this;
        }

        public Criteria andExpnsCrdLessThanOrEqualTo(String value) {
            addCriterion("expns_crd <=", value, "expnsCrd");
            return (Criteria) this;
        }

        public Criteria andExpnsCrdLike(String value) {
            addCriterion("expns_crd like", value, "expnsCrd");
            return (Criteria) this;
        }

        public Criteria andExpnsCrdNotLike(String value) {
            addCriterion("expns_crd not like", value, "expnsCrd");
            return (Criteria) this;
        }

        public Criteria andExpnsCrdIn(List<String> values) {
            addCriterion("expns_crd in", values, "expnsCrd");
            return (Criteria) this;
        }

        public Criteria andExpnsCrdNotIn(List<String> values) {
            addCriterion("expns_crd not in", values, "expnsCrd");
            return (Criteria) this;
        }

        public Criteria andExpnsCrdBetween(String value1, String value2) {
            addCriterion("expns_crd between", value1, value2, "expnsCrd");
            return (Criteria) this;
        }

        public Criteria andExpnsCrdNotBetween(String value1, String value2) {
            addCriterion("expns_crd not between", value1, value2, "expnsCrd");
            return (Criteria) this;
        }

        public Criteria andStffStateIsNull() {
            addCriterion("stff_state is null");
            return (Criteria) this;
        }

        public Criteria andStffStateIsNotNull() {
            addCriterion("stff_state is not null");
            return (Criteria) this;
        }

        public Criteria andStffStateEqualTo(String value) {
            addCriterion("stff_state =", value, "stffState");
            return (Criteria) this;
        }

        public Criteria andStffStateNotEqualTo(String value) {
            addCriterion("stff_state <>", value, "stffState");
            return (Criteria) this;
        }

        public Criteria andStffStateGreaterThan(String value) {
            addCriterion("stff_state >", value, "stffState");
            return (Criteria) this;
        }

        public Criteria andStffStateGreaterThanOrEqualTo(String value) {
            addCriterion("stff_state >=", value, "stffState");
            return (Criteria) this;
        }

        public Criteria andStffStateLessThan(String value) {
            addCriterion("stff_state <", value, "stffState");
            return (Criteria) this;
        }

        public Criteria andStffStateLessThanOrEqualTo(String value) {
            addCriterion("stff_state <=", value, "stffState");
            return (Criteria) this;
        }

        public Criteria andStffStateLike(String value) {
            addCriterion("stff_state like", value, "stffState");
            return (Criteria) this;
        }

        public Criteria andStffStateNotLike(String value) {
            addCriterion("stff_state not like", value, "stffState");
            return (Criteria) this;
        }

        public Criteria andStffStateIn(List<String> values) {
            addCriterion("stff_state in", values, "stffState");
            return (Criteria) this;
        }

        public Criteria andStffStateNotIn(List<String> values) {
            addCriterion("stff_state not in", values, "stffState");
            return (Criteria) this;
        }

        public Criteria andStffStateBetween(String value1, String value2) {
            addCriterion("stff_state between", value1, value2, "stffState");
            return (Criteria) this;
        }

        public Criteria andStffStateNotBetween(String value1, String value2) {
            addCriterion("stff_state not between", value1, value2, "stffState");
            return (Criteria) this;
        }

        public Criteria andGrdtSchlIsNull() {
            addCriterion("grdt_schl is null");
            return (Criteria) this;
        }

        public Criteria andGrdtSchlIsNotNull() {
            addCriterion("grdt_schl is not null");
            return (Criteria) this;
        }

        public Criteria andGrdtSchlEqualTo(String value) {
            addCriterion("grdt_schl =", value, "grdtSchl");
            return (Criteria) this;
        }

        public Criteria andGrdtSchlNotEqualTo(String value) {
            addCriterion("grdt_schl <>", value, "grdtSchl");
            return (Criteria) this;
        }

        public Criteria andGrdtSchlGreaterThan(String value) {
            addCriterion("grdt_schl >", value, "grdtSchl");
            return (Criteria) this;
        }

        public Criteria andGrdtSchlGreaterThanOrEqualTo(String value) {
            addCriterion("grdt_schl >=", value, "grdtSchl");
            return (Criteria) this;
        }

        public Criteria andGrdtSchlLessThan(String value) {
            addCriterion("grdt_schl <", value, "grdtSchl");
            return (Criteria) this;
        }

        public Criteria andGrdtSchlLessThanOrEqualTo(String value) {
            addCriterion("grdt_schl <=", value, "grdtSchl");
            return (Criteria) this;
        }

        public Criteria andGrdtSchlLike(String value) {
            addCriterion("grdt_schl like", value, "grdtSchl");
            return (Criteria) this;
        }

        public Criteria andGrdtSchlNotLike(String value) {
            addCriterion("grdt_schl not like", value, "grdtSchl");
            return (Criteria) this;
        }

        public Criteria andGrdtSchlIn(List<String> values) {
            addCriterion("grdt_schl in", values, "grdtSchl");
            return (Criteria) this;
        }

        public Criteria andGrdtSchlNotIn(List<String> values) {
            addCriterion("grdt_schl not in", values, "grdtSchl");
            return (Criteria) this;
        }

        public Criteria andGrdtSchlBetween(String value1, String value2) {
            addCriterion("grdt_schl between", value1, value2, "grdtSchl");
            return (Criteria) this;
        }

        public Criteria andGrdtSchlNotBetween(String value1, String value2) {
            addCriterion("grdt_schl not between", value1, value2, "grdtSchl");
            return (Criteria) this;
        }

        public Criteria andSchlRcrdIsNull() {
            addCriterion("schl_rcrd is null");
            return (Criteria) this;
        }

        public Criteria andSchlRcrdIsNotNull() {
            addCriterion("schl_rcrd is not null");
            return (Criteria) this;
        }

        public Criteria andSchlRcrdEqualTo(String value) {
            addCriterion("schl_rcrd =", value, "schlRcrd");
            return (Criteria) this;
        }

        public Criteria andSchlRcrdNotEqualTo(String value) {
            addCriterion("schl_rcrd <>", value, "schlRcrd");
            return (Criteria) this;
        }

        public Criteria andSchlRcrdGreaterThan(String value) {
            addCriterion("schl_rcrd >", value, "schlRcrd");
            return (Criteria) this;
        }

        public Criteria andSchlRcrdGreaterThanOrEqualTo(String value) {
            addCriterion("schl_rcrd >=", value, "schlRcrd");
            return (Criteria) this;
        }

        public Criteria andSchlRcrdLessThan(String value) {
            addCriterion("schl_rcrd <", value, "schlRcrd");
            return (Criteria) this;
        }

        public Criteria andSchlRcrdLessThanOrEqualTo(String value) {
            addCriterion("schl_rcrd <=", value, "schlRcrd");
            return (Criteria) this;
        }

        public Criteria andSchlRcrdLike(String value) {
            addCriterion("schl_rcrd like", value, "schlRcrd");
            return (Criteria) this;
        }

        public Criteria andSchlRcrdNotLike(String value) {
            addCriterion("schl_rcrd not like", value, "schlRcrd");
            return (Criteria) this;
        }

        public Criteria andSchlRcrdIn(List<String> values) {
            addCriterion("schl_rcrd in", values, "schlRcrd");
            return (Criteria) this;
        }

        public Criteria andSchlRcrdNotIn(List<String> values) {
            addCriterion("schl_rcrd not in", values, "schlRcrd");
            return (Criteria) this;
        }

        public Criteria andSchlRcrdBetween(String value1, String value2) {
            addCriterion("schl_rcrd between", value1, value2, "schlRcrd");
            return (Criteria) this;
        }

        public Criteria andSchlRcrdNotBetween(String value1, String value2) {
            addCriterion("schl_rcrd not between", value1, value2, "schlRcrd");
            return (Criteria) this;
        }

        public Criteria andGrdtDtIsNull() {
            addCriterion("grdt_dt is null");
            return (Criteria) this;
        }

        public Criteria andGrdtDtIsNotNull() {
            addCriterion("grdt_dt is not null");
            return (Criteria) this;
        }

        public Criteria andGrdtDtEqualTo(String value) {
            addCriterion("grdt_dt =", value, "grdtDt");
            return (Criteria) this;
        }

        public Criteria andGrdtDtNotEqualTo(String value) {
            addCriterion("grdt_dt <>", value, "grdtDt");
            return (Criteria) this;
        }

        public Criteria andGrdtDtGreaterThan(String value) {
            addCriterion("grdt_dt >", value, "grdtDt");
            return (Criteria) this;
        }

        public Criteria andGrdtDtGreaterThanOrEqualTo(String value) {
            addCriterion("grdt_dt >=", value, "grdtDt");
            return (Criteria) this;
        }

        public Criteria andGrdtDtLessThan(String value) {
            addCriterion("grdt_dt <", value, "grdtDt");
            return (Criteria) this;
        }

        public Criteria andGrdtDtLessThanOrEqualTo(String value) {
            addCriterion("grdt_dt <=", value, "grdtDt");
            return (Criteria) this;
        }

        public Criteria andGrdtDtLike(String value) {
            addCriterion("grdt_dt like", value, "grdtDt");
            return (Criteria) this;
        }

        public Criteria andGrdtDtNotLike(String value) {
            addCriterion("grdt_dt not like", value, "grdtDt");
            return (Criteria) this;
        }

        public Criteria andGrdtDtIn(List<String> values) {
            addCriterion("grdt_dt in", values, "grdtDt");
            return (Criteria) this;
        }

        public Criteria andGrdtDtNotIn(List<String> values) {
            addCriterion("grdt_dt not in", values, "grdtDt");
            return (Criteria) this;
        }

        public Criteria andGrdtDtBetween(String value1, String value2) {
            addCriterion("grdt_dt between", value1, value2, "grdtDt");
            return (Criteria) this;
        }

        public Criteria andGrdtDtNotBetween(String value1, String value2) {
            addCriterion("grdt_dt not between", value1, value2, "grdtDt");
            return (Criteria) this;
        }

        public Criteria andNtUntIsNull() {
            addCriterion("nt_unt is null");
            return (Criteria) this;
        }

        public Criteria andNtUntIsNotNull() {
            addCriterion("nt_unt is not null");
            return (Criteria) this;
        }

        public Criteria andNtUntEqualTo(String value) {
            addCriterion("nt_unt =", value, "ntUnt");
            return (Criteria) this;
        }

        public Criteria andNtUntNotEqualTo(String value) {
            addCriterion("nt_unt <>", value, "ntUnt");
            return (Criteria) this;
        }

        public Criteria andNtUntGreaterThan(String value) {
            addCriterion("nt_unt >", value, "ntUnt");
            return (Criteria) this;
        }

        public Criteria andNtUntGreaterThanOrEqualTo(String value) {
            addCriterion("nt_unt >=", value, "ntUnt");
            return (Criteria) this;
        }

        public Criteria andNtUntLessThan(String value) {
            addCriterion("nt_unt <", value, "ntUnt");
            return (Criteria) this;
        }

        public Criteria andNtUntLessThanOrEqualTo(String value) {
            addCriterion("nt_unt <=", value, "ntUnt");
            return (Criteria) this;
        }

        public Criteria andNtUntLike(String value) {
            addCriterion("nt_unt like", value, "ntUnt");
            return (Criteria) this;
        }

        public Criteria andNtUntNotLike(String value) {
            addCriterion("nt_unt not like", value, "ntUnt");
            return (Criteria) this;
        }

        public Criteria andNtUntIn(List<String> values) {
            addCriterion("nt_unt in", values, "ntUnt");
            return (Criteria) this;
        }

        public Criteria andNtUntNotIn(List<String> values) {
            addCriterion("nt_unt not in", values, "ntUnt");
            return (Criteria) this;
        }

        public Criteria andNtUntBetween(String value1, String value2) {
            addCriterion("nt_unt between", value1, value2, "ntUnt");
            return (Criteria) this;
        }

        public Criteria andNtUntNotBetween(String value1, String value2) {
            addCriterion("nt_unt not between", value1, value2, "ntUnt");
            return (Criteria) this;
        }

        public Criteria andTchnldgLvIsNull() {
            addCriterion("tchnldg_lv is null");
            return (Criteria) this;
        }

        public Criteria andTchnldgLvIsNotNull() {
            addCriterion("tchnldg_lv is not null");
            return (Criteria) this;
        }

        public Criteria andTchnldgLvEqualTo(String value) {
            addCriterion("tchnldg_lv =", value, "tchnldgLv");
            return (Criteria) this;
        }

        public Criteria andTchnldgLvNotEqualTo(String value) {
            addCriterion("tchnldg_lv <>", value, "tchnldgLv");
            return (Criteria) this;
        }

        public Criteria andTchnldgLvGreaterThan(String value) {
            addCriterion("tchnldg_lv >", value, "tchnldgLv");
            return (Criteria) this;
        }

        public Criteria andTchnldgLvGreaterThanOrEqualTo(String value) {
            addCriterion("tchnldg_lv >=", value, "tchnldgLv");
            return (Criteria) this;
        }

        public Criteria andTchnldgLvLessThan(String value) {
            addCriterion("tchnldg_lv <", value, "tchnldgLv");
            return (Criteria) this;
        }

        public Criteria andTchnldgLvLessThanOrEqualTo(String value) {
            addCriterion("tchnldg_lv <=", value, "tchnldgLv");
            return (Criteria) this;
        }

        public Criteria andTchnldgLvLike(String value) {
            addCriterion("tchnldg_lv like", value, "tchnldgLv");
            return (Criteria) this;
        }

        public Criteria andTchnldgLvNotLike(String value) {
            addCriterion("tchnldg_lv not like", value, "tchnldgLv");
            return (Criteria) this;
        }

        public Criteria andTchnldgLvIn(List<String> values) {
            addCriterion("tchnldg_lv in", values, "tchnldgLv");
            return (Criteria) this;
        }

        public Criteria andTchnldgLvNotIn(List<String> values) {
            addCriterion("tchnldg_lv not in", values, "tchnldgLv");
            return (Criteria) this;
        }

        public Criteria andTchnldgLvBetween(String value1, String value2) {
            addCriterion("tchnldg_lv between", value1, value2, "tchnldgLv");
            return (Criteria) this;
        }

        public Criteria andTchnldgLvNotBetween(String value1, String value2) {
            addCriterion("tchnldg_lv not between", value1, value2, "tchnldgLv");
            return (Criteria) this;
        }

        public Criteria andIdntfyUntIsNull() {
            addCriterion("idntfy_unt is null");
            return (Criteria) this;
        }

        public Criteria andIdntfyUntIsNotNull() {
            addCriterion("idntfy_unt is not null");
            return (Criteria) this;
        }

        public Criteria andIdntfyUntEqualTo(String value) {
            addCriterion("idntfy_unt =", value, "idntfyUnt");
            return (Criteria) this;
        }

        public Criteria andIdntfyUntNotEqualTo(String value) {
            addCriterion("idntfy_unt <>", value, "idntfyUnt");
            return (Criteria) this;
        }

        public Criteria andIdntfyUntGreaterThan(String value) {
            addCriterion("idntfy_unt >", value, "idntfyUnt");
            return (Criteria) this;
        }

        public Criteria andIdntfyUntGreaterThanOrEqualTo(String value) {
            addCriterion("idntfy_unt >=", value, "idntfyUnt");
            return (Criteria) this;
        }

        public Criteria andIdntfyUntLessThan(String value) {
            addCriterion("idntfy_unt <", value, "idntfyUnt");
            return (Criteria) this;
        }

        public Criteria andIdntfyUntLessThanOrEqualTo(String value) {
            addCriterion("idntfy_unt <=", value, "idntfyUnt");
            return (Criteria) this;
        }

        public Criteria andIdntfyUntLike(String value) {
            addCriterion("idntfy_unt like", value, "idntfyUnt");
            return (Criteria) this;
        }

        public Criteria andIdntfyUntNotLike(String value) {
            addCriterion("idntfy_unt not like", value, "idntfyUnt");
            return (Criteria) this;
        }

        public Criteria andIdntfyUntIn(List<String> values) {
            addCriterion("idntfy_unt in", values, "idntfyUnt");
            return (Criteria) this;
        }

        public Criteria andIdntfyUntNotIn(List<String> values) {
            addCriterion("idntfy_unt not in", values, "idntfyUnt");
            return (Criteria) this;
        }

        public Criteria andIdntfyUntBetween(String value1, String value2) {
            addCriterion("idntfy_unt between", value1, value2, "idntfyUnt");
            return (Criteria) this;
        }

        public Criteria andIdntfyUntNotBetween(String value1, String value2) {
            addCriterion("idntfy_unt not between", value1, value2, "idntfyUnt");
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

        public Criteria andWtrItmIsNull() {
            addCriterion("wtr_itm is null");
            return (Criteria) this;
        }

        public Criteria andWtrItmIsNotNull() {
            addCriterion("wtr_itm is not null");
            return (Criteria) this;
        }

        public Criteria andWtrItmEqualTo(String value) {
            addCriterion("wtr_itm =", value, "wtrItm");
            return (Criteria) this;
        }

        public Criteria andWtrItmNotEqualTo(String value) {
            addCriterion("wtr_itm <>", value, "wtrItm");
            return (Criteria) this;
        }

        public Criteria andWtrItmGreaterThan(String value) {
            addCriterion("wtr_itm >", value, "wtrItm");
            return (Criteria) this;
        }

        public Criteria andWtrItmGreaterThanOrEqualTo(String value) {
            addCriterion("wtr_itm >=", value, "wtrItm");
            return (Criteria) this;
        }

        public Criteria andWtrItmLessThan(String value) {
            addCriterion("wtr_itm <", value, "wtrItm");
            return (Criteria) this;
        }

        public Criteria andWtrItmLessThanOrEqualTo(String value) {
            addCriterion("wtr_itm <=", value, "wtrItm");
            return (Criteria) this;
        }

        public Criteria andWtrItmLike(String value) {
            addCriterion("wtr_itm like", value, "wtrItm");
            return (Criteria) this;
        }

        public Criteria andWtrItmNotLike(String value) {
            addCriterion("wtr_itm not like", value, "wtrItm");
            return (Criteria) this;
        }

        public Criteria andWtrItmIn(List<String> values) {
            addCriterion("wtr_itm in", values, "wtrItm");
            return (Criteria) this;
        }

        public Criteria andWtrItmNotIn(List<String> values) {
            addCriterion("wtr_itm not in", values, "wtrItm");
            return (Criteria) this;
        }

        public Criteria andWtrItmBetween(String value1, String value2) {
            addCriterion("wtr_itm between", value1, value2, "wtrItm");
            return (Criteria) this;
        }

        public Criteria andWtrItmNotBetween(String value1, String value2) {
            addCriterion("wtr_itm not between", value1, value2, "wtrItm");
            return (Criteria) this;
        }

        public Criteria andWtrOrdrIsNull() {
            addCriterion("wtr_ordr is null");
            return (Criteria) this;
        }

        public Criteria andWtrOrdrIsNotNull() {
            addCriterion("wtr_ordr is not null");
            return (Criteria) this;
        }

        public Criteria andWtrOrdrEqualTo(String value) {
            addCriterion("wtr_ordr =", value, "wtrOrdr");
            return (Criteria) this;
        }

        public Criteria andWtrOrdrNotEqualTo(String value) {
            addCriterion("wtr_ordr <>", value, "wtrOrdr");
            return (Criteria) this;
        }

        public Criteria andWtrOrdrGreaterThan(String value) {
            addCriterion("wtr_ordr >", value, "wtrOrdr");
            return (Criteria) this;
        }

        public Criteria andWtrOrdrGreaterThanOrEqualTo(String value) {
            addCriterion("wtr_ordr >=", value, "wtrOrdr");
            return (Criteria) this;
        }

        public Criteria andWtrOrdrLessThan(String value) {
            addCriterion("wtr_ordr <", value, "wtrOrdr");
            return (Criteria) this;
        }

        public Criteria andWtrOrdrLessThanOrEqualTo(String value) {
            addCriterion("wtr_ordr <=", value, "wtrOrdr");
            return (Criteria) this;
        }

        public Criteria andWtrOrdrLike(String value) {
            addCriterion("wtr_ordr like", value, "wtrOrdr");
            return (Criteria) this;
        }

        public Criteria andWtrOrdrNotLike(String value) {
            addCriterion("wtr_ordr not like", value, "wtrOrdr");
            return (Criteria) this;
        }

        public Criteria andWtrOrdrIn(List<String> values) {
            addCriterion("wtr_ordr in", values, "wtrOrdr");
            return (Criteria) this;
        }

        public Criteria andWtrOrdrNotIn(List<String> values) {
            addCriterion("wtr_ordr not in", values, "wtrOrdr");
            return (Criteria) this;
        }

        public Criteria andWtrOrdrBetween(String value1, String value2) {
            addCriterion("wtr_ordr between", value1, value2, "wtrOrdr");
            return (Criteria) this;
        }

        public Criteria andWtrOrdrNotBetween(String value1, String value2) {
            addCriterion("wtr_ordr not between", value1, value2, "wtrOrdr");
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