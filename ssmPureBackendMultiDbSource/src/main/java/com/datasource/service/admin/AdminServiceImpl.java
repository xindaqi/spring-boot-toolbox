package com.datasource.service.admin;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.datasource.dao.AdminDao;
import com.datasource.dao.AdminTypeDao;
import com.datasource.po.Auser;

@Service
@Transactional 
public class AdminServiceImpl implements AdminService{
    @Autowired 
    private AdminDao adminDao;
    @Autowired 
    private AdminTypeDao adminTypeDao;

    @Override 
    public String login(Auser auser, Model model, HttpSession session){
        if(adminDao.login(auser) != null && adminDao.login(auser).size() > 0){
            session.setAttribute("auser", auser);
            // 添加商品与修改商品页使用
            session.setAttribute("goodsType", adminTypeDao.selectGoodsType());
            return "admin/main";
        }
        model.addAttribute("msg", "用户名或密码错误");
        return "admin/login";
    }
}