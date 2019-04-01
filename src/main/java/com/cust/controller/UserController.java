package com.cust.controller;

import com.cust.Utils.WxUtils;
import com.cust.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private WxUtils wxUtils;
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(Map map) {
        System.out.println(map.get("code"));
        String userOpenId = wxUtils.oauth2GetOpenid((String) map.get("code"));
        System.out.println(userOpenId);
        return "sucess";
    }
}
