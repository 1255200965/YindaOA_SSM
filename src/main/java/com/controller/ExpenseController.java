package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import com.ddSdk.auth.AuthHelper;
import com.model.ExpenseApplayBus;
import com.model.ExpenseApplayHotel;
import com.model.ExpenseApplayTaxi;
import com.model.ExpenseApplayTrain;
import com.model.StaffInfo;
import com.service.IExpenseApplayBusService;
import com.service.IExpenseApplayHotelService;
import com.service.IExpenseApplayTaxiService;
import com.service.IExpenseApplayTrainService;
import com.service.IStaffInfoService;
import com.util.DDUtil;
import com.util.GlobalConstant;
import com.util.ImgUpload;

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
	//出差审批界面跳转
	@RequestMapping("/toExpense_applay.do")
	public ModelAndView toExpense_applay(HttpServletRequest request){
		ModelAndView mav =new ModelAndView();
		String config=AuthHelper.getConfig(request);
		request.setAttribute("config", config);
		mav.setViewName("expense/expense_applay");
		return mav;
	}
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
		mav.addObject("expenseApplayTrain", expenseApplayTrain);
		mav.setViewName("expense/expense_view_train");
		return mav;
	}
	
	//火车票报销界面跳转--新增
    @RequestMapping("/toExpense_train.do")
    public ModelAndView toExpense_train(HttpServletRequest request,ExpenseApplayTrain expenseApplayTrain){
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("expense/expense_train");
    	return mav;
    }
    @RequestMapping("/expense_train_save.do")
    @ResponseBody
    public String expense_train_save(HttpServletRequest request,ExpenseApplayTrain expenseApplayTrain){
    	//添加报销信息状态为待审核
    	expenseApplayTrain.setApplayStatus("待审核");
    	/*添加当前报销人信息*/
    	expenseApplayTrain.setStaffId((String) request.getSession().getAttribute(GlobalConstant.user_staffId));
    	expenseApplayTrain.setStaffName((String) request.getSession().getAttribute(GlobalConstant.user_name));
    	expenseApplayTrain.setStaffDepart((String) request.getSession().getAttribute(GlobalConstant.user_department));
    	expenseApplayTrain.setStaffUserId((String) request.getSession().getAttribute(GlobalConstant.user_staff_user_id));
    	/*添加当前报销人信息*/
    	try{
    		expenseApplayTrainService.saveOrUpdate(expenseApplayTrain);
    		return "success";
    	}catch(Exception e){
    		return "fail";
    	}
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

    	//将新记录的状态记为待审核
    	expenseApplayBus.setApplayStatus("待审核");
    	/*新增人员信息*/
    	expenseApplayBus.setStaffId((String)request.getSession().getAttribute(GlobalConstant.user_staffId));
    	expenseApplayBus.setStaffName((String)request.getSession().getAttribute(GlobalConstant.user_name));
    	expenseApplayBus.setStaffDepart((String)request.getSession().getAttribute(GlobalConstant.user_department));
    	expenseApplayBus.setStaffUserId((String)request.getSession().getAttribute(GlobalConstant.user_staff_user_id));
    	/*新增人员信息*/
    
    	try {
    		/*图片存储*/
        	MultipartRequest mRequest = (MultipartRequest)request;
        	MultipartFile mFile= mRequest.getFile("image");
        	//原始图片名称
        	String originalName=mFile.getName();
        	//图片存储的物理路径
    		String basePath =ImgUpload.IMG_PATH;
    		//新的图片名称,设置后缀为.png
    		String newFileName=UUID.randomUUID()+originalName+".png";
    		//新图片
        	File file = new File(basePath+newFileName);
        	//将mFile文件的内容写入file
			mFile.transferTo(file);
			//数据库中记录图片存放位置信息
			expenseApplayBus.setImageUrl(basePath+newFileName);
			/**信息存储**/
			expenseBusService.saveOrUpdate(expenseApplayBus);
	    	return "redirect:toExpense_bus.do?data="+"success";
	    	/**信息存储**/
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
    /** 
     * 出租车报销
     */
    //出租车报销界面跳转--新增
    @RequestMapping("/toExpense_taxi.do")
    public ModelAndView toExpense_taxi(HttpServletRequest request){
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("expense/expense_taxi");
    	return mav;
    }
    //出租车报销表单提交
    @RequestMapping("/toExpense_taxi_save.do")
    @ResponseBody
    public String toExpense_taxi_save(HttpServletRequest request,ExpenseApplayTaxi expenseApplayTaxi){
    	//新增报销信息状态为待审核
    	expenseApplayTaxi.setApplayStatus("待审核");
    	/*当前申请人信息记录*/
    	expenseApplayTaxi.setStaffId((String) request.getSession().getAttribute(GlobalConstant.user_staffId));
    	expenseApplayTaxi.setStaffName((String)request.getSession().getAttribute(GlobalConstant.user_name));
    	expenseApplayTaxi.setStaffDepart((String) request.getSession().getAttribute(GlobalConstant.user_department));
    	expenseApplayTaxi.setStaffUserId((String) request.getSession().getAttribute(GlobalConstant.user_staff_user_id));
    	/*当前申请人信息记录*/
    	try{
    		expenseApplayTaxiService.saveOrUpdate(expenseApplayTaxi);
    		return "success";
    	}catch(Exception e){
    		e.printStackTrace();
    		return "fail";
    	}
    }
    //出租车报销界面跳转--历史信息查看
    @RequestMapping("/toExpense_history_taxi.do")
    public ModelAndView toExpense_history_taxi(HttpServletRequest request){
    	ModelAndView mav =new ModelAndView();
    	String staffId=(String) request.getSession().getAttribute(GlobalConstant.user_staffId);
    	List<ExpenseApplayTaxi> expenseApplayTaxiList = expenseApplayTaxiService.selectByStaffId(staffId);
    	mav.addObject("expenseApplayTaxiList", expenseApplayTaxiList);
    	mav.setViewName("expense/expense_history_taxi");
    	return mav;
    }
    //出租车报销界面跳转--详细信息查看界
    @RequestMapping("/toExpense_view_taxi")
    public ModelAndView toExpense_view_taxi(HttpServletRequest request,int id){
    	ModelAndView mav = new ModelAndView();
    	ExpenseApplayTaxi expenseApplayTaxi = expenseApplayTaxiService.selectById(id);
    	mav.addObject("expenseApplayTaxi", expenseApplayTaxi);
    	mav.setViewName("expense/expense_view_taxi");
    	return mav;
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
    @ResponseBody
    public String toExpense_hotel_save(HttpServletRequest request,ExpenseApplayHotel expenseApplayHotel){
    	//重置报销信息为待审核状态
    	expenseApplayHotel.setApplayStatus("待审核");
    	/*记录当前报销人信息*/
    	expenseApplayHotel.setStaffId((String) request.getSession().getAttribute(GlobalConstant.user_staffId));
    	expenseApplayHotel.setStaffName((String) request.getSession().getAttribute(GlobalConstant.user_name));
    	expenseApplayHotel.setStaffDepart((String) request.getSession().getAttribute(GlobalConstant.user_department));
    	expenseApplayHotel.setStaffUserId((String) request.getSession().getAttribute(GlobalConstant.user_staff_user_id));
    	/*记录当前报销人信息*/
    	try{
    		expenseApplayHotelService.saveOrUpdate(expenseApplayHotel);
    		return "success";
    	}catch(Exception e){
    		return "fail";
    	}
    }
}
