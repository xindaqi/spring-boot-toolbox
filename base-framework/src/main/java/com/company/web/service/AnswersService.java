package com.company.web.service;

import com.company.web.mapper.AnswersMapper;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AnswersService{
    @Autowired 
    private AnswersMapper answersMapper;

    public Map addAnswers(Map params){
        Map returnMap = new HashMap();
        Integer addRes = answersMapper.addAnswers(params);
        returnMap.put("code", 200);
        returnMap.put("msg", "成功添加答案");
        returnMap.put("addRes", addRes);
        return returnMap;
    }

    public Map deleteAnswers(String answers){
        Map returnMap = new HashMap();
        Integer delRes = answersMapper.deleteAnswers(answers);
        returnMap.put("code", 200);
        returnMap.put("msg", "成功删除答案");
        returnMap.put("delRes", delRes);
        return returnMap;
    }

    public Map editAnswers(Map params){
        Map returnMap = new HashMap();
        Integer editRes = answersMapper.editAnswers(params);
        returnMap.put("code", 200);
        returnMap.put("msg", "成功修改答案");
        returnMap.put("editRes", editRes);
        return returnMap;
    }

    public Map queryAnswersAll(Map params){
        Map returnMap = new HashMap();
        List queryAnswersLi = answersMapper.queryAnswersAll(params);
        returnMap.put("code", 200);
        returnMap.put("msg", "成功查询");
        returnMap.put("datas", queryAnswersLi);
        return returnMap;
    }

    public Map queryAnswersSingle(String answers){
        Map returnMap = new HashMap();
        List queryAnswersLi = answersMapper.queryAnswersSingle(answers);
        returnMap.put("code", 200);
        returnMap.put("msg", "成功查询");
        returnMap.put("datas", queryAnswersLi);
        return returnMap;
    }

}