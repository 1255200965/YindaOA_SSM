package com.service;

import java.util.List;

import com.model.YoItemChange;

public interface IItemChangeService {
	//项目变更列表展示界面所有方法
	public List<YoItemChange> selectByPropertities(YoItemChange itemChange); 
	List<YoItemChange>  getItemChangeByStaffId(String staffId);
}
