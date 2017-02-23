package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.util.GlobalConstant;
/**
 * 报销审批+报销入口相关代码---网页版审批后台
 * @author mawei
 *
 */
@Controller
@RequestMapping("/expenseApplyApprove")
public class ExpenseApproveInPC {
	/**
	 * 钉钉PC端审批入口
	 * @return
	 */
	@RequestMapping("/goApproveInPC.do")
	public ModelAndView goApproveInPC(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("expense/approveInMicroApp/approve_record");
		return mav;
	}
}
