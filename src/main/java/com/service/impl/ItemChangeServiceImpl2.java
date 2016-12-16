package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.YoItemChangeMapper;
import com.model.YoItemChange;
import com.service.IItemChangeService;
@Service
public class ItemChangeServiceImpl2 implements IItemChangeService{
	@Autowired
	private YoItemChangeMapper itemChangeMapper;
	public List<YoItemChange> selectByPropertities(YoItemChange itemChange){
		return itemChangeMapper.selectByPropertities(itemChange);
	}
}
