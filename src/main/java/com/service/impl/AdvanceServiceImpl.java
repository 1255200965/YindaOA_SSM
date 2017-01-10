package com.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.YoAdvanceMapper;
import com.model.YoAdvance;
import com.model.YoAdvanceExample;
import com.model.YoAtteninfoExcelExport;
import com.service.IAdvanceService;
import com.util.ExportUtil;

@Service
public class AdvanceServiceImpl implements IAdvanceService{
	
	@Autowired
	private YoAdvanceMapper advanceMapper;
	
	YoAdvance advance2 = new YoAdvance();
	@Override
	public List<String []> readExcel(InputStream is) throws IOException{
		
		YoAdvance advance = new YoAdvance();
		List<String []> errorList = new ArrayList<String[]>();//导入错误汇总
		@SuppressWarnings("resource")
		Workbook workbook = new HSSFWorkbook(is);
         
		Sheet sheet=null;
	    
	 for(int s = 0;s < workbook.getNumberOfSheets();s++){
			//获取第一个sheet
	    sheet= workbook.getSheetAt(s);
    		//获取表头
        Row rowHead = sheet.getRow(0);
        	//表头验证
        String errorMsg[] = ExcelHeadValidate(rowHead);
        if(errorMsg[0] !=null){
        	errorMsg[1] +="第"+s+"个Sheet";
        	errorList.add(errorMsg);
        		//表头验证失败直接返回,错误信息
        	return errorList;
        }
        	//获取总行数
        int totalRowNum =sheet.getLastRowNum();
        	//获取总列数
//        int totalCellNum =rowHead.getPhysicalNumberOfCells();
        //按行读取数据
        for(int i = 1 ;i<=totalRowNum;i++){
        	
        	Row row = sheet.getRow(i);
        	try{    
        	    		//从第1列读入
        			int j=0; 
        			advance.setApproveNo(row.getCell(j++).getStringCellValue().toString());
        			advance.setTitle(row.getCell(j++).getStringCellValue().toString());
        			advance.setApproveStatus(row.getCell(j++).getStringCellValue().toString());
        			advance.setApproveResult(row.getCell(j++).getStringCellValue().toString());
        			advance.setAskStartTime(row.getCell(j++).getStringCellValue().toString());
        			advance.setAskEndTime(row.getCell(j++).getStringCellValue().toString());
        			advance.setAskStaffId(row.getCell(j++).getStringCellValue().toString());
        			advance.setAskStaffName(row.getCell(j++).getStringCellValue().toString());
        			advance.setAskStaffDep(row.getCell(j++).getStringCellValue().toString());
        			advance.setApproverHistory(row.getCell(j++).getStringCellValue().toString());
        			advance.setApproveRecord(row.getCell(j++).getStringCellValue().toString());
        			advance.setApproverNow(row.getCell(j++).getStringCellValue().toString());
        			advance.setApproveCost(row.getCell(j++).getStringCellValue().toString());
        			advance.setAdvanceStartTime(row.getCell(j++).getStringCellValue().toString());
        				//借款用途大类
        			advance.setAdvanceAimMc(row.getCell(j++).getStringCellValue().toString());
        				//获取借款用途小类
        			j++;
        			while(row.getCell(j).getStringCellValue().toString() != null && !"".equals(row.getCell(j).getStringCellValue().toString())){
        			   if(row.getCell(j).getStringCellValue().toString() != null && !"".equals(row.getCell(j).getStringCellValue().toString())){
        				   advance.setAdvanceAimSc(row.getCell(j).getStringCellValue().toString());  
        				   break;
        			   }
        			   j++;
        			}
        				//获取到借款用途小类之后直接去获取借款金额
        			j=20;
        			advance.setAdvanceSum(row.getCell(j++).getStringCellValue().toString());
                    advance.setAdvancePayee(row.getCell(j++).getStringCellValue().toString());
                    advance.setAdvanceBank(row.getCell(j++).getStringCellValue().toString());
                    advance.setAdvanceBranch(row.getCell(j++).getStringCellValue().toString());
                    advance.setAdvanceBankAccount(row.getCell(j++).getStringCellValue().toString());
                    advance.setAdvanceReason(row.getCell(j++).getStringCellValue().toString());
                    advance.setOther(row.getCell(j++).getStringCellValue().toString());
                   
                    if(isExistRecord(advance.getApproveNo())){
                    	
                    	advanceMapper.updateByPrimaryKeySelective(advance);
                    }else{
                    	
                    	advanceMapper.insert(advance);
                    }
        			if(j > 26) continue;
        		
        			
        	}catch(Exception e){
        		e.printStackTrace();
        		errorMsg[0]="行数据导入错误";
        		errorMsg[1]="第"+s+"个sheet;"+(i+1)+"行数据导入错误";
        		errorList.add(errorMsg);
        	}
        
        }
	 }
        return errorList;
	 
	}
	/**
	 * 判断当前数据是否已经在数据库中
	 * @param approveNo
	 * @return true--存在;false--不存在
	 */
	public boolean isExistRecord(String approveNo){
		
		YoAdvanceExample example = new YoAdvanceExample();
		YoAdvanceExample.Criteria criteria = example.createCriteria();
		criteria.andApproveNoEqualTo(approveNo);
		List<YoAdvance> adList= advanceMapper.selectByExample(example);
		if(adList == null || adList.isEmpty()){
			return false;
		}else{
			return true;
		}
		
	}
	
	 /**
     * 表头验证
     * @param rowHead
     * @return
     */
    private String[] ExcelHeadValidate(Row rowHead){
    	
    		//错误信息
    	String []errorMsg = new String[2];
    	int totalCellNum =rowHead.getPhysicalNumberOfCells();
    	
    	if(totalCellNum != 27){
    		
    		errorMsg[0]="导入失败";
    		errorMsg[1]="excel表格列数与要求格式列数不一致,无法导入";
    		return errorMsg;
    	}else{
    		
            if( !"审批编号".equals(rowHead.getCell(0).getStringCellValue())){
    			
    			errorMsg[0]="导入失败";
    			errorMsg[1]="excel第1列列名称不是\"审批编号\",与导入要求不符";
    			return errorMsg;	
    		}
            
            if( !"标题".equals(rowHead.getCell(1).getStringCellValue())){
    			
    			errorMsg[0]="导入失败";
    			errorMsg[1]="excel第2列名称不是\"标题\",与导入要求不符";
    			return errorMsg;	
    		}
            
            if( !"审批状态".equals(rowHead.getCell(2).getStringCellValue())){
    			
    			errorMsg[0]="导入失败";
    			errorMsg[1]="excel第3列名称不是\"审批状态\",与导入要求不符";
    			return errorMsg;	
    		}
            
            if( !"审批结果".equals(rowHead.getCell(3).getStringCellValue())){
    			
    			errorMsg[0]="导入失败";
    			errorMsg[1]="excel第4列名称不是\"审批结果\",与导入要求不符";
    			return errorMsg;	
    		}
            
            if( !"审批发起时间".equals(rowHead.getCell(4).getStringCellValue())){
    			
    			errorMsg[0]="导入失败";
    			errorMsg[1]="excel第5列名称不是\"审批发起时间\",与导入要求不符";
    			return errorMsg;	
    		}
            if( !"审批完成时间".equals(rowHead.getCell(5).getStringCellValue().toString())){
    			
    			errorMsg[0]="导入失败";
    			errorMsg[1]="excel第6列名称不是\"审批完成时间\",与导入要求不符";
    			return errorMsg;	
    		}
            if( !"借款时间".equals(rowHead.getCell(13).getStringCellValue())){
    			
    			errorMsg[0]="导入失败";
    			errorMsg[1]="excel第14列名称不是\"借款时间\",与导入要求不符";
    			return errorMsg;	
    		}
            if( !"借款用途大类".equals(rowHead.getCell(14).getStringCellValue())){
		
 				errorMsg[0]="导入失败";
 				errorMsg[1]="excel第15列名称不是\"借款用途\",与导入要求不符";
 				return errorMsg;	
 		}
            if( !"借款用途小类".equals(rowHead.getCell(15).getStringCellValue())){
        		
 				errorMsg[0]="导入失败";
 				errorMsg[1]="excel第16列名称不是\"借款用途小类\",与导入要求不符";
 				return errorMsg;	
 		}
    		return errorMsg;
    	}	
    }
    @Override
	public List<YoAdvance> search(YoAdvance advance){
    	
		YoAdvanceExample example = new YoAdvanceExample();
		YoAdvanceExample.Criteria criteria = example.createCriteria();
		if(advance.getAskStaffName() != null && !"".equals(advance.getAskStaffName()))
				criteria.andAskStaffNameLike("%"+advance.getAskStaffName()+"%");
		if(advance.getAskStaffId() != null && !"".equals(advance.getAskStaffId()))
				criteria.andAskStaffIdEqualTo(advance.getAskStaffId());
		if(advance.getAskStaffDep() != null && !"".equals(advance.getAskStaffDep()))
				criteria.andAskStaffDepEqualTo(advance.getAskStaffDep());
		if(advance.getAskStartTime() != null && !"".equals(advance.getAskStartTime()))
				criteria.andAdvanceStartTimeGreaterThanOrEqualTo(advance.getAskStartTime());
		if(advance.getAskEndTime() != null && !"".equals(advance.getAskEndTime()))
				criteria.andAdvanceStartTimeLessThanOrEqualTo(advance.getAskEndTime());
		
		
		return advanceMapper.selectByExample(example);	
	}
    @Override
	public List<YoAdvance> searchForExport(YoAdvance advance){
    	
		YoAdvanceExample example = new YoAdvanceExample();
		YoAdvanceExample.Criteria criteria = example.createCriteria();
		if(advance.getAskStaffName() != null && !"".equals(advance.getAskStaffName()))
				criteria.andAskStaffNameLike("%"+advance.getAskStaffName()+"%");
		if(advance.getAskStaffId() != null && !"".equals(advance.getAskStaffId()))
				criteria.andAskStaffIdEqualTo(advance.getAskStaffId());
		if(advance.getAskStaffDep() != null && !"".equals(advance.getAskStaffDep()))
				criteria.andAskStaffDepEqualTo(advance.getAskStaffDep());
		if(advance.getAskStartTime() != null && !"".equals(advance.getAskStartTime()))
				criteria.andAdvanceStartTimeGreaterThanOrEqualTo(advance.getAskStartTime());
		if(advance.getAskEndTime() != null && !"".equals(advance.getAskEndTime()))
		{
				criteria.andAdvanceStartTimeLessThanOrEqualTo(advance.getAskEndTime());
		}
		criteria.andExportStatusIsNull();
		return advanceMapper.selectByExample(example);	
	}
    @Override
    public void advanceExport(List<YoAdvance> advanceList,String []excelHeader,
    		HttpServletResponse response){
    	HSSFWorkbook wb = getHSSFWorkbook(advanceList,excelHeader);
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
     
      private   HSSFWorkbook getHSSFWorkbook(List<YoAdvance> list,String []excelHeader){
       	
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
       	row.createCell(0).setCellValue(list.get(i).getApproveNo());
       	   /**标题**/
       	row.createCell(1).setCellValue(list.get(i).getTitle());
       		/**审批状态**/
       	row.createCell(2).setCellValue(list.get(i).getApproveStatus());
       		/**审批结果**/
       	row.createCell(3).setCellValue(list.get(i).getApproveResult());
       	   /**审批发起时间**/
       	row.createCell(4).setCellValue(list.get(i).getAskStartTime());
       		/**审批完成时间**/	
       	row.createCell(5).setCellValue(list.get(i).getAskEndTime());
       		/**发起人工号**/
       	row.createCell(6).setCellValue(list.get(i).getAskStaffId());
       		/**发起人姓名**/
       	row.createCell(7).setCellValue(list.get(i).getAskStaffName());
       		/**发起人部门**/
       	row.createCell(8).setCellValue(list.get(i).getAskStaffDep());
       		/**历史审批人姓名**/
       	row.createCell(9).setCellValue(list.get(i).getApproverHistory());
       		/**审批记录**/
       	row.createCell(10).setCellValue(list.get(i).getApproveRecord());
       	   /**当前处理人姓名**/
       	row.createCell(11).setCellValue(list.get(i).getApproverNow());
       		/**审批耗时**/
       	row.createCell(12).setCellValue(list.get(i).getApproveCost());
       		/**借款时间**/
       	row.createCell(13).setCellValue(list.get(i).getAdvanceStartTime());
       	   /**借款用途大类**/
       	row.createCell(14).setCellValue(list.get(i).getAdvanceAimMc());
       		/**借款用途小类**/	
       	row.createCell(15).setCellValue(list.get(i).getAdvanceAimSc());
       		/**借款金额**/
       	row.createCell(16).setCellValue(list.get(i).getAdvanceSum());
       		/**收款人**/
       	row.createCell(17).setCellValue(list.get(i).getAdvancePayee());
       		/**开户银行**/
       	row.createCell(18).setCellValue(list.get(i).getAdvanceBank());
       		/**开户支行**/
       	row.createCell(19).setCellValue(list.get(i).getAdvanceBranch());
    	   /**银行账号**/
       	row.createCell(20).setCellValue(list.get(i).getAdvanceBankAccount());
       		/**借款原因**/
       	row.createCell(21).setCellValue(list.get(i).getAdvanceReason());
       		/**其他**/
       	row.createCell(22).setCellValue(list.get(i).getOther());
       		//更新记录下载状态
    	advance2 = list.get(i);
    	advance2.setExportStatus("已下载");
       	advanceMapper.updateByPrimaryKeySelective(advance2);
       	}
       	return wb;
       }
      
      
}
