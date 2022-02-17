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
	 * ������Ʒid��ѯ������Ʒ��Ϣ
	 */
	@Override
	public Map<String, Object> carsinfo(String id) {
		Map<String,Object> map=new HashMap<String, Object>();
		//����mapper��ķ���
		Car car=carMapper.selectByPrimaryKey(id);
		if(car!=null){
			//��ѯ�ɹ�
			map.put("status", "0");
			map.put("msg", "��ѯ�ɹ�");
			map.put("data", car);
		}else{
			//��ѯʧ��
			map.put("status", "1");
			map.put("msg", "��ѯʧ��");
			map.put("data", null);
		}
		return map;
	}


	@Override
	public Map<String, Object> carsList() {
		Map<String,Object> map=new HashMap<String,Object>();
		//����mapper��ķ����������ݿ�
		List<Car> list=carMapper.selectCarsAll();
		if(!list.isEmpty()){
			//��ѯ�ɹ�
			map.put("status", "0");
			map.put("msg", "��ѯ�ɹ�");
			map.put("data", list);
		}else{
			//��ѯʧ��
			map.put("status", "1");
			map.put("msg", "��ѯʧ��");
			map.put("data", null);
		}
		return map;
	}


	/**
	 * ģ����ѯ��Ʒ
	 */
	@Override
	public Map<String, Object> searchForCars(String inp) {
		Map<String,Object> map=new HashMap<String,Object>();
		inp="%"+inp+"%";
		//����mapperģ����ѯ��Ʒ
		List<Car> list=carMapper.selectByInp(inp);
		map.put("status", "0");
		map.put("msg", "��ѯ�ɹ�");
		map.put("data", list);
		return map;
	}
	
	
	

}
