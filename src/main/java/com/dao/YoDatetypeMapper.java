package com.dao;

import com.model.YoDatetype;
import com.model.YoDatetypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YoDatetypeMapper {
    int countByExample(YoDatetypeExample example);

    int deleteByExample(YoDatetypeExample example);

    int deleteByPrimaryKey(Integer dateId);

    int insert(YoDatetype record);

    int insertSelective(YoDatetype record);

    List<YoDatetype> selectByExample(YoDatetypeExample example);

    YoDatetype selectByPrimaryKey(Integer dateId);

    int updateByExampleSelective(@Param("record") YoDatetype record, @Param("example") YoDatetypeExample example);

    int updateByExample(@Param("record") YoDatetype record, @Param("example") YoDatetypeExample example);

    int updateByPrimaryKeySelective(YoDatetype record);

    int updateByPrimaryKey(YoDatetype record);
}