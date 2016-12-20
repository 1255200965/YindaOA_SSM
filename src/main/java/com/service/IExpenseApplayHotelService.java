package com.service;

import java.util.List;

import com.model.ExpenseApplayHotel;

public interface IExpenseApplayHotelService {
   //根据staffId查询得到所有该用户的报销信息
	public List<ExpenseApplayHotel> selectByStaffId(String staffId);
	//根据id查询到对应的报销信息
	public ExpenseApplayHotel selectById(int id);
	//根据ID是否存在新增或者更新用户报销信息
	public int saveOrUpdate(ExpenseApplayHotel expenseApplayHotel);
}
