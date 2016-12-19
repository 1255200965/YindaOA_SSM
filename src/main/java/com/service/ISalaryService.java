package com.service;

import com.model.YoSalary;
import com.model.YoSalaryExample;

import java.util.Date;
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
    /**
     * 日历——考勤
     * @param userId 用户id
     * @param date 当月的日期
     * @return  
     */
   List<YoSalary> select_BY_Anttendane(String userId,Date date);
    
   /**
    * 日历——请假
    * @param userId 用户id
    * @param date 当月的日期
    * @return  
    */
    List<YoSalary> select_BY_Leavetype(String userId,Date date);
    
    /**
     * 日历——加班
     * @param userId 用户id
     * @param date 当月的日期
     * @return  
     */
    List<YoSalary> select_BY_WorkTime(String userId,Date date);
    
    /**
     * 日历——出差
     * @param userId 用户id
     * @param date 当月的日期
     * @return  
     */
    List<YoSalary> select_BY_Evenctime(String userId,Date date);
}
