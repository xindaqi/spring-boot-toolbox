package com.hello.entity;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

//使用lombok插件,可不用写setter和getter
@Data
@Accessors(chain = true)
@Builder
public class Info {
    public String name;
    private String sex;
    private String cellphone;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setSex(String sex){
        this.sex =sex;
    }
    public String getSex(){
        return sex;
    }


    public Info(){

    }

    public Info(String name, String sex, String cellphone){
        this.name = name;
        this.sex = sex;
        this.cellphone = cellphone;
    }
}
