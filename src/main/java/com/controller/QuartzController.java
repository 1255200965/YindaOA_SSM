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
    //星期一早上打开
    @Scheduled(cron = "0 30 01 ? * MON")
    public  void start(){
        System.out.println("考勤任务正在执行中。。。。星期一早上01:30打开考勤");
        System.out.println("考勤星期一到星期五可见");
        AttendanceShow();
    }
    //星期五晚上关闭
    @Scheduled(cron = "0 30 23 ? * FRI")
    public void one() {
        System.out.println("考勤任务正在执行中。。。。星期五晚上23:50关闭考勤");
        System.out.println("考勤星期一到星期五可见");
        AttendanceStop();
    }

    //星期六签到打开，
    @Scheduled(cron = "0 35 23 ? * FRI")
    public void two() {
        System.out.println("考勤任务正在执行中。。。。星期六早上01:10打开签到");
        System.out.println("签到星期六到星期天可见");
        SignShow();
    }

    //    星期天晚上23：50---签到关闭
    @Scheduled(cron = "0 50 23 ? * SUN")
    public void job2() {
        System.out.println("签到任务正在执行中。。。。星期天的晚上23：50关闭签到");
        System.out.println("签到星期六到星期天可见");
        SignStop();
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
