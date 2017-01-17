package com.service.impl;

import com.dao.AskForLeaveMapper;
import com.model.AskForLeave;
import com.model.AskForLeaveExample;
import com.model.YoAdvance;
import com.service.IAskLeaveService;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by ma on 2016/10/15.
 */
@Transactional
@Service
public class AskLeaveServiceImpl implements IAskLeaveService {
   @Autowired
   public AskForLeaveMapper askForLeaveMapper;

//   @Autowired
//   public AskForLeaveMapper askForLeaveMapper;

   @Override
   public List<AskForLeave> selectByExample() {
      return askForLeaveMapper.selectByExample();
   }
   @Override
   public List<AskForLeave> selectByExample(AskForLeaveExample example) {
      return askForLeaveMapper.selectByExample(example);
   }
   @Override
   public List<AskForLeave> selectByPropertities(AskForLeave askForLeave){
	   return askForLeaveMapper.selectByPropertities(askForLeave);
   }
   @Override
   public void askLeaveExport(List<AskForLeave> List,String []excelHeader,HttpServletResponse response){
   	HSSFWorkbook wb = getHSSFWorkbook(List,excelHeader);
   	response.setContentType("application/vnd.ms-excel");    
       response.setHeader("Content-disposition", "attachment;filename=advance.xls");    
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
    
     private   HSSFWorkbook getHSSFWorkbook(List<AskForLeave> list,String []excelHeader){
      	
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
      	row.createCell(0).setCellValue(list.get(i).getYoApproveNo());
      	   /**标题**/
      	row.createCell(1).setCellValue(list.get(i).getYoTitle());
      		/**审批状态**/
      	row.createCell(2).setCellValue(list.get(i).getYoApproveState());
      		/**审批结果**/
      	row.createCell(3).setCellValue(list.get(i).getYoApproveResult());
      	   /**审批发起时间**/
      	row.createCell(4).setCellValue(list.get(i).getYoApproveBegin());
      		/**审批完成时间**/	
      	row.createCell(5).setCellValue(list.get(i).getYoApproveEnd());
      		/**发起人工号**/
      	row.createCell(6).setCellValue(list.get(i).getYoAskStaffId());
      		/**发起人姓名**/
      	row.createCell(7).setCellValue(list.get(i).getYoAskStaffName());
      		/**发起人部门**/
      	row.createCell(8).setCellValue(list.get(i).getYoAskStaffDepart());
      		/**历史审批人姓名**/
      	row.createCell(9).setCellValue(list.get(i).getYoHistoryApproveName());
      		/**审批记录**/
      	row.createCell(10).setCellValue(list.get(i).getYoApproveRecord());
      	   /**当前处理人姓名**/
      	row.createCell(11).setCellValue(list.get(i).getYoNowApproveName());
      		/**审批耗时**/
      	row.createCell(12).setCellValue(list.get(i).getYoCost());
      		/**请假类型**/
      	row.createCell(13).setCellValue(list.get(i).getYoType());
      	   /**开始日期**/
      	row.createCell(14).setCellValue(list.get(i).getYoAskBeginDate());
      		/**开始时间**/	
      	row.createCell(15).setCellValue(list.get(i).getYoAskBeginTime());
      		/**结束日期**/
      	row.createCell(16).setCellValue(list.get(i).getYoAskEndDate());
      		/**结束时间**/
      	row.createCell(17).setCellValue(list.get(i).getYoAskEndTime());
      		/**请假天数**/
      	row.createCell(18).setCellValue(list.get(i).getYoAskSustain());
      		/**请假事由**/
      	row.createCell(19).setCellValue(list.get(i).getYoAskReason());
   	   		/**图片**/
      	row.createCell(20).setCellValue(list.get(i).getYoPicture());
      	}
      	return wb;
      	
      }
     
}
