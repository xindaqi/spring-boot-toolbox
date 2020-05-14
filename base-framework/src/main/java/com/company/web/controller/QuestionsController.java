package com.company.web.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import com.company.web.service.QuestionsService;
// import com.wh.common-config.BizException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin(origins="*", maxAge=3600)
@RestController
@RequestMapping("/api/questions")
public class QuestionsController {
    static Logger logger = LoggerFactory.getLogger(QuestionsController.class);
    
    @Autowired 
    private QuestionsService questionsService;

    @RequestMapping(value="/add/single", method=RequestMethod.POST)
    public Map addQuestionsSingle(@RequestBody Map params){
        Map returnMap = new HashMap();
        try{
            String questions = params.get("questions").toString();
            return questionsService.addQuestions(params);

        }catch(Exception e){
            e.printStackTrace();
        }
        returnMap.put("code", 400);
        returnMap.put("msg", "参数错误,检查参数或者问题重复");
        return returnMap;
    }

    @RequestMapping(value="/delete/single", method=RequestMethod.DELETE)
    public Map deleteQuestionsSingle(@RequestBody Map params){
        Map returnMap = new HashMap();
        try{
            String questions = params.get("questions").toString();
            return questionsService.deleteQuestions(questions);
        }catch(Exception e){
            e.printStackTrace();
        }
        returnMap.put("code", 400);
        returnMap.put("msg", "参数错误,检查参数");
        return returnMap;
    }

    @RequestMapping(value="/edit/single", method=RequestMethod.PUT)
    public Map editQuestionsSingle(@RequestBody Map params){
        Map returnMap = new HashMap();
        try{
            // String questions = params.get("questions").toString();
            return questionsService.editQuestions(params);
        }catch(Exception e){
            e.printStackTrace();
        }
        returnMap.put("code", 400);
        returnMap.put("msg", "参数错误,检查参数");
        return returnMap;
    }

    @RequestMapping(value="/query/all", method=RequestMethod.POST)
    public Map queryQuestionsAll(@RequestBody Map params){
        Map returnMap = new HashMap();
        try{
            return questionsService.queryQuestionsAll(params);
        }catch(Exception e){
            e.printStackTrace();
        }
        returnMap.put("code", 400);
        returnMap.put("msg", "检查参数");
        return returnMap;
    }

    @RequestMapping(value="/query/single", params="questions", method=RequestMethod.GET)
    public Map queryQuestionsSingle(@RequestParam("questions") String questions){
        Map returnMap = new HashMap();
        try{
            return questionsService.queryQuestionsOne(questions);
        }catch(Exception e){
            e.printStackTrace();
        }
        returnMap.put("code", 400);
        returnMap.put("msg", "参数错误,检查参数");
        return returnMap;
    }
}