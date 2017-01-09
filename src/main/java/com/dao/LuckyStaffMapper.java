package com.dao;

import com.model.LuckyStaff;
import com.model.LuckyStaffExample;
import java.util.List;

public interface LuckyStaffMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LuckyStaff record);

    int insertSelective(LuckyStaff record);

    List<LuckyStaff> selectByExample(LuckyStaffExample example);

    LuckyStaff selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LuckyStaff record);

    int updateByPrimaryKey(LuckyStaff record);
}