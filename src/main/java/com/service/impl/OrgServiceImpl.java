package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.YoRoleModuleMapper;
import com.dao.YoUserRoleMapper;
import com.model.ExpenseApplayHotel;
import com.model.ExpenseApplayHotelExample;
import com.model.YoRoleModule;
import com.model.YoRoleModuleExample;
import com.model.YoUserRole;
import com.model.YoUserRoleExample;
import com.service.OrgService;

@Service
public class OrgServiceImpl implements OrgService{
    @Autowired
    private YoUserRoleMapper userRoleMapper;
    @Autowired
    private YoRoleModuleMapper roleModuleMapper;
    
	@Override
	public List<YoUserRole> getAllUserRole() {
		// TODO Auto-generated method stub
		YoUserRoleExample example = new YoUserRoleExample();
		YoUserRoleExample.Criteria criteria = example.createCriteria(); 
		criteria.andRoleIsNotNull();
    	List<YoUserRole> userRoleList=userRoleMapper.selectByExample(example);
    	return userRoleList;
		
	}

	@Override
	public List<YoRoleModule> getAllRoleModule() {
		// TODO Auto-generated method stub
		YoRoleModuleExample example = new YoRoleModuleExample();
		YoRoleModuleExample.Criteria criteria = example.createCriteria(); 
		criteria.andRoleIsNotNull();
    	List<YoRoleModule> roleModuleList=roleModuleMapper.selectByExample(example);
		return roleModuleList;
	}
   
}
