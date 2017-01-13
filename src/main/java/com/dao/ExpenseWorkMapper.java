package com.dao;

import com.model.ExpenseWork;
import com.model.ExpenseWorkExample;
import java.util.List;

public interface ExpenseWorkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExpenseWork record);

    int insertSelective(ExpenseWork record);

    List<ExpenseWork> selectByExample(ExpenseWorkExample example);

    ExpenseWork selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExpenseWork record);

    int updateByPrimaryKey(ExpenseWork record);
    
    int insertList(List<ExpenseWork> record);
    
    
}