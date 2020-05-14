package com.company.web.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.ResponseBody;
// import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@CrossOrigin(origins="*", maxAge=3600)
@RestController 
// @RequestMapping("/admin")
public class ExchangeDataController {
    static Logger logger = LoggerFactory.getLogger(ExchangeDataController.class);
    @RequestMapping(value="/add/exchange", method=RequestMethod.POST)
    public Map dataExchange(@RequestBody Map params, HttpServletRequest req){
        Map returnMap = new HashMap();
        String name = params.get("name").toString();
        String url = req.getRequestURL().toString();
        returnMap.put("code", 200);
        returnMap.put("infos", name);
        returnMap.put("url", url);
        
        return returnMap;
    }
    // @GetMapping("/admin/test")
    // public String admin(){
    //     return "test";
    // }

    @RequestMapping(value="/proxy-test", method=RequestMethod.GET)
    public Map proxyTest(){
        Map returnMap = new HashMap();
        returnMap.put("code", 200);
        return returnMap;
    }
}

// @RestController
// public class ExchangeData{
//     @GetMapping("/admin/hello") 
//     public String admin(){
//         return "hello admin";
//     }

//     @GetMapping("/user/hello")
//     public String user(){
//         return "hello user";
//     }

//     @GetMapping("/hello")
//     public String hello(){
//         return "hello";
//     }
//     @PostMapping("/post-test")
//     public Map<String, String> postTest(){
//         Map<String, String> map = new HashMap<String, String>();
//         map.put("name", "xiaohong");
//         map.put("address", "hegang");
//         return map; 
//     }
// }