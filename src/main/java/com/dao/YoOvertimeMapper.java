package com.dao;

import com.model.YoOvertime;
import com.model.YoOvertimeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YoOvertimeMapper {
    int countByExample(YoOvertimeExample example);

    int deleteByExample(YoOvertimeExample example);

    int deleteByPrimaryKey(Integer otSequenceNo);

    int insert(YoOvertime record);

    int insertSelective(YoOvertime record);

    List<YoOvertime> selectByExample(YoOvertimeExample example);

    //彭文杰改加班表，不带参数
    List<YoOvertime> selectByExample();

    YoOvertime selectByPrimaryKey(Integer otSequenceNo);

    int updateByExampleSelective(@Param("record") YoOvertime record, @Param("example") YoOvertimeExample example);

    int updateByExample(@Param("record") YoOvertime record, @Param("example") YoOvertimeExample example);

    int updateByPrimaryKeySelective(YoOvertime record);

    int updateByPrimaryKey(YoOvertime record);
}