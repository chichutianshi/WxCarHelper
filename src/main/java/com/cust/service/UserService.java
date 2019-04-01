package com.cust.service;

import com.cust.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public boolean login(Map user) {
        if (userMapper.selectUser(user) != null) {
            System.out.println("sucess");
            return true;
        } else {
            System.out.println("false");
            return false;
        }
    }
}
