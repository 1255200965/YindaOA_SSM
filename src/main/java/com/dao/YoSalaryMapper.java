package com.dao;

import com.model.YoSalary;
import com.model.YoSalaryExample;
import java.util.List;

public interface YoSalaryMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(YoSalary record);

    int insertSelective(YoSalary record);

    List<YoSalary> selectAllUser(YoSalary yoSalary);

    List<YoSalary> selectByExample(YoSalaryExample example);

    YoSalary selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(YoSalary record);

    int updateByPrimaryKey(YoSalary record);
}