package com.model;

public class ExpenseApplySubway {
    private Integer id;

    private String askStaffName;

    private String askStaffUserId;

    private String askStaffId;

    private String askStaffDepart;

    private String askMonth;

    private String askMoney;

    private String approverOrder;

    private String approverHistory;

    private String approverNow;

    private String approveStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAskStaffName() {
        return askStaffName;
    }

    public void setAskStaffName(String askStaffName) {
        this.askStaffName = askStaffName;
    }

    public String getAskStaffUserId() {
        return askStaffUserId;
    }

    public void setAskStaffUserId(String askStaffUserId) {
        this.askStaffUserId = askStaffUserId;
    }

    public String getAskStaffId() {
        return askStaffId;
    }

    public void setAskStaffId(String askStaffId) {
        this.askStaffId = askStaffId;
    }

    public String getAskStaffDepart() {
        return askStaffDepart;
    }

    public void setAskStaffDepart(String askStaffDepart) {
        this.askStaffDepart = askStaffDepart;
    }

    public String getAskMonth() {
        return askMonth;
    }

    public void setAskMonth(String askMonth) {
        this.askMonth = askMonth;
    }

    public String getAskMoney() {
        return askMoney;
    }

    public void setAskMoney(String askMoney) {
        this.askMoney = askMoney;
    }

    public String getApproverOrder() {
        return approverOrder;
    }

    public void setApproverOrder(String approverOrder) {
        this.approverOrder = approverOrder;
    }

    public String getApproverHistory() {
        return approverHistory;
    }

    public void setApproverHistory(String approverHistory) {
        this.approverHistory = approverHistory;
    }

    public String getApproverNow() {
        return approverNow;
    }

    public void setApproverNow(String approverNow) {
        this.approverNow = approverNow;
    }

    public String getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(String approveStatus) {
        this.approveStatus = approveStatus;
    }

	@Override
	public String toString() {
		return "ExpenseApplySubway [id=" + id + ", askStaffName="
				+ askStaffName + ", askStaffUserId=" + askStaffUserId
				+ ", askStaffId=" + askStaffId + ", askStaffDepart="
				+ askStaffDepart + ", askMonth=" + askMonth + ", askMoney="
				+ askMoney + ", approverOrder=" + approverOrder
				+ ", approverHistory=" + approverHistory + ", approverNow="
				+ approverNow + ", approveStatus=" + approveStatus + "]";
	}
    
}