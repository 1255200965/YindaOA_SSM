package com.service;

import java.util.List;

import com.model.ExpenseApplayTrain;

public interface IExpenseApplayTrainService {
    //根据StaffID查询对应的所有火车票报销记录
	public List<ExpenseApplayTrain> selectByStaffId(String staffId);
    //根据Id查询单条报销记录
	public ExpenseApplayTrain selectById(int id);
	//根据ID值是否为空新增或者更新数据库报销信息
	public int saveOrUpdate(ExpenseApplayTrain expenseApplayTrain);
}
