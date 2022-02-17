package com.example.buyer.service;

import java.util.Map;

public interface CarService {
	//根据商品id查询所有商品信息
	public Map<String,Object> carsinfo(String id);
	
	//查询所有商品列表
	public Map<String,Object> carsList();
	
	//模糊查询
	public Map<String,Object> searchForCars(String inp);
	
}
