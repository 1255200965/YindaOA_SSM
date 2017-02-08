package com.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dao.StaffInfoMapper;
import com.dao.YoOrderChangeMapper;
import com.dao.YoStaffCurrentOrderMapper;
import com.dao.YoStaffDailyOrderMapper;
import com.ddSdk.base.OApiException;
import com.model.Department;
import com.model.DepartmentExample;
import com.model.StaffInfo;
import com.model.YoOrderChange;
import com.model.YoStaffCurrentOrder;
import com.ning.http.client.Request;
import com.service.IDepartmentService;
import com.service.IOrderChangeService;
import com.service.IStaffCurrentOrderService;
import com.service.IStaffInfoService;
import com.util.DDUtil;
import com.util.GlobalConstant;
import com.util.OrderMessageUtil;
import com.util.StringUtil;
/*
 * create by  yexianglei
 * date : 2017-2-6
 * desc : 项目变更管理后台控制层
 */
@Controller
@RequestMapping("PCOrderChange")
public class PCOrderChangeController {
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
	/**
	 * pc待审批列表
	 * @param request
	 * @return
	 */
	@RequestMapping("/pc_get_approve_un.do")
	public  ModelAndView  PC_get_approve_un(HttpServletRequest request,String orderName){
		ModelAndView mav = new ModelAndView();		
		String user_staff_id= (String) request.getSession().getAttribute(GlobalConstant.user_staff_user_id);		
		List<YoOrderChange> orderChangeList =iOrderChangeService.get_approve_un(user_staff_id,orderName);
		mav.addObject("orderChangeList", orderChangeList);
		mav.setViewName("order/pc_approve_un");
		
		return mav;
	}
	
	/**
	 * 项目变更审批通过
	 * @return
	 */
	@RequestMapping(value ="pc_pass_approve.do")
	@ResponseBody
	public String pc_pass_approve(
			@RequestParam("ids[]") List<String> ids ,
			@RequestParam("identifys[]") List<String> identifys,
            @RequestParam("orderRemarks[]") List<String> orderRemarks,
			@RequestParam("businessProps[]")List<String>  businessProps,
			@RequestParam("outdoorJob3s[]")List<String>  outdoorJob3s,
			@RequestParam("lte3s[]")List<String>  lte3s, 
			HttpServletRequest request){
	  /*
	   *第一步，接收到前台传输的6个数组，数组的长度一致，以ids数组为基准 循环修改！ 
	   */
		for(int i = 0;i<ids.size();i++){
			
			/*
			 * 审批通过
			 */
			String orderRemark = null;
			
			try{
				 orderRemark = orderRemarks.get(i);
			}catch(Exception e){
				
			}
			
			String lte3 = null;
			try{
				lte3 = lte3s.get(i);
			}catch(Exception e){
				
			}
			
			pass_approve(ids.get(i), identifys.get(i), orderRemark, businessProps.get(i), outdoorJob3s.get(i), lte3);
			
			
		}
		
		
		/*
		 *最后，发送一条消息给下级主管，发送内容为：项目申请的数量
		 *这里不选择逐条发送，用户体验不好
		 */
		
		YoOrderChange orederchanger =yoOrderChangeMapper.selectByPrimaryKey(Integer.valueOf(ids.get(0)));
		if(StringUtil.NotBlank(orederchanger.getNowAcess()) ){
			try { 
				OrderMessageUtil.sendMessage("您好！"
						+ "您有"+ids.size()+"条新的项目变更申请需要审批，请尽快处理哦！如果数量较多请前往PC端项目审批后台处理！", orederchanger.getNowAcess());
			} catch (OApiException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return "success";
		
	}
	public static void main(String[] args) throws OApiException {
		
		System.out.println(OrderMessageUtil.sendMessage("您好", "071536130021650043"));
	}
	/**
	 * 项目变更单条审批拒绝
	 * @return
	 */
	@RequestMapping("pc_refuse_approve.do")
	@ResponseBody
	public String pc_refuse_approve(@RequestParam("ids[]") List<String> ids){
		/*
		 * 成功的条数
		 */
		int i =0 ;
		/*
		 * 失败的条数
		 */
		int j =0 ;
		/*
		 * 遍历拒绝
		 */
		for(String id :ids){
			YoOrderChange itemChange =yoOrderChangeMapper.selectByPrimaryKey(Integer.valueOf(id));
			itemChange.setOrderStatus("审核拒绝");
			itemChange.setOrderResult("审核结束");
			itemChange.setNowAcess("");
			try{
				yoOrderChangeMapper.updateByPrimaryKey(itemChange);
				i++;
			}catch(Exception e){
				j++;
			}
		}
		
		return "您总共拒绝了"+ids.size()+"条项目申请！成功拒绝"+i+"条，失败"+j+"条！";
		
	}
	
	/**
	 * 审批通过
	 * @param id 项目信息变更的Id
	 * @param request
	 * @return
	 */
	
	public String pass_approve(String id,String identify,String orderRemark,String businessProp,String outdoorJob3,String lte3){

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
			YoOrderChange OrderChange =iOrderChangeService.nextManager(itemChange);
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
					//如果当前订单表中中没有 该订单信息 创建新的当前订单信息表 那么当前订单表中没有部门和项目信息 
					staffCurentOrder = new YoStaffCurrentOrder();
					StaffInfo s =staffInfoMapper.selectByPrimaryKey(user_staff_id); //从当前staff_info表中拿到该人的信息
					if(s.getDepartment().split("\\|").length==1){//如果当前订单表中的 只有部门没有项目
						staffCurentOrder.setDepartment(Arrays.asList(s.getDepartment().split("\\|")).get(0));						
					}else if(s.getDepartment().split("\\|").length==2){//如果当前订单表中的 有部门也有项目
						staffCurentOrder.setDepartment(Arrays.asList(s.getDepartment().split("\\|")).get(0));
						staffCurentOrder.setScoProjectName(Arrays.asList(s.getDepartment().split("\\|")).get(1));
					};

				}else{

				}
				//第3步 当前订单信息表中 对象属性赋值
				staffCurentOrder.setScoStaffId(staff_id);
				staffCurentOrder.setStaffUserId(user_staff_id);
				staffCurentOrder.setBusinessProperty(businessProp);				
				staffCurentOrder.setOrderCity(orderCity);
				staffCurentOrder.setOrderProvince(orderProvince);
				staffCurentOrder.setOrderYear(orderYear);
				staffCurentOrder.setOutdoorJob(outdoorJob3);
				staffCurentOrder.setPrincipal(principal);
				staffCurentOrder.setScoContratType(scoContratType);
				staffCurentOrder.setScoOrderName(scoOrderName);
				staffCurentOrder.setScoOrderNo(scoOrderNo);
				
				
				String leader =staffInfoMapper.selectByPrimaryKey(staffCurentOrder.getStaffUserId()).getWhetherLeader();

				if(projectList!=null&&projectList.size()>0 && !leader.contains("是")){//如果department表中有该项目 并且这个人不能是主管
					staffCurentOrder.setScoProjectName(scoProjectName);// 则修改当前staff_info表中的项目 保留原先的项目
					staffCurentOrder.setDepartment(department);
				}
				//如果department表中没有有该项目  则 部门项目都不改变，只改变订单 钉钉也是
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
				if(staffCurentOrder.getScoProjectName()!=null){
					staffInfo.setDepartment(staffCurentOrder.getDepartment()+"-"+staffCurentOrder.getScoProjectName());//数据库字段 格式为： 无线事业部-内蒙移动
				}else{
					staffInfo.setDepartment(staffCurentOrder.getDepartment());//数据库字段 格式为： 无线事业部
				}

				staffInfo.setItem(scoOrderName);
				staffInfo.setYoOrder(businessProp);			   
				staffInfo.setContractType(scoContratType);
				try{
					staffInfoMapper.updateByPrimaryKey(staffInfo);
				}catch(Exception e){
					e.printStackTrace();
					System.out.println("staff_info表中"+staffInfo+"更新失败");
					return "error";
				}
				//第6步 更新钉钉中人员信息 钉钉侧修改
				DDUtil ddutil = new DDUtil(iStaffInfoService);
				//				if(projectList==null||projectList.size()==0){//如果department表中没有该项目 则同步钉钉时 项目为空 直属部门下
				//					System.out.println("department表中没有"+department);
				//					staffInfo.setDepartment(department);
				//				}
				Map<String,Object> map = new HashMap<String,Object>();
				String DDresult = ddutil.updateUser(staffInfo);
				System.out.println("DDresult"+DDresult);
				if (DDresult != null){
					map.put("msg", DDresult);
					System.out.println(map);
				}

			}

			//第7步 更新 yo_order_change表中的信息 
			yoOrderChangeMapper.updateByPrimaryKey(OrderChange);


			return "success";
		}catch(Exception e){
			return "error";
		}
	}
}
