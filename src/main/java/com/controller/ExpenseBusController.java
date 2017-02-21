package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.model.ExpenseApplayBus;
import com.service.IExpenseApplayBusService;
import com.util.DDSendMessageUtil;
import com.util.DateUtil;
import com.util.FileUploadUtil;
import com.util.GlobalConstant;

/**
 * 大巴车报销功能代码块
 * @author mawei
 *
 */
@Controller
public class ExpenseBusController {
	
	@Autowired
	private IExpenseApplayBusService expenseBusService;
	@Autowired
	private DDSendMessageUtil ddSendMessageUtil;
	/**
     * 大巴车报销--新增--界面跳转
     */
    @RequestMapping("/toExpense_bus.do")
    public ModelAndView toExpense_bus(HttpServletRequest request){
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("expense/expense_apply/expense_bus");
    	return mav;
    }
    /**
     * 大巴车报销--新增--报销信息保存入库
     * @param request
     * @param expenseApplayBus
     * @return
     */
    @RequestMapping("/toExpense_bus_save.do")
    public String toExpense_bus_save(HttpServletRequest request,ExpenseApplayBus expenseApplayBus){
        int id =0;
    	//将新记录的状态记为待审核
    	expenseApplayBus.setApplayStatus("待审核");
    	expenseApplayBus.setSubmitTime(DateUtil.getCurrentDate());
    	/*新增人员信息*/
    	expenseApplayBus.setStaffId((String)request.getSession().getAttribute(GlobalConstant.user_staffId));
    	expenseApplayBus.setStaffName((String)request.getSession().getAttribute(GlobalConstant.user_name));
    	expenseApplayBus.setStaffDepart((String)request.getSession().getAttribute(GlobalConstant.user_department));
    	expenseApplayBus.setStaffUserId((String)request.getSession().getAttribute(GlobalConstant.user_staff_user_id));
    	/*新增人员信息*/
    
    	try {
    		//图片存储
    		String newFileName = FileUploadUtil.imageUpload(request);
			 //数据库中记录图片存放位置信息
			expenseApplayBus.setImageUrl(newFileName);
			/*被报销人的各级审批人*/
			List<String> approverList=ddSendMessageUtil.getApprovers(expenseApplayBus.getStaffUserId());
			String toUser=null;
			//对于挂职在一级部门的员工
			if(approverList.size() >1){
			toUser=approverList.get(1);
			expenseApplayBus.setApproverOrder(approverList.get(1)+"|"+approverList.get(0)+"|10548"+"|31017"+"|10272");
			
			expenseApplayBus.setApproverNow(approverList.get(1));
			}else{//对于挂职在二级部门下的员工
				toUser=approverList.get(0);
				expenseApplayBus.setApproverOrder(approverList.get(0)+"|10548"+"|31017"+"|10272");
				expenseApplayBus.setApproverNow(approverList.get(0));
			}
			/*被报销人的各级审批人*/
			//存储报销信息
			expenseBusService.saveOrUpdate(expenseApplayBus); 
        	//用户新增的申请需要给管理员推送审批消息
//			toUser="07022352451246847";
//        	DDSendMessageUtil.sendMessageBus(expenseApplayBus, id, toUser);
	    	return "redirect:toExpense_history_bus.do";
	    	
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:toExpense_bus.do?data="+"fail";
		}   	
    }
    /**
     * 大巴车报销--新增--拒绝后再次提交
     * @param request
     * @param expenseApplayBus
     * @return
     */
    @RequestMapping("/toExpense_bus_save_again.do")
    public @ResponseBody String toExpense_bus_save_again(HttpServletRequest request,ExpenseApplayBus expenseApplayBus){
    	//将新记录的状态记为待审核
    	expenseApplayBus.setApplayStatus("待审核");
    	expenseApplayBus.setSubmitTime(DateUtil.getCurrentDate());
    	/*新增人员信息*/
    	expenseApplayBus.setStaffId((String)request.getSession().getAttribute(GlobalConstant.user_staffId));
    	expenseApplayBus.setStaffName((String)request.getSession().getAttribute(GlobalConstant.user_name));
    	expenseApplayBus.setStaffDepart((String)request.getSession().getAttribute(GlobalConstant.user_department));
    	expenseApplayBus.setStaffUserId((String)request.getSession().getAttribute(GlobalConstant.user_staff_user_id));
    	/*新增人员信息*/
    
    	try {
			/*被报销人的各级审批人*/
			List<String> approverList=ddSendMessageUtil.getApprovers(expenseApplayBus.getStaffUserId());
			String toUser=null;
			//对于挂职在一级部门的员工
			if(approverList.size() >1){
			toUser=approverList.get(1);
			expenseApplayBus.setApproverOrder(approverList.get(1)+"|"+approverList.get(0)+"|");
			
			expenseApplayBus.setApproverNow(approverList.get(1));
			}else{//对于挂职在二级部门下的员工
				toUser=approverList.get(0);
				expenseApplayBus.setApproverOrder(approverList.get(0));
				expenseApplayBus.setApproverNow(approverList.get(0));
			}
			/*被报销人的各级审批人*/
			//存储报销信息
		    expenseBusService.UpdateByPrimaryKey(expenseApplayBus); 
	    	return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}   	
    }
    /**
     * 大巴车报销历史信息界面跳转
     * @param request
     * @return
     */
    @RequestMapping("/toExpense_history_bus.do")
    public ModelAndView toExpense_history_bus(HttpServletRequest request){
    	ModelAndView mav = new ModelAndView();
    	String staffId =(String) request.getSession().getAttribute(GlobalConstant.user_staffId);
    	List<ExpenseApplayBus> expenseApplayBusList = expenseBusService.selectAllByStaffId(staffId);
		mav.addObject("expenseApplayBusList", expenseApplayBusList);
    	mav.setViewName("expense/expense_apply/history/expense_history_bus");
    	return mav;
    }
    /**
     * 大巴车报销--详情查看
     * @param request
     * @param id
     * @return
     */
    @RequestMapping("/toExpense_view_bus.do")
    public ModelAndView toExpense_bus_view(HttpServletRequest request,int id){
    	ModelAndView mav = new ModelAndView();
    	ExpenseApplayBus expenseApplayBus = expenseBusService.selectById(id);
    	//获取审批人顺序-当前审批人
    	expenseBusService.constructApprovers(expenseApplayBus);
    	String flag=null;
    		//如果审批状态是驳回的话,允许用户再次编辑
    	if("驳回".equals(expenseApplayBus.getApplayStatus())){
    		flag="show";
    	}else{
    		flag="hide";
    	}
    	mav.addObject("flag",flag);
		mav.addObject("expenseApplayBus", expenseApplayBus);
    	mav.setViewName("expense/expense_apply/view/expense_view_bus");
    	return mav;
    }
  
    /**
     * 大巴车报销--审批界面
     * @param request
     * @param id
     * @param manager
     * @return
     */
    @RequestMapping("/to_approve_bus.do")
    public ModelAndView toApprove_bus(HttpServletRequest request,int id,String manager){
    	ModelAndView mav = new ModelAndView();
    	ExpenseApplayBus expenseApplayBus = expenseBusService.selectById(id);
    	String flag=null;
    	//如果不是当前审批人查看审批消息隐藏通过按钮
    	if(!manager.equals(expenseApplayBus.getApproverNow())){
    		flag="hide";
    	}
    	mav.addObject("flag", flag);
    	mav.addObject("expenseApplayBus",expenseApplayBus );
    	mav.setViewName("expense/approve_bus");
    	return mav;
    }
    //审核通过信息保存
    @RequestMapping("/to_approve_bus_update.do")
    @ResponseBody
    public int to_approve_bus_update(HttpServletRequest request,int id,String result){
    	//找出这条审批记录
    	ExpenseApplayBus expenseApplayBus = expenseBusService.selectById(id);
    	if("agree".equals(result)){
    	   //报销审批处理流程具体实现
    	    expenseApplayBus= expenseBusService.sendTONextManager(expenseApplayBus);
    	}else if("disagree".equals(result)){
    		expenseApplayBus=expenseBusService.refuseOption(expenseApplayBus);
    	}	
       return	expenseBusService.saveOrUpdate(expenseApplayBus);
    }
    /**
     * 大巴车报销-驳回-删除
     * @param id
     * @return
     */
    @RequestMapping("/delete_bus.do")
    public @ResponseBody String delete(int id){
    	return expenseBusService.delete(id);
    }
}
