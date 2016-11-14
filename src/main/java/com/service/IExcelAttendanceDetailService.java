package com.service;

import java.io.IOException;
import java.util.Map;

/**
 * Created by baili on 16-11-10.
 */
public interface IExcelAttendanceDetailService {

    String validateExcelTitle(String fileDir) throws IOException;

    Map<String, Object> insertAndUpdate(String fileDir) throws IOException;
}
