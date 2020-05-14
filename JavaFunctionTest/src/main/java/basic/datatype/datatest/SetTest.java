package basic.datatype.datatest;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetTest{
    public static void main(String[] args){
        Set<String> infos = new TreeSet<String>();
        infos.add("xiaohong");
        infos.add("shenzhen");
        System.out.format("Set--infos: "+infos+"\n");
        Iterator its = infos.iterator();
        while(its.hasNext()){
            System.out.format("Set--iterators: "+its.next()+"\n");
        }

        for(String info : infos){
            System.out.format("Set--foreach: "+info+"\n");
        }

        System.out.format("Set--contains: "+infos.contains("xiaohong")+"\n");
        System.out.format("Set--isEmpty: "+infos.isEmpty()+"\n");
        System.out.format("Set--size: "+infos.size()+"\n");
        infos.remove("xiaohong");
        System.out.format("Set--remove after size: "+infos.size()+"\n");
        infos.clear();
        System.out.format("Set--clear: "+infos.isEmpty()+"\n");
    }
}