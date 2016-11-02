package com.dao;

import com.model.YoItemChange;
import com.model.YoItemChangeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YoItemChangeMapper {
    int countByExample(YoItemChangeExample example);

    int deleteByExample(YoItemChangeExample example);

    int deleteByPrimaryKey(Integer icSequenceNo);

    int insert(YoItemChange record);

    int insertSelective(YoItemChange record);

    List<YoItemChange> selectByExample(YoItemChangeExample example);

    YoItemChange selectByPrimaryKey(Integer icSequenceNo);

    int updateByExampleSelective(@Param("record") YoItemChange record, @Param("example") YoItemChangeExample example);

    int updateByExample(@Param("record") YoItemChange record, @Param("example") YoItemChangeExample example);

    int updateByPrimaryKeySelective(YoItemChange record);

    int updateByPrimaryKey(YoItemChange record);
}