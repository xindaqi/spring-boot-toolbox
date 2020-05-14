package com.company.web.controller;

import com.company.web.service.AnswersService;

import java.util.Map;
import java.util.HashMap;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin(origins="*", maxAge=3600)
@RestController 
@RequestMapping("/api/answers")
public class AnswersController {
    static Logger logger = LoggerFactory.getLogger(AnswersController.class);

    @Autowired 
    private AnswersService answersService;

    @RequestMapping(value="/add/single", method=RequestMethod.POST)
    public Map addAnswersSingle(@RequestBody Map params){
        Map returnMap = new HashMap();
        try{
            return answersService.addAnswers(params);
        }catch(Exception e){
            e.printStackTrace();
        }
        returnMap.put("code", 400);
        returnMap.put("msg","参数错误,检查参数");
        return returnMap;
    }

    @RequestMapping(value="/delete/single", method=RequestMethod.DELETE)
    public Map deleteAnswersSingle(@RequestBody Map params){
        Map returnMap = new HashMap();
        try{
            String answers = params.get("answers").toString();
            return answersService.deleteAnswers(answers);
        }catch(Exception e){
            e.printStackTrace();
        }
        returnMap.put("code", 400);
        returnMap.put("msg", "参数错误,检查参数");
        return returnMap;
    }

    @RequestMapping(value="/edit/single", method=RequestMethod.PUT)
    public Map editAnswersSingle(@RequestBody Map params){
        Map returnMap = new HashMap();
        try{
            return answersService.editAnswers(params);
        }catch(Exception e){
            e.printStackTrace();
        }
        returnMap.put("code", 400);
        returnMap.put("msg", "参数错误,检查参数");
        return returnMap;
    }

    @RequestMapping(value="/query/all", method=RequestMethod.POST)
    public Map queryAnswersAll(@RequestBody Map params){
        Map returnMap = new HashMap();
        try{
            return answersService.queryAnswersAll(params);
        }catch(Exception e){
            e.printStackTrace();
        }
        returnMap.put("code", 400);
        returnMap.put("msg", "参数错误,检查参数");
        return returnMap;
    }

    @RequestMapping(value="/query/single", params="answers", method=RequestMethod.GET)
    public Map queryAnswersSingle(@RequestParam("answers") String answers){
        Map returnMap = new HashMap();
        try{
            return answersService.queryAnswersSingle(answers);
        }catch(Exception e){
            e.printStackTrace();
        }
        returnMap.put("code", 400);
        returnMap.put("msg", "参数错误,检查参数");
        return returnMap;
    }

}