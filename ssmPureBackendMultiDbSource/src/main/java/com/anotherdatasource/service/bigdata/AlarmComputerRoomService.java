package com.anotherdatasource.service.bigdata;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.anotherdatasource.po.AlarmComputerRoom;

public interface AlarmComputerRoomService {
  public AlarmComputerRoom selectAlarmComputerRoomById(Integer id);
  public String addAlarmInfos(Map alarmComputerRoomInfos);
  
}
