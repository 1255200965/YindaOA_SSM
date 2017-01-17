package com.service;

import com.model.AskForLeave;
import com.model.AskForLeaveExample;
import com.model.YoAdvance;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by ma on 2016/10/15.
 */
public interface IAskLeaveService {
   //获取请假表的信息
   public List<AskForLeave> selectByExample();

   public List<AskForLeave> selectByExample(AskForLeaveExample example);
   
   //根据工号、姓名、时间区间、部门进行查询
   public List<AskForLeave> selectByPropertities(AskForLeave askForLeave);
   /**
	 * 请假
	 * @param excelHeader 表头
	 */
	public void askLeaveExport(List<AskForLeave> List,String []excelHeader,HttpServletResponse response);

}
