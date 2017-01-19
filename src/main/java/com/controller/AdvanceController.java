package com.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.model.YoAdvance;
import com.service.IAdvanceService;
import com.service.IDepartmentService;
import com.service.IOrderService;
/**
 * 预付款
 * @author mawei
 *
 */
@Controller
@RequestMapping("/advance")
public class AdvanceController {
	
	@Autowired
	private IAdvanceService advanceService;
	@Autowired
	private IOrderService orderService;
	
	 
    /**
     * 预付款excel上传界面跳转
     * @return
     */
	@RequestMapping("/toUpload.do")
	public String toUpload(){
		
		return "advance/upload_advance";
	}
	
	/**
	 * 预付款上传功能具体实现
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/upload.do")
	public ModelAndView upload(MultipartFile file) throws IOException{
		
		ModelAndView mav = new ModelAndView();
		List<String[]> errorList = null;
		InputStream is = null;
		try {
			is = file.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		errorList=advanceService.readExcel(is);
		mav.addObject("errorList", errorList);
		mav.setViewName("advance/upload_result");
		
		return mav;
	}
	
	/**
	 * 预付款展示界面跳转
	 * @param request
	 * @return
	 */
	@RequestMapping("/toAdvance_getList.do")
	public ModelAndView advanceGetList(HttpServletRequest request,YoAdvance advance){
		System.out.println(advance.toString());
		ModelAndView mav = new ModelAndView();
		YoAdvance advance2 = advance;
		List<YoAdvance> advanceList = advanceService.search(advance);
	
		mav.addObject("advanceList", advanceList);		
		//部门信息
		List<String> depList = orderService.selectAllDepartment();
		mav.addObject("advance2", advance2);
		mav.addObject("depList", depList);
		mav.setViewName("advance/advance_getList");
		return mav;
	}
	/**
	 * 预付款导出
	 * @param request
	 * @param response
	 * @param advance
	 */
	@RequestMapping("/downLoad.do")
	public void  downLoad(HttpServletRequest request,HttpServletResponse response,
			YoAdvance advance){
		
		List<YoAdvance> advanceList = advanceService.searchForExport(advance);
		
		System.out.println("导出信息"+advanceList.toString()+"=="+advanceList.size());
		String []excelHeader={"审批编号","标题","审批状态","审批结果","审批发起时间","审批完成时间","发起人工号",
				"发起人姓名","发起人部门","历史审批人姓名","审批记录","当前处理人姓名","审批耗时","借款时间",
				"借款用途大类","借款用途小类","借款金额","收款人","开户银行","开户支行","银行账号","借款原因","其他"};
		advanceService.advanceExport(advanceList,excelHeader,response);
		
	}
}
