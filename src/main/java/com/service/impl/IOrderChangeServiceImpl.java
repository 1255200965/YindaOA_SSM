package com.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.YoOrderChangeMapper;
import com.model.ExpenseApplayBus;
import com.model.ExpenseApplayBusExample;
import com.model.YoItemChangeExample;
import com.model.YoOrderChange;
import com.model.YoOrderChangeExample;
import com.service.IOrderChangeService;
import com.util.DDSendMessageUtil;
import com.util.OrderMessageUtil;


@Service
public class IOrderChangeServiceImpl  implements
IOrderChangeService{



	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	private YoOrderChangeMapper orderChangeMapper;
	@Autowired
	private OrderMessageUtil orderMessageUtil;

	/**
	 * 项目变更提交给下级管理员，修改项目变更审批流和当前审批人，并且推送消息
	 */
	@Override
	public YoOrderChange sendTONextManager(YoOrderChange orderChange){
		//获取待审批人列表
		String approverOrder=orderChange.getAssess();
		List<String> approverOrderList01 = Arrays.asList(approverOrder.split("\\|"));
		List<String> approverOrderList = new ArrayList<String>(approverOrderList01);
		//获取当前审批人信息
		String approverNow = orderChange.getNowAcess();
		//获取历史审批人信息
		String approverHistory = orderChange.getHistoryAccess();

		if(approverHistory == null){
			approverHistory="";
		}
		List<String> approverHistoryList01= Arrays.asList(approverHistory.split("\\|"));
		List<String> approverHistoryList = new ArrayList<String>(approverHistoryList01);
		//待审批人列表信息
		approverOrderList.removeAll(approverHistoryList);
		//如果是最后一个审批人
		if(approverOrderList.size()==1 || approverOrderList.size()==0){
			orderChange.setOrderResult("审核结束");
			if(approverHistory== null || "".equals(approverHistory) ){//只有一个审核人的情况
				orderChange.setHistoryAccess(approverNow);
			}else{//报销对应多个审核人，但是当前操作为最后一个审核人的操作
				orderChange.setHistoryAccess(approverHistory+"|"+approverNow);
			}
			orderChange.setNowAcess("");

		}else if(approverOrderList.size()>1){
			String toUser = approverOrderList.get(1);
			orderChange.setNowAcess(toUser);
			orderChange.setModifyTime(sdf.format(new Date()));

			if(approverHistory == null || "".equals(approverHistory))
			{
				orderChange.setHistoryAccess(approverNow);
			}else{
				orderChange.setHistoryAccess(approverHistory+"|"+approverNow);
			}
			orderMessageUtil.sendMessage(orderChange);//(orderChange, orderChange.getId(),toUser );
			System.out.println("发送消息给二级管理员");

		}
		return orderChange;
	}
    
	/**
	 * 项目变更提交给下级管理员，修改项目变更审批流和当前审批人，但是不推送消息
	 * @param orderChange
	 * @return
	 */
	public YoOrderChange nextManager(YoOrderChange orderChange){
		//获取待审批人列表
		String approverOrder=orderChange.getAssess();
		List<String> approverOrderList01 = Arrays.asList(approverOrder.split("\\|"));
		List<String> approverOrderList = new ArrayList<String>(approverOrderList01);
		//获取当前审批人信息
		String approverNow = orderChange.getNowAcess();
		//获取历史审批人信息
		String approverHistory = orderChange.getHistoryAccess();

		if(approverHistory == null){
			approverHistory="";
		}
		List<String> approverHistoryList01= Arrays.asList(approverHistory.split("\\|"));
		List<String> approverHistoryList = new ArrayList<String>(approverHistoryList01);
		//待审批人列表信息
		approverOrderList.removeAll(approverHistoryList);
		//如果是最后一个审批人
		if(approverOrderList.size()==1 || approverOrderList.size()==0){
			orderChange.setOrderResult("审核结束");
			if(approverHistory== null || "".equals(approverHistory) ){//只有一个审核人的情况
				orderChange.setHistoryAccess(approverNow);
			}else{//报销对应多个审核人，但是当前操作为最后一个审核人的操作
				orderChange.setHistoryAccess(approverHistory+"|"+approverNow);
			}
			orderChange.setNowAcess("");

		}else if(approverOrderList.size()>1){
			String toUser = approverOrderList.get(1);
			orderChange.setNowAcess(toUser);
			orderChange.setModifyTime(sdf.format(new Date()));

			if(approverHistory == null || "".equals(approverHistory))
			{
				orderChange.setHistoryAccess(approverNow);
			}else{
				orderChange.setHistoryAccess(approverHistory+"|"+approverNow);
			}
		

		}
		return orderChange;
	}
	@Override
	public List<YoOrderChange> get_approve_history(String user_staff_id) {
		// TODO Auto-generated method stub
		YoOrderChangeExample orderChangeExample = new YoOrderChangeExample();
		YoOrderChangeExample.Criteria criteria = orderChangeExample.createCriteria();
		if(user_staff_id != null)
			{
			criteria.andHistoryAccessLike("%"+user_staff_id+"%");
			}else{
				return null;
			}
		//criteria.andNowAcessEqualTo("");
		List<YoOrderChange> expenseBusList=orderChangeMapper.selectByExample(orderChangeExample);  
		return expenseBusList;
	}

	@Override
	public List<YoOrderChange> get_approve_un(String user_staff_id,String orderName) {
		// TODO Auto-generated method stub
		
				YoOrderChangeExample orderChangeExample = new YoOrderChangeExample();
				YoOrderChangeExample.Criteria criteria = orderChangeExample.createCriteria();
				if(user_staff_id != null) 
					{
					criteria.andNowAcessEqualTo(user_staff_id);
					}else{
						return null;
					}
				
                 if(orderName!=null){
                	 criteria.andOrderNameLike("%"+orderName+"%");
				 }
				List<YoOrderChange> expenseBusList=orderChangeMapper.selectByExample(orderChangeExample);  
				return expenseBusList;
	}

	@Override
	public List<YoOrderChange> get_Apply(String user_staff_id) {
		// TODO Auto-generated method stub
		
				YoOrderChangeExample orderChangeExample = new YoOrderChangeExample();
				YoOrderChangeExample.Criteria criteria = orderChangeExample.createCriteria();
				if(user_staff_id != null) 
				{
				criteria.andStaffUserIdEqualTo(user_staff_id);
				}else{
					
					return null;
				}
				List<YoOrderChange> expenseBusList=orderChangeMapper.selectByExample(orderChangeExample);  
				return expenseBusList;
	}
	
	@Override
	public List<YoOrderChange> selectForExport(YoOrderChange orderChange){
		YoOrderChangeExample example = new YoOrderChangeExample();
		YoOrderChangeExample.Criteria criteria = example.createCriteria();
		criteria.andIdBetween(1, 2000000);
		return orderChangeMapper.selectByExample(example);
	}


	
}

