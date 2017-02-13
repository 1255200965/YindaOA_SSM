package com.dao;

import com.model.Prize;
import com.model.PrizeExample;
import java.util.List;

public interface PrizeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Prize record);

    int insertSelective(Prize record);

    List<Prize> selectByExample(PrizeExample example);

    Prize selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Prize record);

    int updateByPrimaryKey(Prize record);
}