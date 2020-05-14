package basic.datatype.dataformat;

import java.util.Map;
import java.util.HashMap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class JSONProcessTest{
    public String map2String(Map params){
        String returnStr = JSON.toJSONString(params);
        return returnStr;
    }
    public Map jsonstr2Json(String jsonString){
        Map returnMap = JSONObject.parseObject(jsonString);
        return returnMap;
    }
    public Map dataProcessMulti(String jsonString){
        try{
            Map dataMap = JSONObject.parseObject(jsonString);
            return dataMap;
        }catch(Exception e){
            
        }
        Map returnMap = new HashMap();
        returnMap.put("id", jsonString);
        return returnMap;
    }

    public static void main(String[] args){
        JSONProcessTest jsonProcess = new JSONProcessTest();
        Map params = new HashMap();
        params.put("name", "xiaohong");
        params.put("address", "China");
        String returnStr = jsonProcess.map2String(params);
        System.out.println("Json string:"+returnStr);
        Map returnMap = jsonProcess.jsonstr2Json(returnStr);
        System.out.println("Json:"+returnMap);
        String jsonStr = "{\"name\":\"xiaohua\"}";
        System.out.println("json string:"+jsonStr);
        Map returnMap2 = jsonProcess.jsonstr2Json(jsonStr);
        System.out.println("Json string tranform to Map:"+returnMap2);
        Map dataMap = jsonProcess.dataProcessMulti("jsonStr");
        System.out.println("data:"+dataMap);
    }
}