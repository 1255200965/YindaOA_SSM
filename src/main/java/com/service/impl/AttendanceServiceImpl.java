package com.service.impl;

import com.dao.YoAttendanceMapper;
import com.model.YoAttendance;
import com.model.YoAttendanceExample;
import com.service.IAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by pwj on 2016/11/4.
 */
@Transactional
@Service
public class AttendanceServiceImpl implements IAttendanceService{

    @Autowired
    private YoAttendanceMapper attendanceMapper;


    public int insertAttend(YoAttendance record) {
        return attendanceMapper.insert(record);
    }


    public List<YoAttendance> selectByExample() {
        return attendanceMapper.selectByExample();
    }

    public List<YoAttendance> selectByExample(YoAttendanceExample example) {
        return attendanceMapper.selectByExample(example);
    }
}
