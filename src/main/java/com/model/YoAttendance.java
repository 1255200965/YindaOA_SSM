package com.model;

import java.sql.Timestamp;

public class YoAttendance {
    private String id;

    private String userid;

    private String corpid;

    private String groupid;

    private String planid;

    private String recordid;

    private Timestamp workdate;

    private String checktype;

    private String timeresult;

    private String locationresult;

    private Timestamp basechecktime;

    private Timestamp userchecktime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getCorpid() {
        return corpid;
    }

    public void setCorpid(String corpid) {
        this.corpid = corpid;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public String getPlanid() {
        return planid;
    }

    public void setPlanid(String planid) {
        this.planid = planid;
    }

    public String getRecordid() {
        return recordid;
    }

    public void setRecordid(String recordid) {
        this.recordid = recordid;
    }

    public Timestamp getWorkdate() {
        return workdate;
    }

    public void setWorkdate(Timestamp workdate) {
        this.workdate = workdate;
    }

    public String getChecktype() {
        return checktype;
    }

    public void setChecktype(String checktype) {
        this.checktype = checktype;
    }

    public String getTimeresult() {
        return timeresult;
    }

    public void setTimeresult(String timeresult) {
        this.timeresult = timeresult;
    }

    public String getLocationresult() {
        return locationresult;
    }

    public void setLocationresult(String locationresult) {
        this.locationresult = locationresult;
    }

    public Timestamp getBasechecktime() {
        return basechecktime;
    }

    public void setBasechecktime(Timestamp basechecktime) {
        this.basechecktime = basechecktime;
    }

    public Timestamp getUserchecktime() {
        return userchecktime;
    }

    public void setUserchecktime(Timestamp userchecktime) {
        this.userchecktime = userchecktime;
    }
}