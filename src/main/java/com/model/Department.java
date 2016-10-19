package com.model;

public class Department {
    private Integer depId;

    private String depName;

    private String depDdId;

    private String depParentid;

    private String depState;

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getDepDdId() {
        return depDdId;
    }

    public void setDepDdId(String depDdId) {
        this.depDdId = depDdId;
    }

    public String getDepParentid() {
        return depParentid;
    }

    public void setDepParentid(String depParentid) {
        this.depParentid = depParentid;
    }

    public String getDepState() {
        return depState;
    }

    public void setDepState(String depState) {
        this.depState = depState;
    }
}