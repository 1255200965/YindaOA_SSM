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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by pwj on 2016/11/18.
 */
@Component
public class QuartzController {
    //考勤工作日每天早上8点30打开
    @Scheduled(cron = "0 30 08 ? * MON-FRI")
    public  void start(){
        //如果是放假时间，不开考勤
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String now =dateFormat.format(new Date());
        //if (now.compareTo("2017-01-26")>0 && now.compareTo("2017-02-03")<0) return;
        System.out.println("考勤任务正在执行中。。。。每天早上8：30打开考勤");
        System.out.println("考勤工作日每天早上8点30打开");
        AttendanceShow();
    }
    //考勤工作日每天下午6点关闭
    @Scheduled(cron = "0 00 18 ? * MON-FRI")
    public void one() {

        System.out.println("考勤任务正在执行中。。。。每天下午18：00关闭考勤");
        System.out.println("考勤工作日下午18：00关闭考勤");
        AttendanceStop();
    }

    //签到每天19点30打开，
    @Scheduled(cron = "0 00 18 ? * MON-FRI")
    public void two() {
        System.out.println("考勤任务正在执行中。。。。每天晚上6点打开签到");
        System.out.println("签到星期六到星期天可见");
        SignShow();
    }

    // 签到每天早上8点30关闭
    @Scheduled(cron = "0 30 08 ? * MON-FRI")
    public void job2() {
        //如果是放假时间，不关签到
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String now =dateFormat.format(new Date());
        //if (now.compareTo("2017-01-26")>0 && now.compareTo("2017-02-03")<0) return;

        System.out.println("签到任务正在执行中。。。。每天早上8点30关闭签到");
        System.out.println("签到星期六到星期天可见");
        SignStop();
    }
    //    签到周六周日早上8点30打开
    @Scheduled(cron = "0 30 08 ? * SUN,SAT")
    public void job3() {
        System.out.println("签到任务正在执行中。。。。星期天的晚上23：50关闭签到");
        System.out.println("签到星期六到星期天可见");

        SignShow();

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
