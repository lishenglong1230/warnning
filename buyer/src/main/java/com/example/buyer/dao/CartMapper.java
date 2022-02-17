package com.example.buyer.dao;

import com.example.buyer.pojo.Cart;

import java.util.List;

public interface CartMapper {
    int deleteByPrimaryKey(String id);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);

    //查询用户是否已经添加了此商品
    Cart selectByUidAndGid(Cart cart);

    //根据用户id查询购物车中所有商品
    List<Cart> selectByuid(String uid);

    //从购物车中删除商品
    int updateByUidAndGid(Cart cart);
}