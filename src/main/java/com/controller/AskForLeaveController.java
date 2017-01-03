package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.AskForLeave;
import com.model.AskForLeaveExample;
import com.service.IAskLeaveService;

@Controller
public class AskForLeaveController {
	@Autowired
	private IAskLeaveService iAskLeaveService;
	
	@RequestMapping("/toAskForLeave.do")
	public ModelAndView toAskForLeave(HttpServletRequest request,AskForLeave askForLeave){
		ModelAndView mav = new ModelAndView();
		
		/*AskForLeave askForLeave2 = new AskForLeave();
		askForLeave2.setYoAskStaffName(askForLeave.getYoAskStaffName());
		askForLeave2.setYoAskStaffId(askForLeave.getYoAskStaffId());
		askForLeave2.setYoAskStaffDepart(askForLeave.getYoAskStaffDepart());*/
		List<AskForLeave> askForLeaveList = iAskLeaveService.selectByPropertities(askForLeave);
		mav.addObject("askForLeave2",askForLeave);
		mav.addObject("askForLeaveList", askForLeaveList);
		mav.setViewName("askforleave");
		return mav;
	}
}
