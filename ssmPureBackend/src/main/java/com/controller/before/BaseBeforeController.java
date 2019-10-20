package com.controller.before;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.exception.UserLoginNoException;

@CrossOrigin 
@Controller 
public class BaseBeforeController{
    // java.lang.NullPointerException
    /**
     * 直接拦截未登录状态
     * @param session
     * @param request
     * @throws UserLoginNoException
     */
    @ModelAttribute 
    public void isLogin(HttpSession session, HttpServletRequest request) throws UserLoginNoException{
        if(session.getAttribute("bruser") == null){
            System.out.format("用户未登录base");
            throw new UserLoginNoException("没有登录");
        }
    }
}