package com.service;

import com.model.StaffInfo;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by baili on 16-11-10.
 */
public interface IExcelStaffInfoService {

    /*
     循环地从excel中插入每一行数据
     如果StaffUserId相同，就更新数据
     */
    Map<String, Object> insertAndUpdate(HSSFWorkbook hssfWorkbook);

    /*
    把staffUserId不为空的员工列表返回
     */
    List<StaffInfo> getAllStaff();
}
