package com.dao;

import com.model.YoOvertime;
import com.model.YoOvertimeExample;
import java.util.List;

public interface YoOvertimeMapper {
    int deleteByPrimaryKey(Integer otSequenceNo);

    int insert(YoOvertime record);

    int insertSelective(YoOvertime record);

    List<YoOvertime> selectByExample(YoOvertimeExample example);

    //彭文杰改加班表，不带参数
    List<YoOvertime> selectByExample();

    YoOvertime selectByPrimaryKey(Integer otSequenceNo);

    int updateByPrimaryKeySelective(YoOvertime record);

    int updateByPrimaryKey(YoOvertime record);
}