package com.service;

import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.model.ExpenseWork;

public interface ExpenseWorkSerivce {
	
	
	/**
	 * 办事处报销EXCEL导入
	 * @param hssfWorkbook
	 * @return
	 */
	Map<String, Object> insertAndUpdate(HSSFWorkbook hssfWorkbook);
	
	/**
	 * 办事处报销查询
	 * @param expenseWork
	 * @return
	 */
	 List<ExpenseWork> search_expenseWorkList(ExpenseWork expenseWork);
}
