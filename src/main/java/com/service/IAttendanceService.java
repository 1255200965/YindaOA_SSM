package com.service;

import com.model.YoAttendance;

import java.util.List;

/**
 * Created by pwj on 2016/11/4.
 */
public interface IAttendanceService {

    int insertAttend(YoAttendance record);

    List<YoAttendance> selectByExample();
}
