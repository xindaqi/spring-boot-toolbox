package basic.datatype.datatest;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest{
    private Map<String, String> peopleInfos = new HashMap<String, String>();
    private Map<String, String> workInfos = new HashMap<String, String>();
    public void putDatas(String name, String sex){
        peopleInfos.put("name", name);
        peopleInfos.put("sex", sex);
        System.out.format("put--people infomations: " + peopleInfos + "\n");
    }

    public void putAllDatas(String occupation, String technology){
        workInfos.put("occupation", occupation);
        workInfos.put("technology", technology);
        peopleInfos.putAll(workInfos);
        System.out.format("put all--people infomations: " + peopleInfos + "\n");
    }

    public void containsKeyTest(){
        boolean judgeKey = peopleInfos.containsKey("name");
        System.out.format("containsKey--peopleInfos contains name: " + judgeKey + "\n");
        judgeKey = peopleInfos.containsKey("address");
        System.out.format("containsKey--peopleInfos contains address: " + judgeKey + "\n");
    }

    public void containsValueTest(){
        boolean judgeValue = peopleInfos.containsValue("xiaohong");
        System.out.format("containsValue--peopleInfos contains value xiaohong: " + judgeValue + "\n");
        judgeValue = peopleInfos.containsValue("xiaoxiao");
        System.out.format("containsValue--peopleInfos contains value xiaoxiao: " + judgeValue + "\n");
    }

    public void entrySetTest(){
        Set set = peopleInfos.entrySet();
        System.out.format("entrySet--peopleInfos Set format: " + set + "\n");
    }

    public void equalsTest(){
        System.out.format("equals--Compare map equal or not:" + peopleInfos.equals(workInfos) + "\n");
    }

    public void getValueByKey(){
        Object obj = peopleInfos.get("name");
        System.out.format("get--peopleInfos name: " + obj + "\n");
    }

    public void getAllValuesTest(){
        Collection col = peopleInfos.values();
        System.out.format("values--peopleInfos values: " + col + "\n");
    }

    public void hashCodeTest(){
        int hashCode = peopleInfos.hashCode();
        System.out.format("hashCode--peopleInfos hashCode: " + hashCode + "\n");
    }

    public void isEmptyTest(){
        boolean emptyStatus = peopleInfos.isEmpty();
        System.out.format("isEmpty--peopleInfos empty status: " + emptyStatus + "\n"); 
    }

    public void keySetTest(){
        Set set = peopleInfos.keySet();
        System.out.format("keySet--peopleInfos key set: " + set + "\n");
    }

    public void removeByKeyTest(){
        System.out.format("remove--before: " + peopleInfos + "\n");
        peopleInfos.remove("name");
        System.out.format("remove--after: " + peopleInfos + "\n");
    }

    public void sizeTest(){
        int size = peopleInfos.size();
        System.out.format("size--peopleInfos size: " + size + "\n");
    }

    public void clearDatas(){
        peopleInfos.clear();
        System.out.format("clear--people infomations: " + peopleInfos + "\n");
    }

    public void entryIteratorTest(){
        System.out.format("------entry iterator------\n");
        for (Map.Entry<String, String> entry : peopleInfos.entrySet()){
            System.out.format("key: "+entry.getKey()+"\n"+"value: "+entry.getValue()+"\n");
        }
        System.out.format("--------------------------\n");
    }

    public void iteratorTest(){
        Iterator<Map.Entry<String, String>> its = peopleInfos.entrySet().iterator();
        System.out.format("--------iterator--------\n");
        while (its.hasNext()){
            Map.Entry<String, String> it = its.next();
            String key = it.getKey();
            String value = it.getValue();
            System.out.format("key: "+key+"\n"+"value: "+value+"\n");
        }
        System.out.format("--------------------------\n");
    }

    public MapTest(){};
    public MapTest(String name){
        System.out.format("name: " + name + "\n");
    }
    public static void main(String[] args){
        MapTest mapTest = new MapTest();
        mapTest.putDatas("xiaohong", "female");
        mapTest.putAllDatas("IT Engineer", "AI+Web");
        mapTest.containsKeyTest();
        mapTest.containsValueTest();
        mapTest.entrySetTest();
        mapTest.equalsTest();
        mapTest.getValueByKey();
        mapTest.getAllValuesTest();
        mapTest.hashCode();
        mapTest.isEmptyTest();
        mapTest.keySetTest();
        mapTest.sizeTest();
        mapTest.entryIteratorTest();
        mapTest.iteratorTest();
        mapTest.removeByKeyTest();
        mapTest.sizeTest();
        mapTest.clearDatas();
        mapTest.sizeTest();
        mapTest.isEmptyTest();
    }
}