package com.service.impl;

import java.util.List;

import com.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.YoItemChangeMapper;
import com.model.YoItemChange;
import com.model.YoItemChangeExample;
import com.service.IItemChangeService;
@Service
public class ItemChangeServiceImpl2 implements IItemChangeService{
	@Autowired
	private YoItemChangeMapper itemChangeMapper;
	public List<YoItemChange> selectByPropertities(YoItemChange itemChange){
		return itemChangeMapper.selectByPropertities(itemChange);
	}
	@Override
	public List<YoItemChange> getItemChangeByStaffId(String staffId) {
		
		YoItemChangeExample example = new YoItemChangeExample();
		YoItemChangeExample.Criteria criteria = example.createCriteria();
		if(StringUtil.NotBlank(staffId)){criteria.andIcAskStaffIdEqualTo(staffId);}
		
		List<YoItemChange> yoItemChangeList=itemChangeMapper.selectByExample(example);
		return yoItemChangeList;
	}
}
