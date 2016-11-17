package com.service.impl;

import com.dao.YoUserinfosalaryMapper;
import com.model.YoUserinfosalary;
import com.model.YoUserinfosalaryExample;
import com.service.IUserInfoSalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ma on 2016/11/14.
 */
@Transactional
@Service
public class UserInfoSalaryServiceImpl implements IUserInfoSalaryService {
    @Autowired
    public YoUserinfosalaryMapper userMapper;
    @Override
    public List<YoUserinfosalary> selectByExample() {
        return null;
    }

    @Override
    public List<YoUserinfosalary> selectSalary(YoUserinfosalary record) {
        return userMapper.selectSalary(record);
    }

    @Override
    public List<YoUserinfosalary> selectByExample(YoUserinfosalaryExample example) {
        return userMapper.selectByExample(example);
    }

    @Override
    public int insert(YoUserinfosalary record) {
        return userMapper.insert(record);
    }
}
