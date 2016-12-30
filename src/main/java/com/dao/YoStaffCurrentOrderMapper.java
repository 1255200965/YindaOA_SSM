package com.dao;

import com.model.YoStaffCurrentOrder;
import com.model.YoStaffCurrentOrderExample;
import java.util.List;

public interface YoStaffCurrentOrderMapper {
    int deleteByPrimaryKey(Integer scoSequenceNo);

    int insert(YoStaffCurrentOrder record);

    int insertSelective(YoStaffCurrentOrder record);

    List<YoStaffCurrentOrder> selectByExample(YoStaffCurrentOrderExample example);

    YoStaffCurrentOrder selectByPrimaryKey(Integer scoSequenceNo);

    int updateByPrimaryKeySelective(YoStaffCurrentOrder record);

    int updateByPrimaryKey(YoStaffCurrentOrder record);
}