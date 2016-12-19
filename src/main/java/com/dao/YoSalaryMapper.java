package com.dao;

import com.model.YoSalary;
import com.model.YoSalaryExample;
import java.util.List;

public interface YoSalaryMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(YoSalary record);

    int insertSelective(YoSalary record);

    List<YoSalary> selectByExample(YoSalaryExample example);

    YoSalary selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(YoSalary record);

    int updateByPrimaryKey(YoSalary record);
    

    
    
    
    /**
     * 日历——考勤
     * @return  
     */
   List<YoSalary> select_BY_Anttendane(YoSalary  yo);
    
   /**
    * 日历——请假
    * @return  
    */
    List<YoSalary> select_BY_Leavetype(YoSalary  yo);
    
    /**
     * 日历——加班
     * @return  
     */
    List<YoSalary> select_BY_WorkTime(YoSalary  yo);
    
    /**
     * 日历——出差
     * @return  
     */
    List<YoSalary> select_BY_Evenctime(YoSalary  yo);
}