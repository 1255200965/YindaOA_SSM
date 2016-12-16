package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.YoOvertime;
import com.service.IOvertimeService;

@Controller
public class OverTimeController {
	@Autowired
	private IOvertimeService overTimeService;
	@RequestMapping("/toOverTime.do")
	public ModelAndView toOverWork(HttpServletRequest request,YoOvertime overTime){
		ModelAndView mav = new ModelAndView();
		YoOvertime overTime2= overTime;
		List<YoOvertime> overTimeList =overTimeService.selectByProperties(overTime);
		mav.addObject("overTime2",overTime2);
		mav.addObject("overTimeList", overTimeList);
		mav.setViewName("overtime");
		return mav;
	}
}
