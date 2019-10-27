package com.controller.index;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.HashMap;

import com.datasource.po.Goods;
import com.datasource.service.admin.AdminGoodsService;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Qualifier;


@CrossOrigin(origins="*", maxAge=3600)
@Controller 
@Component
@RequestMapping("/api")
public class DbCURDController {
    @Autowired 
    @Qualifier("adminGoodsServiceImpl")
    private AdminGoodsService adminGoodsService;

    @Autowired 
    private HttpServletRequest request;

    @RequestMapping(value="/test", method=RequestMethod.GET)
    @ResponseBody 
    public String testAPI(){
        return "working";
    }

    @RequestMapping(value="/get-header-infos", method=RequestMethod.GET)
    @ResponseBody 
    public Map getHeaderInfos(){
        Map<String, String> headerInfos = new HashMap<String, String>();
        headerInfos.put("header", request.getHeader("Accept-Language"));
        headerInfos.put("scheme", request.getScheme());
        headerInfos.put("serverName", request.getServerName());
        // headerInfos.put("header-infos", request.getHeader());
        return headerInfos;

    }

    @RequestMapping(value="/index", method=RequestMethod.POST)
    @ResponseBody 
    public Map<String, String> searchData(@RequestBody Goods goods){
        int id;
        String name = "xiaohong";
        id = goods.getId();
        name = goods.getGname();
        System.out.format("Goods name from request: "+name);
        Map<String, String> goodsInfo = new HashMap<>();
        goods = adminGoodsService.searchGoods(id);
        System.out.format("godds:"+goods);
        goodsInfo.put("gname", goods.getGname());
        goodsInfo.put("goprice", goods.getGoprice().toString());
        goodsInfo.put("grprice", goods.getGrprice().toString());
        
        return goodsInfo;
    }
}