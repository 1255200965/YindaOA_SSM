package com.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.service.IDepartmentService;
import com.service.IItemChangeService;
import com.service.IOrderChangeService;
import com.service.IOrderService;
import com.service.IStaffInfoService;
import com.util.DDMessageUtil;
import com.util.DDSendMessageUtil;
import com.util.GlobalConstant;
import com.util.OrderMessage;
import com.util.OrderMessageUtil;
import com.util.SendOrderMessageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dao.YoItemChangeMapper;
import com.dao.YoOrderChangeMapper;
import com.model.Department;
import com.model.DepartmentExample;
import com.model.StaffInfo;
import com.model.YoItemChange;
import com.model.YoItemChangeExample;
import com.model.YoOrderChange;


@Controller
@RequestMapping("ItemChange")
public class ItemChangeController {
	@Autowired
	private IItemChangeService itemChangeService;
	@Autowired
	private YoItemChangeMapper itemChangeMapper;
	@Autowired
	private SendOrderMessageUtil sendOrderMessageUtil;
	@Autowired
	private OrderMessageUtil orderMessageUtil;
	@Autowired
	private  IStaffInfoService iStaffInfoService;
	@Autowired
    private YoOrderChangeMapper yoOrderChangeMapper;
	
	@Autowired
	private IOrderService iOrderService;
	@Autowired
	private  IOrderChangeService iOrderChangeService;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat msdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@RequestMapping("/toItemChange.do")
	public ModelAndView toItemChange(HttpServletRequest request,YoItemChange itemChange){
		ModelAndView mav = new ModelAndView();
		YoItemChange itemChange2 = itemChange;
		List<YoItemChange> itemChangeList =  itemChangeService.selectByPropertities(itemChange);
		mav.addObject("itemChangeList",itemChangeList);
		mav.addObject("itemChange2", itemChange2);
		mav.setViewName("itemchange");
		return mav;
	}

	/**
	 * 根据id 获取单条项目变更
	 */
	@RequestMapping("/getItemChangeById.do")
	@ResponseBody
	public ModelAndView getItemChangeById(String id){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/order/approve_order");
		YoItemChange itemChange= itemChangeMapper.selectByPrimaryKey(Integer.valueOf(id));
		mav.addObject("itemChange", itemChange);
		return mav;
	}

   

	/**
	 * 获取申请人的所有项目审批列表

	 */
	@RequestMapping("/getItemChangeByStaffId.do")
	@ResponseBody
	public List<YoItemChange> getItemChangeByStaffId(HttpServletRequest request ){
		String user_staffId =(String) request.getSession().getAttribute(GlobalConstant.user_staffId);
		List<YoItemChange> itemChangeList= itemChangeService.getItemChangeByStaffId(user_staffId);
		return itemChangeList;
	}

	/**
	 * 提交项目变更
	 */
	@RequestMapping("/add_ItemChange.do")
	@ResponseBody
	public String  add_ItemChange(
			String department,
			String project,
			String orderName,
			String businessProperty,
			String changeProvince,
			String changeCity,
			String outdoor,
			String beginTime,
			String yindaIdentify,
			String contractType,
			String remark,
			String lte,			
			HttpServletRequest request){

		String user_staffId =(String) request.getSession().getAttribute(GlobalConstant.user_staffId);
		String staff_user_id =(String) request.getSession().getAttribute(GlobalConstant.user_staff_user_id);
		String user_name =(String) request.getSession().getAttribute(GlobalConstant.user_name);
		if(user_staffId==null||"".equals(staff_user_id)){
			return "Yinda OA without your information ,Please contact administrators!";
		}
		String assess ="";
		List <String> approverList = sendOrderMessageUtil.getApprovers(department,project);
	
		if(approverList==null||approverList.size()==0){
			return "You don't have a target for approval,Please contact administrators!";
		}
		System.out.println("审批人列表"+approverList.toString());	
		
		String toUser=null;		
		YoOrderChange orderChange  = new YoOrderChange();
		orderChange.setBusinessProperty(businessProperty);
		orderChange.setLte(lte);
		orderChange.setChangeCity(changeCity);
		orderChange.setChangeProvince(changeProvince);
		orderChange.setContractType(contractType);
		orderChange.setDepartment(department);		
		orderChange.setModifyUser(user_name);
		orderChange.setOrderName(orderName);
		orderChange.setOrderRemark(remark);
		orderChange.setOutdoorJob(outdoor);
		orderChange.setModifyTime(msdf.format(new Date())+"");
		orderChange.setYindaIdentify(yindaIdentify);
		orderChange.setStaffUserId(staff_user_id);
		orderChange.setStaffId(user_staffId);
		orderChange.setUsername(user_name);
        orderChange.setProject(project);
        orderChange.setOrderNumber( iOrderService.getOrderNumberByName(orderName));
       
       
		
		orderChange.setEffectTime(beginTime);
		orderChange.setStaffId(user_staffId);
		//对于挂职在一级部门的员工
		if(approverList.size() >1){
		toUser=approverList.get(1);
		orderChange.setAssess(approverList.get(1)+"|"+approverList.get(0));
		orderChange.setNowAcess(approverList.get(1));
		}else{//对于挂职在二级部门下的员工
			toUser=approverList.get(0);
			orderChange.setAssess(approverList.get(0));
			orderChange.setNowAcess(approverList.get(0));
		}
		int i= yoOrderChangeMapper.add(orderChange);
		
		if(i>0){
			OrderMessage message = new OrderMessage();//正式服务器ip 121.40.29.241 //测试服务器ip yexianglei.ngrok.cc
			message.setMessageUrl("http://121.40.29.241/YindaOA/orderChange/approve_order_page.do?id="+orderChange.getId()+"&staff_user_id="+orderChange.getNowAcess());
			message.setPicUrl("/cc");
			System.out.println("第一次发送："+orderChange.getNowAcess());
			message.setToUser(orderChange.getNowAcess());
			message.setToParty("");
			message.setTitle(user_name+"的项目变更申请");
			message.setDepartment(department);
			message.setOrderName(orderName);
			message.setProject(project);
			message.setUsername(user_name);
			orderMessageUtil.sendMessage(message);
			//yoOrderChangeMapper.updateByPrimaryKeySelective(orderChange2);			
			return "success";
		}else{
			return "error";
		}

	}


	
}
