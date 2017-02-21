package com.model;
/**
 * 钉钉报销数据汇总辅助类
 * @author mawei
 *
 */
public class ApprovalStaff {
	
	private String staffId;
	private String staffName;
	private String sumTime;
	private String cost;
	
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getSumTime() {
		return sumTime;
	}
	public void setSumTime(String sumTime) {
		this.sumTime = sumTime;
	}
	public ApprovalStaff(String staffId, String staffName, String sumTime,String cost) {
		super();
		this.staffId = staffId;
		this.staffName = staffName;
		this.sumTime = sumTime;
		this.cost = cost;
	}
	public ApprovalStaff(ApprovalStaff approvalStaff){
		this.staffId=approvalStaff.getStaffId();
		this.staffName=approvalStaff.getStaffName();
		this.sumTime=approvalStaff.getSumTime();
		this.cost=approvalStaff.getCost();
		
	}
	public ApprovalStaff() {
		
	}
	@Override
	public String toString() {
		return "ApprovalStaff [staffId=" + staffId + ", staffName=" + staffName
				+ ", sumTime=" + sumTime + ", cost=" + cost + "]";
	}
	
	
}
