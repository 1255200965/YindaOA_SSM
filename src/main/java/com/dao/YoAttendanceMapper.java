package com.dao;

import com.model.YoAttendance;
import com.model.YoAttendanceExample;
import java.util.List;

public interface YoAttendanceMapper {
    int deleteByPrimaryKey(String id);

    int insert(YoAttendance record);

    int insertSelective(YoAttendance record);

    List<YoAttendance> selectByExample(YoAttendanceExample example);

    /*彭文杰改，方法不带参数*/
    List<YoAttendance> selectByExample();

    YoAttendance selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(YoAttendance record);

    int updateByPrimaryKey(YoAttendance record);
}