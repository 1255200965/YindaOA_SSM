package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.LuckyStaffMapper;
import com.model.LuckyStaff;
import com.model.LuckyStaffExample;
import com.service.ILuckyStaffService;
@Service
public class LuckyStaffServiceImpl implements ILuckyStaffService{
	@Autowired
	private LuckyStaffMapper LSMapper;
	
	
	@Override
	public void save(LuckyStaff luckyStaff){
		
		LSMapper.insert(luckyStaff);
	}
	@Override
	public List<LuckyStaff> selectAll(){
		LuckyStaffExample example = new LuckyStaffExample();
		LuckyStaffExample.Criteria criteria = example.createCriteria();
		criteria.andIdGreaterThan(0);
		return LSMapper.selectByExample(example);
	}
	@Override
	public List<LuckyStaff> selectByStaffId(String staffId){
		LuckyStaffExample example = new LuckyStaffExample();
		LuckyStaffExample.Criteria criteria = example.createCriteria();
		criteria.andStaffIdEqualTo(staffId);
		return LSMapper.selectByExample(example);
	}
}
