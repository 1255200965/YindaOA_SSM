package com.service;

import java.util.List;

import com.model.ExpenseApplayTaxi;

public interface IExpenseApplayTaxiService {
  //出租票报销历史信息查看
  public List<ExpenseApplayTaxi> selectByStaffId(String staffId);
  //单条出租车报销信息详情查看
  public ExpenseApplayTaxi selectById(int id);
  //单条出租车报销信息保存、更新(根据id是否为0，进行新增或者更新)
  public void saveOrUpdate(ExpenseApplayTaxi expenseApplayTaxi);
}
