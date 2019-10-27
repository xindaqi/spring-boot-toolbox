package com.anotherdatasource.po;

import java.util.Date;

public class DeviceStatus {
    private Long id;
    private String projectId;
    private String deviceId;
    private Byte status;
    private Date eventTime;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectId() {
        return projectId;
    }
    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    public String getDeviceId() {
        return deviceId;
    }
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public Byte getStatus() {
        return status;
    }
    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getEventTime() {
        return eventTime;
    }
    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    // public DeviceStatus(){}

    // public DeviceStatus(Date eventTime){
    //     this.eventTime = eventTime;
    // }
}