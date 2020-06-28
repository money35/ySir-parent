package com.money.service.impl;

import com.money.dao.AdminLoginDao;
import com.money.pojo.Admin;
import com.money.service.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminLoginServiceImpl implements AdminLoginService {
    @Autowired
    private AdminLoginDao adminLoginDao;
    @Override
    public boolean checkAdmin(Admin admin) {
        Integer row = adminLoginDao.checkAdmin(admin);
        return row == 1 ? true : false;
    }
}
