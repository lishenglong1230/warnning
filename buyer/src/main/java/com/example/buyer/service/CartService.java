package com.example.buyer.service;

import java.util.Map;

public interface CartService {
	
	//��ӵ��ղؼ�
	public Map<String,Object> addCart(String uid,String gid);
	
	//��ѯ�û��ղؼ��е�������Ʒ
	public Map<String,Object> cartAll(String uid);
	
	//���ղؼ���ɾ����Ʒ
	public Map<String,Object> delCars(String uid,String gid);
	
	//��ѯ�û�ȷ�Ϲ����������Ʒ
	public Map<String,Object> affirmBuy(String uid,String gids,String sumprice);
	
	
	
	
}
