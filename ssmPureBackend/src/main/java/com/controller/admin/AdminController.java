package com.controller.admin;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.po.Auser;
import com.service.admin.AdminService;

@CrossOrigin(origins="*", maxAge=3600)
@Controller 
public class AdminController{
    @Autowired 
    private AdminService adminService;

    @RequestMapping(value="/api/admin", method=RequestMethod.GET)
    public String controllerAdmin(){
        return "admin/login";
    }

    @RequestMapping("/admin")
    public String toLogin(@ModelAttribute Auser auser){
        return "admin/login";
    }

    @RequestMapping("/admin/login")
    public String login(@ModelAttribute Auser auser, Model model, HttpSession session){
        return adminService.login(auser, model, session);
    }

    @RequestMapping("/exit")
    public String exit(@ModelAttribute Auser auser, HttpSession session){
        session.invalidate();
        return "admin/login";
    }

}
