package com.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.model.*;
import com.service.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.sql.Result;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by pwj on 2016/10/31.
 */
@Controller
@RequestMapping("/usersalary")
public class SalaryController {
    @Resource
    private ISalaryService userSalaryService;
    @Resource
    private IAttendanceService userAttendanceService;
    @Resource
    private IStaffInfoService userStaffInfoService;
    @Resource
    private IAskLeaveService userAskLeaveService;
    @Resource
    private IOvertimeService userOvertimeService;

    public static AskForLeave askForLeave;
    public static YoAttendance yoAttendance;
    public static YoOvertime yoOvertime;
    public static StaffInfo staffInfo;
    public static YoSalaryTotal yoSalaryTotal;
    public static YoSalary yoSalary;


    //查询员工工资信息
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> query1(@RequestBody YoSalary user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //查询指定id，填充进map
        List<YoSalary> list = userSalaryService.searchYoSalaryByEntity(user);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("userlist",list);
        if(list.size() != 0){
            map.put("msg", "成功");
        }else{
            map.put("msg", "查询结果为空");
        }
        return map;
    }


    //工资生成逻辑
    @RequestMapping("/test.do")
    public String testc(HttpServletRequest request) throws IOException {
        while (1<30) {
            YoSalary newitem = new YoSalary();
            newitem.setUserid("01002626191049");
            newitem.setAttendance("1");
            newitem.setLeavetype("没有");
            newitem.setSalaryid("16318");
            List<YoAttendance> listatt = userAttendanceService.selectByExample();
            for (YoAttendance yoAtt : listatt) {
                if (null != yoAtt.getId() && !yoAtt.getId().isEmpty()) {
                    newitem.setUserid(yoAtt.getUserid().toString());
//                    newitem.setDate(yoAtt.getWorkdate().toString());
                    newitem.setAttendance(yoAtt.getRecordid());
                }
//                for (int i = 0; i < listatt.size(); i++) {
//                    System.out.println(yoAtt.getRecordid());
//                    System.out.println(yoAtt.getWorkdate().toString());
//                }
            }
            List<AskForLeave> listask = userAskLeaveService.selectByExample();
            List<String> lists = new ArrayList<String>();
            for (AskForLeave yoAtt : listask) {
                    newitem.setAttendance(yoAtt.getYoType());
                    newitem.setSalaryid(yoAtt.getYoAskStaffId());
                }
//                for (int i = 0; i < lists.size(); i++) {
//                    System.out.println(yoAtt.getYoType());
//                    System.out.println(yoAtt.getYoAskStaffId());
//                }
            }

    }


    //获取考勤的东西和获取请假里面的自段
    public void Total(String attendance,String askforleave){
        List<YoAttendance> listatt=userAttendanceService.selectByExample();
        List<String> list=new ArrayList<String>();
        for (YoAttendance yoAtt : listatt){
            if(null != yoAtt.getId() && !yoAtt.getId().isEmpty()){
                list.add(yoAtt.getUserid().toString());
                list.add(yoAtt.getRecordid());
                list.add(yoAtt.getWorkdate().toString());
            }
            for(int i=0;i<list.size();i++){
//                System.out.println(list.get(i));
            }

        }

        List<AskForLeave> listask=userAskLeaveService.selectByExample();
        List<String> lists=new ArrayList<String>();
        for (AskForLeave yoAtt : listask){
            if(null != yoAtt.getSequenceNo() && !yoAtt.getSequenceNo().equals(0)){
                lists.add(yoAtt.getSequenceNo().toString());
                lists.add(yoAtt.getYoType());
                lists.add(yoAtt.getYoAskStaffId());
            }
            for(int i=0;i<lists.size();i++){
                System.out.println(lists.get(i));
            }
         }
    }



}
