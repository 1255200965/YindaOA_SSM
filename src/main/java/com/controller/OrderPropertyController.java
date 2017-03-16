package com.controller;

import java.util.ArrayList;
import java.util.Arrays;
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
	
	
	/**
	 * 根据订单名获得省份
	 * @param orderName 订单名
	 * @return
	 */
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
	
	/**
	 * 根据订单名中获取当前城市
	 * @param orderName 订单名
	 * @return
	 */
	@RequestMapping("getOrderCity.do")
	@ResponseBody
	public List<String> getOrderCity(String orderName){
		List<YoOrderProperty> o = iOrderPropertyService.getOrderCity(orderName);
		System.out.println("o"+o);
		if(o==null||o.size()==0){
			return null;
		}
		List<String> strList = null;
		try{
			System.out.println(o.get(0).getOrderCity());
			strList = Arrays.asList(o.get(0).getOrderCity().split("\\|"));
		}catch(Exception e){
			return null;	
		}	 
		System.out.println(strList.size());
		return strList;
	}
	
	/**
	 * 根据订单名获取商务属性
	 * @param orderName
	 * @return
	 */
	@RequestMapping("getBusinessProperty.do")
	@ResponseBody
	public List<String> getBusinessProperty(String orderName){
		List<String> strList = iOrderPropertyService.getBusinessProperty(orderName);		
		return strList;
	}
	
}
