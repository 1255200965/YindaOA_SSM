package com.service;

import java.util.List;

import com.model.LuckyStaff;

public interface ILuckyStaffService {
	//保存抽奖结果
	public void save(LuckyStaff luckyStaff);
	//查看抽奖结果
	public List<LuckyStaff> selectAll();
}
