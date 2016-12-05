package com.service;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.IOException;
import java.util.Map;

/**
 * Created by baili on 16-11-10.
 */
public interface IExcelAttendanceDetailService {

    Map<String, Object> insertAndUpdate(HSSFWorkbook hssfWorkbook);
}
