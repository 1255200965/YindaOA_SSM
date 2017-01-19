package com.service.impl;


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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.YoLoanMapper;
import com.model.YoAdvance;
import com.model.YoAdvanceExample;
import com.model.YoLoan;
import com.model.YoLoanExample;
import com.service.ILoanService;

@Service
public class LoanServiceImpl implements ILoanService{
	
	@Autowired
	private YoLoanMapper loanMapper;
	
	YoLoan loan2 =new YoLoan();
	
	@Override
	public YoLoan construct(YoAdvance advance){
		
		YoLoan loan = new YoLoan();
		loan.setApproveCost(advance.getApproveCost());
		loan.setApproveNo(advance.getApproveNo());
		loan.setApproveRecord(advance.getApproveRecord());
		loan.setApproveResult(advance.getApproveResult());
		loan.setApproverHistory(advance.getApproverHistory());
		loan.setApproverNow(advance.getApproverNow());
		loan.setApproveStatus(advance.getApproveStatus());
		loan.setAskEndTime(advance.getAskEndTime());
		loan.setAskStaffDep(advance.getAskStaffDep());
		loan.setAskStaffName(advance.getAskStaffName());
		loan.setAskStaffId(advance.getAskStaffId());
		loan.setAskStartTime(advance.getAskStartTime());
		loan.setLoanAimMc(advance.getAdvanceAimMc());
		loan.setLoanAimSc(advance.getAdvanceAimSc());
		loan.setLoanBank(advance.getAdvanceBank());
		loan.setLoanBankAccount(advance.getAdvanceBankAccount());
		loan.setLoanBranch(advance.getAdvanceBranch());
		loan.setLoanPayee(advance.getAdvancePayee());
		loan.setLoanReason(advance.getAdvanceReason());
		loan.setLoanStartTime(advance.getAdvanceStartTime());
		loan.setLoanSum(advance.getAdvanceSum());
		loan.setOther(advance.getOther());
		loan.setTitle(advance.getTitle());
		
		return loan;
		
	}
	@Override
	public void save(YoLoan loan){
		loanMapper.insert(loan);
	}
	@Override
    public void advanceExport(List<YoLoan> loanList,String []excelHeader,
    		HttpServletResponse response){
    	HSSFWorkbook wb = getHSSFWorkbook(loanList,excelHeader);
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
     
      private   HSSFWorkbook getHSSFWorkbook(List<YoLoan> list,String []excelHeader){
       	
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
       	row.createCell(13).setCellValue(list.get(i).getLoanStartTime());
       	   /**借款用途大类**/
       	row.createCell(14).setCellValue(list.get(i).getLoanAimMc());
       		/**借款用途小类**/	
       	row.createCell(15).setCellValue(list.get(i).getLoanAimSc());
       		/**借款金额**/
       	row.createCell(16).setCellValue(list.get(i).getLoanSum());
       		/**收款人**/
       	row.createCell(17).setCellValue(list.get(i).getLoanPayee());
       		/**开户银行**/
       	row.createCell(18).setCellValue(list.get(i).getLoanBank());
       		/**开户支行**/
       	row.createCell(19).setCellValue(list.get(i).getLoanBranch());
    	   /**银行账号**/
       	row.createCell(20).setCellValue(list.get(i).getLoanBankAccount());
       		/**借款原因**/
       	row.createCell(21).setCellValue(list.get(i).getLoanReason());
       		/**其他**/
       	row.createCell(22).setCellValue(list.get(i).getOther());
       	row.createCell(23).setCellValue(list.get(i).getOther());
       		//更新记录下载状态
       	loan2 = list.get(i);
       	loan2.setExportStatus("已下载");
       	loanMapper.updateByPrimaryKeySelective(loan2);
       	}
       	return wb;
       }
      
      @Override
  	public List<YoLoan> searchForExport(YoLoan loan){
      	
  		YoLoanExample example = new YoLoanExample();
  		YoLoanExample.Criteria criteria = example.createCriteria();
  		if(loan.getAskStaffName() != null && !"".equals(loan.getAskStaffName()))
  				criteria.andAskStaffNameLike("%"+loan.getAskStaffName()+"%");
  		if(loan.getAskStaffId() != null && !"".equals(loan.getAskStaffId()))
  				criteria.andAskStaffIdEqualTo(loan.getAskStaffId());
  		if(loan.getAskStaffDep() != null && !"".equals(loan.getAskStaffDep()))
  				criteria.andAskStaffDepEqualTo(loan.getAskStaffDep());
  		if(loan.getAskStartTime() != null && !"".equals(loan.getAskStartTime()))
  				criteria.andLoanStartTimeGreaterThanOrEqualTo(loan.getAskStartTime());
  		if(loan.getAskEndTime() != null && !"".equals(loan.getAskEndTime()))
  		{
  				criteria.andLoanStartTimeLessThanOrEqualTo(loan.getAskEndTime());
  		}
  		if(loan.getApproveResult() != null && !"".equals(loan.getApproveResult()) ){
  			
  			   criteria.andApproveResultEqualTo(loan.getApproveResult());
  			
  		}
  		criteria.andExportStatusIsNull();
  		
  		return loanMapper.selectByExample(example);	
  	}
      
      @Override
  	public List<YoLoan> search(YoLoan loan){
      	
    	 YoLoanExample example = new  YoLoanExample();
    	 YoLoanExample.Criteria criteria = example.createCriteria();
  		if(loan.getAskStaffName() != null && !"".equals(loan.getAskStaffName()))
  				criteria.andAskStaffNameLike("%"+loan.getAskStaffName()+"%");
  		if(loan.getAskStaffId() != null && !"".equals(loan.getAskStaffId()))
  				criteria.andAskStaffIdEqualTo(loan.getAskStaffId());
  		if(loan.getAskStaffDep() != null && !"".equals(loan.getAskStaffDep()))
  				criteria.andAskStaffDepEqualTo(loan.getAskStaffDep());
  		if(loan.getAskStartTime() != null && !"".equals(loan.getAskStartTime()))
  				criteria.andLoanStartTimeGreaterThanOrEqualTo(loan.getAskStartTime());
  		if(loan.getAskEndTime() != null && !"".equals(loan.getAskEndTime()))
  				criteria.andLoanStartTimeLessThanOrEqualTo(loan.getAskEndTime());
  		if(loan.getApproveResult() != null && !"".equals(loan.getApproveResult()) ){
  			
  				   criteria.andApproveResultEqualTo(loan.getApproveResult());
  			
  		}
  		
  		return loanMapper.selectByExample(example);	
  	}
}
