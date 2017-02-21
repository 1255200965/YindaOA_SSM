package com.service;

import java.util.List;

import com.model.ExpenseApplayBus;
import com.model.ExpenseApplayHotel;

public interface IExpenseApplayHotelService {
   //根据staffId查询得到所有该用户的报销信息
	public List<ExpenseApplayHotel> selectByStaffId(String staffId);
	//根据id查询到对应的报销信息
	public ExpenseApplayHotel selectById(int id);
	//根据ID是否存在新增或者更新用户报销信息
	public int saveOrUpdate(ExpenseApplayHotel expenseApplayHotel);
	//各级管理员审核
    public ExpenseApplayHotel sendTONextManager(ExpenseApplayHotel expenseApplayHotel);
    //驳回操作
	public ExpenseApplayHotel refuseOption(ExpenseApplayHotel expenseApplayHotel);
	//根据用户钉钉Id查询其当前30天内的审批记录
    public List<ExpenseApplayHotel> selectApproved(String userStaffId); 
    //根据用户钉钉Id查询其当前30天内的待审批记录
    public List<ExpenseApplayHotel> selectApproval(String userStaffId,String staffId);
    //获取审批人列表-当前审批人姓名
  	public ExpenseApplayHotel constructApprovers(ExpenseApplayHotel expenseApplayHotel);
  	//更新所有报销信息-返回ID
  	 public int UpdateByPrimaryKey(ExpenseApplayHotel expenseApplayHotel);
  	//根据ID删除对应的报销记录
  	 public String delete(int id);
  	 //根据用户钉钉ID查询用户的待审批员工有那些
     public List<ExpenseApplayHotel> selectApprovalStaff(String staffUserId);
     //查询当前用户上周的待审批条数
     public int selectApprovalCount(String staffUserId);
   //查询出上周管理员未审核的报销并进行驳回
     public void updateDelayApproval(String staffUserId);
}
