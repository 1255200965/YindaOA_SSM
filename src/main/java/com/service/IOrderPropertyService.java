package com.service;

import java.util.List;

import com.model.YoOrderProperty;

public interface IOrderPropertyService {

	
	/**
	 * 根据订单名称获取订单对应的省份
	 * @param orderName 订单名称
	 * @return 
	 */
	YoOrderProperty getOrderProvince(String orderName);
	/**
	 * 根据订单名称获取对应的城市
	 * @param orderName
	 * @return 
	 */
	List<YoOrderProperty> getOrderCity(String orderName);
	
	/**
	 * 根据订单名称获取对应的商务属性 TaskBase or TimeBase
	 * @param orderName
	 * @return 
	 */
	List<String> getBusinessProperty(String orderName);
}
