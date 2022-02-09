package com.example.buyers.service;

import java.util.Map;

public interface UserService {
	
	//用户注册
	public Map<String,Object> reg(String phone,String username,String password);
	
	//用户登录
	public Map<String,Object> login(String username,String password);

	//用户修改昵称等信息
	public Map<String,Object> changeUserinfo(String id,String username,String phone);
	
	//修改密码
	public Map<String,Object> modifyPassword(String id,String oldpassword,String newpassword);
	
}
