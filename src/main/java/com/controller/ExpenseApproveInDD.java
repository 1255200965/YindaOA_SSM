package com.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ddSdk.auth.AuthHelper;
import com.model.ApprovalStaff;
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
import com.util.DateUtil;
import com.util.GlobalConstant;
/**
 * 报销审批+报销入口相关代码---钉钉审批
 * @author mawei
 *
 */
@Controller
@RequestMapping("/expenseApplyApprove")
public class ExpenseApproveInDD {
	@Autowired
	private IExpenseApplayBusService expenseBusService;
	@Autowired
	private IExpenseApplayTaxiService expenseApplayTaxiService;
	@Autowired
	private DDSendMessageUtil ddSendMessageUtil;
	@Autowired
	private IExpenseApplayTrainService expenseApplayTrainService;
	@Autowired
	private IStaffInfoService staffInfoService;
	@Autowired
	private IExpenseApplayHotelService expenseApplayHotelService;
	@Autowired
	private IBusinessTripService businessTripService;
	@Autowired
	private IExpenseApplySubwayService expenseApplySubwayService;
	@Autowired
	private ExpenseQuartz quartz;
	
	
	/**
	 * 报销初始入口界面
	 * @param request
	 * @return
	 */
	@RequestMapping("/goExpense.do")
	public ModelAndView toExpense_applay(HttpServletRequest request){
		ModelAndView mav =new ModelAndView();
		String config=AuthHelper.getConfig(request);
		request.setAttribute("config", config);
		mav.setViewName("expense/expense");
		return mav;
	}
	/**
	 * 报销免登--用户信息Session记录
	 * @param request
	 * @param code
	 */
	@RequestMapping("/loginJudge.do")
	public void loginJudge(HttpServletRequest request,String code){
		//根据code获取用员工钉钉ID
		String staffUserId=DDUtil.getUserID(code);
		System.out.println("staffUserId==="+staffUserId);
		//从数据库中获得该员工的所有信息
		StaffInfo staffInfo= staffInfoService.selectStaffByID(staffUserId);
		//在当前回话session中存储相关信息
		request.getSession().setAttribute(GlobalConstant.user_staffId, staffInfo.getStaffId());
		request.getSession().setAttribute(GlobalConstant.user_department, staffInfo.getDepartment());
		request.getSession().setAttribute(GlobalConstant.user_staff_user_id,staffInfo.getStaffUserId());
		request.getSession().setAttribute(GlobalConstant.user_name,staffInfo.getName());
		
	}
	
    /***审批信息查看相关代码***/
    
    /**
     * 钉钉微应用内审批界面跳转
     * @return
     */
    @RequestMapping("/goApprove_record.do")
    public ModelAndView goApprove_history_view(HttpServletRequest request){
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("expense/approveInMicroApp/approve_record");
    	return mav;
    }
    /**
     * 钉钉微应用内已审批信息查看
     * @param request
     * @param type
     * @return
     */
    @RequestMapping("approved.do")
    public ModelAndView approved(HttpServletRequest request,String type){
    	ModelAndView mav = new ModelAndView();
    	String approverStaffUserId = (String) request.getSession().getAttribute(GlobalConstant.user_staff_user_id);
    	System.out.println(approverStaffUserId);
    	@SuppressWarnings("rawtypes")
		List approvedList = null;
    	if("train".equals(type)){
    		approvedList = expenseApplayTrainService.selectApproved(approverStaffUserId);
    		mav.addObject("approvedList", approvedList);
    		mav.addObject("type","train");
    	}else if("bus".equals(type)){
    		approvedList = expenseBusService.selectByApproveHistory(approverStaffUserId);
    		mav.addObject("approvedList", approvedList);
    		mav.addObject("type","bus");
    	}else if("subway".equals(type)){
    		approvedList = expenseApplySubwayService.selectApproved(approverStaffUserId);
    		mav.addObject("approvedList", approvedList);
    		mav.addObject("type","subway");
    		mav.setViewName("expense/approveInMicroApp/approved_history_subway");
        	return mav;
    	}else if("hotel".equals(type)){
    		approvedList = expenseApplayHotelService.selectApproved(approverStaffUserId);
    		mav.addObject("approvedList", approvedList);
    		mav.addObject("type","hotel");
    	}
    	
    	mav.setViewName("expense/approveInMicroApp/approved_history_bus");
    	return mav;
    }
    /**
     * 跳转进入-报销每周明细
     * @param request
     * @param staffId
     * @return
     */
    @RequestMapping("/goApprovalDetail.do")
    public ModelAndView goApprovalDetail(HttpServletRequest request,ApprovalStaff approvalStaff){
    	
    	ModelAndView mav = new ModelAndView();
    	mav.addObject("approvalStaff", approvalStaff);
    	mav.setViewName("expense/approveInMicroApp/approval_detail");
    	return mav;
    }
    /**
     * 钉钉微应用内待审批信息-明细获取
     * @param request
     * @param type
     * @return
     */
    @RequestMapping("/getApproval.do")
    public @ResponseBody List approval(HttpServletRequest request ,String staffId,String type){
    	
    	String approverStaffUserId = (String) request.getSession().getAttribute(GlobalConstant.user_staff_user_id);
    	@SuppressWarnings("rawtypes")
		List approvalList = null;
    	if("train".equals(type)){
    		approvalList = expenseApplayTrainService.selectApproval(approverStaffUserId, staffId);
    		
    	}else if("bus".equals(type)){
    		approvalList = expenseBusService.selectApproval(approverStaffUserId, staffId);
    		
    	}else if("subway".equals(type)){
    		approvalList = expenseApplySubwayService.selectApproval(approverStaffUserId, staffId);
    		
    	}else if("hotel".equals(type)){
    		approvalList = expenseApplayHotelService.selectApproval(approverStaffUserId, staffId);
    		
    	}
    	return approvalList;
    }
    /**
     * 待审批界面跳转
     * @return
     */
    @RequestMapping("/goApprovalSum.do")
    public ModelAndView approval(HttpServletRequest request){
    	ModelAndView mav = new ModelAndView();
    	/*String staffUserId = (String) request.getSession().getAttribute(GlobalConstant.user_staff_user_id);
    	List<String> leaders = quartz.getLeaders();
    	System.out.println("staffUserId"+staffUserId);
    	int currentDay = DateUtil.getCurrentDay();
    	 if(leaders.contains(staffUserId)){
    	       //1-5号项目经理部门经理进行审批
    		if(currentDay >=1 && currentDay <=5 ){
    			if( !"10548".equals(staffUserId) && !"31017".equals(staffUserId) && !"10272".equals(staffUserId)){
    				mav.setViewName("expense/approveInMicroApp/approval_sum");
    				return mav;
    			}else{
    				mav.setViewName("expense/approveInMicroApp/log");
    				mav.addObject("log", "每月1-5号只运行项目经理部门经理进行审批,财务请于每月6-10号再进行审批");
    				return mav;
    			}
    		}
    			//6-10号陈萍、钱忠瑛进行审批
    		if(currentDay >=6 && currentDay <=10){
    		if(currentDay >=22){
    			//6-10财务进行审批
    			if( "10548".equals(staffUserId) || "31017".equals(staffUserId)){
    				mav.setViewName("expense/approveInMicroApp/approval_sum");
    				return mav;
    			}else{
    				mav.setViewName("expense/approveInMicroApp/log");
    				mav.addObject("log", "6-10号只允许财务进行审批,项目经理请于每月1-5号进行审批");
    				return mav;
    			}
    		}
    			//11-15号钱忠诚进行审批
    		if(currentDay >=11 && currentDay <=15){
    			if("10272".equals(staffUserId)){
    				mav.setViewName("expense/approveInMicroApp/approval_sum");
    				return mav;
    			}else{
    				mav.setViewName("expense/approveInMicroApp/log");
    				mav.addObject("log", "项目经理请于每月1-5号进行审批,财务请于每月6-10号进行审批,超时未审批的数据系统将自动驳回");
    				return mav;
    			}
    		}
    		    mav.setViewName("expense/approveInMicroApp/log");
    		    mav.addObject("log", "每月15之后为财务打款时间,请于每月1-15号及时进行审批,超时未审批的数据系统将自动驳回");
    			return mav;
    	 }else{
    		 mav.setViewName("expense/approveInMicroApp/log");
    		 mav.addObject("log", "当前用户无权限访问该页面,如需开通权限请联系管理员");
    		 return mav;
    	 }*/
    	mav.setViewName("expense/approveInMicroApp/approval_sum");
    	return mav;
    }
    /**
     * 异步获取待审批员工信息
     * @param request
     * @param type
     * @return
     */
    @RequestMapping("/getStaffs.do")
    public @ResponseBody List<ApprovalStaff> getStaffs(HttpServletRequest request){
    	System.out.println("获取员工报销信息汇总");
    	String approverStaffUserId = (String) request.getSession().getAttribute(GlobalConstant.user_staff_user_id);
    	List<ApprovalStaff> list=new ArrayList<ApprovalStaff>();
    	ApprovalStaff approvalStaff = new ApprovalStaff();
    	@SuppressWarnings("rawtypes")
		List<ExpenseApplayTrain> trainList = expenseApplayTrainService.selectApprovalStaff(approverStaffUserId);
    	List<ExpenseApplayBus> busList = expenseBusService.selectApprovalStaff(approverStaffUserId);
    	System.out.println("大巴报销条数"+busList.size());
    	List<ExpenseApplayHotel> hotelList = expenseApplayHotelService.selectApprovalStaff(approverStaffUserId);
    	List<ExpenseApplySubway> subwayList = expenseApplySubwayService.selectApprovalStaff(approverStaffUserId);
    	if(trainList != null && trainList.size() >0){	
    		for(ExpenseApplayTrain train : trainList){
    			approvalStaff.setStaffId(train.getStaffId());
    			approvalStaff.setStaffName(train.getStaffName());
    			approvalStaff.setCost(String.valueOf(train.getMoneyCost()));
    			if( ! isContains(list,approvalStaff)){
    				list.add(new ApprovalStaff(approvalStaff));
    			}
    		}
    	  }
    	if(busList != null && busList.size() > 0){
    		for(ExpenseApplayBus bus : busList ){
    			approvalStaff.setStaffId(bus.getStaffId());
    			approvalStaff.setStaffName(bus.getStaffName());
    			approvalStaff.setCost(String.valueOf(bus.getMoneyCost()));
    			if( ! isContains(list,approvalStaff)){
    				list.add(new ApprovalStaff(approvalStaff));
    			}
    		}
    		
    	}
    	if(hotelList != null && hotelList.size() > 0){
    		for(ExpenseApplayHotel hotel : hotelList){
    			approvalStaff.setStaffId(hotel.getStaffId());
    			approvalStaff.setStaffName(hotel.getStaffName());
    			approvalStaff.setCost(String.valueOf(hotel.getMoneyCost()));
    			if( ! isContains(list,approvalStaff)){
    				list.add(new ApprovalStaff(approvalStaff));
    			}
    		}
    		
    	}
    	if(subwayList != null && subwayList.size() >0){
    		for(ExpenseApplySubway subway : subwayList){
    			approvalStaff.setStaffId(subway.getAskStaffId());
    			approvalStaff.setStaffName(subway.getAskStaffName());
    			approvalStaff.setCost(String.valueOf(subway.getAskMoney()));
    			if( ! isContains(list,approvalStaff)){
    				list.add(new ApprovalStaff(approvalStaff));
    			}else{
    				
    			}
    		}
    		
    	}
    	System.out.println(list.toString());
    	return list;
    }
    /**
     * 判断集合中某个对象是否已存在
     * @param list
     * @param staffId
     * @return --true包含  false不包含
     */
    private boolean isContains(List<ApprovalStaff> list,ApprovalStaff approvalStaff){
    	String cost=null;	
    	//list不为空
    	if(list != null && ! list.isEmpty()){
    			//循环List
    		for(ApprovalStaff staff : list){
    				//若果List中已包含改员工信息
    			if(staff.getStaffId().equals(approvalStaff.getStaffId())){
    				
    				cost=Double.toString(Double.valueOf(staff.getCost())+Double.valueOf(approvalStaff.getCost()));
    				staff.setCost(cost);
    					//已包含
    				return true;
    			}
    		}
    			//不包含
    		return false;
    	}else{
    		//不包含
    		return false;
    	}
    }
    @RequestMapping("/approves.do")
    public @ResponseBody String approves(HttpServletRequest request, String ids,String type){
    	
    	String staffUserId = (String) request.getSession().getAttribute(GlobalConstant.user_staff_user_id);
    	String [] idsArr=null;
    	if(ids != null && !"".equals(ids)){
    		idsArr = ids.split("/,");
    	}
    	
  		try{
  		  for(String staffId : idsArr){
  			  	//找出工号是staffId的员工一周内的数据进行审批
  			  	List<ExpenseApplayTrain> expenseApplayTrains=expenseApplayTrainService.selectApproval(staffUserId, staffId);
  				System.out.println("火车报销"+"--条数"+expenseApplayTrains.size()+"---"+expenseApplayTrains.toString());
  				  if(expenseApplayTrains != null && expenseApplayTrains.size() > 0){
  					for(ExpenseApplayTrain train : expenseApplayTrains){
  						if("agree".equals(type)){
  									//进行下一步的处理,发消息或者只更新审批状态
  								train = expenseApplayTrainService.sendTONextManager(train);
  		    				}else if("disagree".equals(type)){
  		    					train = expenseApplayTrainService.refuseOption(train);
  		    				}
  		        			expenseApplayTrainService.saveOrUpdate(train); 
  						}
  				  }
  			List<ExpenseApplayBus> expenseApplayBuses=expenseBusService.selectApproval(staffUserId, staffId);
  			System.out.println("大巴车报销"+"--条数"+expenseApplayBuses.size()+"---"+expenseApplayBuses.toString());
  			if(expenseApplayBuses != null && expenseApplayBuses.size() > 0){
					for(ExpenseApplayBus bus : expenseApplayBuses){
						if("agree".equals(type)){
									//进行下一步的处理,发消息或者只更新审批状态
								bus = expenseBusService.sendTONextManager(bus);
		    				}else if("disagree".equals(type)){
		    					bus = expenseBusService.refuseOption(bus);
		    				}
						expenseBusService.saveOrUpdate(bus); 
						}
				  }
  			
  			List<ExpenseApplayHotel> expenseApplayHotels=expenseApplayHotelService.selectApproval(staffUserId, staffId);
  			System.out.println("大巴车报销"+"--条数"+expenseApplayHotels.size()+"---"+expenseApplayHotels.toString());
  			if(expenseApplayHotels != null && expenseApplayHotels.size() > 0){
				for(ExpenseApplayHotel hotel : expenseApplayHotels){
					if("agree".equals(type)){
								//进行下一步的处理,发消息或者只更新审批状态
							hotel = expenseApplayHotelService.sendTONextManager(hotel);
	    				}else if("disagree".equals(type)){
	    					hotel = expenseApplayHotelService.refuseOption(hotel);
	    				}
					expenseApplayHotelService.saveOrUpdate(hotel); 
					}
			  }
  			List<ExpenseApplySubway> expenseApplaySubways=expenseApplySubwayService.selectApproval(staffUserId, staffId);
  			System.out.println("大巴车报销"+"--条数"+expenseApplaySubways.size()+"---"+expenseApplaySubways.toString());
  			if(expenseApplayHotels != null && expenseApplayHotels.size() > 0){
				for(ExpenseApplySubway subway : expenseApplaySubways){
					if("agree".equals(type)){
								//进行下一步的处理,发消息或者只更新审批状态
							subway = expenseApplySubwayService.sendTONextManager(subway);
	    				}else if("disagree".equals(type)){
	    					subway = expenseApplySubwayService.refuseOption(subway);
	    				}
					expenseApplySubwayService.saveOrUpdate(subway); 
					}
			  }
  		  }
  		  return "success";
  		}catch(Exception e){
  			e.printStackTrace();
  			return "fail";
  		}
    }
    /**
     * 钉钉微应用内住宿审核界面跳转
     * @param request
     * @param id--该条记录的数据库ID
     * @param manager--当前审批人钉钉ID
     * @return
     */
    @RequestMapping("go_approve_hotel.do")
    public ModelAndView goApproveHotelInMicroApp(HttpServletRequest request,int id){
    	ModelAndView mav = new ModelAndView();
    	ExpenseApplayHotel expenseApplayHotel =expenseApplayHotelService.selectById(id);
    	String flag=null;
    	String manager = (String) request.getSession().getAttribute(GlobalConstant.user_staff_user_id);
    	if(!manager.equals(expenseApplayHotel.getApproverNow())){
    		flag="hide";
    	}
    	mav.addObject("flag", flag);
    	mav.addObject("expenseApplayHotel",expenseApplayHotel);
    	mav.setViewName("expense/approveInMicroApp/approve_hotel");
    	return mav;
    }
    /**
     * 钉钉微应用内大巴车审核界面跳转
     * @param request
     * @param id--该条记录的数据库ID
     * @param manager--当前审批人钉钉ID
     * @return
     */
    @RequestMapping("/go_approve_bus.do")
    public ModelAndView goApproveBusInMicroApp(HttpServletRequest request,int id){
    	ModelAndView mav = new ModelAndView();
    	ExpenseApplayBus expenseApplayBus = expenseBusService.selectById(id);
    	String manager=(String) request.getSession().getAttribute(GlobalConstant.user_staff_user_id);
    	String flag=null;
    	//如果不是当前审批人查看审批消息隐藏通过按钮
    	if(!manager.equals(expenseApplayBus.getApproverNow())){
    		flag="hide";
    	}
    	mav.addObject("flag", flag);
    	mav.addObject("expenseApplayBus",expenseApplayBus );
    	mav.setViewName("expense/approveInMicroApp/approve_bus");
    	return mav;
    }
    /**
     * 钉钉微应用内火车票报销审核界面跳转
     * @param request
     * @param id--该条记录的数据库ID
     * @param manager--当前审批人钉钉ID
     * @return
     */
    @RequestMapping("go_approve_train.do")
    public ModelAndView goApproveTrainInMicroApp(HttpServletRequest request,int id){
    	ModelAndView mav = new ModelAndView();
    	ExpenseApplayTrain  expenseApplayTrain = expenseApplayTrainService.selectById(id);
    	String manager=(String) request.getSession().getAttribute(GlobalConstant.user_staff_user_id);
    	String flag=null;
    	//1.只有当前审批人才有资格审批这条报销消息
    	if(!manager.equals(expenseApplayTrain.getApproverNow())){
    		flag="hide";
    	}
    	mav.addObject("flag", flag);
    	mav.addObject("expenseApplayTrain", expenseApplayTrain);
    	mav.setViewName("expense/approveInMicroApp/approve_train");
    	return mav;
    }
    /**
     * 钉钉微应用内地铁公交报销审核界面跳转
     * @param request
     * @param id--该条记录的数据库ID
     * @param manager--当前审批人钉钉ID
     * @return
     */
    @RequestMapping("/go_approve_subway.do")
    public ModelAndView goApproveSubwayInMicroApp(HttpServletRequest request,int id ){
    	ModelAndView mav = new ModelAndView();
    	//找出该条报销记录
    	ExpenseApplySubway subwayApply=expenseApplySubwayService.selectByPrimarykey(id);
    	String manager=(String) request.getSession().getAttribute(GlobalConstant.user_staff_user_id);
    	String flag=null;
    	if(! manager.equals(subwayApply.getApproverNow())){
    		flag="hide";
    	}
    	mav.addObject("flag", flag);
    	mav.addObject("subwayApply", subwayApply);
    	mav.setViewName("expense/approveInMicroApp/approve_subway");
    	return mav;
    }
    @RequestMapping("/subwayDetailView.do")
    public ModelAndView subwayDetailView(int id){
    	ModelAndView mav = new ModelAndView();
    	ExpenseApplySubway subwayApply = expenseApplySubwayService.selectByPrimarykey(id);
    	mav.addObject("subwayApply", subwayApply);
    	mav.setViewName("expense/approveInMicroApp/expense_view_subway");
    	return mav;
    }
    /**
     * 钉钉微应用内地铁公交报销详情查看
     * @param request
     * @param id
     * @return
     */
    @RequestMapping("/go_expense_view_subway.do")
    public ModelAndView viewSubwayInMicroApp(HttpServletRequest request,int id){
    	ModelAndView mav = new ModelAndView();
    	ExpenseApplySubway subwayApply = expenseApplySubwayService.selectByPrimarykey(id);
    	mav.addObject("subwayApply", subwayApply);
    	mav.setViewName("expense/approveInMicroApp/expense_view_subway");
    	return mav;
    }
    /**
     * 钉钉微应用内旅店报销详情查看
     * @param request
     * @param id
     * @return
     */
    @RequestMapping("/go_expense_view_hotel.do")
    public ModelAndView viewhotelInMicroApp(HttpServletRequest request,int id){
    	ModelAndView mav = new ModelAndView();
    	ExpenseApplayHotel expenseApplayHotel=expenseApplayHotelService.selectById(id);
    	mav.addObject("expenseApplayHotel", expenseApplayHotel);
    	mav.setViewName("expense/approveInMicroApp/expense_view_hotel");
    	return mav;
    }
    /**
     * 钉钉微应用大巴报销详情查看
     * @param request
     * @param id
     * @return
     */
    @RequestMapping("/go_expense_view_bus.do")
    public ModelAndView viewBusInMicroApp(HttpServletRequest request,int id){
    	ModelAndView mav = new ModelAndView();
    	ExpenseApplayBus expenseApplayBus = expenseBusService.selectById(id);
		mav.addObject("expenseApplayBus", expenseApplayBus);
    	mav.setViewName("expense/approveInMicroApp/expense_view_bus");
    	return mav;
    }
    /**
     * 钉钉微应用内火车票报销详情查看
     * @param request
     * @param id
     * @return
     */
  	@RequestMapping("/go_expense_view_train.do")
  	public ModelAndView viewTrainInMicroApp(HttpServletRequest request,int id){
  		ModelAndView mav = new ModelAndView();
  		ExpenseApplayTrain expenseApplayTrain = expenseApplayTrainService.selectById(id);
  		mav.addObject("expenseApplayTrain", expenseApplayTrain);
  		mav.setViewName("expense/approveInMicroApp/expense_view_train");
  		return mav;
  	}
  	/**
  	 * 火车票报销批量审批
  	 * @param request
  	 * @param id
  	 * @param result
  	 * @return
  	 */
  	@RequestMapping("/approve_train_updates.do")
    @ResponseBody
    public String approve_train_updates(HttpServletRequest request,String ids,String result){
  		System.out.println("火车票");
  		String ids01[] = ids.split(",");
  		try{
  		  for(String id : ids01){
  			//找出这条审批记录
  			ExpenseApplayTrain expenseApplayTrain=expenseApplayTrainService.selectById(Integer.parseInt(id));
    		if("agree".equals(result)){
    		//进行下一步的处理,发消息或者只更新审批状态
    		expenseApplayTrain = expenseApplayTrainService.sendTONextManager(expenseApplayTrain);
    		}else if("disagree".equals(result)){
    			expenseApplayTrain = expenseApplayTrainService.refuseOption(expenseApplayTrain);
    		}
        	expenseApplayTrainService.saveOrUpdate(expenseApplayTrain);  
        	
  		  }   
  		  return "success";
  		}catch(Exception e){
  			return "fail";
  		}
    }
  	 /**
  	  * 地铁公交报销批量审批
  	  * @param id
  	  * @param result
  	  * @return
  	  */
    @RequestMapping("/approve_subway_updates.do")
    public @ResponseBody String  expense_subway_approve_updates(String ids,String result){
    	String ids01[] = ids.split(",");
    	System.out.println("地铁公交");
    	//根据ID找到这条报销记录
    	try{	
    		for(String id : ids01){
    			ExpenseApplySubway subwayApply=expenseApplySubwayService.selectByPrimarykey(Integer.parseInt(id));
    			if("agree".equals(result)){//审批同意操作
    				subwayApply=expenseApplySubwayService.sendTONextManager(subwayApply);
    			}else if("disagree".equals(result)){//驳回操作
    				subwayApply=expenseApplySubwayService.refuseOption(subwayApply);
    			}
    			expenseApplySubwayService.saveOrUpdate(subwayApply);
    			}
    		return "success";
    	}catch(Exception e){
    		return "fail";
    	}
    }
    /**
     * 大巴报销批量审批
     * @param request
     * @param id
     * @param result
     * @return
     */
    @RequestMapping("/approve_bus_updates.do")
    @ResponseBody
    public String to_approve_bus_updates(HttpServletRequest request,String ids,String result){
        System.out.println(ids);
    	System.out.println(result);
    	System.out.println("大巴");
    	String ids01[] = ids.split(",");
    try{
    	for(String id : ids01){
    			//找出这条审批记录
    		ExpenseApplayBus expenseApplayBus = expenseBusService.selectById(Integer.parseInt(id));
    		if("agree".equals(result)){
    				//报销审批处理流程具体实现
    			expenseApplayBus= expenseBusService.sendTONextManager(expenseApplayBus);
    		}else if("disagree".equals(result)){
    			expenseApplayBus=expenseBusService.refuseOption(expenseApplayBus);
    		}	
    		expenseBusService.saveOrUpdate(expenseApplayBus);
    	}
       	return "success";
     }catch(Exception e){
    	 return "fail";
     }
    }
    /**
     * 旅店报销批量审批
     * @param request
     * @param id
     * @param result
     * @return
     */
    @RequestMapping("/approve_hotel_updates.do")
    @ResponseBody
    public String approve_hotel_updates(HttpServletRequest request,String ids,String result){
    	String ids01[] = ids.split(",");
    	try{
    		for(String id :ids01){
    			//查询该条报销记录
    			ExpenseApplayHotel expenseApplayHotel = expenseApplayHotelService.selectById(Integer.parseInt(id));
    			if("agree".equals(result)){
    				//各级管理员审核报销
    				expenseApplayHotel = expenseApplayHotelService.sendTONextManager(expenseApplayHotel);
    			}else if("disagree".equals(result)){
    				expenseApplayHotel= expenseApplayHotelService.refuseOption(expenseApplayHotel);
    			}
    			expenseApplayHotelService.saveOrUpdate(expenseApplayHotel);
    			}
    		return "success";
    	}catch(Exception e){
    			return "fail";
    	}
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
