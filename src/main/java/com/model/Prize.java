package com.model;

public class Prize {
    private Integer id;

    private String prizetype;

    private String prizecontent;

    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrizetype() {
        return prizetype;
    }

    public void setPrizetype(String prizetype) {
        this.prizetype = prizetype;
    }

    public String getPrizecontent() {
        return prizecontent;
    }

    public void setPrizecontent(String prizecontent) {
        this.prizecontent = prizecontent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}