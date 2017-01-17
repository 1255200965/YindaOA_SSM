package com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ecache.Impl.SystemCacheImpl;
import com.model.LuckyStaff;
import com.model.StaffInfo;
import com.service.ILuckyStaffService;
import com.service.IStaffInfoService;

@Controller
public class DrawController {
	
	private String option=null;
	private LuckyStaff luckyStaff = new LuckyStaff();//当前中奖人信息
	private List<LuckyStaff> recordList=new ArrayList<LuckyStaff>();//中奖人信息记录
	
	private String []drawTypes={"三等奖","二等奖","一等奖"};//所有奖项设置
	private String drawType=drawTypes[0];//待抽奖项
	private int i=0;//标识当前该抽的奖项类别
	
	@Autowired
	private IStaffInfoService staffInfoService;
	@Autowired
	private ILuckyStaffService LSService;
	
	ValueWrapper staffCache = SystemCacheImpl.cache.get("staffInfo");
		/**
		 * 职工抽奖观看界面跳转
		 * @return
		 */
	@RequestMapping("/toDrawStaff.do")
	public ModelAndView toDrawStaff(){
		ModelAndView mav = new ModelAndView();
		
		@SuppressWarnings("unchecked")
		Map<String,String> staffMap=(Map<String, String>) staffCache.get();
		List<LuckyStaff> luckyList =LSService.selectAll();
		mav.addObject("luckyList", luckyList);
		mav.addObject("staffMap", staffMap);
		mav.setViewName("draw/draw_staff");
		return mav;
	}
		//每个小时的10 进行抽奖
	 @Scheduled(cron = "0 01 * * * *")
	 public void startDraw(){
		 
		 System.out.println("设置信息==========");
		 option="start";
		 	//重置当前抽奖类别
		 if(i<drawTypes.length){
			 
		  drawType=drawTypes[i];
		 }else{
			 drawType="本次抽奖活动已结束";
		 }
		 	//定时任务开始前清空中奖员工信息
		 luckyStaff.setStaffId("");
		 luckyStaff.setStaffName("");
		 luckyStaff.setDrawType("");
		 System.out.println("设置信息======="+option);
	 }
	 	
	//每小时20分进行一次抽奖
	 @Scheduled(cron="0 20 * * * *")
	 public void draw(){
		 
		 if(i<drawTypes.length){
			 
			 System.out.println("第"+i+"次抽奖开始======================");
			 List<StaffInfo> staffInfoList = staffInfoService.selectAllUser();
			 Random r = new Random();
			 int n = r.nextInt(staffInfoList.size());
			 luckyStaff.setStaffId(staffInfoList.get(n).getStaffId());
			 luckyStaff.setStaffName(staffInfoList.get(n).getName());
			 luckyStaff.setDrawType(this.drawType);
			 System.out.println("当前中奖人员信息=="+luckyStaff.toString());
			 LSService.save(luckyStaff);
			 recordList.add(luckyStaff);
			 	//重置抽奖状态为结束
			 option="end";	
			 i++;
			 	
	   }	 
	 }
//普通职工界面定时从后台获取当前数据
	@RequestMapping(value="/getFlagSJ.do",method=RequestMethod.POST,
					produces={"application/json;charset=UTF-8"})
	public @ResponseBody String getFlagSJ(HttpServletRequest request,HttpServletResponse response){
		
		System.out.println(option+"=========="+luckyStaff.toString());
		Map<String,String> map = new HashMap<String,String>();
		if(drawType==null){
			drawType=drawTypes[0];
		}
		map.put("option",option);
		map.put("drawType",drawType);
		map.put("staffName",luckyStaff.getStaffName());
		map.put("staffId",luckyStaff.getStaffId());
		String json =JSON.toJSONString(map);
		System.out.println(json);
		return json;
	}
}
