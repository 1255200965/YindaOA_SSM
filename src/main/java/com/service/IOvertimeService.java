package com.service;

import com.model.YoOvertime;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by pwj on 2016/11/7.
 */
public interface IOvertimeService {
   
    //加班信息列表展示界面所有方法
    public List<YoOvertime> selectByProperties(YoOvertime overTime);
    /**
     * 加班信息导出
     * @param excelHeader
     * @param response
     */
    public void overtimeExport(List<YoOvertime> overTimeList, String []excelHeader,HttpServletResponse response);
}
