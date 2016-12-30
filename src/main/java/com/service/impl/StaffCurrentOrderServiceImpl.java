package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ExpenseApplayBusMapper;
import com.dao.YoStaffCurrentOrderMapper;
import com.model.ExpenseApplayBus;
import com.model.ExpenseApplayBusExample;
import com.model.YoStaffCurrentOrder;
import com.model.YoStaffCurrentOrderExample;
import com.service.IStaffCurrentOrderService;
@Service("IStaffCurrentOrderService")
public class StaffCurrentOrderServiceImpl implements IStaffCurrentOrderService{

	@Autowired
	private YoStaffCurrentOrderMapper yoStaffCurrentOrderMapper;

	@Override
	public YoStaffCurrentOrder getStaffCurrentOrderByStaff_user_id(String staff_user_id) {
		// TODO Auto-generated method stub
		YoStaffCurrentOrderExample yoStaffCurrentOrderExample = new YoStaffCurrentOrderExample();
		YoStaffCurrentOrderExample.Criteria criteria = yoStaffCurrentOrderExample.createCriteria();
		if(staff_user_id != null) criteria.andScoStaffUserIdEqualTo(staff_user_id);
		List<YoStaffCurrentOrder> staffCurrentOrderList=yoStaffCurrentOrderMapper.selectByExample(yoStaffCurrentOrderExample);
		if(staffCurrentOrderList!=null&&staffCurrentOrderList.size()>0){
			return staffCurrentOrderList.get(0);
		}
		return null;
	}

}
