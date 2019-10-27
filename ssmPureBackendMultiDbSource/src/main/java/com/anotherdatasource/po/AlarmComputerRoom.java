package com.anotherdatasource.po;

import java.util.Date;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Data 
@Accessors(chain=true)
@Builder
public class AlarmComputerRoom {
    private String Summary;
    private String Alarm_sys;
    private String Alarm_des;
    private String Alarm_id;
    private String Alarm_level;
    private String Alarm_begin;
    private String Alarm_end;
    private String Alarm_source;
    private String Alarm_projectCode;
    private String Alarm_projectName;
    private String Alarm_areaName;
    private String Alarm_deviceName;
    private String Alarm_pointName;
    private String Alarm_deviceID;
    private Integer Alarm_pointID;
    private String Alarm_pointValue;
    private String Alarm_condition;
    /**
     * 
     * @return
     */
    public String getSummary(){
        return Summary;
    }
    public void setSummary(String Summary){
        this.Summary = Summary;
    }

    /**
     * 
     * @return
     */
    public String getAlarmSys(){
        return Alarm_sys;
    }
    public void setAlarmSys(String Alarm_sys){
        this.Alarm_sys = Alarm_sys;
    }

    /**
     * 
     * @return
     */
    public String getAlarmDes(){
        return Alarm_des;
    }
    public void setAlarmDes(String Alarm_des){
        this.Alarm_des = Alarm_des;
    }

    /**
     * 
     * @return
     */
    public String getAlarmId(){
        return Alarm_id;
    }
    public void setAlarmId(String Alarm_id){
        this.Alarm_id = Alarm_id;
    }

    /**
     * 
     * @return
     */
    public String getAlarmLevel(){
        return Alarm_level;
    }
    public void setAlarmLevel(String Alarm_level){
        this.Alarm_level = Alarm_level;
    }

    /**
     * 
     * @return
     */
    public String getAlarmBegin(){
        return Alarm_begin;
    }
    public void setAlarmBegin(String Alarm_begin){
        this.Alarm_begin = Alarm_begin;
    }

    /**
     * 
     * @return
     */
    public String getAlarmEnd(){
        return Alarm_end;
    }
    public void setAlarmEnd(String Alarm_end){
        this.Alarm_end = Alarm_end;
    }

    /**
     * 
     * @return
     */
    public String getAlarmSource(){
        return Alarm_source;
    }
    public void setAlarmSource(String Alarm_source){
        this.Alarm_source = Alarm_source;
    }

    /**
     * 
     * @return
     */
    public String getAlarmProjectCode(){
        return Alarm_projectCode;
    }
    public void setAlarmProjectCode(String Alarm_projectCode){
        this.Alarm_projectCode = Alarm_projectCode;
    }

    /**
     * 
     * @return
     */
    public String getAlarmProjectName(){
        return Alarm_projectName;
    }
    public void setAlarmProjectName(String Alarm_projectName){
        this.Alarm_projectName = Alarm_projectName;
    }

    /**
     * 
     * @return
     */
    public String getAlarmAreaName(){
        return Alarm_areaName;
    }
    public void setAlarmAreaName(String Alarm_areaName){
        this.Alarm_areaName = Alarm_areaName;
    }

    /**
     * 
     * @return
     */
    public String getAlarmDeviceName(){
        return Alarm_deviceName;
    }
    public void setAlarmDeviceName(String Alarm_deviceName){
        this.Alarm_deviceName = Alarm_deviceName;
    }

    /**
     * 
     * @return
     */
    public String getAlarmPointName(){
        return Alarm_pointName;
    }
    public void setAlarmPointName(String Alarm_pointName){
        this.Alarm_pointName = Alarm_pointName;
    }

    /**
     * 
     * @return
     */
    public String getAlarmDeviceID(){
        return Alarm_deviceID;
    }
    public void setAlarmDeviceID(String Alarm_deviceID){
        this.Alarm_deviceID = Alarm_deviceID;
    }

    /**
     * 
     * @return
     */
    public Integer getAlarmPointID(){
        return Alarm_pointID;
    }
    public void setAlarmPointID(Integer Alarm_pointID){
        this.Alarm_pointID = Alarm_pointID;
    }

    /**
     * 
     * @return
     */
    public String getAlarmPointValue(){
        return Alarm_pointValue;
    }
    public void setAlarmPointValue(String Alarm_pointValue){
        this.Alarm_pointValue = Alarm_pointValue;
    }

    /**
     * 
     * @return
     */
    public String getAlarmCondition(){
        return Alarm_condition;
    }
    public void setAlarmCondition(String Alarm_condition){
        this.Alarm_condition = Alarm_condition;
    } 
    
    public AlarmComputerRoom(){}

    public AlarmComputerRoom(String Summary,String Alarm_sys,
                            String Alarm_des,String Alarm_id,
                            String Alarm_level,String Alarm_begin,
                            String Alarm_end,String Alarm_source,
                            String Alarm_projectCode,String Alarm_projectName,
                            String Alarm_areaName,String Alarm_deviceName,
                            String Alarm_pointName,String Alarm_deviceID,
                            Integer Alarm_pointID,String Alarm_pointValue,
                            String Alarm_condition){
        this.Alarm_condition = Alarm_condition;
    }

}