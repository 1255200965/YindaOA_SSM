package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.dao.YoOrderMapper;
import com.model.YoOrder;
import com.service.IOrderService;
import com.util.StringUtil;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("order")
public class OrderController {	
	@Autowired
	private IOrderService iOrderService;
	
	@Autowired
	private YoOrderMapper orderMapper;
	
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
	 * 获取部门
	 * @return
	 */
	@RequestMapping("/getDepartment.do")
	@ResponseBody
	public 	List<YoOrder> getDepartment(){		
		List<YoOrder> orderList = iOrderService.getDepartment();
		return orderList;
	}
	/**
	 * 根据部门获取项目
	 * @param department
	 * @return
	 */
	@RequestMapping("/getProjectByDepartment.do")
	@ResponseBody
	public 	List<YoOrder> getProjectByDepartment(String department){		
		List<YoOrder> orderList = iOrderService.getProjectByDepartment(department);			
		return orderList;
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
	
}
