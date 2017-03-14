package com.service;

import java.util.List;

import com.model.YoItemChange;

public interface IItemChangeService {
	//项目变更列表展示界面所有方法
	public List<YoItemChange> selectByPropertities(YoItemChange itemChange);
	/**
	 * 根据工号获取项目变更对象的列表
	 * @param staffId 工号
	 * @return
	 */
	List<YoItemChange>  getItemChangeByStaffId(String staffId);
}
