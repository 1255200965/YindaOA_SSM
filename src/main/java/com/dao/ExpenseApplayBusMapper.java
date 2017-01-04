package com.dao;

import com.model.ExpenseApplayBus;
import com.model.ExpenseApplayBusExample;
import java.util.List;

public interface ExpenseApplayBusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExpenseApplayBus record);

    int insertSelective(ExpenseApplayBus record);

    List<ExpenseApplayBus> selectByExample(ExpenseApplayBusExample example);

    ExpenseApplayBus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExpenseApplayBus record);

    int updateByPrimaryKey(ExpenseApplayBus record);
    //查询当前管理员一个月之前的已审批信息
    public List<ExpenseApplayBus> selectApproved(String staffId);
    //查询当前管理员一个月之前的待审批信息
    public List<ExpenseApplayBus> selectApproval(String staffId);
}