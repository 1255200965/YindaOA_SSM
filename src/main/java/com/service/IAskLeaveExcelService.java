package com.service;

import java.io.IOException;
import java.util.Map;

/**
 * Created by ma on 2016/10/15.
 */
public interface IAskLeaveExcelService {

    Map<String, Object> checkAskLeaveExcel(String fileDir) throws IOException;

//    Map<String, Object> insertAskLeave(String fileDir) throws IOException;
}
