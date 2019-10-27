package com.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import com.datasource.po.Buser;

public class MyUtil{
    /**
     * 获取时间字符串
     * @return
     */
    public static String getStringID(){
        String id = null;
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        id = sdf.format(date);
        return id;
    }

    /**
     * 获取用户ID
     * @param session
     * @return
     */
    public static Integer getUserId(HttpSession session){
        Buser ruser = (Buser)session.getAttribute("bruser");
        // 未使用ModelAttribute和HandlerException拦截未登录
        // 调用该输出
        System.out.format("未登录tuil:"+ruser);
        if(ruser == null){
            System.out.format("未登录util");
        }
        return ruser.getId();
    }
}