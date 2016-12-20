package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ExpenseApplayBusMapper;
import com.model.ExpenseApplayBus;
import com.model.ExpenseApplayBusExample;
import com.service.IExpenseApplayBusService;
@Service
public class ExpenseApplayBusServiceImpl implements IExpenseApplayBusService{
  @Autowired
  private ExpenseApplayBusMapper expenseBusMapper;
  @Override
  public List<ExpenseApplayBus> selectAllByStaffId(String staffId){
	  ExpenseApplayBusExample expenseApplayBusExample = new ExpenseApplayBusExample();
	  ExpenseApplayBusExample.Criteria criteria = expenseApplayBusExample.createCriteria();
	  if(staffId != null) criteria.andStaffIdEqualTo(staffId);
	  List<ExpenseApplayBus> expenseBusList=expenseBusMapper.selectByExample(expenseApplayBusExample);
	  return expenseBusList;
  }
  @Override
  public ExpenseApplayBus selectById(int id){
	  ExpenseApplayBusExample example = new ExpenseApplayBusExample();
	  ExpenseApplayBusExample.Criteria criteria =example.createCriteria();
	  if(id != 0) criteria.andIdEqualTo(id);
	  return (ExpenseApplayBus) expenseBusMapper.selectByExample(example).get(0);
  }
  @Override
  public int saveOrUpdate(ExpenseApplayBus expenseApplayBus){
	  Integer id =expenseApplayBus.getId();
	  if(id==null || id==0){//save
		 expenseBusMapper.insert(expenseApplayBus);
		 id=expenseApplayBus.getId();
		 return id;
	  }else{//update
		 return expenseBusMapper.updateByPrimaryKey(expenseApplayBus);
		  }
  }
}
