package com.util;

import java.io.IOException;
import java.io.OutputStream;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.model.YoAtteninfoExcelExport;


/**
 * 数据导出工具类
 * @author mawei
 *
 */
public class ExportUtil {
	
	/**
	 * 获得HSSFWorkbook
	 * @param list 数据信息
	 * @param excelHeader 表头
	 * @return HSSFWorkbook
	 */
  
   private static HSSFWorkbook getHSSFWorkbook(List<String> list,String []excelHeader){
    	
    	HSSFWorkbook wb = new HSSFWorkbook();
    	//创建一个sheet
    	HSSFSheet sheet= wb.createSheet("sheet1");
        //设置单元格宽度
    	sheet.setColumnWidth(1,(int)(14+0.72)*256);
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
    	for(int i=0;i<list.size()-1;i++){
    		//创建新的一行
    		row = sheet.createRow(i+1);
    		//每行中写入与表头列数个数相等的数据
    		for(int k=0;k < excelHeader.length;k++){
    			row.createCell(k).setCellValue(list.get(i*k+k));
    		}
    	}
    	return wb;
    }
    public static void export(List<String> list,String []excelHeader,HttpServletResponse response){
    	HSSFWorkbook wb = getHSSFWorkbook(list,excelHeader);
    	response.setContentType("application/vnd.ms-excel");    
        response.setHeader("Content-disposition", "attachment;filename=keyword.xls");    
        OutputStream ouputStream;
		try {
			ouputStream = response.getOutputStream();
			wb.write(ouputStream);    
	        ouputStream.flush();    
	        ouputStream.close();  
		} catch (IOException e) {
			System.out.println("=========关键字模板导出error");
			e.printStackTrace();
		}    
    }
    /**
	 * 获得HSSFWorkbook
	 * @param list 数据信息
	 * @param excelHeader 表头
	 * @return HSSFWorkbook
	 */
  
   private static  HSSFWorkbook getHSSFWorkbook2(List<YoAtteninfoExcelExport> list,String[] excelHeader){
    	
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
    	row.createCell(0).setCellValue(list.get(i).getName());
    	row.createCell(1).setCellValue(list.get(i).getStaffId());
    	row.createCell(2).setCellValue(list.get(i).getDepartment());
    	row.createCell(3).setCellValue(list.get(i).getProjectName());
    	row.createCell(4).setCellValue(list.get(i).getOrderName());
    	row.createCell(5).setCellValue(list.get(i).getContractType());
    	row.createCell(6).setCellValue(list.get(i).getAttendTime());
    	row.createCell(7).setCellValue(list.get(i).getAttendResult());
    	row.createCell(8).setCellValue(list.get(i).getRemark());
    	row.createCell(9).setCellValue(list.get(i).getDeviceid());
    		
    	}
    	return wb;
    }
    public static void export2(List<YoAtteninfoExcelExport> list,String[] excelHeader,HttpServletResponse response){
    	HSSFWorkbook wb = getHSSFWorkbook2(list,excelHeader);
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
  
}
