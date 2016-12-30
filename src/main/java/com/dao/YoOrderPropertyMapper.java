package com.dao;

import com.model.YoOrderProperty;
import com.model.YoOrderPropertyExample;
import java.util.List;

public interface YoOrderPropertyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(YoOrderProperty record);

    int insertSelective(YoOrderProperty record);

    List<YoOrderProperty> selectByExample(YoOrderPropertyExample example);

    YoOrderProperty selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(YoOrderProperty record);

    int updateByPrimaryKey(YoOrderProperty record);
}