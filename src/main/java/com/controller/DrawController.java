package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.model.LuckyStaff;
import com.model.StaffInfo;
import com.service.ILuckyStaffService;
import com.service.IStaffInfoService;

@Controller
public class DrawController {
	
	private String option=null;
	private String result=null;
	private String drawType=null;
	private LuckyStaff luckyStaff = new LuckyStaff();
	@Autowired
	private IStaffInfoService staffInfoService;
	@Autowired
	private ILuckyStaffService LSService;
	/**
	 * 首登界面
	 * @return
	 */
	@RequestMapping("/toDraw.do")
	public String toDraw(){
		return "draw/draw";
	}
		/**
		 * 管理员抽奖操作界面
		 * @return
		 */
	@RequestMapping("/toDrawManager.do")
	public ModelAndView toDrawManager(){
		ModelAndView mav = new ModelAndView();
		List<StaffInfo> staffInfoList = staffInfoService.selectAllUserName();
		System.out.println(staffInfoList.toString());
		mav.addObject("staffInfoList", staffInfoList);
		mav.setViewName("draw/draw_manager");
		return mav;
	}
		/**
		 * 职工抽奖观看界面跳转
		 * @return
		 */
	@RequestMapping("/toDrawStaff.do")
	public ModelAndView toDrawStaff(){
		ModelAndView mav = new ModelAndView();
		List<StaffInfo> staffInfoList = staffInfoService.selectAllUserName();
		System.out.println(staffInfoList.toString());
		mav.addObject("staffInfoList", staffInfoList);
		mav.setViewName("draw/draw_staff");
		return mav;
	}
		//管理员界面定时返回操作信息
	@RequestMapping("/getMessageMJ")
	public void getMessageMJ(String option ,String result,String drawType){
		this.option = option;
		this.result = result;
		this.drawType=drawType;
		luckyStaff.setStaffName(result);
		luckyStaff.setDrawType(this.drawType);
		if(result!=null && !"".equals(result)){
			LSService.save(luckyStaff);
		}
		
		System.out.println(option+"========="+result);
	}
		//普通职工界面定时从后台获取当前数据
	@RequestMapping(value="/getFlagSJ.do",method=RequestMethod.POST,
					produces={"application/json;charset=UTF-8"})
	public @ResponseBody String getFlagSJ(HttpServletRequest request,HttpServletResponse response){
		
		System.out.println(option+"=========="+result);
		Map<String,String> map = new HashMap<String,String>();
		map.put("option",option);
		map.put("result", result);
		map.put("drawType",drawType);
		String json =JSON.toJSONString(map);
		System.out.println(json);
		return json;
	}
	@RequestMapping("/toDraw_getList")
	public ModelAndView toDraw_getList(){
		
		ModelAndView mav = new ModelAndView();
		List<LuckyStaff> list = LSService.selectAll();
		mav.addObject("list", list);
		mav.setViewName("draw/draw_getList");
		return mav;
	}
	@RequestMapping("/getDrawResult")
	public @ResponseBody List<LuckyStaff> getDrawResult(){
		List<LuckyStaff> list = LSService.selectAll();
		return list;
	}
}
