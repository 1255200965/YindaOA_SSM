package com.service;

import com.model.YoSalary;


import java.util.List;

/**
 * Created by pwj on 2016/10/31.
 */
public interface ISalaryService {
    //查询单个用户
//    YoSalary countByExample(Integer sid);

    //更新用户
//    int updateStaffByID(YoSalary sid);

    //通过姓名来查询员工信息*/
       List<YoSalary> searchYoSalaryByEntity(YoSalary yoSalary);

    //查询所有用户信息
//    List<YoSalary> selectYoSalary(YoSalary yoSalary);


}
