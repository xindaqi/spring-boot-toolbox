package com.company.web.mapper;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import com.company.web.po.UserInfos;

public interface UserInfosMapper {
    public Integer addUser(UserInfos params);
    public Integer deleteUser(Integer id );
    public Integer editUser(UserInfos params);
    public List<UserInfos> queryUser(Map params);
    public UserInfos queryUserWithId(Integer id);
}