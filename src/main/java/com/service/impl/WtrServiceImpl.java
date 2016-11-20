package com.service.impl;

import com.dao.OaWtrMapper;
import com.model.OaWtr;
import com.model.OaWtrExample;
import com.model.YoUserinfosalary;
import com.service.IWtrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ma on 2016/11/18.
 */

@Transactional
@Service
public class WtrServiceImpl implements IWtrService {
    @Autowired
    public OaWtrMapper userMapper;


    @Override
    public List<OaWtr> selectByExample(OaWtrExample example) {
        return userMapper.selectByExample(example);
    }


    @Override
    public int insert(OaWtr record) {
        return userMapper.insert(record);

    }
}