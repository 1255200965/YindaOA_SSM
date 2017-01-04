package com.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ExpenseApplayHotelMapper;
import com.model.ExpenseApplayHotel;
import com.model.ExpenseApplayHotelExample;
import com.model.ExpenseApplySubway;
import com.service.IExpenseApplayHotelService;
import com.util.DDSendMessageUtil;
@Service
public class ExpenseApplayHotelServiceImpl implements IExpenseApplayHotelService{
    @Autowired
    private ExpenseApplayHotelMapper expenseApplayHotelMapper;
    @Override
    public List<ExpenseApplayHotel> selectByStaffId(String staffId){
    	ExpenseApplayHotelExample example = new ExpenseApplayHotelExample();
    	ExpenseApplayHotelExample.Criteria criteria = example.createCriteria();
    	criteria.andStaffIdEqualTo(staffId);
    	List<ExpenseApplayHotel> expenseApplayHotelList=expenseApplayHotelMapper.selectByExample(example);
    	return expenseApplayHotelList;
    }
    @Override
    public ExpenseApplayHotel selectById(int id){
    	return expenseApplayHotelMapper.selectByPrimaryKey(id);
    }
    @Override
    public int saveOrUpdate(ExpenseApplayHotel expenseApplayHotel){
    	Integer id = expenseApplayHotel.getId();
    	if(id == null || id == 0){//新增
    		expenseApplayHotelMapper.insert(expenseApplayHotel);
    		id = expenseApplayHotel.getId();
    		return id;
    	}else{//更新
    		return expenseApplayHotelMapper.updateByPrimaryKeySelective(expenseApplayHotel);
    	}
    }
    @Override
    public ExpenseApplayHotel sendTONextManager(ExpenseApplayHotel expenseApplayHotel){
    	//获取待审批人列表
 	   String approverOrder=expenseApplayHotel.getApproverOrder();
 	   List<String> approverOrderList01 = Arrays.asList(approverOrder.split("\\|"));
 	   List<String> approverOrderList = new ArrayList<String>(approverOrderList01);
 	   //获取当前审批人信息
 	   String approverNow = expenseApplayHotel.getApproverNow();
 	   //获取历史审批人信息
 	   String approverHistory = expenseApplayHotel.getApproverHistory();
 	   
 	   if(approverHistory == null){
 		   approverHistory="";
 	   }
 	   List<String> approverHistoryList01= Arrays.asList(approverHistory.split("\\|"));
 	   List<String> approverHistoryList = new ArrayList<String>(approverHistoryList01);
 	   //待审批人列表信息
 	   approverOrderList.removeAll(approverHistoryList);
 	   //如果是最后一个审批人
      if(approverOrderList.size()==1 || approverOrderList.size()==0){
    	  expenseApplayHotel.setApplayStatus("审核通过");
    	  if(approverHistory== null || "".equals(approverHistory) ){//只有一个审核人的情况
    		  expenseApplayHotel.setApproverHistory(approverNow);
    	  }else{//报销对应多个审核人，但是当前操作为最后一个审核人的操作
    		  expenseApplayHotel.setApproverHistory(approverHistory+"|"+approverNow);
    	  }
    	  expenseApplayHotel.setApproverNow("");
       
      }else if(approverOrderList.size()>1){
    	 
    	 
    	  String toUser = approverOrderList.get(1);
    	  expenseApplayHotel.setApproverNow(toUser);
//    	  expenseApplayHotel.setStaffName("测试");
    	  if(approverHistory == null || "".equals(approverHistory))
    	  {
    		  expenseApplayHotel.setApproverHistory(approverNow);
    	  }else{
    		  expenseApplayHotel.setApproverHistory(approverHistory+"|"+approverNow);
    	  }
    	  DDSendMessageUtil.sendMessageHotel(expenseApplayHotel, expenseApplayHotel.getId(),toUser );
    	  System.out.println("发送消息给二级管理员");
    	 
      }
      return expenseApplayHotel;
    }
    @Override
	public ExpenseApplayHotel refuseOption(ExpenseApplayHotel expenseApplayHotel){
	 //审批历史记录
	  String approverHistory = expenseApplayHotel.getApproverHistory();
	//获取当前审批人信息
	  String approverNow = expenseApplayHotel.getApproverNow();
	  if(approverHistory== null || "".equals(approverHistory)){//只有一个审核人的情况
		  expenseApplayHotel.setApproverHistory(approverNow);
   	  }else{//报销对应多个审核人，但是当前操作为最后一个审核人的操作
   		expenseApplayHotel.setApproverHistory(approverHistory+"|"+approverNow);
   	  }
	  expenseApplayHotel.setApplayStatus("驳回");
	  expenseApplayHotel.setApproverNow("");
   	  return expenseApplayHotel;
	}
    @Override
  //根据用户钉钉Id查询其当前30天内的审批记录
    public List<ExpenseApplayHotel> selectApproved(String userStaffId){
    	return expenseApplayHotelMapper.selectApproved(userStaffId);
    }
    @Override
    //根据用户钉钉Id查询其当前30天内的审批记录
      public List<ExpenseApplayHotel> selectApproval(String userStaffId){
      	return expenseApplayHotelMapper.selectApproval(userStaffId);
      }
}
