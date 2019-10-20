package com.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.service.admin.AdminUserService;

@CrossOrigin(origins="*", maxAge=3600)
@Controller 
@RequestMapping("/adminUser")
public class AdminUserController extends BaseController{
    @Autowired 
    private AdminUserService adminUserService;

    @RequestMapping("/userInfo")
    public String userInfo(Model model){
        return adminUserService.userInfo(model);
    }

    @RequestMapping("/deleteuserManager")
    public String deleteuserManager(Integer id, Model model){
        return adminUserService.deleteuserManager(id, model);
    }
}