package com.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.model.StaffInfo;
import com.model.YoAttendance;
import com.service.IAttendanceService;
import com.service.IStaffInfoService;
import com.util.AttendanceWork;
import com.util.DDUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by pwj on 2016/11/4.
 */
@Controller
@RequestMapping("userinfo")
public class AttendanceController {
    @Resource
    private IAttendanceService iAttendanceService;


//    @RequestMapping(value = "/save.do", method = RequestMethod.POST)
//    public @ResponseBody
//    Map<String,Object> save(@RequestBody YoAttendance user, HttpServletRequest request, HttpServletResponse response) throws IOException {
//        Map<String,Object> map = new HashMap<String,Object>();
//        int result = iAttendanceService.insertAttend(user);
//        if(result != 0){
//            map.put("msg", "成功");
//        }else{
//            map.put("msg", "失败");
//        }
//        return map;
//    }


    /*测试的数据，从钉钉里面取出json数据，然后将它保存到数据库中*/
//    @RequestMapping("/test55.do")
//    public String test(HttpServletRequest request) throws IOException {
//        DDUtil ddUtil=new DDUtil((IStaffInfoService) iAttendanceService);
//        AttendanceWork ddUtil2 = new AttendanceWork();
//        try {
//            String result= ddUtil2.getSuiteToken("01002626191049","2016-10-20 00:00:00","2016-10-21 00:00:00",ddUtil.getAccessToken());
//            JSONObject ob=JSONObject.parseObject(result);
//            List<YoAttendance> record=null;
//            YoAttendance yoAttendance=null;
//            JSONArray lists=ob.getJSONArray("recordresult");
//            if (null!=lists || lists.size()>0)
//              //  for (int i=0;i<lists.size();i++){
//                    for (int i=0;i<5;i++){
//                    System.out.println(">>>>>>>>>>>>>>>>>>>>>"+lists.get(i).toString());
//                    yoAttendance=(YoAttendance)lists.get(i);
//                        yoAttendance.setId(UUID.randomUUID().toString());
//                    iAttendanceService.insertAttend(yoAttendance);
//                }
//            System.out.println(result);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "/UserInfo";
//    }
}
