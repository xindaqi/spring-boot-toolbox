package com.company.web.po;

import com.company.web.po.Answers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;

// 将下划线的数据映射到小驼峰命名格式的数据,如user_id映射到userId
@JsonIgnoreProperties(value={"handler"})
public class Questions implements Serializable{
    private String questions;
    private List<Answers> answers_li;

    public void setQuestion(String questions){
        this.questions = questions;
    }
    public String getQuestion(){
        return questions;
    }
    public void setAnswersLi(List<Answers> answers_li){
        this.answers_li = answers_li;
    }
    public List<Answers> getAnswersLi(){
        return answers_li;
    }
}