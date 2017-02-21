package com.model;

public class ExpenseApplayTrain {
    private Integer id;

    private String staffName;

    private String staffId;

    private String staffDepart;

    private String startTime;

    private String endTime;

    private String trainNum;

    private String startAddress;

    private String endAddress;

    private Double moneyCost;

    private String detailExplain;

    private String staffUserId;

    private Integer tripId;

    private String applayStatus;

    private String reason;

    private String imageUrl;

    private String approverOrder;

    private String approverHistory;

    private String approverNow;

    private String refuseReason;

    private String submitTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffDepart() {
        return staffDepart;
    }

    public void setStaffDepart(String staffDepart) {
        this.staffDepart = staffDepart;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTrainNum() {
        return trainNum;
    }

    public void setTrainNum(String trainNum) {
        this.trainNum = trainNum;
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

    public Double getMoneyCost() {
        return moneyCost;
    }

    public void setMoneyCost(Double moneyCost) {
        this.moneyCost = moneyCost;
    }

    public String getDetailExplain() {
        return detailExplain;
    }

    public void setDetailExplain(String detailExplain) {
        this.detailExplain = detailExplain;
    }

    public String getStaffUserId() {
        return staffUserId;
    }

    public void setStaffUserId(String staffUserId) {
        this.staffUserId = staffUserId;
    }

    public Integer getTripId() {
        return tripId;
    }

    public void setTripId(Integer tripId) {
        this.tripId = tripId;
    }

    public String getApplayStatus() {
        return applayStatus;
    }

    public void setApplayStatus(String applayStatus) {
        this.applayStatus = applayStatus;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public String getRefuseReason() {
        return refuseReason;
    }

    public void setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason;
    }

    public String getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(String submitTime) {
        this.submitTime = submitTime;
    }

	@Override
	public String toString() {
		return "ExpenseApplayTrain [id=" + id + ", staffName=" + staffName
				+ ", staffId=" + staffId + ", staffDepart=" + staffDepart
				+ ", startTime=" + startTime + ", endTime=" + endTime
				+ ", trainNum=" + trainNum + ", startAddress=" + startAddress
				+ ", endAddress=" + endAddress + ", moneyCost=" + moneyCost
				+ ", detailExplain=" + detailExplain + ", staffUserId="
				+ staffUserId + ", tripId=" + tripId + ", applayStatus="
				+ applayStatus + ", reason=" + reason + ", imageUrl="
				+ imageUrl + ", approverOrder=" + approverOrder
				+ ", approverHistory=" + approverHistory + ", approverNow="
				+ approverNow + ", refuseReason=" + refuseReason
				+ ", submitTime=" + submitTime + "]";
	}
    
}