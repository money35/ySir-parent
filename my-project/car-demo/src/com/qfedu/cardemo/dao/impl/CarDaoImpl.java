package com.qfedu.cardemo.dao.impl;

import com.qfedu.cardemo.dao.CarDao;
import com.qfedu.cardemo.entity.Car;
import com.qfedu.cardemo.util.DataSourceUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

//持久层的实现类
public class CarDaoImpl implements CarDao {
   private QueryRunner runner = new QueryRunner(DataSourceUtil.getDataSource());

    @Override
    public List<Car> list() throws Exception {
        String sql = "select * from sys_cars";
        List<Car> list = runner.query(sql, new BeanListHandler<>(Car.class));
        return list;
    }

    @Override
    public Car findById(Integer id) throws Exception {
       String sql = "select * from sys_cars where id=?";
        Car car = runner.query(sql, new BeanHandler<>(Car.class), id);
        return car;
    }

    @Override
    public boolean delete(int id) throws Exception {
        String sql = "delete from sys_cars where id=?";
        int row = runner.update(sql, id);
        return row>0 ? true : false;
    }

    @Override
    public boolean save(Car car) throws Exception {
        String sql = "insert into sys_cars(carName,pl,carType,price,mileage,productionDate,serial) " +
                "values(?,?,?,?,?,?,?)";
        int row = runner.update(sql,
                car.getCarName(),
                car.getPl(),
                car.getCarType(),
                car.getPrice(),
                car.getMileage(),
                car.getProductionDate(),
                car.getSerial()
        );
        return row>0?true:false;
    }

    @Override
    public boolean update(Car car) throws Exception {
        String sql = "update sys_cars set carName=?,pl=?,carType=?,price=?,mileage=?,productionDate=?,serial=? where id=?";
        int row = runner.update(sql,
                car.getCarName(),
                car.getPl(),
                car.getCarType(),
                car.getPrice(),
                car.getMileage(),
                car.getProductionDate(),
                car.getSerial(),
                car.getId()
        );
        return row>0?true:false;
    }
}
