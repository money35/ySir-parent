package com.qfedu.cardemo.service.impl;

import com.qfedu.cardemo.dao.UserDao;
import com.qfedu.cardemo.dao.impl.UserDaoImpl;
import com.qfedu.cardemo.entity.User;
import com.qfedu.cardemo.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();
    @Override
    public User login(User user) throws Exception {
        return dao.login(user);
    }

    @Override
    public int register(User user) throws Exception {
        return dao.register(user);
    }

    @Override
    public boolean checkName(String userName) throws Exception {
        User user = dao.findByUserName(userName);
        return user==null?false:true;
    }
}
