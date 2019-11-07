package com.sb.service.impl;

import java.util.List;

import com.sb.service.PeopleInfosService;
// import com.sb.dao.PeopleInfosDao;
import com.sb.mapper.PeopleInfosMapper;
import com.sb.po.PeopleInfos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service 
@Transactional
public class PeopleInfosServiceImpl implements PeopleInfosService{

    @Autowired 
    private PeopleInfosMapper peopleInfosMapper;

    @Override 
    public List<PeopleInfos> getAllPeopleInfos(){
        // List<PeopleInfos> infos = peopleInfosDao.selectAllPeopleInfos();
        List<PeopleInfos> infos = peopleInfosMapper.selectAllPeopleInfos();
        return infos;
    }

}