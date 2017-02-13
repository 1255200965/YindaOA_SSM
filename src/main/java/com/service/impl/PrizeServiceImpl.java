package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.PrizeMapper;
import com.model.Prize;
import com.model.PrizeExample;
import com.service.PrizeService;

@Service
public class PrizeServiceImpl implements PrizeService{
	
	@Autowired
	private PrizeMapper prizeMapper;
	
	
	@Override
	public List<Prize> selectAllPrize(){
		PrizeExample example = new PrizeExample();
		PrizeExample.Criteria criteria = example.createCriteria();
		criteria.andStatusNotEqualTo("已抽");
		return prizeMapper.selectByExample(example);
	}
	
	@Override
	public Prize selectNowPrize(){
		Prize prize=null;
		try{
			PrizeExample example = new PrizeExample();
			PrizeExample.Criteria criteria = example.createCriteria();
			criteria.andStatusNotEqualTo("已抽");
			prize = prizeMapper.selectByExample(example).get(0);
			System.out.println();
		}catch(Exception e){
			prize=null;
		}
		return prize;
	}
	
	@Override
	public int updateSelective(Prize prize){
		
		return prizeMapper.updateByPrimaryKeySelective(prize);
	}
	@Override
	public List<Prize> selectByType(String prizeType){
		PrizeExample example = new PrizeExample();
		PrizeExample.Criteria criteria = example.createCriteria();
		criteria.andPrizetypeEqualTo(prizeType);
		criteria.andStatusNotEqualTo("已抽");
		List<Prize> prizeList = prizeMapper.selectByExample(example);
		System.out.println("剩余奖品"+prizeList);
		return prizeList;
	}
}
