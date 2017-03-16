package com.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dingtalk.open.client.api.model.corp.CorpUserDetail;
import com.model.StaffInfo;
import com.model.YoAttendance;
import com.service.IAttendanceService;
import com.service.IStaffInfoService;
import com.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by ma on 2016/10/17.
 */
@Controller
@RequestMapping("/userinfo")
public class StaffInfoController {
    @Resource
    private IStaffInfoService userInfoService;

    @Resource
    private IAttendanceService iAttendanceService;

    @RequestMapping("/testMethod.do")
    public String getAllUser(HttpServletRequest request) throws IOException {
//        DDUtil ddUtil = new DDUtil();
//        try {
//            List<CorpUserDetail> list = ddUtil.getAllDepartMem(15111);
//            CorpUserDetail corpUserDetailLLR = list.get(3);
//            StaffInfo staffInfoLLR = ddUtil.ChangeToLocal(corpUserDetailLLR);
//            System.out.println("okc的电话号码是"+staffInfoLLR.getCellphone());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        return "/UserInfo";
    }

    /**
     * 点击查询按钮后，根据输入框产生的实体类进行查询，页面不跳转
     * @param user
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> login1(@RequestBody StaffInfo user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //查询指定id，填充进map
        //List<StaffInfo> list = userInfoService.searchStaffInfoByEntity(user);
        List<StaffInfo> list = userInfoService.selectStaffInfo(user);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("usertest",list);
        if(list.size() != 0){
            map.put("msg", "成功");
        }else{
            map.put("msg", "查询结果为空");
        }
        return map;
    }
    //根据条件查询所有员工信息
    @RequestMapping(value = "/query.do", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> query1(@RequestBody StaffInfo stu, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //List<StaffInfo> list = userInfoService.searchStaffInfoByEntity(stu);//改！
        //更换天国的遗产
        List<StaffInfo> list = userInfoService.selectStaffInfo(stu);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userlist", list);
        if (list.size() != 0) {
            map.put("msg", "成功");
        } else {
            map.put("msg", "查询结果为空");
        }
        return map;
    }


    //修改用户信息
    @RequestMapping(value = "/updateuser.do", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> updateuser(@RequestBody StaffInfo user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String,Object> map = new HashMap<String,Object>();

        // 数据库修改部分
        int result = userInfoService.updateStaffByID(user);
        if(result != 0){
            map.put("msg", "更新成功");
            map.put("ok", "ok");
        }else{
            map.put("msg", "更新失败");
        }

        // 钉钉修改部分
        DDUtil ddutil = new DDUtil(userInfoService);
        // 把手机号置为空后再更新钉钉
        user.setCellphone("");
        String DDresult = ddutil.updateUser(user);
        if (DDresult != null){
            map.put("msg", DDresult);
            return map;
        }
        return map;
    }

    //删除用户信息
    @RequestMapping(value = "/delete.do", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> delete(@RequestBody StaffInfo user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String,Object> map = new HashMap<String,Object>();
        user.setWorkState("离职");
        user.setLeaveDate(DateUtil.getCurrentTimeDate().toString());
        //钉钉侧删除
        DDUtil ddutil = new DDUtil(userInfoService);
        String DDresult = ddutil.deleteUser(user);
        if (DDresult != null){
            map.put("msg", DDresult);
            return map;
        }
        int result = userInfoService.updateStaffByID(user);
        if(result != 0){
            map.put("msg", "离职成功");
            map.put("ok", "ok");
        }else{
            map.put("msg", "离职失败");
        }
        return map;
    }


    @RequestMapping("/test.do")
    public String test(Map<String,Object> map,HttpServletRequest request){
        List<StaffInfo> userDtoList = new ArrayList<StaffInfo>();
        map.put("listUser", userDtoList);
        return "/UserSalary";
    }

    @RequestMapping("/querys.do")
    public String querys(Map<String,Object> map,HttpServletRequest request){
        List<StaffInfo> userDtoList = new ArrayList<StaffInfo>();
        String userRole = (String) request.getSession().getAttribute("user_role");
        String Department = (String) request.getSession().getAttribute(GlobalConstant.user_department);
        String StaffID = (String) request.getSession().getAttribute(GlobalConstant.user_staffId);
        String StaffUserID = (String) request.getSession().getAttribute(GlobalConstant.user_staff_user_id);
        String StaffName =(String) request.getSession().getAttribute(GlobalConstant.user_name);

        map.put("userRole", userRole);
        map.put("Department", Department);
        map.put("StaffName", StaffName);
        map.put("StaffID", StaffID);
        map.put("StaffUserID", StaffUserID);
        System.out.print(userRole);
        return "/UserInfoSalary";
    }

    @RequestMapping("/test22.do")
    public String testd(Map<String,Object> map,HttpServletRequest request){

        return "/UserSalary";
    }

    //从服务解析出来的json
    public  void saveAttendance(String result) {
        //我要将0100变成一个集合，就是一张表里的所有id
        JSONObject ob = JSONObject.parseObject(result);
        JSONObject thwb = null;
        List<YoAttendance> record = null;
        YoAttendance yoAttendance = null;
        JSONArray lists = ob.getJSONArray("recordresult");
        System.out.println(">>>刷数据，刷数据>>>>>>>> >>>>>>>" + lists.size());
        if (null != lists || lists.size() > 0)
            for (int j = 0; j < lists.size(); j++) {
                yoAttendance = new YoAttendance();
                thwb = (JSONObject) lists.get(j);
                yoAttendance.setCorpid(thwb.getString("corpId"));
                yoAttendance.setId(thwb.getInteger("id") + "");
                yoAttendance.setBasechecktime(thwb.getTimestamp("baseCheckTime"));
                yoAttendance.setChecktype(thwb.getString("checkType"));
                yoAttendance.setGroupid(thwb.getInteger("groupId") + "");
                yoAttendance.setLocationresult(thwb.getString("locationResult"));
                yoAttendance.setPlanid(thwb.getInteger("planId") + "");
                yoAttendance.setRecordid(thwb.getInteger("recordId") + "");
                yoAttendance.setTimeresult(thwb.getString("timeResult"));
                yoAttendance.setUserchecktime(thwb.getTimestamp("userCheckTime"));
                yoAttendance.setUserid(thwb.getString("userId") + "");
                yoAttendance.setWorkdate(thwb.getTimestamp("workDate"));
                System.out.println(">>>>>>>>>>哦咯> >>>>>>>" + yoAttendance.toString());
                try {
                    iAttendanceService.insertAttend(yoAttendance);
                } catch (Exception e) {
                    System.out.print("主键唯一约束");
                }
            }
        }

}
