package com.datasource.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.datasource.po.Auser;

@Repository("adminDao")
@Mapper
public interface AdminDao{
    public List<Auser> login(Auser auser);
}