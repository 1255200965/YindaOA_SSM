package com.dao;

import com.model.StaffInfo;
import com.model.StaffInfoExample;
import java.util.List;

public interface StaffInfoMapper {
    int deleteByPrimaryKey(String staffUserId);

    int insert(StaffInfo record);

    int insertSelective(StaffInfo record);

    List<StaffInfo> selectByExample(StaffInfoExample example);

    StaffInfo selectByPrimaryKey(String staffUserId);

    int updateByPrimaryKeySelective(StaffInfo record);

    int updateByPrimaryKey(StaffInfo record);
}