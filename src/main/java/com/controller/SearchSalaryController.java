package com.controller;

import com.model.YoSalaryDaily;
import com.model.YoUserinfosalary;
import com.model.YoUserinfosalaryExample;
import com.service.IUserInfoSalaryService;
import com.service.impl.ExcelStaffInfoServiceImpl;
import com.util.GlobalConstant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ma on 2016/10/17.
 * 此方法是奖金生成页面的controller
 */
@Controller
@RequestMapping("/userinfosalary")
public class SearchSalaryController {
    @Resource
    private IUserInfoSalaryService userInfoService;
/**
     * 点击查询按钮后，根据输入框产生的实体类进行查询，页面不跳转
     * @param user
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/select.do", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> select(@RequestBody YoUserinfosalary user) throws IOException {
        YoUserinfosalaryExample example = new YoUserinfosalaryExample();
        YoUserinfosalaryExample.Criteria criteria1 = example.createCriteria();
        //姓名模糊查询
        if (user.getName()!=null) criteria1.andNameLike("%"+user.getName()+"%");
        if (user.getSalarydate()!=null) criteria1.andSalarydateEqualTo(user.getSalarydate());
        if (user.getSalaryid()!= null) criteria1.andSalaryidEqualTo(user.getSalaryid());
        if (user.getDepartment()!=null) criteria1.andDepartmentLike(user.getDepartment());
        List<YoUserinfosalary> list = userInfoService.selectByExample(example);

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("usertest",list);
        if(list.size() != 0){
            map.put("msg", "成功");
        }else{
//    修改用户工资信息
            map.put("msg", "查询结果为空");
        }
        return map;
    }

    /**
     * 更新工资
     */
    @RequestMapping(value = "/updatesalary.do", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> updateuser(@RequestBody YoUserinfosalary totalSum) throws IOException {
        Map<String,Object> map = new HashMap<String,Object>();
        //重新计算工资
        if (totalSum.getTaskbaseadd() == null) {
            totalSum.setTaskbaseadd(totalSum.getTasksalary());
        }
        if (totalSum.getTimebaseadd() == null) {
            totalSum.setTimebaseadd(totalSum.getTimesalary());
        }
        //totalSum.setSubtotal(totalSum.getAttendancesalary() + totalSum.getLeavesalary() + totalSum.getAllowance() + totalSum.getWorksalary() + totalSum.getTrafficsalary());
        totalSum.setTotalsalary(totalSum.getSubtotal()  + totalSum.getAllowance() + totalSum.getHeatingAllowance() + totalSum.getTrafficsalary()   + totalSum.getUserbonus() + totalSum.getTimebaseadd() + totalSum.getTaskbaseadd());

        int result = userInfoService.updateByUserSalary(totalSum);

        if(result != 0){
            map.put("msg", "更新成功");
            map.put("ok", "ok");
        }else{
            map.put("msg", "更新失败");
        }
        return map;
    }

    @RequestMapping(value = "/querys.do", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> querys(@RequestBody YoUserinfosalary user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<YoUserinfosalary> list = userInfoService.searchUserInfoByEntity(user);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("usertest",list);
        if(list.size() != 0){
            map.put("msg", "成功");
        }else{
            map.put("msg", "查询结果为空");
        }
        return map;
    }

    /**
     * 查询日报
     */
    @RequestMapping(value = "/RBquerys.do", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> RBquerys(@RequestBody YoSalaryDaily user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<YoSalaryDaily> list = userInfoService.selectDailyByExample(user);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("usertest",list);
        if(list.size() != 0){
            map.put("msg", "成功");
        }else{
            map.put("msg", "查询结果为空");
        }
        return map;
    }

    /**
     * 更新日报
     */
    @RequestMapping(value = "/RBupdate.do", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> RBupdate(@RequestBody YoSalaryDaily totalSum) throws IOException {
        Map<String,Object> map = new HashMap<String,Object>();

        int result = userInfoService.updateDailyByUserSalary(totalSum);

        if(result != 0){
            map.put("msg", "更新成功");
            map.put("ok", "ok");
        }else{
            map.put("msg", "更新失败");
        }
        return map;
    }



    /*
    日报页面，点击工资后触发
    工号通过读取jsp的nama属性加RequestParam注解得到。注意写了注解就必须有对应的name，否则就报错了
    返回一个实体类列表
     */
    @RequestMapping(value = "journal.do")
    // 接收一个参数，用注解还可以忍的。3个参数如果同在一个实体类那还是传类进来吧
    public String journal( @RequestParam(value = "staffid", defaultValue = "") String staffid, Model m, HttpServletRequest request) {
        //写session 啊，统统干掉
        String userRole = (String) request.getSession().getAttribute("user_role");
        String Department = (String) request.getSession().getAttribute(GlobalConstant.user_department);
        String StaffID = (String) request.getSession().getAttribute(GlobalConstant.user_staffId);
        String StaffUserID = (String) request.getSession().getAttribute(GlobalConstant.user_staff_user_id);
        String StaffName =(String) request.getSession().getAttribute(GlobalConstant.user_name);

        m.addAttribute("userRole", userRole);
        m.addAttribute("Department", Department);
        m.addAttribute("StaffName", StaffName);
        m.addAttribute("StaffID", StaffID);
        m.addAttribute("StaffUserID", StaffUserID);

        // 第1步，操作者是9大PM，状态设为1，否则为2
        String operator;
        // 如果session过期打开日报审批会报404，不知用try能不能解决
        try {
            // 170317，不会用注解的方法只能先这么鱼了
            operator = request.getSession().getAttribute(GlobalConstant.user_name).toString();
        } catch (Exception e) {
            // 170317，如有异常回到首页。先看能不能解决问题，如不能，再研究怎么回到登录页
            return "index";
        }
        List<String> staffidList = new ArrayList<>();
        staffidList.add("王龙");
        staffidList.add("岳韶斌");
        staffidList.add("周靓");
        staffidList.add("韩永林");
        staffidList.add("方舒");
        staffidList.add("魏群");
        staffidList.add("孙华武");
        staffidList.add("丁希林");
        staffidList.add("吴成勇");
        String operatorState;
        if (staffidList.contains(operator)) {
            operatorState = "1";
        } else {
            operatorState = "2";
        }

        List<YoSalaryDaily> list = userInfoService.getJournal(staffid);
        // 在页面中扒开这个列表，就是实体类了
        m.addAttribute("journal", list);
        m.addAttribute("operatorState", operatorState);
        return "/salary/journal";
    }

    /*
    考勤设为有效
    操作成功之后重定向到日报页面
     */
    @RequestMapping(value = "attEffective.do")
    public String attEffective(int seqNo, String staffid, String salaryState, RedirectAttributes ra) {
        userInfoService.attEffective(seqNo);
        ra.addAttribute("staffid", staffid);
        return "redirect:/userinfosalary/journal.do";
    }

    /*
    考勤设为无效
    操作成功之后重定向到日报页面
     */
    @RequestMapping(value = "attInvalid.do")
    public String attInvalid(int seqNo, String staffid, String salaryState, RedirectAttributes ra) {
        userInfoService.attInvalid(seqNo);
        ra.addAttribute("staffid", staffid);
        return "redirect:/userinfosalary/journal.do";
    }

    /*
    170319,提交改为有效考勤的审批，PM一级要用到
    操作成功之后重定向到日报页面
    表单上的几个name都在同一个entity中，提交之后一次传过来
     */
    @RequestMapping(value = "submitApprove.do")
    public String submitApprove( @RequestParam("salaryState") String salaryState, YoSalaryDaily yoSalaryDaily, RedirectAttributes ra) {
        userInfoService.submitApprove(yoSalaryDaily);
        String staffid = yoSalaryDaily.getStaffid();
        ra.addAttribute("staffid", staffid);
        return "redirect:/userinfosalary/journal.do";
    }

    /*
    审批列表页面，只有我和黄照香能进入
     */
    @RequestMapping(value = "checkJournal.do")
    public String checkJournal(Model m, HttpServletRequest request) {
        String staffid;
        // 第1步，在转发之前得到工号
        // 如果session过期打开日报审批会报404，不知用try能不能解决
        try {
            // 170317，不会用注解的方法只能先这么鱼了
            staffid = request.getSession().getAttribute(GlobalConstant.user_staffId).toString();
        } catch (Exception e) {
            // 170317，如有异常回到首页。先看能不能解决问题，如不能，再研究怎么回到登录页
            return "index";
        }

        // 第2步，如果工号为指定的人，就跳到正常页面。否则就跳到无权限页面
        // 就算强行输入地址，也同样只有我和黄照香可以进入页面
        if (staffid.equals("16462") || staffid.equals("19119")) {
            // 在测试阶段，查看日报状态为1的人的日报
            List<YoSalaryDaily> list = userInfoService.getJournalOnCheck();
            // 在页面中扒开这个列表，就是实体类了
            m.addAttribute("journal", list);
            return "/salary/check_journal";
        } else {
            return "error2";
        }
    }

    /*
    打回日报审批
    当黄照香点击打回时，日报状态1变成0
    如果该员工没有审批中的日报时，总表的工资状态3变成0，分表维持0（改为3没有实际意义）
     */
    @RequestMapping(value = "rejectJournal.do")
    // 170321读取页面值的时候，会自动做类型转换
    public String rejectJournal(int seqNo, String staffid) {
        userInfoService.rejectJournal(seqNo, staffid);
        return "redirect:/userinfosalary/checkJournal.do";
    }

    /*
    通过日报审批
    当黄照香点击通过时，改日报和工资数据，日报状态1变成2
    如果该员工没有审批中的日报时，总表的工资状态3变成0，分表维持0（改为3没有实际意义）
     */
    @RequestMapping(value = "approveJournal.do")
    public String approveJournal(int seqNo, String staffid) {
        userInfoService.approveJournal(seqNo, staffid);
        return "redirect:/userinfosalary/checkJournal.do";
    }

}
