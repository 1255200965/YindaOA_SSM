package com.dao;

import com.model.YoOrderChange;
import com.model.YoOrderChangeExample;
import java.util.List;

public interface YoOrderChangeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(YoOrderChange record);

    int insertSelective(YoOrderChange record);

    List<YoOrderChange> selectByExample(YoOrderChangeExample example);

    YoOrderChange selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(YoOrderChange record);

    int updateByPrimaryKey(YoOrderChange record);
    
    int add(YoOrderChange record); 
}