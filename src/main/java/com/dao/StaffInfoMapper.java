package com.dao;

import com.model.StaffInfo;
import com.model.StaffInfoExample;
import java.util.List;

public interface StaffInfoMapper {
    int deleteByPrimaryKey(Integer sqncNmbr);

    int insert(StaffInfo record);

    int insertSelective(StaffInfo record);

    List<StaffInfo> selectByExample(StaffInfoExample example);

    StaffInfo selectByPrimaryKey(Integer sqncNmbr);

    int updateByPrimaryKeySelective(StaffInfo record);

    int updateByPrimaryKey(StaffInfo record);
}