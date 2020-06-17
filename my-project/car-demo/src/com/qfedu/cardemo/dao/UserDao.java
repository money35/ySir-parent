package com.qfedu.cardemo.dao;

import com.qfedu.cardemo.entity.User;

public interface UserDao {
    //登录
    public User login(User user) throws Exception;

    //注册
    public int register(User user) throws Exception;

    //验证是否存在
    public User findByUserName(String userName) throws Exception;
}
