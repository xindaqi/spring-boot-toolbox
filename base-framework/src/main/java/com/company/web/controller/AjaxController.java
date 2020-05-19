package com.company.web.controller;

import java.util.Map;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

@CrossOrigin(origins="*", maxAge=3600)
@RestController
@RequestMapping("/api/ajax")
public class AjaxController {

    @RequestMapping(value="/get-test", params="id", method=RequestMethod.GET)
    public String getId(@RequestParam("id") String id){
        System.out.println("id:"+id);
        return id;
    }

    @RequestMapping(value="/post-test", method=RequestMethod.POST)
    public String getParams(@RequestBody Map params){
        String id = params.get("id").toString();
        return id;
    }

}