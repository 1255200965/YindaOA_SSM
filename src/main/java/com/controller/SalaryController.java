package com.controller;


import com.model.YoSalary;
import com.service.ISalaryService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pwj on 2016/10/31.
 */

@Controller
@RequestMapping("/usersalary")
public class SalaryController {

    @Resource
    private ISalaryService userSalaryService;

    //查询员工工资信息
    @RequestMapping(value = "/query.do", method = RequestMethod.POST)
    public @ResponseBody
    Map<String,Object> query2(@RequestBody YoSalary user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //查询指定id，填充进map
        List<YoSalary> list = userSalaryService.searchYoSalaryByEntity(user);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("usertest",list);
        if(list.size() != 0){
            map.put("msg", "成功");
        }else{
            map.put("msg", "查询结果为空");
        }
        return map;
    }
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
