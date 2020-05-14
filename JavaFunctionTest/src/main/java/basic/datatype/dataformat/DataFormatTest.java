package basic.datatype.dataformat;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;

public class DataFormatTest{
    private static void arrayToStr(){
        String[] dataStrArr = {"xiao", "da", "diandian"};
        List dataLi = Arrays.asList("xiao", "hei");

        String dataStr = String.join(",", dataLi);
        // String dataStr = Arrays.toString(dataStrArr);
        // String dataStr = String.valueOf(dataStrArr);
        System.out.println("data string:"+dataStr);
    }
    
    public static void main(String[] args){
        Map dataMap = new HashMap(){
            {
                put("code", 200);
            }
        };
        String name = null;
        String address = "china";
        String data = "china";
        if(address == data){
            System.out.println("data equal address");
        }else{
            System.out.println("data not equal address");
        }
        if(name == null){
            System.out.format("name equals null");
        }else{
            System.out.format("name is:"+name);
        }
        System.out.println("name and address have same format:"+name instanceof String);
        System.out.println("Format:"+data.getClass());
        System.out.println("Map:"+dataMap.getClass());
        arrayToStr();
    }
}