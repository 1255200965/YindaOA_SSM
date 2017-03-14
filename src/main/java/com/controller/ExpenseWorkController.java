package com.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dao.ExpenseWorkMapper;
import com.model.ExpenseWork;
import com.service.ExpenseWorkSerivce;



/**
 * 办事处报销 导出，导出，查看
 * @author yexianglei
 *  create date:2017-03-09
 */
@Controller
@RequestMapping("/expenseWork")
public class ExpenseWorkController {

	@Autowired
	private ExpenseWorkSerivce expenseWorkSerivce; 

	@Autowired
	private ExpenseWorkMapper expenseWorkMapper; 
	/**
	 * 进去办事处费用导入界面
	 * @return
	 */
	@RequestMapping("/expenseWork_import_page.do")
	public ModelAndView expenseWork_import_page(){		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("excel/expensework_import");
		return mav;
	}
    /**
     * 办事报销发文模块
     * @return
     */
	@RequestMapping("/expenseWork_page.do")
	public ModelAndView expenseWork_page(){		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("expense/expensework");
		return mav;
	}
    /**
     * 办事报销查询
     * @return
     */
	@RequestMapping("/expenseWork_search.do")
	@ResponseBody
	public List<ExpenseWork> expenseWork_search(HttpServletRequest request,ExpenseWork expenseWork,String endTime1,String endTime2){		
		List<ExpenseWork> expenseWorkList=expenseWorkSerivce.search_expenseWorkList(expenseWork,endTime1,endTime2);
		return expenseWorkList;
	}
	
	
    /**
     * 办事处报销导入
     * @param fileUpload
     * @param m
     * @return
     */
	@RequestMapping("/upload.do")
	public ModelAndView expenseWork_upload(@RequestParam("fileUpload") MultipartFile fileUpload, Model m){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("excel/expensework_import");
		// 第1步，从上传的文件中得到输入流
		InputStream inputStream = null;
		try {
			inputStream = fileUpload.getInputStream();
			mav.addObject("validateUpload", "文件上传成功！");
			System.out.println("文件上传成功！");
		} catch (Exception e) {
			mav.addObject("validateUpload", "文件上传失败，请检查联网状态");
			System.out.println("文件上传失败，请检查联网状态");
			
			return mav;
		}


		// 第2步，从输入流中得到excel工作表
		// Java的规定，有了输入流才能按照格式读取excel文件
		HSSFWorkbook hssfWorkbook = null;
		try {
			// 
			hssfWorkbook = new HSSFWorkbook(inputStream);
			System.out.println("成功转为excel！");
			
		} catch (Exception e) {
			System.out.println("文件格式只能为03版EXCEL");
			mav.addObject("validateTitle", "文件格式只能为03版EXCEL");

			return mav;
		}
        try{
        	Map<String, Object> reulstmap= expenseWorkSerivce.insertAndUpdate(hssfWorkbook);
        	String listFail= (String) reulstmap.get("listFail");
        	mav.addObject("listFail", listFail);
    		int insertList  =(int) reulstmap.get("insertList");
    		int updateList =(int) reulstmap.get("updateList");
    		mav.addObject("validateTitle", "导入系统成功！");
    		
  
    		mav.addObject("insertList", insertList);
    		mav.addObject("updateList", updateList);
        }catch(Exception e){
        	mav.addObject("validateTitle", "导入系统失败！");
        	return mav;
        }
		
		
		
		return mav;
	}
	
	
	
	  //EXCEL表头
	  String []excelHeader = {"审批编号","标题","审批状态","审批结果","审批发起时间","审批完成时间","发起人工号","发起人姓名","发起人部门",
	            "历史审批人姓名","审批记录","当前处理人姓名","审批耗时","所属部门","所属项目","所属订单","办事处名称","费用类别",
	            "费用月份","收款人","开户银行","开户支行","银行账号","总金额（元）","总金额（元）(大写)","银行卡照片","说明","发票","发票类型","发票代码","发票号码","发票日期","收款方名称"," 收款方税号","金额（元）","图片"};
	  


																															 			



    /**
     * 办事处报销导出
     * @param expenseWork  办事处报销对象
     * @param request
     * @param response
     * @param endTime1 结束时间范围
     * @param endTime2 结束时间范围
     */
	@RequestMapping("expenseWork_export.do")
	public void expenseWork_export(ExpenseWork expenseWork,HttpServletRequest request,HttpServletResponse response,String endTime1,String endTime2){
		    //按条件查询
		    List<ExpenseWork> expenseWorkList=expenseWorkSerivce.search_expenseWorkList(expenseWork,endTime1,endTime2); 
		  
		    //导出列表
		    List<ExpenseWork> exportList = new ArrayList<ExpenseWork>();
		   
		    //按条件查询的结果中是未导出过的那么添加到导出的列表中
            for(ExpenseWork e :expenseWorkList){
		    	if((e.getIsExport()==null||"".equals(e.getIsExport()))&&e.getResult().equals("同意") ){
		    		exportList.add(e);
		    	}
		    }
            
            //导出
	        export(exportList,excelHeader,response);
	        
	        //导出的列表状态修改为已经导出 更新
	        for( ExpenseWork e :exportList){
	        	e.setIsExport("已导出");
	        	expenseWorkMapper.updateByPrimaryKey(e);
	        }
	        
	        
	}
	
	/**
	 * 
	 * @param expenseWorkList  办事处报销的List
	 * @param excelHeader Excel的报销
	 * @param response  返回
	 */
	public static void export( List<ExpenseWork> expenseWorkList,String[] excelHeader,HttpServletResponse response){
	        HSSFWorkbook wb = getHSSFWorkbook(expenseWorkList,excelHeader);
	        response.setContentType("application/vnd.ms-excel");
	        response.setHeader("Content-disposition", "attachment;filename=attendanceInfo.xls");
	        OutputStream ouputStream;
	        try {
	            ouputStream = response.getOutputStream();
	            wb.write(ouputStream);
	            ouputStream.flush();
	            ouputStream.close();
	        } catch (IOException e) {
	            System.out.println("=========考勤表模板导出error");
	            e.printStackTrace();
	        }
	    }
	  
	  
	  /**
	     * 获得HSSFWorkbook
	     * @param list 数据信息
	     * @param excelHeader 表头
	     * @return HSSFWorkbook
	     */

	    private static HSSFWorkbook getHSSFWorkbook(List<ExpenseWork> list, String[] excelHeader){

	        HSSFWorkbook wb = new HSSFWorkbook();
	        //创建一个sheet
	        HSSFSheet sheet= wb.createSheet("sheet1");
	        //设置单元格宽度
	        sheet.setColumnWidth(0,(int)(20+0.72)*256);
	        sheet.setColumnWidth(1,(int)(20+0.72)*256);
	        sheet.setColumnWidth(2,(int)(20+0.72)*256);
	        sheet.setColumnWidth(3,(int)(20+0.72)*256);
	        sheet.setColumnWidth(4,(int)(20+0.72)*256);
	        sheet.setColumnWidth(5,(int)(20+0.72)*256);
	        sheet.setColumnWidth(6,(int)(20+0.72)*256);
	        sheet.setColumnWidth(7,(int)(20+0.72)*256);
	        sheet.setColumnWidth(8,(int)(20+0.72)*256);
	        sheet.setColumnWidth(9,(int)(30+0.72)*256);
	        sheet.setColumnWidth(10,(int)(20+0.72)*256);
	        sheet.setColumnWidth(11,(int)(20+0.72)*256);
	        sheet.setColumnWidth(12,(int)(20+0.72)*256);
	        sheet.setColumnWidth(13,(int)(20+0.72)*256);
	        sheet.setColumnWidth(14,(int)(20+0.72)*256);
	        sheet.setColumnWidth(15,(int)(20+0.72)*256);
	        sheet.setColumnWidth(16,(int)(20+0.72)*256);
	        sheet.setColumnWidth(17,(int)(20+0.72)*256);
	        sheet.setColumnWidth(18,(int)(20+0.72)*256);
	        sheet.setColumnWidth(19,(int)(30+0.72)*256);
	        sheet.setColumnWidth(20,(int)(20+0.72)*256);
	        sheet.setColumnWidth(21,(int)(20+0.72)*256);
	        sheet.setColumnWidth(22,(int)(20+0.72)*256);
	        sheet.setColumnWidth(23,(int)(20+0.72)*256);

	        //创建行
	        HSSFRow row = sheet.createRow(0);
	        //设置表头样式
	        HSSFCellStyle style = wb.createCellStyle();
	        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//左右居中
	        HSSFFont f = wb.createFont();
	        f.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//加粗
	        //创建表头
	        for(int i = 0;i <excelHeader.length;i++){//根据反射获取当前对象的属性个数
	            //当前行下创建列
	            HSSFCell cell = row.createCell(i);
	            //列中写入值
	            cell.setCellValue(excelHeader[i]);
	            //设置表头显示风格
	            cell.setCellStyle(style);

	            //sheet.autoSizeColumn(i);//单元格宽度自适应

	        }

	        //写入数据
	        for(int i=0;i<list.size();i++){
	            //创建新的一行
	            row = sheet.createRow(i+1);
	            //每行中写入与表头列数个数相等的数据
	            if(list.get(i).getApproveNumber()!=null){
	            	 row.createCell(0).setCellValue(list.get(i).getApproveNumber());//月份
	            }else{
	            	row.createCell(0).setCellValue("");//月份
	            }
	           
	            if(list.get(i).getTitle()!=null){
	            	 row.createCell(1).setCellValue(list.get(i).getTitle());//姓名
	            }else{
	            	row.createCell(1).setCellValue("");
	            }
	           
	            if(list.get(i).getExpenseStatus()!=null){
	            	 row.createCell(2).setCellValue(list.get(i).getExpenseStatus());//部门
	            }else{
	            	 row.createCell(2).setCellValue("");//部门
	            }
	           
	            if(list.get(i).getResult()!=null){
	            	  row.createCell(3).setCellValue(list.get(i).getResult());//审批结果
	            }else{
	            	 row.createCell(3).setCellValue("");//审批结果
	            }
	          
	            if(list.get(i).getStartTime()!=null){
	            	  row.createCell(4).setCellValue(list.get(i).getStartTime());//计薪天数
	            }else{
	            	 row.createCell(4).setCellValue("");//审批发起时间
	            }
	          
	            if(list.get(i).getEndTime()!=null){
	            	  row.createCell(5).setCellValue(list.get(i).getEndTime());//出勤
	            }else{
	            	  row.createCell(5).setCellValue("");//审批完成时间
	            }
	           
	            if(list.get(i).getApplyStaffId()!=null){
	            	 row.createCell(6).setCellValue(list.get(i).getApplyStaffId());//发起人工号
	            }else{
	            	 row.createCell(6).setCellValue("");//发起人工号
	            }
	           
	           if(list.get(i).getApplyName()!=null){
	        	   row.createCell(7).setCellValue(list.get(i).getApplyName());//有效出勤
	           }else{
	        	   row.createCell(7).setCellValue("");//有效出勤
	           }
	           
	           if(list.get(i).getApplyDepartment()!=null){
	        	   row.createCell(8).setCellValue(list.get(i).getApplyDepartment());//出勤工资
	           }else{
	        	   row.createCell(8).setCellValue("");//出勤工资
	           }
	           
	          if(list.get(i).getHistotyAccess()!=null){
	        	  row.createCell(9).setCellValue(list.get(i).getHistotyAccess());//请假天数
	          }else{
	        	  row.createCell(9).setCellValue("");//请假天数
	          }
	          
	          if(list.get(i).getHistoryRecord()!=null){
	        	  row.createCell(10).setCellValue(list.get(i).getHistoryRecord());//请假补款
	          }else{
	        	  row.createCell(10).setCellValue("");//请假补款
	          }
	          
	          if(list.get(i).getNowAccess()!=null){
	        	  row.createCell(11).setCellValue(list.get(i).getNowAccess());//加班时间  
	          }else{
	        	  row.createCell(11).setCellValue("");//加班时间  
	          }
	            
	          if(list.get(i).getUsedTime()!=null){
	        	  row.createCell(12).setCellValue(list.get(i).getUsedTime());//加班补款
	          }else{
	        	  row.createCell(12).setCellValue("");//加班补款
	          }
	           
	          if(list.get(i).getDepartment()!=null){
	        	  row.createCell(13).setCellValue(list.get(i).getDepartment());//出差 
	          }else{
	        	  row.createCell(13).setCellValue("");//出差 
	        	  
	          }
	           
	          if(list.get(i).getProject()!=null){
	        	  row.createCell(14).setCellValue(list.get(i).getProject());//出差费
	          }else{
	        	  row.createCell(14).setCellValue("");//出差费
	          }
	           
	          if(list.get(i).getOrderName()!=null){
	        	   row.createCell(15).setCellValue(list.get(i).getOrderName());//timebase奖金
	          }else{
	        	  row.createCell(15).setCellValue("");//timebase奖金
	          }
	         
	          if(list.get(i).getOfficeSite()!=null){
	        	  row.createCell(16).setCellValue(list.get(i).getOfficeSite());//taskbase奖金
	          }else{
	        	  row.createCell(16).setCellValue("");//taskbase奖金
	          }
	           
	            if( list.get(i).getCostClass()!=null){row.createCell(17).setCellValue(list.get(i).getCostClass());//交通费
	            }else{
	            	row.createCell(17).setCellValue("");
	            }
	           
	            if(list.get(i).getMoneyMonth()!=null){
	            	  row.createCell(18).setCellValue(list.get(i).getMoneyMonth());//社保扣款
	            }else{
	            	 row.createCell(18).setCellValue("");//社保扣款
	            }
	          
	            if(list.get(i).getReceiverName()!=null){
	            	  row.createCell(19).setCellValue(list.get(i).getReceiverName());//额外奖金
	            }else{
	            	row.createCell(19).setCellValue("");//额外奖金
	            }
	            
	            if(list.get(i).getBank()!=null){
	            	 row.createCell(20).setCellValue(list.get(i).getBank());//小计
	            }else{
	            	 row.createCell(20).setCellValue("");//小计
	            }
	          
	           if(list.get(i).getBrachBank()!=null){
	        	   row.createCell(21).setCellValue(list.get(i).getBrachBank());//税前应发
	           }else{
	        	   row.createCell(21).setCellValue("");//税前应发
	           }
	           if(list.get(i).getBankAccount()!=null){
	        	   row.createCell(22).setCellValue(list.get(i).getBankAccount());//个税
	           }else{
	        	   row.createCell(22).setCellValue("");//个税
	           }
	            
	           if(list.get(i).getTotalMoney()!=null){
	        	   row.createCell(23).setCellValue(list.get(i).getTotalMoney());//个税
	           }else{
	        	   row.createCell(23).setCellValue("");//个税
	           }
	           if(list.get(i).getTotalMoneyUpper()!=null){
	        	   row.createCell(24).setCellValue(list.get(i).getTotalMoneyUpper());//个税
	           }else{
	        	   row.createCell(24).setCellValue("");//个税
	           }
	           if(list.get(i).getImage()!=null){
	        	   row.createCell(25).setCellValue(list.get(i).getImage());//个税
	           }else{
	        	   row.createCell(25).setCellValue("");//个税
	           }
	           if(list.get(i).getDescription()!=null){
	        	   row.createCell(26).setCellValue(list.get(i).getDescription());//个税
	           }else{
	        	   row.createCell(26).setCellValue("");//个税
	           }
	           if(list.get(i).getInvoice()!=null){
	        	   row.createCell(27).setCellValue(list.get(i).getInvoice());//个税
	           }else{
	        	   row.createCell(27).setCellValue("");//个税
	           }
	           if(list.get(i).getInvoiceClass()!=null){
	        	   row.createCell(28).setCellValue(list.get(i).getInvoiceClass());//个税
	           }else{
	        	   row.createCell(28).setCellValue("");//个税
	           }
	           if(list.get(i).getInvoiceCode()!=null){
	        	   row.createCell(29).setCellValue(list.get(i).getInvoiceCode());//个税
	           }else{
	        	   row.createCell(29).setCellValue("");//个税
	           }
	           if(list.get(i).getInvoiceNumber()!=null){
	        	   row.createCell(30).setCellValue(list.get(i).getInvoiceNumber());//个税
	           }else{
	        	   row.createCell(30).setCellValue("");//个税
	           }
	           if(list.get(i).getInvoiceTime()!=null){
	        	   row.createCell(31).setCellValue(list.get(i).getInvoiceTime());//个税
	           }else{
	        	   row.createCell(31).setCellValue("");//个税
	           }
	           if(list.get(i).getReceiveOrg()!=null){
	        	   row.createCell(32).setCellValue(list.get(i).getReceiveOrg());//个税
	           }else{
	        	   row.createCell(32).setCellValue("");//个税
	           }
	           if(list.get(i).getReceiveOrgNumber()!=null){
	        	   row.createCell(33).setCellValue(list.get(i).getReceiveOrgNumber());//个税
	           }else{
	        	   row.createCell(33).setCellValue("");//个税
	           }
	           if(list.get(i).getReceiveMoney()!=null){
	        	   row.createCell(34).setCellValue(list.get(i).getReceiveMoney());//个税
	           }else{
	        	   row.createCell(34).setCellValue("");//个税
	           }
	           if(list.get(i).getImage()!=null){
	        	   row.createCell(35).setCellValue(list.get(i).getImage());//个税
	           }else{
	        	   row.createCell(35).setCellValue("");//个税
	           }
	           
	        }
	        return wb;
	    }
}
