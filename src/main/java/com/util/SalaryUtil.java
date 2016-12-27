package com.util;

import com.model.*;
import com.service.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by ma on 2016/11/28.
 */
public class SalaryUtil {
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
    @Resource
    private IExcelSignInService userSighInService;

    double manDay = 21.75;//满勤天数
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//日期转换器
    Calendar ca = Calendar.getInstance();//日历

    public SalaryUtil(ISalaryService service1,IAttendanceInfoService service2,IExcelSignInService service6,IStaffInfoService service3,IAskLeaveService service4,IUserInfoSalaryService service5){

        userSalaryService = service1;
        userAttendanceService = service2;
        userStaffInfoService = service3;
        userAskLeaveService = service4;
        userinfoSalaryService = service5;
        userSighInService = service6;
    }

    /**
     * 基础的一些方法
     */
    int getMaxDate(int year,int month){//上个月的最大日期
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
    String getLastMonth(int year,int month){//工资月份
        if (month == 1){
            month = 12;
            year --;
        } else month --;
        return ""+year + '-' + month ;
    }
    String formartDate(int day){//日期格式标准化
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
    //判断合同类型是否发出差费
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

    /**
     * 按月份生成工资
     */
    public String generateSalaryByMonth(int nowyear,int nowMonth,StaffInfo userid){
        int l = 0;
        //当前日期
        String workDate = getNext(nowyear, nowMonth, l++);
        String workMonth = "" + nowyear + '-' + nowMonth;
        while (workDate != null) {
            YoSalary today = selectSalary(userid,workDate);
            today = updateDateInfo(userid,workDate,workMonth,today);
            today = updateAttendance(userid,workDate,today);
            today = updateLeave(userid,workDate,today);
            today = updateOverwork(userid,workDate,today);
            today = updateEffective(userid,workDate,today);
            today = updateEvection(userid,workDate,today);
            today = updateTimebase(userid,workDate,today);

            //如果是在职区间
            insertORupdate(today);//插入或更新

            workDate = getNext(nowyear, nowMonth, l++);
        }

        return "OK";
    }
    /**
     * 按月份生成全部工资
     */
    public String generateSalaryByMonth(int nowyear,int nowMonth){
        //查询用户列表
        StaffInfo staff = new StaffInfo();
        List<StaffInfo> userlist = userStaffInfoService.selectStaffInfo(staff);
        for(StaffInfo user: userlist) {
            //String userid = user.getStaffUserId();
            //每个人每个月的工资
            //if (!user.getStaffUserId().equals("062201111627694277")) continue;
            generateSalaryByMonth(nowyear,nowMonth,user);
        }

        return "OK";
    }
    /**
     * 按日期生成工资
     */
    public String generateSalaryByDay(String workDate,StaffInfo userid) {
        YoSalary today = selectSalary(userid,workDate);
        String workMonth = workDate.substring(0,6);
        today = updateDateInfo(userid,workDate,workMonth,today);
        today = updateAttendance(userid,workDate,today);
        today = updateLeave(userid,workDate,today);
        today = updateEvection(userid,workDate,today);
        today = updateTimebase(userid,workDate,today);
        today = updateEffective(userid,workDate,today);
        insertORupdate(today);
        return  "OK";
    }
    /**
     * 按日期生成所有人的工资
     */
    public String generateSalaryByDay(String workDate) {
        //查询用户列表
        StaffInfo staff = new StaffInfo();
        List<StaffInfo> userlist = userStaffInfoService.selectStaffInfo(staff);
        for(StaffInfo user: userlist) {
            //String userid = user.getStaffUserId();
            //每个人每个月的工资
            generateSalaryByDay(workDate,user);
        }

        return "OK";
    }
//==============================================================
    /**
     * 添加或新增，加入一条工资记录，判断数据库里面是否存在，已存在就更新，否则就添加
     */
    public String insertORupdate(YoSalary salaryItem) {
        //查询是否存在记录
        try{
            YoSalaryExample Example = new YoSalaryExample();
            YoSalaryExample.Criteria criteria1 = Example.createCriteria();
            criteria1.andDateEqualTo(salaryItem.getDate());
            criteria1.andUseridEqualTo(salaryItem.getUserid());
            List<YoSalary> qlist = userSalaryService.selectByExample(Example);
            if (qlist.size() != 0) {
                //update
                salaryItem.setSid(qlist.get(0).getSid());
                userSalaryService.updateByPrimaryKey(salaryItem);
            } else {
                //insert
                userSalaryService.insert(salaryItem);
            }
        } catch (Exception e){
            return e.getMessage();
        }
        return "OK";
    }




    /**
     *  按用户id，日期查询工资条目
     */
    public YoSalary selectSalary(StaffInfo user, String workDate) {
        YoSalary salaryItem = new YoSalary();
        try{
            Date workdate = sdf.parse(workDate);
            YoSalaryExample Example = new YoSalaryExample();
            YoSalaryExample.Criteria criteria1 = Example.createCriteria();
            criteria1.andDateEqualTo(workdate);
            criteria1.andUseridEqualTo(user.getStaffUserId());
            List<YoSalary> qlist = userSalaryService.selectByExample(Example);
            if (qlist.size() != 0) {
                //返回对象
                salaryItem = qlist.get(0);
            } else {

            }
        } catch (Exception e){
            System.out.print(e.getMessage());
        }
        return salaryItem;
    }


    /**
     *  生成日期格式
     */
    /*public Date generateDate(int nowyear,int nowMonth) {
        String workMonth = "" + nowyear + '-' + nowMonth;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar ca = Calendar.getInstance();
        Date d = sdf.parse(workDate);
        ca.setTime(d);
    }*/

    /**
     *  添加日期信息
     */
    public YoSalary updateDateInfo(StaffInfo user, String workDate , String workMonth , YoSalary salaryItem) {
        try {
            Date d = sdf.parse(workDate);
            ca.setTime(d);
            //处理一天的工资

            salaryItem.setSalarydate(workMonth);
            salaryItem.setDate(sdf.parse(workDate));
            salaryItem.setUserid(user.getStaffUserId());
            salaryItem.setStaffid(user.getStaffId());//工号从何而来

            //当天是否周末/节假日
            if (checkHoliday(ca)){
                //是
                salaryItem.setDatetype("休");
            } else salaryItem.setDatetype("工");
        } catch (Exception e){
            System.out.print(e.getMessage());
        }
        return salaryItem;
    }

    /**
     *  添加考勤记录
     */
    public YoSalary updateAttendance(StaffInfo user, String workDate , YoSalary salaryItem) {
        try {
            Date workdate = sdf.parse(workDate);
            //处理出勤,查询一个人当天的打卡情况
            YoAtteninfoExample attExample = new YoAtteninfoExample();
            YoAtteninfoExample.Criteria criteria = attExample.createCriteria();
            criteria.andStaffIdEqualTo(user.getStaffId());
            criteria.andAttdateEqualTo(workdate);
            List<YoAtteninfo> cqlist = userAttendanceService.selectByExample(attExample);
            if (0 == cqlist.size()) {
                //当天没有出勤
                salaryItem.setAttendance("0");

                salaryItem.setWorkAddress("");
            } else {
                salaryItem.setAttendance("1");

                //当天打卡地
                salaryItem.setWorkAddress(cqlist.get(0).getAttaddress());

            }

            //如果是休息日就要看签到
            if (salaryItem.getDatetype().equals("休")){
                YoSignInExample siExample = new YoSignInExample();
                YoSignInExample.Criteria criteria1 = siExample.createCriteria();
                criteria1.andSiStaffIdEqualTo(user.getStaffId());
                criteria1.andSiDateEqualTo(workDate);
                List<YoSignIn> silist = userSighInService.selectByExample(siExample);
                if (0 == silist.size()) {
                    //当天没有出勤
                    salaryItem.setAttendance("0");

                    salaryItem.setWorkAddress("");
                } else {
                    salaryItem.setAttendance("1");

                    //当天打卡地
                    salaryItem.setWorkAddress(silist.get(0).getSiCompleteAddress());

                }

            }
        } catch (Exception e){
            System.out.print(e.getMessage());
        }
        return salaryItem;
    }


    /**
     *  添加请假记录
     */
    public YoSalary updateLeave(StaffInfo user, String workDate , YoSalary salaryItem) {
        try {
            //Date workdate = sdf.parse(workDate);
            //处理请假
            AskForLeaveExample qjExample = new AskForLeaveExample();
            AskForLeaveExample.Criteria criteria1 = qjExample.createCriteria();
            criteria1.andYoAskStaffIdEqualTo(user.getStaffId());
            criteria1.andYoApproveResultEqualTo("同意");
            criteria1.andYoAskBeginDateLessThanOrEqualTo(workDate);
            criteria1.andYoAskEndDateGreaterThanOrEqualTo(workDate);
            List<AskForLeave> qjlist = userAskLeaveService.selectByExample(qjExample);
            if (0 == qjlist.size()) {
                //当天没有请假
                salaryItem.setLeavetype("0");
                salaryItem.setLeavesalary(0.0);
            } else {
                //根据请假类型扣款
                salaryItem.setLeavetype(qjlist.get(0).getYoType());
                salaryItem.setLeavesalary(DateSalary(salaryItem.getLeavetype(),getBaseSalary(user.getBaseSalary(),manDay)));
            }
        } catch (Exception e){
            System.out.print(e.getMessage());
        }
        return salaryItem;
    }
    /**
     *  添加加班记录
     */
    public YoSalary updateOverwork(StaffInfo user, String workDate , YoSalary salaryItem) {

        salaryItem.setWorkovertime("0");
        salaryItem.setWorksalary(0.0);
        return salaryItem;
    }
    /**
     *  添加真实出勤
     */
    public YoSalary updateEffective(StaffInfo user, String workDate , YoSalary salaryItem) {
        //判断真实出勤-发奖金,有效出勤-算工资
        salaryItem.setEffectiveAttendance(salaryItem.getAttendance());
        if (!salaryItem.getLeavetype().equals("0") || salaryItem.getDatetype().equals("休"))
        {
            //如果有请假，实际算缺勤出勤，然后补助对应的工资，或者今天是休息日
            salaryItem.setEffectiveAttendance("0");
        }
        salaryItem.setRealityattendance(salaryItem.getAttendance());
        if (!salaryItem.getLeavetype().equals("0"))
        {
            //如果有请假，实际算缺勤出勤，今天是休息日，看签到
            salaryItem.setRealityattendance("0");
        }
        //有效工资-通过有效出勤计算
        if (!salaryItem.getEffectiveAttendance().equals("0") ){
            salaryItem.setAttendanceSalary(getBaseSalary(user.getBaseSalary(),manDay));
        } else salaryItem.setAttendanceSalary(0.0);

        return salaryItem;
    }
    /**
     *  添加timebase奖金
     */
    public YoSalary updateTimebase(StaffInfo user, String workDate , YoSalary salaryItem) {
        //timebase奖金,今天是真实出勤日，人在对应项目中
        //if (!user.getYoOrder().isEmpty() && user.getYoOrder().equals("Timebase") && !salaryItem.getRealityattendance().equals("0")){
        if (user.getYoOrder()!= null && user.getYoOrder().equals("Timebase") && !salaryItem.getRealityattendance().equals("0")){
            //按技术等级发奖金
            salaryItem.setTimesalary(callYI(user.getYindaIdentify()));
        } else salaryItem.setTimesalary(0.0);
        return salaryItem;
    }
    /**
     *  添加出差
     */
    public YoSalary updateEvection(StaffInfo user, String workDate , YoSalary salaryItem) {
        //处理出差,签到地点与base地是否匹配,是否有打卡，是否要算加班费，是否是指定合同FDS
        String workaddress = salaryItem.getWorkAddress();
        String address = user.getOrdinaryAddress().trim();
        //if (!salaryItem.getRealityattendance().equals("0") && !user.getComment2().isEmpty() && !user.getComment2().equals("否") && checkContract(user.getContractType()) && !address.isEmpty() && !workaddress.isEmpty() && !workaddress.substring(0,2).contains(address)){
        if (!salaryItem.getRealityattendance().equals("0") && user.getComment2()!=null && !user.getComment2().equals("否") && checkContract(user.getContractType()) && address!=null && workaddress!=null && workaddress.length()>1 && !workaddress.substring(0,2).contains(address)){

                salaryItem.setEvection("1");
                salaryItem.setAllowance(16.0);
            } else {
                salaryItem.setEvection("0");
                salaryItem.setAllowance(16.0);
            }


        return salaryItem;
    }

    //===============================================
    /**
     *  添加或更新一条合计记录
     */
    public String insertORupdateTotal(YoUserinfosalary salaryItem) {
        //查询是否存在记录
        try{
            YoUserinfosalaryExample Example = new YoUserinfosalaryExample();
            YoUserinfosalaryExample.Criteria criteria1 = Example.createCriteria();
            criteria1.andSalarydateEqualTo(salaryItem.getSalarydate());
            criteria1.andUseridEqualTo(salaryItem.getUserid());
            List<YoUserinfosalary> qlist = userinfoSalaryService.selectByExample(Example);
            if (qlist.size() != 0) {
                //update
                salaryItem.setSid(qlist.get(0).getSid());
                userinfoSalaryService.updateByUserSalary(salaryItem);
            } else {
                //insert
                userinfoSalaryService.insert(salaryItem);
            }
        } catch (Exception e){
            return e.getMessage();
        }
        return "OK";
    }
    /**
     *  按用户id，日期查询工资条目
     */
    public YoUserinfosalary selectSalaryTotal(StaffInfo user, String workMonth) {
        YoUserinfosalary salaryItem = new YoUserinfosalary();
        try{
            YoUserinfosalaryExample Example = new YoUserinfosalaryExample();
            YoUserinfosalaryExample.Criteria criteria1 = Example.createCriteria();
            criteria1.andSalarydateEqualTo(workMonth);
            criteria1.andUseridEqualTo(user.getStaffUserId());
            List<YoUserinfosalary> qlist = userinfoSalaryService.selectByExample(Example);
            if (qlist.size() != 0) {
                //返回对象
                salaryItem = qlist.get(0);
            } else {

            }
        } catch (Exception e){
            System.out.print(e.getMessage());
        }
        return salaryItem;
    }
    /**
     * 按月份生成工资
     */
    public String generateSalaryTotal(int nowyear,int nowMonth,StaffInfo user){
        //当前日期
        String workMonth = "" + nowyear + '-' + nowMonth;
        YoUserinfosalary totalSum = new YoUserinfosalary();
        totalSum.setUserid(user.getStaffUserId());
        totalSum.setName(user.getName());
        totalSum.setDepartment(user.getDepartment());
        totalSum.setSalaryid(user.getStaffId());
        totalSum.setSalarydate(workMonth);
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
        totalSum.setTasksalary(0.0);
        totalSum.setEffectiveattendance("0");
        totalSum.setRealityattendance("0");
        totalSum.setUserbonus(0.0);
        totalSum.setSocialdecase(0.0);
        totalSum.setTax(0.0);


        YoSalaryExample Example = new YoSalaryExample();
        YoSalaryExample.Criteria criteria1 = Example.createCriteria();
        criteria1.andSalarydateEqualTo(workMonth);
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
        double b1 = getBaseSalary(user.getBaseSalary(),manDay);
        double bt = user.getBaseSalary().isEmpty() ? 0.0 : Double.parseDouble(user.getBaseSalary());
        if (1.0*e1/t1>0.5){
            totalSum.setAttendancesalary(bt - (t1-e1)*b1);
        } else totalSum.setAttendancesalary(e1*b1);
        //把总工资插入到工资表中
        totalSum.setSubtotal(totalSum.getAttendancesalary() + totalSum.getLeavesalary() + totalSum.getAllowance() + totalSum.getWorksalary());
        totalSum.setTotalsalary(totalSum.getSubtotal() - totalSum.getSocialdecase() + totalSum.getTimesalary() + totalSum.getTasksalary() + totalSum.getUserbonus());
        totalSum.setRealsalary(totalSum.getTotalsalary() - totalSum.getTax());

        insertORupdateTotal(totalSum);

        return "OK";
    }
    /**
     * 按月份生成全部工资
     */
    public String generateSalaryTotal(int nowyear,int nowMonth){
        //查询用户列表
        StaffInfo staff = new StaffInfo();
        List<StaffInfo> userlist = userStaffInfoService.selectStaffInfo(staff);
        for(StaffInfo user: userlist) {
            //String userid = user.getStaffUserId();
            //每个人每个月的工资
            generateSalaryTotal(nowyear,nowMonth,user);
        }

        return "OK";
    }
    /**
     * 查询单个人的工资单
     */
    public YoUserinfosalary getSalaryTotal(String month,StaffInfo user){
        YoUserinfosalary salaryItem = new YoUserinfosalary();
        try{

            YoUserinfosalaryExample Example = new YoUserinfosalaryExample();
            YoUserinfosalaryExample.Criteria criteria1 = Example.createCriteria();
            criteria1.andSalaryidEqualTo(month);
            criteria1.andUseridEqualTo(user.getStaffUserId());
            List<YoUserinfosalary> qlist = userinfoSalaryService.selectByExample(Example);
            if (qlist.size() != 0) {
                //返回对象
                salaryItem = qlist.get(0);
            } else {

            }
        } catch (Exception e){
            System.out.print(e.getMessage());
        }
        return salaryItem;
    }
    /**
     * 更新工资单
     */
    public String updateSalaryTotal(YoUserinfosalary totalSum){
        try{
            //把总工资插入到工资表中

            totalSum.setSubtotal(totalSum.getAttendancesalary() + totalSum.getLeavesalary() + totalSum.getAllowance() + totalSum.getWorksalary() + totalSum.getTrafficsalary());
            totalSum.setTotalsalary(totalSum.getSubtotal() - totalSum.getSocialdecase() + totalSum.getUserbonus() + totalSum.getTimebaseadd() + totalSum.getTaskbaseadd());
            totalSum.setRealsalary(totalSum.getTotalsalary() - totalSum.getTax());

            insertORupdateTotal(totalSum);

        } catch (Exception e){
            System.out.print(e.getMessage());
        }
        return "OK";
    }
}
