package com.money.dao;

import com.money.pojo.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminLoginDao {
    //登录验证
    Integer checkAdmin(Admin admin);
}
