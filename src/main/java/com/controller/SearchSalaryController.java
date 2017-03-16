package com.controller;

import com.model.YoSalaryDaily;
import com.model.YoUserinfosalary;
import com.model.YoUserinfosalaryExample;
import com.service.IUserInfoSalaryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        if (user.getName()!="") criteria1.andNameEqualTo(user.getName());
        if (user.getSalarydate()!="") criteria1.andSalarydateEqualTo(user.getSalarydate());
        if (user.getSalaryid()!="") criteria1.andSalaryidEqualTo(user.getSalaryid());
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
     * @param totalSum
     * @return
     * @throws IOException
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

    /*
    查询员工当月日报。点击每一个员工都会触发
    工号通过读取jsp的nama属性加RequestParam注解得到。注意写了注解就必须有对应的name，否则就报错了
    返回一个实体类列表
    @RequestParam("staffid") String staffid,
     */
    @RequestMapping(value = "journal.do")
    public String journal( Model m) {
        // 在测试阶段，就直接查我的日报吧
        List<YoSalaryDaily> list = userInfoService.getJournal("16462");
        // 在页面中扒开这个列表，就是实体类了
        m.addAttribute("journal", list);
        return "/salary/journal";
    }
}
