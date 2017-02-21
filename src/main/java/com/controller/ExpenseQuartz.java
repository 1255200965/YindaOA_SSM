package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.IBusinessTripService;
import com.service.IExpenseApplayBusService;
import com.service.IExpenseApplayHotelService;
import com.service.IExpenseApplayTaxiService;
import com.service.IExpenseApplayTrainService;
import com.service.IExpenseApplySubwayService;
import com.service.IStaffInfoService;
import com.util.DDMessageUtil;
import com.util.DDSendMessageUtil;
/**
 * 周报销待审批消息推送定时任务
 * @author mawei
 *
 */
@Component
public class ExpenseQuartz {
	@Autowired
	private IExpenseApplayBusService expenseBusService;
	@Autowired
	private DDSendMessageUtil ddSendMessageUtil;
	@Autowired
	private IExpenseApplayTrainService expenseApplayTrainService;
	@Autowired
	private IStaffInfoService staffInfoService;
	@Autowired
	private IExpenseApplayHotelService expenseApplayHotelService;
	@Autowired
	private IExpenseApplySubwayService expenseApplySubwayService;
	/**
	 * 钉钉报销待审批推送定时任务--周一下午17:30启动推送
	 */
    @Scheduled(cron = "0 30 17 ? * MON")
	public void sendWeekExpenseCount(){
    	System.out.println("钉钉待审批报销定推送定时任务启动---");
    	List<String> staffUserIdList = getLeaders();
		DDMessageUtil ddMessage=new DDMessageUtil();
		for(String staffUserId : staffUserIdList){
		   try{
			ddMessage = getWeekCountDetail(ddMessage,staffUserId);
			DDSendMessageUtil.sendMessage(ddMessage, "weekCount");
			//该功能出异常,推送消息给马天力
		   }catch(Exception e){
			   	  e.printStackTrace();
				  DDMessageUtil ddMessage2=new DDMessageUtil();
				  ddMessage.setToUser("031618475738729262");
				  ddMessage.setTitle("钉钉报销异常通知");
				  ddMessage.setNotice("系统推送"+staffUserId+"的钉钉未审批报销数据时出错");
				  DDSendMessageUtil.sendMessage(ddMessage2, "exception");
		   }
		}
		System.out.println("钉钉待审批报销定推送定时任务结束");
	}
    /**
	 * 钉钉报销待审批推送定时任务--周日下午17:30启动推送
	 */
    @Scheduled(cron = "0 30 17 ? * SUN")
    public void sendWeekExpenseCount2(){
    	System.out.println("钉钉待审批报销定推送定时任务启动---");
    	List<String> staffUserIdList = getLeaders();
		DDMessageUtil ddMessage=new DDMessageUtil();
		for(String staffUserId : staffUserIdList){
		   try{
			ddMessage = getWeekCountDetail(ddMessage,staffUserId);
			DDSendMessageUtil.sendMessage(ddMessage, "weekCount");
			//该功能出异常,推送消息给马天力
		   }catch(Exception e){
			   	  e.printStackTrace();
				  DDMessageUtil ddMessage2=new DDMessageUtil();
				  ddMessage.setToUser("031618475738729262");
				  ddMessage.setTitle("钉钉报销异常通知");
				  ddMessage.setNotice("系统推送"+staffUserId+"的钉钉未审批报销数据时出错");
				  DDSendMessageUtil.sendMessage(ddMessage2, "exception");
		   }
		}
		System.out.println("钉钉待审批报销定推送定时任务结束");
	}
    /**
	 * 延迟未审批的数据做系统自动驳回处理--周末11:10
	 */
    @Scheduled(cron = "0 10 23 ? * SUN")
	public void refuseApprovalDelay(){
    	List<String> staffUserIdList = getLeaders();
    	refuseDelayApprove(staffUserIdList);
	}
    /**
     * 获取各级部门经理项目经理的钉钉ID
     * @return
     */
    private List<String> getLeaders(){
    	List<String> leaders=staffInfoService.selectLeaders();
    	return leaders;
    }
    /**
     * 钉钉报销待审批推送消息文本组织
     * @param ddMessage
     * @param staffUserId
     * @return
     */
	private DDMessageUtil getWeekCountDetail(DDMessageUtil ddMessage,String staffUserId){
		ddMessage.setTrainCount(expenseApplayTrainService.selectApprovalCount(staffUserId));
		ddMessage.setBusCount(expenseBusService.selectApprovalCount(staffUserId));
		ddMessage.setHotelCount(expenseApplayHotelService.selectApprovalCount(staffUserId));
		ddMessage.setSubwayCount(expenseApplySubwayService.selectApprovalCount(staffUserId));
		ddMessage.setToUser(staffUserId);
		ddMessage.setTitle("钉钉报销待审批通知");
		return ddMessage;
	}
	/**
	 * 系统自动驳回延迟未审批的报销数据
	 */
	private void refuseDelayApprove(List<String> staffUserIdList){
	  
		for(String staffUserId : staffUserIdList){
		  try{
			expenseBusService.updateDelayApproval(staffUserId);
			expenseApplayTrainService.updateDelayApproval(staffUserId);
			expenseApplayHotelService.updateDelayApproval(staffUserId);
			expenseApplySubwayService.updateDelayApproval(staffUserId);
			//该功能出异常时给马天立推送出错消息
		  }catch(Exception e){
			  e.printStackTrace();
			  DDMessageUtil ddMessage=new DDMessageUtil();
			  ddMessage.setToUser("031618475738729262");
			  ddMessage.setTitle("钉钉报销异常通知");
			  ddMessage.setNotice("系统自动驳回钉钉ID为"+staffUserId+"的钉钉报销审批人未及时审批的数据时出错");
			  DDSendMessageUtil.sendMessage(ddMessage, "exception");
		  }
		}
	}
}
