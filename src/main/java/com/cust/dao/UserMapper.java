package com.cust.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UserMapper {
    @Select("select * from user where openid=#{openid}")
    Map selectUser(String openid);

    @Insert("insert into user (nikename,gender,province,city,country,openid) values(#{nikename},#{gender},#{province},#{city},#{country},#{openid})")
    int insertUserInfo(Map map);
}