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
	private String messageUrl;
	private String picUrl;
	private String title;
	private String text;
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
	
	
}
