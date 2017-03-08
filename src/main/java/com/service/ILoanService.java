package com.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.model.YoAdvance;
import com.model.YoLoan;




public interface ILoanService {
   
	/**
	 * 根据单条预付款信息构造对应的单条冲借款记录
	 * @param advance
	 * @return
	 */
	public YoLoan construct(YoAdvance advance, String approveRepayment,
			String approveInvoice, String imageUrl);
	/**
	 * 保存单条冲借款记录
	 * @param loan
	 */
	public void save(YoLoan loan);
	/**
	 * 预付款导出
	 * @param advanceList
	 * @param excelHeader 表头
	 */
	public void advanceExport(List<YoLoan> loanList,String []excelHeader,HttpServletResponse response);
	/**
	 * 预付款导出查询--下载
	 * @param advance
	 * @return
	 */
	public List<YoLoan> searchForExport(YoLoan loan);
	/**
	 * 预付款界面展示条件查询
	 * @param advance
	 * @return
	 */
	public List<YoLoan> search(YoLoan loan);
	/**
	 * 根据审批编号选择性的更新
	 * @param loan
	 */
	public void updateApproveMessage(YoLoan loan);
	/**
	 * 根据approve(审批编号)找到财务对应的冲借款信息
	 * @param approveNo
	 * @return
	 */
	public YoLoan selectByApproveNo(String approveNo);
	/**
	 * 更新冲借款信息
	 */
	public void updateByPrimarykey(YoLoan loan);
}
