package com.dao;

import com.model.ExpenseApplayTaxi;
import com.model.ExpenseApplayTaxiExample;
import java.util.List;

public interface ExpenseApplayTaxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExpenseApplayTaxi record);

    int insertSelective(ExpenseApplayTaxi record);

    List<ExpenseApplayTaxi> selectByExample(ExpenseApplayTaxiExample example);

    ExpenseApplayTaxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExpenseApplayTaxi record);

    int updateByPrimaryKey(ExpenseApplayTaxi record);
}