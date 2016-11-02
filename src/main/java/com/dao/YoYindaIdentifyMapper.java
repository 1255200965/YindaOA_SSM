package com.dao;

import com.model.YoYindaIdentify;
import com.model.YoYindaIdentifyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YoYindaIdentifyMapper {
    int countByExample(YoYindaIdentifyExample example);

    int deleteByExample(YoYindaIdentifyExample example);

    int deleteByPrimaryKey(Integer yiSequenceNo);

    int insert(YoYindaIdentify record);

    int insertSelective(YoYindaIdentify record);

    List<YoYindaIdentify> selectByExample(YoYindaIdentifyExample example);

    YoYindaIdentify selectByPrimaryKey(Integer yiSequenceNo);

    int updateByExampleSelective(@Param("record") YoYindaIdentify record, @Param("example") YoYindaIdentifyExample example);

    int updateByExample(@Param("record") YoYindaIdentify record, @Param("example") YoYindaIdentifyExample example);

    int updateByPrimaryKeySelective(YoYindaIdentify record);

    int updateByPrimaryKey(YoYindaIdentify record);
}