package com.example.buyer.service;

import java.util.Map;

public interface CarService {
	//������Ʒid��ѯ������Ʒ��Ϣ
	public Map<String,Object> carsinfo(String id);
	
	//��ѯ������Ʒ�б�
	public Map<String,Object> carsList();
	
	//ģ����ѯ
	public Map<String,Object> searchForCars(String inp);
	
}
