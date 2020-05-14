package basic.datatype.datatest;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class StringTest{
    public static void main(String[] args){
        // String name = "";
        String name = "xiaohei";
        // String testData = "xiaohei,xiaohong,xiaolv";
        String testData = "xiaohei";
        String[] inputData = testData.split("\\,");
        System.out.format("input datas: "+inputData+"\n");
        List inputDataForSearch = Arrays.asList(inputData);
        System.out.format("list data: "+inputDataForSearch+"\n");
        String tokenStr = "{\"token\":\"accce1dc2ecc4ee9bf9be664377e7861\"}";
        System.out.println("token 1:"+tokenStr);
         if(tokenStr instanceof String){
            System.out.println("String");
         }else{
             System.out.println("Not string");
         }
        System.out.format("status:"+name.equals("")+"\n");
    }
}