package com.dao;

import com.model.ExpenseApplayBus;
import com.model.ExpenseApplayBusExample;
import java.util.List;

public interface ExpenseApplayBusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExpenseApplayBus record);

    int insertSelective(ExpenseApplayBus record);

    List<ExpenseApplayBus> selectByExample(ExpenseApplayBusExample example);

    ExpenseApplayBus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExpenseApplayBus record);

    int updateByPrimaryKey(ExpenseApplayBus record);
}