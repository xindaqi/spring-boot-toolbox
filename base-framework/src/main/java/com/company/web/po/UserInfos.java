package com.company.web.po;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value={"handler"})
public class UserInfos implements Serializable{
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String sex;
    private String position;
    private String telephoneNum;

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }
    
    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setSex(String sex){
        this.sex = sex;
    }

    public String getSex(){
        return sex;
    }

    public void setPosition(String position){
        this.position = position;
    }

    public String getPosition(){
        return position;
    }

    public void setTelephoneNum(String telephoneNum){
        this.telephoneNum = telephoneNum;
    }

    public String getTelephoneNum(){
        return telephoneNum;
    }
}