package com.model;

/**
 * 考勤相关信息导出页面所用参数封装
 * @author mawei
 *
 */
public class YoAtteninfoExcelExport {
	 private String name;
	 private String staffId;
	 private String department;
	 //项目
	 private String projectName;
	 //订单名称
	 private String orderName;
	 //合同类型
	 private String contractType;
	 private String attendTime;
	 private String attendResult;
	 private String remark;
	 private String deviceid;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	
	public String getAttendResult() {
		return attendResult;
	}
	public void setAttendResult(String attendResult) {
		this.attendResult = attendResult;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getDeviceid() {
		return deviceid;
	}
	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}
	
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public String getContractType() {
		return contractType;
	}
	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
	public String getAttendTime() {
		return attendTime;
	}
	public void setAttendTime(String attendTime) {
		this.attendTime = attendTime;
	}
	@Override
	public String toString() {
		return "YoAtteninfoExcelExport [name=" + name + ", department="
				+ department + ", staffId=" + staffId + ", attendTime="
				+ attendTime + ", attendResult=" + attendResult + ", remark="
				+ remark + ", deviceid=" + deviceid + ", projectName=" + projectName
				+ ", orderName=" + orderName + ", contractType=" + contractType
				+ "]";
	}
	
}
