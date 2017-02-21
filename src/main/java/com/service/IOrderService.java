package com.service;

import java.util.List;

import com.model.YoOrder;

public interface IOrderService {

	/**
	 * 获取所有部门
	 * @return
	 */
	List<YoOrder> getDepartment();
	
	
	/**
	 * 根据部门获取项目
	 * @param department
	 * @return
	 */
	List<YoOrder> getProjectByDepartment(String department);
	
	
	
	/**
	 * 条件查询订单
	 * @param order
	 * @return
	 */
	 List<YoOrder> getOrderList(YoOrder order);
	 
	 
	 /**
	  * 根据部门，项目获取订单
	  * @param department
	  * @return
	  */
	 List<YoOrder> getOrderByDepartmentAndProject(String department,String project);
	/**
	 * 获取所有部门信息
	 * @return
	 */
	 public List<String> selectAllDepartment();
	 /**
	  * 根据部门名称获取部门下的所有项目的名称
	  * @param department
	  * @return
	  */
	 public List<String> selectProjectOfDepartment(String department);
	 /**
	  	 * 获取某个项目下的所有订单
	  	 * @param project
	  	 * @return
	  	 */
	 public List<String> selectOrderofProject(String project);

	 /**
	  * 根据订单名获取订单号
	  * @param orderName
	  * @return 订单号
	  */
	 String getOrderNumberByName (String orderName);

}
