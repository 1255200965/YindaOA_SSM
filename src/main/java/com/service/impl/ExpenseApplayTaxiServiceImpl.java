package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ExpenseApplayTaxiMapper;
import com.model.ExpenseApplayTaxi;
import com.model.ExpenseApplayTaxiExample;
import com.service.IExpenseApplayTaxiService;
@Service
public class ExpenseApplayTaxiServiceImpl implements IExpenseApplayTaxiService{
	@Autowired
	private ExpenseApplayTaxiMapper expenseApplayTaxiMapper;
   @Override
   public List<ExpenseApplayTaxi> selectByStaffId(String staffId){
	   ExpenseApplayTaxiExample example = new ExpenseApplayTaxiExample();
	   ExpenseApplayTaxiExample.Criteria criteria = example.createCriteria();
	   criteria.andStaffIdEqualTo(staffId);
	   List<ExpenseApplayTaxi> expenseApplayTaxiList = expenseApplayTaxiMapper.selectByExample(example);
	   return expenseApplayTaxiList;
	   }
   @Override
   public ExpenseApplayTaxi selectById(int id){
	   ExpenseApplayTaxiExample example = new ExpenseApplayTaxiExample();
	   ExpenseApplayTaxiExample.Criteria criteria = example.createCriteria();
	   criteria.andIdEqualTo(id);
	   ExpenseApplayTaxi expenseApplayTaxi =(ExpenseApplayTaxi) expenseApplayTaxiMapper.selectByExample(example).get(0);
	   return expenseApplayTaxi;
   }
   @Override
   public int saveOrUpdate(ExpenseApplayTaxi expenseApplayTaxi){
	   Integer id = expenseApplayTaxi.getId();
	   if(id == null || id == 0){//插入
		    expenseApplayTaxiMapper.insert(expenseApplayTaxi);
		    id=expenseApplayTaxi.getId();
		    return id;
	   }else{
		  return expenseApplayTaxiMapper.updateByPrimaryKey(expenseApplayTaxi);
		   }
   }
}
