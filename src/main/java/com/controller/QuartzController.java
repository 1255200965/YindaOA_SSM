package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.ddSdk.auth.AuthHelper;
import com.ddSdk.base.OApiException;
import com.ddSdk.utils.HttpHelper;
import com.model.StaffInfo;
import com.service.IAttendanceService;
import com.service.IStaffInfoService;
import com.util.AttendanceWork;
import com.util.DDUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.swing.text.Document;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pwj on 2016/11/18.
 */
@Component
public class QuartzController {
    //星期一早上0：00---星期六 0:00 --------------考勤打开，签到关闭
    @Scheduled(cron = "0 00 0 ? * MON-SAT")
    public void one() {
        System.out.println("考勤任务正在执行中。。。星期一的0：00-到星期六的0:00");
        System.out.println("考勤星期一到星期五可见");
        AttendanceShow();
        SignStop();
    }

    //星期五晚上23：59-星期六晚上23：59--------------签到打开，考勤关闭
    @Scheduled(cron = "0 59 23 ? * FRI-SAT")
    public void two() {
        System.out.println("考勤任务正在执行中。。。星期五晚上的23：59-到星期六的23：59");
        System.out.println("签到星期六到星期天可见");
        SignShow();
        AttendanceStop();
    }


//    星期天早上0：00---星期一 0:00--------------签到打开，考勤关闭
    @Scheduled(cron = "0 00 0 ? * SUN-MON")
    public void job2() {
        System.out.println("签到任务正在执行中。。。星期天的早上的0：00到星期一的0:00");
        System.out.println("签到星期六到星期天可见");
        SignShow();
        AttendanceStop();
    }


    //考勤打开
    public static String AttendanceShow() {
        JSONObject json = new JSONObject();
        json.put("agentId", 22414566);
        json.put("isHidden",false);
        JSONObject reponseJson = null;
        try {
            String url = "https://oapi.dingtalk.com/microapp/set_visible_scopes?access_token=" +  AuthHelper.getAccessToken();
            reponseJson = HttpHelper.httpPost(url, json);
        } catch (OApiException e) {
            e.printStackTrace();
        }
        return reponseJson.toJSONString();
    }

    //签到打开
    public static String SignShow() {
        JSONObject json = new JSONObject();
        json.put("agentId", 918369);
        json.put("isHidden",false);
        JSONObject reponseJson = null;
        try {
            String url = "https://oapi.dingtalk.com/microapp/set_visible_scopes?access_token=" +  AuthHelper.getAccessToken();
            reponseJson = HttpHelper.httpPost(url, json);
        } catch (OApiException e) {
            e.printStackTrace();
        }
        return reponseJson.toJSONString();
    }


    //考勤关闭
    public static String AttendanceStop() {
        JSONObject json = new JSONObject();
        List<String> userid=new ArrayList<String>();
        json.put("agentId", 22414566);
        json.put("isHidden",true);
//        json.put("userVisibleScopes",userid);
        JSONObject reponseJson = null;
        try {
            String url = "https://oapi.dingtalk.com/microapp/set_visible_scopes?access_token=" +  AuthHelper.getAccessToken();
            reponseJson = HttpHelper.httpPost(url, json);
        } catch (OApiException e) {
            e.printStackTrace();
        }
        return reponseJson.toJSONString();
    }


    //签到关闭
    public static String SignStop() {
        JSONObject json = new JSONObject();
        json.put("agentId", 918369);
        json.put("isHidden",true);
        JSONObject reponseJson = null;
        try {
            String url = "https://oapi.dingtalk.com/microapp/set_visible_scopes?access_token=" +  AuthHelper.getAccessToken();
            reponseJson = HttpHelper.httpPost(url, json);
        } catch (OApiException e) {
            e.printStackTrace();
        }
        return reponseJson.toJSONString();
    }


}
