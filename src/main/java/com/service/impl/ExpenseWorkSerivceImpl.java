package com.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ExpenseWorkMapper;
import com.model.ExpenseApplayTrainExample;
import com.model.ExpenseWork;
import com.model.ExpenseWorkExample;
import com.model.YoSocialSecurityInfo;
import com.model.YoSocialSecurityInfoExample;
import com.service.ExpenseWorkSerivce;
@Service
public class ExpenseWorkSerivceImpl implements ExpenseWorkSerivce{
	@Autowired
	private ExpenseWorkMapper expenseWorkMapper;



    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Override
	public Map<String, Object> insertAndUpdate(HSSFWorkbook hssfWorkbook) {
		// TODO Auto-generated method stub
		Map<String, Object> mapInsert = new HashMap<String, Object>();
		List<ExpenseWork> listFail = new ArrayList<ExpenseWork>();
        
		

		//插入的数据
		List<ExpenseWork> insertList = new ArrayList<ExpenseWork>(); 

		//更新的数据
		List<ExpenseWork> updateList = new ArrayList<ExpenseWork>();
		
		
		int sheetNumber = hssfWorkbook.getNumberOfSheets();
		System.out.println("总表单数为："+hssfWorkbook.getNumberOfSheets());
		
		
		for(int j =0 ;j<sheetNumber;j++){
			
	   // 得j张到第表
	    HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(j);
	    
	    
		// 这里不要用物理行数，要用最后一行的编号，不然很容易跳坑
		int rowLastNo = hssfSheet.getLastRowNum();
        
		// 设定一个变量，记录for循环当中操作成功的条目数目
		int successAmount = 0;

		
        //校验表头
		HSSFRow hssfRow0 =hssfSheet.getRow(0);
		  String []excelHeader = {"审批编号","标题","审批状态","审批结果","审批发起时间","审批完成时间","发起人工号","发起人姓名","发起人部门",
		            "历史审批人姓名","审批记录","当前处理人姓名","审批耗时","所属部门","所属项目","所属订单","办事处名称","费用类别",
		            "费用月份","收款人","开户银行","开户支行","银行账号","总金额（元）","总金额（元）(大写)","银行卡照片","说明","发票","发票类型","发票代码","发票号码","发票日期","收款方名称","收款方税号","金额（元）","图片"};
		  
		  
		for(int i=0;i<excelHeader.length;i++){
			String name = hssfRow0.getCell(i).getStringCellValue();
			if(name.contains(excelHeader[i])){
				continue;
			}else{
				mapInsert.put("listFail", "表头校验失败，请检查excel表头！");
				return mapInsert;
			}
		}
		// 接下来从第2行开始，对每一行进行操作
		for (int rowNo=1; rowNo<=rowLastNo; rowNo++) {
			HSSFRow hssfRow = hssfSheet.getRow(rowNo);
			// 同理，这里也不要用单元格的总数，要用最后一个单元格的序号
			int cellLastNo = hssfRow.getLastCellNum();

			/*
	            现在开始做真正的功能！
	            第1步，把得到的hssfRow中每一个不为null的cell都设为文本类型，确保每一个整形数值在toString后不会自动加上.0
			 */
			for (int cellNo=0; cellNo<=cellLastNo; cellNo++) {
				// cell不为空时才操作，为空也就不用管他是什么类型了
				// 想管也管不起，因为会报NullPointerException，而我们编程时应当避免异常，而不是积极处理异常
				if (hssfRow.getCell(cellNo) != null) hssfRow.getCell(cellNo).setCellType(1);
			}

			/*
	            第2步，检查当前行是不是空行，如果是就跳过后面的，操作下一行
	            检查方法：空的单元格的数目是否等于最后单元格序号+1
			 */
			int emptyCellAmount = 0;
			for (int cellNo=0; cellNo<=cellLastNo; cellNo++) {
				if (hssfRow.getCell(cellNo)==null || hssfRow.getCell(cellNo).toString().equals("")) {
					// 这里就可以用++i了，听说运算速度更快= =
					++emptyCellAmount;
				}
			}
			if (emptyCellAmount == cellLastNo+1) continue;

			/*
	            第3步，对于不为空的行，将数据注入引用过来的实体对象
			 */
			int cellNo = -1;
			ExpenseWork expenseWork = new ExpenseWork();
			if (hssfRow.getCell(++cellNo) != null) expenseWork.setApproveNumber(hssfRow.getCell(cellNo).toString());//审批编号
			if (hssfRow.getCell(++cellNo) != null) expenseWork.setTitle(hssfRow.getCell(cellNo).toString());//标题
			if (hssfRow.getCell(++cellNo) != null) expenseWork.setExpenseStatus(hssfRow.getCell(cellNo).toString());//审批状态
			if (hssfRow.getCell(++cellNo) != null) expenseWork.setResult(hssfRow.getCell(cellNo).toString());//审批结果
			if (hssfRow.getCell(++cellNo) != null) expenseWork.setStartTime(hssfRow.getCell(cellNo).toString());//审批发起时间
			if (hssfRow.getCell(++cellNo) != null) expenseWork.setEndTime(hssfRow.getCell(cellNo).toString());//审批完成时间
			if (hssfRow.getCell(++cellNo) != null) expenseWork.setApplyStaffId(hssfRow.getCell(cellNo).toString());//发起人工号
			if (hssfRow.getCell(++cellNo) != null) expenseWork.setApplyName(hssfRow.getCell(cellNo).toString());//发起人姓名
			if (hssfRow.getCell(++cellNo) != null) expenseWork.setApplyDepartment(hssfRow.getCell(cellNo).toString());//发起人部门
			if (hssfRow.getCell(++cellNo) != null) expenseWork.setHistotyAccess(hssfRow.getCell(cellNo).toString());//历史审批人姓名
			if (hssfRow.getCell(++cellNo) != null) expenseWork.setHistoryRecord(hssfRow.getCell(cellNo).toString());//审批记录
			if (hssfRow.getCell(++cellNo) != null) expenseWork.setNowAccess(hssfRow.getCell(cellNo).toString());//当前处理人姓名
			if (hssfRow.getCell(++cellNo) != null) expenseWork.setUsedTime(hssfRow.getCell(cellNo).toString());//审批耗时
			if (hssfRow.getCell(++cellNo) != null) expenseWork.setDepartment(hssfRow.getCell(cellNo).toString());	//所属部门
			if (hssfRow.getCell(++cellNo) != null) expenseWork.setProject(hssfRow.getCell(cellNo).toString());//所属项目
			if (hssfRow.getCell(++cellNo) != null) expenseWork.setOrderName(hssfRow.getCell(cellNo).toString());//所属订单
			if (hssfRow.getCell(++cellNo) != null) expenseWork.setOfficeSite(hssfRow.getCell(cellNo).toString());//办事处名称
			if (hssfRow.getCell(++cellNo) != null) expenseWork.setCostClass(hssfRow.getCell(cellNo).toString());//费用类别
			if (hssfRow.getCell(++cellNo) != null) expenseWork.setMoneyMonth(hssfRow.getCell(cellNo).toString());
			if (hssfRow.getCell(++cellNo) != null) expenseWork.setReceiverName(hssfRow.getCell(cellNo).toString());//收款人
			if (hssfRow.getCell(++cellNo) != null) expenseWork.setBank(hssfRow.getCell(cellNo).toString());//开户银行
			if (hssfRow.getCell(++cellNo) != null) expenseWork.setBrachBank(hssfRow.getCell(cellNo).toString());//开户支行
			if (hssfRow.getCell(++cellNo) != null) expenseWork.setBankAccount(hssfRow.getCell(cellNo).toString());//银行账号
			if (hssfRow.getCell(++cellNo) != null) expenseWork.setTotalMoney(hssfRow.getCell(cellNo).toString());//总金额
			if (hssfRow.getCell(++cellNo) != null) expenseWork.setTotalMoneyUpper(hssfRow.getCell(cellNo).toString());//总金额
			if (hssfRow.getCell(++cellNo) != null) expenseWork.setBankCardImage(hssfRow.getCell(cellNo).toString());
			if (hssfRow.getCell(++cellNo) != null) expenseWork.setDescription(hssfRow.getCell(cellNo).toString());//说明
			if (hssfRow.getCell(++cellNo) != null) expenseWork.setInvoice(hssfRow.getCell(cellNo).toString());//发票
			if (hssfRow.getCell(++cellNo) != null) expenseWork.setInvoiceClass(hssfRow.getCell(cellNo).toString());//发票类型
			if (hssfRow.getCell(++cellNo) != null) expenseWork.setInvoiceCode(hssfRow.getCell(cellNo).toString());//发票代码
			if (hssfRow.getCell(++cellNo) != null) expenseWork.setInvoiceNumber(hssfRow.getCell(cellNo).toString());//发票号码
			if (hssfRow.getCell(++cellNo) != null) expenseWork.setInvoiceTime(hssfRow.getCell(cellNo).toString());//发票日期
			if (hssfRow.getCell(++cellNo) != null) expenseWork.setReceiveOrg(hssfRow.getCell(cellNo).toString());
			if (hssfRow.getCell(++cellNo) != null) expenseWork.setReceiveOrgNumber(hssfRow.getCell(cellNo).toString());
			if (hssfRow.getCell(++cellNo) != null) expenseWork.setReceiveMoney(hssfRow.getCell(cellNo).toString());
			if (hssfRow.getCell(++cellNo) != null) expenseWork.setImage(hssfRow.getCell(cellNo).toString());
			                                       expenseWork.setImprotTime(sdf.format(new Date()));
		


			/*
	                              第5步，如果审批编号和发票相同，这一条已经存在，则添加到需要更新的List
			 */

			ExpenseWorkExample expenseWorkExample = new ExpenseWorkExample();
			ExpenseWorkExample.Criteria criteria = expenseWorkExample.createCriteria();

			criteria.andApproveNumberEqualTo(expenseWork.getApproveNumber());
			criteria.andInvoiceEqualTo(expenseWork.getInvoice());
			criteria.andIsExportNotEqualTo("已导出");
			List<ExpenseWork> ExpenseWorkList = expenseWorkMapper.selectByExample(expenseWorkExample);

			if (ExpenseWorkList.size() > 0) {
				expenseWork.setId(ExpenseWorkList.get(0).getId());
				updateList.add(expenseWork);
				continue;
			}
		
			// 第6步，如果是一条新信息，就插入新数据
			else {
				try {
					insertList.add(expenseWork);
				} catch (Exception e) {
					listFail.add(expenseWork);
					continue;
				}
			}

			// 到了这一步，说明插入或更新成功，数目自加！
			successAmount++;
			if (successAmount % 1000 == 0) System.out.println(successAmount);
		}
		}
		System.out.println("插入的条数为："+insertList.size());
		System.out.println("更新的条数为："+updateList.size());
		insert(insertList);
		update(updateList);
		// for循环之后，把成功数目和失败列表返回到map
		
		mapInsert.put("listFail", listFail.size()+"");
		mapInsert.put("insertList", insertList.size());
		mapInsert.put("updateList", updateList.size());
		
		return mapInsert;
	}
	/**
	 * 批量插入
	 * @param members
	 */
	public void insert(List<ExpenseWork> members){

		int result = 1;
		int batchCount = 100;// 每批commit的个数
		int batchLastIndex = batchCount;// 每批最后一个的下标
		for (int index = 0; index < members.size();) {
			if (batchLastIndex >= members.size()) {
				batchLastIndex = members.size();
				//result = result * batchSqlSession.insert("ExpenseWorkMapper.insertList",members.subList(index, batchLastIndex));
				// batchSqlSession.commit();
				expenseWorkMapper.insertList(members.subList(index, batchLastIndex));
				System.out.println("index:" + index+ " batchLastIndex:" + batchLastIndex);
				break;// 数据插入完毕，退出循环
			} else {
				//result = result * batchSqlSession.insert("ExpenseWorkMapper.insertList",members.subList(index, batchLastIndex));
				//batchSqlSession.commit();
				expenseWorkMapper.insertList(members.subList(index, batchLastIndex));
				System.out.println("index:" + index+ " batchLastIndex:" + batchLastIndex);
				index = batchLastIndex;// 设置下一批下标
				batchLastIndex = index + (batchCount - 1);
			}
		}
	}

	/**
	 * 批量更新
	 * @param members
	 */
	public void update(List<ExpenseWork> members){
		for(ExpenseWork expenseWork :members){
			expenseWorkMapper.updateByPrimaryKey(expenseWork);
		}


	}
	@Override
	public List<ExpenseWork> search_expenseWorkList(ExpenseWork expenseWork,String endTime1,String endTime2) {
		
		// TODO Auto-generated method stub
		ExpenseWorkExample expenseWorkExample = new ExpenseWorkExample();
		ExpenseWorkExample.Criteria criteria = expenseWorkExample.createCriteria();
        if(expenseWork.getResult()!=null){ criteria.andResultEqualTo(expenseWork.getResult());}
        
        	String value1 = endTime1 + " 00:00:0000";
        	String value2 = endTime2 + " 23:59:9999";
        	criteria.andEndTimeBetween(value1, value2);
        if(expenseWork.getCostClass()!=null){ criteria.andCostClassEqualTo(expenseWork.getCostClass());}
        
        List<ExpenseWork> expenseWorkList = expenseWorkMapper.selectByExample(expenseWorkExample);
		return expenseWorkList;
	} 
}

