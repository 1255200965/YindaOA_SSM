package com.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bsh.ParseException;

import com.dao.YoAtteninfoMapper;
import com.model.YoAtteninfo;
import com.model.YoAtteninfoExcelExport;
import com.service.IAttendanceInfoService;
import com.util.ExportUtil;



@Controller
public class ExcelAtteninfoExportController {
	 @Autowired
	private IAttendanceInfoService atteninfoService;
	 /**
	  * 考勤信息展示
	  * @param request
	  * @param department
	  * @param orderName
	  * @param attendtime
	  * @param atttime
	  * @return
	  * @throws ParseException
	  * @throws java.text.ParseException
	  */
    @SuppressWarnings("null")
	@RequestMapping("/attendance_search.do")
    public ModelAndView attendance_search(HttpServletRequest request,String department,
    		String orderName,String attendtime,String atttime,String projectName) throws ParseException, java.text.ParseException{
    	ModelAndView mav = new ModelAndView();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	   List<YoAtteninfoExcelExport> YEList=null;
	   YoAtteninfo yoAtteninfo=new YoAtteninfo();
	   System.out.println(projectName);
	   if(department !=null && !"".equals(department)){
	
		   yoAtteninfo.setDepartment(department);
		   yoAtteninfo.setAttendtime(sdf.parse(attendtime));
		   yoAtteninfo.setAtttime(sdf.parse(atttime));
		   yoAtteninfo.setAttaddress(orderName);//利用address携带orderName到数据库方便查询
		   yoAtteninfo.setDevice(projectName);//利用device携带projectName到数据库方便查询
		   System.out.println(yoAtteninfo.getDevice());
		   YEList= atteninfoService.selectAtteninfoExcelExport(yoAtteninfo); 
			   
		   
		  
	   }
	   //待会前端输入框中的字段，这块有点乱，是因为SQL查询时有些字段已经写死了，就没再改
	   yoAtteninfo.setAttaddress(attendtime);
	   yoAtteninfo.setAttendresult(atttime);
	   yoAtteninfo.setIfactivity(orderName);
	   mav.addObject("yoAtteninfo", yoAtteninfo);
	   mav.addObject("YEList", YEList);
	   mav.setViewName("attendance");
	   return mav;
   }
    /**
     * 考勤报表下载
     * @param response
     * @param request
     * @param department
     * @param orderName
     * @param attendtime
     * @param atttime
     * @throws java.text.ParseException
     */
    @SuppressWarnings("null")
	@RequestMapping("/attendance_export.do")
    public void attendance_export(HttpServletResponse response,HttpServletRequest request,String department,
    		String orderName,String attendtime,String atttime,String projectName) throws java.text.ParseException{
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	YoAtteninfo yoAtteninfo=new YoAtteninfo();
    	if(department !=null && !"".equals(department)){
 		   yoAtteninfo.setDepartment(department);
 		  yoAtteninfo.setAttendtime(sdf.parse(attendtime));
		   yoAtteninfo.setAtttime(sdf.parse(atttime));
		   yoAtteninfo.setAttaddress(orderName);//利用address携带orderName到数据库方便查询
		   yoAtteninfo.setDevice(projectName);//利用device携带projectName到数据库方便查询
 		  List<YoAtteninfoExcelExport> exportList= atteninfoService.selectAtteninfoExcelExport(yoAtteninfo);
 	       //表头
		  String []excelHeader = {"姓名","工号","部门","项目","订单名称","合同类型","打卡时间","打卡结果","备注","打卡设备号"};
	      ExportUtil.export2(exportList, excelHeader, response);
 	   } 
    	  
    }
}
