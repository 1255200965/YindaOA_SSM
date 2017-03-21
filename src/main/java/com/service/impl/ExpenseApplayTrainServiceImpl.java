package com.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BusinessTripMapper;
import com.dao.ExpenseApplayTrainMapper;
import com.model.BusinessTrip;
import com.model.ExpenseApplayBus;
import com.model.ExpenseApplayTrain;
import com.model.ExpenseApplayTrainExample;
import com.model.ExpenseApplySubway;
import com.model.ToolsForselectApproval;
import com.service.IBusinessTripService;
import com.service.IExpenseApplayTrainService;
import com.service.IStaffInfoService;
import com.util.DDSendMessageUtil;
@Service
public class ExpenseApplayTrainServiceImpl implements IExpenseApplayTrainService {
   @Autowired
   private ExpenseApplayTrainMapper expenseApplayTrainMapper;
   @Autowired
   private IStaffInfoService staffInfoService;
   @Autowired
	private BusinessTripMapper businessTripMapper;
   @Override
   public List<ExpenseApplayTrain> selectByStaffId(String staffId){
	   ExpenseApplayTrainExample example = new ExpenseApplayTrainExample();
	   ExpenseApplayTrainExample.Criteria criteria = example.createCriteria();
	   criteria.andStaffIdEqualTo(staffId);
	   List<ExpenseApplayTrain> expenseApplayTrainList = expenseApplayTrainMapper.selectByExample(example);
	   return expenseApplayTrainList;   
   }
   @Override
   public ExpenseApplayTrain selectById(int id){
	    return expenseApplayTrainMapper.selectByPrimaryKey(id);
   }
   @Override
   public int saveOrUpdate(ExpenseApplayTrain expenseApplayTrain){
	   Integer id = expenseApplayTrain.getId();
	   if(id == null || id == 0){//新增并返回主键值
		  expenseApplayTrainMapper.insert(expenseApplayTrain);
//		  id=expenseApplayTrain.getId();
		   return -1;
	   }else{//更新
		 return  expenseApplayTrainMapper.updateByPrimaryKeySelective(expenseApplayTrain); 
	   }
   }
   
   @Override
   public ExpenseApplayTrain sendTONextManager(ExpenseApplayTrain expenseApplayTrain){
	   //获取待审批人列表
	   String approverOrder=expenseApplayTrain.getApproverOrder();
	   List<String> approverOrderList01 = Arrays.asList(approverOrder.split("\\|"));
	   List<String> approverOrderList = new ArrayList<String>(approverOrderList01);
	   //获取当前审批人信息
	   String approverNow = expenseApplayTrain.getApproverNow();
	   //获取历史审批人信息
	   String approverHistory = expenseApplayTrain.getApproverHistory();
	   
	   if(approverHistory == null){
		   approverHistory="";
	   }
	   List<String> approverHistoryList01= Arrays.asList(approverHistory.split("\\|"));
	   List<String> approverHistoryList = new ArrayList<String>(approverHistoryList01);
	   //待审批人列表信息
	   approverOrderList.removeAll(approverHistoryList);
	   //如果是最后一个审批人
      if(approverOrderList.size()==1 || approverOrderList.size()==0){
    	  expenseApplayTrain.setApplayStatus("审核通过");
    	  if(approverHistory== null || "".equals(approverHistory) ){//只有一个审核人的情况
    		  expenseApplayTrain.setApproverHistory(approverNow);
    	  }else{//报销对应多个审核人，但是当前操作为最后一个审核人的操作
    		  expenseApplayTrain.setApproverHistory(approverHistory+"|"+approverNow);
    	  }
    	  expenseApplayTrain.setApproverNow("");
       
      }else if(approverOrderList.size()>1){
    	 
    	 
    	  String toUser = approverOrderList.get(1);
    	  expenseApplayTrain.setApproverNow(toUser);
//    	  expenseApplayTrain.setEndAddress("非洲");
    	  if(approverHistory == null || "".equals(approverHistory))
    	  {
    		  expenseApplayTrain.setApproverHistory(approverNow);
    	  }else{
    		  expenseApplayTrain.setApproverHistory(approverHistory+"|"+approverNow);
    	  }
    	 /* DDSendMessageUtil.sendMessageTrain(expenseApplayTrain, expenseApplayTrain.getId(),toUser );*/
    	  System.out.println("发送消息给二级管理员");
    	 
      }
      return expenseApplayTrain;
   }
   @Override
	public ExpenseApplayTrain refuseOption(ExpenseApplayTrain expenseApplayTrain){
	 //审批历史记录
	  String approverHistory = expenseApplayTrain.getApproverHistory();
	//获取当前审批人信息
	  String approverNow = expenseApplayTrain.getApproverNow();
	  if(approverHistory== null || "".equals(approverHistory)){//只有一个审核人的情况
		  expenseApplayTrain.setApproverHistory(approverNow);
  	  }else{//报销对应多个审核人，但是当前操作为最后一个审核人的操作
  		expenseApplayTrain.setApproverHistory(approverHistory+"|"+approverNow);
  	  }
	  expenseApplayTrain.setApplayStatus("驳回");
	  expenseApplayTrain.setApproverNow("");
  	  return expenseApplayTrain;
	}
   		@Override
   		
	   public List<ExpenseApplayTrain> selectApproved(String staffUserId){
	   
	    return expenseApplayTrainMapper.selectApproved(staffUserId);
	    }
   		
   		@SuppressWarnings("unchecked")
		@Override
	    public List<ExpenseApplayTrain> selectApproval(String staffUserId,String staffId){
	   		ToolsForselectApproval tools = new ToolsForselectApproval();
	   		tools.setStaffId(staffId);
	   		tools.setStaffUserId(staffUserId);
	    	return expenseApplayTrainMapper.selectApproval(tools);
	    }
   		@Override
   		public ExpenseApplayTrain constructApprovers(ExpenseApplayTrain expenseApplayTrain){
   		 String approverOrders="";
  	   String approverNow=null;
  	   try{
     			String []approverOrderArray=expenseApplayTrain.getApproverOrder().split("\\|");
     			
     				for(String approverOrder : approverOrderArray){
     					approverOrders +=staffInfoService.selectStaffByID(approverOrder).getName()+",";	
     				}
     			
     		}catch(Exception e ){
     			approverOrders="error,请联系管理员";
     		
     		}
  	   try{
  		   String approverNow01=expenseApplayTrain.getApproverNow();
  		   if(approverNow01 !=null && !"".equals(approverNow01)){
  			   approverNow = staffInfoService.selectStaffByID(approverNow01).getName();
  		   }else{
  			 approverNow=""; 
  		   }
  	   }catch(Exception e){
  		   approverNow="error,请联系管理员";
  	   }
  	   	expenseApplayTrain.setApproverOrder(approverOrders);
  	  	expenseApplayTrain.setApproverNow(approverNow);
    	return expenseApplayTrain;
   		}
   		@Override
   		public int UpdateByPrimaryKey(ExpenseApplayTrain expenseApplayTrain){
   			return expenseApplayTrainMapper.updateByPrimaryKey(expenseApplayTrain);
   		}
   		@Override
   		public String delete(int id){
   			try{
   				expenseApplayTrainMapper.deleteByPrimaryKey(id);
   			   return "success";
   		   }catch(Exception e){
   			   e.printStackTrace();
   			   return "fail";
   		   }
   		}
   		@Override
   	    public List<ExpenseApplayTrain> selectApprovalStaff(String staffUserId){
   	    	return expenseApplayTrainMapper.selectApprovalStaff(staffUserId);
   	    }
   		@Override
   	    public int selectApprovalCount(String staffUserId){
   	 	   return expenseApplayTrainMapper.selectApprovalCount(staffUserId);
   	 	   }
   		@Override
   		//查询出上周管理员未审核的报销并进行驳回
   	    public void updateDelayApproval(String staffUserId){
   			expenseApplayTrainMapper.updateDelayApproval(staffUserId);
   		}
   	    /**
   	     * 根据出差审批的ID更新该条出差申请的状态为已提交
   	     * @param btId
   	     */
   		@Override
   	    public void updateBtData(int btId){
   	    	BusinessTrip record = new BusinessTrip();
   	    	record.setBtSequenceNo(btId);
   	    	record.setBtStatus("已提交");
   	    	businessTripMapper.updateByPrimaryKeySelective(record);
   	    }
}
