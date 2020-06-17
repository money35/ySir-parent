package com.qfedu.cardemo.dao.impl;

import com.qfedu.cardemo.dao.UserDao;
import com.qfedu.cardemo.entity.User;
import com.qfedu.cardemo.util.DataSourceUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class UserDaoImpl implements UserDao {
    private QueryRunner runner = new QueryRunner(DataSourceUtil.getDataSource());
    @Override
    public User login(User user) throws Exception {
        String sql = "select * from users where userName=? and password=? ";
        return runner.query(sql, new BeanHandler<>(User.class),user.getUserName(),user.getPassword());

    }

    @Override
    public int register(User user) throws Exception {
        String sql = "insert into users(userName,password) values(?,?)";
       return runner.update(sql,user.getUserName(),user.getPassword());
    }

    @Override
    public User findByUserName(String userName) throws Exception {
        String sql = "select * from users where userName=? ";
        return runner.query(sql, new BeanHandler<>(User.class),userName);

    }
}
