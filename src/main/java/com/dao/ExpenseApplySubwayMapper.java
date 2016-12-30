package com.dao;

import com.model.ExpenseApplySubway;
import com.model.ExpenseApplySubwayExample;
import java.util.List;

public interface ExpenseApplySubwayMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExpenseApplySubway record);

    int insertSelective(ExpenseApplySubway record);

    List<ExpenseApplySubway> selectByExample(ExpenseApplySubwayExample example);

    ExpenseApplySubway selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExpenseApplySubway record);

    int updateByPrimaryKey(ExpenseApplySubway record);
}