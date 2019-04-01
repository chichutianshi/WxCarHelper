package com.cust.service;

import com.cust.Entity.User;
import com.cust.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
    @Autowired
    private UserMapper userMapper;
    public boolean login(String username,String password)
    {

        return false;
    }
}
