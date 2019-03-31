package com.cust.service;

import com.cust.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {
    @Autowired
    com.cust.dao.UserMapper UserMapper;

    public Map getaccount(String str) {
        return UserMapper.selectUser(str);
    }
}
