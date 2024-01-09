package com.ping.homeschool.model;

import java.util.Date;

public class Request {
    private Integer requestId;

    private Integer requestType;

    private Short requestStatus;

    private Date requestTime;

    private String requestForm;

    public Request() {
    }

    public Request(Integer requestId, Integer requestType, Short requestStatus, Date requestTime, String requestForm) {
        this.requestId = requestId;
        this.requestType = requestType;
        this.requestStatus = requestStatus;
        this.requestTime = requestTime;
        this.requestForm = requestForm;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public Integer getRequestType() {
        return requestType;
    }

    public void setRequestType(Integer requestType) {
        this.requestType = requestType;
    }

    public Short getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(Short requestStatus) {
        this.requestStatus = requestStatus;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public String getRequestForm() {
        return requestForm;
    }

    public void setRequestForm(String requestForm) {
        this.requestForm = requestForm;
    }

    @Override
    public String toString() {
        return "Request{" +
                "requestId=" + requestId +
                ", requestType=" + requestType +
                ", requestStatus=" + requestStatus +
                ", requestTime=" + requestTime +
                ", requestForm='" + requestForm + '\'' +
                '}';
    }
}