package api.request;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

public class PostJsonTest {
    public static void main(String[] args){
        String url="http://127.0.0.1:8090/test-json";
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "xiaohong");
        map.put("sex", "female");
        String param = JSONObject.fromObject(map).toString();
        String str = HttpClientUtil.doPostJson(url, param);
        System.out.print(str);
    }
}
