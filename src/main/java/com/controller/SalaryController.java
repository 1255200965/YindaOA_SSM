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

//        Map<String,Integer> datetype= DatetypeCount(list);
//        Map<Integer,Integer> attendance=AttendanceCount(list);
//        Map<Integer,Integer> effective=EffectiveAttendanceCount(list);
//        double attendancesalary=AttendanceSalaryCount(list);
//        Map<Integer,Integer> leavetype=LeavetypeCount(list);
//        Map<String,Integer> worktime= WorkovertimeCount(list);
//        double worksalary=WorkSalaryCount(list);
//        int evection=EvectionCount(list);
//        int allowance=AllowanceCount(list);



        Map<String,Object> map = new HashMap<String,Object>();
        map.put("userlist",list);
//        map.put("datetype",datetype);
//        map.put("attendance",attendance);
//        map.put("effective",effective);
//        map.put("attendancesalary",attendancesalary);
//        map.put("leavetype",leavetype);
//        map.put("worktime",worktime);
//        map.put("worksalary",worksalary);
//        map.put("evection",evection);
//        map.put("allowance",allowance);


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
    double getBaseSalary(String base,double day){
        if (base.isEmpty()) return 0.0;
        return Double.parseDouble(base)/day;
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
            double manDay = 21.75;//满勤天数
            String workMonth = "" + nowyear + '-' + nowMonth;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar ca = Calendar.getInstance();

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
                    //当前日期转换
                    Date d = sdf.parse(workDate);
                    ca.setTime(d);
                    //处理一天的工资
                    YoSalary today = new YoSalary();
                    String workaddress = null;//当天出勤地
                    today.setSalarydate(workMonth);
                    today.setDate(sdf.parse(workDate));
                    today.setUserid(user.getStaffUserId());
                    today.setSalaryid(user.getStaffId());
                    //当天是否周末/节假日
                    if (checkHoliday(ca)){
                        //是
                        today.setDatetype("休");
                    } else today.setDatetype("工");
                    //处理出勤,查询一个人当天的打卡情况
                    YoAttendanceExample attExample = new YoAttendanceExample();
                    YoAttendanceExample.Criteria criteria = attExample.createCriteria();
                    criteria.andUseridEqualTo(today.getUserid());
                    criteria.andWorkdateEqualTo(d);
                    List<YoAttendance> cqlist = userAttendanceService.selectByExample(attExample);
                    if (0 == cqlist.size()){
                        //当天没有出勤
                        today.setAttendance("0");
                        //today.setAttendanceSalary(0.0);
                        //today.setworkaddress("");
                    } else{
                        today.setAttendance("1");
                        //today.setAttendanceSalary(getBaseSalary(user.getBaseSalary(),getMaxDate(nowyear,nowMonth)));
                        //当天打卡地
                        workaddress = cqlist.get(0).getLocationresult();
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
                        today.setLeavesalary(DateSalary(today.getLeavetype(),getBaseSalary(user.getBaseSalary(),manDay)));
                    }
                    //判断真实出勤,有效出勤
                    today.setEffectiveAttendance(today.getAttendance());
                    if (!today.getLeavetype().equals("0") || today.getDatetype().equals("休"))
                    {
                        //如果有请假，实际算缺勤出勤，然后补助对应的工资，或者今天是休息日
                        today.setEffectiveAttendance("0");
                    }
                    //有效工资
                    if (!today.getEffectiveAttendance().equals("0") ){
                        today.setAttendanceSalary(getBaseSalary(user.getBaseSalary(),manDay));
                    } else today.setAttendanceSalary(0.0);
                    //处理加班
                    today.setWorkovertime("0");
                    today.setWorksalary(0.0);
                    //处理出差,签到地点与base地是否匹配,是否有打卡，是否要算加班费，是否是指定合同
                    String address = user.getOrdinaryAddress();
                    //if (!today.getAttendance().equals("0") && !address.isEmpty() && !workaddress.contains(address)){
                    if (!today.getAttendance().equals("0") && !address.isEmpty() && workaddress.equals("Outside")){
                        today.setEvection("1");
                        today.setAllowance("16");
                    } else {
                        today.setEvection("0");
                        today.setAllowance("0");
                    }
                    //timebase奖金
                    //公交地铁票

                    //插入到数据库
                    userSalaryService.insert(today);
                    workDate = getNext(nowyear, nowMonth, l++);
                }
            }
        } catch (Exception e){
            System.out.print(e.toString());
        }
    }
    @RequestMapping("/test.do")
    public String testc(HttpServletRequest request,YoSalary user) throws IOException {
        //generateSalary(2016,11);
//        System.out.print("OK!");
        //查询指定id，填充进map

        YoSalary yo=new YoSalary();
        yo.setName("刘立人");
        List<YoSalary> list =userSalaryService.searchYoSalaryByEntity(yo);

        Map<String,Integer> datetype= DatetypeCount(list);
        int attendance=AttendanceCount(list);
        int effective=EvectionCount(list);
        double attendancesalary=AttendanceSalaryCount(list);
        int leavetype=LeavetypeCount(list);
        int worktime= WorkovertimeCount(list);
        double worksalary=WorkSalaryCount(list);
        int evection=EvectionCount(list);
        int allowance=AllowanceCount(list);


        Map<String,Object> map = new HashMap<String,Object>();
        map.put("userlist",list);
        map.put("datetype",datetype);
        map.put("attendance",attendance);
        map.put("effective",effective);
        map.put("attendancesalary",attendancesalary);

        System.out.println("工作日有多少天"+datetype.toString());
        System.out.println("打卡情况"+attendance);
        System.out.println("有效打卡情况"+effective);
        System.out.println("出勤工资"+attendancesalary);
        System.out.println("请教类型"+leavetype);
        System.out.println("加班"+worktime);
        System.out.println("加班工资"+worksalary);
        System.out.println("出差"+evection);
        System.out.println("出差补贴"+allowance);

        return "/UserSalary" ;
    }

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




    /**
     * 计算的次数
     * @param salariesLists 考勤信息（同一个人）
    //     * @param all 每项考勤的类型，暂时只有0和1
     * @return Map<String,Integer>  表示的是考勤的类型和数量
     */
    public Map<String,Integer> DatetypeCount(List<YoSalary> salariesLists){
        Map<String,Integer> mapCount=new HashMap<String,Integer>();
        List<String> kaoqianDateType=new ArrayList<String>();
        //统计考勤的类型
        for(int i=0;i<salariesLists.size();i++){
            if(null==salariesLists.get(i).getDatetype()||kaoqianDateType.contains(salariesLists.get(i).getDatetype()) ){
                continue;
            }
            kaoqianDateType.add(salariesLists.get(i).getDatetype());
        }
        //kaoqianDateType
        int count=0;//定义一个保存次数的变量
        for(int j=0;j<kaoqianDateType.size();j++){
            count=caclKong(salariesLists,kaoqianDateType.get(j));
            mapCount.put(kaoqianDateType.get(j),count);
            //将count清零
            count=0;
        }
        return mapCount;
    }

    /**
     * 这里计算的是对一个list<int>类型的累计
     * @param
     * @return
     */
    public int caclKong(List<YoSalary> salariesLists,String dateType){
        int allCount=0;
        for(int i=0;i<salariesLists.size();i++){
            //排除不符合的统计类型
            if(salariesLists.get(i).getDatetype().equals(dateType)){
                continue;
            }
            allCount++;
        }
        return allCount;
    }

    /**
     * 打卡情况
     * @param salariesLists 打卡情况信息（同一个人）
    //     * @param all 每项考勤的类型，暂时只有0和1
     * @return Map<String,Integer>  表示的是考勤的类型和数量
     */
    public int AttendanceCount(List<YoSalary> salariesLists){
        int useridSalary=0;
        //统计考勤的类型
        for(int i=0;i<salariesLists.size();i++){
            if(null==salariesLists.get(i).getAttendance() || (Integer.parseInt(salariesLists.get(i).getAttendance()))==0){
                continue;
            }
            useridSalary +=Integer.parseInt(salariesLists.get(i).getAttendance());
        }

        return useridSalary;
    }


    /**
     * 有效打卡情况
     * @param salariesLists 打卡情况信息（同一个人）
    //     * @param all 每项考勤的类型，暂时只有0和1
     * @return Map<String,Integer>  表示的是考勤的类型和数量
     */
    public int effectiveAttendanceCount(List<YoSalary> salariesLists){
        int useridSalary=0;
        for(int i=0;i<salariesLists.size();i++){
            if(null==salariesLists.get(i).getEffectiveAttendance() || (Integer.parseInt(salariesLists.get(i).getEffectiveAttendance()))==0){
                continue;
            }
            useridSalary +=Integer.parseInt(salariesLists.get(i).getEffectiveAttendance());
        }

        return useridSalary;
    }


    /**
     * 计算考勤工资
     * @param salariesLists 考勤信息（同一个人）
    //     * @param all 每项考勤的类型，暂时只有0和1
     * @return Map<String,Integer>  表示的是考勤的类型和数量
     */
    public Double AttendanceSalaryCount(List<YoSalary> salariesLists){
        double useridSalary=0;
        //统计考勤的类型
        for(int i=0;i<salariesLists.size();i++){
            if(null==salariesLists.get(i).getAttendanceSalary() || salariesLists.get(i).getAttendanceSalary()==0){
                continue;
            }
            useridSalary +=salariesLists.get(i).getAttendanceSalary();
        }
        return useridSalary;
    }

    //请假次数
    public int LeavetypeCount(List<YoSalary> salariesLists){
        int useridSalary=0;
        for(int i=0;i<salariesLists.size();i++){
            if(null==salariesLists.get(i).getLeavetype() || (Integer.parseInt(salariesLists.get(i).getLeavetype()))==0){
                continue;
            }
            useridSalary +=Integer.parseInt(salariesLists.get(i).getLeavetype());
        }

        return useridSalary;
    }

    //加班次数
    public int WorkovertimeCount(List<YoSalary> salariesLists){
        int useridSalary=0;
        for(int i=0;i<salariesLists.size();i++){
            if(null==salariesLists.get(i).getWorkovertime() || (Integer.parseInt(salariesLists.get(i).getWorkovertime()))==0){
                continue;
            }
            useridSalary +=Integer.parseInt(salariesLists.get(i).getWorkovertime());
        }

        return useridSalary;
    }


    /**
     * 计算加班工资
     * @param salariesLists 考勤信息（同一个人）
    //     * @param all 每项考勤的类型，暂时只有0和1
     * @return Map<String,Integer>  表示的是考勤的类型和数量
     */
    public Double WorkSalaryCount(List<YoSalary> salariesLists){
        double useridSalary=0;
        //统计考勤的类型
        for(int i=0;i<salariesLists.size();i++){
            if(null==salariesLists.get(i).getWorksalary() || salariesLists.get(i).getWorksalary()==0){
                continue;
            }
            useridSalary +=salariesLists.get(i).getWorksalary();
        }
        return useridSalary;
    }


    //出差次数
    public int EvectionCount(List<YoSalary> salariesLists){
        int useridSalary=0;
        for(int i=0;i<salariesLists.size();i++){
            if(null==salariesLists.get(i).getEvection() || (Integer.parseInt(salariesLists.get(i).getEvection()))==0){
                continue;
            }
            useridSalary +=Integer.parseInt(salariesLists.get(i).getEvection());
        }

        return useridSalary;
    }

    /**
     * 津贴
     * @param salariesLists 考勤信息（同一个人）
    //     * @param all 每项考勤的类型，暂时只有0和1
     * @return Map<String,Integer>  表示的是考勤的类型和数量
     */
    public int AllowanceCount(List<YoSalary> salariesLists){
        int useridSalary=0;
        //统计考勤的类型
        for(int i=0;i<salariesLists.size();i++){
            if(null==(salariesLists.get(i).getAllowance()) || (Integer.parseInt(salariesLists.get(i).getAllowance())==0)){
                continue;
            }
            useridSalary +=(Integer.parseInt(salariesLists.get(i).getAllowance()));
        }
        return useridSalary;
    }


    /***
     * 查询员工工资详细信息
     */
    @RequestMapping(value = "/queryusersalary", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> queryusersalary(@RequestBody YoSalary user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //查询指定id，填充进map
        List<YoSalary> list = userSalaryService.searchYoSalaryByEntity(user);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("usersalary", list);
        if (list.size() != 0) {
            map.put("msg", "成功");
        } else {
            map.put("msg", "查询结果为空");
        }
        return map;
    }




}
