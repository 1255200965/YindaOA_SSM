package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.model.ExpenseApplayHotel;
import com.service.IExpenseApplayHotelService;
import com.util.DDSendMessageUtil;
import com.util.DateUtil;
import com.util.FileUploadUtil;
import com.util.GlobalConstant;
/**
 * 住宿费报销功能
 * @author mawei
 *
 */
@Controller
public class ExpenseHotelController {
	@Autowired
	private IExpenseApplayHotelService expenseApplayHotelService;
	@Autowired
	private DDSendMessageUtil ddSendMessageUtil;
	 
   /**
    * 住宿报销-新增界面跳转
    * @param request
    * @return
    */
    @RequestMapping("/toExpense_hotel.do")
    public ModelAndView toExpense_hotel(HttpServletRequest request){
    	ModelAndView mav =new ModelAndView();
    	mav.setViewName("expense/expense_apply/expense_hotel");
    	return mav;
    }
    /**
     * 住宿报销--历史信息查看
     * @param request
     * @return
     */
    @RequestMapping("/toExpense_history_hotel.do")
    public ModelAndView toExpense_history_hotel(HttpServletRequest request){
    	ModelAndView mav = new ModelAndView();
    	String staffId=(String) request.getSession().getAttribute(GlobalConstant.user_staffId);
    	List<ExpenseApplayHotel> expenseApplayHotelList = expenseApplayHotelService.selectByStaffId(staffId);
    	mav.addObject("expenseApplayHotelList", expenseApplayHotelList);
    	mav.setViewName("expense/expense_apply/history/expense_history_hotel");
    	return mav;
    }
    /**
     * 住宿报销--详情查看
     * @param request
     * @param id
     * @return
     */
    @RequestMapping("/toExpense_view_hotel.do")
    public ModelAndView toExpense_view_hotel(HttpServletRequest request,int id){
    	ModelAndView mav = new ModelAndView();
    	ExpenseApplayHotel expenseApplayHotel=expenseApplayHotelService.selectById(id);
    	//获取审批人顺序-当前审批人
    	expenseApplayHotelService.constructApprovers(expenseApplayHotel);
    	String flag=null;
    		//如果审批状态是驳回的话,允许用户再次编辑
    	if("驳回".equals(expenseApplayHotel.getApplayStatus())){
    		flag="show";
    	}else{
    		flag="hide";
    	}
    	mav.addObject("flag",flag);
    	mav.addObject("expenseApplayHotel", expenseApplayHotel);
    	mav.setViewName("expense/expense_apply/view/expense_view_hotel");
    	return mav;
    }
    /**
     * 住宿报销-数据保存
     * @param request
     * @param expenseApplayHotel
     * @return
     */
    @RequestMapping("/toExpense_hotel_save.do")
    public String toExpense_hotel_save(HttpServletRequest request,ExpenseApplayHotel expenseApplayHotel){
    	int id = 0;
    	//重置报销信息为待审核状态
    	expenseApplayHotel.setApplayStatus("待审核");
    	expenseApplayHotel.setSubmitTime(DateUtil.getCurrentDate());
    	/*记录当前报销人信息*/
    	expenseApplayHotel.setStaffId((String) request.getSession().getAttribute(GlobalConstant.user_staffId));
    	expenseApplayHotel.setStaffName((String) request.getSession().getAttribute(GlobalConstant.user_name));
    	expenseApplayHotel.setStaffDepart((String) request.getSession().getAttribute(GlobalConstant.user_department));
    	expenseApplayHotel.setStaffUserId((String) request.getSession().getAttribute(GlobalConstant.user_staff_user_id));
    	/*记录当前报销人信息*/
    	try{
    		String newFileName = FileUploadUtil.imageUpload(request);
			 //数据库中记录图片存放位置信息
			expenseApplayHotel.setImageUrl(newFileName);
			
			/****被报销人的各级审批人****/
			List<String> approverList=ddSendMessageUtil.getApprovers(expenseApplayHotel.getStaffUserId());
			String toUser=null;
			//对于挂职在一级部门的员工
			if(approverList.size() >1){
			toUser=approverList.get(1);
			expenseApplayHotel.setApproverOrder(approverList.get(1)+"|"+approverList.get(0)+"|10548"+"|31017"+"|10272");
			expenseApplayHotel.setApproverNow(approverList.get(1));
			}else{//对于挂职在二级部门下的员工
				toUser=approverList.get(0);
				expenseApplayHotel.setApproverOrder(approverList.get(0)+"|10548"+"|31017"+"|10272");
				expenseApplayHotel.setApproverNow(approverList.get(0));
			}
			/****被报销人的各级审批人****/
    		id =expenseApplayHotelService.saveOrUpdate(expenseApplayHotel);
            //推送消息
//    		DDSendMessageUtil.sendMessageHotel(expenseApplayHotel, id, toUser);
           
    		return "redirect:toExpense_history_hotel.do";
    	}catch(Exception e){
    		return "redirect:toExpense_hotel.do?data=fail";
    	}
    
    }
   /**
    * 差旅报销--审批
    * @param request
    * @param id
    * @param manager
    * @return
    */
    @RequestMapping("/to_approve_hotel.do")
    public ModelAndView to_approve_hotel(HttpServletRequest request,int id,String manager){
    	ModelAndView mav = new ModelAndView();
    	ExpenseApplayHotel expenseApplayHotel =expenseApplayHotelService.selectById(id);
    	String flag=null;
    	
    	if(!manager.equals(expenseApplayHotel.getApproverNow())){
    		flag="hide";
    	}
    	mav.addObject("flag", flag);
    	mav.addObject("expenseApplayHotel",expenseApplayHotel);
    	mav.setViewName("expense/approve_hotel");
    	return mav;
    }
    @RequestMapping("/approve_hotel_update.do")
    @ResponseBody
    public int approve_hotel_update(HttpServletRequest request,int id,String result){
    	//查询该条报销记录
    	ExpenseApplayHotel expenseApplayHotel = expenseApplayHotelService.selectById(id);
    	if("agree".equals(result)){
    		//各级管理员审核报销
    		expenseApplayHotel = expenseApplayHotelService.sendTONextManager(expenseApplayHotel);
    	}else if("disagree".equals(result)){
    		expenseApplayHotel= expenseApplayHotelService.refuseOption(expenseApplayHotel);
    	}
    	return expenseApplayHotelService.saveOrUpdate(expenseApplayHotel);
    }
    /**
     * 驳回后的报销--删除
     * @param id
     * @return
     */
    @RequestMapping("/delete_hotel.do")
    public @ResponseBody String delete(int id){
    	return expenseApplayHotelService.delete(id);
    }
    /**
     * 住宿报销-驳回重新编辑后，数据保存
     * @param request
     * @param expenseApplayHotel
     * @return
     */
    @RequestMapping("/toExpense_hotel_save_again.do")
    public @ResponseBody String toExpense_hotel_save_again(HttpServletRequest request,ExpenseApplayHotel expenseApplayHotel){
    	int id = 0;
    	//重置报销信息为待审核状态
    	expenseApplayHotel.setApplayStatus("待审核");
    	expenseApplayHotel.setSubmitTime(DateUtil.getCurrentDate());
    	/*记录当前报销人信息*/
    	expenseApplayHotel.setStaffId((String) request.getSession().getAttribute(GlobalConstant.user_staffId));
    	expenseApplayHotel.setStaffName((String) request.getSession().getAttribute(GlobalConstant.user_name));
    	expenseApplayHotel.setStaffDepart((String) request.getSession().getAttribute(GlobalConstant.user_department));
    	expenseApplayHotel.setStaffUserId((String) request.getSession().getAttribute(GlobalConstant.user_staff_user_id));
    	/*记录当前报销人信息*/
    	try{
			
			/****被报销人的各级审批人****/
			List<String> approverList=ddSendMessageUtil.getApprovers(expenseApplayHotel.getStaffUserId());
			String toUser=null;
			//对于挂职在一级部门的员工
			if(approverList.size() >1){
			toUser=approverList.get(1);
			expenseApplayHotel.setApproverOrder(approverList.get(1)+"|"+approverList.get(0));
			expenseApplayHotel.setApproverNow(approverList.get(1));
			}else{//对于挂职在二级部门下的员工
				toUser=approverList.get(0);
				expenseApplayHotel.setApproverOrder(approverList.get(0));
				expenseApplayHotel.setApproverNow(approverList.get(0));
			}
			/****被报销人的各级审批人****/
    		id =expenseApplayHotelService.saveOrUpdate(expenseApplayHotel);
            //推送消息
//    		DDSendMessageUtil.sendMessageHotel(expenseApplayHotel, id, toUser);
           
    		return "success";
    	}catch(Exception e){
    		return "fail";
    	}
    
    }
}
