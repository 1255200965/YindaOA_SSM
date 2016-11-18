package com.dao;

import com.model.OaWtrSalary;
import com.model.OaWtrSalaryExample;
import java.util.List;

public interface OaWtrSalaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OaWtrSalary record);

    int insertSelective(OaWtrSalary record);

    List<OaWtrSalary> selectByExample(OaWtrSalaryExample example);

    OaWtrSalary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OaWtrSalary record);

    int updateByPrimaryKey(OaWtrSalary record);
}