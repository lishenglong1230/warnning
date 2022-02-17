package com.example.buyer.service;

import java.util.Map;

public interface CartService {
	
	//添加到收藏夹
	public Map<String,Object> addCart(String uid,String gid);
	
	//查询用户收藏夹中的所有商品
	public Map<String,Object> cartAll(String uid);
	
	//从收藏夹中删除商品
	public Map<String,Object> delCars(String uid,String gid);
	
	//查询用户确认购买的所有商品
	public Map<String,Object> affirmBuy(String uid,String gids,String sumprice);
	
	
	
	
}
