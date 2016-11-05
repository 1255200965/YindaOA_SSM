package com.service;

import java.io.IOException;
import java.util.Map;

/**
 * Created by ma on 2016/10/15.
 */
public interface IBusinessTripExcelService {
    /*插入从excel行得到的实体类*/
    Map<String, Object> insertAskLeave(String fileDir) throws IOException;

    Map<String, Object> insertBusinessTrip(String fileDir) throws IOException;

    Map<String, Object> insertSubway(String fileDir) throws IOException;

    Map<String, Object> insertYoOvertime(String fileDir) throws IOException;

    Map<String, Object> insertYoItemChange(String fileDir) throws IOException;

    Map<String, Object> insertYoYindaIdentify(String fileDir) throws IOException;
}
