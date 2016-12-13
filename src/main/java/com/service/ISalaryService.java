package com.service;

import com.model.YoSalary;
import com.model.YoSalaryExample;


import java.util.List;

/**
 * Created by pwj on 2016/10/31.
 */
public interface ISalaryService {
    //查询单个用户
//    YoSalary countByExample(Integer sid);

    //添加工资
    int insert(YoSalary record);

    //通过姓名来查询员工信息*/
    List<YoSalary> searchYoSalaryByEntity(YoSalaryExample example);

    //按查询条件查询
    List<YoSalary> selectByExample(YoSalaryExample example);

    int updateByPrimaryKey(YoSalary record);

    //查询所有用户信息
//    List<YoSalary> selectYoSalary(YoSalary yoSalary);


}
