package com.controller.bigdata;

import java.util.Map;

import com.anotherdatasource.po.DeviceStatus;
import com.anotherdatasource.service.bigdata.DeviceStatusService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller 
@RequestMapping("/api")
@Api(value="/api", tags="功能测试", description="数据搜索性能分析")
public class DeviceStatusController{
    @Autowired
    @Qualifier("deviceStatusServiceImpl")
    private DeviceStatusService deviceStatusService;

    @RequestMapping(value="/map-return", method=RequestMethod.POST)
    @ResponseBody 
    @ApiOperation(value="测试接口连接")
    public Map mapReturn(@RequestBody Map infos){
        return infos;
    }

    @RequestMapping(value="/device/{id}", method=RequestMethod.GET)
    @ResponseBody 
    @ApiOperation(value="通过id查询数据")
    public ResponseEntity getDeviceInfosById(@PathVariable("id") Integer id) throws Exception{
        System.out.format("Id: "+id+"\n");
        DeviceStatus deviceStatus = deviceStatusService.selectDeviceStatusById(id);
        deviceStatus.getDeviceId();
        // System.out.format()
        // return deviceStatus.getDeviceId();
        return ResponseEntity.ok(deviceStatus);
    }
}