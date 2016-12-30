package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.YoOrderPropertyMapper;
import com.model.YoOrderProperty;
import com.service.IOrderPropertyService;

@Controller
@RequestMapping("orderProperty")
public class OrderPropertyController {

	@Autowired
	private YoOrderPropertyMapper  yoOrderPropertyMapper;
	
	@Autowired
	private IOrderPropertyService iOrderPropertyService;
	
	
	
	@RequestMapping(value="getOrderProvince.do",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getOrderProvince(String orderName){
		YoOrderProperty o = iOrderPropertyService.getOrderProvince(orderName);
		if(o!=null){
			System.out.println(o.getOrderProvince());
			return o.getOrderProvince().toString();
		}
		return null;
	}
	
	
	@RequestMapping("getOrderCity.do")
	@ResponseBody
	public List<YoOrderProperty> getOrderCity(String orderName){
		List<YoOrderProperty> o = iOrderPropertyService.getOrderCity(orderName);		
		return o;
	}
	
	
	@RequestMapping("getBusinessProperty.do")
	@ResponseBody
	public List<String> getBusinessProperty(String orderName){
		List<String> strList = iOrderPropertyService.getBusinessProperty(orderName);		
		return strList;
	}
	
}
