package com.cust.controller;

import com.cust.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class test {

    @Autowired
    UserMapper dao;

    @RequestMapping("/test1")
    public void test(){
        Map mao=dao.selectUser("1234");
        System.out.println(mao);
    }

}
