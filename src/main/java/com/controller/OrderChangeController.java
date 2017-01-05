package com.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dao.StaffInfoMapper;
import com.dao.YoOrderChangeMapper;
import com.dao.YoStaffCurrentOrderMapper;
import com.dao.YoStaffDailyOrderMapper;
import com.model.Department;
import com.model.DepartmentExample;
import com.model.StaffInfo;
import com.model.YoItemChange;
import com.model.YoOrderChange;
import com.model.YoStaffCurrentOrder;
import com.model.YoStaffDailyOrder;
import com.service.IDepartmentService;
import com.service.IOrderChangeService;
import com.service.IStaffCurrentOrderService;
import com.service.IStaffInfoService;
import com.util.DDUtil;
import com.util.GlobalConstant;

@Controller
@RequestMapping("orderChange")
public class OrderChangeController {

	@Autowired
	private  IOrderChangeService iOrderChangeService;
	@Autowired
	private YoOrderChangeMapper yoOrderChangeMapper;
	@Autowired
	private  IStaffInfoService iStaffInfoService;
	@Autowired
	private  YoStaffCurrentOrderMapper staffCurrentOrderMapper;
	@Autowired
	private  IStaffCurrentOrderService iStaffCurrentOrderService;

	@Autowired
	private  StaffInfoMapper staffInfoMapper;
	@Autowired
	private  IDepartmentService departmentService;
	@Autowired
	private  YoStaffDailyOrderMapper staffDailyOrderMapper;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat msdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@RequestMapping("/approve_order_page.do")
	public ModelAndView approve_order_page(String id,HttpServletRequest request,String staff_user_id){
		ModelAndView mav = new ModelAndView();
		System.out.println("当前界面的staffuserid"+staff_user_id);
		YoOrderChange orderChange =yoOrderChangeMapper.selectByPrimaryKey(Integer.valueOf(id));
		String approveId =orderChange.getStaffUserId();//根据项目申请中查找申请人的ID
		StaffInfo approve =iStaffInfoService.selectStaffByID(approveId); //根据申请人的ID查找审批人
		List <StaffInfo> identifyList = staffInfoMapper.getAllIdentifyInStallInfo();
		String approveName = approve.getName();//获取审批人的姓名
		System.out.println("商务等级长度"+identifyList.size());
		mav.addObject("identifyList", identifyList);
		mav.addObject("itemChange", orderChange);
		mav.addObject("approveName", approveName);
		mav.addObject("staff_user_id", staff_user_id);
		mav.addObject("alength", approveName.length());
		mav.setViewName("/order/approve_order");
		return mav;

	}



	@RequestMapping("/approve_order_page_in.do")
	public ModelAndView approve_order_page_in(String id,HttpServletRequest request,String staff_user_id){
		ModelAndView mav = new ModelAndView();
		System.out.println("当前界面的staffuserid"+staff_user_id);
		YoOrderChange orderChange =yoOrderChangeMapper.selectByPrimaryKey(Integer.valueOf(id));
		String approveId =orderChange.getStaffUserId();//根据项目申请中查找申请人的ID
		StaffInfo approve =iStaffInfoService.selectStaffByID(approveId); //根据申请人的ID查找审批人
		List <StaffInfo> identifyList = staffInfoMapper.getAllIdentifyInStallInfo();
		String approveName = approve.getName();//获取审批人的姓名
		System.out.println("商务等级长度"+identifyList.size());
		mav.addObject("identifyList", identifyList);
		mav.addObject("itemChange", orderChange);
		mav.addObject("approveName", approveName);
		mav.addObject("staff_user_id", staff_user_id);
		mav.addObject("alength", approveName.length());
		mav.setViewName("/order/approve_order2");
		return mav;
	}

	/**
	 * 审批通过
	 * @param id 项目信息变更的Id
	 * @param request
	 * @return
	 */
	@RequestMapping("/pass_approve.do")
	@ResponseBody
	public String pass_approve(String id,HttpServletRequest request,String identify,String orderRemark,String businessProp,String outdoorJob3,String lte3){

		YoOrderChange itemChange =yoOrderChangeMapper.selectByPrimaryKey(Integer.valueOf(id));
		itemChange.setOrderStatus("审核通过");
		itemChange.setYindaIdentify(identify);//前端修改的商务属性
		itemChange.setBusinessProperty(businessProp);
		itemChange.setOrderRemark(orderRemark);
		itemChange.setOutdoorJob(outdoorJob3);
		itemChange.setLte(lte3);
		try{
			yoOrderChangeMapper.updateByPrimaryKey(itemChange);
			itemChange.setModifyTime(msdf.format(new Date()));
			YoOrderChange OrderChange =iOrderChangeService.sendTONextManager(itemChange);
			if(OrderChange.getOrderResult()!=null&&!"".equalsIgnoreCase(OrderChange.getOrderResult())){
				String user_staff_id = itemChange.getStaffUserId();//申请通过后 项目中声请人的钉钉号
				String staff_id =itemChange.getStaffId();

				//查询department表是否有当前项目 如果没有该项目 ，申请提交的项目无效，只改变订单
				DepartmentExample example = new DepartmentExample();
				DepartmentExample.Criteria criteria = example.createCriteria();    	
				criteria.andDepNameEqualTo(OrderChange.getProject());
				List<Department> projectList= departmentService.selectByExample(example); //从department表中获取项目

				//第1步 根据根据用户的钉钉号查找当前订单信息中是否有该用户的订单
				YoStaffCurrentOrder staffCurentOrder =iStaffCurrentOrderService.getStaffCurrentOrderByStaff_user_id(user_staff_id);
				//第2步 获取审批中的项目变更新的信息
				String businessProperty=itemChange.getBusinessProperty();
				String lte =itemChange.getLte();
				String effectTime =itemChange.getEffectTime();
				String department= itemChange.getDepartment();
				String orderCity= itemChange.getChangeCity();
				String orderProvince =itemChange.getChangeProvince();
				String orderYear=itemChange.getOrderYear();
				String outdoorJob= itemChange.getOutdoorJob();
				String principal =itemChange.getPrincipal();
				String scoContratType=itemChange.getContractType();
				String scoOrderName=itemChange.getOrderName();
				String scoOrderNo=itemChange.getOrderNumber();
				
				String scoProjectName= itemChange.getProject();
				String yindaIdentify=itemChange.getYindaIdentify();
				if (staffCurentOrder==null){
					//如果当前订单表中中没有 该订单信息 创建新的当前订单信息表
					staffCurentOrder = new YoStaffCurrentOrder();
				}else{
					//将当前订单表中的订单信息存入历史订单表中
					/*					System.out.println("保存到历史订单表");
					YoStaffDailyOrder  dorder = new YoStaffDailyOrder();
					String businessProperty2=staffCurentOrder.getBusinessProperty();
					String department2= staffCurentOrder.getDepartment();
					String orderCity2= staffCurentOrder.getOrderCity();
					String orderProvince2 =staffCurentOrder.getOrderProvince();
					String orderYear2=staffCurentOrder.getOrderYear();
					String outdoorJob2= staffCurentOrder.getOutdoorJob();
					String principal2 =staffCurentOrder.getPrincipal();
					String scoContratType2=staffCurentOrder.getScoContratType();
					String scoOrderName2=staffCurentOrder.getScoOrderName();
					String scoOrderNo2=staffCurentOrder.getScoOrderNo();
					String scoProjectName2= staffCurentOrder.getScoProjectName();
					String yindaIdentify2=staffCurentOrder.getYindaIdentify();
					String lte2  =staffCurentOrder.getLte();
					String effectTime2=staffCurentOrder.getEffectTime();
					String modifyTime2 =staffCurentOrder.getModifyTime();*/
					//历史订单对象赋值
					//					dorder.setStaffUserId(user_staff_id);
					//					dorder.setBusinessProperty(businessProperty2);
					//					dorder.setDepartment(department2);
					//					dorder.setOrderCity(orderCity2);
					//					dorder.setOrderProvince(orderProvince2);
					//					dorder.setOrderYear(orderYear2);
					//					dorder.setOutdoorJob(outdoorJob2);
					//					dorder.setPrincipal(principal2);
					//					dorder.setContractType(scoContratType2);
					//					dorder.setOrderName(scoOrderName2);
					//					dorder.setSdoDate(sdf.format(new Date()));
					//					dorder.setProject(scoProjectName2);
					//					dorder.setYindaIdentify(yindaIdentify2);
					//					staffDailyOrderMapper.insert(dorder);
				}
				//第3步 当前订单信息表中 对象属性赋值
				staffCurentOrder.setScoStaffId(staff_id);
				staffCurentOrder.setStaffUserId(user_staff_id);
				staffCurentOrder.setBusinessProperty(businessProp);
				staffCurentOrder.setDepartment(department);


				staffCurentOrder.setOrderCity(orderCity);
				staffCurentOrder.setOrderProvince(orderProvince);
				staffCurentOrder.setOrderYear(orderYear);
				staffCurentOrder.setOutdoorJob(outdoorJob3);
				staffCurentOrder.setPrincipal(principal);
				staffCurentOrder.setScoContratType(scoContratType);
				staffCurentOrder.setScoOrderName(scoOrderName);
				staffCurentOrder.setScoOrderNo(scoOrderNo);
				if(projectList!=null&&projectList.size()>0){//如果department表中没有该项目 则不修改当前staff_info表中的项目 保留原先的项目
					staffCurentOrder.setScoProjectName(scoProjectName);
				}
				//是否修改当前订单表的department 
				else{
					
				}

				staffCurentOrder.setYindaIdentify(yindaIdentify);
				staffCurentOrder.setEffectTime(effectTime);
				staffCurentOrder.setModifyTime(msdf.format(new Date()));
				staffCurentOrder.setLte(lte);
				if(staffCurentOrder.getScoSequenceNo()!=null){
					staffCurrentOrderMapper.updateByPrimaryKey(staffCurentOrder);//如果当前有该用户的信息，跟新
					System.out.println("更新当前订单表");
				}else{
					staffCurrentOrderMapper.insert(staffCurentOrder);//如果数据库中没有该用户的信息，添加
					System.out.println("添加到当前订单表");
				}
				//第4步 更新/添加 当前订单表后 需要同步staff_info 表中人员信息

				//根据工号查找staff_info的人员信息
				StaffInfo staffInfo = new StaffInfo();
				staffInfo.setStaffId(staff_id);
				try{
					staffInfo = iStaffInfoService.searchStaffInfoByEntity(staffInfo).get(0);
				}catch(Exception e){
					System.out.println("staff_info表没有工号"+staffInfo+"的人员信息");
					return "error";
				}


				//第5步 同步staff_info 表中的信息
				
				staffInfo.setDepartment(department+"-"+staffCurentOrder.getScoProjectName());//数据库字段 格式为： 无线事业部-内蒙移动
				staffInfo.setItem(scoOrderName);
				staffInfo.setYoOrder(businessProp);			   
				staffInfo.setContractType(scoContratType);
				try{
					staffInfoMapper.updateByPrimaryKey(staffInfo);
				}catch(Exception e){
					System.out.println("staff_info表中"+staffInfo+"更新失败");
					return "error";
				}
				//第7步 更新钉钉中人员信息 钉钉侧修改
				DDUtil ddutil = new DDUtil(iStaffInfoService);
				if(projectList==null||projectList.size()==0){//如果department表中没有该项目 则同步钉钉时 项目为空 直属部门下
					System.out.println("department表中没有"+department);
					staffInfo.setDepartment(department);
				}
				Map<String,Object> map = new HashMap<String,Object>();
				String DDresult = ddutil.updateUser(staffInfo);
				System.out.println("DDresult"+DDresult);
				if (DDresult != null){
					map.put("msg", DDresult);
					System.out.println(map);
				}

			}

			//第6步 更新 yo_order_change表中的信息 
			yoOrderChangeMapper.updateByPrimaryKey(OrderChange);


			return "success";
		}catch(Exception e){
			return "error";
		}
	}
	/**
	 * 审批拒绝
	 * @param id 项目信息变更的Id
	 * @param request
	 * @return
	 */
	@RequestMapping("/refuse_approve.do")
	@ResponseBody
	public String refuse_approve(String id,HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		YoOrderChange itemChange =yoOrderChangeMapper.selectByPrimaryKey(Integer.valueOf(id));
		itemChange.setOrderStatus("审核拒绝");
		itemChange.setOrderResult("审核结束");
		itemChange.setNowAcess("");
		try{
			yoOrderChangeMapper.updateByPrimaryKey(itemChange);
			return "success";
		}catch(Exception e){
			return "error";
		}
	}

	/**
	 * 已审批列表
	 * @param request
	 * @return
	 */
	@RequestMapping("/approve_history_page.do")
	public  ModelAndView  approve_history_page(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("order/approve_history");
		String user_staff_id= (String) request.getSession().getAttribute(GlobalConstant.user_staff_user_id);

		List<YoOrderChange> orderChangeList = iOrderChangeService.get_approve_history(user_staff_id);
		//System.out.println("已审批列表长度："+orderChangeList.size());
		mav.addObject("orderChangeList", orderChangeList);
		return mav;
	}

	/**
	 * 待审批列表
	 * @param request
	 * @return
	 */
	@RequestMapping("/get_approve_un.do")
	public  ModelAndView  get_approve_un(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("order/approve_un");
		String user_staff_id= (String) request.getSession().getAttribute(GlobalConstant.user_staff_user_id);
		List<YoOrderChange> orderChangeList =iOrderChangeService.get_approve_un(user_staff_id);
		mav.addObject("orderChangeList", orderChangeList);
		return mav;
	}

	/**
	 * 申请记录列表
	 * @param request
	 * @return
	 */
	@RequestMapping("/get_Apply.do")
	public  ModelAndView  get_Apply(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("order/get_Apply");
		String user_staff_id= (String) request.getSession().getAttribute(GlobalConstant.user_staff_user_id);
		List<YoOrderChange> orderChangeList =iOrderChangeService.get_Apply(user_staff_id);
		mav.addObject("orderChangeList", orderChangeList);
		return mav;
	}
}
