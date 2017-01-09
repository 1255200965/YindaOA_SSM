package com.model;

public class LuckyStaff {
    private Integer id;

    private String staffName;

    private String staffId;

    private String drawType;

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

    public String getDrawType() {
        return drawType;
    }

    public void setDrawType(String drawType) {
        this.drawType = drawType;
    }

	@Override
	public String toString() {
		return "LuckyStaff [id=" + id + ", staffName=" + staffName
				+ ", staffId=" + staffId + ", drawType=" + drawType + "]";
	}
    
}