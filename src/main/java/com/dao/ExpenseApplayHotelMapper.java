package com.dao;

import com.model.ExpenseApplayBus;
import com.model.ExpenseApplayHotel;
import com.model.ExpenseApplayHotelExample;
import com.model.ToolsForselectApproval;

import java.util.List;

public interface ExpenseApplayHotelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExpenseApplayHotel record);

    int insertSelective(ExpenseApplayHotel record);

    List<ExpenseApplayHotel> selectByExample(ExpenseApplayHotelExample example);

    ExpenseApplayHotel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExpenseApplayHotel record);

    int updateByPrimaryKey(ExpenseApplayHotel record);
    
    //根据用户钉钉ID查询用户的待审批记录
    public List<ExpenseApplayHotel> selectApproval(ToolsForselectApproval tools);
    //根据用户钉钉ID查询用户的已审批记录
    public List<ExpenseApplayHotel> selectApproved(String staffUserId);
    //根据用户钉钉ID查询用户的待审批员工有那些
    public List<ExpenseApplayHotel> selectApprovalStaff(String staffUserId);
    //查询当前用户上周的待审批条数
    public int selectApprovalCount(String staffUserId);
    //查询出上周管理员未审核的报销并进行驳回
    public void updateDelayApproval(String staffUserId);
}