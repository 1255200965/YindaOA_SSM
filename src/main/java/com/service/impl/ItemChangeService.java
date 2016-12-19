package com.service.impl;

import java.util.List;

import com.service.IItemChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.YoItemChangeMapper;
import com.model.YoItemChange;

@Service
public class ItemChangeService implements IItemChangeService {
	@Autowired
	private YoItemChangeMapper itemChangeMapper;

	public List<YoItemChange> selectByPropertities(YoItemChange itemChange){
//		return itemChangeMapper.selectByPropertities(itemChange);
		return null;
	}
}
