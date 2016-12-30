package com.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.YoOrderPropertyMapper;
import com.model.ExpenseApplayBus;
import com.model.ExpenseApplayBusExample;
import com.model.YoOrderProperty;
import com.model.YoOrderPropertyExample;
import com.service.IOrderPropertyService;

@Service
public class IOrderPropertyServiceImpl implements IOrderPropertyService{
	@Autowired
	private YoOrderPropertyMapper  yoOrderPropertyMapper;
	@Override
	public YoOrderProperty getOrderProvince(String orderName) {
		// TODO Auto-generated method stub


		YoOrderPropertyExample yoOrderPropertyExample = new YoOrderPropertyExample();
		YoOrderPropertyExample.Criteria criteria = yoOrderPropertyExample.createCriteria();
		if(orderName != null) criteria.andOrderNameEqualTo(orderName);
		List<YoOrderProperty> orderPropertyList =yoOrderPropertyMapper.selectByExample(yoOrderPropertyExample);
		YoOrderProperty orderProperty= null;
		if(orderPropertyList!=null&&orderPropertyList.size()>0){ orderProperty = orderPropertyList.get(0);}
		return orderProperty;
	}
	@Override
	public List<YoOrderProperty> getOrderCity(String orderName) {
		// TODO Auto-generated method stub
		YoOrderPropertyExample yoOrderPropertyExample = new YoOrderPropertyExample();
		YoOrderPropertyExample.Criteria criteria = yoOrderPropertyExample.createCriteria();
		if(orderName != null) criteria.andOrderNameEqualTo(orderName);
		List<YoOrderProperty> orderPropertyList =yoOrderPropertyMapper.selectByExample(yoOrderPropertyExample);
		
		return orderPropertyList;
	}
	@Override
	public List<String> getBusinessProperty(String orderName) {
		// TODO Auto-generated method stub
		List<String> strList = new ArrayList<String>();
		YoOrderPropertyExample yoOrderPropertyExample = new YoOrderPropertyExample();
		YoOrderPropertyExample.Criteria criteria = yoOrderPropertyExample.createCriteria();
		if(orderName != null) criteria.andOrderNameEqualTo(orderName);
		List<YoOrderProperty> orderPropertyList =yoOrderPropertyMapper.selectByExample(yoOrderPropertyExample);
		if(orderPropertyList!=null&&orderPropertyList.size()>0){
			String bussProperty =orderPropertyList.get(0).getOrderBusinessProperty();
			if(bussProperty.contains("|")){
				String[] s =bussProperty.split("\\|");
				strList =Arrays.asList(s);
			}else{
				strList.add(bussProperty);
			}
		}
		return strList;
	}

}
