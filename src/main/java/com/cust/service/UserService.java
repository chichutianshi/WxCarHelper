package com.cust.service;

import com.cust.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public boolean selectUserOpenId(String openid) {
        Map userInfo = userMapper.selectUser(openid);
        System.out.println(userInfo);
        if (userInfo != null) {
            return true;
        } else {
            return false;
        }

    }

    public boolean insertUserInfo(Map userInfo) {

        return userMapper.insertUserInfo(userInfo) > 0 ? true : false;
    }
}
