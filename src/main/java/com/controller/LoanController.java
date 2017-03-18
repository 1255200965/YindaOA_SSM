package com.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.model.YoAdvance;
import com.model.YoLoan;
import com.service.IAdvanceService;
import com.service.ILoanService;
import com.service.IOrderService;
import com.util.ExpenseApplyResources;
import com.util.GlobalConstant;
import com.util.Picture;
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
	 * 预付款做冲借款界面跳转--列表展示
	 * @param request
	 * @return
	 */
	@RequestMapping("/toLoan_operation.do")
	public ModelAndView loanGetList(HttpServletRequest request,String staffName,String staffId,
			String startTime,String endTime){
		
		ModelAndView mav = new ModelAndView();
		/*request.getSession().setAttribute(GlobalConstant.user_staffId,"19770");*/
		staffId=(String) request.getSession().getAttribute(GlobalConstant.user_staffId);
		//留权限给马天立
		if("16360".equals(staffId)){
			staffId=null;
		}
			//查询当前登录人已同意并经财务导出的预付款信息
		List<YoAdvance> advanceList = advanceService.selectExported(staffName,staffId, startTime, endTime);
    	mav.addObject("staffName", staffName);
    	mav.addObject("staffId",staffId);
    	mav.addObject("startTime",startTime);
    	mav.addObject("endTime", endTime);
		mav.addObject("advanceList", advanceList);
		mav.setViewName("loan/loan_operation");
		return mav;	
	}
	/**
	 * 发起冲借款--单条--界面跳转
	 * @param approveNo 审批编号
	 * @param approveRepayment 返还金额
	 * @param approveInvoice 发票金额
	 * @return
	 */
	@RequestMapping("/goStartALoan.do")
	public ModelAndView startALoan(String approveNo){
			ModelAndView mav = new ModelAndView();
				//根据审批编号找到对应的预付款记录
			YoAdvance advance = advanceService.selectByapproveNo(approveNo);
		    mav.addObject("advance", advance);
			mav.setViewName("loan/startaloan");
			return mav;
	}
	/**
	 * 发起冲借款--单条--数据保存
	 * @param approveNo 审批编号
	 * @param approveRepayment 返还金额
	 * @param approveInvoice 发票金额
	 * @return
	 */
	@RequestMapping("/startALoan.do")
	public @ResponseBody String startALoan2(HttpServletRequest request , String approveNo,String approveRepayment,
			String approveInvoice,String imageUrl){
		System.out.println("发起冲预付===发票金额"+approveInvoice+"===返还金额"+approveRepayment);
		try{
				//根据审批编号找到对应的预付款记录
			YoAdvance advance = advanceService.selectByapproveNo(approveNo);
				//冲借款状态信息
			String loanStatus=advance.getLoanStatus();
				//更新预付款冲借款状态为待审核
			advance.setLoanStatus("待审核");
				//更行预付款信息
			advanceService.updateLoanStatus(advance);
				//根据预付款记录生成对应的冲借款信息--置冲借款审批结果为待审批
			YoLoan loan = loanService.construct(advance,approveInvoice,approveRepayment,imageUrl);
			loan.setImageUrl(imageUrl);
				//如果是驳回重新提交的数据--此处缺少一个删除原先图片的方法
			if("驳回".equals(loanStatus)){
				loanService.updateByPrimarykey(loan);
			}else{
			    //保存冲借款信息
			loanService.save(loan);
			}
			return "success";
		}catch(Exception e){
			e.printStackTrace();
			return "fail";
		}	
	}
	
	/**
	 * fileUpload图片上传后台
	 * @param mFiles
	 * @param request
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping(value="/upLoadImage.do",method=RequestMethod.POST)
	public @ResponseBody Picture upload(@RequestParam(value="mFiles")MultipartFile []mFiles,HttpServletRequest request) throws IllegalStateException, IOException{
		try{ 
			System.out.println("照片上传");
			Picture pic = new Picture();
			String path=null;
			for(MultipartFile mFile:mFiles){
			/*request.getSession().setAttribute(GlobalConstant.user_name, "谭英花");*/
		   	   //原始图片名称
		   	String originalName=mFile.getOriginalFilename();
		   	System.out.println("上传的文件名为"+originalName+mFile.getSize());
		   	  		//图片存储的物理根路径
			//String basePath ="/alidata/server/tomcat-7.0.54/webapps/YindaOAImageUpload/LoanImage/";
		   	String basePath="E://";
				  //新的图片名称--命名形式为 姓名+_+年月日+图片原来的名称
			String newFileName=request.getSession().getAttribute(GlobalConstant.user_name)+"_"
					+getDatePath()+originalName;
				  //新图片
		   	File file = new File(basePath+newFileName);  
		   	      //将mFile文件的内容写入file
			mFile.transferTo(file);	
			path=newFileName;
			System.out.println("上传后的文件名为"+newFileName);
		}
			pic.setPath(path);
			return pic;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 获取时间路径
	 * @return
	 */
    private String getDatePath(){
    	 //年月日
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    	return sdf.format(new Date());
    }
    /**
	 * 冲借款明细查看
	 * @param approveNo
	 * @return
	 */
	@RequestMapping("/toLoanView.do")
	public ModelAndView toLoanView(String approveNo){
		
		ModelAndView mav = new ModelAndView();
		YoLoan loan = loanService.selectByApproveNo(approveNo);
		mav.addObject("loan", loan);
		mav.setViewName("loan/loan_view");
		return mav;
	}
	/**
	 * 冲借款展示界面跳转--列表展示
	 * @return
	 */
	@RequestMapping("/toLoan_approveGetList.do")
	public ModelAndView loanShow(YoLoan loan){
		ModelAndView mav = new ModelAndView();
		List<YoLoan> loanList =loanService.search(loan); 
		 //部门信息
	    List<String> depList = orderService.selectAllDepartment();
	    mav.addObject("depList", depList);
		mav.addObject("loan",loan);
		mav.addObject("loanList", loanList);
		mav.setViewName("loan/loan_approve_getlist");
		return mav;
	}
	/**
	 * 跳转进入财务审核界面
	 * @param approveNo
	 * @return
	 */
	@RequestMapping("/toLoanApprove.do")
	public ModelAndView toLoanOperation(String approveNo){
		
		ModelAndView mav = new ModelAndView();
		YoLoan loan = loanService.selectByApproveNo(approveNo);
		mav.addObject("loan", loan);
		mav.setViewName("loan/loan_approve");
		return mav;
	}
	/**
	 * 财务审核操作
	 * @param approveNo
	 * @param operationStatus
	 * @param operationReason
	 * @return
	 */
	@RequestMapping("/approve.do")
	public @ResponseBody String loanOperation(HttpServletRequest request,String approveNo,String approveStatus
			,String approveAdvice){
		String staffId=(String) request.getSession().getAttribute(GlobalConstant.user_staffId);
		if("10548".equals(staffId)){
		try{
			YoAdvance advance = new YoAdvance();
			advance.setLoanStatus(approveStatus);
			advance.setApproveNo(approveNo);
			advanceService.updateLoanStatus(advance);
			YoLoan loan = new YoLoan();
			loan.setApproveNo(approveNo);
			loan.setApproveStatus(approveStatus);;
			loan.setApproveAdvice(approveAdvice);
			loanService.updateApproveMessage(loan);
			return "success";
		}catch(Exception e){
			return "fail";
		}
		}else{
			return "noPermission";
		}
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
