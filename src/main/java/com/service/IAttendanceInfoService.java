package com.service;

import com.model.YoAtteninfo;
import com.model.YoAtteninfoExample;
import com.model.YoAtteninfoExcelExport;

import java.util.List;



/**
 * Created by ma on 2016/11/15.
 */
public interface IAttendanceInfoService {


        int insertAttend(YoAtteninfo record);


        List<YoAtteninfo> selectByExample(YoAtteninfoExample example);
        //考勤明细导出
        public List<YoAtteninfoExcelExport> selectAtteninfoExcelExport(YoAtteninfo yoAtteninfo);
        
        
    }