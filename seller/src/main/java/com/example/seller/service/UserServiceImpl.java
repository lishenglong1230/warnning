package com.example.seller.service;


import com.example.seller.dao.UserDao;
import com.example.seller.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl{
    @Autowired
    private UserDao userDao;
    /*
    public int insertUser(String phone,String code){
        //return userDao.create(username,password);
    }*/




}
