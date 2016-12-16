package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.model.StaffInfo;
import com.service.IStaffInfoService;
import com.util.GlobalConstant;

@Controller
public class LoginController {
  @Autowired 
  public IStaffInfoService staffInfoService;
  /**
   * 登录验证
   * @param request
   * @param name
   * @param password
   * @return
   */
  @RequestMapping("/login.do")
  @ResponseBody
  public String login(HttpServletRequest request,String name,String password){
	  StaffInfo staffInfo=new StaffInfo();
	  staffInfo.setStaffId(name);
	 List<StaffInfo> staffList = staffInfoService.searchStaffInfoByEntity(staffInfo);
	 if(staffList == null || staffList.isEmpty()){
		 return "fail";
	 }else{
		 staffInfo = staffList.get(0);
		 request.getSession().setAttribute(GlobalConstant.user_department,staffInfo.getDepartment());
		 request.getSession().setAttribute(GlobalConstant.user_name, staffInfo.getName());
		 request.getSession().setAttribute(GlobalConstant.user_staffId,staffInfo.getStaffId());
		 return "success";
	 }
  }
  /**
   * 登录成功界面跳转
   * @return
   */
  @RequestMapping("/loginSuccess.do")
  public ModelAndView loginSuccess(){
	  ModelAndView mav =new ModelAndView();
	  mav.setViewName("UserInfo");
	  return mav;
  }
}
