package com.service;

import java.io.IOException;
import java.util.Map;

public interface ISubwayExcelService {

    /**
     * 该方法实现对表头的校验，至于剩余内容的校验，在插入方法中完成
     * 表头不符合规范或者发生了空指针异常，皆视为校验失败
     */
    String validateExcelTitle(String fileDir) throws IOException;

    /**
     * 循环地操作excel中的每一行数据
     * 如果审批编号相同，就更新数据，如果为新数据则插入
     * 为了方便，暂时将Map的格式统一为String+Object
     */
    Map<String, Object> insertAndUpdate(String fileDir) throws IOException;

}
