package com.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.model.User;
import com.model.YoSalary;
import com.service.IAttendanceService;
import com.service.ISalaryService;
import com.service.IStaffInfoService;
import com.util.DDUtil;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.cglib.core.Constants;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.tagext.PageData;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by pwj on 2016/11/11.
 */
@Controller
@RequestMapping("/userinfo")
public class UserSalaryController {
    @Resource
    private ISalaryService userSalaryService;

////    @RequestMapping(value = "getUserSalary",produces ="application/json;charset=UTF-8",method= RequestMethod.POST)
////    @ResponseBody
////    public Object getUserSalary(){
////        return null;
////    }
//
//    //根据用户id进行查询
//    @RequestMapping("/getAllUser.do")
//    @ResponseBody
//    public ModelAndView getAllUser(@RequestBody YoSalary usersalary){
//        List<YoSalary> list=userSalaryService.searchYoSalaryByEntity(usersalary);
//        ModelAndView modelView=new ModelAndView();
//        Map<String,Object> modelMap=new HashMap<String,Object>();
//        modelMap.put("userid", list);
//        modelMap.put("date", list);
//        modelView.addAllObjects(modelMap);
//        System.out.println("返回JSON数据");
//        return modelView;
//    }
//
//    //根据类型进行查询
//    @RequestMapping("/querytype.do")
//    @ResponseBody
//    public ModelAndView querytype(@RequestBody YoSalary usersalary){
//        List<YoSalary> list=userSalaryService.searchYoSalaryByEntity(usersalary);
//        ModelAndView modelView=new ModelAndView();
//        Map<String,Object> modelMap=new HashMap<String,Object>();
//        modelMap.put("userid", list);
//        modelMap.put("date", list);
//        modelMap.put("leavetype", list);
//        modelView.addAllObjects(modelMap);
//        return modelView;
//    }
//
//
//    //返回json数据
//
//    @RequestMapping(value={"getUserSalary"},method=RequestMethod.POST)
//    @ResponseBody
//    public ModelAndView getProductInfo(@PathVariable String userid,@PathVariable String date) throws Exception {
//        Map<String,Object> map = new HashMap<String,Object>();
//        YoSalary salary = new YoSalary();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        salary.setUserid(userid);
//        salary.setDate(sdf.parse(date));
//
//        map.put("userid", userid);
//        map.put("date",date);
//        map.put("salary", salary);
//        ModelAndView mav=new ModelAndView("android/list",map);
//        return mav;
//    }
//
//
//    /**
//     *
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping(value = "/getAllUser")
//    @ResponseBody
//    public String getAllUser(Model model,@RequestParam(value = "userid", defaultValue = "") String userid,
//                             @RequestParam(value = "date", defaultValue = "") String date,YoSalary yoSalary) throws Exception {
//        try {
//            List<YoSalary> result = userSalaryService.searchYoSalaryByEntity(yoSalary);
//            model.addAttribute("userid",userid);
//            model.addAttribute("date",date);
//            model.addAttribute("result",result);
//            return JSON.toJSONString(model);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//
//    //这个对没对
//    @RequestMapping(value = "/getAllType")
//    @ResponseBody
//    public String getAllType(Model model,@RequestParam(value = "userid", defaultValue = "") String userid,
//                             @RequestParam(value = "date", defaultValue = "") String date,
//                             @RequestParam(value = "leavetype", defaultValue = "") String leavetype,YoSalary yoSalary) throws  Exception{
//        try{
//            List<YoSalary> result=userSalaryService.searchYoSalaryByEntity(yoSalary);
//            model.addAttribute("userid",userid);
//            model.addAttribute("date",date);
//            model.addAttribute("leavetype",leavetype);
//            model.addAttribute("result",result);
//            return  JSON.toJSONString(model);
//        }catch (Exception e){
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//
//    //封装给移动端
//    @RequestMapping("/getSalary")
//    @ResponseBody
//    public Map<String, String> getjson(HttpServletRequest req,HttpServletResponse rep,YoSalary yoSalary) throws Exception {
//        String userid = req.getParameter("userid");
//        String date = req.getParameter("date");
//        System.out.println("使用Spring内置的支持：" + userid + "--->" + date);
//        PrintWriter writer = rep.getWriter();
//        JSONObject object = new JSONObject();
//        Map<String, String> map = new HashMap<String, String>();
//        List<YoSalary> result = userSalaryService.searchYoSalaryByEntity(yoSalary);
//        map.put("userid", userid);
//        map.put("date", date);
//        return map;
//
//        }


    //不知道成功没，卧槽，给我成功吧,
/*    @RequestMapping("/QuerySalary")
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
    }*/


    //根据类型日期的查询
/*    @RequestMapping("/QueryType")
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
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
      }*/
    }
