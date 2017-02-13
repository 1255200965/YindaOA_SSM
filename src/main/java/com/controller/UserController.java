package com.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ddSdk.auth.AuthHelper;
import com.model.YoUserinfosalary;
import com.model.YoUserinfosalaryExample;
import com.service.ISalaryService;
import com.service.IUserInfoSalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.IUserService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by ma on 2016/10/13.
 */
    @Controller
    @RequestMapping("/user")
    public class UserController {
        @Autowired
        private IUserInfoSalaryService salaryService;
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
    //工资明细
        @RequestMapping("/phone-details.do")
        public ModelAndView PhoneDetails(String userid, String date){
            ModelAndView mav = new ModelAndView();
            YoUserinfosalaryExample example = new YoUserinfosalaryExample();
            YoUserinfosalaryExample.Criteria criteria1 = example.createCriteria();
            if (date!=null) criteria1.andSalarydateEqualTo(date);
            if (userid!=null) criteria1.andUseridEqualTo(userid);
            List<YoUserinfosalary> query = salaryService.selectByExample(example);

            if ("2017-01".equals(date)){
               query = salaryService.search_Jan_salary(userid,date);
            }
            if (query.size()>0){
                mav.addObject("list", query.get(0));
            } else {
                mav.addObject("list", new YoUserinfosalary());
            }

            mav.setViewName("phone/phone-details");
            mav.addObject("userid", userid);
            mav.addObject("date",date);
            mav.setViewName("/dd/details");
            return mav;
        }



    }

