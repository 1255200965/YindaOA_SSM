package com.dao;

import com.model.YoOrder;
import com.model.YoOrderExample;
import java.util.List;

public interface YoOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(YoOrder record);

    int insertSelective(YoOrder record);

    List<YoOrder> selectByExample(YoOrderExample example);

    YoOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(YoOrder record);

    int updateByPrimaryKey(YoOrder record);
    
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
  	 * 获取所有部门
  	 * @return
  	 */
  	List<String> selectAllDepartment();
  	/**
  	 * 根据部门获取部门下所有的项目
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
}