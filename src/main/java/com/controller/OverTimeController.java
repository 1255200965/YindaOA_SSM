package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.YoAdvance;
import com.model.YoOvertime;
import com.service.IOrderService;
import com.service.IOvertimeService;

@Controller
public class OverTimeController {
	@Autowired
	private IOvertimeService overTimeService;
	@Autowired
	private IOrderService orderService;
	@RequestMapping("/toOverTime.do")
	public ModelAndView toOverWork(HttpServletRequest request,YoOvertime overTime){
		ModelAndView mav = new ModelAndView();
		YoOvertime overTime2= overTime;
		List<YoOvertime> overTimeList =overTimeService.selectByProperties(overTime);
		//部门信息
//	    List<String> depList = orderService.s;
//	    mav.addObject("depList", depList);
		mav.addObject("overTime2",overTime2);
		mav.addObject("overTimeList", overTimeList);
		mav.setViewName("overtime/overtime_getList");
		return mav;
	}
	@RequestMapping("/overtime/download.do")
	public void downLoad(HttpServletRequest request,HttpServletResponse response,
			YoOvertime overTime){
			
		List<YoOvertime> overTimeList =overTimeService.selectByProperties(overTime);
			System.out.println("导出信息"+overTimeList.size());
			String []excelHeader={"审批编号","标题","审批状态","审批结果","审批发起时间","审批完成时间","发起人工号",
					"发起人姓名","发起人部门","历史审批人姓名","审批记录","当前处理人姓名","审批耗时","加班类型",
					"开始时间","结束时间","加班时长(小时)","加班原因","备注","加班地点"};
			overTimeService.overtimeExport(overTimeList,excelHeader,response);
			
		}
}

