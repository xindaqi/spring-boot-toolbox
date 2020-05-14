package basic.datatype.datatest;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class ArraysTest{
    public static void main(String[] args){
        String[] infosArray = {"xiaohong", "female"};
        for (String info:infosArray){
            System.out.format("ArrayInfo:"+info+"\n");
        }
        Map infos = new HashMap();
        infos.put("name", "xiaolv");
        infos.put("sex", "female");

        System.out.format("Array--infos: "+infosArray+"\n");
        System.out.format("Array--infos: "+infosArray[0]+"\n");
        List infosList = new ArrayList();
        // infosList = Arrays.asList(infosArray);
        infosList.add(infos);
        System.out.format("List--infos"+infosList+"\n");

    }
}