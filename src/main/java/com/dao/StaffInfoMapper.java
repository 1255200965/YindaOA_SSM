package com.dao;

import com.model.StaffInfo;
import com.model.StaffInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StaffInfoMapper {
    int countByExample(StaffInfoExample example);

    int deleteByExample(StaffInfoExample example);

    int deleteByPrimaryKey(String staffUserId);

    int insert(StaffInfo record);

    int insertSelective(StaffInfo record);

    List<StaffInfo> selectByExample(StaffInfoExample example);

    StaffInfo selectByPrimaryKey(String staffUserId);

    int updateByExampleSelective(@Param("record") StaffInfo record, @Param("example") StaffInfoExample example);

    int updateByExample(@Param("record") StaffInfo record, @Param("example") StaffInfoExample example);

    int updateByPrimaryKeySelective(StaffInfo record);

    int updateByPrimaryKey(StaffInfo record);


}