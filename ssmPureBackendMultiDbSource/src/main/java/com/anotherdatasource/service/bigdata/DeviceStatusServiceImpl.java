package com.anotherdatasource.service.bigdata;

import com.anotherdatasource.dao.DeviceStatusDao;
import com.anotherdatasource.po.DeviceStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("deviceStatusServiceImpl")
@Transactional
public class DeviceStatusServiceImpl implements DeviceStatusService {

    @Autowired
    private DeviceStatusDao deviceStatusDao;

    public DeviceStatus selectDeviceStatusById(Integer id){
        DeviceStatus deviceStatus = deviceStatusDao.selectDeviceStatusById(id);
        return deviceStatus;
    }
}