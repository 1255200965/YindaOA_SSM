package com.service;

import java.util.List;
import java.util.Map;

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
	public List<ExpenseApplayBus> selectApproval(String approverStaffId,String staffId);
	//获取审批人列表-当前审批人姓名
	public ExpenseApplayBus constructApprovers(ExpenseApplayBus expenseApplayBus);
	//更新所有报销信息-返回ID
	 public int UpdateByPrimaryKey(ExpenseApplayBus expenseApplayBus);
	//根据ID删除对应的报销记录
	 public String delete(int id);
	//根据用户钉钉ID查询用户的待审批员工有那些
	 public List<ExpenseApplayBus> selectApprovalStaff(String staffUserId);
	//查询当前用户上周的待审批条数
	 public int selectApprovalCount(String staffUserId);
	//查询出上周管理员未审核的报销并进行驳回
	public void updateDelayApproval(String staffUserId);
}
