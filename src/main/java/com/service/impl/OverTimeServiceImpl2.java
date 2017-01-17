package com.service.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.YoOvertimeMapper;
import com.model.YoAdvance;
import com.model.YoOvertime;
import com.service.IOvertimeService;

@Service
public class OverTimeServiceImpl2 implements IOvertimeService{
   @Autowired
   private YoOvertimeMapper overTimeMapper;
   @Override
   public List<YoOvertime> selectByProperties(YoOvertime overTime){
	  return overTimeMapper.selectByProperties(overTime);
   }
   @Override
   public void overtimeExport(List<YoOvertime> overTimeList, String []excelHeader
		   ,HttpServletResponse response){
	   
	   HSSFWorkbook wb = getHSSFWorkbook(overTimeList,excelHeader);
   	response.setContentType("application/vnd.ms-excel");    
       response.setHeader("Content-disposition", "attachment;filename=overtime.xls");    
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
	* */
 
  private   HSSFWorkbook getHSSFWorkbook(List<YoOvertime> list,String []excelHeader){
   	
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
  
   	//创建行
   	HSSFRow row = sheet.createRow(0);
   	//设置表头样式
   	HSSFCellStyle style = wb.createCellStyle();
   	style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//左右居中
   	HSSFFont f = wb.createFont();
   	f.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//加粗
   	//创建表头
   	for(int i = 0;i <excelHeader.length;i++){
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
   		/**审批编号**/
   	row.createCell(0).setCellValue(list.get(i).getOtApproveNo());
   	   /**标题**/
   	row.createCell(1).setCellValue(list.get(i).getOtTitle());
   		/**审批状态**/
   	row.createCell(2).setCellValue(list.get(i).getOtApproveState());
   		/**审批结果**/
   	row.createCell(3).setCellValue(list.get(i).getOtApproveResult());
   	   /**审批发起时间**/
   	row.createCell(4).setCellValue(list.get(i).getOtApproveBegin());
   		/**审批完成时间**/	
   	row.createCell(5).setCellValue(list.get(i).getOtApproveEnd());
   		/**发起人工号**/
   	row.createCell(6).setCellValue(list.get(i).getOtAskStaffId());
   		/**发起人姓名**/
   	row.createCell(7).setCellValue(list.get(i).getOtAskStaffName());
   		/**发起人部门**/
   	row.createCell(8).setCellValue(list.get(i).getOtAskStaffDepart());
   		/**历史审批人姓名**/
   	row.createCell(9).setCellValue(list.get(i).getOtHistoryApproveName());
   		/**审批记录**/
   	row.createCell(10).setCellValue(list.get(i).getOtApproveRecord());
   	   /**当前处理人姓名**/
   	row.createCell(11).setCellValue(list.get(i).getOtNowApproveName());
   		/**审批耗时**/
   	row.createCell(12).setCellValue(list.get(i).getOtCost());
   		/**加班类型**/
   	row.createCell(13).setCellValue(list.get(i).getOtPayMethod());
   	   /**开始时间**/
   	row.createCell(14).setCellValue(list.get(i).getOtAskBeginTime());
   		/**结束时间**/	
   	row.createCell(15).setCellValue(list.get(i).getOtAskEndTime());
   		/**加班时长**/
   	row.createCell(16).setCellValue(list.get(i).getOtAskSustain());
   		/**加班原因**/
   	row.createCell(17).setCellValue(list.get(i).getOtAskReason());
   		/**备注**/
   	row.createCell(18).setCellValue(list.get(i).getOtComment());
   		/**加班地点**/
   	row.createCell(19).setCellValue(list.get(i).getOtComment());
   	}
   	return wb;
   }
  
}
