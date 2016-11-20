package com.service.impl;

import com.dao.OaWtrSalaryMapper;
import com.model.OaWtrSalary;
import com.model.OaWtrSalaryExample;
import com.service.IWtrSalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ma on 2016/11/18.
 */

@Transactional
@Service
public class WtrSalaryServiceImpl implements IWtrSalaryService {
    @Autowired
    public OaWtrSalaryMapper userMapper;



    @Override
    public List<OaWtrSalary> selectByExample(OaWtrSalaryExample example) {
        return userMapper.selectByExample(example);
    }


    @Override
    public int insert(OaWtrSalary record) {
        return userMapper.insert(record);

    }
}