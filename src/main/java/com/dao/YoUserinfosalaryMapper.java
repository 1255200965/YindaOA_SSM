package com.dao;

import com.model.YoUserinfosalary;
import com.model.YoUserinfosalaryExample;
import java.util.List;

public interface YoUserinfosalaryMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(YoUserinfosalary record);

    int insertSelective(YoUserinfosalary record);

    List<YoUserinfosalary> selectByExample(YoUserinfosalaryExample example);

    YoUserinfosalary selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(YoUserinfosalary record);

    int updateByPrimaryKey(YoUserinfosalary record);

    List<YoUserinfosalary> search_salary(String company,String salarydate);
}