package com.dao;

import com.model.ExpenseApplayHotel;
import com.model.ExpenseApplayTrain;
import com.model.ExpenseApplayTrainExample;

import java.util.List;

public interface ExpenseApplayTrainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExpenseApplayTrain record);

    int insertSelective(ExpenseApplayTrain record);

    List<ExpenseApplayTrain> selectByExample(ExpenseApplayTrainExample example);

    ExpenseApplayTrain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExpenseApplayTrain record);

    int updateByPrimaryKey(ExpenseApplayTrain record);
   //根据用户钉钉Id查询其当前30天内的审批记录
    public List<ExpenseApplayTrain> selectApproved(String userStaffId); 
  //根据用户钉钉Id查询其当前30天内的审批记录
    public List<ExpenseApplayTrain> selectApproval(String userStaffId); 
}