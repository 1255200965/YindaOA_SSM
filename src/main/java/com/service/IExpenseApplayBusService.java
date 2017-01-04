package com.service;

import java.util.List;

import com.model.ExpenseApplayBus;


public interface IExpenseApplayBusService {
	//根据用户ID查询用户所有的大巴票据报销信息
	 public List<ExpenseApplayBus> selectAllByStaffId(String staffId);
	 //根据报销信息ID查询具体的报销信息
	 public ExpenseApplayBus selectById(int id);
	 //大巴报销信息保存，返回ID
	 public int saveOrUpdate(ExpenseApplayBus expenseApplayBus);
	 //各级管理员审核
	 public ExpenseApplayBus sendTONextManager(ExpenseApplayBus expenseApplayBus);
	 //大巴拒绝操作
	 public ExpenseApplayBus refuseOption(ExpenseApplayBus expenseApplayBus);
	 //查询当前管理员的历史审批信息--一个月以前
	 public List<ExpenseApplayBus> selectByApproveHistory(String approverStaffId);
	//查询当前管理员的历史审批信息--一个月以前
	public List<ExpenseApplayBus> selectApproval(String approverStaffId);
}
