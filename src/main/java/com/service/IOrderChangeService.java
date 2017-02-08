package com.service;

import java.util.List;

import com.model.YoOrderChange;

public interface IOrderChangeService {
	
	/**
	 * 项目变更提交给下级管理员，修改项目变更审批流和当前审批人，并且推送消息
	 * @param orderChange
	 * @return
	 */
	 public YoOrderChange sendTONextManager(YoOrderChange orderChange);
	 
	 
	 /**
		 * 项目变更提交给下级管理员，修改项目变更审批流和当前审批人，但是不推送消息
		 * @param orderChange
		 * @return
		 */
	 public YoOrderChange nextManager(YoOrderChange orderChange);
	 /**
	  * 审批记录
	  * @param user_staff_id
	  * @return
	  */
	 List<YoOrderChange> get_approve_history(String user_staff_id);
	 
	 /**
	  * 待审批
	  * @param user_staff_id
	  * @return
	  */
	 List<YoOrderChange> get_approve_un(String user_staff_id,String orderName);
	 /**
	  * 申请记录
	  * @param user_staff_id
	  * @return
	  */
	 List<YoOrderChange> get_Apply(String user_staff_id);
	 
	 List<YoOrderChange> selectForExport(YoOrderChange orderChange);
	 

}
