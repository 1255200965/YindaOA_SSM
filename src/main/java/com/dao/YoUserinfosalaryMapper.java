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
    /**
     * 根据分公司，月份去查询薪资
     * @param company  分公司
     * @param salarydate 月份
     * @return
     */
    List<YoUserinfosalary> search_salary(String company,String salarydate);
}