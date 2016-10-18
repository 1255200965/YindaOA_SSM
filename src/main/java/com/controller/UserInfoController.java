package com.controller;

import com.model.UserDto;
import com.service.IUserInfoService;
import com.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public @ResponseBody Map<String,Object> login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //查询指定id，填充进map
        Map<String,Object> map = new HashMap<String,Object>();
        List<UserDto> userDtoList = new ArrayList<UserDto>();
        int id = 0;
        if (request.getParameter("name")!= null) {
            id = Integer.parseInt(request.getParameter("name"));
        }
        userDtoList.add(userService.selectUserByID(id));
        map.put("usertest",userDtoList);

        if(id != 0){
            map.put("msg", "成功");
        }else{
            map.put("msg", "失败");
        }
        return map;
    }

}
