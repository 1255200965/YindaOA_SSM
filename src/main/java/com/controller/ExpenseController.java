package com.controller;


import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ddSdk.auth.AuthHelper;
import com.model.BusinessTrip;
import com.model.ExpenseApplayBus;
import com.model.ExpenseApplayHotel;
import com.model.ExpenseApplayTrain;
import com.model.ExpenseApplySubway;
import com.model.StaffInfo;
import com.service.IBusinessTripService;
import com.service.IExpenseApplayBusService;
import com.service.IExpenseApplayHotelService;
import com.service.IExpenseApplayTaxiService;
import com.service.IExpenseApplayTrainService;
import com.service.IExpenseApplySubwayService;
import com.service.IStaffInfoService;
import com.util.DDSendMessageUtil;
import com.util.DDUtil;
import com.util.FileUploadUtil;
import com.util.GlobalConstant;

@Controller
public class ExpenseController {
	@Autowired
	private IExpenseApplayBusService expenseBusService;
	@Autowired
	private IExpenseApplayTaxiService expenseApplayTaxiService;
	@Autowired
	private IExpenseApplayHotelService expenseApplayHotelService;
	@Autowired
	private IExpenseApplayTrainService expenseApplayTrainService;
	@Autowired
	private IStaffInfoService staffInfoService;
	@Autowired
	private DDSendMessageUtil ddSendMessageUtil;
	@Autowired
	private IBusinessTripService businessTripService;
	@Autowired
	private IExpenseApplySubwayService expenseApplySubwayService;
	//出差审批界面跳转
	@RequestMapping("/toExpense_applay.do")
	public ModelAndView toExpense_applay(HttpServletRequest request){
		ModelAndView mav =new ModelAndView();
		String config=AuthHelper.getConfig(request);
		request.setAttribute("config", config);
		mav.setViewName("expense/expense_applay");
		return mav;
	}
	//免登用户信息记录session
	@RequestMapping("/loginJudge.do")
	public void loginJudge(HttpServletRequest request,String code){
		//根据code获取用员工钉钉ID
		String staffUserId=DDUtil.getUserID(code);
		//从数据库中获得该员工的所有信息
		StaffInfo staffInfo= staffInfoService.selectStaffByID(staffUserId);
		//在当前回话session中存储相关信息
		request.getSession().setAttribute(GlobalConstant.user_staffId, staffInfo.getStaffId());
		request.getSession().setAttribute(GlobalConstant.user_department, staffInfo.getDepartment());
		request.getSession().setAttribute(GlobalConstant.user_staff_user_id,staffInfo.getStaffUserId());
		request.getSession().setAttribute(GlobalConstant.user_name,staffInfo.getName());
		
	}
	/**
	 * 火车票报销
	 * 
	 */
	//火车票报销界面跳转--历史信息
	@RequestMapping("/toExpense_history_train.do")
	public ModelAndView toExpense_history_train(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		String staffId=(String) request.getSession().getAttribute(GlobalConstant.user_staffId);
		List<ExpenseApplayTrain> expenseApplayTrainList = expenseApplayTrainService.selectByStaffId(staffId);
		mav.addObject("expenseApplayTrainList", expenseApplayTrainList);
		mav.setViewName("expense/expense_history_train");
		return mav;
	}
	//火车票报销界面--详细信息查看
	@RequestMapping("/toExpense_view_train.do")
	public ModelAndView toExpense_view_train(HttpServletRequest request,int id){
		ModelAndView mav = new ModelAndView();
		ExpenseApplayTrain expenseApplayTrain = expenseApplayTrainService.selectById(id);
		System.out.println(expenseApplayTrain);
		mav.addObject("expenseApplayTrain", expenseApplayTrain);
		mav.setViewName("expense/expense_view_train");
		return mav;
	}
	
	//火车票报销界面跳转--新增--省外
    @RequestMapping("/toExpense_train.do")
    public ModelAndView toExpense_train(HttpServletRequest request,ExpenseApplayTrain expenseApplayTrain,String type){
    	ModelAndView mav = new ModelAndView();
    	List<BusinessTrip> businessTripList = businessTripService.selectByStaffId((String) request.getSession().getAttribute(GlobalConstant.user_staffId));
    	mav.addObject("businessTripList", businessTripList);
    	mav.setViewName("expense/expense_train");
    	return mav;
    }
  //火车票报销界面跳转--新增--省内
    @RequestMapping("/toExpense_train_InProvince.do")
    public ModelAndView toExpense_train_InProvince(HttpServletRequest request,ExpenseApplayTrain expenseApplayTrain,String type){
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("expense/expense_train_Inprovince");
    	return mav;
    }
    //出差详细信息获取
    @RequestMapping("/getDetail.do")
    @ResponseBody
    public BusinessTrip getDetail(int btSequenceNo){
    	BusinessTrip businessTrip = businessTripService.selectById(btSequenceNo);
    	return businessTrip;
    }
    //火车票报销信息记录
    @RequestMapping("/expense_train_save.do")
    public String expense_train_save(HttpServletRequest request,ExpenseApplayTrain expenseApplayTrain){
    	Integer id =expenseApplayTrain.getId();
    	//添加报销信息状态为待审核
    	expenseApplayTrain.setApplayStatus("待审核");
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
    		id = expenseApplayTrainService.saveOrUpdate(expenseApplayTrain);
        	//用户新增的申请需要给管理员推送审批消息
    		DDSendMessageUtil.sendMessageTrain(expenseApplayTrain, id, toUser);
            //操作成功,重定向到历史信息查看界面
    		return "redirect:toExpense_history_train.do";
    	}catch(Exception e){
    		//返回操作状态信息
    		return "redirect:toExpense_train?data=fail";
    	}
    	/**保存当前报销信息**/
    	
    }
    //公司火车票据审批界面跳转
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
    //审批数据保存
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
     * 大巴车报销
     * 
     */
    //大巴车报销界面跳转--新增
    @RequestMapping("/toExpense_bus.do")
    public ModelAndView toExpense_bus(HttpServletRequest request){
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("expense/expense_bus");
    	return mav;
    }
    //大巴车报销记录--保存
    @RequestMapping("/toExpense_bus_save.do")
    public String toExpense_bus_save(HttpServletRequest request,ExpenseApplayBus expenseApplayBus){
        int id =0;
    	//将新记录的状态记为待审核
    	expenseApplayBus.setApplayStatus("待审核");
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
			expenseApplayBus.setApproverOrder(approverList.get(1)+"|"+approverList.get(0));
			expenseApplayBus.setApproverNow(approverList.get(1));
			}else{//对于挂职在二级部门下的员工
				toUser=approverList.get(0);
				expenseApplayBus.setApproverOrder(approverList.get(0));
				expenseApplayBus.setApproverNow(approverList.get(0));
			}
			/*被报销人的各级审批人*/
			//存储报销信息
			id=expenseBusService.saveOrUpdate(expenseApplayBus); 
        	//用户新增的申请需要给管理员推送审批消息
//			toUser="07022352451246847";
        	DDSendMessageUtil.sendMessageBus(expenseApplayBus, id, toUser);
	    	return "redirect:toExpense_history_bus.do";
	    	
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:toExpense_bus.do?data="+"fail";
		}   	
    }
    //大巴车报销界面跳转--历史记录
    @RequestMapping("/toExpense_history_bus.do")
    public ModelAndView toExpense_history_bus(HttpServletRequest request){
    	ModelAndView mav = new ModelAndView();
    	String staffId =(String) request.getSession().getAttribute(GlobalConstant.user_staffId);
    	List<ExpenseApplayBus> expenseApplayBusList = expenseBusService.selectAllByStaffId(staffId);
		mav.addObject("expenseApplayBusList", expenseApplayBusList);
    	mav.setViewName("expense/expense_history_bus");
    	return mav;
    }
    //大巴车报销界面跳转--详细信息查看
    @RequestMapping("/toExpense_view_bus.do")
    public ModelAndView toExpense_bus_view(HttpServletRequest request,int id){
    	ModelAndView mav = new ModelAndView();
    	ExpenseApplayBus expenseApplayBus = expenseBusService.selectById(id);
		mav.addObject("expenseApplayBus", expenseApplayBus);
    	mav.setViewName("expense/expense_view_bus");
    	return mav;
    }
    //大巴车报销审核
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
     * 
     * 旅店报销
     * 
     */
    //旅店报销界面跳转--新增
    @RequestMapping("/toExpense_hotel.do")
    public ModelAndView toExpense_hotel(HttpServletRequest request){
    	ModelAndView mav =new ModelAndView();
    	mav.setViewName("expense/expense_hotel");
    	return mav;
    }
    //旅店报销界面跳转--历史信息查看
    @RequestMapping("/toExpense_history_hotel.do")
    public ModelAndView toExpense_history_hotel(HttpServletRequest request){
    	ModelAndView mav = new ModelAndView();
    	String staffId=(String) request.getSession().getAttribute(GlobalConstant.user_staffId);
    	List<ExpenseApplayHotel> expenseApplayHotelList = expenseApplayHotelService.selectByStaffId(staffId);
    	mav.addObject("expenseApplayHotelList", expenseApplayHotelList);
    	mav.setViewName("expense/expense_history_hotel");
    	return mav;
    }
    //旅店报销界面跳转--详细信息查看
    @RequestMapping("/toExpense_view_hotel.do")
    public ModelAndView toExpense_view_hotel(HttpServletRequest request,int id){
    	ModelAndView mav = new ModelAndView();
    	ExpenseApplayHotel expenseApplayHotel=expenseApplayHotelService.selectById(id);
    	mav.addObject("expenseApplayHotel", expenseApplayHotel);
    	mav.setViewName("expense/expense_view_hotel");
    	return mav;
    }
    //住宿报销信息保存
    @RequestMapping("/toExpense_hotel_save.do")
    public String toExpense_hotel_save(HttpServletRequest request,ExpenseApplayHotel expenseApplayHotel){
    	int id = 0;
    	//重置报销信息为待审核状态
    	expenseApplayHotel.setApplayStatus("待审核");
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
    		DDSendMessageUtil.sendMessageHotel(expenseApplayHotel, id, toUser);
           
    		return "redirect:toExpense_history_hotel.do";
    	}catch(Exception e){
    		return "redirect:toExpense_hotel.do?data=fail";
    	}
    
    }
    //住宿审核界面跳转
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
     * 公交地铁费用报销
     * @return
     */
   //公交地铁报销申报界面跳转
    @RequestMapping("/toExpense_subway.do")
    public ModelAndView toExpense_subway(){
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("expense/expense_subway");
    	return mav;
    }
    @RequestMapping("/toExpense_subway_save.do")
    public @ResponseBody String toExpense_subway_save(HttpServletRequest request,ExpenseApplySubway subwayApply){
    /******添加当前报销人信息*****/
try{ subwayApply.setAskStaffId((String) request.getSession().getAttribute(GlobalConstant.user_staffId));
     subwayApply.setAskStaffUserId((String) request.getSession().getAttribute(GlobalConstant.user_staff_user_id));
    subwayApply.setAskStaffName((String) request.getSession().getAttribute(GlobalConstant.user_name));
    subwayApply.setAskStaffDepart((String) request.getSession().getAttribute(GlobalConstant.user_department)); 	
   /******添加当前报销人信息*****/
    subwayApply.setApproveStatus("待审核");
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
	DDSendMessageUtil.sendMessageSubway(subwayApply, id, toUser);
	return "success";
  }catch(Exception e){
	 return "fail";
  }
}
    //地铁公交报销审批界面跳转
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
    public @ResponseBody String  expense_subway_approve_update(int id,String result){
    	//根据ID找到这条报销记录
    	try{	
    		ExpenseApplySubway subwayApply=expenseApplySubwayService.selectByPrimarykey(id);
    		if("agree".equals(result)){//审批同意操作
    			subwayApply=expenseApplySubwayService.sendTONextManager(subwayApply);
    		}else if("disagree".equals(result)){//驳回操作
    			subwayApply=expenseApplySubwayService.refuseOption(subwayApply);
    		}
    		expenseApplySubwayService.saveOrUpdate(subwayApply);
    		return "success";
    	}catch(Exception e){
    		return "fail";
    	}
    }
    //历史审批信息查看
    @RequestMapping("/goApprove_history_view.do")
    public ModelAndView goApprove_history_view(){
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("expense/approve_history_view");
    	return mav;
    }
   
//    /** 
//     * 出租车报销
//     */
//    //出租车报销界面跳转--新增
//    @RequestMapping("/toExpense_taxi.do")
//    public ModelAndView toExpense_taxi(HttpServletRequest request){
//    	ModelAndView mav = new ModelAndView();
//    	mav.setViewName("expense/expense_taxi");
//    	return mav;
//    }
//    //出租车报销表单提交
//    @RequestMapping("/toExpense_taxi_save.do")
//    public String toExpense_taxi_save(HttpServletRequest request,ExpenseApplayTaxi expenseApplayTaxi){
//    	int id=0;
//    	//新增报销信息状态为待审核
//    	expenseApplayTaxi.setApplayStatus("待审核");
//    	/*当前申请人信息记录*/
//    	expenseApplayTaxi.setStaffId((String) request.getSession().getAttribute(GlobalConstant.user_staffId));
//    	expenseApplayTaxi.setStaffName((String)request.getSession().getAttribute(GlobalConstant.user_name));
//    	expenseApplayTaxi.setStaffDepart((String) request.getSession().getAttribute(GlobalConstant.user_department));
//    	expenseApplayTaxi.setStaffUserId((String) request.getSession().getAttribute(GlobalConstant.user_staff_user_id));
//    	/*当前申请人信息记录*/
//    	try{
//    		/**图片存储**/
//        	MultipartRequest mRequest = (MultipartRequest)request;
//        	MultipartFile mFile= mRequest.getFile("image");
//        	   //原始图片名称
//        	String originalName=mFile.getOriginalFilename();
//        	System.out.println("上传后的文件名为"+originalName);
//        	  //图片存储的物理路径
//    		String basePath =ExpenseApplyResources.IMG_SAVE_PATH;
//    		  //新的图片名称
//    		String newFileName=UUID.randomUUID()+originalName.substring(originalName.lastIndexOf("."));
//    		  //新图片
//        	File file = new File(basePath+newFileName);
//        	  //将mFile文件的内容写入file
//			mFile.transferTo(file);
//			  //数据库中记录图片存放位置信息
//			expenseApplayTaxi.setImageUrl(newFileName);
//			/**图片存储**/
//    		id = expenseApplayTaxiService.saveOrUpdate(expenseApplayTaxi);
//    		String text =DDSendMessageUtil.getText("出租票报销",expenseApplayTaxi.getStaffName(),expenseApplayTaxi.getStartAddress(),expenseApplayTaxi.getEndAddress());
//            DDMessageUtil ddMessage = new DDMessageUtil();
//            ddMessage.setMessageUrl("http://121.40.29.241/YindaOA/to_approve_taxi.do?id="+id);
//            ddMessage.setPicUrl("http://121.40.29.241/YindaOA/images/approve.png");
//            ddMessage.setText(text);
//            ddMessage.setTitle("报销");
//            ddMessage.setToParty("");
//            ddMessage.setToUser("07022352451246847");
//            DDSendMessageUtil.sendMessage(ddMessage);
//    		return "redirect:toExpense_taxi.do?data=success";
//    	}catch(Exception e){
//    		e.printStackTrace();
//    		return "redirect:toExpense_taxi.do?data=fail";
//    	}
//    }
//    //审批界面跳转
//    @RequestMapping("/to_approve_taxi.do")
//    public ModelAndView to_approve_taxi(HttpServletRequest request,int id){
//    	ModelAndView mav = new ModelAndView();
//    	ExpenseApplayTaxi expenseApplayTaxi = expenseApplayTaxiService.selectById(id);
//    	mav.addObject("expenseApplayTaxi", expenseApplayTaxi);
//    	mav.setViewName("expense/approve_taxi");
//    	return mav;
//    }
//    //审批过后数据更新
//    @RequestMapping("/approve_taxi_update.do")
//    @ResponseBody
//    public int approve_taxi_update(HttpServletRequest request,ExpenseApplayTaxi expenseApplayTaxi){
//    	//新增报销信息状态为待审核
//    	expenseApplayTaxi.setApplayStatus("通过");
//    	/*当前申请人信息记录*/
//    	expenseApplayTaxi.setStaffId((String) request.getSession().getAttribute(GlobalConstant.user_staffId));
//    	expenseApplayTaxi.setStaffName((String)request.getSession().getAttribute(GlobalConstant.user_name));
//    	expenseApplayTaxi.setStaffDepart((String) request.getSession().getAttribute(GlobalConstant.user_department));
//    	expenseApplayTaxi.setStaffUserId((String) request.getSession().getAttribute(GlobalConstant.user_staff_user_id));
//    	/*当前申请人信息记录*/
//    	return expenseApplayTaxiService.saveOrUpdate(expenseApplayTaxi);
//    }
//    //出租车报销界面跳转--历史信息查看
//    @RequestMapping("/toExpense_history_taxi.do")
//    public ModelAndView toExpense_history_taxi(HttpServletRequest request){
//    	ModelAndView mav =new ModelAndView();
//    	String staffId=(String) request.getSession().getAttribute(GlobalConstant.user_staffId);
//    	List<ExpenseApplayTaxi> expenseApplayTaxiList = expenseApplayTaxiService.selectByStaffId(staffId);
//    	mav.addObject("expenseApplayTaxiList", expenseApplayTaxiList);
//    	mav.setViewName("expense/expense_history_taxi");
//    	return mav;
//    }
//    //出租车报销界面跳转--详细信息查看界
//    @RequestMapping("/toExpense_view_taxi.do")
//    public ModelAndView toExpense_view_taxi(HttpServletRequest request,int id){
//    	ModelAndView mav = new ModelAndView();
//    	ExpenseApplayTaxi expenseApplayTaxi = expenseApplayTaxiService.selectById(id);
//    	mav.addObject("expenseApplayTaxi", expenseApplayTaxi);
//    	mav.setViewName("expense/expense_view_taxi");
//    	return mav;
//    }
    
}
