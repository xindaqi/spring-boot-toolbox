package com.anotherdatasource.service.bigdata;

import com.anotherdatasource.po.DeviceStatus;

public interface DeviceStatusService {
  public DeviceStatus selectDeviceStatusById(Integer id);

}