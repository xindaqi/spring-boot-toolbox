package com.controller.admin;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.exception.AdminLoginNoException;

@CrossOrigin(origins="*", maxAge=3600)
@Controller 
public class BaseController{
    @ModelAttribute
    public void isLogin(HttpSession session, HttpServletRequest request) throws AdminLoginNoException{
        if(session.getAttribute("auser") == null){
            throw new AdminLoginNoException("没有登录");
        }
    }
}

