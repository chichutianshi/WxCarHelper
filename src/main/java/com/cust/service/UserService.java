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
    private RedisTemplate<Object, Object> redisTemplate;

    public String selectUserOpenId(String openid) {
        String userid= (String) redisTemplate.opsForValue().get(openid);
        User userInfo=new User();
        if (null==userid){
            System.out.println("无缓存");
            synchronized (this){
                userInfo = userMapper.selectUser(openid);//线程锁
            }
        }else {
            return userid;
        }

        if (userInfo != null) {
            redisTemplate.opsForValue().set(openid,userInfo.getId(),10,TimeUnit.SECONDS);
            return userInfo.getId();
        } else {
            return null;
        }
    }

    public boolean insertUserInfo(User userInfo) {

        return userMapper.insertUserInfo(userInfo) > 0 ? true : false;
    }
}
