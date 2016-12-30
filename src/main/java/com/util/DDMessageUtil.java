package com.util;
/**
 * 滴滴发送消息所需要属性的封装
 * @author mawei
 *
 */
public class DDMessageUtil {
	private String toUser;
	private String toParty;
	//默认为报销信息的推送
	private String AgentId="55840385";
	/*private String msgType;*/
	//点击消息后跳转的页面链接
	private String messageUrl;
	private String picUrl;
	//正文标题
	private String title;
	//头部标题
	private String text;
	//申请人
	private String askStaffName;
	//所在部门
	private String askStaffDepartment;
	//申请发送时间
	private String askTime;
	//起始地址
	private String startAddress;
	//终止地址
	private String endAddress;
	//旅馆名称
	private String hotelName;
	
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getAskStaffName() {
		return askStaffName;
	}
	public void setAskStaffName(String askStaffName) {
		this.askStaffName = askStaffName;
	}
	public String getAskStaffDepartment() {
		return askStaffDepartment;
	}
	public void setAskStaffDepartment(String askStaffDepartment) {
		this.askStaffDepartment = askStaffDepartment;
	}
	
	public String getAskTime() {
		return askTime;
	}
	public void setAskTime(String askTime) {
		this.askTime = askTime;
	}
	public void setAgentId(String agentId) {
		AgentId = agentId;
	}
	public String getToUser() {
		return toUser;
	}
	public void setToUser(String toUser) {
		this.toUser = toUser;
	}
	public String getToParty() {
		return toParty;
	}
	public void setToParty(String toParty) {
		this.toParty = toParty;
	}
	
	public String getAgentId() {
		return AgentId;
	}
	/*public void setAgentId(String agentId) {
		AgentId = agentId;
	}*/
	/*public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}*/
	public String getMessageUrl() {
		return messageUrl;
	}
	public void setMessageUrl(String messageUrl) {
		this.messageUrl = messageUrl;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getStartAddress() {
		return startAddress;
	}
	public void setStartAddress(String startAddress) {
		this.startAddress = startAddress;
	}
	public String getEndAddress() {
		return endAddress;
	}
	public void setEndAddress(String endAddress) {
		this.endAddress = endAddress;
	}
	
	
}
