package com.company.web.mapper;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import com.company.web.po.Answers;
import com.company.web.po.Questions;

public interface QuestionsMapper {
    public Integer addQuestions(Map params);
    public Integer deleteQuestions(String questions);
    public Integer editQuestions(Map params);
    public List<Questions> queryQuestionsAll(Map params); 
    public List<Questions> queryQuestionsOne(String questions);

}