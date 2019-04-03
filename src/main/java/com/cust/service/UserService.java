package com.cust.service;

import com.cust.Entity.User;
import com.cust.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;



    public String selectUserOpenId(String openid) {
        Map userInfo=new HashMap();
        String userid= (String) redisTemplate.opsForValue().get(openid);
        if (null==userid){
            System.out.println("没有走缓存");
            userInfo = userMapper.selectUser(openid);
            redisTemplate.opsForValue().set(openid, userInfo.get("id"),5, TimeUnit.SECONDS);

            return (String) userInfo.get("id");
        }else {
           return userid;
       }


//        System.out.println(userInfo);
//        if (userInfo != null) {
//            return Integer.toString((Integer) userInfo.get("id"));

//        } else {
//            return null;
//        }

    }

    public boolean insertUserInfo(User userInfo) {

        return userMapper.insertUserInfo(userInfo) > 0 ? true : false;
    }
}
