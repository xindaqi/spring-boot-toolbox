package basic.datatype.datatest;

import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class IteratorTest{
    public static void main(String[] args){
        List<String> infos = new ArrayList<String>();
        infos.add("xiaohong");
        infos.add("shenzhen");
        Iterator its = infos.iterator();
        while(its.hasNext()){
            System.out.format("values:"+its.next()+"\n");
        }
    }
}