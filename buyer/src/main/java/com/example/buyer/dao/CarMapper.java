package com.example.buyer.dao;

import com.example.buyer.pojo.Car;

import java.util.List;

public interface CarMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Car record);

    int insertSelective(Car record);

    Car selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Car record);

    int updateByPrimaryKey(Car record);

    //查询所有商品列表
    List<Car> selectCarsAll();

    //模糊查询商品
    List<Car> selectByInp(String brand);
}