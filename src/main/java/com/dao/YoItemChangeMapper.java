package com.dao;

import com.model.YoItemChange;
import com.model.YoItemChangeExample;
import java.util.List;

public interface YoItemChangeMapper {
    int deleteByPrimaryKey(Integer icSequenceNo);

    int insert(YoItemChange record);

    int insertSelective(YoItemChange record);

    List<YoItemChange> selectByExample(YoItemChangeExample example);

    YoItemChange selectByPrimaryKey(Integer icSequenceNo);

    int updateByPrimaryKeySelective(YoItemChange record);

    int updateByPrimaryKey(YoItemChange record);
     //项目变更列表展示界面所有方法
    public List<YoItemChange> selectByPropertities(YoItemChange itemChange);

    int add(YoItemChange record);
}