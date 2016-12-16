package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.YoSocialSecurityInfo;
import com.service.ISocialSecurityService;

@Controller
public class SocialSecurityController {
	@Autowired
	private ISocialSecurityService socialSecurityService;
	@RequestMapping("/toSocialSecurity.do")
	public ModelAndView toSocailSecurity(HttpServletRequest request,YoSocialSecurityInfo socialSecurity){
		ModelAndView mav = new ModelAndView();
		YoSocialSecurityInfo socialSecurity2=socialSecurity;
		List<YoSocialSecurityInfo> socialSecurityList=socialSecurityService.selectByPropertities(socialSecurity);
		mav.addObject("socialSecurityList", socialSecurityList);
		mav.addObject("socialSecurity2", socialSecurity2);
		mav.setViewName("socialSecurity");
		return mav;
	}
}
