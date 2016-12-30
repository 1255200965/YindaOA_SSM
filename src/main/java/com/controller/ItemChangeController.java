package com.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.service.IItemChangeService;
import com.service.IOrderChangeService;
import com.service.IStaffInfoService;
import com.util.DDMessageUtil;
import com.util.DDSendMessageUtil;
import com.util.GlobalConstant;
import com.util.OrderMessage;
import com.util.OrderMessageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dao.YoItemChangeMapper;
import com.dao.YoOrderChangeMapper;
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
	private DDSendMessageUtil ddSendMessageUtil;
	@Autowired
	private OrderMessageUtil orderMessageUtil;
	@Autowired
	private  IStaffInfoService iStaffInfoService;
	@Autowired
    private YoOrderChangeMapper yoOrderChangeMapper;
	
	@Autowired
	private  IOrderChangeService iOrderChangeService;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
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
			HttpServletRequest request){

		String user_staffId =(String) request.getSession().getAttribute(GlobalConstant.user_staffId);
		String staff_user_id =(String) request.getSession().getAttribute(GlobalConstant.user_staff_user_id);
		String user_name =(String) request.getSession().getAttribute(GlobalConstant.user_name);
		String assess ="";
		List <String> approverList = ddSendMessageUtil.getApprovers(staff_user_id);
		System.out.println("审批人列表"+approverList.toString());
		String toUser=null;
		
		YoOrderChange orderChange  = new YoOrderChange();
		orderChange.setBusinessProperty(businessProperty);
		orderChange.setChangeCity(changeCity);
		orderChange.setChangeProvince(changeProvince);
		orderChange.setContractType(contractType);
		orderChange.setDepartment(department);		
		orderChange.setModifyUser(user_name);
		orderChange.setOrderName(orderName);
		orderChange.setOrderRemark(remark);
		orderChange.setOutdoorJob(outdoor);
		orderChange.setModifyTime(sdf.format(new Date())+"");
		orderChange.setYindaIdentify(yindaIdentify);
		orderChange.setStaffUserId(staff_user_id);
		orderChange.setStaffId(user_staffId);
		orderChange.setUsername(user_name);
		orderChange.setProject(project);
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
			OrderMessage message = new OrderMessage();
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
/*	@RequestMapping("/approve_order_page.do")
	public ModelAndView approve_order_page(String id,HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		YoOrderChange orderChange =yoOrderChangeMapper.selectByPrimaryKey(Integer.valueOf(id));
		String approveId =orderChange.getStaffUserId();//根据项目申请中查找申请人的ID
		StaffInfo approve =iStaffInfoService.selectStaffByID(approveId); //根据申请人的ID查找审批人
		String approveName = approve.getName();//获取审批人的姓名
		mav.addObject("itemChange", orderChange);
		mav.addObject("approveName", approveName);
		mav.addObject("alength", approveName.length());
		mav.setViewName("/order/approve_order");
		return mav;
	}


	@RequestMapping("/pass_approve.do")
	@ResponseBody
	public String pass_approve(String id,HttpServletRequest request){

		YoItemChange itemChange =itemChangeMapper.selectByPrimaryKey(Integer.valueOf(id));
		itemChange.setIcApproveState("完成");
		itemChange.setIcApproveResult("同意");
		try{
			itemChangeMapper.updateByPrimaryKey(itemChange);
			return "success";
		}catch(Exception e){
			return "error";
		}

	}


	@RequestMapping("/refuse_approve.do")
	@ResponseBody
	public String refuse_approve(String id,HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		YoItemChange itemChange =itemChangeMapper.selectByPrimaryKey(Integer.valueOf(id));
		itemChange.setIcApproveResult("拒绝");
		itemChange.setIcApproveState("完成");
		try{
			itemChangeMapper.updateByPrimaryKey(itemChange);
			return "success";
		}catch(Exception e){
			return "error";
		}
	}*/

	@RequestMapping("toItemchange_history.do")
	public ModelAndView toItemchange_history(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		YoItemChangeExample example = new YoItemChangeExample();
		YoItemChangeExample.Criteria criteria = example.createCriteria();
		String staffId = (String) request.getSession().getAttribute(GlobalConstant.user_staffId);

		criteria.andIcAskStaffIdEqualTo(staffId);
		List<YoItemChange> itemChangeList = itemChangeMapper.selectByExample(example);
		mav.addObject("itemChangeList", itemChangeList);
		mav.setViewName("order/itemchange_history");
		return mav;
	}
	//单条项目变更信息详情查看
	@RequestMapping("itemChange_view.do")
	public ModelAndView itemChange_view(HttpServletRequest request,int id){
		ModelAndView  mav = new ModelAndView();
		YoItemChange itemChange = new YoItemChange();
		itemChange=itemChangeMapper.selectByPrimaryKey(id);
		mav.addObject("itemChange",itemChange);
		mav.setViewName("order/itemchange_view");
		return mav;
	}
}
