package com.company.web.mapper;

import java.util.Map;
import java.util.List;

public interface AnswersMapper {

    public Integer addAnswers(Map params);
    public Integer deleteAnswers(String answers);
    public Integer editAnswers(Map params);
    public List queryAnswersAll(Map params);
    public List queryAnswersSingle(String answers);

}