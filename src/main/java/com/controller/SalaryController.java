package com.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.model.*;
import com.service.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.tagext.PageData;
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
    int getMaxDate(int year,int month){
            if (month == 1) {
                month = 12;
                year--;
            } else month--;
        if (month == 2) {
            if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
                return 29;
            } else return 28;
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) return 30;
        return 31;
    }
    String getLastMonth(int year,int month){
        if (month == 1){
            month = 12;
            year --;
        } else month --;
        return ""+year + '-' + month ;
    }
    String formartDate(int day){
        if (day<10) return "0"+day;
        else return ""+day;
    }
    //请假类型，所扣工资
    double DateSalary(String type,double baseSalary){
        double salary=0;
        if (type.equals("事假")) {
            salary =  -baseSalary;
        } else if (type.equals("病假")) {
            salary = - baseSalary/2;
        } else if (type.equals("年假")) {
            salary = 0;
        } else if (type.equals("调休")) {
            salary = 0;
        } else if (type.equals("婚假")) {
            salary =  -0;
        } else if (type.equals("调休")) {
            salary =  -0;
        } else if (type.equals("产假")) {
            salary =  -0;
        } else if (type.equals("陪产假")) {
            salary =  -0;
        } else if (type.equals("路途假")) {
            salary =  -0;
        } else if (type.equals("其他")) {
            salary =  -0;
        } else {
            salary =  -0;
        }
        return salary;
    }
    double getBaseSalary(String base,int day){
        return 100;
    }
    String getNext(int year ,int month,int num){
        //如果是上个月的,计算的也是上个月的日期
        int maxDate = getMaxDate(year,month);
        if (num + 21 <= maxDate){
            return "" + getLastMonth(year,month) + '-' + formartDate(num + 21);
        } else if (num < maxDate){
            return "" + year + '-' + month + '-' + formartDate(num + 21 - maxDate);
        }
        return null;
    }
    //工资生成逻辑
    void generateSalary(int nowyear,int nowMonth){
        try {
            //选取年月 2016-11
            // nowyear = 2016;
            // nowMonth = 11;
            //当前工资序列
            String workMonth = "" + nowyear + '-' + nowMonth;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            //查询用户列表
            StaffInfo staff = new StaffInfo();
            List<StaffInfo> userlist = userStaffInfoService.selectStaffInfo(staff);
            //开始循环每个人
            for(StaffInfo user: userlist) {
                //当前序列
                //if (!user.getName().equals("马天立")) continue;
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
                        today.setAdditionalsalary(0.0);
                        //today.setworkaddress("");
                    } else{
                        today.setAttendance("1");
                        today.setAttendanceSalary(getBaseSalary(user.getBaseSalary(),getMaxDate(nowyear,nowMonth)));
                        //today.setworkaddress(cqlist.get(0).getLocationresult());
                    }
                    //处理请假
                    AskForLeaveExample qjExample = new AskForLeaveExample();
                    AskForLeaveExample.Criteria criteria1 = qjExample.createCriteria();
                    criteria1.andYoAskStaffIdEqualTo(today.getSalaryid());
                    criteria1.andYoApproveResultEqualTo("同意");
                    criteria1.andYoAskBeginDateLessThanOrEqualTo(workDate);
                    criteria1.andYoAskEndDateGreaterThanOrEqualTo(workDate);
                    List<AskForLeave> qjlist = userAskLeaveService.selectByExample(qjExample);
                    if (0 == qjlist.size()){
                        //当天没有请假
                        today.setLeavetype("0");
                    } else{
                        //today.setLeavetype("1");
                        //根据请假类型扣款
                        today.setLeavetype(qjlist.get(0).getYoType());
                        today.setLeavesalary(DateSalary(today.getLeavetype(),getBaseSalary(user.getBaseSalary(),getMaxDate(nowyear,nowMonth))));
                    }
                    //判断真实出勤
                    today.setDatetype(today.getAttendance());
                    if (!today.getLeavetype().equals("0"))
                    {
                        //如果有请假，实际算出勤，然后扣除对应的工资
                        today.setDatetype("1");
                    }
                    //处理加班
                    today.setWorkovertime("0");
                    today.setWorksalary(0.0);
                    //处理出差,签到地点与base地是否匹配
                    String address = user.getWorkAddress();
                    if (today.getDatetype().equals("1") && address.equals(today.getEvection())){
                        today.setEvection("1");
                    } else {
                        today.setEvection("0");
                    }
                    //timebase奖金
                    //公交地铁票

                    //插入到数据库
                    userSalaryService.insert(today);
                    workDate = getNext(nowyear, nowMonth, l++);
                }
            }
        } catch (Exception e){

        }
    }
    @RequestMapping("/test.do")
    public String testc(HttpServletRequest request) throws IOException {
        //generateSalary(2016,11);

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
                    System.out.println("请教总次数"+userIds.size());
                }
            }
        }
    }


    @RequestMapping()


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

//    @RequestMapping("/getAllUser.do")
//    @ResponseBody
//    public ModelAndView querySalaryList(@RequestBody YoSalary usersalary){
//        List<YoSalary> list=userSalaryService.searchYoSalaryByEntity(usersalary);
//        ModelAndView modelView=new ModelAndView();
//        Map<String,Object> modelMap=new HashMap<String,Object>();
//        modelMap.put("userid", list);
//        modelMap.put("date", list);
//        modelView.addAllObjects(modelMap);
//        System.out.println("返回JSON数据"+modelView);
//        return modelView;
//    }


    //根据类型日期的查询
    @RequestMapping("/QueryType")
    @ResponseBody
    public Object handleQuerySchemaEnName(@RequestParam(value = "userid", defaultValue = "") String userid,
                                          @RequestParam(value = "date", defaultValue = "") String date,
                                          @RequestParam(value = "leavetype", defaultValue = "") String leavetype,YoSalary yoSalary) {
        try {
            List<YoSalary> schemaEnNameList = userSalaryService.searchYoSalaryByEntity(yoSalary);
            Map<String,Object> map = new HashMap();
            map.put("userid",userid);
            map.put("date",date);
            map.put("leavetype",leavetype);
            map.put("root", schemaEnNameList);
            map.put("success", true);
            System.out.print("返回map数据"+map.toString());
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/AllSalary";
    }


    //不知道根据用户id，日期,
    @RequestMapping("/QuerySalary")
    @ResponseBody
    public Object QuerySalary(@RequestParam(value = "userid", defaultValue = "") String userid,
                              @RequestParam(value = "date", defaultValue = "") String date,YoSalary yoSalary) {
        try {
            List<YoSalary> schemaEnNameList = userSalaryService.searchYoSalaryByEntity(yoSalary);
            Map<String,Object> map = new HashMap();
            map.put("userid",userid);
            map.put("date",date);
            map.put("root", schemaEnNameList);
            map.put("success", true);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
