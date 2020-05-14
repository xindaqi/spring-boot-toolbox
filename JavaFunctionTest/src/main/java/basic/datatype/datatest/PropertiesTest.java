package basic.datatype.datatest;

import java.util.Properties;
import java.util.Set;
import java.util.Iterator;

public class PropertiesTest{
    public static void main(String[] args){
        Properties infos = new Properties();
        Set keySet;
        String str;
        infos.put("name", "xiaoxiao");
        infos.put("address", "shenzhen");
        infos.put("sex", "female");
        System.out.format("Properties--infos: "+infos+"\n");
        keySet = infos.keySet();
        System.out.format("Properties--keys:"+keySet+"\n");
        Iterator its = keySet.iterator();
        System.out.format("Properties--iterators: "+its+"\n");
        while (its.hasNext()){
            str = (String)its.next();
            System.out.format("Properties--iterator: "+str+"\n");
            System.out.format("Properties--values: "+infos.getProperty(str)+"\n");
        }

    }
}