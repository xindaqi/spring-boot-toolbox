package api.request;

import java.util.HashMap;
import java.util.Map;

public class GetTest {
    public static void main(String[] args){
        String url="http://127.0.0.1:8090/test-get";
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "xiaohuang");
        map.put("sex", "female");
        String str = HttpClientUtil.doGet(url, map);
        System.out.println(str);
    }
}
