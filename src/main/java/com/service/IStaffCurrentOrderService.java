package com.service;

import com.model.YoStaffCurrentOrder;

public interface IStaffCurrentOrderService {

	/**
	 * 根据钉钉号 获取当前项目订单表中的第一个订单
	 * @param staff_user_id
	 * @return
	 */
	public YoStaffCurrentOrder getStaffCurrentOrderByStaff_user_id(String staff_user_id);
}
