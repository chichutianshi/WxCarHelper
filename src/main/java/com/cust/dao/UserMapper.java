package com.cust.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Map;
@Repository
public interface UserMapper {
    Map selectUser(String name);
}
