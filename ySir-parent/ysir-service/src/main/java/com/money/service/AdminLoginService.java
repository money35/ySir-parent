package com.money.service;


import com.money.pojo.Admin;

public interface AdminLoginService {
    //验证用户登录
    public boolean checkAdmin(Admin admin);
}
