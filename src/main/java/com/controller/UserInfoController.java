package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.model.UserInfo;

import org.springframework.stereotype.Controller;   // allow controller
import org.springframework.web.bind.annotation.RequestMapping;   // allow map tag

import com.service.IUserInfoService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Created by ma on 2016/10/17.
 */
@Controller
@RequestMapping("/userinfo")
public class UserInfoController {
    @Resource
    private IUserInfoService userInfoService;

    @RequestMapping("/testMethod.do")
    public String getAllUser(Map<String,Object> map,HttpServletRequest request){
        List<UserInfo> userDtoList = new ArrayList<UserInfo>();
        //int index = Integer.parseInt(request.getParameter("index"));
        //int page = Integer.parseInt(request.getParameter("page"));
        int id = 0;
        if (request.getParameter("name")!= null) {
            id = Integer.parseInt(request.getParameter("name"));
        }
        userDtoList.add(userInfoService.selectUserByID(id));

        map.put("listUser", userDtoList);
        return "/UserInfo";
    }

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> login(@RequestBody UserInfo user) throws IOException {
        //查询指定id，填充进map
        List<UserInfo> list = userInfoService.searchUserInfoByEntity(user);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("usertest",list);
        if(list.size() != 0){
            map.put("msg", "成功");
        }else{
            map.put("msg", "查询结果为空");
        }
        return map;
    }

    @RequestMapping(value = "/adduser.do", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> adduser(@RequestBody UserInfo user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String,Object> map = new HashMap<String,Object>();

        int result = userInfoService.insertUser(user);
        if(result != 0){
            map.put("msg", "成功");
        }else{
            map.put("msg", "失败");
        }
        return map;
    }
    @RequestMapping(value = "/updateuser.do", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> updateuser(@RequestBody UserInfo user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String,Object> map = new HashMap<String,Object>();

        int result = userInfoService.updateUserByID(user);
        if(result != 0){
            map.put("msg", "成功");
        }else{
            map.put("msg", "失败");
        }
        return map;
    }
}
