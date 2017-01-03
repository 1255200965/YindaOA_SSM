package com.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.sf.json.JSONObject;

import com.ddSdk.base.OApiException;
import com.model.DepartmentExample;
import com.model.ExpenseApplayBus;
import com.model.ExpenseApplayHotel;
import com.model.ExpenseApplayTrain;
import com.model.ExpenseApplySubway;
import com.service.IDepartmentService;
import com.service.IStaffInfoService;
import com.service.impl.StaffInfoServiceImpl;

import bsh.ParseException;
@Component("sendOrderMessageUtil")
public class SendOrderMessageUtil {
	@Autowired
	private  IStaffInfoService staffInfoService;
	@Autowired
	private  IDepartmentService departmentService;
	
	
	private static String corp_id= "ding246914ee44e47d4c";
	private static String corp_secrect= "Vnm79JLaXD1oiiZi-XV4LJlVW6KOYJmvWQfr3Z5mr-fZA8HSkMMhcoAySyRB5D_8";
	//请求access_token的URL
    private static String baseUrl01="https://oapi.dingtalk.com/gettoken?";
    //推送企业消息的URL
    private static String baseUrl02="https://oapi.dingtalk.com/message/send?access_token=";
	//获取部门详情
    private static String baseUrl03="https://oapi.dingtalk.com/department/get?access_token=";
    /**
     * 获取当前时间
     * @return
     */
    private static  String getCurrentTimeDate() {

        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        String time=format.format(date);
        return time;
    }
    /**
	 * 获取access_token
	 * @return
	 */
    private static String getAccess_token(){
		String access_token=null;
    	try {
    		//根据corpid跟corpsecrect获取accesstoken
			String ddResponse=HttpsUtil.httpGet(SendOrderMessageUtil.baseUrl01+"corpid="+SendOrderMessageUtil.corp_id+"&corpsecret="+SendOrderMessageUtil.corp_secrect);
			JSONObject jsonObject = JSONObject.fromObject(ddResponse);
			if(jsonObject != null){
				//获取access_token
				access_token=jsonObject.getString("access_token");
			}
		}catch (ParseException | IOException
				| URISyntaxException e) {
			e.printStackTrace();
		} 
    	return access_token;
    }
    /**
     * 组织推送报文
     * @return
     */
    public static String getText(String expenseApplyType,String staffName,String startAddress,String endAddress){
    	return staffName+"的"+expenseApplyType+"\n ;"+"从"+startAddress+"至"+endAddress;
    }
    /**
     * 推送消息
     * @param message
     */
    public static void sendMessage(DDMessageUtil message,String type){
    	//link消息类型
    	String contentJson1="{"
			    +"touser:"+"'"+message.getToUser()+"'"+","
			    +"toparty:"+"'"+message.getToParty()+"'"+","
			    +"agentid:"+"'"+message.getAgentId()+"'"+","
	    		+"msgtype:'link',"
			    +"link:{"
			    + "messageUrl:"+"'"+message.getMessageUrl()+"'"+","
			    + "picUrl:"+"'"+message.getPicUrl()+"'"+","
			    + "title:"+"'"+message.getTitle()+"'"+","
			    + "text:"+"'"+message.getText()+"'"
			    + "}"
	    		+ "}"; 
    	//OA消息类型
    	String contentJsonSubway = "{"
				+"touser:"+"'"+message.getToUser()+"'"+","
				+"toparty:"+"'"+message.getToParty()+"'"+","
				+"agentid:"+"'"+message.getAgentId()+"'"+","
				+"msgtype:" +"'oa',"
				+"oa: "+"{"
				+  "message_url:"+ "'"+message.getMessageUrl()+"',"
				+ "head:" +"{"
				+    "bgcolor:"+ "'FF0000FF',"
				+     "text: "+"'"+message.getText()+"'"
				+ "},"
				+  "body:{" 
				+      "title:" +"'"+message.getTitle()+"',"
				+     "form:" +"["
				+         " {"
				+            "key: "+"'姓名:',"
				+            "value:"+ "'"+message.getAskStaffName()+"'"
				+"},"			
				+         " {"
				+            "key: "+"'部门:',"
				+            "value:"+ "'"+message.getAskStaffDepartment()+"'"
				+      "},"  
				+         " {"
				+            "key: "+"'申请发送时间:',"
				+            "value:"+ "'"+message.getAskTime()+"'"
				+      "}" 
				+" ],"   	          
				+"}" 
				+"}" 
				+"}";
    	String contentJsonBus = "{"
				+"touser:"+"'"+message.getToUser()+"'"+","
				+"toparty:"+"'"+message.getToParty()+"'"+","
				+"agentid:"+"'"+message.getAgentId()+"'"+","
				+"msgtype:" +"'oa',"
				+"oa: "+"{"
				+  "message_url:"+ "'"+message.getMessageUrl()+"',"
				+ "head:" +"{"
				+    "bgcolor:"+ "'FF0000FF',"
				+     "text: "+"'"+message.getText()+"'"
				+ "},"
				+  "body:{" 
				+      "title:" +"'"+message.getTitle()+"',"
				+     "form:" +"["
				+         " {"
				+            "key: "+"'姓名:',"
				+            "value:"+ "'"+message.getAskStaffName()+"'"
				+"},"			
				+         " {"
				+            "key: "+"'部门:',"
				+            "value:"+ "'"+message.getAskStaffDepartment()+"'"
				+      "}," 
				+         " {"
				+            "key: "+"'起始地址:',"
				+            "value:"+ "'"+message.getStartAddress()+"'"
				+      "},"
				+         " {"
				+            "key: "+"'终点地址:',"
				+            "value:"+ "'"+message.getEndAddress()+"'"
				+      "},"
				+         " {"
				+            "key: "+"'乘车时间:',"
				+            "value:"+ "'"+message.getAskTime()+"'"
				+      "}" 
				+" ],"   	          
				+"}" 
				+"}" 
				+"}";
    	String contentJsonHotel = "{"
				+"touser:"+"'"+message.getToUser()+"'"+","
				+"toparty:"+"'"+message.getToParty()+"'"+","
				+"agentid:"+"'"+message.getAgentId()+"'"+","
				+"msgtype:" +"'oa',"
				+"oa: "+"{"
				+  "message_url:"+ "'"+message.getMessageUrl()+"',"
				+ "head:" +"{"
				+    "bgcolor:"+ "'FF0000FF',"
				+     "text: "+"'"+message.getText()+"'"
				+ "},"
				+  "body:{" 
				+      "title:" +"'"+message.getTitle()+"',"
				+     "form:" +"["
				+         " {"
				+            "key: "+"'姓名:',"
				+            "value:"+ "'"+message.getAskStaffName()+"'"
				+"},"			
				+         " {"
				+            "key: "+"'部门:',"
				+            "value:"+ "'"+message.getAskStaffDepartment()+"'"
				+      "}," 
				+         " {"
				+            "key: "+"'旅店名称:',"
				+            "value:"+ "'"+message.getHotelName()+"'"
				+      "},"
				+         " {"
				+            "key: "+"'住店时间:',"
				+            "value:"+ "'"+message.getAskTime()+"'"
				+      "},"
				+" ],"   	          
				+"}" 
				+"}" 
				+"}";
        String contentJson=null;
    	if("subway".equals(type)){
    		contentJson=contentJsonSubway;
    	}else if("bus".equals(type)){
    		contentJson = contentJsonBus;
    	}else if("hotel".equals(type)){
    		contentJson=contentJsonHotel;
    	}else{
    		contentJson=contentJson1;
    	}
    	System.out.println("contentJson====="+contentJson);
    	try {
			String access_token = SendOrderMessageUtil.getAccess_token();
			JSONObject json=HttpsUtil.httpPost(SendOrderMessageUtil.baseUrl02+access_token,contentJson);
			System.out.println("消息发送成功----->钉钉返回Json"+json);
		} catch (OApiException e) {
			e.printStackTrace();
		}  	
    }
    /**
     * 根据当前用户的钉钉ID生成当前审批请求的审批人
     * @param staffUserId 当前用户钉钉ID
     * @return  [二级部门审批人钉钉ID,一级部门审批人钉钉ID]
     * 对于挂职在二级部门下的员工【二级部门审批人钉钉ID】
     */
    public  List<String> getApprovers(String department,String project){//目标部门
    	
    	List<String> approverList=new ArrayList<String>();//需要的审批人信息记录
    	List<String> departmentList=new ArrayList<String>();//当前用户所在的各级部门列表
    	List<String> depDDIdList=new ArrayList<String>();;//当前用户所在部门的各级部门钉钉ID列表
    	//根据staffuserid获取用户的部门结构List 	
    	departmentList = Arrays.asList(Arrays.asList(("创新事业部-海南项目").split("\\,")).get(0).split("\\-"));
    	System.out.println("目标部门"+departmentList.toString());
    	//根据二级部门名称,获取二级部门ID
    	DepartmentExample example = new DepartmentExample();
    	DepartmentExample.Criteria criteria = example.createCriteria();
    	criteria.andDepNameEqualTo(departmentList.get(0));
    	depDDIdList.add(departmentService.selectByExample(example).get(0).getDepDdId());
    	//根据一级部门名称,以及一级部门对应父部门的钉钉ID，获得当前一级部门的钉钉ID
    	if(departmentList.size() > 1){//挂职不在二级部门下的员工
    	DepartmentExample example2 = new DepartmentExample();
    	DepartmentExample.Criteria criteria02 = example2.createCriteria();
    	criteria02.andDepParentidEqualTo(depDDIdList.get(0));
    	criteria02.andDepNameEqualTo(departmentList.get(1));
        depDDIdList.add(departmentService.selectByExample(example2).get(0).getDepDdId());
    	
    	}
    	System.out.println(depDDIdList);
    	//根据获得的部门ID查询对应的审批人的滴滴ID
    	for(String depDDId : depDDIdList){
    		try {
    			String managerDDId=SendOrderMessageUtil.getManagerDDId(depDDId);
    			System.out.println(managerDDId);
    			//如果一级部门的负责人不存在,则要求二级部门的负责人批阅两次
    			if(managerDDId==null || "".equals(managerDDId)){
    				approverList.add(approverList.get(0));
    			}else{
    				approverList.add(managerDDId);
    			}
			} catch (ParseException | IOException
					| URISyntaxException e) {
				e.printStackTrace();
			}
    	}
    	return approverList;
    }
    //根据当前部门的钉钉ID获取当前部门的管理员的钉钉ID
    private static String getManagerDDId(String depDDId) throws ClientProtocolException, ParseException, IOException, URISyntaxException{
    	String managerDDId=null;
    	//获取Access_token
    	String access_token = SendOrderMessageUtil.getAccess_token();
    	//请求的URL
    	String reqURL=baseUrl03+access_token+"&id="+depDDId;
    	//发起https get请求
    	String resp=HttpsUtil.httpGet(reqURL);
    	JSONObject jsonObject = JSONObject.fromObject(resp);
    	System.out.println(jsonObject.toString());
    	if(jsonObject != null){
    		//该部门主管ID可能包括多个这个时候只取第一个
    		managerDDId=Arrays.asList(jsonObject.getString("deptManagerUseridList").split("\\|")).get(0);
    	}
    	return managerDDId;
    }
   
}
