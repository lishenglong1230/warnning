package com.example.buyers.service;

import java.util.Map;

public interface UserService {
	
	//�û�ע��
	public Map<String,Object> reg(String phone,String username,String password);
	
	//�û���¼
	public Map<String,Object> login(String username,String password);

	//�û��޸��ǳƵ���Ϣ
	public Map<String,Object> changeUserinfo(String id,String username,String phone);
	
	//�޸�����
	public Map<String,Object> modifyPassword(String id,String oldpassword,String newpassword);
	
}
