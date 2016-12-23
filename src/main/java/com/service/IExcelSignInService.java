package com.service;

import com.model.YoSignIn;
import com.model.YoSignInExample;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.util.List;
import java.util.Map;

/**
 * Created by baili on 16-11-10.
 */
public interface IExcelSignInService {

    Map<String, Object> insertAndUpdate(HSSFWorkbook hssfWorkbook);

    List<YoSignIn> selectByExample(YoSignInExample example);
}
