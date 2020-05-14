package basic.datatype.datatest;

import java.util.Enumeration;
import java.util.Vector;

public class EnumerationTest{
    public static void main(String[] args){
        Enumeration<String> infos;
        Vector<String> infosValue = new Vector<String>();
        infosValue.add("xiaohong");
        infosValue.add("shenzhen");
        infosValue.add("female");
        infos = infosValue.elements();
        while(infos.hasMoreElements()){
            System.out.format("Infomations: "+infos.nextElement()+"\n");
        }
        
    }
}