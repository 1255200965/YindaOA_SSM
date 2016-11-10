package com.controller;


import com.model.*;
import com.service.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
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


    public static AskForLeave askForLeave;
    public static YoAttendance yoAttendance;
    public static YoOvertime yoOvertime;
    public static StaffInfo staffInfo;


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

    String getNext(int year ,int month,int num){
        //如果是上个月的
        if (num + 21 <= 31){
            return "" + year + '-' + (month - 1) + '-' + (num + 21);
        } else if (num < 31){
            return "" + year + '-' + month + '-' + (num - 10);
        }
        return null;
    }
    //工资生成逻辑
    @RequestMapping("/test.do")
    public String testc(HttpServletRequest request) throws IOException {
        try {
            //选取年月 2016-11
            int nowyear = 2016;
            int nowMonth = 11;
            //当前工资序列
            String workMonth = "" + nowyear + '-' + nowMonth;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
/*            YoSalary today1 = new YoSalary();
            today1.setSalarydate(workMonth);
            today1.setSid(0);
            userSalaryService.insert(today1);*/

            //查询用户列表
            StaffInfo staff = new StaffInfo();
            List<StaffInfo> userlist = userStaffInfoService.selectStaffInfo(staff);
            //开始循环每个人
            for(StaffInfo user: userlist) {
                //当前许序列
                int l = 0;
                //当前日期
                String workDate = getNext(nowyear, nowMonth, l++);
                while (workDate != null) {
                    //处理一天的工资
                    YoSalary today = new YoSalary();
                    today.setSalarydate(workMonth);
                    today.setDate(sdf.parse(workDate));
                    today.setUserid(user.getStaffUserId());
                    today.setSalaryid(user.getStaffId());

                    //处理出勤,查询一个人当天的打卡情况
                    YoAttendanceExample attExample = new YoAttendanceExample();
                    YoAttendanceExample.Criteria criteria = attExample.createCriteria();
                    criteria.andUseridEqualTo(today.getUserid());
                    criteria.andWorkdateEqualTo(workDate);
                    List<YoAttendance> cqlist = userAttendanceService.selectByExample(attExample);
                    if (0 == cqlist.size()){
                        //当天没有出勤
                        today.setAttendance("0");
                    } else{
                        today.setAttendance("1");
                    }
                    //处理请假
                    /*AskForLeaveExample qjExample = new AskForLeaveExample();
                    AskForLeaveExample.Criteria criteria1 = qjExample.createCriteria();
                    criteria1.andYoAskStaffIdEqualTo(today.getYoAskStaffId());
                    criteria1.andYoApproveStateEqualTo("同意");
                    criteria1.andYoAskBeginDateLessThanOrEqualTo(workDate);
                    criteria1.andYoAskEndDateGreaterThanOrEqualTo(workDate);
                    List<AskForLeave> qjlist = userAskLeaveService.selectByExample(qjExample);
                    if (0 == qjlist.size()){
                        //当天没有请假
                        today.setYoType("0");
                    } else{
                        today.setYoType("1");
                        //根据请假类型扣款
                        //today.setLeavesalary();
                    }*/
                    //处理加班

                    //处理出差

                    //插入到数据库
                    userSalaryService.insert(today);
                    workDate = getNext(nowyear, nowMonth, l++);
                }
            }
        } catch (Exception e){

        }

        return "/UserSalary" ;
    }



    //出勤总数
    public void totalAttendance(String atttotal) {
        List<YoAttendance> list = userAttendanceService.selectByExample();
        List<String> userIds = new ArrayList<String>();
        //统计所有考勤总有请假或者其它原因的记录员工
        for (int i = 0; i < userIds.size(); i++) {
            if (userIds.contains(userIds.get(i))) {
                continue;
            }
            userIds.add(userIds.get(i));
        }
        //统计每个员工的考勤的次数
        for (int i = 0; i < userIds.size(); i++) {//有多少个员工的考勤记录
            for (int j = 0; j < list.size(); j++) {//对每条考勤记录进行统计
                if (userIds.get(i).equals(list.get(j).getUserid())) {
                    System.out.println("考勤总次数:"+userIds.size());
                }
            }
        }
    }

    //请假总数
    public void totalAskLeave(String asktotal) {
        List<YoAttendance> list = userAttendanceService.selectByExample();
        List<String> userIds = new ArrayList<String>();
        //员工的所有请假次数
        for (int i = 0; i < userIds.size(); i++) {
            if (userIds.contains(userIds.get(i))) {
                continue;
            }
            userIds.add(userIds.get(i));
        }
        //统计每个员工的请假的次数
        for (int i = 0; i < userIds.size(); i++) {//有多少个员工的考勤记录
            for (int j = 0; j < list.size(); j++) {//对每条考勤记录进行扣除工资计算
                if (userIds.get(i).equals(list.get(j).getUserid())) {
                    System.out.println("请教总次数");
                }
            }
        }
    }





    /***
     * 请假算法
     * @param
     */
    public void AskLeave(String askTotal) {
        List<AskForLeave> list=userAskLeaveService.selectByExample();
        List<String> listAll=new ArrayList<String>();
        for (AskForLeave yoAtt : list){
            if(null != yoAtt.getSequenceNo() && !yoAtt.getSequenceNo().equals(0)){
                listAll.add(yoAtt.getSequenceNo().toString());
                listAll.add(yoAtt.getYoType());
                listAll.add(yoAtt.getYoTitle());
                listAll.add(yoAtt.getYoApproveResult());
                listAll.add(yoAtt.getYoAskReason());
            }
        }
        for(int i=0;i<listAll.size();i++){
            String result=listAll.get(i);
        }
    }


    //请假类型，所扣工资
    public double DateSalary(String begintime,String endtime,String type){
        double onResult=LeaveData(begintime,endtime);
        double salary=0;
        if (type.equals("事假")) {
            salary = onResult -275;
        } else if (type.equals("病假")) {
            salary = onResult -275/2;
        } else if (type.equals("年假")) {
            salary = onResult -0;
        } else if (type.equals("调休")) {
            salary = onResult -0;
        } else if (type.equals("婚假")) {
            salary = onResult -0;
        } else if (type.equals("调休")) {
            salary = onResult -0;
        } else if (type.equals("产假")) {
            salary = onResult -0;
        } else if (type.equals("陪产假")) {
            salary = onResult -0;
        } else if (type.equals("路途假")) {
            salary = onResult -0;
        } else if (type.equals("其他")) {
            salary = onResult -0;
        } else {
            salary = onResult -0;
        }
        return salary;
    }

    //请假时间
    public double LeaveData(String begintime, String endtime) {
        DateFormat dateFat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dateStart = dateFat.parse(begintime);
            Date dateStop = dateFat.parse(endtime);
            double result = dateStart.getTime() - dateStop.getTime() / 86400000;
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }



    //加班时间
    public double Overtime(String begintime, String endtime) {
        DateFormat dateFat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dateStart = dateFat.parse(begintime);
            Date dateStop = dateFat.parse(endtime);
            double result = dateStart.getTime() - dateStop.getTime() / 86400000;
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    //加班算法
    public void AddDateSalary(String begintime,String endtime,String type){
        double onResult=LeaveData(begintime,endtime);
        double salary=0;
        if (type.equals("加班")) {
            salary = onResult +275;
        } else if (type.equals("调休")) {
            salary = onResult +0;
        }
    }

    public void totalSalary(){
        //考勤总数
        //
    }





}
