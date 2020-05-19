package com.company.web.controller;

import com.company.web.po.UserInfos;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.stereotype.Controller;
import org.springframework.http.ResponseEntity; 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@CrossOrigin(origins="*", maxAge=3600)
@Controller 
@RequestMapping("/api/page/limit")
public class PageInterceptController {
    static Logger logger = LoggerFactory.getLogger(PageController.class);
    
    
    @RequestMapping(value="/index", method=RequestMethod.GET)
    public String indexPage(Model model){
        Map<String, String> userInfos = new HashMap<>();
        userInfos.put("username", "xioaxioa");
        userInfos.put("password", "123456");
        model.addAttribute("loginInfos", userInfos);
        return "sys/index";

    }

    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String login(ModelMap map, Model model, @ModelAttribute UserInfos params, HttpSession session){
        UserInfos userInfos = new UserInfos();
        // map.put("userInfo", userInfos);
        model.addAttribute("userInfo", userInfos);
        session.setAttribute("username", "xiaoxiao");
        return "sign-in/index";
    }

    @RequestMapping(value="/sign-in", method=RequestMethod.POST)
    @ResponseBody
    public String signIn(@ModelAttribute UserInfos params,Model model, HttpServletRequest req, HttpSession session){
        // Map<String, String> userInfos = new HashMap<>();
        // userInfos.put("username", "xioaxioa");
        // userInfos.put("password", "1234567890");
        // model.addAttribute("loginInfos", userInfos);
        String email = params.getEmail();
        System.out.println("email:"+email);
        String username = session.getAttribute("username").toString();
        // String email = userInfoObj.;
        System.out.println("username:"+username);
        return email;
    }

    @RequestMapping(value="/infos", method=RequestMethod.GET)
    public ResponseEntity infosShow(){
        return ResponseEntity.ok("请求成功");
    }


}