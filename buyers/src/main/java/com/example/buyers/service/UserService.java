package com.example.buyers.service;

import java.util.Map;

public interface UserService {
	
	//用户注册
	public Map<String,Object> reg(String phone,String name,String password);
	
	//用户登录
	public Map<String,Object> login(String name,String password);
	
	//短信登录
	public Map<String,Object> loginByPhone(String phone);
	

	//用户修改昵称等信息
	public Map<String,Object> changeUserinfo(String id,String name,String sex);
	
	//修改密码
	public Map<String,Object> modifyPassword(String id,String oldpassword,String newpassword);
	
}
