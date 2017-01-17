package com.ecache.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;

import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.stereotype.Service;

import com.dao.YoOrderMapper;
import com.ecache.SystemCache;
import com.model.YoOrder;
import com.model.YoRoleModule;
import com.model.YoUserRole;
import com.service.IOrderService;
import com.service.OrgService;



public class SystemCacheImpl  implements SystemCache{

	@Autowired
	EhCacheCacheManager cacheManager;
	@Autowired
	private YoOrderMapper yoOrderMapper;
	@Autowired
	private IOrderService iOrderService;
	@Autowired
	private OrgService orgService;
	/**
	 * 缓存名字
	 */
	public static String cacheName = "orgSysCache";
	
	public static Cache cache;

	
	public void put(String key,List list) {
		getCache().put(key, list);
	}

	public void removeCache(String key) {
		getCache().evict(key);
	}
	
	public void updateCache(String key) {
		// TODO Auto-generated method stub
	}	

	public  SimpleValueWrapper get(String key){
		SimpleValueWrapper  parameter =   (SimpleValueWrapper)getCache().get(key);
		return parameter;
	}

  
	public void initCache(){
    	System.out.println("初始化缓存。。。");
    	//第一步 获取所有需要缓存的数据
    	//获取所有部门
    	List<YoOrder> departmentList = iOrderService.getDepartment();
    	System.out.println(departmentList.size());
    	//获取所有项目
    	List<YoOrder> projectList = yoOrderMapper.getAllProject();
    	System.out.println(projectList.size());
    	
    	
    	//第2步 处理需要缓存的数据
    	//部门 字符串列表
    	List<String> departmentList1 = new ArrayList<String>();
    	for(YoOrder yoorder: departmentList){
    		if(yoorder.getDepartment()!=null&&yoorder.getDepartment().length()>0){
    			departmentList1.add(yoorder.getDepartment());
    		}   		
    	}
    	
    	//第3步 组成部门，项目 Map<String,List<String>>
    	Map<String,List<String>> projectMap = new HashMap<String,List<String>>();
    	
    	List<String> strList=null;                                 // 申明一个字符串列表
    	for(String department : departmentList1){                  // 循环处理好的部门列表
    		strList = new ArrayList<String>();                           // 充值strList
    		for(YoOrder project :projectList ){                    // 循环项目列表      		
        		if(department.equals(project.getDepartment())){    // 如果部门中的部门等于项目中的部门
        			strList.add(project.getProject());
        		}
        	}
    		projectMap.put(department, strList);                    //一个部门作为key 项目列表作为value
    	}
    	
    	
    	for(Map.Entry<String, List<String>> entry : projectMap.entrySet())    
    	{    
    	    System.out.println(entry.getKey()+": "+entry.getValue());    
    	} 
    	//组成订单部门项目，订单<Map<String,List<String>>
    	Map<String,String> orderMap = new HashMap<String,String>();
    	//获取所有订单
    	List<YoOrder> orderList= iOrderService.getOrderByDepartmentAndProject(null, null);
    	System.out.println(orderList.get(0).getDepartment());
    	
    	for(Map.Entry<String, List<String>> entry : projectMap.entrySet())   //循环所有的部门
    	{    
    		for(String str :entry.getValue()){                               //循环当前部门下的所有项目
    			     for(YoOrder order :orderList){                          //循环所有订单
    			    	 if( order.getDepartment().equals(entry.getKey())&&order.getProject().equals(str)){ //当前订单 属于某个部门下的 某个项目
    			    		 orderMap.put(order.getOrderName(), order.getDepartment()+order.getProject());
    			    	 }
    			     }
    		}
    	     
    	} 
        System.out.println("所有订单");
        System.out.println(orderMap.size());
    	for(Map.Entry<String,String> entry : orderMap.entrySet())   //循环所有的部门
    	{    
    		System.out.println(entry.getKey()+": "+entry.getValue()); 
    	     
    	} 

    	  
		  getCache().put("department",departmentList1);
		  getCache().put("project",projectMap);
		  getCache().put("order",orderMap);
		  
		  //初始化用户角色缓存
		  System.out.println("正在初始化角色权限缓存");
		  System.out.println(orgService.getAllUserRole().size());
		  List<YoUserRole> userRoleList = orgService.getAllUserRole();
		  getCache().put("user_role", userRoleList);
		  //初始化用户模块信息
		  List<YoRoleModule> roleModuleList = orgService.getAllRoleModule();
		  getCache().put("role_module", roleModuleList);
		  
	}
	
    
    
    
	public   Cache getCache() {
		if(cache == null){
			cache = cacheManager.getCache(cacheName);
		}
		return cache;
	}



}
