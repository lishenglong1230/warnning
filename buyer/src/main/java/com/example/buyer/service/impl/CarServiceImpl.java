package com.example.buyer.service.impl;


import com.example.buyer.dao.CarMapper;
import com.example.buyer.pojo.Car;
import com.example.buyer.service.CarService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("carsServiceImpl")
public class CarServiceImpl implements CarService {
	
	@Resource
    CarMapper carMapper	;
	
	/**
	 * 根据商品id查询所有商品信息
	 */
	@Override
	public Map<String, Object> carsinfo(String id) {
		Map<String,Object> map=new HashMap<String, Object>();
		//调用mapper层的方法
		Car car=carMapper.selectByPrimaryKey(id);
		if(car!=null){
			//查询成功
			map.put("status", "0");
			map.put("msg", "查询成功");
			map.put("data", car);
		}else{
			//查询失败
			map.put("status", "1");
			map.put("msg", "查询失败");
			map.put("data", null);
		}
		return map;
	}


	@Override
	public Map<String, Object> carsList() {
		Map<String,Object> map=new HashMap<String,Object>();
		//调用mapper层的方法访问数据库
		List<Car> list=carMapper.selectCarsAll();
		if(!list.isEmpty()){
			//查询成功
			map.put("status", "0");
			map.put("msg", "查询成功");
			map.put("data", list);
		}else{
			//查询失败
			map.put("status", "1");
			map.put("msg", "查询失败");
			map.put("data", null);
		}
		return map;
	}


	/**
	 * 模糊查询商品
	 */
	@Override
	public Map<String, Object> searchForCars(String inp) {
		Map<String,Object> map=new HashMap<String,Object>();
		inp="%"+inp+"%";
		//调用mapper模糊查询商品
		List<Car> list=carMapper.selectByInp(inp);
		map.put("status", "0");
		map.put("msg", "查询成功");
		map.put("data", list);
		return map;
	}
	
	
	

}
