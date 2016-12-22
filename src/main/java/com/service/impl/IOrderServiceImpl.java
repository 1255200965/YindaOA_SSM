package com.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dao.YoOrderMapper;
import com.model.YoOrder;
import com.model.YoOrderExample;
import com.service.IOrderService;
import com.util.StringUtil;


@Transactional
@Service
public class IOrderServiceImpl implements IOrderService{
	@Autowired
	private YoOrderMapper yoOrderMapper;
	@Override
	public List<YoOrder> getDepartment() {
    
	
		List<YoOrder> orderBusList=yoOrderMapper.getDepartment();
		return orderBusList;
	}

	@Override
	public List<YoOrder> getProjectByDepartment(String department) {
		// TODO Auto-generated method stub
		return yoOrderMapper.getProjectByDepartment(department);
		
	}

	/**
	 * 条件查询
	 */
	public  List<YoOrder> getOrderList(YoOrder order){
		
		YoOrderExample example = new YoOrderExample();
		YoOrderExample.Criteria criteria = example.createCriteria();
    	if(order.getOrderNumber()!=null&&!"".equals(order.getOrderNumber())) criteria.andOrderNumberEqualTo(order.getOrderNumber());
    	if(order.getProject()!=null) criteria.andProjectEqualTo(order.getProject());
    	if(order.getDepartment()!=null) criteria.andDepartmentEqualTo(order.getDepartment());
    	List<YoOrder> orderList=yoOrderMapper.selectByExample(example);
    	
    	return orderList;
	}

	@Override
	public List<YoOrder> getOrderByDepartmentAndProject(String department,String project) {
		// TODO Auto-generated method stub
		YoOrderExample example = new YoOrderExample();
		YoOrderExample.Criteria criteria = example.createCriteria();
    	if(StringUtil.NotBlank(project)) {criteria.andProjectEqualTo(project);}else{return null;};
    	if(StringUtil.NotBlank(department)) {criteria.andDepartmentEqualTo(department);}else{return null;};
    	List<YoOrder> orderList=yoOrderMapper.selectByExample(example);
		return orderList;
	}
	
	
}
