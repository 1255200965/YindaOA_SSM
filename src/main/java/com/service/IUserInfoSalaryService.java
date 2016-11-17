package com.service;

import com.model.YoUserinfosalary;
import com.model.YoUserinfosalaryExample;

import java.util.List;

/**
 * Created by ma on 2016/11/14.
 */
public interface IUserInfoSalaryService {
    List<YoUserinfosalary> selectByExample();

    List<YoUserinfosalary> selectSalary(YoUserinfosalary record);

    List<YoUserinfosalary> selectByExample(YoUserinfosalaryExample example);

    List<YoUserinfosalary> searchUserInfoByEntity(YoUserinfosalary yoUserinfosalary);


    //添加工资
    int insert(YoUserinfosalary record);

//    YoUserinfosalary selectByPrimaryKey(Integer sid);

    int updateByUserSalary(YoUserinfosalary record);

}
