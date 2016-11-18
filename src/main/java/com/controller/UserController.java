package com.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ddSdk.auth.AuthHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.IUserService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ma on 2016/10/13.
 */
    @Controller
    @RequestMapping("/user")
    public class UserController {

        @Resource
        private IUserService userService;

        @RequestMapping("/test.do")
        public String findAllUser(HttpServletRequest request){

            return "/affairs-search";
        }
        @RequestMapping("/upload.do")
        public String Upload(HttpServletRequest request){

            return "/upload";
        }
        @RequestMapping("/upload-chuchai.do")
        public String UploadChuChai(HttpServletRequest request){

            return "/upload-chuchai";
        }

        @RequestMapping("/upload-jiaban.do")
        public String UploadJaBan(HttpServletRequest request){

            return "/upload-jiaban";
        }
        @RequestMapping("/upload-jiaotong.do")
        public String UploadJiaoTong(HttpServletRequest request){

            return "/upload-jiaotong";
        }
        @RequestMapping("/upload-project.do")
        public String UploadProject(HttpServletRequest request){

            return "/upload-project";
        }
        @RequestMapping("/upload-qingjia.do")
        public String UploadQingJia(HttpServletRequest request){

            return "/upload-qingjia";
        }
        @RequestMapping("/upload-renzheng.do")
        public String UploadRenZheng(HttpServletRequest request){

            return "/upload-renzheng";
        }

        @RequestMapping("/phone-salary.do")
        public String PhoneSalary(HttpServletRequest request){
            String config = AuthHelper.getConfig(request);
            request.setAttribute("config",config);
            return "/dd/salary";
        }
        @RequestMapping("/phone-kaoqin.do")
        public String PhoneKaoQin(HttpServletRequest request){

            return "/dd/kaoqin";
        }

        @RequestMapping("/phone-details.do")
        public String PhoneDetails(HttpServletRequest request){

            return "/dd/details";
        }



    }

