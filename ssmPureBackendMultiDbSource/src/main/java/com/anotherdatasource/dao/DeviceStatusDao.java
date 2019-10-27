package com.anotherdatasource.dao;

import com.anotherdatasource.po.DeviceStatus;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository("deviceStatusDao")
@Mapper
public interface DeviceStatusDao{   
    public DeviceStatus selectDeviceStatusById(Integer id);
}