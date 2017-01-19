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
	public YoLoan construct(YoAdvance advance);
	/**
	 * 保存单条冲借款记录
	 * @param loan
	 */
	public void save(YoLoan loan);
	/**
	 * 预付款导出

	 * @param excelHeader 表头
	 */
	public void advanceExport(List<YoLoan> loanList,String []excelHeader,HttpServletResponse response);
	/**
	 * 预付款导出查询--下载

	 * @return
	 */
	public List<YoLoan> searchForExport(YoLoan loan);
	/**
	 * 预付款界面展示条件查询

	 * @return
	 */
	public List<YoLoan> search(YoLoan loan);
}
