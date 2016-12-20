package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ExpenseApplayHotelMapper;
import com.model.ExpenseApplayHotel;
import com.model.ExpenseApplayHotelExample;
import com.service.IExpenseApplayHotelService;
@Service
public class ExpenseApplayHotelServiceImpl implements IExpenseApplayHotelService{
    @Autowired
    private ExpenseApplayHotelMapper expenseApplayHotelMapper;
    @Override
    public List<ExpenseApplayHotel> selectByStaffId(String staffId){
    	ExpenseApplayHotelExample example = new ExpenseApplayHotelExample();
    	ExpenseApplayHotelExample.Criteria criteria = example.createCriteria();
    	criteria.andStaffIdEqualTo(staffId);
    	List<ExpenseApplayHotel> expenseApplayHotelList=expenseApplayHotelMapper.selectByExample(example);
    	return expenseApplayHotelList;
    }
    @Override
    public ExpenseApplayHotel selectById(int id){
    	return expenseApplayHotelMapper.selectByPrimaryKey(id);
    }
    @Override
    public int saveOrUpdate(ExpenseApplayHotel expenseApplayHotel){
    	Integer id = expenseApplayHotel.getId();
    	if(id == null || id == 0){//新增
    		expenseApplayHotelMapper.insert(expenseApplayHotel);
    		id = expenseApplayHotel.getId();
    		return id;
    	}else{//更新
    		return expenseApplayHotelMapper.updateByPrimaryKey(expenseApplayHotel);
    	}
    }
}
