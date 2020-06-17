package com.qfedu.cardemo.service;


import com.qfedu.cardemo.entity.Car;

import java.util.List;

/**
 * 汽车模块的业务功能抽取
 */
public interface CarService {

    /**
     * 查询全部的车辆信息
     * @return
     * @throws Exception
     */
    public List<Car> list() throws Exception;

    /**
     * 更具ID查询相应车辆信息
     * @param id
     * @return
     * @throws Exception
     */
    public Car findById(Integer id) throws Exception;

    /**
     * 根据ID删除车辆信息(硬删除)
     * @param id
     * @return
     * @throws Exception
     */
    public boolean delete(int id) throws Exception;

    /**
     * 添加车辆信息
     * @param car
     * @return
     * @throws Exception
     */
    public boolean save(Car car) throws Exception;

    /**
     * 修改车辆信息
     * @param car
     * @return
     * @throws Exception
     */
     public boolean update(Car car) throws Exception;



}
