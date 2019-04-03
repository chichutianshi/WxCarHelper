package com.cust.service;

import com.cust.Entity.User;
import com.cust.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public String selectUserOpenId(String openid) {
        Map userInfo = userMapper.selectUser(openid);
        System.out.println(userInfo);
        if (userInfo != null) {
            return (String) userInfo.get("id");
        } else {
            return null;
        }

    }

    public boolean insertUserInfo(User userInfo) {

        return userMapper.insertUserInfo(userInfo) > 0 ? true : false;
    }
}
