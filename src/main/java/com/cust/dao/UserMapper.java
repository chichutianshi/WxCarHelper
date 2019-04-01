package com.cust.dao;

import com.cust.Entity.User;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);
}