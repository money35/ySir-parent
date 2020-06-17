package com.qfedu.cardemo.service;

import com.qfedu.cardemo.entity.User;

public interface UserService {

    //登录
    public User login(User user) throws Exception;

    //注册
    public int register(User user) throws Exception;

    //验证是否存在
    public boolean checkName(String userName) throws Exception;
}
