package com.dao;

import com.model.ExpenseApplayHotel;
import com.model.ExpenseApplayHotelExample;
import java.util.List;

public interface ExpenseApplayHotelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExpenseApplayHotel record);

    int insertSelective(ExpenseApplayHotel record);

    List<ExpenseApplayHotel> selectByExample(ExpenseApplayHotelExample example);

    ExpenseApplayHotel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExpenseApplayHotel record);

    int updateByPrimaryKey(ExpenseApplayHotel record);
    //根据用户钉钉Id查询其当前30天内的已审批记录
     public List<ExpenseApplayHotel> selectApproved(String userStaffId); 
   //根据用户钉钉Id查询其当前30天内的待审批记录
     public List<ExpenseApplayHotel> selectApproval(String userStaffId); 
}