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

        public Criteria andStaffUserIdIsNull() {
            addCriterion("staff_user_id is null");
            return (Criteria) this;
        }

        public Criteria andStaffUserIdIsNotNull() {
            addCriterion("staff_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andStaffUserIdEqualTo(String value) {
            addCriterion("staff_user_id =", value, "staffUserId");
            return (Criteria) this;
        }

        public Criteria andStaffUserIdNotEqualTo(String value) {
            addCriterion("staff_user_id <>", value, "staffUserId");
            return (Criteria) this;
        }

        public Criteria andStaffUserIdGreaterThan(String value) {
            addCriterion("staff_user_id >", value, "staffUserId");
            return (Criteria) this;
        }

        public Criteria andStaffUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("staff_user_id >=", value, "staffUserId");
            return (Criteria) this;
        }

        public Criteria andStaffUserIdLessThan(String value) {
            addCriterion("staff_user_id <", value, "staffUserId");
            return (Criteria) this;
        }

        public Criteria andStaffUserIdLessThanOrEqualTo(String value) {
            addCriterion("staff_user_id <=", value, "staffUserId");
            return (Criteria) this;
        }

        public Criteria andStaffUserIdLike(String value) {
            addCriterion("staff_user_id like", value, "staffUserId");
            return (Criteria) this;
        }

        public Criteria andStaffUserIdNotLike(String value) {
            addCriterion("staff_user_id not like", value, "staffUserId");
            return (Criteria) this;
        }

        public Criteria andStaffUserIdIn(List<String> values) {
            addCriterion("staff_user_id in", values, "staffUserId");
            return (Criteria) this;
        }

        public Criteria andStaffUserIdNotIn(List<String> values) {
            addCriterion("staff_user_id not in", values, "staffUserId");
            return (Criteria) this;
        }

        public Criteria andStaffUserIdBetween(String value1, String value2) {
            addCriterion("staff_user_id between", value1, value2, "staffUserId");
            return (Criteria) this;
        }

        public Criteria andStaffUserIdNotBetween(String value1, String value2) {
            addCriterion("staff_user_id not between", value1, value2, "staffUserId");
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

        public Criteria andWhetherLeaderIsNull() {
            addCriterion("whether_leader is null");
            return (Criteria) this;
        }

        public Criteria andWhetherLeaderIsNotNull() {
            addCriterion("whether_leader is not null");
            return (Criteria) this;
        }

        public Criteria andWhetherLeaderEqualTo(String value) {
            addCriterion("whether_leader =", value, "whetherLeader");
            return (Criteria) this;
        }

        public Criteria andWhetherLeaderNotEqualTo(String value) {
            addCriterion("whether_leader <>", value, "whetherLeader");
            return (Criteria) this;
        }

        public Criteria andWhetherLeaderGreaterThan(String value) {
            addCriterion("whether_leader >", value, "whetherLeader");
            return (Criteria) this;
        }

        public Criteria andWhetherLeaderGreaterThanOrEqualTo(String value) {
            addCriterion("whether_leader >=", value, "whetherLeader");
            return (Criteria) this;
        }

        public Criteria andWhetherLeaderLessThan(String value) {
            addCriterion("whether_leader <", value, "whetherLeader");
            return (Criteria) this;
        }

        public Criteria andWhetherLeaderLessThanOrEqualTo(String value) {
            addCriterion("whether_leader <=", value, "whetherLeader");
            return (Criteria) this;
        }

        public Criteria andWhetherLeaderLike(String value) {
            addCriterion("whether_leader like", value, "whetherLeader");
            return (Criteria) this;
        }

        public Criteria andWhetherLeaderNotLike(String value) {
            addCriterion("whether_leader not like", value, "whetherLeader");
            return (Criteria) this;
        }

        public Criteria andWhetherLeaderIn(List<String> values) {
            addCriterion("whether_leader in", values, "whetherLeader");
            return (Criteria) this;
        }

        public Criteria andWhetherLeaderNotIn(List<String> values) {
            addCriterion("whether_leader not in", values, "whetherLeader");
            return (Criteria) this;
        }

        public Criteria andWhetherLeaderBetween(String value1, String value2) {
            addCriterion("whether_leader between", value1, value2, "whetherLeader");
            return (Criteria) this;
        }

        public Criteria andWhetherLeaderNotBetween(String value1, String value2) {
            addCriterion("whether_leader not between", value1, value2, "whetherLeader");
            return (Criteria) this;
        }

        public Criteria andPositionIsNull() {
            addCriterion("position is null");
            return (Criteria) this;
        }

        public Criteria andPositionIsNotNull() {
            addCriterion("position is not null");
            return (Criteria) this;
        }

        public Criteria andPositionEqualTo(String value) {
            addCriterion("position =", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotEqualTo(String value) {
            addCriterion("position <>", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThan(String value) {
            addCriterion("position >", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThanOrEqualTo(String value) {
            addCriterion("position >=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThan(String value) {
            addCriterion("position <", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThanOrEqualTo(String value) {
            addCriterion("position <=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLike(String value) {
            addCriterion("position like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotLike(String value) {
            addCriterion("position not like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionIn(List<String> values) {
            addCriterion("position in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotIn(List<String> values) {
            addCriterion("position not in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionBetween(String value1, String value2) {
            addCriterion("position between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotBetween(String value1, String value2) {
            addCriterion("position not between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andIdNoIsNull() {
            addCriterion("id_no is null");
            return (Criteria) this;
        }

        public Criteria andIdNoIsNotNull() {
            addCriterion("id_no is not null");
            return (Criteria) this;
        }

        public Criteria andIdNoEqualTo(String value) {
            addCriterion("id_no =", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoNotEqualTo(String value) {
            addCriterion("id_no <>", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoGreaterThan(String value) {
            addCriterion("id_no >", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoGreaterThanOrEqualTo(String value) {
            addCriterion("id_no >=", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoLessThan(String value) {
            addCriterion("id_no <", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoLessThanOrEqualTo(String value) {
            addCriterion("id_no <=", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoLike(String value) {
            addCriterion("id_no like", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoNotLike(String value) {
            addCriterion("id_no not like", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoIn(List<String> values) {
            addCriterion("id_no in", values, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoNotIn(List<String> values) {
            addCriterion("id_no not in", values, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoBetween(String value1, String value2) {
            addCriterion("id_no between", value1, value2, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoNotBetween(String value1, String value2) {
            addCriterion("id_no not between", value1, value2, "idNo");
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

        public Criteria andBranchPhoneIsNull() {
            addCriterion("branch_phone is null");
            return (Criteria) this;
        }

        public Criteria andBranchPhoneIsNotNull() {
            addCriterion("branch_phone is not null");
            return (Criteria) this;
        }

        public Criteria andBranchPhoneEqualTo(String value) {
            addCriterion("branch_phone =", value, "branchPhone");
            return (Criteria) this;
        }

        public Criteria andBranchPhoneNotEqualTo(String value) {
            addCriterion("branch_phone <>", value, "branchPhone");
            return (Criteria) this;
        }

        public Criteria andBranchPhoneGreaterThan(String value) {
            addCriterion("branch_phone >", value, "branchPhone");
            return (Criteria) this;
        }

        public Criteria andBranchPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("branch_phone >=", value, "branchPhone");
            return (Criteria) this;
        }

        public Criteria andBranchPhoneLessThan(String value) {
            addCriterion("branch_phone <", value, "branchPhone");
            return (Criteria) this;
        }

        public Criteria andBranchPhoneLessThanOrEqualTo(String value) {
            addCriterion("branch_phone <=", value, "branchPhone");
            return (Criteria) this;
        }

        public Criteria andBranchPhoneLike(String value) {
            addCriterion("branch_phone like", value, "branchPhone");
            return (Criteria) this;
        }

        public Criteria andBranchPhoneNotLike(String value) {
            addCriterion("branch_phone not like", value, "branchPhone");
            return (Criteria) this;
        }

        public Criteria andBranchPhoneIn(List<String> values) {
            addCriterion("branch_phone in", values, "branchPhone");
            return (Criteria) this;
        }

        public Criteria andBranchPhoneNotIn(List<String> values) {
            addCriterion("branch_phone not in", values, "branchPhone");
            return (Criteria) this;
        }

        public Criteria andBranchPhoneBetween(String value1, String value2) {
            addCriterion("branch_phone between", value1, value2, "branchPhone");
            return (Criteria) this;
        }

        public Criteria andBranchPhoneNotBetween(String value1, String value2) {
            addCriterion("branch_phone not between", value1, value2, "branchPhone");
            return (Criteria) this;
        }

        public Criteria andWorkAddressIsNull() {
            addCriterion("work_address is null");
            return (Criteria) this;
        }

        public Criteria andWorkAddressIsNotNull() {
            addCriterion("work_address is not null");
            return (Criteria) this;
        }

        public Criteria andWorkAddressEqualTo(String value) {
            addCriterion("work_address =", value, "workAddress");
            return (Criteria) this;
        }

        public Criteria andWorkAddressNotEqualTo(String value) {
            addCriterion("work_address <>", value, "workAddress");
            return (Criteria) this;
        }

        public Criteria andWorkAddressGreaterThan(String value) {
            addCriterion("work_address >", value, "workAddress");
            return (Criteria) this;
        }

        public Criteria andWorkAddressGreaterThanOrEqualTo(String value) {
            addCriterion("work_address >=", value, "workAddress");
            return (Criteria) this;
        }

        public Criteria andWorkAddressLessThan(String value) {
            addCriterion("work_address <", value, "workAddress");
            return (Criteria) this;
        }

        public Criteria andWorkAddressLessThanOrEqualTo(String value) {
            addCriterion("work_address <=", value, "workAddress");
            return (Criteria) this;
        }

        public Criteria andWorkAddressLike(String value) {
            addCriterion("work_address like", value, "workAddress");
            return (Criteria) this;
        }

        public Criteria andWorkAddressNotLike(String value) {
            addCriterion("work_address not like", value, "workAddress");
            return (Criteria) this;
        }

        public Criteria andWorkAddressIn(List<String> values) {
            addCriterion("work_address in", values, "workAddress");
            return (Criteria) this;
        }

        public Criteria andWorkAddressNotIn(List<String> values) {
            addCriterion("work_address not in", values, "workAddress");
            return (Criteria) this;
        }

        public Criteria andWorkAddressBetween(String value1, String value2) {
            addCriterion("work_address between", value1, value2, "workAddress");
            return (Criteria) this;
        }

        public Criteria andWorkAddressNotBetween(String value1, String value2) {
            addCriterion("work_address not between", value1, value2, "workAddress");
            return (Criteria) this;
        }

        public Criteria andComment1IsNull() {
            addCriterion("comment1 is null");
            return (Criteria) this;
        }

        public Criteria andComment1IsNotNull() {
            addCriterion("comment1 is not null");
            return (Criteria) this;
        }

        public Criteria andComment1EqualTo(String value) {
            addCriterion("comment1 =", value, "comment1");
            return (Criteria) this;
        }

        public Criteria andComment1NotEqualTo(String value) {
            addCriterion("comment1 <>", value, "comment1");
            return (Criteria) this;
        }

        public Criteria andComment1GreaterThan(String value) {
            addCriterion("comment1 >", value, "comment1");
            return (Criteria) this;
        }

        public Criteria andComment1GreaterThanOrEqualTo(String value) {
            addCriterion("comment1 >=", value, "comment1");
            return (Criteria) this;
        }

        public Criteria andComment1LessThan(String value) {
            addCriterion("comment1 <", value, "comment1");
            return (Criteria) this;
        }

        public Criteria andComment1LessThanOrEqualTo(String value) {
            addCriterion("comment1 <=", value, "comment1");
            return (Criteria) this;
        }

        public Criteria andComment1Like(String value) {
            addCriterion("comment1 like", value, "comment1");
            return (Criteria) this;
        }

        public Criteria andComment1NotLike(String value) {
            addCriterion("comment1 not like", value, "comment1");
            return (Criteria) this;
        }

        public Criteria andComment1In(List<String> values) {
            addCriterion("comment1 in", values, "comment1");
            return (Criteria) this;
        }

        public Criteria andComment1NotIn(List<String> values) {
            addCriterion("comment1 not in", values, "comment1");
            return (Criteria) this;
        }

        public Criteria andComment1Between(String value1, String value2) {
            addCriterion("comment1 between", value1, value2, "comment1");
            return (Criteria) this;
        }

        public Criteria andComment1NotBetween(String value1, String value2) {
            addCriterion("comment1 not between", value1, value2, "comment1");
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

        public Criteria andYindaIdentifyIsNull() {
            addCriterion("Yinda_identify is null");
            return (Criteria) this;
        }

        public Criteria andYindaIdentifyIsNotNull() {
            addCriterion("Yinda_identify is not null");
            return (Criteria) this;
        }

        public Criteria andYindaIdentifyEqualTo(String value) {
            addCriterion("Yinda_identify =", value, "yindaIdentify");
            return (Criteria) this;
        }

        public Criteria andYindaIdentifyNotEqualTo(String value) {
            addCriterion("Yinda_identify <>", value, "yindaIdentify");
            return (Criteria) this;
        }

        public Criteria andYindaIdentifyGreaterThan(String value) {
            addCriterion("Yinda_identify >", value, "yindaIdentify");
            return (Criteria) this;
        }

        public Criteria andYindaIdentifyGreaterThanOrEqualTo(String value) {
            addCriterion("Yinda_identify >=", value, "yindaIdentify");
            return (Criteria) this;
        }

        public Criteria andYindaIdentifyLessThan(String value) {
            addCriterion("Yinda_identify <", value, "yindaIdentify");
            return (Criteria) this;
        }

        public Criteria andYindaIdentifyLessThanOrEqualTo(String value) {
            addCriterion("Yinda_identify <=", value, "yindaIdentify");
            return (Criteria) this;
        }

        public Criteria andYindaIdentifyLike(String value) {
            addCriterion("Yinda_identify like", value, "yindaIdentify");
            return (Criteria) this;
        }

        public Criteria andYindaIdentifyNotLike(String value) {
            addCriterion("Yinda_identify not like", value, "yindaIdentify");
            return (Criteria) this;
        }

        public Criteria andYindaIdentifyIn(List<String> values) {
            addCriterion("Yinda_identify in", values, "yindaIdentify");
            return (Criteria) this;
        }

        public Criteria andYindaIdentifyNotIn(List<String> values) {
            addCriterion("Yinda_identify not in", values, "yindaIdentify");
            return (Criteria) this;
        }

        public Criteria andYindaIdentifyBetween(String value1, String value2) {
            addCriterion("Yinda_identify between", value1, value2, "yindaIdentify");
            return (Criteria) this;
        }

        public Criteria andYindaIdentifyNotBetween(String value1, String value2) {
            addCriterion("Yinda_identify not between", value1, value2, "yindaIdentify");
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

        public Criteria andComment2IsNull() {
            addCriterion("comment2 is null");
            return (Criteria) this;
        }

        public Criteria andComment2IsNotNull() {
            addCriterion("comment2 is not null");
            return (Criteria) this;
        }

        public Criteria andComment2EqualTo(String value) {
            addCriterion("comment2 =", value, "comment2");
            return (Criteria) this;
        }

        public Criteria andComment2NotEqualTo(String value) {
            addCriterion("comment2 <>", value, "comment2");
            return (Criteria) this;
        }

        public Criteria andComment2GreaterThan(String value) {
            addCriterion("comment2 >", value, "comment2");
            return (Criteria) this;
        }

        public Criteria andComment2GreaterThanOrEqualTo(String value) {
            addCriterion("comment2 >=", value, "comment2");
            return (Criteria) this;
        }

        public Criteria andComment2LessThan(String value) {
            addCriterion("comment2 <", value, "comment2");
            return (Criteria) this;
        }

        public Criteria andComment2LessThanOrEqualTo(String value) {
            addCriterion("comment2 <=", value, "comment2");
            return (Criteria) this;
        }

        public Criteria andComment2Like(String value) {
            addCriterion("comment2 like", value, "comment2");
            return (Criteria) this;
        }

        public Criteria andComment2NotLike(String value) {
            addCriterion("comment2 not like", value, "comment2");
            return (Criteria) this;
        }

        public Criteria andComment2In(List<String> values) {
            addCriterion("comment2 in", values, "comment2");
            return (Criteria) this;
        }

        public Criteria andComment2NotIn(List<String> values) {
            addCriterion("comment2 not in", values, "comment2");
            return (Criteria) this;
        }

        public Criteria andComment2Between(String value1, String value2) {
            addCriterion("comment2 between", value1, value2, "comment2");
            return (Criteria) this;
        }

        public Criteria andComment2NotBetween(String value1, String value2) {
            addCriterion("comment2 not between", value1, value2, "comment2");
            return (Criteria) this;
        }

        public Criteria andHouseholdAddressIsNull() {
            addCriterion("household_address is null");
            return (Criteria) this;
        }

        public Criteria andHouseholdAddressIsNotNull() {
            addCriterion("household_address is not null");
            return (Criteria) this;
        }

        public Criteria andHouseholdAddressEqualTo(String value) {
            addCriterion("household_address =", value, "householdAddress");
            return (Criteria) this;
        }

        public Criteria andHouseholdAddressNotEqualTo(String value) {
            addCriterion("household_address <>", value, "householdAddress");
            return (Criteria) this;
        }

        public Criteria andHouseholdAddressGreaterThan(String value) {
            addCriterion("household_address >", value, "householdAddress");
            return (Criteria) this;
        }

        public Criteria andHouseholdAddressGreaterThanOrEqualTo(String value) {
            addCriterion("household_address >=", value, "householdAddress");
            return (Criteria) this;
        }

        public Criteria andHouseholdAddressLessThan(String value) {
            addCriterion("household_address <", value, "householdAddress");
            return (Criteria) this;
        }

        public Criteria andHouseholdAddressLessThanOrEqualTo(String value) {
            addCriterion("household_address <=", value, "householdAddress");
            return (Criteria) this;
        }

        public Criteria andHouseholdAddressLike(String value) {
            addCriterion("household_address like", value, "householdAddress");
            return (Criteria) this;
        }

        public Criteria andHouseholdAddressNotLike(String value) {
            addCriterion("household_address not like", value, "householdAddress");
            return (Criteria) this;
        }

        public Criteria andHouseholdAddressIn(List<String> values) {
            addCriterion("household_address in", values, "householdAddress");
            return (Criteria) this;
        }

        public Criteria andHouseholdAddressNotIn(List<String> values) {
            addCriterion("household_address not in", values, "householdAddress");
            return (Criteria) this;
        }

        public Criteria andHouseholdAddressBetween(String value1, String value2) {
            addCriterion("household_address between", value1, value2, "householdAddress");
            return (Criteria) this;
        }

        public Criteria andHouseholdAddressNotBetween(String value1, String value2) {
            addCriterion("household_address not between", value1, value2, "householdAddress");
            return (Criteria) this;
        }

        public Criteria andBranchCompanyIsNull() {
            addCriterion("branch_company is null");
            return (Criteria) this;
        }

        public Criteria andBranchCompanyIsNotNull() {
            addCriterion("branch_company is not null");
            return (Criteria) this;
        }

        public Criteria andBranchCompanyEqualTo(String value) {
            addCriterion("branch_company =", value, "branchCompany");
            return (Criteria) this;
        }

        public Criteria andBranchCompanyNotEqualTo(String value) {
            addCriterion("branch_company <>", value, "branchCompany");
            return (Criteria) this;
        }

        public Criteria andBranchCompanyGreaterThan(String value) {
            addCriterion("branch_company >", value, "branchCompany");
            return (Criteria) this;
        }

        public Criteria andBranchCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("branch_company >=", value, "branchCompany");
            return (Criteria) this;
        }

        public Criteria andBranchCompanyLessThan(String value) {
            addCriterion("branch_company <", value, "branchCompany");
            return (Criteria) this;
        }

        public Criteria andBranchCompanyLessThanOrEqualTo(String value) {
            addCriterion("branch_company <=", value, "branchCompany");
            return (Criteria) this;
        }

        public Criteria andBranchCompanyLike(String value) {
            addCriterion("branch_company like", value, "branchCompany");
            return (Criteria) this;
        }

        public Criteria andBranchCompanyNotLike(String value) {
            addCriterion("branch_company not like", value, "branchCompany");
            return (Criteria) this;
        }

        public Criteria andBranchCompanyIn(List<String> values) {
            addCriterion("branch_company in", values, "branchCompany");
            return (Criteria) this;
        }

        public Criteria andBranchCompanyNotIn(List<String> values) {
            addCriterion("branch_company not in", values, "branchCompany");
            return (Criteria) this;
        }

        public Criteria andBranchCompanyBetween(String value1, String value2) {
            addCriterion("branch_company between", value1, value2, "branchCompany");
            return (Criteria) this;
        }

        public Criteria andBranchCompanyNotBetween(String value1, String value2) {
            addCriterion("branch_company not between", value1, value2, "branchCompany");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityAddressIsNull() {
            addCriterion("social_security_address is null");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityAddressIsNotNull() {
            addCriterion("social_security_address is not null");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityAddressEqualTo(String value) {
            addCriterion("social_security_address =", value, "socialSecurityAddress");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityAddressNotEqualTo(String value) {
            addCriterion("social_security_address <>", value, "socialSecurityAddress");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityAddressGreaterThan(String value) {
            addCriterion("social_security_address >", value, "socialSecurityAddress");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityAddressGreaterThanOrEqualTo(String value) {
            addCriterion("social_security_address >=", value, "socialSecurityAddress");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityAddressLessThan(String value) {
            addCriterion("social_security_address <", value, "socialSecurityAddress");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityAddressLessThanOrEqualTo(String value) {
            addCriterion("social_security_address <=", value, "socialSecurityAddress");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityAddressLike(String value) {
            addCriterion("social_security_address like", value, "socialSecurityAddress");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityAddressNotLike(String value) {
            addCriterion("social_security_address not like", value, "socialSecurityAddress");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityAddressIn(List<String> values) {
            addCriterion("social_security_address in", values, "socialSecurityAddress");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityAddressNotIn(List<String> values) {
            addCriterion("social_security_address not in", values, "socialSecurityAddress");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityAddressBetween(String value1, String value2) {
            addCriterion("social_security_address between", value1, value2, "socialSecurityAddress");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityAddressNotBetween(String value1, String value2) {
            addCriterion("social_security_address not between", value1, value2, "socialSecurityAddress");
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

        public Criteria andRsoIdentifyIsNull() {
            addCriterion("RSO_identify is null");
            return (Criteria) this;
        }

        public Criteria andRsoIdentifyIsNotNull() {
            addCriterion("RSO_identify is not null");
            return (Criteria) this;
        }

        public Criteria andRsoIdentifyEqualTo(String value) {
            addCriterion("RSO_identify =", value, "rsoIdentify");
            return (Criteria) this;
        }

        public Criteria andRsoIdentifyNotEqualTo(String value) {
            addCriterion("RSO_identify <>", value, "rsoIdentify");
            return (Criteria) this;
        }

        public Criteria andRsoIdentifyGreaterThan(String value) {
            addCriterion("RSO_identify >", value, "rsoIdentify");
            return (Criteria) this;
        }

        public Criteria andRsoIdentifyGreaterThanOrEqualTo(String value) {
            addCriterion("RSO_identify >=", value, "rsoIdentify");
            return (Criteria) this;
        }

        public Criteria andRsoIdentifyLessThan(String value) {
            addCriterion("RSO_identify <", value, "rsoIdentify");
            return (Criteria) this;
        }

        public Criteria andRsoIdentifyLessThanOrEqualTo(String value) {
            addCriterion("RSO_identify <=", value, "rsoIdentify");
            return (Criteria) this;
        }

        public Criteria andRsoIdentifyLike(String value) {
            addCriterion("RSO_identify like", value, "rsoIdentify");
            return (Criteria) this;
        }

        public Criteria andRsoIdentifyNotLike(String value) {
            addCriterion("RSO_identify not like", value, "rsoIdentify");
            return (Criteria) this;
        }

        public Criteria andRsoIdentifyIn(List<String> values) {
            addCriterion("RSO_identify in", values, "rsoIdentify");
            return (Criteria) this;
        }

        public Criteria andRsoIdentifyNotIn(List<String> values) {
            addCriterion("RSO_identify not in", values, "rsoIdentify");
            return (Criteria) this;
        }

        public Criteria andRsoIdentifyBetween(String value1, String value2) {
            addCriterion("RSO_identify between", value1, value2, "rsoIdentify");
            return (Criteria) this;
        }

        public Criteria andRsoIdentifyNotBetween(String value1, String value2) {
            addCriterion("RSO_identify not between", value1, value2, "rsoIdentify");
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

        public Criteria andItemSalaryIsNull() {
            addCriterion("item_salary is null");
            return (Criteria) this;
        }

        public Criteria andItemSalaryIsNotNull() {
            addCriterion("item_salary is not null");
            return (Criteria) this;
        }

        public Criteria andItemSalaryEqualTo(String value) {
            addCriterion("item_salary =", value, "itemSalary");
            return (Criteria) this;
        }

        public Criteria andItemSalaryNotEqualTo(String value) {
            addCriterion("item_salary <>", value, "itemSalary");
            return (Criteria) this;
        }

        public Criteria andItemSalaryGreaterThan(String value) {
            addCriterion("item_salary >", value, "itemSalary");
            return (Criteria) this;
        }

        public Criteria andItemSalaryGreaterThanOrEqualTo(String value) {
            addCriterion("item_salary >=", value, "itemSalary");
            return (Criteria) this;
        }

        public Criteria andItemSalaryLessThan(String value) {
            addCriterion("item_salary <", value, "itemSalary");
            return (Criteria) this;
        }

        public Criteria andItemSalaryLessThanOrEqualTo(String value) {
            addCriterion("item_salary <=", value, "itemSalary");
            return (Criteria) this;
        }

        public Criteria andItemSalaryLike(String value) {
            addCriterion("item_salary like", value, "itemSalary");
            return (Criteria) this;
        }

        public Criteria andItemSalaryNotLike(String value) {
            addCriterion("item_salary not like", value, "itemSalary");
            return (Criteria) this;
        }

        public Criteria andItemSalaryIn(List<String> values) {
            addCriterion("item_salary in", values, "itemSalary");
            return (Criteria) this;
        }

        public Criteria andItemSalaryNotIn(List<String> values) {
            addCriterion("item_salary not in", values, "itemSalary");
            return (Criteria) this;
        }

        public Criteria andItemSalaryBetween(String value1, String value2) {
            addCriterion("item_salary between", value1, value2, "itemSalary");
            return (Criteria) this;
        }

        public Criteria andItemSalaryNotBetween(String value1, String value2) {
            addCriterion("item_salary not between", value1, value2, "itemSalary");
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

        public Criteria andAgeIsNull() {
            addCriterion("age is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("age is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(String value) {
            addCriterion("age =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(String value) {
            addCriterion("age <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(String value) {
            addCriterion("age >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(String value) {
            addCriterion("age >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(String value) {
            addCriterion("age <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(String value) {
            addCriterion("age <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLike(String value) {
            addCriterion("age like", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotLike(String value) {
            addCriterion("age not like", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<String> values) {
            addCriterion("age in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<String> values) {
            addCriterion("age not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(String value1, String value2) {
            addCriterion("age between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(String value1, String value2) {
            addCriterion("age not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andLastContractIsNull() {
            addCriterion("last_contract is null");
            return (Criteria) this;
        }

        public Criteria andLastContractIsNotNull() {
            addCriterion("last_contract is not null");
            return (Criteria) this;
        }

        public Criteria andLastContractEqualTo(String value) {
            addCriterion("last_contract =", value, "lastContract");
            return (Criteria) this;
        }

        public Criteria andLastContractNotEqualTo(String value) {
            addCriterion("last_contract <>", value, "lastContract");
            return (Criteria) this;
        }

        public Criteria andLastContractGreaterThan(String value) {
            addCriterion("last_contract >", value, "lastContract");
            return (Criteria) this;
        }

        public Criteria andLastContractGreaterThanOrEqualTo(String value) {
            addCriterion("last_contract >=", value, "lastContract");
            return (Criteria) this;
        }

        public Criteria andLastContractLessThan(String value) {
            addCriterion("last_contract <", value, "lastContract");
            return (Criteria) this;
        }

        public Criteria andLastContractLessThanOrEqualTo(String value) {
            addCriterion("last_contract <=", value, "lastContract");
            return (Criteria) this;
        }

        public Criteria andLastContractLike(String value) {
            addCriterion("last_contract like", value, "lastContract");
            return (Criteria) this;
        }

        public Criteria andLastContractNotLike(String value) {
            addCriterion("last_contract not like", value, "lastContract");
            return (Criteria) this;
        }

        public Criteria andLastContractIn(List<String> values) {
            addCriterion("last_contract in", values, "lastContract");
            return (Criteria) this;
        }

        public Criteria andLastContractNotIn(List<String> values) {
            addCriterion("last_contract not in", values, "lastContract");
            return (Criteria) this;
        }

        public Criteria andLastContractBetween(String value1, String value2) {
            addCriterion("last_contract between", value1, value2, "lastContract");
            return (Criteria) this;
        }

        public Criteria andLastContractNotBetween(String value1, String value2) {
            addCriterion("last_contract not between", value1, value2, "lastContract");
            return (Criteria) this;
        }

        public Criteria andLastContractBeginIsNull() {
            addCriterion("last_contract_begin is null");
            return (Criteria) this;
        }

        public Criteria andLastContractBeginIsNotNull() {
            addCriterion("last_contract_begin is not null");
            return (Criteria) this;
        }

        public Criteria andLastContractBeginEqualTo(String value) {
            addCriterion("last_contract_begin =", value, "lastContractBegin");
            return (Criteria) this;
        }

        public Criteria andLastContractBeginNotEqualTo(String value) {
            addCriterion("last_contract_begin <>", value, "lastContractBegin");
            return (Criteria) this;
        }

        public Criteria andLastContractBeginGreaterThan(String value) {
            addCriterion("last_contract_begin >", value, "lastContractBegin");
            return (Criteria) this;
        }

        public Criteria andLastContractBeginGreaterThanOrEqualTo(String value) {
            addCriterion("last_contract_begin >=", value, "lastContractBegin");
            return (Criteria) this;
        }

        public Criteria andLastContractBeginLessThan(String value) {
            addCriterion("last_contract_begin <", value, "lastContractBegin");
            return (Criteria) this;
        }

        public Criteria andLastContractBeginLessThanOrEqualTo(String value) {
            addCriterion("last_contract_begin <=", value, "lastContractBegin");
            return (Criteria) this;
        }

        public Criteria andLastContractBeginLike(String value) {
            addCriterion("last_contract_begin like", value, "lastContractBegin");
            return (Criteria) this;
        }

        public Criteria andLastContractBeginNotLike(String value) {
            addCriterion("last_contract_begin not like", value, "lastContractBegin");
            return (Criteria) this;
        }

        public Criteria andLastContractBeginIn(List<String> values) {
            addCriterion("last_contract_begin in", values, "lastContractBegin");
            return (Criteria) this;
        }

        public Criteria andLastContractBeginNotIn(List<String> values) {
            addCriterion("last_contract_begin not in", values, "lastContractBegin");
            return (Criteria) this;
        }

        public Criteria andLastContractBeginBetween(String value1, String value2) {
            addCriterion("last_contract_begin between", value1, value2, "lastContractBegin");
            return (Criteria) this;
        }

        public Criteria andLastContractBeginNotBetween(String value1, String value2) {
            addCriterion("last_contract_begin not between", value1, value2, "lastContractBegin");
            return (Criteria) this;
        }

        public Criteria andLastContractEndIsNull() {
            addCriterion("last_contract_end is null");
            return (Criteria) this;
        }

        public Criteria andLastContractEndIsNotNull() {
            addCriterion("last_contract_end is not null");
            return (Criteria) this;
        }

        public Criteria andLastContractEndEqualTo(String value) {
            addCriterion("last_contract_end =", value, "lastContractEnd");
            return (Criteria) this;
        }

        public Criteria andLastContractEndNotEqualTo(String value) {
            addCriterion("last_contract_end <>", value, "lastContractEnd");
            return (Criteria) this;
        }

        public Criteria andLastContractEndGreaterThan(String value) {
            addCriterion("last_contract_end >", value, "lastContractEnd");
            return (Criteria) this;
        }

        public Criteria andLastContractEndGreaterThanOrEqualTo(String value) {
            addCriterion("last_contract_end >=", value, "lastContractEnd");
            return (Criteria) this;
        }

        public Criteria andLastContractEndLessThan(String value) {
            addCriterion("last_contract_end <", value, "lastContractEnd");
            return (Criteria) this;
        }

        public Criteria andLastContractEndLessThanOrEqualTo(String value) {
            addCriterion("last_contract_end <=", value, "lastContractEnd");
            return (Criteria) this;
        }

        public Criteria andLastContractEndLike(String value) {
            addCriterion("last_contract_end like", value, "lastContractEnd");
            return (Criteria) this;
        }

        public Criteria andLastContractEndNotLike(String value) {
            addCriterion("last_contract_end not like", value, "lastContractEnd");
            return (Criteria) this;
        }

        public Criteria andLastContractEndIn(List<String> values) {
            addCriterion("last_contract_end in", values, "lastContractEnd");
            return (Criteria) this;
        }

        public Criteria andLastContractEndNotIn(List<String> values) {
            addCriterion("last_contract_end not in", values, "lastContractEnd");
            return (Criteria) this;
        }

        public Criteria andLastContractEndBetween(String value1, String value2) {
            addCriterion("last_contract_end between", value1, value2, "lastContractEnd");
            return (Criteria) this;
        }

        public Criteria andLastContractEndNotBetween(String value1, String value2) {
            addCriterion("last_contract_end not between", value1, value2, "lastContractEnd");
            return (Criteria) this;
        }

        public Criteria andEnterTimeIsNull() {
            addCriterion("enter_time is null");
            return (Criteria) this;
        }

        public Criteria andEnterTimeIsNotNull() {
            addCriterion("enter_time is not null");
            return (Criteria) this;
        }

        public Criteria andEnterTimeEqualTo(String value) {
            addCriterion("enter_time =", value, "enterTime");
            return (Criteria) this;
        }

        public Criteria andEnterTimeNotEqualTo(String value) {
            addCriterion("enter_time <>", value, "enterTime");
            return (Criteria) this;
        }

        public Criteria andEnterTimeGreaterThan(String value) {
            addCriterion("enter_time >", value, "enterTime");
            return (Criteria) this;
        }

        public Criteria andEnterTimeGreaterThanOrEqualTo(String value) {
            addCriterion("enter_time >=", value, "enterTime");
            return (Criteria) this;
        }

        public Criteria andEnterTimeLessThan(String value) {
            addCriterion("enter_time <", value, "enterTime");
            return (Criteria) this;
        }

        public Criteria andEnterTimeLessThanOrEqualTo(String value) {
            addCriterion("enter_time <=", value, "enterTime");
            return (Criteria) this;
        }

        public Criteria andEnterTimeLike(String value) {
            addCriterion("enter_time like", value, "enterTime");
            return (Criteria) this;
        }

        public Criteria andEnterTimeNotLike(String value) {
            addCriterion("enter_time not like", value, "enterTime");
            return (Criteria) this;
        }

        public Criteria andEnterTimeIn(List<String> values) {
            addCriterion("enter_time in", values, "enterTime");
            return (Criteria) this;
        }

        public Criteria andEnterTimeNotIn(List<String> values) {
            addCriterion("enter_time not in", values, "enterTime");
            return (Criteria) this;
        }

        public Criteria andEnterTimeBetween(String value1, String value2) {
            addCriterion("enter_time between", value1, value2, "enterTime");
            return (Criteria) this;
        }

        public Criteria andEnterTimeNotBetween(String value1, String value2) {
            addCriterion("enter_time not between", value1, value2, "enterTime");
            return (Criteria) this;
        }

        public Criteria andWorkYearIsNull() {
            addCriterion("work_year is null");
            return (Criteria) this;
        }

        public Criteria andWorkYearIsNotNull() {
            addCriterion("work_year is not null");
            return (Criteria) this;
        }

        public Criteria andWorkYearEqualTo(String value) {
            addCriterion("work_year =", value, "workYear");
            return (Criteria) this;
        }

        public Criteria andWorkYearNotEqualTo(String value) {
            addCriterion("work_year <>", value, "workYear");
            return (Criteria) this;
        }

        public Criteria andWorkYearGreaterThan(String value) {
            addCriterion("work_year >", value, "workYear");
            return (Criteria) this;
        }

        public Criteria andWorkYearGreaterThanOrEqualTo(String value) {
            addCriterion("work_year >=", value, "workYear");
            return (Criteria) this;
        }

        public Criteria andWorkYearLessThan(String value) {
            addCriterion("work_year <", value, "workYear");
            return (Criteria) this;
        }

        public Criteria andWorkYearLessThanOrEqualTo(String value) {
            addCriterion("work_year <=", value, "workYear");
            return (Criteria) this;
        }

        public Criteria andWorkYearLike(String value) {
            addCriterion("work_year like", value, "workYear");
            return (Criteria) this;
        }

        public Criteria andWorkYearNotLike(String value) {
            addCriterion("work_year not like", value, "workYear");
            return (Criteria) this;
        }

        public Criteria andWorkYearIn(List<String> values) {
            addCriterion("work_year in", values, "workYear");
            return (Criteria) this;
        }

        public Criteria andWorkYearNotIn(List<String> values) {
            addCriterion("work_year not in", values, "workYear");
            return (Criteria) this;
        }

        public Criteria andWorkYearBetween(String value1, String value2) {
            addCriterion("work_year between", value1, value2, "workYear");
            return (Criteria) this;
        }

        public Criteria andWorkYearNotBetween(String value1, String value2) {
            addCriterion("work_year not between", value1, value2, "workYear");
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

        public Criteria andGraduateSchoolIsNull() {
            addCriterion("graduate_school is null");
            return (Criteria) this;
        }

        public Criteria andGraduateSchoolIsNotNull() {
            addCriterion("graduate_school is not null");
            return (Criteria) this;
        }

        public Criteria andGraduateSchoolEqualTo(String value) {
            addCriterion("graduate_school =", value, "graduateSchool");
            return (Criteria) this;
        }

        public Criteria andGraduateSchoolNotEqualTo(String value) {
            addCriterion("graduate_school <>", value, "graduateSchool");
            return (Criteria) this;
        }

        public Criteria andGraduateSchoolGreaterThan(String value) {
            addCriterion("graduate_school >", value, "graduateSchool");
            return (Criteria) this;
        }

        public Criteria andGraduateSchoolGreaterThanOrEqualTo(String value) {
            addCriterion("graduate_school >=", value, "graduateSchool");
            return (Criteria) this;
        }

        public Criteria andGraduateSchoolLessThan(String value) {
            addCriterion("graduate_school <", value, "graduateSchool");
            return (Criteria) this;
        }

        public Criteria andGraduateSchoolLessThanOrEqualTo(String value) {
            addCriterion("graduate_school <=", value, "graduateSchool");
            return (Criteria) this;
        }

        public Criteria andGraduateSchoolLike(String value) {
            addCriterion("graduate_school like", value, "graduateSchool");
            return (Criteria) this;
        }

        public Criteria andGraduateSchoolNotLike(String value) {
            addCriterion("graduate_school not like", value, "graduateSchool");
            return (Criteria) this;
        }

        public Criteria andGraduateSchoolIn(List<String> values) {
            addCriterion("graduate_school in", values, "graduateSchool");
            return (Criteria) this;
        }

        public Criteria andGraduateSchoolNotIn(List<String> values) {
            addCriterion("graduate_school not in", values, "graduateSchool");
            return (Criteria) this;
        }

        public Criteria andGraduateSchoolBetween(String value1, String value2) {
            addCriterion("graduate_school between", value1, value2, "graduateSchool");
            return (Criteria) this;
        }

        public Criteria andGraduateSchoolNotBetween(String value1, String value2) {
            addCriterion("graduate_school not between", value1, value2, "graduateSchool");
            return (Criteria) this;
        }

        public Criteria andSchoolRecordIsNull() {
            addCriterion("school_record is null");
            return (Criteria) this;
        }

        public Criteria andSchoolRecordIsNotNull() {
            addCriterion("school_record is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolRecordEqualTo(String value) {
            addCriterion("school_record =", value, "schoolRecord");
            return (Criteria) this;
        }

        public Criteria andSchoolRecordNotEqualTo(String value) {
            addCriterion("school_record <>", value, "schoolRecord");
            return (Criteria) this;
        }

        public Criteria andSchoolRecordGreaterThan(String value) {
            addCriterion("school_record >", value, "schoolRecord");
            return (Criteria) this;
        }

        public Criteria andSchoolRecordGreaterThanOrEqualTo(String value) {
            addCriterion("school_record >=", value, "schoolRecord");
            return (Criteria) this;
        }

        public Criteria andSchoolRecordLessThan(String value) {
            addCriterion("school_record <", value, "schoolRecord");
            return (Criteria) this;
        }

        public Criteria andSchoolRecordLessThanOrEqualTo(String value) {
            addCriterion("school_record <=", value, "schoolRecord");
            return (Criteria) this;
        }

        public Criteria andSchoolRecordLike(String value) {
            addCriterion("school_record like", value, "schoolRecord");
            return (Criteria) this;
        }

        public Criteria andSchoolRecordNotLike(String value) {
            addCriterion("school_record not like", value, "schoolRecord");
            return (Criteria) this;
        }

        public Criteria andSchoolRecordIn(List<String> values) {
            addCriterion("school_record in", values, "schoolRecord");
            return (Criteria) this;
        }

        public Criteria andSchoolRecordNotIn(List<String> values) {
            addCriterion("school_record not in", values, "schoolRecord");
            return (Criteria) this;
        }

        public Criteria andSchoolRecordBetween(String value1, String value2) {
            addCriterion("school_record between", value1, value2, "schoolRecord");
            return (Criteria) this;
        }

        public Criteria andSchoolRecordNotBetween(String value1, String value2) {
            addCriterion("school_record not between", value1, value2, "schoolRecord");
            return (Criteria) this;
        }

        public Criteria andGraduateDateIsNull() {
            addCriterion("graduate_date is null");
            return (Criteria) this;
        }

        public Criteria andGraduateDateIsNotNull() {
            addCriterion("graduate_date is not null");
            return (Criteria) this;
        }

        public Criteria andGraduateDateEqualTo(String value) {
            addCriterion("graduate_date =", value, "graduateDate");
            return (Criteria) this;
        }

        public Criteria andGraduateDateNotEqualTo(String value) {
            addCriterion("graduate_date <>", value, "graduateDate");
            return (Criteria) this;
        }

        public Criteria andGraduateDateGreaterThan(String value) {
            addCriterion("graduate_date >", value, "graduateDate");
            return (Criteria) this;
        }

        public Criteria andGraduateDateGreaterThanOrEqualTo(String value) {
            addCriterion("graduate_date >=", value, "graduateDate");
            return (Criteria) this;
        }

        public Criteria andGraduateDateLessThan(String value) {
            addCriterion("graduate_date <", value, "graduateDate");
            return (Criteria) this;
        }

        public Criteria andGraduateDateLessThanOrEqualTo(String value) {
            addCriterion("graduate_date <=", value, "graduateDate");
            return (Criteria) this;
        }

        public Criteria andGraduateDateLike(String value) {
            addCriterion("graduate_date like", value, "graduateDate");
            return (Criteria) this;
        }

        public Criteria andGraduateDateNotLike(String value) {
            addCriterion("graduate_date not like", value, "graduateDate");
            return (Criteria) this;
        }

        public Criteria andGraduateDateIn(List<String> values) {
            addCriterion("graduate_date in", values, "graduateDate");
            return (Criteria) this;
        }

        public Criteria andGraduateDateNotIn(List<String> values) {
            addCriterion("graduate_date not in", values, "graduateDate");
            return (Criteria) this;
        }

        public Criteria andGraduateDateBetween(String value1, String value2) {
            addCriterion("graduate_date between", value1, value2, "graduateDate");
            return (Criteria) this;
        }

        public Criteria andGraduateDateNotBetween(String value1, String value2) {
            addCriterion("graduate_date not between", value1, value2, "graduateDate");
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

        public Criteria andItemIsNull() {
            addCriterion("item is null");
            return (Criteria) this;
        }

        public Criteria andItemIsNotNull() {
            addCriterion("item is not null");
            return (Criteria) this;
        }

        public Criteria andItemEqualTo(String value) {
            addCriterion("item =", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemNotEqualTo(String value) {
            addCriterion("item <>", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemGreaterThan(String value) {
            addCriterion("item >", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemGreaterThanOrEqualTo(String value) {
            addCriterion("item >=", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemLessThan(String value) {
            addCriterion("item <", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemLessThanOrEqualTo(String value) {
            addCriterion("item <=", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemLike(String value) {
            addCriterion("item like", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemNotLike(String value) {
            addCriterion("item not like", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemIn(List<String> values) {
            addCriterion("item in", values, "item");
            return (Criteria) this;
        }

        public Criteria andItemNotIn(List<String> values) {
            addCriterion("item not in", values, "item");
            return (Criteria) this;
        }

        public Criteria andItemBetween(String value1, String value2) {
            addCriterion("item between", value1, value2, "item");
            return (Criteria) this;
        }

        public Criteria andItemNotBetween(String value1, String value2) {
            addCriterion("item not between", value1, value2, "item");
            return (Criteria) this;
        }

        public Criteria andOrderIsNull() {
            addCriterion("order is null");
            return (Criteria) this;
        }

        public Criteria andOrderIsNotNull() {
            addCriterion("order is not null");
            return (Criteria) this;
        }

        public Criteria andOrderEqualTo(String value) {
            addCriterion("order =", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderNotEqualTo(String value) {
            addCriterion("order <>", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderGreaterThan(String value) {
            addCriterion("order >", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderGreaterThanOrEqualTo(String value) {
            addCriterion("order >=", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderLessThan(String value) {
            addCriterion("order <", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderLessThanOrEqualTo(String value) {
            addCriterion("order <=", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderLike(String value) {
            addCriterion("order like", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderNotLike(String value) {
            addCriterion("order not like", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderIn(List<String> values) {
            addCriterion("order in", values, "order");
            return (Criteria) this;
        }

        public Criteria andOrderNotIn(List<String> values) {
            addCriterion("order not in", values, "order");
            return (Criteria) this;
        }

        public Criteria andOrderBetween(String value1, String value2) {
            addCriterion("order between", value1, value2, "order");
            return (Criteria) this;
        }

        public Criteria andOrderNotBetween(String value1, String value2) {
            addCriterion("order not between", value1, value2, "order");
            return (Criteria) this;
        }

        public Criteria andStaffStateIsNull() {
            addCriterion("staff_state is null");
            return (Criteria) this;
        }

        public Criteria andStaffStateIsNotNull() {
            addCriterion("staff_state is not null");
            return (Criteria) this;
        }

        public Criteria andStaffStateEqualTo(String value) {
            addCriterion("staff_state =", value, "staffState");
            return (Criteria) this;
        }

        public Criteria andStaffStateNotEqualTo(String value) {
            addCriterion("staff_state <>", value, "staffState");
            return (Criteria) this;
        }

        public Criteria andStaffStateGreaterThan(String value) {
            addCriterion("staff_state >", value, "staffState");
            return (Criteria) this;
        }

        public Criteria andStaffStateGreaterThanOrEqualTo(String value) {
            addCriterion("staff_state >=", value, "staffState");
            return (Criteria) this;
        }

        public Criteria andStaffStateLessThan(String value) {
            addCriterion("staff_state <", value, "staffState");
            return (Criteria) this;
        }

        public Criteria andStaffStateLessThanOrEqualTo(String value) {
            addCriterion("staff_state <=", value, "staffState");
            return (Criteria) this;
        }

        public Criteria andStaffStateLike(String value) {
            addCriterion("staff_state like", value, "staffState");
            return (Criteria) this;
        }

        public Criteria andStaffStateNotLike(String value) {
            addCriterion("staff_state not like", value, "staffState");
            return (Criteria) this;
        }

        public Criteria andStaffStateIn(List<String> values) {
            addCriterion("staff_state in", values, "staffState");
            return (Criteria) this;
        }

        public Criteria andStaffStateNotIn(List<String> values) {
            addCriterion("staff_state not in", values, "staffState");
            return (Criteria) this;
        }

        public Criteria andStaffStateBetween(String value1, String value2) {
            addCriterion("staff_state between", value1, value2, "staffState");
            return (Criteria) this;
        }

        public Criteria andStaffStateNotBetween(String value1, String value2) {
            addCriterion("staff_state not between", value1, value2, "staffState");
            return (Criteria) this;
        }

        public Criteria andWorkStateIsNull() {
            addCriterion("work_state is null");
            return (Criteria) this;
        }

        public Criteria andWorkStateIsNotNull() {
            addCriterion("work_state is not null");
            return (Criteria) this;
        }

        public Criteria andWorkStateEqualTo(String value) {
            addCriterion("work_state =", value, "workState");
            return (Criteria) this;
        }

        public Criteria andWorkStateNotEqualTo(String value) {
            addCriterion("work_state <>", value, "workState");
            return (Criteria) this;
        }

        public Criteria andWorkStateGreaterThan(String value) {
            addCriterion("work_state >", value, "workState");
            return (Criteria) this;
        }

        public Criteria andWorkStateGreaterThanOrEqualTo(String value) {
            addCriterion("work_state >=", value, "workState");
            return (Criteria) this;
        }

        public Criteria andWorkStateLessThan(String value) {
            addCriterion("work_state <", value, "workState");
            return (Criteria) this;
        }

        public Criteria andWorkStateLessThanOrEqualTo(String value) {
            addCriterion("work_state <=", value, "workState");
            return (Criteria) this;
        }

        public Criteria andWorkStateLike(String value) {
            addCriterion("work_state like", value, "workState");
            return (Criteria) this;
        }

        public Criteria andWorkStateNotLike(String value) {
            addCriterion("work_state not like", value, "workState");
            return (Criteria) this;
        }

        public Criteria andWorkStateIn(List<String> values) {
            addCriterion("work_state in", values, "workState");
            return (Criteria) this;
        }

        public Criteria andWorkStateNotIn(List<String> values) {
            addCriterion("work_state not in", values, "workState");
            return (Criteria) this;
        }

        public Criteria andWorkStateBetween(String value1, String value2) {
            addCriterion("work_state between", value1, value2, "workState");
            return (Criteria) this;
        }

        public Criteria andWorkStateNotBetween(String value1, String value2) {
            addCriterion("work_state not between", value1, value2, "workState");
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