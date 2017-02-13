package com.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dao.StaffInfoMapper;
import com.model.*;
import com.service.*;
import com.util.DDUtil;
import com.util.SalaryUtil;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.tagext.PageData;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by pwj on 2016/10/31.
 * 这是工资查询页面的controller
 */
@Controller
@RequestMapping("/usersalary")
public class SalaryController {
    @Resource
    private ISalaryService userSalaryService;
    @Resource
    private IAttendanceInfoService userAttendanceService;
    @Resource
    private IExcelSignInService userSighInService;
    @Resource
    private IStaffInfoService userStaffInfoService;
    @Resource
    private IAskLeaveService userAskLeaveService;
    @Resource
    private IUserInfoSalaryService userinfoSalaryService;

    @Autowired
    private StaffInfoMapper staffInfoMapper;
    @Resource
    private IWtrService wtrService;
    @Resource
    private IWtrSalaryService wtrSalaryService;

    public static AskForLeave askForLeave;
    public static YoAttendance yoAttendance;
    public static YoOvertime yoOvertime;
    public static StaffInfo staffInfo;

    //查询员工工资信息(工资单分项)
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> query1(@RequestBody YoSalary user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //查询指定id，填充进map
        Map<String,Object> map = new HashMap<String,Object>();

        //工资单
        YoSalaryExample example = new YoSalaryExample();
        YoSalaryExample.Criteria criteria1 = example.createCriteria();
        if (user.getSalarydate()!=null && user.getSalarydate() !="") criteria1.andSalarydateEqualTo(user.getSalarydate());
        if (user.getStaffid()!=null && user.getStaffid() !="") criteria1.andStaffidEqualTo(user.getStaffid());
        List<YoSalary> query = userSalaryService.selectByExample(example);
        if (query.size()>0){
            map.put("list",query);
        }

        if(query.size() != 0){
            map.put("msg", "成功");
        }else{
            map.put("msg", "单项查询结果为空");
        }

        //工资单合计
        YoUserinfosalaryExample example1 = new YoUserinfosalaryExample();
        YoUserinfosalaryExample.Criteria criteria2 = example1.createCriteria();
        if (user.getSalarydate()!=null && user.getSalarydate() !="") criteria2.andSalarydateEqualTo(user.getSalarydate());
        if (user.getStaffid()!=null && user.getStaffid() !="") criteria2.andSalaryidEqualTo(user.getStaffid());
        List<YoUserinfosalary> query1 = userinfoSalaryService.selectByExample(example1);
        if (query1.size()>0){
            map.put("total",query1.get(0));
            map.put("msg", "成功");
        } else {
            map.put("total",user);
            map.put("msg", "合计查询结果为空");
        }

        return map;
    }
    //查询员工工资信息(合计)
    @RequestMapping(value = "/querySalary", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> query2(@RequestBody YoUserinfosalary user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //查询指定id，填充进map

        Map<String,Object> map = new HashMap<String,Object>();


        //工资单
        YoUserinfosalaryExample example = new YoUserinfosalaryExample();
        YoUserinfosalaryExample.Criteria criteria1 = example.createCriteria();
        if (user.getSalarydate()!=null) criteria1.andSalarydateEqualTo(user.getSalarydate());
        if (user.getUserid()!=null) criteria1.andUseridEqualTo(user.getUserid());
        List<YoUserinfosalary> query = userinfoSalaryService.selectByExample(example);
        if ("2017-01".equals(user.getSalarydate())){
            query = userinfoSalaryService.search_Jan_salary(user.getUserid(),user.getSalarydate());
        }
        if (query.size()>0){
            map.put("total",query.get(0));
            map.put("msg", "成功");
        } else {
            map.put("total",user);
            map.put("msg", "查询结果为空");
        }

        return map;
    }
    @RequestMapping("/queryUserid")
    @ResponseBody
    public Object queryUserid(@RequestBody String code) {
        try {
            String userid = DDUtil.getUserID(code);
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("userid",userid);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
    //判断是否周末
    public boolean checkHoliday(Calendar calendar) throws Exception{

        //判断日期是否是周六周日
        if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ||
                calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
            return true;
        }
        //判断日期是否是节假日

        return false;
    }
    //请假类型，所扣工资
    double DateSalary(String type,double baseSalary){
        double salary=0;
        if (type.equals("事假")) {
            salary =  0;
        } else if (type.equals("病假")) {
            salary =  baseSalary/2;
        } else if (type.equals("年假")) {
            salary = baseSalary;
        } else if (type.equals("调休")) {
            salary = baseSalary;
        } else if (type.equals("婚假")) {
            salary =  baseSalary;
        } else if (type.equals("调休")) {
            salary = baseSalary;
        } else if (type.equals("产假")) {
            salary =  baseSalary;
        } else if (type.equals("陪产假")) {
            salary =  baseSalary;
        } else if (type.equals("路途假")) {
            salary = baseSalary;
        } else if (type.equals("其他")) {
            salary =  0;
        } else {
            salary =  0;
        }
        return salary;
    }
    //获取日基础工资
    double getBaseSalary(String base,double day){
        if (base == null || base.isEmpty()) return 0.0;
        return Double.parseDouble(base)/day;
    }
    //判断合同类型是否发加班费
    boolean checkContract(String type){
        if (type != null && (type.equals("F") || type.equals("D") || type.equals("S")) ) return false;
        return  true;
    }
    //按技术等级获取timebase奖金
    double callYI(String type){
        double salary=0;
        if (type== null || type.isEmpty()) return salary;
        if (type.equals("OJT")) {
            salary =  0;
        } else if (type.equals("初级1")) {
            salary =  20;
        } else if (type.equals("初级2")) {
            salary = 40;
        } else if (type.equals("中级1")) {
            salary = 40;
        } else if (type.equals("中级2")) {
            salary =  60;
        } else if (type.equals("中级3")) {
            salary = 80;
        } else if (type.equals("中级4")) {
            salary =  100;
        } else if (type.equals("高级1")) {
            salary = 100;
        } else if (type.equals("高级2")) {
            salary = 120;
        } else if (type.equals("高级3")) {
            salary =  150;
        } else if (type.equals("高级4")) {
            salary = 200;
        } else if (type.equals("高级5")) {
            salary = 300;
        } else if (type.equals("专家1")) {
            salary =  400;
        }
        return salary;
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
    void generateSalary1(int nowyear,int nowMonth) {
        try {
            //查询用户列表
            StaffInfo staff = new StaffInfo();
            List<StaffInfo> userlist = userStaffInfoService.selectStaffInfo(staff);

            for(StaffInfo user: userlist) {
                YoUserinfosalary totalSum = new YoUserinfosalary();
                totalSum.setUserid(user.getStaffUserId());
                totalSum.setSalaryid(user.getStaffId());
                totalSum.setDatetype("0");
                totalSum.setAttendance("0");
                totalSum.setAttendancesalary(0.0);
                totalSum.setLeavetype("0");
                totalSum.setLeavesalary(0.0);
                totalSum.setWorkovertime("0");
                totalSum.setWorksalary(0.0);
                totalSum.setEvection("0");
                totalSum.setAllowance(0.0);
                totalSum.setTimesalary(0.0);
                totalSum.setEffectiveattendance("0");
                totalSum.setRealityattendance("0");


                YoSalaryExample Example = new YoSalaryExample();
                YoSalaryExample.Criteria criteria1 = Example.createCriteria();
                criteria1.andSalarydateEqualTo("2016-12");
                criteria1.andUseridEqualTo(user.getStaffUserId());

                List<YoSalary> salaryList = userSalaryService.searchYoSalaryByEntity(Example);
                for(YoSalary today:salaryList){
                    //累加总工资
                    if (today.getDatetype().equals("工")) {
                        totalSum.setDatetype(Integer.parseInt(totalSum.getDatetype())+1+"");
                    }
                    totalSum.setAttendance(Integer.parseInt(totalSum.getAttendance())+Integer.parseInt(today.getAttendance())+"");
                    totalSum.setAttendancesalary(totalSum.getAttendancesalary() + today.getAttendanceSalary());
                    if (!today.getLeavetype().equals("0")) {
                        totalSum.setLeavetype(Integer.parseInt(totalSum.getLeavetype())+1+"");
                    }
                    totalSum.setLeavesalary(totalSum.getLeavesalary() + today.getLeavesalary());
                    totalSum.setWorkovertime(Integer.parseInt(totalSum.getWorkovertime())+Integer.parseInt(today.getWorkovertime())+"");
                    totalSum.setWorksalary(totalSum.getWorksalary() + today.getWorksalary());
                    totalSum.setEvection(Integer.parseInt(totalSum.getEvection())+Integer.parseInt(today.getEvection())+"");
                    totalSum.setAllowance(totalSum.getAllowance()+today.getAllowance());
                    totalSum.setTimesalary(totalSum.getTimesalary()+today.getTimesalary());
                    totalSum.setEffectiveattendance(Integer.parseInt(totalSum.getEffectiveattendance())+Integer.parseInt(today.getEffectiveAttendance())+"");
                    totalSum.setRealityattendance(Integer.parseInt(totalSum.getRealityattendance())+Integer.parseInt(today.getRealityattendance())+"");
                }
                //计算有效出勤工资
                int e1 = Integer.parseInt(totalSum.getEffectiveattendance());
                int t1 = Integer.parseInt(totalSum.getDatetype());
                double bt = Double.parseDouble(user.getBaseSalary());
                double b1 = getBaseSalary(user.getBaseSalary(),t1);
                if (e1/t1>0.5){
                    totalSum.setAttendancesalary(bt - (t1-e1)*b1);
                } else totalSum.setAttendancesalary(e1*b1);
                //把总工资插入到工资表中
                totalSum.setTotalsalary(totalSum.getAttendancesalary() + totalSum.getLeavesalary() + totalSum.getTimesalary() + totalSum.getAllowance());
                userinfoSalaryService.insert(totalSum);
            }
        } catch (Exception e){
            System.out.print(e.toString());
        }
    }

    void generateSalary2(int nowyear,int nowMonth) {
        try {
            double manDay = 21.75;//满勤天数
            String workMonth = "" + nowyear + '-' + nowMonth;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar ca = Calendar.getInstance();
            //查询用户列表
            StaffInfo staff = new StaffInfo();
            List<StaffInfo> userlist = userStaffInfoService.selectStaffInfo(staff);


            for(StaffInfo user: userlist) {
                //if (!user.getName().equals("马天立")) continue;
                OaWtrExample wtrExample = new OaWtrExample();
                OaWtrExample.Criteria criteria1 = wtrExample.createCriteria();
                criteria1.andStaffIdEqualTo(user.getStaffId());
                List<OaWtr> wtrList = wtrService.selectByExample(wtrExample);
                OaWtr wtrObject = new OaWtr();
                if (wtrList.size()>0){
                    wtrObject = wtrList.get(0);
                }

                OaWtrSalary totalSum = new OaWtrSalary();
                totalSum.setName(user.getName());

                totalSum.setStaffId(user.getStaffId());
                totalSum.setDepartment(user.getDepartment());
                totalSum.setProject(wtrObject.getProject());
                totalSum.setHour(wtrObject.getHour());
                totalSum.setOrderId(wtrObject.getOrderId());
                totalSum.setOrderName(wtrObject.getOrderName());
                totalSum.setStatement(wtrObject.getStatement());
                totalSum.setWorkHouse(wtrObject.getWorkHouse());
                totalSum.setWorkInfo(wtrObject.getWorkInfo());
                int l = 0;
                //当前日期
                String workDate = getNext(nowyear, nowMonth, l++);
                while (workDate != null) {
                    //当前日期转换
                    Date d = sdf.parse(workDate);
                    ca.setTime(d);
                    totalSum.setWorkdate(d);
                    //处理出勤,查询一个人当天的打卡情况
                    YoAtteninfoExample attExample = new YoAtteninfoExample();
                    YoAtteninfoExample.Criteria criteria = attExample.createCriteria();
                    criteria.andStaffIdEqualTo(totalSum.getStaffId());
                    criteria.andAttdateEqualTo(d);
                    List<YoAtteninfo> cqlist = userAttendanceService.selectByExample(attExample);
                    if (0 == cqlist.size()) {
                        //当天没有出勤
                        totalSum.setAddress(wtrObject.getAddress());
                        if (!user.getDepartment().equals("人力资源部-实习生返校") && !user.getDepartment().equals("人力资源部-新人")) {
                            wtrSalaryService.insert(totalSum);
                        }
                    } else {
                        //
                        totalSum.setAddress(cqlist.get(0).getAttaddress());
                        wtrSalaryService.insert(totalSum);
                    }
                    //insert date

                    workDate = getNext(nowyear, nowMonth, l++);
                }
            }
        } catch (Exception e){
            System.out.print(e.toString());
        }
    }

    void generateSalary3(int nowyear,int nowMonth) {
        try {
            double manDay = 21.75;//满勤天数
            String workMonth = "" + nowyear + '-' + nowMonth;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar ca = Calendar.getInstance();
            //查询用户列表
            StaffInfo staff = new StaffInfo();
            List<StaffInfo> userlist = userStaffInfoService.selectStaffInfo(staff);


            for(StaffInfo user: userlist) {
                //if (user.getName().equals("郭梦秋"))                   continue;
                if (user.getStaffId().isEmpty()) continue;
                YoUserinfosalary totalSum = new YoUserinfosalary();
                totalSum.setName(user.getName());

                totalSum.setUserid(user.getStaffUserId());
                totalSum.setSalaryid(user.getStaffId());
                totalSum.setDatetype("0");
                totalSum.setAttendance("0");
                totalSum.setAttendancesalary(0.0);
                totalSum.setLeavetype("0");
                totalSum.setLeavesalary(0.0);
                totalSum.setWorkovertime("0");
                totalSum.setWorksalary(0.0);
                totalSum.setEvection("0");
                totalSum.setAllowance(0.0);
                totalSum.setTimesalary(0.0);
                totalSum.setEffectiveattendance("0");
                totalSum.setRealityattendance("0");
                int l = 0;
                //当前日期
                String workDate = getNext(nowyear, nowMonth, l++);
                while (workDate != null) {
                    //当前日期转换
                    Date d = sdf.parse(workDate);
                    ca.setTime(d);
                    //获取当天日报
                    OaWtrSalaryExample wtrExample = new OaWtrSalaryExample();
                    OaWtrSalaryExample.Criteria criteria1 = wtrExample.createCriteria();
                    criteria1.andStaffIdEqualTo(user.getStaffId());
                    criteria1.andWorkdateEqualTo(d);
                    List<OaWtrSalary> wtrList = wtrSalaryService.selectByExample(wtrExample);
                    OaWtrSalary wtrObject = new OaWtrSalary();
                    if (wtrList.size()>0){
                        wtrObject = wtrList.get(0);
                    }

                    //处理一天的工资
                    YoSalary today = new YoSalary();
                    String workaddress = null;//当天出勤地
                    String isOnLoc = null;//当天考勤范围
                    today.setSalarydate(workMonth);
                    today.setDate(sdf.parse(workDate));
                    today.setUserid(user.getStaffUserId());
                    today.setStaffid(user.getStaffId());
                    //当天是否周末/节假日
                    if (checkHoliday(ca)){
                        //是
                        today.setDatetype("休");
                    } else today.setDatetype("工");
                    //处理出勤,查询一个人当天的打卡情况
                    if (wtrList.size()>0){
                        //当天打卡地
                        today.setAttendance("1");
                        workaddress = wtrObject.getAddress();
                    } else {today.setAttendance("0");}

                    //处理请假

                    if (wtrObject.getWorkInfo()!= null && wtrObject.getWorkInfo().contains("假")){
                        //根据请假类型扣款
                        today.setLeavetype(wtrObject.getWorkInfo());
                        today.setLeavesalary(DateSalary(today.getLeavetype(),getBaseSalary(user.getBaseSalary(),manDay)));
                    }else{
                        //当天没有请假
                        today.setLeavetype("0");
                        today.setLeavesalary(0.0);
                    }

                    //判断真实出勤-发奖金,有效出勤-算工资
                    today.setEffectiveAttendance(today.getAttendance());
                    if (!today.getLeavetype().equals("0") || today.getDatetype().equals("休"))
                    {
                        //如果有请假，实际算缺勤出勤，然后补助对应的工资，或者今天是休息日
                        today.setEffectiveAttendance("0");
                    }
                    today.setRealityattendance(today.getAttendance());
                    if (!today.getLeavetype().equals("0"))
                    {
                        //如果有请假，实际算缺勤出勤，今天是休息日，看签到
                        today.setEffectiveAttendance("0");
                    }
                    //有效工资-通过有效出勤计算
                    if (!today.getEffectiveAttendance().equals("0") ){
                        today.setAttendanceSalary(getBaseSalary(user.getBaseSalary(),manDay));
                    } else today.setAttendanceSalary(0.0);
                    //处理加班
                    today.setWorkovertime("0");
                    today.setWorksalary(0.0);
                    //处理出差,签到地点与base地是否匹配,是否有打卡，是否要算加班费，是否是指定合同FDS
                    String address = user.getOrdinaryAddress().trim();
                    if (!today.getRealityattendance().equals("0") && user.getComment2()!=null && !user.getComment2().equals("否") && checkContract(user.getContractType()) && address!=null && workaddress!=null && workaddress.length()>1 && !workaddress.substring(0,2).contains(address)){
                        //if (!today.getAttendance().equals("0") && !address.isEmpty() && workaddress.equals("Outside")){
                        today.setEvection("1");
                        today.setAllowance(16.0);
                    } else {
                        today.setEvection("0");
                        today.setAllowance(0.0);
                    }
                    //timebase奖金,今天是真实出勤日，人在对应项目中
                    if (user.getYoOrder()!= null && user.getYoOrder().equals("Timebase") && !today.getRealityattendance().equals("0")){
                        //按技术等级发奖金
                        today.setTimesalary(callYI(user.getYindaIdentify()));
                    } else today.setTimesalary(0.0);
                    //公交地铁票

                    //插入到数据库
                    userSalaryService.insert(today);

                    //累加总工资
                    if (today.getDatetype().equals("工")) {
                        totalSum.setDatetype(Integer.parseInt(totalSum.getDatetype())+1+"");
                    }
                    totalSum.setAttendance(Integer.parseInt(totalSum.getAttendance())+Integer.parseInt(today.getAttendance())+"");
                    totalSum.setAttendancesalary(totalSum.getAttendancesalary() + today.getAttendanceSalary());
                    if (!today.getLeavetype().equals("0")) {
                        totalSum.setLeavetype(Integer.parseInt(totalSum.getLeavetype())+1+"");
                    }
                    totalSum.setLeavesalary(totalSum.getLeavesalary() + today.getLeavesalary());
                    totalSum.setWorkovertime(Integer.parseInt(totalSum.getWorkovertime())+Integer.parseInt(today.getWorkovertime())+"");
                    totalSum.setWorksalary(totalSum.getWorksalary() + today.getWorksalary());
                    totalSum.setEvection(Integer.parseInt(totalSum.getEvection())+Integer.parseInt(today.getEvection())+"");
                    totalSum.setAllowance(totalSum.getAllowance()+today.getAllowance());
                    totalSum.setTimesalary(totalSum.getTimesalary()+today.getTimesalary());
                    totalSum.setEffectiveattendance(Integer.parseInt(totalSum.getEffectiveattendance())+Integer.parseInt(today.getEffectiveAttendance())+"");
                    totalSum.setRealityattendance(Integer.parseInt(totalSum.getRealityattendance())+Integer.parseInt(today.getRealityattendance())+"");

                    workDate = getNext(nowyear, nowMonth, l++);
                }
                //计算有效出勤工资
                int e1 = Integer.parseInt(totalSum.getEffectiveattendance());
                int t1 = Integer.parseInt(totalSum.getDatetype());
                double b1 = getBaseSalary(user.getBaseSalary(),manDay);
                double bt = user.getBaseSalary().isEmpty() ? 0.0 : Double.parseDouble(user.getBaseSalary());
                if (1.0*e1/t1>0.5){
                    totalSum.setAttendancesalary(bt - (t1-e1)*b1);
                } else totalSum.setAttendancesalary(e1*b1);
                //把总工资插入到工资表中
                totalSum.setTotalsalary(totalSum.getAttendancesalary() + totalSum.getLeavesalary() + totalSum.getTimesalary() + totalSum.getAllowance());
                userinfoSalaryService.insert(totalSum);
            }

        } catch (Exception e){
            System.out.print(e.toString());
        }
    }
    //工资生成逻辑
    void generateSalary(int nowyear,int nowMonth){
        try {
            //选取年月 2016-11
            // nowyear = 2016;
            // nowMonth = 11;
            //当前工资序列
            double manDay = 21.75;//满勤天数
            String workMonth = "" + nowyear + '-' + nowMonth;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar ca = Calendar.getInstance();

            //查询用户列表
            StaffInfo staff = new StaffInfo();
            List<StaffInfo> userlist = userStaffInfoService.selectStaffInfo(staff);
            //开始循环每个人
            for(StaffInfo user: userlist) {
                YoUserinfosalary totalSum = new YoUserinfosalary();
                totalSum.setUserid(user.getStaffUserId());
                totalSum.setSalaryid(user.getStaffId());
                totalSum.setDatetype("0");
                totalSum.setAttendance("0");
                totalSum.setAttendancesalary(0.0);
                totalSum.setLeavetype("0");
                totalSum.setLeavesalary(0.0);
                totalSum.setWorkovertime("0");
                totalSum.setWorksalary(0.0);
                totalSum.setEvection("0");
                totalSum.setAllowance(0.0);
                totalSum.setTimesalary(0.0);
                totalSum.setEffectiveattendance("0");
                totalSum.setRealityattendance("0");

                //当前序列
                if (user.getStaffUserId().equals("01101067165859")) {
                    continue;
                 }
                //if (!user.getStaffUserId().equals("115868443423")) continue;
                int l = 0;
                //当前日期
                String workDate = getNext(nowyear, nowMonth, l++);
                 while (workDate != null) {
                    //当前日期转换
                    Date d = sdf.parse(workDate);
                    ca.setTime(d);
                    //处理一天的工资
                    YoSalary today = new YoSalary();
                    String workaddress = null;//当天出勤地
                    String isOnLoc = null;//当天考勤范围
                    today.setSalarydate(workMonth);
                    today.setDate(sdf.parse(workDate));
                    today.setUserid(user.getStaffUserId());
                    today.setStaffid(user.getStaffId());
                    //当天是否周末/节假日
                    if (checkHoliday(ca)){
                        //是
                        today.setDatetype("休");
                    } else today.setDatetype("工");
                    //处理出勤,查询一个人当天的打卡情况
                    YoAtteninfoExample attExample = new YoAtteninfoExample();
                    YoAtteninfoExample.Criteria criteria = attExample.createCriteria();
                    criteria.andUseridEqualTo(today.getUserid());
                    criteria.andAttdateEqualTo(d);
                    List<YoAtteninfo> cqlist = userAttendanceService.selectByExample(attExample);
                    if (0 == cqlist.size()){
                        //当天没有出勤
                        today.setAttendance("0");

                    } else{
                        today.setAttendance("1");

                        //当天打卡地
                         workaddress = cqlist.get(0).getAttaddress();
                        //当天打卡状态
                        isOnLoc = cqlist.get(0).getAttendresult();
                    }
                    //处理请假
                    AskForLeaveExample qjExample = new AskForLeaveExample();
                    AskForLeaveExample.Criteria criteria1 = qjExample.createCriteria();
                    criteria1.andYoAskStaffIdEqualTo(today.getStaffid());
                    criteria1.andYoApproveResultEqualTo("同意");
                    criteria1.andYoAskBeginDateLessThanOrEqualTo(workDate);
                    criteria1.andYoAskEndDateGreaterThanOrEqualTo(workDate);
                    List<AskForLeave> qjlist = userAskLeaveService.selectByExample(qjExample);
                    if (0 == qjlist.size()){
                        //当天没有请假
                        today.setLeavetype("0");
                        today.setLeavesalary(0.0);
                    } else{
                        //today.setLeavetype("1");
                        //根据请假类型扣款
                        today.setLeavetype(qjlist.get(0).getYoType());
                        today.setLeavesalary(DateSalary(today.getLeavetype(),getBaseSalary(user.getBaseSalary(),manDay)));
                    }
                    //判断真实出勤-发奖金,有效出勤-算工资
                    today.setEffectiveAttendance(today.getAttendance());
                    if (!today.getLeavetype().equals("0") || today.getDatetype().equals("休"))
                    {
                        //如果有请假，实际算缺勤出勤，然后补助对应的工资，或者今天是休息日
                        today.setEffectiveAttendance("0");
                    }
                    today.setRealityattendance(today.getAttendance());
                    if (!today.getLeavetype().equals("0"))
                    {
                        //如果有请假，实际算缺勤出勤，今天是休息日，看签到
                        today.setEffectiveAttendance("0");
                    }
                    //有效工资-通过有效出勤计算
                    if (!today.getEffectiveAttendance().equals("0") ){
                        today.setAttendanceSalary(getBaseSalary(user.getBaseSalary(),manDay));
                    } else today.setAttendanceSalary(0.0);
                    //处理加班
                    today.setWorkovertime("0");
                    today.setWorksalary(0.0);
                    //处理出差,签到地点与base地是否匹配,是否有打卡，是否要算加班费，是否是指定合同FDS
                    String address = user.getOrdinaryAddress().trim();
                    if (!today.getRealityattendance().equals("0") && !user.getComment2().isEmpty() && !user.getComment2().equals("否") && checkContract(user.getContractType()) && !address.isEmpty() && !workaddress.isEmpty() && !workaddress.substring(0,2).contains(address)){
                    //if (!today.getAttendance().equals("0") && !address.isEmpty() && workaddress.equals("Outside")){
                        today.setEvection("1");
                        today.setAllowance(16.0);
                    } else {
                        today.setEvection("0");
                        today.setAllowance(0.0);
                    }
                    //timebase奖金,今天是真实出勤日，人在对应项目中
                    if (!user.getYoOrder().isEmpty() && user.getYoOrder().equals("Timebase") && !today.getRealityattendance().equals("0")){
                        //按技术等级发奖金
                        today.setTimesalary(callYI(user.getYindaIdentify()));
                    } else today.setTimesalary(0.0);
                    //公交地铁票

                    //插入到数据库
                    userSalaryService.insert(today);

                    //累加总工资
                    if (today.getDatetype().equals("工")) {
                        totalSum.setDatetype(Integer.parseInt(totalSum.getDatetype())+1+"");
                    }
                    totalSum.setAttendance(Integer.parseInt(totalSum.getAttendance())+Integer.parseInt(today.getAttendance())+"");
                    totalSum.setAttendancesalary(totalSum.getAttendancesalary() + today.getAttendanceSalary());
                    if (!today.getLeavetype().equals("0")) {
                        totalSum.setLeavetype(Integer.parseInt(totalSum.getLeavetype())+1+"");
                    }
                    totalSum.setLeavesalary(totalSum.getLeavesalary() + today.getLeavesalary());
                    totalSum.setWorkovertime(Integer.parseInt(totalSum.getWorkovertime())+Integer.parseInt(today.getWorkovertime())+"");
                    totalSum.setWorksalary(totalSum.getWorksalary() + today.getWorksalary());
                    totalSum.setEvection(Integer.parseInt(totalSum.getEvection())+Integer.parseInt(today.getEvection())+"");
                    totalSum.setAllowance(totalSum.getAllowance()+today.getAllowance());
                    totalSum.setTimesalary(totalSum.getTimesalary()+today.getTimesalary());
                    totalSum.setEffectiveattendance(Integer.parseInt(totalSum.getEffectiveattendance())+Integer.parseInt(today.getEffectiveAttendance())+"");
                    totalSum.setRealityattendance(Integer.parseInt(totalSum.getRealityattendance())+Integer.parseInt(today.getRealityattendance())+"");

                    workDate = getNext(nowyear, nowMonth, l++);
                }
                //计算有效出勤工资
                int e1 = Integer.parseInt(totalSum.getEffectiveattendance());
                int t1 = Integer.parseInt(totalSum.getDatetype());
                double b1 = getBaseSalary(user.getBaseSalary(),t1);
                double bt = user.getBaseSalary().isEmpty() ? 0.0 : Double.parseDouble(user.getBaseSalary());
                if (e1/t1>0.5){
                    totalSum.setAttendancesalary(bt - (t1-e1)*b1);
                } else totalSum.setAttendancesalary(e1*b1);
                //把总工资插入到工资表中
                totalSum.setTotalsalary(totalSum.getAttendancesalary() + totalSum.getLeavesalary() + totalSum.getTimesalary() + totalSum.getAllowance());
                userinfoSalaryService.insert(totalSum);
            }
        } catch (Exception e){
            System.out.print(e.toString());
        }
    }
    //生成工资方法
    @RequestMapping("/test.do")
    public String testc(HttpServletRequest request) throws IOException {
        //generateSalary(2017,1);
        //generateSalary3(2016,12);
       // System.out.print(DDUtil.testShow());


        System.out.print("OK!");
        return "/UserSalary" ;
    }

    //查询员工工资信息(合计)
    @RequestMapping(value = "/generate", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> generate(@RequestBody YoSalary user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //查询指定id，填充进map
        Map<String,Object> map = new HashMap<String,Object>();
/*        if (user.getSalarydate()!=null) salaryDate = user.getSalarydate();
        if (user.getStaffid()!=null) user.getStaffid();*/
        //generateSalary(2016,12);
        SalaryUtil salaryUtil = new SalaryUtil(userSalaryService,userAttendanceService,userSighInService,userStaffInfoService,userAskLeaveService,userinfoSalaryService);
        salaryUtil.generateSalaryByMonth(2017,1);
        salaryUtil.generateSalaryTotal(2017,1);
//        salaryUtil.generateSalaryByMonth(2017,1);
        salaryUtil.generateSalaryTotal(2017,1);
        //List<StaffInfo> ttt = staffInfoMapper.getAllIdentifyInStallInfo();

        if(true){
            map.put("msg", "成功");
        }else{
            map.put("msg", "失败");
        }

        System.out.print("！！！OK!");
        return map;
    }


    @RequestMapping("search_salary_page.do")
    public ModelAndView search_salary_page(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("salary/search_salary");
        return mav;
    }


    @RequestMapping("search_salary.do")
    @ResponseBody
    public List<YoUserinfosalary> search_salary(String branchCompany,String salarydate){
        return userinfoSalaryService.search_salary(branchCompany, salarydate);
    }

    @RequestMapping("/getbranchCompany.do")
    @ResponseBody
    public List<StaffInfo> getbranchCompany(){
        return staffInfoMapper.getbranchCompany();
    }


    @RequestMapping("export_salary.do")
    public void export_salary(String branchCompany,String salarydate,HttpServletResponse response){
        System.out.println(branchCompany+"==="+salarydate);
        List<YoUserinfosalary> salaryList =userinfoSalaryService.search_salary(branchCompany, salarydate);
        System.out.println(salaryList.size());
        exportYoUserinfosalary(salaryList, excelHeader, response);

    }


    /**
     * 获得HSSFWorkbook
     * @param list 数据信息
     * @param excelHeader 表头
     * @return HSSFWorkbook
     */

    private static HSSFWorkbook getHSSFWorkbook(List<YoUserinfosalary> list, String[] excelHeader){

        HSSFWorkbook wb = new HSSFWorkbook();
        //创建一个sheet
        HSSFSheet sheet= wb.createSheet("sheet1");
        //设置单元格宽度
        sheet.setColumnWidth(0,(int)(20+0.72)*256);
        sheet.setColumnWidth(1,(int)(20+0.72)*256);
        sheet.setColumnWidth(2,(int)(20+0.72)*256);
        sheet.setColumnWidth(3,(int)(20+0.72)*256);
        sheet.setColumnWidth(4,(int)(20+0.72)*256);
        sheet.setColumnWidth(5,(int)(20+0.72)*256);
        sheet.setColumnWidth(6,(int)(20+0.72)*256);
        sheet.setColumnWidth(7,(int)(20+0.72)*256);
        sheet.setColumnWidth(8,(int)(20+0.72)*256);
        sheet.setColumnWidth(9,(int)(30+0.72)*256);
        sheet.setColumnWidth(10,(int)(20+0.72)*256);
        sheet.setColumnWidth(11,(int)(20+0.72)*256);
        sheet.setColumnWidth(12,(int)(20+0.72)*256);
        sheet.setColumnWidth(13,(int)(20+0.72)*256);
        sheet.setColumnWidth(14,(int)(20+0.72)*256);
        sheet.setColumnWidth(15,(int)(20+0.72)*256);
        sheet.setColumnWidth(16,(int)(20+0.72)*256);
        sheet.setColumnWidth(17,(int)(20+0.72)*256);
        sheet.setColumnWidth(18,(int)(20+0.72)*256);
        sheet.setColumnWidth(19,(int)(30+0.72)*256);
        sheet.setColumnWidth(20,(int)(20+0.72)*256);
        sheet.setColumnWidth(21,(int)(20+0.72)*256);
        sheet.setColumnWidth(22,(int)(20+0.72)*256);
        sheet.setColumnWidth(23,(int)(20+0.72)*256);

        //创建行
        HSSFRow row = sheet.createRow(0);
        //设置表头样式
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//左右居中
        HSSFFont f = wb.createFont();
        f.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//加粗
        //创建表头
        for(int i = 0;i <excelHeader.length;i++){//根据反射获取当前对象的属性个数
            //当前行下创建列
            HSSFCell cell = row.createCell(i);
            //列中写入值
            cell.setCellValue(excelHeader[i]);
            //设置表头显示风格
            cell.setCellStyle(style);

            //sheet.autoSizeColumn(i);//单元格宽度自适应

        }

        //写入数据
        for(int i=0;i<list.size();i++){
            //创建新的一行
            row = sheet.createRow(i+1);
            //每行中写入与表头列数个数相等的数据
            if(list.get(i).getSalarydate()!=null){
            	 row.createCell(0).setCellValue(list.get(i).getSalarydate());//月份
            }else{
            	row.createCell(0).setCellValue("");//月份
            }
           
            if(list.get(i).getName()!=null){
            	 row.createCell(1).setCellValue(list.get(i).getName());//姓名
            }else{
            	row.createCell(1).setCellValue("");
            }
           
            if(list.get(i).getDepartment()!=null){
            	 row.createCell(2).setCellValue(list.get(i).getDepartment());//部门
            }else{
            	 row.createCell(2).setCellValue("");//部门
            }
           
            if(list.get(i).getSalaryid()!=null){
            	  row.createCell(3).setCellValue(list.get(i).getSalaryid());//工号
            }else{
            	 row.createCell(3).setCellValue("");//工号
            }
          
            if(list.get(i).getDatetype()!=null){
            	  row.createCell(4).setCellValue(list.get(i).getDatetype());//计薪天数
            }else{
            	 row.createCell(4).setCellValue("");//计薪天数
            }
          
            if(list.get(i).getAttendance()!=null){
            	  row.createCell(5).setCellValue(list.get(i).getAttendance());//出勤
            }else{
            	  row.createCell(5).setCellValue("");//出勤
            }
           
            if(list.get(i).getRealityattendance()!=null){
            	 row.createCell(6).setCellValue(list.get(i).getRealityattendance());//实际出勤
            }else{
            	 row.createCell(6).setCellValue("");//实际出勤
            }
           
           if(list.get(i).getEffectiveattendance()!=null){
        	   row.createCell(7).setCellValue(list.get(i).getEffectiveattendance());//有效出勤
           }else{
        	   row.createCell(7).setCellValue("");//有效出勤
           }
           
           if(list.get(i).getAttendancesalary()!=null){
        	   row.createCell(8).setCellValue(list.get(i).getAttendancesalary());//出勤工资
           }else{
        	   row.createCell(8).setCellValue("");//出勤工资
           }
           
          if(list.get(i).getLeavetype()!=null){
        	  row.createCell(9).setCellValue(list.get(i).getLeavetype());//请假天数
          }else{
        	  row.createCell(9).setCellValue("");//请假天数
          }
          
          if(list.get(i).getLeavesalary()!=null){
        	  row.createCell(10).setCellValue(list.get(i).getLeavesalary());//请假补款
          }else{
        	  row.createCell(10).setCellValue("");//请假补款
          }
          
          if(list.get(i).getWorkovertime()!=null){
        	  row.createCell(11).setCellValue(list.get(i).getWorkovertime());//加班时间  
          }else{
        	  row.createCell(11).setCellValue("");//加班时间  
          }
            
          if(list.get(i).getWorksalary()!=null){
        	  row.createCell(12).setCellValue(list.get(i).getWorksalary());//加班补款
          }else{
        	  row.createCell(12).setCellValue("");//加班补款
          }
           
          if(list.get(i).getEvection()!=null){
        	  row.createCell(13).setCellValue(list.get(i).getEvection());//出差 
          }else{
        	  row.createCell(13).setCellValue("");//出差 
        	  
          }
           
          if(list.get(i).getAllowance()!=null){
        	  row.createCell(14).setCellValue(list.get(i).getAllowance());//出差费
          }else{
        	  row.createCell(14).setCellValue("");//出差费
          }
           
          if(list.get(i).getTimesalary()!=null){
        	   row.createCell(15).setCellValue(list.get(i).getTimesalary());//timebase奖金
          }else{
        	  row.createCell(15).setCellValue("");//timebase奖金
          }
         
          if(list.get(i).getTasksalary()!=null){
        	  row.createCell(16).setCellValue(list.get(i).getTasksalary());//taskbase奖金
          }else{
        	  row.createCell(16).setCellValue("");//taskbase奖金
          }
           
            if( list.get(i).getTrafficsalary()!=null){row.createCell(17).setCellValue(list.get(i).getTrafficsalary());//交通费
            }else{
            	row.createCell(17).setCellValue("");
            }
           
            if(list.get(i).getSocialdecase()!=null){
            	  row.createCell(18).setCellValue(list.get(i).getSocialdecase());//社保扣款
            }else{
            	 row.createCell(18).setCellValue("");//社保扣款
            }
          
            if(list.get(i).getUserbonus()!=null){
            	  row.createCell(19).setCellValue(list.get(i).getUserbonus());//额外奖金
            }else{
            	row.createCell(19).setCellValue("");//额外奖金
            }
            
            if(list.get(i).getSubtotal()!=null){
            	 row.createCell(20).setCellValue(list.get(i).getSubtotal());//小计
            }else{
            	 row.createCell(20).setCellValue("");//小计
            }
          
           if(list.get(i).getTotalsalary()!=null){
        	   row.createCell(21).setCellValue(list.get(i).getTotalsalary());//税前应发
           }else{
        	   row.createCell(21).setCellValue("");//税前应发
           }
           if(list.get(i).getTax()!=null){
        	   row.createCell(22).setCellValue(list.get(i).getTax());//个税
           }else{
        	   row.createCell(22).setCellValue("");//个税
           }
            
            //row.createCell(23).setCellValue(list.get(i).getRealsalary());//实际应发
        }
        return wb;
    }



    String []excelHeader = {"月份","姓名","部门","工号","记薪天数","出勤","实际出勤","有效出勤","出勤工资",
            "请假天数","请假补款","加班时间","加班补款","出差","出差费用","timebase奖金","taskbase奖金","交通费用",
            "社保扣款","额外奖金","小计","税前应发","个税","实际应发"};
    public static void exportYoUserinfosalary(List<YoUserinfosalary> list,String[] excelHeader,HttpServletResponse response){
        HSSFWorkbook wb = getHSSFWorkbook(list,excelHeader);
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "attachment;filename=attendanceInfo.xls");
        OutputStream ouputStream;
        try {
            ouputStream = response.getOutputStream();
            wb.write(ouputStream);
            ouputStream.flush();
            ouputStream.close();
        } catch (IOException e) {
            System.out.println("=========考勤表模板导出error");
            e.printStackTrace();
        }
    }


}
