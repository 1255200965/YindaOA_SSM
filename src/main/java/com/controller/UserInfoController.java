package com.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;   // allow Spring injection
import org.springframework.stereotype.Controller;   // allow controller
import org.springframework.ui.Model;   // allow model
import org.springframework.web.bind.annotation.RequestMapping;   // allow map tag
import org.springframework.web.bind.annotation.RequestParam;   // allow using name to pass argument
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.model.UserDto;
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
    private IUserInfoService userService;

    @RequestMapping("/testMethod.do")
    public String getAllUser(Map<String,Object> map,HttpServletRequest request){
        List<UserDto> userDtoList = new ArrayList<UserDto>();
        //int index = Integer.parseInt(request.getParameter("index"));
        //int page = Integer.parseInt(request.getParameter("page"));
        int id = 0;
        if (request.getParameter("name")!= null) {
            id = Integer.parseInt(request.getParameter("name"));
        }
        userDtoList.add(userService.selectUserByID(id));

        map.put("listUser", userDtoList);
        return "/UserInfo";
    }

    @RequestMapping(value = "/login.do", method = RequestMethod.GET)
    public Map<String,Object> login( @RequestParam("userId") String userId) throws IOException {
        //查询指定id，填充进map
        List<UserInfo> list = userService.searchUserInfoByUserId(userId);
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
    public @ResponseBody Map<String,Object> adduser(@RequestBody UserDto user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String,Object> map = new HashMap<String,Object>();

        int result = userService.insertUser(user);
        if(result != 0){
            map.put("msg", "成功");
        }else{
            map.put("msg", "失败");
        }
        return map;
    }
    @RequestMapping(value = "/updateuser.do", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> updateuser(@RequestBody UserDto user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String,Object> map = new HashMap<String,Object>();

        int result = userService.updateUserByID(user);
        if(result != 0){
            map.put("msg", "成功");
        }else{
            map.put("msg", "失败");
        }
        return map;
    }
}
