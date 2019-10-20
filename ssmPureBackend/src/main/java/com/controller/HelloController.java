package com.controller;

import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.ModelMap;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;

import java.io.*;
import java.net.URLDecoder;


import java.util.Map;
import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller 
@RequestMapping("/api")
public class HelloController{
    @RequestMapping(value="/datas", method=RequestMethod.GET)
    // @ResponseBody
    public String printHello(HttpServletRequest request, Model model){
        model.addAttribute("message", "Hello Spring MVC Framework!");
        // return "hello";
        return "hello";
    }

    /**
     * URI paramter received.
     * @param request: parameter request object
     * @param model: database model object
     * @return name: user name
     */
    @RequestMapping(value="/get-infos", method=RequestMethod.GET)
    @ResponseBody
    public String returnString(HttpServletRequest request, Model model){
        String name = request.getParameter("name");
        System.out.println("name:"+name);
        // String address = request.getParameter("address");
        return name;
    }

    /**
     * x-www-form-urlencode parameter received.
     * @param name: variable
     * @param address: variable
     * @return name
     */
    @RequestMapping(value="/post-infos", method=RequestMethod.POST)
    @ResponseBody
    public String returnJson(@RequestBody String name, @RequestBody String address){
        System.out.println("data: "+name);
        // String address = request.getParameter("address");
        return name;
    }

    public static String getType(Object o){
        return o.getClass().toString();
    }

    /**
     * Transfer json data and parse it directly.
     * @param request: request object
     * @return request body
     */
    @RequestMapping(value="/post-json", method=RequestMethod.POST)
    @ResponseBody
    public String loadJson(HttpServletRequest request){
        BufferedReader br;
        StringBuilder sb = null;
        String reqBody = null;
        try{
            br = new BufferedReader(new InputStreamReader(
                request.getInputStream()
            ));
            String line = null;
            sb = new StringBuilder();
            while ((line = br.readLine()) != null ){
                sb.append(line);
            }
            reqBody = URLDecoder.decode(sb.toString(), "UTF-8");
            reqBody = reqBody.substring(reqBody.indexOf("{"));
            request.setAttribute("inputParam", reqBody);
            System.out.println("JsonRequest :"+reqBody);
            System.out.println("Type of request data:"+getType(reqBody));
            return reqBody;
        } catch (IOException e){
            e.printStackTrace();
            return "jsonerror";
        }
    }

    /**
     * Tranfering map data.
     * @param map
     * @return
     */
    @RequestMapping(value="/post-map", method=RequestMethod.POST)
    @ResponseBody
    public String postMap(@RequestBody Map<String, String> map){
        String name = "hello";
        String sex = "male";
        if(map.containsKey("name")){
            name = map.get("name").toString();
        }
        if(map.containsKey("sex")){
            sex = map.get("sex").toString();
        }
        return name;
    }
    
    /**
     * Transfering x-www-from-urlencode data.
     * @param name
     * @return
     */
    @RequestMapping(value="/post-param", method=RequestMethod.POST)
    @ResponseBody
    public String postParam(@RequestParam("name") String name){
        System.out.println("name:"+name);
        return name;
    }
}