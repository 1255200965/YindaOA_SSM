package com.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.sf.json.JSONObject;

import com.ddSdk.base.OApiException;
import com.model.DepartmentExample;
import com.service.IDepartmentService;
import com.service.IStaffInfoService;
import com.service.impl.StaffInfoServiceImpl;

import bsh.ParseException;
@Component("ddSendMessageUtil")
public class DDSendMessageUtil {
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
	 * 获取access_token
	 * @return
	 */
    private static String getAccess_token(){
		String access_token=null;
    	try {
    		//根据corpid跟corpsecrect获取accesstoken
			String ddResponse=HttpsUtil.httpGet(DDSendMessageUtil.baseUrl01+"corpid="+DDSendMessageUtil.corp_id+"&corpsecret="+DDSendMessageUtil.corp_secrect);
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
    public static void sendMessage(DDMessageUtil message){
    	String contentJson="{"
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
    	System.out.println("contentJson====="+contentJson);
    	try {
			String access_token = DDSendMessageUtil.getAccess_token();
			JSONObject json=HttpsUtil.httpPost(DDSendMessageUtil.baseUrl02+access_token,contentJson);
			System.out.println("发送成功"+json);
		} catch (OApiException e) {
			e.printStackTrace();
		}
    	
    }
    /**
     * 根据当前用户的钉钉ID生成当前审批请求的审批人
     * @param staffUserId 当前用户钉钉ID
     * @return  [二级部门审批人钉钉ID,一级部门审批人钉钉ID]
     */
    public  List<String> getApprovers(String staffUserId){
    	List<String> approverList=new ArrayList<String>();//需要的审批人信息记录
    	List<String> departmentList=new ArrayList<String>();//当前用户所在的各级部门列表
    	List<String> depDDIdList=new ArrayList<String>();;//当前用户所在部门的各级部门钉钉ID列表
    	//根据staffuserid获取用户的部门结构List
    	departmentList = Arrays.asList(staffInfoService.selectStaffByID(staffUserId).getDepartment().split("\\-"));
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
    	//根据获得的部门ID查询对应的审批人的滴滴ID
    	for(String depDDId : depDDIdList){
    		try {
    			String managerDDId=DDSendMessageUtil.getManagerDDId(depDDId);
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
    	String access_token = DDSendMessageUtil.getAccess_token();
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
    public static void main(String []args) throws ClientProtocolException{
    	/*DDMessageUtil ddMessage = new DDMessageUtil();
    	ddMessage.setMessageUrl("http://www.baidu.com");
    	ddMessage.setText("马卫的报销记录");
    	ddMessage.setTitle("报销");
    	ddMessage.setPicUrl("123");
    	ddMessage.setToParty("");
    	ddMessage.setToUser("07022352451246847");
    	DDSendMessageUtil.sendMessage(ddMessage);*/
    	
    	//商务部----Manager:10389 employer:15249
    	//核心网实业部---manager:10305
     	DDSendMessageUtil ddSendMessage = new DDSendMessageUtil();
    	String strList = null;
		try {
			strList = ddSendMessage.getManagerDDId("4195154");
			 System.out.println("管理员DDID==="+strList);	
		} catch (ParseException | IOException
				| URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        		
    	
    }
}
