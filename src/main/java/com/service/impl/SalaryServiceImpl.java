package com.service.impl;


import com.dao.YoSalaryMapper;
import com.model.ExpenseApplayBus;
import com.model.ExpenseApplayBusExample;
import com.model.YoSalary;
import com.model.YoSalaryExample;
import com.service.ISalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by pwj on 2016/10/31.
 */
@Transactional
@Service
public class SalaryServiceImpl implements ISalaryService {

    @Autowired
    private YoSalaryMapper yoSalaryMapper;

    //添加工资生成表

    public int insert(YoSalary record) {
        return yoSalaryMapper.insertSelective(record);
    }


    public List<YoSalary> searchYoSalaryByEntity(YoSalaryExample example) {
        return yoSalaryMapper.selectByExample(example);
    }

    public List<YoSalary> selectByExample(YoSalaryExample example){
        return yoSalaryMapper.selectByExample(example);
    }


   @Override
    public int updateByPrimaryKey(YoSalary yoSalaryid) {
       return yoSalaryMapper.updateByPrimaryKey(yoSalaryid);
    }



	@Override
	public List<YoSalary> select_BY_Anttendane(String userid, Date date) {
		// TODO Auto-generated method stub
		YoSalary yo = new YoSalary();
		yo.setUserid(userid);
		yo.setDate(date);
		return  yoSalaryMapper.select_BY_Anttendane(yo);
	}


	@Override
	public List<YoSalary> select_BY_Leavetype(String userid, Date date) {
		// TODO Auto-generated method stub
		YoSalary yo = new YoSalary();
		yo.setUserid(userid);
		yo.setDate(date);
		return   yoSalaryMapper.select_BY_Leavetype(yo);
	}


	@Override
	public List<YoSalary> select_BY_WorkTime(String userid, Date date) {
		// TODO Auto-generated method stub
		YoSalary yo = new YoSalary();
		yo.setUserid(userid);
		yo.setDate(date);
		return yoSalaryMapper.select_BY_WorkTime(yo);
	}


	@Override
	public List<YoSalary> select_BY_Evenctime(String userid, Date date) {
		// TODO Auto-generated method stub
		YoSalary yo = new YoSalary();
		yo.setUserid(userid);
		yo.setDate(date);
		return yoSalaryMapper.select_BY_Evenctime(yo);
	}


}
