package com.service;

import com.model.YoAtteninfo;
import com.model.YoAtteninfoExample;

import java.util.List;

/**
 * Created by ma on 2016/11/15.
 */
public interface IAttendanceInfoService {


        int insertAttend(YoAtteninfo record);


        List<YoAtteninfo> selectByExample(YoAtteninfoExample example);
    }