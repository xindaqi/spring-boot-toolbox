package com.company.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import java.util.concurrent.TimeUnit;
import java.util.UUID;

@CrossOrigin(origins="*", maxAge=3600)
@RestController
@RequestMapping("/token")
public class TokenByRedisController {
    @Autowired 
    private StringRedisTemplate redisTemplate;

    /**
     * 依据userId生成Token,存储到Redis中,
     * 数据过期时间单位为分钟,如设定为1分钟
     * 数据结构为userId:token
     * @param userId
     * @return
     */
    @RequestMapping(value="/add", params="userId",method=RequestMethod.PUT)
    public String setToken(@RequestParam("userId") String userId){
        // redisTemplate.opsForValue().set("token","123456token");
        String token = UUID.randomUUID().toString();
        redisTemplate.opsForValue().set(userId, token, 1, TimeUnit.MINUTES);
        return "success";
    }

    /**
     * 依据userId删除Redis中的Token
     * @param userId
     * @return
     */
    @RequestMapping(value="/delete", params="userId", method=RequestMethod.DELETE)
    public String delToken(@RequestParam("userId") String userId){
        Boolean isDelToken = redisTemplate.delete(userId);
        if(isDelToken){
            return "success";
        }else{
            return "failed";
        }
        
    }

    /**
     * 依据userId获取Redis中对应的Token
     * @param userId
     * @return
     */
    @RequestMapping(value="/get", params="userId", method=RequestMethod.GET)
    public String getToken(@RequestParam("userId") String userId){
        String token = redisTemplate.opsForValue().get(userId);
        if(token == null){
            return "Token已过期";
        }else{
            return token;
        }
        
    }

    /**
     * 依据userId和Token请求数据,
     * 若Token过期或错误,需要重新获取Token
     * @param userId
     * @param token
     * @return
     */
    @RequestMapping(value="/datas-search", params={"userId", "token"},method=RequestMethod.GET)
    public Map searchDatas(@RequestParam("userId") String userId,@RequestParam("token") String token){
        Map returnMap = new HashMap();
        String tokenInMemory = redisTemplate.opsForValue().get(userId);
        try{
            if(tokenInMemory == null){
                returnMap.put("code", 201);
                returnMap.put("msg", "Token过期,请重新获取");
                // return returnMap;
            }else{
                if(tokenInMemory.equals(token)){
                    returnMap.put("code", 200);
                    returnMap.put("token", token);
                    returnMap.put("msg", "请求成功");
                }else{
                    returnMap.put("code", 202);
                    returnMap.put("msg", "Token无效,请传入正确的数据");
                    // return returnMap;
                }
            }
            return returnMap;

        }catch(Exception e){
            e.printStackTrace();
        }
        returnMap.put("code", 400);
        returnMap.put("msg", "参数异常,请检查参数");
        return returnMap;
    }

}