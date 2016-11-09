package com.service.impl;

import com.model.YoOvertime;
import com.service.IOvertimeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by pwj on 2016/11/7.
 */
@Transactional
@Service
public class OvertimeServiceImpI implements IOvertimeService{
    @Override
    public List<YoOvertime> selectByExample() {
        return selectByExample();
    }
}
