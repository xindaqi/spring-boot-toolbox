package com.company.web.service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.company.web.mapper.QuestionsMapper;
import com.company.web.po.Questions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class QuestionsService {

    @Autowired 
    private QuestionsMapper questionsMapper;

    public Map addQuestions(Map params){
        Map returnMap = new HashMap();
        questionsMapper.addQuestions(params);
        returnMap.put("code", 200);
        returnMap.put("msg", "成功添加问题");
        return returnMap;
    }

    public Map deleteQuestions(String questions){
        Map returnMap = new HashMap();
        questionsMapper.deleteQuestions(questions);
        returnMap.put("code", 200);
        returnMap.put("msg", "成功删除问题");
        return returnMap;
    }

    public Map editQuestions(Map params){
        Map returnMap = new HashMap();
        questionsMapper.editQuestions(params);
        returnMap.put("code", 200);
        returnMap.put("msg", "成功修改问题");
        return returnMap;
    }

    public Map queryQuestionsAll(Map params){
        Map returnMap = new HashMap();
        // Integer pageNo = Integer.parseInt(params.get("pageNo").toString());
        // Integer contentSize = Integer.parseInt(params.get("contentSize").toString());
        // PageHelper.startPage(1, 2);
        // PageHelper.startPage(pageNo, contentSize);
        List questionsLi = questionsMapper.queryQuestionsAll(params);
        
        // PageInfo<Questions> pageLi = new PageInfo(questionsLi);
        
        returnMap.put("code", 200);
        returnMap.put("msg", "成功查询所有数据");
        returnMap.put("datas", questionsLi);
        return returnMap;
    }

    public Map queryQuestionsOne(String questions){
        Map returnMap = new HashMap();
        List questionsLi = questionsMapper.queryQuestionsOne(questions);
        returnMap.put("code", 200);
        returnMap.put("msg", "成功查询单条数据");
        returnMap.put("datas", questionsLi);
        return returnMap;
    }

}