package com.controller.before;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.po.Buser;
import com.service.before.UserService;
import com.dao.UserDao;

@CrossOrigin(origins="*", maxAge=3600)
@Controller 
@RequestMapping("/user")
public class UserController{
    @Autowired 
    private UserService userService;
    @Autowired
    private UserDao userDao;

    @RequestMapping("/test/insert")
    @ResponseBody 
    public String insertUser(){
        Buser addUser = new Buser();
        addUser.setId(2);
        addUser.setBemail("test@qq.com");
        addUser.setBpwd("123456");
        int up = userDao.register(addUser);
        System.out.format("添加"+up+"用户");

        return "insert successully";
    }

    @RequestMapping("/register")
    public String register(@ModelAttribute Buser buser, Model model, HttpSession session, String code){
        return userService.register(buser, model, session, code);
    }

    @RequestMapping("/login")
    public String login(@ModelAttribute Buser buser, Model model, HttpSession session, String code){
        return userService.login(buser, model, session, code);
    }

    @RequestMapping("/exit")
    public String exit(HttpSession session){
        session.invalidate();
        return "forward:/before";
    }
}