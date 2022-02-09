package com.example.seller.service;


import com.example.seller.dao.UserDao;
import com.example.seller.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl{
    @Autowired
    private UserDao userDao;
    public int insertUser(String username,String password,String phone){
        return userDao.create(username,password,phone);
    }
    public User findByName(String name){
        return userDao.findByName(name);
    }
    public User findByNameAndPassword(String username,String password){
        return userDao.findByNameAndPassword(username,password);
    }
}
