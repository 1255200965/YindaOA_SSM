package com.service;

import java.util.List;

import com.model.YoOrderChange;

public interface IOrderChangeService {
	 public YoOrderChange sendTONextManager(YoOrderChange orderChange);
	 
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
	 List<YoOrderChange> get_approve_un(String user_staff_id);
	 /**
	  * 申请记录
	  * @param user_staff_id
	  * @return
	  */
	 List<YoOrderChange> get_Apply(String user_staff_id);
	 
	 List<YoOrderChange> selectForExport(YoOrderChange orderChange);
	 
}
