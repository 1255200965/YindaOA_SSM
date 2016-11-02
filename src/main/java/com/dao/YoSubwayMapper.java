package com.dao;

import com.model.YoSubway;
import com.model.YoSubwayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YoSubwayMapper {
    int countByExample(YoSubwayExample example);

    int deleteByExample(YoSubwayExample example);

    int deleteByPrimaryKey(Integer subSequenceNo);

    int insert(YoSubway record);

    int insertSelective(YoSubway record);

    List<YoSubway> selectByExample(YoSubwayExample example);

    YoSubway selectByPrimaryKey(Integer subSequenceNo);

    int updateByExampleSelective(@Param("record") YoSubway record, @Param("example") YoSubwayExample example);

    int updateByExample(@Param("record") YoSubway record, @Param("example") YoSubwayExample example);

    int updateByPrimaryKeySelective(YoSubway record);

    int updateByPrimaryKey(YoSubway record);
}