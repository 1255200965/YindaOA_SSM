package com.service.impl;

import com.dao.YoAtteninfoMapper;
import com.model.YoAtteninfo;
import com.model.YoAtteninfoExample;
import com.model.YoAtteninfoExcelExport;
import com.service.IAttendanceInfoService;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ma on 2016/11/15.
 */
@Transactional
@Service
public class AttendanceInfoServiceImpl implements IAttendanceInfoService{

    @Autowired
    private YoAtteninfoMapper attendanceMapper;


    public int insertAttend(YoAtteninfo record) {
        return attendanceMapper.insert(record);
    }



    public List<YoAtteninfo> selectByExample(YoAtteninfoExample example) {
        return attendanceMapper.selectByExample(example);
    }
    
    @Override
    public List<YoAtteninfoExcelExport> selectAtteninfoExcelExport(YoAtteninfo yoAtteninfo){
    	return attendanceMapper.selectAtteninfoExcelExport(yoAtteninfo);
    }
}