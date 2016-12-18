package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ExpenseApplayTrainMapper;
import com.model.ExpenseApplayTrain;
import com.model.ExpenseApplayTrainExample;
import com.service.IExpenseApplayTrainService;
@Service
public class ExpenseApplayTrainServiceImpl implements IExpenseApplayTrainService {
   @Autowired
   private ExpenseApplayTrainMapper expenseApplayTrainMapper;
   @Override
   public List<ExpenseApplayTrain> selectByStaffId(String staffId){
	   ExpenseApplayTrainExample example = new ExpenseApplayTrainExample();
	   ExpenseApplayTrainExample.Criteria criteria = example.createCriteria();
	   criteria.andStaffIdEqualTo(staffId);
	   List<ExpenseApplayTrain> expenseApplayTrainList = expenseApplayTrainMapper.selectByExample(example);
	   return expenseApplayTrainList;   
   }
   @Override
   public ExpenseApplayTrain selectById(int id){
	    return expenseApplayTrainMapper.selectByPrimaryKey(id);
   }
   @Override
   public void saveOrUpdate(ExpenseApplayTrain expenseApplayTrain){
	   Integer id = expenseApplayTrain.getId();
	   if(id == null || id == 0){//新增
		   expenseApplayTrainMapper.insert(expenseApplayTrain);
	   }else{//更新
		   expenseApplayTrainMapper.updateByPrimaryKey(expenseApplayTrain);
	   }
   }
}
