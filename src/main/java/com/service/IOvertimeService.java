package com.service;

import com.model.YoOvertime;

import java.util.List;

/**
 * Created by pwj on 2016/11/7.
 */
public interface IOvertimeService {
   
    //加班信息列表展示界面所有方法
    public List<YoOvertime> selectByProperties(YoOvertime overTime);
}
