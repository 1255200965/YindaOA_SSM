package com.dao;

import com.model.ExpenseApplayBus;
import com.model.ExpenseApplayTrain;
import com.model.ExpenseApplySubway;
import com.model.ExpenseApplySubwayExample;
import com.model.ToolsForselectApproval;

import java.util.List;

public interface ExpenseApplySubwayMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExpenseApplySubway record);

    int insertSelective(ExpenseApplySubway record);

    List<ExpenseApplySubway> selectByExample(ExpenseApplySubwayExample example);

    ExpenseApplySubway selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExpenseApplySubway record);

    int updateByPrimaryKey(ExpenseApplySubway record);
    
    	//根据用户钉钉ID查询用户的待审批记录
    public List<ExpenseApplySubway> selectApproval(ToolsForselectApproval tools);
    	//根据用户钉钉ID查询用户的已审批记录
    public List<ExpenseApplySubway> selectApproved(String staffUserId);
    	//根据用户钉钉ID查询用户的待审批员工有那些
    public List<ExpenseApplySubway> selectApprovalStaff(String staffUserId);
    	//查询当前用户上周的待审批条数
    public int selectApprovalCount(String staffUserId);
  //查询出上周管理员未审核的报销并进行驳回
    public void updateDelayApproval(String staffUserId);
}