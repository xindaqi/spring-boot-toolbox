package basic.datatype.datatest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class OutputTest {
    public void lineEnter(){
        System.out.println("=============\n");
    }
    
    public List listTest(){
        List<String> natureInfo = new ArrayList<String>();
        natureInfo.add("xiaohong");
        natureInfo.add("河北");
        natureInfo.add("很能吃");

        List<String> workInfo = new ArrayList<String>(){{
            add("公务员");
            add("上市公司");
        }};

        List<List<String>> datas = new ArrayList<List<String>>();
        datas.add(natureInfo);
        datas.add(workInfo);
        return datas;
    }

    public Map mapTest(){
        Map<String, String> natureInfo = new HashMap<String, String>();
        natureInfo.put("name", "小吕");
        natureInfo.put("address", "洛杉矶");

        Map<String, String> workInfo = new HashMap<String, String>(){
            {
                put("position", "小白");
                put("company", "NASDAQ");
            }
        };

        Map<String, Map> datas = new HashMap<String, Map>();
        datas.put("natureInfo", natureInfo);
        datas.put("workInfo", workInfo);

        return datas;
    }

    public static String getType(Object o){
        return o.getClass().toString();
    }

    public static void main(String[] args){
        String strTest = "hello world!";
        System.out.println("data:"+strTest);
        // create object
        OutputTest functionTest = new OutputTest();
        // listTest function test
        List<List> datas = functionTest.listTest();
        System.out.println("datas: "+datas);
        System.out.println("data: "+datas.get(0));
        for(int i=0;i<datas.size();i++){
            System.out.println("size iterator:"+datas.get(i));

        }
        for(List data : datas){
            System.out.println("foreach iterator:"+data);
        }
        for(Iterator<List> it = datas.iterator();it.hasNext();){
            System.out.println("iterator: "+it.next());
        }
        functionTest.lineEnter();
        // mapTest function test
        Map<String, Map> mapDatas = new HashMap<String, Map>();
        mapDatas = functionTest.mapTest();
        System.out.println("map datas: "+mapDatas);
        System.out.println("entry function iterator\n");
        for (Map.Entry<String, Map> entry : mapDatas.entrySet()){
            System.out.println("key:"+entry.getKey()+"\n"+"value:"+entry.getValue()+"\n");
        }
        System.out.println("foreach iterator\n");
        for(String key : mapDatas.keySet()){
            System.out.println("key:"+key+"\n");
        }
        for(Map values: mapDatas.values()){
            System.out.println("value: "+values+"\n");
        }
        System.out.println("iterator\n");
        Iterator<Map.Entry<String, Map>> its = mapDatas.entrySet().iterator();
        while(its.hasNext()){
            Map.Entry<String, Map> it = its.next();
            String key = it.getKey();
            Map value = it.getValue();
            System.out.println("key:"+key+"\nvalue:"+value+"\n");
        }
        System.out.println("key iterator\n");
        for(String key : mapDatas.keySet()){
            Map value = mapDatas.get(key);
            System.out.println("key:"+key+"\nvalue:"+value+"\n");
        }


//        get data format
        String data_test = "hello";
        System.out.println("data type: "+getType(data_test));
        System.out.println("data type: "+data_test.getClass().toString());

        String name = "xiaohong";
        if(name == "xiaohong"){
            System.out.println("equal");
        }

        MapTest mapTest = new MapTest();
        
    }

}
