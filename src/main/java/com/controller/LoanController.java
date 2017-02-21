package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.model.YoAdvance;
import com.model.YoLoan;
import com.service.IAdvanceService;
import com.service.ILoanService;
import com.service.IOrderService;
import com.util.GlobalConstant;
/**
 * 冲借款controller
 * @author mawei
 *
 */

@Controller
@RequestMapping("/loan")
public class LoanController {
	@Autowired
	private IAdvanceService advanceService;
	@Autowired
	private ILoanService loanService;
	@Autowired
	private IOrderService orderService;
	
	
	/**
	 * 冲借款操作界面
	 * @param request
	 * @return
	 */
	@RequestMapping("/toLoan_operation.do")
	public ModelAndView loanGetList(HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView();
		List<YoAdvance> advanceList = advanceService.selectByStaffId((String) request.getSession().getAttribute(GlobalConstant.user_staffId));
		 //部门信息
	    List<String> depList = orderService.selectAllDepartment();
	    mav.addObject("depList", depList);
    	mav.addObject("advanceList", advanceList);
		mav.setViewName("loan/loan_operation");
		return mav;	
	}
	/**
	 * 发起冲借款--单条
	 * @param approveNo
	 * @return
	 */
	@RequestMapping("/startALoan.do")
	public @ResponseBody String startALoan(String approveNo){
		
		try{
				//根据审批编号找到对应的预付款记录
			YoAdvance advance = advanceService.selectByapproveNo(approveNo);
				//更新预付款冲借款状态记录为已做冲借款
			//advance.setOperationStatus("已做冲借款");
			advanceService.updateSelective(advance);
				//根据预付款记录生成对应的冲借款信息
			YoLoan loan = loanService.construct(advance);
			    //保存冲借款信息
			loanService.save(loan);
			
			return "success";
		}catch(Exception e){
			
			return "fail";
		}	
	}
	/**
	 * 冲借款展示界面跳转
	 * @return
	 */
	@RequestMapping("/toLoan_getList.do")
	public ModelAndView loanShow(YoLoan loan){
		ModelAndView mav = new ModelAndView();
		List<YoLoan> loanList =loanService.search(loan); 
		 //部门信息
	    List<String> depList = orderService.selectAllDepartment();
	    mav.addObject("depList", depList);
		mav.addObject("loan",loan);
		mav.addObject("loanList", loanList);
		mav.setViewName("loan/loan_getList");
		return mav;
	}
	/**
	 * 冲借款导出
	 */
	@RequestMapping("/downLoad.do")
	public void  downLoad(HttpServletRequest request,HttpServletResponse response,
			YoLoan loan){
		
		List<YoLoan> loanList = loanService.searchForExport(loan);
		
		System.out.println("导出信息"+loanList.toString()+"=="+loanList.size());
		String []excelHeader={"审批编号","标题","审批状态","审批结果","审批发起时间","审批完成时间","发起人工号",
				"发起人姓名","发起人部门","历史审批人姓名","审批记录","当前处理人姓名","审批耗时","借款时间",
				"借款用途大类","借款用途小类","借款金额","收款人","开户银行","开户支行","银行账号","借款原因","其他"};
		loanService.advanceExport(loanList,excelHeader,response);
		
	}
}
