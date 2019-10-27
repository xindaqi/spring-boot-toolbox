package com.anotherdatasource.service.bigdata;

import com.github.pagehelper.PageInfo;
import com.anotherdatasource.dao.AlarmComputerRoomDao;
import com.anotherdatasource.po.AlarmComputerRoom;
import com.anotherdatasource.service.bigdata.AlarmComputerRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
// import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service("alarmComputerRoomServiceImpl")
@Transactional
public class AlarmComputerRoomServiceImpl implements AlarmComputerRoomService{

    @Autowired
    private AlarmComputerRoomDao alarmComputerRoomMapper;

    @Override
    public AlarmComputerRoom selectAlarmComputerRoomById(Integer id){
        AlarmComputerRoom deviceStatus = alarmComputerRoomMapper.selectAlarmComputerRoomById(id);
        return deviceStatus;
    }

    @Override 
    public String addAlarmInfos(Map alarmComputerRoomInfos){
        if(alarmComputerRoomMapper.addAlarmComputerRoomInfos(alarmComputerRoomInfos) > 0){
            return "success saved alarm infomations";
        }else{
            return "save failed";
        }
        
    }

    
}
