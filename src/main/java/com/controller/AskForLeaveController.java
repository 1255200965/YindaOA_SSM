package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.AskForLeave;
import com.model.AskForLeaveExample;
import com.model.YoAdvance;
import com.service.IAskLeaveService;
import com.service.IOrderService;

@Controller
public class AskForLeaveController {
	@Autowired
	private IAskLeaveService iAskLeaveService;
	@Autowired
	private IOrderService orderService;;
	
	@RequestMapping("/toAskForLeave.do")
	public ModelAndView toAskForLeave(HttpServletRequest request,AskForLeave askForLeave){
		ModelAndView mav = new ModelAndView();
		
		System.out.println(askForLeave.toString());
		List<AskForLeave> askForLeaveList = iAskLeaveService.selectByPropertities(askForLeave);
		//部门信息
	    List<String> depList = orderService.selectAllDepartment();
	    mav.addObject("depList", depList);
		mav.addObject("askForLeave2",askForLeave);
		mav.addObject("askForLeaveList", askForLeaveList);
		mav.setViewName("askforleave/askforleave");
		return mav;
	}
	@RequestMapping("/askForLeaveDownload.do")
	public void downLoad(HttpServletRequest Request ,AskForLeave askForLeave,
			HttpServletResponse response){
		
		List<AskForLeave> askForLeaveList = iAskLeaveService.selectByPropertities(askForLeave);
		String []excelHeader={"审批编号","标题","审批状态","审批结果","审批发起时间","审批完成时间","发起人工号",
								"发起人姓名","发起人部门","历史审批人姓名","审批记录","当前处理人姓名","审批耗时",
								"请假类型","开始日期","开始时间","结束日期","结束时间","请假天数","请假事由","图片"};			
		iAskLeaveService.askLeaveExport(askForLeaveList, excelHeader, response);
	}
}
