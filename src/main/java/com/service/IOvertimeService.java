package com.service;

import com.model.YoOvertime;

import java.util.List;

/**
 * Created by pwj on 2016/11/7.
 */
public interface IOvertimeService {
    //获取加班表的信息
    List<YoOvertime> selectByExample();
}
