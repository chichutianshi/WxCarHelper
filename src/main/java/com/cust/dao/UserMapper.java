package com.cust.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UserMapper {
    @Select("select * from user where openid=#{openid}")
    Map selectUser(String openid);

    @Insert("insert into user (nickname,gender,province,city,country,openid) values(#{nickname},#{gender},#{province},#{city},#{country},#{openid})")
    int insertUserInfo(Map map);
}