package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.model.ExpenseApplySubway;
import com.service.IExpenseApplySubwayService;
import com.util.DDSendMessageUtil;
import com.util.DateUtil;
import com.util.GlobalConstant;

@Controller
@RequestMapping("/expenseApplyApprove")
public class ExpenseSubwayController {
	@Autowired
	private IExpenseApplySubwayService expenseApplySubwayService;
	@Autowired
	private DDSendMessageUtil ddSendMessageUtil;
	 
  /**
   * 公交地铁报销-申报
   * @return
   */
    @RequestMapping("/toExpense_subway.do")
    public ModelAndView toExpense_subway(){
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("expense/expense_apply/expense_subway");
    	return mav;
    }
    /**
     * 公交地铁报销-新增数据保存
     * @param request
     * @param subwayApply
     * @return
     */
    @RequestMapping("/toExpense_subway_save.do")
    public @ResponseBody String toExpense_subway_save(HttpServletRequest request,ExpenseApplySubway subwayApply){
    /******添加当前报销人信息*****/
try{ subwayApply.setAskStaffId((String) request.getSession().getAttribute(GlobalConstant.user_staffId));
     subwayApply.setAskStaffUserId((String) request.getSession().getAttribute(GlobalConstant.user_staff_user_id));
    subwayApply.setAskStaffName((String) request.getSession().getAttribute(GlobalConstant.user_name));
    subwayApply.setAskStaffDepart((String) request.getSession().getAttribute(GlobalConstant.user_department)); 	
   /******添加当前报销人信息*****/
    subwayApply.setApproveStatus("待审核");
    subwayApply.setSubmitTime(DateUtil.getCurrentDate());
    /****被报销人的各级审批人****/
	List<String> approverList=ddSendMessageUtil.getApprovers(subwayApply.getAskStaffUserId());
	String toUser=null;
	//对于挂职在一级部门的员工
	if(approverList.size() >1){
	toUser=approverList.get(1);
	subwayApply.setApproverOrder(approverList.get(1)+"|"+approverList.get(0));
	subwayApply.setApproverNow(approverList.get(1));
	}else{//对于挂职在二级部门下的员工
		toUser=approverList.get(0);
		subwayApply.setApproverOrder(approverList.get(0));
		subwayApply.setApproverNow(approverList.get(0));
	}
	/****被报销人的各级审批人****/
	int id = expenseApplySubwayService.saveOrUpdate(subwayApply);
	 //推送消息
//	DDSendMessageUtil.sendMessageSubway(subwayApply, id, toUser);
	return "success";
  }catch(Exception e){
	 return "fail";
  }
}
    /**
     * 地铁公交报销-详情查看
     * @param request
     * @param id
     * @return
     */
    @RequestMapping("/toExpense_view_subway.do")
    public ModelAndView toExpense_view_subway(HttpServletRequest request,int id){
    	ModelAndView mav = new ModelAndView();
    	ExpenseApplySubway subwayApply = expenseApplySubwayService.selectByPrimarykey(id);
    	//获取审批人顺序-当前审批人
    	expenseApplySubwayService.constructApprovers(subwayApply);
    	String flag=null;
    		//如果审批状态是驳回的话,允许用户再次编辑
    	if("驳回".equals(subwayApply.getApproveStatus())){
    		flag="show";
    	}else{
    		flag="hide";
    	}
    	mav.addObject("flag",flag);
    	mav.addObject("subwayApply", subwayApply);
    	mav.setViewName("expense/expense_apply/view/expense_view_subway");
    	return mav;
    }
    /**
     * 地铁公交报销审批界面跳转
     * @param id
     * @param manager
     * @return
     */
    @RequestMapping("/toExpense_subway_approve.do")
    public ModelAndView toExpense_subway_approve(int id , String manager){
    	ModelAndView mav = new ModelAndView();
    	//找出该条报销记录
    	ExpenseApplySubway subwayApply=expenseApplySubwayService.selectByPrimarykey(id);
    	String flag=null;
    	if(! manager.equals(subwayApply.getApproverNow())){
    		flag="hide";
    	}
    	mav.addObject("flag", flag);
    	mav.addObject("subwayApply", subwayApply);
    	mav.setViewName("expense/approve_subway");
    	return mav;
    }
    //审核后数据的保存
    @RequestMapping("/expense_subway_approve_update.do")
    public @ResponseBody String  expense_subway_approve_update(int id,String result,String refuseReason){
    	//根据ID找到这条报销记录
    	try{	
    		ExpenseApplySubway subwayApply=expenseApplySubwayService.selectByPrimarykey(id);
    		if("agree".equals(result)){//审批同意操作
    			subwayApply=expenseApplySubwayService.sendTONextManager(subwayApply);
    		}else if("disagree".equals(result)){//驳回操作
    			subwayApply=expenseApplySubwayService.refuseOption(subwayApply);
    			subwayApply.setRefuseReason(refuseReason);
    		}
    		expenseApplySubwayService.saveOrUpdate(subwayApply);
    		return "success";
    	}catch(Exception e){
    		return "fail";
    	}
    }
    //地铁公交报销历史信息查看
    @RequestMapping("/toExpense_history_subway.do")
    public ModelAndView subwayHistory(HttpServletRequest request){
    	ModelAndView mav = new ModelAndView();
    	//员工工号
    	String staffId = (String) request.getSession().getAttribute(GlobalConstant.user_staffId);
    	List<ExpenseApplySubway> subwayList = expenseApplySubwayService.selectByStaffId(staffId);
    	mav.addObject("subwayList", subwayList);
    	mav.setViewName("expense/expense_apply/history/expense_history_subway");
    	return mav;
    }
    /**
     * 驳回后的报销--删除
     * @param id
     * @return
     */
    @RequestMapping("/delete_subway.do")
    public @ResponseBody String delete(int id){
    	return expenseApplySubwayService.delete(id);
    }
    /**
     * 公交地铁报销-驳回后再次编辑
     * @param request
     * @param subwayApply
     * @return
     */
    @RequestMapping("/toExpense_subway_save_again.do")
    public @ResponseBody String toExpense_subway_save_again(HttpServletRequest request,ExpenseApplySubway subwayApply){
    /******添加当前报销人信息*****/
try{ subwayApply.setAskStaffId((String) request.getSession().getAttribute(GlobalConstant.user_staffId));
     subwayApply.setAskStaffUserId((String) request.getSession().getAttribute(GlobalConstant.user_staff_user_id));
    subwayApply.setAskStaffName((String) request.getSession().getAttribute(GlobalConstant.user_name));
    subwayApply.setAskStaffDepart((String) request.getSession().getAttribute(GlobalConstant.user_department)); 	
   /******添加当前报销人信息*****/
    subwayApply.setApproveStatus("待审核");
    subwayApply.setSubmitTime(DateUtil.getCurrentDate());
    /****被报销人的各级审批人****/
	List<String> approverList=ddSendMessageUtil.getApprovers(subwayApply.getAskStaffUserId());
	String toUser=null;
	//对于挂职在一级部门的员工
	if(approverList.size() >1){
	toUser=approverList.get(1);
	subwayApply.setApproverOrder(approverList.get(1)+"|"+approverList.get(0));
	subwayApply.setApproverNow(approverList.get(1));
	}else{//对于挂职在二级部门下的员工
		toUser=approverList.get(0);
		subwayApply.setApproverOrder(approverList.get(0));
		subwayApply.setApproverNow(approverList.get(0));
	}
	/****被报销人的各级审批人****/
	int id = expenseApplySubwayService.saveOrUpdate(subwayApply);
	 //推送消息
//	DDSendMessageUtil.sendMessageSubway(subwayApply, id, toUser);
	return "success";
  }catch(Exception e){
	 return "fail";
  }
}
}
