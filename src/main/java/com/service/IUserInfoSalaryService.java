package com.service;

import com.model.YoUserinfosalary;
import com.model.YoUserinfosalaryExample;

import java.util.List;

/**
 * Created by ma on 2016/11/14.
 */
public interface IUserInfoSalaryService {

    List<YoUserinfosalary> selectSalary(YoUserinfosalaryExample record);

    List<YoUserinfosalary> selectByExample(YoUserinfosalaryExample example);

    List<YoUserinfosalary> searchUserInfoByEntity(YoUserinfosalary yoUserinfosalary);


    //添加工资
    int insert(YoUserinfosalary record);

//    YoUserinfosalary selectByPrimaryKey(Integer sid);

    int updateByUserSalary(YoUserinfosalary record);
    /**
     * 根据分公司，月份去查询薪资
     * @param company  分公司
     * @param salarydate 月份
     * @return
     */
    List<YoUserinfosalary> search_salary(String company,String salarydate);
}
