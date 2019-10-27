package com.controller.bigdata;

import java.util.Map;
import java.util.HashMap;

import com.anotherdatasource.po.AlarmComputerRoom;
import com.anotherdatasource.service.bigdata.AlarmComputerRoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.ResponseEntity;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Qualifier;

import io.swagger.annotations.Api;
// import 
import io.swagger.annotations.ApiOperation;

@Controller 
@RequestMapping("/api")
@Api(value="/api", tags="测试接口", description="测试API", hidden=false)
public class AlarmComputerRoomController{
    @Autowired 
    // @Resource(name="alarmComputerRoomService") 
    @Qualifier("alarmComputerRoomServiceImpl")
    private AlarmComputerRoomService alarmComputerRoomService;

    
    @RequestMapping(value="/get-infos/alarm-computer-room/{id}", method=RequestMethod.GET)
    @ResponseBody 
    @ApiOperation(value="通过id查询数据")
    public ResponseEntity getAlarmsInfosById(@PathVariable("id") Integer id) throws Exception{
        System.out.format("Id: "+id+"\n");
        AlarmComputerRoom alarmComputerRoom = alarmComputerRoomService.selectAlarmComputerRoomById(id);
        alarmComputerRoom.getSummary();
        // System.out.format()
        // return deviceStatus.getDeviceId();
        return ResponseEntity.ok(alarmComputerRoom);
    }
    @RequestMapping(value="/insert-infos/alarm-computer-room", method=RequestMethod.POST) 
    @ResponseBody 
    @ApiOperation(value="添加数据")
    public Map setAlarmInfos(@RequestBody Map alarmComputerRoomInfos){
        String alarmInfos = alarmComputerRoomService.addAlarmInfos(alarmComputerRoomInfos);
        Map returnInfos = new HashMap();
        returnInfos.put("code", 200);
        returnInfos.put("info",alarmInfos);
        return returnInfos;
    }


}