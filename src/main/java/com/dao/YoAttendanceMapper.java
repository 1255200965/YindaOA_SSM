package com.dao;

import com.model.YoAttendance;
import com.model.YoAttendanceExample;
import java.util.List;

public interface YoAttendanceMapper {
    int deleteByPrimaryKey(String id);

    int insert(YoAttendance record);

    int insertSelective(YoAttendance record);

    List<YoAttendance> selectByExample(YoAttendanceExample example);

    YoAttendance selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(YoAttendance record);

    int updateByPrimaryKey(YoAttendance record);
}