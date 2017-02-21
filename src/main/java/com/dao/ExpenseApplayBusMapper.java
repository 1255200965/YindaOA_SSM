package com.dao;

import com.model.ExpenseApplayBus;
import com.model.ExpenseApplayBusExample;
import com.model.ToolsForselectApproval;

import java.util.List;

public interface ExpenseApplayBusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExpenseApplayBus record);

    int insertSelective(ExpenseApplayBus record);

    List<ExpenseApplayBus> selectByExample(ExpenseApplayBusExample example);

    ExpenseApplayBus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExpenseApplayBus record);

    int updateByPrimaryKey(ExpenseApplayBus record);
    //根据用户钉钉ID查询用户的待审批记录
    public List<ExpenseApplayBus> selectApproval(ToolsForselectApproval tools);
    //根据用户钉钉ID查询用户的已审批记录
    public List<ExpenseApplayBus> selectApproved(String staffUserId);
    //根据用户钉钉ID查询用户的待审批员工有那些
    public List<ExpenseApplayBus> selectApprovalStaff(String staffUserId);
    //查询当前用户上周的待审批条数
    public int selectApprovalCount(String staffUserId);
    //查询出上周管理员未审核的报销并进行驳回
    public void updateDelayApproval(String staffUserId);
}