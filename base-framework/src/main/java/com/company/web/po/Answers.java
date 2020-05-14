package com.company.web.po;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value={"handler"})
public class Answers implements Serializable{
    private String answers;
    private String questions;

    public void setAnswers(String answers){
        this.answers = answers;
    }
    public String getAnswers(){
        return answers;
    }
    public void setQuestions(String questions){
        this.questions = questions;
    }
    public String getQeuestions(){
        return questions;
    }

}