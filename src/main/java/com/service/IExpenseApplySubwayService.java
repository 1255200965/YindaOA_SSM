package com.service;

import java.util.List;

import com.model.ExpenseApplySubway;

public interface IExpenseApplySubwayService {
	
  //根据是否有主键删除或者更新一条审批记录
  public int saveOrUpdate(ExpenseApplySubway expenseSubway);
  
  //根据主键查询审批记录
  public ExpenseApplySubway selectByPrimarykey(int id);
  
  //多级消息推送流程
  public ExpenseApplySubway sendTONextManager(ExpenseApplySubway expenseApplySubway);
  //驳回
  public ExpenseApplySubway refuseOption(ExpenseApplySubway expenseApplySubway);
  //查询当前管理员的历史审批信息--一个月以前
  public List<ExpenseApplySubway> selectApproved(String userStaffId);
  //根据工号查询员工所有的地铁公交已审核
   public  List<ExpenseApplySubway> selectByStaffId(String staffId);
   //根据工号查询员工所有的地铁公交待审核信息
 //查询当前管理员的历史审批信息--一个月以前
   public List<ExpenseApplySubway> selectApproval(String userStaffId);
}
