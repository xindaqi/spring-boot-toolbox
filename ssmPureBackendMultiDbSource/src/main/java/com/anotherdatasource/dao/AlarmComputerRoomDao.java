package com.anotherdatasource.dao;

import com.anotherdatasource.po.AlarmComputerRoom;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Mapper;
// import tk.mybatis.mapper.common.Mapper;

import java.util.Map;


@Repository
@Mapper
public interface AlarmComputerRoomDao {    
    public AlarmComputerRoom selectAlarmComputerRoomById(Integer id);
    public int addAlarmComputerRoomInfos(Map alarmComputerRoomInfos);

}