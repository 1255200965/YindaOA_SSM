package com.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.model.StaffInfo;
import com.model.YoSalary;
import com.service.ISalaryService;
import com.service.IStaffInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pwj on 2016/11/10.
 */
@Controller
@RequestMapping("Service")
public class StaffInfoDateService {
    @Resource
    private IStaffInfoService userStaffInfoService;
    @Resource
    private ISalaryService userSalaryService;


//    @RequestMapping("/query")
//    public void getjson(HttpServletRequest req,HttpServletResponse rep) throws Exception {
//        String userid = req.getParameter("userid");
//        String date = req.getParameter("date");
//
//        System.out.println(" 直接 PrintWriter输出json :" + userid + "--->" + date);
//        JSONObject ob = JSONObject.parseObject(userid);
//        PrintWriter writer = rep.getWriter();
//        JSONObject object = null;
//        JSONArray lists = ob.getJSONArray("recordresult");
//        if (null != lists || lists.size() > 0)
//            for (int j = 0; j < lists.size(); j++) {
//                StaffInfo staffInfo = new StaffInfo();
//                staffInfo.getIdNo();
//                writer.println(object.toString());
//                writer.flush();
//                writer.close();
//            }
//    }
//
//
//    //查询员工工资信息
//    @RequestMapping(value = "/query", method = RequestMethod.POST)
//    public @ResponseBody Map<String,Object> query1(@RequestBody YoSalary user, HttpServletRequest request, HttpServletResponse response) throws IOException {
//        //查询指定id，填充进map
//        List<YoSalary> list = userSalaryService.searchYoSalaryByEntity(user);
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("userlist", list);
//        if (list.size() != 0) {
//            map.put("msg", "成功");
//        } else {
//            map.put("msg", "查询结果为空");
//        }
//        JSONObject object = new JSONObject();
//        JSONArray ob = new JSONArray();
//        if (null != ob || ob.size() > 0)
//            for (int j = 0; j < ob.size(); j++) {
//                YoSalary yoSalary=new YoSalary();
//                yoSalary.setSid(object.getInteger("userid"));
//                yoSalary.setDate(object.getSqlDate("date"));
//                yoSalary.setDatetype(object.getString("datetype"));
//                yoSalary.setAttendance(object.getString("attendance"));
//                yoSalary.setLeavetype(object.getString("leavetype"));
//                yoSalary.setLeavesalary(object.getDouble("leavesalary"));
//                yoSalary.setWorkovertime(object.getString("workovertime"));
//                yoSalary.setWorksalary(object.getDouble("worksalary"));
//                yoSalary.setEvection(object.getString("evection"));
//                yoSalary.setAllowance(object.getString("allowance"));
//                yoSalary.setTimesalary(object.getDouble("timesalary"));
//                yoSalary.setTask(object.getString("task"));
//                yoSalary.setTasksalary(object.getDouble("tasksalary"));
//                yoSalary.setBusalary(object.getDouble("busalary"));
//            }
//        return map;
//    }


}
