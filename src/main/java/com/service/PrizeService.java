package com.service;

import java.util.List;

import com.model.Prize;

public interface PrizeService {
		//获取所有待抽的奖项
	public List<Prize> selectAllPrize();
		//获取当前该抽的奖项
	public Prize selectNowPrize();
		//选择性更新(更新为空的行)
	public int updateSelective(Prize prize);
		//根据奖品类别查询待抽的剩余奖项
	public List<Prize> selectByType(String prizeType);
}
