package com.hello;

import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.ui.ModelMap;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;

import java.io.*;
import java.net.URLDecoder;

import com.hello.entity.Info;

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
            return reqBody;
        } catch (IOException e){
            e.printStackTrace();
            return "jsonerror";
        }
    }

    public static String getType(Object o){
        return o.getClass().toString();
    }

    @RequestMapping(value="/post-class", method=RequestMethod.POST)
    @ResponseBody
    public Info loadClass(@RequestBody Info info){
        System.out.println("info:"+info);
        System.out.println("info type:"+getType(info));
        System.out.println("name:"+info.name);
        return info;
    }
}