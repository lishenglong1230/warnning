package com.example.buyers.service;

import java.util.Map;

public interface UserService {
	
	//�û�ע��
	public Map<String,Object> reg(String phone,String name,String password);
	
	//�û���¼
	public Map<String,Object> login(String name,String password);
	
	//���ŵ�¼
	public Map<String,Object> loginByPhone(String phone);
	

	//�û��޸��ǳƵ���Ϣ
	public Map<String,Object> changeUserinfo(String id,String name,String sex);
	
	//�޸�����
	public Map<String,Object> modifyPassword(String id,String oldpassword,String newpassword);
	
}
