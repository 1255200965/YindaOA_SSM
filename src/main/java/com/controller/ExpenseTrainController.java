package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.model.BusinessTrip;
import com.model.ExpenseApplayTrain;
import com.service.IBusinessTripService;
import com.service.IExpenseApplayTrainService;
import com.util.DDSendMessageUtil;
import com.util.DateUtil;
import com.util.FileUploadUtil;
import com.util.GlobalConstant;

@Controller
public class ExpenseTrainController {

	@Autowired
	private DDSendMessageUtil ddSendMessageUtil;
	@Autowired
	private IExpenseApplayTrainService expenseApplayTrainService;
	@Autowired
	private IBusinessTripService businessTripService;
	/**
	 * 火车票报销历史信息查看
	 * @param request
	 * @return
	 */
	@RequestMapping("/toExpense_history_train.do")
	public ModelAndView toExpense_history_train(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		String staffId=(String) request.getSession().getAttribute(GlobalConstant.user_staffId);
		System.out.println("staffId======="+staffId);
		List<ExpenseApplayTrain> expenseApplayTrainList = expenseApplayTrainService.selectByStaffId(staffId);
		mav.addObject("expenseApplayTrainList", expenseApplayTrainList);
		mav.setViewName("expense/expense_apply/history/expense_history_train");
		return mav;
	}
	/**
	 * 火车票报销-详情查看
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/toExpense_view_train.do")
	public ModelAndView toExpense_view_train(HttpServletRequest request,int id){
		ModelAndView mav = new ModelAndView();
		ExpenseApplayTrain expenseApplayTrain = expenseApplayTrainService.selectById(id);
		//获取审批人顺序-当前审批人
		expenseApplayTrainService.constructApprovers(expenseApplayTrain);
    	String flag=null;
    		//如果审批状态是驳回的话,允许用户再次编辑
    	if("驳回".equals(expenseApplayTrain.getApplayStatus())){
    		flag="show";
    	}else{
    		flag="hide";
    	}
    	mav.addObject("flag",flag);
		mav.addObject("expenseApplayTrain", expenseApplayTrain);
		mav.setViewName("expense/expense_apply/view/expense_view_train");
		return mav;
	}
	
	/**
	 * 火车票申报-省外
	 * @param request
	 * @param expenseApplayTrain
	 * @param type
	 * @return
	 */
    @RequestMapping("/toExpense_train.do")
    public ModelAndView toExpense_train(HttpServletRequest request,ExpenseApplayTrain expenseApplayTrain,String type){
    	ModelAndView mav = new ModelAndView();
    	List<BusinessTrip> businessTripList = businessTripService.selectByStaffId((String) request.getSession().getAttribute(GlobalConstant.user_staffId));
    	mav.addObject("businessTripList", businessTripList);
    	mav.setViewName("expense/expense_apply/expense_train");
    	return mav;
    }
    /**
     * 火车票报销申报-省内
     * @param request
     * @param expenseApplayTrain
     * @param type
     * @return
     */
    @RequestMapping("/toExpense_train_InProvince.do")
    public ModelAndView toExpense_train_InProvince(HttpServletRequest request,ExpenseApplayTrain expenseApplayTrain,String type){
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("expense/expense_apply/expense_train_Inprovince");
    	return mav;
    }
    /**
     * 出差详情获取
     * @param btSequenceNo
     * @return
     */
    @RequestMapping("/getDetail.do")
    @ResponseBody
    public BusinessTrip getDetail(int btSequenceNo){
    	BusinessTrip businessTrip = businessTripService.selectById(btSequenceNo);
    	return businessTrip;
    }
    /**
     * 火车票报销申报-审核信息记录
     * @param request
     * @param expenseApplayTrain
     * @return
     */
    @RequestMapping("/expense_train_save.do")
    public String expense_train_save(HttpServletRequest request,ExpenseApplayTrain expenseApplayTrain){
    	Integer id =expenseApplayTrain.getId();
    	//添加报销信息状态为待审核
    	expenseApplayTrain.setApplayStatus("待审核");
    	expenseApplayTrain.setSubmitTime(DateUtil.getCurrentDate());
    	/**添加当前报销人信息**/
    	expenseApplayTrain.setStaffId((String) request.getSession().getAttribute(GlobalConstant.user_staffId));
    	expenseApplayTrain.setStaffName((String) request.getSession().getAttribute(GlobalConstant.user_name));
    	expenseApplayTrain.setStaffDepart((String) request.getSession().getAttribute(GlobalConstant.user_department));
    	expenseApplayTrain.setStaffUserId((String) request.getSession().getAttribute(GlobalConstant.user_staff_user_id));
    	/**添加当前报销人信息**/
    	
        /**保存当前报销信息**/
    	try{
    		//图片上传存储
    		String newFileName =FileUploadUtil.imageUpload(request);
			//数据库中记录图片存放位置信息
			expenseApplayTrain.setImageUrl(newFileName);
			/*****用户对应报销管理员查询******/
			List<String> approverList=ddSendMessageUtil.getApprovers(expenseApplayTrain.getStaffUserId());
			String toUser=null;
			//对于挂职在一级部门的员工
			if(approverList.size() >1){
			toUser=approverList.get(1);//先发送给一级部门的管理员
			expenseApplayTrain.setApproverOrder(approverList.get(1)+"|"+approverList.get(0)+"|10548"+"|31017"+"|10272");
			expenseApplayTrain.setApproverNow(toUser);
			}else{//对于挂职在二级部门下的员工
				toUser=approverList.get(0);//直接发送给二级部门的管理员
				expenseApplayTrain.setApproverOrder(approverList.get(0)+"|10548"+"|31017"+"|10272");
				expenseApplayTrain.setApproverNow(toUser);
			}	
			/*****用户对应报销管理员查询******/
			//添加当前审批人信息
		    expenseApplayTrain.setApproverNow(toUser);
    		id = expenseApplayTrainService.saveOrUpdate(expenseApplayTrain);
        	//用户新增的申请需要给管理员推送审批消息
//    		DDSendMessageUtil.sendMessageTrain(expenseApplayTrain, id, toUser);
            //操作成功,重定向到历史信息查看界面
    		return "redirect:toExpense_history_train.do";
    	}catch(Exception e){
    		//返回操作状态信息
    		return "redirect:toExpense_train?data=fail";
    	}
    	/**保存当前报销信息**/
    	
    }
    /**
     * 火车票报销-审批界面跳转
     * @param request
     * @param id
     * @param manager
     * @return
     */
    @RequestMapping("/to_approve_train.do")
    public ModelAndView toBus_approve(HttpServletRequest request,int id,String manager){
    	ModelAndView mav = new ModelAndView();
    	ExpenseApplayTrain  expenseApplayTrain = expenseApplayTrainService.selectById(id);
    	String flag=null;
    	//1.只有当前审批人才有资格审批这条报销消息
    	if(!manager.equals(expenseApplayTrain.getApproverNow())){
    		flag="hide";
    	}
    	mav.addObject("flag", flag);
    	mav.addObject("expenseApplayTrain", expenseApplayTrain);
    	mav.setViewName("expense/approve_train");
    	return mav;
    }
    /**
     * 火车票报销审批数据保存
     * @param request
     * @param id
     * @param result
     * @return
     */
    @RequestMapping("/approve_train_update.do")
    @ResponseBody
    public int approve_train_update(HttpServletRequest request,int id,String result){
    	//找出这条审批记录
    	ExpenseApplayTrain expenseApplayTrain=expenseApplayTrainService.selectById(id);
    	if("agree".equals(result)){
    	   //进行下一步的处理,发消息或者只更新审批状态
    	   expenseApplayTrain = expenseApplayTrainService.sendTONextManager(expenseApplayTrain);
    	}else if("disagree".equals(result)){
    		 expenseApplayTrain = expenseApplayTrainService.refuseOption(expenseApplayTrain);
    	}
        return expenseApplayTrainService.saveOrUpdate(expenseApplayTrain);     
    }
    /**
     * 火车票报销-驳回-删除
     * @param id
     * @return
     */
    @RequestMapping("/delete_train.do")
    public @ResponseBody String delete(int id){
    	return expenseApplayTrainService.delete(id);
    }
    /**
     * 火车票报销申报-审核信息记录
     * @param request
     * @param expenseApplayTrain
     * @return
     */
    @RequestMapping("/toExpense_train_save_again.do")
    public String expense_train_save_again(HttpServletRequest request,ExpenseApplayTrain expenseApplayTrain){
    	Integer id =expenseApplayTrain.getId();
    	//添加报销信息状态为待审核
    	expenseApplayTrain.setApplayStatus("待审核");
    	expenseApplayTrain.setSubmitTime(DateUtil.getCurrentDate());
    	/**添加当前报销人信息**/
    	expenseApplayTrain.setStaffId((String) request.getSession().getAttribute(GlobalConstant.user_staffId));
    	expenseApplayTrain.setStaffName((String) request.getSession().getAttribute(GlobalConstant.user_name));
    	expenseApplayTrain.setStaffDepart((String) request.getSession().getAttribute(GlobalConstant.user_department));
    	expenseApplayTrain.setStaffUserId((String) request.getSession().getAttribute(GlobalConstant.user_staff_user_id));
    	/**添加当前报销人信息**/
    	
        /**保存当前报销信息**/
    	try{
			/*****用户对应报销管理员查询******/
			List<String> approverList=ddSendMessageUtil.getApprovers(expenseApplayTrain.getStaffUserId());
			String toUser=null;
			//对于挂职在一级部门的员工
			if(approverList.size() >1){
			toUser=approverList.get(1);//先发送给一级部门的管理员
			expenseApplayTrain.setApproverOrder(approverList.get(1)+"|"+approverList.get(0));
			expenseApplayTrain.setApproverNow(toUser);
			}else{//对于挂职在二级部门下的员工
				toUser=approverList.get(0);//直接发送给二级部门的管理员
				expenseApplayTrain.setApproverOrder(approverList.get(0));
				expenseApplayTrain.setApproverNow(toUser);
			}	
			/*****用户对应报销管理员查询******/
			//添加当前审批人信息
		    expenseApplayTrain.setApproverNow(toUser);
    		expenseApplayTrainService.UpdateByPrimaryKey(expenseApplayTrain);
        	//用户新增的申请需要给管理员推送审批消息
//    		DDSendMessageUtil.sendMessageTrain(expenseApplayTrain, id, toUser);
            //操作成功,重定向到历史信息查看界面
    		return "success";
    	}catch(Exception e){
    		//返回操作状态信息
    		return "fail";
    	}
    	/**保存当前报销信息**/
    	
    }
}
