package com.service;

import java.io.IOException;
import java.util.Map;

/**
 * Created by ma on 2016/10/15.
 */
public interface IAskLeaveExcelService {

    Map<String, Object> checkExcelTitle(String fileDir) throws IOException;

    Map<String, Object> insertAndUpdate(String fileDir) throws IOException;
}
