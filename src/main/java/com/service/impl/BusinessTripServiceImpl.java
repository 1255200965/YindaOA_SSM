package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BusinessTripMapper;
import com.model.BusinessTrip;
import com.model.BusinessTripExample;
import com.service.IBusinessTripService;
@Service
public class BusinessTripServiceImpl implements IBusinessTripService{
	@Autowired
	private BusinessTripMapper businessTripMapper;
    @Override
    public List<BusinessTrip> selectByPropertities(BusinessTrip businessTrip){
    	return businessTripMapper.selectByPropertities(businessTrip);
    }
    @Override
    public List<BusinessTrip> selectByStaffId(String staffId){
    	BusinessTripExample example=new BusinessTripExample();
    	BusinessTripExample.Criteria criteria = example.createCriteria();
    	criteria.andBtAskStaffIdEqualTo(staffId);
    	return businessTripMapper.selectByExample(example);
    }
    @Override
    public BusinessTrip selectById(int id){
    	return businessTripMapper.selectByPrimaryKey(id);
    }
}
