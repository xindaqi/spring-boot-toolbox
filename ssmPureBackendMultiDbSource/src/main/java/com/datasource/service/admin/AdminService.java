package com.datasource.service.admin;

import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;

import com.datasource.po.Auser;

public interface AdminService{
    public String login(Auser auser, Model model, HttpSession session);
}