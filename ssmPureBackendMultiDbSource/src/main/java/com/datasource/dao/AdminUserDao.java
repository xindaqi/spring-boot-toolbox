package com.datasource.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.datasource.po.Buser;

@Repository("adminUserDao")
@Mapper
public interface AdminUserDao{
    public List<Buser> userInfo();
    public int deleteuserManager(Integer id);
}