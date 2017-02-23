package com.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ExpenseApplayBusMapper;
import com.model.ExpenseApplayBus;
import com.model.ExpenseApplayBusExample;
import com.model.ToolsForselectApproval;
import com.service.IExpenseApplayBusService;
import com.service.IStaffInfoService;

@Service
public class ExpenseApplayBusServiceImpl implements IExpenseApplayBusService{
  @Autowired
  private ExpenseApplayBusMapper expenseBusMapper;
  @Autowired
  private IStaffInfoService staffInfoService;
  @Override
  public List<ExpenseApplayBus> selectAllByStaffId(String staffId){
	  ExpenseApplayBusExample expenseApplayBusExample = new ExpenseApplayBusExample();
	  ExpenseApplayBusExample.Criteria criteria = expenseApplayBusExample.createCriteria();
	  if(staffId != null) criteria.andStaffIdEqualTo(staffId);
	  List<ExpenseApplayBus> expenseBusList=expenseBusMapper.selectByExample(expenseApplayBusExample);
	  return expenseBusList;
  }
  @Override
  public ExpenseApplayBus selectById(int id){
	  ExpenseApplayBusExample example = new ExpenseApplayBusExample();
	  ExpenseApplayBusExample.Criteria criteria =example.createCriteria();
	  if(id != 0) criteria.andIdEqualTo(id);
	  return (ExpenseApplayBus) expenseBusMapper.selectByExample(example).get(0);
  }
  @Override
  public int saveOrUpdate(ExpenseApplayBus expenseApplayBus){
	  Integer id =expenseApplayBus.getId();
	  if(id==null || id==0){//save
		 expenseBusMapper.insert(expenseApplayBus);
//		 id=expenseApplayBus.getId();
		 return -1;
	  }else{//update
		  
		 return expenseBusMapper.updateByPrimaryKeySelective(expenseApplayBus);
		  }
  }
  @Override
  public int UpdateByPrimaryKey(ExpenseApplayBus expenseApplayBus){
	  return expenseBusMapper.updateByPrimaryKey(expenseApplayBus);
  }
  @Override
  public ExpenseApplayBus sendTONextManager(ExpenseApplayBus expenseApplayBus){
	//获取待审批人列表
	   String approverOrder=expenseApplayBus.getApproverOrder();
	   List<String> approverOrderList01 = Arrays.asList(approverOrder.split("\\|"));
	   List<String> approverOrderList = new ArrayList<String>(approverOrderList01);
	   //获取当前审批人信息
	   String approverNow = expenseApplayBus.getApproverNow();
	   //获取历史审批人信息
	   String approverHistory = expenseApplayBus.getApproverHistory();
	   
	   if(approverHistory == null){
		   approverHistory="";
	   }
	   List<String> approverHistoryList01= Arrays.asList(approverHistory.split("\\|"));
	   List<String> approverHistoryList = new ArrayList<String>(approverHistoryList01);
	   //待审批人列表信息
	   approverOrderList.removeAll(approverHistoryList);
	   //如果是最后一个审批人
     if(approverOrderList.size()==1 || approverOrderList.size()==0){
    	 expenseApplayBus.setApplayStatus("审核通过");
   	  if(approverHistory== null || "".equals(approverHistory) ){//只有一个审核人的情况
   		expenseApplayBus.setApproverHistory(approverNow);
   	  }else{//报销对应多个审核人，但是当前操作为最后一个审核人的操作
   		expenseApplayBus.setApproverHistory(approverHistory+"|"+approverNow);
   	  }
   	  expenseApplayBus.setApproverNow("");
      
     }else if(approverOrderList.size()>1){
   	 
   	 
   	  String toUser = approverOrderList.get(1);
   	 expenseApplayBus.setApproverNow(toUser);
//    	expenseApplayBus.setDestination("非洲");
   	  if(approverHistory == null || "".equals(approverHistory))
   	  {
   		expenseApplayBus.setApproverHistory(approverNow);
   	  }else{
   		expenseApplayBus.setApproverHistory(approverHistory+"|"+approverNow);
   	  }
//   	  DDSendMessageUtil.sendMessageBus(expenseApplayBus, expenseApplayBus.getId(),toUser );
   	  
     }
     return expenseApplayBus;
  }
  @Override
	public ExpenseApplayBus refuseOption(ExpenseApplayBus expenseApplayBus){
	 //审批历史记录
	  String approverHistory = expenseApplayBus.getApproverHistory();
	//获取当前审批人信息
	  String approverNow = expenseApplayBus.getApproverNow();
	  if(approverHistory== null || "".equals(approverHistory)){//只有一个审核人的情况
		  expenseApplayBus.setApproverHistory(approverNow);
 	  }else{//报销对应多个审核人，但是当前操作为最后一个审核人的操作
 		 expenseApplayBus.setApproverHistory(approverHistory+"|"+approverNow);
 	  }
	  expenseApplayBus.setApplayStatus("驳回");
	  expenseApplayBus.setApproverNow("");
 	  return expenseApplayBus;
	}
   @Override
   public List<ExpenseApplayBus> selectByApproveHistory(String approverStaffId){
	   
	   List<ExpenseApplayBus> expenseBusList = expenseBusMapper.selectApproved(approverStaffId);
	   return expenseBusList;  
   }
   @Override
   public List<ExpenseApplayBus> selectApproval(String staffUserId,String staffId){
	   	ToolsForselectApproval tools = new ToolsForselectApproval();
  		tools.setStaffId(staffId);
  		tools.setStaffUserId(staffUserId);
	   List<ExpenseApplayBus> expenseBusList = expenseBusMapper.selectApproval(tools);
	   return expenseBusList;  
   }
   @Override
   public ExpenseApplayBus constructApprovers(ExpenseApplayBus expenseApplayBus){
	   String approverOrders="";
	   String approverNow=null;
	   try{
   			String []approverOrderArray=expenseApplayBus.getApproverOrder().split("\\|");
   			
   				for(String approverOrder : approverOrderArray){
   					approverOrders +=staffInfoService.selectStaffByID(approverOrder).getName()+",";	
   				}
   			
   		}catch(Exception e ){
   			approverOrders="error,请联系管理员";
   		
   		}
	   try{
		   String approverNow01=expenseApplayBus.getApproverNow();
		   if(approverNow01 !=null && !"".equals(approverNow01)){
			   approverNow = staffInfoService.selectStaffByID(approverNow01).getName();
		   }else{
			 approverNow=""; 
		   }
	   }catch(Exception e){
		   approverNow="error,请联系管理员";
	   }
	    expenseApplayBus.setApproverOrder(approverOrders);
  		expenseApplayBus.setApproverNow(approverNow);
  		return expenseApplayBus;
   }
   @Override
   public String delete(int id){
	   try{
		   expenseBusMapper.deleteByPrimaryKey(id);
		   return "success";
	   }catch(Exception e){
		   e.printStackTrace();
		   return "fail";
	   }
   }
   @Override
   public List<ExpenseApplayBus> selectApprovalStaff(String staffUserId){
	   return expenseBusMapper.selectApprovalStaff(staffUserId);
   }
   @Override
   public int selectApprovalCount(String staffUserId){
	   return expenseBusMapper.selectApprovalCount(staffUserId);
	   }
 //查询出上周管理员未审核的报销并进行驳回
   public void updateDelayApproval(String staffUserId){
	   expenseBusMapper.updateDelayApproval(staffUserId);
   }
}
