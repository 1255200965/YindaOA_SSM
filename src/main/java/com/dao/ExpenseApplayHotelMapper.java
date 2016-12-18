package com.dao;

import com.model.ExpenseApplayHotel;
import com.model.ExpenseApplayHotelExample;
import java.util.List;

public interface ExpenseApplayHotelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExpenseApplayHotel record);

    int insertSelective(ExpenseApplayHotel record);

    List<ExpenseApplayHotel> selectByExample(ExpenseApplayHotelExample example);

    ExpenseApplayHotel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExpenseApplayHotel record);

    int updateByPrimaryKey(ExpenseApplayHotel record);
}