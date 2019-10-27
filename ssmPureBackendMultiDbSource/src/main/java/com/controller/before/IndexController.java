package com.controller.before;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.datasource.po.Goods;
import com.datasource.service.before.IndexService;

@CrossOrigin(origins="*", maxAge=3600)
@Controller 
public class IndexController{
    @Autowired 
    private IndexService indexService;

    // @RequestMapping(value="/api/test", method=RequestMethod.POST)
    // @ResponseBody
    // public String test(){
    //     return "test";
    // }

    @RequestMapping("/before")
    public String before(Model model, HttpSession session, Goods goods){
        return indexService.before(model, session, goods);
    }

    @RequestMapping("/toRegister")
    public String toRegister(Model model){
        return indexService.toRegister(model);
    }

    @RequestMapping("/toLogin")
    public String toLogin(Model model){
        return indexService.toLogin(model);
    }

    @RequestMapping("/goodsDetail")
    public String goodsDetail(Model model, Integer id){
        return indexService.goodsDetail(model, id);
    }

    @RequestMapping("/selectANotice")
    public String selectANotice(Model model, Integer id){
        return indexService.selectANotice(model, id);
    }

    @RequestMapping("/search")
    public String search(Model model, String mykey){
        System.out.format("search keywords: "+mykey);
        return indexService.search(model, mykey);
    }

}