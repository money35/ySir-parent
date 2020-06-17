package com.qfedu.cardemo.util;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

public class DataSourceUtil {
    private static DataSource dataSource = null;
    public synchronized static DataSource getDataSource(){
        if(dataSource==null){
            DruidDataSource druidDataSource = new DruidDataSource();
            Properties pro = new Properties();
            try {
                pro.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            druidDataSource.configFromPropety(pro);
            dataSource=druidDataSource;
        }

        return dataSource;
    }
}
