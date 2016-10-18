package com.controller;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.User;
import com.service.IUserService;

/**
 * Created by ma on 2016/10/13.
 */
    @Controller
    @RequestMapping("/user")
    public class UserController {

        @Resource
        private IUserService userService;

        @RequestMapping("/findAllUser.do")
        public String findAllUser(HttpServletRequest request){
            List<User> listUser =  userService.findAllUser();
            request.setAttribute("listUser", listUser);
            return "/allUser";
        }
    }

