package com.hello;

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

import com.hello.entity.Info;
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

    @RequestMapping(value="/get-infos", method=RequestMethod.GET)
    @ResponseBody
    public String returnString(HttpServletRequest request, Model model){
        String name = request.getParameter("name");
        System.out.println("name:"+name);
        // String address = request.getParameter("address");
        return name;
    }

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

    
    @RequestMapping(value="/post-class", method=RequestMethod.POST)
    @ResponseBody
    public Info loadClass(@RequestBody Info info){
        System.out.println("info:"+info);
        System.out.println("info type:"+getType(info));
        System.out.println("name:"+info.getName());
        String compare_name = "hello";
        
        // info.setName("xiaohong");
        System.out.println("source name: "+info.getName());
        System.out.println("source name type: "+getType(info.getName()));
        if(info.getName().equals(compare_name)){
            info.setName("xiaohong");
            System.out.println("judge name: "+info.getName());
        }else{
            System.out.println("Name changed error");
        }
        System.out.println("After name changed:"+info.getName());
        return info; 
    }

    @RequestMapping(value="/post-class-new", method=RequestMethod.POST)
    @ResponseBody
    public Info classNew(){
        Info info = new Info();
        info.setSex("male");
        return info;
    }

    @RequestMapping(value="/post-class-json", method=RequestMethod.POST)
    @ResponseBody
    public String classJson(@RequestBody Info info, HttpServletRequest request){
        request.setAttribute("test_name", info.getName());
        String test_name = info.getName();
        return test_name;
    }

    @RequestMapping(value="/post-class-map", method=RequestMethod.POST)
    @ResponseBody
    public Map<String, String> classMap(@RequestBody Info info){
        Map<String, String> datas = new HashMap<String, String>();
        datas.put("username", info.getName());
        datas.put("sex", info.getSex());
        System.out.println("datas:"+datas);
        return datas;
    }

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

    @RequestMapping(value="/post-list", method=RequestMethod.POST)
    @ResponseBody
    public List<Info> postList(@RequestBody List<Info> lists){
        for(Info info : lists){
            System.out.println("data:"+info.toString());
        }
        return lists;
    }

    @RequestMapping(value="/post-param", method=RequestMethod.POST)
    @ResponseBody
    public String postParam(@RequestParam("name") String name){
        System.out.println("name:"+name);
        return name;
    }
}