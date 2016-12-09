package com.service;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.util.Map;

/**
 * Created by baili on 16-11-10.
 */
public interface IExcelSignInService {

    Map<String, Object> insertAndUpdate(HSSFWorkbook hssfWorkbook);
}
