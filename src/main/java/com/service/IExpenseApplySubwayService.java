package com.service;

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
}
