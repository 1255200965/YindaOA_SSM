package com.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ExpenseApplySubwayMapper;
import com.model.ExpenseApplayHotel;
import com.model.ExpenseApplayTrain;
import com.model.ExpenseApplySubway;
import com.model.ExpenseApplySubwayExample;
import com.model.ToolsForselectApproval;
import com.service.IExpenseApplySubwayService;
import com.service.IStaffInfoService;
import com.util.DDSendMessageUtil;
@Service
public class ExpenseApplySubwayServiceImpl implements IExpenseApplySubwayService{
	@Autowired
	private ExpenseApplySubwayMapper subwayMapper;
	@Autowired
    private IStaffInfoService staffInfoService;
	@Override
	public int saveOrUpdate(ExpenseApplySubway expenseSubway){
		if(expenseSubway.getId() == null || "".equals(expenseSubway.getId())){//id为空进行插入
			subwayMapper.insert(expenseSubway);
//			expenseSubway.getId();
			return -1;//返回主键ID
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
//	    	  DDSendMessageUtil.sendMessageSubway(expenseApplySubway, expenseApplySubway.getId(),toUser );
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
	  @Override
	  //根据用户钉钉Id查询其当前30天内的审批记录
	    public List<ExpenseApplySubway> selectApproved(String staffUserId){
		  
		  return subwayMapper.selectApproved(staffUserId);
	    }
	  @Override
	  public  List<ExpenseApplySubway> selectByStaffId(String staffId){
		  ExpenseApplySubwayExample example = new ExpenseApplySubwayExample();
		  ExpenseApplySubwayExample.Criteria criteria = example.createCriteria();
		  criteria.andAskStaffIdEqualTo(staffId);
		  return subwayMapper.selectByExample(example);
	  }
	  @Override
	    //根据用户钉钉Id查询其
	    public List<ExpenseApplySubway> selectApproval(String staffUserId,String staffId){
		  	ToolsForselectApproval tools = new ToolsForselectApproval();
	  		tools.setStaffId(staffId);
	  		tools.setStaffUserId(staffUserId);
		  return subwayMapper.selectApproval(tools);
	    }
	  @Override
	  public ExpenseApplySubway constructApprovers(ExpenseApplySubway expenseApplySubway){
		  String approverOrders="";
	  	   String approverNow=null;
	  	   try{
	     			String []approverOrderArray=expenseApplySubway.getApproverOrder().split("\\|");
	     			
	     				for(String approverOrder : approverOrderArray){
	     					approverOrders +=staffInfoService.selectStaffByID(approverOrder).getName()+",";	
	     				}
	     			
	     		}catch(Exception e ){
	     			approverOrders="error,请联系管理员";
	     		
	     		}
	  	   try{
	  		   String approverNow01=expenseApplySubway.getApproverNow();
	  		   if(approverNow01 !=null && !"".equals(approverNow01)){
	  			   approverNow = staffInfoService.selectStaffByID(approverNow01).getName();
	  		   }else{
	  			 approverNow=""; 
	  		   }
	  	   }catch(Exception e){
	  		   approverNow="error,请联系管理员";
	  	   }
	  	 expenseApplySubway.setApproverOrder(approverOrders);
	  	expenseApplySubway.setApproverNow(approverNow);
	    		return expenseApplySubway;
	  }
	  @Override
	  public int UpdateByPrimaryKey(ExpenseApplySubway expenseApplySubway){
	    	return subwayMapper.updateByPrimaryKey(expenseApplySubway);
	  }
	  @Override
	  public String delete(int id){
		  try{
			  subwayMapper.deleteByPrimaryKey(id);
	 		   return "success";
	 	   }catch(Exception e){
	 		   e.printStackTrace();
	 		   return "fail";
	 	   }
	   }
	  @Override
 	    public List<ExpenseApplySubway> selectApprovalStaff(String staffUserId){
 	    	return subwayMapper.selectApprovalStaff(staffUserId);
 	    }
	  @Override
 	    public int selectApprovalCount(String staffUserId){
 	 	   return subwayMapper.selectApprovalCount(staffUserId);
 	 	   }
	  @Override
	//查询出上周管理员未审核的报销并进行驳回
	    public void updateDelayApproval(String staffUserId){
		  subwayMapper.updateDelayApproval(staffUserId);
	  }
}

