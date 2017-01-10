package com.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.jdbc.support.incrementer.H2SequenceMaxValueIncrementer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.dao.YoOrderMapper;
import com.ddSdk.auth.AuthHelper;
import com.ecache.Impl.SystemCacheImpl;
import com.model.StaffInfo;
import com.model.YoItemChange;
import com.model.YoItemChangeExample;
import com.model.YoOrder;
import com.service.IOrderService;
import com.service.IStaffInfoService;
import com.util.DDUtil;
import com.util.GlobalConstant;

import com.util.StringUtil;



@Controller
@RequestMapping("order")
public class OrderController {	
	@Autowired
	private IOrderService iOrderService;
	
	@Autowired
	private YoOrderMapper orderMapper;
	
	 
	@Autowired
	private IStaffInfoService iStaffInfoService;
	
	 ValueWrapper departmentCache =SystemCacheImpl.cache.get("department");
	 
	 ValueWrapper projectCache =SystemCacheImpl.cache.get("project");
	 ValueWrapper orderCache =SystemCacheImpl.cache.get("order");
	/**
	 * 订单系统界面
	 * @return
	 */
	@RequestMapping("/search_order_page.do")
	public ModelAndView search_order_page(){     
		ModelAndView mav = new ModelAndView();	
		mav.setViewName("order/search_order");
		
		return mav;
	}
	
	 
	
	/**
	 * 项目变更主界面
	 * @return
	 */
	@RequestMapping("/order_mainPage.do")
	public ModelAndView order_mainPage(HttpServletRequest request){		
		ModelAndView mav = new ModelAndView();		
	 	String config= AuthHelper.getConfig(request);
	 	System.out.println("config:"+config);
	 	request.setAttribute("config", config);
		mav.setViewName("order/order_mainPage");		
		return mav;
	}
	
	
	@RequestMapping("/change_order_apply_page.do")
	public ModelAndView change_order_apply_page(HttpServletRequest request){		
		ModelAndView mav = new ModelAndView();		
	 	String config= AuthHelper.getConfig(request);
	 	System.out.println("config:"+config);
	 	request.setAttribute("config", config);
		mav.setViewName("order/change_order_apply");		
		return mav;
	}
	
	/**
	 * 项目变更申请界面
	 * @return
	 */
	@RequestMapping("/login.do")
	public void login(HttpServletRequest request,String code){		
		String staffUserId=DDUtil.getUserID(code);
		System.out.println("staffUserId:"+staffUserId);
		//从数据库中获得该员工的所有信息
		StaffInfo staffInfo= iStaffInfoService.selectStaffByID(staffUserId);
		//在当前回话session中存储相关信息
		String staffId ="99999";
		String user_staff_id = "071536130021650043";
		String department ="创新事业部";
		String username ="叶祥磊";
//		request.getSession().setAttribute(GlobalConstant.user_staffId, staffId);
//		request.getSession().setAttribute(GlobalConstant.user_department, department);
//		request.getSession().setAttribute(GlobalConstant.user_staff_user_id,user_staff_id);
//		request.getSession().setAttribute(GlobalConstant.user_name,username);
		request.getSession().setAttribute(GlobalConstant.user_staffId, staffInfo.getStaffId());
		request.getSession().setAttribute(GlobalConstant.user_department, staffInfo.getDepartment());
		request.getSession().setAttribute(GlobalConstant.user_staff_user_id,staffInfo.getStaffUserId());
		request.getSession().setAttribute(GlobalConstant.user_name,staffInfo.getName());
		request.getSession().setAttribute("contractType",staffInfo.getContractType());
		
	}
	

	/**
	 * 获取部门
	 * @return
	 */
	@RequestMapping("/getDepartment.do")
	@ResponseBody
	public 	List<String> getDepartment(){		
        List<String> orderList = (List<String>) departmentCache.get();
        
		return orderList;
	}
	/**
	 * 根据部门获取项目
	 * @param department
	 * @return
	 */
	@RequestMapping("/getProjectByDepartment.do")
	@ResponseBody
	public 	List<String> getProjectByDepartment(String department){		
		//List<YoOrder> orderList = iOrderService.getProjectByDepartment(department);
		Map<String,List<String>>  projectMap = (Map) projectCache.get();
		List<String> orderList = (List<String>) projectMap.get(department);
		return orderList;
	}
	
	/**
	 * 根据项目获取项目下的所有订单
	 * @param department
	 * @return
	 */
	@RequestMapping("/getOrderByDepartmentAndProject.do")
	@ResponseBody
	public 	List<String> getOrderByDepartmentAndProject(String department,String project){	
		
		//List<YoOrder> orderList= iOrderService.getOrderByDepartmentAndProject(department, project);	
		Map<String,String> orderMap = (Map) orderCache.get();
		List<String> strList = new ArrayList<String>();
		for(Map.Entry<String,String> entry : orderMap.entrySet())   //循环所有的部门
    	{    
			if(entry.getValue()!=null&&entry.getValue().equals(department+project)){
				strList.add(entry.getKey());
			}   	     
    	}  
		return strList;
	}
	
	
	/**
	 * 根据项目获取项目下的所有订单
	 * @return
	 */
	@RequestMapping("/getRemarkByOrder.do")
	@ResponseBody
	public 	List<String> getRemarkByOrder(YoOrder order){	
		List<String> remarkList = new ArrayList<String>();
		List<YoOrder> orderList= iOrderService.getOrderList(order);
		if(orderList==null||orderList.size()==0){
			return null;
		}
		String remark = orderList.get(0).getBusinessProperty();//数据库字段替换
		if(remark!=null){
			if(remark.contains("|")){
			String [] strList =remark.split("\\|");
			remarkList =Arrays.asList(strList);
			}			
		}
		return remarkList;
	}
	
	
	/**
	 * 订单查询
	 * @param oder
	 * @return
	 */
	@RequestMapping("/search_order.do")
	@ResponseBody
	public 	List<YoOrder> search_order(YoOrder oder){
	System.out.println(iOrderService.getOrderList(oder));
		return iOrderService.getOrderList(oder);
	}
	
	/**
	 * 根据主键获取订单对象
	 * @param id
	 * @return
	 */
	@RequestMapping("/get_order_by_id.do")
	@ResponseBody
	public 	YoOrder get_order_by_id(String id){
			return orderMapper.selectByPrimaryKey(Integer.valueOf(id));
	}
	
	/**
	 * 更新订单
	 * @param oder
	 * @return
	 */
	@RequestMapping("/update_order.do")
	@ResponseBody
	public 	String update_order(YoOrder oder){
		YoOrder	sqlorder =orderMapper.selectByPrimaryKey(oder.getId());
		String orderName=oder.getOrderName();
		String department=oder.getDepartment();
		String project=oder.getProject();
		try{			
			if(StringUtil.NotBlank(oder.getOrderName())){sqlorder.setOrderName(orderName); }
			if(StringUtil.NotBlank(oder.getProject())) {sqlorder.setProject(project); }
			if(StringUtil.NotBlank(oder.getOrderName())){sqlorder.setDepartment(department); }
			orderMapper.updateByPrimaryKey(sqlorder);			
			return "success";
		}catch(Exception e){
			System.out.println("更新出错");
			return "error";
		}

	}
	
	/**
	 * 根据主键删除订单
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete_order.do")
	@ResponseBody
	public 	String delete_order(String id){
		try{
			orderMapper.deleteByPrimaryKey(Integer.valueOf(id));
			return "success";
		}catch(Exception e){
			return "error";
		}
		
	}
	
	
	/**
	 * 新增订单
	 * @return
	 */
	@RequestMapping("/add_order.do")
	@ResponseBody
	public 	String add_order(YoOrder order){
		try{
			orderMapper.insert(order);
			return "success";
		}catch(Exception e){
			return "error";
		}
		
	}
	
	/**
	 * 获取staffinfo表中 商务等级yinda_identify
	 * @return
	 */
	@RequestMapping("/getIdentifyInStallInfo.do")
	@ResponseBody
	public List<StaffInfo> getIdentifyInStallInfo(HttpServletRequest request){	
		String user_staffId =(String) request.getSession().getAttribute(GlobalConstant.user_staffId);
		System.out.println(user_staffId);
		List<StaffInfo> staffInfoList = iStaffInfoService.getIdentifyInStallInfo(user_staffId);		
		return staffInfoList;
	}
	
	
	/**
	 * 获取staffinfo表中 合同属性contract_type
	 * @return
	 */
	@RequestMapping("/getContract_typeInStallInfo.do")
	@ResponseBody
	public List<StaffInfo> getContract_typeInStallInfo(HttpServletRequest request){
		String user_staffId =(String) request.getSession().getAttribute(GlobalConstant.user_staffId);
		List<StaffInfo> staffInfoList = iStaffInfoService.getContract_typeInStallInfo(user_staffId);
		
		return staffInfoList;
	}
	
	


}
