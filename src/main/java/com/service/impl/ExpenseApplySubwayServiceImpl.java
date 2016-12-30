package com.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ExpenseApplySubwayMapper;
import com.model.ExpenseApplayTrain;
import com.model.ExpenseApplySubway;
import com.service.IExpenseApplySubwayService;
import com.util.DDSendMessageUtil;
@Service
public class ExpenseApplySubwayServiceImpl implements IExpenseApplySubwayService{
	@Autowired
	private ExpenseApplySubwayMapper subwayMapper;
	@Override
	public int saveOrUpdate(ExpenseApplySubway expenseSubway){
		if(expenseSubway.getId() == null || "".equals(expenseSubway.getId())){//id为空进行插入
			subwayMapper.insert(expenseSubway);
			return expenseSubway.getId();//返回主键ID
		}else{//ID不为空进行更新
			return subwayMapper.updateByPrimaryKeySelective(expenseSubway);//返回插入成功与否 0-失败  1成功
		}
	}
	@Override
	public ExpenseApplySubway selectByPrimarykey(int id){
		return subwayMapper.selectByPrimaryKey(id);
	}
	@Override
	 public ExpenseApplySubway sendTONextManager(ExpenseApplySubway expenseApplySubway){
		   //获取待审批人列表
		   String approverOrder=expenseApplySubway.getApproverOrder();
		   List<String> approverOrderList01 = Arrays.asList(approverOrder.split("\\|"));
		   List<String> approverOrderList = new ArrayList<String>(approverOrderList01);
		   //获取当前审批人信息
		   String approverNow = expenseApplySubway.getApproverNow();
		   //获取历史审批人信息
		   String approverHistory = expenseApplySubway.getApproverHistory();
		   
		   if(approverHistory == null){
			   approverHistory="";
		   }
		   List<String> approverHistoryList01= Arrays.asList(approverHistory.split("\\|"));
		   List<String> approverHistoryList = new ArrayList<String>(approverHistoryList01);
		   //待审批人列表信息
		   approverOrderList.removeAll(approverHistoryList);
		   //如果是最后一个审批人
	      if(approverOrderList.size()==1 || approverOrderList.size()==0){
	    	  expenseApplySubway.setApproveStatus("审核通过");
	    	  if(approverHistory== null || "".equals(approverHistory)){//只有一个审核人的情况
	    		  expenseApplySubway.setApproverHistory(approverNow);
	    	  }else{//报销对应多个审核人，但是当前操作为最后一个审核人的操作
	    		  expenseApplySubway.setApproverHistory(approverHistory+"|"+approverNow);
	    	  }
	    	  expenseApplySubway.setApproverNow("");
	       
	      }else if(approverOrderList.size()>1){
	    	 
	    	 
	    	  String toUser = approverOrderList.get(1);
	    	  expenseApplySubway.setApproverNow(toUser);
	    	  if(approverHistory == null || "".equals(approverHistory))
	    	  {
	    		  expenseApplySubway.setApproverHistory(approverNow);
	    	  }else{
	    		  expenseApplySubway.setApproverHistory(approverHistory+"|"+approverNow);
	    	  }
	    	  DDSendMessageUtil.sendMessageSubway(expenseApplySubway, expenseApplySubway.getId(),toUser );
	    	  System.out.println("发送消息给二级管理员");
	    	 
	      }
	      return expenseApplySubway;
	   }
	
	@Override
	public ExpenseApplySubway refuseOption(ExpenseApplySubway expenseApplySubway){
	 //审批历史记录
	  String approverHistory = expenseApplySubway.getApproverHistory();
	//获取当前审批人信息
	  String approverNow = expenseApplySubway.getApproverNow();
	  if(approverHistory== null || "".equals(approverHistory)){//只有一个审核人的情况
   		  expenseApplySubway.setApproverHistory(approverNow);
   	  }else{//报销对应多个审核人，但是当前操作为最后一个审核人的操作
   		  expenseApplySubway.setApproverHistory(approverHistory+"|"+approverNow);
   	  }
	  expenseApplySubway.setApproveStatus("驳回");
   	  expenseApplySubway.setApproverNow("");
   	  return expenseApplySubway;
	}
}
