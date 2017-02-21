package com.service;

import java.util.List;

import com.model.ExpenseApplayHotel;
import com.model.ExpenseApplayTrain;
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
  //查询当前管理员的历史审批信息--一个月以前
   public List<ExpenseApplySubway> selectApproval(String userStaffId,String staffId);
 //获取审批人列表-当前审批人姓名
 public ExpenseApplySubway constructApprovers(ExpenseApplySubway expenseApplySubway);
 	//更新所有报销信息-返回ID
  public int UpdateByPrimaryKey(ExpenseApplySubway expenseApplySubway);
 	//根据ID删除对应的报销记录
  public String delete(int id);
  //根据用户钉钉ID查询用户的待审批员工有那些
  public List<ExpenseApplySubway> selectApprovalStaff(String staffUserId);
  //查询当前用户上周的待审批条数
  public int selectApprovalCount(String staffUserId);
  //查询出上周管理员未审核的报销并进行驳回
  public void updateDelayApproval(String staffUserId);
}
