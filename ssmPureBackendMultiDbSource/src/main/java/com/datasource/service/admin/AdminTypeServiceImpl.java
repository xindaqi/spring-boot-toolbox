package com.datasource.service.admin; 

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.datasource.dao.AdminTypeDao;

@Service
@Transactional 
public class AdminTypeServiceImpl implements AdminTypeService{
    @Autowired 
    private AdminTypeDao adminTypeDao;
    
    @Override 
    public String toAddType(Model model){
        model.addAttribute("allTypes", adminTypeDao.selectGoodsType());
        return "admin/addType";
    }

    @Override 
    public String addType(String typename, Model model, HttpSession session){
        adminTypeDao.addType(typename);
        // 添加商品与修改商品使用
        session.setAttribute("goodsType", adminTypeDao.selectGoodsType());
        return "forward:/adminType/toAddType";
    }

    @Override 
    public String toDeleteType(Model model){
        model.addAttribute("allTypes", adminTypeDao.selectGoodsType());
        return "admin/deleteType";
    }

    @Override 
    public String deleteType(Integer id, Model model){
        // 类型有关联
        if(adminTypeDao.selectGoodsByType(id).size() > 0){
            model.addAttribute("msg", "类型有关联,禁止删除");
            return "forward:/adminType/toDeleteType";
        }
        if(adminTypeDao.deleteType(id) > 0){
            model.addAttribute("msg", "类型删除成功");
        }
        // 回到删除页面
        return "forward:/adminType/toDeleteType";
    }
}