package com.controller;


import com.model.YoSalary;
import com.service.ISalaryService;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

//    @RequestMapping("/query.do")
//    public String listBrand(Model model){
//        List<YoSalary> bList = userSalaryService.searchYoSalaryByEntity();
//        model.addAttribute("usertest", bList);
//        return "jsp/UserSalary";
//    }


//
//    //更新员工工资信息
//    @RequestMapping(value = "/update.do", method = RequestMethod.POST)
//    public @ResponseBody Map<String,Object> update(@RequestBody YoSalary user, HttpServletRequest request, HttpServletResponse response) throws IOException {
//        Map<String,Object> map = new HashMap<String,Object>();
//        int result = userSalaryService.updateUserSalary(user);
//        if(result != 0){
//            map.put("msg", "更新员工的工资成功");
//        }else{
//            map.put("msg", "更新失败");
//        }
//        return map;
//    }
//
//    //工资生成逻辑,添加成功
//    @RequestMapping(value = "/insert.do", method = RequestMethod.POST)
//    public @ResponseBody Map<String,Object> insert(@RequestBody YoSalary user, HttpServletRequest request, HttpServletResponse response) throws IOException {
//        Map<String,Object> map = new HashMap<String,Object>();
//        int result = userSalaryService.insert(user);
//        if(result != 0){
//            map.put("msg", "成功");
//        }else{
//            map.put("msg", "失败");
//        }
//        return map;
//    }

}
