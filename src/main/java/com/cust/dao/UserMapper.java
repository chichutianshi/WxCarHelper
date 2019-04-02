package com.cust.dao;

import org.springframework.stereotype.Repository;

import java.util.Map;
@Repository
public interface UserMapper {
    Map selectUser(String openid);
    int insertUserInfo(Map map);
}