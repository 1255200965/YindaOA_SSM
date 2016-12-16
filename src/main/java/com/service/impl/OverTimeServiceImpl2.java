package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.YoOvertimeMapper;
import com.model.YoOvertime;
import com.service.IOvertimeService;

@Service
public class OverTimeServiceImpl2 implements IOvertimeService{
   @Autowired
   private YoOvertimeMapper overTimeMapper;
   @Override
   public List<YoOvertime> selectByProperties(YoOvertime overTime){
	  return overTimeMapper.selectByProperties(overTime);
   }
}
