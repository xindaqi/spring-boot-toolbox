package com.company.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.company.web.mapper.UserInfosMapper;
import com.company.web.po.UserInfos;

@Service
@Transactional
public class UserInfosService {
    @Autowired
    private UserInfosMapper userInfosMapper;

    public Integer addUser(UserInfos params){
        return userInfosMapper.addUser(params);
    }
    public Integer deleteUser(Integer id){
        return userInfosMapper.deleteUser(id);
    }
    public Integer editUser(UserInfos params){
        return userInfosMapper.editUser(params);
    }
    public List queryUser(Map params){
        return userInfosMapper.queryUser(params);
    }

    public UserInfos queryUserWithId(Integer id){
        return userInfosMapper.queryUserWithId(id);
    }

}