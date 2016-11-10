package com.service;

import com.model.AskForLeave;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by ma on 2016/10/15.
 */
public interface IAskLeaveService {
   //获取请假表的信息
   List<AskForLeave> selectByExample();
    
}
