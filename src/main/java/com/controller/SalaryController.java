package com.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.model.*;
import com.service.*;
import com.util.DDUtil;
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
    private IAttendanceInfoService userAttendanceService;
    @Resource
    private IStaffInfoService userStaffInfoService;
    @Resource
    private IAskLeaveService userAskLeaveService;
    @Resource
    private IUserInfoSalaryService userinfoSalaryService;

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


        //工资单
        YoUserinfosalaryExample example = new YoUserinfosalaryExample();
        YoUserinfosalaryExample.Criteria criteria1 = example.createCriteria();
        criteria1.andSalarydateEqualTo(user.getSalarydate());
        criteria1.andNameEqualTo(user.getName());
        List<YoUserinfosalary> query = userinfoSalaryService.selectByExample(example);
        if (query.size()>0){
            map.put("total",query.get(0));
        }


        if(list.size() != 0){
            map.put("msg", "成功");
        }else{
            map.put("msg", "查询结果为空");
        }
        return map;
    }
    //查询员工工资信息(页面)
    @RequestMapping(value = "/querySalary", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> query2(@RequestBody YoUserinfosalary user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //查询指定id，填充进map

        Map<String,Object> map = new HashMap<String,Object>();


        //工资单
        YoUserinfosalaryExample example = new YoUserinfosalaryExample();
        YoUserinfosalaryExample.Criteria criteria1 = example.createCriteria();
        criteria1.andSalarydateEqualTo(user.getSalarydate());
        criteria1.andUseridEqualTo(user.getUserid());
        List<YoUserinfosalary> query = userinfoSalaryService.selectByExample(example);
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
    public Object queryUserid(@RequestBody() String code) {
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
        if (base.isEmpty()) return 0.0;
        return Double.parseDouble(base)/day;
    }
    //判断合同类型是否发加班费
    boolean checkContract(String type){
        if (type.equals("F") || type.equals("D") || type.equals("S") ) return false;
        return  true;
    }
    //按技术等级获取timebase奖金
    double callYI(String type){
        double salary=0;
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
                totalSum.setAllowance("0");
                totalSum.setTimesalary(0.0);
                totalSum.setEffectiveattendance("0");
                totalSum.setRealityattendance("0");

                YoSalary search = new YoSalary();
                search.setName(user.getName());
                search.setSalarydate("2016-11");
                List<YoSalary> salaryList = userSalaryService.searchYoSalaryByEntity(search);
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
                    totalSum.setAllowance(Integer.parseInt(totalSum.getAllowance())+Integer.parseInt(today.getAllowance())+"");
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
                totalSum.setTotalsalary(totalSum.getAttendancesalary() + totalSum.getLeavesalary() + totalSum.getTimesalary() + Double.parseDouble(totalSum.getAllowance()));
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
                totalSum.setAllowance("0");
                totalSum.setTimesalary(0.0);
                totalSum.setEffectiveattendance("0");
                totalSum.setRealityattendance("0");

                //当前序列
                /*if (user.getStaffUserId().equals("115868443423")) {
                    continue;
                 }*/
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
                    today.setSalaryid(user.getStaffId());
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
                    criteria1.andYoAskStaffIdEqualTo(today.getSalaryid());
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
                    if (!today.getRealityattendance().equals("0") && !user.getComment2().equals("否") && checkContract(user.getContractType()) && !address.isEmpty() && !workaddress.isEmpty() && !workaddress.substring(0,2).contains(address)){
                    //if (!today.getAttendance().equals("0") && !address.isEmpty() && workaddress.equals("Outside")){
                        today.setEvection("1");
                        today.setAllowance("16");
                    } else {
                        today.setEvection("0");
                        today.setAllowance("0");
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
                    totalSum.setAllowance(Integer.parseInt(totalSum.getAllowance())+Integer.parseInt(today.getAllowance())+"");
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
                totalSum.setTotalsalary(totalSum.getAttendancesalary() + totalSum.getLeavesalary() + totalSum.getTimesalary() + Double.parseDouble(totalSum.getAllowance()));
                userinfoSalaryService.insert(totalSum);
            }
        } catch (Exception e){
            System.out.print(e.toString());
        }
    }
    @RequestMapping("/test.do")
    public String testc(HttpServletRequest request) throws IOException {
        //generateSalary(2016,11);
        //System.out.print(DDUtil.testShow());
        System.out.print("OK!");
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


    /**
     * 请假的次数
     * @param salariesLists 考勤信息（同一个人）
    //     * @param all 每项考勤的类型，暂时只有0和1
     * @return Map<String,Integer>  表示的是考勤的类型和数量
     */
    public Map<String,Integer> LeavetypeCount(List<YoSalary> salariesLists){
        Map<String,Integer> mapCount=new HashMap<String,Integer>();
        List<String> kaoqianDateType=new ArrayList<String>();
        //统计考勤的类型
        for(int i=0;i<salariesLists.size();i++){
            if(null==salariesLists.get(i).getLeavetype()||kaoqianDateType.contains(salariesLists.get(i).getLeavetype()) ){
                continue;
            }
            kaoqianDateType.add(salariesLists.get(i).getLeavetype());
        }
        //kaoqianDateType
        int count=0;//定义一个保存次数的变量
        for(int j=0;j<kaoqianDateType.size();j++){
            count=leave(salariesLists,kaoqianDateType.get(j));
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
    public int leave(List<YoSalary> salariesLists,String leavetype){
        int allCount=0;
        for(int i=0;i<salariesLists.size();i++){
            //排除不符合的统计类型
            if(salariesLists.get(i).getLeavetype().equals(leavetype)){
                continue;
            }
            allCount++;
        }
        return allCount;
    }


//    //请假次数
//    public int LeavetypeCount(List<YoSalary> salariesLists){
//        int useridSalary=0;
//        for(int i=0;i<salariesLists.size();i++){
//            if(null==salariesLists.get(i).getLeavetype() || (Integer.parseInt(salariesLists.get(i).getLeavetype()))==0){
//                continue;
//            }
//            useridSalary +=Integer.parseInt(salariesLists.get(i).getLeavetype());
//        }
//
//        return useridSalary;
//    }

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
