package com.dao;


import com.model.ExpenseApplayTrain;
import com.model.ExpenseApplayTrainExample;
import com.model.ToolsForselectApproval;

import java.util.List;

public interface ExpenseApplayTrainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExpenseApplayTrain record);

    int insertSelective(ExpenseApplayTrain record);

    List<ExpenseApplayTrain> selectByExample(ExpenseApplayTrainExample example);

    ExpenseApplayTrain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExpenseApplayTrain record);

    int updateByPrimaryKey(ExpenseApplayTrain record);
    
    //根据用户钉钉ID查询用户的待审批记录
    public List<ExpenseApplayTrain> selectApproval(ToolsForselectApproval tools);
    //根据用户钉钉ID查询用户的已审批记录
    public List<ExpenseApplayTrain> selectApproved(String staffUserId);
    //根据用户钉钉ID查询用户的待审批员工有那些
    public List<ExpenseApplayTrain> selectApprovalStaff(String staffUserId);
    //查询当前用户上周的待审批条数
    public int selectApprovalCount(String staffUserId);
    //查询出上周管理员未审核的报销并进行驳回
    public void updateDelayApproval(String staffUserId);
}