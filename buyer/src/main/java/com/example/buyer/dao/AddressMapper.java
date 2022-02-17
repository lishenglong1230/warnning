package com.example.buyer.dao;


import com.example.buyer.pojo.Address;

import java.util.List;

public interface AddressMapper {
    int deleteByPrimaryKey(String id);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
    
    //查询用户的可用地址
    List<Address> selectAddressAll(String uid);
    
    //修改地址状态
    int updataByid(Address address);
    
    //将地址修改为默认状态
    int updateByDefault(Address address);
    
    //删除地址的方法
    int delAddress(Address address);
    
    
    
    
}