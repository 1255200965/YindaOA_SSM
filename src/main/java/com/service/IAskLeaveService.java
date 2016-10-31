package com.service;

import java.io.IOException;
import java.util.Map;

/**
 * Created by ma on 2016/10/15.
 */
public interface IAskLeaveService {
    /*插入从excel行得到的实体类*/
    Map<String, Object> insert(String fileDir) throws IOException;

}
