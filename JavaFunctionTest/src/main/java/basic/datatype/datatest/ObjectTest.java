package basic.datatype.datatest;

import java.util.Map;
import java.util.HashMap;

import basic.datatype.po.Infos;

public class ObjectTest{
    public static void main(String[] args){
        Infos infoTest = new Infos();
        infoTest.setName("xiaohong");
        infoTest.setAddress("hefei");
        Map data = new HashMap();
        data.put("datas", infoTest);
        System.out.format("data object:"+data+"\n");
        System.out.format("data object:"+data.get("datas")+"\n");
        Map dataNew = (Map)data.get("datas");
        System.out.format("data map: "+dataNew.get("name"));

    }
}