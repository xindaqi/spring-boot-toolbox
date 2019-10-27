package com.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.datasource.service.admin.AdminOrderService;

@CrossOrigin(origins="*", maxAge=3600)
@Controller 
@RequestMapping("/adminOrder")
public class AdminOrderController extends BaseController{
    @Autowired 
    private AdminOrderService adminOrderService;

    @RequestMapping("/orderInfo")
    public String orderInfo(Model model){
        return adminOrderService.orderInfo(model);
    }

    @RequestMapping("/deleteorderManger")
    public String deleteorderManager(Integer id){
        return adminOrderService.deleteorderManager(id);
    }
}