package com.dao;

import com.model.YoStaffDailyOrder;
import com.model.YoStaffDailyOrderExample;
import java.util.List;

public interface YoStaffDailyOrderMapper {
    int deleteByPrimaryKey(Integer sdoSequenceNo);

    int insert(YoStaffDailyOrder record);

    int insertSelective(YoStaffDailyOrder record);

    List<YoStaffDailyOrder> selectByExample(YoStaffDailyOrderExample example);

    YoStaffDailyOrder selectByPrimaryKey(Integer sdoSequenceNo);

    int updateByPrimaryKeySelective(YoStaffDailyOrder record);

    int updateByPrimaryKey(YoStaffDailyOrder record);
}