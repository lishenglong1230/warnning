package com.example.seller.service;


import com.example.seller.entity.User;

public interface UserService {
    /**
     * 新增一个用户
     *
     */
    int create(String username,String Password);


  /**
     * 根据name删除一个用户高
     * @param username
     */
    void deleteByName(String username);



}
