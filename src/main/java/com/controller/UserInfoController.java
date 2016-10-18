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
        System.out.println(request.getParameter("name"));
        Map<String,Object> map = new HashMap<String,Object>();
        int id = Integer.parseInt(request.getParameter("name"));
        map.put("usertest",userService.selectUserByID(id));



        if(request.getParameter("name").equals("123")){
            System.out.println("城东");
            map.put("msg", "成功");
        }else{
            System.out.println("失败");
            map.put("msg", "失败");
        }
        return map;
    }

}
