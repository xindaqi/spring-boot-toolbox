package com.controller.admin;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.datasource.service.admin.AdminTypeService;

@CrossOrigin(origins="*", maxAge=3600)
@Controller 
@RequestMapping("/adminType")
public class AdminTypeController extends BaseController{
    @Autowired 
    private AdminTypeService adminTypeService;

    @RequestMapping("/toAddType")
    public String toAddType(Model model){
        return adminTypeService.toAddType(model);
    }

    @RequestMapping("/addType")
    public String addType(String typename, Model model, HttpSession session){
        return adminTypeService.addType(typename, model, session);
    }

    @RequestMapping("/toDeleteType")
    public String toDeleteType(Model model){
        return adminTypeService.toDeleteType(model);
    }

    @RequestMapping("/deleteType")
    public String deleteType(Integer id, Model model){
        return adminTypeService.deleteType(id, model);
    }
}



