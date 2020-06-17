package com.qfedu.cardemo.service.impl;

import com.qfedu.cardemo.dao.CarDao;
import com.qfedu.cardemo.dao.impl.CarDaoImpl;
import com.qfedu.cardemo.entity.Car;
import com.qfedu.cardemo.service.CarService;

import java.util.List;

public class CarServiceImpl implements CarService {

   private CarDao carDao = new CarDaoImpl();
    @Override
    public List<Car> list() throws Exception {
        return carDao.list();
    }

    @Override
    public Car findById(Integer id) throws Exception {
        return carDao.findById(id);
    }

    @Override
    public boolean delete(int id) throws Exception {
        return carDao.delete(id);
    }

    @Override
    public boolean save(Car car) throws Exception {
        return carDao.save(car);
    }

    @Override
    public boolean update(Car car) throws Exception {
        return carDao.update(car);
    }
}
